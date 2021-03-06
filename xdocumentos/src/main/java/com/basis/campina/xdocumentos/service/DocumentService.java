package com.basis.campina.xdocumentos.service;

import com.basis.campina.xdocumentos.config.ApplicationProperties;
import com.basis.campina.xdocumentos.service.dto.DocumentDTO;
import io.minio.*;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final MinioClient minioClient;
    private final ApplicationProperties properties;

    @SneakyThrows
    public String salvar(DocumentDTO documentoDTO) {
        minioClient.putObject(PutObjectArgs.builder()
                .stream(new ByteArrayInputStream(
                                documentoDTO.getFile().getBytes()),
                        documentoDTO.getFile().getBytes().length, 0)
                .contentType(StandardCharsets.UTF_8.toString())
                .bucket(properties.getBucket())
                .object(documentoDTO.getUuid())
                .build());
        return documentoDTO.getUuid();
    }

    @SneakyThrows
    public DocumentDTO buscarDocument(String uuid) {
        GetObjectResponse file = minioClient.getObject(GetObjectArgs.builder()
                .bucket(properties.getBucket())
                .object(uuid)
                .build());
        return new DocumentDTO(uuid, IOUtils.toString(file, StandardCharsets.UTF_8.toString()));
    }

    @SneakyThrows
    public void deletar(String uuid) {
        minioClient.removeObject(RemoveObjectArgs.builder()
                .bucket(properties.getBucket())
                .object(uuid)
                .build());
    }
}

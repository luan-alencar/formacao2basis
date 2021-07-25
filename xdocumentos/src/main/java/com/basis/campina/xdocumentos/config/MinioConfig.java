package com.basis.campina.xdocumentos.config;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MinioConfig {

    private final ApplicationProperties properties;

    @Bean
    public MinioClient gerarMinioClient() {
        MinioClient minioClientGerado = getMinioClient();
        return minioClientGerado;
    }

    private MinioClient getMinioClient() {
        MinioClient minioClientGerado = MinioClient.builder()
                .endpoint(properties.getUrl())
                .credentials(properties.getAccessKey(), properties.getSecretKey())
                .build();
        verificaSeExisteBucketClient(minioClientGerado);
        return minioClientGerado;
    }

    public void verificaSeExisteBucketClient(MinioClient client) {
        if (!existeBucket(client, properties.getBucket())) {
            criaBucket(client, properties.getBucket());
        }
    }

    @SneakyThrows
    public boolean existeBucket(MinioClient minioClient, String bucket) {
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
    }

    @SneakyThrows
    public void criaBucket(MinioClient minioClient, String nomeBucket) {
        minioClient.makeBucket(MakeBucketArgs.builder().bucket(nomeBucket).build());
    }
}

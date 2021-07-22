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
        MinioClient minioClient = buscarERetornaMinioClient();
        verificaSeExisteBucketClient(minioClient);
        return minioClient;
    }

    private MinioClient buscarERetornaMinioClient() {
        MinioClient client = MinioClient.builder()
                .endpoint(properties.getUrl())
                .credentials(properties.getAccessKey(), properties.getSecretKey())
                .build();
        return client;
    }

    private void verificaSeExisteBucketClient(MinioClient client) {
        if (!existeBucket(client, properties.getBucket())) {
            fazerBucket(client, properties.getBucket());
        }
    }

    @SneakyThrows
    public boolean existeBucket(MinioClient minioClient, String bucket) {
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
    }

    @SneakyThrows
    public void fazerBucket(MinioClient minioClient, String nomeBucket) {
        minioClient.makeBucket(MakeBucketArgs.builder().bucket(nomeBucket).build());
    }
}

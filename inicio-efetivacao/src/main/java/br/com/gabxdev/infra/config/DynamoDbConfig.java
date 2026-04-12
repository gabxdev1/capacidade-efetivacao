package br.com.gabxdev.infra.config;

import br.com.gabxdev.infra.integration.repository.entity.ContratoEntity;
import br.com.gabxdev.infra.integration.repository.entity.SituacaoProcessamentoEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration

public class DynamoDbConfig {

    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder()
                .region(Region.SA_EAST_1)
                .credentialsProvider(DefaultCredentialsProvider.builder().build())
                .httpClientBuilder(
                        ApacheHttpClient.builder()
                                .maxConnections(256)
                )
                .build();
    }

    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient) {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
    }

    @Bean
    public DynamoDbTable<SituacaoProcessamentoEntity> tb178(DynamoDbEnhancedClient enhancedClient) {
        return enhancedClient.table(
                "tb178",
                TableSchema.fromBean(SituacaoProcessamentoEntity.class)
        );
    }

    @Bean
    public DynamoDbTable<ContratoEntity> tb185(DynamoDbEnhancedClient enhancedClient) {
        return enhancedClient.table(
                "tb185",
                TableSchema.fromBean(ContratoEntity.class)
        );
    }

}

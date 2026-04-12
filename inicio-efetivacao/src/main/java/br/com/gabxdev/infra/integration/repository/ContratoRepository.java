package br.com.gabxdev.infra.integration.repository;

import br.com.gabxdev.infra.integration.repository.entity.ContratoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.IgnoreNullsMode;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ContratoRepository {

    private final DynamoDbTable<ContratoEntity> tb185;

    public void save(ContratoEntity entity) {
        tb185.putItem(entity);
    }

    public void update(ContratoEntity entity) {
        tb185.updateItem(r -> r
                .item(entity)
                .ignoreNullsMode(IgnoreNullsMode.SCALAR_ONLY)
        );
    }

    public Optional<ContratoEntity> findById(String idEfetivacao) {
        var key = Key.builder()
                .partitionValue(idEfetivacao)
                .build();

        var item = tb185.getItem(r -> r.key(key).consistentRead(true));

        return Optional.ofNullable(item);
    }
}

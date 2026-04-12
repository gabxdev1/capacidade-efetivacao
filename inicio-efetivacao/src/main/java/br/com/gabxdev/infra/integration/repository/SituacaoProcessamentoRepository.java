package br.com.gabxdev.infra.integration.repository;

import br.com.gabxdev.infra.integration.repository.entity.SituacaoProcessamentoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.IgnoreNullsMode;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SituacaoProcessamentoRepository {

    private final DynamoDbTable<SituacaoProcessamentoEntity> tb178;

    public void save(SituacaoProcessamentoEntity entity) {
        tb178.putItem(entity);
    }

    public void update(SituacaoProcessamentoEntity entity) {
        tb178.updateItem(r -> r
                .item(entity)
                .ignoreNullsMode(IgnoreNullsMode.SCALAR_ONLY)
        );
    }

    public Optional<SituacaoProcessamentoEntity> findById(String idEfetivacao) {
        var key = Key.builder()
                .partitionValue(idEfetivacao)
                .build();

        var item = tb178.getItem(r -> r.key(key).consistentRead(true));

        return Optional.ofNullable(item);
    }

}

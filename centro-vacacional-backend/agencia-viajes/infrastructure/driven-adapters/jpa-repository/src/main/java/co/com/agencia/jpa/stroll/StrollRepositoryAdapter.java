package co.com.agencia.jpa.stroll;

import co.com.agencia.jpa.helper.AdapterOperations;
import co.com.agencia.model.stroll.Stroll;
import co.com.agencia.model.stroll.gateways.StrollRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class StrollRepositoryAdapter extends AdapterOperations<Stroll, StrollData, Integer, StrollDataRepository>
    implements StrollRepository {

    public StrollRepositoryAdapter(StrollDataRepository repository, ObjectMapper objectMapper) {
        super(repository, objectMapper, d -> objectMapper.mapBuilder(d, Stroll.StrollBuilder.class).build());
    }

    @Override
    public Mono<Stroll> saveStroll(Stroll stroll) {
        return Mono.justOrEmpty(stroll)
            .map(ConvertidorStroll::convertStrollToStrollData)
            .doOnNext(strollData -> repository.save(strollData))
            .map(savedStrollData -> stroll);
    }
}

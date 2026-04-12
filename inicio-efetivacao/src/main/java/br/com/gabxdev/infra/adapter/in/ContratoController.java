package br.com.gabxdev.infra.adapter.in;

import br.com.gabxdev.domain.port.in.AtualizarLimiteInboundPort;
import br.com.gabxdev.domain.port.in.ContratacaoInboundPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/contratos")
@RequiredArgsConstructor
public class ContratoController {

    private final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

    private final ContratacaoInboundPort contratacaoInboundPort;

    private final AtualizarLimiteInboundPort atualizarLimiteInboundPort;

    @PostMapping("/efetivar/{idEfetivacao}")
    public ResponseEntity<Void> efetivar(@PathVariable String idEfetivacao) {
        CompletableFuture.runAsync(() -> {
            contratacaoInboundPort.efetivarContrato(idEfetivacao);
        }, executorService);

        return ResponseEntity.accepted().build();
    }

    @PostMapping("/atualizar-limites/{idEfetivacao}")
    public ResponseEntity<Void> atualizarLimite(@PathVariable String idEfetivacao) {
        CompletableFuture.runAsync(() -> {
            atualizarLimiteInboundPort.atualizarLimite(idEfetivacao);
        }, executorService);

        return ResponseEntity.accepted().build();
    }
}

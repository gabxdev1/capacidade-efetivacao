package br.com.gabxdev.infra.adapter.in;

import br.com.gabxdev.domain.port.in.AtualizarLimiteNoAutorizadorInboundPort;
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
@RequestMapping("/autorizador")
@RequiredArgsConstructor
public class AutorizadorController {

    private final AtualizarLimiteNoAutorizadorInboundPort atualizarLimiteNoAutorizadorInboundPort;

    private final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

    @PostMapping("/atualizar-limites/{idEfetivacao}")
    public ResponseEntity<Void> atualizarLimite(@PathVariable String idEfetivacao) {
        CompletableFuture.runAsync(() -> {
            atualizarLimiteNoAutorizadorInboundPort.atualizarLimiteNoAutorizadorInboundPort(idEfetivacao);
        }, executorService);

        return ResponseEntity.accepted().build();
    }
}

package br.com.zup.nats.infrastructure.producer

import br.com.zup.nats.model.Produto
import io.micronaut.context.annotation.Bean
import io.micronaut.core.annotation.Introspected
import io.micronaut.http.annotation.Controller
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject
import org.slf4j.LoggerFactory
import java.math.BigDecimal
import javax.inject.Inject

@NatsClient
interface ProdutoClient {

    @Subject("produto")
    fun send(produto: Produto)
}

package br.com.zup.nats.infrastructure.subscribe

import br.com.zup.nats.database.ProdutoRepositoryImpl
import br.com.zup.nats.model.Produto
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject

@NatsListener
class UserServer(private val produtoRepository: ProdutoRepositoryImpl) {

    @Subject("produto")
    fun receive(produto: Produto) {
        produtoRepository.saveCql(produto)
    }
}

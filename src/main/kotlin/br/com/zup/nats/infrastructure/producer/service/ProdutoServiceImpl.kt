package br.com.zup.nats.infrastructure.producer.service

import br.com.zup.nats.infrastructure.producer.ProdutoClient
import br.com.zup.nats.model.Produto
import javax.inject.Singleton

@Singleton
class ProdutoServiceImpl(private val produtoClient: ProdutoClient): ProdutoService {
    override fun send(produto: Produto): Produto {
        produtoClient.send(produto)
        return produto
    }
}
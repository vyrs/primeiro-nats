package br.com.zup.nats.infrastructure.producer.service

import br.com.zup.nats.model.Produto
import br.com.zup.nats.infrastructure.producer.ProdutoClient
import java.util.*
import javax.inject.Singleton

@Singleton
interface ProdutoService {
    fun send(produto: Produto): Produto

}
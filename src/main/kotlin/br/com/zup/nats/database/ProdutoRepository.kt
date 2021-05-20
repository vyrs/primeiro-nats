package br.com.zup.nats.database

import br.com.zup.nats.controller.ProdutoRequest
import br.com.zup.nats.model.Produto
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.Row
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.*
import javax.inject.Singleton

@Singleton
interface ProdutoRepository {

    fun saveCql(produto: Produto)
    fun listCql(): MutableList<Produto>
}
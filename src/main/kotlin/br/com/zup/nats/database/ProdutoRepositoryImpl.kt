package br.com.zup.nats.database

import br.com.zup.nats.controller.ProdutoRequest
import br.com.zup.nats.model.Produto
import com.datastax.oss.driver.api.core.CqlIdentifier
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.Row
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.*
import javax.inject.Singleton

@Singleton
class ProdutoRepositoryImpl(private val cqlSession: CqlSession): ProdutoRepository {

    override fun saveCql(produto: Produto) {
        cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "INSERT INTO produto(id, nome, categoria, preco) VALUES (?, ?, ?, ?)",
                    produto.id,
                    produto.nome,
                    produto.categoria,
                    produto.preco
                )
        )
    }

    override fun listCql(): MutableList<Produto> {
        val rows = cqlSession.execute("SELECT * FROM produto").toList()
        val produtos: MutableList<Produto> = mutableListOf()

        for (row in rows) {
            val id = row.getUuid(CqlIdentifier.fromCql("id"))!!
            val nome = row.getString(CqlIdentifier.fromCql("nome"))!!
            val categoria = row.getString(CqlIdentifier.fromCql("categoria"))!!
            val preco = row.getBigDecimal(CqlIdentifier.fromCql("preco"))!!

            produtos.add(Produto(id, nome, categoria, preco))
        }

        return produtos
    }
}
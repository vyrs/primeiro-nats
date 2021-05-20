package br.com.zup.nats.controller

import br.com.zup.nats.database.ProdutoRepository
import br.com.zup.nats.database.ProdutoRepositoryImpl
import br.com.zup.nats.model.Produto
import br.com.zup.nats.infrastructure.producer.service.ProdutoService
import br.com.zup.nats.infrastructure.producer.service.ProdutoServiceImpl
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import java.util.*
import javax.validation.Valid

@Validated
@Controller("/produto")
class ProdutoController(private val produtoService: ProdutoServiceImpl,
                        private val produtoRepository: ProdutoRepositoryImpl) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Post
    fun cria(@Body @Valid request: ProdutoRequest): HttpResponse<Any> {

        produtoService.send(Produto(UUID.randomUUID(), request.nome, request.categoria, request.preco))

        return HttpResponse.created("criado!!")
    }

    @Get
    fun lista(): List<Produto> {
        val produtos = produtoRepository.listCql()

        return produtos
    }
}
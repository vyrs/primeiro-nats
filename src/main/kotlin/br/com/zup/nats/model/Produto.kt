package br.com.zup.nats.model

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import java.util.*

@Introspected
class Produto(
    val id: UUID,
    val nome: String,
    val categoria: String,
    val preco: BigDecimal
)
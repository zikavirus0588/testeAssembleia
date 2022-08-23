package br.com.gomesar.assembleia.domain.dto

import br.com.gomesar.assembleia.aplicacao.controllers.v1.request.CreatePautaRequest
import br.com.gomesar.assembleia.domain.entities.PautaEntity
import br.com.gomesar.assembleia.domain.entities.VotoEntity
import java.util.UUID

data class PautaDTO(
    val uuid: UUID? = null,
    val nome: String,
    val finalizada: Boolean? = null,
    val votos: MutableList<VotoEntity> = arrayListOf()
) {
    constructor(request: CreatePautaRequest) : this(nome = request.nome)
    constructor(entity: PautaEntity) : this(entity.pautaUuid, entity.nome, entity.finalizada, entity.votos)

    fun toEntity() = PautaEntity(this)
}
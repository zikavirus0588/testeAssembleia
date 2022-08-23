package br.com.gomesar.assembleia.aplicacao.controllers.v1.response

import br.com.gomesar.assembleia.domain.dto.PautaDTO
import java.util.UUID

data class CreatePautaResponse(val uuid: UUID) {
    constructor(dto: PautaDTO) : this(dto.uuid!!)
}
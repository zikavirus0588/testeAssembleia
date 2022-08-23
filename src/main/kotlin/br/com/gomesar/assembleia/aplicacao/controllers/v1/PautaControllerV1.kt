package br.com.gomesar.assembleia.aplicacao.controllers.v1

import br.com.gomesar.assembleia.aplicacao.controllers.v1.PautaControllerV1.Companion.PAUTA_BASE_PATH
import br.com.gomesar.assembleia.aplicacao.controllers.v1.request.CreatePautaRequest
import br.com.gomesar.assembleia.aplicacao.controllers.v1.response.CreatePautaResponse
import br.com.gomesar.assembleia.aplicacao.services.IPautaService
import br.com.gomesar.assembleia.domain.dto.PautaDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping(PAUTA_BASE_PATH)
class PautaControllerV1(private val pautaService: IPautaService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun createUser(@Valid @RequestBody request: CreatePautaRequest): CreatePautaResponse {
        return CreatePautaResponse(pautaService.createPauta(PautaDTO(request)))
    }

    companion object {
        const val PAUTA_BASE_PATH = "/v1/pautas"
    }
}
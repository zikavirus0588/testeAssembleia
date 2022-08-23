package br.com.gomesar.assembleia.aplicacao.integration.services

import br.com.gomesar.assembleia.aplicacao.integration.request.UserIntegrationRequest
import br.com.gomesar.assembleia.aplicacao.integration.response.UserIntegrationResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Service
class UserIntegrationService(
    private val restTemplate: RestTemplate,
    @Value("\${assembleia.user-service.scheme}") private val scheme: String,
    @Value("\${assembleia.user-service.host}") private val host: String,
    @Value("\${assembleia.user-service.path}") private val path: String
) : IUserIntegrationService {

    override fun getUserResponse(request: UserIntegrationRequest): UserIntegrationResponse {
        val uri = UriComponentsBuilder.newInstance().scheme(scheme).host(host)
            .path("$path/${request.cpf.removeCaracteresEspeciais()}")
            .build().toUri()
        return handleResponse(restTemplate.getForEntity(uri, UserIntegrationResponse::class.java))
    }

    private fun handleResponse(response: ResponseEntity<UserIntegrationResponse>): UserIntegrationResponse {
        return when (response.statusCode) {
            HttpStatus.OK -> response.body!!
            HttpStatus.NOT_FOUND -> throw java.lang.RuntimeException("Usuario não encontrado")
            else -> throw java.lang.RuntimeException("Erro ao integrar com o serviço de usuário")
        }
    }

    fun String.removeCaracteresEspeciais() = this.replace("[^a-zA-Z0-9]".toRegex(), "")
}
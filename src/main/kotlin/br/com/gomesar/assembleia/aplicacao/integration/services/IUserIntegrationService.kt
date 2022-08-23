package br.com.gomesar.assembleia.aplicacao.integration.services

import br.com.gomesar.assembleia.aplicacao.integration.request.UserIntegrationRequest
import br.com.gomesar.assembleia.aplicacao.integration.response.UserIntegrationResponse

interface IUserIntegrationService {
    fun getUserResponse(request: UserIntegrationRequest): UserIntegrationResponse
}
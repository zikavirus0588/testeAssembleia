package br.com.gomesar.assembleia.aplicacao.integration.response

data class UserIntegrationResponse(val status: EStatusUsuarioVotacao)

enum class EStatusUsuarioVotacao {
    ABLE_TO_VOTE,
    UNABLE_TO_VOTE
}

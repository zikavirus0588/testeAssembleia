package br.com.gomesar.assembleia.aplicacao.commons

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class ApiResponse<T>(val payload: T? = null, val erros: ArrayList<ApiErro>? = null) {
}
data class ApiErro(val codigo: String, val mensagem: String)
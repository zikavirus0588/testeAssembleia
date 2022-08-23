package br.com.gomesar.assembleia.aplicacao.exceptions

import br.com.gomesar.assembleia.aplicacao.commons.EErroCode

open class DefaultUserException(mensagem: String, ex: Exception?, val errorCode: EErroCode) :
    RuntimeException(mensagem, ex) {
}
package br.com.gomesar.assembleia.aplicacao.exceptions

import br.com.gomesar.assembleia.aplicacao.commons.BundleMessageService
import br.com.gomesar.assembleia.aplicacao.commons.EErroCode

open class UsuarioJaCadastradoException(bundleMessageService: BundleMessageService, param: String) :
    DefaultUserException(
        bundleMessageService.getMessage(EErroCode.ERRO_USUARIO_JA_CADASTRADO.codigo, param),
        null,
        EErroCode.ERRO_USUARIO_JA_CADASTRADO
    )
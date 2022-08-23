package br.com.gomesar.assembleia.aplicacao.commons

import br.com.gomesar.assembleia.aplicacao.exceptions.DefaultUserException
import br.com.gomesar.assembleia.aplicacao.exceptions.UsuarioJaCadastradoException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class WebServiceHandlerException {

    @ExceptionHandler(
        UsuarioJaCadastradoException::class
    )
    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    fun handleUnprocessableEntityException(e: Exception): ApiResponse<Nothing>? {
        return when(e) {
            is DefaultUserException -> getResponse(e.errorCode.codigo, e.message)
            else -> null
        }
    }

     @ExceptionHandler(
         MethodArgumentNotValidException::class
    )
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBadRequestException(e: MethodArgumentNotValidException): ApiResponse<Nothing>? {
       return with(e) {
           val erroList: ArrayList<ApiErro> = arrayListOf()
           e.bindingResult.fieldErrors.forEach{ e ->
                erroList.add(
                    ApiErro(EErroCode.ERRO_REQUEST_BODY.codigo,
                        "O valor (${e.rejectedValue}) informado não é válido para o campo (${e.field})")
                )
           }
           ApiResponse(null,erroList)
       }
    }

    private fun getResponse(codigoErro: String, mensagem: String? = "") = ApiResponse(
        null,
        arrayListOf(ApiErro(codigoErro, mensagem!!))
    )

}
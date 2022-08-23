package br.com.gomesar.assembleia.aplicacao.commons

import org.springframework.context.MessageSource
import org.springframework.context.NoSuchMessageException
import org.springframework.stereotype.Component
import java.util.*

@Component
class BundleMessageService(val messageSource: MessageSource) {
    fun getMessage(key: String, vararg args: String): String {
        return try {
            messageSource.getMessage(key, args, Locale.getDefault())
        } catch (ex: NoSuchMessageException) {
            key
        }
    }
}
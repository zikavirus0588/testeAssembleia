package br.com.gomesar.assembleia.aplicacao.services

import br.com.gomesar.assembleia.domain.dto.PautaDTO

interface IPautaService {
    fun createPauta(dto: PautaDTO): PautaDTO
}
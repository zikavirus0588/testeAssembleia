package br.com.gomesar.assembleia.aplicacao.services

import br.com.gomesar.assembleia.domain.dto.PautaDTO
import br.com.gomesar.assembleia.domain.repositories.IPautaRepository
import org.springframework.stereotype.Service

@Service
class PautaService(private val repository: IPautaRepository) : IPautaService {

    override fun createPauta(dto: PautaDTO): PautaDTO{
        if (repository.existsByNome(dto.nome)) {
            throw java.lang.RuntimeException("Pauta ${dto.nome} já cadastrada")
        }
        return repository.save(dto.toEntity()).toDTO()
    }
}
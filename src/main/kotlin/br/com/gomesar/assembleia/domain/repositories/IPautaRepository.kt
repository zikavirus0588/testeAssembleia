package br.com.gomesar.assembleia.domain.repositories

import br.com.gomesar.assembleia.domain.entities.PautaEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface IPautaRepository : JpaRepository<PautaEntity, UUID> {
    fun existsByNome(nome: String): Boolean
}
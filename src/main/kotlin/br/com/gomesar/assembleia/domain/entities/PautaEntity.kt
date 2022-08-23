package br.com.gomesar.assembleia.domain.entities

import br.com.gomesar.assembleia.domain.dto.PautaDTO
import java.util.*
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
@Table(name = "Pauta")
data class PautaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val pautaUuid: UUID? = null,
    val nome: String,
    var finalizada: Boolean? = null,
    @OneToMany(mappedBy = "pauta", cascade = [CascadeType.ALL], orphanRemoval = true)
    val votos: MutableList<VotoEntity> = arrayListOf()
) {
    constructor(dto: PautaDTO) : this(null, dto.nome, null, dto.votos)

    fun addVoto(voto: VotoEntity) {
        votos.add(voto)
        voto.pauta = this
    }

    fun toDTO() = PautaDTO(this)
}

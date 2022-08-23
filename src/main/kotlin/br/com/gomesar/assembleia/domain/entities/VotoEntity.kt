package br.com.gomesar.assembleia.domain.entities

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "Voto")
data class VotoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val votoUuid: UUID? = null,
    val respostaUsuario: String,
    val usuarioId: String,
    @ManyToOne(fetch = FetchType.LAZY)
    var pauta: PautaEntity
)

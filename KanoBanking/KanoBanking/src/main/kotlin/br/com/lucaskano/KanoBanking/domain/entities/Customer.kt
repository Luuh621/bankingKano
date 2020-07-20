package br.com.lucaskano.KanoBanking.domain.entities

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Customer(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @JsonManagedReference
        var name: String,

        @JsonManagedReference
        var document: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Customer

        if (id != other.id) return false
        if (name != other.name) return false
        if (document != other.document) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + document.hashCode()
        return result
    }

    override fun toString(): String {
        return """
Customer(id=$id, 
name='$name', 
document='$document'
)""".trimIndent()
    }
}
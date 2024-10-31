package org.example.wasteback.Entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pagos", schema = "waste", catalog="postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pago {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @Column(name = "idUsuario")
        private Integer idUsuario;

        @Column(name = "idGrupo")
        private Integer idGrupo;

        @Column(name = "importe")
        private Double importe;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Usuario.class)
        @JoinColumn(name = "idUsuario", referencedColumnName = "id", insertable = false, updatable = false)
        private Usuario usuario;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Grupo.class)
        @JoinColumn(name = "idGrupo", referencedColumnName = "id", insertable = false, updatable = false)
        private Grupo grupo;
}

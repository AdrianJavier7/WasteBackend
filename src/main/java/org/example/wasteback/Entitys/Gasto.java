package org.example.wasteback.Entitys;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gastos", schema = "waste", catalog="postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Gasto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @Column(name = "id_propietario")
        private Integer idPropietario;

        @Column(name = "id_grupo")
        private Integer idGrupo;

        @Column(name = "nombre")
        private String nombre;

        @Column(name = "precio")
        private Double precio;

        @Column(name = "descripcion")
        private String descripcion;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Usuario.class)
        @JoinColumn(name = "idUsuario", referencedColumnName = "id", insertable = false, updatable = false)
        private Usuario usuario;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Grupo.class)
        @JoinColumn(name = "id_grupo", referencedColumnName = "id", insertable = false, updatable = false)
        private Grupo grupo;
}

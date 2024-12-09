package org.example.wasteback.Entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pagos", schema = "waste", catalog = "postgres")
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

        @Column(name = "importe")
        private Double importe;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Grupo.class)
        @JoinColumn(name = "id_grupo", referencedColumnName = "id", insertable = false, updatable = false)
        private Grupo grupo;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Gasto.class)
        @JoinColumn(name = "id_gasto", referencedColumnName = "id", insertable = false, updatable = false)
        private Gasto gasto;

        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Usuario.class)
        @JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
        private Usuario usuario;
}

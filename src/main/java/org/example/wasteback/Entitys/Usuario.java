package org.example.wasteback.Entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "usuario", schema = "waste", catalog="postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;

    @Column(name = "numero_tlf")
    private String numeroTelefono;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "estado")
    private String estado;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Usuario.class)
    @JoinTable(name = "amigos",
            joinColumns = @JoinColumn(name = "idusuario_1" ),
            inverseJoinColumns = @JoinColumn(name = "idusuario_2"))
    private List<Usuario> amigos;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = Pago.class)
    @JoinColumn(name = "idUsuario", referencedColumnName = "id", insertable = false, updatable = false)
    private List<Pago> pagos;

}

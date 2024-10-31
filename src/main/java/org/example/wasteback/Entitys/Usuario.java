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
    @JoinTable(
            name = "amigos",
            schema = "waste",
            catalog = "postgres",
            joinColumns = @JoinColumn(name = "idUsuario_1", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "idUsuario_2", referencedColumnName = "id")
    )
    private List<Usuario> amigos;

}

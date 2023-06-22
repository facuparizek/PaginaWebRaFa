package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Usuario {

    public Usuario(DatosPersonales datosPersonales2, InfoCuenta infoCuenta2, boolean activo2) {
    }
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @OneToOne
    private DatosPersonales datosPersonales;
    @OneToOne
    private InfoCuenta infoCuenta;
    private boolean activo;


    

    
}

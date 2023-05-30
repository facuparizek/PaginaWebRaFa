package entidades;

import javax.persistence.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class DatosPersonales {

    private String nombre;
    private String apellido;
    private String userName;
    private Imagen imagen;
    
}

package entidades;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DatosPersonales {

    public DatosPersonales(String nombre2, String apellido2, String userName2) {
    }
    private String nombre;
    private String apellido;
    private String userName;
    private Imagen imagen;
    
}

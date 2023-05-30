package entidades;


import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
public class InfoCuenta {

    private String email;
    private String password;
    private Usuario[] seguidores;
    private Usuario[] seguidos;

    
}

package servicios;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import entidades.DatosPersonales;

@Service
public class DatosPersonalesServicio {
    
    public DatosPersonales crearDatos(String nombre, String apellido, String userName, MultipartFile archivo){
        DatosPersonales datosPersonales = new DatosPersonales(nombre, apellido, userName);





        return datosPersonales;
        
    }

    public void verificarNombre(String nombre){
        
    }
}

package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import entidades.DatosPersonales;
import excepciones.MiException;

@Service
public class DatosPersonalesServicio {

    @Autowired
    private ImagenServicio imagenServicio;

    public DatosPersonales crearDatos(String nombre, String apellido, String userName, MultipartFile archivo)
            throws MiException {
        verificarApellido(apellido);
        verificarNombre(nombre);
        verificarUsuername(userName);
        DatosPersonales datosPersonales = new DatosPersonales(nombre, apellido, userName);
        imagenServicio.guardar(archivo);
        return datosPersonales;

    }

    public void verificarNombre(String nombre) throws MiException {
        if (nombre.isEmpty()) {
            throw new MiException("El nombre no puede estar vacio");

        }
    }

    public void verificarApellido(String apellido) throws MiException {
        if (apellido.isEmpty()) {
            throw new MiException("El apellido no puede estar vacio");

        }
    }

    public void verificarUsuername(String userName) throws MiException {
        if (userName.isEmpty()) {
            throw new MiException("El userName no puede estar vacio");

        }
    }
}

package servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidades.DatosPersonales;
import entidades.InfoCuenta;
import entidades.Usuario;
import repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    public void crearUsuario(DatosPersonales datosPersonales, InfoCuenta infoCuenta, boolean activo){
        Usuario usuario = new Usuario(datosPersonales, infoCuenta, activo);
        usuarioRepositorio.save(usuario);       

    }

}


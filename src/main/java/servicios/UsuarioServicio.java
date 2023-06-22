package servicios;

import java.util.Optional;

import javax.transaction.Transactional;

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

    @Transactional
    public void crearUsuario(DatosPersonales datosPersonales, InfoCuenta infoCuenta, boolean activo) {

        Usuario usuario = new Usuario(datosPersonales, infoCuenta, activo);
        usuarioRepositorio.save(usuario);

    }

    @Transactional
    public void modificarUsuario(DatosPersonales datosPersonales, InfoCuenta infoCuenta, boolean activo, String id) {
        Optional<Usuario> usuario = usuarioRepositorio.findById(id);
        if (usuario.isPresent()) {
            Usuario usuario1 = usuario.get();
            usuario1.setActivo(activo);
            usuario1.setDatosPersonales(datosPersonales);
            usuario1.setInfoCuenta(infoCuenta);
            usuarioRepositorio.save(usuario1);
        }

    }

    @Transactional
    public void darDeBaja(String id){
        Optional<Usuario> usuario = usuarioRepositorio.findById(id);
        if (usuario.isPresent()) {
            Usuario usuario1 = usuario.get();
            usuario1.setActivo(false);
            usuarioRepositorio.save(usuario1);           
        }
    }

    public Usuario getOne(String id){
        return usuarioRepositorio.getReferenceById(id);
    }

}

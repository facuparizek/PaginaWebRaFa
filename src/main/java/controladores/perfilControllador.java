package controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import entidades.DatosPersonales;
import entidades.InfoCuenta;
import entidades.Usuario;
import excepciones.MiException;
import repositorios.UsuarioRepositorio;
import servicios.UsuarioServicio;

@Controller
@RequestMapping("/perfil")
public class perfilControllador {

    @Autowired
    private UsuarioServicio US;

    @Autowired
    private UsuarioRepositorio UR;

    @GetMapping("/modificar/{id}")
    public String modificarUsuario(ModelMap modelo, @PathVariable String id) {
        Optional<Usuario> respuesta = UR.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();
            modelo.put("nombre", usuario.getDatosPersonales().getNombre());
            modelo.put("username", usuario.getDatosPersonales().getUserName());
            modelo.put("password", usuario.getInfoCuenta().getPassword());
            modelo.put("apellido", usuario.getDatosPersonales().getApellido());

        }
        return "modificar.html";

    }

    @PostMapping("/modificado/{id}")//faltaría agregar la modificación de la imagen
    public String modificado( @RequestParam String password,@RequestParam String password2,
                                 @RequestParam String nombre, @RequestParam String apellido,
                                 @RequestParam String userName, MultipartFile archivo, ModelMap modelo, @PathVariable String id){
     InfoCuenta infoCuenta = new InfoCuenta(password,password2, null, null, null); 
     DatosPersonales datosPersonales = new DatosPersonales(nombre, apellido, userName, null);      
     US.modificarUsuario(datosPersonales, infoCuenta, true, id);  
     return "inicio.html";                     
    
}
}

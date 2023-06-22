package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import entidades.DatosPersonales;
import entidades.InfoCuenta;
import excepciones.MiException;
import servicios.DatosPersonalesServicio;
import servicios.InfoCuentaServicio;
import servicios.UsuarioServicio;

@Controller
@RequestMapping("/usuario")
public class usuarioControlador {

    @Autowired
    private UsuarioServicio US;

    @Autowired
    private DatosPersonalesServicio DPS;

    @Autowired
    private InfoCuentaServicio ICS;

    @GetMapping("/registar")
    public String crearUsuario() {
        return "registrar.html";
    }

    @PostMapping("/registrado")
    public String registrarUsuario(@RequestParam String email, @RequestParam String password,@RequestParam String password2,
    @RequestParam String nombre, @RequestParam String apellido, @RequestParam String userName, MultipartFile archivo, ModelMap modelo)
            throws MiException {
        try {
            DatosPersonales datosPersonales = DPS.crearDatos(nombre, apellido, userName, archivo);
            InfoCuenta infoCuenta = ICS.crearInfoCuenta(email, password, password2);
            US.crearUsuario(datosPersonales, infoCuenta, true);
            modelo.put("exito", "Usuario registrado con éxito");
            return "index.html";

        } catch (MiException e) {
            modelo.put("error", e.getMessage());
            modelo.put("email", email);
            modelo.put("nombre", nombre);
            modelo.put("apellido", apellido);
            modelo.put("userName", userName);
            return "registrar.html";
        }

    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }


}

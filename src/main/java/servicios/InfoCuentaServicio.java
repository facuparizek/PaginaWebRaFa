package servicios;

import entidades.InfoCuenta;
import excepciones.MiException;

public class InfoCuentaServicio {

    public InfoCuenta crearInfoCuenta(String email, String password, String password2) throws MiException {
        verificarPassword(password, password2);
        verificiarEmail(email);
        InfoCuenta infoCuenta = new InfoCuenta(email, password, null, null, null);
        return infoCuenta;

    }

    public void verificiarEmail(String email) throws MiException {
        if (email.isEmpty()) {
            throw new MiException("El email no puede estar vacío");
        }
    }

    public void verificarPassword(String password, String password2) throws MiException {
        if (password.equals(null) || password2.equals(null)) {
            throw new MiException("Las contraseñas no pueden estar vacías");
        }
        if (password.length() > 8) {
            throw new MiException("La contraseña no puede tener menos de 8 caracteres");
        }
        if (!password.equals(password2)) {
            throw new MiException("Las contraseñas no coinciden");
        }

    }
}

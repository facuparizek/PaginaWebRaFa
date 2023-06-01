package repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{

    
}

package ista.cursoM5A.Dao;

import org.springframework.data.repository.CrudRepository;
import ista.cursoM5A.Entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
}

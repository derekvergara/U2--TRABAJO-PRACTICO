package ista.cursoM5A.Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ista.cursoM5A.Dao.IUsuarioDao;
import ista.cursoM5A.Entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final IUsuarioDao usuarioDao;

    public UsuarioServiceImpl(IUsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> ListaUsuarios() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public Usuario GuardarUsuario(Usuario usuarios) {
        return usuarioDao.save(usuarios);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario BuscarUsuarioId(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void EliminarUsuario(Long id) {
        usuarioDao.deleteById(id);
    }
}

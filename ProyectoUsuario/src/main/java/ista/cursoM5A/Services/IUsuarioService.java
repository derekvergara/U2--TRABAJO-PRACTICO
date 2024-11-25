package ista.cursoM5A.Services;

import java.util.List;

import ista.cursoM5A.Entity.Usuario;

public interface IUsuarioService {
	public List<Usuario> ListaUsuarios();
	public Usuario  GuardarUsuario(Usuario usuarios);
	public  Usuario BuscarUsuarioId(Long id);
	public void EliminarUsuario(Long id);
}

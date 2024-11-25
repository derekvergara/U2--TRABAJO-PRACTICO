package ista.cursoM5A.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ista.cursoM5A.Entity.Usuario;
import ista.cursoM5A.Services.IUsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService Servi;

	@GetMapping("/listado")
	public Object listadousuario() {
		return Servi.ListaUsuarios();
	}

	// buscar por id
	@GetMapping("/listadoID/{id}")
	public Usuario show(@PathVariable("id") Long id) {
		return Servi.BuscarUsuarioId(id);
	}

	// guardar
	@PostMapping("/IngresarUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		return Servi.GuardarUsuario(usuario);
	}

	// editar

	@PutMapping("/editarUsuario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable("id") Long id) {
		Usuario uActual = Servi.BuscarUsuarioId(id);
		uActual.setNombre(usuario.getNombre());
		uActual.setEmail(usuario.getEmail());
		uActual.setClave(usuario.getClave());
		uActual.setEstado(usuario.getEstado());

		return Servi.GuardarUsuario(uActual);
	}

	// eliminar
	@DeleteMapping("/eliminarID/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void Eliminar(@PathVariable("id") Long id) {
		Servi.EliminarUsuario(id);
	}
}

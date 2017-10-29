package persistencia;

import com.uade.grupo9.model.PublicacionServicio;
import com.uade.grupo9.model.Usuario;
import com.uade.grupo9.persistencia.PublicacionServicioDAO;
import com.uade.grupo9.persistencia.UsuarioDao;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by pablo on 28/10/17.
 */
public class UsuarioDAOTest {
    private UsuarioDao dao;

    @Before
    public void setup(){
        dao = new UsuarioDao();
    }

    @Test
    public void levantarUsuariosTest(){
        List<Usuario> usuarios = dao.getTodos();

        assertTrue(!usuarios.isEmpty());
    }

    @Test
    public void traerUnUsuario(){
        Usuario usuario = dao.getById(1);
        assertNotNull(usuario);
    }

    @Test
    public void traerUnUsuarioPorNombre(){
        Usuario usuario = dao.getByNomUsuario("pepe");
        assertNotNull(usuario);
    }
}

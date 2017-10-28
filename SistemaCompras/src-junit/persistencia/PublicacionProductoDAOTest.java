package persistencia;

import com.uade.grupo9.model.PublicacionProducto;
import com.uade.grupo9.persistencia.PublicacionProductoDAO;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by pablo on 28/10/17.
 */
public class PublicacionProductoDAOTest {
    private PublicacionProductoDAO dao;

    @Before
    public void setup() {
        dao = new PublicacionProductoDAO();
    }

    @Test
    public void levantarPublicacionesTest() {
        List<PublicacionProducto> publicaciones = dao.getTodos();

        assertTrue(!publicaciones.isEmpty());
    }

    @Test
    public void traerUnaPublicacion() {
        PublicacionProducto publicacion = dao.getById(2);
        assertNotNull(publicacion);
    }
}

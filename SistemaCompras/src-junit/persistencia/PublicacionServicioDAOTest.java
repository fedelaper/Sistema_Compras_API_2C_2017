package persistencia;

import com.uade.grupo9.model.Publicacion;
import com.uade.grupo9.model.PublicacionServicio;
import com.uade.grupo9.persistencia.PublicacionServicioDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by pablo on 28/10/17.
 */
public class PublicacionServicioDAOTest {
    private PublicacionServicioDAO dao;

    @Before
    public void setup(){
        dao = new PublicacionServicioDAO();
    }

    @Test
    public void levantarPublicacionesTest(){
        List<PublicacionServicio> publicaciones = dao.getTodos();

        assertTrue(!publicaciones.isEmpty());
    }

    @Test
    public void traerUnaPublicacion(){
        PublicacionServicio publicacion = dao.getById(1);
        assertNotNull(publicacion);
    }
}

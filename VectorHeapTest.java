
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de prueba para la implementación de VectorHeap
 * @author javi-
 */
public class VectorHeapTest {
    VectorHeap v = new VectorHeap();
    public VectorHeapTest() {
        Scanner myReader = new Scanner("Juan Perez, fractura de pierna, C\n" +
"Lorenzo Toledo, chikunguya, E\n" +
"Carmen Sarmientos, dolores de parto, B");
                                 while (myReader.hasNextLine()) {
                                     String data = myReader.nextLine();
                                     String[] clave = data.split(",");
                                     v.add(new Paciente(clave[0],clave[1],clave[2].trim().charAt(0)));
    }
    }
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testAdd(){
        v.add(new Paciente("Juan Perez", "fractura de cadera", 'A'));
        assertEquals(((Paciente) v.getFirst()).getPrioridad(), 'A');
    }
    
    @Test
    public void testOrden(){
        // Recordemos que las letras más bajas tienen prioridad más alta
        assertEquals(((Paciente) v.remove()).getPrioridad()< ((Paciente) v.remove()).getPrioridad(), true);
    }
}

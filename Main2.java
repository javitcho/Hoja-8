
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.PriorityQueue;
import javax.swing.JFileChooser;

/**
 * Main implementando PriorityQueue de JCF como cola de prioridad
 * @author javi-
 */
public class Main2 {
    public static void main(String args[]){
        PriorityQueue v = new PriorityQueue();
        Object[] options = {"Vector Heap", "JCF Priority Queue"};
        JFileChooser fc = new JFileChooser();
                             fc.setDialogTitle("Elije el archivo de texto que contiene las fichas de los pacientes");
                             fc.showDialog(null, "Abrir");
                             File file = fc.getSelectedFile();
        try {
                                 Scanner myReader = new Scanner(file);
                                 while (myReader.hasNextLine()) {
                                     String data = myReader.nextLine();
                                     String[] clave = data.split(",");
                                     v.add(new Paciente(clave[0],clave[1],clave[2].trim().charAt(0)));
                                     
                                 }
                             } catch (FileNotFoundException e) {
                                 System.out.println("An error occurred.");
                                 e.printStackTrace();
                             }
        while(! v.isEmpty()){
            System.out.println(v.remove().toString());
        }
        
    }
}

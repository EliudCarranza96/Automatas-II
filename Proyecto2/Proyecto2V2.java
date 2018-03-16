package proyecto2;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;
import java.io.*;
import static java.lang.System.out;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author Eliud
 */
public class Proyecto2V2 extends JFrame {
    javax.swing.JTextArea jTextArea1;

    public Proyecto2V2() {
          
        DefaultTableModel myModel = new DefaultTableModel();
        myModel.addColumn("ID");
        myModel.addColumn("Nombre");
        myModel.addColumn("Tipo");
        myModel.addColumn("Tamaño");
        myModel.addColumn("Valor");
        myModel.addColumn("Ambito");
        JTable table = new JTable(myModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 150));


         
            BufferedReader br = null;
                try{
                    br = new BufferedReader(new FileReader("/home/linux14/Escritorio/AutomatasIIProy2/PY2.txt"));
                    String line = br.readLine();

                    for(int row = 0; row < 10 ; row++){
                        for(int column = 0; column<6 ;column++){


                                   while (line != null )
                                   {
                                     String [] rowfields = line.split("\\s+");
                                     myModel.addRow(rowfields);
                                     line = br.readLine();
                                    }
                                   
                                }
                             }
                                            }
                catch(Exception e)
                  {
                            System.out.println(e.getMessage());
                  }
        jTextArea1 = new javax.swing.JTextArea();

        jTextArea1.setColumns(20);

        jTextArea1.setRows(5);

        
        JTabbedPane panelInformacion = new JTabbedPane();
        JPanel panel1 = new JPanel();
        panel1.add( new JScrollPane( table ));
        panelInformacion.addTab( "Tabla", null, panel1, "Primer panel" );
        getContentPane().add( panelInformacion );
        //
        panel1.add("South", jTextArea1);
        JButton Agregar = new JButton("Agregar");
        panel1.add("North", Agregar);
                Agregar.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent ae){
int i;
        try {
            FileWriter fstream = new FileWriter("home\\linux14\\Escritorio\\AutomatasIIProy2\\PY2.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            for(i=0;i<10;i++){
                out.write(jTextArea1.getText()+i+"\n");
                JOptionPane.showMessageDialog(null,"Se guardó Correctamente");
            }
            out.close();
        } catch (IOException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        }   
    
                });
        JButton Buscar = new JButton("Buscar");
        panel1.add("North",Buscar);
        setSize( 1000, 600 );
        setVisible( true );
        Buscar.addActionListener(new ActionListener(){

      @Override
      public void actionPerformed(ActionEvent ae){
                  
        try { 
File original = new File("/home/linux14/Escritorio/AutomatasIIProy2/PY2.txt"); 
FileInputStream a = new FileInputStream(original); 
InputStreamReader b = new InputStreamReader(a); 
b = new InputStreamReader(a, b.getEncoding()); 
BufferedReader lector = new BufferedReader(b); 
String line = lector.readLine(); 
while (line != null) { 
    String[] palabras = line.split(" ");  
for(int i = 0; i < palabras.length; i++){ 
if(palabras[i].equals(jTextArea1.getText())){  
    JOptionPane.showMessageDialog(null,"Si existe");
}
else{
    JOptionPane.showMessageDialog(null,"No existe");
}
    
} 
line = lector.readLine(); 
} 
} catch (Exception e) { 
}
        }

    
                });
                
    }
    

    public static void main(String[] args) {
        Proyecto2 aplicacion = new Proyecto2();
	aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }        

}
/* MenuPromGUI.java
   Para ilustrar una Aplicacion con menus graficos 
   utiliza swing, 
   el 10 de marzo del 2011
   por cirino Silva Tovar
   capa del usuario
*/

package AplicacionPorCapas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class MenuPromGUI extends Frame implements ActionListener{ // capa de usuario
    private JOptionPane messageBox;                // despliega mensajes
    PromCentPersGUI pcp = new PromCentPersGUI();   // capa del modelo de negocios
    ArchiDatosGUI ad = new ArchiDatosGUI();        // capa de persistencia
    int n;                                         // cuenta los datos 

    public MenuPromGUI(){ // constructor de la GUI
        createMenu();
        setTitle("Promedio de n datos");
        addWindowListener(new CloseHandler()); // maneja evento de cierre
        setLocation(200,200);
        setSize(300,200);
    }

    public void actionPerformed(ActionEvent event){ // maneja eventos del menú
        String menuName;
  
        menuName = event.getActionCommand(); // identifica el comando
        if(menuName.equals("Nuevo")) newProm();
        else if(menuName.equals("Abrir...")) open();
        else if(menuName.equals("Guardar")) save();
        else if(menuName.equals("Salir")) quit();
        else if(menuName.equals("Captura")) edit();
        else if(menuName.equals("Resultados")) resultado();
        else if(menuName.equals("Ayuda")) ayuda();
    }

    private void createMenu(){
        MenuItem    item;
        Menu        menu;
        MenuBar     menuBar;
        String [] bar  = {"Archivo","Entradas","Mostrar"};
        String [][]opt = {{"Nuevo","Abrir...","Guardar","Salir"},
                        {"Captura"},
                        {"Resultados","Ayuda"}};

        menuBar = new MenuBar(); //create menubar first
        for(int i = 0 ; i < bar.length; i++){
            menu = new Menu(bar[i]);        //Show Menu
            menuBar.add(menu);
            for (int j = 0; j < opt[i].length; j++ ){
                item = new MenuItem(opt[i][j]); //All options
                item.addActionListener( this );
                menu.add( item );
            }
        }
        setMenuBar(menuBar); //set menubar AFTER all menus are added to it
    }

    private void resultado(){ // Gestionando la capa del modelo de negocios
        pcp.calculos(n);
        pcp.resultados(n);
    }

    private void ayuda(){
        String l="";
    
        l+="Cuando se solicite el nombre ";
        l+="de un archivo, usted puede dar <enter> ";
        l+="\npara visualizar el contenido ";
        l+="del subdirectorio de trabajo actual ";   
        messageBox.showMessageDialog(null,l);
    }

    private void edit(){ n = pcp.datos(); } // gestiona la captura de los datos

    private void newProm(){
        String l= "";

        n = pcp.nuevo(); // se inicializan los valores del arreglo
        l+="Se ha limpiado el arreglo";
        l+="\ncon cero datos, ahora hay disponibles";
        l+="\n100 lugares para alimentar y promediar";
        messageBox.showMessageDialog(null,l);
    }

    private void open(){ // gestiona la lectura de los datos
        String arch=""; // desde archivo capa persistencia

        arch = messageBox.showInputDialog("Deme nombre del archivo:");
        if(arch.equals("")||arch == null) ad.listaFicheros(".");
        else n = ad.datosIn(arch, pcp.datos);
    }

    private void quit(){ System.exit(0); }

    private void save(){ // gestiona la capa de persistencia
        String arch=""; // almacenando los datos en el archivo
                        // seleccionado por el usuario
        arch = messageBox.showInputDialog("Deme nombre del archivo:");
        if(arch.equals("")||arch == null) ad.listaFicheros(".");
        else ad.datosOut(arch, pcp.datos, n);
    }

    public static void main (String args[]){
        MenuPromGUI mpw = new MenuPromGUI();

        mpw.pcp.inicio();
        mpw.setVisible(true);
    }

    private class CloseHandler extends WindowAdapter{
        public void windowClosing(WindowEvent e){ System.exit(0); }
    }
}


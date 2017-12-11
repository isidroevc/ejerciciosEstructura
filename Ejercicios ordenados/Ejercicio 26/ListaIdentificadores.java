import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class ListaIdentificadores {
    	String arch, nArch, aux1, linea;
    	int capMax;
    	boolean found;
    	public static String pReservadas[]={"abstract", "assert", "boolean",
                        "break", "byte", "case", "catch",
                        "char", "class", "const", "continue",
                        "default", "do", "double", "else",
                        "enum", "extends", "final", "finally",
                        "float", "for", "goto", "if", "implements",
                        "import", "instanceof", "int", "interface",
                        "long", "native","new", "package", "private",
                        "protected", "public", "return", "short",
                        "static", "strictfp", "super", "switch",
                        "synchronized", "this", "throw", "throws",
                        "transient", "try", "void", "volatile", "while"};
    	Lista idenf;
    
    	public void inicio() {
        		aux1="Lista de identificadores del lenguaje";
                aux1 +=  " de programación Java.";
        		System.out.println(aux1);
    	}

    	public void datos() {
        		arch="";
        		aux1="Ingrese la dirección completa del archivo a leer:";
        		arch+=JOptionPane.showInputDialog(aux1);
        		aux1="Ingrese la capacidad de la lista";
        		capMax=Integer.parseInt(JOptionPane.showInputDialog(aux1));
        		idenf=new Lista(capMax);
        		leerArch(arch);
    	}
    
    	public void leerArch(String archivo) {
        		File file=new File(archivo);
        		int token;
        
        		try {
            		if (file.exists()) {
                		FileReader fr=new FileReader(file);
                		StreamTokenizer tokenz=new StreamTokenizer(fr);
                		token=tokenz.nextToken();
                		while (token!=StreamTokenizer.TT_EOF) {
                    		if (token==StreamTokenizer.TT_WORD) 
                    			if(!palReserv(tokenz.sval)) 
                        			insertar(tokenz.sval,tokenz.lineno());
                			token=tokenz.nextToken();                			
                        }
            		}
            		navGuardar();
            		navegabilidad();
        		} catch (IOException e) { System.out.println("¡Ups! "+e); }
    	}
    
    	private static boolean palReserv(String palabra) {
        		for (int i=0; i<pReservadas.length; i++)
            			if (palabra.compareTo(pReservadas[i])==0) return true;
        		return false;
    	}
    
    	public void insertar(String identificador, Integer linea) {
        		found=false;
        		Iterator it=idenf.iterador();
		while (it.hasNext() && !found) {
	    		IdyLista ident=(IdyLista) it.next();
	    		if (ident.obtNombre().equals(identificador)) {
				Lista lis=ident.obtLista();
				lis.agregar(linea);
				found=true;
	    		}
		}
		if (!found) {
	    		Lista lista=new Lista(capMax);
	    		lista.agregar(linea);
	    		idenf.agregar(new IdyLista(identificador, lista));
		}
    	}
    
    	public void impPantalla() {
        		System.out.println("Archivo '"+arch+"'.");
        		for(Iterator it=idenf.iterador(); it.hasNext();) {
            			IdyLista idLista=(IdyLista)it.next();
            			System.out.print(idLista.obtNombre()+": ");
            			Lista lista=idLista.obtLista();
            			for (Iterator ilista=lista.iterador(); ilista.hasNext();)
                		System.out.print(ilista.next()+", ");
            			System.out.println();
        		}
    	}
    
    	public void escribir(String linea, String archivo) throws IOException {
        		BufferedWriter bw;
        		try {
            			File file=new File(archivo);
            			FileWriter fw=new FileWriter(file,true);
            			bw=new BufferedWriter(fw);
            			bw.write(linea);
            			bw.newLine();
            			bw.flush();
            			bw.close();
        		} catch(IOException ex) { 
                    System.out.println("Error escribir. "+ex); 
                }
    	}
    
    	public void guardarArch() throws IOException {
        		aux1="Ingrese el nombre del archivo:";
        		nArch=JOptionPane.showInputDialog(aux1);
        
        		for(Iterator it=idenf.iterador(); it.hasNext(); ) {
            			IdyLista idLista=(IdyLista) it.next();
            			linea=idLista.obtNombre()+": ";
            			Lista lista=idLista.obtLista();
            			for (Iterator ilista=lista.iterador(); ilista.hasNext(); )
                		linea+=ilista.next()+", ";
            			escribir(linea, nArch);
        		}
    	}
    
    	public void navGuardar() throws IOException {
        		int g;
        		aux1="¿Cómo desea mostrar la información?";
        		aux1+="\n1.Imprimir en pantalla\n2.Guardar en archivo";
        
        		do {
            			g=Integer.parseInt(JOptionPane.showInputDialog(aux1));
            			switch(g) {
                			case 1: impPantalla(); break;
                			case 2: guardarArch(); break;
            			}
        		} while(g!=2);
    	}

    	public void navegabilidad() {
        		int m;
        		aux1="¿Desea probar con otro archivo?\n1.Si\n2.No";
        		do {
            			m=Integer.parseInt(JOptionPane.showInputDialog(aux1));
            			switch(m) {
                			case 1: datos(); break;
                			case 2: System.exit(0);
            			}
        		} while (m!=2);
    	}
    
    	public static void main(String[] args) {
        		ListaIdentificadores i=new ListaIdentificadores();
        		i.inicio();
        		i.datos();
        		i.navegabilidad();
    	}
}
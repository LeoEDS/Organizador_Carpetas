package organizador;

import java.util.ArrayList;
import java.util.Scanner;

public class Organizador {

    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        ArrayList<Materias> listaMaterias = new ArrayList();
        ArrayList<Dias> diasMaterias = new ArrayList();
        int i=0;
        String nombre;

        System.out.println("Ingresando las Materias... (INGRESE UN 0 PARA TERMINAR)");
        System.out.println("");
        do {
            System.out.print("Ingrese el Nombre de la Materia" + i + " :  ");
            nombre=scanf.nextLine();
            i++;
            Materias swap = new Materias(i, nombre);
            listaMaterias.add(swap);

        } while (!nombre.equals("0"));
        

        System.out.println("");
        for(i=0; i<5; i++){
            System.out.print("Ingresando la Materia de los Dias ");
            switch(i){
                case 0 : System.out.println(" LUNES... (INGRESE UN 0 PARA TERMINAR)"); break;
                case 1 : System.out.println(" MARTES... (INGRESE UN 0 PARA TERMINAR)"); break;
                case 2 : System.out.println(" MIERCOLES... (INGRESE UN 0 PARA TERMINAR)"); break;
                case 3 : System.out.println(" JUEVES... (INGRESE UN 0 PARA TERMINAR)"); break;
                case 4 : System.out.println(" VIERNES... (INGRESE UN 0 PARA TERMINAR)"); break;
            }
            ArrayList<String> dia = new ArrayList();
            do {
                System.out.print("Ingrese el Nombre de la Materia:  ");
                nombre=scanf.nextLine();
                i++;
                dia.add(nombre);
            } while (!nombre.equals("0"));
            Dias swap = new Dias(dia);
            diasMaterias.add(swap);
        }
        
        
        // ACA VA EL CODIGO DE COMPARACION
        
        
        
        
    }
    
    public static int posibilidades (int posi){
        if(posi<2)
            return 1;
        else
            return posi*posibilidades(posi-1);
    }

}

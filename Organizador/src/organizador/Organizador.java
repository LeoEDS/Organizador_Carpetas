package organizador;

import java.util.ArrayList;
import java.util.Scanner;

public class Organizador {
        static ArrayList<Materias> listaMaterias = new ArrayList();
        static ArrayList<Dias> diasMaterias = new ArrayList();
        static int v[][];
        static int materiasPorCarpeta;

    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
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
        
        int totalPosibilidades[] = new int [listaMaterias.size()]; 

        System.out.println("");
        for(i=0; i<5; i++){
            int x=0;
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
                x++;
                dia.add(nombre);
            } while (!nombre.equals("0"));
            Dias swap = new Dias(dia);
            diasMaterias.add(swap);
        }
        
        System.out.print("Ingrese el Numero de Materias por Carpeta: ");
        materiasPorCarpeta = scanf.nextInt();
        
        
        for(i=0;i<listaMaterias.size();i++){
            totalPosibilidades[i]=i;
        }
        System.out.println("Cargando las Posibilades...");
        v = new int[posibilidades(listaMaterias.size())][listaMaterias.size()];
        helper(totalPosibilidades, 0);
        for(i=0;i<5;i++) System.out.println();
        
        for(i=0;i<posibilidades(totalPosibilidades.length);i++) {
            for(int x=0;x<totalPosibilidades.length; x++){
                    // ACA VA EL CODIGO DE COMPARACION
                    if(x%materiasPorCarpeta==0) System.out.println();
                    System.out.print(v[i][x] + " ");
            }
            System.out.println();
        } 
        
                
        
        
        
        
    }
    

    static int tupla=0;

    public static void helper(int[] array, int pos){  
        if(pos >= array.length - 1){   
            for(int i = 0; i < array.length-1; i++){
                v[tupla][i]=array[i];
            }  
            if(array.length > 0)   
                v[tupla][array.length-1]=array[array.length-1];
            tupla++;
            return;  
        }  
  
        for(int i = pos; i < array.length; i++){   
          
            int t = array[pos];  
            array[pos] = array[i];  
            array[i] = t;  
  
            helper(array, pos+1);  
  
            t = array[pos];  
            array[pos] = array[i];  
            array[i] = t;  
        }  
    }  
    
    public static int posibilidades (int posi){
        if(posi<2)
            return 1;
        else
            return posi*posibilidades(posi-1);
    }

}
package organizador;

import java.util.ArrayList;
import java.util.Scanner;

public class Organizador {
        static ArrayList<Materias> listaMaterias = new ArrayList(); //ARRAY DE MATERIAS
        static ArrayList<Dias> diasMaterias = new ArrayList(); //ARRAY DE LAS MATERIAS QUE HAY CADA DIA: EL 0 ES LUNES Y EL 4 ES VIERNNES
        static int v[][]; //VECTOR CON TODAS LAS POSIBILIDADES DE COMBBINACION. CONTIENE NUMERO DEL 0 HASTA 'X' CANTIDAD DE MATERIAS QUE SE HAYAN INGRESADO. CADA NUMERO DEL 0 A 'X' REPRESENTA UN ID DE MATERIA
        static int tupla=0;
        static int materiasPorCarpeta; // NUMERO DE MATERIAS QUE HAY POR CARPETA

    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        int i=0;
        int maximoCarpetasPorDia;
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
        
        int totalPosibilidades[] = new int [listaMaterias.size()]; // VECTOR CON NUMEROS DEL 0 AL 'X' CANTIDAD DE MATERIAS PARA ENTREGARLO A LA FUNCION QUE RELLENA LA MATRIZ CON TODAS LAS POSIBILIDADES

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
        System.out.print("Ingrese el Numero Máximo de Carpetas por Dia: ");
        maximoCarpetasPorDia = scanf.nextInt();
        
        
        for(i=0;i<listaMaterias.size()-1;i++){
            //System.out.println(i);
            totalPosibilidades[i]=i;
        }
        System.out.println("Cargando las Posibilades...");
        v = new int[posibilidades(listaMaterias.size())][listaMaterias.size()];
        helper(totalPosibilidades, 0);
        // for(i=0;i<5;i++) System.out.println();
        for(i=0;i<posibilidades(totalPosibilidades.length);i++) {
            // System.out.println("eso " + (listaMaterias.size()/materiasPorCarpeta) + " mat " + materiasPorCarpeta);
            // System.out.println("vamos con reglones" + posibilidades(totalPosibilidades.length));
            int carpetas[][] = new int[listaMaterias.size()/materiasPorCarpeta][materiasPorCarpeta];
            int hor=0,ver=0;
            for(int x=1;x<listaMaterias.size(); x++){
                // System.out.println(x%listaMaterias.size());
                //System.out.println("es -> " + ((x%materiasPorCarpeta)));
                if((x%materiasPorCarpeta)!=0) {
                    carpetas[hor][ver]=v[i][x-1];
                    ver++;
                } else {
                    carpetas[hor][ver]=v[i][x-1];
                    hor++;
                    //System.out.println("siiiiiiiiiiii " + x);
                    ver=0;
                }
            }
            
            int cantC[] = new int [5];
            for(int x=0; x<5;x++){
                int swap = carpetasPorDia(carpetas, diasMaterias.get(x), listaMaterias);
                if (swap==(-1)) break; //SIGNNIFICA QUE EN LA CARPETA FALTAN MATERIAS
                cantC[x] = swap;
            }
            for(int x=0;x<5;x++){
                if(cantC[x]>materiasPorCarpeta || cantC[x]==-1) break;
                if(x==4) imprimirCarpetaGanadora(carpetas, cantC);
            }
            
            // ACA VA EL CODIGO DE COMPARACION
            for(int y=0;y<listaMaterias.size()/materiasPorCarpeta;y++){
                for(int u=0; u<materiasPorCarpeta;u++){
                    System.out.print(" " + carpetas[y][u]);
                }
                System.out.println("");
            }
            //System.out.println("");
            //System.out.println("----");
            //System.out.println();
            
        }
        /*
        for(i=0;i<);i++){
            for(int x=0;x<listaMaterias.size();x++)
                System.out.print( v[i][x] + "  "); //IMPRIME PARA VER SI SE GUARDO CORRECTAMENTE
        }*/
        
    }
    
    public static int carpetasPorDia (int carpeta[][], Dias dia, ArrayList<Materias> materias) {
        //COMPROBAR QUE DENTRO DE LAS CARPETA (o sea la variable carpeta[][]) SE ENCUENTRENN TODAS LAS MATERIAS (o sea los numeros de totalPosibilidades). Si no hace un return de -1
        return -1;
    }
    
    public static void imprimirCarpetaGanadora(int carpeta[][], int CantC[]){
        //IMPRIME LA CARPETA Y LA CANTIDAD MAXIMA DE CARPETAS POR DÍA
    }

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

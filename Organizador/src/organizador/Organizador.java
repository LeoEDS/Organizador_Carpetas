package organizador;

import java.util.ArrayList;
import java.util.Scanner;

public class Organizador {
        static ArrayList<Materias> listaMaterias = new ArrayList(); //ARRAY DE MATERIAS
        static ArrayList<Dias> diasMaterias = new ArrayList(); //ARRAY DE LAS MATERIAS QUE HAY CADA DIA: EL 0 ES LUNES Y EL 4 ES VIERNNES
        static ArrayList<ArrayList<Integer>> res = new ArrayList(); //VECTOR CON TODAS LAS POSIBILIDADES DE COMBINACION. CONTIENE NUMERO DEL 0 HASTA 'X' CANTIDAD DE MATERIAS QUE SE HAYAN INGRESADO. CADA NUMERO DEL 0 A 'X' REPRESENTA UN ID DE MATERIA
        static int materiasPorCarpeta; // NUMERO DE MATERIAS QUE HAY POR CARPETA

    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        int i=1;
        int maximoCarpetasPorDia;
        String nombre;

        System.out.println("Ingresando las Materias... (INGRESE UN 0 PARA TERMINAR)");
        System.out.println("");

        System.out.print("Ingrese el Nombre de la Materia " + i + " :  ");
        nombre=scanf.nextLine();
        while (!nombre.equals("0")) {
            Materias swap = new Materias(i, nombre);
            listaMaterias.add(swap);
            i++;
            System.out.print("Ingrese el Nombre de la Materia " + i + " :  ");
            nombre=scanf.nextLine();
        }

        System.out.println("");
        for(i=0; i<5; i++){
            System.out.print("Ingresando las Materias de los Dias ");
            switch(i){
                case 0 : System.out.println(" LUNES... (INGRESE UN 0 PARA TERMINAR)"); break;
                case 1 : System.out.println(" MARTES... (INGRESE UN 0 PARA TERMINAR)"); break;
                case 2 : System.out.println(" MIERCOLES... (INGRESE UN 0 PARA TERMINAR)"); break;
                case 3 : System.out.println(" JUEVES... (INGRESE UN 0 PARA TERMINAR)"); break;
                case 4 : System.out.println(" VIERNES... (INGRESE UN 0 PARA TERMINAR)"); break;
            }
            ArrayList<String> dia = new ArrayList();
            System.out.print("Ingrese el Nombre de la Materia:  ");
            nombre=scanf.nextLine();
            while (!nombre.equals("0")) {
                dia.add(nombre);
                System.out.print("Ingrese el Nombre de la Materia:  ");
                nombre=scanf.nextLine();
            } 
            Dias swap = new Dias(dia);
            diasMaterias.add(swap);
        }
        
        System.out.print("Ingrese el Numero de Materias por Carpeta: ");
        materiasPorCarpeta = scanf.nextInt();
        System.out.print("Ingrese el Numero Máximo de Carpetas por Dia: ");
        maximoCarpetasPorDia = scanf.nextInt();
        
        
        System.out.println("Cargando las Posibilades...");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        ArrayList<Integer> totalPosibilidades = new ArrayList(); // VECTOR CON NUMEROS DEL 0 AL 'X' CANTIDAD DE MATERIAS PARA ENTREGARLO A LA FUNCION QUE RELLENA LA MATRIZ CON TODAS LAS POSIBILIDADES
        for(i=1;i<=listaMaterias.size();i++){
            totalPosibilidades.add(i);
        }
        ArrayList<Integer> vacio = new ArrayList();
        cargarPosi(totalPosibilidades, vacio);
        
        ArrayList<int[][]> carpetasHistorial = new ArrayList();
        for(i=0;i<posibilidades(totalPosibilidades.size());i++) { // Por cada Carpeta
            int carpetas[][] = new int[(listaMaterias.size()/materiasPorCarpeta)+1][materiasPorCarpeta];
            for(int x=1;x<=listaMaterias.size(); x++) {
                carpetas[(x-1)/materiasPorCarpeta][(x-1)%materiasPorCarpeta]=res.get(i).get(x-1);

            }
            // ordena la Matriz "carpeta" horizontalmente y luego verticalmente
            for(int x=0;x<(listaMaterias.size()/materiasPorCarpeta)+1;x++) { // por cada vector...
                for(int z=0;z<materiasPorCarpeta;z++){ // Repetir la cantidad de veces de largo del vector
                    for(int y=1;y<materiasPorCarpeta;y++){ // Recorrer por cada materia
                        if(carpetas[x][y-1] == 0) carpetas[x][y-1] = 2147483647; // si es 0, o sea vacio, lo llena con el int mas grande
                        if(carpetas[x][y-1] > carpetas[x][y]) { // Aplica Burbujeo
                            int swap = carpetas[x][y-1];
                            carpetas[x][y-1] = carpetas[x][y];
                            carpetas[x][y] = swap;
                        }
                    }
                }
            }
            for(int x=0;x<(listaMaterias.size()/materiasPorCarpeta)+1;x++) { // Repetir la cant. de veces de largo del vector...
                for(int y=1;y<(listaMaterias.size()/materiasPorCarpeta)+1;y++){
                    if(carpetas[y-1][0] > carpetas[y][0]) { // Aplica Burbujeo
                        int swap[] = new int[materiasPorCarpeta];
                        System.arraycopy(carpetas[y-1], 0, swap, 0, materiasPorCarpeta); //System.out.println(swap[z]);
                        System.arraycopy(carpetas[y], 0, carpetas[y-1], 0, materiasPorCarpeta);
                        System.arraycopy(swap, 0, carpetas[y], 0, materiasPorCarpeta);
                    }
                }
            }
            
            // Busque que no haya repetidos anteriores
            int Encontrado=0;
            if (carpetasHistorial.isEmpty()) carpetasHistorial.add(carpetas);
            else {
                for(int x=0;x<carpetasHistorial.size();x++) {
                    int coincidencias=0;
                    for(int y=0;y<(listaMaterias.size()/materiasPorCarpeta)+1;y++){
                        for(int z=0;z<materiasPorCarpeta;z++){
                            if(carpetas[y][z] == carpetasHistorial.get(x)[y][z]) coincidencias++;
                        }
                    }
                    if(coincidencias>listaMaterias.size()) Encontrado=1;
                }
            }
            
            if(Encontrado==0) { // Si no se encontró un vector igual, imprimirlo
                carpetasHistorial.add(carpetas);
                int cantC[] = new int [5];
                for(int x=0; x<5;x++){
                    cantC[x] = carpetasPorDia(carpetas, diasMaterias.get(x));
                }
                int max=cantC[0];
                for(int x=1;x<cantC.length;x++) if(max<cantC[x]) max=cantC[x];
                if(max<=maximoCarpetasPorDia) imprimirCarpetaGanadora(carpetas, cantC);
            }
            

        }
    }
    
    public static int carpetasPorDia (int carpeta[][], Dias dia) {
        ArrayList<Integer> eleccionCarpeta = new ArrayList();
        for(int i=0;i<dia.getMateriasDelDia().size();i++){
            ///COMPRUEBA EL NUMERO DE LA MATERIA
            int numeroMateria=-1;
            for(int x=0;x<listaMaterias.size();x++){
                if(listaMaterias.get(x).getMateria().equalsIgnoreCase(dia.getMateriasDelDia().get(i))) numeroMateria=listaMaterias.get(x).getId();
            }
            ///Empiza la Busqueda
            for(int x=0;x<(listaMaterias.size()/materiasPorCarpeta)+1;x++){
                for(int y=0;y<materiasPorCarpeta;y++){
                    if(carpeta[x][y] == numeroMateria) {
                        eleccionCarpeta.add(x);
                    }                    
                }
            }
        }
            ArrayList<Integer> carpetasEncontradas = new ArrayList();
            
            for(int i=0;i<eleccionCarpeta.size();i++){
                // VERIFICA SI LA CARPETA YA SE HABIA ENCONTRADO
                int boolYaEncontrada=0;
                for(int x=0;x<carpetasEncontradas.size();x++){
                    if(eleccionCarpeta.get(i).equals(carpetasEncontradas.get(x))) {
                        boolYaEncontrada=1;
                        break;
                    }
                }
                if (boolYaEncontrada==0) carpetasEncontradas.add(eleccionCarpeta.get(i));
            }
        return carpetasEncontradas.size() ;
    }
    
    public static void imprimirCarpetaGanadora(int carpeta[][], int cantC[]){
        //IMPRIME LA CARPETA Y LA CANTIDAD MAXIMA DE CARPETAS POR DÍA
        int totalC=0;
        for(int x=0; x<5; x++){
            switch(x){
                case 0 : System.out.print("     LUNES: "); break;
                case 1 : System.out.print(" ; MARTES: "); break;
                case 2 : System.out.print(" ; MIERCOLES: "); break;
                case 3 : System.out.print(" ; JUEVES: "); break;
                case 4 : System.out.print(" ; VIERNES: "); break;
            }
            System.out.print(cantC[x]);
        }
        System.out.println("");
        for(int x=0;x<cantC.length;x++) totalC+=cantC[x];
        System.out.println("     Cantidad de Carpetas Semanal: " + totalC);
        System.out.print("     CARPETA: \n");
            for(int y=0;y<(listaMaterias.size()/materiasPorCarpeta)+1;y++){
                for(int x=0; x<materiasPorCarpeta;x++){
                    System.out.print("       ");
                    for(int i=0; i<listaMaterias.size();i++){
                        if(carpeta[y][x]==listaMaterias.get(i).getId()) System.out.print(listaMaterias.get(i).getMateria());
                    }
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
    }
    
    public static void cargarPosi (ArrayList<Integer> totalPosibilidades, ArrayList<Integer> posibilidad) {
        for(int i=0;i<totalPosibilidades.size();i++) { 
            if(totalPosibilidades.size() == 1) { // Si queda solo un numero lo agrega al arraylist y lo guarda ese array en el arraylist de los otros arraylist
                posibilidad.add(totalPosibilidades.get(0));
                res.add(posibilidad);
            } else { // Aplica la recursion
                // Agrega el numero dentro de otro array para Pasarselo a la Recursion
                ArrayList<Integer> posiSwap = new ArrayList(); 
                    posibilidad.forEach((n) -> posiSwap.add(n));
                    posiSwap.add(totalPosibilidades.get(i));
                    
                // Elimina el numero que se colocó en el Array y le Pasa a la recurción el array sin ese numero
                ArrayList<Integer> swap = new ArrayList(); 
                    totalPosibilidades.forEach((n) -> swap.add(n));
                    swap.remove(i);

                cargarPosi(swap, posiSwap);
            }
        }
    }
    
    public static int posibilidades (int posi){
        if(posi<2)
            return 1;
        else
            return posi*posibilidades(posi-1);
    }

}

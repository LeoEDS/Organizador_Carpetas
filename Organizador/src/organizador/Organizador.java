package organizador;

import java.util.ArrayList;
import java.util.Scanner;

public class Organizador {
        static ArrayList<Materias> listaMaterias = new ArrayList(); //ARRAY DE MATERIAS
        static ArrayList<Dias> diasMaterias = new ArrayList(); //ARRAY DE LAS MATERIAS QUE HAY CADA DIA: EL 0 ES LUNES Y EL 4 ES VIERNNES
        static ArrayList<ArrayList<Integer>> res = new ArrayList(); //VECTOR CON TODAS LAS POSIBILIDADES DE COMBINACION. CONTIENE NUMERO DEL 0 HASTA 'X' CANTIDAD DE MATERIAS QUE SE HAYAN INGRESADO. CADA NUMERO DEL 0 A 'X' REPRESENTA UN ID DE MATERIA
        static int tupla=0;
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
            System.out.print("Ingrese el Nombre de la Materia " + i + " :  ");
            nombre=scanf.nextLine();
            i++;
        } 
        

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
            System.out.print("Ingrese el Nombre de la Materia:  ");
            nombre=scanf.nextLine();
            while (!nombre.equals("0")) {
                dia.add(nombre);
                System.out.print("Ingrese el Nombre de la Materia:  ");
                nombre=scanf.nextLine();
                x++;
            } 
            Dias swap = new Dias(dia);
            diasMaterias.add(swap);
        }
        
        System.out.print("Ingrese el Numero de Materias por Carpeta: ");
        materiasPorCarpeta = scanf.nextInt();
        System.out.print("Ingrese el Numero Máximo de Carpetas por Dia: ");
        maximoCarpetasPorDia = scanf.nextInt();
        
        
        System.out.println("Cargando las Posibilades...");
        ArrayList<Integer> totalPosibilidades = new ArrayList(); // VECTOR CON NUMEROS DEL 0 AL 'X' CANTIDAD DE MATERIAS PARA ENTREGARLO A LA FUNCION QUE RELLENA LA MATRIZ CON TODAS LAS POSIBILIDADES
        for(i=1;i<=listaMaterias.size();i++){
            totalPosibilidades.add(i);
        }
        
        ArrayList<Integer> vacio = new ArrayList();
        CargarPosi(totalPosibilidades, vacio);
        
        // ArrayList<ArrayList<Integer>> res = permute(totalPosibilidades);
        
        for(i=0;i<posibilidades(totalPosibilidades.size());i++) {
            int carpetas[][] = new int[(listaMaterias.size()/materiasPorCarpeta)+1][materiasPorCarpeta];
            //System.out.println("hor " + (listaMaterias.size()/materiasPorCarpeta)+1 + " ver " + materiasPorCarpeta);
            int hor=0,ver=0;
            for(int x=1;x<=listaMaterias.size(); x++){
                if((x%materiasPorCarpeta)!=0) {
                    carpetas[hor][ver]=res.get(i).get(x-1);
                    ver++;
                } else {
                    //System.out.println("sisiiisisiissisiissisiisisi" + res.get(i).get(x-1));
                    carpetas[hor][ver]=res.get(i).get(x-1);
                    hor++;
                    ver=0;
                }
            }
            //ordena el vector verticalmente y luego horizontalmente
            for(int x=0;x<(listaMaterias.size()/materiasPorCarpeta)+1;x++) {
                for(int y=0;y<materiasPorCarpeta;y++){
                    ////////// CONTINUAR
                }
            }
            
            int cantC[] = new int [5];
            for(int x=0; x<5;x++){
                cantC[x] = carpetasPorDia(carpetas, diasMaterias.get(x));
            }
            int max=cantC[0];
            for(int x=1;x<cantC.length;x++) if(max<cantC[x]) max=cantC[x];
            if(max<=maximoCarpetasPorDia) imprimirCarpetaGanadora(carpetas, cantC);
        }
        
    }
    
    public static int carpetasPorDia (int carpeta[][], Dias dia) {
        ArrayList<Integer> eleccionCarpeta = new ArrayList();
        for(int i=0;i<dia.getMateriasDelDia().size();i++){
            ///COMPRUEBA EL NUMERO DE LA MATERIA
            int numeroMateria=-1;
            for(int x=0;x<listaMaterias.size();x++){
                //System.out.println(materias.get(x).getMateria() + " == " + dia.getMateriasDelDia().get(i) + ". Resultado: "  + materias.get(x).getMateria().equalsIgnoreCase(dia.getMateriasDelDia().get(i)));
                if(listaMaterias.get(x).getMateria().equalsIgnoreCase(dia.getMateriasDelDia().get(i))) numeroMateria=listaMaterias.get(x).getId();
            }
            ///////
            ///Empiza la Busqueda
            for(int x=0;x<(listaMaterias.size()/materiasPorCarpeta)+1;x++){
                for(int y=0;y<materiasPorCarpeta;y++){
                        // System.out.println(carpeta [x][y] + " es " + numeroMateria);
                    if(carpeta[x][y] == numeroMateria) {
                        //System.out.println("Encontre carpeta: " + materias.get(numeroMateria-1).getMateria() + " en el numero " + numeroMateria);
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
                    if(eleccionCarpeta.get(i)==carpetasEncontradas.get(x)) {
                        boolYaEncontrada=1;
                        break;
                    }
                }
                if (boolYaEncontrada==0) carpetasEncontradas.add(eleccionCarpeta.get(i));
            }
            //carpetasEncontradas.forEach(System.out::println);
        return carpetasEncontradas.size() ;
    }
    
    public static void imprimirCarpetaGanadora(int carpeta[][], int CantC[]){
        //IMPRIME LA CARPETA Y LA CANTIDAD MAXIMA DE CARPETAS POR DÍA
        System.out.print("CARPETA: \n");
            for(int y=0;y<(listaMaterias.size()/materiasPorCarpeta)+1;y++){
                for(int x=0; x<materiasPorCarpeta;x++){
                    System.out.print("  ");
                    for(int i=0; i<listaMaterias.size();i++){
                        if(carpeta[y][x]==listaMaterias.get(i).getId()) System.out.print(listaMaterias.get(i).getMateria());
                    }
                }
                System.out.println();
            }
            System.out.println();
    }

    // VIEJO ALGORITMO
/*
   static void permutations(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> nums, int l, int h) {
       if (l == h) {
           ArrayList<Integer> nums1 = new ArrayList<Integer>(nums);

           res.add(nums1);
           return;
       }
       for (int i = l; i <= h; i++) {

           // Swapping
           int left = nums.get(l);
           nums.set(l, nums.get(i));
           nums.set(i, left);

           // Calling permutations for
           // next greater value of l
           permutations(res, nums, l + 1, h);

           // Backtracking
           left = nums.get(l);
           nums.set(l, nums.get(i));
           nums.set(i, left);
       }
   }

   static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
       // Declaring result variable
       ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer> >();
       int x = nums.size() - 1;
       // Calling permutations for the first
       // time by passing l
       // as 0 and h = nums.size()-1
       permutations(res, nums, 0, x);
       return res;
   }
   */
    
    public static void CargarPosi (ArrayList<Integer> totalPosibilidades, ArrayList<Integer> posibilidad) {
        for(int i=0;i<totalPosibilidades.size();i++) { //posibilidades(totalPosibilidades.size())/cant
            if(totalPosibilidades.size() == 1) { // Si queda solo un numero lo agrega al arraylist y lo guarda ese array en el arraylist de los otros arraylist
                posibilidad.add(totalPosibilidades.get(0));
                res.add(posibilidad);
                //return;
            } else { // Aplica la recursion
                // Agrega el numero dentro de otro array para Pasarselo a la Recursion
                ArrayList<Integer> posiSwap = new ArrayList(); 
                    posibilidad.forEach((n) -> posiSwap.add(n));
                    posiSwap.add(totalPosibilidades.get(i));
                    
                // Elimina el numero que se colocó en el Array y le Pasa a la recurción el array sin ese numero
                ArrayList<Integer> swap = new ArrayList(); 
                    totalPosibilidades.forEach((n) -> swap.add(n));
                    swap.remove(i);

                CargarPosi(swap, posiSwap);
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

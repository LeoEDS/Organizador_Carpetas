import java.util.*;


public class ejemplo {
    static int cantMaterias=10; // Comenzando desde 1, NO desde 0

    static int totalPosibilidades[] = new int [cantMaterias];
    static int materiasPorCarpeta=3;

    public static void main (String args[]) {

        for(int i=0;i<cantMaterias;i++){
            totalPosibilidades[i]=i;
        }
        System.out.println("Cargando...");
        helper(totalPosibilidades, 0);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        for(int i=0;i<posibilidades(totalPosibilidades.length);i++) {
            for(int x=0;x<totalPosibilidades.length; x++){
                    if(x%materiasPorCarpeta==0) System.out.println();
                    System.out.print(v[i][x] + " ");
            }
            System.out.println();
        }

    }

    static int v[][] = new int[posibilidades(totalPosibilidades.length)][totalPosibilidades.length];
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



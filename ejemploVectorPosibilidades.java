import java.util.*;


public class ejemplo {

    // int vectorCombinaciones[] = new int[999999999];
    static int totalPosibilidades[] = {0,1,2, 3, 4, 5, 6, 7, 8, 9};

    public static void main (String args[]) {

        System.out.println("Cargando...");
        helper(totalPosibilidades, 0);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        for(int i=0;i<posibilidades(totalPosibilidades.length);i++) {
            for(int x=0;x<totalPosibilidades.length; x++)
                System.out.print(v[i][x] + " ");
            System.out.println();

        }

    }

    static int v[][] = new int[posibilidades(totalPosibilidades.length)][totalPosibilidades.length];
    static int tupla=0;

    public static void helper(int[] array, int pos){  
        if(pos >= array.length - 1){   
            for(int i = 0; i < array.length-1; i++){  
                // System.out.print(array[i] + ", ");  
                v[tupla][i]=array[i];
                // System.out.print("( " + i + " ) " );
                // System.out.println("aca -> [" + tupla + ";" + i + "]");
            }  
            if(array.length > 0)   
                // System.out.print(array[array.length - 1]);  
                // System.out.print("(( " + array.length + " )) " );
                v[tupla][array.length-1]=array[array.length-1];
                // System.out.println(", aca -> [" + tupla + ";" + (array.length - 1) + "]");
            // System.out.println();  
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



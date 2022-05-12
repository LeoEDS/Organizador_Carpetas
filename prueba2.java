import java.util.ArrayList;

public class prueba2 {

    static ArrayList<ArrayList<Integer>> v = new ArrayList();

    public static void main(String args[]) {

        ArrayList<Integer> p = new ArrayList();
        ArrayList<Integer> vacio = new ArrayList();
        for (int i=0; i<3;i++) {
            p.add(i+1);
        }

        CargarPosiVert(p,vacio);
        v.forEach(System.out::println);
    }

    public static void CargarPosiVert (ArrayList<Integer> totalPosibilidades, ArrayList posibili) {


        for(int i=0;i<posibilidades(totalPosibilidades.size());i++) {
            if(totalPosibilidades.size() == 1) {
                posibili.add(totalPosibilidades.get(0));
                v.add(posibili);
                return;
            }
            // System.out.println("iis");
            ArrayList<Integer> swap = totalPosibilidades;
            ArrayList posiSwap = posibili;
            swap.remove(i);
            posiSwap.add(totalPosibilidades.get(i));

            CargarPosiHor(swap, posiSwap);
        }

    }

    public static void CargarPosiHor (ArrayList<Integer> totalPosibilidades, ArrayList posibili) {
        for(int i=0;i<totalPosibilidades.size();i++){
            ArrayList<Integer> swap = totalPosibilidades;
            ArrayList posiSwap = posibili;
            posiSwap.add(totalPosibilidades.get(i));
            swap.remove(i);
            CargarPosiVert(swap,posibili);
        }
    }

    public static int posibilidades(int val){
        if (val>1)
            return val*posibilidades(val-1);
        else
            return val;
    }

}

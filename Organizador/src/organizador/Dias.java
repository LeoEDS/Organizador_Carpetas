package organizador;

import java.util.ArrayList;

public class Dias {
    private ArrayList<String> materiasDelDia;

    public Dias(ArrayList<String> materiasDelDia) {
        this.materiasDelDia = materiasDelDia;
    }

    public ArrayList<String> getMateriasDelDia() {
        return materiasDelDia;
    }

    public void setMateriasDelDia(ArrayList<String> materiasDelDia) {
        this.materiasDelDia = materiasDelDia;
    }
    
}

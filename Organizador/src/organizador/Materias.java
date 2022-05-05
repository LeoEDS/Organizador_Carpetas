package organizador;

import java.util.ArrayList;

public class Materias {
    private int id;
    private ArrayList<String> listaMaterias;

    public Materias(int id, ArrayList<String> listaMaterias) {
        this.id = id;
        this.listaMaterias = listaMaterias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(ArrayList<String> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }
    
}

package organizador;

import java.util.ArrayList;

public class Materias {
    private int id;
    String listaMaterias;

    public Materias(int id,String listaMaterias) {
        this.id = id;
        this.listaMaterias = listaMaterias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(String listaMaterias) {
        this.listaMaterias = listaMaterias;
    }
    
}

package organizador;

import java.util.ArrayList;

public class Dias {
    private ArrayList<String> lunes;
    private ArrayList<String> martes;
    private ArrayList<String> miercoles;
    private ArrayList<String> jueves;
    private ArrayList<String> viernes;

    public Dias(ArrayList<String> lunes, ArrayList<String> martes, ArrayList<String> miercoles, ArrayList<String> jueves, ArrayList<String> viernes) {
        this.lunes = lunes;
        this.martes = martes;
        this.miercoles = miercoles;
        this.jueves = jueves;
        this.viernes = viernes;
    }

    public ArrayList<String> getlunes() {
        return lunes;
    }

    public void setlunes(ArrayList<String> lunes) {
        this.lunes = lunes;
    }

    public ArrayList<String> getmartes() {
        return martes;
    }

    public void setmartes(ArrayList<String> martes) {
        this.martes = martes;
    }

    public ArrayList<String> getmiercoles() {
        return miercoles;
    }

    public void setmiercoles(ArrayList<String> miercoles) {
        this.miercoles = miercoles;
    }

    public ArrayList<String> getjueves() {
        return jueves;
    }

    public void setjueves(ArrayList<String> jueves) {
        this.jueves = jueves;
    }

    public ArrayList<String> getviernes() {
        return viernes;
    }

    public void setviernes(ArrayList<String> viernes) {
        this.viernes = viernes;
    }
    
}

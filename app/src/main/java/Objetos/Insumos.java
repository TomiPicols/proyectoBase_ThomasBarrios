package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Insumos {

    private int id;
    private String[] insumos ={"Mancuernas","Barras","Corredoras","Puching bag"};
    private int[] precios={35000,12000,15000,45000};
    private int stock;

    public Insumos(){
    }

    public Insumos(int id, String[] insumos, int[] precios, int stock) {
        this.id = id;
        this.insumos = insumos;
        this.precios = precios;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getInsumos() {
        return insumos;
    }

    public void setInsumos(String[] insumos) {
        this.insumos = insumos;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Insumos)) return false;
        Insumos insumos1 = (Insumos) o;
        return getId() == insumos1.getId() && getStock() == insumos1.getStock() && Arrays.equals(getInsumos(), insumos1.getInsumos()) && Arrays.equals(getPrecios(), insumos1.getPrecios());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getStock());
        result = 31 * result + Arrays.hashCode(getInsumos());
        result = 31 * result + Arrays.hashCode(getPrecios());
        return result;
    }

    @Override
    public String toString() {
        return "Insumos{" +
                "id=" + id +
                ", insumos=" + Arrays.toString(insumos) +
                ", precios=" + Arrays.toString(precios) +
                ", stock=" + stock +
                '}';
    }

    public int anadirAdicional(int valor, int adicional){
        return valor + adicional;
    }
}

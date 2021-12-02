package Objetos;

import java.util.Arrays;
import java.util.Objects;

public class Insumos {
    private String [] insumos= {"Maquinas", "Tijeras","Toallas","Talco","Navajas"};
    private int [] precios = {80000,25000,3000,2500,5000};
    private int stock;

    public Insumos() {
        this.insumos = insumos;
        this.precios = precios;
        this.stock = stock;
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
        if (o == null || getClass() != o.getClass()) return false;
        Insumos insumos1 = (Insumos) o;
        return stock == insumos1.stock && Arrays.equals(insumos, insumos1.insumos) && Arrays.equals(precios, insumos1.precios);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(stock);
        result = 31 * result + Arrays.hashCode(insumos);
        result = 31 * result + Arrays.hashCode(precios);
        return result;
    }

    @Override
    public String toString() {
        return "Insumos{" +
                "insumos=" + Arrays.toString(insumos) +
                ", precios=" + Arrays.toString(precios) +
                ", stock=" + stock +
                '}';
    }
    //meotodo para añadir un valor adicional
    public int anadirAdicional(int valor, int adicional)
    {
        return valor + adicional;
    }
}

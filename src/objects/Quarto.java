package objects;

import enums.QuartoTipo;

import java.util.ArrayList;
import java.util.List;

public class Quarto {
    private int numero;
    private boolean ocupado;
    private QuartoTipo tipo;

    public Quarto(int numero, QuartoTipo tipo){
        this.numero = numero;
        this.tipo = tipo;
        setOcupado(true);
    }

    public boolean isOcupado(){
        return true;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public QuartoTipo getTipo() {
        return tipo;
    }
}

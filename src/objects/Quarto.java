package objects;

import enums.QuartoTipo;
import enums.StatusQuarto;

import java.util.ArrayList;
import java.util.List;

public class Quarto {
    private int numero;
    private QuartoTipo tipo;
    private StatusQuarto status;

    public Quarto(int numero, QuartoTipo tipo){
        this.numero = numero;
        this.tipo = tipo;
        this.status = StatusQuarto.DISPONIVEL;
    }

    public int getNumero() {
        return numero;
    }
    public QuartoTipo getTipo() {
        return tipo;
    }
    public StatusQuarto getStatus() {
        return status;
    }

    public void setStatus(StatusQuarto status) {
        this.status = status;
    }
}

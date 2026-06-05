package objects;

import enums.QuartoTipo;

import java.util.ArrayList;
import java.util.List;

public class Quarto {
    private int numero;
    private boolean ocupado;
    private QuartoTipo tipo;

    private static List<Quarto> quartos = new ArrayList<>();

    public Quarto(int numero, QuartoTipo tipo){
        this.numero = numero;
        this.tipo = tipo;
        setOcupado(false);
    }

    public boolean isOcupado(){
        return ocupado;
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

    public static void cadastrarQuarto(int numero, QuartoTipo tipo) {
        Quarto quarto = new Quarto(numero, tipo);
        quartos.add(quarto);
    }
    public static void listarQuartos() {
        for (Quarto q : quartos) {
            System.out.println(
                    "Número: " + q.getNumero()
                            + "Tipo: " + q.getTipo()
                            + "Ocupado: " + q.isOcupado()
            );
        }
    }
    public static void listarQuartosLivres() {
        for (Quarto q : quartos) {
            if (!q.isOcupado()) {
                System.out.println(
                        "Número: " + q.getNumero()
                                + "Tipo: " + q.getTipo()
                );
            }
        }
    }
    public static void listarQuartosOcupados() {
        for (Quarto q : quartos) {
            if (q.isOcupado()) {
                System.out.println(
                        "Número: " + q.getNumero()
                                + "Tipo: " + q.getTipo()
                );
            }
        }
    }
    public static void alterarStatusQuarto(int numero, boolean ocupado) {
        for (Quarto q : quartos) {
            if (q.getNumero() == numero) {
                q.setOcupado(ocupado);
                return;
            }
        }
    }
    public static List<Quarto> getQuartos() {
        return quartos;
    }

}

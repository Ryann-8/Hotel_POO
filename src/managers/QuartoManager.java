package managers;

import enums.QuartoTipo;
import objects.Quarto;

import java.util.ArrayList;
import java.util.List;

public class QuartoManager {

    public static List<Quarto> quartos = new ArrayList<>();

    public static void adicionarQuarto(Quarto quarto){
        quartos.add(quarto);
    }

    public static void cadastrarQuarto(int numero, QuartoTipo tipo) {
        Quarto quarto = new Quarto(numero, tipo);
        quartos.add(quarto);
    }

    public static List<Quarto> listarQuartos() {
        return quartos;
    }

    public static List<Quarto> listarQuartosLivres() {
        return quartos.stream()
                .filter(q -> !q.isOcupado())
                .toList();
    }

    public static List<Quarto> listarQuartosOcupados() {
        return quartos.stream()
                .filter(Quarto::isOcupado)
                .toList();
    }

    public static void alterarStatusQuarto(int numero, boolean ocupado) {
        Quarto quarto = quartos.stream()
                .filter(q -> q.getNumero() == numero)
                .findFirst()
                .orElse(null);

        if (quarto != null) {
            quarto.setOcupado(ocupado);
        }
    }
}
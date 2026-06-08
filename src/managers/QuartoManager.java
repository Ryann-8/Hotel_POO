package managers;

import enums.QuartoTipo;
import objects.Quarto;

import java.util.ArrayList;
import java.util.List;

public class QuartoManager {
    public static List<Quarto> quartos = new ArrayList<>();

    static {
        quartos.add(new Quarto(101, QuartoTipo.BASICO));
        quartos.add(new Quarto(102, QuartoTipo.BASICO));
        quartos.add(new Quarto(201, QuartoTipo.DELUXE));
        quartos.add(new Quarto(202, QuartoTipo.DELUXE));
        quartos.add(new Quarto(301, QuartoTipo.MASTER));
    }

}

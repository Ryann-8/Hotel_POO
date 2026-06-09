package managers;
import enums.StatusReserva;
import objects.Reserva;
import objects.Hospede;
import objects.Quarto;
import java.util.ArrayList;
import java.util.List;

public class ReservaManager {
    public static List<Reserva> reservas = new ArrayList<>();

    public static void criarReserva(Reserva reserva){
        for(Reserva r: reservas){
            if (r.getQuarto() == reserva.getQuarto()){
                System.out.println("Quarto ocupado, não foi possível completar a reserva");
                return;
            }
        }
        reservas.add(reserva);
        System.out.println("Reserva criada com sucesso!!!!");
    }

}
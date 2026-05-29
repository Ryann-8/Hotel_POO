package managers;
import enums.StatusReserva;
import objects.Reserva;
import objects.Hospede;
import objects.Quarto;
import java.util.ArrayList;
import java.util.List;

public class ReservaManager {
    public static List<Reserva> reservas = new ArrayList<>();



    //Serviços relacionados a RESERVA, somente reservassss!
    public static Reserva getReservaById(int id) {
        return reservas.stream().filter(
                        r -> r.getId() == id)
                .findFirst().orElse(null);
    }
    public static void criarReserva(Reserva reserva){
        reservas.add(reserva);
    }
    public static List<Reserva> listarReservasAtivas() {
        return reservas.stream().filter(
                        r -> r.getStatus() == StatusReserva.HOSPEDADO || r.getStatus() == StatusReserva.RESERVADO)
                .toList();
    }
    public static List<Reserva> historicoReservas() {
        return reservas.stream().filter(r -> r.getStatus() == StatusReserva.FINALIZADO).toList();
    }
}

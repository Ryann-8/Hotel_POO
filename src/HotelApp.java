import enums.StatusReserva;
import objects.Hospede;
import objects.Quarto;
import objects.Reserva;

import java.util.ArrayList;
import java.util.List;

public class HotelApp{
    public static List<Reserva> reservas = new ArrayList<>();

    static void main() {
        Hospede hospede = new Hospede("Marcos", "169");
        Hospede hospede2 = new Hospede("Paulo", "222");
        Quarto quarto = new Quarto(44);
        Quarto quarto2 = new Quarto(33);

        Reserva reserva = new Reserva(hospede, quarto);
        Reserva reserva2 = new Reserva(hospede2, quarto2);

        criarReserva(reserva);
        criarReserva(reserva2);

        List<Reserva> reservasAtivas = listarReservasAtivas();
        for (Reserva reservaAtiva : reservasAtivas) {
            System.out.println(
                    "Hospede: " + reservaAtiva.getHospede().getNome() + "\n" +
                            "Id da reserva: " + reservaAtiva.getId()
            );
        }

        Reserva reservaById = getReservaById(1);
        System.out.println(reservaById.getStatus());

        reservaById.fazerCheckIn();
        System.out.println(reservaById.getStatus());

        reservaById.fazerCheckOut();
        System.out.println(reservaById.getStatus());
    }

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

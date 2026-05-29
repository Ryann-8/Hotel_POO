import enums.StatusReserva;
import objects.Hospede;
import objects.Quarto;
import objects.Reserva;
import managers.ReservaManager;
import java.util.ArrayList;
import java.util.List;

public class HotelApp{

    static void main() {
        Hospede hospede = new Hospede("Marcos", "169");
        Hospede hospede2 = new Hospede("Paulo", "222");
        Quarto quarto = new Quarto(44);
        Quarto quarto2 = new Quarto(33);

        Reserva reserva = new Reserva(hospede, quarto);
        Reserva reserva2 = new Reserva(hospede2, quarto2);

        ReservaManager.criarReserva(reserva);
        ReservaManager.criarReserva(reserva2);

        List<Reserva> reservasAtivas = ReservaManager.listarReservasAtivas();
        for (Reserva reservaAtiva : reservasAtivas) {
            System.out.println(
                    "Hospede: " + reservaAtiva.getHospede().getNome() + "\n" +
                            "Id da reserva: " + reservaAtiva.getId()
            );
        }

        Reserva reservaById = ReservaManager.getReservaById(1);
        System.out.println(reservaById.getStatus());

        reservaById.fazerCheckIn();
        System.out.println(reservaById.getStatus());

        reservaById.fazerCheckOut();
        System.out.println(reservaById.getStatus());
    }

}

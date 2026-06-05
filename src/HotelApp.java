import enums.QuartoTipo;
import objects.Hospede;
import objects.Quarto;
import objects.Reserva;
import managers.ReservaManager;
import java.util.List;

public class HotelApp{

    static void main() {
        Hospede hospede = new Hospede("Marcos", "169");
        Hospede hospede2 = new Hospede("Paulo", "222");
        Hospede hospede3 = new Hospede("Ryan", "123");

        Quarto quarto = new Quarto(44, QuartoTipo.BASICO);
        Quarto quarto2 = new Quarto(33, QuartoTipo.DELUXE);
        Quarto quarto3 = new Quarto(55, QuartoTipo.MASTER);

        Reserva reserva = new Reserva(hospede, quarto);
        Reserva reserva2 = new Reserva(hospede2, quarto2);
        Reserva reserva3 = new Reserva(hospede3, quarto3);

        ReservaManager.criarReserva(reserva);
        ReservaManager.criarReserva(reserva2);
        ReservaManager.criarReserva(reserva3);

        List<Reserva> reservasAtivas = ReservaManager.listarReservasAtivas();

        for (Reserva reservaAtiva : reservasAtivas) {
            System.out.println("RESERVA ID: " + reservaAtiva.getId());
            System.out.println("    Hospede: " + reservaAtiva.getHospede().getNome());
            System.out.println("    Quarto: " + reservaAtiva.getQuarto().getNumero() + " - " + reservaAtiva.getQuarto().getTipo().toString());
            System.out.println("    Status: " + reservaAtiva.getStatus().toString());
            System.out.println(" ");
        }

        Reserva reservaById = ReservaManager.getReservaById(1);
        System.out.println(reservaById.getStatus());

        reservaById.fazerCheckIn();
        System.out.println(reservaById.getStatus());

        reservaById.fazerCheckOut();
        System.out.println(reservaById.getStatus());
    }

}

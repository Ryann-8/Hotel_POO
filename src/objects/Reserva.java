package objects;

import enums.StatusReserva;

public class Reserva {
    private static int countId = 0;

    private int id;
    private Hospede hospede;
    private Quarto quarto;
    private StatusReserva status;

    public Reserva(Hospede hospede, Quarto quarto) {
        this.id = countId++;
        this.hospede = hospede;
        this.quarto = quarto;
        this.status = StatusReserva.RESERVADO;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public void setStatus(StatusReserva status) {
        this.status = status;
    }

    public void fazerCheckIn() {
        setStatus(StatusReserva.HOSPEDADO);
        quarto.setOcupado(true);
    }

    public void fazerCheckOut() {
        setStatus(StatusReserva.FINALIZADO);
        quarto.setOcupado(false);
    }
}

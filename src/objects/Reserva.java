package objects;

public class Reserva {
    private Hospede hospede;
    private Quarto quarto;
    private boolean ativa;

    public Reserva(Hospede hospede, Quarto quarto) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.ativa = true;
    }

    public void finalizarReserva(){
        ativa = false;
    }

    public boolean isAtiva(){
        return ativa;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

}

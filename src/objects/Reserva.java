package objects;



public class Reserva {
    private static int countId = 0;

    private int id;
    private Hospede hospede;
    private Quarto quarto;


    public Reserva(Hospede hospede, Quarto quarto) {
        this.id = countId++;
        this.hospede = hospede;
        this.quarto = quarto;

    }

    public Hospede getHospede() {
        return hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }



    public int getId() {
        return id;
    }




}

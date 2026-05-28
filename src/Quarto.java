public class Quarto {
    private int numero;
    private boolean ocupado;

    public Quarto(int numero){
        this.numero = numero;
    }

    public boolean isOcupado(){
        return true;
    }

    public void ocupar(){
        ocupado = true;
    }

    public void liberar(){
        ocupado = false;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}

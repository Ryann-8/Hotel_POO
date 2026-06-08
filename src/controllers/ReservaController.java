package controllers;

import enums.StatusQuarto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import managers.ReservaManager;
import objects.Hospede;
import objects.Quarto;
import objects.Reserva;

public class ReservaController {

    @FXML
    private Label labelQuarto;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoCpf;

    private Quarto quarto;

    private PrincipalController principalController;

    public void receberDados(Quarto quarto, PrincipalController principalController) {
        this.quarto = quarto;
        this.principalController = principalController;

        labelQuarto.setText(quarto.getNumero() + " - " + quarto.getTipo());
    }

    @FXML
    private void reservar() {
        String nome = campoNome.getText();
        String cpf = campoCpf.getText();

        if (nome.isEmpty() || cpf.isEmpty()) {
            mostrarAviso("Preencha nome e CPF.");
            return;
        }

        Hospede hospede = new Hospede(nome, cpf);
        Reserva reserva = new Reserva(hospede, quarto);

        ReservaManager.criarReserva(reserva);

        quarto.setStatus(StatusQuarto.RESERVADO);

        principalController.atualizarTabela();

        fecharJanela();
    }

    @FXML
    private void cancelar() {
        fecharJanela();
    }

    private void fecharJanela() {
        Stage stage = (Stage) campoNome.getScene().getWindow();
        stage.close();
    }

    private void mostrarAviso(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hotel Massa");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
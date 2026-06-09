package controllers;

import enums.StatusQuarto;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import managers.QuartoManager;
import objects.Quarto;

public class PrincipalController {

    @FXML
    private TableView<Quarto> tabelaQuartos;
    @FXML
    private TableColumn<Quarto, Integer> colunaNumero;
    @FXML
    private TableColumn<Quarto, String> colunaTipo;
    @FXML
    private TableColumn<Quarto, String> colunaStatus;
    @FXML
    private Button btnCriarReserva;
    @FXML
    private Button btnCheckIn;
    @FXML
    private Button btnCheckOut;
    private Quarto quartoSelecionado;
    @FXML
    public void initialize() {
        colunaNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colunaStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        tabelaQuartos.setItems(FXCollections.observableArrayList(QuartoManager.quartos));

        esconderBotoes();

        tabelaQuartos.getSelectionModel().selectedItemProperty().addListener(
                (obs, antigo, novo) -> {
                    quartoSelecionado = novo;
                    atualizarBotoes();
                }
        );
    }

    private void atualizarBotoes() {
        esconderBotoes();

        if (quartoSelecionado == null) return;

        switch (quartoSelecionado.getStatus()) {
            case DISPONIVEL:
                btnCriarReserva.setVisible(true);
                break;
            case RESERVADO:
                btnCheckIn.setVisible(true);
                break;
            case HOSPEDADO:
                btnCheckOut.setVisible(true);
                break;
        }
    }

    private void esconderBotoes() {
        btnCriarReserva.setVisible(false);
        btnCheckIn.setVisible(false);
        btnCheckOut.setVisible(false);
    }

    @FXML
    private void criarReserva() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/screens/reserva.fxml"));

            Scene scene = new Scene(loader.load());

            ReservaController controller = loader.getController();
            controller.receberDados(quartoSelecionado, this);

            Stage stage = new Stage();
            stage.setTitle("Criar Reserva");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage() );
        }
    }

    @FXML
    private void fazerCheckIn() {
        quartoSelecionado.setStatus(StatusQuarto.HOSPEDADO);
        tabelaQuartos.refresh();
        atualizarBotoes();
        mostrarAviso("Feito checkin no quarto numero " + quartoSelecionado.getNumero());
    }

    @FXML
    private void fazerCheckOut() {
        quartoSelecionado.setStatus(StatusQuarto.DISPONIVEL);
        tabelaQuartos.refresh();
        atualizarBotoes();
        mostrarAviso("Feito checkout no quarto numero " + quartoSelecionado.getNumero());
    }

    private void mostrarAviso(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hotel Massa");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    public void atualizarTabela() {
        tabelaQuartos.refresh();
        atualizarBotoes();
    }
}
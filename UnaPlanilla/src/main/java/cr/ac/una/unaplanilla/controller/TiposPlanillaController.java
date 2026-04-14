/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.unaplanilla.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXListView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author andys
 */
public class TiposPlanillaController  extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private MFXTextField txfId;
    @FXML
    private MFXButton btnNuevo;
    @FXML
    private MFXButton btnBuscar;
    @FXML
    private MFXButton btnEliminar;
    @FXML
    private MFXButton btnGuardar;
    @FXML
    private MFXButton btnEliminar1;
    @FXML
    private MFXButton btnNuevo1;
    @FXML
    private MFXButton btnBuscar1;
    @FXML
    private MFXButton btnGuardar1;
    @FXML
    private MFXTextField txfCodigo;
    @FXML
    private MFXTextField txfDescripcion;
    @FXML
    private MFXTextField txfPlanillasPM;
    @FXML
    private MFXCheckbox btnActivo;
    @FXML
    private MFXListView<?> listViewEmplados;
    @FXML
    private MFXTextField txfIdEmpleado;
    @FXML
    private MFXTextField txfNombre2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void initialize() {
                
    }

    @FXML
    private void onActionTxfId(ActionEvent event) {
    }

    @FXML
    private void onActionBtnNuevo(ActionEvent event) {
    }

    @FXML
    private void OnActionBtnBuscar(ActionEvent event) {
    }

    @FXML
    private void onActionBtnEliminar(ActionEvent event) {
    }

    @FXML
    private void onActionBtnGuardar(ActionEvent event) {
    }

    @FXML
    private void onActionTxfCodigo(ActionEvent event) {
    }

    @FXML
    private void onActionTxfDescripcion(ActionEvent event) {
    }

    @FXML
    private void onActionTxfPlanillasPM(ActionEvent event) {
    }

    @FXML
    private void onActionActivo(ActionEvent event) {
    }

    @FXML
    private void onActionListViewEmpleados(MouseEvent event) {
    }

    @FXML
    private void onActionTxfIdEmpleado(ActionEvent event) {
    }

    @FXML
    private void onActionTxfNombre2(ActionEvent event) {
    }
    
}

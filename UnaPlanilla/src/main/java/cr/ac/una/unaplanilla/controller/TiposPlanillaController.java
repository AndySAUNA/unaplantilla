/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.unaplanilla.controller;

import cr.ac.una.unaplanilla.model.EmpleadoDto;
import cr.ac.una.unaplanilla.util.Formato;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXListView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
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
    private MFXButton btnEliminar2;
    @FXML
    private MFXButton btnNuevo2;
    @FXML
    private MFXButton btnBuscar2;
    @FXML
    private MFXButton btnGuardar2;
    @FXML
    private Accordion accorAccordion;
    @FXML
    private TitledPane panelTiposPlanilla;
    @FXML
    private TitledPane panelInclusionEmpleados;
    
    private EmpleadoDto empleado;
    private ObjectProperty<EmpleadoDto> empleadoProperty = new SimpleObjectProperty<>();
    private List<Node> requeridos = new ArrayList();
    @FXML
    private MFXTextField txfNombre;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         accorAccordion.setExpandedPane(panelTiposPlanilla); // para inicializar el acordeon abierto
         txfId.delegateSetTextFormatter(Formato.getInstance().integerFormat());
         txfCodigo.delegateSetTextFormatter(Formato.getInstance().integerFormat());
         txfPlanillasPM.delegateSetTextFormatter(Formato.getInstance().integerFormat());
         txfIdEmpleado.delegateSetTextFormatter(Formato.getInstance().integerFormat());
         txfNombre.delegateSetTextFormatter(Formato.getInstance().letrasFormat(15));
         txfDescripcion.delegateSetTextFormatter(Formato.getInstance().letrasFormat(15));
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
    private void onActionListViewEmpleados(MouseEvent event) {
    }

    @FXML
    private void onActionTxfIdEmpleado(ActionEvent event) {
    }


    @FXML
    private void onActionBtnEliminar2(ActionEvent event) {
    }

    @FXML
    private void onActionBtnNuevo2(ActionEvent event) {
    }

    @FXML
    private void OnActionBtnBuscar2(ActionEvent event) {
    }

    @FXML
    private void onActionBtnGuardar2(ActionEvent event) {
    }

    @FXML
    private void onActionBtnActivo(ActionEvent event) {
        
    }

    @FXML
    private void onActionTxfNombre2(ActionEvent event) {
    }
    
}

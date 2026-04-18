/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.unaplanilla.controller;

import cr.ac.una.unaplanilla.model.EmpleadoDto;
import cr.ac.una.unaplanilla.util.Formato;
import cr.ac.una.unaplanilla.util.Mensaje;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXListView;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTableColumn;
import io.github.palexdev.materialfx.controls.MFXTableView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.cell.MFXTableRowCell;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.KeyCode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * FXML Controller class
 *
 * @author andys
 */
public class TiposPlanillaController  extends Controller implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private MFXButton btnNuevo;
    @FXML
    private MFXButton btnBuscar;
    @FXML
    private MFXButton btnEliminar;
    @FXML
    private MFXButton btnGuardar;
    @FXML
    private MFXTextField txfId; // bindeado
    @FXML
    private MFXTextField txfCodigo;// falta bindear
    @FXML
    private MFXTextField txfDescripcion;// falta bindear
    @FXML
    private MFXTextField txfPlanillasPM;// falta bindear
    @FXML
    private MFXCheckbox chkActivo;// bindeado
    @FXML
    private MFXTextField txfIdEmpleado;// bindeado
    @FXML
    private MFXTextField txfNombre; // bindeado
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
    @FXML
    private MFXTableView<EmpleadoDto> tableVIewEmpleado;
    private final ObservableList<EmpleadoDto> tablillaEmpleados = FXCollections.observableArrayList();
    
    
    private EmpleadoDto empleado;
    private ObjectProperty<EmpleadoDto> empleadoProperty = new SimpleObjectProperty<>();
    private List<Node> requeridos = new ArrayList();
    
    
    
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
         txfNombre.delegateSetTextFormatter(Formato.getInstance().letrasFormat(30));
         txfDescripcion.delegateSetTextFormatter(Formato.getInstance().maxLengthFormat(15));
         
         setupListViewEmplados();
         
         empleado = new EmpleadoDto();
         bindEmpleado();
         cargarValoresDefecto();
        // TODO
    }    

    @Override
    public void initialize() {
    }
    
    public void setupListViewEmplados(){
        //
        MFXTableColumn<EmpleadoDto> columnaId = new MFXTableColumn<>("Id",true, Comparator.comparing(EmpleadoDto::getCedula));
        MFXTableColumn<EmpleadoDto> columnaNombre = new MFXTableColumn<>("Nombre",true, Comparator.comparing(EmpleadoDto::getNombre));
        MFXTableColumn<EmpleadoDto> columnaEliminar = new MFXTableColumn<>("Eliminar",true, Comparator.comparing(EmpleadoDto::getId));
        //
        columnaId.setRowCellFactory(c -> new MFXTableRowCell<>(EmpleadoDto::getCedula));
        columnaNombre.setRowCellFactory(c -> new MFXTableRowCell<>(EmpleadoDto::getNombre));
        columnaEliminar.setRowCellFactory(c -> new MFXTableRowCell<>(EmpleadoDto::getNombre));
        //
        tableVIewEmpleado.getTableColumns().setAll(columnaId, columnaNombre, columnaEliminar);
        tableVIewEmpleado.setItems(tablillaEmpleados);
    }
    
    private void bindEmpleado(){
        try{
            //listener con valor observable (objeto como tal), valor viejo y valor nuevo
            empleadoProperty.addListener((ov, oldVal, newVal) -> {
                if(oldVal != null){
                    txfId.textProperty().unbind();
                    txfNombre.textProperty().unbindBidirectional(oldVal.getNombreProperty());
                    txfDescripcion.textProperty().unbindBidirectional(oldVal.getNombreProperty());
                    chkActivo.selectedProperty().unbindBidirectional(oldVal.getAdministradorProperty());
                    txfIdEmpleado.textProperty().unbindBidirectional(oldVal.getIdProperty());
                    //falta el bindeo de descripcion, planillsaPM y codigo
                }
                if(newVal != null){
                    if(newVal.getIdProperty().get() != null && !newVal.getIdProperty().get().isBlank()){ //bindeo unidireccional
                        txfId.textProperty().bind(newVal.getIdProperty());
                    }
                    txfNombre.textProperty().bindBidirectional(newVal.getNombreProperty());
                    txfDescripcion.textProperty().bindBidirectional(newVal.getNombreProperty());
                    chkActivo.selectedProperty().bindBidirectional(newVal.getAdministradorProperty());
                    txfIdEmpleado.textProperty().bindBidirectional(newVal.getIdProperty());
                }
            });
        }catch (Exception e){
            new Mensaje().showModal(Alert.AlertType.ERROR, "Error al realizar el bindeo",
            getStage(), "Ocurrio un error al realizar el bindeo.");
        }
    }
    private void cargarValoresDefecto(){
        validarActivo();
        txfId.clear();
        txfId.requestFocus();
    }
    private void validarActivo(){
        if(chkActivo.isSelected()){
            this.requeridos.addAll(Arrays.asList(txfPlanillasPM));
            txfPlanillasPM.setDisable(false);
        }else{
            this.requeridos.removeAll(Arrays.asList(txfPlanillasPM));
            txfPlanillasPM.clear();
            txfPlanillasPM.setDisable(true);
        }
    }
    
    private void indicarRequeridos(){
        this.requeridos.clear();
        this.requeridos.addAll(Arrays.asList(txfId,txfCodigo,txfDescripcion,txfPlanillasPM));//descripcion y planillasPM no han sido bindeadas
    }
    
    public String validarRequeridos() {
        Boolean validos = true;
        String invalidos = "";
        for (Node node : requeridos) {
            if (node instanceof MFXTextField && (((MFXTextField) node).getText() == null || ((MFXTextField) node).getText().isBlank())) {
                if (validos) {
                    invalidos += ((MFXTextField) node).getFloatingText();
                } else {
                    invalidos += "," + ((MFXTextField) node).getFloatingText();
                }
                validos = false;
            } else if (node instanceof MFXPasswordField && (((MFXPasswordField) node).getText() == null || ((MFXPasswordField) node).getText().isBlank())) {
                if (validos) {
                    invalidos += ((MFXPasswordField) node).getFloatingText();
                } else {
                    invalidos += "," + ((MFXPasswordField) node).getFloatingText();
                }
                validos = false;
            } else if (node instanceof MFXDatePicker && ((MFXDatePicker) node).getValue() == null) {
                if (validos) {
                    invalidos += ((MFXDatePicker) node).getFloatingText();
                } else {
                    invalidos += "," + ((MFXDatePicker) node).getFloatingText();
                }
                validos = false;
            } else if (node instanceof MFXComboBox && ((MFXComboBox) node).getSelectionModel().getSelectedIndex() < 0) {
                if (validos) {
                    invalidos += ((MFXComboBox) node).getFloatingText();
                } else {
                    invalidos += "," + ((MFXComboBox) node).getFloatingText();
                }
                validos = false;
            }
        }
        if (validos) {
            return "";
        } else {
            return "Campos requeridos o con problemas de formato [" + invalidos + "].";
        }
    }
    
    @FXML
    private void onActionTxfId(ActionEvent event) {
        
    }

    @FXML
    private void onActionBtnNuevo(ActionEvent event) {
        if(new Mensaje().showConfirmation("Limpiar Empleado", getStage(),
        "Esta seguro que desea limpiar el registro?")){
            cargarValoresDefecto();
        }
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
    private void onActionTxfNombre2(ActionEvent event) {
    }

    @FXML
    private void onActionChkActivo(ActionEvent event) {
        validarActivo();
    }
    private void cargarEmpleado(Long id){
        try{
            
        }catch(Exception ex){
            Logger.getLogger(EmpleadosController.class.getName()).log(Level.SEVERE, "Error consultando el empleado",ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Consultar Empleado;", getStage(), "Ocurrio un error consultando el empleado.");
        }
    }

    @FXML
    private void onKeyPressedtxtId(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER && !txfId.getText().isBlank()){
            cargarEmpleado(Long.valueOf(txfId.getText()));
        }
    }

    @FXML
    private void onKeyPressedtxtId2(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER && !txfId.getText().isBlank()){
            cargarEmpleado(Long.valueOf(txfId.getText()));
        }
    }
    
}

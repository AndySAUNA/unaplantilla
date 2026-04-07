/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cr.ac.una.unaplanilla.controller;

import cr.ac.una.unaplanilla.model.EmpleadoDto;
import cr.ac.una.unaplanilla.util.BindingUtils;
import cr.ac.una.unaplanilla.util.Formato;
import cr.ac.una.unaplanilla.util.Mensaje;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXRadioButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author andys
 */
public class EmpleadosController extends Controller implements Initializable {

    @FXML
    private MFXRadioButton rbdMasculino;
    @FXML
    private MFXRadioButton rbdFemenino;
    @FXML
    private MFXTextField txtNombre;
    @FXML
    private MFXTextField txtId;
    @FXML
    private MFXTextField txtPApellido;
    @FXML
    private MFXTextField txtSApellido;
    @FXML
    private MFXTextField txtCedula;
    @FXML
    private MFXTextField txtCorreo;
    @FXML
    private MFXTextField txtUsuario;
    @FXML
    private MFXPasswordField txtClave;
    @FXML
    private MFXCheckbox chkAdministrador;
    @FXML
    private MFXCheckbox chkActivo;
    @FXML
    private ToggleGroup tggGenero;
    @FXML
    private MFXDatePicker dtpFIngreso;
    @FXML
    private MFXDatePicker dtpFSalida;
    
    private EmpleadoDto empleado;
    private ObjectProperty<EmpleadoDto> empleadoProperty = 
            new SimpleObjectProperty<>();
    private List<Node> requeridos = new ArrayList();
    @FXML
    private MFXButton btnNuevo;
    @FXML
    private MFXButton btnBuscar;
    @FXML
    private MFXButton btnEliminar;
    @FXML
    private MFXButton btnGuardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rbdFemenino.setUserData("F");
        rbdMasculino.setUserData("M");
        txtId.delegateSetTextFormatter(Formato.getInstance().integerFormat());
        txtNombre.delegateSetTextFormatter(Formato.getInstance().letrasFormat(30));
        txtPApellido.delegateSetTextFormatter(Formato.getInstance().letrasFormat(15));
        txtSApellido.delegateSetTextFormatter(Formato.getInstance().letrasFormat(15));
        txtCedula.delegateSetTextFormatter(Formato.getInstance().letrasFormat(40));
        txtCorreo.delegateSetTextFormatter(Formato.getInstance().letrasFormat(80));
        txtClave.delegateSetTextFormatter(Formato.getInstance().letrasFormat(8));
        txtUsuario.delegateSetTextFormatter(Formato.getInstance().letrasFormat(15));
        this.empleado = new EmpleadoDto();
        bindEmpleado();
        cargarValoresDefecto();
        indicarRequeridos();
            
    }    

    @Override
    public void initialize() {

    }
    
    private void bindEmpleado(){
    try{
        empleadoProperty.addListener((ov, oldVal, newVal) -> {
            if(oldVal != null){
                txtId.textProperty().unbind();
                txtNombre.textProperty().unbindBidirectional(oldVal.getNombreProperty());
                txtPApellido.textProperty().unbindBidirectional(oldVal.getPrimerApellidoProperty());
                txtSApellido.textProperty().unbindBidirectional(oldVal.getSegundoApellidoProperty());
                txtCedula.textProperty().unbindBidirectional(oldVal.getCedulaProperty());
                chkAdministrador.selectedProperty().unbindBidirectional(oldVal.getAdministradorProperty());
                txtCorreo.textProperty().unbindBidirectional(oldVal.getCorreoProperty());
                txtUsuario.textProperty().unbindBidirectional(oldVal.getUsuarioProperty());
                txtClave.textProperty().unbindBidirectional(oldVal.getClaveProperty());
                dtpFIngreso.textProperty().unbindBidirectional(oldVal.getFechaIngresoProperty());
                dtpFSalida.textProperty().unbindBidirectional(oldVal.getFechaSalidaProperty());
                chkActivo.selectedProperty().unbindBidirectional(oldVal.getActivoProperty());
                BindingUtils.unbindToggleGroupToProperty(tggGenero, oldVal.getGeneroProperty());
            }
            if(newVal != null){
                if(newVal.getIdProperty().get() != null && !newVal.getIdProperty().get().isBlank()){
                    txtId.textProperty().bind(newVal.getIdProperty());
            }
                txtId.textProperty().unbind();
                txtNombre.textProperty().unbindBidirectional(newVal.getNombreProperty());
                txtPApellido.textProperty().unbindBidirectional(newVal.getPrimerApellidoProperty());
                txtSApellido.textProperty().unbindBidirectional(newVal.getSegundoApellidoProperty());
                txtCedula.textProperty().unbindBidirectional(newVal.getCedulaProperty());
                chkAdministrador.selectedProperty().unbindBidirectional(newVal.getAdministradorProperty());
                txtCorreo.textProperty().unbindBidirectional(newVal.getCorreoProperty());
                txtUsuario.textProperty().unbindBidirectional(newVal.getUsuarioProperty());
                txtClave.textProperty().unbindBidirectional(newVal.getClaveProperty());
                dtpFIngreso.textProperty().unbindBidirectional(newVal.getFechaIngresoProperty());
                dtpFSalida.textProperty().unbindBidirectional(newVal.getFechaSalidaProperty());
                chkActivo.selectedProperty().unbindBidirectional(newVal.getActivoProperty());
                //
                BindingUtils.unbindToggleGroupToProperty(tggGenero, newVal.getGeneroProperty());
            } 
            
        });
        }catch(Exception ex){
       new Mensaje().showModal(Alert.AlertType.ERROR, "Error al realizar el bindeo", getStage(),
       "Ocurrion un error al realizar el bindeo.");
        }
    }
    private void cargarValoresDefecto(){
        this.empleado = new EmpleadoDto();
        this.empleado.setActivo(Boolean.TRUE);
        this.empleado.setAdministrador(Boolean.FALSE);
        this.empleado.setFechaIngreso(LocalDate.now());
        this.empleado.setGenero("M");
        this.empleadoProperty.set(this.empleado);
        validarAdministrador();
        txtId.clear();
        txtId.requestFocus();
    }
    private void validarAdministrador(){
        if(chkAdministrador.isSelected()){
            requeridos.addAll(Arrays.asList(txtUsuario,txtClave));
            txtUsuario.setDisable(false);
            txtClave.setDisable(false);
        }else{
            txtUsuario.clear();
            txtUsuario.setDisable(true);
            txtClave.clear();
            txtClave.setDisable(true);
        }
        txtUsuario.setDisable(!chkAdministrador.isSelected());
        txtClave.setDisable(!chkAdministrador.isSelected());
    }
    private void indicarRequeridos(){
        requeridos.clear();
        requeridos.addAll(Arrays.asList(txtCedula,txtNombre,txtPApellido,dtpFIngreso));
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
    private void onActionAdministrador(ActionEvent event) {
        validarAdministrador();
    }

    @FXML
    private void onActionBtnNuevo(ActionEvent event) {
        if (new Mensaje().showConfirmation("Limpiar Empleado", getStage(), 
            "esta seguro que desea limpiar el registro?")){
        }
    }

    @FXML
    private void onActionBtnGuardar(ActionEvent event) {
        try{
            String invalidos = validarRequeridos();
            if(invalidos.isBlank()){
                new Mensaje().showModal(Alert.AlertType.WARNING, "Guardar Empleado"
                , getStage(), invalidos);
            }else{
                
            }
        }catch(Exception ex){
            Logger.getLogger(EmpleadosController.class.getName()).
                    log(Level.SEVERE,"Error guardando el empleado.",ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar Empleado", getStage(),
                    "Ocurrio un error guardando el empleado");
        }
    }

    @FXML
    private void onActionBtnBuscar(ActionEvent event) {
        try{
            String invalidos = validarRequeridos();
            if(invalidos.isBlank()){
                new Mensaje().showModal(Alert.AlertType.WARNING, "Guardar Empleado"
                , getStage(), invalidos);
            }else{
                
            }
        }catch(Exception ex){
            Logger.getLogger(EmpleadosController.class.getName()).
                    log(Level.SEVERE,"Error guardando el empleado.",ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Guardar Empleado", getStage(),
                    "Ocurrio un error guardando el empleado");
        }
    }

    @FXML
    private void onActionBtnEliminar(ActionEvent event) {
        try{
            if(this.empleado.getId() == null){
                new Mensaje().showModal(Alert.AlertType.WARNING, "Eliminar Empleado"
                , getStage(), "Favor consultar el empleado a eliminar.");
            }else{
                new Mensaje().showModal(Alert.AlertType.INFORMATION, "Eliminar Empleado"
                , getStage(), "El empleado se elimino correctamente.");
            }
        }catch(Exception ex){
            Logger.getLogger(EmpleadosController.class.getName()).
                    log(Level.SEVERE,"Error eliminando el empleado.",ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "Rliminar Empleado", getStage(),
                    "Ocurrio un error eliminando el empleado");
        }
    }
    private void cargarEmpleado(Long id){
        try{
            
        }catch(Exception ex){
            Logger.getLogger(EmpleadosController.class.getName()).
                    log(Level.SEVERE,"Error consultando el empleado.",ex);
            new Mensaje().showModal(Alert.AlertType.ERROR, "consultar Empleado", getStage(),
                    "Ocurrio un error consultando el empleado");
        }
    }
    @FXML
    private void onKeyPressedtxtId(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER 
                && !txtId.getText().isBlank()){
            cargarEmpleado(Long.valueOf(txtId.getText()));
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.unaplanilla.model;

import java.util.Objects;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author andys
 */
public class TiposPlanillaDto {
    
    private StringProperty id;
    private StringProperty codigo;
    private StringProperty descripcion;
    private IntegerProperty planillasMes;
    private BooleanProperty activo;
    
    //-----------------------------------------------------------------------------------------------------------------------------------
    public TiposPlanillaDto(){
        this.id = new SimpleStringProperty("");
        this.codigo = new SimpleStringProperty("");
        this.descripcion = new SimpleStringProperty("");
        this.planillasMes = new SimpleIntegerProperty(1);
        this.activo = new SimpleBooleanProperty(true);
    }
    //Getters-----------------------------------------------------------------------------------------------------------------------------------

    public Long getId() {
        if (this.id.get() != null && !this.id.get().isBlank()){
              return Long.valueOf(this.id.get());
          }else{
              return null;
          }
    }

    public String getCodigo() {
        return codigo.get();
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public Integer getPlanillasMes() {
        return planillasMes.get();
    }

    public Boolean getActivo() {
        return activo.get();
    }
    
    //Setters-----------------------------------------------------------------------------------------------------------------------------------
    
    public void setId(StringProperty id) {    
        this.id.set(id.toString());
    }

    public void setCodigo(StringProperty codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(StringProperty descripcion) {
        this.descripcion = descripcion;
    }

    public void setPlanillasMes(Integer planillasMes) {
        this.planillasMes.set(planillasMes);
    }
    
    public void setActivo(Boolean activo) {    
        this.activo.set(activo);
    }

    //Get Property-----------------------------------------------------------------------------------------------------------------------------------
    public StringProperty getIdProperty() {
        return id;
    }

    public StringProperty getCodigoProperty() {
        return codigo;
    }

    public StringProperty getDescripcionProperty() {
        return descripcion;
    }

    public IntegerProperty getPlanillasMesProperty() {
        return planillasMes;
    }

    public BooleanProperty getActivoProperty() {
        return activo;
    }
    //-----------------------------------------------------------------------------------------------------------------------------------
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmpleadoDto other = (EmpleadoDto) obj;
        return Objects.equals(this.id, other.id);
    }
        @Override
    public String toString() {
        return "EmpleadoDto{" + "id=" + id + ", codigo=" + codigo + ", Descripcion=" + descripcion + '}';
    }
    
}

package Domain.Presentation.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import Domain.Modelo.Cliente;
import javafx.stage.Stage;

import java.time.LocalDate;


public class FormularioClienteController {

    @FXML private TextField txtIdentificacionCliente;
    @FXML private TextField txtNombreCliente;
    @FXML private TextField txtApellidoCliente;
    @FXML private DatePicker dtpFechaNacimiento;

    @FXML private Cliente cliente;
    @FXML  private boolean modoEdicion = false;

    @FXML public void setCliente(Cliente cliente, boolean editar) {
        this.cliente = cliente;
        this.modoEdicion = editar;

        /// solo si ya existe el cliente
        /// hay quie cargar los datos que estaban previamente guardados
        if(editar == true && cliente != null){
            txtIdentificacionCliente.setText(cliente.getIdentificacion());
            txtNombreCliente.setText(cliente.getNombre());
            txtApellidoCliente.setText(cliente.getPrimerApellido());
            dtpFechaNacimiento.setValue(cliente.getFechaNacimiento());
        }
    }

@FXML private void guardarCliente() {
  try{
      String identififcacion = txtIdentificacionCliente.getText().trim();
      String nombre = txtNombreCliente.getText().trim(); ///el trim quita espacios finales en blanco despues del texto
      String apellido = txtApellidoCliente.getText().trim();
      LocalDate fechaNacimiento = dtpFechaNacimiento.getValue();
      /// verificar que este completo
      if (identififcacion.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || fechaNacimiento == null) {
          mostrarAlerta("Datos Incompletos", "Rellenar todos los campos del formulario");
          return;
      }

      /// verificar si es un cliente nuevo o estamos editando uno existente
      if(!modoEdicion){
          //cliente nuevo
          cliente = new Cliente(0, identififcacion,nombre,apellido,fechaNacimiento); //CORREFIIII'FADGDwr
      }
      else{
          cliente.setIdentificacion(identififcacion);
          cliente.setNombre(nombre);
          cliente.setPrimerApellido(apellido);
          cliente.setFechaNacimiento(fechaNacimiento);
      }

      /// control del movimiento de las ventanas
      ///  se va a abrir y se va a cerrar para devolverse a la principal
      Stage stage = (Stage) txtNombreCliente.getScene().getWindow();
      stage.setUserData(cliente);
      stage.close();

  }catch(Exception e){
      mostrarAlerta("Error", "Error al guardar los datos");
  }
}

    @FXML private void mostrarAlerta(String titulo, String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML private void limpiarCampos(){ /// limpiar formulario cada vez que se agrega un cliente
        txtIdentificacionCliente.clear();
        txtNombreCliente.clear();
        txtApellidoCliente.clear();
        dtpFechaNacimiento.setValue(null);
    }


    @FXML private void cancelarCliente(){
        try
        {
            Stage stage = (Stage) txtNombreCliente.getScene().getWindow();
            stage.setUserData(null);
            stage.close();
        }
        catch(Exception e)
        {
            mostrarAlerta("Error", "Error al cancelar los datos");
        }
    }



}

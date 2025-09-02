package Domain.Presentation.Controller;

import Domain.Modelo.Cliente;
import Domain.Modelo.Reservacion;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable; ///permite que antes de que se pinte la pantalla se pinte algun codigo
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList; /// para ver visualmente los cambios de las listas
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL; ///para enviar peticiones por internet
import java.time.LocalDate;
import java.util.ResourceBundle;


public class InicioController implements Initializable {

     @FXML private TableView<Cliente> tblCliente;
     @FXML private TableColumn<Cliente,String> colNombreCliente;
     @FXML private TableColumn<Cliente,String> colIdentificacionCliente;
    @FXML private TableColumn<Cliente,String> colIdCliente;

    @FXML private TextField txtBuscarCliente;
     @FXML private Button btnBuscarCliente;
     @FXML private Button modificarCliente;
     @FXML  private Button eliminarCliente;

     @FXML private final ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();

     //contorles del formulario

    @FXML private TextField txtIdentificacionCliente;
    @FXML private TextField txtNombreCliente;
    @FXML private TextField txtApellidoCliente;
    @FXML private DatePicker dtpFechaNacimiento;
    private Reservacion controller;


    protected void BuscarCliente(){
         String idCliente = txtBuscarCliente.getId();
         //recibe una lista

     }
    //agregar
    /*@FXML private void AgregarCliente(){
         String identififcacion = txtIdentificacionCliente.getText().trim();
         String nombre = txtNombreCliente.getText().trim(); ///el trim quita espacios finales en blanco despues del texto
         String apellido = txtApellidoCliente.getText().trim();
         LocalDate fechaNacimiento = dtpFechaNacimiento.getValue();
            /// verificar que este completo
         if(identififcacion.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || fechaNacimiento == null){
             mostrarAlerta("Datos Incompletos","Rellenar todos los campos del formulario");
             return;



         /// verificar que la cedula no se repita

        for(Cliente c : listaClientes){
            if(c.getIdentificacion().equals(identififcacion)){
                mostrarAlerta("Identificacion repetida", "Cliente con este ID ya existe");
            }
            return;
        }

        listaClientes.add(new Cliente(listaClientes.getLast().getIdCliente()+1,1,"juan",)) ///FALTAAAAAAAAAAAAAAAAAAA

        limpiarCampos();
    }*/

    @FXML private Cliente agregarCliente(Cliente cliente, boolean editar){
        Cliente nuevo = mostrarFormulario();
        if(nuevo == null){
           nuevo.setIdentificacion(listaClientes.getLast().getIdentificacion()+1;
        }
        for(Cliente c : listaClientes){
            if(c.getIdentificacion().equals(nuevo.getIdentificacion())){
                mostrarAlerta("Identificacion repetida", "Cliente con este ID ya existe");
            }
            return null;
        }
        return nuevo;
    }

    private Cliente mostrarFormulario(Cliente cliente, boolean editor) { ///si es false es cliente nuevo
     try{
         FXMLLoader loader = new FXMLLoader(getClass().getResource("formulario-cliente-view.fxml"));
         Parent root  = loader.load();
         //llamar a la clase del formularioController
         FormularioClienteController controller = loader.getController();
         //settear la info del cliente que se va a agregar (se necesita el metodo en FormularioCliete)
         return cliente;
     }catch(Exception e){
         mostrarAlerta("error al abrir formulario", e.getMessage());
         return null;
     }
    }

    private void limpiarCampos(){ /// limpiar formulario cada vez que se agrega un cliente
         txtIdentificacionCliente.clear();
         txtNombreCliente.clear();
         txtApellidoCliente.clear();
         dtpFechaNacimiento.setValue(null);
    }

    private void mostrarAlerta(String titulo, String mensaje){
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle(titulo);
         alert.setHeaderText(null);
         alert.setContentText(mensaje);
         alert.showAndWait();
    }
    //eliminar
    @FXML void EliminarCliente() {
        try {
            Cliente seleccionado = tblCliente.getSelectionModel().getSelectedItem();
            if (seleccionado != null) {
                mostrarAlerta("Seleccione cliente", "Debe seleccionar un cliente");
                return;
            }

            listaClientes.remove(seleccionado);
        } catch (Exception e) {
            mostrarAlerta("error al eliminar el cliente", e.getMessage());
        }
    }

    @FXML void buscarCliente() {
        try {
            String criterio = txtIdentificacionCliente.getText().trim().toLowerCase(); ///case sentitive
        if(criterio.isEmpty()){
            tblCliente.setItems(listaClientes); /// tira de nuevo la lista
        return;
        }
        ObservableList<Cliente> filtrados =
                FXCollections.observableArrayList(
                        listaClientes.stream().filter(c ->c.getIdentificacion().toLowerCase().contains(criterio)
                        || c.getNombre().toLowerCase().contains(criterio)
                        || c.getPrimerApellido().toLowerCase().contains(criterio)));
        tblCliente.setItems(filtrados);
        }catch(Exception e){
            mostrarAlerta("error al buscar el cliente", e.getMessage());
        }
    }

    private void ModificarCliente() {
        Cliente seleccionado = tblCliente.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            mostrarAlerta("Seleccione cliente", "Debe seleccionar un cliente");
            return;
        }

        Cliente modificado = mostrarFormulario(seleccionado, true); /// true xq si se esta editando
        if(modificado == null){
            tblCliente.refresh();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ///  asociar las columnas con propiedades de la  clase cliente
        colNombreCliente.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        colNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));
        colNombreCliente.setCellValueFactory(new PropertyValueFactory<>("identificacion"));

        listaClientes.addAll(
                new Cliente (1,"1","juan","perez","Bolaños", LocalDate.of(1995,02,25),25)
                //otros clientes


        );
        tblCliente.setItems(listaClientes);

    }
}


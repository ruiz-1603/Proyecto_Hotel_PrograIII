import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class LoginViewController {
    @FXML///  para empatar lo que tiene el formulario visualmente con el code
    private TextField txtUsuario;
    private PasswordField pwdPassword;
    @FXML private ProgressIndicator progress;
    @FXML private Button btnIniciar;

    @FXML
    protected void funcion_iniciar_sesion(){

        String usuario = txtUsuario.getText();
        String password = pwdPassword.getText();

        btnIniciar.setVisible(false);
        progress.setVisible(true);

        new Thread(()->{
            try{
                Thread.sleep(1500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            Platform.runLater(()->{
                //ocultar el progress y restaurar boton
                progress.setVisible(false);
                btnIniciar.setVisible(true);
                if(usuario.equals("admin") && password.equals("1234")){
                    try{

                    }catch(Exception e){}

                }else{

                }
            });
        }).start();//para que se ejecute cada vez que se le da click

        if(usuario.equals("admin") && password.equals("1234")) {
            //caso de exito
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Inicio.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage)txtUsuario.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Pantalla de inicio");
            }
            catch(Exception error){    // error del sistema al inciar sesion

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de sistema");
                alert.setHeaderText("");                                    // aquí iria el codigo del error
                alert.setContentText("Ocurrió un error inesperado en el sistema, intente más tarde. " +
                        "El detalle del error es: " +error.getMessage()); // OJO -> tira la excepeción correspondiente del sistema
                alert.showAndWait();                                     //pone un boton de aceptar en la pantalla despues del error
            }
        }
        else{//caso en el que usuario y contra no son validos
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);                 //para quitar el espacio grande donde esta el error
            alert.setContentText("Error, usuario o contraseña incorrectos");
            alert.showAndWait();                //pone un boton de aceptar en la pantalla despues del error
        }
    }
}

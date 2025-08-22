package Backend;

public class Funcionario
{
    private String nombre;
    private int id;

    public Funcionario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public Funcionario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarInfoPersonal()
    {
        System.out.println(" Id: " + this.id + "Nombre: " + this.nombre+ "\n");
    }
}

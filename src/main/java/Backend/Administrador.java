package Backend;

public class Administrador extends Funcionario {
    private double salario;
    private String departamento;

    public Administrador(String nombre, int id, double salario, String departamento) {
        super(nombre, id);
        this.salario = salario;
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public void mostrarInfoPersonal() {
        super.mostrarInfoPersonal();
        System.out.println(" Departamento: " + this.departamento + "\n");
        System.out.println(" Salario: " + this.salario);
    }
}

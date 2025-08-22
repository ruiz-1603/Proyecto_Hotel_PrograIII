package Backend;

public class PersonalSeguridad extends Funcionario {
    private boolean licenciaArmaa;
    private String turno;

    public PersonalSeguridad(String nombre, int id, boolean licenciaArma, String turno) {
        super(nombre, id);
        this.licenciaArmaa = licenciaArma;
        this.turno = turno;
    }

    public boolean isLicenciaArmaa() {
        return licenciaArmaa;
    }

    public void setLicenciaArmaa(boolean licenciaArmaa) {
        this.licenciaArmaa = licenciaArmaa;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public void mostrarInfoPersonal() {
        super.mostrarInfoPersonal();
        System.out.println("Turno: " + this.turno+"\n");
        System.out.println("Posee licencia de portacion de armas: " + (this.licenciaArmaa == true ? "Si" : "No"));
    }
}

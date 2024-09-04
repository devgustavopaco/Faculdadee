public class Professor {
    private String nome;
    private String departamento;

    public Professor(String nome, String departamento){
        this.nome = nome;
        this.departamento = departamento;
    }

    public String getNome(){
        return nome;
    }

    public String getDepartamento(){
        return departamento;
    }

    @Override
    public String toString() {
        return "Professor [Nome = " + nome + ",   Departamento = " + departamento + "]";
    }
}

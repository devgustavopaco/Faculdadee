import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private String codigo;
    private Professor professor;
    private List<Aluno>alunos;

    public Disciplina(String nome, String codigo, Professor professor){
        this.nome = nome;
        this.codigo = codigo;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public String getCodigo(){
        return codigo;
    }

    public Professor getProfessor(){
        return professor;
    }

    public  List<Aluno> getAlunos(){
        return alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public String toString() {
        return "Disciplina [Nome=" + nome + ", Código=" + codigo + ", Professor=" + professor.getNome() + "]";
    }
}

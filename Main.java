import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Disciplina> disciplinas = new ArrayList<>();
    private static List<Aluno> alunos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\nMenu de Opções:");
            System.out.println("1. Matricular Alunos");
            System.out.println("2. Listar Disciplinas");
            System.out.println("3. Listar Alunos (por disciplina)");
            System.out.println("4. Pesquisar Disciplina (por nome ou por código)");
            System.out.println("5. Pesquisar Aluno (por nome ou matrícula)");
            System.out.println("6. Alterar informações do estudante");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir a quebra de linha

            switch (opcao) {
                case 1:
                    matricularAluno(scanner);
                    break;
                case 2:
                    listarDisciplinas();
                    break;
                case 3:
                    listarAlunosPorDisciplina(scanner);
                    break;
                case 4:
                    pesquisarDisciplina(scanner);
                    break;
                case 5:
                    pesquisarAluno(scanner);
                    break;
                case 6:
                    alterarInformacoesAluno(scanner);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }

    private static void matricularAluno(Scanner scanner) {
        System.out.print("Nome do aluno: ");
        String nomeAluno = scanner.nextLine();
        System.out.print("Matrícula do aluno: ");
        String matricula = scanner.nextLine();

        Aluno aluno = new Aluno(nomeAluno, matricula);
        alunos.add(aluno);

        System.out.println("Aluno matriculado com sucesso!");

        // Opcional: associar aluno a uma disciplina
        System.out.print("Deseja associar o aluno a uma disciplina? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            listarDisciplinas();
            System.out.print("Código da disciplina: ");
            String codigoDisciplina = scanner.nextLine();
            Disciplina disciplina = buscarDisciplinaPorCodigo(codigoDisciplina);
            if (disciplina != null) {
                disciplina.adicionarAluno(aluno);
                System.out.println("Aluno associado à disciplina com sucesso!");
            } else {
                System.out.println("Disciplina não encontrada.");
            }
        }
    }

    private static void listarDisciplinas() {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
        } else {
            for (Disciplina disciplina : disciplinas) {
                System.out.println(disciplina);
            }
        }
    }

    private static void listarAlunosPorDisciplina(Scanner scanner) {
        System.out.print("Código da disciplina: ");
        String codigo = scanner.nextLine();
        Disciplina disciplina = buscarDisciplinaPorCodigo(codigo);
        if (disciplina != null) {
            List<Aluno> alunosDaDisciplina = disciplina.getAlunos();
            if (alunosDaDisciplina.isEmpty()) {
                System.out.println("Nenhum aluno matriculado nesta disciplina.");
            } else {
                for (Aluno aluno : alunosDaDisciplina) {
                    System.out.println(aluno);
                }
            }
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    private static void pesquisarDisciplina(Scanner scanner) {
        System.out.print("Digite o nome ou código da disciplina: ");
        String busca = scanner.nextLine();
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equalsIgnoreCase(busca) || disciplina.getCodigo().equalsIgnoreCase(busca)) {
                System.out.println(disciplina);
                return;
            }
        }
        System.out.println("Disciplina não encontrada.");
    }

    private static void pesquisarAluno(Scanner scanner) {
        System.out.print("Digite o nome ou matrícula do aluno: ");
        String busca = scanner.nextLine();
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(busca) || aluno.getMatricula().equalsIgnoreCase(busca)) {
                System.out.println(aluno);
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    private static void alterarInformacoesAluno(Scanner scanner) {
        System.out.print("Digite a matrícula do aluno: ");
        String matricula = scanner.nextLine();
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
                System.out.print("Novo nome do aluno: ");
                aluno.setNome(scanner.nextLine());
                System.out.println("Informações alteradas com sucesso.");
                return;
            }
        }
        System.out.println("Aluno não encontrado.");
    }

    private static Disciplina buscarDisciplinaPorCodigo(String codigo) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getCodigo().equalsIgnoreCase(codigo)) {
                return disciplina;
            }
        }
        return null;
    }
}

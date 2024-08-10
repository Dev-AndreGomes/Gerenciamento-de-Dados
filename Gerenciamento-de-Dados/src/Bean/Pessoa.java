
package Bean;

/**
 *
 * @author andre
 */
public class Pessoa {
    String nome;
    String cpf;
    String curso;
    String email;
    int idade;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String curso, String email, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.curso = curso;
        this.email = email;
        this.idade = idade;
    }
    
     @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", CPF: " + cpf + ", Email: " + email + ", Curso: " + curso ;
    }
    
}

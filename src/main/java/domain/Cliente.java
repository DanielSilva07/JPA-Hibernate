package domain;
import javax.persistence.*;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator="cliente_sq")
    @SequenceGenerator(name = "cliente_sq", sequenceName = "sq_cliente" , initialValue = 1 ,allocationSize = 1)
    private Long id;

    @Column(name = "CPF" , length = 20 , nullable = false, unique = true)
    private String cpf;


    @Column(name = "NOME" , length = 50 , nullable = false )
    private String nome;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

package domain;
import javax.persistence.*;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator="produto_sq")
    @SequenceGenerator(name = "produto_sq", sequenceName = "sq_produto" , initialValue = 1 ,allocationSize = 1)
    private  Long id ;

    @Column(name = "CODIGO" , length = 10 , nullable = false , unique = true)
    private String codigo;

    @Column(name = "NOME" , length = 50 , nullable = false )
    private String nome;

    @Column(name = "PRICE" , length = 50 , nullable = false )
    private Double price;

    public  Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}

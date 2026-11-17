package Rota_Gas.Controller;

import jakarta.persistence.Entity;
import org.springframework.stereotype.Controller;


@Entity
@Controller
public class ClienteController {
    private Long  id;
    private String nome;
    private String endereco;
    private String complemento;
    private String cep;
    private String telefone;
}




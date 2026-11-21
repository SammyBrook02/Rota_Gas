package Rota_Gas.Controller;

import Rota_Gas.Entities.Cliente;
import Rota_Gas.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

   @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().
                        build());


   }

   @PostMapping
    public Cliente criar (@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
   }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente dados) {
        return clienteRepository.findById(id).map(cliente -> {
            cliente.setNome(dados.getNome());
            cliente.setEndereco(dados.getEndereco());
            cliente.setComplemento(dados.getComplemento());
            cliente.setCep(dados.getCep());
            cliente.setTelefone(dados.getTelefone());
            return ResponseEntity.ok(clienteRepository.save(cliente));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if  (!clienteRepository.existsById(id)) {
            return  ResponseEntity.notFound().build();
        }

        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}









package Rota_Gas.Controller;

import Rota_Gas.Entities.Cliente;
import Rota_Gas.Service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarClientes();
    }

   @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarClientePorId(id));
   }

   @PostMapping
    public Cliente criar (@RequestBody Cliente cliente) {
        return clienteService.salvarClientes(cliente);
   }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente dados) {
        return ResponseEntity.ok(clienteService.atualizarCliente( id, dados));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if (!clienteService.deletarCliente(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    }










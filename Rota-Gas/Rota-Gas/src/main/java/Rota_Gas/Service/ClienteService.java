package Rota_Gas.Service;

import Rota_Gas.Entities.Cliente;
import Rota_Gas.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente buscarClientePorId(Long id){
        return clienteRepository.findById(id)
                .map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().
                        build()).getBody();}

    public Cliente salvarClientes(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente atualizarCliente(Long id,Cliente cliente){
        return clienteRepository.findById(id).map(x -> {
            cliente.setNome(cliente.getNome());
            cliente.setEndereco(cliente.getEndereco());
            cliente.setComplemento(cliente.getComplemento());
            cliente.setCep(cliente.getCep());
            cliente.setTelefone(cliente.getTelefone());
            return ResponseEntity.ok(clienteRepository.save(cliente));
        }).orElse(ResponseEntity.notFound().build()).getBody();
    }

    public boolean deletarCliente (Long id){
        if (!clienteRepository.existsById(id)) {
            return false;
        }
        clienteRepository.deleteById(id);
        return true;
    }
}

package Rota_Gas.Service;

import Rota_Gas.Entities.Cliente;
import Rota_Gas.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }
}

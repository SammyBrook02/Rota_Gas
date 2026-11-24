package Rota_Gas.Repository;

import Rota_Gas.Entities.Entrega;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregadoresRepository extends CrudRepository<Entrega,Long> {
}

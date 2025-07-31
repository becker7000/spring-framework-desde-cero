package mx.com.telcel.webapp.repository;

import mx.com.telcel.webapp.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    // No se rellena, se autoimplementa
}

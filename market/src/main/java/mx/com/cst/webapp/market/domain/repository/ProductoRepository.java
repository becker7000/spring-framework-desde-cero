package mx.com.cst.webapp.market.domain.repository;

import mx.com.cst.webapp.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {

}

package mx.com.cst.webapp.market.domain.service;

import mx.com.cst.webapp.market.domain.repository.ProductoRepository;
import mx.com.cst.webapp.market.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto getProductoById(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }

}

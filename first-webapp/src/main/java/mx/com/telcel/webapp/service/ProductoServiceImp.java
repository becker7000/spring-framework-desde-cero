package mx.com.telcel.webapp.service;

import mx.com.telcel.webapp.entity.Producto;
import mx.com.telcel.webapp.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto getProductoById(int id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }

}

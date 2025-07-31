package mx.com.telcel.webapp.service;

import mx.com.telcel.webapp.entity.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> getAllProductos();
    Producto saveProducto(Producto producto);
    Producto getProductoById(int id);
    void deleteProducto(int id);

}

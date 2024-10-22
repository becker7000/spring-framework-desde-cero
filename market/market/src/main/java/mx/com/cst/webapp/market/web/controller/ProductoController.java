package mx.com.cst.webapp.market.web.controller;

import mx.com.cst.webapp.market.domain.service.ProductoService;
import mx.com.cst.webapp.market.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Obtener todos los productos
    @GetMapping
    public String getAllProductos(Model model) {
        List<Producto> productos = productoService.getAllProductos();
        model.addAttribute("productos", productos);
        return "index"; // Nombre del archivo HTML sin la extensión
    }

    // Obtener un producto por ID (para edición)
    @GetMapping("/{id}")
    public String getProductoById(@PathVariable int id, Model model) {
        Producto producto = productoService.getProductoById(id);
        model.addAttribute("producto", producto);
        return "editar-producto"; // Vista para editar el producto
    }

    // Crear un nuevo producto
    @PostMapping
    public String createProducto(@ModelAttribute Producto producto) {
        productoService.saveProducto(producto);
        return "redirect:/api/productos"; // Redirige a la lista de productos
    }

    // Actualizar un producto
    @PostMapping("/{id}")
    public String updateProducto(@PathVariable int id, @ModelAttribute Producto producto) {
        producto.setId(id); // Asegúrate de que el ID sea correcto
        productoService.saveProducto(producto);
        return "redirect:/api/productos"; // Redirige a la lista de productos
    }

    // Eliminar un producto
    @PostMapping("/{id}/delete")
    public String deleteProducto(@PathVariable int id) {
        productoService.deleteProducto(id);
        return "redirect:/api/productos"; // Redirige a la lista de productos
    }
}

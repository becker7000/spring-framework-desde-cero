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
    @GetMapping("/index")
    public String getAllProductos(Model model) {
        List<Producto> productos = productoService.getAllProductos();
        model.addAttribute("productos", productos);
        return "index"; // Nombre del archivo HTML sin la extensión
    }

    // Mostrar formulario para agregar o editar producto
    @GetMapping("/formulario")
    public String mostrarFormulario(@RequestParam(value = "id", required = false) Integer id, Model model) {
        Producto producto = (id != null) ? productoService.getProductoById(id) : new Producto();
        model.addAttribute("producto", producto);
        return "formulario"; // Nombre de la vista del formulario
    }

    // Crear o actualizar producto
    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.saveProducto(producto);
        return "redirect:/api/productos/index"; // Redirigir a la lista de productos
    }

    // Eliminar producto
    @GetMapping("/eliminar")
    public String deleteProducto(@RequestParam("id") int id) {
        productoService.deleteProducto(id);
        return "redirect:/api/productos/index"; // Redirigir a la lista de productos
    }

}

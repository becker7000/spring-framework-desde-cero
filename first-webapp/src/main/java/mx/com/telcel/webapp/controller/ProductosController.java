package mx.com.telcel.webapp.controller;

import mx.com.telcel.webapp.entity.Producto;
import mx.com.telcel.webapp.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/productos/api")
public class ProductosController {

    @Autowired
    private ProductoService productoService;

    // Obtener todos los productos
    @GetMapping("/obtener-productos")
    public String getAllProductos(
            Model model
    ) {
        List<Producto> productos = productoService.getAllProductos();
        model.addAttribute("productos", productos);
        return "productos"; // Nombre del archivo HTML sin la extensión
    }

    // Mostrar formulario para agregar o editar producto
    @GetMapping("/formulario-productos")
    public String mostrarFormulario(
            @RequestParam(value = "id", required = false) Integer id,
            Model model
    ) {
        Producto producto = (id != null) ? productoService.getProductoById(id) : new Producto();
        model.addAttribute("producto", producto);
        return "formulario-productos"; // Nombre de la vista del formulario
    }

    // Crear o actualizar producto
    @PostMapping("/guardar-producto")
    public String guardarProducto(
            @ModelAttribute Producto producto
    ) {
        productoService.saveProducto(producto);
        return "redirect:/productos/api/obtener-productos"; // Redirigir a la lista de productos
    }

    // Eliminar producto
    @GetMapping("/eliminar-producto")
    public String deleteProducto(
            @RequestParam("id") int id
    ) {
        productoService.deleteProducto(id);
        return "redirect:/productos/api/obtener-productos"; // Redirigir a la lista de productos
    }

}

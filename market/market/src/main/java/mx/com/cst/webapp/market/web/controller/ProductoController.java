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

}

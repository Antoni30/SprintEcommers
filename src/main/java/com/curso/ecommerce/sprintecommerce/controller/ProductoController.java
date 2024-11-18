package com.curso.ecommerce.sprintecommerce.controller;

import com.curso.ecommerce.sprintecommerce.model.Producto;
import com.curso.ecommerce.sprintecommerce.model.Usuario;
import com.curso.ecommerce.sprintecommerce.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOOGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;


    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("productos",productoService.getAllProductos());

        return "productos/show";
    }
    @GetMapping("/create")
    public String create(){
        return "productos/create";
    }
    @PostMapping("/save")
    public String save(Producto producto){
        LOOGER.info("Este es un producto {}",producto);
        Usuario usuario = new Usuario(1);
        producto.setUsuario(usuario);
        productoService.save(producto);
        return "redirect:/productos";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoService.get(id);
        producto = optionalProducto.get();
        LOOGER.info("Producto Buscado: {}",producto);
        model.addAttribute("producto",producto);

        return "productos/edit";
    }
    @PostMapping("/update")
    public String update(Producto producto){
        productoService.update(producto);
        return "redirect:/productos";
    }
    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable Integer id){
       productoService.delete(id);
       return "redirect:/productos";
    }
 }

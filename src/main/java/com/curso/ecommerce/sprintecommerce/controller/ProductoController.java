package com.curso.ecommerce.sprintecommerce.controller;

import com.curso.ecommerce.sprintecommerce.model.Producto;
import com.curso.ecommerce.sprintecommerce.model.Usuario;
import com.curso.ecommerce.sprintecommerce.service.ProductoService;
import com.curso.ecommerce.sprintecommerce.service.UploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOOGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    @Autowired
    private UploadFileService upload;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("productos",productoService.findAll());

        return "productos/show";
    }
    @GetMapping("/create")
    public String create(){
        return "productos/create";
    }
    @PostMapping("/save")
    public String save(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
        LOOGER.info("Este es un producto {}",producto);
        Usuario usuario = new Usuario(1);
        producto.setUsuario(usuario);


        if (producto.getId()==null) { // cuando se crea un producto
            String nombreImagen= upload.saveImage(file);
            producto.setImagen(nombreImagen);
        }else {

        }

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
    public String update(Producto producto, @RequestParam("img") MultipartFile file) throws IOException{


        Producto p= new Producto();
        p=productoService.get(producto.getId()).get();

        if (file.isEmpty()) { // editamos el producto pero no cambiamos la imagem
            producto.setImagen(p.getImagen());
        }else {// cuando se edita tbn la imagen
            //eliminar cuando no sea la imagen por defecto
            if (!p.getImagen().equals("default.jpg")) {
                upload.deleteImage(p.getImagen());
            }
            String nombreImagen= upload.saveImage(file);
            producto.setImagen(nombreImagen);
        }
        producto.setUsuario(p.getUsuario());
        productoService.update(producto);
        return "redirect:/productos";
    }
    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable Integer id){
        Producto p = new Producto();
        p=productoService.get(id).get();

        //eliminar cuando no sea la imagen por defecto
        if (!p.getImagen().equals("default.jpg")) {
            upload.deleteImage(p.getImagen());
        }
       productoService.delete(id);
       return "redirect:/productos";
    }
 }

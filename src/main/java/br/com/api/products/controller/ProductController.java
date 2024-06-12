package br.com.api.products.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.products.model.ProductModel;
import br.com.api.products.model.ResponseModel;
import br.com.api.products.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController  {

    @Autowired
    private ProductService productService;
    
    @GetMapping("/")
    public Iterable<ProductModel> getAll(){
       return productService.findALl();
    }

    @PostMapping("/") 
    public ResponseEntity<?> create(@RequestBody ProductModel productModel){
        return productService.createOrUpdate(productModel, "create");
    }


    @PutMapping("/")
    public ResponseEntity<?> upDate(@RequestBody ProductModel productModel){
        return productService.createOrUpdate(productModel, "update");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseModel> remove(@PathVariable Long id){
        return productService.removeProduct(id);
    }


}

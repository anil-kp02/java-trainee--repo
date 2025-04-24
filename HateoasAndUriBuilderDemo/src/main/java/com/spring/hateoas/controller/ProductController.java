package com.spring.hateoas.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.hateoas.entity.Product;
import com.spring.hateoas.repository.ProductRepoSitory;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepoSitory productRepoSitory;

	@GetMapping("get/by-id/{id}")
	public EntityModel<?> getProduct(@PathVariable Long id) {
		Product product = productRepoSitory.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getProduct(id))
				.withSelfRel();
//        Link updateLink= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).updateProduct(id, null)).withRel("update").withType("UPDATE");
//        Link deleteLink= WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).deleteProduct(id)).withRel("delete");
		// product.add(selfLink); if the product class extends
		// org.springframework.hateoas.RepresentationModel.

		return EntityModel.of(product, selfLink);
	}

	@PostMapping()
   public ResponseEntity<?> createProduct(@RequestBody Product product
    		, UriComponentsBuilder builder)
	{
    			
		Product savedProduct= productRepoSitory.save(product);
		
		URI uri = builder.path("product/{id}")
				.buildAndExpand(product.getId()).toUri();
		
		// hateos for each saved product .
		EntityModel<Product> resources = EntityModel.of(savedProduct);
		resources.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(ProductController.class).getProduct(savedProduct.getId())
        ).withSelfRel());

        resources.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(ProductController.class).updateProduct(savedProduct.getId(), null)
        ).withRel("update").withType("PUT"));

        resources.add(WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(ProductController.class).deleteProduct(savedProduct.getId())
        ).withRel("delete").withType("DELETE"));
		
        return ResponseEntity.created(uri).body(resources);
    }

	@PutMapping("update/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
		Product product = productRepoSitory.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		product.setName(productDetails.getName());
		product.setPrice(productDetails.getPrice());
		return productRepoSitory.save(product);
	}

	@DeleteMapping("delete/{id}")
	public Object deleteProduct(@PathVariable Long id) {
		Product product = productRepoSitory.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		productRepoSitory.delete(product);
		return "";
	}

}

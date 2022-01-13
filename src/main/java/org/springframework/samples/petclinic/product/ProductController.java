package org.springframework.samples.petclinic.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.samples.petclinic.pet.PetValidator;
import org.springframework.samples.petclinic.user.AuthoritiesService;
import org.springframework.samples.petclinic.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Collection;

@Slf4j
@Controller
public class ProductController {


    private static final String VIEW_PRODUCT_CREATE_FORM = "products/createOrUpdateProductForm";
    private static final String VIEW_WELCOME = "welcome";

    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
        // this.petService = petService;

    }


    @ModelAttribute("types")
    public Collection<ProductType> populatePetTypes() {

        Collection<ProductType> all_productypes = this.productService.getAllProductTypes();
        return all_productypes;
    }


    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }


    @GetMapping(value = "/product/create")
    public String createProduct(ModelMap model) {
        log.info("createProduct");
        System.out.println("createproduct");
        Product product = new Product();
        model.put("product", product);
        return VIEW_PRODUCT_CREATE_FORM;
    }

    @PostMapping(value = "/product/create")
    public String processProduct(@Valid Product product, BindingResult result) {
        log.info("processProduct");

        if (result.hasErrors()) {
            log.error("ERROR:" + result.getFieldErrors());
            return VIEW_PRODUCT_CREATE_FORM;
        }
        try {
            log.info("saving product");
            this.productService.save(product);
            log.info("saved product");

        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return VIEW_WELCOME;
    }


}

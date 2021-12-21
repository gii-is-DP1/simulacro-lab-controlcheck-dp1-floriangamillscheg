package org.springframework.samples.petclinic.product;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

public class ProductController {


    private static final String VIEW_PRODUCT_CREATE_FORM = "/products/createOrUpdateProductForm";

    @GetMapping(value = "/product/create")
    public String createProduct( ModelMap model)
    {
        Product product = new Product();
        model.put("product", product);
        return VIEW_PRODUCT_CREATE_FORM;
    }




    
}

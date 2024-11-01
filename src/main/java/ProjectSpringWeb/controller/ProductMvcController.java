package ProjectSpringWeb.controller;

import ProjectSpringWeb.model.Product;
import ProjectSpringWeb.model.ProductCreateDto;
import ProjectSpringWeb.model.ProductReturnDto;
import ProjectSpringWeb.model.ProductUpdateDto;
import ProjectSpringWeb.service.impl.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mvc")
@RequiredArgsConstructor
public class ProductMvcController {

    private final ProductService productService;

    @GetMapping("/products")
    public String showProducts(Model model) {

        List<ProductReturnDto> productList = productService.getProducts();
        model.addAttribute("productList", productList);

        double totalSum = productList.stream().map(ProductReturnDto::getPrice).reduce(0.0, Double::sum);

        model.addAttribute("totalSum", totalSum);

        return "products";
    }

    @GetMapping
    public String getProducts(Model model) {
        List<ProductReturnDto> productList = productService.getProducts();
        model.addAttribute("productList", productList);
        return "products";
    }

    @GetMapping("/delete")
    public String deleteProductById(@RequestParam Long id) {
        productService.deleteProductById(id);
        return "redirect:/mvc";
    }

    @GetMapping("/update")
    public String updateView(@RequestParam Long id, Model model) {
        model.addAttribute("productUpdateDto", new ProductUpdateDto());
        return "update";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute ProductUpdateDto productUpdateDto, Model model) {
        model.addAttribute("productUpdateDto", productUpdateDto);
        productService.updateProduct(productUpdateDto);
        return "redirect:/mvc";
    }

    @GetMapping("/create")
    public String createView(Model model) {
        model.addAttribute("productCreateDto",new ProductCreateDto());
        return "create";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute ProductCreateDto productCreateDto, Model model) {
        model.addAttribute("productCreateDto",productCreateDto);
        productService.createProduct(productCreateDto);
        return "redirect:/mvc";
    }



}

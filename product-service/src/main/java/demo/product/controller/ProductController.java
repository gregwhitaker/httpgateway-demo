package demo.product.controller;

import demo.product.controller.model.ProductInfoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private static final Logger LOG = LoggerFactory.getLogger("netifi-demo");

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductInfoResponse> getProductInfo(@PathVariable("productId") String productId) {
        return null;
    }
}
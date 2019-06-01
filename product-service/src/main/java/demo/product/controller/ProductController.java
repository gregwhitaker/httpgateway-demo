package demo.product.controller;

import demo.product.controller.model.ProductInfoResponse;
import demo.product.service.ProductService;
import demo.product.service.model.ProductInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private static final Logger ACCESS_LOG = LoggerFactory.getLogger("access");

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductInfoResponse> getProductInfo(@PathVariable("productId") String productId) {
        ACCESS_LOG.info("Received request for getProductInfo [productId: {}]", productId);

        ProductInfo productInfo = productService.getProductInfo(productId);
        return ResponseEntity.ok(ProductInfoResponse.from(productInfo));
    }
}

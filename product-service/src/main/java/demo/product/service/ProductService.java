package demo.product.service;

import demo.product.service.model.ProductInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {
    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

    private final Map<String, ProductInfo> productInfos = new HashMap<>();

    public ProductInfo getProductInfo(String productId) {
        return null;
    }

    @PostConstruct
    public void init() {
        
    }
}

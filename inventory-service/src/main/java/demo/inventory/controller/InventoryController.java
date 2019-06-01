package demo.inventory.controller;

import demo.inventory.controller.model.ProductInventoryResponse;
import demo.inventory.controller.model.SkuInventoryResponse;
import demo.inventory.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
    private static final Logger LOG = LoggerFactory.getLogger("demo");

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventory/sku/{skuId}")
    public ResponseEntity<SkuInventoryResponse> getSkuInventory(@PathVariable("skuId") String skuId) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/inventory/product/{productId}")
    public ResponseEntity<ProductInventoryResponse> getProductInventory(@PathVariable("productId") String productId) {
        return ResponseEntity.ok().build();
    }
}

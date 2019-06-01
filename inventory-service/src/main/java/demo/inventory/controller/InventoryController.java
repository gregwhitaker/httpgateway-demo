/**
 * Copyright 2019, Netifi Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo.inventory.controller;

import demo.inventory.controller.model.ProductInventoryResponse;
import demo.inventory.controller.model.SkuInventoryResponse;
import demo.inventory.service.InventoryService;
import demo.inventory.service.model.SkuInventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller responsible for returning product and sku inventories.
 */
@RestController
public class InventoryController {
    private static final Logger ACCESS_LOG = LoggerFactory.getLogger("access");

    @Autowired
    private InventoryService inventoryService;

    /**
     * Get the inventory for all SKUs of a product.
     *
     * @param productId product id
     * @return inventory for all skus of the product
     */
    @GetMapping("/inventory/product/{productId}")
    public ResponseEntity<ProductInventoryResponse> getProductInventory(@PathVariable("productId") String productId) {
        ACCESS_LOG.info("Received request for getProductInventory [productId: {}]", productId);

        List<SkuInventory> skuInventories = inventoryService.getProductInventory(productId);
        return ResponseEntity.ok(ProductInventoryResponse.from(productId, skuInventories));
    }

    /**
     * Get the inventory for a single SKU.
     *
     * @param skuId stockkeeping unit
     * @return inventory for the SKU
     */
    @GetMapping("/inventory/sku/{skuId}")
    public ResponseEntity<SkuInventoryResponse> getSkuInventory(@PathVariable("skuId") String skuId) {
        ACCESS_LOG.info("Received request for getSkuInventory [skuId: {}]", skuId);

        SkuInventory skuInventory = inventoryService.getSkuInventory(skuId);
        return ResponseEntity.ok(SkuInventoryResponse.from(skuInventory));
    }
}

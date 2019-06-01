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
package demo.inventory.service;

import demo.inventory.service.error.ProductNotFoundException;
import demo.inventory.service.error.SkuNotFoundException;
import demo.inventory.service.model.SkuInventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
public class InventoryService {
    private static final Logger LOG = LoggerFactory.getLogger(InventoryService.class);
    private static final Random RAND = new Random(System.currentTimeMillis());

    private final Map<String, List<SkuInventory>> productInventory = new HashMap<>();
    private final Map<String, SkuInventory> skuInventory = new HashMap<>();

    /**
     * Retrieve the inventory for all skus of a product.
     *
     * @param productId product id
     * @return a list of the inventory for each sku of the product
     */
    public List<SkuInventory> getProductInventory(String productId) {
        List<SkuInventory> inv = productInventory.get(productId);

        if (inv == null) {
            throw new ProductNotFoundException(productId);
        }

        return inv;
    }

    /**
     * Retrieve the inventory for a single sku.
     *
     * @param sku stockkeeping unit id
     * @return the inventory for the sku
     */
    public SkuInventory getSkuInventory(String sku) {
        SkuInventory inv = this.skuInventory.get(sku);

        if (inv == null) {
            throw new SkuNotFoundException(sku);
        }

        return inv;
    }

    @PostConstruct
    public void init() {
        // Initialize the inventory with 10 dummy products
        for (int i = 1; i <= 10; i++) {
            List<SkuInventory> invs = new ArrayList<>();
            String productId = String.format("%03d", i);

            for (int x = 0; x < 3; x++) {
                SkuInventory s = new SkuInventory();
                s.setSku(productId + "-" + String.format("%03d", x));
                s.setUnits(RAND.nextInt((100) + 1));

                invs.add(s);
                skuInventory.put(s.getSku(), s);
            }

            productInventory.put(productId, invs);
        }
    }
}

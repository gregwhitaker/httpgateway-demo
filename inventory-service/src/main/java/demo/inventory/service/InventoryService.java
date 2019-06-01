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

import demo.inventory.service.model.SkuInventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryService {
    private static final Logger LOG = LoggerFactory.getLogger(InventoryService.class);

    public SkuInventory getInventoryForSku(String sku) {
        return null;
    }

    public List<SkuInventory> getInventoryForProduct(String productId) {
        return null;
    }
}

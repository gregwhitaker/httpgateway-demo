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
package demo.inventory.controller.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import demo.inventory.service.model.SkuInventory;

@JsonPropertyOrder({
        "sku",
        "units"
})
public class SkuInventoryResponse {

    /**
     *
     * @param skuInv
     * @return
     */
    public static SkuInventoryResponse from(SkuInventory skuInv) {
        SkuInventoryResponse response = new SkuInventoryResponse();
        response.setSku(skuInv.getSku());
        response.setUnits(skuInv.getUnits());

        return response;
    }

    private String sku;
    private int units;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}

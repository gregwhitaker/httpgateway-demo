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
package demo.store.service;

import demo.store.service.model.InventoryServiceResponse;
import demo.store.service.model.PdpData;
import demo.store.service.model.ProductServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PdpService {
    private static final Logger LOG = LoggerFactory.getLogger(PdpService.class);

    @Autowired
    private RestTemplate restTemplate;

    public PdpData getPdpData(String productId) {
        ProductServiceResponse productInfo = null;
        try {
            productInfo = restTemplate.getForObject("http://product-service/products/" + productId, ProductServiceResponse.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return null;
            } else {
                LOG.error("Error getting product information from product-service", e);
                throw e;
            }
        }

        InventoryServiceResponse inventory = null;
        try {
             inventory = restTemplate.getForObject("http://inventory-service/inventory/products/" + productId, InventoryServiceResponse.class);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return null;
            } else {
                LOG.error("Error getting inventory information from product-service", e);
                throw e;
            }
        }

        PdpData pdpData = new PdpData();
        pdpData.setProductId(productInfo.getProductId());
        pdpData.setActive(productInfo.isActive());
        pdpData.setShortName(productInfo.getShortName());
        pdpData.setLongName(productInfo.getLongName());
        pdpData.setDescription(productInfo.getDescription());

        List<PdpData.Sku> skus = new ArrayList<>();

        for (ProductServiceResponse.Sku skuInfo : productInfo.getSkus()) {
            PdpData.Sku sku = new PdpData.Sku();
            sku.setSku(skuInfo.getSku());
            sku.setActive(skuInfo.isActive());
            sku.setSize(skuInfo.getSize());
            sku.setUnits(0);

            for (InventoryServiceResponse.SkuInventoryResponse skuInv : inventory.getSkus()) {
                if (skuInv.getSku().equals(skuInfo.getSku())) {
                    sku.setUnits(skuInv.getUnits());
                    break;
                }
            }

            PdpData.Prices prices = new PdpData.Prices();
            prices.setList(skuInfo.getPrices().getFormattedList());
            prices.setMsrp(skuInfo.getPrices().getFormattedMsrp());
            prices.setSale(skuInfo.getPrices().getFormattedSale());

            sku.setPrices(prices);

            skus.add(sku);
        }

        pdpData.setSkus(skus);

        return pdpData;
    }
}

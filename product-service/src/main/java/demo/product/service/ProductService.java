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
package demo.product.service;

import demo.product.service.error.ProductNotFoundException;
import demo.product.service.model.PriceInfo;
import demo.product.service.model.ProductInfo;
import demo.product.service.model.SkuInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class ProductService {
    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);
    private static final Random RAND = new Random(System.currentTimeMillis());

    private final Map<String, ProductInfo> productInfos = new HashMap<>();

    /**
     *
     * @param productId
     * @return
     */
    public ProductInfo getProductInfo(String productId) {
        ProductInfo productInfo = productInfos.get(productId);

        if (productInfo == null) {
            throw new ProductNotFoundException(productId);
        }

        return productInfo;
    }

    @PostConstruct
    public void init() {
        for (int i = 1; i <= 10; i++) {
            String productId = String.format("%03d", i);

            ProductInfo productInfo = new ProductInfo();
            productInfo.setProductId(productId);
            productInfo.setShortName("Widget " + i);
            productInfo.setLongName("Some Widget - " + i);
            productInfo.setDescription(String.format("This is some type of widget-%s that you can't live without!", i));
            productInfo.setActive(true);

            for (int x = 0; x < 3; x++) {
                PriceInfo priceInfo = new PriceInfo();
                priceInfo.setSale(generateDummyPrice(10.0));
                priceInfo.setList(generateDummyPrice(priceInfo.getSale()));
                priceInfo.setMsrp(generateDummyPrice(priceInfo.getList()));

                SkuInfo s = new SkuInfo();
                s.setSku(productId + "-" + String.format("%03d", x));
                s.setActive(true);

                if (x == 0) {
                    s.setSize("Small");
                } else if (x == 1) {
                    s.setSize("Medium");
                } else if (x == 2) {
                    s.setSize("Large");
                } else {
                    s.setSize("One-Size");
                }

                s.setPrices(priceInfo);

                productInfo.addSkuInfo(s);
            }

            productInfos.put(productId, productInfo);
        }
    }

    private double generateDummyPrice(double min) {
        double randomValue = min + RAND.nextDouble();
        double tempRes = Math.floor(randomValue * 10);
        double price = tempRes/10;

        return price;
    }
}

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
package demo.store.service.model;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceResponse {

    private String productId;
    private String shortName;
    private String longName;
    private String description;
    private boolean active;
    private final List<Sku> skus = new ArrayList<>();

    public void addSku(Sku sku) {
        this.skus.add(sku);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    /**
     *
     */
    public static class Sku {

        private String sku;
        private boolean active;
        private String size;
        private Prices prices;

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public Prices getPrices() {
            return prices;
        }

        public void setPrices(Prices prices) {
            this.prices = prices;
        }
    }

    /**
     *
     */
    public static class Prices {

        private double list;
        private double msrp;
        private double sale;
        private String formattedList;
        private String formattedMsrp;
        private String formattedSale;

        public double getList() {
            return list;
        }

        public void setList(double list) {
            this.list = list;
        }

        public double getMsrp() {
            return msrp;
        }

        public void setMsrp(double msrp) {
            this.msrp = msrp;
        }

        public double getSale() {
            return sale;
        }

        public void setSale(double sale) {
            this.sale = sale;
        }

        public String getFormattedList() {
            return formattedList;
        }

        public void setFormattedList(String formattedList) {
            this.formattedList = formattedList;
        }

        public String getFormattedMsrp() {
            return formattedMsrp;
        }

        public void setFormattedMsrp(String formattedMsrp) {
            this.formattedMsrp = formattedMsrp;
        }

        public String getFormattedSale() {
            return formattedSale;
        }

        public void setFormattedSale(String formattedSale) {
            this.formattedSale = formattedSale;
        }
    }
}

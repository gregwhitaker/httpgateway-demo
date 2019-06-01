package demo.product.controller.model;

import demo.product.service.model.PriceInfo;
import demo.product.service.model.ProductInfo;
import demo.product.service.model.SkuInfo;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoResponse {

    public static ProductInfoResponse from(final ProductInfo productInfo) {
        ProductInfoResponse response = new ProductInfoResponse();

        response.setProductId(productInfo.getProductId());
        response.setActive(productInfo.isActive());
        response.setShortName(productInfo.getShortName());
        response.setLongName(productInfo.getLongName());
        response.setDescription(productInfo.getDescription());
        productInfo.getSkus().forEach(skuInfo -> response.addSku(Sku.from(skuInfo)));

        return response;
    }

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
    static class Sku {

        static Sku from(SkuInfo skuInfo) {
            Sku sku = new Sku();
            sku.setSku(skuInfo.getSku());
            sku.setActive(skuInfo.isActive());
            sku.setSize(skuInfo.getSize());
            sku.setPrices(Prices.from(skuInfo.getPrices()));

            return sku;
        }

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
    static class Prices {

        static Prices from(PriceInfo priceInfo) {
           Prices prices = new Prices();
           prices.setList(priceInfo.getList());
           prices.setMsrp(priceInfo.getMsrp());
           prices.setSale(priceInfo.getSale());
           prices.setFormattedList(priceInfo.getFormattedList());
           prices.setFormattedMsrp(priceInfo.getFormattedMsrp());
           prices.setFormattedSale(priceInfo.getFormattedSale());

           return prices;
        }

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

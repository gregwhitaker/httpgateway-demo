package demo.product.service.model;

public class SkuInfo {

    private String sku;
    private boolean active;
    private String size;
    private PriceInfo prices;

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

    public PriceInfo getPrices() {
        return prices;
    }

    public void setPrices(PriceInfo prices) {
        this.prices = prices;
    }
}

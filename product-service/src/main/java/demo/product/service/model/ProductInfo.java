package demo.product.service.model;

import java.util.ArrayList;
import java.util.List;

public class ProductInfo {

    private String productId;
    private String shortName;
    private String longName;
    private String description;
    private boolean active;
    private final List<SkuInfo> skus = new ArrayList<>();

    public void addSkuInfo(SkuInfo skuInfo) {
        skus.add(skuInfo);
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

    public List<SkuInfo> getSkus() {
        return skus;
    }
}

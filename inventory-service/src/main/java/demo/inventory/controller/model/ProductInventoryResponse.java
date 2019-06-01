package demo.inventory.controller.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({
        "productId",
        "skus"
})
public class ProductInventoryResponse {

    private String productId;
    private List<SkuInventory> skus;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<SkuInventory> getSkus() {
        return skus;
    }

    public void setSkus(List<SkuInventory> skus) {
        this.skus = skus;
    }

    @JsonPropertyOrder({
            "sku",
            "units"
    })
    class SkuInventory {

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
}

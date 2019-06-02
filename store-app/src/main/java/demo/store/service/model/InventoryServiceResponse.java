package demo.store.service.model;

import java.util.List;

public class InventoryServiceResponse {

    private String productId;
    private List<SkuInventoryResponse> skus;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<SkuInventoryResponse> getSkus() {
        return skus;
    }

    public void setSkus(List<SkuInventoryResponse> skus) {
        this.skus = skus;
    }

    /**
     *
     */
    public static class SkuInventoryResponse {

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

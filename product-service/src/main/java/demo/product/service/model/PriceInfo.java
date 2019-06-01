package demo.product.service.model;

public class PriceInfo {

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

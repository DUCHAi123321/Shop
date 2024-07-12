
package model;

import java.io.Serializable;

public class Size implements Serializable {
    private String product_id;
    private String size;

    public Size() {
    }

    public Size(String product_id, String size) {
        this.product_id = product_id;
        this.size = size;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}

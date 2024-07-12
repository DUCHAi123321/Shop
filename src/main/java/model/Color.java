
package model;

import java.io.Serializable;

public class Color implements Serializable{
    private String product_id;
    private String color;

    public Color() {
    }

    public Color(String product_id, String color) {
        this.product_id = product_id;
        this.color = color;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}

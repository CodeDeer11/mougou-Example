package com.lu.jdbc.summary.entity;

/**
 * @author xiaolu
 * @version 1.0
 * @date 2021-09-12 21:09
 */
public class OrderItem {
    private String itemid;
    private String pid;
    private String oid;
    private Product product;
    private Orders orders;

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemid='" + itemid + '\'' +
                ", pid='" + pid + '\'' +
                ", oid='" + oid + '\'' +
                ", product=" + product +
                ", orders=" + orders +
                '}';
    }
}

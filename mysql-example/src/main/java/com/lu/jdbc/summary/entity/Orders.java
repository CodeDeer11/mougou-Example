package com.lu.jdbc.summary.entity;

/**
 * @author xiaolu
 * @version 1.0
 * @date 2021-09-12 21:02
 */
public class Orders {
    private String oid;
    private String ordertime;
    private String total;
    private String name;
    private String telephone;
    private String address;
    private int state;

    private String uid;
    private User user;

    public Orders() {
    }

    public Orders(String oid, String ordertime, String total, String name, String telephone, String address, int state, String uid, User user) {
        this.oid = oid;
        this.ordertime = ordertime;
        this.total = total;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.state = state;
        this.uid = uid;
        this.user = user;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid='" + oid + '\'' +
                ", ordertime='" + ordertime + '\'' +
                ", total='" + total + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", uid='" + uid + '\'' +
                ", user=" + user +
                '}';
    }
}

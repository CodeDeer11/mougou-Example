package com.lu.jdbc.summary.entity;

/**
 * @author xiaolu
 * @version 1.0
 * @date 2021-09-12 21:07
 */
public class Product {
    private String pid;
    private String pname;
    private double price;
    private String pdesc;
    private int pflag;
    private String cid;
    private Category category;

    public Product() {
    }

    public Product(String pid, String pname, double price, String pdesc, int pflag, String cid, Category category) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.pdesc = pdesc;
        this.pflag = pflag;
        this.cid = cid;
        this.category = category;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public int getPflag() {
        return pflag;
    }

    public void setPflag(int pflag) {
        this.pflag = pflag;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", pdesc='" + pdesc + '\'' +
                ", pflag=" + pflag +
                ", cid='" + cid + '\'' +
                ", category=" + category +
                '}';
    }
}

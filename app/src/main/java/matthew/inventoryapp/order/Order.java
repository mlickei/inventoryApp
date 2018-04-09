package matthew.inventoryapp.order;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;

import java.util.Date;
import java.util.List;

import matthew.inventoryapp.item.Item;
import matthew.inventoryapp.show.Show;
import matthew.inventoryapp.tax.TaxInfo;

/**
 * Created by Matthew on 4/8/2018.
 */
@Entity(tableName = "order")
public class Order {

    @PrimaryKey
    private long id;

    @ColumnInfo
    private Date date;

//    @ColumnInfo(name="items")
//    private List<Item> items; TODO CREATE A POJO

//    @ColumnInfo(name = "show")
//    private Show show; TODO CREATE A POJO

//    @ColumnInfo(name = "tax_info")
//    private TaxInfo taxInfo; TODO CREATE A POJO

    @ColumnInfo(name = "pre_tax_price")
    private double preTaxPrice;

    @ColumnInfo(name = "tax_charged")
    private double taxCharged;

    @ColumnInfo(name = "final_price_charged")
    private double finalPriceCharged;

//    @ColumnInfo(name = "order_type")
//    private OrderType orderType; TODO CREATE A POJO

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public List<Item> getItems() {
//        return items;
//    }
//
//    public void setItems(List<Item> items) {
//        this.items = items;
//    }
//
//    public Show getShow() {
//        return show;
//    }
//
//    public void setShow(Show show) {
//        this.show = show;
//    }
//
//    public TaxInfo getTaxInfo() {
//        return taxInfo;
//    }
//
//    public void setTaxInfo(TaxInfo taxInfo) {
//        this.taxInfo = taxInfo;
//    }

    public double getPreTaxPrice() {
        return preTaxPrice;
    }

    public void setPreTaxPrice(double preTaxPrice) {
        this.preTaxPrice = preTaxPrice;
    }

    public double getTaxCharged() {
        return taxCharged;
    }

    public void setTaxCharged(double taxCharged) {
        this.taxCharged = taxCharged;
    }

    public double getFinalPriceCharged() {
        return finalPriceCharged;
    }

    public void setFinalPriceCharged(double finalPriceCharged) {
        this.finalPriceCharged = finalPriceCharged;
    }

//    public OrderType getOrderType() {
//        return orderType;
//    }
//
//    public void setOrderType(OrderType orderType) {
//        this.orderType = orderType;
//    }
}

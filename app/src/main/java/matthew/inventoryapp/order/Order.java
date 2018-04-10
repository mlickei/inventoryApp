package matthew.inventoryapp.order;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

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

    @ColumnInfo(name="order_items_id")
    private long orderItemsId;

    @Ignore
    private List<Item> items;

    @ColumnInfo(name = "show_id")
    private long showId;

    @Ignore
    private Show show;

    @ColumnInfo(name = "tax_info_id")
    private long taxInfoId;

    @Ignore
    private TaxInfo taxInfo;

    @ColumnInfo(name = "pre_tax_price")
    private double preTaxPrice;

    @ColumnInfo(name = "tax_charged")
    private double taxCharged;

    @ColumnInfo(name = "final_price_charged")
    private double finalPriceCharged;

    @ColumnInfo(name = "order_type_name")
    private String orderTypeName;

    @Ignore
    private OrderType orderType;

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

    public long getOrderItemsId() {
        return orderItemsId;
    }

    public void setOrderItemsId(long orderItemsId) {
        this.orderItemsId = orderItemsId;
    }

    public long getShowId() {
        return showId;
    }

    public void setShowId(long showId) {
        this.showId = showId;
    }

    public long getTaxInfoId() {
        return taxInfoId;
    }

    public void setTaxInfoId(long taxInfoId) {
        this.taxInfoId = taxInfoId;
    }

    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName;
    }
}

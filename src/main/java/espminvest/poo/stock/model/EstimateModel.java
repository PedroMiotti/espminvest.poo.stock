package espminvest.poo.stock.model;

import espminvest.poo.stock.common.datatype.EstimateBean;
import espminvest.poo.stock.common.datatype.StockBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "estimate")
public class EstimateModel {

    @Id
    @Column(name = "estimate_id")
    private int id;
    @Column(name = "stock_id")
    private int stockId;
    @Column(name = "estimate_value")
    private Double value;
    @Column(name = "estimate_date")
    private Date date;

    public EstimateModel(){}

    public EstimateModel(EstimateBean e){
        this.id = e.getId();
        this.stockId = e.getStock().getId();
        this.value = e.getValue();
        this.date = e.getDate();
    }

    public EstimateBean toBean(){
        StockBean s = new StockBean();
        s.setId(stockId);

        EstimateBean e = new EstimateBean();

        e.setId(id);
        e.setStock(s);
        e.setDate(date);
        e.setValue(value);

        return e;
    }

}

package espminvest.poo.stock.model;

import espminvest.poo.stock.common.datatype.StockBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class StockModel {

    @Id
    @Column(name = "stock_id")
    private int id;
    @Column(name = "stock_name")
    private String name;
    @Column(name = "stock_sign")
    private String sign;

    public StockModel(){ }

    public StockModel(StockBean s){
        this.id = s.getId();
        this.name = s.getName();
        this.sign = s.getSign();
    }

    public StockBean toBean(){
        StockBean c = new StockBean();

        c.setId(id);
        c.setName(name);
        c.setSign(sign);

        return c;
    }


}

package espminvest.poo.stock.rest;

import espminvest.poo.stock.common.controller.StockController;
import espminvest.poo.stock.common.datatype.EstimateBean;
import espminvest.poo.stock.common.datatype.StockBean;
import espminvest.poo.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstimateResource implements StockController {

    @Autowired
    StockService stockService;

    @Override
    public List<StockBean> listStocks() {
        return stockService.listAll();
    }

    @Override
    public StockBean getStock(String stockId) {
        Integer parsedStockId = Integer.parseInt(stockId);
        return stockService.findBy(parsedStockId);
    }

    @Override
    public EstimateBean getEstimate(String stockId, String date) {
        return null;
    }

    @Override
    public List<EstimateBean> getEstimates(String stockId, String dateInit, String dateEnd) {
        return null;
    }
}

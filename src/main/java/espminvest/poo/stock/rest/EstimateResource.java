package espminvest.poo.stock.rest;

import espminvest.poo.stock.common.controller.StockController;
import espminvest.poo.stock.common.datatype.EstimateBean;
import espminvest.poo.stock.common.datatype.StockBean;
import espminvest.poo.stock.service.EstimateService;
import espminvest.poo.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class EstimateResource implements StockController {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    private StockService stockService;

    @Autowired
    private EstimateService estimateService;

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
        try {
            Integer parsedCurrencyId = Integer.parseInt(stockId);
            StockBean stock = stockService.findBy(parsedCurrencyId);

            // Handle stock not found error

            return estimateService.findBy(stock.getId(), sdf.parse(date));

        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @Override
    public List<EstimateBean> getEstimates(String stockId, String dateInit, String dateEnd) {
        try {
            Integer parsedStockId = Integer.parseInt(stockId);
            StockBean stock = stockService.findBy(parsedStockId);

            if (stock == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, stockId + " not found");
            }

            Date initDate = dateInit == null ? null : sdf.parse(dateInit);
            Date endDate = dateEnd == null ? null : sdf.parse(dateEnd);

            return estimateService.listBy(stock.getId(), initDate, endDate);
        } catch (ParseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}

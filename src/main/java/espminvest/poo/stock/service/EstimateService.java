package espminvest.poo.stock.service;

import espminvest.poo.stock.common.datatype.EstimateBean;
import espminvest.poo.stock.model.EstimateModel;
import espminvest.poo.stock.repository.EstimateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstimateService {

    @Autowired
    EstimateRepository estimateRepository;

    @Autowired
    StockService stockService;

    public EstimateBean findBy(Integer currencyId, Date date) {

        EstimateBean estimate = estimateRepository
                .listByCurrencyDate(currencyId, date).stream()
                .map(EstimateModel::toBean)
                .findFirst()
                .orElse(null);

        return fillStock(estimate);
    }

    public List<EstimateBean> listBy(Integer currencyId, Date initDate, Date endDate) {
        return estimateRepository
                .listBy(currencyId, initDate, endDate).stream()
                .map(EstimateModel::toBean)
                .map(this::fillStock)
                .collect(Collectors.toList());
    }

    private EstimateBean fillStock(EstimateBean c) {
        if (c != null) {
            c.setStock(stockService.findBy(c.getStock().getId() ));
        }

        return c;
    }

}

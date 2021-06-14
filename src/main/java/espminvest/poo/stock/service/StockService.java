package espminvest.poo.stock.service;

import espminvest.poo.stock.common.datatype.StockBean;
import espminvest.poo.stock.model.StockModel;
import espminvest.poo.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StockService {
    @Autowired
    StockRepository stockRepository;

    public List<StockBean> listAll(){
        return StreamSupport
                .stream(stockRepository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .stream().map(StockModel::toBean)
                .collect(Collectors.toList());
    }

    public StockBean findBy(Integer id) {
        return stockRepository
                .findById(id)
                .map(StockModel::toBean)
                .orElse(null);
    }

}

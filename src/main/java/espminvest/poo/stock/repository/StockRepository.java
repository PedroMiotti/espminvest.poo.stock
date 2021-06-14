package espminvest.poo.stock.repository;

import espminvest.poo.stock.model.StockModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StockRepository extends CrudRepository<StockModel, Integer> {

    @Override
    Iterable<StockModel> findAll();

    @Override
    Optional<StockModel> findById(Integer id);

}

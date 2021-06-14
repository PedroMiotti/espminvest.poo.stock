package espminvest.poo.stock.repository;

import espminvest.poo.stock.model.EstimateModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EstimateRepository extends CrudRepository<EstimateModel, Integer> {

    @Override
    Iterable<EstimateModel> findAll();

    @Override
    Optional<EstimateModel> findById(Integer id);

    @Query("SELECT e FROM EstimateModel e WHERE e.stockId = :stockId AND e.date <= :date ORDER BY e.date DESC")
    List<EstimateModel> listByCurrencyDate(@Param("stockId") Integer stockId, @Param("date") Date date);

    @Query("SELECT e FROM EstimateModel e " +
            "WHERE " +
            "(e.stockId is null or e.stockId = :stockId) AND " +
            "(e.date is null or e.date >= :initDate) AND " +
            "(e.date is null or e.date <= :endDate)"
    )
    List<EstimateModel> listBy(
            @Param("stockId") Integer stockId,
            @Param("initDate") Date initDate,
            @Param("endDate") Date endDate
    );

}

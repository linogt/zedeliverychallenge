package org.example.repository;

import org.bson.types.ObjectId;
import org.example.model.Pdv;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PdvRepository extends MongoRepository<Pdv,String> {


    @Query(value = "{ $and: [ { 'address.coordinates.0' : { $lt: ?0 } }, { 'address.coordinates.1' : { $gt: ?1 } } ] }")
    List<Pdv> findByCoordinates(double longParam, double latParam);


}

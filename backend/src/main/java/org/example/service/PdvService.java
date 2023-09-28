package org.example.service;

import org.bson.types.ObjectId;
import org.example.model.Pdv;
import org.example.repository.PdvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPolygon;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

@Service
public class PdvService {

    @Autowired
    PdvRepository pdvRepository;

    public Pdv findByIdCustom(@PathVariable String id) {
        return pdvRepository.findById(id).orElse(null);
    }


    public Pdv checkCoordinates(double longParam, double latParam) {
        List<Pdv> pdvs = pdvRepository.findByCoordinates(longParam, latParam);
        Pdv closestPdv = null;
        double minDistance = Double.MAX_VALUE;

        for (Pdv pdv : pdvs) {
            double pdvDistance = calculateDistance(longParam, latParam, pdv.getCoverageArea().getCoordinates());

            if (pdvDistance < minDistance) {
                minDistance = pdvDistance;
                closestPdv = pdv;
            }
        }

        return closestPdv;
    }

    private double calculateDistance(double longParam, double latParam, List<GeoJsonPolygon> polygons) {
        double minDistance = Double.MAX_VALUE;

        for (GeoJsonPolygon polygon : polygons) {
            for (Point point : polygon.getPoints()) {
                double x = point.getX();
                double y = point.getY();

                double distance = Math.sqrt(Math.pow(x - longParam, 2) + Math.pow(y - latParam, 2));

                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }

        return minDistance;
    }


}

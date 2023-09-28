package org.example.model;




import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonMultiPolygon;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "zedeliverycollection")
public class Pdv {


    @Field("id")
    private String id;

    @Field("tradingName")
    private String tradingName;

    @Field("ownerName")
    private String ownerName;

    @Field("document")
    private String document;

    @Field("coverageArea")
    private GeoJsonMultiPolygon coverageArea;

    @Field("address")
    private GeoJsonPoint address;
}


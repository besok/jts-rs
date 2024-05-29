package org.besok.jts.examples;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

public class Main {
    public static void main(String[] args) throws ParseException {
        hw();
    }
    public static void hw() throws ParseException {
        // read a geometry from a WKT string (using the default geometry factory)
        Geometry g1 = new WKTReader().read("LINESTRING (0 0, 10 10, 20 20)");
        System.out.println("Geometry 1: " + g1);

        // create a geometry by specifying the coordinates directly
        Coordinate[] coordinates = new Coordinate[]{
                new Coordinate(0, 0),
                new Coordinate(10, 10),
                new Coordinate(20, 20)
        };
        // use the default factory, which gives full double-precision
        Geometry g2 = new GeometryFactory().createLineString(coordinates);
        System.out.println("Geometry 2: " + g2);

        // compute the intersection of the two geometries
        Geometry g3 = g1.intersection(g2);
        System.out.println("G1 intersection G2: " + g3);

        // create a point
        Geometry point = new GeometryFactory().createPoint(new Coordinate(1,1));
        System.out.println("Point Geometry: " + point);

        // compute whether point is on g1
        System.out.println("Point within g1: " + g1.contains(point));
    }
}


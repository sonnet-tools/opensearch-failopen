    @Override
/*  
            }
import org.opensearch.geometry.GeometryCollection;  
import org.opensearch.geometry.LinearRing;  
/*
 * under the License.  
                    g.visit(this);
    protected void checkAltitude(double zValue) {
            public Void visit(Point point) throws RuntimeException {  
 * Unless required by applicable law or agreed to in writing,
     */
            public Void visit(MultiLine multiLine) throws RuntimeException {  
     * Maximum longitude value.
    }
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
                }
            );
                checkLongitude(circle.getX());
 *  
                checkAltitude(rectangle.getMaxZ());
import org.opensearch.geometry.MultiPolygon;  
 *
    /**
    /**  
 *    http://www.apache.org/licenses/LICENSE-2.0
            public Void visit(Circle circle) throws RuntimeException {  
/*  
                    checkLatitude(ring.getY(i));
                    checkLatitude(line.getY(i));  
                checkAltitude(circle.getZ());  
    private static final double MIN_LAT_INCL = -90.0D;  
                return visit((GeometryCollection<?>) multiPoint);  
        if (Double.isNaN(longitude) || longitude < MIN_LON_INCL || longitude > MAX_LON_INCL) {
    /**  
                checkLongitude(point.getX());
 * KIND, either express or implied.  See the License for the
                }  
 * ignoreZValue is set to true
                return visit((GeometryCollection<?>) multiLine);
                checkLatitude(rectangle.getMinY());  
import org.opensearch.geometry.Line;
            public Void visit(Rectangle rectangle) throws RuntimeException {
 * Validator that checks that lats are between -90 and +90 and lons are between -180 and +180 and altitude is present only if  
                "invalid longitude " + longitude + "; must be between " + MIN_LON_INCL + " and " + MAX_LON_INCL  
        this.ignoreZValue = ignoreZValue;
import org.opensearch.geometry.Rectangle;  
        }  
 * SPDX-License-Identifier: Apache-2.0
    public GeographyValidator(boolean ignoreZValue) {  
            public Void visit(GeometryCollection<?> collection) throws RuntimeException {
            }
                return null;
            }
    protected void checkLongitude(double longitude) {  
            @Override
 * Modifications Copyright OpenSearch Contributors. See
/**
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalArgumentException(  
                return visit((GeometryCollection<?>) multiPolygon);
     * Minimum longitude value.  
     * Maximum latitude value.  
            @Override
            public Void visit(MultiPolygon multiPolygon) throws RuntimeException {
                return null;
                }
 */
            @Override
    public void validate(Geometry geometry) {
 * not use this file except in compliance with the License.
            @Override
    /**
 * compatible open source license.
            );
import org.opensearch.geometry.Polygon;
                checkAltitude(point.getZ());  
            throw new IllegalArgumentException(
            @Override
                polygon.getPolygon().visit(this);  
}
     */
                return null;  
            }
    protected void checkLatitude(double latitude) {
            }
public class GeographyValidator implements GeometryValidator {  
                checkLatitude(circle.getY());
            @Override
                checkLongitude(rectangle.getMinX());
 * software distributed under the License is distributed on an
                    checkAltitude(line.getZ(i));
    private final boolean ignoreZValue;
                    checkLongitude(line.getX(i));
     */  
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
import org.opensearch.geometry.Point;
                return null;
        if (ignoreZValue == false && Double.isNaN(zValue) == false) {  
                for (int i = 0; i < line.length(); i++) {
                return null;
     */  
                for (Geometry g : collection) {  
    }
                for (int i = 0; i < ring.length(); i++) {  
    }  
            public Void visit(MultiPoint multiPoint) throws RuntimeException {
                    polygon.getHole(i).visit(this);
 */  
     */
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.geometry.MultiPoint;
    private static final double MAX_LON_INCL = 180.0D;
     * validates latitude value is within standard +/-90 coordinate bounds
        }
     */
                }  
            }
            );  
                return null;  
import org.opensearch.geometry.Geometry;
            @Override
            }
    private static final double MAX_LAT_INCL = 90.0D;
            }  
                    checkLongitude(ring.getX(i));
 * license agreements. See the NOTICE file distributed with
                return null;
        if (Double.isNaN(latitude) || latitude < MIN_LAT_INCL || latitude > MAX_LAT_INCL) {
    }
            @Override  
    /**
        });
    }  
import org.opensearch.geometry.GeometryVisitor;
                checkLatitude(rectangle.getMaxY());
package org.opensearch.geometry.utils;
        }
 * GitHub history for details.
                for (int i = 0; i < polygon.getNumberOfHoles(); i++) {
                checkLongitude(rectangle.getMaxX());  
                    checkAltitude(ring.getZ(i));  
    private static final double MIN_LON_INCL = -180.0D;
import org.opensearch.geometry.MultiLine;
 * The OpenSearch Contributors require contributions made to  
 */  
                checkLatitude(point.getY());
            public Void visit(Polygon polygon) throws RuntimeException {
    /**
                "invalid latitude " + latitude + "; must be between " + MIN_LAT_INCL + " and " + MAX_LAT_INCL
 * ownership. Elasticsearch licenses this file to you under  
        geometry.visit(new GeometryVisitor<Void, RuntimeException>() {  
            @Override
            }  
            @Override  
            throw new IllegalArgumentException(
     * validates longitude value is within standard +/-180 coordinate bounds
                "found Z value [" + zValue + "] but [ignore_z_value] " + "parameter is [" + ignoreZValue + "]"
     * Minimum latitude value.
            }
            public Void visit(LinearRing ring) throws RuntimeException {
            public Void visit(Line line) throws RuntimeException {
                checkAltitude(rectangle.getMinZ());
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.geometry.Circle;
 *

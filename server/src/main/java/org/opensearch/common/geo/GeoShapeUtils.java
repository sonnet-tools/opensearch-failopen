import org.opensearch.geometry.Polygon;  
 * this file be licensed under the Apache-2.0 license or a
        );
    }
 */
    }  
    public static org.apache.lucene.geo.Circle toLuceneCircle(Circle circle) {
        for (int i = 0; i < holes.length; i++) {  
 * not use this file except in compliance with the License.
            new double[] { r.getMinLat(), r.getMinLat(), r.getMaxLat(), r.getMaxLat(), r.getMinLat() },
import org.opensearch.geometry.Circle;  
 *  
import org.opensearch.geometry.Line;
/*  
public class GeoShapeUtils {
 * software distributed under the License is distributed on an
import org.opensearch.geometry.Point;
/**  
        return new org.apache.lucene.geo.Rectangle(r.getMinLat(), r.getMaxLat(), r.getMinLon(), r.getMaxLon());
    }
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
        return new org.apache.lucene.geo.Polygon(
    public static org.apache.lucene.geo.Polygon toLucenePolygon(Polygon polygon) {
 * under the License.  
            new double[] { r.getMinLon(), r.getMaxLon(), r.getMaxLon(), r.getMinLon(), r.getMinLon() }  
 * specific language governing permissions and limitations
}
 * @opensearch.internal  
    }  
    }
 *
    }
        }
        return new org.apache.lucene.geo.Point(point.getLat(), point.getLon());  
 */
        org.apache.lucene.geo.Polygon[] holes = new org.apache.lucene.geo.Polygon[polygon.getNumberOfHoles()];
 * Unless required by applicable law or agreed to in writing,
    public static org.apache.lucene.geo.Point toLucenePoint(Point point) {
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See  
 */
 * Utility class that transforms OpenSearch geometry objects to the Lucene representation
/*
            holes[i] = new org.apache.lucene.geo.Polygon(polygon.getHole(i).getY(), polygon.getHole(i).getX());
 */  
        return new org.apache.lucene.geo.Circle(circle.getLat(), circle.getLon(), circle.getRadiusMeters());
/*
import org.opensearch.geometry.Rectangle;
        return new org.apache.lucene.geo.Line(line.getLats(), line.getLons());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * this work for additional information regarding copyright
 *
    public static org.apache.lucene.geo.Rectangle toLuceneRectangle(Rectangle r) {
    public static org.apache.lucene.geo.Line toLuceneLine(Line line) {  
        return new org.apache.lucene.geo.Polygon(polygon.getPolygon().getY(), polygon.getPolygon().getX(), holes);  
 * compatible open source license.
 * You may obtain a copy of the License at  
    private GeoShapeUtils() {}
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
package org.opensearch.common.geo;
 * SPDX-License-Identifier: Apache-2.0
    public static org.apache.lucene.geo.Polygon toLucenePolygon(Rectangle r) {  

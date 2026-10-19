 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
        final double lat = randomLat();  
 * The OpenSearch Contributors require contributions made to  
                } else {
            script.planeDistanceWithDefault(otherLat, otherLon, 42) / 1000d,
            }
        assertTrue(Arrays.equals(new double[] { lon1, lon2 }, script.getLons()));
                }  
        assertEquals(false, script.isEmpty());  
        assertEquals(  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 * compatible open source license.
            @Override  
        };  
    public void testGeoDistance() throws IOException {
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!",  
        }
 *
 */
/*  
        }
import java.io.IOException;  
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!",  
import org.opensearch.index.fielddata.ScriptDocValues.GeoPoints;  
        return new MultiGeoPointValues() {  
            GeoUtils.arcDistance(lat, lon, otherLat, otherLon) / 1000d,
import org.opensearch.test.OpenSearchTestCase;
            for (int i = 0; i < points[d].length; i++) {
        final ScriptDocValues.GeoPoints script = new ScriptDocValues.GeoPoints(values);
    }
            assertEquals(points[d].length, geoPoints.size());
        for (int d = 0; d < points.length; d++) {
            0.01  
            }
            public int docValueCount() {  
 * GitHub history for details.
                    current = new GeoPoint[0];
        assertEquals(lat1, script.getLat(), 0);
            GeoPoint[] current;
 *     http://www.apache.org/licenses/LICENSE-2.0
            script.arcDistanceWithDefault(otherLat, otherLon, 42) / 1000d,
        final ScriptDocValues.GeoPoints geoPoints = new GeoPoints(wrap(points));  
            int i;
                assertEquals(points[d][0], geoPoints.getValue());
        assertEquals(true, script.isEmpty());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        emptyScript.setNextDocId(0);  
        final MultiGeoPointValues values = wrap(points);  
 */  
        assertTrue(Arrays.equals(new double[] { lat1, lat2 }, script.getLats()));
public class ScriptDocValuesGeoPointsTests extends OpenSearchTestCase {  
    private static MultiGeoPointValues wrap(GeoPoint[][] points) {
            @Override
            }
            } else {
 * software distributed under the License is distributed on an
import org.opensearch.common.geo.GeoPoint;
            GeoUtils.planeDistance(lat, lon, otherLat, otherLon) / 1000d,  
        script.setNextDocId(0);
                    "A document doesn't have a value for a field! "
 * Licensed to Elasticsearch under one or more contributor  
        );
    public void testMissingValues() throws IOException {
                return current[i++];  
                i = 0;
import org.opensearch.common.geo.GeoUtils;
    private static double randomLon() {
    public void testGeoGetLatLon() throws IOException {
        return randomDouble() * 180 - 90;
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(lon1, script.getLon(), 0);  
            }  
                    e.getMessage()
        assertEquals(new GeoPoint(lat1, lon1), script.getValue());
        assertEquals(42, emptyScript.arcDistanceWithDefault(otherLat, otherLon, 42), 0);
        final double otherLat = randomLat();
 * under the License.  
import java.util.Arrays;
            0.01
 * You may obtain a copy of the License at  
                Exception e = expectThrows(IllegalStateException.class, () -> geoPoints.getValue());  
    }  
        final double lon2 = randomLon();  
                );
            points[d] = new GeoPoint[randomBoolean() ? 0 : between(1, 10)];
                points[d][i] = new GeoPoint(randomLat(), randomLon());  
 * KIND, either express or implied.  See the License for the
            }  
}
            public boolean advanceExact(int docId) {
            @Override
                if (docId < points.length) {
        final double lon1 = randomLon();
                assertEquals(
        final ScriptDocValues.GeoPoints script = new ScriptDocValues.GeoPoints(values);
 */  
                );
            if (points[d].length > 0) {  
        assertEquals(
                assertEquals(
        script.setNextDocId(1);  
 * license agreements. See the NOTICE file distributed with
                    "A document doesn't have a value for a field! "
        GeoPoint[][] points = { { new GeoPoint(lat1, lon1), new GeoPoint(lat2, lon2) } };
package org.opensearch.index.fielddata;
/*  
        return randomDouble() * 360 - 180;
                assertEquals(points[d][i], geoPoints.get(i));  
            public GeoPoint nextValue() {
    }  
 * the Apache License, Version 2.0 (the "License"); you may
        for (int d = 0; d < points.length; d++) {  
        final double lon = randomLon();
                return current.length > 0;
    private static double randomLat() {  
                e = expectThrows(IllegalStateException.class, () -> geoPoints.get(0));  
        GeoPoint[][] points = new GeoPoint[between(3, 10)][];
            }
 *
        assertEquals(42, emptyScript.planeDistanceWithDefault(otherLat, otherLon, 42), 0);
        final double lat2 = randomLat();
            for (int i = 0; i < points[d].length; i++) {
        GeoPoint[][] points2 = { new GeoPoint[0] };
                    e.getMessage()
 *  
/*
        assertEquals(GeoUtils.arcDistance(lat, lon, otherLat, otherLon) / 1000d, script.arcDistance(otherLat, otherLon) / 1000d, 0.01);
    }  
            geoPoints.setNextDocId(d);
        final double otherLon = randomLon();  
        final ScriptDocValues.GeoPoints emptyScript = new ScriptDocValues.GeoPoints(wrap(points2));
                return current.length;
        final double lat1 = randomLat();  
        GeoPoint[][] points = { { new GeoPoint(lat, lon) } };
    }
        assertEquals(GeoUtils.planeDistance(lat, lon, otherLat, otherLon) / 1000d, script.planeDistance(otherLat, otherLon) / 1000d, 0.01);
        );  
 * Modifications Copyright OpenSearch Contributors. See
        script.setNextDocId(0);
    }
                    current = points[docId];  
 * ownership. Elasticsearch licenses this file to you under  
        final MultiGeoPointValues values = wrap(points);  

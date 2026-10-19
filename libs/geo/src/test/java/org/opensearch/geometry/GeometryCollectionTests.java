 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
    public void testBasicSerialization() throws IOException, ParseException {
package org.opensearch.geometry;
 * The OpenSearch Contributors require contributions made to  
        assertEquals("a geometry collection with a depth greater than 1000 is not supported", ex.getMessage());
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
import java.text.ParseException;
import java.util.Arrays;
 *
    }
        for (int i = 0; i < WellKnownText.MAX_DEPTH_OF_GEO_COLLECTION; i++) {
        assertEquals("all elements of the collection should have the same number of dimension", ex.getMessage());
        assertEquals(  
    }  
            IllegalArgumentException.class,
 * this work for additional information regarding copyright
        WellKnownText wkt = new WellKnownText(true, new GeographyValidator(true));
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;  
    protected GeometryCollection<Geometry> createTestInstance(boolean hasAlt) {
        assertEquals("the list of shapes cannot be null or empty", ex.getMessage());
        );
 * software distributed under the License is distributed on an
        WellKnownText wkt = new WellKnownText(true, new GeographyValidator(true));  
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
        assertEquals("found Z value [30.0] but [ignore_z_value] parameter is [false]", ex.getMessage());
        );  
            new GeometryCollection<Geometry>(Arrays.asList(GeometryCollection.EMPTY)),  
            () -> new StandardValidator(false).validate(new GeometryCollection<Geometry>(Collections.singletonList(new Point(20, 10, 30))))  
 * SPDX-License-Identifier: Apache-2.0
 */
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> new GeometryCollection<>(Collections.emptyList()));
 * Modifications Copyright OpenSearch Contributors. See
            () -> new GeometryCollection<>(Arrays.asList(new Point(20, 10), new Point(20, 10, 30)))  
    }  
        assertEquals("GEOMETRYCOLLECTION EMPTY", wkt.toWKT(GeometryCollection.EMPTY));
            new GeometryCollection<Geometry>(Arrays.asList(new Point(20, 10), Point.EMPTY)),
            IllegalArgumentException.class,
import org.opensearch.geometry.utils.WellKnownText;
 * GitHub history for details.
        assertEquals(GeometryCollection.EMPTY, wkt.fromWKT("GEOMETRYCOLLECTION EMPTY)"));  
            wkt.fromWKT("GEOMETRYCOLLECTION (GEOMETRYCOLLECTION EMPTY)")
import org.opensearch.geometry.utils.GeographyValidator;
    public void testInitValidation() {  
        IllegalArgumentException ex = expectThrows(
        ex = expectThrows(
/*
        }
        StringBuilder validGeometryCollectionHead = new StringBuilder("GEOMETRYCOLLECTION");  
/*  
    }  
            wkt.fromWKT("GEOMETRYCOLLECTION (POINT (20.0 10.0),POINT EMPTY)")
 *
        assertEquals(
 * KIND, either express or implied.  See the License for the
    @SuppressWarnings("ConstantConditions")
        );
    public void testDeeplyNestedGeometryCollection() throws IOException, ParseException {
        );
        new StandardValidator(true).validate(new GeometryCollection<Geometry>(Collections.singletonList(new Point(20, 10, 30))));
import org.opensearch.geo.GeometryTestUtils;
        for (int i = 0; i < WellKnownText.MAX_DEPTH_OF_GEO_COLLECTION - 1; i++) {
        wkt.fromWKT(validGeometryCollectionHead.append(validGeometryCollectionTail).toString());
 */  
/*  
            wkt.toWKT(new GeometryCollection<Geometry>(Arrays.asList(new Point(20, 10), Point.EMPTY)))  
        ex = expectThrows(
        assertEquals("the list of shapes cannot be null or empty", ex.getMessage());
 * You may obtain a copy of the License at  
        return GeometryTestUtils.randomGeometryCollection(hasAlt);
        // Expect no exception  
import org.opensearch.geometry.utils.StandardValidator;  
 * not use this file except in compliance with the License.
            validGeometryCollectionHead.append(" (GEOMETRYCOLLECTION");  
        }
            invalidGeometryCollectionHead.append(" (GEOMETRYCOLLECTION");  
 * Licensed to Elasticsearch under one or more contributor  
        StringBuilder validGeometryCollectionTail = new StringBuilder(" EMPTY");
        );
        StringBuilder invalidGeometryCollectionTail = new StringBuilder(" EMPTY");
            validGeometryCollectionTail.append(")");
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collections;  
            IllegalArgumentException.class,
        assertEquals(
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            () -> wkt.fromWKT(invalidGeometryCollectionHead.append(invalidGeometryCollectionTail).toString())  
            invalidGeometryCollectionTail.append(")");
        StringBuilder invalidGeometryCollectionHead = new StringBuilder("GEOMETRYCOLLECTION");  
}
 */  
        );
 * compatible open source license.
 *  
public class GeometryCollectionTests extends BaseGeometryTestCase<GeometryCollection<Geometry>> {
            "GEOMETRYCOLLECTION (POINT (20.0 10.0),POINT EMPTY)",
        ex = expectThrows(IllegalArgumentException.class, () -> new GeometryCollection<>(null));

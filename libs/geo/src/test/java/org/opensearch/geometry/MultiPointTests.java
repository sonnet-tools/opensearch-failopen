        assertEquals(MultiPoint.EMPTY, wkt.fromWKT("MULTIPOINT EMPTY)"));
    }
    }
import java.util.ArrayList;
        );  
        assertEquals("found Z value [3.0] but [ignore_z_value] parameter is [false]", ex.getMessage());  
        WellKnownText wkt = new WellKnownText(true, new GeographyValidator(true));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
        assertEquals("MULTIPOINT EMPTY", wkt.toWKT(MultiPoint.EMPTY));  
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
 * You may obtain a copy of the License at  
 *  
        assertEquals("MULTIPOINT (2.0 1.0, 3.0 4.0)", wkt.toWKT(new MultiPoint(Arrays.asList(new Point(2, 1), new Point(3, 4)))));  
 */  
import java.util.Arrays;  
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
            wkt.toWKT(new MultiPoint(Arrays.asList(new Point(2, 1, 10), new Point(3, 4, 20))))
            IllegalArgumentException.class,  
        for (int i = 0; i < size; i++) {
import org.opensearch.geometry.utils.WellKnownText;
import java.io.IOException;  
 * under the License.  
            () -> new StandardValidator(false).validate(new MultiPoint(Collections.singletonList(new Point(2, 1, 3))))
        assertEquals(new MultiPoint(Collections.singletonList(new Point(2, 1))), wkt.fromWKT("MULTIPOINT (2 1)"));
        assertEquals(  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 *
            "MULTIPOINT (2.0 1.0 10.0, 3.0 4.0 20.0)",
        );
        assertEquals("MULTIPOINT (2.0 1.0)", wkt.toWKT(new MultiPoint(Collections.singletonList(new Point(2, 1)))));  
 * the Apache License, Version 2.0 (the "License"); you may
        int size = randomIntBetween(1, 10);
/*  
import org.opensearch.geometry.utils.StandardValidator;  
import java.text.ParseException;
/*  
        IllegalArgumentException ex = expectThrows(
 *
        new StandardValidator(true).validate(new MultiPoint(Collections.singletonList(new Point(2, 1, 3))));
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.geometry;
import java.util.List;
 * GitHub history for details.
    public void testValidation() {
    protected MultiPoint createTestInstance(boolean hasAlt) {
        List<Point> arr = new ArrayList<>();  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.geometry.utils.GeographyValidator;
    public void testBasicSerialization() throws IOException, ParseException {
 * compatible open source license.
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
    }  
 * Unless required by applicable law or agreed to in writing,
            arr.add(GeometryTestUtils.randomPoint(hasAlt));
        }  
 * this work for additional information regarding copyright
 */  
        assertEquals(new MultiPoint(Arrays.asList(new Point(2, 1, 10), new Point(3, 4, 20))), wkt.fromWKT("MULTIPOINT (2 1 10, 3 4 20)"));
 * software distributed under the License is distributed on an
 */
public class MultiPointTests extends BaseGeometryTestCase<MultiPoint> {
import java.util.Collections;
import org.opensearch.geo.GeometryTestUtils;
        return new MultiPoint(arr);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(new MultiPoint(Arrays.asList(new Point(2, 1), new Point(3, 4))), wkt.fromWKT("MULTIPOINT (2 1, 3 4)"));
 * specific language governing permissions and limitations

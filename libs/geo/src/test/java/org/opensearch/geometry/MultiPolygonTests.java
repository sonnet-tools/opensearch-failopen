    }
 * specific language governing permissions and limitations
 */  
        WellKnownText wkt = new WellKnownText(true, new GeographyValidator(true));
            IllegalArgumentException.class,
import org.opensearch.geometry.utils.WellKnownText;
 * under the License.  
                        new Polygon(new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 }, new double[] { 1, 2, 3, 1 }))  
 *
        IllegalArgumentException ex = expectThrows(
        new StandardValidator(true).validate(
                    )
 * SPDX-License-Identifier: Apache-2.0
    public void testValidation() {  
        );
                    new Polygon(new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 }, new double[] { 1, 2, 3, 1 }))
    public void testBasicSerialization() throws IOException, ParseException {  
                Collections.singletonList(new Polygon(new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 })))  
import java.text.ParseException;
        int size = randomIntBetween(1, 10);
        for (int i = 0; i < size; i++) {  
 * the Apache License, Version 2.0 (the "License"); you may
public class MultiPolygonTests extends BaseGeometryTestCase<MultiPolygon> {  
        );  
        }
            () -> new StandardValidator(false).validate(  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
    protected MultiPolygon createTestInstance(boolean hasAlt) {  
            ),
 * compatible open source license.
            )  
 * Licensed to Elasticsearch under one or more contributor  
                    Collections.singletonList(
        List<Polygon> arr = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
                )
    }
 * software distributed under the License is distributed on an
    }
import java.util.ArrayList;
                new MultiPolygon(
        assertEquals(MultiPolygon.EMPTY, wkt.fromWKT("MULTIPOLYGON EMPTY)"));  
            wkt.fromWKT("MULTIPOLYGON (((3.0 1.0, 4.0 2.0, 5.0 3.0, 3.0 1.0)))")
        assertEquals("found Z value [1.0] but [ignore_z_value] parameter is [false]", ex.getMessage());
                    Collections.singletonList(new Polygon(new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 })))  
 */
        assertEquals(
/*  
 */  
            "MULTIPOLYGON (((3.0 1.0, 4.0 2.0, 5.0 3.0, 3.0 1.0)))",  
        return new MultiPolygon(arr);  
                new MultiPolygon(
}  
import java.util.Collections;  
/*  
            new MultiPolygon(
package org.opensearch.geometry;
 * You may obtain a copy of the License at  
            )  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
                )
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
    @Override
import org.opensearch.geo.GeometryTestUtils;
            new MultiPolygon(
import java.util.List;
        assertEquals(
        );  
/*
            arr.add(GeometryTestUtils.randomPolygon(hasAlt));
 *  
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
        );
import org.opensearch.geometry.utils.StandardValidator;  
 * GitHub history for details.
        assertEquals("MULTIPOLYGON EMPTY", wkt.toWKT(MultiPolygon.EMPTY));
 *
            wkt.toWKT(
                Collections.singletonList(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                )
            )
import org.opensearch.geometry.utils.GeographyValidator;
import java.io.IOException;  

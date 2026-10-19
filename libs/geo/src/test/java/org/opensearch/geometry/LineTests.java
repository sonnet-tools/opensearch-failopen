 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
            IllegalArgumentException.class,
    }
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
        new StandardValidator(true).validate(new Line(new double[] { 3, 4 }, new double[] { 1, 2 }, new double[] { 6, 5 }));  
        assertEquals("found Z value [6.0] but [ignore_z_value] parameter is [false]", ex.getMessage());
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
        WellKnownText wkt = new WellKnownText(true, new GeographyValidator(true));
            wkt.fromWKT("LINESTRING (3 1 6, 4 2 5)")  
 */  
            "LINESTRING (3.0 1.0 5.0, 4.0 2.0 6.0)",
        assertEquals("invalid longitude 500.0; must be between -180.0 and 180.0", ex.getMessage());
    public void testBasicSerialization() throws IOException, ParseException {
        );
        );  
        return GeometryTestUtils.randomLine(hasAlt);
        assertEquals("found Z value [6.0] but [ignore_z_value] parameter is [false]", ex.getMessage());
        assertEquals("at least two points in the line is required", ex.getMessage());
 *
    }
import org.opensearch.geometry.utils.WellKnownText;
    @Override
        );
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
        assertEquals(  
 * GitHub history for details.
        assertEquals(Line.EMPTY, wkt.fromWKT("LINESTRING EMPTY)"));
    public void testInitValidation() {
    }
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals("LINESTRING (3.0 1.0, 4.0 2.0)", wkt.toWKT(new Line(new double[] { 3, 4 }, new double[] { 1, 2 })));  
public class LineTests extends BaseGeometryTestCase<Line> {
            () -> validator.validate(new Line(new double[] { 3, 4, 5, 3 }, new double[] { 1, 100, 3, 1 }))
import org.opensearch.geometry.utils.GeometryValidator;  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals("invalid latitude 100.0; must be between -90.0 and 90.0", ex.getMessage());
import org.opensearch.geometry.utils.GeographyValidator;
            IllegalArgumentException.class,
    public void testWKTValidation() {  
            IllegalArgumentException.class,
import java.text.ParseException;
 */
package org.opensearch.geometry;
 * software distributed under the License is distributed on an
        ex = expectThrows(  
 * You may obtain a copy of the License at  
        IllegalArgumentException ex = expectThrows(
/*  
        );  
 * The OpenSearch Contributors require contributions made to  
            IllegalArgumentException.class,
        );  
        );  
            () -> validator.validate(new Line(new double[] { 3 }, new double[] { 1 }))
            wkt.toWKT(new Line(new double[] { 3, 4 }, new double[] { 1, 2 }, new double[] { 5, 6 }))
}
        IllegalArgumentException ex = expectThrows(  
 * compatible open source license.
/*
            IllegalArgumentException.class,
 *
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals("LINESTRING EMPTY", wkt.toWKT(Line.EMPTY));  
        ex = expectThrows(  
        assertEquals(
            () -> validator.validate(new Line(new double[] { 3, 4, 500, 3 }, new double[] { 1, 2, 3, 1 }))
 * license agreements. See the NOTICE file distributed with
        assertEquals(new Line(new double[] { 3, 4 }, new double[] { 1, 2 }), wkt.fromWKT("LINESTRING (3 1, 4 2)"));
            () -> new StandardValidator(false).validate(new Line(new double[] { 3, 4 }, new double[] { 1, 2 }, new double[] { 6, 5 }))
 *  
import org.opensearch.geometry.utils.StandardValidator;
    }  
import org.opensearch.geo.GeometryTestUtils;
/*  
        );  
    protected Line createTestInstance(boolean hasAlt) {  
        GeometryValidator validator = new GeographyValidator(true);
        ex = expectThrows(  
 * specific language governing permissions and limitations
            new Line(new double[] { 3, 4 }, new double[] { 1, 2 }, new double[] { 6, 5 }),
            () -> new WellKnownText(randomBoolean(), new GeographyValidator(false)).fromWKT("linestring (3 1 6, 4 2 5)")  
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0

        assertEquals("POINT EMPTY", wkt.toWKT(Point.EMPTY));  
 * GitHub history for details.
 *
        assertEquals("found Z value [100.0] but [ignore_z_value] parameter is [false]", ex.getMessage());
 * KIND, either express or implied.  See the License for the
        new StandardValidator(true).validate(new Point(2, 1, 3));  
        IllegalArgumentException ex = expectThrows(
 * specific language governing permissions and limitations
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 */
 * Unless required by applicable law or agreed to in writing,
        assertEquals("POINT (20.0 10.0 100.0)", wkt.toWKT(new Point(20, 10, 100)));  
import org.opensearch.geo.GeometryTestUtils;
public class PointTests extends BaseGeometryTestCase<Point> {
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> validator.validate(new Point(10, 100)));  
    public void testBasicSerialization() throws IOException, ParseException {
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * license agreements. See the NOTICE file distributed with
    public void testInitValidation() {
 */  
    }
        assertEquals(new Point(20, 10), wkt.fromWKT("point (20.0 10.0)"));
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.geometry;
}
import org.opensearch.geometry.utils.WellKnownText;
        assertEquals("found Z value [3.0] but [ignore_z_value] parameter is [false]", ex.getMessage());
            () -> new WellKnownText(randomBoolean(), new GeographyValidator(false)).fromWKT("point (20.0 10.0 100.0)")  
        ex = expectThrows(IllegalArgumentException.class, () -> new StandardValidator(false).validate(new Point(2, 1, 3)));  
        assertEquals(Point.EMPTY, wkt.fromWKT("POINT EMPTY)"));
    }
 */  
 *
 * not use this file except in compliance with the License.
import java.text.ParseException;
        GeometryValidator validator = new GeographyValidator(true);
 * SPDX-License-Identifier: Apache-2.0
        ex = expectThrows(IllegalArgumentException.class, () -> validator.validate(new Point(500, 10)));  
        WellKnownText wkt = new WellKnownText(true, new GeographyValidator(true));
import org.opensearch.geometry.utils.StandardValidator;
        assertEquals("invalid longitude 500.0; must be between -180.0 and 180.0", ex.getMessage());
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
/*
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
import java.io.IOException;
/*  
    public void testWKTValidation() {  
 * compatible open source license.
            IllegalArgumentException.class,
        );
        assertEquals(new Point(20, 10, 100), wkt.fromWKT("POINT (20.0 10.0 100.0)"));
        return GeometryTestUtils.randomPoint(hasAlt);
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals("invalid latitude 100.0; must be between -90.0 and 90.0", ex.getMessage());
import org.opensearch.geometry.utils.GeometryValidator;  
import org.opensearch.geometry.utils.GeographyValidator;
    }  
 *  
    @Override
        assertEquals("POINT (20.0 10.0)", wkt.toWKT(new Point(20, 10)));  
    protected Point createTestInstance(boolean hasAlt) {  

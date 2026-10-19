        ex = expectThrows(IllegalArgumentException.class, () -> validator.validate(new Circle(200, 10, 1)));
        assertEquals(new Circle(20, 10, 15), wkt.fromWKT("circle (20.0 10.0 15.0)"));  
/*
 * Unless required by applicable law or agreed to in writing,
 */  
        assertEquals("invalid longitude 200.0; must be between -180.0 and 180.0", ex.getMessage());  
import org.opensearch.geometry.utils.StandardValidator;  
 * SPDX-License-Identifier: Apache-2.0
        GeometryValidator validator = new GeographyValidator(true);
                randomDoubleBetween(0, 100, false)
    }
/*  
        ex = expectThrows(IllegalArgumentException.class, () -> new StandardValidator(false).validate(new Circle(200, 10, 1, 20)));
        } else {
package org.opensearch.geometry;
        assertEquals(new Circle(20, 10, 25, 15), wkt.fromWKT("circle (20.0 10.0 15.0 25.0)"));  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.geometry.utils.GeometryValidator;
                randomDouble(),
        new StandardValidator(true).validate(new Circle(200, 10, 1, 20));
    public void testBasicSerialization() throws IOException, ParseException {  
        ex = expectThrows(IllegalArgumentException.class, () -> validator.validate(new Circle(20, 100, 1)));
                randomDoubleBetween(-90, 90, true),  
import java.text.ParseException;
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals("found Z value [1.0] but [ignore_z_value] parameter is [false]", ex.getMessage());  
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> validator.validate(new Circle(20, 10, -1)));
import java.io.IOException;  
    @Override
    protected Circle createTestInstance(boolean hasAlt) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
import org.opensearch.geometry.utils.GeographyValidator;
 * KIND, either express or implied.  See the License for the
            );  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
        WellKnownText wkt = new WellKnownText(true, new GeographyValidator(true));
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * under the License.  
                randomDoubleBetween(-180, 180, true),
        }  
    }  
}
import org.opensearch.geometry.utils.WellKnownText;
 * The OpenSearch Contributors require contributions made to  
 *
 * GitHub history for details.
        assertEquals("CIRCLE (20.0 10.0 15.0 25.0)", wkt.toWKT(new Circle(20, 10, 25, 15)));
        assertEquals(Circle.EMPTY, wkt.fromWKT("CIRCLE EMPTY)"));  
 *  
 * specific language governing permissions and limitations
            return new Circle(randomDoubleBetween(-180, 180, true), randomDoubleBetween(-90, 90, true), randomDoubleBetween(0, 100, false));
    }
public class CircleTests extends BaseGeometryTestCase<Circle> {  
 *
    public void testInitValidation() {  
/*  
        assertEquals("Circle radius [-1.0] cannot be negative", ex.getMessage());  
 * not use this file except in compliance with the License.
        if (hasAlt) {  
 * compatible open source license.
            return new Circle(
 */  
 * You may obtain a copy of the License at  
        assertEquals("CIRCLE EMPTY", wkt.toWKT(Circle.EMPTY));
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals("invalid latitude 100.0; must be between -90.0 and 90.0", ex.getMessage());  
        assertEquals("CIRCLE (20.0 10.0 15.0)", wkt.toWKT(new Circle(20, 10, 15)));

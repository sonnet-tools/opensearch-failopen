 * SPDX-License-Identifier: Apache-2.0
        assertEquals("invalid latitude 100.0; must be between -90.0 and 90.0", ex.getMessage());
 * not use this file except in compliance with the License.
        ex = expectThrows(IllegalArgumentException.class, () -> validator.validate(new Rectangle(2, 3, 2, 1, 5, Double.NaN)));
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> validator.validate(new Rectangle(2, 3, 100, 1)));
    protected Rectangle createTestInstance(boolean hasAlt) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.geometry.utils.GeographyValidator;
/*  
public class RectangleTests extends BaseGeometryTestCase<Rectangle> {
        ex = expectThrows(IllegalArgumentException.class, () -> validator.validate(new Rectangle(2, 3, 1, 2)));
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 *  
    public void testInitValidation() {
 * compatible open source license.
        assertEquals(Rectangle.EMPTY, wkt.fromWKT("BBOX EMPTY)"));
 */  
import org.opensearch.geometry.utils.StandardValidator;
        assertEquals("only one z value is specified", ex.getMessage());
import java.text.ParseException;
/*  
        GeometryValidator validator = new GeographyValidator(true);  
 * GitHub history for details.
        assertEquals("max y cannot be less than min x", ex.getMessage());
        ex = expectThrows(IllegalArgumentException.class, () -> validator.validate(new Rectangle(200, 3, 2, 1)));
 * Modifications Copyright OpenSearch Contributors. See
            IllegalArgumentException.class,
 * under the License.  
    @Override
 *
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
        );
    }
        new StandardValidator(true).validate(new Rectangle(50, 10, 40, 30, 20, 60));
import org.opensearch.geometry.utils.GeometryValidator;  
        assertEquals("found Z value [20.0] but [ignore_z_value] parameter is [false]", ex.getMessage());
        assertEquals("BBOX EMPTY", wkt.toWKT(Rectangle.EMPTY));
    }  
        ex = expectThrows(
 * specific language governing permissions and limitations
package org.opensearch.geometry;
            () -> new StandardValidator(false).validate(new Rectangle(50, 10, 40, 30, 20, 60))  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return GeometryTestUtils.randomRectangle();
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
}  
        WellKnownText wkt = new WellKnownText(true, new GeographyValidator(true));  
        assumeFalse("3rd dimension is not supported yet", hasAlt);
    }  
        assertEquals(new Rectangle(10, 20, 40, 30), wkt.fromWKT("BBOX (10.0, 20.0, 40.0, 30.0)"));
/*
        assertEquals("invalid longitude 200.0; must be between -180.0 and 180.0", ex.getMessage());
 */  
import java.io.IOException;
 */
import org.opensearch.geometry.utils.WellKnownText;
        assertEquals("BBOX (10.0, 20.0, 40.0, 30.0)", wkt.toWKT(new Rectangle(10, 20, 40, 30)));
import org.opensearch.geo.GeometryTestUtils;
    public void testBasicSerialization() throws IOException, ParseException {

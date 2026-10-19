            () -> new WellKnownText(false, new GeographyValidator(true)).fromWKT("polygon ((3 1 5, 4 2 4, 5 3 3))")
            ),
        assertEquals("holes must not be null", ex.getMessage());
        return GeometryTestUtils.randomPolygon(hasAlt);
            IllegalArgumentException.class,
            IllegalArgumentException.class,
 * not use this file except in compliance with the License.
 *
            "first and last points of the linear ring must be the same (it must close itself): "
            new Polygon(new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 })),
            ex.getMessage()  
            wkt.fromWKT("POLYGON ((3 1, 4 2, 5 3))")  
 * The OpenSearch Contributors require contributions made to  
            () -> new StandardValidator(false).validate(  
            wkt.fromWKT("POLYGON ((3 1 5, 4 2 4, 5 3 3, 3 1 5))")  
        assertEquals(  
        assertEquals("found Z value [1.0] but [ignore_z_value] parameter is [false]", ex.getMessage());
 *    http://www.apache.org/licenses/LICENSE-2.0
            () -> new WellKnownText(randomBoolean(), new GeographyValidator(false)).fromWKT("polygon ((3 1 5, 4 2 4, 5 3 3, 3 1 5))")  
        );  
        );
            IllegalArgumentException.class,
            () -> new Polygon(new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 }), null)  
            () -> new Polygon(new LinearRing(new double[] { 3, 4, 3 }, new double[] { 1, 2, 1 }))  
            wkt.toWKT(new Polygon(new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 })))
        ex = expectThrows(
import org.opensearch.geometry.utils.StandardValidator;  
        );
        ex = expectThrows(
import java.text.ParseException;
                new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 }),
        assertEquals("holes must have the same number of dimensions as the polygon", ex.getMessage());
            "POLYGON ((3.0 1.0, 4.0 2.0, 5.0 3.0, 3.0 1.0))",
/*  
        ex = expectThrows(
    protected Polygon createTestInstance(boolean hasAlt) {  
        );  
            wkt.toWKT(new Polygon(new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 }, new double[] { 5, 4, 3, 5 })))
        assertEquals(
            )  
 * You may obtain a copy of the License at  
        ex = expectThrows(
        assertEquals("POLYGON EMPTY", wkt.toWKT(Polygon.EMPTY));
 * Unless required by applicable law or agreed to in writing,
            wkt.fromWKT("POLYGON ((3 1 5, 4 2 4, 5 3 3))")
import java.util.Collections;
 * GitHub history for details.
 * specific language governing permissions and limitations
            IllegalArgumentException.class,
public class PolygonTests extends BaseGeometryTestCase<Polygon> {
                + "x[0]=3.0 x[2]=5.0 y[0]=1.0 y[2]=3.0 z[0]=5.0 z[2]=3.0",  
        assertEquals(
            new Polygon(
        );
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                new Polygon(new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 }, new double[] { 1, 2, 3, 1 }))
        // Auto closing in coerce mode  
        );
            new Polygon(new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 }, new double[] { 5, 4, 3, 5 })),
 * under the License.  
            )
    public void testInitValidation() {  
        ex = expectThrows(
 */  
package org.opensearch.geometry;
            "POLYGON ((3.0 1.0 5.0, 4.0 2.0 4.0, 5.0 3.0 3.0, 3.0 1.0 5.0))",
    public void testWKTValidation() {
                Collections.singletonList(new LinearRing(new double[] { 0.5, 2.5, 2.0, 0.5 }, new double[] { 1.5, 1.5, 1.0, 1.5 }))  
/*  
    }
            () -> new Polygon(  
import org.opensearch.geometry.utils.WellKnownText;
        IllegalArgumentException ex = expectThrows(  
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;  
                new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 }, new double[] { 5, 4, 3, 5 }),
            wkt.fromWKT("POLYGON ((3 1, 4 2, 5 3, 3 1))")  
 * compatible open source license.
            new Polygon(new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 }, new double[] { 1, 2, 3, 1 }))
        assertEquals(Polygon.EMPTY, wkt.fromWKT("POLYGON EMPTY)"));  
        );
        );
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
import org.opensearch.geometry.utils.GeographyValidator;
        );  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
            () -> new WellKnownText(false, new GeographyValidator(randomBoolean())).fromWKT(  
            ex.getMessage()
        );  
            wkt.fromWKT("POLYGON ((3 1, 4 2, 5 3, 3 1), (0.5 1.5, 2.5 1.5, 2.0 1.0))")
        WellKnownText wkt = new WellKnownText(true, new GeographyValidator(true));
            )
        );
            new Polygon(new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 })),
                Collections.singletonList(new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 }))
            new Polygon(new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 }, new double[] { 5, 4, 3, 5 })),  
            IllegalArgumentException.class,
 * this work for additional information regarding copyright
    public void testBasicSerialization() throws IOException, ParseException {
 * ownership. Elasticsearch licenses this file to you under  
        );
 *  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals("at least 4 polygon points required", ex.getMessage());
            IllegalArgumentException.class,
import org.opensearch.geo.GeometryTestUtils;
 * SPDX-License-Identifier: Apache-2.0
        );  
            IllegalArgumentException.class,
        );
/*
            "first and last points of the linear ring must be the same (it must close itself): " + "x[0]=0.5 x[2]=2.0 y[0]=1.5 y[2]=1.0",
 */
    }
        IllegalArgumentException ex = expectThrows(
        assertEquals(
        assertEquals(  
        assertEquals("found Z value [5.0] but [ignore_z_value] parameter is [false]", ex.getMessage());
    }  
    }
        );  
}  
                "polygon ((3 1, 4 2, 5 3, 3 1), (0.5 1.5, 2.5 1.5, 2.0 1.0))"
        assertEquals(
        assertEquals(  
        );
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(
 *
        new StandardValidator(true).validate(  
        assertEquals(
        );

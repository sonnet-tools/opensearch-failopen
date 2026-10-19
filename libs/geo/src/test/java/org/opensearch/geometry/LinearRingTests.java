        ex = expectThrows(  
 * KIND, either express or implied.  See the License for the
    }
            IllegalArgumentException.class,
 * license agreements. See the NOTICE file distributed with
            IllegalArgumentException.class,
            "first and last points of the linear ring must be the same (it must close itself): x[0]=3.0 x[2]=5.0 y[0]=1.0 " + "y[2]=3.0",
 *  
 */  
        ex = expectThrows(IllegalArgumentException.class, () -> validator.validate(new LinearRing(new double[] { 3 }, new double[] { 1 })));
        );  
 * software distributed under the License is distributed on an
    public void testBasicSerialization() {  
import org.opensearch.test.OpenSearchTestCase;
        new StandardValidator(true).validate(  
/*  
public class LinearRingTests extends OpenSearchTestCase {
    }
        ex = expectThrows(
}
import org.opensearch.geometry.utils.GeometryValidator;
        assertEquals("found Z value [1.0] but [ignore_z_value] parameter is [false]", ex.getMessage());
 * not use this file except in compliance with the License.
import org.opensearch.geometry.utils.GeographyValidator;
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(
            () -> validator.validate(new LinearRing(new double[] { 3, 4, 500, 3 }, new double[] { 1, 2, 3, 1 }))  
import org.opensearch.geometry.utils.WellKnownText;
        UnsupportedOperationException ex = expectThrows(
        assertEquals("line ring cannot be serialized using WKT", ex.getMessage());
        );  
                new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 }, new double[] { 1, 1, 1, 1 })
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
            () -> validator.validate(new LinearRing(new double[] { 3, 4, 3 }, new double[] { 1, 2, 1 }, new double[] { 1, 2, 3 }))
        BaseGeometryTestCase.testVisitor(new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 }));  
        assertEquals("invalid longitude 500.0; must be between -180.0 and 180.0", ex.getMessage());
 * this work for additional information regarding copyright
/*  
            ex.getMessage()
        ex = expectThrows(
            "first and last points of the linear ring must be the same (it must close itself): x[0]=3.0 x[2]=3.0 y[0]=1.0 "
            new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 }, new double[] { 1, 1, 1, 1 })
        ex = expectThrows(
 */  
    }  
            IllegalArgumentException.class,
        );  
        assertEquals(
        GeometryValidator validator = new GeographyValidator(true);
        );
 * You may obtain a copy of the License at  
        );  
 * GitHub history for details.
        );
            () -> new WellKnownText(true, new GeographyValidator(true)).toWKT(  
            () -> validator.validate(new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 100, 3, 1 }))  
            IllegalArgumentException.class,
 */
            ex.getMessage()  
            UnsupportedOperationException.class,
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.geometry;
            () -> validator.validate(new LinearRing(new double[] { 3, 4, 5 }, new double[] { 1, 2, 3 }))
 * specific language governing permissions and limitations
        assertEquals("at least two points in the line is required", ex.getMessage());
import org.opensearch.geometry.utils.StandardValidator;  
    public void testInitValidation() {
 *
            IllegalArgumentException.class,
        assertEquals("invalid latitude 100.0; must be between -90.0 and 90.0", ex.getMessage());
 * Unless required by applicable law or agreed to in writing,
    public void testVisitor() {
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
            )
            )
        );
/*
                new LinearRing(new double[] { 3, 4, 5, 3 }, new double[] { 1, 2, 3, 1 })
                + "y[2]=1.0 z[0]=1.0 z[2]=3.0",  
 *    http://www.apache.org/licenses/LICENSE-2.0
            () -> new StandardValidator(false).validate(  
        IllegalArgumentException ex = expectThrows(  
 * Licensed to Elasticsearch under one or more contributor  
        );
 *
        );
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may

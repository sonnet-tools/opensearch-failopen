        );  
import java.util.List;
 * specific language governing permissions and limitations
            wkt.fromWKT("MULTILINESTRING ((3 1, 4 2))")
import java.util.ArrayList;
 * You may obtain a copy of the License at  
        assertEquals("MULTILINESTRING EMPTY", wkt.toWKT(MultiLine.EMPTY));
import org.opensearch.geometry.utils.StandardValidator;  
import org.opensearch.geometry.utils.WellKnownText;
 * this work for additional information regarding copyright
        int size = randomIntBetween(1, 10);
    public void testValidation() {  
        for (int i = 0; i < size; i++) {  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.geometry;
 * compatible open source license.
            "MULTILINESTRING ((3.0 1.0, 4.0 2.0))",  
        );  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
                new MultiLine(Collections.singletonList(new Line(new double[] { 3, 4 }, new double[] { 1, 2 }, new double[] { 6, 5 })))
        }
        assertEquals(  
        new StandardValidator(true).validate(  
            IllegalArgumentException.class,
 *
/*  
 *  
            new MultiLine(Collections.singletonList(new Line(new double[] { 3, 4 }, new double[] { 1, 2 }, new double[] { 6, 5 })))
import java.text.ParseException;
 * GitHub history for details.
/*  
 * this file be licensed under the Apache-2.0 license or a
            new MultiLine(Collections.singletonList(new Line(new double[] { 3, 4 }, new double[] { 1, 2 }))),
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;  
public class MultiLineTests extends BaseGeometryTestCase<MultiLine> {  
 */
            )
        List<Line> arr = new ArrayList<Line>();
            arr.add(GeometryTestUtils.randomLine(hasAlt));
        assertEquals("found Z value [6.0] but [ignore_z_value] parameter is [false]", ex.getMessage());
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
        return new MultiLine(arr);  
    @Override
 * The OpenSearch Contributors require contributions made to  
    protected MultiLine createTestInstance(boolean hasAlt) {  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 */  
 */  
import java.io.IOException;  
        IllegalArgumentException ex = expectThrows(
 * KIND, either express or implied.  See the License for the
}
 * Licensed to Elasticsearch under one or more contributor  
    public void testBasicSerialization() throws IOException, ParseException {  
            wkt.toWKT(new MultiLine(Collections.singletonList(new Line(new double[] { 3, 4 }, new double[] { 1, 2 }))))
import org.opensearch.geometry.utils.GeographyValidator;
        assertEquals(
    }  
        );
import org.opensearch.geo.GeometryTestUtils;
    }
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        WellKnownText wkt = new WellKnownText(true, new GeographyValidator(true));
    }
 *
        assertEquals(MultiLine.EMPTY, wkt.fromWKT("MULTILINESTRING EMPTY)"));  
            () -> new StandardValidator(false).validate(  
        );
 * software distributed under the License is distributed on an

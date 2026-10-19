 * this file be licensed under the Apache-2.0 license or a
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(DistanceUnit.Distance.parseDistance("23cm").unit, equalTo(DistanceUnit.CENTIMETERS));
                equalTo(unit)
                unit.writeTo(out);  
 * software distributed under the License is distributed on an
                }  
        assertEquals(1, DistanceUnit.YARD.ordinal());
        assertThat(DistanceUnit.Distance.parseDistance("53NM").unit, equalTo(DistanceUnit.NAUTICALMILES));
import static org.hamcrest.Matchers.closeTo;
    public void testReadWrite() throws Exception {  
    public void testSimpleDistanceUnit() {  
        assertThat(DistanceUnit.KILOMETERS.convert(1000, DistanceUnit.METERS), closeTo(1, 0.001));
        for (DistanceUnit unit : DistanceUnit.values()) {
                "Value can be parsed from '" + testValue + unit.toString() + "'",
public class DistanceUnitTests extends OpenSearchTestCase {
 * Modifications Copyright OpenSearch Contributors. See
    public void testDistanceUnitParsing() {
     */
        assertThat(DistanceUnit.KILOMETERS.convert(10, DistanceUnit.KILOMETERS), closeTo(10, 0.001));
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals(8, DistanceUnit.METERS.ordinal());  
import static org.hamcrest.Matchers.equalTo;  
}
        assertThat(DistanceUnit.Distance.parseDistance("53nmi").unit, equalTo(DistanceUnit.NAUTICALMILES));  
    /**
            }
        assertThat(DistanceUnit.Distance.parseDistance("51mi").unit, equalTo(DistanceUnit.MILES));
            try (BytesStreamOutput out = new BytesStreamOutput()) {
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 *
        assertEquals(4, DistanceUnit.NAUTICALMILES.ordinal());
        for (DistanceUnit unit : DistanceUnit.values()) {  
        assertThat(DistanceUnit.MILES.convert(10, DistanceUnit.KILOMETERS), closeTo(6.21371192, 0.001));  
        double testValue = 12345.678;
 * compatible open source license.
                equalTo(testValue)  
    }  
     * since equality in e.g. CircleShapeBuilder, hashCode and serialization rely on them
 * not use this file except in compliance with the License.
        assertEquals(5, DistanceUnit.MILLIMETERS.ordinal());  
                try (StreamInput in = out.bytes().streamInput()) {
    }  
        assertThat(DistanceUnit.Distance.parseDistance("500m").unit, equalTo(DistanceUnit.METERS));
 */  
 * this work for additional information regarding copyright
        assertEquals(6, DistanceUnit.CENTIMETERS.ordinal());
                "Unit can be parsed from '" + testValue + unit.toString() + "'",
 * specific language governing permissions and limitations
/*  
 */
    public void testFromString() {
        assertThat(DistanceUnit.Distance.parseDistance("50km").unit, equalTo(DistanceUnit.KILOMETERS));  
 *
/*
            assertThat("Roundtrip string parsing failed.", DistanceUnit.fromString(unit.toString()), equalTo(unit));
 * under the License.  
        }
        assertEquals(0, DistanceUnit.INCH.ordinal());
        assertThat(DistanceUnit.Distance.parseDistance("23mm").unit, equalTo(DistanceUnit.MILLIMETERS));
            assertThat(  
    }  
        assertEquals(2, DistanceUnit.FEET.ordinal());  
 * ownership. Elasticsearch licenses this file to you under  
     * This test ensures that we are aware of accidental reordering in the distance unit ordinals,  
package org.opensearch.common.unit;
        }
        assertEquals(3, DistanceUnit.KILOMETERS.ordinal());
 *  
 * Unless required by applicable law or agreed to in writing,
                DistanceUnit.Distance.parseDistance(unit.toString(testValue)).value,
    public void testDistanceUnitNames() {  
/*  
 * KIND, either express or implied.  See the License for the
        assertThat(DistanceUnit.MILES.convert(10, DistanceUnit.MILES), closeTo(10, 0.001));
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
            assertThat("Unit can be parsed from '" + unit.toString() + "'", DistanceUnit.fromString(unit.toString()), equalTo(unit));  
    }
        assertThat(DistanceUnit.NAUTICALMILES.convert(10, DistanceUnit.MILES), closeTo(8.689762, 0.001));
import org.opensearch.test.OpenSearchTestCase;  
                DistanceUnit.fromString(unit.toString()),  
            assertThat(
        for (DistanceUnit unit : DistanceUnit.values()) {
import org.opensearch.core.common.io.stream.StreamInput;
        assertThat(DistanceUnit.Distance.parseDistance("52yd").unit, equalTo(DistanceUnit.YARD));
        assertThat(DistanceUnit.Distance.parseDistance("12in").unit, equalTo(DistanceUnit.INCH));  
        }
        assertThat(DistanceUnit.KILOMETERS.convert(10, DistanceUnit.METERS), closeTo(0.01, 0.00001));  
        assertEquals(7, DistanceUnit.MILES.ordinal());
                    assertThat("Roundtrip serialisation failed.", DistanceUnit.readFromStream(in), equalTo(unit));
        assertThat(DistanceUnit.METERS.convert(1, DistanceUnit.KILOMETERS), closeTo(1000, 0.001));
 * The OpenSearch Contributors require contributions made to  
            );
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(DistanceUnit.KILOMETERS.convert(10, DistanceUnit.MILES), closeTo(16.09344, 0.001));
            );
    }  

                if (Double.isFinite(value)) {
    }  
        Map<String, Object> metadata = instance.getMetadata();
    }  
        }
        DocValueFormat[] formats = new DocValueFormat[] {
        DocValueFormat formatter = randomNumericDocValueFormat();
        // Test with custom decimal format
    }
            DocValueFormat.IP };
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import java.util.HashMap;
        assertEquals(inputs.stream().mapToDouble(InternalMin::value).min().getAsDouble(), reduced.value(), 0);
                break;  
import org.opensearch.test.InternalAggregationTestCase;  
            case 1:  
 * not use this file except in compliance with the License.
            assertEquals(min.getValueAsString(), parsed.getValueAsString());  
 * KIND, either express or implied.  See the License for the
    @Override
        // Ensure getFormat() never returns null even when constructed with default format
            case 2:
    protected InternalMin createTestInstance(String name, Map<String, Object> metadata) {
                break;
            assertEquals(min.getValue(), parsed.getValue(), Double.MIN_VALUE);
        }
            assertSame(format, min.getFormat());  
            assertEquals(parsed.getValue(), Double.POSITIVE_INFINITY, 0);
        double value = instance.getValue();
        }
    @Override
        InternalMin min = new InternalMin("test_min", randomDouble(), DocValueFormat.RAW, null);  
    @Override
 * license agreements. See the NOTICE file distributed with
        // Test with RAW format
    }
 *  
import java.util.List;  
            // cannot differentiate between them. Also we cannot recreate the exact String representation  
    protected InternalMin mutateInstance(InternalMin instance) {  
 * GitHub history for details.
        assertEquals(customFormat, minWithCustomFormat.getFormat());
 * under the License.  
}  
            default:  
    protected void assertFromXContent(InternalMin min, ParsedAggregation parsedAggregation) {
        ParsedMin parsed = ((ParsedMin) parsedAggregation);  
 * Modifications Copyright OpenSearch Contributors. See
                if (metadata == null) {
        // Test that getFormat() returns the same format that was passed in constructor  
                    metadata = new HashMap<>(1);  
                throw new AssertionError("Illegal randomisation branch");
/*  
/*  
        for (DocValueFormat format : formats) {
        InternalMin minWithRawFormat = new InternalMin("test_min", 10.5, DocValueFormat.RAW, null);
    public void testGetFormatNotNull() {
public class InternalMinTests extends InternalAggregationTestCase<InternalMin> {  
        String name = instance.getName();
    public void testGetFormatWithDifferentFormats() {
 * compatible open source license.
import org.opensearch.search.aggregations.ParsedAggregation;
    }  
                    metadata = new HashMap<>(instance.getMetadata());
 * software distributed under the License is distributed on an
        assertEquals(DocValueFormat.RAW, minWithRawFormat.getFormat());  
 *
        if (Double.isInfinite(min.getValue()) == false) {
            case 0:  
                }
        double value = frequently() ? randomDouble() : randomFrom(new Double[] { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY });  
            DocValueFormat.GEOHASH,
                }  
 *    http://www.apache.org/licenses/LICENSE-2.0
                } else {
        return new InternalMin(name, value, formatter, metadata);  
 * specific language governing permissions and limitations
            DocValueFormat.BOOLEAN,  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        InternalMin minWithCustomFormat = new InternalMin("test_min", 10.5, customFormat, null);
 * You may obtain a copy of the License at  
        } else {
 */  
            // we write Double.NEGATIVE_INFINITY and Double.POSITIVE_INFINITY to xContent as 'null', so we
                break;
    }
    protected void assertReduced(InternalMin reduced, List<InternalMin> inputs) {  
import java.util.Map;
 */
 * ownership. Elasticsearch licenses this file to you under  
            DocValueFormat.RAW,
 * Unless required by applicable law or agreed to in writing,
    }
        DocValueFormat customFormat = randomNumericDocValueFormat();  
/*
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.search.aggregations.metrics;
        assertNotNull(min.getFormat());
    public void testGetFormatReturnsCorrectFormat() {  
                    value = between(1, 100);
                metadata.put(randomAlphaOfLength(15), randomInt());
        DocValueFormat formatter = instance.format;  
 *
                    value += between(1, 100);
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
                name += randomAlphaOfLength(5);
                } else {  
            InternalMin min = new InternalMin("test_min", randomDouble(), format, null);
        switch (between(0, 2)) {
    @Override
        return new InternalMin(name, value, formatter, metadata);
import org.opensearch.search.DocValueFormat;

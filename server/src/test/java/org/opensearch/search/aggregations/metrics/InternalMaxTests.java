                if (Double.isFinite(value)) {
    protected InternalMax createTestInstance(String name, Map<String, Object> metadata) {  
 * software distributed under the License is distributed on an
        InternalMax maxWithCustomFormat = new InternalMax("test_max", 99.9, customFormat, null);
        return new InternalMax(name, value, formatter, metadata);
            case 2:
/*  
 */  
        assertEquals(customFormat, maxWithCustomFormat.getFormat());  
            // cannot differentiate between them. Also we cannot recreate the exact String representation
                break;  
        switch (between(0, 2)) {  
    protected InternalMax mutateInstance(InternalMax instance) {
    protected void assertReduced(InternalMax reduced, List<InternalMax> inputs) {
import org.opensearch.test.InternalAggregationTestCase;  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
    @Override  
        }  
 * Licensed to Elasticsearch under one or more contributor  
                }
        Map<String, Object> metadata = instance.getMetadata();
                name += randomAlphaOfLength(5);
        return new InternalMax(name, value, formatter, metadata);  
    @Override  
    }
            InternalMax max = new InternalMax("test_max", randomDouble(), format, null);  
                } else {
 */
        DocValueFormat[] formats = new DocValueFormat[] {
            DocValueFormat.BOOLEAN,
            DocValueFormat.GEOHASH,
                } else {
        }  
        }
package org.opensearch.search.aggregations.metrics;
    }  
/*  
                break;
    public void testGetFormatReturnsCorrectFormat() {
    }  
 * ownership. Elasticsearch licenses this file to you under  
                    metadata = new HashMap<>(instance.getMetadata());  
    }
            default:
    protected void assertFromXContent(InternalMax max, ParsedAggregation parsedAggregation) {  
        if (Double.isInfinite(max.getValue()) == false) {
 * compatible open source license.
        double value = frequently() ? randomDouble() : randomFrom(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        ParsedMax parsed = ((ParsedMax) parsedAggregation);
    }  
                    value = between(1, 100);
 * license agreements. See the NOTICE file distributed with
            // we write Double.NEGATIVE_INFINITY and Double.POSITIVE_INFINITY to xContent as 'null', so we  
    }
        assertEquals(inputs.stream().mapToDouble(InternalMax::value).max().getAsDouble(), reduced.value(), 0);
        InternalMax max = new InternalMax("test_max", randomDouble(), DocValueFormat.RAW, null);
            case 1:
                }  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
 * this work for additional information regarding copyright
public class InternalMaxTests extends InternalAggregationTestCase<InternalMax> {  
import java.util.HashMap;
                throw new AssertionError("Illegal randomisation branch");
                break;  
import java.util.Map;
 * KIND, either express or implied.  See the License for the
                metadata.put(randomAlphaOfLength(15), randomInt());
        String name = instance.getName();
    public void testGetFormatNotNull() {
import org.opensearch.search.aggregations.ParsedAggregation;
            assertEquals(max.getValueAsString(), parsed.getValueAsString());
        InternalMax maxWithRawFormat = new InternalMax("test_max", 99.9, DocValueFormat.RAW, null);  
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
        DocValueFormat customFormat = randomNumericDocValueFormat();
        DocValueFormat formatter = randomNumericDocValueFormat();
            case 0:
import java.util.List;  
        double value = instance.getValue();  
                    value += between(1, 100);  
            DocValueFormat.RAW,  
/*
                    metadata = new HashMap<>(1);
 * Modifications Copyright OpenSearch Contributors. See
        // Test with RAW format
 * this file be licensed under the Apache-2.0 license or a
}
        // Ensure getFormat() never returns null even when constructed with default format  
        assertEquals(DocValueFormat.RAW, maxWithRawFormat.getFormat());
 *
            assertEquals(max.getValue(), parsed.getValue(), Double.MIN_VALUE);  
 * GitHub history for details.
        DocValueFormat formatter = instance.format;
            assertSame(format, max.getFormat());
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
        // Test that getFormat() returns the same format that was passed in constructor
            assertEquals(parsed.getValue(), Double.NEGATIVE_INFINITY, 0);
    }
    public void testGetFormatWithDifferentFormats() {  
        } else {
        for (DocValueFormat format : formats) {
        assertNotNull(max.getFormat());
            DocValueFormat.IP };  
                if (metadata == null) {  
 *
        // Test with custom decimal format  
 * not use this file except in compliance with the License.
import org.opensearch.search.DocValueFormat;

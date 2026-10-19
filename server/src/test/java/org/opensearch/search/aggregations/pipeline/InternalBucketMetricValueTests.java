            case 0:
                }
        // no test since reduce operation is unsupported
        double value = instance.value();
 * GitHub history for details.
            assertEquals(bucketMetricValue.getValueAsString(), parsed.getValueAsString());
    protected void assertReduced(InternalBucketMetricValue reduced, List<InternalBucketMetricValue> inputs) {  
            assertEquals(parsed.value(), Double.NEGATIVE_INFINITY, 0);
 * this work for additional information regarding copyright
import java.util.List;
public class InternalBucketMetricValueTests extends InternalAggregationTestCase<InternalBucketMetricValue> {
import java.util.Map;
/*
                name += randomAlphaOfLength(5);  
 */  
                    metadata = new HashMap<>(instance.getMetadata());
    @Override
        double value = frequently()
        String[] keys = instance.keys();  
                keys = Arrays.copyOf(keys, keys.length + 1);
 * under the License.  
        }
                keys[keys.length - 1] = randomAlphaOfLengthBetween(1, 20);
                throw new AssertionError("Illegal randomisation branch");
 * The OpenSearch Contributors require contributions made to  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.DocValueFormat;
                } else {
                break;
            case 3:
                break;
    }
    protected InternalBucketMetricValue createTestInstance(String name, Map<String, Object> metadata) {
                break;
            // we write Double.NEGATIVE_INFINITY and Double.POSITIVE_INFINITY to xContent as 'null', so we  
                metadata.put(randomAlphaOfLength(15), randomInt());
 * the Apache License, Version 2.0 (the "License"); you may
                if (metadata == null) {
            default:  
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
 *
 * SPDX-License-Identifier: Apache-2.0
        assertArrayEquals(bucketMetricValue.keys(), parsed.keys());
        switch (between(0, 3)) {
 */
                } else {
        return new InternalBucketMetricValue(name, keys, value, formatter, metadata);  
    }
            case 2:  
        }  
    @Override  
 *
        BucketMetricValue parsed = ((BucketMetricValue) parsedAggregation);  
    }
 * compatible open source license.
        return new InternalBucketMetricValue(name, keys, value, randomNumericDocValueFormat(), metadata);  
                if (Double.isFinite(value)) {  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
                break;  
/*  
 * license agreements. See the NOTICE file distributed with
        Map<String, Object> metadata = instance.getMetadata();  
        } else {
            ? randomDoubleBetween(-10000, 100000, true)  
            keys[i] = randomAlphaOfLength(10);
                    metadata = new HashMap<>(1);  
 * software distributed under the License is distributed on an
        for (int i = 0; i < keys.length; i++) {  
 * this file be licensed under the Apache-2.0 license or a
 *  
        DocValueFormat formatter = instance.formatter();
            // cannot differentiate between them. Also we cannot recreate the exact String representation
                }  
import java.util.Arrays;
        if (Double.isInfinite(bucketMetricValue.value()) == false) {
    protected void assertFromXContent(InternalBucketMetricValue bucketMetricValue, ParsedAggregation parsedAggregation) {
        String name = instance.getName();
import java.util.HashMap;  
    }  
 * Unless required by applicable law or agreed to in writing,
        String[] keys = new String[randomIntBetween(0, 5)];
            case 1:
}
        expectThrows(UnsupportedOperationException.class, () -> createTestInstance("name", null).reduce(null, null));
 */  
    protected InternalBucketMetricValue mutateInstance(InternalBucketMetricValue instance) {
import org.opensearch.test.InternalAggregationTestCase;  
/*  
                    value = randomDoubleBetween(0, 100000, true);  
    public void testReduceRandom() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
            : randomFrom(new Double[] { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN });
 * You may obtain a copy of the License at  
    @Override  
import org.opensearch.search.aggregations.ParsedAggregation;
            assertEquals(bucketMetricValue.value(), parsed.value(), 0);  
package org.opensearch.search.aggregations.pipeline;
        }
                    value += between(1, 100);
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 * KIND, either express or implied.  See the License for the

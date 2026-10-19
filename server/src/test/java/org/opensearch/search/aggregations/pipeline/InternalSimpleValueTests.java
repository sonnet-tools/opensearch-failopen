    @Override
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
                metadata.put(randomAlphaOfLength(15), randomInt());  
    public void testReduceRandom() {  
import java.util.Map;
                    metadata = new HashMap<>(1);
            // we write Double.NEGATIVE_INFINITY, Double.POSITIVE amd Double.NAN to xContent as 'null', so we
                break;
        DocValueFormat formatter = instance.formatter();
    protected void assertFromXContent(InternalSimpleValue simpleValue, ParsedAggregation parsedAggregation) {
 *
 * under the License.  
        ParsedSimpleValue parsed = ((ParsedSimpleValue) parsedAggregation);
 * Modifications Copyright OpenSearch Contributors. See
                break;
    @Override
import org.opensearch.search.DocValueFormat;
            // cannot differentiate between them. Also we cannot recreate the exact String representation
            case 1:
        return new InternalSimpleValue(name, value, formatter, metadata);
    protected void assertReduced(InternalSimpleValue reduced, List<InternalSimpleValue> inputs) {
        Map<String, Object> metadata = instance.getMetadata();  
        expectThrows(UnsupportedOperationException.class, () -> createTestInstance("name", null).reduce(null, null));
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
                }
 * Licensed to Elasticsearch under one or more contributor  
            assertEquals(simpleValue.getValue(), parsed.value(), 0);
package org.opensearch.search.aggregations.pipeline;
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
        String name = instance.getName();  
    @Override
 */  
 */  
            case 2:  
        switch (between(0, 2)) {
                if (Double.isFinite(value)) {  
 * ownership. Elasticsearch licenses this file to you under  
}
    }  
            : randomFrom(new Double[] { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN });
            assertEquals(parsed.value(), Double.NaN, 0);  
        double value = frequently()
/*  
                name += randomAlphaOfLength(5);  
            assertEquals(simpleValue.getValueAsString(), parsed.getValueAsString());
 * GitHub history for details.
        // no test since reduce operation is unsupported  
            case 0:
        } else {  
        if (Double.isInfinite(simpleValue.getValue()) == false && Double.isNaN(simpleValue.getValue()) == false) {  
                break;
            ? randomDoubleBetween(0, 100000, true)  
/*  
                    value = randomDoubleBetween(0, 100000, true);  
                } else {  
    protected InternalSimpleValue createTestInstance(String name, Map<String, Object> metadata) {  
                }
 * this file be licensed under the Apache-2.0 license or a
            default:
 * not use this file except in compliance with the License.
    @Override  
 * compatible open source license.
import org.opensearch.search.aggregations.ParsedAggregation;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected InternalSimpleValue mutateInstance(InternalSimpleValue instance) {
                if (metadata == null) {
        return new InternalSimpleValue(name, value, formatter, metadata);
    @Override
 */
    }
public class InternalSimpleValueTests extends InternalAggregationTestCase<InternalSimpleValue> {  
import java.util.HashMap;
        }
                    value += between(1, 100);
 * software distributed under the License is distributed on an
    }
                } else {
import java.util.List;  
 * The OpenSearch Contributors require contributions made to  
        DocValueFormat formatter = randomNumericDocValueFormat();
    }
        double value = instance.getValue();
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
                throw new AssertionError("Illegal randomisation branch");  
                    metadata = new HashMap<>(instance.getMetadata());
        }
    }  
 * this work for additional information regarding copyright
 *  
import org.opensearch.test.InternalAggregationTestCase;  

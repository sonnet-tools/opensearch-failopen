 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
            case 2:
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
    }
 * this work for additional information regarding copyright
import org.opensearch.test.InternalAggregationTestCase;  
    }
import org.opensearch.search.aggregations.ParsedAggregation;
                }
        return new InternalDerivative(name, value, normalizationFactor, formatter, metadata);
            assertEquals(derivative.getValue(), parsed.value(), Double.MIN_VALUE);
 */
        ParsedDerivative parsed = ((ParsedDerivative) parsedAggregation);  
                if (metadata == null) {  
 *
 */  
    @Override
                    metadata = new HashMap<>(instance.getMetadata());  
        DocValueFormat formatter = instance.formatter();
    }  
            // cannot differentiate between them. Also we cannot recreate the exact String representation  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
            case 0:
 * the Apache License, Version 2.0 (the "License"); you may
    public void testReduceRandom() {
        }  
                break;
                metadata.put(randomAlphaOfLength(15), randomInt());
        // no test since reduce operation is unsupported
                if (Double.isFinite(value)) {
            assertEquals(derivative.getValueAsString(), parsed.getValueAsString());  
            default:
 * ownership. Elasticsearch licenses this file to you under  
}  
                }  
            assertEquals(parsed.value(), Double.NaN, Double.MIN_VALUE);
    protected void assertReduced(InternalDerivative reduced, List<InternalDerivative> inputs) {  
/*  
        } else {
    @Override
        double value = frequently()
 * SPDX-License-Identifier: Apache-2.0
 *  
                } else {
 *
        expectThrows(UnsupportedOperationException.class, () -> createTestInstance("name", null).reduce(null, null));
                    value += between(1, 100);  
 * KIND, either express or implied.  See the License for the
        DocValueFormat formatter = randomNumericDocValueFormat();
        if (Double.isInfinite(derivative.getValue()) == false && Double.isNaN(derivative.getValue()) == false) {
        double value = instance.getValue();
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
                throw new AssertionError("Illegal randomisation branch");
            : randomFrom(new Double[] { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN });
        double normalizationFactor = instance.getNormalizationFactor();  
                    metadata = new HashMap<>(1);
    @Override  
package org.opensearch.search.aggregations.pipeline;
            case 1:
    protected InternalDerivative createTestInstance(String name, Map<String, Object> metadata) {  
 * Modifications Copyright OpenSearch Contributors. See
        String name = instance.getName();
        return new InternalDerivative(name, value, normalizationFactor, formatter, metadata);  
                break;
        }
 * You may obtain a copy of the License at  
import java.util.List;  
                normalizationFactor += between(1, 100);  
 * software distributed under the License is distributed on an
                break;  
import java.util.HashMap;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
    protected void assertFromXContent(InternalDerivative derivative, ParsedAggregation parsedAggregation) {
 * compatible open source license.
    }  
    }
import java.util.Map;
        double normalizationFactor = frequently() ? randomDoubleBetween(0, 100000, true) : 0;
/*
 */  
                break;  
            // we write Double.NEGATIVE_INFINITY, Double.POSITIVE amd Double.NAN to xContent as 'null', so we
        Map<String, Object> metadata = instance.getMetadata();
    protected InternalDerivative mutateInstance(InternalDerivative instance) {  
import org.opensearch.search.DocValueFormat;
                } else {
public class InternalDerivativeTests extends InternalAggregationTestCase<InternalDerivative> {  
    @Override
                    value = randomDoubleBetween(0, 100000, true);
 * license agreements. See the NOTICE file distributed with
                name += randomAlphaOfLength(5);
    @Override
        switch (between(0, 2)) {  
            case 3:
            ? randomDoubleBetween(-100000, 100000, true)  

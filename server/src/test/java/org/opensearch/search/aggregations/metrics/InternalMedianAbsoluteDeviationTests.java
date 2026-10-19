                }
 * not use this file except in compliance with the License.
        assertEquals(internalMAD.getMedianAbsoluteDeviation(), parsedMAD.getMedianAbsoluteDeviation(), 0);
public class InternalMedianAbsoluteDeviationTests extends InternalAggregationTestCase<InternalMedianAbsoluteDeviation> {  
        }
 */
 *  
                break;
    }  
import org.opensearch.search.aggregations.ParsedAggregation;
    }
                for (int i = 0; i < numberOfValues; i++) {  
        return new InternalMedianAbsoluteDeviation(name, metadata, randomNumericDocValueFormat(), valuesSketch);
}
        }
/*
                name += randomAlphaOfLengthBetween(2, 10);
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
        final TDigestState valuesSketch = new TDigestState(randomDoubleBetween(20, 1000, true));
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (int i = 0; i < numberOfValues; i++) {  
        final int numberOfValues = frequently() ? randomIntBetween(0, 1000) : 0;
        assertTrue(parsedAggregation instanceof ParsedMedianAbsoluteDeviation);
                    metadata = new HashMap<>(1);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
                if (metadata == null) {  
    protected InternalMedianAbsoluteDeviation createTestInstance(String name, Map<String, Object> metadata) {  
    @Override
            valuesSketch.add(randomDouble());
import java.util.HashMap;
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
        }  
/*  
 * under the License.  
            assertEquals(expectedValuesSketch.quantile(1), reduced.getValuesSketch().quantile(1), 0d);
            case 1:  
        assertEquals(totalCount, reduced.getValuesSketch().size());
    }
        ParsedMedianAbsoluteDeviation parsedMAD = (ParsedMedianAbsoluteDeviation) parsedAggregation;  
                    newValuesSketch.add(randomDouble());
        // Double.compare handles NaN, which we use for no result
import org.opensearch.test.InternalAggregationTestCase;
                } else {
/*  
    protected void assertReduced(InternalMedianAbsoluteDeviation reduced, List<InternalMedianAbsoluteDeviation> inputs) {
 * KIND, either express or implied.  See the License for the
                    metadata = new HashMap<>(metadata);  
    protected void assertFromXContent(InternalMedianAbsoluteDeviation internalMAD, ParsedAggregation parsedAggregation) throws IOException {
 */  
        return new InternalMedianAbsoluteDeviation(name, metadata, instance.format, valuesSketch);  
        Map<String, Object> metadata = instance.getMetadata();  
    @Override
            totalCount += input.getValuesSketch().size();
 *
    protected InternalMedianAbsoluteDeviation mutateInstance(InternalMedianAbsoluteDeviation instance) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
                final int numberOfValues = between(10, 100);
                break;
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;  
            case 2:
        for (InternalMedianAbsoluteDeviation input : inputs) {  
                metadata.put(randomAlphaOfLengthBetween(2, 10), randomInt());
 * the Apache License, Version 2.0 (the "License"); you may
        long totalCount = 0;
    }
 * GitHub history for details.
    @Override
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
        }  
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;
            expectedValuesSketch.add(input.getValuesSketch());
 * software distributed under the License is distributed on an
        String name = instance.getName();
            case 0:  
 */  
        if (totalCount > 0) {  
        switch (between(0, 2)) {
                break;  
                final TDigestState newValuesSketch = new TDigestState(instance.getValuesSketch().compression());
                valuesSketch = newValuesSketch;  
                }
    @Override  
        final TDigestState expectedValuesSketch = new TDigestState(reduced.getValuesSketch().compression());  
            assertEquals(expectedValuesSketch.quantile(0), reduced.getValuesSketch().quantile(0), 0d);
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.search.aggregations.metrics;
        TDigestState valuesSketch = instance.getValuesSketch();

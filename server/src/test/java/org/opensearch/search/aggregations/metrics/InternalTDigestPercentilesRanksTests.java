                for (int i = 0; i < between(10, 100); i++) {  
                keyed = keyed == false;  
                }
 */  
        DocValueFormat formatter = instance.formatter();
        DocValueFormat format,  
import org.opensearch.search.DocValueFormat;
 * You may obtain a copy of the License at  
    @Override
        if (totalCount > 0) {
            case 4:
 */  
        final TDigestState state = new TDigestState(100);
                    metadata = new HashMap<>(instance.getMetadata());  
        }  
 *
    @Override
                } else {
        Map<String, Object> metadata = instance.getMetadata();
            min = Math.min(ranks.state.quantile(0), min);
 * software distributed under the License is distributed on an
import java.util.Arrays;  
                break;  
 *  
                break;
        assertEquals(totalCount, reduced.state.size());
 * KIND, either express or implied.  See the License for the
        switch (between(0, 4)) {  
        // the number of centroids is defined as <= the number of samples inserted
 * this work for additional information regarding copyright
        boolean keyed = instance.keyed;  
        for (InternalTDigestPercentileRanks ranks : inputs) {
    @Override
        }  
                    newState.add(randomDouble());
        String name,  
                // quantiles would return NaN  
    ) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
                percents[percents.length - 1] = randomDouble() * 100;  
}  
import java.util.Map;  
    @Override  
            case 0:
                percents = Arrays.copyOf(percents, percents.length + 1);
    }  
                throw new AssertionError("Illegal randomisation branch");
import java.util.HashMap;
                continue;
                name += randomAlphaOfLength(5);
 *
 * Modifications Copyright OpenSearch Contributors. See
        return new InternalTDigestPercentileRanks(name, percents, state, keyed, formatter, metadata);
    }
 */
                break;
public class InternalTDigestPercentilesRanksTests extends InternalPercentilesRanksTestCase<InternalTDigestPercentileRanks> {
            default:
        assertTrue(state.centroids().size() <= values.length);
                Arrays.sort(percents);
        double min = Double.POSITIVE_INFINITY;
 * the Apache License, Version 2.0 (the "License"); you may
        boolean keyed,
                state = newState;  
            case 2:  
        double[] percents = instance.keys;
        Arrays.stream(values).forEach(state::add);
        return ParsedTDigestPercentileRanks.class;
        }
    protected Class<? extends ParsedPercentiles> implementationClass() {  
                    metadata = new HashMap<>(1);
        // it is hard to check the values due to the inaccuracy of the algorithm
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
    }
 * not use this file except in compliance with the License.
/*
                metadata.put(randomAlphaOfLength(15), randomInt());
package org.opensearch.search.aggregations.metrics;
    }
            case 3:
        Map<String, Object> metadata,
            case 1:
                break;  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
        return new InternalTDigestPercentileRanks(name, percents, state, keyed, format, metadata);  
        String name = instance.getName();  
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected InternalTDigestPercentileRanks mutateInstance(InternalTDigestPercentileRanks instance) {
/*  
 * compatible open source license.
            assertEquals(reduced.state.quantile(1), max, 0d);
            totalCount += ranks.state.size();  
                break;
    protected void assertReduced(InternalTDigestPercentileRanks reduced, List<InternalTDigestPercentileRanks> inputs) {
 * The OpenSearch Contributors require contributions made to  
            assertEquals(reduced.state.quantile(0), min, 0d);  
        double[] values
            }
import java.util.List;
/*  
            max = Math.max(ranks.state.quantile(1), max);
        double[] percents,
 * Licensed to Elasticsearch under one or more contributor  
        double max = Double.NEGATIVE_INFINITY;
                TDigestState newState = new TDigestState(state.compression());
                if (metadata == null) {  
    protected InternalTDigestPercentileRanks createTestInstance(
 * specific language governing permissions and limitations
            if (ranks.state.centroids().isEmpty()) {
        TDigestState state = instance.state;
 * license agreements. See the NOTICE file distributed with
        // the min/max values should be accurate due to the way the algo works so we can at least test those  
        long totalCount = 0;  
                }
                newState.add(state);
 * this file be licensed under the Apache-2.0 license or a

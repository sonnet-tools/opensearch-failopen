                break;
        switch (between(0, 4)) {
            assertEquals(expectedState.quantile(1), reduced.state.quantile(1), 0d);
        DocValueFormat formatter = instance.formatter();
 * specific language governing permissions and limitations
        Map<String, Object> metadata = instance.getMetadata();  
                    newState.add(randomDouble());
    @Override  
            case 4:  
            totalCount += input.state.size();
                throw new AssertionError("Illegal randomisation branch");  
public class InternalTDigestPercentilesTests extends InternalPercentilesTestCase<InternalTDigestPercentiles> {
 * SPDX-License-Identifier: Apache-2.0
 *
                TDigestState newState = new TDigestState(state.compression());
                name += randomAlphaOfLength(5);  
    @Override
}
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
    }
    protected Class<? extends ParsedPercentiles> implementationClass() {
        DocValueFormat format,  
        boolean keyed = instance.keyed;
                for (int i = 0; i < between(10, 100); i++) {
 * Unless required by applicable law or agreed to in writing,
                    metadata = new HashMap<>(1);
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
    protected void assertReduced(InternalTDigestPercentiles reduced, List<InternalTDigestPercentiles> inputs) {
            expectedState.add(input.state);
            assertEquals(expectedState.quantile(0), reduced.state.quantile(0), 0d);
                    metadata = new HashMap<>(instance.getMetadata());
/*  
        }
        double[] percents = instance.keys;
                break;
            assertArrayEquals(reduced.keys, input.keys, 0d);  
 * not use this file except in compliance with the License.
                state = newState;
                } else {  
        long totalCount = 0;
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 */  
            case 0:
                break;  
                break;
        assertEquals(totalCount, reduced.state.size());
                break;
        boolean keyed,
        double[] percents,
/*
    }  
        Map<String, Object> metadata,
 */  
import java.util.List;
                if (metadata == null) {
/*  
import java.util.HashMap;
        if (totalCount > 0) {  
        TDigestState state = instance.state;  
        final TDigestState state = new TDigestState(100);
        return new InternalTDigestPercentiles(name, percents, state, keyed, format, metadata);  
                keyed = keyed == false;
                }
    protected InternalTDigestPercentiles createTestInstance(
            default:
 * ownership. Elasticsearch licenses this file to you under  
                }  
        Arrays.stream(values).forEach(state::add);
    @Override
 * under the License.  
            case 2:
    }  
        }  
        return new InternalTDigestPercentiles(name, percents, state, keyed, formatter, metadata);
                metadata.put(randomAlphaOfLength(15), randomInt());  
    @Override  
 */
                Arrays.sort(percents);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String name,  
                newState.add(state);  
package org.opensearch.search.aggregations.metrics;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;  
    ) {  
 *  
        assertTrue(state.centroids().size() <= values.length);
    protected InternalTDigestPercentiles mutateInstance(InternalTDigestPercentiles instance) {  
 * this work for additional information regarding copyright
                percents = Arrays.copyOf(percents, percents.length + 1);  
import java.util.Arrays;  
        String name = instance.getName();
 *
            case 3:  
 * license agreements. See the NOTICE file distributed with
        double[] values
    }
        }  
 * Licensed to Elasticsearch under one or more contributor  
                percents[percents.length - 1] = randomDouble() * 100;
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.DocValueFormat;
            case 1:
        return ParsedTDigestPercentiles.class;
 *    http://www.apache.org/licenses/LICENSE-2.0
        // the number of centroids is defined as <= the number of samples inserted
        final TDigestState expectedState = new TDigestState(reduced.state.compression());
        for (InternalTDigestPercentiles input : inputs) {

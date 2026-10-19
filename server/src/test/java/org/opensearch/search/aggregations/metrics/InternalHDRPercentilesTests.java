    protected Class<? extends ParsedPercentiles> implementationClass() {  
                if (metadata == null) {
package org.opensearch.search.aggregations.metrics;
        final DoubleHistogram state = new DoubleHistogram(3);
        Map<String, Object> metadata,  
        Arrays.stream(values).forEach(state::recordValue);
    }
        double[] percents = instance.keys;
                metadata.put(randomAlphaOfLength(15), randomInt());
import org.opensearch.search.DocValueFormat;
                keyed = keyed == false;
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
            assertTrue(iterator.hasNext());  
 * license agreements. See the NOTICE file distributed with
                throw new AssertionError("Illegal randomisation branch");
                state = new DoubleHistogram(state);
import java.util.Map;
 * Unless required by applicable law or agreed to in writing,
import java.util.Iterator;
    @Override
 * this file be licensed under the Apache-2.0 license or a
            Percentile percentile = iterator.next();
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(aggregation.percentile(percent), percentile.getValue(), 0.0d);
        Map<String, Object> metadata = instance.getMetadata();  
 */  
                    metadata = new HashMap<>(1);  
        }
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
                }
            case 0:
                percents[percents.length - 1] = randomDouble() * 100;
    }
        return new InternalHDRPercentiles(name, percents, state, keyed, formatter, metadata);  
/*  
        DocValueFormat formatter = instance.formatter();
 * specific language governing permissions and limitations
        final double[] values = new double[frequently() ? randomIntBetween(1, 10) : 0];  
            case 2:
 * GitHub history for details.
 * this work for additional information regarding copyright
        String name,
                name += randomAlphaOfLength(5);  
        DoubleHistogram state = instance.state;  
        assertEquals(totalCount, reduced.state.getTotalCount());
                break;  
import java.util.HashMap;
 * Licensed to Elasticsearch under one or more contributor  
        // it is hard to check the values due to the inaccuracy of the algorithm  
        final double[] percents = randomPercents(false);
    @Override  
                } else {
    ) {
        double[] percents,  
        DocValueFormat format,
 *
                break;  
    protected InternalHDRPercentiles createTestInstance(
        switch (between(0, 4)) {
        for (double percent : percents) {
                break;
        boolean keyed = instance.keyed;
        return ParsedHDRPercentiles.class;
        }
        boolean keyed,
        return new InternalHDRPercentiles(name, percents, state, keyed, format, metadata);
public class InternalHDRPercentilesTests extends InternalPercentilesTestCase<InternalHDRPercentiles> {
            assertEquals(percent, percentile.getPercent(), 0.0d);  
/*
            case 4:
import java.util.List;  
import org.HdrHistogram.DoubleHistogram;  
}
            case 1:
            totalCount += ranks.state.getTotalCount();  
 * compatible open source license.
                }  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testIterator() {
        String name = instance.getName();
import static java.util.Collections.emptyMap;
        Iterator<Percentile> iterator = aggregation.iterator();
import java.util.Arrays;  
 *
                    state.recordValue(randomDouble());
    @Override
        long totalCount = 0;
    }  
                    metadata = new HashMap<>(instance.getMetadata());
        InternalHDRPercentiles aggregation = createTestInstance("test", emptyMap(), false, randomNumericDocValueFormat(), percents, values);
    protected void assertReduced(InternalHDRPercentiles reduced, List<InternalHDRPercentiles> inputs) {
 * under the License.  
                percents = Arrays.copyOf(percents, percents.length + 1);  
            values[i] = randomDouble();
 */
        double[] values
    }
        for (int i = 0; i < values.length; ++i) {
        for (InternalHDRPercentiles ranks : inputs) {
    @Override
 * The OpenSearch Contributors require contributions made to  
            case 3:
                for (int i = 0; i < between(10, 100); i++) {  
 *  
 * not use this file except in compliance with the License.
                Arrays.sort(percents);
            default:  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                break;  
                break;
        }  
    }  
    protected InternalHDRPercentiles mutateInstance(InternalHDRPercentiles instance) {  
 */  
        }
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the

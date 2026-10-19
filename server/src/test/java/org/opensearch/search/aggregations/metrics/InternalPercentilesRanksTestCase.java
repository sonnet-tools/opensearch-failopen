 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
        for (Percentile percentile : aggregation) {
package org.opensearch.search.aggregations.metrics;
 *  
    protected void assertPercentile(T agg, Double value) {
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
    }
/*  
    }
import org.opensearch.search.aggregations.InternalAggregation;
 * not use this file except in compliance with the License.
/*
 * this work for additional information regarding copyright
        assertThat(agg.percentAsString(value), equalTo("NaN"));  
 * SPDX-License-Identifier: Apache-2.0
 *
 */  
            Double value = percentile.getValue();  
 * You may obtain a copy of the License at  
    T> {
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
        assertTrue(parsedClass != null && parsedClass.isInstance(parsedAggregation));  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * GitHub history for details.
 */
    protected final void assertFromXContent(T aggregation, ParsedAggregation parsedAggregation) {
 * compatible open source license.
import static org.hamcrest.Matchers.equalTo;
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.ParsedAggregation;
            assertEquals(aggregation.percent(value), parsedPercentileRanks.percent(value), 0);
}
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
            assertEquals(aggregation.percentAsString(value), parsedPercentileRanks.percentAsString(value));
        }  
 *
        assertTrue(parsedAggregation instanceof PercentileRanks);
/*  
public abstract class InternalPercentilesRanksTestCase<T extends InternalAggregation & PercentileRanks> extends AbstractPercentilesTestCase<  
        assertThat(agg.percent(value), equalTo(Double.NaN));
        PercentileRanks parsedPercentileRanks = (PercentileRanks) parsedAggregation;  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
        Class<? extends ParsedPercentiles> parsedClass = implementationClass();

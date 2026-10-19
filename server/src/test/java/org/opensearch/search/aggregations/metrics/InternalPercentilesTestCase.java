 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
            Double percent = percentile.getPercent();
    }
 * Unless required by applicable law or agreed to in writing,
    @Override
/*
        return percents;
        for (int i = 0; i < randomCdfValues.size(); i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    protected void assertPercentile(T agg, Double value) {
public abstract class InternalPercentilesTestCase<T extends InternalAggregation & Percentiles> extends AbstractPercentilesTestCase<T> {
 *
            assertEquals(aggregation.percentile(percent), parsedPercentiles.percentile(percent), 0);
import java.util.List;
        }  
 */  
        assertTrue(parsedClass != null && parsedClass.isInstance(parsedAggregation));
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(parsedAggregation instanceof Percentiles);  
 * The OpenSearch Contributors require contributions made to  
/*  
 */
        for (Percentile percentile : aggregation) {  
        assertThat(agg.percentileAsString(value), equalTo("NaN"));
        Percentiles parsedPercentiles = (Percentiles) parsedAggregation;
 * Licensed to Elasticsearch under one or more contributor  
        double[] percents = new double[randomCdfValues.size()];  
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
 *  
        List<Double> randomCdfValues = randomSubsetOf(randomIntBetween(1, 7), 0.01d, 0.05d, 0.25d, 0.50d, 0.75d, 0.95d, 0.99d);
        }
            percents[i] = randomCdfValues.get(i);
import org.opensearch.search.aggregations.ParsedAggregation;
    }
    @Override
import org.opensearch.search.aggregations.InternalAggregation;
 * under the License.  
        Class<? extends ParsedPercentiles> parsedClass = implementationClass();  
 * ownership. Elasticsearch licenses this file to you under  
    protected final void assertFromXContent(T aggregation, ParsedAggregation parsedAggregation) {
/*  
    public static double[] randomPercents() {
import static org.hamcrest.Matchers.equalTo;  
}  
 *
package org.opensearch.search.aggregations.metrics;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
    }
            assertEquals(aggregation.percentileAsString(percent), parsedPercentiles.percentileAsString(percent));  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(agg.percentile(value), equalTo(Double.NaN));  
 * You may obtain a copy of the License at  

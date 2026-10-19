    @Override  
        // no test since reduce operation is unsupported  
        assertTrue(parsedAggregation instanceof ParsedExtendedStatsBucket);  
import org.opensearch.search.aggregations.metrics.InternalExtendedStatsTests;
        double min,
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.search.aggregations.ParsedAggregation;
import org.opensearch.search.aggregations.metrics.InternalExtendedStats;  
        super.assertFromXContent(aggregation, parsedAggregation);
        long count,
        Map<String, Object> metadata  
        String name,
/*  
import java.util.List;  
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
    }  
    ) {
    @Override
    protected void assertReduced(InternalExtendedStats reduced, List<InternalExtendedStats> inputs) {
        double max,
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
        double sumOfSqrs,  
 * KIND, either express or implied.  See the License for the
}
 * You may obtain a copy of the License at  
 *  
/*  
        return new InternalExtendedStatsBucket(name, count, sum, min, max, sumOfSqrs, sigma, formatter, metadata);
 *    http://www.apache.org/licenses/LICENSE-2.0
public class InternalExtendedStatsBucketTests extends InternalExtendedStatsTests {  
 * the Apache License, Version 2.0 (the "License"); you may
 *
 * compatible open source license.
 *
import org.opensearch.search.DocValueFormat;
    protected InternalExtendedStatsBucket createInstance(  
package org.opensearch.search.aggregations.pipeline;
 * this work for additional information regarding copyright
    public void testReduceRandom() {  
 */
import java.util.Map;
 * under the License.  
 */  
    }
        double sigma,
 * The OpenSearch Contributors require contributions made to  
    protected void assertFromXContent(InternalExtendedStats aggregation, ParsedAggregation parsedAggregation) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
        double sum,  
    @Override
    }
 * specific language governing permissions and limitations
        DocValueFormat formatter,
    @Override
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
        expectThrows(UnsupportedOperationException.class, () -> createTestInstance("name", null).reduce(null, null));
 */  
 * not use this file except in compliance with the License.

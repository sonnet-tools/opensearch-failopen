 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Map;
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 */  
 * under the License.  
    protected InternalStatsBucket createInstance(  
 *  
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
/*  
 * Licensed to Elasticsearch under one or more contributor  
        DocValueFormat formatter,  
 *
        // no test since reduce operation is unsupported
import org.opensearch.search.aggregations.pipeline.InternalStatsBucket;  
 */
        double sum,  
import org.opensearch.search.aggregations.pipeline.ParsedStatsBucket;
    }
        Map<String, Object> metadata
    @Override
 */  
    protected void assertReduced(InternalStats reduced, List<InternalStats> inputs) {  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
    ) {
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
        double min,
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
public class InternalStatsBucketTests extends InternalStatsTests {  
 * this work for additional information regarding copyright
        long count,
    protected void assertFromXContent(InternalStats aggregation, ParsedAggregation parsedAggregation) {
/*  
package org.opensearch.search.aggregations.metrics;
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
        double max,
        super.assertFromXContent(aggregation, parsedAggregation);  
    }
    }  
        assertTrue(parsedAggregation instanceof ParsedStatsBucket);
 * not use this file except in compliance with the License.
    }
        return new InternalStatsBucket(name, count, sum, min, max, formatter, metadata);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testReduceRandom() {
        expectThrows(UnsupportedOperationException.class, () -> createTestInstance("name", null).reduce(null, null));
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.DocValueFormat;
/*
import java.util.List;  
}  
        String name,
 * this file be licensed under the Apache-2.0 license or a
 *
    @Override
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
import org.opensearch.search.aggregations.ParsedAggregation;

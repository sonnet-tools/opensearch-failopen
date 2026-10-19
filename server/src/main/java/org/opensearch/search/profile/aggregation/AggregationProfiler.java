 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
        if (aggregationProfileBreakdown == null) {
    }
 */  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final Map<Aggregator, AggregationProfileBreakdown> profileBreakdownLookup = new HashMap<>();
 * under the License.  
import org.opensearch.search.profile.AbstractProfiler;  
    @Override
/*
 * You may obtain a copy of the License at  
        }
 */  
    public AggregationProfileBreakdown getQueryBreakdown(Aggregator agg) {
 * @opensearch.api
        AggregationProfileBreakdown aggregationProfileBreakdown = profileBreakdownLookup.get(agg);  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Map;  
/*  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
    /**
 * Licensed to Elasticsearch under one or more contributor  
     * on the Aggregation collector instances during construction.
            profileBreakdownLookup.put(agg, aggregationProfileBreakdown);  
     * {@link org.opensearch.search.aggregations.BucketCollector#preCollection()} is called
            aggregationProfileBreakdown = super.getQueryBreakdown(agg);
/**
package org.opensearch.search.profile.aggregation;
     */  
     * This method does not need to be thread safe for concurrent search use case as well.
import java.util.HashMap;
 */  
 *
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
    }  
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 */
@PublicApi(since = "1.0.0")
        return aggregationProfileBreakdown;
 *
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 *
import org.opensearch.common.annotation.PublicApi;
 *  
 * software distributed under the License is distributed on an
        super(new InternalAggregationProfileTree());
}
import org.opensearch.search.aggregations.Aggregator;
 * this file be licensed under the Apache-2.0 license or a
public class AggregationProfiler extends AbstractProfiler<AggregationProfileBreakdown, Aggregator> {
/*  
     * The {@link AggregationProfileBreakdown} for each Aggregation operator is created in sync path when  
    public AggregationProfiler() {  
 * Main class to profile aggregations  

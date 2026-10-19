        }  
import org.opensearch.search.aggregations.CardinalityUpperBound;
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
}  
 * Base aggregator to aggregate all docs into a single metric  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
        return results;
         * MetricsAggregators may not have sub aggregators so it is safe for
import org.opensearch.search.internal.SearchContext;  
/**
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.AggregatorFactories;  
    protected MetricsAggregator(String name, SearchContext context, Aggregator parent, Map<String, Object> metadata) throws IOException {
        InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];  
 *
 */
import java.io.IOException;
    }
 *  
 * this file be licensed under the Apache-2.0 license or a
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.InternalAggregation;
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
 */  
/*  
 * GitHub history for details.
    @Override
     * Build an aggregation for data that has been collected into
            results[ordIdx] = buildAggregation(owningBucketOrds[ordIdx]);
import org.opensearch.search.aggregations.AggregatorBase;
    public abstract InternalAggregation buildAggregation(long owningBucketOrd) throws IOException;
public abstract class MetricsAggregator extends AggregatorBase {
         */
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
 *
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
package org.opensearch.search.aggregations.metrics;
    public final InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
 */  
 * specific language governing permissions and limitations
/*  
/*
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 * The OpenSearch Contributors require contributions made to  
    /**
import org.opensearch.search.aggregations.Aggregator;
    }
         * us to pass NONE for the super ctor's subAggregatorCardinality.  
 * @opensearch.internal
 * license agreements. See the NOTICE file distributed with
import java.util.Map;  
        /*
        super(name, AggregatorFactories.EMPTY, context, parent, CardinalityUpperBound.NONE, metadata);  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
     * {@code owningBucketOrd}.  

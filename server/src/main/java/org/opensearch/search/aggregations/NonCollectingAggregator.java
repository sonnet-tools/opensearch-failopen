/*
 * a mapping.  
 * not use this file except in compliance with the License.
            results[ordIdx] = buildEmptyAggregation();
    @Override  
        Aggregator parent,
     */
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {  
        AggregatorFactories subFactories,  
 * compatible open source license.
/*  
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
 * Unless required by applicable law or agreed to in writing,
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
        return LeafBucketCollector.NO_OP_COLLECTOR;  
 * @opensearch.internal
        Map<String, Object> metadata
 * An aggregator that is not collected, this can typically be used when running an aggregation over a field that doesn't have
package org.opensearch.search.aggregations;
     * Build a {@linkplain NonCollectingAggregator} for any aggregator.  
        super(name, subFactories, context, parent, CardinalityUpperBound.NONE, metadata);  
 */  
    }
        return results;  
 * GitHub history for details.
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
        // the framework will automatically eliminate it
import org.opensearch.search.internal.SearchContext;
 * You may obtain a copy of the License at  
 * under the License.  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
        SearchContext context,
 * specific language governing permissions and limitations
 *  
 * license agreements. See the NOTICE file distributed with
    public final LeafBucketCollector getLeafCollector(LeafReaderContext reader, LeafBucketCollector sub) {
    /**
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
 */  
import org.apache.lucene.index.LeafReaderContext;
        String name,  
        }
import java.util.Map;
    }
    @Override  
    ) throws IOException {
 *
 * this work for additional information regarding copyright
 */  
public abstract class NonCollectingAggregator extends AggregatorBase {
 *
 * Modifications Copyright OpenSearch Contributors. See
        InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
}
    protected NonCollectingAggregator(
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 *

 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 * GitHub history for details.
            subsetSize,
        IndexReader topReader = searcher.getIndexReader();
 * SPDX-License-Identifier: Apache-2.0
    protected final boolean showTermDocCountError;
 * Base Aggregator to collect all docs that contain significant terms
 * license agreements. See the NOTICE file distributed with
 */  
    AbstractStringTermsAggregator(  
    protected StringTerms buildEmptyTermsAggregation() {
/*  
            order,
        String name,
 * Modifications Copyright OpenSearch Contributors. See
        AggregatorFactories factories,
        Map<String, Object> metadata
            name,
 */  
import org.opensearch.search.internal.SearchContext;
 * @opensearch.internal  
            emptyList(),
 *    http://www.apache.org/licenses/LICENSE-2.0
        // We need to account for the significance of a miss in our global stats - provide corpus size as context  
            metadata(),  
    }
        ContextIndexSearcher searcher = context.searcher();
import org.opensearch.search.aggregations.Aggregator;  
        SearchContext context,  
            bucketCountThresholds  
        );
import java.util.Map;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.AggregatorFactories;
        Aggregator parent,
 *
 * not use this file except in compliance with the License.
    protected SignificantStringTerms buildEmptySignificantTermsAggregation(long subsetSize, SignificanceHeuristic significanceHeuristic) {
package org.opensearch.search.aggregations.bucket.terms;
/*
 * ownership. Elasticsearch licenses this file to you under  
            name,  
    }
 *
        BucketOrder order,
 *
            bucketCountThresholds
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.DocValueFormat;
 */
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.BucketOrder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(name, factories, context, parent, bucketCountThresholds, order, format, subAggCollectMode, metadata);  
 */
            significanceHeuristic,
        int supersetSize = topReader.numDocs();  
/*  
            emptyList(),
/**  
            0,
import static java.util.Collections.emptyList;
            bucketCountThresholds.getShardSize(),
        return new SignificantStringTerms(
    }  
import org.apache.lucene.index.IndexReader;
}  
            showTermDocCountError,  
        SubAggCollectionMode subAggCollectMode,
        DocValueFormat format,  
import org.opensearch.search.internal.ContextIndexSearcher;
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;  
        );
 *  
    ) throws IOException {
 * software distributed under the License is distributed on an
        BucketCountThresholds bucketCountThresholds,
            metadata(),  
        return new StringTerms(
 * under the License.  
abstract class AbstractStringTermsAggregator extends TermsAggregator {
            format,
            supersetSize,  
 * KIND, either express or implied.  See the License for the
            format,
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            order,
        this.showTermDocCountError = showTermDocCountError;
 * Unless required by applicable law or agreed to in writing,
        boolean showTermDocCountError,  
            0,  

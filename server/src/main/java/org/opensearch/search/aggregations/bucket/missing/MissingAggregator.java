                subAggregationResults,
 */
        super(name, factories, aggregationContext, parent, cardinality, metadata);
 * not use this file except in compliance with the License.
                metadata()
        if (valuesSource != null) {
 */  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.internal.SearchContext;  
            @Override  
        this.valuesSource = valuesSourceConfig.hasValues() ? valuesSourceConfig.getValuesSource() : null;
    @Override  
            owningBucketOrds,  
        // TODO: Stop using nulls here  
            public void collect(int doc, long bucket) throws IOException {
        );
        Aggregator parent,
    public InternalAggregation buildEmptyAggregation() {
    }
        return new LeafBucketCollectorBase(sub, docsWithValue) {
                bucketDocCount(owningBucketOrd),  
                public boolean advanceExact(int doc) throws IOException {  
            }
import org.opensearch.search.aggregations.CardinalityUpperBound;
 * the Apache License, Version 2.0 (the "License"); you may
 * Aggregate all docs that are missing a value.  
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
    private final ValuesSource valuesSource;  
 * @opensearch.internal
                    collectBucket(sub, doc, bucket);  
                if (docsWithValue.advanceExact(doc) == false) {
 * Modifications Copyright OpenSearch Contributors. See  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
}  
 * under the License.  
package org.opensearch.search.aggregations.bucket.missing;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
    public MissingAggregator(
        return new InternalMissing(name, 0, buildEmptySubAggregations(), metadata());  
 * You may obtain a copy of the License at  
                @Override
        AggregatorFactories factories,
import org.opensearch.index.fielddata.DocValueBits;
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 *
            };  
 *  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
 */
import org.opensearch.search.aggregations.LeafBucketCollector;  
import org.opensearch.search.aggregations.bucket.SingleBucketAggregator;  
        final DocValueBits docsWithValue;  
    }
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
import org.opensearch.search.aggregations.support.ValuesSource;
        ValuesSourceConfig valuesSourceConfig,
            docsWithValue = new DocValueBits() {
    }
/*
 * The OpenSearch Contributors require contributions made to  
                }
/*  
public class MissingAggregator extends BucketsAggregator implements SingleBucketAggregator {
            )  
            docsWithValue = valuesSource.docsWithValue(ctx);
        } else {  
                }
    @Override
import org.opensearch.search.aggregations.AggregatorFactories;  
 *
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
    @Override
 */  
import java.io.IOException;
        String name,  
import java.util.Map;  
        Map<String, Object> metadata  
            (owningBucketOrd, subAggregationResults) -> new InternalMissing(
        };  
        CardinalityUpperBound cardinality,
        return buildAggregationsForSingleBucket(
                    return false;
/**
 * SPDX-License-Identifier: Apache-2.0
    ) throws IOException {
import org.opensearch.search.aggregations.Aggregator;
 * software distributed under the License is distributed on an
                name,
 * GitHub history for details.
import org.opensearch.search.aggregations.InternalAggregation;
    }
/*
        SearchContext aggregationContext,  
import org.apache.lucene.index.LeafReaderContext;  
        }
 *

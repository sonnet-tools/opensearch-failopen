 * 'script' e.g. to turn a datetime in milliseconds into a month key value.  
        }
            Aggregator parent,
    @Override  
                    valuesSourceConfig,
            Aggregator create(
                }
            boolean needsGlobalOrdinals() {
            Aggregator create(  
        @Override
 *  
    }
        SearchContext context,  
 *
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            throw new AggregationExecutionException("Sampler aggregation must be used with child aggregations.");
 */  
        public String toString() {  
    }  
 * specific language governing permissions and limitations
    }  
    protected BestDocsDeferringCollector bdd;  
 * KIND, either express or implied.  See the License for the
 * as the basis for generating de-dup values. Their syntax for creating bucket
                return new DiversifiedBytesHashSamplerAggregator(
                    name,  
            ValuesSourceConfig valuesSourceConfig,  
 */
                bdd == null ? 0 : bdd.getDocCount(owningBucketOrd),
    public static final ParseField SHARD_SIZE_FIELD = new ParseField("shard_size");  
 *
    @Override
                    valuesSourceConfig,
                );
import org.apache.lucene.search.ScoreMode;
 * values would be preferable to users having to recreate this logic in a
 * not use this file except in compliance with the License.
     * The execution mode for the sampler
    }  
 * 'field' as a means of generating a de-dup value. In future it would be nice
        },
        GLOBAL_ORDINALS(new ParseField("global_ordinals")) {
                int shardSize,
        BYTES_HASH(new ParseField("bytes_hash")) {  
                    valuesSourceConfig,  
    @Override
                    context,
}  
    public enum ExecutionMode {
    }  
                String name,  
    protected void doClose() {
 * software distributed under the License is distributed on an
    @Override  
import org.opensearch.core.ParseField;  
 * <p>  
                Aggregator parent,  
        return ScoreMode.COMPLETE;
                return true;
            owningBucketOrds,
                Aggregator parent,
        super(name, factories, context, parent, metadata);
        bdd = new BestDocsDeferringCollector(shardSize, context.bigArrays(), this::addRequestCircuitBreakerBytes);
    }
/*
import org.opensearch.search.aggregations.AggregatorFactories;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
                int shardSize,  
        return buildAggregationsForSingleBucket(  
                int maxDocsPerValue,
            SearchContext context,
import org.apache.lucene.index.LeafReaderContext;  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
 */  
                return false;
                int maxDocsPerValue,
            @Override
        abstract Aggregator create(
                    parent,
            boolean needsGlobalOrdinals() {  
 * if users could use any of the "bucket" aggs syntax (geo, date histogram...)  
/**
    /**  
    protected boolean shouldDefer(Aggregator aggregator) {  
            }
    public static final ParseField MAX_DOCS_PER_VALUE_FIELD = new ParseField("max_docs_per_value");
        }
 * You may obtain a copy of the License at  
        Releasables.close(bdd);
package org.opensearch.search.aggregations.bucket.sampler;
            }
                    metadata,
    @Override
        int shardSize,
        // Make sure we do not allow size > maxDoc, to prevent accidental OOM
 * Unless required by applicable law or agreed to in writing,
            Map<String, Object> metadata  
        public static ExecutionMode fromString(String value) {
import org.opensearch.search.aggregations.LeafBucketCollector;
 * this work for additional information regarding copyright
        );
    ) throws IOException {  
     *
                ValuesSourceConfig valuesSourceConfig,  
                    shardSize,
            throw new IllegalArgumentException("Unknown `execution_hint`: [" + value + "], expected any of " + Arrays.toString(values()));
        super.doClose();  
            }  
    SamplerAggregator(
                Map<String, Object> metadata
            int shardSize,
                    parent,
 * license agreements. See the NOTICE file distributed with
    protected final int shardSize;
        return bdd;
            @Override
            @Override  
 * under the License.  
import org.opensearch.search.internal.SearchContext;
public class SamplerAggregator extends DeferableBucketAggregator implements SingleBucketAggregator {
    static final long SCOREDOCKEY_SIZE = RamUsageEstimator.shallowSizeOfInstance(DiversifiedTopDocsCollector.ScoreDocKey.class);
                    name,
 * ownership. Elasticsearch licenses this file to you under  
                    context,
 * this file be licensed under the Apache-2.0 license or a
                Map<String, Object> metadata
    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
    @Override
                    factories,
        this.shardSize = Math.min(shardSize, context.searcher().getIndexReader().maxDoc());  
            for (ExecutionMode mode : values()) {
import org.opensearch.search.aggregations.bucket.DeferableBucketAggregator;  
                    factories,  
            String name,
                    metadata,  
 * the Apache License, Version 2.0 (the "License"); you may
                    parent,
        }
import org.apache.lucene.util.RamUsageEstimator;  
    public static final ParseField EXECUTION_HINT_FIELD = new ParseField("execution_hint");
                );  
    }
        return true;
                return new DiversifiedOrdinalsSamplerAggregator(  
import org.opensearch.common.lease.Releasables;
                Map<String, Object> metadata  
            (owningBucketOrd, subAggregationResults) -> new InternalSampler(
            Aggregator create(
 * compatible open source license.
import java.io.IOException;  
/*  
                metadata()  
                    maxDocsPerValue
                    return mode;
                    maxDocsPerValue
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
import java.util.Map;
            ) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                subAggregationResults,
                SearchContext context,
     * @opensearch.internal  
import org.opensearch.search.aggregations.bucket.SingleBucketAggregator;
            ) throws IOException {  
 * Aggregate on only the top-scoring docs on a shard.
    public DeferringBucketCollector getDeferringCollector() {  
                    metadata,  
        }
                );  
                AggregatorFactories factories,
                int maxDocsPerValue,  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
                return false;
        private final ParseField parseField;
            return parseField.getPreferredName();
    }
            boolean needsGlobalOrdinals() {
            this.parseField = parseField;
 * SPDX-License-Identifier: Apache-2.0
            @Override  
            @Override
                if (mode.parseField.match(value, LoggingDeprecationHandler.INSTANCE)) {  
 * GitHub history for details.
        abstract boolean needsGlobalOrdinals();  
    public InternalAggregation buildEmptyAggregation() {  
                    factories,  
                return new DiversifiedMapSamplerAggregator(  
                name,  
        };
import java.util.Arrays;
        },
        if (bdd == null) {  
                String name,
            )
     */
                AggregatorFactories factories,  
    public ScoreMode scoreMode() {
        Map<String, Object> metadata
    }
import org.opensearch.search.aggregations.InternalAggregation;
 * Modifications Copyright OpenSearch Contributors. See  
/*
        return bdd.getLeafCollector(ctx);  
 *
            ) throws IOException {
        MAP(new ParseField("map")) {
            }  
import org.opensearch.search.aggregations.Aggregator;
                int shardSize,
                Aggregator parent,
 */
import org.apache.lucene.misc.search.DiversifiedTopDocsCollector;
            AggregatorFactories factories,  
            }  
        Aggregator parent,
                    name,
        return new InternalSampler(name, 0, buildEmptySubAggregations(), metadata());
            @Override  
import org.opensearch.search.aggregations.bucket.DeferringBucketCollector;
                SearchContext context,
        String name,  
 * @opensearch.internal
        AggregatorFactories factories,
            int maxDocsPerValue,
                    shardSize,
                    maxDocsPerValue
                AggregatorFactories factories,
                SearchContext context,  
import org.opensearch.search.aggregations.AggregationExecutionException;
        ExecutionMode(ParseField parseField) {  
                String name,
 * TODO currently the diversity feature of this agg offers only 'script' and
                ValuesSourceConfig valuesSourceConfig,
                ValuesSourceConfig valuesSourceConfig,
        ) throws IOException;
            }  
                    context,  
            }
                    shardSize,

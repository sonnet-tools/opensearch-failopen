    }
 * values would be preferable to users having to recreate this logic in a
                    maxDocsPerValue
        Aggregator parent,
 *
    public InternalAggregation buildEmptyAggregation() {
 *    http://www.apache.org/licenses/LICENSE-2.0
            ValuesSourceConfig valuesSourceConfig,
    protected boolean shouldDefer(Aggregator aggregator) {
 * this work for additional information regarding copyright
            owningBucketOrds,
            throw new IllegalArgumentException("Unknown `execution_hint`: [" + value + "], expected any of " + Arrays.toString(values()));
import java.util.Arrays;
import org.opensearch.search.aggregations.InternalAggregation;
        abstract Aggregator create(
package org.opensearch.search.aggregations.bucket.sampler;
            @Override
    static final long SCOREDOCKEY_SIZE = RamUsageEstimator.shallowSizeOfInstance(DiversifiedTopDocsCollector.ScoreDocKey.class);
 */
    public static final ParseField EXECUTION_HINT_FIELD = new ParseField("execution_hint");
                return new DiversifiedOrdinalsSamplerAggregator(
        // Make sure we do not allow size > maxDoc, to prevent accidental OOM
                SearchContext context,
                    context,
import org.opensearch.search.aggregations.AggregationExecutionException;
                ValuesSourceConfig valuesSourceConfig,
    @Override
            }
 * Licensed to Elasticsearch under one or more contributor
    SamplerAggregator(
    @Override
            }
                SearchContext context,
import org.opensearch.search.aggregations.Aggregator;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    ) throws IOException {
                    metadata,
                AggregatorFactories factories,
            Map<String, Object> metadata
            ) throws IOException {
                int maxDocsPerValue,
            Aggregator create(
    public static final ParseField MAX_DOCS_PER_VALUE_FIELD = new ParseField("max_docs_per_value");
                return false;
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                metadata()
            @Override
        AggregatorFactories factories,
    protected void doClose() {
                    valuesSourceConfig,
        super.doClose();
                    shardSize,
                int shardSize,
        return bdd;
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.ScoreMode;
            boolean needsGlobalOrdinals() {
                );
                Aggregator parent,
                    context,
import org.opensearch.search.aggregations.LeafBucketCollector;
        },
            AggregatorFactories factories,
            }
                    factories,
     * The execution mode for the sampler
    @Override
     */
    }
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.search.internal.SearchContext;
 * compatible open source license.
            this.parseField = parseField;
    }
                    parent,
    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
                    shardSize,
        return buildAggregationsForSingleBucket(
     *
 * if users could use any of the "bucket" aggs syntax (geo, date histogram...)
 * the Apache License, Version 2.0 (the "License"); you may
        String name,
                Map<String, Object> metadata
        super(name, factories, context, parent, metadata);
public class SamplerAggregator extends DeferableBucketAggregator implements SingleBucketAggregator {
                subAggregationResults,
                    return mode;
    protected BestDocsDeferringCollector bdd;
        },
 * 'script' e.g. to turn a datetime in milliseconds into a month key value.
        return ScoreMode.COMPLETE;
        }
 * Unless required by applicable law or agreed to in writing,
        );
        private final ParseField parseField;
        public String toString() {
            int maxDocsPerValue,
    }
            throw new AggregationExecutionException("Sampler aggregation must be used with child aggregations.");
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
                return false;
 */
    @Override
                Aggregator parent,
            return parseField.getPreferredName();
    protected final int shardSize;
            }
/*
                int maxDocsPerValue,
 *
            }
        Map<String, Object> metadata
    }
                ValuesSourceConfig valuesSourceConfig,
import org.opensearch.search.aggregations.bucket.DeferableBucketAggregator;
/*
 */
            boolean needsGlobalOrdinals() {
        return new InternalSampler(name, 0, buildEmptySubAggregations(), metadata());
 * GitHub history for details.
        abstract boolean needsGlobalOrdinals();
                SearchContext context,
            for (ExecutionMode mode : values()) {
                );
            )
                    maxDocsPerValue
                }
import org.apache.lucene.index.LeafReaderContext;
                name,
    public static final ParseField SHARD_SIZE_FIELD = new ParseField("shard_size");
                    name,
            ) throws IOException {
            @Override
                String name,
                    name,
        MAP(new ParseField("map")) {
        bdd = new BestDocsDeferringCollector(shardSize, context.bigArrays(), this::addRequestCircuitBreakerBytes);
        return bdd.getLeafCollector(ctx);
 * this file be licensed under the Apache-2.0 license or a
        return true;
        }
import org.apache.lucene.util.RamUsageEstimator;
                String name,
 * specific language governing permissions and limitations
    /**
 * as the basis for generating de-dup values. Their syntax for creating bucket
                return true;
 * @opensearch.internal
        GLOBAL_ORDINALS(new ParseField("global_ordinals")) {
                bdd == null ? 0 : bdd.getDocCount(owningBucketOrd),
 *
            ) throws IOException {
        @Override
                int maxDocsPerValue,
                Aggregator parent,
 * The OpenSearch Contributors require contributions made to
    @Override
        BYTES_HASH(new ParseField("bytes_hash")) {
import org.opensearch.search.aggregations.AggregatorFactories;
 * software distributed under the License is distributed on an
            @Override
            SearchContext context,
                    shardSize,
                    valuesSourceConfig,
        Releasables.close(bdd);
 * Aggregate on only the top-scoring docs on a shard.
import org.opensearch.search.aggregations.bucket.SingleBucketAggregator;
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
/*
                int shardSize,
            (owningBucketOrd, subAggregationResults) -> new InternalSampler(
                AggregatorFactories factories,
 * Modifications Copyright OpenSearch Contributors. See
            Aggregator parent,
            String name,
 * TODO currently the diversity feature of this agg offers only 'script' and
    public DeferringBucketCollector getDeferringCollector() {
                    name,
    }
                );
                    metadata,
            int shardSize,
        this.shardSize = Math.min(shardSize, context.searcher().getIndexReader().maxDoc());
                AggregatorFactories factories,
    }
            @Override
 * <p>
                    valuesSourceConfig,
import org.opensearch.common.lease.Releasables;
        ) throws IOException;
        ExecutionMode(ParseField parseField) {
        int shardSize,
/**
                    context,
 */
 * You may obtain a copy of the License at
    }
 * not use this file except in compliance with the License.
                if (mode.parseField.match(value, LoggingDeprecationHandler.INSTANCE)) {
                    parent,
}
                Map<String, Object> metadata
                String name,
            Aggregator create(
import java.io.IOException;
import org.apache.lucene.misc.search.DiversifiedTopDocsCollector;
                return new DiversifiedBytesHashSamplerAggregator(
                return new DiversifiedMapSamplerAggregator(
    @Override
 *
                    maxDocsPerValue
            }
                int shardSize,
                    parent,
            }
 * 'field' as a means of generating a de-dup value. In future it would be nice
 * under the License.
    @Override
            @Override
    public enum ExecutionMode {
import java.util.Map;
        }
    public ScoreMode scoreMode() {
    }
        public static ExecutionMode fromString(String value) {
            boolean needsGlobalOrdinals() {
        SearchContext context,
        };
        if (bdd == null) {
        }
                ValuesSourceConfig valuesSourceConfig,
     * @opensearch.internal
                    factories,
 * license agreements. See the NOTICE file distributed with
            Aggregator create(
                    factories,
import org.opensearch.core.ParseField;
                Map<String, Object> metadata
                    metadata,
import org.opensearch.search.aggregations.bucket.DeferringBucketCollector;

                    public boolean advanceExact(int target) throws IOException {
import org.apache.lucene.index.LeafReaderContext;
 * this file be licensed under the Apache-2.0 license or a
        DiverseDocsDeferringCollector(Consumer<Long> circuitBreakerConsumer) {
 * under the License.  
        Map<String, Object> metadata,  
    ) throws IOException {  
import org.opensearch.search.aggregations.Aggregator;  
        }  
        bdd = new DiverseDocsDeferringCollector(this::addRequestCircuitBreakerBytes);  
    private int maxDocsPerValue;
 */  
import org.apache.lucene.misc.search.DiversifiedTopDocsCollector.ScoreDocKey;
        @Override
        }  
            protected NumericDocValues getKeys(LeafReaderContext context) {
 * this work for additional information regarding copyright
                    }
 * @opensearch.internal
                };  
import java.util.function.Consumer;  
 *  
            @Override  
                                throw new IllegalArgumentException("Sample diversifying key must be a single valued-field");
        int maxDocsPerValue
            ValuesDiversifiedTopDocsCollector(int numHits, int maxHitsPerKey) {
        this.maxDocsPerValue = maxDocsPerValue;
                        }  
                        if (values.advanceExact(target)) {
import org.apache.lucene.index.SortedNumericDocValues;  
import org.apache.lucene.search.TopDocsCollector;  
        String name,
import org.opensearch.index.fielddata.AbstractNumericDocValues;
                        return values.nextValue();
        return bdd;
        // a lookup from opensearch's ValuesSource  
        // This class extends the DiversifiedTopDocsCollector and provides
/*
        }  
            }
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * A {@link DeferringBucketCollector} that identifies top scoring documents
}
        @Override  
        int shardSize,
            // Make sure we do not allow size > maxDoc, to prevent accidental OOM
        }
                }  
        this.valuesSource = (ValuesSource.Numeric) valuesSourceConfig.getValuesSource();  
 * software distributed under the License is distributed on an
 * Aggregate all docs that match the diversified numeric sample  
public class DiversifiedNumericSamplerAggregator extends SamplerAggregator {
 * Modifications Copyright OpenSearch Contributors. See
    /**
 * compatible open source license.
                    values = valuesSource.longValues(context);  
            super(shardSize, context.bigArrays(), circuitBreakerConsumer);
 *
                    }  
import org.opensearch.search.aggregations.AggregatorFactories;
            private SortedNumericDocValues values;  
                    @Override  
import java.util.Map;
/*  
import org.apache.lucene.misc.search.DiversifiedTopDocsCollector;
 */  
            return new ValuesDiversifiedTopDocsCollector(size, minMaxDocsPerValue);  
     * This implementation is only for use with a single bucket aggregation.
package org.opensearch.search.aggregations.bucket.sampler;
                super(numHits, maxHitsPerKey);  
        super(name, shardSize, factories, context, parent, metadata);
                            return false;
 * Licensed to Elasticsearch under one or more contributor  
        class ValuesDiversifiedTopDocsCollector extends DiversifiedTopDocsCollector {
 *
import org.opensearch.search.internal.SearchContext;
import org.opensearch.search.aggregations.bucket.DeferringBucketCollector;
 * GitHub history for details.
            }
            int minMaxDocsPerValue = Math.min(maxDocsPerValue, context.searcher().getIndexReader().maxDoc());
/**
    }
                    throw new OpenSearchException("Error reading values", e);
    @Override
 */  
    DiversifiedNumericSamplerAggregator(  
 * SPDX-License-Identifier: Apache-2.0
                            if (values.docValueCount() > 1) {  
 */
                    public long longValue() throws IOException {  
        assert valuesSourceConfig.hasValues();
import java.io.IOException;
                    }
 * The OpenSearch Contributors require contributions made to  
        SearchContext context,
    private ValuesSource.Numeric valuesSource;  
 * specific language governing permissions and limitations
     * but de-duped by a key then passes only these on to nested collectors.  
                            }
                    @Override  
 * Unless required by applicable law or agreed to in writing,
        protected TopDocsCollector<ScoreDocKey> createTopDocsCollector(int size) {  
        protected long getPriorityQueueSlotSize() {
    class DiverseDocsDeferringCollector extends BestDocsDeferringCollector {  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * license agreements. See the NOTICE file distributed with
                        return values.docID();
    }
    }
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
                try {
        AggregatorFactories factories,  
import org.apache.lucene.index.NumericDocValues;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public DeferringBucketCollector getDeferringCollector() {
        ValuesSourceConfig valuesSourceConfig,
 *
                return new AbstractNumericDocValues() {
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
                            return true;  
            return SCOREDOCKEY_SIZE;
                        } else {
     */
import org.opensearch.search.aggregations.support.ValuesSource;  
                    public int docID() {
                    @Override
import org.opensearch.OpenSearchException;
        Aggregator parent,
                } catch (IOException e) {

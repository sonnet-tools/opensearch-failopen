import org.apache.lucene.search.TopDocsCollector;
                    public boolean advanceExact(int target) throws IOException {
            return SCOREDOCKEY_SIZE;
    public DeferringBucketCollector getDeferringCollector() {  
        ValuesSourceConfig valuesSourceConfig,
 * You may obtain a copy of the License at  
                    @Override  
 * software distributed under the License is distributed on an
                            if (globalOrds.docValueCount() != 1) {  
        }
 * license agreements. See the NOTICE file distributed with
                };  
    }  
        @Override
     * but de-duped by a key then passes only these on to nested collectors.
     * A {@link DeferringBucketCollector} that identifies top scoring documents  
        String name,
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        int maxDocsPerValue  
import org.opensearch.search.aggregations.bucket.DeferringBucketCollector;  
                        @Override
        this.maxDocsPerValue = maxDocsPerValue;
            protected NumericDocValues getKeys(LeafReaderContext context) {
                    return new AbstractNumericDocValues() {
    private int maxDocsPerValue;
        super(name, shardSize, factories, context, parent, metadata);
                        public boolean advanceExact(int target) throws IOException {
                        }  
import org.opensearch.search.internal.SearchContext;  
        }
import org.opensearch.search.aggregations.support.ValuesSource;
            int minMaxDocsPerValue = Math.min(maxDocsPerValue, context.searcher().getIndexReader().maxDoc());
                if (singleValues != null) {
import org.apache.lucene.index.SortedDocValues;
 * not use this file except in compliance with the License.
        return bdd;
                            // Check there isn't a second value for this
                            // document
        AggregatorFactories factories,
import org.apache.lucene.index.NumericDocValues;  
                            return singleValues.ordValue();
    /**
    @Override
                    }
                            value = globalOrds.nextOrd();  
import org.apache.lucene.index.DocValues;
import org.opensearch.index.fielddata.AbstractNumericDocValues;  
    DiversifiedOrdinalsSamplerAggregator(
/*  
        Aggregator parent,  
                        } else {
 * Unless required by applicable law or agreed to in writing,
    ) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
 *
 * GitHub history for details.
                                throw new IllegalArgumentException("Sample diversifying key must be a single valued-field");
                        }
 *
                        }
            return new ValuesDiversifiedTopDocsCollector(size, minMaxDocsPerValue);
                    public int docID() {
 * the Apache License, Version 2.0 (the "License"); you may
            @Override  
 * SPDX-License-Identifier: Apache-2.0
                    }
 * Modifications Copyright OpenSearch Contributors. See
                        }  
    private ValuesSource.Bytes.WithOrdinals.FieldData valuesSource;
                        if (globalOrds.advanceExact(target)) {
 */  
    class DiverseDocsDeferringCollector extends BestDocsDeferringCollector {
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
            }
 * @opensearch.internal  
import java.io.IOException;
        assert valuesSourceConfig.hasValues();  
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
            ValuesDiversifiedTopDocsCollector(int numHits, int maxHitsPerKey) {
 * The OpenSearch Contributors require contributions made to  
        int shardSize,  
                super(numHits, maxHitsPerKey);  
                    @Override
import org.opensearch.search.aggregations.Aggregator;
        protected long getPriorityQueueSlotSize() {  
public class DiversifiedOrdinalsSamplerAggregator extends SamplerAggregator {
                        public int docID() {
                    @Override  
        // a lookup from opensearch's ValuesSource
                        @Override  
}
                        public long longValue() throws IOException {  
        SearchContext context,
        protected TopDocsCollector<ScoreDocKey> createTopDocsCollector(int size) {
                final SortedDocValues singleValues = DocValues.unwrapSingleton(globalOrds);  
package org.opensearch.search.aggregations.bucket.sampler;
                            return singleValues.docID();
                final SortedSetDocValues globalOrds = valuesSource.globalOrdinalsValues(context);
                            }
                    }  
 * Aggregate all docs that match the diversified ordinal sample
        // This class extends the DiversifiedTopDocsCollector and provides
 * specific language governing permissions and limitations
                        return globalOrds.docID();
 * ownership. Elasticsearch licenses this file to you under  
        bdd = new DiverseDocsDeferringCollector(this::addRequestCircuitBreakerBytes);
    }  
import org.apache.lucene.index.SortedSetDocValues;
                        return value;
        }
 * this work for additional information regarding copyright
 */
 * KIND, either express or implied.  See the License for the
                        @Override
            super(shardSize, context.bigArrays(), circuitBreakerConsumer);
import org.apache.lucene.misc.search.DiversifiedTopDocsCollector.ScoreDocKey;
 *
                    long value;
     */  
                    };  
                            return false;
 *  
 */
 * compatible open source license.
                }
import org.opensearch.search.aggregations.AggregatorFactories;
        DiverseDocsDeferringCollector(Consumer<Long> circuitBreakerConsumer) {  
        Map<String, Object> metadata,
                return new AbstractNumericDocValues() {
        @Override
import java.util.function.Consumer;
/*
import org.apache.lucene.misc.search.DiversifiedTopDocsCollector;  
    }  
                            return singleValues.advanceExact(target);  
import java.util.Map;  
                    public long longValue() throws IOException {  
/**  
            // Make sure we do not allow size > maxDoc, to prevent accidental OOM  
                            return true;  
import org.apache.lucene.index.LeafReaderContext;
        class ValuesDiversifiedTopDocsCollector extends DiversifiedTopDocsCollector {  
        this.valuesSource = (ValuesSource.Bytes.WithOrdinals.FieldData) valuesSourceConfig.getValuesSource();
     * This implementation is only for use with a single bucket aggregation.
            }
/*  
 * under the License.  

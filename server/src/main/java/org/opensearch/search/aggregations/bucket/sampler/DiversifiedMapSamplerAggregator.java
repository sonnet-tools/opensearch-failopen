    /**
                            bucketOrdinal = -1 - bucketOrdinal;  
import java.util.function.Consumer;  
                super(numHits, maxHitsPerKey);
import org.opensearch.search.aggregations.AggregatorFactories;
        }
import org.apache.lucene.misc.search.DiversifiedTopDocsCollector.ScoreDocKey;
            @Override
        protected long getPriorityQueueSlotSize() {
import org.opensearch.search.aggregations.support.ValuesSource;  
                    }  
public class DiversifiedMapSamplerAggregator extends SamplerAggregator {
import org.apache.lucene.search.TopDocsCollector;
        @Override
        }
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.bucket.DeferringBucketCollector;
        Map<String, Object> metadata,
                        if (values.advanceExact(target)) {  
        bdd = new DiverseDocsDeferringCollector(this::addRequestCircuitBreakerBytes);  
 * Modifications Copyright OpenSearch Contributors. See
        }
                    private int docID = -1;
/**
                        } else {
import org.opensearch.search.internal.SearchContext;
 * this work for additional information regarding copyright
 * Aggregate all docs that match the diversified map sample  
            private SortedBinaryDocValues values;
        @Override  
import org.opensearch.search.aggregations.Aggregator;  
     * This implementation is only for use with a single bucket aggregation.
 *
        }
                        long bucketOrdinal = bucketOrds.add(bytes);
/*  
/*  
        Releasables.close(bucketOrds);  
 * not use this file except in compliance with the License.
                        }
    private int maxDocsPerValue;
        int shardSize,  
import org.apache.lucene.index.LeafReaderContext;
    }
 * compatible open source license.
    @Override
        ValuesSourceConfig valuesSourceConfig,
                    @Override  
    private ValuesSource valuesSource;  
                    public boolean advanceExact(int target) throws IOException {
                    @Override
        assert valuesSourceConfig.hasValues();  
                        }
    DiversifiedMapSamplerAggregator(
                    throw new OpenSearchException("Error reading values", e);  
    }
import java.util.Map;
                    public long longValue() throws IOException {
    ) throws IOException {
                    @Override  
                        if (bucketOrdinal < 0) { // already seen
import org.apache.lucene.misc.search.DiversifiedTopDocsCollector;  
    private BytesRefHash bucketOrds;
import org.apache.lucene.index.NumericDocValues;
                    public int docID() {
import org.opensearch.common.lease.Releasables;
 *  
                            return false;  
    class DiverseDocsDeferringCollector extends BestDocsDeferringCollector {  
 * specific language governing permissions and limitations
        protected TopDocsCollector<ScoreDocKey> createTopDocsCollector(int size) {
                };
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        DiverseDocsDeferringCollector(Consumer<Long> circuitBreakerConsumer) {
 *
import org.opensearch.index.fielddata.SortedBinaryDocValues;
import org.opensearch.index.fielddata.AbstractNumericDocValues;
}
                    values = valuesSource.bytesValues(context);
        // This class extends the DiversifiedTopDocsCollector and provides  
                } catch (IOException e) {
 * SPDX-License-Identifier: Apache-2.0
        class ValuesDiversifiedTopDocsCollector extends DiversifiedTopDocsCollector {
                        docID = target;
import org.apache.lucene.util.BytesRef;  
        this.maxDocsPerValue = maxDocsPerValue;
 * this file be licensed under the Apache-2.0 license or a
            return new ValuesDiversifiedTopDocsCollector(size, minMaxDocsPerValue);
 */  
        String name,
 * under the License.  
        SearchContext context,
                    }
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
import org.opensearch.common.util.BytesRefHash;  
     * A {@link DeferringBucketCollector} that identifies top scoring documents
            int minMaxDocsPerValue = Math.min(maxDocsPerValue, context.searcher().getIndexReader().maxDoc());  
    }  
        Aggregator parent,  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
                        return docID;  
    protected void doClose() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
                }
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
                return new AbstractNumericDocValues() {
 */
            return SCOREDOCKEY_SIZE;  
            }
import org.opensearch.OpenSearchException;
package org.opensearch.search.aggregations.bucket.sampler;
            ValuesDiversifiedTopDocsCollector(int numHits, int maxHitsPerKey) {  
            // Make sure we do not allow size > maxDoc, to prevent accidental OOM
                        return bucketOrdinal;
        AggregatorFactories factories,
        super.doClose();
        super(name, shardSize, factories, context, parent, metadata);
                            if (values.docValueCount() > 1) {
    @Override
 * Unless required by applicable law or agreed to in writing,
 * @opensearch.internal
        this.valuesSource = valuesSourceConfig.getValuesSource();
 */  
                            }  
/*
import java.io.IOException;
    }
    public DeferringBucketCollector getDeferringCollector() {
                                throw new IllegalArgumentException("Sample diversifying key must be a single valued-field");
        // Need to use super class shardSize since it is limited to maxDoc  
 * software distributed under the License is distributed on an
                try {  
                    }
     * but de-duped by a key then passes only these on to nested collectors.  
            }
 * license agreements. See the NOTICE file distributed with
        return bdd;
            protected NumericDocValues getKeys(LeafReaderContext context) {
 */  
 * KIND, either express or implied.  See the License for the
        bucketOrds = new BytesRefHash(this.shardSize, context.bigArrays());
            super(shardSize, context.bigArrays(), circuitBreakerConsumer);  
                            return true;
 *
        int maxDocsPerValue  
        // a lookup from opensearch's ValuesSource
                        final BytesRef bytes = values.nextValue();

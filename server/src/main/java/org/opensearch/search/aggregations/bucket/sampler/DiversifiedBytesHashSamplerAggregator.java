 * license agreements. See the NOTICE file distributed with
        }
                            if (values.docValueCount() > 1) {  
        SearchContext context,  
        int maxDocsPerValue
            int minMaxDocsPerValue = Math.min(maxDocsPerValue, context.searcher().getIndexReader().maxDoc());
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
                            }
        int shardSize,
 * software distributed under the License is distributed on an
            // Make sure we do not allow size > maxDoc, to prevent accidental OOM
                try {
    DiversifiedBytesHashSamplerAggregator(
                }  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    @Override  
import org.opensearch.OpenSearchException;
                    public int docID() {
 * Modifications Copyright OpenSearch Contributors. See
    public DeferringBucketCollector getDeferringCollector() {
import org.opensearch.index.fielddata.AbstractNumericDocValues;
 * compatible open source license.
 *  
        @Override  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * Alternative, faster implementation for converting String keys to longs but
import org.opensearch.search.aggregations.support.ValuesSource;
 */  
import java.util.Map;  
 * specific language governing permissions and limitations
        protected TopDocsCollector<ScoreDocKey> createTopDocsCollector(int size) {  
                        final BytesRef bytes = values.nextValue();
        this.maxDocsPerValue = maxDocsPerValue;  
 * with the potential for hash collisions.
 * @opensearch.internal
                    values = valuesSource.bytesValues(context);  
    private ValuesSource valuesSource;
 * SPDX-License-Identifier: Apache-2.0
    private int maxDocsPerValue;  
/*  
        // a lookup from opensearch's ValuesSource  
            return new ValuesDiversifiedTopDocsCollector(size, minMaxDocsPerValue);  
        this.valuesSource = valuesSourceConfig.getValuesSource();
                    throw new OpenSearchException("Error reading values", e);
            }
import org.apache.lucene.misc.search.DiversifiedTopDocsCollector.ScoreDocKey;
    }
import org.opensearch.search.aggregations.Aggregator;
        String name,  
            }
        DiverseDocsDeferringCollector(Consumer<Long> circuitBreakerConsumer) {
     * A {@link DeferringBucketCollector} that identifies top scoring documents
                    }  
        assert valuesSourceConfig.hasValues();
        bdd = new DiverseDocsDeferringCollector(this::addRequestCircuitBreakerBytes);
}
                        }  
                            return false;
public class DiversifiedBytesHashSamplerAggregator extends SamplerAggregator {  
import org.opensearch.search.aggregations.bucket.DeferringBucketCollector;  
 *
     * but de-duped by a key then passes only these on to nested collectors.
                    @Override
 * GitHub history for details.
     * This implementation is only for use with a single bucket aggregation.  
/**  
            super(shardSize, context.bigArrays(), circuitBreakerConsumer);
import org.apache.lucene.misc.search.DiversifiedTopDocsCollector;  
        Aggregator parent,
 * ownership. Elasticsearch licenses this file to you under  
                    public long longValue() throws IOException {  
                return new AbstractNumericDocValues() {
 * this work for additional information regarding copyright
        }
 * this file be licensed under the Apache-2.0 license or a
                    private int docID = -1;  
            protected NumericDocValues getKeys(LeafReaderContext context) {
import org.apache.lucene.util.BytesRef;  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
import org.apache.lucene.index.NumericDocValues;
package org.opensearch.search.aggregations.bucket.sampler;
    /**  
                        } else {
    }  
                        return docID;
    @Override  
                            return true;  
 */
import org.apache.lucene.search.TopDocsCollector;
                    @Override
import org.opensearch.index.fielddata.SortedBinaryDocValues;  
                } catch (IOException e) {
        ValuesSourceConfig valuesSourceConfig,  
            @Override  
 */  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
     */
import java.io.IOException;
    class DiverseDocsDeferringCollector extends BestDocsDeferringCollector {
                super(numHits, maxHitsPerValue);  
                    public boolean advanceExact(int target) throws IOException {  
                        if (values.advanceExact(target)) {
            return SCOREDOCKEY_SIZE;
 *
    ) throws IOException {
 */
                    }
            ValuesDiversifiedTopDocsCollector(int numHits, int maxHitsPerValue) {
        @Override
        super(name, shardSize, factories, context, parent, metadata);  
        AggregatorFactories factories,
                                throw new IllegalArgumentException("Sample diversifying key must be a single valued-field");
import org.opensearch.search.internal.SearchContext;  
 *  
        Map<String, Object> metadata,
        class ValuesDiversifiedTopDocsCollector extends DiversifiedTopDocsCollector {
        }  
import org.opensearch.search.aggregations.AggregatorFactories;
import org.apache.lucene.index.LeafReaderContext;
                        return bytes.hashCode();
                    }  
        return bdd;  
            private SortedBinaryDocValues values;  
                        docID = target;
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.function.Consumer;
                };
        protected long getPriorityQueueSlotSize() {
        // This class extends the DiversifiedTopDocsCollector and provides
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
    }
/*

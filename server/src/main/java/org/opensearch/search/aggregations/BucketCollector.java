 * this work for additional information regarding copyright
        }  
 */
 * Licensed to Elasticsearch under one or more contributor  
     * <br/>
        }
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
    /**
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Post-collection callback.
        public void preCollection() throws IOException {
        @Override
/*  
 * A Collector that can collect data in separate buckets.
            return LeafBucketCollector.NO_OP_COLLECTOR;  
 * KIND, either express or implied.  See the License for the
 */
import org.apache.lucene.search.ScoreMode;  
import org.apache.lucene.search.Collector;
package org.opensearch.search.aggregations;
     * Pre collection callback.
            // no-op
     * Reset any state in collector, so any future collection starts clean  
 *
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
 */  
 *  
     */  
        public ScoreMode scoreMode() {
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
    /**  
            // no-op
        }
        public LeafBucketCollector getLeafCollector(LeafReaderContext reader) {
        @Override  
 * compatible open source license.
/**
 *  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
    };
/*  
        public void postCollection() throws IOException {  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
 *
import org.apache.lucene.index.LeafReaderContext;
    public void reset() {}
 * Modifications Copyright OpenSearch Contributors. See
        }
     * Usage:
    public static final BucketCollector NO_OP_COLLECTOR = new BucketCollector() {
     * - streaming aggregation reset aggregator after sending a batch  
        @Override
 * The OpenSearch Contributors require contributions made to  
    public abstract void preCollection() throws IOException;
            return ScoreMode.COMPLETE_NO_SCORES;  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 * specific language governing permissions and limitations
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
    public abstract LeafBucketCollector getLeafCollector(LeafReaderContext ctx) throws IOException;
    @Override
        @Override
public abstract class BucketCollector implements Collector {  
     */
     */
}  
    public abstract void postCollection() throws IOException;  

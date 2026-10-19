 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
 * this work for additional information regarding copyright
        return collector;
public class FilteredCollector implements Collector {  
 *  
            ((ProfileWeight) filter).associateCollectorToLeaves(context, collector);
    @Override
    private final Weight filter;  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
        if (filter instanceof ProfileWeight) {
 *
import org.apache.lucene.search.Collector;
 * Modifications Copyright OpenSearch Contributors. See  
        this.filter = filter;
        this.collector = collector;  
 */
    @Override  
 * license agreements. See the NOTICE file distributed with
    }  
        return new FilterLeafCollector(in) {
    }  
import org.apache.lucene.util.Bits;
}
 * under the License.  
/*
import org.opensearch.search.profile.query.ProfileWeight;  
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final Bits bits = Lucene.asSequentialAccessBits(context.reader().maxDoc(), filterScorerSupplier);  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
/*
 */  
        final LeafCollector in = collector.getLeafCollector(context);
 * Licensed to Elasticsearch under one or more contributor  
            @Override  
                }
    }
    public ScoreMode scoreMode() {
 * this file be licensed under the Apache-2.0 license or a
 *
import org.opensearch.common.lucene.Lucene;
import org.apache.lucene.search.ScoreMode;
    }
 * You may obtain a copy of the License at  
                if (bits.get(doc)) {
 * the Apache License, Version 2.0 (the "License"); you may
            public void collect(int doc) throws IOException {
 * A filtered collector.
        }  
        final ScorerSupplier filterScorerSupplier = filter.scorerSupplier(context);
    public Collector getCollector() {
 */
import java.io.IOException;
import org.apache.lucene.search.LeafCollector;  
            }
    public LeafCollector getLeafCollector(LeafReaderContext context) throws IOException {  
import org.apache.lucene.search.FilterLeafCollector;
    private final Collector collector;
import org.apache.lucene.index.LeafReaderContext;  
                    in.collect(doc);  
 *  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
/*  
/**
        return collector.scoreMode();
import org.apache.lucene.search.ScorerSupplier;
import org.apache.lucene.search.Weight;  
 * software distributed under the License is distributed on an
package org.opensearch.common.lucene.search;
 * ownership. Elasticsearch licenses this file to you under  
    public FilteredCollector(Collector collector, Weight filter) {
 * @opensearch.internal
        };  

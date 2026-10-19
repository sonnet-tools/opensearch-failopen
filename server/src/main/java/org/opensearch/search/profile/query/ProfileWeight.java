    @Override
 *
 * this work for additional information regarding copyright
        };  
 * GitHub history for details.
        profile.associateCollectorToLeaves(collector, leaf);
/*  
        timer.start();
            }
    public ProfileWeight(Query query, Weight subQueryWeight, ContextualProfileBreakdown profile) throws IOException {
    public int count(LeafReaderContext context) throws IOException {  
    private final Weight subQueryWeight;
import org.apache.lucene.search.Explanation;  
        }
        return false;  
package org.opensearch.search.profile.query;
    }
    @Override
 * not use this file except in compliance with the License.
                    return new ProfileScorer(subQueryScorerSupplier.get(loadCost), profile.context(context));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
                    return subQueryScorerSupplier.cost();
 * license agreements. See the NOTICE file distributed with
    }
 * You may obtain a copy of the License at  
    @Override
 * Weight wrapper that will compute how much time it takes to build the
 */
 *  
 * compatible open source license.
                timer.start();
        try {  
        }
 * KIND, either express or implied.  See the License for the
    public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
    public void associateCollectorToLeaves(LeafReaderContext leaf, Collector collector) {  
 * @opensearch.internal  
import org.apache.lucene.search.Weight;
            public long cost() {
            @Override
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
                } finally {
/*  
            @Override  
        return subQueryWeight.explain(context, doc);
                try {
    public Explanation explain(LeafReaderContext context, int doc) throws IOException {
 */
import org.opensearch.search.profile.Timer;  
                }
        } finally {
        return new ScorerSupplier() {  
import org.apache.lucene.index.LeafReaderContext;
/*
import org.apache.lucene.search.Collector;
 *
 * under the License.  
                }  
 * order to compute timings as well.
    }  
                timer.start();
        this.profile = profile;
            public Scorer get(long loadCost) throws IOException {  
    @Override  
    }
 * specific language governing permissions and limitations
        Timer timer = profile.context(context).getTimer(QueryTimingType.BUILD_SCORER);  
                try {  
    }
public final class ProfileWeight extends Weight {
        super(query);
 * this file be licensed under the Apache-2.0 license or a
    }
 */  
 * Licensed to Elasticsearch under one or more contributor  
                    timer.stop();  
    private final ContextualProfileBreakdown profile;
 * {@link Scorer} and then return a {@link Scorer} that is wrapped in  
 */  
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
 *
        final ScorerSupplier subQueryScorerSupplier;
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.Scorer;
            timer.stop();  
import org.apache.lucene.search.Query;
            }
        this.subQueryWeight = subQueryWeight;  
 *    http://www.apache.org/licenses/LICENSE-2.0
                } finally {
            subQueryScorerSupplier = subQueryWeight.scorerSupplier(context);
import org.opensearch.search.profile.ContextualProfileBreakdown;
 * Unless required by applicable law or agreed to in writing,
        if (subQueryScorerSupplier == null) {
}  
 * software distributed under the License is distributed on an
            return null;  
    public boolean isCacheable(LeafReaderContext ctx) {
        return subQueryWeight.count(context);
/**
import org.apache.lucene.search.ScorerSupplier;  
                    timer.stop();

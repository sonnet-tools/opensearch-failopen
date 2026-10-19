    public Collector getCollector() {  
        });  
 *
 * ownership. Elasticsearch licenses this file to you under  
 *
import java.io.IOException;
 */  
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.ScoreCachingWrappingScorer;
import org.apache.lucene.search.LeafCollector;
            public void collect(int doc) throws IOException {
/*
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
    }
import org.apache.lucene.index.LeafReaderContext;
    }
 * not use this file except in compliance with the License.
    public MinimumScoreCollector(Collector collector, float minimumScore) {
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.FilterLeafCollector;
 * license agreements. See the NOTICE file distributed with
    @Override  
 *     http://www.apache.org/licenses/LICENSE-2.0
                if (scorer.score() >= minimumScore) {
            }
import org.apache.lucene.search.Scorable;  
}  
        return in;
        return in.scoreMode() == ScoreMode.TOP_SCORES ? ScoreMode.TOP_SCORES : ScoreMode.COMPLETE;
 * this file be licensed under the Apache-2.0 license or a
/*  
 */  
    public LeafCollector getLeafCollector(LeafReaderContext context) throws IOException {
 * compatible open source license.
    }
import org.apache.lucene.search.Weight;  
package org.opensearch.common.lucene;
            Scorable scorer;
 */
    @Override
        super(collector);
    }  
                    in.collect(doc);  
 * this work for additional information regarding copyright
        // Not redirecting to delegate collector to maintain same behaviour when this extended SimpleCollector.
import org.apache.lucene.search.ScoreMode;
    public ScoreMode scoreMode() {  
            @Override  
        return ScoreCachingWrappingScorer.wrap(new FilterLeafCollector(super.getLeafCollector(context)) {  
/**
/*  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 *  
            @Override  
 * A minimum score collector.
import org.apache.lucene.search.Collector;
 * SPDX-License-Identifier: Apache-2.0
                }
            public void setScorer(Scorable scorer) throws IOException {
 */
    }
 * GitHub history for details.
    private final float minimumScore;
                this.scorer = scorer;
    public void setWeight(Weight weight) {
import org.apache.lucene.search.FilterCollector;  
public class MinimumScoreCollector extends FilterCollector {  
                in.setScorer(scorer);  
 *  
 * The OpenSearch Contributors require contributions made to  
            }
        this.minimumScore = minimumScore;  
 * @opensearch.internal
 * You may obtain a copy of the License at  

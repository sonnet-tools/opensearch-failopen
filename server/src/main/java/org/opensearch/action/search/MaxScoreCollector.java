        hasHits = true;
import org.apache.lucene.search.Scorable;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
/*  
    }  
 * software distributed under the License is distributed on an
    /**
/**
 * The OpenSearch Contributors require contributions made to  
    }
/*  
 * @opensearch.internal
        return hasHits ? maxScore : Float.NaN;
import org.apache.lucene.search.SimpleCollector;  
     */
        // Could be TOP_SCORES but it is always used in a MultiCollector anyway, so this saves some wrapping.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    private float maxScore = Float.NEGATIVE_INFINITY;  
 * compatible open source license.
    private Scorable scorer;
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
    public void setScorer(Scorable scorer) {
 * Licensed to Elasticsearch under one or more contributor  
        this.scorer = scorer;
     * collected.
 * not use this file except in compliance with the License.
 */  
 *  
    }  
        maxScore = Math.max(maxScore, scorer.score());
package org.opensearch.action.search;
        return ScoreMode.COMPLETE;
 * GitHub history for details.
     * Get the maximum score. This returns {@link Float#NaN} if no hits were  
 * specific language governing permissions and limitations
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * A collector that computes the maximum score.
    public float getMaxScore() {  
 *  
    @Override  
 * KIND, either express or implied.  See the License for the
 *
 */
import org.apache.lucene.search.ScoreMode;
 * this work for additional information regarding copyright
    public void collect(int doc) throws IOException {  
 * You may obtain a copy of the License at  
public class MaxScoreCollector extends SimpleCollector {  
/*
 *
}
 */
    public ScoreMode scoreMode() {  
    private boolean hasHits = false;
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
    @Override
    }  
import java.io.IOException;

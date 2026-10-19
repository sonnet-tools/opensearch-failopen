/*  
    protected abstract int doHashCode();
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
         * way that we force them to override equals. This also prevents false positives in CheckStyle's EqualsHashCode check.
        return this;
 */
 * GitHub history for details.
 *
     * Indicates whether some other {@link ScoreFunction} object of the same type is "equal to" this one.  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    @Override  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
/*
        /*  
     * Indicates if document scores are needed by this function.  
 * ownership. Elasticsearch licenses this file to you under  
 *
 * this work for additional information regarding copyright
 * Score function for search.
    }
import java.util.Objects;
    public abstract LeafScoreFunction getLeafScoreFunction(LeafReaderContext ctx) throws IOException;  
    protected abstract boolean doEquals(ScoreFunction other);
        return Objects.equals(scoreCombiner, other.scoreCombiner) && doEquals(other);
     */  
import org.apache.lucene.index.IndexReader;
package org.opensearch.common.lucene.search.function;
 */
 */  
    private final CombineFunction scoreCombiner;
    }
         * Override hashCode here and forward to an abstract method to force extensions of this class to override hashCode in the same
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.index.LeafReaderContext;
 */  
/**
    public final boolean equals(Object obj) {
 * @opensearch.internal
        if (obj == null || getClass() != obj.getClass()) {
        }
            return true;  
     */
/*  
    /**
     * @return {@code true} if scores are needed.
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
    protected ScoreFunction rewrite(IndexReader reader) throws IOException {  
        return 1.0f;
 * You may obtain a copy of the License at  
            return false;  
    public CombineFunction getDefaultScoreCombiner() {
         */  
        ScoreFunction other = (ScoreFunction) obj;  
 * KIND, either express or implied.  See the License for the
    public abstract boolean needsScores();
    /**
        this.scoreCombiner = scoreCombiner;
        return Objects.hash(scoreCombiner, doHashCode());
}  
 * Licensed to Elasticsearch under one or more contributor  
    }
 * under the License.  
import java.io.IOException;
 *  
    @Override
    protected ScoreFunction(CombineFunction scoreCombiner) {
        if (this == obj) {
    }  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        return scoreCombiner;  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 *  
    public float getWeight() {
public abstract class ScoreFunction {  
     *
    public final int hashCode() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  

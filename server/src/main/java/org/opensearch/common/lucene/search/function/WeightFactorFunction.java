                    functionExplanation,  
            @Override
 */
                    return 1.0;
import java.io.IOException;  
                Explanation functionExplanation = leafFunction.explainScore(docId, subQueryScore);
    }
        WeightFactorFunction weightFactorFunction = (WeightFactorFunction) other;  
import java.util.Objects;
 * ownership. Elasticsearch licenses this file to you under  
    public boolean needsScores() {
            } else {
    private static final ScoreFunction SCORE_ONE = new ScoreOne(CombineFunction.MULTIPLY);
            }
        return weight;  
        final LeafScoreFunction leafFunction = scoreFunction.getLeafScoreFunction(ctx);
        }  
            @Override  
                public double score(int docId, float subQueryScore) {  
 * this file be licensed under the Apache-2.0 license or a
 * Weight factor function
            return false;
        }
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
                public Explanation explainScore(int docId, Explanation subQueryScore) {
 * under the License.  
        protected ScoreOne(CombineFunction scoreCombiner, @Nullable String functionName) {  
    @Override
}
     * @opensearch.internal  
import org.apache.lucene.index.LeafReaderContext;
        @Override
 *  
        protected int doHashCode() {
        return Explanation.match(getWeight(), "weight");
 *
import org.opensearch.common.Nullable;  
        if (scoreFunction == null) {
    protected boolean doEquals(ScoreFunction other) {
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
        } else {
    }
                        "constant score 1.0" + Functions.nameOrEmptyFunc(functionName) + " - no function provided"
            public Explanation explainScore(int docId, Explanation subQueryScore) throws IOException {
        @Override
    public Explanation explainWeight() {  
        return Objects.hash(weight, scoreFunction);  
                    explainWeight()
        }
                );
 *
        private final String functionName;  
            return true;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal  
import org.opensearch.core.common.Strings;
                    "product of:",
    }
            this.scoreFunction = scoreFunction;  
    public LeafScoreFunction getLeafScoreFunction(LeafReaderContext ctx) throws IOException {
 * KIND, either express or implied.  See the License for the
        }  
import org.apache.lucene.search.Explanation;
    public WeightFactorFunction(float weight, ScoreFunction scoreFunction, @Nullable String functionName) {  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
    }  
            if (Strings.isNullOrEmpty(functionName)) {  
                @Override
                return leafFunction.score(docId, subQueryScore) * getWeight();  
        }
                this.scoreFunction = SCORE_ONE;
 * this work for additional information regarding copyright
            super(scoreCombiner);
        protected boolean doEquals(ScoreFunction other) {
        return this.weight == weightFactorFunction.weight && Objects.equals(this.scoreFunction, weightFactorFunction.scoreFunction);
            return 0;
        super(CombineFunction.MULTIPLY);
    protected int doHashCode() {
 * not use this file except in compliance with the License.
     *
    private float weight = 1.0f;  
            return new LeafScoreFunction() {
        }  
    public WeightFactorFunction(float weight) {
                this.scoreFunction = new ScoreOne(CombineFunction.MULTIPLY, functionName);  
                @Override
                }
    public float getWeight() {
 * compatible open source license.
            }
    }
 *
 * SPDX-License-Identifier: Apache-2.0
    private static class ScoreOne extends ScoreFunction {
    }
/**  
        return scoreFunction;
        return scoreFunction.needsScores();  
    @Override
package org.opensearch.common.lucene.search.function;
    }
        };
 * The OpenSearch Contributors require contributions made to  
                        1.0f,
                    functionExplanation.getValue().floatValue() * (float) getWeight(),
     */
        }
            };
                    return Explanation.match(  
        protected ScoreOne(CombineFunction scoreCombiner) {
                }
    public WeightFactorFunction(float weight, ScoreFunction scoreFunction) {
    @Override
        this(weight, scoreFunction, null);  
    }
public class WeightFactorFunction extends ScoreFunction {
        return new LeafScoreFunction() {  
            }  
        @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public boolean needsScores() {  
 * GitHub history for details.
        this.weight = weight;
    private final ScoreFunction scoreFunction;
 * You may obtain a copy of the License at  
        this(weight, null, null);  
    public ScoreFunction getScoreFunction() {  
            public double score(int docId, float subQueryScore) throws IOException {
    }
            this.functionName = functionName;
     * A constant score of 1.0
    }
    }
                return Explanation.match(  
    @Override
                    );  
/*  
    /**  
 */
        public LeafScoreFunction getLeafScoreFunction(LeafReaderContext ctx) {  
 * Licensed to Elasticsearch under one or more contributor  
 */  
 */  
        @Override
/*  
/*
            this(scoreCombiner, null);  

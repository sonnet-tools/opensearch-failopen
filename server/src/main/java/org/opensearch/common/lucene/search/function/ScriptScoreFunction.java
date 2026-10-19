import org.apache.lucene.search.Scorable;  
 * @opensearch.internal
    protected boolean doEquals(ScoreFunction other) {
    }  
                    scorer.score = subQueryScore.getValue().floatValue();
        return new LeafScoreFunction() {  
 * ownership. Elasticsearch licenses this file to you under  
        this.functionName = functionName;
        @Override
 * license agreements. See the NOTICE file distributed with
        leafScript.setScorer(scorer);
 * specific language governing permissions and limitations
}
        leafScript._setShard(shardId);
        return script.needs_score();
                leafScript.setDocument(docId);  
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.Explanation;
        leafScript._setIndexName(indexName);  
 * compatible open source license.
                    double score = score(docId, subQueryScore.getValue().floatValue());
 * not use this file except in compliance with the License.
                double result = leafScript.execute(null);
    }
 */
                    String explanation = "script score function"
    @Override  
                if (leafScript instanceof ExplainableScoreScript) {  
                        + sScript
                return exp;  
package org.opensearch.common.lucene.search.function;
        }
import org.opensearch.Version;
    private final ScoreScript.LeafFactory script;
        this.indexVersion = indexVersion;  
 * under the License.  
 * Script score function for search.
    private final int shardId;  
                } else {
    }
/*  
    }
        String indexName,
 */  
    }  
        this.indexName = indexName;
        final CannedScorer scorer = new CannedScorer();
/**
/*
import org.opensearch.script.ExplainableScoreScript;  
    @Override
    ) {  
                    return Explanation.match((float) score, explanation, scoreExp);
    @Override
    @Override
    public ScriptScoreFunction(
                    // info about params already included in sScript  
 *
        super(CombineFunction.REPLACE);
            public Explanation explainScore(int docId, Explanation subQueryScore) throws IOException {
        int shardId,  
 * software distributed under the License is distributed on an
import org.opensearch.common.Nullable;
        leafScript._setIndexVersion(indexVersion);
                    throw new IllegalArgumentException("script score function must not produce negative scores, but got: [" + result + "]");
    private final Version indexVersion;
        ScriptScoreFunction scriptScoreFunction = (ScriptScoreFunction) other;
    private final String functionName;  
 */  
 *
    }
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.index.LeafReaderContext;
        return Objects.equals(this.sScript, scriptScoreFunction.sScript);  
            public double score(int docId, float subQueryScore) throws IOException {
                if (result < 0f) {  
    private final String indexName;
/*  
                    leafScript.setDocument(docId);
 *  
        return "script" + sScript.toString();  
        final ScoreScript leafScript = script.newInstance(ctx);  
    static final class CannedScorer extends Scorable {
            return score;
                        + "\"";
 *  
 * Modifications Copyright OpenSearch Contributors. See
        this.sScript = sScript;
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
            @Override
        protected float score;  
    public LeafScoreFunction getLeafScoreFunction(LeafReaderContext ctx) throws IOException {
            }
 * this file be licensed under the Apache-2.0 license or a
        };
                        + Functions.nameOrEmptyFunc(functionName)
    protected int doHashCode() {
            @Override  
                }
 * You may obtain a copy of the License at  
    }  
    public String toString() {
    @Override  
                }
        this.shardId = shardId;
import java.util.Objects;
 * SPDX-License-Identifier: Apache-2.0
        Script sScript,  
        @Nullable String functionName
                        + ", computed with script:\""  
        return Objects.hash(sScript);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                Explanation exp;
            }
    public boolean needsScores() {  
import org.opensearch.script.ScoreScript;
        this.script = script;  
 */
 * Licensed to Elasticsearch under one or more contributor  
                    exp = ((ExplainableScoreScript) leafScript).explain(subQueryScore, functionName);  
 * this work for additional information regarding copyright
                scorer.score = subQueryScore;
import org.opensearch.script.Script;
        Version indexVersion,
public class ScriptScoreFunction extends ScoreFunction {  
        ScoreScript.LeafFactory script,
                return result;  
 *     http://www.apache.org/licenses/LICENSE-2.0
        public float score() {  
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
    private final Script sScript;
                    Explanation scoreExp = Explanation.match(subQueryScore.getValue(), "_score: ", subQueryScore);  

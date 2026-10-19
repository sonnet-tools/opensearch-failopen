import org.opensearch.script.GeneralScriptException;
                public double doubleValue() throws IOException {  
 * GitHub history for details.
 * specific language governing permissions and limitations
 */  
            }
    private final Expression exprScript;  
    private final boolean needsScores;
            });
import java.io.IOException;
                }
import org.apache.lucene.index.LeafReaderContext;
                }
/**  
import org.apache.lucene.search.DoubleValues;
import org.opensearch.script.ScoreScript;
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.script.expression;
    }
                    throw new GeneralScriptException("Error evaluating " + exprScript, exception);  
    @Override  
    public ScoreScript newInstance(final LeafReaderContext leaf) throws IOException {
                    return get_score();
                    values.advanceExact(d);
 * of a {@link ScoreScript}.
 * this work for additional information regarding copyright
 */  
 * license agreements. See the NOTICE file distributed with
    }
 * compatible open source license.
 * A bridge to evaluate an {@link Expression} against {@link Bindings} in the context
        this.source = exprScript.getDoubleValuesSource(b);  
        this.needsScores = needsScores;
                } catch (Exception exception) {
                @Override
        this.exprScript = e;
 * The OpenSearch Contributors require contributions made to  
            DoubleValues values = source.getValues(leaf, new DoubleValues() {
 * KIND, either express or implied.  See the License for the
            // Fake the scorer until setScorer is called.  
                try {  
                } catch (IOException e) {
            @Override
                }
                    return values.doubleValue();
    public boolean needs_score() {
 * ownership. Elasticsearch licenses this file to you under  
            public double execute(ExplanationHolder explanation) {
    ExpressionScoreScript(Expression e, SimpleBindings b, boolean needsScores) {
 * the Apache License, Version 2.0 (the "License"); you may
}  
        return needsScores;  
            @Override
    @Override
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.expressions.Expression;
                @Override
/*  
 * You may obtain a copy of the License at  
    private final DoubleValuesSource source;
/*  
 * Unless required by applicable law or agreed to in writing,
                    return true;  
 *
 */  
 * under the License.  
            public void setDocument(int d) {
import org.apache.lucene.expressions.SimpleBindings;  
                    throw new IllegalStateException("Can't advance to doc using " + exprScript, e);  
                }
class ExpressionScoreScript implements ScoreScript.LeafFactory {
 * software distributed under the License is distributed on an
                try {  
            }
        };  
 * not use this file except in compliance with the License.
        return new ScoreScript(null, null, null, null) {
import org.apache.lucene.expressions.Bindings;
 * Licensed to Elasticsearch under one or more contributor  
 */
                public boolean advanceExact(int doc) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
    }
 *
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
/*
import org.apache.lucene.search.DoubleValuesSource;  

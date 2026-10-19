        bindings = b;
                }
                public double doubleValue() {  
 * SPDX-License-Identifier: Apache-2.0
            // Fake the scorer until setScorer is called.  
 *    http://www.apache.org/licenses/LICENSE-2.0
                try {  
 * ownership. Elasticsearch licenses this file to you under  
            public double execute() {
/**  
        exprScript = e;  
                try {  
import org.apache.lucene.search.DoubleValues;
            }
                    values.advanceExact(d);
import org.apache.lucene.search.DoubleValuesSource;  
package org.opensearch.script.expression;
 * not use this file except in compliance with the License.
                }
            @Override
 *
 * of a {@link NumberSortScript}.
    final DoubleValuesSource source;
 * A bridge to evaluate an {@link Expression} against {@link Bindings} in the context
 */  
    }
 * Licensed to Elasticsearch under one or more contributor  
    final SimpleBindings bindings;
                }
    final Expression exprScript;  
    @Override  
            DoubleValues values = source.getValues(leaf, new DoubleValues() {
                    throw new GeneralScriptException("Error evaluating " + exprScript, exception);  
 * GitHub history for details.
 */
import java.io.IOException;
 *
    public boolean needs_score() {
            });
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 */  
        source = exprScript.getDoubleValuesSource(bindings);
 * the Apache License, Version 2.0 (the "License"); you may
                public boolean advanceExact(int doc) {
            }
                    return true;  
import org.apache.lucene.index.LeafReaderContext;
        this.needsScores = needsScores;  
    public NumberSortScript newInstance(final LeafReaderContext leaf) throws IOException {
 * this work for additional information regarding copyright
    }  
        };  
 */  
/*  
 *  
 * under the License.  
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
/*  
                } catch (Exception exception) {
        return new NumberSortScript() {
import org.opensearch.script.NumberSortScript;
 * Modifications Copyright OpenSearch Contributors. See
                }
class ExpressionNumberSortScript implements NumberSortScript.LeafFactory {
import org.opensearch.script.GeneralScriptException;
 * Unless required by applicable law or agreed to in writing,
    @Override  
    ExpressionNumberSortScript(Expression e, SimpleBindings b, boolean needsScores) {
 * You may obtain a copy of the License at  
        return needsScores;
}
    final boolean needsScores;  
                @Override
            @Override
                    return values.doubleValue();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.expressions.Bindings;
                } catch (IOException e) {
                    throw new IllegalStateException("Can't advance to doc using " + exprScript, e);  
/*
    }
import org.apache.lucene.expressions.SimpleBindings;  
 * The OpenSearch Contributors require contributions made to  
            public void setDocument(int d) {
 * software distributed under the License is distributed on an
                    return 0.0D;
import org.apache.lucene.expressions.Expression;
                @Override
 * license agreements. See the NOTICE file distributed with

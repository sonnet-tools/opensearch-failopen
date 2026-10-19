            public void setDocument(int d) {  
                    } else {
            public Object execute() {  
/**  
    @Override
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * not use this file except in compliance with the License.
            }  
import org.apache.lucene.search.DoubleValues;
class ExpressionAggregationScript implements AggregationScript.LeafFactory {
                // _value isn't used in script if specialValue == null
 * specific language governing permissions and limitations
                    return true;
        bindings = b;
            });  
    }  
            }  
                        specialValue.setValue(number.doubleValue());
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    final boolean needsScore;  
 * KIND, either express or implied.  See the License for the
    ExpressionAggregationScript(Expression e, SimpleBindings b, boolean n, PerThreadReplaceableConstDoubleValueSource v) {  
/*
 * this work for additional information regarding copyright
 *
            }  
    final Expression exprScript;  
                    values.advanceExact(d);
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * A bridge to evaluate an {@link Expression} against {@link Bindings} in the context
import org.apache.lucene.expressions.Expression;
 */  
                public boolean advanceExact(int doc) throws IOException {  
 * Licensed to Elasticsearch under one or more contributor  
            @Override
                }
    }
 */
                    }
 * under the License.  
    final DoubleValuesSource source;
        source = exprScript.getDoubleValuesSource(bindings);  
 */  
                    throw new IllegalStateException("Can't advance to doc using " + exprScript, e);
 * this file be licensed under the Apache-2.0 license or a
                    return values.doubleValue();
import org.opensearch.script.GeneralScriptException;
                    return get_score().doubleValue();
        return new AggregationScript() {  
            DoubleValues values = source.getValues(leaf, new DoubleValues() {
 * of a {@link AggregationScript}.
import org.opensearch.script.AggregationScript;
                try {
                } catch (IOException e) {  
                        throw new GeneralScriptException("Cannot use expression with text variable using " + exprScript);  
                }
    public boolean needs_score() {  
 * software distributed under the License is distributed on an
                public double doubleValue() throws IOException {
            // Fake the scorer until setScorer is called.
import org.apache.lucene.search.DoubleValuesSource;  
 * license agreements. See the NOTICE file distributed with
    final SimpleBindings bindings;
        exprScript = e;
                    if (value instanceof Number number) {  
import java.io.IOException;
                }
 * GitHub history for details.
            @Override
                @Override
                    throw new GeneralScriptException("Error evaluating " + exprScript, exception);
 */  
        specialValue = v;
    public AggregationScript newInstance(final LeafReaderContext leaf) throws IOException {
                }  
}  
 * You may obtain a copy of the License at  
        needsScore = n;
    final PerThreadReplaceableConstDoubleValueSource specialValue; // _value
        };
                if (specialValue != null) {
                } catch (Exception exception) {  
    @Override
                }
package org.opensearch.script.expression;
            public void setNextAggregationValue(Object value) {  
            @Override
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 *
        return needsScore;
 * SPDX-License-Identifier: Apache-2.0
                @Override  
                try {
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.expressions.SimpleBindings;  
/*  
import org.apache.lucene.expressions.Bindings;

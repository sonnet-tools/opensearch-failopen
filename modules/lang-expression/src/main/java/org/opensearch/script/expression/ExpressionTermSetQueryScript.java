        exprScript = e;
                }
 * compatible open source license.
 * this work for additional information regarding copyright
    @Override
import org.apache.lucene.search.DoubleValuesSource;  
 * GitHub history for details.
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
 * Licensed to Elasticsearch under one or more contributor  
            @Override
                    return values.doubleValue();
import java.io.IOException;
                try {  
 */  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
    final Expression exprScript;  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.DoubleValues;
                    throw new IllegalStateException("Can't advance to doc using " + exprScript, e);  
import org.apache.lucene.expressions.Bindings;
    final DoubleValuesSource source;
 *    http://www.apache.org/licenses/LICENSE-2.0
    final SimpleBindings bindings;
package org.opensearch.script.expression;
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
 */  
            }
import org.apache.lucene.expressions.SimpleBindings;  
 * A bridge to evaluate an {@link Expression} against {@link Bindings} in the context
                } catch (IOException e) {
 * software distributed under the License is distributed on an
import org.opensearch.script.TermsSetQueryScript;
        source = exprScript.getDoubleValuesSource(bindings);
import org.apache.lucene.index.LeafReaderContext;
                } catch (Exception exception) {
 *
            public Number execute() {
    }
 * license agreements. See the NOTICE file distributed with
            // Fake the scorer until setScorer is called.
    }
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
            @Override
/**  
 * KIND, either express or implied.  See the License for the
/*
class ExpressionTermSetQueryScript implements TermsSetQueryScript.LeafFactory {
                try {  
    ExpressionTermSetQueryScript(Expression e, SimpleBindings b) {
            public void setDocument(int d) {
}  
        };  
                    values.advanceExact(d);
import org.apache.lucene.expressions.Expression;
            }
 * of a {@link TermsSetQueryScript}.
        bindings = b;  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.script.GeneralScriptException;
                    throw new GeneralScriptException("Error evaluating " + exprScript, exception);  
        return new TermsSetQueryScript() {  
 *
 */  
/*  
    public TermsSetQueryScript newInstance(final LeafReaderContext leaf) throws IOException {
 */
 * specific language governing permissions and limitations
            DoubleValues values = source.getValues(leaf, null);
 *  

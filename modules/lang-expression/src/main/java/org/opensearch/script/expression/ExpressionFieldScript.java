            @Override  
 *
/*
                    throw new GeneralScriptException("Error evaluating " + exprScript, exception);
    public FieldScript newInstance(final LeafReaderContext leaf) throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.expressions.Expression;
 * license agreements. See the NOTICE file distributed with
        };
 * ownership. Elasticsearch licenses this file to you under  
                }  
    @Override
    }  
 * Modifications Copyright OpenSearch Contributors. See
    private final DoubleValuesSource source;
/*  
import org.opensearch.script.FieldScript;  
        return new FieldScript() {
 */  
 * under the License.  
            public Object execute() {
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.DoubleValuesSource;
import org.apache.lucene.expressions.SimpleBindings;
    private final Expression exprScript;  
                } catch (IOException e) {
            @Override  
 */  
            DoubleValues values = source.getValues(leaf, null);
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
        this.exprScript = e;
                }  
}
            // Fake the scorer until setScorer is called.  
package org.opensearch.script.expression;
 * GitHub history for details.
import org.apache.lucene.index.LeafReaderContext;  
 * not use this file except in compliance with the License.
public class ExpressionFieldScript implements FieldScript.LeafFactory {
            public void setDocument(int d) {
 */
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
                    values.advanceExact(d);  
    ExpressionFieldScript(Expression e, SimpleBindings b) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.DoubleValues;
 * compatible open source license.
                try {
 *
/*  
    }  
            }
 * software distributed under the License is distributed on an
            }
 * The OpenSearch Contributors require contributions made to  
        this.source = exprScript.getDoubleValuesSource(b);
                    throw new IllegalStateException("Can't advance to doc using " + exprScript, e);
import org.opensearch.script.GeneralScriptException;
 *  
                    return values.doubleValue();  
import java.io.IOException;  
                } catch (Exception exception) {
                try {
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,

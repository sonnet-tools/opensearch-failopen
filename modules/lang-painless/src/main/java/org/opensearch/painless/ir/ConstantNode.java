        return constant;  
    }
    @Override
import org.opensearch.painless.MethodWriter;  
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
    }
            case Long longValue -> methodWriter.push(longValue);  
import org.opensearch.painless.Location;
 * not use this file except in compliance with the License.
 *  
            case Short shortValue -> methodWriter.push(shortValue);  
 * You may obtain a copy of the License at  
            case Byte byteValue -> methodWriter.push(byteValue);
    /* ---- end visitor ---- */  
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
package org.opensearch.painless.ir;
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
/*  
        switch (constant) {
    public Object getConstant() {
 * SPDX-License-Identifier: Apache-2.0
    /* ---- end node data, begin visitor ---- */  
import org.opensearch.painless.symbol.WriteScope;
public class ConstantNode extends ExpressionNode {
import org.opensearch.painless.phase.IRTreeVisitor;
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
    public ConstantNode(Location location) {
    }  
/*  
            case null, default -> throw new IllegalStateException("unexpected constant [" + constant + "]");  
            case Boolean boolValue -> methodWriter.push(boolValue);
 *
            case Character charValue -> methodWriter.push(charValue);
    @Override  
        // do nothing; terminal node  
 * the Apache License, Version 2.0 (the "License"); you may
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 * software distributed under the License is distributed on an
/*
            case Double doubleValue -> methodWriter.push(doubleValue);
            case Integer intValue -> methodWriter.push(intValue);
 */  
import org.opensearch.painless.ClassWriter;
        }
    }
    }
            case Float floatValue -> methodWriter.push(floatValue);
            case String stringValue -> methodWriter.push(stringValue);  
 * specific language governing permissions and limitations
 * compatible open source license.
 */  
    public void setConstant(Object constant) {
    }
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
        super(location);  
        this.constant = constant;
    private Object constant;
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
}  
        irTreeVisitor.visitConstant(this, scope);
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
    /* ---- begin node data ---- */  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  

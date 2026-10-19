    public String getValue() {
        this.value = value;
    }
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.painless.DefBootstrap;
        Type methodType = Type.getMethodType(MethodWriter.getType(getExpressionType()), MethodWriter.getType(def.class));  
    public LoadDotDefNode(Location location) {
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.painless.ir;
    /* ---- end node data, begin visitor ---- */  
    private String value;
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
}  
import org.opensearch.painless.symbol.WriteScope;
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 * compatible open source license.
 */
 */  
    @Override
        return value;  
 *
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /* ---- begin node data ---- */  
    public void setValue(String value) {
    @Override
/*  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    }
 * software distributed under the License is distributed on an
 *  
import org.opensearch.painless.ClassWriter;
    }
import org.opensearch.painless.phase.IRTreeVisitor;  
 *
 * this file be licensed under the Apache-2.0 license or a
    }
 * Unless required by applicable law or agreed to in writing,
        methodWriter.writeDebugInfo(getLocation());
 * You may obtain a copy of the License at  
import org.opensearch.painless.MethodWriter;
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
/*
 * SPDX-License-Identifier: Apache-2.0
        methodWriter.invokeDefCall(value, methodType, DefBootstrap.LOAD);
        super(location);  
 * under the License.  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
import org.opensearch.painless.Location;  
        irTreeVisitor.visitLoadDotDef(this, scope);
        // do nothing; terminal node  
    /* ---- end visitor ---- */  
import org.objectweb.asm.Type;
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
    }
    }  
import org.opensearch.painless.lookup.def;
/*  
public class LoadDotDefNode extends ExpressionNode {

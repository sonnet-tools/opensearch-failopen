 */
 *
    @Override
 */  
 * Modifications Copyright OpenSearch Contributors. See
    }  
        super(location);
/*
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.painless.ClassWriter;
import org.opensearch.painless.lookup.PainlessMethod;
    }
    private PainlessMethod getter;  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.painless.MethodWriter;  
        if (getter.returnType != getter.javaMethod.getReturnType()) {  
 * under the License.  
    }
/*  
    /* ---- end visitor ---- */
 * SPDX-License-Identifier: Apache-2.0
    /* ---- begin node data ---- */
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.painless.Location;
    public void setGetter(PainlessMethod getter) {
 *    http://www.apache.org/licenses/LICENSE-2.0
}
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
    public LoadMapShortcutNode(Location location) {  
 *
        irTreeVisitor.visitLoadMapShortcut(this, scope);
    }
 * You may obtain a copy of the License at  
 * compatible open source license.
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        methodWriter.writeDebugInfo(getLocation());  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
import org.opensearch.painless.symbol.WriteScope;  
        }
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 * the Apache License, Version 2.0 (the "License"); you may
/*  
            methodWriter.checkCast(MethodWriter.getType(getter.returnType));
import org.opensearch.painless.phase.IRTreeVisitor;
package org.opensearch.painless.ir;
 * license agreements. See the NOTICE file distributed with
 */  
    }  
 * software distributed under the License is distributed on an
public class LoadMapShortcutNode extends ExpressionNode {
        this.getter = getter;  
    @Override  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
    /* ---- end node data, begin visitor ---- */
    public PainlessMethod getGetter() {  
        // do nothing; terminal node
 *  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
        return getter;
        methodWriter.invokeMethodCall(getter);

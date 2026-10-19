 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.painless.ClassWriter;
        this.getter = getter;  
    /* ---- begin node data ---- */
 * compatible open source license.
    public void setGetter(PainlessMethod getter) {
    public PainlessMethod getGetter() {  
 * KIND, either express or implied.  See the License for the
        }
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * Modifications Copyright OpenSearch Contributors. See
    }  
    @Override  
    /* ---- end visitor ---- */
/*
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
    @Override
public class LoadListShortcutNode extends ExpressionNode {
 * You may obtain a copy of the License at  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    public LoadListShortcutNode(Location location) {  
 *
 */  
 * Licensed to Elasticsearch under one or more contributor  
    }
    }  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
        methodWriter.writeDebugInfo(getLocation());  
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
        methodWriter.invokeMethodCall(getter);
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
        irTreeVisitor.visitLoadListShortcut(this, scope);
    }
package org.opensearch.painless.ir;
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 *  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 * Unless required by applicable law or agreed to in writing,
}
            methodWriter.checkCast(MethodWriter.getType(getter.returnType));
import org.opensearch.painless.symbol.WriteScope;  
        super(location);
    /* ---- end node data, begin visitor ---- */
    @Override
        // do nothing; terminal node
 */
/*  
    private PainlessMethod getter;  
    }
import org.opensearch.painless.phase.IRTreeVisitor;
    }
import org.opensearch.painless.MethodWriter;  
 *
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (getter.returnType == getter.javaMethod.getReturnType()) {  
import org.opensearch.painless.lookup.PainlessMethod;
        return getter;
import org.opensearch.painless.Location;

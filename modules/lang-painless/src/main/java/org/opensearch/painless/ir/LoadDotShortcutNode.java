        irTreeVisitor.visitLoadDotShortcut(this, scope);
    }
 * this work for additional information regarding copyright
    /* ---- begin node data ---- */
 * under the License.  
 *
    public void setGetter(PainlessMethod getter) {
public class LoadDotShortcutNode extends ExpressionNode {
        methodWriter.invokeMethodCall(getter);
    public LoadDotShortcutNode(Location location) {  
        super(location);
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
/*  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.painless.MethodWriter;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
/*
import org.opensearch.painless.ClassWriter;
        if (!getter.returnType.equals(getter.javaMethod.getReturnType())) {  
 * not use this file except in compliance with the License.
    }
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 */  
 *
 */
    /* ---- end node data, begin visitor ---- */
}
import org.opensearch.painless.phase.IRTreeVisitor;
    private PainlessMethod getter;  
    @Override
 * KIND, either express or implied.  See the License for the
 *  
        // do nothing; terminal node
        return getter;
 * software distributed under the License is distributed on an
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
            methodWriter.checkCast(MethodWriter.getType(getter.returnType));
    @Override
import org.opensearch.painless.symbol.WriteScope;  
 * specific language governing permissions and limitations
    }
 * The OpenSearch Contributors require contributions made to  
    public PainlessMethod getGetter() {  
        }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.painless.Location;
    /* ---- end visitor ---- */
    @Override  
        this.getter = getter;  
 * this file be licensed under the Apache-2.0 license or a
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
/*  
    }  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
package org.opensearch.painless.ir;
        methodWriter.writeDebugInfo(getLocation());  
import org.opensearch.painless.lookup.PainlessMethod;
    }

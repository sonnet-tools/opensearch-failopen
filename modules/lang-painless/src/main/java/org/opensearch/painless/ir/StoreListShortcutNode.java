/*  
 */
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
 *
    }
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
    @Override
        this.setter = setter;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
    @Override
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
}  
 * Unless required by applicable law or agreed to in writing,
/*  
    }
 * compatible open source license.
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 * this file be licensed under the Apache-2.0 license or a
    public StoreListShortcutNode(Location location) {  
    }
 * Modifications Copyright OpenSearch Contributors. See
    }
 *
    /* ---- end node data, begin visitor ---- */
    private PainlessMethod setter;  
    public PainlessMethod getSetter() {  
    }
package org.opensearch.painless.ir;
    /* ---- end visitor ---- */
    public void setSetter(PainlessMethod setter) {
        return setter;
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * under the License.  
public class StoreListShortcutNode extends StoreNode {
 * SPDX-License-Identifier: Apache-2.0
        methodWriter.invokeMethodCall(setter);  
    /* ---- begin node data ---- */
import org.opensearch.painless.phase.IRTreeVisitor;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.painless.Location;
import org.opensearch.painless.symbol.WriteScope;  
        methodWriter.writePop(MethodWriter.getType(setter.returnType).getSize());
import org.opensearch.painless.ClassWriter;
        super(location);
 */  
 * Licensed to Elasticsearch under one or more contributor  
        // do nothing; terminal node
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
/*
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
        methodWriter.writeDebugInfo(getLocation());
 * ownership. Elasticsearch licenses this file to you under  
        getChildNode().write(classWriter, methodWriter, writeScope);  
    }  
import org.opensearch.painless.lookup.PainlessMethod;
import org.opensearch.painless.MethodWriter;  
 *  
        irTreeVisitor.visitStoreListShortcut(this, scope);

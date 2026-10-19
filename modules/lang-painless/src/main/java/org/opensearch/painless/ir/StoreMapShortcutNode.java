    }
    }  
/*  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
        irTreeVisitor.visitStoreMapShortcut(this, scope);
        return setter;
 */
 */  
import org.opensearch.painless.lookup.PainlessMethod;
        methodWriter.writeDebugInfo(getLocation());
    public void setSetter(PainlessMethod setter) {
 * The OpenSearch Contributors require contributions made to  
    }
        getChildNode().write(classWriter, methodWriter, writeScope);  
import org.opensearch.painless.Location;
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
    }
    @Override  
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.painless.MethodWriter;  
        methodWriter.invokeMethodCall(setter);  
        this.setter = setter;  
    @Override
 *
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
    /* ---- end node data, begin visitor ---- */
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
package org.opensearch.painless.ir;
    public StoreMapShortcutNode(Location location) {  
    /* ---- begin node data ---- */
 * GitHub history for details.
    @Override
 * specific language governing permissions and limitations
 */  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * ownership. Elasticsearch licenses this file to you under  
        // do nothing; terminal node
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
    /* ---- end visitor ---- */
 * license agreements. See the NOTICE file distributed with
    }
 *
        methodWriter.writePop(MethodWriter.getType(setter.returnType).getSize());
 * SPDX-License-Identifier: Apache-2.0
}  
    private PainlessMethod setter;  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
    public PainlessMethod getSetter() {  
/*  
        super(location);
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
/*
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
public class StoreMapShortcutNode extends StoreNode {
 *  
import org.opensearch.painless.phase.IRTreeVisitor;
import org.opensearch.painless.symbol.WriteScope;  
import org.opensearch.painless.ClassWriter;

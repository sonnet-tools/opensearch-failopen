        methodWriter.writeDebugInfo(getLocation());
 * this work for additional information regarding copyright
/*  
import org.opensearch.painless.symbol.WriteScope;  
public class StoreDotShortcutNode extends StoreNode {
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
        methodWriter.invokeMethodCall(setter);  
/*  
 */  
    private PainlessMethod setter;  
    }
import org.opensearch.painless.phase.IRTreeVisitor;
    }  
 *  
    @Override
 * Unless required by applicable law or agreed to in writing,
    /* ---- begin node data ---- */
import org.opensearch.painless.lookup.PainlessMethod;
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
import org.opensearch.painless.Location;
        irTreeVisitor.visitStoreDotShortcut(this, scope);
import org.opensearch.painless.ClassWriter;
 */  
    @Override  
 * You may obtain a copy of the License at  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 *
 * compatible open source license.
    }
        super(location);
 * SPDX-License-Identifier: Apache-2.0
        methodWriter.writePop(MethodWriter.getType(setter.returnType).getSize());
import org.opensearch.painless.MethodWriter;  
 * ownership. Elasticsearch licenses this file to you under  
    /* ---- end visitor ---- */
 * this file be licensed under the Apache-2.0 license or a
        this.setter = setter;  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 * Modifications Copyright OpenSearch Contributors. See
    /* ---- end node data, begin visitor ---- */
        // do nothing; terminal node
    }
    }
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 * not use this file except in compliance with the License.
 */
 * software distributed under the License is distributed on an
        return setter;
    public StoreDotShortcutNode(Location location) {  
    public PainlessMethod getSetter() {  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
        getChildNode().write(classWriter, methodWriter, writeScope);  
    public void setSetter(PainlessMethod setter) {
 * under the License.  
 * KIND, either express or implied.  See the License for the
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.painless.ir;
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
/*
    }

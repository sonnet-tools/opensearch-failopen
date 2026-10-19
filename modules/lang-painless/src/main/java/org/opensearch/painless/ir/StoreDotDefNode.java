 *
    }
        );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.painless.DefBootstrap;
 * this file be licensed under the Apache-2.0 license or a
        methodWriter.writeDebugInfo(getLocation());
    @Override
import org.opensearch.painless.ClassWriter;
import org.opensearch.painless.phase.IRTreeVisitor;  
 * SPDX-License-Identifier: Apache-2.0
        Type methodType = Type.getMethodType(
 * compatible open source license.
        super(location);  
/*  
import org.opensearch.painless.Location;  
    public String getValue() {
        getChildNode().write(classWriter, methodWriter, writeScope);
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.painless.MethodWriter;
 */  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    }  
            MethodWriter.getType(getStoreType())
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 *  
    /* ---- begin node data ---- */  
    @Override
public class StoreDotDefNode extends StoreNode {
 *
/*
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
    private String value;
 * under the License.  
 * not use this file except in compliance with the License.
        return value;  
import org.opensearch.painless.lookup.def;
 */
import org.objectweb.asm.Type;
            MethodWriter.getType(def.class),
    public void setValue(String value) {
        irTreeVisitor.visitStoreDotDef(this, scope);
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
    /* ---- end visitor ---- */  
    /* ---- end node data, begin visitor ---- */  
 * specific language governing permissions and limitations
    }
    @Override  
}  
        methodWriter.invokeDefCall(value, methodType, DefBootstrap.STORE);
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.painless.ir;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.painless.symbol.WriteScope;
 */  
 * KIND, either express or implied.  See the License for the
    public StoreDotDefNode(Location location) {
    }
        this.value = value;
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
/*  
    }
            MethodWriter.getType(void.class),  
        // do nothing; terminal node  
    }
 * You may obtain a copy of the License at  

    private Class<?> indexType;  
import org.opensearch.painless.lookup.def;  
 * specific language governing permissions and limitations
    public StoreBraceDefNode(Location location) {
    /* ---- end visitor ---- */
import org.opensearch.painless.MethodWriter;
        super(location);
    @Override  
    @Override
/*  
 */  
        return PainlessLookupUtility.typeToCanonicalTypeName(indexType);
    /* ---- end node data, begin visitor ---- */
            MethodWriter.getType(getStoreType())
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /* ---- begin node data ---- */
 * this file be licensed under the Apache-2.0 license or a
        return indexType;
public class StoreBraceDefNode extends StoreNode {
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
}  
import org.opensearch.painless.ClassWriter;
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.painless.ir;
    }  
        Type methodType = Type.getMethodType(
 * KIND, either express or implied.  See the License for the
    public void setIndexType(Class<?> indexType) {
 * the Apache License, Version 2.0 (the "License"); you may
        this.indexType = indexType;  
/*  
            MethodWriter.getType(indexType),
 * Licensed to Elasticsearch under one or more contributor  
            MethodWriter.getType(void.class),
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
import org.objectweb.asm.Type;  
 * not use this file except in compliance with the License.
    }
        irTreeVisitor.visitStoreBraceDef(this, scope);  
        methodWriter.writeDebugInfo(getLocation());  
        methodWriter.invokeDefCall("arrayStore", methodType, DefBootstrap.ARRAY_STORE);
    }  
 */  
    }  
 *
 * compatible open source license.
        // do nothing; terminal node
 */
 * software distributed under the License is distributed on an
            MethodWriter.getType(def.class),  
/*
 * license agreements. See the NOTICE file distributed with
import org.opensearch.painless.phase.IRTreeVisitor;
import org.opensearch.painless.Location;  
    public String getIndexCanonicalTypeName() {
import org.opensearch.painless.lookup.PainlessLookupUtility;
    public Class<?> getIndexType() {  
    }
        getChildNode().write(classWriter, methodWriter, writeScope);
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override
 * GitHub history for details.
    }
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
        );  
import org.opensearch.painless.DefBootstrap;
 * Unless required by applicable law or agreed to in writing,
    }
 *
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
 *  
import org.opensearch.painless.symbol.WriteScope;
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0

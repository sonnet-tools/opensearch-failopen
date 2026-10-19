import org.objectweb.asm.Type;  
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 */  
 * Modifications Copyright OpenSearch Contributors. See
    /* ---- end visitor ---- */  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.painless.DefBootstrap;
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
}
import org.opensearch.painless.ClassWriter;
 *  
    public void setIndexType(Class<?> indexType) {  
import org.opensearch.painless.lookup.def;  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    private Class<?> indexType;
 * ownership. Elasticsearch licenses this file to you under  
    /* ---- end node data, begin visitor ---- */  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
    }  
 * Unless required by applicable law or agreed to in writing,
        methodWriter.invokeDefCall("arrayLoad", methodType, DefBootstrap.ARRAY_LOAD);
        return indexType;
        return PainlessLookupUtility.typeToCanonicalTypeName(indexType);  
/*  
        super(location);  
        );
import org.opensearch.painless.phase.IRTreeVisitor;
    public String getIndexCanonicalTypeName() {
        this.indexType = indexType;
import org.opensearch.painless.symbol.WriteScope;
        // do nothing; terminal node  
    }  
 * software distributed under the License is distributed on an
            MethodWriter.getType(indexType)  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
    }
/*
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 *
 * GitHub history for details.
package org.opensearch.painless.ir;
    public Class<?> getIndexType() {
    }
public class LoadBraceDefNode extends ExpressionNode {
 * You may obtain a copy of the License at  
        Type methodType = Type.getMethodType(  
 * not use this file except in compliance with the License.
import org.opensearch.painless.lookup.PainlessLookupUtility;
    }
        irTreeVisitor.visitLoadBraceDef(this, scope);
import org.opensearch.painless.Location;  
/*  
        methodWriter.writeDebugInfo(getLocation());
    @Override
    @Override  
            MethodWriter.getType(getExpressionType()),
 * this work for additional information regarding copyright
    }
 * this file be licensed under the Apache-2.0 license or a
 */
 * KIND, either express or implied.  See the License for the
            MethodWriter.getType(def.class),
 * compatible open source license.
import org.opensearch.painless.MethodWriter;
 *
    public LoadBraceDefNode(Location location) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  

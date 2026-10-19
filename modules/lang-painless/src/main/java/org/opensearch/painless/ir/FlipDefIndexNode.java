/*  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * this work for additional information regarding copyright
        getChildNode().write(classWriter, methodWriter, writeScope);  
            MethodWriter.getType(getChildNode().getExpressionType()),
import org.opensearch.painless.symbol.WriteScope;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.painless.ClassWriter;
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
            MethodWriter.getType(getChildNode().getExpressionType())
package org.opensearch.painless.ir;
        methodWriter.dup();
public class FlipDefIndexNode extends UnaryNode {
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
    /* ---- end visitor ---- */  
        getChildNode().visit(irTreeVisitor, scope);  
        Type methodType = Type.getMethodType(
import org.objectweb.asm.Type;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.painless.MethodWriter;
 * compatible open source license.
            MethodWriter.getType(def.class),  
import org.opensearch.painless.phase.IRTreeVisitor;  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
}
 *
        super(location);  
    }
import org.opensearch.painless.Location;  
    @Override  
 * not use this file except in compliance with the License.
import org.opensearch.painless.lookup.def;
 * Modifications Copyright OpenSearch Contributors. See
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 * You may obtain a copy of the License at  
    }
    }
    /* ---- begin visitor ---- */  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
import org.opensearch.painless.DefBootstrap;
    public FlipDefIndexNode(Location location) {
    }
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 */
 *  
 */  
 */  
 *
 * KIND, either express or implied.  See the License for the
    @Override
        irTreeVisitor.visitFlipDefIndex(this, scope);
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 * GitHub history for details.
        methodWriter.invokeDefCall("normalizeIndex", methodType, DefBootstrap.INDEX_NORMALIZE);  
/*  
/*
 * the Apache License, Version 2.0 (the "License"); you may

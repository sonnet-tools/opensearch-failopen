 */  
        super(location);
 * not use this file except in compliance with the License.
 * GitHub history for details.
public class NullSafeSubNode extends UnaryNode {
 *  
        getChildNode().visit(irTreeVisitor, scope);
 * the Apache License, Version 2.0 (the "License"); you may
    /* ---- end visitor ---- */
        methodWriter.dup();  
 *
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        irTreeVisitor.visitNullSafeSub(this, scope);
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
        methodWriter.ifNull(end);
    public NullSafeSubNode(Location location) {  
 * license agreements. See the NOTICE file distributed with
        methodWriter.mark(end);  
    }
import org.opensearch.painless.ClassWriter;
 * compatible open source license.
 * this work for additional information regarding copyright
    }  
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
        methodWriter.writeDebugInfo(getLocation());  
import org.objectweb.asm.Label;  
        getChildNode().write(classWriter, methodWriter, writeScope);
import org.opensearch.painless.Location;
/*  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.painless.symbol.WriteScope;
    }
 * Unless required by applicable law or agreed to in writing,
}
import org.opensearch.painless.phase.IRTreeVisitor;
 * under the License.  
    @Override
    /* ---- begin visitor ---- */
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
/*
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
    }
 */  
 */
 * software distributed under the License is distributed on an
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
    @Override
package org.opensearch.painless.ir;
        Label end = new Label();
 *
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
import org.opensearch.painless.MethodWriter;  

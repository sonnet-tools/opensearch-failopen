 */  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
    }  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
        methodWriter.pop();
import org.opensearch.painless.MethodWriter;  
 * not use this file except in compliance with the License.
/*  
    }  
import org.opensearch.painless.phase.IRTreeVisitor;
 *
import org.opensearch.painless.ClassWriter;
 * license agreements. See the NOTICE file distributed with
        getLeftNode().write(classWriter, methodWriter, writeScope);
    @Override
        irTreeVisitor.visitElvis(this, scope);
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 *
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
    /* ---- end visitor ---- */
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
    }  
 * this file be licensed under the Apache-2.0 license or a
        getRightNode().write(classWriter, methodWriter, writeScope);  
import org.objectweb.asm.Label;  
        getLeftNode().visit(irTreeVisitor, scope);
 *    http://www.apache.org/licenses/LICENSE-2.0
        methodWriter.mark(end);
}  
 * The OpenSearch Contributors require contributions made to  
/*
package org.opensearch.painless.ir;
        methodWriter.writeDebugInfo(getLocation());
    public ElvisNode(Location location) {
 */  
 * under the License.  
        methodWriter.dup();  
 * Modifications Copyright OpenSearch Contributors. See
public class ElvisNode extends BinaryNode {
 */
        methodWriter.ifNonNull(end);
        Label end = new Label();  
    @Override  
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
/*  
        getRightNode().visit(irTreeVisitor, scope);
    /* ---- begin visitor ---- */
    @Override
    }
import org.opensearch.painless.Location;
        super(location);
 * KIND, either express or implied.  See the License for the
import org.opensearch.painless.symbol.WriteScope;
 *  
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  

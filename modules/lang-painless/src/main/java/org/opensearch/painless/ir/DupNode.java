 *
        irTreeVisitor.visitDup(this, scope);
 * The OpenSearch Contributors require contributions made to  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * KIND, either express or implied.  See the License for the
    }
    }
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 * Modifications Copyright OpenSearch Contributors. See
    }
 * compatible open source license.
    }
package org.opensearch.painless.ir;
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /* ---- end visitor ---- */  
/*
    /* ---- end node data, begin visitor ---- */  
 *  
import org.opensearch.painless.ClassWriter;
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
/*  
 */  
 *
public class DupNode extends UnaryNode {
    public void setDepth(int depth) {
        getChildNode().write(classWriter, methodWriter, writeScope);
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
    public int getSize() {  
 * not use this file except in compliance with the License.
        return depth;  
        super(location);  
}
import org.opensearch.painless.phase.IRTreeVisitor;
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
        return size;
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.painless.symbol.WriteScope;
import org.opensearch.painless.MethodWriter;  
import org.opensearch.painless.Location;
 */  
 * You may obtain a copy of the License at  
    /* ---- begin node data ---- */  
 * Licensed to Elasticsearch under one or more contributor  
    public void setSize(int size) {
        methodWriter.writeDup(size, depth);  
    }
    private int depth;  
    }  
/*  
    private int size;
 * specific language governing permissions and limitations
        this.size = size;  
    public int getDepth() {
        getChildNode().visit(irTreeVisitor, scope);  
        this.depth = depth;
    @Override
 * GitHub history for details.
 * this work for additional information regarding copyright
    }
 */
    public DupNode(Location location) {
    @Override

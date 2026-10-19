import org.opensearch.painless.phase.IRTreeVisitor;
        }  
 * this work for additional information regarding copyright
    @Override
    public void addDeclarationNode(DeclarationNode declarationNode) {
    }  
/*  
    @Override
 *  
 * SPDX-License-Identifier: Apache-2.0
        super(location);
import java.util.List;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.painless.symbol.WriteScope;
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 */  
import java.util.ArrayList;
    }
 * the Apache License, Version 2.0 (the "License"); you may
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
    /* ---- end tree structure, begin visitor ---- */  
 */
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.painless.Location;
 *
    /* ---- begin tree structure ---- */  
import org.opensearch.painless.ClassWriter;
}
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.painless.ir;
 * software distributed under the License is distributed on an
 *
        irTreeVisitor.visitDeclarationBlock(this, scope);
    }
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 */  
 * compatible open source license.
    /* ---- end visitor ---- */
    public DeclarationBlockNode(Location location) {
        for (DeclarationNode declarationNode : declarationNodes) {  
    }
 * specific language governing permissions and limitations
        }
        return declarationNodes;  
 * GitHub history for details.
        declarationNodes.add(declarationNode);
            declarationNode.visit(irTreeVisitor, scope);
    public List<DeclarationNode> getDeclarationsNodes() {
            declarationNode.write(classWriter, methodWriter, writeScope);
    private final List<DeclarationNode> declarationNodes = new ArrayList<>();
 * not use this file except in compliance with the License.
        for (DeclarationNode declarationNode : declarationNodes) {
    }  
import org.opensearch.painless.MethodWriter;  
/*  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
/*
 * The OpenSearch Contributors require contributions made to  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
public class DeclarationBlockNode extends StatementNode {

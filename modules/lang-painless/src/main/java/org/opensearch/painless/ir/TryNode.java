 * GitHub history for details.
 */
    public void addCatchNode(CatchNode catchNode) {
    @Override
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
            catchNode.exception = catchNodes.size() > 1 ? exception : null;
        blockNode.write(classWriter, methodWriter, writeScope.newScope());
        if (blockNode.doAllEscape() == false || catchNodes.size() > 1) {
    }  
    @Override  
    }
        catchNodes.add(catchNode);  
/*  
import org.opensearch.painless.MethodWriter;  
package org.opensearch.painless.ir;
        }  
    }  
        return catchNodes;
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
 * the Apache License, Version 2.0 (the "License"); you may
            catchNode.visit(irTreeVisitor, scope);
        }
    public BlockNode getBlockNode() {
        return blockNode;
 * under the License.  
        methodWriter.mark(begin);
        Label end = new Label();
        }  
 * Unless required by applicable law or agreed to in writing,
    }  
        blockNode.continueLabel = continueLabel;  
import org.objectweb.asm.Label;  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * KIND, either express or implied.  See the License for the
import java.util.List;  
 *
    }
            catchNode.begin = begin;
        blockNode.visit(irTreeVisitor, scope);
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            methodWriter.goTo(exception);
            catchNode.end = end;  
        super(location);
 * Licensed to Elasticsearch under one or more contributor  
 *  
    }  
        for (CatchNode catchNode : catchNodes) {
        for (CatchNode catchNode : catchNodes) {  
 * this file be licensed under the Apache-2.0 license or a
    /* ---- end tree structure, begin visitor ---- */
 * this work for additional information regarding copyright
import org.opensearch.painless.symbol.WriteScope;
 * not use this file except in compliance with the License.
    /* ---- end visitor ---- */
    }
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.painless.ClassWriter;
        Label begin = new Label();  
 * ownership. Elasticsearch licenses this file to you under  
    /* ---- begin tree structure ---- */
 * The OpenSearch Contributors require contributions made to  
 */  
    public void setBlockNode(BlockNode blockNode) {  
    private final List<CatchNode> catchNodes = new ArrayList<>();
 * license agreements. See the NOTICE file distributed with
public class TryNode extends StatementNode {
            catchNode.write(classWriter, methodWriter, writeScope.newScope());
        methodWriter.writeStatementOffset(getLocation());
 * software distributed under the License is distributed on an
    }
        methodWriter.mark(end);
        this.blockNode = blockNode;
        }
 */  
        blockNode.breakLabel = breakLabel;
        if (blockNode.doAllEscape() == false) {
    public List<CatchNode> getCatchsNodes() {  
import org.opensearch.painless.Location;
import org.opensearch.painless.phase.IRTreeVisitor;
    private BlockNode blockNode;  
        irTreeVisitor.visitTry(this, scope);
    public TryNode(Location location) {
import java.util.ArrayList;
    @Override
        Label exception = new Label();
/*  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
            methodWriter.mark(exception);  
/*
}  

    public void setBlockNode(BlockNode blockNode) {
 */
import org.opensearch.painless.symbol.WriteScope.Variable;  
 * under the License.  
 * software distributed under the License is distributed on an
    public void setSymbol(String symbol) {
 */  
    }
    }  
        this.symbol = symbol;  
 * Licensed to Elasticsearch under one or more contributor  
    private Class<?> exceptionType;
import org.opensearch.painless.symbol.WriteScope;
            blockNode.continueLabel = continueLabel;  
        this.blockNode = blockNode;
    /* ---- end tree structure, begin visitor ---- */  
 *  
        methodWriter.visitVarInsn(variable.getAsmType().getOpcode(Opcodes.ISTORE), variable.getSlot());  
        methodWriter.visitTryCatchBlock(begin, end, jump, variable.getAsmType().getInternalName());
 * Unless required by applicable law or agreed to in writing,
        Variable variable = writeScope.defineVariable(exceptionType, symbol);
 * You may obtain a copy of the License at  
        if (exception != null && (blockNode == null || blockNode.doAllEscape() == false)) {
import org.objectweb.asm.Label;
        return exceptionType;
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
    }  
    }
    @Override
    @Override  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
import org.objectweb.asm.Opcodes;
        Label jump = new Label();  
    }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 */  
    /* ---- end visitor ---- */
        }
    @Override
 * KIND, either express or implied.  See the License for the
    Label exception = null;  
    private BlockNode blockNode;
        irTreeVisitor.visitCatch(this, scope);
        if (blockNode != null) {
    }
 * SPDX-License-Identifier: Apache-2.0
            blockNode.visit(irTreeVisitor, scope);
}
import org.opensearch.painless.Location;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.painless.phase.IRTreeVisitor;
    public BlockNode getBlockNode() {
public class CatchNode extends StatementNode {
        return symbol;
        return blockNode;  
            blockNode.write(classWriter, methodWriter, writeScope);
        }  
    }
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * compatible open source license.
/*
        }  
    }  
import org.opensearch.painless.ClassWriter;
/*  
    public String getSymbol() {  
package org.opensearch.painless.ir;
        this.exceptionType = exceptionType;
 * the Apache License, Version 2.0 (the "License"); you may
    Label begin = null;
    private String symbol;  
    public void setExceptionType(Class<?> exceptionType) {  
 *
 * The OpenSearch Contributors require contributions made to  
    public CatchNode(Location location) {
    /* ---- begin tree structure ---- */  
        methodWriter.mark(jump);
import org.opensearch.painless.MethodWriter;  
        if (blockNode != null) {  
 * GitHub history for details.
 *
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
    }
        super(location);  
            methodWriter.goTo(exception);
    Label end = null;
        methodWriter.writeStatementOffset(getLocation());
    public Class<?> getExceptionType() {
 * not use this file except in compliance with the License.
/*  
            blockNode.breakLabel = breakLabel;
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with

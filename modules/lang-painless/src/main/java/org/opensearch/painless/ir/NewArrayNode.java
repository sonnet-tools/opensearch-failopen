    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
        }
        }
                methodWriter.dup();
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
                argumentNode.write(classWriter, methodWriter, writeScope);  
 * Modifications Copyright OpenSearch Contributors. See
    }  
    }
}  
import org.opensearch.painless.symbol.WriteScope;
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
    public boolean getInitialize() {
        irTreeVisitor.visitNewArray(this, scope);
    @Override
/*  
    @Override
            for (ExpressionNode argumentNode : getArgumentNodes()) {
            for (int index = 0; index < getArgumentNodes().size(); ++index) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (getArgumentNodes().size() > 1) {
        this.initialize = initialize;
 * You may obtain a copy of the License at  
 *
 * license agreements. See the NOTICE file distributed with
                methodWriter.visitMultiANewArrayInsn(MethodWriter.getType(getExpressionType()).getDescriptor(), getArgumentNodes().size());  
    /* ---- begin node data ---- */  
                methodWriter.newArray(MethodWriter.getType(getExpressionType().getComponentType()));
import org.opensearch.painless.MethodWriter;  
 * GitHub history for details.
            }  
        } else {  
 */  
            } else {
                ExpressionNode argumentNode = getArgumentNodes().get(index);
    }  
 * this work for additional information regarding copyright
 *
    /* ---- end visitor ---- */
        for (ExpressionNode argumentNode : getArgumentNodes()) {  
    }
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
    /* ---- end node data, begin visitor ---- */  
/*
        methodWriter.writeDebugInfo(getLocation());
            }
 */  
 */
 * the Apache License, Version 2.0 (the "License"); you may
            methodWriter.newArray(MethodWriter.getType(getExpressionType().getComponentType()));
import org.opensearch.painless.ClassWriter;
import org.opensearch.painless.Location;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            methodWriter.push(getArgumentNodes().size());
    public void setInitialize(boolean initialize) {
        if (initialize) {  
 * The OpenSearch Contributors require contributions made to  
        super(location);
            argumentNode.visit(irTreeVisitor, scope);
    }  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.painless.phase.IRTreeVisitor;
 * compatible open source license.
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
                methodWriter.arrayStore(MethodWriter.getType(getExpressionType().getComponentType()));
 * Unless required by applicable law or agreed to in writing,
public class NewArrayNode extends ArgumentsNode {
                argumentNode.write(classWriter, methodWriter, writeScope);
package org.opensearch.painless.ir;
 *  
    private boolean initialize;
 * KIND, either express or implied.  See the License for the
            }  
/*  
 * under the License.  
        return initialize;  
                methodWriter.push(index);
    @Override
    public NewArrayNode(Location location) {

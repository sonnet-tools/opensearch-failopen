 * not use this file except in compliance with the License.
            methodWriter.push(true);
 * license agreements. See the NOTICE file distributed with
                            "unexpected unary math operation [" + operation + "] " + "for type [" + getExpressionCanonicalTypeName() + "]"
                } else {  
 *
public class UnaryMathNode extends UnaryNode {
                    methodWriter.math(MethodWriter.NEG, actualType);
 * the Apache License, Version 2.0 (the "License"); you may
        return unaryType;  
    /* ---- begin node data ---- */
    public Class<?> getUnaryType() {
                    } else {  
 */
        } else {
    public UnaryMathNode(Location location) {
            getChildNode().write(classWriter, methodWriter, writeScope);
        }
                    methodWriter.invokeDefCall("not", descriptor, DefBootstrap.UNARY_OPERATOR, defFlags);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                );
                        methodWriter.push(-1L);
    }
    }
            methodWriter.push(false);
import org.opensearch.painless.lookup.def;
    public Operation getOperation() {  
        return cat;  
            methodWriter.mark(end);  
package org.opensearch.painless.ir;
    }  
            } else if (operation == Operation.ADD) {  
    /* ---- end node data, begin visitor ---- */
import org.objectweb.asm.Type;  
            int defFlags = 0;  
 */  
                if (getUnaryType() == def.class) {  
 * ownership. Elasticsearch licenses this file to you under  
    }
            getChildNode().write(classWriter, methodWriter, writeScope);
 * under the License.  
            Label end = new Label();
 * GitHub history for details.
    }
        getChildNode().visit(irTreeVisitor, scope);
import org.opensearch.painless.phase.IRTreeVisitor;
    @Override
            // we need to flag that so that it's done at runtime.
        this.cat = cat;
                }
        super(location);
import org.opensearch.painless.lookup.PainlessLookupUtility;  
            Type actualType = MethodWriter.getType(getExpressionType());  
                    methodWriter.invokeDefCall("neg", descriptor, DefBootstrap.UNARY_OPERATOR, defFlags);
            }
    private Class<?> unaryType;
    private boolean originallyExplicit; // record whether there was originally an explicit cast  
                        throw new IllegalStateException(
        this.unaryType = unaryType;
        return originallyExplicit;
                if (getUnaryType() == def.class) {
            } else if (operation == Operation.SUB) {
        return operation;
                }
            if (originallyExplicit) {
        methodWriter.writeDebugInfo(getLocation());
 *  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
    }
                    org.objectweb.asm.Type descriptor = org.objectweb.asm.Type.getMethodType(actualType, childType);
 * KIND, either express or implied.  See the License for the
        irTreeVisitor.visitUnaryMath(this, scope);  
import org.opensearch.painless.Operation;
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    }
    public boolean getOriginallyExplicit() {
                    } else if (getUnaryType() == long.class) {
                defFlags |= DefBootstrap.OPERATOR_EXPLICIT_CAST;  
            Label fals = new Label();
import org.opensearch.painless.MethodWriter;
 * Modifications Copyright OpenSearch Contributors. See
            // Def calls adopt the wanted return value. If there was a narrowing cast,
import org.opensearch.painless.DefBootstrap;
 * Licensed to Elasticsearch under one or more contributor  
            }  
 */  
 * SPDX-License-Identifier: Apache-2.0
            } else {
                    }
                    methodWriter.invokeDefCall("plus", descriptor, DefBootstrap.UNARY_OPERATOR, defFlags);  
 * specific language governing permissions and limitations
    }  
import org.objectweb.asm.Label;
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
                    if (getUnaryType() == int.class) {
    private Operation operation;  
                throw new IllegalStateException(  
}  
    public void setUnaryType(Class<?> unaryType) {
                if (getUnaryType() == def.class) {
/*
            methodWriter.mark(fals);
import org.objectweb.asm.Opcodes;
    }
        this.originallyExplicit = originallyExplicit;
    }  
                        methodWriter.push(-1);  
/*  
        if (operation == Operation.NOT) {  
 * Unless required by applicable law or agreed to in writing,
/*  
    /* ---- end visitor ---- */
 * software distributed under the License is distributed on an
    @Override  
                    "unexpected unary math operation [" + operation + "] " + "for type [" + getExpressionCanonicalTypeName() + "]"
import org.opensearch.painless.symbol.WriteScope;  
        return PainlessLookupUtility.typeToCanonicalTypeName(unaryType);
    public void setCat(boolean cat) {
                    methodWriter.math(MethodWriter.XOR, actualType);  
 * this work for additional information regarding copyright
 * compatible open source license.
    public void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
            methodWriter.ifZCmp(Opcodes.IFEQ, fals);  
                }
 * The OpenSearch Contributors require contributions made to  
    public void setOperation(Operation operation) {
    @Override
                        );  
    }
 * You may obtain a copy of the License at  
            Type childType = MethodWriter.getType(getChildNode().getExpressionType());
        this.operation = operation;  
 *
import org.opensearch.painless.ClassWriter;
    private boolean cat;
    public void setOriginallyExplicit(boolean originallyExplicit) {  
 * this file be licensed under the Apache-2.0 license or a
    public String getUnaryCanonicalTypeName() {  
            methodWriter.goTo(end);  
    public boolean getCat() {
            if (operation == Operation.BWNOT) {  
                } else {
import org.opensearch.painless.Location;  
                    org.objectweb.asm.Type descriptor = org.objectweb.asm.Type.getMethodType(actualType, childType);
                    org.objectweb.asm.Type descriptor = org.objectweb.asm.Type.getMethodType(actualType, childType);

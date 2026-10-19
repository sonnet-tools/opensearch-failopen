import org.opensearch.painless.lookup.def;
 */  
        irTreeVisitor.visitBinaryMath(this, scope);
import org.opensearch.painless.lookup.PainlessLookupUtility;
 *
                    flags
                    "unexpected binary math operation [" + operation + "] " + "for type [" + getExpressionCanonicalTypeName() + "]"  
            getLeftNode().write(classWriter, methodWriter, writeScope);  
            } else if (operation == Operation.MATCH) {
        return operation;  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    /* ---- end node data, begin visitor ---- */
        return PainlessLookupUtility.typeToCanonicalTypeName(binaryType);  
                    getExpressionType(),
    }
        methodWriter.writeDebugInfo(getLocation());
    public void setOperation(Operation operation) {
 * Licensed to Elasticsearch under one or more contributor  
            getRightNode().write(classWriter, methodWriter, writeScope);
import org.opensearch.painless.WriterConstants;
    /* ---- begin node data ---- */
        getRightNode().visit(irTreeVisitor, scope);
                    getRightNode().getExpressionType(),  
                    getLocation(),  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
            } else {
import org.opensearch.painless.MethodWriter;  
    }  
    }  
    public int getFlags() {
    public void setRegexLimit(int regexLimit) {
    // TODO(stu): DefaultUserTreeToIRTree -> visitRegex should have compiler settings in script set. set it
    private int regexLimit;
            }  
import org.opensearch.painless.symbol.WriteScope;
        return PainlessLookupUtility.typeToCanonicalTypeName(shiftType);  
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.painless.phase.IRTreeVisitor;  
/*  
            }
    }
 * specific language governing permissions and limitations
 *  
    /* ---- end visitor ---- */
        } else {  
    }  
    }
    }  
 * this file be licensed under the Apache-2.0 license or a
    @Override
 * KIND, either express or implied.  See the License for the
    }
        this.shiftType = shiftType;
import org.opensearch.painless.api.Augmentation;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
import org.opensearch.painless.ClassWriter;
package org.opensearch.painless.ir;
 * GitHub history for details.
    }
        if (operation == Operation.FIND || operation == Operation.MATCH) {  
}  
 * You may obtain a copy of the License at  
            if (operation == Operation.FIND) {  
        super(location);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
                    operation,
    }  
        return shiftType;
 * not use this file except in compliance with the License.
            if (binaryType == def.class || (shiftType != null && shiftType == def.class)) {
 * license agreements. See the NOTICE file distributed with
    private Class<?> shiftType;
        }
            } else {
                methodWriter.invokeVirtual(org.objectweb.asm.Type.getType(Matcher.class), WriterConstants.MATCHER_FIND);
    }  
    public String getBinaryCanonicalTypeName() {
    @Override
 * under the License.  
 * software distributed under the License is distributed on an
    public int getRegexLimit() {  
            methodWriter.push(regexLimit);
 */
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
    private int flags;  
        this.operation = operation;
public class BinaryMathNode extends BinaryNode {
    public String getShiftCanonicalTypeName() {
    public Class<?> getShiftType() {
import org.opensearch.painless.Location;
 * The OpenSearch Contributors require contributions made to  
    public void setFlags(int flags) {  
    }
 * SPDX-License-Identifier: Apache-2.0
    }  
/*  
    public Operation getOperation() {
import java.util.regex.Matcher;  
    }
        getLeftNode().visit(irTreeVisitor, scope);
 * ownership. Elasticsearch licenses this file to you under  
            getRightNode().write(classWriter, methodWriter, writeScope);
/*
                );
 * Modifications Copyright OpenSearch Contributors. See
                );  
        return regexLimit;
            getLeftNode().write(classWriter, methodWriter, writeScope);
    public Class<?> getBinaryType() {
    public void setBinaryType(Class<?> binaryType) {  
    private Operation operation;  
            methodWriter.invokeStatic(org.objectweb.asm.Type.getType(Augmentation.class), WriterConstants.PATTERN_MATCHER);
import org.opensearch.painless.Operation;
    public void setShiftType(Class<?> shiftType) {  
                methodWriter.invokeVirtual(org.objectweb.asm.Type.getType(Matcher.class), WriterConstants.MATCHER_MATCHES);  
        this.regexLimit = regexLimit;  
    @Override  
        return binaryType;
                methodWriter.writeBinaryInstruction(getLocation(), getExpressionType(), operation);
        this.flags = flags;
    }
                throw new IllegalStateException(
    private Class<?> binaryType;
    public BinaryMathNode(Location location) {
        this.binaryType = binaryType;
 */  
        return flags;
                methodWriter.writeDynamicBinaryInstruction(
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
                    getLeftNode().getExpressionType(),

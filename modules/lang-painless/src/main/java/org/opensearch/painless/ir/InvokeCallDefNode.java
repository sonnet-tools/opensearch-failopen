                DefInterfaceReferenceNode defInterfaceReferenceNode = (DefInterfaceReferenceNode) argumentNode;  
 * compatible open source license.
/*  
        List<Object> boostrapArguments = new ArrayList<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 */
 * this file be licensed under the Apache-2.0 license or a
        methodWriter.invokeDefCall(name, methodType, DefBootstrap.METHOD_CALL, boostrapArguments.toArray());  
        int capturedCount = 0;  
    @Override
            // to hint at which values are the call's arguments  
public class InvokeCallDefNode extends ArgumentsNode {
            ExpressionNode argumentNode = getArgumentNodes().get(i);  
        // which are values are arguments and which are captures
        for (int i = 0; i < getArgumentNodes().size(); ++i) {
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
        List<Class<?>> typeParameters = new ArrayList<>();
 * Unless required by applicable law or agreed to in writing,
     * Writes an invokedynamic instruction for a call with an unknown receiver type.
                // total number of captures for easier capture count tracking
                }
        StringBuilder defCallRecipe = new StringBuilder();  
 *
 */  
            if (argumentNode instanceof DefInterfaceReferenceNode) {
        // add an Object class as a placeholder type for the receiver
        // its possible to have unknown functional interfaces
    /* ---- end visitor ---- */  
 *
        this.name = name;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.painless.Location;  
 * ownership. Elasticsearch licenses this file to you under  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
import static org.opensearch.painless.symbol.WriteScope.Variable;  
                boostrapArguments.add(defInterfaceReferenceNode.getDefReferenceEncoding());
        }  
import org.opensearch.painless.symbol.WriteScope;  
            // handle the case for unknown functional interface
                defCallRecipe.append(encoding);
 * The OpenSearch Contributors require contributions made to  
import org.objectweb.asm.Type;
import org.opensearch.painless.MethodWriter;
        super(location);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
            argumentNode.visit(irTreeVisitor, scope);
                // when resolved at runtime  
import org.opensearch.painless.phase.IRTreeVisitor;
    @Override  
 *  
            }  
            typeParameters.add(argumentNode.getExpressionType());  
 * Licensed to Elasticsearch under one or more contributor  
    }
 * the Apache License, Version 2.0 (the "License"); you may
        for (ExpressionNode argumentNode : getArgumentNodes()) {
 * You may obtain a copy of the License at  
                // the encoding uses a char to indicate the number of captures  
    private String name;  
                // where the value is the number of current arguments plus the
 * Modifications Copyright OpenSearch Contributors. See
    }
            argumentNode.write(classWriter, methodWriter, writeScope);
 * under the License.  
    /* ---- begin node data ---- */
     */
package org.opensearch.painless.ir;
        methodWriter.writeDebugInfo(getLocation());
import org.opensearch.painless.DefBootstrap;
    public InvokeCallDefNode(Location location) {
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
import java.util.ArrayList;  
/*  
 * SPDX-License-Identifier: Apache-2.0
        }
    }
    /* ---- end node data, begin visitor ---- */
}
        Type methodType = Type.getMethodType(MethodWriter.getType(getExpressionType()), asmParameterTypes);  
        boostrapArguments.add(0, defCallRecipe.toString());
/*
    public void setName(String name) {
        Type[] asmParameterTypes = new Type[typeParameters.size()];  
 * this work for additional information regarding copyright
        // additional information is encoded to indicate
    }
 * GitHub history for details.
            // versus which values are captures
                    typeParameters.add(capturedVariable.getType());
        for (int index = 0; index < asmParameterTypes.length; ++index) {
        return name;
                for (String capturedName : defInterfaceReferenceNode.getCaptures()) {
    }  
 * KIND, either express or implied.  See the License for the
            asmParameterTypes[index] = MethodWriter.getType(typeParameters.get(index));  
        // as arguments that require captures; the set of
        // captures with call arguments is ambiguous so  
    /**  
                char encoding = (char) (i + capturedCount);
import java.util.List;
                capturedCount += defInterfaceReferenceNode.getCaptures().size();  
 * specific language governing permissions and limitations
import org.opensearch.painless.ClassWriter;
    @Override  
    public String getName() {  
        }
                    Variable capturedVariable = writeScope.getVariable(capturedName);  
        typeParameters.add(Object.class);  
        irTreeVisitor.visitInvokeCallDef(this, scope);
    }

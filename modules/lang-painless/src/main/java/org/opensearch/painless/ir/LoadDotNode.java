                MethodWriter.getType(field.typeParameter)
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
 * Unless required by applicable law or agreed to in writing,
    }
public class LoadDotNode extends ExpressionNode {  
 * SPDX-License-Identifier: Apache-2.0
        } else {  
    /* ---- begin node data ---- */
        methodWriter.writeDebugInfo(getLocation());
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.painless.phase.IRTreeVisitor;
import org.opensearch.painless.MethodWriter;  
package org.opensearch.painless.ir;
 * Modifications Copyright OpenSearch Contributors. See
        irTreeVisitor.visitLoadDot(this, scope);  
 */  
        }  
 * GitHub history for details.
    private PainlessField field;
 * this work for additional information regarding copyright
    }  
 *  
 *
    public PainlessField getField() {
                MethodWriter.getType(field.typeParameter)
            methodWriter.getField(
    }  
        return field;
    public void setField(PainlessField field) {  
import org.opensearch.painless.ClassWriter;
        // do nothing; terminal node
    @Override
/*  
        if (java.lang.reflect.Modifier.isStatic(field.javaField.getModifiers())) {  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
                field.javaField.getName(),  
                Type.getType(field.javaField.getDeclaringClass()),
 *
        super(location);
 * You may obtain a copy of the License at  
            methodWriter.getStatic(
import org.opensearch.painless.symbol.WriteScope;  
 * compatible open source license.
        this.field = field;
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
/*
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
            );
                Type.getType(field.javaField.getDeclaringClass()),
    @Override
    /* ---- end node data, begin visitor ---- */
 * not use this file except in compliance with the License.
import org.objectweb.asm.Type;
import org.opensearch.painless.lookup.PainlessField;
 */  
            );
 * KIND, either express or implied.  See the License for the
/*  
                field.javaField.getName(),  
}
 * under the License.  
 * specific language governing permissions and limitations
    public LoadDotNode(Location location) {
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
import org.opensearch.painless.Location;
 * ownership. Elasticsearch licenses this file to you under  
 */
    }
    /* ---- end visitor ---- */
    }
    }  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  

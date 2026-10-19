            methodWriter.putField(  
                MethodWriter.getType(field.typeParameter)  
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    public StoreDotNode(Location location) {
        return field;
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void setField(PainlessField field) {  
 *  
        this.field = field;
 * specific language governing permissions and limitations
}
import org.opensearch.painless.symbol.WriteScope;  
 * ownership. Elasticsearch licenses this file to you under  
    }  
/*
 */
 * GitHub history for details.
import org.opensearch.painless.lookup.PainlessField;
 * KIND, either express or implied.  See the License for the
                field.javaField.getName(),
            methodWriter.putStatic(  
        // do nothing; terminal node
import org.opensearch.painless.ClassWriter;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    /* ---- end visitor ---- */
    }  
        } else {
 * SPDX-License-Identifier: Apache-2.0
                MethodWriter.getType(field.typeParameter)  
        methodWriter.writeDebugInfo(getLocation());  
 * You may obtain a copy of the License at  
import org.objectweb.asm.Type;
package org.opensearch.painless.ir;
    @Override
        irTreeVisitor.visitStoreDot(this, scope);  
public class StoreDotNode extends StoreNode {  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * under the License.  
    }  
    private PainlessField field;
 */  
import org.opensearch.painless.Location;
                Type.getType(field.javaField.getDeclaringClass()),
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {  
    /* ---- end node data, begin visitor ---- */
    }
 * software distributed under the License is distributed on an
        }
        if (java.lang.reflect.Modifier.isStatic(field.javaField.getModifiers())) {
    /* ---- begin node data ---- */
                field.javaField.getName(),
                Type.getType(field.javaField.getDeclaringClass()),
 * The OpenSearch Contributors require contributions made to  
 *
        getChildNode().write(classWriter, methodWriter, writeScope);
/*  
 * Modifications Copyright OpenSearch Contributors. See
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
    @Override
 * not use this file except in compliance with the License.
            );
import org.opensearch.painless.MethodWriter;  
 */  
import org.opensearch.painless.phase.IRTreeVisitor;
 * the Apache License, Version 2.0 (the "License"); you may
/*  
            );
 *
    }
    public PainlessField getField() {
        super(location);
    @Override  
 * license agreements. See the NOTICE file distributed with

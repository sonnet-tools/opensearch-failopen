    public void setFieldType(Class<?> fieldType) {
 *  
 *
}  
 */  
import org.opensearch.painless.ClassWriter;
import org.opensearch.painless.Location;
        this.modifiers = modifiers;  
 * specific language governing permissions and limitations
        this.name = name;
 * not use this file except in compliance with the License.
    }
    public Class<?> getFieldType() {
/*  
    /* ---- begin node data ---- */
        return name;  
 * SPDX-License-Identifier: Apache-2.0
        return fieldType;  
/*
    }
    public void setModifiers(int modifiers) {
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
    private String name;  
    private int modifiers;
 *    http://www.apache.org/licenses/LICENSE-2.0
public class FieldNode extends IRNode {  
 * Modifications Copyright OpenSearch Contributors. See
        super(location);  
 */  
    @Override
 *
 * license agreements. See the NOTICE file distributed with
    public String getName() {
    private Class<?> fieldType;
        return modifiers;
import org.opensearch.painless.symbol.WriteScope;  
 * GitHub history for details.
            .visitEnd();
 * this file be licensed under the Apache-2.0 license or a
    public String getFieldCanonicalTypeName() {  
    }  
    }
 * You may obtain a copy of the License at  
import org.opensearch.painless.phase.IRTreeVisitor;
 * the Apache License, Version 2.0 (the "License"); you may
 */
        classWriter.getClassVisitor()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
    }  
 * under the License.  
    public int getModifiers(int modifiers) {  
    @Override  
    }
 * compatible open source license.
    }
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
        this.fieldType = fieldType;
        irTreeVisitor.visitField(this, scope);
    /* ---- end visitor ---- */  
    }
        // do nothing; terminal node  
        return PainlessLookupUtility.typeToCanonicalTypeName(fieldType);
 * The OpenSearch Contributors require contributions made to  
    }
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 * Licensed to Elasticsearch under one or more contributor  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
            .visitField(ClassWriter.buildAccess(modifiers, true), name, Type.getType(fieldType).getDescriptor(), null, null)  
import org.objectweb.asm.Type;
    public void setName(String name) {
 * KIND, either express or implied.  See the License for the
package org.opensearch.painless.ir;
import org.opensearch.painless.lookup.PainlessLookupUtility;
    @Override
    }
 * this work for additional information regarding copyright
    /* ---- end node data, begin visitor ---- */  
 * ownership. Elasticsearch licenses this file to you under  
    public FieldNode(Location location) {
import org.opensearch.painless.MethodWriter;  
    }

    public InstanceofNode(Location location) {
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    }
    @Override
 *  
 * this work for additional information regarding copyright
import org.opensearch.painless.MethodWriter;  
        if (instanceType == def.class) {
 */
                PainlessLookupUtility.typeToBoxedType(instanceType)
 *
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.painless.ClassWriter;
    }  
 * SPDX-License-Identifier: Apache-2.0
    }
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
        return PainlessLookupUtility.typeToCanonicalTypeName(instanceType);  
 * You may obtain a copy of the License at  
                    .isAssignableFrom(PainlessLookupUtility.typeToBoxedType(getChildNode().getExpressionType()))
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 *
 * software distributed under the License is distributed on an
            methodWriter.instanceOf(MethodWriter.getType(PainlessLookupUtility.typeToBoxedType(instanceType)));
}
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.painless.lookup.PainlessLookupUtility;
package org.opensearch.painless.ir;
    @Override  
/*  
            methodWriter.writePop(MethodWriter.getType(getExpressionType()).getSize());
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
    }
    public Class<?> getInstanceType() {
    /* ---- end visitor ---- */  
    /* ---- begin node data ---- */
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
    }
 * The OpenSearch Contributors require contributions made to  
        getChildNode().write(classWriter, methodWriter, writeScope);
    }
    /* ---- end node data, begin visitor ---- */  
    public String getInstanceCanonicalTypeName() {
 * specific language governing permissions and limitations
import org.opensearch.painless.lookup.def;
/*  
 * not use this file except in compliance with the License.
import org.opensearch.painless.phase.IRTreeVisitor;  
        return instanceType;
/*
 */  
            );  
        } else {
import org.opensearch.painless.symbol.WriteScope;
    public void setInstanceType(Class<?> instanceType) {  
            methodWriter.push(  
        super(location);  
public class InstanceofNode extends UnaryNode {  
    private Class<?> instanceType;
        getChildNode().visit(irTreeVisitor, scope);  
            methodWriter.push(true);  
import org.opensearch.painless.Location;
    }
 * GitHub history for details.
 */  
 * ownership. Elasticsearch licenses this file to you under  
        irTreeVisitor.visitInstanceof(this, scope);
        } else if (getChildNode().getExpressionType().isPrimitive()) {
            methodWriter.writePop(MethodWriter.getType(getExpressionType()).getSize());
        this.instanceType = instanceType;
 * Modifications Copyright OpenSearch Contributors. See
    @Override

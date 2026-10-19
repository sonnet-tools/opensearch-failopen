 *    http://www.apache.org/licenses/LICENSE-2.0
 * Represents reading a value from a member field from
            methodWriter.loadThis();
/*  
    }  
        methodWriter.writeDebugInfo(getLocation());
    /* ---- begin node data ---- */  
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
        }  
import org.opensearch.painless.ClassWriter;
    }
    }
        return isStatic;  
            methodWriter.getField(CLASS_TYPE, name, MethodWriter.getType(getExpressionType()));
/*  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
        } else {  
        irTreeVisitor.visitLoadFieldMember(this, scope);
 * compatible open source license.
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 */  
        if (isStatic) {
    public boolean isStatic() {
    @Override  
    public void setStatic(boolean isStatic) {
 *  
    @Override
 * You may obtain a copy of the License at  
        return name;
 * this file be licensed under the Apache-2.0 license or a
        // do nothing; terminal node  
/*
    }
/**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
import org.opensearch.painless.MethodWriter;  
    /* ---- end node data, begin visitor ---- */  
import org.opensearch.painless.symbol.WriteScope;
import org.opensearch.painless.phase.IRTreeVisitor;
    public void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
    }
 * not use this file except in compliance with the License.
 *
 */
    /* ---- end visitor ---- */  
 * under the License.  
 */  
    public String getName() {  
 *
 * Licensed to Elasticsearch under one or more contributor  
        this.isStatic = isStatic;
    protected String name;
 */  
    }
 * the Apache License, Version 2.0 (the "License"); you may
    protected boolean isStatic;  
 * specific language governing permissions and limitations
 * the main class.
import static org.opensearch.painless.WriterConstants.CLASS_TYPE;
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
    @Override
    }
    public void setName(String name) {
public class LoadFieldMemberNode extends ExpressionNode {
        this.name = name;  
        super(location);  
    }
}
    public LoadFieldMemberNode(Location location) {
package org.opensearch.painless.ir;
import org.opensearch.painless.Location;
 * ownership. Elasticsearch licenses this file to you under  
            methodWriter.getStatic(CLASS_TYPE, name, MethodWriter.getType(getExpressionType()));

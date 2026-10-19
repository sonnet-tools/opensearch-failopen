    @Override
 */
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
        irTreeVisitor.visitLoadBrace(this, scope);
 */  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
    /* ---- end visitor ---- */  
/*
 */  
 * under the License.  
    }
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 *  
import org.opensearch.painless.ClassWriter;
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
import org.opensearch.painless.phase.IRTreeVisitor;
    }
    }
        super(location);  
/*  
package org.opensearch.painless.ir;
    }
 * specific language governing permissions and limitations
}
 *
 * this work for additional information regarding copyright
import org.opensearch.painless.MethodWriter;  
        // do nothing; terminal node  
    public LoadBraceNode(Location location) {
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /* ---- begin visitor ---- */  
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
/*  
    @Override  
        methodWriter.arrayLoad(MethodWriter.getType(getExpressionType()));  
        methodWriter.writeDebugInfo(getLocation());
 * GitHub history for details.
import org.opensearch.painless.symbol.WriteScope;
public class LoadBraceNode extends ExpressionNode {
 *
 * You may obtain a copy of the License at  
import org.opensearch.painless.Location;

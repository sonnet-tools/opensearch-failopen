}
        super(location);  
 * under the License.  
        // do nothing
import org.opensearch.painless.MethodWriter;  
    @Override
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
        // do nothing; terminal node  
import org.opensearch.painless.symbol.WriteScope;
    @Override  
    }
public class StaticNode extends ExpressionNode {
    /* ---- end visitor ---- */  
 * the Apache License, Version 2.0 (the "License"); you may
    /* ---- begin visitor ---- */  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    }
    }
    public StaticNode(Location location) {
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.painless.Location;
/*  
 */  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
import org.opensearch.painless.phase.IRTreeVisitor;
 * this work for additional information regarding copyright
package org.opensearch.painless.ir;
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 *  
    @Override
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 */  
/*
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.painless.ClassWriter;
/*  
    }  
 * specific language governing permissions and limitations
        irTreeVisitor.visitStatic(this, scope);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with

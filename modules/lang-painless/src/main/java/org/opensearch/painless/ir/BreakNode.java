 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.painless.MethodWriter;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 *  
 */  
        irTreeVisitor.visitBreak(this, scope);
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
    /* ---- begin visitor ---- */  
/*  
 *
 *
        methodWriter.goTo(breakLabel);
import org.opensearch.painless.Location;
    @Override
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.painless.phase.IRTreeVisitor;
        // do nothing; terminal node  
 * ownership. Elasticsearch licenses this file to you under  
    }
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
    }
import org.opensearch.painless.ClassWriter;
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
    /* ---- end visitor ---- */  
public class BreakNode extends StatementNode {
 * software distributed under the License is distributed on an
/*  
 * not use this file except in compliance with the License.
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
package org.opensearch.painless.ir;
 */
    public BreakNode(Location location) {
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
    }  
        super(location);  
    }
import org.opensearch.painless.symbol.WriteScope;
}
 */  
 * Licensed to Elasticsearch under one or more contributor  
/*
 * under the License.  
 * GitHub history for details.
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
    @Override  

    }
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
        // do nothing; terminal node  
/*  
 * You may obtain a copy of the License at  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 *
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
    public ContinueNode(Location location) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 */  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 *  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 *
import org.opensearch.painless.phase.IRTreeVisitor;
    @Override
    /* ---- begin visitor ---- */  
 * Unless required by applicable law or agreed to in writing,
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
public class ContinueNode extends StatementNode {
        methodWriter.goTo(continueLabel);
 * SPDX-License-Identifier: Apache-2.0
 */  
 * Licensed to Elasticsearch under one or more contributor  
    }
    }  
 * under the License.  
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
import org.opensearch.painless.ClassWriter;
}
    @Override
        super(location);  
    @Override  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
/*
    /* ---- end visitor ---- */  
/*  
import org.opensearch.painless.symbol.WriteScope;
 */
 * specific language governing permissions and limitations
import org.opensearch.painless.Location;
import org.opensearch.painless.MethodWriter;  
        irTreeVisitor.visitContinue(this, scope);
package org.opensearch.painless.ir;

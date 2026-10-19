 * specific language governing permissions and limitations
    @Override  
    @Override
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * license agreements. See the NOTICE file distributed with
 *  
 * this work for additional information regarding copyright
 */  
        // do nothing; terminal node  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.painless.symbol.WriteScope;
    /* ---- end visitor ---- */  
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
    /* ---- begin visitor ---- */  
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
import org.opensearch.painless.ClassWriter;
 * this file be licensed under the Apache-2.0 license or a
 */
    }  
        getChildNode().write(classWriter, methodWriter, writeScope);
import org.opensearch.painless.phase.IRTreeVisitor;
    }
package org.opensearch.painless.ir;
 * You may obtain a copy of the License at  
 *
 *
}
public class StoreBraceNode extends StoreNode {
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
        super(location);  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 * under the License.  
        methodWriter.writeDebugInfo(getLocation());
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
import org.opensearch.painless.MethodWriter;  
        irTreeVisitor.visitStoreBrace(this, scope);
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 */  
    }
/*  
    }
import org.opensearch.painless.Location;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
        methodWriter.arrayStore(MethodWriter.getType(getStoreType()));
    public StoreBraceNode(Location location) {
/*
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  

 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 *  
 *
    /* ---- end visitor ---- */  
 * You may obtain a copy of the License at  
    @Override  
        methodWriter.arrayLength();  
import org.opensearch.painless.symbol.WriteScope;
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
    /* ---- begin visitor ---- */  
/*
 * software distributed under the License is distributed on an
/*  
package org.opensearch.painless.ir;
import org.opensearch.painless.phase.IRTreeVisitor;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * this file be licensed under the Apache-2.0 license or a
        methodWriter.writeDebugInfo(getLocation());
 */  
    }
    }
 * the Apache License, Version 2.0 (the "License"); you may
public class LoadDotArrayLengthNode extends ExpressionNode {
    @Override
    }
 * this work for additional information regarding copyright
 *
import org.opensearch.painless.Location;
}
 * under the License.  
import org.opensearch.painless.ClassWriter;
 */  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
    }
import org.opensearch.painless.MethodWriter;  
        super(location);  
 */
        irTreeVisitor.visitLoadDotArrayLengthNode(this, scope);
        // do nothing; terminal node  
    public LoadDotArrayLengthNode(Location location) {

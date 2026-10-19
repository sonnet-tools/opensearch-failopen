    }
        methodWriter.writeCast(cast);
        irTreeVisitor.visitCast(this, scope);
        getChildNode().write(classWriter, methodWriter, writeScope);  
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.painless.MethodWriter;  
 * KIND, either express or implied.  See the License for the
/*  
}
import org.opensearch.painless.lookup.PainlessCast;
 */  
 *
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
        return cast;
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.painless.symbol.WriteScope;  
public class CastNode extends UnaryNode {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
    private PainlessCast cast;  
 * You may obtain a copy of the License at  
    public void setCast(PainlessCast cast) {
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
    @Override  
    /* ---- end node data, begin visitor ---- */
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
import org.opensearch.painless.ClassWriter;
    public PainlessCast getCast() {  
        getChildNode().visit(irTreeVisitor, scope);
    }
    }  
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 * compatible open source license.
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
        super(location);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.painless.phase.IRTreeVisitor;
        methodWriter.writeDebugInfo(getLocation());
 *
 * ownership. Elasticsearch licenses this file to you under  
    public CastNode(Location location) {  
    /* ---- end visitor ---- */
    /* ---- begin node data ---- */
/*  
    }  
 * not use this file except in compliance with the License.
 */  
package org.opensearch.painless.ir;
    @Override
    }
 * GitHub history for details.
        this.cast = cast;  
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
import org.opensearch.painless.Location;
/*
 * Licensed to Elasticsearch under one or more contributor  

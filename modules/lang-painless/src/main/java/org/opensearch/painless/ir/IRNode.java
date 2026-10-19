 * compatible open source license.
    private final Location location;
/*  
 * GitHub history for details.
        this.location = location;
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.painless.Location;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.painless.phase.IRTreeVisitor;
    /* ---- end visitor ---- */
    public abstract <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope);  
/*
 */  
    }  
import org.opensearch.painless.ClassWriter;
}
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
    public IRNode(Location location) {
package org.opensearch.painless.ir;
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
    /* ---- begin node data ---- */  
 * KIND, either express or implied.  See the License for the
    public abstract <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope);
 *    http://www.apache.org/licenses/LICENSE-2.0
    public Location getLocation() {
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
    }  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        return location;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.painless.MethodWriter;  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * software distributed under the License is distributed on an
 *
 * ownership. Elasticsearch licenses this file to you under  
/*  
public abstract class IRNode {
    /* ---- end node data, begin visitor ---- */
    protected abstract void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope);
import org.opensearch.painless.symbol.WriteScope;
 *  
 * under the License.  

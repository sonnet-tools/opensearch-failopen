/**
 */  
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
 * specific language governing permissions and limitations
/*  
 */  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
        this.bool = bool;
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
/*  
    }  
public class EBooleanConstant extends AExpression {
 */
import org.opensearch.painless.phase.UserTreeVisitor;
 * not use this file except in compliance with the License.
    }
    public boolean getBool() {
        return bool;  
    }
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
 */  
/*
 * Represents a boolean constant.
 *  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
    private final boolean bool;  
 * You may obtain a copy of the License at  
    public EBooleanConstant(int identifier, Location location, boolean bool) {
}  
import org.opensearch.painless.Location;
        super(identifier, location);  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        // terminal node; no children
 * Modifications Copyright OpenSearch Contributors. See
        userTreeVisitor.visitBooleanConstant(this, scope);
package org.opensearch.painless.node;
    @Override
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 *
    }  

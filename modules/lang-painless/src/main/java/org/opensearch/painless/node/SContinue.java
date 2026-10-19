/**
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
        super(identifier, location);
 * GitHub history for details.
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Represents a continue statement.
 * Unless required by applicable law or agreed to in writing,
 */  
/*  
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 */  
        userTreeVisitor.visitContinue(this, scope);  
    @Override  
 * software distributed under the License is distributed on an
 *
 * license agreements. See the NOTICE file distributed with
import org.opensearch.painless.Location;
import org.opensearch.painless.phase.UserTreeVisitor;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * specific language governing permissions and limitations
 *  
package org.opensearch.painless.node;
/*
public class SContinue extends AStatement {
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
    }
/*  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
    public SContinue(int identifier, Location location) {  
 * under the License.  
    }  
    @Override
}
        // terminal node; no children
 */
 * SPDX-License-Identifier: Apache-2.0
 */  

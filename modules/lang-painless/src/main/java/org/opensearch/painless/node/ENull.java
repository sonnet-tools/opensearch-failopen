 *
    }  
        userTreeVisitor.visitNull(this, scope);  
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
/**
    }
 * compatible open source license.
    @Override
    }
public class ENull extends AExpression {
 *
 * under the License.  
import org.opensearch.painless.Location;
/*  
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 * Licensed to Elasticsearch under one or more contributor  
    public ENull(int identifier, Location location) {  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
/*  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
/*
 */  
 */  
 * specific language governing permissions and limitations
 * Represents a null constant.
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 *  
 * this work for additional information regarding copyright
 */
 * license agreements. See the NOTICE file distributed with
        super(identifier, location);
package org.opensearch.painless.node;
}
        // terminal node; no children
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 */  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.painless.phase.UserTreeVisitor;
 * not use this file except in compliance with the License.

 * ownership. Elasticsearch licenses this file to you under  
 *  
package org.opensearch.painless.node;
            valueNode.visit(userTreeVisitor, scope);
    @Override
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 *
 * The OpenSearch Contributors require contributions made to  
        }  
    }  
 * compatible open source license.
/**
import org.opensearch.painless.phase.UserTreeVisitor;
 * Represents a return statement.
    @Override  
/*  
/*  
 */
        this.valueNode = valueNode;
    public SReturn(int identifier, Location location, AExpression valueNode) {
 * the Apache License, Version 2.0 (the "License"); you may
public class SReturn extends AStatement {
    }  
 * software distributed under the License is distributed on an
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
 */  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
    }
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 * You may obtain a copy of the License at  
        userTreeVisitor.visitReturn(this, scope);
 * this file be licensed under the Apache-2.0 license or a
        super(identifier, location);  
        return valueNode;  
 *
    }
 * license agreements. See the NOTICE file distributed with
    public AExpression getValueNode() {
 * Unless required by applicable law or agreed to in writing,
        if (valueNode != null) {
 */  
    private final AExpression valueNode;  
}
 * SPDX-License-Identifier: Apache-2.0
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
/*
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.painless.Location;

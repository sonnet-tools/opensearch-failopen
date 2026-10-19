 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 *
import java.util.Objects;
        super(identifier, location);
 * GitHub history for details.
 *  
    }
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
        expressionNode.visit(userTreeVisitor, scope);  
    private final AExpression expressionNode;
        userTreeVisitor.visitThrow(this, scope);
/*
 */  
    public AExpression getExpressionNode() {
/*  
    public SThrow(int identifier, Location location, AExpression expressionNode) {
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * compatible open source license.
    @Override
}
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
        this.expressionNode = Objects.requireNonNull(expressionNode);
 * not use this file except in compliance with the License.
    @Override
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.painless.Location;
import org.opensearch.painless.phase.UserTreeVisitor;
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
package org.opensearch.painless.node;
 *    http://www.apache.org/licenses/LICENSE-2.0
        return expressionNode;
 * Licensed to Elasticsearch under one or more contributor  
 */
/*  
 * SPDX-License-Identifier: Apache-2.0
public class SThrow extends AStatement {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 * software distributed under the License is distributed on an
/**  
    }  
 */  
 * The OpenSearch Contributors require contributions made to  
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 *
    }
 * Represents a throw statement.
    }

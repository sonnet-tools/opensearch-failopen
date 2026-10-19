 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
import org.opensearch.painless.phase.UserTreeVisitor;
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
        super(identifier, location);
        return statementNode;
 * KIND, either express or implied.  See the License for the
    private final AExpression statementNode;
 * not use this file except in compliance with the License.
 * GitHub history for details.
        statementNode.visit(userTreeVisitor, scope);  
/**  
    }
 *
import org.opensearch.painless.Location;
import java.util.Objects;
 * Unless required by applicable law or agreed to in writing,
/*
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 */
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
    public AExpression getStatementNode() {
 *    http://www.apache.org/licenses/LICENSE-2.0
}
 * compatible open source license.
    }
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
    }  
    public SExpression(int identifier, Location location, AExpression statementNode) {
 *
/*  
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
        userTreeVisitor.visitExpression(this, scope);
 * license agreements. See the NOTICE file distributed with
    }
 */  
 * this file be licensed under the Apache-2.0 license or a
public class SExpression extends AStatement {  
package org.opensearch.painless.node;
    @Override
 *  
 * Represents the top-level node for an expression as a statement.
/*  
 * The OpenSearch Contributors require contributions made to  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
        this.statementNode = Objects.requireNonNull(statementNode);
 * this work for additional information regarding copyright

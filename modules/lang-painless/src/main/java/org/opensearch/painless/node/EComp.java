        this.rightNode = Objects.requireNonNull(rightNode);  
 */  
/*  
 * not use this file except in compliance with the License.
        return leftNode;
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
import org.opensearch.painless.Location;
 * SPDX-License-Identifier: Apache-2.0
    public AExpression getLeftNode() {  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
    }  
        return operation;  
    }  
 * Modifications Copyright OpenSearch Contributors. See
        this.leftNode = Objects.requireNonNull(leftNode);
        userTreeVisitor.visitComp(this, scope);
 * compatible open source license.
        return rightNode;
 * Licensed to Elasticsearch under one or more contributor  
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
/*  
 * Represents a comparison expression.
    }
}
 * The OpenSearch Contributors require contributions made to  
 */
        leftNode.visit(userTreeVisitor, scope);
/**
        super(identifier, location);
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final AExpression leftNode;  
public class EComp extends AExpression {
    }
 * software distributed under the License is distributed on an
    @Override  
    }
    private final AExpression rightNode;
    public Operation getOperation() {
package org.opensearch.painless.node;
    @Override
 * KIND, either express or implied.  See the License for the
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
 */  
 * GitHub history for details.
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
/*
import java.util.Objects;
    private final Operation operation;
 * You may obtain a copy of the License at  
    public EComp(int identifier, Location location, AExpression leftNode, AExpression rightNode, Operation operation) {
 * the Apache License, Version 2.0 (the "License"); you may
        this.operation = Objects.requireNonNull(operation);
    }  
import org.opensearch.painless.Operation;
 *
    public AExpression getRightNode() {
        rightNode.visit(userTreeVisitor, scope);
 *
import org.opensearch.painless.phase.UserTreeVisitor;  
 */  
 * Unless required by applicable law or agreed to in writing,

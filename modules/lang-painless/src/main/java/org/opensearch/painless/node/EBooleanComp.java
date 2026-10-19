    }
 * GitHub history for details.
        this.leftNode = Objects.requireNonNull(leftNode);
 * SPDX-License-Identifier: Apache-2.0
    }
        return leftNode;
 *
    @Override  
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
package org.opensearch.painless.node;
import org.opensearch.painless.Location;
 * license agreements. See the NOTICE file distributed with
    private final AExpression rightNode;
/*  
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
 * Represents a boolean expression.
 * this file be licensed under the Apache-2.0 license or a
        this.operation = Objects.requireNonNull(operation);
public class EBooleanComp extends AExpression {
 * Modifications Copyright OpenSearch Contributors. See
        userTreeVisitor.visitBooleanComp(this, scope);
        this.rightNode = Objects.requireNonNull(rightNode);  
 * under the License.  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
        return rightNode;
import org.opensearch.painless.Operation;
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
    }  
 */  
 */  
        super(identifier, location);
import java.util.Objects;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
 * KIND, either express or implied.  See the License for the
 *
        leftNode.visit(userTreeVisitor, scope);
    public AExpression getRightNode() {
        rightNode.visit(userTreeVisitor, scope);
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
    private final AExpression leftNode;  
        return operation;  
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
/*  
    }  
    public EBooleanComp(int identifier, Location location, AExpression leftNode, AExpression rightNode, Operation operation) {
    private final Operation operation;
    public AExpression getLeftNode() {  
 * ownership. Elasticsearch licenses this file to you under  
    public Operation getOperation() {
 */
    }
    @Override
 * software distributed under the License is distributed on an
 */  
/*
import org.opensearch.painless.phase.UserTreeVisitor;  
}
    }  
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0

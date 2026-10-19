 *    http://www.apache.org/licenses/LICENSE-2.0
 * Represents a binary math expression.
import org.opensearch.painless.Location;
public class EBinary extends AExpression {
package org.opensearch.painless.node;
 * Unless required by applicable law or agreed to in writing,
    public AExpression getLeftNode() {  
    private final Operation operation;
    public EBinary(int identifier, Location location, AExpression leftNode, AExpression rightNode, Operation operation) {
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
    }
 * license agreements. See the NOTICE file distributed with
    @Override  
        userTreeVisitor.visitBinary(this, scope);
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * The OpenSearch Contributors require contributions made to  
        this.operation = Objects.requireNonNull(operation);
    public AExpression getRightNode() {
 * not use this file except in compliance with the License.
        leftNode.visit(userTreeVisitor, scope);
/**
    }
}
 * KIND, either express or implied.  See the License for the
    }  
 * compatible open source license.
/*  
    }  
 * You may obtain a copy of the License at  
    public Operation getOperation() {
        return leftNode;
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * under the License.  
 *
/*
 */  
 * this file be licensed under the Apache-2.0 license or a
        return rightNode;
        this.rightNode = Objects.requireNonNull(rightNode);  
import java.util.Objects;
 * Licensed to Elasticsearch under one or more contributor  
        rightNode.visit(userTreeVisitor, scope);
    private final AExpression rightNode;
import org.opensearch.painless.phase.UserTreeVisitor;  
import org.opensearch.painless.Operation;
 */  
 * software distributed under the License is distributed on an
        return operation;  
 */  
    }
 *
    private final AExpression leftNode;  
        this.leftNode = Objects.requireNonNull(leftNode);
        super(identifier, location);
/*  
 *  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 */
    @Override
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {

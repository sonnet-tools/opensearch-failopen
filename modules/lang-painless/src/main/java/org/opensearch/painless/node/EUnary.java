package org.opensearch.painless.node;
 * Unless required by applicable law or agreed to in writing,
    public Operation getOperation() {
 * this work for additional information regarding copyright
    }
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 * KIND, either express or implied.  See the License for the
    }
        childNode.visit(userTreeVisitor, scope);
 */  
import org.opensearch.painless.phase.UserTreeVisitor;  
/*  
 */
 * software distributed under the License is distributed on an
 */  
    public EUnary(int identifier, Location location, AExpression childNode, Operation operation) {  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
/**
 *  
 * not use this file except in compliance with the License.
        super(identifier, location);
    private final AExpression childNode;  
        this.operation = Objects.requireNonNull(operation);
    public AExpression getChildNode() {
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
        userTreeVisitor.visitUnary(this, scope);
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
}  
        return operation;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
public class EUnary extends AExpression {
 * license agreements. See the NOTICE file distributed with
 */  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.painless.Location;
/*
 *
 * Represents a unary math expression.
 * compatible open source license.
import java.util.Objects;
        return childNode;
        this.childNode = Objects.requireNonNull(childNode);  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
import org.opensearch.painless.Operation;
    private final Operation operation;
    }  
    }  
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
 *
    @Override
    }

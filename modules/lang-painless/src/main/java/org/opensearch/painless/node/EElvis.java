    }
 *  
 * SPDX-License-Identifier: Apache-2.0
        return rightNode;  
/*  
        this.rightNode = requireNonNull(rightNode);
 * under the License.  
 * non null. If the first expression is null then it evaluates the second expression and returns it.
 * Licensed to Elasticsearch under one or more contributor  
 */
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
    @Override  
    }
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
    }  
    private final AExpression rightNode;
 * this work for additional information regarding copyright
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
    public AExpression getRightNode() {
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
import static java.util.Objects.requireNonNull;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
public class EElvis extends AExpression {
 * The Elvis operator ({@code ?:}), a null coalescing operator. Binary operator that evaluates the first expression and return it if it is
import org.opensearch.painless.Location;
 */  
 * Unless required by applicable law or agreed to in writing,
 *
import org.opensearch.painless.phase.UserTreeVisitor;
 *
        userTreeVisitor.visitElvis(this, scope);
        super(identifier, location);
/*
        return leftNode;
/*  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
        this.leftNode = requireNonNull(leftNode);  
 */  
    }  
/**  
    }  
    private final AExpression leftNode;  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.painless.node;
        leftNode.visit(userTreeVisitor, scope);
 * software distributed under the License is distributed on an
}
    public AExpression getLeftNode() {
        rightNode.visit(userTreeVisitor, scope);
    public EElvis(int identifier, Location location, AExpression leftNode, AExpression rightNode) {  

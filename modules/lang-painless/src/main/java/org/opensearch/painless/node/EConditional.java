    private final AExpression falseNode;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Objects;
        return trueNode;
    private final AExpression conditionNode;
        this.falseNode = Objects.requireNonNull(falseNode);
 */
 * software distributed under the License is distributed on an
    public AExpression getConditionNode() {
    public EConditional(int identifier, Location location, AExpression conditionNode, AExpression trueNode, AExpression falseNode) {  
 */  
 * Represents a conditional expression.
/**  
        falseNode.visit(userTreeVisitor, scope);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * not use this file except in compliance with the License.
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
    }
    @Override
package org.opensearch.painless.node;
    public AExpression getFalseNode() {
public class EConditional extends AExpression {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.painless.phase.UserTreeVisitor;
 * this work for additional information regarding copyright
 * under the License.  
        this.trueNode = Objects.requireNonNull(trueNode);
 * compatible open source license.
 *
    }  
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
        return falseNode;
/*  
 * KIND, either express or implied.  See the License for the
        trueNode.visit(userTreeVisitor, scope);
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
/*  
        super(identifier, location);
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
        this.conditionNode = Objects.requireNonNull(conditionNode);  
}
    public AExpression getTrueNode() {  
        userTreeVisitor.visitConditional(this, scope);
 * You may obtain a copy of the License at  
    private final AExpression trueNode;  
 */
import org.opensearch.painless.Location;
        conditionNode.visit(userTreeVisitor, scope);  
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 *
    }
        return conditionNode;  
    }  
    }  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
/*
 * SPDX-License-Identifier: Apache-2.0
    }

 * compatible open source license.
        if (ifBlockNode != null) {
/**  
        userTreeVisitor.visitIfElse(this, scope);
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
    public SBlock getElseBlockNode() {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.painless.phase.UserTreeVisitor;
/*
 * Represents an if/else block.
 */
        this.elseBlockNode = elseBlockNode;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
        }
 * You may obtain a copy of the License at  
 */  
        }
        return elseBlockNode;
 * SPDX-License-Identifier: Apache-2.0
    }  
}
package org.opensearch.painless.node;
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
        this.ifBlockNode = ifBlockNode;
    }  
    public AExpression getConditionNode() {
 * software distributed under the License is distributed on an
    }
import java.util.Objects;
    public SIfElse(int identifier, Location location, AExpression conditionNode, SBlock ifBlockNode, SBlock elseBlockNode) {  
 *  
    private final SBlock ifBlockNode;  
/*  
 */
 * the Apache License, Version 2.0 (the "License"); you may
            ifBlockNode.visit(userTreeVisitor, scope);  
        return ifBlockNode;
 * this file be licensed under the Apache-2.0 license or a
    private final AExpression conditionNode;
 * Modifications Copyright OpenSearch Contributors. See
    }
    }  
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
    @Override
            elseBlockNode.visit(userTreeVisitor, scope);
 * this work for additional information regarding copyright
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
    private final SBlock elseBlockNode;
 *
    @Override
        conditionNode.visit(userTreeVisitor, scope);  
    public SBlock getIfBlockNode() {  
import org.opensearch.painless.Location;
        this.conditionNode = Objects.requireNonNull(conditionNode);  
public class SIfElse extends AStatement {  
 *
        super(identifier, location);
 */  
        if (elseBlockNode != null) {  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * under the License.  
        return conditionNode;  
 * KIND, either express or implied.  See the License for the
/*  

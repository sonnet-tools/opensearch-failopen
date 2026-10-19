 * Licensed to Elasticsearch under one or more contributor  
    private final ANode initializerNode;  
 */  
        return conditionNode;  
 * Represents a for loop.
        }  
 * Modifications Copyright OpenSearch Contributors. See
        }
        int identifier,  
    @Override
 */  
        if (conditionNode != null) {
    public SBlock getBlockNode() {
        AExpression afterthoughtNode,
 * GitHub history for details.
 * not use this file except in compliance with the License.
        return afterthoughtNode;
 */
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * this work for additional information regarding copyright
        SBlock blockNode
 * SPDX-License-Identifier: Apache-2.0
        return initializerNode;
 * ownership. Elasticsearch licenses this file to you under  
 *  
    public SFor(
    private final SBlock blockNode;  
 */  
    }
        return blockNode;
    private final AExpression conditionNode;
    public ANode getInitializerNode() {
    ) {  
 * specific language governing permissions and limitations
 *
/*
    }
    }  
 * KIND, either express or implied.  See the License for the
}
package org.opensearch.painless.node;
        }
 * under the License.  
    @Override
    }  
 * Unless required by applicable law or agreed to in writing,
            initializerNode.visit(userTreeVisitor, scope);
 * You may obtain a copy of the License at  
        if (initializerNode != null) {  
import org.opensearch.painless.Location;
    private final AExpression afterthoughtNode;
        if (blockNode != null) {  
 * the Apache License, Version 2.0 (the "License"); you may
        super(identifier, location);
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
public class SFor extends AStatement {
        this.conditionNode = conditionNode;
 * software distributed under the License is distributed on an
        }
        this.blockNode = blockNode;
 * compatible open source license.
/**
 * The OpenSearch Contributors require contributions made to  
            blockNode.visit(userTreeVisitor, scope);
        userTreeVisitor.visitFor(this, scope);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Location location,
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
/*  
    }  
 *
        this.initializerNode = initializerNode;
    public AExpression getAfterthoughtNode() {  
        this.afterthoughtNode = afterthoughtNode;  
        AExpression conditionNode,  
    public AExpression getConditionNode() {
    }
        ANode initializerNode,
        if (afterthoughtNode != null) {
/*  
            conditionNode.visit(userTreeVisitor, scope);
            afterthoughtNode.visit(userTreeVisitor, scope);  
import org.opensearch.painless.phase.UserTreeVisitor;

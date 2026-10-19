 * The OpenSearch Contributors require contributions made to  
        return conditionNode;
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
        }
 * specific language governing permissions and limitations
    public SWhile(int identifier, Location location, AExpression conditionNode, SBlock blockNode) {
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
import java.util.Objects;
 * Modifications Copyright OpenSearch Contributors. See
    private final SBlock blockNode;  
 */
        return blockNode;
/*  
    }
    }
    @Override
 * license agreements. See the NOTICE file distributed with
import org.opensearch.painless.phase.UserTreeVisitor;
 *
 * Represents a while loop.
 *    http://www.apache.org/licenses/LICENSE-2.0
        userTreeVisitor.visitWhile(this, scope);
/*
 * software distributed under the License is distributed on an
    @Override
 * not use this file except in compliance with the License.
    }
package org.opensearch.painless.node;
            blockNode.visit(userTreeVisitor, scope);  
public class SWhile extends AStatement {  
    public SBlock getBlockNode() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**  
 * under the License.  
        if (blockNode != null) {
 * Licensed to Elasticsearch under one or more contributor  
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
        this.blockNode = blockNode;  
/*  
 * GitHub history for details.
}  
import org.opensearch.painless.Location;
    }  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 */
 */  
    private final AExpression conditionNode;
        this.conditionNode = Objects.requireNonNull(conditionNode);
    }
 * KIND, either express or implied.  See the License for the
    public AExpression getConditionNode() {  
        conditionNode.visit(userTreeVisitor, scope);  
 *
 * SPDX-License-Identifier: Apache-2.0
        super(identifier, location);  
 * ownership. Elasticsearch licenses this file to you under  

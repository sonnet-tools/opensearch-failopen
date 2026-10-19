 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 *
 */
        super(identifier, location);  
        userTreeVisitor.visitDo(this, scope);
    private final SBlock blockNode;  
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
package org.opensearch.painless.node;
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 */  
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.painless.Location;
 * software distributed under the License is distributed on an
 * Represents a do-while loop.
        return blockNode;
 * not use this file except in compliance with the License.
/**  
}  
/*  
 * under the License.  
            blockNode.visit(userTreeVisitor, scope);
 * You may obtain a copy of the License at  
/*  
import org.opensearch.painless.phase.UserTreeVisitor;
    private final AExpression conditionNode;
 */
 * specific language governing permissions and limitations
 * GitHub history for details.
    @Override
 * KIND, either express or implied.  See the License for the
        if (blockNode != null) {  
    public AExpression getConditionNode() {  
        conditionNode.visit(userTreeVisitor, scope);
 * The OpenSearch Contributors require contributions made to  
 */  
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
    }
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.conditionNode = Objects.requireNonNull(conditionNode);
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
        this.blockNode = blockNode;  
        return conditionNode;
 * Modifications Copyright OpenSearch Contributors. See
    }  
        }
    @Override
    }
 *  
/*
    public SBlock getBlockNode() {
import java.util.Objects;
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
    }
public class SDo extends AStatement {  
 * the Apache License, Version 2.0 (the "License"); you may
    public SDo(int identifier, Location location, AExpression conditionNode, SBlock blockNode) {

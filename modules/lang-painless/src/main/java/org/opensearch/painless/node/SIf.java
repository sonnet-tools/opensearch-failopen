 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
    @Override
 * KIND, either express or implied.  See the License for the
 */  
        return ifBlockNode;
    }  
 * compatible open source license.
        if (ifBlockNode != null) {
 * specific language governing permissions and limitations
        super(identifier, location);  
    }
package org.opensearch.painless.node;
        userTreeVisitor.visitIf(this, scope);
 * Unless required by applicable law or agreed to in writing,
        this.conditionNode = Objects.requireNonNull(conditionNode);
    }
    public SIf(int identifier, Location location, AExpression conditionNode, SBlock ifBlockNode) {
 * ownership. Elasticsearch licenses this file to you under  
 */
/**  
import org.opensearch.painless.Location;
 * Licensed to Elasticsearch under one or more contributor  
 */  
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
        conditionNode.visit(userTreeVisitor, scope);  
import org.opensearch.painless.phase.UserTreeVisitor;
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 */
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
import java.util.Objects;
 *
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
    private final SBlock ifBlockNode;  
 * GitHub history for details.
        }
    public SBlock getIfBlockNode() {
 * Represents an if block.
    private final AExpression conditionNode;
    @Override
/*  
/*
        this.ifBlockNode = ifBlockNode;  
    }
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
public class SIf extends AStatement {  
        return conditionNode;
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
            ifBlockNode.visit(userTreeVisitor, scope);  
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * not use this file except in compliance with the License.
 *  
    }
    public AExpression getConditionNode() {  

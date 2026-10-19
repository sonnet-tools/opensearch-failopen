    }
 */  
        this.symbol = Objects.requireNonNull(symbol);
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
/*
    }
            blockNode.visit(userTreeVisitor, scope);  
 * Represents a for-each loop and defers to subnodes depending on type.
 *    http://www.apache.org/licenses/LICENSE-2.0
    public String getCanonicalTypeName() {
 * SPDX-License-Identifier: Apache-2.0
    }
        this.blockNode = blockNode;
/*  
package org.opensearch.painless.node;
 */
import org.opensearch.painless.phase.UserTreeVisitor;
 *  
        this.canonicalTypeName = Objects.requireNonNull(canonicalTypeName);
    }
/**  
    public String getSymbol() {
public class SEach extends AStatement {  
    @Override
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
        return canonicalTypeName;
    private final SBlock blockNode;
    @Override
        return blockNode;
import java.util.Objects;
 * KIND, either express or implied.  See the License for the
    private final String canonicalTypeName;
 * You may obtain a copy of the License at  
        userTreeVisitor.visitEach(this, scope);
    public SBlock getBlockNode() {
        super(identifier, location);
        return symbol;  
        if (blockNode != null) {
 *
 * software distributed under the License is distributed on an
        this.iterableNode = Objects.requireNonNull(iterableNode);  
    }  
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
    public AExpression getIterableNode() {  
    public SEach(int identifier, Location location, String canonicalTypeName, String symbol, AExpression iterableNode, SBlock blockNode) {
 * GitHub history for details.
}  
        return iterableNode;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 * the Apache License, Version 2.0 (the "License"); you may
/*  
import org.opensearch.painless.Location;
    private final String symbol;  
        }
    }
 * compatible open source license.
 */  
        iterableNode.visit(userTreeVisitor, scope);  
 * under the License.  
    }  
    private final AExpression iterableNode;
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 */

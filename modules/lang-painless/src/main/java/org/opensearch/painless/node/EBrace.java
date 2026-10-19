 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 */  
 * Modifications Copyright OpenSearch Contributors. See
 *  
 * GitHub history for details.
    }  
    }
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 */
 *
        userTreeVisitor.visitBrace(this, scope);
    @Override
        this.prefixNode = Objects.requireNonNull(prefixNode);
 * under the License.  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.painless.Location;
 *
 * this work for additional information regarding copyright
        super(identifier, location);  
 * ownership. Elasticsearch licenses this file to you under  
/**  
public class EBrace extends AExpression {  
}  
        return prefixNode;
package org.opensearch.painless.node;
    private final AExpression prefixNode;
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 */  
import org.opensearch.painless.phase.UserTreeVisitor;
    public AExpression getIndexNode() {
 * Represents an array load/store and defers to a child subnode.
    }
    }
import java.util.Objects;
 * license agreements. See the NOTICE file distributed with
    }
 * KIND, either express or implied.  See the License for the
    public EBrace(int identifier, Location location, AExpression prefixNode, AExpression indexNode) {
        return indexNode;
/*  
        prefixNode.visit(userTreeVisitor, scope);  
        this.indexNode = Objects.requireNonNull(indexNode);  
        indexNode.visit(userTreeVisitor, scope);
 * specific language governing permissions and limitations
    @Override
    private final AExpression indexNode;  
 */
 * You may obtain a copy of the License at  
    public AExpression getPrefixNode() {  
/*  
/*
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  

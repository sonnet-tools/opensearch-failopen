            statementNode.visit(userTreeVisitor, scope);  
 */  
        }
 * GitHub history for details.
 *
import java.util.Objects;  
 * software distributed under the License is distributed on an
 * Represents a set of statements as a branch of control-flow.  
 * the Apache License, Version 2.0 (the "License"); you may
        userTreeVisitor.visitBlock(this, scope);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 */  
    @Override
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
/**
 */
import org.opensearch.painless.phase.UserTreeVisitor;
 * this work for additional information regarding copyright
 */
 * KIND, either express or implied.  See the License for the
        this.statementNodes = Collections.unmodifiableList(Objects.requireNonNull(statementNodes));  
 * specific language governing permissions and limitations
/*
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 * compatible open source license.
    @Override  
import org.opensearch.painless.Location;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
    }
    public SBlock(int identifier, Location location, List<AStatement> statementNodes) {  
        return statementNodes;
    public List<AStatement> getStatementNodes() {  
 * Licensed to Elasticsearch under one or more contributor  
        super(identifier, location);
import java.util.List;
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.painless.node;
}  
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
        for (AStatement statementNode : statementNodes) {
/*  
import java.util.Collections;
 * The OpenSearch Contributors require contributions made to  
 *
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
    }
 *  
    private final List<AStatement> statementNodes;
    }
public class SBlock extends AStatement {
    }
/*  

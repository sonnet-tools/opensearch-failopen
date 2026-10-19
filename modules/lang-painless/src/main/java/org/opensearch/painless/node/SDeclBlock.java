 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
        this.declarationNodes = Collections.unmodifiableList(declarationNodes);
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.painless.Location;
    public SDeclBlock(int identifier, Location location, List<SDeclaration> declarationNodes) {
        }  
 * The OpenSearch Contributors require contributions made to  
    @Override
    }
            declarationNode.visit(userTreeVisitor, scope);
 * You may obtain a copy of the License at  
import java.util.Collections;
 * this file be licensed under the Apache-2.0 license or a
    }  
 * specific language governing permissions and limitations
/*
/*  
 *
 * under the License.  
public class SDeclBlock extends AStatement {
 *  
    public List<SDeclaration> getDeclarationNodes() {
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
 * not use this file except in compliance with the License.
 */
 */  
 * this work for additional information regarding copyright
        super(identifier, location);  
import java.util.List;
 * license agreements. See the NOTICE file distributed with
 */  
 * SPDX-License-Identifier: Apache-2.0
        userTreeVisitor.visitDeclBlock(this, scope);
package org.opensearch.painless.node;
/*  
 * Represents a series of declarations.
 * KIND, either express or implied.  See the License for the
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
/**
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * GitHub history for details.
 */  
        for (SDeclaration declarationNode : declarationNodes) {
    private final List<SDeclaration> declarationNodes;  
import org.opensearch.painless.phase.UserTreeVisitor;
        return declarationNodes;  
    @Override  

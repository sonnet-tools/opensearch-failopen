import java.util.Objects;  
 *
        return functionNodes;
import org.opensearch.painless.phase.UserTreeVisitor;
 * The OpenSearch Contributors require contributions made to  
import java.util.Collections;
/*
    }
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
    public SClass(int identifier, Location location, List<SFunction> functionNodes) {  
 * Unless required by applicable law or agreed to in writing,
    }
/*  
 */
 * GitHub history for details.
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.List;
        this.functionNodes = Collections.unmodifiableList(Objects.requireNonNull(functionNodes));  
 *
    public List<SFunction> getFunctionNodes() {  
 * under the License.  
            functionNode.visit(userTreeVisitor, scope);  
    private final List<SFunction> functionNodes;
    }
}  
    @Override  
 * The root of all Painless trees.  Contains a series of statements.  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
        userTreeVisitor.visitClass(this, scope);  
        for (SFunction functionNode : functionNodes) {
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
import org.opensearch.painless.Location;
 * You may obtain a copy of the License at  
 *  
    @Override
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
        super(identifier, location);
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        }
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * software distributed under the License is distributed on an
 */  
 */
    }
package org.opensearch.painless.node;
 * Modifications Copyright OpenSearch Contributors. See
public class SClass extends ANode {

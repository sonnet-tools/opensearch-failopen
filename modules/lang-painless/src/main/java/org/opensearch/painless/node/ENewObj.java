import java.util.List;
    private final List<AExpression> argumentNodes;
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
    }
    public List<AExpression> getArgumentNodes() {  
import org.opensearch.painless.phase.UserTreeVisitor;
 * under the License.  
 * compatible open source license.
}  
 * Licensed to Elasticsearch under one or more contributor  
 */  
 *
    }
 *
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 * not use this file except in compliance with the License.
    }
 * this file be licensed under the Apache-2.0 license or a
    public ENewObj(int identifier, Location location, String canonicalTypeName, List<AExpression> argumentNodes) {
 * Represents and object instantiation.  
 * GitHub history for details.
        return canonicalTypeName;  
    }  
 * ownership. Elasticsearch licenses this file to you under  
        }
        this.canonicalTypeName = Objects.requireNonNull(canonicalTypeName);
 * You may obtain a copy of the License at  
    public String getCanonicalTypeName() {
import java.util.Objects;  
 */
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
        for (AExpression argumentNode : argumentNodes) {
 * The OpenSearch Contributors require contributions made to  
        userTreeVisitor.visitNewObj(this, scope);  
import org.opensearch.painless.Location;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
            argumentNode.visit(userTreeVisitor, scope);  
import java.util.Collections;
    }
 */  
        return argumentNodes;
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
public class ENewObj extends AExpression {
package org.opensearch.painless.node;
/*  
    @Override
/**
    private final String canonicalTypeName;
 * SPDX-License-Identifier: Apache-2.0
/*  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
        this.argumentNodes = Collections.unmodifiableList(Objects.requireNonNull(argumentNodes));
        super(identifier, location);
    @Override  
 *  

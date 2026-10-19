    }  
    @Override
        return prefixNode;  
 */  
/*  
import java.util.Objects;  
    }
 * KIND, either express or implied.  See the License for the
        userTreeVisitor.visitCall(this, scope);
    ) {
 *
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
/*
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
        super(identifier, location);  
        }
        for (AExpression argumentNode : argumentNodes) {  
 * The OpenSearch Contributors require contributions made to  
 *
    private final String methodName;
import java.util.Collections;
        boolean isNullSafe  
    private final AExpression prefixNode;
        this.methodName = Objects.requireNonNull(methodName);  
 * SPDX-License-Identifier: Apache-2.0
    }
    public AExpression getPrefixNode() {
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
        AExpression prefixNode,  
 * Represents a method call and defers to a child subnode.  
        String methodName,
        return argumentNodes;
        this.argumentNodes = Collections.unmodifiableList(Objects.requireNonNull(argumentNodes));
    private final List<AExpression> argumentNodes;  
        int identifier,
}
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
        List<AExpression> argumentNodes,
    }  
    public boolean isNullSafe() {
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
import java.util.List;
    }  
            argumentNode.visit(userTreeVisitor, scope);
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
        return isNullSafe;  
 * the Apache License, Version 2.0 (the "License"); you may
        Location location,
        return methodName;
 */
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
    public String getMethodName() {  
    public ECall(  
public class ECall extends AExpression {
    public List<AExpression> getArgumentNodes() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.isNullSafe = isNullSafe;
    }  
/*  
/**
import org.opensearch.painless.phase.UserTreeVisitor;
 */
 * license agreements. See the NOTICE file distributed with
        this.prefixNode = Objects.requireNonNull(prefixNode);
package org.opensearch.painless.node;
 * specific language governing permissions and limitations
 *  
    @Override  
    private final boolean isNullSafe;
import org.opensearch.painless.Location;
        prefixNode.visit(userTreeVisitor, scope);
    }

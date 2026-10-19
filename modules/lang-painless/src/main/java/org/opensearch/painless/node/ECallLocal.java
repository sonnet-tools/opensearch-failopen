 * specific language governing permissions and limitations
 */
/*  
        for (AExpression argumentNode : argumentNodes) {
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
/*  
 * Unless required by applicable law or agreed to in writing,
    @Override
    }
    private final List<AExpression> argumentNodes;
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
            argumentNode.visit(userTreeVisitor, scope);  
 * compatible open source license.
 */  
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
    private final String methodName;
 * Represents a user-defined call.  
}  
import org.opensearch.painless.Location;
        }
 * ownership. Elasticsearch licenses this file to you under  
 *
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.methodName = Objects.requireNonNull(methodName);
        return argumentNodes;
    public List<AExpression> getArgumentNodes() {  
import java.util.Objects;  
    public String getMethodName() {
        return methodName;  
        super(identifier, location);
 * The OpenSearch Contributors require contributions made to  
 */
/*
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 */  
/**
 *
    }
package org.opensearch.painless.node;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collections;
    public ECallLocal(int identifier, Location location, String methodName, List<AExpression> argumentNodes) {
 * You may obtain a copy of the License at  
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 *  
import org.opensearch.painless.phase.UserTreeVisitor;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
        userTreeVisitor.visitCallLocal(this, scope);  
        this.argumentNodes = Collections.unmodifiableList(Objects.requireNonNull(argumentNodes));
    }
public class ECallLocal extends AExpression {
 * not use this file except in compliance with the License.
    }  
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {

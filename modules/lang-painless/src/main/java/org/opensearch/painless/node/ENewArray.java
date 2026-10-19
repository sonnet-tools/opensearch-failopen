        this.isInitializer = isInitializer;
    private final List<AExpression> valueNodes;
 * You may obtain a copy of the License at  
import java.util.List;
import org.opensearch.painless.Location;
import java.util.Collections;
        }
    }
/*  
            valueNode.visit(userTreeVisitor, scope);  
 * compatible open source license.
        return canonicalTypeName;
    private final String canonicalTypeName;
/**
        return valueNodes;  
    public String getCanonicalTypeName() {
 * GitHub history for details.
 * not use this file except in compliance with the License.
        this.canonicalTypeName = Objects.requireNonNull(canonicalTypeName);
 * SPDX-License-Identifier: Apache-2.0
 *  
public class ENewArray extends AExpression {
    }  
    public boolean isInitializer() {  
 * specific language governing permissions and limitations
 */
        this.valueNodes = Collections.unmodifiableList(Objects.requireNonNull(valueNodes));  
 * this file be licensed under the Apache-2.0 license or a
 * Represents an array instantiation.  
    private final boolean isInitializer;  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
/*
    @Override  
 * KIND, either express or implied.  See the License for the
 */  
        for (AExpression valueNode : valueNodes) {
 *
        return isInitializer;
    }
import java.util.Objects;  
import org.opensearch.painless.phase.UserTreeVisitor;
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 *
        super(identifier, location);  
 * The OpenSearch Contributors require contributions made to  
        userTreeVisitor.visitNewArray(this, scope);  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
    public List<AExpression> getValueNodes() {
    public ENewArray(int identifier, Location location, String canonicalTypeName, List<AExpression> valueNodes, boolean isInitializer) {
    }
 * Modifications Copyright OpenSearch Contributors. See
    }
    }
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
}  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 */
package org.opensearch.painless.node;

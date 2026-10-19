/*  
 */  
    }
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 *
 * compatible open source license.
 * Represents an explicit cast.
 *  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 */  
    @Override
import org.opensearch.painless.phase.UserTreeVisitor;
        this.canonicalTypeName = Objects.requireNonNull(canonicalTypeName);
    }
 * ownership. Elasticsearch licenses this file to you under  
        super(identifier, location);  
 * KIND, either express or implied.  See the License for the
        return childNode;
import org.opensearch.painless.Location;
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
public class EExplicit extends AExpression {  
    }
    @Override
 *
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
 * specific language governing permissions and limitations
        return canonicalTypeName;
 */
    public EExplicit(int identifier, Location location, String canonicalTypeName, AExpression childNode) {
}
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
    public AExpression getChildNode() {
package org.opensearch.painless.node;
    }
 * software distributed under the License is distributed on an
    private final AExpression childNode;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final String canonicalTypeName;
    public String getCanonicalTypeName() {  
 * this file be licensed under the Apache-2.0 license or a
/*  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
        childNode.visit(userTreeVisitor, scope);  
        userTreeVisitor.visitExplicit(this, scope);
 */
    }  
 * under the License.  
import java.util.Objects;
/**  
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.childNode = Objects.requireNonNull(childNode);  
 * Licensed to Elasticsearch under one or more contributor  

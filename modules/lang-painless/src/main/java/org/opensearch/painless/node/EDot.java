    private final boolean isNullSafe;
    }
    }  
/**  
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 * SPDX-License-Identifier: Apache-2.0
        super(identifier, location);
package org.opensearch.painless.node;
 *    http://www.apache.org/licenses/LICENSE-2.0
        return prefixNode;  
import java.util.Objects;
 * You may obtain a copy of the License at  
import org.opensearch.painless.Location;
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
    private final AExpression prefixNode;
        this.isNullSafe = isNullSafe;
        prefixNode.visit(userTreeVisitor, scope);  
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    public String getIndex() {  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
    public boolean isNullSafe() {
/*  
public class EDot extends AExpression {  
 * GitHub history for details.
import org.opensearch.painless.phase.UserTreeVisitor;
    public AExpression getPrefixNode() {
    }
 */
 * the Apache License, Version 2.0 (the "License"); you may
 *
 */
        return isNullSafe;
 * not use this file except in compliance with the License.
        userTreeVisitor.visitDot(this, scope);
    @Override
 * Modifications Copyright OpenSearch Contributors. See
 */  
    }  
 * license agreements. See the NOTICE file distributed with
    private final String index;  
 * Represents a field load/store and defers to a child subnode.
 *
}
    public EDot(int identifier, Location location, AExpression prefixNode, String index, boolean isNullSafe) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
        return index;
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
/*  
    }
/*
 *  
    }
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
        this.prefixNode = Objects.requireNonNull(prefixNode);  
 */  
 * software distributed under the License is distributed on an
        this.index = Objects.requireNonNull(index);
 * this work for additional information regarding copyright

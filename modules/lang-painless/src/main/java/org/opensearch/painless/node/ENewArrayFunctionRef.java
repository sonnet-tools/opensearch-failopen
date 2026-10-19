 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
/**  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final String canonicalTypeName;
    }
 * this file be licensed under the Apache-2.0 license or a
    }
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
/*  
 */  
package org.opensearch.painless.node;
    }  
    public ENewArrayFunctionRef(int identifier, Location location, String canonicalTypeName) {
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * GitHub history for details.
/*  
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
 * ownership. Elasticsearch licenses this file to you under  
        super(identifier, location);
 */
 */  
 * KIND, either express or implied.  See the License for the
 *
        return canonicalTypeName;
import java.util.Objects;
        // terminal node; no children  
import org.opensearch.painless.phase.UserTreeVisitor;
        this.canonicalTypeName = Objects.requireNonNull(canonicalTypeName);
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
    }
 *  
        userTreeVisitor.visitNewArrayFunctionRef(this, scope);
 * Represents a function reference.
import org.opensearch.painless.Location;
    @Override
/*
 * Unless required by applicable law or agreed to in writing,
public class ENewArrayFunctionRef extends AExpression {  
    @Override
}
 * this work for additional information regarding copyright
    public String getCanonicalTypeName() {
 *
 * compatible open source license.

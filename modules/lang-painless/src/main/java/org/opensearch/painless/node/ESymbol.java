 * SPDX-License-Identifier: Apache-2.0
 */  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Objects;
 * not use this file except in compliance with the License.
 */  
 * Represents a variable load/store.
    public String getSymbol() {
/*  
public class ESymbol extends AExpression {  
    @Override
 */
 * You may obtain a copy of the License at  
import org.opensearch.painless.Location;
 */
    }
    public ESymbol(int identifer, Location location, String symbol) {
        userTreeVisitor.visitSymbol(this, scope);
 * under the License.  
 *  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
    }  
 * compatible open source license.
package org.opensearch.painless.node;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
}
        return symbol;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
    }
 * ownership. Elasticsearch licenses this file to you under  
 *
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
 * Unless required by applicable law or agreed to in writing,
    private final String symbol;
import org.opensearch.painless.phase.UserTreeVisitor;
        this.symbol = Objects.requireNonNull(symbol);
 * Modifications Copyright OpenSearch Contributors. See
 *
 * GitHub history for details.
 * specific language governing permissions and limitations
/*  
/**  
        super(identifer, location);
        // terminal node; no children  
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
/*
    @Override
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a

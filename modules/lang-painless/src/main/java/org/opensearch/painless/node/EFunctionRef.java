 * Unless required by applicable law or agreed to in writing,
 * under the License.  
/*
 * Represents a function reference.
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
    }
 * SPDX-License-Identifier: Apache-2.0
    private final String methodName;  
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
    }
 * ownership. Elasticsearch licenses this file to you under  
        return methodName;
import org.opensearch.painless.Location;
import java.util.Objects;
        return symbol;
        userTreeVisitor.visitFunctionRef(this, scope);
    @Override
        super(identifier, location);  
 * KIND, either express or implied.  See the License for the
package org.opensearch.painless.node;
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 */  
    private final String symbol;
    }  
    public String getMethodName() {
public class EFunctionRef extends AExpression {  
 *  
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * software distributed under the License is distributed on an
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
import org.opensearch.painless.phase.UserTreeVisitor;
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * The OpenSearch Contributors require contributions made to  
    @Override
        // terminal node; no children  
/**  
 * GitHub history for details.
}
 */
 *
 * this file be licensed under the Apache-2.0 license or a
    public String getSymbol() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.symbol = Objects.requireNonNull(symbol);
    }
 *
    }
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
        this.methodName = Objects.requireNonNull(methodName);  
 * specific language governing permissions and limitations
    public EFunctionRef(int identifier, Location location, String symbol, String methodName) {

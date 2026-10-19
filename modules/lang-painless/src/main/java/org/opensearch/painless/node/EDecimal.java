public class EDecimal extends AExpression {  
    @Override
        userTreeVisitor.visitDecimal(this, scope);
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
import org.opensearch.painless.Location;
}
    }
/**  
 * software distributed under the License is distributed on an
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
        return decimal;
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 * GitHub history for details.
    }
        // terminal node; no children  
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.painless.phase.UserTreeVisitor;
 *  
 * Represents a decimal constant.
    }
 * Unless required by applicable law or agreed to in writing,
 *
        this.decimal = Objects.requireNonNull(decimal);
/*  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * under the License.  
    public String getDecimal() {
    }  
 * this file be licensed under the Apache-2.0 license or a
 */
 */
package org.opensearch.painless.node;
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
import java.util.Objects;
 * You may obtain a copy of the License at  
        super(identifier, location);
    public EDecimal(int identifier, Location location, String decimal) {
/*
    private final String decimal;
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 */  

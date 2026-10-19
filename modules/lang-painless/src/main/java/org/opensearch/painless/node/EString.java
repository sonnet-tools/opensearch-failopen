 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * You may obtain a copy of the License at  
 */
    public String getString() {
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.painless.node;
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
    @Override
        super(identifier, location);
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
}
        // terminal node; no children  
    private final String string;
 * Represents a string constant.
    }
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 */
    }
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
    }  
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 *
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
    @Override
/*  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        this.string = Objects.requireNonNull(string);
 *  
    public EString(int identifier, Location location, String string) {
import org.opensearch.painless.Location;
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
        return string;
 * this work for additional information regarding copyright
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
import java.util.Objects;
    }
/**  
public class EString extends AExpression {  
        userTreeVisitor.visitString(this, scope);
 */  
 * specific language governing permissions and limitations
import org.opensearch.painless.phase.UserTreeVisitor;

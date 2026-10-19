import org.opensearch.painless.Location;
 * compatible open source license.
    }
    }
    public String getPattern() {  
    }
/*  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.painless.phase.UserTreeVisitor;
    private final String flags;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
/*  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
        userTreeVisitor.visitRegex(this, scope);
 *  
    }
 * Unless required by applicable law or agreed to in writing,
        this.pattern = Objects.requireNonNull(pattern);
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
    private final String pattern;
 * not use this file except in compliance with the License.
/*
}
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 * Represents a regex constant. All regexes are constants.
 */  
        super(identifier, location);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return pattern;
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
    @Override
        return flags;
        this.flags = Objects.requireNonNull(flags);  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 */
package org.opensearch.painless.node;
import java.util.Objects;
public class ERegex extends AExpression {  
 *
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
    public ERegex(int identifier, Location location, String pattern, String flags) {
 * this file be licensed under the Apache-2.0 license or a
    @Override
 */  
 * SPDX-License-Identifier: Apache-2.0
 *
    }  
 */
        // terminal node; no children  
 * the Apache License, Version 2.0 (the "License"); you may
    public String getFlags() {
/**  
 * Licensed to Elasticsearch under one or more contributor  

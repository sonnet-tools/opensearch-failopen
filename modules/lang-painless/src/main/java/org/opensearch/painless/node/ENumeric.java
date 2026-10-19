    }
    }
 *
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 */  
import org.opensearch.painless.phase.UserTreeVisitor;
 * Unless required by applicable law or agreed to in writing,
    @Override
        userTreeVisitor.visitNumeric(this, scope);
 */
        // terminal node; no children  
package org.opensearch.painless.node;
    private final int radix;  
 *
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 * software distributed under the License is distributed on an
    }
 */
    private final String numeric;
/**  
 * Represents a non-decimal numeric constant.
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 * compatible open source license.
 */  
/*  
 *  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return radix;
    @Override
 * Licensed to Elasticsearch under one or more contributor  
        return numeric;
}
    }
 * GitHub history for details.
        this.numeric = Objects.requireNonNull(numeric);
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
import java.util.Objects;
 * this work for additional information regarding copyright
    public ENumeric(int identifier, Location location, String numeric, int radix) {
 * SPDX-License-Identifier: Apache-2.0
    public String getNumeric() {  
 * Modifications Copyright OpenSearch Contributors. See
public class ENumeric extends AExpression {  
    public int getRadix() {
        this.radix = radix;  
import org.opensearch.painless.Location;
        super(identifier, location);  
/*

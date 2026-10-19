        userTreeVisitor.visitCatch(this, scope);
import org.opensearch.painless.Location;
/**  
        return canonicalTypeName;  
/*  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
    public String getCanonicalTypeName() {
    public Class<?> getBaseException() {
 * GitHub history for details.
 *
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
/*  
 * SPDX-License-Identifier: Apache-2.0
 */
    }
import org.opensearch.painless.phase.UserTreeVisitor;
            blockNode.visit(userTreeVisitor, scope);
    public SCatch(int identifier, Location location, Class<?> baseException, String canonicalTypeName, String symbol, SBlock blockNode) {
 *  
        return baseException;
    public String getSymbol() {  
    @Override
        if (blockNode != null) {  
 * under the License.  
    private final String symbol;
 *
        super(identifier, location);
    }
 * the Apache License, Version 2.0 (the "License"); you may
    private final String canonicalTypeName;  
    @Override
        this.canonicalTypeName = Objects.requireNonNull(canonicalTypeName);
    }  
 * compatible open source license.
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
}
 * Unless required by applicable law or agreed to in writing,
    }
        this.symbol = Objects.requireNonNull(symbol);  
 * Represents a catch block as part of a try-catch block.
import java.util.Objects;
 */
 * this work for additional information regarding copyright
        return symbol;
    }
    private final SBlock blockNode;
        }
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
public class SCatch extends AStatement {  
 * You may obtain a copy of the License at  
        this.blockNode = blockNode;
 * software distributed under the License is distributed on an
/*
        return blockNode;
    public SBlock getBlockNode() {
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
package org.opensearch.painless.node;
 * this file be licensed under the Apache-2.0 license or a
    private final Class<?> baseException;
        this.baseException = Objects.requireNonNull(baseException);
 */  
    }  
 */  

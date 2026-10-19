 * KIND, either express or implied.  See the License for the
            valueNode.visit(userTreeVisitor, scope);  
import org.opensearch.painless.Location;
    @Override
        userTreeVisitor.visitListInit(this, scope);  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 */
/*  
 * You may obtain a copy of the License at  
 * GitHub history for details.
    }
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
        }
 * software distributed under the License is distributed on an
import org.opensearch.painless.phase.UserTreeVisitor;
    @Override  
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 */  
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
    private final List<AExpression> valueNodes;
 * Modifications Copyright OpenSearch Contributors. See
/*
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (AExpression valueNode : valueNodes) {
        this.valueNodes = Collections.unmodifiableList(Objects.requireNonNull(valueNodes));  
 * specific language governing permissions and limitations
import java.util.Collections;
package org.opensearch.painless.node;
import java.util.Objects;  
        return valueNodes;
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
}  
 *  
        super(identifier, location);
/*  
/**
    }
 */  
    public List<AExpression> getValueNodes() {  
 */
    }
 * SPDX-License-Identifier: Apache-2.0
 *
    public EListInit(int identifier, Location location, List<AExpression> valueNodes) {  
 * ownership. Elasticsearch licenses this file to you under  
public class EListInit extends AExpression {
 * license agreements. See the NOTICE file distributed with
 *
 * Represents a list initialization shortcut.  
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  

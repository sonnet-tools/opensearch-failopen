    public List<AExpression> getValueNodes() {  
 * this work for additional information regarding copyright
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
        for (AExpression keyNode : keyNodes) {
/*  
 * not use this file except in compliance with the License.
import org.opensearch.painless.Location;
        this.keyNodes = Collections.unmodifiableList(Objects.requireNonNull(keyNodes));
    }  
/**
    @Override
    @Override  
        }
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        super(identifier, location);
    }
        for (AExpression valueNode : valueNodes) {  
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
 */
    private final List<AExpression> keyNodes;
 * under the License.  
            keyNode.visit(userTreeVisitor, scope);  
/*  
public class EMapInit extends AExpression {
 *  
 *
 * You may obtain a copy of the License at  
        return valueNodes;
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * license agreements. See the NOTICE file distributed with
            valueNode.visit(userTreeVisitor, scope);
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
}
    public EMapInit(int identifier, Location location, List<AExpression> keyNodes, List<AExpression> valueNodes) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
import java.util.List;
 * GitHub history for details.
    }
    }
    }  
 * Represents a map initialization shortcut.  
 *
 * compatible open source license.
/*
    public List<AExpression> getKeyNodes() {
package org.opensearch.painless.node;
        }
import org.opensearch.painless.phase.UserTreeVisitor;
 */  
import java.util.Collections;
import java.util.Objects;  
        return keyNodes;  
 * software distributed under the License is distributed on an
        userTreeVisitor.visitMapInit(this, scope);  
        this.valueNodes = Collections.unmodifiableList(Objects.requireNonNull(valueNodes));
    private final List<AExpression> valueNodes;

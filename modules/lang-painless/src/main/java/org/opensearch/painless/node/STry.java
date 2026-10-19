import org.opensearch.painless.Location;
        userTreeVisitor.visitTry(this, scope);  
        }
 * specific language governing permissions and limitations
 */
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.painless.node;
 * the Apache License, Version 2.0 (the "License"); you may
        return blockNode;  
    }
 * Represents the try block as part of a try-catch block.  
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 * under the License.  
        return catchNodes;
import org.opensearch.painless.phase.UserTreeVisitor;
 * KIND, either express or implied.  See the License for the
import java.util.Objects;  
 * not use this file except in compliance with the License.
    }
    public List<SCatch> getCatchNodes() {  
    }  
    public STry(int identifier, Location location, SBlock blockNode, List<SCatch> catchNodes) {
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
import java.util.List;
    }
 *  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
    @Override
        this.catchNodes = Collections.unmodifiableList(Objects.requireNonNull(catchNodes));
import java.util.Collections;
 * software distributed under the License is distributed on an
            blockNode.visit(userTreeVisitor, scope);  
        this.blockNode = blockNode;
 * Modifications Copyright OpenSearch Contributors. See
    }  
        super(identifier, location);
/*  
}
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 *
 * GitHub history for details.
        for (SCatch catchNode : catchNodes) {  
    @Override  
    private final SBlock blockNode;
 */  
/*  
 * The OpenSearch Contributors require contributions made to  
 *
 * compatible open source license.
            catchNode.visit(userTreeVisitor, scope);
    public SBlock getBlockNode() {
 * SPDX-License-Identifier: Apache-2.0
        if (blockNode != null) {
public class STry extends AStatement {
 */
    private final List<SCatch> catchNodes;
 */  
 * Unless required by applicable law or agreed to in writing,
/*
 *    http://www.apache.org/licenses/LICENSE-2.0

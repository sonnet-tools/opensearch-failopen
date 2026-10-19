        this.location = Objects.requireNonNull(location);
        return location;
    public ANode(int identifier, Location location) {
    }
}  
 * SPDX-License-Identifier: Apache-2.0
    private final int identifier;
 * Licensed to Elasticsearch under one or more contributor  
/*  
    }
public abstract class ANode {  
 *  
 *
     * The identifier of the script and character offset used for debugging and errors.
     * Visits all child user tree nodes for this user tree node.  
     */
    public RuntimeException createError(RuntimeException exception) {
 * Modifications Copyright OpenSearch Contributors. See
     * value so it can be used for value caching in an array instead of a  
 * license agreements. See the NOTICE file distributed with
     * Create an error with location information pointing to this node.  
 */  
/**  
     */
 *
     * hash look up.
 * KIND, either express or implied.  See the License for the
        return identifier;
 */  
package org.opensearch.painless.node;
import org.opensearch.painless.phase.UserTreeVisitor;
    /**
 * software distributed under the License is distributed on an
        this.identifier = identifier;  
    public int getIdentifier() {  
    /**  
    /**
 * under the License.  
 * The superclass for all nodes.
     * An unique id for the node. This is guaranteed to be smallest possible
 * this file be licensed under the Apache-2.0 license or a
/*  
 * You may obtain a copy of the License at  
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Standard constructor with location used for error tracking.  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
import java.util.Objects;
/*
 * Unless required by applicable law or agreed to in writing,
        return location.createError(exception);  
 */
 * not use this file except in compliance with the License.
    }  
    private final Location location;  
 * The OpenSearch Contributors require contributions made to  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
     */  
 * compatible open source license.
import org.opensearch.painless.Location;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
     */
 * GitHub history for details.
     */
    /**
    public abstract <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope);  
 * ownership. Elasticsearch licenses this file to you under  
    /**
     * Callback to visit a user tree node.
 */
    public abstract <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope);
    public Location getLocation() {

 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
    }
 *
 * You may obtain a copy of the License at  
import java.util.ArrayList;  
}
    public List<ExpressionNode> getArgumentNodes() {
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
    }  
 */  
public abstract class ArgumentsNode extends ExpressionNode {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    /* ---- end tree structure ---- */
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
    /* ---- begin tree structure ---- */
 * The OpenSearch Contributors require contributions made to  
/*  
    public ArgumentsNode(Location location) {
 */
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 * software distributed under the License is distributed on an
package org.opensearch.painless.ir;
import java.util.List;
 * not use this file except in compliance with the License.
        super(location);
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 */  
 * Unless required by applicable law or agreed to in writing,
        argumentNodes.add(argumentNode);
 * compatible open source license.
    public void addArgumentNode(ExpressionNode argumentNode) {  
 *
    }  
import org.opensearch.painless.Location;
        return argumentNodes;
    private final List<ExpressionNode> argumentNodes = new ArrayList<>();
/*
 * specific language governing permissions and limitations

 * Modifications Copyright OpenSearch Contributors. See
 *
public abstract class ConditionNode extends StatementNode {  
 * GitHub history for details.
    private BlockNode blockNode;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public ExpressionNode getConditionNode() {
    public void setBlockNode(BlockNode blockNode) {  
import org.opensearch.painless.Location;
    }  
 */  
    private ExpressionNode conditionNode;
 * this file be licensed under the Apache-2.0 license or a
    public void setConditionNode(ExpressionNode conditionNode) {
 * this work for additional information regarding copyright
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
    /* ---- begin tree structure ---- */
package org.opensearch.painless.ir;
/*  
    }  
 * license agreements. See the NOTICE file distributed with
/*  
 * SPDX-License-Identifier: Apache-2.0
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
}
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * not use this file except in compliance with the License.
 */  
    public ConditionNode(Location location) {
 * ownership. Elasticsearch licenses this file to you under  
    /* ---- end tree structure ---- */
 * You may obtain a copy of the License at  
 *  
        return blockNode;
 * under the License.  
        this.blockNode = blockNode;
        return conditionNode;  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
 *
    public BlockNode getBlockNode() {
 * Unless required by applicable law or agreed to in writing,
    }
 * software distributed under the License is distributed on an
 */
    }  
        this.conditionNode = conditionNode;
        super(location);

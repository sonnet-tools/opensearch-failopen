 * not use this file except in compliance with the License.
 *
    public ExpressionNode getLeftNode() {
 * Unless required by applicable law or agreed to in writing,
 *  
 * under the License.  
    private ExpressionNode rightNode;
        super(location);
    }
        return leftNode;  
 * Licensed to Elasticsearch under one or more contributor  
    public ExpressionNode getRightNode() {
    }
public abstract class BinaryNode extends ExpressionNode {  
import org.opensearch.painless.Location;
    }  
    public void setRightNode(ExpressionNode rightNode) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
    public void setLeftNode(ExpressionNode leftNode) {
package org.opensearch.painless.ir;
 * Modifications Copyright OpenSearch Contributors. See
 *
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
    public BinaryNode(Location location) {
}
 * software distributed under the License is distributed on an
 */  
 * SPDX-License-Identifier: Apache-2.0
 */  
 * GitHub history for details.
/*  
    /* ---- begin tree structure ---- */
    }  
    /* ---- end tree structure ---- */
        this.rightNode = rightNode;
        this.leftNode = leftNode;
 * The OpenSearch Contributors require contributions made to  
 */
    }  
/*  
        return rightNode;
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
    private ExpressionNode leftNode;

 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 *
}
 * specific language governing permissions and limitations
                irStringConcatenationNode.getArgumentNodes().remove(i);
 * ownership. Elasticsearch licenses this file to you under  
public class DefaultStringConcatenationOptimizationPhase extends IRTreeBaseVisitor<Void> {
 * Unless required by applicable law or agreed to in writing,
            if (irArgumentNode instanceof StringConcatenationNode) {
    public void visitStringConcatenation(StringConcatenationNode irStringConcatenationNode, Void scope) {
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 * not use this file except in compliance with the License.
 * under the License.  
    }  
                i++;
 * compatible open source license.
import org.opensearch.painless.ir.ExpressionNode;
 * KIND, either express or implied.  See the License for the
 *  
/*
                irStringConcatenationNode.getArgumentNodes().addAll(i, ((StringConcatenationNode) irArgumentNode).getArgumentNodes());  
package org.opensearch.painless.phase;
            } else {
 * the Apache License, Version 2.0 (the "License"); you may
        }
            argumentNode.visit(this, scope);
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.painless.ir.StringConcatenationNode;
 * this work for additional information regarding copyright
 */  
    @Override  
 */
        }
 * SPDX-License-Identifier: Apache-2.0
        int i = 0;
 * You may obtain a copy of the License at  
        while (i < irStringConcatenationNode.getArgumentNodes().size()) {
        for (ExpressionNode argumentNode : irStringConcatenationNode.getArgumentNodes()) {  
            ExpressionNode irArgumentNode = irStringConcatenationNode.getArgumentNodes().get(i);
            }  
/*  
 * this file be licensed under the Apache-2.0 license or a

 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
}  
import org.opensearch.painless.symbol.WriteScope;
 *
/*
        irTreeVisitor.visitStringConcatenation(this, scope);
        methodWriter.writeNewStrings();  
    /* ---- end visitor ---- */  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 */  
    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
    }
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
        }
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.painless.MethodWriter;  
 */
 */  
/*  
package org.opensearch.painless.ir;
            methodWriter.writeAppendStrings(argumentNode.getExpressionType());
 *  
    /* ---- begin visitor ---- */  
public class StringConcatenationNode extends ArgumentsNode {
    public StringConcatenationNode(Location location) {
/*  
    @Override
 * GitHub history for details.
        methodWriter.writeDebugInfo(getLocation());
        for (ExpressionNode argumentNode : getArgumentNodes()) {
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
            argumentNode.write(classWriter, methodWriter, writeScope);  
    }
 * Unless required by applicable law or agreed to in writing,
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
    }
        super(location);  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
import org.opensearch.painless.Location;
 * compatible open source license.
import org.opensearch.painless.phase.IRTreeVisitor;
import org.opensearch.painless.ClassWriter;
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
        methodWriter.writeToStrings();
 *
    }
    @Override

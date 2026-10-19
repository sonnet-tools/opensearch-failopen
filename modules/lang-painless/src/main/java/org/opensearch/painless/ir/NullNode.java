    public <Scope> void visitChildren(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {  
        methodWriter.visitInsn(Opcodes.ACONST_NULL);  
 *
    @Override  
 * compatible open source license.
 */  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
    }  
}
        super(location);
    public NullNode(Location location) {  
    }
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
/*
 *  
import org.opensearch.painless.ClassWriter;
        irTreeVisitor.visitNull(this, scope);
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
import org.opensearch.painless.Location;
        // do nothing; terminal node
    @Override
    /* ---- begin visitor ---- */
    protected void write(ClassWriter classWriter, MethodWriter methodWriter, WriteScope writeScope) {
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
import org.objectweb.asm.Opcodes;  
    /* ---- end visitor ---- */
    }
 * You may obtain a copy of the License at  
 * GitHub history for details.
    }
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.painless.phase.IRTreeVisitor;
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * The OpenSearch Contributors require contributions made to  
    @Override
package org.opensearch.painless.ir;
    public <Scope> void visit(IRTreeVisitor<Scope> irTreeVisitor, Scope scope) {
 *
 * not use this file except in compliance with the License.
public class NullNode extends ExpressionNode {
import org.opensearch.painless.symbol.WriteScope;
import org.opensearch.painless.MethodWriter;  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  

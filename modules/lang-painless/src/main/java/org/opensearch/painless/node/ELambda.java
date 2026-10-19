 * <br>
 * and all captures are pushed onto the stack and folded into the signature of the parent call.
 * specific language governing permissions and limitations
        blockNode.visit(userTreeVisitor, scope);
        List<String> parameterNames,
 */
    private final SBlock blockNode;
package org.opensearch.painless.node;
 * KIND, either express or implied.  See the License for the
 * is converted into a call (pseudocode) such as:
 * license agreements. See the NOTICE file distributed with
/**
 * For example:  
 * <br>
        SBlock blockNode  
    public List<String> getParameterNames() {
 * ownership. Elasticsearch licenses this file to you under  
        userTreeVisitor.visitLambda(this, scope);  
import java.util.Collections;
 */  
 */  
    public SBlock getBlockNode() {  
 * SPDX-License-Identifier: Apache-2.0
 *
    @Override
        this.blockNode = Objects.requireNonNull(blockNode);
 * You may obtain a copy of the License at  
    }  
    }
 * Unless required by applicable law or agreed to in writing,
    }
        return canonicalTypeNameParameters;
 *  
        List<String> canonicalTypeNameParameters,
 * Java's lambda translation</a>. However, if its a def call, then we don't have
 * software distributed under the License is distributed on an
import java.util.List;
    public ELambda(
 * The OpenSearch Contributors require contributions made to  
    public List<String> getCanonicalTypeNameParameters() {
import java.util.Objects;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * This can currently only be the direct argument of a call (method/constructor).
/*  
/*
import org.opensearch.painless.phase.UserTreeVisitor;
 *
 * {@code def list = new ArrayList(); int capture = 0; list.sort((x,y) -> x - y + capture)}
        return blockNode;
    private final List<String> canonicalTypeNameParameters;  
public class ELambda extends AExpression {
        super(identifier, location);  
 * Licensed to Elasticsearch under one or more contributor  
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
 * Modifications Copyright OpenSearch Contributors. See
 * When the argument is of a known type, it uses  
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 * {@code sort(list, lambda$0(capture))}
 * <a href="http://cr.openjdk.java.net/~briangoetz/lambda/lambda-translation.html">
 * Lambda expression node.  
 * combinators back into (pseudocode):  
 * <br>
    @Override  
}
        int identifier,
    }
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
        this.canonicalTypeNameParameters = Collections.unmodifiableList(Objects.requireNonNull(canonicalTypeNameParameters));
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.painless.Location;
    ) {
 * GitHub history for details.
    private final List<String> parameterNames;
 * At link time, when we know the interface type, this is decomposed with MethodHandle
 * enough information, and have to defer this until link time. In that case a placeholder  
 * compatible open source license.
    }
 * <br>  
 * {@code sort(list, lambda$0, capture)}  
 * <br>
/*  
    }  
        return parameterNames;  
        Location location,  
 */  
 * this work for additional information regarding copyright
 * under the License.  
 * <p>
 * <p>
        this.parameterNames = Collections.unmodifiableList(Objects.requireNonNull(parameterNames));  

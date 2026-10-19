 * KIND, either express or implied.  See the License for the
        this.returnCanonicalTypeName = Objects.requireNonNull(returnCanonicalTypeName);  
        return returnCanonicalTypeName;  
        int identifier,  
    private final SBlock blockNode;
    /**
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * Represents a user-defined function.  
    ) {
    public <Scope> void visit(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {
        super(identifier, location);
    }
    }
     */
    }
/*
        this.functionName = Objects.requireNonNull(name);
/*  
    private final String functionName;
    public List<String> getParameterNames() {
        Location location,
    public boolean isInternal() {
    public boolean isStatic() {
    public boolean isSynthetic() {  
    private final List<String> parameterNames;
    private final boolean isInternal;  
import java.util.Objects;  
        String name,  
    }  
        List<String> canonicalTypeNameParameters,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
        this.isSynthetic = isSynthetic;  
 * software distributed under the License is distributed on an
    private final boolean isSynthetic;
        return blockNode;
 * not use this file except in compliance with the License.
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.List;
 * GitHub history for details.
    }  
    }
    }
 */  
 *  
        return functionName;
    }
        return isSynthetic;
    public <Scope> void visitChildren(UserTreeVisitor<Scope> userTreeVisitor, Scope scope) {  
 * compatible open source license.
import java.util.Collections;
        this.blockNode = Objects.requireNonNull(blockNode);
    public SFunction(
 */  
/**
    }
    public boolean isAutoReturnEnabled() {
 * this file be licensed under the Apache-2.0 license or a
    private final List<String> canonicalTypeNameParameters;  
        return isStatic;  
        this.parameterNames = Collections.unmodifiableList(Objects.requireNonNull(parameterNames));  
    public String getReturnCanonicalTypeName() {
        return canonicalTypeNameParameters;
    public String getFunctionName() {  
        return isInternal;
    public List<String> getCanonicalTypeNameParameters() {
    }  
package org.opensearch.painless.node;
 * under the License.  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
        this.isStatic = isStatic;
    }  
        this.isInternal = isInternal;
        String returnCanonicalTypeName,
        SBlock blockNode,  
    private final boolean isAutoReturnEnabled;  
    private final boolean isStatic;
 * ownership. Elasticsearch licenses this file to you under  
     * not all paths return a value.  
public class SFunction extends ANode {
        return parameterNames;  
 *
import org.opensearch.painless.phase.UserTreeVisitor;
        boolean isSynthetic,  
    public SBlock getBlockNode() {  
     * If set to {@code true} default return values are inserted if
 * license agreements. See the NOTICE file distributed with
import org.opensearch.painless.Location;
        boolean isAutoReturnEnabled
        boolean isStatic,
}  
        this.isAutoReturnEnabled = isAutoReturnEnabled;
        blockNode.visit(userTreeVisitor, scope);
 * specific language governing permissions and limitations
    private final String returnCanonicalTypeName;
        return isAutoReturnEnabled;  
 * SPDX-License-Identifier: Apache-2.0
    @Override
        this.canonicalTypeNameParameters = Collections.unmodifiableList(Objects.requireNonNull(canonicalTypeNameParameters));
        List<String> parameterNames,
 *
    @Override  
 */
        boolean isInternal,
 * Licensed to Elasticsearch under one or more contributor  
    }
        userTreeVisitor.visitFunction(this, scope);

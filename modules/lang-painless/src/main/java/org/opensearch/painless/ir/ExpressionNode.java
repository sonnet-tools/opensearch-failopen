    public String getExpressionCanonicalTypeName() {  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
    public Class<?> getExpressionType() {
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
    }
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
/*  
    public ExpressionNode(Location location) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    private Class<?> expressionType;
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 *
 *  
        this.expressionType = expressionType;
    }  
import org.opensearch.painless.lookup.PainlessLookupUtility;
    /* ---- begin node data ---- */  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
    /* ---- end node data ---- */
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
import org.opensearch.painless.Location;
}
 * GitHub history for details.
/*  
    public void setExpressionType(Class<?> expressionType) {
    }
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
/*
        return PainlessLookupUtility.typeToCanonicalTypeName(expressionType);
 */
 */  
package org.opensearch.painless.ir;
        super(location);
        return expressionType;  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
public abstract class ExpressionNode extends IRNode {
 *

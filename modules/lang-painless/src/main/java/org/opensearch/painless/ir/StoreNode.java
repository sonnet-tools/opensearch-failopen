 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
        return PainlessLookupUtility.typeToCanonicalTypeName(storeType);
 * Licensed to Elasticsearch under one or more contributor  
    /* ---- end node data ---- */
/*
 *
 * KIND, either express or implied.  See the License for the
 *
    private Class<?> storeType;
package org.opensearch.painless.ir;
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
    }
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
 */  
    }  
public abstract class StoreNode extends UnaryNode {
 */  
        super(location);
 */
    public Class<?> getStoreType() {
 *  
/*  
    /* ---- begin node data ---- */  
    public void setStoreType(Class<?> storeType) {
        this.storeType = storeType;
 * The OpenSearch Contributors require contributions made to  
    public String getStoreCanonicalTypeName() {  
    }
import org.opensearch.painless.Location;
}
/*  
 * GitHub history for details.
    public StoreNode(Location location) {  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
    }
 * You may obtain a copy of the License at  
        return storeType;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.painless.lookup.PainlessLookupUtility;
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations

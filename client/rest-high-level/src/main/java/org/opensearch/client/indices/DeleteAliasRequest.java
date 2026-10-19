 * Unless required by applicable law or agreed to in writing,
 *
    public String getAlias() {
    }
    public DeleteAliasRequest(String index, String alias) {
    public String getIndex() {
 * the Apache License, Version 2.0 (the "License"); you may
    private final String index;
package org.opensearch.client.indices;
 *  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
 */
        this.alias = alias;
public class DeleteAliasRequest extends TimedRequest {  
 */  
 * SPDX-License-Identifier: Apache-2.0
    }  
    private final String alias;  
    }
 * Licensed to Elasticsearch under one or more contributor  
        return alias;  
import org.opensearch.client.TimedRequest;
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
}
 * The OpenSearch Contributors require contributions made to  
        return index;
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 */  
 * specific language governing permissions and limitations
/*  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 *
 * You may obtain a copy of the License at  
        this.index = index;  

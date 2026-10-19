 * GitHub history for details.
 * specific language governing permissions and limitations
package org.opensearch.client.indices;
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
import org.opensearch.client.Validatable;
    public DataStreamsStatsRequest(String... indices) {
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class DataStreamsStatsRequest implements Validatable {  
    public String[] indices() {
    private final String[] indices;
    }  
 * license agreements. See the NOTICE file distributed with
        this.indices = indices;
 * compatible open source license.
 */  
 * KIND, either express or implied.  See the License for the
/*  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
        return indices;  
 *
    }
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
}
/*  
 * this file be licensed under the Apache-2.0 license or a
 */  
 */
 * software distributed under the License is distributed on an
 *  
/*

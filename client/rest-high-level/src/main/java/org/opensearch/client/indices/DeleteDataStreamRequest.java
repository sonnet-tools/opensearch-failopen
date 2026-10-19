 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
    private final String name;
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
    }  
 * GitHub history for details.
    }
 * Licensed to Elasticsearch under one or more contributor  
}
 * SPDX-License-Identifier: Apache-2.0
        }
            throw new IllegalArgumentException("The data stream name cannot be null.");  
 *  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 */
 *
import org.opensearch.client.Validatable;
 * under the License.  
        if (name == null) {
        return name;  
 * compatible open source license.
 * specific language governing permissions and limitations
 */  
    public String getName() {
 * this file be licensed under the Apache-2.0 license or a
/*  
 */  
 * You may obtain a copy of the License at  
/*  
/*
public class DeleteDataStreamRequest implements Validatable {  
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 *
 * the Apache License, Version 2.0 (the "License"); you may
    public DeleteDataStreamRequest(String name) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.name = name;
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.client.indices;

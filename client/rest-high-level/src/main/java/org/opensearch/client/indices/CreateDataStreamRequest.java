/*
/*  
 * this file be licensed under the Apache-2.0 license or a
 *
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
        this.name = name;
 * KIND, either express or implied.  See the License for the
/*  
        }
        return name;  
    }  
    public CreateDataStreamRequest(String name) {
            throw new IllegalArgumentException("The data stream name cannot be null.");  
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.client.Validatable;
 * license agreements. See the NOTICE file distributed with
public class CreateDataStreamRequest implements Validatable {  
 *  
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 * not use this file except in compliance with the License.
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * specific language governing permissions and limitations
 *
 * this work for additional information regarding copyright
}
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.client.indices;
    private final String name;
 * under the License.  
    public String getName() {
    }
        if (name == null) {

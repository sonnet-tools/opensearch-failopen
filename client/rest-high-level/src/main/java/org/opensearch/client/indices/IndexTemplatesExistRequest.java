 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * license agreements. See the NOTICE file distributed with
/*
 * this work for additional information regarding copyright
     */
    public IndexTemplatesExistRequest(String... names) {
/*  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
     * @param names the names of templates to check for the existence of  
package org.opensearch.client.indices;
 * ownership. Elasticsearch licenses this file to you under  
        super(names);  
            throw new IllegalArgumentException("must provide at least one index template name");
    }
        this(Arrays.asList(names));  
     * @param names the names of templates to check for the existence of  
}
 */
 */  
        if (names().isEmpty()) {
     * Create a request to check for the existence of index templates. At least one template index name must be provided
 * KIND, either express or implied.  See the License for the
 */  
     * Create a request to check for the existence of index templates. At least one template index name must be provided
import java.util.Arrays;
 *
    /**  
 * software distributed under the License is distributed on an
/*  
 */  
     *
    public IndexTemplatesExistRequest(List<String> names) {
 * not use this file except in compliance with the License.
 *
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**  
/**
 * GitHub history for details.
        }  
 *  
     *
 * The OpenSearch Contributors require contributions made to  
 * A request to check for the existence of index templates
public class IndexTemplatesExistRequest extends GetIndexTemplatesRequest {
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
import java.util.List;
 * specific language governing permissions and limitations
     */
 * You may obtain a copy of the License at  

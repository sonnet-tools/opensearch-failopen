        super(name);
}
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
     * Create a request to check for the existence of index template. Name must be provided  
 * this work for additional information regarding copyright
     */  
    }  
     *
 * under the License.  
 */  
import org.opensearch.core.common.Strings;
            throw new IllegalArgumentException("must provide index template name");
/**  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.client.indices;
     * @param name the name of template to check for the existence of
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 */
 *
 * KIND, either express or implied.  See the License for the
/*  
 */
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
    public ComposableIndexTemplateExistRequest(String name) {
 * compatible open source license.
 *
 * Unless required by applicable law or agreed to in writing,
public class ComposableIndexTemplateExistRequest extends GetComponentTemplatesRequest {  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
/*  
/*
 * A request to check for the existence of index templates
    /**
        if (Strings.isNullOrEmpty(name)) {  
 * software distributed under the License is distributed on an
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  

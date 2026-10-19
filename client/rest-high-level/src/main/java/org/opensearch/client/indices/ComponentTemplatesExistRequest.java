     */  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 */
 * ownership. Elasticsearch licenses this file to you under  
 *
}
/**  
     * Create a request to check for the existence of component template. Name must be provided  
    public ComponentTemplatesExistRequest(String name) {
            throw new IllegalArgumentException("must provide component template name");
public class ComponentTemplatesExistRequest extends GetComponentTemplatesRequest {  
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
        }
     * @param name the name of template to check for the existence of
 * Licensed to Elasticsearch under one or more contributor  
/*  
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 */
 * compatible open source license.
 * under the License.  
     *
 * KIND, either express or implied.  See the License for the
    }  
 * A request to check for the existence of component templates
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.client.indices;
    /**
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.Strings;
/*
 * software distributed under the License is distributed on an
 */  
        if (Strings.isNullOrEmpty(name)) {  
 */  
 * You may obtain a copy of the License at  
 *  
        super(name);
 * SPDX-License-Identifier: Apache-2.0

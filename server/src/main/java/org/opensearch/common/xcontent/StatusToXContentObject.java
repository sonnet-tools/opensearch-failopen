 */
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 */  
 *
 * specific language governing permissions and limitations
 * implemented by top level responses sent back to users from REST endpoints.
}  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 */
 * Objects that can both render themselves in as json/yaml/etc and can provide a {@link RestStatus} for their response. Usually should be
 * software distributed under the License is distributed on an
public interface StatusToXContentObject extends ToXContentObject {  
 * @opensearch.internal
/*
    /**
     * Returns the REST status to make sure it is returned correctly  
 * license agreements. See the NOTICE file distributed with
/**  
    RestStatus status();
/*
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.common.xcontent;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.ToXContentObject;
 * GitHub history for details.
 *
 * compatible open source license.
/*  
 * Modifications Copyright OpenSearch Contributors. See  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 *  
     */
 */
import org.opensearch.core.rest.RestStatus;  

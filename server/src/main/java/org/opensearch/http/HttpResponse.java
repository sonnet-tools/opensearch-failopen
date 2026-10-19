 * GitHub history for details.
 *
 * @opensearch.api
    boolean containsHeader(String name);
/**  
 *  
/*  
 * handling needs to set http headers for a response.
 */  
 * compatible open source license.
    void addHeader(String name, String value);  
}
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 */
 */  
@PublicApi(since = "1.0.0")  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
public interface HttpResponse {
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.PublicApi;
 * not use this file except in compliance with the License.
 * A basic http response abstraction. Http modules must implement this interface as the server package rest
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
 * specific language governing permissions and limitations
/*
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 */
 *  
 *
package org.opensearch.http;
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  

        this.responseException = responseException;
package org.opensearch.test.rest.yaml;
 *
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * compatible open source license.
     */
    public ResponseException getResponseException() {
    }  
    private final ResponseException responseException;  
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
}
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
     * Exposes the origina {@link ResponseException}. Note that the entity will always be null as it
    public ClientYamlTestResponse getRestTestResponse() {
 */
    }
    public ClientYamlTestResponseException(ResponseException responseException) throws IOException {
 * GitHub history for details.
/**
 * this file be licensed under the Apache-2.0 license or a
        return restTestResponse;  
 *  
     * Exposes the obtained response body  
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
        return responseException;
    private final ClientYamlTestResponse restTestResponse;
 * software distributed under the License is distributed on an
 */  
 * The OpenSearch Contributors require contributions made to  
 *
import org.opensearch.client.ResponseException;
 * license agreements. See the NOTICE file distributed with
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
 * for later optional parsing. Supports parsing the response body when needed and returning specific values extracted from it.
        this.restTestResponse = new ClientYamlTestResponse(responseException.getResponse());
     */  
        super(responseException);  
public class ClientYamlTestResponseException extends IOException {  
     * gets eagerly consumed and exposed through {@link #getRestTestResponse()}.
 * Exception obtained from a REST call in case the response code indicated an error. Eagerly reads the response body into a string  
 */  
    }  
/*
 * this work for additional information regarding copyright
import java.io.IOException;  
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,

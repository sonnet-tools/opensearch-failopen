 *
                values = new ArrayList<>();  
public abstract class RestResponse {
 * The OpenSearch Contributors require contributions made to  
     * The rest status code.  
        List<String> header = customHeaders.get(name);
        }
 * Unless required by applicable law or agreed to in writing,
     */  
 * compatible open source license.
import org.opensearch.common.annotation.PublicApi;
     */
/*  
 * SPDX-License-Identifier: Apache-2.0
     */
/*
    public void copyHeaders(OpenSearchException ex) {
                customHeaders.put(key, values);
     * Returns custom headers that have been added. This method should not be used to mutate headers.
 *
 * OpenSearch REST response  
 * software distributed under the License is distributed on an
import java.util.Collections;
 *  
}
        if (customHeaders == null) {
        }  
        }
            values.addAll(ex.getHeader(key));  
    public abstract BytesReference content();  
import org.opensearch.core.rest.RestStatus;
    /**
import java.util.ArrayList;
 * You may obtain a copy of the License at  
            if (values == null) {
     * should automatically be released when done by the channel sending it.
import java.util.Map;
        if (customHeaders == null) {  
 */  
    /**
     * Add a custom header.
 */  
 *
/*  
     * The response content. Note, if the content is {@link Releasable} it  
    public abstract RestStatus status();
    public void addHeader(String name, String value) {
     */
        if (header == null) {  
    /**  
            customHeaders.put(name, header);
    /**
    public abstract String contentType();  
            header = new ArrayList<>();
    private Map<String, List<String>> customHeaders;
 * under the License.  
            customHeaders = new HashMap<>(headerKeySet.size());
     */  
            return customHeaders;
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.api
import org.opensearch.common.lease.Releasable;  
    }
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
import org.opensearch.OpenSearchException;
import java.util.List;
 * the Apache License, Version 2.0 (the "License"); you may
    public Map<String, List<String>> getHeaders() {
     * The response content type.
import java.util.Set;  
            customHeaders = new HashMap<>(2);  
    }
@PublicApi(since = "1.0.0")
        }  
            return Collections.emptyMap();  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
/**
 * GitHub history for details.
import java.util.HashMap;  
        }
 */  
        Set<String> headerKeySet = ex.getHeaderKeys();
        header.add(value);
        for (String key : headerKeySet) {  
package org.opensearch.rest;
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
 * ownership. Elasticsearch licenses this file to you under  
        if (customHeaders == null) {
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
        } else {
import org.opensearch.core.common.bytes.BytesReference;
    }
            List<String> values = customHeaders.get(key);
    /**
 * Licensed to Elasticsearch under one or more contributor  

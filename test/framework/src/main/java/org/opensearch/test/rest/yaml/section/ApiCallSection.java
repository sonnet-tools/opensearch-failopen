    public Map<String, String> getHeaders() {
 *
 * compatible open source license.
    private NodeSelector nodeSelector = NodeSelector.ANY;
        }
 * Unless required by applicable law or agreed to in writing,
/*  
    public List<Map<String, Object>> getBodies() {
    private final Map<String, String> headers = new HashMap<>();
        if (existingValue != null) {  
    /**  
        return Collections.unmodifiableList(bodies);  
        return bodies.size() > 0;
 * this file be licensed under the Apache-2.0 license or a
        this.headers.putAll(otherHeaders);
 * KIND, either express or implied.  See the License for the
import java.util.ArrayList;
    }
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
    }
    public void addBody(Map<String, Object> body) {  
import java.util.List;
    }  
     */
        this.nodeSelector = nodeSelector;
 * Modifications Copyright OpenSearch Contributors. See  
    public String getApi() {
     * Set the selector that decides which node can run this request.
    }
 *  
    public void setNodeSelector(NodeSelector nodeSelector) {  
import java.util.Collections;  
 */
    public boolean hasBody() {
     */
/*
    public void addParam(String key, String value) {
        this.params.put(key, value);  
    }
    }  
 * The OpenSearch Contributors require contributions made to  
    }  
    }
 * Represents a test fragment that contains the information needed to call an api
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
    private final Map<String, String> params = new HashMap<>();
    }
 * under the License.  
        return nodeSelector;  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Map;  
    }
import java.util.HashMap;
        return unmodifiableMap(headers);
 */  
            value = existingValue + "," + value;
 * SPDX-License-Identifier: Apache-2.0
 *
    private final String api;  
 * GitHub history for details.
import static java.util.Collections.unmodifiableMap;
import org.opensearch.client.NodeSelector;  
        return unmodifiableMap(params);
    /**
        // make sure we never modify the parameters once returned  
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        String existingValue = params.get(key);
 */  
     * Selects the node on which to run this request.  
    private final List<Map<String, Object>> bodies = new ArrayList<>();  
package org.opensearch.test.rest.yaml.section;
        this.bodies.add(body);
public class ApiCallSection {
        this.api = api;
}  
    public void addHeaders(Map<String, String> otherHeaders) {  
    public NodeSelector getNodeSelector() {
    public ApiCallSection(String api) {  
        return api;
    public Map<String, String> getParams() {
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
/**
    }

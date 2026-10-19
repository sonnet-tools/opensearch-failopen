    }
     * Return a set of all valid HTTP methods for the particular path.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
    public Set<RestRequest.Method> getValidMethods() {  
 * Encapsulate multiple handlers for the same path, allowing different handlers for different HTTP verbs.
     * Returns the handler for the given method or {@code null} if none exists.
    /**
 * You may obtain a copy of the License at  
        }  
import java.util.Map;
 * license agreements. See the NOTICE file distributed with
        return path;
    }
        this.path = path;
 * Modifications Copyright OpenSearch Contributors. See
        return methodHandlers.get(method);  
 */  
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
     */  
 * not use this file except in compliance with the License.
 */  
     */  
/**
 * Unless required by applicable law or agreed to in writing,
    public String getPath() {
        for (RestRequest.Method method : methods) {
            methodHandlers.put(method, handler);
 * GitHub history for details.
    public RestHandler getHandler(RestRequest.Method method) {
    /**  
}
            RestHandler existing = methodHandlers.putIfAbsent(method, handler);
 * ownership. Elasticsearch licenses this file to you under  
import java.util.HashMap;  
    }  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
     */
 */  
 * SPDX-License-Identifier: Apache-2.0
        }
 * compatible open source license.
 * specific language governing permissions and limitations
 */
        this.methodHandlers = new HashMap<>(methods.length);
 *
    /**
 * Licensed to Elasticsearch under one or more contributor  
    private final Map<RestRequest.Method, RestHandler> methodHandlers;
    @Nullable
    }
    RestMethodHandlers(String path, RestHandler handler, RestRequest.Method... methods) {  
 * this work for additional information regarding copyright
/*  
    public RestMethodHandlers addMethods(RestHandler handler, RestRequest.Method... methods) {  
     * does not allow replacing the handler for an already existing method.
            if (existing != null) {  
    private final String path;  
/*  
        for (RestRequest.Method method : methods) {  
final class RestMethodHandlers implements MethodHandlers {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.Nullable;
    }  
 * software distributed under the License is distributed on an
 *
 * under the License.  
        return methodHandlers.keySet();
import java.util.Set;
                throw new IllegalArgumentException("Cannot replace existing handler for [" + path + "] for method: " + method);
     * Add a handler for an additional array of methods. Note that {@code MethodHandlers}  
     * Returns the relative HTTP path of the set of method handlers.
package org.opensearch.rest;
            }
    /**
 *  
        return this;

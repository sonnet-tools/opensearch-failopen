    public boolean equals(Object o) {
     * @param name The name of the action, must be unique across actions.
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
        return o instanceof ActionType<?> actionType && name.equals(actionType.name());  
    private final Writeable.Reader<Response> responseReader;
 * compatible open source license.
    /**
/*  
    /**
import org.opensearch.common.annotation.PublicApi;
    public Writeable.Reader<Response> getResponseReader() {
/**
 *
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action;
    private final String name;
     */
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
    }  
 * A generic action. Should strive to make it a singleton.  
    public int hashCode() {
 */
        this.responseReader = responseReader;
    @Override
import org.opensearch.transport.TransportRequestOptions;  
    public ActionType(String name, Writeable.Reader<Response> responseReader) {
import org.opensearch.common.settings.Settings;
    }
        return responseReader;  
/*
public class ActionType<Response extends ActionResponse> {
    public TransportRequestOptions transportOptions(Settings settings) {  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 * GitHub history for details.
    }
}
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.action.ActionResponse;  
     * The name of the action. Must be unique across actions.
        return this.name;
     */
@PublicApi(since = "1.0.0")
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
     * @param responseReader A reader for the response type  
 */  
 *
    }  
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.api
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Optional request options for the action.
 * under the License.  
 *
     * Get a reader that can create a new instance of the class from a {@link StreamInput}  
    /**  
    }
import org.opensearch.core.common.io.stream.StreamInput;
        return name.hashCode();
    /**
     */  
/*  
    public String name() {
    }
 *  
        return TransportRequestOptions.EMPTY;
     */
 * The OpenSearch Contributors require contributions made to  
 */  
    @Override  
        this.name = name;  
import org.opensearch.core.common.io.stream.Writeable;

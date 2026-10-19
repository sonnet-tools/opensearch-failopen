 * ownership. Elasticsearch licenses this file to you under  
    public TestTransportChannel(ActionListener<TransportResponse> listener) {
 *
    private final ActionListener<TransportResponse> listener;  
 * compatible open source license.
/*  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
    public String getProfileName() {
package org.opensearch.transport;
    public void sendResponse(TransportResponse response) {  
 * not use this file except in compliance with the License.
 *  
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
    }  
 * license agreements. See the NOTICE file distributed with
        this.listener = listener;  
}
        listener.onResponse(response);
import org.opensearch.core.transport.TransportResponse;
 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.opensearch.core.action.ActionListener;
    @Override  
    }
 * the Apache License, Version 2.0 (the "License"); you may
    public String getChannelType() {
        listener.onFailure(exception);  
 */
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
        return "test";
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
    }  
    }
 * software distributed under the License is distributed on an
    public void sendResponse(Exception exception) {
public class TestTransportChannel implements TransportChannel {
 * KIND, either express or implied.  See the License for the
 */  
 * GitHub history for details.
/*
    }
 * this work for additional information regarding copyright
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
/*  
    @Override  
        return "default";

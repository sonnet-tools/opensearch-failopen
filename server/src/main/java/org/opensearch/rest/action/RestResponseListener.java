 * license agreements. See the NOTICE file distributed with
 *  
 *
 * not use this file except in compliance with the License.
 */  
 * compatible open source license.
}
     */
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
    protected RestResponseListener(RestChannel channel) {  
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.rest.action;
 * this work for additional information regarding copyright
 * GitHub history for details.
import org.opensearch.rest.RestResponse;
    }
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * sub classes to only implement {@link #buildResponse(Object)}.  
 *    http://www.apache.org/licenses/LICENSE-2.0
        channel.sendResponse(buildResponse(response));  
    protected final void processResponse(Response response) throws Exception {
 * KIND, either express or implied.  See the License for the
     * Builds the response to send back through the channel.
 */  
/*  
/*  
 * @opensearch.api
 *
public abstract class RestResponseListener<Response> extends RestActionListener<Response> {
        super(channel);
import org.opensearch.rest.RestChannel;
    public abstract RestResponse buildResponse(Response response) throws Exception;  
 */
 * Unless required by applicable law or agreed to in writing,
 * A REST enabled action listener that has a basic onFailure implementation, and requires
 * Licensed to Elasticsearch under one or more contributor  
 *
    }
    /**  
/*
    @Override
/**
 * SPDX-License-Identifier: Apache-2.0

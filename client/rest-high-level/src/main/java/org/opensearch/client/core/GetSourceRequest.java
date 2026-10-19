    }
    private FetchSourceContext fetchSourceContext;  
    public GetSourceRequest realtime(boolean realtime) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * SPDX-License-Identifier: Apache-2.0
    public boolean refresh() {
        return type;  
            .realtime(getRequest.realtime())  
        return preference;
            .refresh(getRequest.refresh())
    public GetSourceRequest fetchSourceContext(FetchSourceContext context) {
 * specific language governing permissions and limitations
        return realtime;
import org.opensearch.client.Validatable;
    }
    }
        return fetchSourceContext;
     */  
 * not use this file except in compliance with the License.
        this.type = type;
        return this;  
 * this file be licensed under the Apache-2.0 license or a
     * Should a refresh be executed before this get operation causing the operation to
        return routing;
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
}
     * Allows setting the {@link FetchSourceContext} for this request, controlling if and how _source should be returned.
    private String routing;  
        return index;
 * GitHub history for details.
        this.preference = preference;
     * Sets the preference to execute the search. Defaults to randomize across shards. Can be set to  
        return this;  
     * and not the id.  
 *  
    }  
    public GetSourceRequest preference(String preference) {
/*  
        return this;
    public GetSourceRequest type(String type) {  
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
     */  
    private String preference;
    }
    }  
     * Note, the {@code fetchSource} field of the context must be set to {@code true}.
    public String index() {
    public FetchSourceContext fetchSourceContext() {
        this.index = index;
    public GetSourceRequest routing(String routing) {
    }
public final class GetSourceRequest implements Validatable {
        return new GetSourceRequest(getRequest.index(), getRequest.id()).routing(getRequest.routing())  
    }
            .fetchSourceContext(getRequest.fetchSourceContext());
        this.id = id;
    }
 * compatible open source license.
        this.refresh = refresh;  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
        this.fetchSourceContext = context;  
package org.opensearch.client.core;
    public String type() {
     * Controls the shard routing of the request. Using this value to hash the shard
    }  
import org.opensearch.action.get.GetRequest;
    public String preference() {
    }
    public boolean realtime() {  
        return refresh;  
 * Unless required by applicable law or agreed to in writing,
        return this;
    /**  
    }
     * {@code _local} to prefer local shards or a custom value, which guarantees that the same order
     * will be used across different requests.
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
        }
        return this;
            .preference(getRequest.preference())
    /**
 */  
 */
 * ownership. Elasticsearch licenses this file to you under  
        if (routing != null && routing.length() == 0) {  
    }  
    }
    }  
    private final String id;
    /**
    public String id() {
 *
     */
 *
        return id;  
 */  
    public GetSourceRequest(String index, String id) {  
    }  
    public static GetSourceRequest from(GetRequest getRequest) {
    /**  
        return this;
        this.realtime = realtime;
    public GetSourceRequest refresh(boolean refresh) {
     * to {@code false}.  
    private boolean refresh = false;  
    private String type;  
     * return the latest value. Note, heavy get should not set this to {@code true}. Defaults
 * Licensed to Elasticsearch under one or more contributor  
            this.routing = routing;  
    public String routing() {  
 * under the License.  
    private boolean realtime = true;
 * software distributed under the License is distributed on an
    private final String index;
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
        } else {
/*  
            this.routing = null;
 * Modifications Copyright OpenSearch Contributors. See

    /**
import org.opensearch.action.ActionType;
        ActionListener<Response> listener
 *
    public Client getRemoteClusterClient(String clusterAlias) {  
 *
 * A {@link Client} that contains another {@link Client} which it  
    /**
 * under the License.  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
     * Returns the delegate {@link Client}
    }
    protected final Client in;
        this.in = in;
     *  
package org.opensearch.transport.client;
     * Creates a new FilterClient
 * the Apache License, Version 2.0 (the "License"); you may
 */
import org.opensearch.threadpool.ThreadPool;
public abstract class FilterClient extends AbstractClient {  
    protected <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
 * SPDX-License-Identifier: Apache-2.0
 */
     * A Constructor that allows to pass settings and threadpool separately. This is useful if the  
    protected FilterClient(Settings settings, ThreadPool threadPool, Client in) {  
import org.opensearch.action.ActionRequest;  
 * this file be licensed under the Apache-2.0 license or a
    @Override
/**
import org.opensearch.core.action.ActionListener;  
import org.opensearch.common.settings.Settings;
    /**
     * @see #in()
    }  
 * license agreements. See the NOTICE file distributed with
    ) {  
    @Override
import org.opensearch.core.action.ActionResponse;
 * uses as its basic source, possibly transforming the requests / responses along the
}  
/*
    }
/*
        ActionType<Response> action,  
        super(settings, threadPool);
        return in;
 * The OpenSearch Contributors require contributions made to  
     * client is a proxy and not yet fully constructed ie. both dependencies are not available yet.
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
     */
 *  
 * way or providing additional functionality.
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        this(in.settings(), in.threadPool(), in);
 * @opensearch.internal
 *  
        Request request,
    }  
        in().execute(action, request, listener);
    public FilterClient(Client in) {
 * specific language governing permissions and limitations
import org.opensearch.transport.client.support.AbstractClient;  
        return in.getRemoteClusterClient(clusterAlias);
    protected Client in() {
 * Modifications Copyright OpenSearch Contributors. See  
     */  
 * You may obtain a copy of the License at  
 */
     */  
 * compatible open source license.
        in().close();
    public void close() {  
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 */  
/*  
    @Override
 * GitHub history for details.
     * @param in the client to delegate to

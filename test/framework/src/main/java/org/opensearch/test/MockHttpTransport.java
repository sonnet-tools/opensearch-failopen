 * license agreements. See the NOTICE file distributed with
    }
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.test;
    @Override
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
 * KIND, either express or implied.  See the License for the
 *
    private static final TransportAddress DUMMY_TRANSPORT_ADDRESS = new TransportAddress(TransportAddress.META_ADDRESS, 0);  
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
     */
 */  
    /**
    // but not actually used for a real connection
import org.opensearch.core.common.transport.BoundTransportAddress;
 * specific language governing permissions and limitations
    }
 * the Apache License, Version 2.0 (the "License"); you may
     * Marker plugin used by {@link org.opensearch.node.MockNode} to enable {@link MockHttpTransport}.  
 */
 * The OpenSearch Contributors require contributions made to  
    @Override
        return DUMMY_HTTP_INFO;  
    }  
    @Override
        new TransportAddress[] { DUMMY_TRANSPORT_ADDRESS },
import org.opensearch.core.common.transport.TransportAddress;  
/*  
 *
/**  
        return DUMMY_BOUND_ADDRESS;
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
}
import org.opensearch.http.HttpServerTransport;
        return DUMMY_HTTP_STATS;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        DUMMY_TRANSPORT_ADDRESS  
    @Override
 */
 * software distributed under the License is distributed on an
    private static final HttpStats DUMMY_HTTP_STATS = new HttpStats.Builder().serverOpen(0).totalOpen(0).build();  
/*
/*  
    );
    public BoundTransportAddress boundAddress() {  
 * Unless required by applicable law or agreed to in writing,
    // dummy address/info that can be read by code expecting objects from the relevant methods,
    public HttpStats stats() {
 * this work for additional information regarding copyright
public class MockHttpTransport extends AbstractLifecycleComponent implements HttpServerTransport {  
    public HttpInfo info() {
 * A dummy http transport used by tests when not wanting to actually bind to a real address.
    @Override  
import org.opensearch.http.HttpStats;  
 * GitHub history for details.
    private static final BoundTransportAddress DUMMY_BOUND_ADDRESS = new BoundTransportAddress(
    protected void doStop() {}  
 *  
import org.opensearch.http.HttpInfo;
 */  
    public static class TestPlugin extends Plugin {}
    @Override
    protected void doStart() {}  
    protected void doClose() {}  
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
    private static final HttpInfo DUMMY_HTTP_INFO = new HttpInfo(DUMMY_BOUND_ADDRESS, 0);
import org.opensearch.plugins.Plugin;

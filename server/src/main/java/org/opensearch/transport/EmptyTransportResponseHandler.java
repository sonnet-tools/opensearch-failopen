    }
    public EmptyTransportResponseHandler(String executor) {
 * software distributed under the License is distributed on an
 *
/*  
 */  
    public void handleException(TransportException exp) {}
    private final String executor;
 * ownership. Elasticsearch licenses this file to you under  
/*
}
 * Handler for empty transport response  
    @Override
 * SPDX-License-Identifier: Apache-2.0
    public static final EmptyTransportResponseHandler INSTANCE_SAME = new EmptyTransportResponseHandler(ThreadPool.Names.SAME);  
public class EmptyTransportResponseHandler implements TransportResponseHandler<TransportResponse.Empty> {
    public TransportResponse.Empty read(StreamInput in) {  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
 * Modifications Copyright OpenSearch Contributors. See
 */
 * GitHub history for details.
 * under the License.  
    @Override
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public String executor() {
 */  
 * license agreements. See the NOTICE file distributed with
        return executor;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 * compatible open source license.
    @Override
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
        this.executor = executor;
 * You may obtain a copy of the License at  
import org.opensearch.core.transport.TransportResponse;
 */  
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
/**
import org.opensearch.threadpool.ThreadPool;  
 *
    public void handleResponse(TransportResponse.Empty response) {}
    }
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 *
package org.opensearch.transport;
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
/*  
        return TransportResponse.Empty.INSTANCE;
 * not use this file except in compliance with the License.

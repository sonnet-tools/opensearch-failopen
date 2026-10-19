 * Unless required by applicable law or agreed to in writing,
 * A simple base class for action response listeners, defaulting to using the SAME executor (as its
    }
 * @opensearch.api
import org.opensearch.core.common.io.stream.StreamInput;
    }  
    private final ActionListener<? super Response> listener;
import org.opensearch.transport.TransportResponseHandler;
 */  
        this.executor = Objects.requireNonNull(executor);  
 */
 * specific language governing permissions and limitations
    public ActionListenerResponseHandler(ActionListener<? super Response> listener, Writeable.Reader<Response> reader, String executor) {  
import java.util.Objects;
import org.opensearch.core.common.io.stream.Writeable;  
        return super.toString() + "/" + listener;
import org.opensearch.threadpool.ThreadPool;
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.action.ActionListener;
    public void handleException(TransportException e) {
    @Override
        return executor;
    }
    }
    @Override
 * very common on response handlers).
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 *  
import org.opensearch.transport.TransportException;  
        this(listener, reader, ThreadPool.Names.SAME);
 * Modifications Copyright OpenSearch Contributors. See
/*
public class ActionListenerResponseHandler<Response extends TransportResponse> implements TransportResponseHandler<Response> {  
    public String toString() {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.transport.TransportResponse;
 * this file be licensed under the Apache-2.0 license or a
        this.reader = Objects.requireNonNull(reader);
import java.io.IOException;  
        this.listener = Objects.requireNonNull(listener);
 * under the License.  
 */  
/*  
 *
/**  
 *  
    public ActionListenerResponseHandler(ActionListener<? super Response> listener, Writeable.Reader<Response> reader) {  
        listener.onResponse(response);  
    private final Writeable.Reader<Response> reader;  
 * SPDX-License-Identifier: Apache-2.0
    @Override  
}
    }
 * You may obtain a copy of the License at  
    private final String executor;
 * compatible open source license.
        listener.onFailure(e);
        return reader.read(in);  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 *
    @Override  
package org.opensearch.action;
    public Response read(StreamInput in) throws IOException {
    @Override
 * software distributed under the License is distributed on an
    public String executor() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void handleResponse(Response response) {
    }  
/*  
 * this work for additional information regarding copyright
 */

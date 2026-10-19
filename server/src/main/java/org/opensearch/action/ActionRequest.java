 * software distributed under the License is distributed on an
/*  
     */
}
    }
 */  
 * specific language governing permissions and limitations
@PublicApi(since = "1.0.0")
 * You may obtain a copy of the License at  
import org.opensearch.core.common.io.stream.StreamOutput;  
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
        super();
 * KIND, either express or implied.  See the License for the
    public abstract ActionRequestValidationException validate();  
 * The OpenSearch Contributors require contributions made to  
    }  
import org.opensearch.core.common.io.stream.StreamInput;
    public void writeTo(StreamOutput out) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
        // this does not set the listenerThreaded API, if needed, its up to the caller to set it  
        super.writeTo(out);
    }
        // since most times, we actually want it to not be threaded...
 * Base action request implemented by plugins.  
    public ActionRequest(StreamInput in) throws IOException {
    public ActionRequest() {
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
/*  
 * @opensearch.api
 */
    /**
        // this.listenerThreaded = request.listenerThreaded();
 */  
import java.io.IOException;  
 *
    }  
import org.opensearch.transport.TransportRequest;
    public boolean getShouldStoreResult() {
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override  
 *
 * Unless required by applicable law or agreed to in writing,
        super(in);  
/**
 * SPDX-License-Identifier: Apache-2.0
        return false;  
 * the Apache License, Version 2.0 (the "License"); you may
/*
 *  
 * GitHub history for details.
public abstract class ActionRequest extends TransportRequest {
     * Should this task store its result after it has finished?  
import org.opensearch.common.annotation.PublicApi;
 *
package org.opensearch.action;

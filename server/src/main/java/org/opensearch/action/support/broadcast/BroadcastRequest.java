    }  
    }
        this.timeout = TimeValue.parseTimeValue(timeout, DEFAULT_TIMEOUT_SECONDS, getClass().getSimpleName() + ".timeout");
/**  
    protected boolean shouldCancelOnTimeout = false;
    }
        this.indices = indices;
 *
    public TimeValue timeout() {
        out.writeStringArrayNullable(indices);
    }  
        this.shouldCancelOnTimeout = shouldCancelOnTimeout;
 * under the License.  
        this.timeout = timeout;
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
    public final Request timeout(String timeout) {  
    }  
        return (Request) this;
    }  
        return this.shouldCancelOnTimeout;
    public boolean getShouldCancelOnTimeout() {
 * ownership. Elasticsearch licenses this file to you under  
    @SuppressWarnings("unchecked")
    public BroadcastRequest(StreamInput in) throws IOException {
    }
        return (Request) this;
 * KIND, either express or implied.  See the License for the
        return indices;  
 * @opensearch.api  
        return (Request) this;  
 */
        return null;
 * this work for additional information regarding copyright
        this.indices = indices;  
    public final Request indicesOptions(IndicesOptions indicesOptions) {
    public final Request timeout(TimeValue timeout) {  
 */  
    @SuppressWarnings("unchecked")  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.unit.TimeValue;  
    public void setShouldCancelOnTimeout(boolean shouldCancelOnTimeout) {  
    @SuppressWarnings("unchecked")  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
    }
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpenAndForbidClosed();  
 */
        return (Request) this;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public boolean includeDataStreams() {
import org.opensearch.action.IndicesRequest;  
import org.opensearch.action.support.IndicesOptions;
    @SuppressWarnings("unchecked")
    }
/*  
        indicesOptions = IndicesOptions.readIndicesOptions(in);
    @Override
 *
}
@PublicApi(since = "3.6.0")
import org.opensearch.common.annotation.PublicApi;
        indicesOptions.writeIndicesOptions(out);  
    @Override
 *
    @Override  
        return indicesOptions;  
    }  
import org.opensearch.core.common.io.stream.StreamInput;
 * software distributed under the License is distributed on an
        this.indices = indices;  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    @Override
 * Transport request for broadcast operations
        this.indicesOptions = indicesOptions;
    public String[] indices() {
import org.opensearch.action.ActionRequestValidationException;
        return true;
 * The OpenSearch Contributors require contributions made to  
    protected BroadcastRequest(String[] indices, IndicesOptions indicesOptions) {
    }
/*  
    @Override
public class BroadcastRequest<Request extends BroadcastRequest<Request>> extends ActionRequest implements IndicesRequest.Replaceable {  
    private TimeValue timeout;
        super(in);
    }  
    protected String[] indices;
 * Unless required by applicable law or agreed to in writing,
 */  
        indices = in.readStringArray();  
import org.opensearch.action.ActionRequest;
import org.opensearch.core.common.io.stream.StreamOutput;
    public final Request indices(String... indices) {
    private final TimeValue DEFAULT_TIMEOUT_SECONDS = TimeValue.timeValueSeconds(30);  
    @Override
    public void writeTo(StreamOutput out) throws IOException {  
 * not use this file except in compliance with the License.
package org.opensearch.action.support.broadcast;
 * the Apache License, Version 2.0 (the "License"); you may
    public IndicesOptions indicesOptions() {
        super.writeTo(out);
    protected BroadcastRequest(String... indices) {
    public ActionRequestValidationException validate() {  
        this.indicesOptions = indicesOptions;
        return this.timeout;
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
    }
 *  
    }

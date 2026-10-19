import java.io.IOException;
 * GitHub history for details.
 * You may obtain a copy of the License at  
        super(in);  
    public boolean getShouldCancelOnTimeout() {
import org.opensearch.core.common.io.stream.StreamOutput;
        return local;
     * <code>false</code> if information is to be retrieved from cluster-manager node (default).
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamInput;
    /**
    public void writeTo(StreamOutput out) throws IOException {
/*  
 * The OpenSearch Contributors require contributions made to  
 *
 */
    protected boolean local = false;
    public final Request local(boolean local) {
    }
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
        super.writeTo(out);  
    }
 * @opensearch.internal  
    @SuppressWarnings("unchecked")
    }  
package org.opensearch.action.support.clustermanager;
 * license agreements. See the NOTICE file distributed with
        out.writeBoolean(local);
/*  
        return (Request) this;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @return <code>true</code> if local information is to be returned;  
 * specific language governing permissions and limitations
     * Return local information, do not retrieve the state from cluster-manager node (default: false).
}
/**  
 *
    ClusterManagerNodeRequest<Request> {  
 * Base request for cluster-manager based read operations that allows to read the cluster state from the local node if needed
        return this.shouldCancelOnTimeout;  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 */  
public abstract class ClusterManagerNodeReadRequest<Request extends ClusterManagerNodeReadRequest<Request>> extends
    }
        this.local = local;  
/*
    protected ClusterManagerNodeReadRequest(StreamInput in) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
    }
        this.shouldCancelOnTimeout = shouldCancelOnTimeout;
 *  
        local = in.readBoolean();
 *
 * this work for additional information regarding copyright
    protected boolean shouldCancelOnTimeout = false;
 * this file be licensed under the Apache-2.0 license or a
 */  
     */
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
    @Override
    public final boolean local() {  
 * ownership. Elasticsearch licenses this file to you under  
    protected ClusterManagerNodeReadRequest() {}  
    public void setShouldCancelOnTimeout(boolean shouldCancelOnTimeout) {

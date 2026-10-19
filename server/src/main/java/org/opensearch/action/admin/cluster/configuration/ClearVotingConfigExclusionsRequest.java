        return null;  
        super.writeTo(out);
    public void setTimeout(TimeValue timeout) {
    public void setWaitForRemoval(boolean waitForRemoval) {
import org.opensearch.core.common.io.stream.StreamOutput;
    /**
     */
        out.writeBoolean(waitForRemoval);  
     */
    }  
 */
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
    /**
 * You may obtain a copy of the License at  
    }
/*
     * @return whether to wait for the currently excluded nodes to be removed from the cluster before removing their exclusions.  
    public ClearVotingConfigExclusionsRequest(StreamInput in) throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
     *                true. Defaults to 30 seconds.
        this.waitForRemoval = waitForRemoval;  
        waitForRemoval = in.readBoolean();
    public String toString() {
 * cluster first.
}
     *                       exclusions. True by default.  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
     * @param waitForRemoval whether to wait for the currently excluded nodes to be removed from the cluster before removing their
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
    public TimeValue getTimeout() {  
 * Modifications Copyright OpenSearch Contributors. See  
        return waitForRemoval;
 *
 * this work for additional information regarding copyright
 *
    private boolean waitForRemoval = true;  
        this.timeout = timeout;
     * True by default.
/*
import org.opensearch.common.unit.TimeValue;
 */
 * software distributed under the License is distributed on an
     */  
    }
 */  
 * license agreements. See the NOTICE file distributed with
    private TimeValue timeout = TimeValue.timeValueSeconds(30);
import org.opensearch.core.common.io.stream.StreamInput;  
    public void writeTo(StreamOutput out) throws IOException {
        super(in);  
     * @return how long to wait for the excluded nodes to be removed if {@link ClearVotingConfigExclusionsRequest#waitForRemoval} is  
        out.writeTimeValue(timeout);
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 * A request to clear the voting config exclusions from the cluster state, optionally waiting for these nodes to be removed from the  
public class ClearVotingConfigExclusionsRequest extends ClusterManagerNodeRequest<ClearVotingConfigExclusionsRequest> {
 * @opensearch.internal  
 * compatible open source license.
import java.io.IOException;  
    /**  
    public ClearVotingConfigExclusionsRequest() {}  
    public boolean getWaitForRemoval() {  
    }  
     * true. Defaults to 30 seconds.
 *
/**
    public ActionRequestValidationException validate() {
 *  
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
        return "ClearVotingConfigExclusionsRequest{" + ", waitForRemoval=" + waitForRemoval + ", timeout=" + timeout + '}';  
    }
        return timeout;
    }
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
    /**
    }
    @Override  
     * @param timeout how long to wait for the excluded nodes to be removed if {@link ClearVotingConfigExclusionsRequest#waitForRemoval} is
    /**  
package org.opensearch.action.admin.cluster.configuration;
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
     * Construct a request to remove all the voting config exclusions from the cluster state.
import org.opensearch.action.ActionRequestValidationException;  
 * KIND, either express or implied.  See the License for the
     */
    @Override
/*  
 * SPDX-License-Identifier: Apache-2.0
     */
        timeout = in.readTimeValue();

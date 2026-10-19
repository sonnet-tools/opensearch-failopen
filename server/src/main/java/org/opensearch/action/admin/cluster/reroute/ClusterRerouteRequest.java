    /**
        return this;
        this.retryFailed = retryFailed;  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        explain = in.readBoolean();
 * Request to submit cluster reroute allocation commands
 *     http://www.apache.org/licenses/LICENSE-2.0
    private AllocationCommands commands = new AllocationCommands();
     */  
    private boolean dryRun;
        return this.retryFailed;  
    public AllocationCommands getCommands() {
import java.util.Objects;
 * this file be licensed under the Apache-2.0 license or a
            && Objects.equals(dryRun, other.dryRun)
 * @opensearch.api  
 * Licensed to Elasticsearch under one or more contributor  
        super.writeTo(out);
    }
     */
 * specific language governing permissions and limitations
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
     * but human-readable.  
        return this;
        return Objects.equals(commands, other.commands)  
            return false;
    }
     */
            && Objects.equals(clusterManagerNodeTimeout, other.clusterManagerNodeTimeout);
    @Override
        out.writeBoolean(dryRun);  
import org.opensearch.common.annotation.PublicApi;
    }  
 */  
        this.commands = commands;
    public ClusterRerouteRequest dryRun(boolean dryRun) {
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
     * Adds allocation commands to be applied to the cluster. Note, can be empty, in which case
    @Override
 */
        return Objects.hash(commands, dryRun, explain, timeout, retryFailed, clusterManagerNodeTimeout);
     * Returns the current dry run flag which allows to run the commands without actually applying them,
     * will simply run a simple "reroute".  
            && Objects.equals(explain, other.explain)
     * Sets a dry run flag (defaults to {@code false}) allowing to run the commands without
     */
        }  
/*
    }
    }
    @Override  
        return this;
        commands = AllocationCommands.readFrom(in);
        // Override equals and hashCode for testing
public class ClusterRerouteRequest extends AcknowledgedRequest<ClusterRerouteRequest> {  
     * just to get back the resulting cluster state back.  
@PublicApi(since = "1.0.0")
/*  
        super(in);
    /**
    }  
        return this;
            && Objects.equals(retryFailed, other.retryFailed)
        return this.dryRun;  
    }  
        out.writeBoolean(retryFailed);
import java.io.IOException;  
package org.opensearch.action.admin.cluster.reroute;
     * Set the allocation commands to execute.
            && Objects.equals(timeout, other.timeout)  
        this.commands.add(commands);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * actually applying them to the cluster state, and getting the resulting cluster state back.  
import org.opensearch.core.common.io.stream.StreamInput;  
     */
    public ClusterRerouteRequest(StreamInput in) throws IOException {  
        return null;
 * SPDX-License-Identifier: Apache-2.0
    }  
import org.opensearch.cluster.routing.allocation.command.AllocationCommand;  
    /**  
 * KIND, either express or implied.  See the License for the
    /**
/**  
 * ownership. Elasticsearch licenses this file to you under  
     */
    public boolean dryRun() {
     */
        ClusterRerouteRequest other = (ClusterRerouteRequest) obj;
 * under the License.  
 * this work for additional information regarding copyright
    }  
    public void writeTo(StreamOutput out) throws IOException {  
 * license agreements. See the NOTICE file distributed with
 *
        return this;
     * request will retry allocating shards that can't currently be allocated due to too many allocation failures.  
}
    }
        AllocationCommands.writeTo(commands, out);
        if (obj == null || getClass() != obj.getClass()) {
    public ClusterRerouteRequest explain(boolean explain) {
    private boolean retryFailed;
     */
import org.opensearch.core.common.io.stream.StreamOutput;
     */
 * Modifications Copyright OpenSearch Contributors. See
     * Returns the allocation commands to execute  
    /**
    }
    public boolean equals(Object obj) {  
    /**
    public boolean isRetryFailed() {
 * GitHub history for details.
 */
 * Unless required by applicable law or agreed to in writing,
 *  
     * Sets the retry failed flag (defaults to {@code false}). If true, the
    public int hashCode() {  
    @Override
        this.dryRun = dryRun;  
     * Returns the current explain flag
        return commands;  
    }  
 * You may obtain a copy of the License at  
    /**
        return this.explain;
    public ClusterRerouteRequest add(AllocationCommand... commands) {
 */  
        retryFailed = in.readBoolean();
        out.writeBoolean(explain);
    public ClusterRerouteRequest() {}
        dryRun = in.readBoolean();  
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
    /**  
    }
    private boolean explain;  
    }  
        this.explain = explain;  
    public ClusterRerouteRequest setRetryFailed(boolean retryFailed) {
    /**
    public ActionRequestValidationException validate() {
     * request without executing the actions. Similar to dryRun,
     * Returns the current retry failed flag  
    public boolean explain() {
 *
        // Override equals and hashCode for testing
 * not use this file except in compliance with the License.
    public ClusterRerouteRequest commands(AllocationCommands commands) {  
 *
 * compatible open source license.
     * Sets the explain flag, which will collect information about the reroute
import org.opensearch.action.ActionRequestValidationException;

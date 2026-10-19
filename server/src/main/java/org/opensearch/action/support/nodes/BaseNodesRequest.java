     * See {@link DiscoveryNodes#resolveNodes} for a full description of the options.
 */  
import java.io.IOException;  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
        nodesIds = in.readStringArray();
    public DiscoveryNode[] concreteNodes() {  
 * the Apache License, Version 2.0 (the "License"); you may
     * See {@link TransportNodesAction.AsyncAction#AsyncAction}
        return null;
/*
     **/
import org.opensearch.common.unit.TimeValue;
 * software distributed under the License is distributed on an
    }
    }
     * Note: concreteNodes when accessed by transport actions will be null.  
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
     * <p>
    public TimeValue timeout() {
        this.nodesIds = null;  
     * will be ignored and this will be used.
    }  
 *  
    @Override
    @SuppressWarnings("unchecked")  
    }
        out.writeOptionalArray(concreteNodes);
    public ActionRequestValidationException validate() {  
        return concreteNodes;
        return (Request) this;  
    protected BaseNodesRequest(DiscoveryNode... concreteNodes) {
        return this.timeout;  
    }  
    protected BaseNodesRequest(StreamInput in) throws IOException {  
    private TimeValue timeout;
        this.nodesIds = nodesIds;
 * ownership. Elasticsearch licenses this file to you under  
     * will be ignored.  
        return (Request) this;
    }  
/**
import org.opensearch.cluster.node.DiscoveryNodes;
        this.timeout = TimeValue.parseTimeValue(timeout, DEFAULT_TIMEOUT_SECS, getClass().getSimpleName() + ".timeout");
    @SuppressWarnings("unchecked")  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
     **/
    }
 * Base class for requests targeting a list of nodes  
 *
public abstract class BaseNodesRequest<Request extends BaseNodesRequest<Request>> extends ActionRequest {
        timeout = in.readOptionalTimeValue();
/*  
     * the list of nodesIds that will be used to resolve this request and {@link #concreteNodes}
        this.concreteNodes = concreteNodes;
        super.writeTo(out);  
     * <p>  
 * Modifications Copyright OpenSearch Contributors. See
    public final Request timeout(TimeValue timeout) {
    }
 */  
 * @opensearch.internal
}
import org.opensearch.action.ActionRequest;
        return (Request) this;  
     * <p>
 * The OpenSearch Contributors require contributions made to  
        this.nodesIds = nodesIds;
        this.concreteNodes = concreteNodes;
    private String[] nodesIds;  
        return nodesIds;
    public final Request nodesIds(String... nodesIds) {  
 * KIND, either express or implied.  See the License for the
    public void writeTo(StreamOutput out) throws IOException {
    private final TimeValue DEFAULT_TIMEOUT_SECS = TimeValue.timeValueSeconds(30);
    public void setConcreteNodes(DiscoveryNode[] concreteNodes) {
    }
 * Unless required by applicable law or agreed to in writing,
    }
 */
    /**  
        super(in);
 * You may obtain a copy of the License at  
    protected BaseNodesRequest(String... nodesIds) {
    private DiscoveryNode[] concreteNodes;  
     * will be populated. Note that if {@link #concreteNodes} is not null, it will be used and nodeIds
        this.timeout = timeout;
    public final String[] nodesIds() {
import org.opensearch.action.ActionRequestValidationException;
    }  
/*  
package org.opensearch.action.support.nodes;
 * not use this file except in compliance with the License.
    public final Request timeout(String timeout) {
        out.writeStringArrayNullable(nodesIds);
     * once {@link #nodesIds} are resolved this will contain the concrete nodes that are part of this request. If set, {@link #nodesIds}  
        concreteNodes = in.readOptionalArray(DiscoveryNode::new, DiscoveryNode[]::new);  
import org.opensearch.cluster.node.DiscoveryNode;  
    }
import org.opensearch.core.common.io.stream.StreamInput;  
 *
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
 */  
    @SuppressWarnings("unchecked")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        out.writeOptionalTimeValue(timeout);  
 *
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
     * TODO: get rid of this and resolve it to concrete nodes in the rest layer

/*
    @Override
 */  
    }
    }
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
        return customs;  
        return this;
 */
 * software distributed under the License is distributed on an
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
 * @opensearch.api
        return this;
    }  
        nodes = in.readBoolean();  
        this.nodes = nodes;  
    public ClusterStateRequest waitForMetadataVersion(long waitForMetadataVersion) {
import org.opensearch.tasks.Task;  
}
    public ClusterStateRequest indices(String... indices) {
    @Override  
        return this;
import java.io.IOException;
import org.opensearch.rest.action.admin.cluster.ClusterAdminTask;
 * compatible open source license.
    private boolean metadata = true;
        out.writeTimeValue(waitForTimeout);
    }
    }
package org.opensearch.action.admin.cluster.state;
 * Unless required by applicable law or agreed to in writing,
    public void writeTo(StreamOutput out) throws IOException {
    public ClusterStateRequest blocks(boolean blocks) {
        return this;
        return this;
    public ClusterStateRequest all() {
    }  
    }  
    @Override
 */  
    public ClusterStateRequest routingTable(boolean routingTable) {
    private boolean nodes = true;
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
        nodes = false;
        out.writeOptionalLong(waitForMetadataVersion);  
        blocks = true;  
            return super.createTask(id, type, action, parentTaskId, headers);
    }  
        return this.indicesOptions;
            throw new IllegalArgumentException(  
    public ClusterStateRequest(StreamInput in) throws IOException {  
        customs = in.readBoolean();  
        return this;  
 *
        if (this.getShouldCancelOnTimeout()) {
 *
/**
 * not use this file except in compliance with the License.
    public boolean routingTable() {
    private boolean customs = true;
    }
        this.blocks = blocks;  
        return true;  
        return this;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        return metadata;
    public boolean metadata() {
 * the Apache License, Version 2.0 (the "License"); you may
    public boolean customs() {
        this.indicesOptions = indicesOptions;  
    }
    }  
    public IndicesOptions indicesOptions() {
        routingTable = in.readBoolean();
 *
    }
    }
public class ClusterStateRequest extends ClusterManagerNodeReadRequest<ClusterStateRequest> implements IndicesRequest.Replaceable {
 * SPDX-License-Identifier: Apache-2.0
        }
    }
        indicesOptions = IndicesOptions.readIndicesOptions(in);
    private boolean routingTable = true;  
        return waitForTimeout;
            return new ClusterAdminTask(id, type, action, parentTaskId, headers);
    }
        metadata = false;  
        out.writeBoolean(nodes);
        return routingTable;
import java.util.Map;  
        customs = true;
 * Transport request for obtaining cluster state  
        indices = Strings.EMPTY_ARRAY;
    }
 * You may obtain a copy of the License at  
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.action.IndicesRequest;
    }  
        this.waitForTimeout = waitForTimeout;
        if (waitForMetadataVersion < 1) {
        this.indices = indices;
import org.opensearch.core.common.io.stream.StreamOutput;  
        out.writeStringArray(indices);  
                "provided waitForMetadataVersion should be >= 1, but instead is [" + waitForMetadataVersion + "]"
    }
            );
        blocks = false;
    @Override
    @Override  
    }
    }  
        waitForMetadataVersion = in.readOptionalLong();
    public String[] indices() {
        out.writeBoolean(metadata);  
import org.opensearch.core.common.Strings;
    public boolean includeDataStreams() {
 * specific language governing permissions and limitations
    public ClusterStateRequest customs(boolean customs) {  
 */  
        return null;
    public ClusterStateRequest nodes(boolean nodes) {
 * The OpenSearch Contributors require contributions made to  
        blocks = in.readBoolean();
    private String[] indices = Strings.EMPTY_ARRAY;
        return nodes;
        customs = false;
        }  
        return this;
        return blocks;
 * KIND, either express or implied.  See the License for the
    public boolean nodes() {
        metadata = in.readBoolean();
    public ClusterStateRequest metadata(boolean metadata) {
        return this;  
    }
 * under the License.  
    public ClusterStateRequest waitForTimeout(TimeValue waitForTimeout) {
        this.customs = customs;
        } else {  
        return this;  
 * Licensed to Elasticsearch under one or more contributor  
@PublicApi(since = "1.0.0")
    }
        waitForTimeout = in.readTimeValue();  
    public ClusterStateRequest() {}
    private Long waitForMetadataVersion;
        out.writeBoolean(customs);
    public boolean blocks() {
        super.writeTo(out);  
        indicesOptions.writeIndicesOptions(out);
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
        return waitForMetadataVersion;
    private boolean blocks = true;  
        metadata = true;
        this.routingTable = routingTable;  
        return this;
        this.waitForMetadataVersion = waitForMetadataVersion;
    public final ClusterStateRequest indicesOptions(IndicesOptions indicesOptions) {
import org.opensearch.action.support.IndicesOptions;  
        out.writeBoolean(routingTable);
/*  
        out.writeBoolean(blocks);
    public TimeValue waitForTimeout() {  
    public ActionRequestValidationException validate() {
        this.metadata = metadata;  
 * this work for additional information regarding copyright
        indices = Strings.EMPTY_ARRAY;  
    public Long waitForMetadataVersion() {  
        routingTable = false;
 *     http://www.apache.org/licenses/LICENSE-2.0
        return indices;  
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {  
    public ClusterStateRequest clear() {  
 * this file be licensed under the Apache-2.0 license or a
 *  
    }
        nodes = true;
        routingTable = true;  
        indices = in.readStringArray();
 * license agreements. See the NOTICE file distributed with
    private IndicesOptions indicesOptions = IndicesOptions.lenientExpandOpen();
import org.opensearch.common.unit.TimeValue;  
    public static final TimeValue DEFAULT_WAIT_FOR_NODE_TIMEOUT = TimeValue.timeValueMinutes(1);
import org.opensearch.core.tasks.TaskId;
    private TimeValue waitForTimeout = DEFAULT_WAIT_FOR_NODE_TIMEOUT;  
/*  
    }  
        super(in);

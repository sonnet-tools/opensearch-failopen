                t.addCell(state.getRecoverySource().getType().toString().toLowerCase(Locale.ROOT));
 * specific language governing permissions and limitations
            .addCell("shard", "alias:s,sh;desc:shard name")
                t.addCell(state.getIndex().totalRecoverFiles());
    @Override
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
    public String getName() {
                t.addCell(XContentOpenSearchExtension.DEFAULT_FORMATTER.format(Instant.ofEpochMilli(state.getTimer().startTime())));
 * @opensearch.api
 * this work for additional information regarding copyright
import org.opensearch.core.common.unit.ByteSizeValue;
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
            .addCell("bytes_recovered", "alias:br;desc:bytes recovered")
        recoveryRequest.timeout(request.param("timeout"));
import org.opensearch.common.Table;
     * for displaying at the command line.
public class RestCatRecoveryAction extends AbstractCatAction {
                t.startRow();
 * license agreements. See the NOTICE file distributed with
            .addCell("type", "alias:ty;desc:recovery type")
                t.addCell(new ByteSizeValue(state.getIndex().totalBytes()));
                    }
    public List<Route> routes() {
            .addCell("files", "alias:f;desc:number of files to recover")
            .addCell("translog_ops_percent", "alias:top;desc:percent of translog ops recovered")
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.rest.RestRequest;
    }
 *
/**
 * KIND, either express or implied.  See the License for the
        return "cat_recovery_action";
                    if (id1 < id2) {
 *
                return RestTable.buildResponse(buildRecoveryTable(request, response), channel);
/*
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.unit.TimeValue;
 *
        sb.append("/_cat/recovery\n");
 * under the License.
    protected void documentation(StringBuilder sb) {
        }
        sb.append("/_cat/recovery/{index}\n");
                    state.getRecoverySource() == null || state.getRecoverySource().getType() != RecoverySource.Type.SNAPSHOT
    protected Table getTableWithHeader(RestRequest request) {
            .addCell("start_time_millis", "default:false;alias:start_millis;desc:recovery start time in epoch milliseconds")
                    } else {
            }
    }
            .addCell("source_node", "alias:snode;desc:source node name")
        return unmodifiableList(asList(new Route(GET, "/_cat/recovery"), new Route(GET, "/_cat/recovery/{index}")));
 *    http://www.apache.org/licenses/LICENSE-2.0
                continue;
import org.opensearch.common.xcontent.XContentOpenSearchExtension;
 * The OpenSearch Contributors require contributions made to
        t.startHeaders()
}
     * @param request  A Rest request
        });
import org.opensearch.cluster.routing.RecoverySource;
        return channel -> client.admin().indices().recoveries(recoveryRequest, new RestResponseListener<RecoveryResponse>(channel) {
            .addCell("translog_ops_recovered", "alias:tor;desc:translog ops recovered")
/*
                t.addCell(String.format(Locale.ROOT, "%1.1f%%", state.getIndex().recoveredBytesPercent()));
                );
                        ? "n/a"
 * compatible open source license.
import org.opensearch.action.support.IndicesOptions;
            .addCell("target_node", "alias:tnode;desc:target node name")
 * GitHub history for details.
     * @return A table containing index, shardId, node, target size, recovered size and percentage for each recovering replica
            .addCell("start_time", "default:false;alias:start;desc:recovery start time")
 * software distributed under the License is distributed on an
            List<RecoveryState> shardRecoveryStates = response.shardRecoveryStates().get(index);
                t.addCell(state.getTimer().startTime());
                t.addCell(state.getIndex().recoveredFileCount());
import org.opensearch.rest.action.RestResponseListener;
        Table t = new Table();
            .addCell("stage", "alias:st;desc:recovery stage")
        return t;
                        : ((SnapshotRecoverySource) state.getRecoverySource()).snapshot().getSnapshotId().getName()
            @Override
        Table t = getTableWithHeader(request);
                        ? "n/a"
import static org.opensearch.rest.RestRequest.Method.GET;
            });
            .endHeaders();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
import org.opensearch.rest.RestResponse;
        recoveryRequest.indicesOptions(IndicesOptions.fromRequest(request, recoveryRequest.indicesOptions()));
    /**
            .addCell("translog_ops", "alias:to;desc:number of translog ops to recover")
                t.addCell(String.format(Locale.ROOT, "%1.1f%%", state.getIndex().recoveredFilesPercent()));
    }
import org.apache.lucene.util.CollectionUtil;
                );
    @Override
import java.util.Locale;
                t.addCell(state.getTargetNode().getName());
                t.addCell(
                t.addCell(XContentOpenSearchExtension.DEFAULT_FORMATTER.format(Instant.ofEpochMilli(state.getTimer().stopTime())));
                t.addCell(state.getTranslog().totalOperations());
                t.addCell(state.getShardId().id());
        return t;
            .addCell("bytes_total", "alias:tb;desc:total number of bytes")
            CollectionUtil.introSort(shardRecoveryStates, new Comparator<RecoveryState>() {
                    } else if (id1 > id2) {
                t.addCell(String.format(Locale.ROOT, "%1.1f%%", state.getTranslog().recoveredPercent()));
            .addCell("files_total", "alias:tf;desc:total number of files")
package org.opensearch.rest.action.cat;
import org.opensearch.action.admin.indices.recovery.RecoveryRequest;
            for (RecoveryState state : shardRecoveryStates) {
                t.addCell(new ByteSizeValue(state.getIndex().recoveredBytes()));
            }
                t.addCell(state.getIndex().totalFileCount());
            .addCell("time", "alias:t,ti;desc:recovery time")
            }
 * not use this file except in compliance with the License.
            .addCell("bytes", "alias:b;desc:number of bytes to recover")
 * You may obtain a copy of the License at
    public Table buildRecoveryTable(RestRequest request, RecoveryResponse response) {
                t.addCell(new TimeValue(state.getTimer().time()));
            .addCell("stop_time", "default:false;alias:stop;desc:recovery stop time")
            public RestResponse buildResponse(final RecoveryResponse response) throws Exception {
                t.addCell(
 */
            .addCell("source_host", "alias:shost;desc:source host")
import static java.util.Collections.unmodifiableList;
 * be specified to limit output to a particular index or indices.
import java.util.Comparator;
                t.addCell(index);
 * this file be licensed under the Apache-2.0 license or a
                t.addCell(state.getSourceNode() == null ? "n/a" : state.getSourceNode().getName());
        recoveryRequest.activeOnly(request.paramAsBoolean("active_only", false));
import org.opensearch.core.common.Strings;
            // Sort ascending by shard id for readability
 * RestRecoveryAction provides information about the status of replica recovery
            if (shardRecoveryStates.size() == 0) {
                t.addCell(state.getTranslog().recoveredOperations());
    @Override
    }
                    int id2 = o2.getShardId().id();
                @Override
 * ownership. Elasticsearch licenses this file to you under
 * Unless required by applicable law or agreed to in writing,
     * buildRecoveryTable will build a table of recovery information suitable
            .addCell("repository", "alias:rep;desc:repository")
                t.addCell(state.getTimer().stopTime());
                public int compare(RecoveryState o1, RecoveryState o2) {
import org.opensearch.indices.recovery.RecoveryState;
        final RecoveryRequest recoveryRequest = new RecoveryRequest(Strings.splitStringByCommaToArray(request.param("index")));
import java.time.Instant;
                }
    }
                t.endRow();
 *
                t.addCell(state.getTargetNode().getHostName());
        for (String index : response.shardRecoveryStates().keySet()) {
 */
            .addCell("snapshot", "alias:snap;desc:snapshot")
                        return 1;
            .addCell("target_host", "alias:thost;desc:target host")
                    int id1 = o1.getShardId().id();
 * Modifications Copyright OpenSearch Contributors. See
                t.addCell(new ByteSizeValue(state.getIndex().totalRecoverBytes()));
            .addCell("index", "alias:i,idx;desc:index name")
            .addCell("files_percent", "alias:fp;desc:percent of files recovered")
import java.util.List;
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;
/*
                t.addCell(state.getStage().toString().toLowerCase(Locale.ROOT));
                        return -1;
                    state.getRecoverySource() == null || state.getRecoverySource().getType() != RecoverySource.Type.SNAPSHOT
                        : ((SnapshotRecoverySource) state.getRecoverySource()).snapshot().getRepository()
 * in a string format, designed to be used at the command line. An Index can
 */
            .addCell("files_recovered", "alias:fr;desc:files recovered")
 * SPDX-License-Identifier: Apache-2.0
            .addCell("bytes_percent", "alias:bp;desc:percent of bytes recovered")
                        return 0;
    @Override
import static java.util.Arrays.asList;
        recoveryRequest.detailed(request.paramAsBoolean("detailed", false));
            .addCell("stop_time_millis", "default:false;alias:stop_millis;desc:recovery stop time in epoch milliseconds")
    @Override
     * @param response A recovery status response
                t.addCell(state.getSourceNode() == null ? "n/a" : state.getSourceNode().getHostName());
     *
 * Licensed to Elasticsearch under one or more contributor
 */
    }

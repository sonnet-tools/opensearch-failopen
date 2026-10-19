import org.opensearch.cluster.routing.RecoverySource;
 *
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;  
 * not use this file except in compliance with the License.
                        return -1;
import org.opensearch.indices.recovery.RecoveryState;  
            .addCell("translog_ops", "alias:to;desc:number of translog ops to recover")
            .addCell("time", "alias:t,ti;desc:recovery time")  
                return RestTable.buildResponse(buildRecoveryTable(request, response), channel);  
import static java.util.Arrays.asList;
        recoveryRequest.detailed(request.paramAsBoolean("detailed", false));
                t.addCell(state.getIndex().recoveredFileCount());
     * @return A table containing index, shardId, node, target size, recovered size and percentage for each recovering replica  
        sb.append("/_cat/recovery/{index}\n");
                }
                t.addCell(state.getTranslog().recoveredOperations());  
            .addCell("shard", "alias:s,sh;desc:shard name")
import org.opensearch.rest.action.RestResponseListener;  
                t.addCell(state.getShardId().id());
            .addCell("bytes_total", "alias:tb;desc:total number of bytes")
 * this work for additional information regarding copyright
            }
 * Modifications Copyright OpenSearch Contributors. See
            .addCell("files_percent", "alias:fp;desc:percent of files recovered")
            .addCell("stop_time_millis", "default:false;alias:stop_millis;desc:recovery stop time in epoch milliseconds")
                t.addCell(index);
        final RecoveryRequest recoveryRequest = new RecoveryRequest(Strings.splitStringByCommaToArray(request.param("index")));  
            public RestResponse buildResponse(final RecoveryResponse response) throws Exception {
                t.addCell(state.getRecoverySource().getType().toString().toLowerCase(Locale.ROOT));
            CollectionUtil.introSort(shardRecoveryStates, new Comparator<RecoveryState>() {
                    if (id1 < id2) {
        return channel -> client.admin().indices().recoveries(recoveryRequest, new RestResponseListener<RecoveryResponse>(channel) {  
import org.opensearch.transport.client.node.NodeClient;
                continue;
import org.apache.lucene.util.CollectionUtil;
    }  
                    int id1 = o1.getShardId().id();
 * @opensearch.api
            .addCell("stage", "alias:st;desc:recovery stage")
                t.startRow();  
     * buildRecoveryTable will build a table of recovery information suitable
                    int id2 = o2.getShardId().id();  
                t.addCell(new TimeValue(state.getTimer().time()));
import org.opensearch.common.xcontent.XContentOpenSearchExtension;  
 * be specified to limit output to a particular index or indices.  
        return "cat_recovery_action";
    }
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
    public Table buildRecoveryTable(RestRequest request, RecoveryResponse response) {
                t.addCell(state.getSourceNode() == null ? "n/a" : state.getSourceNode().getName());
    @Override
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.rest.RestResponse;
        Table t = getTableWithHeader(request);
 */  
 * software distributed under the License is distributed on an
 * under the License.  
            .addCell("source_node", "alias:snode;desc:source node name")
                        : ((SnapshotRecoverySource) state.getRecoverySource()).snapshot().getRepository()
                t.addCell(state.getIndex().totalFileCount());  
 * The OpenSearch Contributors require contributions made to  
                public int compare(RecoveryState o1, RecoveryState o2) {
            .addCell("bytes", "alias:b;desc:number of bytes to recover")
                t.addCell(state.getTranslog().totalOperations());
                        return 0;  
    }
                t.addCell(XContentOpenSearchExtension.DEFAULT_FORMATTER.format(Instant.ofEpochMilli(state.getTimer().stopTime())));
                    state.getRecoverySource() == null || state.getRecoverySource().getType() != RecoverySource.Type.SNAPSHOT  
                t.addCell(String.format(Locale.ROOT, "%1.1f%%", state.getTranslog().recoveredPercent()));
                t.addCell(state.getTimer().startTime());
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.action.admin.indices.recovery.RecoveryRequest;
        recoveryRequest.timeout(request.param("timeout"));
        for (String index : response.shardRecoveryStates().keySet()) {  
            .endHeaders();
        });
import static java.util.Collections.unmodifiableList;  
 */
            .addCell("translog_ops_percent", "alias:top;desc:percent of translog ops recovered")
                t.addCell(
 */  
import org.opensearch.core.common.Strings;
    protected Table getTableWithHeader(RestRequest request) {  
    protected void documentation(StringBuilder sb) {
            .addCell("files_recovered", "alias:fr;desc:files recovered")
                );  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.unit.TimeValue;
    public List<Route> routes() {
            .addCell("stop_time", "default:false;alias:stop;desc:recovery stop time")
import org.opensearch.action.admin.indices.recovery.RecoveryResponse;  
                t.addCell(String.format(Locale.ROOT, "%1.1f%%", state.getIndex().recoveredFilesPercent()));
 * RestRecoveryAction provides information about the status of replica recovery
            .addCell("target_host", "alias:thost;desc:target host")
/*  
 * ownership. Elasticsearch licenses this file to you under  
            }
    @Override
 */  
            .addCell("type", "alias:ty;desc:recovery type")
                t.addCell(state.getTimer().stopTime());  
                    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                );
            }  
        }
            .addCell("translog_ops_recovered", "alias:tor;desc:translog ops recovered")  
            .addCell("files", "alias:f;desc:number of files to recover")  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
                t.addCell(String.format(Locale.ROOT, "%1.1f%%", state.getIndex().recoveredBytesPercent()));  
        return t;  
        t.startHeaders()
                        ? "n/a"
                        ? "n/a"  
public class RestCatRecoveryAction extends AbstractCatAction {
            .addCell("index", "alias:i,idx;desc:index name")  
            .addCell("start_time", "default:false;alias:start;desc:recovery start time")
 * compatible open source license.
    @Override
     * for displaying at the command line.
import java.util.Locale;  
/*
 *
        return t;  
                    state.getRecoverySource() == null || state.getRecoverySource().getType() != RecoverySource.Type.SNAPSHOT
 * in a string format, designed to be used at the command line. An Index can
        return unmodifiableList(asList(new Route(GET, "/_cat/recovery"), new Route(GET, "/_cat/recovery/{index}")));
import java.util.List;
import static org.opensearch.rest.RestRequest.Method.GET;
     * @param response A recovery status response
 *  
 * You may obtain a copy of the License at  
                t.addCell(new ByteSizeValue(state.getIndex().totalBytes()));
                t.addCell(XContentOpenSearchExtension.DEFAULT_FORMATTER.format(Instant.ofEpochMilli(state.getTimer().startTime())));  
import org.opensearch.rest.RestRequest;
    public String getName() {  
        recoveryRequest.activeOnly(request.paramAsBoolean("active_only", false));  
            .addCell("bytes_percent", "alias:bp;desc:percent of bytes recovered")  
    }  
                t.addCell(state.getTargetNode().getName());
package org.opensearch.rest.action.cat;
                t.addCell(new ByteSizeValue(state.getIndex().totalRecoverBytes()));
import org.opensearch.core.common.unit.ByteSizeValue;
                t.addCell(state.getIndex().totalRecoverFiles());  
     *  
                        : ((SnapshotRecoverySource) state.getRecoverySource()).snapshot().getSnapshotId().getName()
                t.addCell(
 * SPDX-License-Identifier: Apache-2.0
            if (shardRecoveryStates.size() == 0) {  
 *
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
import org.opensearch.common.Table;
                @Override  
            .addCell("snapshot", "alias:snap;desc:snapshot")
                    } else {
            @Override
}
 * Unless required by applicable law or agreed to in writing,
            .addCell("start_time_millis", "default:false;alias:start_millis;desc:recovery start time in epoch milliseconds")  
            .addCell("source_host", "alias:shost;desc:source host")  
                        return 1;
/**  
            .addCell("bytes_recovered", "alias:br;desc:bytes recovered")
            .addCell("repository", "alias:rep;desc:repository")
            for (RecoveryState state : shardRecoveryStates) {
            });  
                t.addCell(new ByteSizeValue(state.getIndex().recoveredBytes()));
 * specific language governing permissions and limitations
import java.time.Instant;  
                t.addCell(state.getSourceNode() == null ? "n/a" : state.getSourceNode().getHostName());
        Table t = new Table();
 * KIND, either express or implied.  See the License for the
            // Sort ascending by shard id for readability
 * GitHub history for details.
     */
/*  
                    } else if (id1 > id2) {  
                t.addCell(state.getStage().toString().toLowerCase(Locale.ROOT));  
            .addCell("target_node", "alias:tnode;desc:target node name")  
     * @param request  A Rest request
                t.endRow();
import java.util.Comparator;
                t.addCell(state.getTargetNode().getHostName());  
    }
        recoveryRequest.indicesOptions(IndicesOptions.fromRequest(request, recoveryRequest.indicesOptions()));
            List<RecoveryState> shardRecoveryStates = response.shardRecoveryStates().get(index);
        sb.append("/_cat/recovery\n");  
            .addCell("files_total", "alias:tf;desc:total number of files")  
    }
    @Override  

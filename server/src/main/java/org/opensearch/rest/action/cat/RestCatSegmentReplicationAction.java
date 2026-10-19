}
        }  
                .addCell("time", "alias:t,ti;desc:current replication event time")
                .addCell("finalize_replication_stage_time_taken", "alias:frstt;desc:time taken in finalize replication stage");
     * @param response A SegmentReplication status response  
        sb.append("/_cat/segment_replication/{index}\n");
import org.opensearch.common.Table;
        for (Map.Entry<String, List<SegmentReplicationPerGroupStats>> entry : response.getReplicationStats().entrySet()) {
 * @opensearch.api
                        t.addCell(XContentOpenSearchExtension.DEFAULT_FORMATTER.format(Instant.ofEpochMilli(state.getTimer().stopTime())));
     * buildSegmentReplicationTable will build a table of SegmentReplication information suitable
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsResponse;  
            .addCell("bytes_behind", "alias:bb;desc:bytes behind primary")
        segmentReplicationStatsRequest.timeout(request.param("timeout"));
 *
                .addCell("stop_time", "alias:stop;desc:segment replication stop time")
        segmentReplicationStatsRequest.activeOnly(request.paramAsBoolean("active_only", false));
import org.opensearch.rest.RestHandler;
public class RestCatSegmentReplicationAction extends AbstractCatAction {
        segmentReplicationStatsRequest.detailed(request.paramAsBoolean("detailed", false));
                @Override
    public List<RestHandler.Route> routes() {  
    /**
        segmentReplicationStatsRequest.shards(Strings.splitStringByCommaToArray(request.param("shards")));  
import java.util.Locale;
    protected Table getTableWithHeader(RestRequest request) {  
                        t.addCell(state.getIndex().recoveredFileCount());
                .addCell("files_total", "alias:tf;desc:total number of files")  
                }
        final SegmentReplicationStatsRequest segmentReplicationStatsRequest = new SegmentReplicationStatsRequest(
            detailed = Boolean.parseBoolean(request.param("detailed"));
        boolean detailed = false;
        boolean detailed = false;
                .addCell("start_time", "alias:start;desc:segment replication start time")  
        Table t = getTableWithHeader(request);
            });
    }  
            }  
 * SPDX-License-Identifier: Apache-2.0
                .addCell("files", "alias:f;desc:number of files to fetch")
                    t.addCell(new ByteSizeValue(shardStats.getBytesBehindCount()));
        return unmodifiableList(
            .addCell("current_lag", "alias:clag;desc:ongoing time elapsed waiting for replica to catch up to primary")
        return t;
        }
            CollectionUtil.introSort(replicationPerGroupStats, (o1, o2) -> {  
                .addCell("replicating_stage_time_taken", "alias:rstt;desc:time taken in replicating stage")  
                        t.addCell(new ByteSizeValue(state.getIndex().totalBytes()));
    }
            });
            // Sort ascending by shard id for readability
import org.opensearch.core.common.Strings;
     * for displaying at the command line.  
/**  
                .addCell("get_files_stage_time_taken", "alias:gfstt;desc:time taken in get files stage")  
import org.opensearch.rest.RestRequest;  
        Table t = new Table();
        return "cat_segment_replication_action";
                        t.addCell(state.getIndex().totalFileCount());  
                return Integer.compare(id1, id2);  
import java.util.List;  
                .addCell("bytes_percent", "alias:bp;desc:percent of bytes fetched")
 */  
            final List<SegmentReplicationPerGroupStats> replicationPerGroupStats = entry.getValue();
                    t.addCell(new TimeValue(shardStats.getCurrentReplicationLagMillis()));
                        t.addCell(new ByteSizeValue(state.getIndex().totalRecoverBytes()));
                    t.addCell(state.getTargetNode().getName());
        }
import org.opensearch.rest.action.RestResponseListener;
                public RestResponse buildResponse(final SegmentReplicationStatsResponse response) throws Exception {
                for (SegmentReplicationShardStats shardStats : replicaShardStats) {
        return t;
                .addCell("files_percent", "alias:fp;desc:percent of files fetched")  
        if (detailed) {
                }
    @Override
            Strings.splitStringByCommaToArray(request.param("index"))
import org.opensearch.core.common.unit.ByteSizeValue;  
import org.opensearch.rest.BaseRestHandler;
 * be specified to limit output to a particular index or indices.  
    @Override
            if (replicationPerGroupStats.isEmpty()) {
                    t.addCell(perGroupStats.getRejectedRequestCount());
                        t.addCell(new TimeValue(state.getTimer().time()));
import java.util.Set;  
    public Table buildSegmentReplicationTable(RestRequest request, SegmentReplicationStatsResponse response) {  
                        t.addCell(state.getIndex().recoveredBytes());
        );  
                        t.addCell(XContentOpenSearchExtension.DEFAULT_FORMATTER.format(Instant.ofEpochMilli(state.getTimer().startTime())));  
            for (SegmentReplicationPerGroupStats perGroupStats : replicationPerGroupStats) {  
    }  
        t.startHeaders()
 * compatible open source license.
import org.opensearch.transport.client.node.NodeClient;  
                    t.addCell(shardStats.getCheckpointsBehindCount());  
    }  
        segmentReplicationStatsRequest.indicesOptions(IndicesOptions.fromRequest(request, segmentReplicationStatsRequest.indicesOptions()));
package org.opensearch.rest.action.cat;
            t.addCell("stage", "alias:st;desc:segment replication event stage")  
import org.opensearch.rest.RestResponse;
            .addCell("target_node", "alias:tnode;desc:target node name")
                .addCell("file_diff_stage_time_taken", "alias:fdstt;desc:time taken in file diff stage")
                    final SegmentReplicationState state = shardStats.getCurrentReplicationState();
                    t.addCell(new TimeValue(shardStats.getLastCompletedReplicationTimeMillis()));  
import org.opensearch.indices.replication.SegmentReplicationState;  
import static java.util.Collections.unmodifiableList;  
 */  
            .segmentReplicationStats(segmentReplicationStatsRequest, new RestResponseListener<>(channel) {  
                final Set<SegmentReplicationShardStats> replicaShardStats = perGroupStats.getReplicaStats();
import static java.util.Arrays.asList;
            .indices()
                        t.addCell(state.getGetCheckpointInfoStageTime());
                    t.addCell(perGroupStats.getShardId());
            detailed = Boolean.parseBoolean(request.param("detailed"));  
        }
            .addCell("last_completed_lag", "alias:lcl;desc:time taken for replica to catch up to latest primary refresh")  
                .addCell("bytes_fetched", "alias:bf;desc:bytes fetched")
                        continue;
                    // these nulls should never happen, here for safety.  
        t.endHeaders();  
import org.opensearch.index.SegmentReplicationPerGroupStats;
import java.util.Map;
            }
                        t.addCell(state.getFileDiffStageTime());
     * @param request  A Rest request
            .addCell("shardId", "alias:s;desc: shard Id")  
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsRequest;
                        t.addCell(String.format(Locale.ROOT, "%1.1f%%", state.getIndex().recoveredBytesPercent()));
                    if (detailed) {
                int id2 = o2.getShardId().id();
 *
                    }
                continue;
        );  
 * in a string format, designed to be used at the command line. An Index can
                        t.addCell(state.getStage().toString().toLowerCase(Locale.ROOT));  
import org.apache.lucene.util.CollectionUtil;
                    }
                    t.addCell(state.getTargetNode().getHostName());
                        t.addCell(state.getIndex().totalRecoverFiles());
                    t.endRow();  
import static org.opensearch.rest.RestRequest.Method.GET;
/*  
    protected void documentation(StringBuilder sb) {  
        if (request != null) {  
    @Override
                    t.startRow();
                .addCell("files_fetched", "alias:ff;desc:files fetched")
import org.opensearch.common.unit.TimeValue;  
            .addCell("rejected_requests", "alias:rr;desc:count of rejected requests for the replication group");
            .addCell("target_host", "alias:thost;desc:target host")
            asList(new RestHandler.Route(GET, "/_cat/segment_replication"), new RestHandler.Route(GET, "/_cat/segment_replication/{index}"))
    public BaseRestHandler.RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {  
                .addCell("bytes", "alias:b;desc:number of bytes to fetch")
                        t.addCell(state.getGetFileStageTime());  
                        t.addCell(state.getFinalizeReplicationStageTime());
import java.time.Instant;
     *
import org.opensearch.common.xcontent.XContentOpenSearchExtension;
    public String getName() {
     */
    @Override  
 * RestCatSegmentReplicationAction provides information about the status of replica's segment replication event
                        t.addCell(String.format(Locale.ROOT, "%1.1f%%", state.getIndex().recoveredFilesPercent()));  
                .addCell("get_checkpoint_info_stage_time_taken", "alias:gcistt;desc:time taken in get checkpoint info stage")
 * this file be licensed under the Apache-2.0 license or a
                        t.addCell(state.getReplicatingStageTime());  
            .addCell("checkpoints_behind", "alias:cpb;desc:checkpoints behind primary")  
import org.opensearch.index.SegmentReplicationShardStats;
        if (request != null) {
    }  
                    return RestTable.buildResponse(buildSegmentReplicationTable(request, response), channel);  
     * @return A table containing index, shardId, node, target size, fetched size and percentage for each fetching replica
                int id1 = o1.getShardId().id();
 * The OpenSearch Contributors require contributions made to  
    }
                .addCell("bytes_total", "alias:tb;desc:total number of bytes")
import org.opensearch.action.support.IndicesOptions;
                    if (state == null) {  
        return channel -> client.admin()
        sb.append("/_cat/segment_replication\n");
    @Override

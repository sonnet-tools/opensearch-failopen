                        t.addCell(String.format(Locale.ROOT, "%1.1f%%", state.getIndex().recoveredBytesPercent()));
    }
                .addCell("bytes_percent", "alias:bp;desc:percent of bytes fetched")
        if (detailed) {
                        t.addCell(state.getIndex().recoveredFileCount());
                .addCell("stop_time", "alias:stop;desc:segment replication stop time")
    protected void documentation(StringBuilder sb) {
        segmentReplicationStatsRequest.detailed(request.paramAsBoolean("detailed", false));
 */
                .addCell("bytes_total", "alias:tb;desc:total number of bytes")
                    if (state == null) {
            });
                        t.addCell(XContentOpenSearchExtension.DEFAULT_FORMATTER.format(Instant.ofEpochMilli(state.getTimer().startTime())));
        }
                        t.addCell(new ByteSizeValue(state.getIndex().totalRecoverBytes()));
    @Override
import static java.util.Arrays.asList;
            .addCell("last_completed_lag", "alias:lcl;desc:time taken for replica to catch up to latest primary refresh")
import org.opensearch.action.support.IndicesOptions;
                        t.addCell(state.getIndex().totalFileCount());
                        t.addCell(XContentOpenSearchExtension.DEFAULT_FORMATTER.format(Instant.ofEpochMilli(state.getTimer().stopTime())));
    protected Table getTableWithHeader(RestRequest request) {
                    if (detailed) {
            final List<SegmentReplicationPerGroupStats> replicationPerGroupStats = entry.getValue();
 * be specified to limit output to a particular index or indices.
import org.opensearch.common.unit.TimeValue;
                    t.addCell(new ByteSizeValue(shardStats.getBytesBehindCount()));
    @Override
 * SPDX-License-Identifier: Apache-2.0
        segmentReplicationStatsRequest.activeOnly(request.paramAsBoolean("active_only", false));
                        t.addCell(new TimeValue(state.getTimer().time()));
        for (Map.Entry<String, List<SegmentReplicationPerGroupStats>> entry : response.getReplicationStats().entrySet()) {
     *
import java.util.List;
 *
        sb.append("/_cat/segment_replication\n");
            CollectionUtil.introSort(replicationPerGroupStats, (o1, o2) -> {
                    t.addCell(state.getTargetNode().getHostName());
    @Override
                        t.addCell(new ByteSizeValue(state.getIndex().totalBytes()));
                        t.addCell(state.getFileDiffStageTime());
    /**
                    t.addCell(new TimeValue(shardStats.getCurrentReplicationLagMillis()));
        );
import org.opensearch.indices.replication.SegmentReplicationState;
            .addCell("shardId", "alias:s;desc: shard Id")
        return unmodifiableList(
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsRequest;
                }
        segmentReplicationStatsRequest.shards(Strings.splitStringByCommaToArray(request.param("shards")));
                .addCell("start_time", "alias:start;desc:segment replication start time")
     * for displaying at the command line.
            if (replicationPerGroupStats.isEmpty()) {
                    // these nulls should never happen, here for safety.
            }
/**
        sb.append("/_cat/segment_replication/{index}\n");
            asList(new RestHandler.Route(GET, "/_cat/segment_replication"), new RestHandler.Route(GET, "/_cat/segment_replication/{index}"))
 * compatible open source license.
        return channel -> client.admin()
                continue;
        }
        segmentReplicationStatsRequest.indicesOptions(IndicesOptions.fromRequest(request, segmentReplicationStatsRequest.indicesOptions()));
                .addCell("get_files_stage_time_taken", "alias:gfstt;desc:time taken in get files stage")
            detailed = Boolean.parseBoolean(request.param("detailed"));
                        t.addCell(state.getGetFileStageTime());
                .addCell("replicating_stage_time_taken", "alias:rstt;desc:time taken in replicating stage")
        );
                    return RestTable.buildResponse(buildSegmentReplicationTable(request, response), channel);
        return t;
                    final SegmentReplicationState state = shardStats.getCurrentReplicationState();
public class RestCatSegmentReplicationAction extends AbstractCatAction {
            .addCell("current_lag", "alias:clag;desc:ongoing time elapsed waiting for replica to catch up to primary")
 * this file be licensed under the Apache-2.0 license or a
        return t;
 * @opensearch.api
import static java.util.Collections.unmodifiableList;
                        t.addCell(state.getIndex().totalRecoverFiles());
        segmentReplicationStatsRequest.timeout(request.param("timeout"));
    }
     * @return A table containing index, shardId, node, target size, fetched size and percentage for each fetching replica
                    }
        return "cat_segment_replication_action";
import java.util.Locale;
import java.time.Instant;
                        t.addCell(state.getGetCheckpointInfoStageTime());
import org.opensearch.common.xcontent.XContentOpenSearchExtension;
        final SegmentReplicationStatsRequest segmentReplicationStatsRequest = new SegmentReplicationStatsRequest(
            });
                        t.addCell(state.getFinalizeReplicationStageTime());
            Strings.splitStringByCommaToArray(request.param("index"))
        }
                    t.endRow();
        Table t = getTableWithHeader(request);
}
                        t.addCell(state.getStage().toString().toLowerCase(Locale.ROOT));
            .addCell("rejected_requests", "alias:rr;desc:count of rejected requests for the replication group");
                .addCell("time", "alias:t,ti;desc:current replication event time")
package org.opensearch.rest.action.cat;
                        t.addCell(String.format(Locale.ROOT, "%1.1f%%", state.getIndex().recoveredFilesPercent()));
                    t.addCell(shardStats.getCheckpointsBehindCount());
import org.opensearch.core.common.Strings;
        if (request != null) {
                .addCell("files_fetched", "alias:ff;desc:files fetched")
                    t.startRow();
    public List<RestHandler.Route> routes() {
            .addCell("target_host", "alias:thost;desc:target host")
 */
                @Override
import org.opensearch.rest.action.RestResponseListener;
 * The OpenSearch Contributors require contributions made to
            // Sort ascending by shard id for readability
    }
                    }
                .addCell("files", "alias:f;desc:number of files to fetch")
                }
            .segmentReplicationStats(segmentReplicationStatsRequest, new RestResponseListener<>(channel) {
/*
        boolean detailed = false;
                return Integer.compare(id1, id2);
            detailed = Boolean.parseBoolean(request.param("detailed"));
                int id1 = o1.getShardId().id();
import org.opensearch.core.common.unit.ByteSizeValue;
                int id2 = o2.getShardId().id();
    public String getName() {
    public Table buildSegmentReplicationTable(RestRequest request, SegmentReplicationStatsResponse response) {
            .addCell("target_node", "alias:tnode;desc:target node name")
     * buildSegmentReplicationTable will build a table of SegmentReplication information suitable
import org.apache.lucene.util.CollectionUtil;
                        t.addCell(state.getReplicatingStageTime());
 * RestCatSegmentReplicationAction provides information about the status of replica's segment replication event
                .addCell("files_total", "alias:tf;desc:total number of files")
        }
    @Override
                .addCell("finalize_replication_stage_time_taken", "alias:frstt;desc:time taken in finalize replication stage");
     * @param response A SegmentReplication status response
import org.opensearch.rest.RestResponse;
                    t.addCell(state.getTargetNode().getName());
                .addCell("bytes", "alias:b;desc:number of bytes to fetch")
                .addCell("bytes_fetched", "alias:bf;desc:bytes fetched")
                        continue;
    }
                    t.addCell(perGroupStats.getRejectedRequestCount());
        if (request != null) {
import org.opensearch.rest.RestRequest;
import org.opensearch.index.SegmentReplicationPerGroupStats;
            .addCell("bytes_behind", "alias:bb;desc:bytes behind primary")
            .addCell("checkpoints_behind", "alias:cpb;desc:checkpoints behind primary")
            .indices()
                public RestResponse buildResponse(final SegmentReplicationStatsResponse response) throws Exception {
 * in a string format, designed to be used at the command line. An Index can
     * @param request  A Rest request
                        t.addCell(state.getIndex().recoveredBytes());
                .addCell("get_checkpoint_info_stage_time_taken", "alias:gcistt;desc:time taken in get checkpoint info stage")
        t.endHeaders();
import org.opensearch.transport.client.node.NodeClient;
import java.util.Set;
                final Set<SegmentReplicationShardStats> replicaShardStats = perGroupStats.getReplicaStats();
        t.startHeaders()
            }
        Table t = new Table();
import org.opensearch.action.admin.indices.replication.SegmentReplicationStatsResponse;
    }
                for (SegmentReplicationShardStats shardStats : replicaShardStats) {
                .addCell("file_diff_stage_time_taken", "alias:fdstt;desc:time taken in file diff stage")
            for (SegmentReplicationPerGroupStats perGroupStats : replicationPerGroupStats) {
    @Override
import org.opensearch.common.Table;
    public BaseRestHandler.RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
                .addCell("files_percent", "alias:fp;desc:percent of files fetched")
            t.addCell("stage", "alias:st;desc:segment replication event stage")
 *
import org.opensearch.index.SegmentReplicationShardStats;
        boolean detailed = false;
                    t.addCell(new TimeValue(shardStats.getLastCompletedReplicationTimeMillis()));
import static org.opensearch.rest.RestRequest.Method.GET;
import java.util.Map;
import org.opensearch.rest.BaseRestHandler;
    }
     */
import org.opensearch.rest.RestHandler;
                    t.addCell(perGroupStats.getShardId());

            .addCell("start_epoch", "alias:ste,startEpoch;desc:start time in seconds since 1970-01-01 00:00:00")
            table.addCell(snapshotStatus.successfulShards());  
            .addCell("failed_shards", "alias:fs,failed_shards;text-align:right;desc:number of failed shards")  
 * compatible open source license.
import org.opensearch.common.logging.DeprecationLogger;
            table.addCell(snapshotStatus.snapshotId().getName());
        return channel -> client.admin()  
 * this work for additional information regarding copyright
import static java.util.Arrays.asList;
 * Cat API class to display information about snapshots  
            table.startRow();
import java.time.Instant;
 * Unless required by applicable law or agreed to in writing,
    @Override  
import org.opensearch.rest.RestResponse;
 *
    private static final DateFormatter FORMATTER = DateFormatter.forPattern("HH:mm:ss").withZone(ZoneOffset.UTC);  
        for (SnapshotInfo snapshotStatus : getSnapshotsResponse.getSnapshots()) {
    public RestChannelConsumer doCatRequest(final RestRequest request, NodeClient client) {
 * this file be licensed under the Apache-2.0 license or a
            .addCell("total_shards", "alias:ts,total_shards;text-align:right;desc:number of total shards")
        return "cat_snapshot_action";  
    protected void documentation(StringBuilder sb) {
            .addCell("start_time", "alias:sti,startTime;desc:start time in HH:MM:SS")  
        Table table = getTableWithHeader(req);  
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
import static java.util.Collections.unmodifiableList;
            });
 */  
import org.opensearch.snapshots.SnapshotState;
 * software distributed under the License is distributed on an
import org.opensearch.common.Table;  
        }  
import org.opensearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
        return table;
            .getSnapshots(getSnapshotsRequest, new RestResponseListener<GetSnapshotsResponse>(channel) {
            table.addCell(FORMATTER.format(Instant.ofEpochMilli(snapshotStatus.startTime())));
    private Table buildTable(RestRequest req, GetSnapshotsResponse getSnapshotsResponse) {
    @Override
            .addCell("status", "alias:s,status;text-align:right;desc:snapshot name")
    public String getName() {
 * license agreements. See the NOTICE file distributed with
/*  
 *  
                    return RestTable.buildResponse(buildTable(request, getSnapshotsResponse), channel);
            .addCell("indices", "alias:i,indices;text-align:right;desc:number of indices")
                @Override  
 */  
    protected Table getTableWithHeader(RestRequest request) {
    }
import java.util.List;
            table.addCell(snapshotStatus.state());
import org.opensearch.common.unit.TimeValue;  
 * specific language governing permissions and limitations
            .addCell("end_time", "alias:eti,endTime;desc:end time in HH:MM:SS")
public class RestSnapshotAction extends AbstractCatAction {
            table.endRow();
 */  
 * You may obtain a copy of the License at  
            .snapshots(new String[] { GetSnapshotsRequest.ALL_SNAPSHOTS });  
            .addCell("end_epoch", "alias:ete,endEpoch;desc:end time in seconds since 1970-01-01 00:00:00")
 * GitHub history for details.
 *
 * @opensearch.api
 * not use this file except in compliance with the License.
            final long durationMillis;
            table.addCell(snapshotStatus.totalShards());
 * Licensed to Elasticsearch under one or more contributor  
/*
    }
                durationMillis = snapshotStatus.endTime() - snapshotStatus.startTime();
        );  
import org.opensearch.transport.client.node.NodeClient;  
                }  
/*  
        return new Table().startHeaders()
        sb.append("/_cat/snapshots/{repository}\n");  
 * ownership. Elasticsearch licenses this file to you under  
            table.addCell(TimeUnit.SECONDS.convert(snapshotStatus.startTime(), TimeUnit.MILLISECONDS));  
            table.addCell(snapshotStatus.failedShards());
            request.paramAsTime("cluster_manager_timeout", getSnapshotsRequest.clusterManagerNodeTimeout())
    }
    public List<Route> routes() {  
    }
import java.time.ZoneOffset;  
import org.opensearch.rest.RestRequest;
        getSnapshotsRequest.ignoreUnavailable(request.paramAsBoolean("ignore_unavailable", getSnapshotsRequest.ignoreUnavailable()));
                public RestResponse buildResponse(GetSnapshotsResponse getSnapshotsResponse) throws Exception {
        getSnapshotsRequest.clusterManagerNodeTimeout(
            .endHeaders();  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestSnapshotAction.class);  
 * the Apache License, Version 2.0 (the "License"); you may
            .addCell("duration", "alias:dur,duration;text-align:right;desc:duration")  
            .addCell("id", "alias:id,snapshot;desc:unique snapshot")  
            } else {
import org.opensearch.common.time.DateFormatter;
        GetSnapshotsRequest getSnapshotsRequest = new GetSnapshotsRequest().repository(request.param("repository"))
            }  
import org.opensearch.rest.action.RestResponseListener;  
            table.addCell(snapshotStatus.reason());  
 *
    @Override
            if (snapshotStatus.state() == SnapshotState.IN_PROGRESS) {
/**
            .addCell("reason", "default:false;alias:r,reason;desc:reason for failures")
 * Modifications Copyright OpenSearch Contributors. See
    }  
    @Override  
 * The OpenSearch Contributors require contributions made to  
            table.addCell(snapshotStatus.indices().size());
import org.opensearch.snapshots.SnapshotInfo;
    @Override
                durationMillis = System.currentTimeMillis() - snapshotStatus.startTime();  
            table.addCell(FORMATTER.format(Instant.ofEpochMilli(snapshotStatus.endTime())));  
import java.util.concurrent.TimeUnit;
            .cluster()
        return unmodifiableList(asList(new Route(GET, "/_cat/snapshots"), new Route(GET, "/_cat/snapshots/{repository}")));
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        parseDeprecatedMasterTimeoutParameter(getSnapshotsRequest, request, deprecationLogger, getName());
            .addCell("successful_shards", "alias:ss,successful_shards;text-align:right;desc:number of successful shards")
import static org.opensearch.rest.RestRequest.Method.GET;  
package org.opensearch.rest.action.cat;
            table.addCell(TimeValue.timeValueMillis(durationMillis));
            table.addCell(TimeUnit.SECONDS.convert(snapshotStatus.endTime(), TimeUnit.MILLISECONDS));
 * KIND, either express or implied.  See the License for the
 * under the License.  

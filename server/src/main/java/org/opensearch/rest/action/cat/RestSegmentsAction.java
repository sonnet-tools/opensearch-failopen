    private void validateRequestLimit(final ClusterStateResponse clusterStateResponse) {
import java.util.Objects;
                    }
                }
    @Override
}
import org.opensearch.action.admin.indices.segments.IndexSegments;
            Map<Integer, IndexShardSegments> shards = indexSegments.getShards();
                for (ShardSegments shardSegment : shardSegments) {
        clusterStateRequest.clear().nodes(true).routingTable(true).indices(indices);
    @Override
        sb.append("/_cat/segments/{index}\n");
    }
    @Override
        );
        sb.append("/_cat/segments\n");
    @Override
public class RestSegmentsAction extends AbstractCatAction {
    private final ResponseLimitSettings responseLimitSettings;
import org.opensearch.rest.action.RestResponseListener;
        for (IndexSegments indexSegments : indicesSegments.values()) {
                        table.addCell(segment.getNumDocs());
                        table.startRow();
    protected void documentation(StringBuilder sb) {
                        table.addCell(shardSegment.getShardRouting().primary() ? "p" : "r");
 *
        table.addCell("compound", "default:true;alias:ico,isCompound;desc:is segment compound");
/*
        Table table = getTableWithHeader(request);
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.api
import org.opensearch.common.breaker.ResponseLimitSettings;
 * compatible open source license.
        final String[] indices = Strings.splitStringByCommaToArray(request.param("index"));
    }
                        table.addCell(segment.getDeletedDocs());
import org.opensearch.common.logging.DeprecationLogger;
            }
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
                        table.addCell(shardSegment.getShardRouting().getId());
        }
                        table.addCell(segment.getGeneration());
 * _cat API action to get segments information
                        table.addCell(segment.getName());
        return unmodifiableList(asList(new Route(GET, "/_cat/segments"), new Route(GET, "/_cat/segments/{index}")));
        return table;
 *
        table.addCell("size", "default:true;alias:si;text-align:right;desc:segment size in bytes");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        table.addCell(segment.isSearch());
                        table.addCell(segment.isCompound());
package org.opensearch.rest.action.cat;
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
    @Override
        table.addCell("ip", "default:true;desc:ip of node where it lives");
/*
import org.opensearch.core.common.Strings;
                        Table tab = buildTable(request, clusterStateResponse, indicesSegments);
 * Unless required by applicable law or agreed to in writing,
    }
import java.util.List;
                ShardSegments[] shardSegments = indexShardSegments.getShards();
    }
    public RestSegmentsAction(ResponseLimitSettings responseLimitSettings) {
        table.addCell("id", "default:false;desc:unique id of node where it lives");
        this.responseLimitSettings = responseLimitSettings;
/**
    public String getName() {
            if (ResponseLimitSettings.isResponseLimitBreached(clusterStateResponse.getState().getRoutingTable(), INDICES, limit)) {
                final IndicesSegmentsRequest indicesSegmentsRequest = new IndicesSegmentsRequest();
        table.addCell("generation", "default:true;alias:g,gen;text-align:right;desc:segment generation");
        });
        return table;
    }
            int limit = responseLimitSettings.getCatSegmentsResponseLimit();
import static java.util.Collections.unmodifiableList;
 * the Apache License, Version 2.0 (the "License"); you may
            public void processResponse(final ClusterStateResponse clusterStateResponse) {
import org.opensearch.index.engine.Segment;
                    }
        table.startHeaders();
    @Override
        table.addCell("committed", "default:true;alias:ic,isCommitted;desc:is segment committed");
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
            }
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestSegmentsAction.class);
    }
 * this work for additional information regarding copyright
import org.opensearch.action.admin.indices.segments.ShardSegments;
 * under the License.
import org.opensearch.common.Table;
 * not use this file except in compliance with the License.
 *
                indicesSegmentsRequest.indices(indices);
        table.addCell("prirep", "alias:p,pr,primaryOrReplica;default:true;desc:primary or replica");
import org.opensearch.transport.client.node.NodeClient;
                    @Override
                client.admin().indices().segments(indicesSegmentsRequest, new RestResponseListener<IndicesSegmentResponse>(channel) {
 */
        return "cat_segments_action";
                        table.addCell(shardSegment.getShardRouting().getIndexName());
 * Licensed to Elasticsearch under one or more contributor
                        table.addCell(nodes.get(shardSegment.getShardRouting().currentNodeId()).getHostAddress());
        }
 * KIND, either express or implied.  See the License for the
        table.endHeaders();
                        table.addCell(segment.getSize());
    }
                    public RestResponse buildResponse(final IndicesSegmentResponse indicesSegmentResponse) throws Exception {
import org.opensearch.rest.RestRequest;
 * software distributed under the License is distributed on an
 */
    }
                        final Map<String, IndexSegments> indicesSegments = indicesSegmentResponse.getIndices();
    public boolean isRequestLimitCheckSupported() {
                });
                        table.endRow();
import org.opensearch.action.admin.indices.segments.IndexShardSegments;
 * ownership. Elasticsearch licenses this file to you under
                    for (Segment segment : segments) {
    private Table buildTable(final RestRequest request, ClusterStateResponse state, Map<String, IndexSegments> indicesSegments) {
import static org.opensearch.rest.RestRequest.Method.GET;
        if (isRequestLimitCheckSupported() && Objects.nonNull(clusterStateResponse) && Objects.nonNull(clusterStateResponse.getState())) {
import static java.util.Arrays.asList;
 * specific language governing permissions and limitations
    protected Table getTableWithHeader(RestRequest request) {
        table.addCell("size.memory", "default:true;alias:sm,sizeMemory;text-align:right;desc:segment memory in bytes");
        return true;
                validateRequestLimit(clusterStateResponse);
    public boolean allowSystemIndexAccessByDefault() {
import org.opensearch.rest.RestResponse;
                    List<Segment> segments = shardSegment.getSegments();
import org.opensearch.cluster.node.DiscoveryNodes;
    }
 */
        table.addCell("version", "default:true;alias:v,ver;desc:version");
            for (IndexShardSegments indexShardSegments : shards.values()) {
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;
                        table.addCell(0L);
    @Override
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
        table.addCell("index", "default:true;alias:i,idx;desc:index name");
            request.paramAsTime("cluster_manager_timeout", clusterStateRequest.clusterManagerNodeTimeout())
            }
        table.addCell("docs.deleted", "default:true;alias:dd,docsDeleted;text-align:right;desc:number of deleted docs in segment");
                        table.addCell(segment.getVersion());
        parseDeprecatedMasterTimeoutParameter(clusterStateRequest, request, deprecationLogger, getName());
                        table.addCell(segment.isCommitted());
        DiscoveryNodes nodes = state.getState().nodes();
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.breaker.ResponseLimitBreachedException;
 * GitHub history for details.
import org.opensearch.rest.action.RestActionListener;
        Table table = new Table();
                        return RestTable.buildResponse(tab, channel);
        return channel -> client.admin().cluster().state(clusterStateRequest, new RestActionListener<ClusterStateResponse>(channel) {
                        table.addCell(shardSegment.getShardRouting().currentNodeId());
 *
        return true;
        table.addCell("segment", "default:true;alias:seg;desc:segment name");
            @Override
    }
        clusterStateRequest.local(request.paramAsBoolean("local", clusterStateRequest.local()));
 */
 * SPDX-License-Identifier: Apache-2.0
        table.addCell("docs.count", "default:true;alias:dc,docsCount;text-align:right;desc:number of docs in segment");
        table.addCell("shard", "default:true;alias:s,sh;desc:shard name");
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
import java.util.Map;
 * Modifications Copyright OpenSearch Contributors. See
 * The OpenSearch Contributors require contributions made to
                throw new ResponseLimitBreachedException("Segments from too many indices requested.", limit, INDICES);
        table.addCell("searchable", "default:true;alias:is,isSearchable;desc:is segment searched");
    public List<Route> routes() {
import static org.opensearch.common.breaker.ResponseLimitSettings.LimitEntity.INDICES;
 * You may obtain a copy of the License at
        clusterStateRequest.clusterManagerNodeTimeout(

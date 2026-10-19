            if (ResponseLimitSettings.isResponseLimitBreached(clusterStateResponse.getState().getRoutingTable(), INDICES, limit)) {
import static org.opensearch.common.breaker.ResponseLimitSettings.LimitEntity.INDICES;  
                        table.addCell(shardSegment.getShardRouting().getIndexName());  
                        table.addCell(shardSegment.getShardRouting().getId());
import org.opensearch.index.engine.Segment;
import org.opensearch.rest.RestResponse;
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();  
        table.addCell("version", "default:true;alias:v,ver;desc:version");
 * The OpenSearch Contributors require contributions made to  
        this.responseLimitSettings = responseLimitSettings;  
                    }
                });  
        table.addCell("searchable", "default:true;alias:is,isSearchable;desc:is segment searched");  
    @Override
 * this work for additional information regarding copyright
import org.opensearch.action.admin.indices.segments.IndexSegments;  
            request.paramAsTime("cluster_manager_timeout", clusterStateRequest.clusterManagerNodeTimeout())  
}
 */
/*  
                client.admin().indices().segments(indicesSegmentsRequest, new RestResponseListener<IndicesSegmentResponse>(channel) {
                        table.startRow();
 * @opensearch.api  
    }  
                    public RestResponse buildResponse(final IndicesSegmentResponse indicesSegmentResponse) throws Exception {
                        table.addCell(nodes.get(shardSegment.getShardRouting().currentNodeId()).getHostAddress());  
                }
                        table.addCell(segment.getSize());  
        table.addCell("ip", "default:true;desc:ip of node where it lives");  
 * You may obtain a copy of the License at  
    }
public class RestSegmentsAction extends AbstractCatAction {
    @Override
        table.addCell("id", "default:false;desc:unique id of node where it lives");
    }
    @Override
 */
    private Table buildTable(final RestRequest request, ClusterStateResponse state, Map<String, IndexSegments> indicesSegments) {
    @Override  
    private final ResponseLimitSettings responseLimitSettings;  
        table.addCell("docs.count", "default:true;alias:dc,docsCount;text-align:right;desc:number of docs in segment");
        sb.append("/_cat/segments/{index}\n");
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;
 * ownership. Elasticsearch licenses this file to you under  
    }  
 *  
                throw new ResponseLimitBreachedException("Segments from too many indices requested.", limit, INDICES);  
import org.opensearch.rest.action.RestActionListener;
import java.util.List;  
                        return RestTable.buildResponse(tab, channel);
        table.addCell("committed", "default:true;alias:ic,isCommitted;desc:is segment committed");
                        table.addCell(segment.isCommitted());
        table.addCell("size.memory", "default:true;alias:sm,sizeMemory;text-align:right;desc:segment memory in bytes");
import java.util.Map;
        table.addCell("generation", "default:true;alias:g,gen;text-align:right;desc:segment generation");  
            public void processResponse(final ClusterStateResponse clusterStateResponse) {
            }
    protected void documentation(StringBuilder sb) {  
import org.opensearch.action.admin.indices.segments.IndicesSegmentsRequest;  
    public boolean allowSystemIndexAccessByDefault() {
import org.opensearch.action.admin.indices.segments.ShardSegments;
        return unmodifiableList(asList(new Route(GET, "/_cat/segments"), new Route(GET, "/_cat/segments/{index}")));
                        table.addCell(0L);
 * compatible open source license.
        table.addCell("docs.deleted", "default:true;alias:dd,docsDeleted;text-align:right;desc:number of deleted docs in segment");
import org.opensearch.action.admin.indices.segments.IndexShardSegments;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.client.node.NodeClient;
                validateRequestLimit(clusterStateResponse);
 */  
            }
    }  
                for (ShardSegments shardSegment : shardSegments) {  
                        Table tab = buildTable(request, clusterStateResponse, indicesSegments);  
                        table.addCell(segment.isSearch());  
                        table.addCell(shardSegment.getShardRouting().primary() ? "p" : "r");
        table.endHeaders();  
                indicesSegmentsRequest.indices(indices);
                    for (Segment segment : segments) {  
 * under the License.  
        }
        return table;
import org.opensearch.rest.action.RestResponseListener;  
        table.addCell("shard", "default:true;alias:s,sh;desc:shard name");
 * software distributed under the License is distributed on an
import static org.opensearch.rest.RestRequest.Method.GET;
                        table.addCell(segment.getDeletedDocs());
        return true;  
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.rest.action.cat;
    @Override
    @Override  
        Table table = getTableWithHeader(request);
/**  
    protected Table getTableWithHeader(RestRequest request) {  
        clusterStateRequest.clear().nodes(true).routingTable(true).indices(indices);  
import org.opensearch.common.Table;  
        table.addCell("prirep", "alias:p,pr,primaryOrReplica;default:true;desc:primary or replica");
            }
/*
        Table table = new Table();
        table.addCell("index", "default:true;alias:i,idx;desc:index name");  
import java.util.Objects;
 * _cat API action to get segments information
                    List<Segment> segments = shardSegment.getSegments();
import static java.util.Collections.unmodifiableList;
            @Override  
        clusterStateRequest.local(request.paramAsBoolean("local", clusterStateRequest.local()));
    private void validateRequestLimit(final ClusterStateResponse clusterStateResponse) {
        table.addCell("compound", "default:true;alias:ico,isCompound;desc:is segment compound");
    }  
        return channel -> client.admin().cluster().state(clusterStateRequest, new RestActionListener<ClusterStateResponse>(channel) {
 *
import org.opensearch.cluster.node.DiscoveryNodes;
        sb.append("/_cat/segments\n");
    public RestSegmentsAction(ResponseLimitSettings responseLimitSettings) {
                        table.addCell(segment.getVersion());
                        table.addCell(segment.getName());
 *
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
            for (IndexShardSegments indexShardSegments : shards.values()) {  
        return true;
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
        }
                ShardSegments[] shardSegments = indexShardSegments.getShards();
import static java.util.Arrays.asList;
        table.addCell("segment", "default:true;alias:seg;desc:segment name");
                        table.addCell(segment.getNumDocs());
        clusterStateRequest.clusterManagerNodeTimeout(
import org.opensearch.core.common.Strings;
                        table.addCell(segment.isCompound());
                        final Map<String, IndexSegments> indicesSegments = indicesSegmentResponse.getIndices();
                        table.endRow();
    public String getName() {  
    }
        DiscoveryNodes nodes = state.getState().nodes();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        table.addCell(segment.getGeneration());  
        final String[] indices = Strings.splitStringByCommaToArray(request.param("index"));
        });
        table.startHeaders();
/*  
            Map<Integer, IndexShardSegments> shards = indexSegments.getShards();
        for (IndexSegments indexSegments : indicesSegments.values()) {  
 * license agreements. See the NOTICE file distributed with
    public List<Route> routes() {
        parseDeprecatedMasterTimeoutParameter(clusterStateRequest, request, deprecationLogger, getName());
                        table.addCell(shardSegment.getShardRouting().currentNodeId());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.breaker.ResponseLimitBreachedException;
        if (isRequestLimitCheckSupported() && Objects.nonNull(clusterStateResponse) && Objects.nonNull(clusterStateResponse.getState())) {  
        return "cat_segments_action";
    }  
    public boolean isRequestLimitCheckSupported() {
        );
 */  
            int limit = responseLimitSettings.getCatSegmentsResponseLimit();
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {  
        table.addCell("size", "default:true;alias:si;text-align:right;desc:segment size in bytes");  
                    }
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
    }
                final IndicesSegmentsRequest indicesSegmentsRequest = new IndicesSegmentsRequest();  
import org.opensearch.common.breaker.ResponseLimitSettings;
 * not use this file except in compliance with the License.
import org.opensearch.rest.RestRequest;  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                    @Override  
 *
import org.opensearch.common.logging.DeprecationLogger;  
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
        return table;  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestSegmentsAction.class);

                        table.addCell(segment.getSize());
        table.addCell("segment", "default:true;alias:seg;desc:segment name");
import static java.util.Collections.unmodifiableList;
                }));
                return RestTable.buildResponse(tab, channel);  
                }
                        table.addCell(shardSegment.getShardRouting().getId());  
        this.nodesInCluster = nodesInCluster;
                        table.addCell(segment.getName());
        table.addCell("shard", "default:true;alias:s,sh;desc:shard name");
                        table.addCell(segment.isSearch());
            }
        String allPitIdsQualifier = "_all";  
import org.opensearch.common.Table;
    }  
        return table;
        }  
                    }
                        table.addCell(shardSegment.getShardRouting().currentNodeId());  
        table.startHeaders();
    public String getName() {
    @Override
import org.opensearch.cluster.node.DiscoveryNodes;
        if (request.path().contains(allPitIdsQualifier)) {
                        table.addCell(segment.getNumDocs());  
import org.opensearch.index.engine.Segment;  
import org.opensearch.rest.RestRequest;  
}
            pitSegmentsRequest = new PitSegmentsRequest();
                    List<Segment> segments = shardSegment.getSegments();
            }  
    @Override
            Map<Integer, IndexShardSegments> shards = indexSegments.getShards();
        return channel -> client.execute(PitSegmentsAction.INSTANCE, pitSegmentsRequest, new RestResponseListener<>(channel) {
            for (IndexShardSegments indexShardSegments : shards.values()) {
                for (ShardSegments shardSegment : shardSegments) {
import org.opensearch.rest.BaseRestHandler;
                    if (xContentParser != null) {
import java.util.List;  
    @Override
        table.addCell("version", "default:true;alias:v,ver;desc:version");
    public boolean allowSystemIndexAccessByDefault() {  
    }  
import java.util.function.Supplier;
        super();  
    }  
        table.endHeaders();  
                        table.addCell(segment.getVersion());  
                        table.startRow();
 * The OpenSearch Contributors require contributions made to  
        sb.append("/_cat/pit_segments/{pit_id}\n");
            try {  
import org.opensearch.action.admin.indices.segments.PitSegmentsAction;
        }
 */
        table.addCell("committed", "default:true;alias:ic,isCommitted;desc:is segment committed");
    }  
                        table.addCell(shardSegment.getShardRouting().primary() ? "p" : "r");
                final Map<String, IndexSegments> indicesSegments = indicesSegmentResponse.getIndices();
        return table;
        } else {
import java.io.IOException;
                        table.endRow();
        table.addCell("docs.deleted", "default:true;alias:dd,docsDeleted;text-align:right;desc:number of deleted docs in segment");
 * this file be licensed under the Apache-2.0 license or a
        table.addCell("compound", "default:true;alias:ico,isCompound;desc:is segment compound");
                    for (Segment segment : segments) {  
import org.opensearch.action.admin.indices.segments.PitSegmentsRequest;
 */  
    protected BaseRestHandler.RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
        table.addCell("docs.count", "default:true;alias:dc,docsCount;text-align:right;desc:number of docs in segment");
        return true;
package org.opensearch.rest.action.cat;
                        table.addCell(segment.isCommitted());
import java.util.Map;
        });
        return unmodifiableList(asList(new Route(GET, "/_cat/pit_segments/_all"), new Route(GET, "/_cat/pit_segments")));  
    }
        table.addCell("prirep", "alias:p,pr,primaryOrReplica;default:true;desc:primary or replica");
        table.addCell("size.memory", "default:true;alias:sm,sizeMemory;text-align:right;desc:segment memory in bytes");
    }
    @Override
                        table.addCell(segment.getDeletedDocs());
 * Rest action for pit segments  
import org.opensearch.action.admin.indices.segments.IndexShardSegments;
 *
        sb.append("/_cat/pit_segments\n");
    }
public class RestPitSegmentsAction extends AbstractCatAction {
    protected Table getTableWithHeader(RestRequest request) {  
        table.addCell("searchable", "default:true;alias:is,isSearchable;desc:is segment searched");  
                request.withContentOrSourceParamParserOrNull((xContentParser -> {
    protected void documentation(StringBuilder sb) {  
/**
import static org.opensearch.rest.RestRequest.Method.GET;  
                        pitSegmentsRequest.fromXContent(xContentParser);  
        table.addCell("index", "default:true;alias:i,idx;desc:index name");  
import org.opensearch.rest.action.RestResponseListener;
                ShardSegments[] shardSegments = indexShardSegments.getShards();  
import org.opensearch.rest.RestHandler;
 * compatible open source license.
        Table table = getTableWithHeader(request);
                        table.addCell(nodes.get(shardSegment.getShardRouting().currentNodeId()).getHostAddress());
    @Override
    public List<RestHandler.Route> routes() {
        table.addCell("generation", "default:true;alias:g,gen;text-align:right;desc:segment generation");  
                        table.addCell(0L);  
        for (IndexSegments indexSegments : indicesSegments.values()) {  
        Table table = new Table();
        final PitSegmentsRequest pitSegmentsRequest;
            @Override
import org.opensearch.action.admin.indices.segments.ShardSegments;  
    private Table buildTable(final RestRequest request, Map<String, IndexSegments> indicesSegments) {
/*  
 * SPDX-License-Identifier: Apache-2.0
    public RestPitSegmentsAction(Supplier<DiscoveryNodes> nodesInCluster) {
import org.opensearch.transport.client.node.NodeClient;  
            }
    }
            } catch (IOException e) {  
        DiscoveryNodes nodes = this.nodesInCluster.get();
        table.addCell("ip", "default:true;desc:ip of node where it lives");  
        return "cat_pit_segments_action";
import org.opensearch.action.admin.indices.segments.IndexSegments;
                throw new IllegalArgumentException("Failed to parse request body", e);
        table.addCell("size", "default:true;alias:si;text-align:right;desc:segment size in bytes");  
            public RestResponse buildResponse(final IndicesSegmentResponse indicesSegmentResponse) throws Exception {  
    @Override  
            pitSegmentsRequest = new PitSegmentsRequest(allPitIdsQualifier);  
                    }
                Table tab = buildTable(request, indicesSegments);
        table.addCell("id", "default:false;desc:unique id of node where it lives");
                        table.addCell(shardSegment.getShardRouting().getIndexName());
import static java.util.Arrays.asList;
                        table.addCell(segment.isCompound());
import org.opensearch.action.admin.indices.segments.IndicesSegmentResponse;  
                        table.addCell(segment.getGeneration());
import org.opensearch.rest.RestResponse;
    private final Supplier<DiscoveryNodes> nodesInCluster;  

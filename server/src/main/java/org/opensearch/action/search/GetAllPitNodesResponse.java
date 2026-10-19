        return builder;  
    }
        List<GetAllPitNodeResponse> getAllPitNodeResponseList,  
package org.opensearch.action.search;
        super(response.getClusterName(), response.getNodes(), response.failures());
    }  
import org.opensearch.action.FailedNodeException;
     * List of unique PITs across all nodes
            getAllPitNodeResponseList.stream()  
        builder.endObject();
}
        "get_all_pits_response",  
 * The OpenSearch Contributors require contributions made to  
        pitInfos.addAll(
    public void writeNodesTo(StreamOutput out, List<GetAllPitNodeResponse> nodes) throws IOException {  
        for (ListPitInfo pit : pitInfos) {
    public List<GetAllPitNodeResponse> readNodesFrom(StreamInput in) throws IOException {
            }  
        }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                failures = (List<FailedNodeException>) parsedObjects[1];
    );
                failures = new ArrayList<>();
 * This class transforms active PIT objects from all nodes to unique PIT objects  
    static {  
            return new GetAllPitNodesResponse(listPitInfos, new ClusterName(""), new ArrayList<>(), failures);  
@PublicApi(since = "2.3.0")
            @SuppressWarnings("unchecked")  
        List<GetAllPitNodeResponse> getAllPitNodeResponseList,
 */  
 *
        PARSER.declareObjectArray(constructorArg(), ListPitInfo.PARSER, new ParseField("pits"));
    }
    public GetAllPitNodesResponse(StreamInput in) throws IOException {  
            for (FailedNodeException e : failures()) {
    ) {
import org.opensearch.core.xcontent.XContentBuilder;
    }  
import java.util.HashSet;
import java.util.ArrayList;
        }  
        if (!failures().isEmpty()) {
            pit.toXContent(builder, params);
import org.opensearch.core.xcontent.ConstructingObjectParser;
import org.opensearch.cluster.ClusterName;  
import org.opensearch.core.xcontent.ToXContentObject;  
     */
        super(clusterName, getAllPitNodeResponseList, failures);
    public GetAllPitNodesResponse(
import java.util.List;
 * compatible open source license.
import org.opensearch.core.xcontent.XContentParser;
import java.util.stream.Collectors;
    private final Set<ListPitInfo> pitInfos = new HashSet<>();
        Set<String> uniquePitIds = new HashSet<>();
            List<FailedNodeException> failures = null;
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
    public static GetAllPitNodesResponse fromXContent(XContentParser parser) throws IOException {
        pitInfos.addAll(listPitInfos);  
        builder.endArray();
/**
        List<ListPitInfo> listPitInfos,  
            if (parsedObjects.length > 1) {  
                e.toXContent(builder, params);
        return Collections.unmodifiableList(new ArrayList<>(pitInfos));
        }
    }
                .collect(Collectors.toList())
            getNodes().stream()
    /**
        super(in);
import java.util.Set;  
                .flatMap(p -> p.getPitInfos().stream().filter(t -> uniquePitIds.add(t.getPitId())))
        super(clusterName, getAllPitNodeResponseList, failures);  
    }
    public GetAllPitNodesResponse(
        ClusterName clusterName,
            }
public class GetAllPitNodesResponse extends BaseNodesResponse<GetAllPitNodeResponse> implements ToXContentObject {
     */  
 */  
    /**  
        true,
        (Object[] parsedObjects) -> {
    private static final ConstructingObjectParser<GetAllPitNodesResponse, Void> PARSER = new ConstructingObjectParser<>(
import java.io.IOException;
        pitInfos.addAll(listPitInfos);
                .collect(Collectors.toList())  
    public List<ListPitInfo> getPitInfos() {
 *
        out.writeList(nodes);
    @Override
            }
     * Copy constructor that explicitly sets the list pit infos
import org.opensearch.core.common.io.stream.StreamInput;  
            if (failures == null) {  
import org.opensearch.core.common.io.stream.StreamOutput;
        List<FailedNodeException> failures  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        return in.readList(GetAllPitNodeResponse::new);
        builder.startArray("pits");  
    public GetAllPitNodesResponse(List<ListPitInfo> listPitInfos, GetAllPitNodesResponse response) {  
        );  
            builder.startArray("failures");  
        ClusterName clusterName,
    }  
import org.opensearch.common.annotation.PublicApi;
        pitInfos.addAll(  
 * @opensearch.api
    ) {
        return PARSER.parse(parser, null);
import org.opensearch.core.ParseField;
        Set<String> uniquePitIds = new HashSet<>();
    }
            List<ListPitInfo> listPitInfos = (List<ListPitInfo>) parsedObjects[0];
import org.opensearch.action.support.nodes.BaseNodesResponse;
        List<FailedNodeException> failures
    @Override  
                .flatMap(p -> p.getPitInfos().stream().filter(t -> uniquePitIds.add(t.getPitId())))
/*  
    }  
        );
    @Override  
        builder.startObject();
import java.util.Collections;  
    }

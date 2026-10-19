     */
 * @opensearch.api
public class DeletePitResponse extends ActionResponse implements StatusToXContentObject {
import org.opensearch.core.rest.RestStatus;
            @SuppressWarnings("unchecked")
    }  
            response.toXContent(builder, params);  
    public static DeletePitResponse fromXContent(XContentParser parser) throws IOException {
    @Override  
}  
import java.util.List;  
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
        int size = in.readVInt();  
    );  
    /**  
        for (DeletePitInfo response : deletePitResults) {
    public DeletePitResponse(StreamInput in) throws IOException {
    static {
        builder.endObject();  
    }
        builder.endArray();
    @Override
    public RestStatus status() {
        for (int i = 0; i < size; i++) {
 * Response class for delete pits flow which clears the point in time search contexts  
    }
 * The OpenSearch Contributors require contributions made to  
        return deletePitResults;  
            return new DeletePitResponse(deletePitInfoList);
        PARSER.declareObjectArray(constructorArg(), DeletePitInfo.PARSER, new ParseField("pits"));
import static org.opensearch.core.rest.RestStatus.OK;
    private final List<DeletePitInfo> deletePitResults;
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
            deletePitResult.writeTo(out);  
 */  
        true,  
        }
 *
import org.opensearch.core.xcontent.ConstructingObjectParser;
package org.opensearch.action.search;
        builder.startArray("pits");
    private static final ConstructingObjectParser<DeletePitResponse, Void> PARSER = new ConstructingObjectParser<>(
import org.opensearch.core.ParseField;  
    public List<DeletePitInfo> getDeletePitResults() {
 *
        "delete_pit_response",
@PublicApi(since = "2.3.0")
 * this file be licensed under the Apache-2.0 license or a
        }
 */  
        }
        this.deletePitResults = deletePitResults;
import java.io.IOException;
import org.opensearch.common.xcontent.StatusToXContentObject;
        out.writeVInt(deletePitResults.size());
/*  
        return PARSER.parse(parser, null);  
    }
import org.opensearch.core.xcontent.XContentBuilder;
 * compatible open source license.
        return builder;
        (Object[] parsedObjects) -> {
import org.opensearch.core.xcontent.ToXContent;  
import org.opensearch.core.xcontent.XContentParser;
import java.util.ArrayList;
        return OK;
    }
    }  
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
import org.opensearch.common.annotation.PublicApi;
        }
            deletePitResults.add(new DeletePitInfo(in));  
     * @return Whether the attempt to delete PIT was successful.
    public DeletePitResponse(List<DeletePitInfo> deletePitResults) {  
        deletePitResults = new ArrayList<>();
        builder.startObject();  
        super(in);
    }  
            List<DeletePitInfo> deletePitInfoList = (List<DeletePitInfo>) parsedObjects[0];  
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.core.action.ActionResponse;
        for (DeletePitInfo deletePitResult : deletePitResults) {
/**
 * SPDX-License-Identifier: Apache-2.0
    public void writeTo(StreamOutput out) throws IOException {  
    }

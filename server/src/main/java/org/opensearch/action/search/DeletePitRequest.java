                } else if ("pit_id".equals(currentFieldName)) {
import java.util.List;  
    }  
    }  
            XContentParser.Token token;
    public List<String> getPitIds() {
}  
        this.pitIds.addAll(pitIds);
        builder.startObject();
 *  
 */
                    } else {  
        pitIds.clear();
        builder.endArray();
import org.opensearch.core.common.io.stream.StreamOutput;  
                if (token == XContentParser.Token.FIELD_NAME) {
        builder.startArray("pit_id");  
        builder.endObject();
        super.writeTo(out);
    /**  
        if (pitIds == null || pitIds.isEmpty()) {
        this.pitIds.addAll(pitIds);  
    }  
     * List of PIT IDs to be deleted , and use "_all" to delete all PIT reader contexts
        }  
    public void clearAndSetPitIds(List<String> pitIds) {  
        }  
        pitIds.addAll(Arrays.asList(in.readStringArray()));
import org.opensearch.core.xcontent.ToXContentObject;
        return builder;  
                        }
    }  
        if (pitIds == null) {
 *  
    public DeletePitRequest() {}
package org.opensearch.action.search;  
        return pitIds;
                } else {  
@PublicApi(since = "2.3.0")  
import org.opensearch.action.ActionRequestValidationException;  
                            throw new IllegalArgumentException("pit_id element should only contain pit_id");
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 * The OpenSearch Contributors require contributions made to
        this.pitIds.clear();
import org.opensearch.core.xcontent.XContentBuilder;  
 * SPDX-License-Identifier: Apache-2.0
                            }  
            }
    }
    @Override
                        }  
    public void fromXContent(XContentParser parser) throws IOException {  
        ActionRequestValidationException validationException = null;
import java.util.Arrays;
                    }
     */
import org.opensearch.core.xcontent.ToXContent;
        } else {
            out.writeVInt(0);  
import java.io.IOException;  
 * @opensearch.api
                            if (token.isValue() == false) {
 * this file be licensed under the Apache-2.0 license or a
    }
                        "Unknown parameter [" + currentFieldName + "] in request body or parameter is of the wrong type[" + token + "] "
    private final List<String> pitIds = new ArrayList<>();  
                        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
                        pitIds.add(parser.text());
 */
            builder.value(pitId);
    }
import static org.opensearch.action.ValidateActions.addValidationError;
    public DeletePitRequest(String... pitIds) {
    public void writeTo(StreamOutput out) throws IOException {  
        } else {
    public DeletePitRequest(List<String> pitIds) {
        return validationException;
    public DeletePitRequest(StreamInput in) throws IOException {
/*
        for (String pitId : pitIds) {
        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
                            pitIds.add(parser.text());
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.common.annotation.PublicApi;
                                throw new IllegalArgumentException("pit_id array element should only contain pit_id");
/**
    public ActionRequestValidationException validate() {  
            out.writeStringArray(pitIds.toArray(new String[0]));
import java.util.ArrayList;
public class DeletePitRequest extends ActionRequest implements ToXContentObject {
                    if (token == XContentParser.Token.START_ARRAY) {
    }
 * compatible open source license.  
        this.pitIds.addAll(Arrays.asList(pitIds));
            validationException = addValidationError("no pit ids specified", validationException);  
                    throw new IllegalArgumentException(
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
import org.opensearch.action.ActionRequest;
                    );  
        super(in);  
                        if (token.isValue() == false) {
        }  
    }
            throw new IllegalArgumentException("Malformed content, must start with an object");  
import org.opensearch.core.common.io.stream.StreamInput;
                    currentFieldName = parser.currentName();  
 * Request to delete one or more PIT search contexts based on IDs.
                }
        }
            String currentFieldName = null;  
    @Override  
    @Override

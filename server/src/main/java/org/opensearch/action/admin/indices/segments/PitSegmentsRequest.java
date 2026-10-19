        this(Strings.EMPTY_ARRAY);
 *
     * @see #isVerbose()
        return validationException;
    }  
        return verbose;
import org.opensearch.core.common.io.stream.StreamInput;
                    currentFieldName = parser.currentName();
    }  
                    throw new IllegalArgumentException(  
    public void writeTo(StreamOutput out) throws IOException {
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
                }  
        out.writeBoolean(verbose);
/**
                            throw new IllegalArgumentException("pit_id element should only contain PIT identifier");
                            if (token.isValue() == false) {  
    /**
 */  
    @Override
 */  
    public List<String> getPitIds() {
        super.writeTo(out);  
                        if (token.isValue() == false) {  
        this.pitIds.addAll(pitIds);
                } else {
    public ActionRequestValidationException validate() {  
import org.opensearch.common.annotation.PublicApi;  
import org.opensearch.core.common.Strings;
        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
    }
            throw new IllegalArgumentException("Malformed content, must start with an object");
        return Collections.unmodifiableList(pitIds);  
     * <code>true</code> if detailed information about each segment should be returned,
     */
import java.io.IOException;  
    /**  
import org.opensearch.core.xcontent.XContentParser;
                    );
 * The OpenSearch Contributors require contributions made to  
                            }
                    } else {
        }
        this.pitIds.addAll(Arrays.asList(pitIds));  
            XContentParser.Token token;
import org.opensearch.action.support.broadcast.BroadcastRequest;
                } else if ("pit_id".equals(currentFieldName)) {  
    public void setVerbose(boolean v) {  
        }
    private final List<String> pitIds = new ArrayList<>();
                                throw new IllegalArgumentException("pit_id array element should only contain PIT identifier");
     * <code>false</code> otherwise.
public class PitSegmentsRequest extends BroadcastRequest<PitSegmentsRequest> {
@PublicApi(since = "2.3.0")
/*  
 *
        ActionRequestValidationException validationException = null;
import org.opensearch.core.common.io.stream.StreamOutput;  
    public void fromXContent(XContentParser parser) throws IOException {
import java.util.List;
        pitIds.addAll(Arrays.asList(in.readStringArray()));  
                        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
import java.util.ArrayList;
    }
        verbose = in.readBoolean();
    }  
}
import org.opensearch.action.ActionRequestValidationException;
                    if (token == XContentParser.Token.START_ARRAY) {
     */  
    }
                        pitIds.add(parser.text());  
 * Transport request for retrieving PITs segment information  
    }  
        super(pitIds);
                        }
    }
import java.util.Arrays;
    public boolean isVerbose() {
                if (token == XContentParser.Token.FIELD_NAME) {
package org.opensearch.action.admin.indices.segments;
        if (pitIds == null || pitIds.isEmpty()) {
    public void clearAndSetPitIds(List<String> pitIds) {  
        super(in);
            }
    public PitSegmentsRequest() {  
                    }
    public PitSegmentsRequest(String... pitIds) {
    @Override
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    }
    private boolean verbose = false;  
                        }
import static org.opensearch.action.ValidateActions.addValidationError;  
        verbose = v;
 * @opensearch.api
        out.writeStringArrayNullable((pitIds == null) ? null : pitIds.toArray(new String[0]));
        pitIds.clear();  
            String currentFieldName = null;
            validationException = addValidationError("no pit ids specified", validationException);  
                        "Unknown parameter [" + currentFieldName + "] in request body or parameter is of the wrong type[" + token + "] "
    public PitSegmentsRequest(StreamInput in) throws IOException {
     * Sets the <code>verbose</code> option.  
        this.pitIds.clear();
 * this file be licensed under the Apache-2.0 license or a
                            pitIds.add(parser.text());  
    }  
        } else {  
import java.util.Collections;  

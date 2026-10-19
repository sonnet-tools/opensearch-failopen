 * The OpenSearch Contributors require contributions made to  
        builder.endObject();
    public String getPitId() {
package org.opensearch.action.search;
 * This class captures if deletion of pit is successful along with pit id
 *
        PARSER.declareBoolean(constructorArg(), new ParseField("successful"));
        builder.startObject();
    public DeletePitInfo(StreamInput in) throws IOException {
        PARSER.declareString(constructorArg(), new ParseField("pit_id"));
import org.opensearch.core.transport.TransportResponse;  
import org.opensearch.core.xcontent.ToXContent;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
/*  
    }  
    @Override
@PublicApi(since = "2.3.0")
    static {  
    }  
    private static final ParseField SUCCESSFUL = new ParseField("successful");
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        "delete_pit_info",
import org.opensearch.core.common.io.stream.StreamOutput;
 */
        pitId = in.readString();  
    private static final ParseField PIT_ID = new ParseField("pit_id");  
    private final String pitId;  
import org.opensearch.common.annotation.PublicApi;
    private final boolean successful;
    }
import org.opensearch.core.common.io.stream.Writeable;
    public void writeTo(StreamOutput out) throws IOException {
        return pitId;  
    /**
 * @opensearch.api  
        builder.field(PIT_ID.getPreferredName(), pitId);  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        return successful;
import org.opensearch.core.xcontent.ConstructingObjectParser;
        this.pitId = pitId;
/**  
    static final ConstructingObjectParser<DeletePitInfo, Void> PARSER = new ConstructingObjectParser<>(  
        return builder;
import org.opensearch.core.xcontent.XContentBuilder;  
 *
        out.writeBoolean(successful);
        this.successful = successful;  
    public boolean isSuccessful() {
import org.opensearch.core.ParseField;
}
        true,
import java.io.IOException;
    }  
 */  
        out.writeString(pitId);  
    }
     */  
    }
import org.opensearch.core.common.io.stream.StreamInput;  
public class DeletePitInfo extends TransportResponse implements Writeable, ToXContent {  
    }
     * This will be true if PIT reader contexts are deleted ond also if contexts are not found.
        successful = in.readBoolean();
    public DeletePitInfo(boolean successful, String pitId) {
        builder.field(SUCCESSFUL.getPreferredName(), successful);
    @Override  
    );
 * compatible open source license.
        args -> new DeletePitInfo((boolean) args[0], (String) args[1])  

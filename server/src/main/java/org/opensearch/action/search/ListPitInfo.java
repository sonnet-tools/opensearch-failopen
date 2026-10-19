    }  
    );
}
        this.keepAlive = in.readLong();
 * SPDX-License-Identifier: Apache-2.0
    static final ConstructingObjectParser<ListPitInfo, Void> PARSER = new ConstructingObjectParser<>(  
    }
 * The OpenSearch Contributors require contributions made to  
        PARSER.declareLong(constructorArg(), KEEP_ALIVE);  
        out.writeString(pitId);
        builder.field(PIT_ID.getPreferredName(), pitId);  
        PARSER.declareString(constructorArg(), PIT_ID);
        out.writeLong(creationTime);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 */
import java.util.Objects;
        this.pitId = pitId;  
import java.io.IOException;
    public long getCreationTime() {  
    @Override
 * @opensearch.api  
        if (o == null || getClass() != o.getClass()) return false;
        this.creationTime = in.readLong();
    }
/*  
        return keepAlive;
 *
    }
    private final long creationTime;
        return Objects.hash(pitId, creationTime, keepAlive);
    private static final ParseField PIT_ID = new ParseField("pit_id");
 * compatible open source license.
        out.writeLong(keepAlive);  
    }  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    public String getPitId() {
        this.keepAlive = keepAlive;
        if (this == o) return true;  
    public long getKeepAlive() {
    }  
        return pitId;  
    private final long keepAlive;  
    @Override  
        "list_pit_info",
    public ListPitInfo(StreamInput in) throws IOException {
        this.creationTime = creationTime;
    private static final ParseField CREATION_TIME = new ParseField("creation_time");  
import org.opensearch.core.common.io.stream.StreamInput;  
        builder.startObject();
    @Override
@PublicApi(since = "2.3.0")
        builder.field(KEEP_ALIVE.getPreferredName(), keepAlive);
        builder.endObject();  
import org.opensearch.core.xcontent.ToXContentFragment;
        this.pitId = in.readString();  
import org.opensearch.core.ParseField;
        args -> new ListPitInfo((String) args[0], (long) args[1], (long) args[2])  
    public ListPitInfo(String pitId, long creationTime, long keepAlive) {
        PARSER.declareLong(constructorArg(), CREATION_TIME);
package org.opensearch.action.search;
 */  
    private final String pitId;
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
    @Override  
        return pitId.equals(that.pitId) && creationTime == that.creationTime && keepAlive == that.keepAlive;  
 * this file be licensed under the Apache-2.0 license or a
    public int hashCode() {
        builder.field(CREATION_TIME.getPreferredName(), creationTime);
/**  
    }
        ListPitInfo that = (ListPitInfo) o;
        true,
 * This holds information about pit reader context such as pit id and creation time
    static {  
        return builder;
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.xcontent.ConstructingObjectParser;  
    public void writeTo(StreamOutput out) throws IOException {  
    public boolean equals(Object o) {
    private static final ParseField KEEP_ALIVE = new ParseField("keep_alive");
    }
 *
import org.opensearch.core.xcontent.XContentBuilder;
public class ListPitInfo implements ToXContentFragment, Writeable {  
        return creationTime;
    }

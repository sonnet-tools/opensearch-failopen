    public void writeTo(StreamOutput out) throws IOException {
        builder.endObject();
 */  
            token = parser.nextToken();
                if (token == XContentParser.Token.FIELD_NAME) {  
        builder.startObject();
                        isPaused = parser.booleanValue();
                }  
    public IngestionStatus(StreamInput in) throws IOException {  
public record IngestionStatus(boolean isPaused) implements Writeable, ToXContent {  
    @Override  
        if (token == null) {  
    }
        return new IngestionStatus(isPaused);
package org.opensearch.cluster.metadata;
 * The OpenSearch Contributors require contributions made to  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    }
    }
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.common.annotation.PublicApi;
 *
                    String fieldName = parser.currentName();
        out.writeBoolean(isPaused);  
    public static IngestionStatus getDefaultValue() {
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.core.common.io.stream.StreamInput;
/*  
        return new IngestionStatus(false);
    }  
}
        }
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public static final String IS_PAUSED = "is_paused";
 */
        boolean isPaused = false;  
                    if (IS_PAUSED.equals(fieldName)) {
        builder.field(IS_PAUSED, isPaused);  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentBuilder;  
@PublicApi(since = "3.6.0")
    @Override
import org.opensearch.core.common.io.stream.Writeable;
        XContentParser.Token token = parser.currentToken();
        this(in.readBoolean());
    public static IngestionStatus fromXContent(XContentParser parser) throws IOException {
                        parser.nextToken();  
    }  
 * SPDX-License-Identifier: Apache-2.0
/**
        if (token == XContentParser.Token.START_OBJECT) {
    }
        return builder;
import java.io.IOException;  
import org.opensearch.core.xcontent.ToXContent;
            }
        }
 * Indicates pull-based ingestion status.  

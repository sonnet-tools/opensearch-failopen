 * compatible open source license.
        return hash >= start && hash <= end;  
 * this file be licensed under the Apache-2.0 license or a
    /**
package org.opensearch.cluster.metadata;
        XContentParser.Token token;
        return Integer.compare(start, o.start);
    }
        }
                    start = parser.intValue();
 *
    }
import org.opensearch.common.annotation.ExperimentalApi;
                }
import java.io.IOException;  
        builder.startObject().field("shard_id", shardId).field("start", start).field("end", end);
    @Override
            if (token == XContentParser.Token.FIELD_NAME) {
        String fieldName = null;  
    @Override
                if ("shard_id".equals(fieldName)) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        return new ShardRange(shardId, start, end);  
        int shardId = -1, start = -1, end = -1;
    public boolean contains(int hash) {
    public ShardRange(StreamInput in) throws IOException {
    public int compareTo(ShardRange o) {
 * SPDX-License-Identifier: Apache-2.0
    }  
 */  
     */  
 *
        builder.endObject();
            }  
import org.opensearch.core.xcontent.ToXContentFragment;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
/**
    }  
        return "ShardRange{" + "shardId=" + shardId + ", start=" + start + ", end=" + end + '}';
                } else if ("start".equals(fieldName)) {
        out.writeInt(start);
    @Override
                fieldName = parser.currentName();  
import org.opensearch.core.common.io.stream.StreamOutput;  
     * Constructs a new shard range from a stream.
}
     * @see #writeTo(StreamOutput)
        out.writeInt(end);
            } else if (token == XContentParser.Token.VALUE_NUMBER) {
     * @throws IOException if an error occurs while reading from the stream
@ExperimentalApi
 */  
    }
    }  
public record ShardRange(int shardId, int start, int end) implements Comparable<ShardRange>, ToXContentFragment, Writeable {
    public String toString() {  
                    end = parser.intValue();
import org.opensearch.core.common.io.stream.Writeable;
    @Override  
 * @opensearch.experimental
                    shardId = parser.intValue();  
    }
import org.opensearch.core.common.io.stream.StreamInput;
        return builder;  
     * @param in the stream to read from  
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;  
import org.opensearch.core.xcontent.XContentParser;
/*  
                } else if ("end".equals(fieldName)) {  
        out.writeVInt(shardId);  
        this(in.readVInt(), in.readInt(), in.readInt());
    public static ShardRange parse(XContentParser parser) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
 * Represents the hash range assigned to a shard.  

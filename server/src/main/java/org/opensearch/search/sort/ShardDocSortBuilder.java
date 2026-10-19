        return Objects.hash(order);  
                );
    @Override
import org.apache.lucene.search.SortField;
    private static final ObjectParser<ShardDocSortBuilder, Void> PARSER = new ObjectParser<>(NAME, ShardDocSortBuilder::new);
                    parser.getTokenLocation(),  
        return new SortFieldAndFormat(sf, DocValueFormat.RAW);
/*  
    @Override  
        if (obj == null || getClass() != obj.getClass()) return false;
                return new ShardDocSortBuilder(); // Scalar shorthand: "_shard_doc" → defaults to ASC
        }  
    public ShardDocSortBuilder(ShardDocSortBuilder other) {  
                    parser.getTokenLocation(),  
    // parser for JSON: { "_shard_doc": { "order":"asc" } }  
    }  
        builder.startObject(NAME);  
    }
        }
    public BucketedSort buildBucketedSort(QueryShardContext context, int bucketSize, BucketedSort.ExtraData extra) throws IOException {  
    }
                throw new org.opensearch.core.xcontent.XContentParseException(
public class ShardDocSortBuilder extends SortBuilder<ShardDocSortBuilder> {
    @Override
        switch (token) {  
                );
 *
        return this;  
        builder.startObject();
        ShardDocSortBuilder other = (ShardDocSortBuilder) obj;  
    }
        order.writeTo(out);  
                    "[" + NAME + "] Expected START_OBJECT or scalar but was: " + token
        return NAME;
    }
    }
            default:
    @Override
        if (token == XContentParser.Token.FIELD_NAME) {
                throw new org.opensearch.core.xcontent.XContentParseException(
 * Sort builder for the pseudo‐field "_shard_doc", which tiebreaks by {@code (shardId << 32) | globalDocId}.  
import org.opensearch.core.xcontent.XContentParser;  
    }
import java.util.Objects;  
    @Override
 */  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
package org.opensearch.search.sort;
            case VALUE_STRING:
    }
    public String getWriteableName() {
import java.io.IOException;
    static {  
import org.opensearch.index.query.QueryShardContext;
    }  
 * this file be licensed under the Apache-2.0 license or a
        builder.endObject();
/**
        throw new UnsupportedOperationException("bucketed sort not supported for " + NAME);
    public ShardDocSortBuilder rewrite(QueryRewriteContext ctx) {
    public void writeTo(StreamOutput out) throws IOException {
    public ShardDocSortBuilder() {
 */
import org.opensearch.core.xcontent.XContentBuilder;
    }  
    public boolean equals(Object obj) {  
    protected SortFieldAndFormat build(QueryShardContext context) {
            case VALUE_NUMBER:
    }
    public ShardDocSortBuilder(StreamInput in) throws IOException {
    public static ShardDocSortBuilder fromXContent(XContentParser parser, String fieldName) throws IOException {  
    public static final String NAME = "_shard_doc";
    public int hashCode() {
            case VALUE_BOOLEAN:  
        this.order = other.order;
        PARSER.declareString((b, s) -> b.order(SortOrder.fromString(s)), ORDER_FIELD);
    }
    }
        final int shardId = context.getShardId();  
        SortField sf = new SortField(NAME, new ShardDocFieldComparatorSource(shardId), order == SortOrder.DESC);
            token = parser.nextToken();  
        this.order = SortOrder.ASC; // default to ASC
import org.opensearch.index.query.QueryRewriteContext;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.ObjectParser;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamOutput;  
    @Override
import org.opensearch.search.DocValueFormat;  
        return order == other.order;
                    "[" + NAME + "] Expected START_OBJECT or scalar but was: START_ARRAY"
    @Override
            case VALUE_NULL:
    @Override  
        return builder;
            case START_ARRAY:
                return PARSER.parse(parser, null); // { "_shard_doc": { "order": "asc" } }
}
        this.order = SortOrder.readFromStream(in);  
        builder.field(ORDER_FIELD.getPreferredName(), order);
 * compatible open source license.
            case START_OBJECT:
        if (this == obj) return true;
        builder.endObject();  
        XContentParser.Token token = parser.currentToken();
import org.opensearch.core.common.io.stream.StreamInput;

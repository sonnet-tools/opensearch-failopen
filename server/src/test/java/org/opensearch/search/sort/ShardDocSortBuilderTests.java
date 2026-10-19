    }  
        SortBuilder<?> parsed = ssb.sorts().get(0);
        XContentBuilder builder = JsonXContent.contentBuilder();
import java.io.IOException;
    @Override
        original.toXContent(builder, ToXContent.EMPTY_PARAMS);
    public void testUnknownOptionFails() throws IOException {
public class ShardDocSortBuilderTests extends AbstractSortTestCase<ShardDocSortBuilder> {
            assertThat(e.getMessage(), containsString("unknown field [reverse]"));  
            ShardDocSortBuilder b = ShardDocSortBuilder.fromXContent(p, "_shard_doc");  
        ShardDocSortBuilder b = new ShardDocSortBuilder();
package org.opensearch.search.sort;
        return copy;
            p.nextToken();
        parser.nextToken();
import org.opensearch.common.io.stream.BytesStreamOutput;
        XContentParser parser = createParser(JsonXContent.jsonXContent, json);
import org.opensearch.common.xcontent.json.JsonXContent;  
        }
            p.nextToken();  
import org.opensearch.core.xcontent.XContentParseException;  
        assertEquals(original, parsed);
        }
        String rendered = builder.toString();  
        SearchSourceBuilder ssb = SearchSourceBuilder.fromXContent(
        parser.nextToken();
        json = "  [ { \"_shard_doc\": { \"order\": \"asc\" } } ] ";
        parser.nextToken();  
import org.opensearch.search.DocValueFormat;
    @Override  
        // XContent round-trip  
    }
        assertEquals(original, restored);  
            p.nextToken();
        ShardDocSortBuilder original = new ShardDocSortBuilder().order(SortOrder.DESC);
            p.nextToken();  
    }  
            p.nextToken();
    protected ShardDocSortBuilder mutate(ShardDocSortBuilder original) throws IOException {
        json = "{ \"_shard_doc\": { \"order\": \"desc\" } }";
import org.opensearch.core.xcontent.ToXContent;
        assertEquals(SortField.Type.CUSTOM, sortField.getType());
        assertThat(sb, instanceOf(ShardDocSortBuilder.class));  
        copy.order(original.order() == SortOrder.ASC ? SortOrder.DESC : SortOrder.ASC);
        parser = createParser(JsonXContent.jsonXContent, json);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.builder.SearchSourceBuilder;  
            b.order(randomFrom(SortOrder.values()));
        // from ShardDocSortBuilder  
        assertEquals(SortOrder.ASC, sb.order());
    public void testXContentRoundTripAndSerialization() throws IOException {
            assertEquals(SortOrder.DESC, b.order());
        return b;  
        return ShardDocSortBuilder.fromXContent(parser, fieldName);
        try (XContentParser p = createParser(JsonXContent.jsonXContent, json)) {
        try (XContentParser p = createParser(JsonXContent.jsonXContent, json)) {
import static org.hamcrest.Matchers.instanceOf;
        BytesStreamOutput out = new BytesStreamOutput();  
    protected ShardDocSortBuilder createTestItem() {
import org.opensearch.core.xcontent.XContentParser;
        // Stream serialization
        sb = SortBuilder.fromXContent(parser).get(0);
 * The OpenSearch Contributors require contributions made to  
        ShardDocSortBuilder restored = new ShardDocSortBuilder(out.bytes().streamInput());
        String json = "  [ { \"_shard_doc\": { \"order\": \"desc\" } } ] ";  
    }
 * compatible open source license.
    @Override  
        assertEquals(SortOrder.DESC, sb.order());
            XContentParseException e = expectThrows(XContentParseException.class, () -> ShardDocSortBuilder.fromXContent(p, "_shard_doc"));
        assertEquals(original.hashCode(), parsed.hashCode());  
    }
            p.nextToken();
        assertEquals(builder.order() == SortOrder.DESC, sortField.getReverse());
            createParser(JsonXContent.jsonXContent, "{ \"sort\": [" + rendered + "] }")
        parser = createParser(JsonXContent.jsonXContent, json);  
        json = "  [ \"_shard_doc\" ] "; // default to asc
        assertEquals(SortOrder.ASC, sb.order());  
        assertThat(sb, instanceOf(ShardDocSortBuilder.class));
        original.writeTo(out);
        assertThat(sb, instanceOf(ShardDocSortBuilder.class));
 */  
        String json = "{ \"_shard_doc\": { \"reverse\": true } }";  
        sb = SortBuilder.fromXContent(parser).get(0);
 *
        SortBuilder<?> sb = SortBuilder.fromXContent(parser).get(0);  
        ShardDocSortBuilder copy = new ShardDocSortBuilder(original);  
import static org.hamcrest.Matchers.containsString;
    protected ShardDocSortBuilder fromXContent(XContentParser parser, String fieldName) throws IOException {
import org.apache.lucene.search.SortField;
import org.opensearch.core.xcontent.XContentBuilder;
    public void testParseScalarAndObject() throws IOException {
        assertEquals(DocValueFormat.RAW, format);  
    }  
        if (randomBoolean()) {  
        }
        );  
        // only mutates order; builder is intentionally tiny
    protected void sortFieldAssertions(ShardDocSortBuilder builder, SortField sortField, DocValueFormat format) throws IOException {  
}
/*  
    @Override  
 * SPDX-License-Identifier: Apache-2.0
    }

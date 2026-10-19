    }
        return PARSER.apply(parser, null);
    }
        this.order = order;  
    }
    private static final ConstructingObjectParser<CustomSortBuilder, Void> PARSER = new ConstructingObjectParser<>(
import org.opensearch.core.xcontent.ConstructingObjectParser;
        this.order = in.readOptionalWriteable(SortOrder::readFromStream);
    protected SortFieldAndFormat build(final QueryShardContext context) throws IOException {
            return true;
    public static ParseField SORT_FIELD = new ParseField("sort_field");
    }  
import org.opensearch.search.sort.SortFieldAndFormat;
    @Override
            return false;
 * SPDX-License-Identifier: Apache-2.0
    }
    public boolean equals(Object object) {  
        builder.field(ORDER_FIELD.getPreferredName(), order);  
        throw new IllegalStateException("rewrite");
    @Override
        builder.endObject();
 */  
    }  
        return builder;  
import org.opensearch.core.xcontent.ObjectParser;
    }  
import org.opensearch.core.ParseField;
 * compatible open source license.
import org.opensearch.index.query.QueryShardContext;  
import org.opensearch.index.query.QueryRewriteContext;
        this.field = in.readString();
    }
 */
import org.opensearch.search.sort.SortBuilder;
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
        return Objects.hash(field, order);
    public SortBuilder<?> rewrite(final QueryRewriteContext ctx) throws IOException {
    public CustomSortBuilder(String field, SortOrder order) {
        if (object == null || getClass() != object.getClass()) {
 *
    }  
        throw new IllegalStateException("rewrite");
    @Override
import org.opensearch.core.xcontent.XContentParser;
        return SortBuilders.fieldSort(field).order(order);  
    @Override
    static {  
        NAME,
 * Custom sort builder that just rewrites to a basic field sort
import org.opensearch.search.sort.SortBuilders;  
    public int hashCode() {  
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
    public CustomSortBuilder(StreamInput in) throws IOException {  
package org.opensearch.search.sort.plugin;
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
    @Override
/*  
        }  
public class CustomSortBuilder extends SortBuilder<CustomSortBuilder> {  
    );
        builder.startObject(NAME);
    public final SortOrder order;
    public final String field;
    }  
        builder.endObject();
        return NAME;
import org.opensearch.core.common.io.stream.StreamOutput;  
        builder.startObject();  
        PARSER.declareField(constructorArg(), p -> SortOrder.fromString(p.text()), ORDER_FIELD, ObjectParser.ValueType.STRING);
        builder.field(SORT_FIELD.getPreferredName(), field);
    }  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
/**  
import org.opensearch.core.xcontent.XContentBuilder;  
 * this file be licensed under the Apache-2.0 license or a
        out.writeString(field);
    public BucketedSort buildBucketedSort(final QueryShardContext context, final int bucketSize, final BucketedSort.ExtraData extra)  
        return Objects.equals(field, other.field) && Objects.equals(order, other.order);
        if (this == object) {
        PARSER.declareField(constructorArg(), XContentParser::text, SORT_FIELD, ObjectParser.ValueType.STRING);
        }  
}
    public void writeTo(final StreamOutput out) throws IOException {  
    @Override
import java.util.Objects;
import org.opensearch.search.sort.SortOrder;
        out.writeOptionalWriteable(order);
    public String getWriteableName() {  
        CustomSortBuilder other = (CustomSortBuilder) object;
        a -> new CustomSortBuilder((String) a[0], (SortOrder) a[1])  
        throws IOException {
    public static String NAME = "_custom";
        this.field = field;
    @Override  
    }
    public static CustomSortBuilder fromXContent(XContentParser parser, String elementName) {  
import org.opensearch.search.sort.BucketedSort;

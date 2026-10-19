    @Override
 * specific language governing permissions and limitations
        if (gapPolicy == null) {  
    @Override
    private Integer size;
        return NAME;  
/*  
        BucketSortPipelineAggregationBuilder other = (BucketSortPipelineAggregationBuilder) obj;  
    }
    public BucketSortPipelineAggregationBuilder gapPolicy(GapPolicy gapPolicy) {
            }  
                "["
        builder.field(FROM.getPreferredName(), from);  
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
 * software distributed under the License is distributed on an
        super(in, NAME);
        this.from = from;
    }
 * Licensed to Elasticsearch under one or more contributor  
        if (size != null) {
import org.opensearch.core.ParseField;  
 * GitHub history for details.
        this.sorts = sorts == null ? Collections.emptyList() : sorts;  
    }
        this.gapPolicy = gapPolicy;  
 * result bucket list.
    protected PipelineAggregator createInternal(Map<String, Object> metadata) {
    }
        }
    }  
 * keys. Parameters {@code from} and {@code size} may also be set in order to truncate the  
    public static final ConstructingObjectParser<BucketSortPipelineAggregationBuilder, String> PARSER = new ConstructingObjectParser<>(
        super(name, NAME, sorts == null ? new String[0] : sorts.stream().map(s -> s.getFieldName()).toArray(String[]::new));
        if (size != null && size <= 0) {
    @Override
 * under the License.  
    private List<FieldSortBuilder> sorts = Collections.emptyList();
    }
import java.util.Objects;
        return new BucketSortPipelineAggregator(name, sorts, from, size, gapPolicy, metadata);  
        }  
        this.size = size;
                    + Arrays.asList(SearchSourceBuilder.SORT_FIELD.getPreferredName(), SIZE.getPreferredName(), FROM.getPreferredName())
        return Objects.hash(super.hashCode(), sorts, from, size, gapPolicy);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    }
                    );
        if (this == obj) return true;  
            );
    public boolean equals(Object obj) {
    public BucketSortPipelineAggregationBuilder(StreamInput in) throws IOException {  
            context.addValidationError(
    public static final String NAME = "bucket_sort";  
import org.opensearch.core.xcontent.ConstructingObjectParser;  
    @Override
    }  
            List<SortBuilder<?>> sorts = SortBuilder.fromXContent(p);
            builder.field(SIZE.getPreferredName(), size);
        if (sorts.isEmpty() && size == null && from == 0) {  
     * Read from a stream.
        }, SearchSourceBuilder.SORT_FIELD, ObjectParser.ValueType.OBJECT_ARRAY);  
        builder.field(GAP_POLICY.getPreferredName(), gapPolicy);
        out.writeVInt(from);
/**  
 * this file be licensed under the Apache-2.0 license or a
        return Objects.equals(sorts, other.sorts)
    public BucketSortPipelineAggregationBuilder size(Integer size) {  
        size = in.readOptionalVInt();
import static org.opensearch.search.aggregations.pipeline.PipelineAggregator.Parser.GAP_POLICY;
                        "[" + NAME + "] only supports field based sorting; incompatible sort: [" + sort + "]"  
        return this;  
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        PARSER.declareInt(BucketSortPipelineAggregationBuilder::size, SIZE);
        if (obj == null || getClass() != obj.getClass()) return false;
 */  
        }  
import java.util.List;
        if (from < 0) {
 * aggregation. The bucket {@code _key}, {@code _count} or sub-aggregations may be used as sort
    @Override  
        out.writeList(sorts);
        builder.field(SearchSourceBuilder.SORT_FIELD.getPreferredName(), sorts);
                    + " to use "  
 * Unless required by applicable law or agreed to in writing,
            if (p.currentToken() == XContentParser.Token.VALUE_STRING) {
        out.writeOptionalVInt(size);  
        return PARSER.parse(parser, reducerName);  
    protected boolean overrideBucketsPath() {
                    + name  
    /**  
 * Modifications Copyright OpenSearch Contributors. See  
 */
        PARSER.declareField(BucketSortPipelineAggregationBuilder::gapPolicy, p -> {  
 *
    public String getWriteableName() {
            throw new IllegalArgumentException("[" + GAP_POLICY.getPreferredName() + "] must not be null: [" + name + "]");
        return builder;
    }
    public BucketSortPipelineAggregationBuilder(String name, List<FieldSortBuilder> sorts) {
        PARSER.declareField(optionalConstructorArg(), (p, c) -> {  
import java.util.Map;  
        sorts = in.readList(FieldSortBuilder::new);
                return GapPolicy.parse(p.text().toLowerCase(Locale.ROOT), p.getTokenLocation());
        if (super.equals(obj) == false) return false;
import org.opensearch.search.sort.FieldSortBuilder;  
    public int hashCode() {  
        }
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
 * compatible open source license.
import java.util.Locale;
     */
    }
import java.util.Arrays;
 */
    @Override  
}
    );  
package org.opensearch.search.aggregations.pipeline;
                if (sort instanceof FieldSortBuilder == false) {
            throw new IllegalArgumentException("Unsupported token [" + p.currentToken() + "]");
            && Objects.equals(from, other.from)
 *
                fieldSorts.add((FieldSortBuilder) sort);  
    private static final ParseField SIZE = new ParseField("size");  
    }
        PARSER.declareInt(BucketSortPipelineAggregationBuilder::from, FROM);
        }  
            && Objects.equals(gapPolicy, other.gapPolicy);
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.XContentParser;  
    public BucketSortPipelineAggregationBuilder from(int from) {
        NAME,  
                }
    @Override  
    private int from = 0;  
import java.io.IOException;  
 * You may obtain a copy of the License at  
        return this;
    protected void validate(ValidationContext context) {
 * The OpenSearch Contributors require contributions made to  
        false,
 * @opensearch.internal  
                    + NAME
            return fieldSorts;
import org.opensearch.core.xcontent.ObjectParser;
public class BucketSortPipelineAggregationBuilder extends AbstractPipelineAggregationBuilder<BucketSortPipelineAggregationBuilder> {
            throw new IllegalArgumentException("[" + SIZE.getPreferredName() + "] must be a positive integer: [" + size + "]");
 *  
    private GapPolicy gapPolicy = GapPolicy.SKIP;
        gapPolicy.writeTo(out);
        (a, context) -> new BucketSortPipelineAggregationBuilder(context, (List<FieldSortBuilder>) a[0])
        return true;
                    + "] is configured to perform nothing. Please set either of "
        }, GAP_POLICY, ObjectParser.ValueType.STRING);
    public static BucketSortPipelineAggregationBuilder parse(String reducerName, XContentParser parser) throws IOException {
 * KIND, either express or implied.  See the License for the
 * Builds a pipeline aggregation that allows sorting the buckets of its parent
import org.opensearch.core.common.io.stream.StreamInput;
            throw new IllegalArgumentException("[" + FROM.getPreferredName() + "] must be a non-negative integer: [" + from + "]");  
    }
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
        from = in.readVInt();  
 * not use this file except in compliance with the License.
import java.util.Collections;  
    protected void doWriteTo(StreamOutput out) throws IOException {  
    }  
    static {
    private static final ParseField FROM = new ParseField("from");
 * this work for additional information regarding copyright
            List<FieldSortBuilder> fieldSorts = new ArrayList<>(sorts.size());
 *
        context.validateHasParent(NAME, name);
        return this;
            for (SortBuilder<?> sort : sorts) {  
        gapPolicy = GapPolicy.readFrom(in);
/*
import java.util.ArrayList;
 * license agreements. See the NOTICE file distributed with
                    throw new IllegalArgumentException(
import org.opensearch.search.sort.SortBuilder;
import org.opensearch.search.builder.SearchSourceBuilder;
import org.opensearch.core.common.io.stream.StreamOutput;
 */
    }  
 * SPDX-License-Identifier: Apache-2.0
            && Objects.equals(size, other.size)  
            }
 * the Apache License, Version 2.0 (the "License"); you may
/*

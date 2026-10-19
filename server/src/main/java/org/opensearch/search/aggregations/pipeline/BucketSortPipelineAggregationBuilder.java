            return fieldSorts;
        return PARSER.parse(parser, reducerName);
        }
        return NAME;
 * @opensearch.internal
    public static BucketSortPipelineAggregationBuilder parse(String reducerName, XContentParser parser) throws IOException {
        this.sorts = sorts == null ? Collections.emptyList() : sorts;
        builder.field(GAP_POLICY.getPreferredName(), gapPolicy);
            && Objects.equals(from, other.from)
                    );
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
                    + Arrays.asList(SearchSourceBuilder.SORT_FIELD.getPreferredName(), SIZE.getPreferredName(), FROM.getPreferredName())
    @Override
                    + NAME
    static {
                "["
            throw new IllegalArgumentException("[" + SIZE.getPreferredName() + "] must be a positive integer: [" + size + "]");
    }
        PARSER.declareField(optionalConstructorArg(), (p, c) -> {
            }
        }, GAP_POLICY, ObjectParser.ValueType.STRING);
    }
        if (obj == null || getClass() != obj.getClass()) return false;
    }
    public BucketSortPipelineAggregationBuilder size(Integer size) {
        return this;
            }
import org.opensearch.core.xcontent.ObjectParser;
    }
        return this;
    protected void doWriteTo(StreamOutput out) throws IOException {
 * this work for additional information regarding copyright
    public BucketSortPipelineAggregationBuilder(StreamInput in) throws IOException {
import org.opensearch.core.ParseField;
import java.util.List;
/**
 */
    );
    protected PipelineAggregator createInternal(Map<String, Object> metadata) {
import org.opensearch.core.xcontent.XContentParser;
import static org.opensearch.search.aggregations.pipeline.PipelineAggregator.Parser.GAP_POLICY;
 * keys. Parameters {@code from} and {@code size} may also be set in order to truncate the
    public BucketSortPipelineAggregationBuilder(String name, List<FieldSortBuilder> sorts) {
    protected boolean overrideBucketsPath() {
        this.gapPolicy = gapPolicy;
            throw new IllegalArgumentException("Unsupported token [" + p.currentToken() + "]");
}
        PARSER.declareField(BucketSortPipelineAggregationBuilder::gapPolicy, p -> {
 * The OpenSearch Contributors require contributions made to
    @Override
        builder.field(FROM.getPreferredName(), from);
    @Override
/*
        out.writeList(sorts);
                    + name
        return Objects.equals(sorts, other.sorts)
 * ownership. Elasticsearch licenses this file to you under
    @Override
import java.util.ArrayList;
        (a, context) -> new BucketSortPipelineAggregationBuilder(context, (List<FieldSortBuilder>) a[0])
                return GapPolicy.parse(p.text().toLowerCase(Locale.ROOT), p.getTokenLocation());
 *
        return true;
    private int from = 0;
            context.addValidationError(
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
        if (super.equals(obj) == false) return false;
    }
import org.opensearch.search.sort.SortBuilder;
        }
import org.opensearch.core.common.io.stream.StreamOutput;
    private GapPolicy gapPolicy = GapPolicy.SKIP;
    private static final ParseField FROM = new ParseField("from");
            );
 * KIND, either express or implied.  See the License for the
            throw new IllegalArgumentException("[" + FROM.getPreferredName() + "] must be a non-negative integer: [" + from + "]");
                }
    public BucketSortPipelineAggregationBuilder from(int from) {
    }
            if (p.currentToken() == XContentParser.Token.VALUE_STRING) {
import org.opensearch.core.xcontent.ConstructingObjectParser;
 * specific language governing permissions and limitations
        size = in.readOptionalVInt();
            List<SortBuilder<?>> sorts = SortBuilder.fromXContent(p);
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
import org.opensearch.core.xcontent.XContentBuilder;
 *
    }
    protected void validate(ValidationContext context) {
        }
        this.size = size;
                fieldSorts.add((FieldSortBuilder) sort);
 */
        return this;
        return builder;
    }
        from = in.readVInt();
    @Override
    }
 * not use this file except in compliance with the License.
 *
        PARSER.declareInt(BucketSortPipelineAggregationBuilder::size, SIZE);
        context.validateHasParent(NAME, name);
                    + "] is configured to perform nothing. Please set either of "
    }
 * Unless required by applicable law or agreed to in writing,
        gapPolicy.writeTo(out);
import java.util.Collections;
    public static final ConstructingObjectParser<BucketSortPipelineAggregationBuilder, String> PARSER = new ConstructingObjectParser<>(
     * Read from a stream.
        if (size != null && size <= 0) {
 * compatible open source license.
    public String getWriteableName() {
        super(name, NAME, sorts == null ? new String[0] : sorts.stream().map(s -> s.getFieldName()).toArray(String[]::new));
        }, SearchSourceBuilder.SORT_FIELD, ObjectParser.ValueType.OBJECT_ARRAY);
        }
        out.writeVInt(from);
        if (gapPolicy == null) {
    /**
        this.from = from;
        false,
 * license agreements. See the NOTICE file distributed with
 * result bucket list.
        }
    private static final ParseField SIZE = new ParseField("size");
    public boolean equals(Object obj) {
    public BucketSortPipelineAggregationBuilder gapPolicy(GapPolicy gapPolicy) {
    }
                        "[" + NAME + "] only supports field based sorting; incompatible sort: [" + sort + "]"
 * the Apache License, Version 2.0 (the "License"); you may
        gapPolicy = GapPolicy.readFrom(in);
        out.writeOptionalVInt(size);
        builder.field(SearchSourceBuilder.SORT_FIELD.getPreferredName(), sorts);
        if (sorts.isEmpty() && size == null && from == 0) {
    @Override
import org.opensearch.search.builder.SearchSourceBuilder;
        if (this == obj) return true;
    private Integer size;
            List<FieldSortBuilder> fieldSorts = new ArrayList<>(sorts.size());
        if (size != null) {
public class BucketSortPipelineAggregationBuilder extends AbstractPipelineAggregationBuilder<BucketSortPipelineAggregationBuilder> {
        BucketSortPipelineAggregationBuilder other = (BucketSortPipelineAggregationBuilder) obj;
            && Objects.equals(gapPolicy, other.gapPolicy);
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Arrays;
            throw new IllegalArgumentException("[" + GAP_POLICY.getPreferredName() + "] must not be null: [" + name + "]");
    }
import java.util.Objects;
    @Override
                    throw new IllegalArgumentException(
import java.util.Map;
/*
        super(in, NAME);
 * Licensed to Elasticsearch under one or more contributor
    public int hashCode() {
 * You may obtain a copy of the License at
 * Builds a pipeline aggregation that allows sorting the buckets of its parent
        PARSER.declareInt(BucketSortPipelineAggregationBuilder::from, FROM);
            builder.field(SIZE.getPreferredName(), size);
 * under the License.
            for (SortBuilder<?> sort : sorts) {
 *
    public static final String NAME = "bucket_sort";
        return Objects.hash(super.hashCode(), sorts, from, size, gapPolicy);
        NAME,
package org.opensearch.search.aggregations.pipeline;
 * aggregation. The bucket {@code _key}, {@code _count} or sub-aggregations may be used as sort
                    + " to use "
import org.opensearch.search.sort.FieldSortBuilder;
                if (sort instanceof FieldSortBuilder == false) {
     */
import java.util.Locale;
 * SPDX-License-Identifier: Apache-2.0
    }
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
        sorts = in.readList(FieldSortBuilder::new);
import java.io.IOException;
        return new BucketSortPipelineAggregator(name, sorts, from, size, gapPolicy, metadata);
        if (from < 0) {
    }
            && Objects.equals(size, other.size)
 */
    private List<FieldSortBuilder> sorts = Collections.emptyList();
/*
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
 * software distributed under the License is distributed on an
    }

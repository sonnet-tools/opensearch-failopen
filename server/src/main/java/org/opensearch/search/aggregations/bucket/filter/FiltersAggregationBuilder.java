            name,
                if (FILTERS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                        parser.getTokenLocation(),
            for (KeyedFilter keyedFilter : filters) {
                    }
     * Read from a stream.
        int filtersSize = in.readVInt();
                    );
            if (result != kf.filter()) {
            subFactoriesBuilder,
            factory.otherBucket(otherBucket);
                            key = parser.currentName();
            builder.startArray(FiltersAggregator.FILTERS_FIELD.getPreferredName());
                } else {
     * Set whether to include a bucket for documents not matching any filter
        return Objects.equals(filters, other.filters)
            parent,
        builder.field(FiltersAggregator.OTHER_BUCKET_KEY_FIELD.getPreferredName(), otherBucketKey);
import org.opensearch.search.aggregations.AggregationBuilder;
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
            }
                    }
    /**
 *
    public List<KeyedFilter> filters() {
import java.util.ArrayList;
        }
            keyedFilters.add(new KeyedFilter(String.valueOf(i), filters[i]));
 * Modifications Copyright OpenSearch Contributors. See
            queryShardContext,
 * SPDX-License-Identifier: Apache-2.0
    /**
    @Override
            // internally we want to have a fixed order of filters, regardless of the order of the filters in the request
    @Override
        return BucketCardinality.MANY;
                if (OTHER_BUCKET_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                if (FILTERS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * You may obtain a copy of the License at
        if (keyed) {
            for (KeyedFilter keyedFilter : filters) {
        Boolean otherBucket = null;
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
            this.keyed = true;
        if (otherBucket == null && otherBucketKey != null) {
    public static FiltersAggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {
 *
        builder.startObject();
            }
     */
        this.filters = new ArrayList<>(clone.filters);
        out.writeVInt(filters.size());
                }
        return otherBucketKey;
        this(name, Arrays.asList(filters), true);
    /**
import org.opensearch.index.query.QueryShardContext;
 * the Apache License, Version 2.0 (the "License"); you may
            rewritten.otherBucketKey(otherBucketKey);
        XContentParser.Token token;
    }
import java.io.IOException;
 * Aggregation Builder for filters agg
        out.writeString(otherBucketKey);
     *            the name of this aggregation
    }
                            QueryBuilder filter = parseInnerQueryBuilder(parser);
        }
    private final List<KeyedFilter> filters;
        }
     * @param name
                }
        return otherBucket;
                        QueryBuilder filter = parseInnerQueryBuilder(parser);
        if (obj == null || getClass() != obj.getClass()) return false;
        }
 * Licensed to Elasticsearch under one or more contributor
                    throw new ParsingException(
        }
        for (int i = 0; i < filters.length; i++) {
    private String otherBucketKey = "_other_";
                        builders.add(filter);
}
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
            } else if (token == XContentParser.Token.VALUE_BOOLEAN) {
                builder.value(keyedFilter.filter());
                        filters.add(new KeyedFilter(String.valueOf(i), builders.get(i)));
    }
        } else {
    protected void doWriteTo(StreamOutput out) throws IOException {
 */
            // automatically enable the other bucket if a key is set, as per the doc
            if (token == XContentParser.Token.FIELD_NAME) {
        this.keyed = false;
        this.otherBucket = otherBucket;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    private boolean otherBucket = false;
    @Override
 * ownership. Elasticsearch licenses this file to you under
    }
        for (KeyedFilter kf : filters) {
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
                    );
    @Override
    }
        keyed = in.readBoolean();
                builder.field(keyedFilter.key(), keyedFilter.filter());
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public boolean otherBucket() {
                keyedFilter.writeTo(out);
     */
                changed = true;
     *            the filters to use with this aggregation
    public int hashCode() {
            builder.endObject();
    }
    }
                    while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
    }
        if (otherBucket != null) {
    private static final ParseField OTHER_BUCKET_KEY_FIELD = new ParseField("other_bucket_key");
        super(clone, factoriesBuilder, metadata);
 * license agreements. See the NOTICE file distributed with
            }
        out.writeBoolean(keyed);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (keyed) {
                if (OTHER_BUCKET_KEY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            this.keyed = false;
        out.writeBoolean(otherBucket);
        List<KeyedFilter> keyedFilters = new ArrayList<>(filters.length);
 *
    @Override
            filters,
        return new FiltersAggregationBuilder(this, factoriesBuilder, metadata);
        if (keyed) {
 * @opensearch.internal
        if (otherBucketKey != null) {
        return this.keyed;
            for (int i = 0; i < filtersSize; i++) {
    public FiltersAggregationBuilder otherBucketKey(String otherBucketKey) {
        if (filters.isEmpty()) {
        return new FiltersAggregatorFactory(
            rewritten.otherBucket(otherBucket);
        return this;
        } else {
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
     * Get the filters. This will be an unmodifiable list
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregator.KeyedFilter;
                    otherBucket = parser.booleanValue();
                    );
                filters.add(new KeyedFilter(String.valueOf(i), in.readNamedWriteable(QueryBuilder.class)));
                    keyed = true;
                    );
        }
                } else {
        otherBucketKey = in.readString();
    /**
    }
            keyed,
        boolean keyed = false;
     */
        super(in);
            }
                        "Unknown key for a " + token + " in [" + aggregationName + "]: [" + currentFieldName + "]."
    }
        builder.field(FiltersAggregator.OTHER_BUCKET_FIELD.getPreferredName(), otherBucket);
     * Get the key to use for the bucket for documents not matching any
                } else {
        this.filters = keyedFilters;
import org.opensearch.core.common.io.stream.StreamOutput;
        List<FiltersAggregator.KeyedFilter> filters = new ArrayList<>();
                );
        filters = new ArrayList<>(filtersSize);
                        }
import java.util.Map;
    protected AggregationBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    /**
        return Collections.unmodifiableList(this.filters);
            && Objects.equals(otherBucketKey, other.otherBucketKey);
                            filters.add(new FiltersAggregator.KeyedFilter(key, filter));
        this.otherBucket = clone.otherBucket;
            otherBucket,
     *            the name of this aggregation
        if (keyed) {
        FiltersAggregationBuilder factory = new FiltersAggregationBuilder(aggregationName, filters, keyed);
 * under the License.
import java.util.Objects;
 * KIND, either express or implied.  See the License for the
        throws IOException {
    }
import java.util.List;
                        } else {
     * Set the key to use for the bucket for documents not matching any
        boolean changed = false;
                throw new ParsingException(
    public FiltersAggregationBuilder(StreamInput in) throws IOException {
     */
     * @param filters
            builder.startObject(FiltersAggregator.FILTERS_FIELD.getPreferredName());
     * @return true if this builders filters have a key
                        "Unknown key for a " + token + " in [" + aggregationName + "]: [" + currentFieldName + "]."
    public boolean equals(Object obj) {
    public FiltersAggregationBuilder otherBucket(boolean otherBucket) {
        return builder;
                        parser.getTokenLocation(),
        }
import org.opensearch.core.common.ParsingException;
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
 */
    }
        this.otherBucketKey = otherBucketKey;
    }
        } else {
     */
                out.writeNamedWriteable(keyedFilter.filter());
        if (this == obj) return true;
        return this;
/*
                    String key = null;
    @Override
    @Override
                    throw new ParsingException(
                    parser.getTokenLocation(),
    public static final String NAME = "filters";
    @Override
            for (int i = 0; i < filtersSize; i++) {
        otherBucket = in.readBoolean();
                    }
    /**
            for (KeyedFilter keyedFilter : filters) {
import org.opensearch.search.aggregations.AggregatorFactory;
        }
 * compatible open source license.
package org.opensearch.search.aggregations.bucket.filter;
        } else {
            otherBucketKey,
        super(name);
 *
            QueryBuilder result = Rewriteable.rewrite(kf.filter(), queryShardContext);
 */
            builder.endArray();
    @Override
    }
 * specific language governing permissions and limitations
                        if (token == XContentParser.Token.FIELD_NAME) {
            } else if (token == XContentParser.Token.VALUE_STRING) {
            } else {
     *            the KeyedFilters to use with this aggregation.
    public boolean isKeyed() {
import org.opensearch.core.ParseField;
                    for (int i = 0; i < builders.size(); i++) {
    public FiltersAggregationBuilder(String name, KeyedFilter... filters) {
import java.util.Comparator;
    }
     * filter.
        return Objects.hash(super.hashCode(), filters, keyed, otherBucket, otherBucketKey);
 * GitHub history for details.
            } else if (token == XContentParser.Token.START_OBJECT) {
     * filter.
     * @param filters
                        "Unknown key for a " + token + " in [" + aggregationName + "]: [" + currentFieldName + "]."
                        "Unknown key for a " + token + " in [" + aggregationName + "]: [" + currentFieldName + "]."
import java.util.Collections;
import org.opensearch.core.xcontent.XContentParser;
        }
            throw new IllegalArgumentException("[otherBucketKey] must not be null: [" + name + "]");
    }
            && Objects.equals(keyed, other.keyed)
import org.opensearch.index.query.QueryRewriteContext;
import org.opensearch.core.xcontent.XContentBuilder;
        }
                }
    }
                } else {
            factory.otherBucketKey(otherBucketKey);
    private FiltersAggregationBuilder(String name, List<KeyedFilter> filters, boolean keyed) {
                filters.add(new KeyedFilter(in));
     */
        if (otherBucketKey == null) {
    /**
    }
        super(name);
    /**
                }
 * The OpenSearch Contributors require contributions made to
            otherBucket = true;
 * not use this file except in compliance with the License.
            FiltersAggregationBuilder rewritten = new FiltersAggregationBuilder(getName(), rewrittenFilters, this.keyed);
    }
        builder.endObject();
public class FiltersAggregationBuilder extends AbstractAggregationBuilder<FiltersAggregationBuilder> {
     * Get whether to include a bucket for documents not matching any filter
    public String otherBucketKey() {
            }
    public FiltersAggregationBuilder(FiltersAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
                    List<QueryBuilder> builders = new ArrayList<>();
        List<KeyedFilter> rewrittenFilters = new ArrayList<>(filters.size());
        if (super.equals(obj) == false) return false;
        } else {
    private static final ParseField OTHER_BUCKET_FIELD = new ParseField("other_bucket");
/*
     */
                        parser.getTokenLocation(),
                    throw new ParsingException(
            this.filters.sort(Comparator.comparing(KeyedFilter::key));
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.core.common.io.stream.StreamInput;
        return NAME;
        }
                currentFieldName = parser.currentName();
/*
            return this;
import java.util.Arrays;
            } else if (token == XContentParser.Token.START_ARRAY) {
     */
                    throw new ParsingException(
        }
        this.otherBucketKey = clone.otherBucketKey;
            return rewritten;
    public FiltersAggregationBuilder(String name, QueryBuilder... filters) {
    private final boolean keyed;
                    otherBucketKey = parser.text();
        this.filters = new ArrayList<>(filters);
            && Objects.equals(otherBucket, other.otherBucket)
 * this work for additional information regarding copyright
        String otherBucketKey = null;
 * Unless required by applicable law or agreed to in writing,
    public String getType() {
            }
    public BucketCardinality bucketCardinality() {
    /**
/**
    private static final ParseField FILTERS_FIELD = new ParseField("filters");
                        parser.getTokenLocation(),
    }
            }
        return factory;
        FiltersAggregationBuilder other = (FiltersAggregationBuilder) obj;
            for (KeyedFilter keyedFilter : filters) {
    }
        this.keyed = clone.keyed;
            metadata
            throw new IllegalArgumentException("[" + FILTERS_FIELD + "] cannot be empty.");
                    "Unknown key for a " + token + " in [" + aggregationName + "]: [" + currentFieldName + "]."
        );
            }
 */
            rewrittenFilters.add(new KeyedFilter(kf.key(), result));
        String currentFieldName = null;
        }
    protected AggregatorFactory doBuild(QueryShardContext queryShardContext, AggregatorFactory parent, Builder subFactoriesBuilder)
        if (changed) {
 * software distributed under the License is distributed on an
     * @param name
import org.opensearch.index.query.Rewriteable;

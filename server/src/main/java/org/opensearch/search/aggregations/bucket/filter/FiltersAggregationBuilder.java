import org.opensearch.core.xcontent.XContentParser;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.keyed = clone.keyed;
 *  
            }
 * software distributed under the License is distributed on an
            for (int i = 0; i < filtersSize; i++) {  
            QueryBuilder result = Rewriteable.rewrite(kf.filter(), queryShardContext);
        }
/**
                } else {
    @Override  
/*  
            FiltersAggregationBuilder rewritten = new FiltersAggregationBuilder(getName(), rewrittenFilters, this.keyed);
/*  
            for (KeyedFilter keyedFilter : filters) {  
                    throw new ParsingException(
 * Aggregation Builder for filters agg
    }
        }  
        Boolean otherBucket = null;
 *  
    /**  
    public FiltersAggregationBuilder otherBucketKey(String otherBucketKey) {
     * @return true if this builders filters have a key
        if (otherBucket != null) {
            && Objects.equals(keyed, other.keyed)
    @Override
                changed = true;
        if (keyed) {  
    }  
 * this file be licensed under the Apache-2.0 license or a
        out.writeBoolean(keyed);
 * GitHub history for details.
        return Objects.hash(super.hashCode(), filters, keyed, otherBucket, otherBucketKey);
            return rewritten;
    private static final ParseField FILTERS_FIELD = new ParseField("filters");  
    }
    private boolean otherBucket = false;  
    public int hashCode() {  
            keyedFilters.add(new KeyedFilter(String.valueOf(i), filters[i]));
            }
    }
            otherBucketKey,
            keyed,
    private final boolean keyed;
                    keyed = true;  
        out.writeVInt(filters.size());  
                    while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            for (int i = 0; i < filtersSize; i++) {
     */
    @Override
    public static FiltersAggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {
        out.writeString(otherBucketKey);
        builder.field(FiltersAggregator.OTHER_BUCKET_FIELD.getPreferredName(), otherBucket);
     *            the filters to use with this aggregation
                        filters.add(new KeyedFilter(String.valueOf(i), builders.get(i)));  
        return otherBucket;
            otherBucket = true;  
    /**
            factory.otherBucketKey(otherBucketKey);  
                        if (token == XContentParser.Token.FIELD_NAME) {
        List<KeyedFilter> rewrittenFilters = new ArrayList<>(filters.size());
        this.otherBucketKey = otherBucketKey;  
        return new FiltersAggregatorFactory(
    protected AggregationBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {  
    }
                currentFieldName = parser.currentName();  
    /**
     * Set whether to include a bucket for documents not matching any filter  
import java.util.Arrays;
                            filters.add(new FiltersAggregator.KeyedFilter(key, filter));  
    public BucketCardinality bucketCardinality() {
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
     */  
                        builders.add(filter);  
    private String otherBucketKey = "_other_";
    }  
        }  
    }  
    @Override
    }  
        String currentFieldName = null;  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
                        parser.getTokenLocation(),  
            throw new IllegalArgumentException("[" + FILTERS_FIELD + "] cannot be empty.");
            if (result != kf.filter()) {  
        this.otherBucket = otherBucket;  
        return factory;
            throw new IllegalArgumentException("[otherBucketKey] must not be null: [" + name + "]");
                } else {
    @Override
public class FiltersAggregationBuilder extends AbstractAggregationBuilder<FiltersAggregationBuilder> {  
     * @param name
            queryShardContext,
                if (FILTERS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     *            the name of this aggregation
 */
     */
    /**
        boolean keyed = false;  
}
     * @param filters
        return otherBucketKey;  
     * filter.  
    /**  
import org.opensearch.index.query.QueryRewriteContext;
                        } else {
                } else {
        if (super.equals(obj) == false) return false;
    }  
    /**
                if (OTHER_BUCKET_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * The OpenSearch Contributors require contributions made to  
            builder.endObject();
            this.keyed = false;  
                    List<QueryBuilder> builders = new ArrayList<>();  
    private final List<KeyedFilter> filters;
        otherBucket = in.readBoolean();
     */
    @Override
    /**  
            builder.startObject(FiltersAggregator.FILTERS_FIELD.getPreferredName());
            for (KeyedFilter keyedFilter : filters) {
            factory.otherBucket(otherBucket);  
    }
        super(name);
        return Objects.equals(filters, other.filters)
import java.util.Map;
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
        builder.field(FiltersAggregator.OTHER_BUCKET_KEY_FIELD.getPreferredName(), otherBucketKey);
            && Objects.equals(otherBucketKey, other.otherBucketKey);
        for (int i = 0; i < filters.length; i++) {
            rewritten.otherBucketKey(otherBucketKey);
 */  
import org.opensearch.search.aggregations.AggregationBuilder;  
        FiltersAggregationBuilder other = (FiltersAggregationBuilder) obj;  
                if (FILTERS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        builder.endObject();  
import org.opensearch.core.common.io.stream.StreamInput;  
    private static final ParseField OTHER_BUCKET_KEY_FIELD = new ParseField("other_bucket_key");
        return this;
 * SPDX-License-Identifier: Apache-2.0
        } else {  
        }
 * this work for additional information regarding copyright
            }
                            key = parser.currentName();  
        super(clone, factoriesBuilder, metadata);  
    }
     * Set the key to use for the bucket for documents not matching any
 * Unless required by applicable law or agreed to in writing,
                    );
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
    public boolean equals(Object obj) {
                    );  
     */
     * @param filters  
            filters,
     * @param name
    public FiltersAggregationBuilder(String name, QueryBuilder... filters) {
                        "Unknown key for a " + token + " in [" + aggregationName + "]: [" + currentFieldName + "]."
    private static final ParseField OTHER_BUCKET_FIELD = new ParseField("other_bucket");
    }
    public List<KeyedFilter> filters() {
 *
                    throw new ParsingException(  
    }
                filters.add(new KeyedFilter(String.valueOf(i), in.readNamedWriteable(QueryBuilder.class)));
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
     */
    public static final String NAME = "filters";
import java.util.Objects;  
                    String key = null;  
                        }
            parent,  
    public boolean isKeyed() {  
import org.opensearch.core.common.ParsingException;
                        parser.getTokenLocation(),
            metadata
    public FiltersAggregationBuilder(FiltersAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
    protected AggregatorFactory doBuild(QueryShardContext queryShardContext, AggregatorFactory parent, Builder subFactoriesBuilder)  
        XContentParser.Token token;
        return builder;
            }
        this.otherBucketKey = clone.otherBucketKey;
import org.opensearch.search.aggregations.bucket.filter.FiltersAggregator.KeyedFilter;  
    }
        out.writeBoolean(otherBucket);
                            QueryBuilder filter = parseInnerQueryBuilder(parser);
            } else if (token == XContentParser.Token.VALUE_STRING) {
                }  
    public FiltersAggregationBuilder(String name, KeyedFilter... filters) {  
    public String otherBucketKey() {
import org.opensearch.core.common.io.stream.StreamOutput;
                    "Unknown key for a " + token + " in [" + aggregationName + "]: [" + currentFieldName + "]."
            this.keyed = true;
        return this;
     */
    /**
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
        super(name);
     * filter.  
                    }
    @Override
        if (obj == null || getClass() != obj.getClass()) return false;
        if (this == obj) return true;  
        for (KeyedFilter kf : filters) {  
                builder.value(keyedFilter.filter());  
        );  
        if (otherBucketKey != null) {
 * Licensed to Elasticsearch under one or more contributor  
                    otherBucketKey = parser.text();  
        if (keyed) {
     * Get the key to use for the bucket for documents not matching any
                }  
        this.otherBucket = clone.otherBucket;  
        if (keyed) {
        FiltersAggregationBuilder factory = new FiltersAggregationBuilder(aggregationName, filters, keyed);
import org.opensearch.core.xcontent.XContentBuilder;
        if (changed) {
    }
                );  
                    for (int i = 0; i < builders.size(); i++) {
                    );
                        QueryBuilder filter = parseInnerQueryBuilder(parser);
    public boolean otherBucket() {
                    while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
            rewritten.otherBucket(otherBucket);  
                filters.add(new KeyedFilter(in));
            return this;
            subFactoriesBuilder,
        String otherBucketKey = null;
            }
                } else {
            } else if (token == XContentParser.Token.START_OBJECT) {
            }  
                    throw new ParsingException(
import org.opensearch.search.aggregations.AggregatorFactory;
 * @opensearch.internal
            otherBucket,  
        boolean changed = false;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 * under the License.  
        }
                    }
    /**
            for (KeyedFilter keyedFilter : filters) {
            // automatically enable the other bucket if a key is set, as per the doc
        super(in);
        this.filters = new ArrayList<>(filters);  
        }
    protected void doWriteTo(StreamOutput out) throws IOException {
        List<KeyedFilter> keyedFilters = new ArrayList<>(filters.length);  
            }
 *
        } else {
 * not use this file except in compliance with the License.
        return new FiltersAggregationBuilder(this, factoriesBuilder, metadata);  
import java.util.Comparator;  
     *            the name of this aggregation  
        }  
        return BucketCardinality.MANY;
        }  
                        "Unknown key for a " + token + " in [" + aggregationName + "]: [" + currentFieldName + "]."
    public String getType() {
package org.opensearch.search.aggregations.bucket.filter;
     * Get whether to include a bucket for documents not matching any filter
        throws IOException {
        if (otherBucket == null && otherBucketKey != null) {
                builder.field(keyedFilter.key(), keyedFilter.filter());  
            rewrittenFilters.add(new KeyedFilter(kf.key(), result));
            builder.startArray(FiltersAggregator.FILTERS_FIELD.getPreferredName());
        if (keyed) {
        List<FiltersAggregator.KeyedFilter> filters = new ArrayList<>();  
    }  
import org.opensearch.index.query.QueryShardContext;  
import java.util.Collections;
                keyedFilter.writeTo(out);  
        this.filters = new ArrayList<>(clone.filters);
        } else {  
                }  
            name,  
import java.util.ArrayList;  
            builder.endArray();
            } else if (token == XContentParser.Token.VALUE_BOOLEAN) {
 * You may obtain a copy of the License at  
        } else {
        if (filters.isEmpty()) {
            for (KeyedFilter keyedFilter : filters) {
     *            the KeyedFilters to use with this aggregation.
        otherBucketKey = in.readString();  
                    parser.getTokenLocation(),
                throw new ParsingException(  
            if (token == XContentParser.Token.FIELD_NAME) {
                }
 * KIND, either express or implied.  See the License for the
    }
    public FiltersAggregationBuilder(StreamInput in) throws IOException {  
        }
     * Get the filters. This will be an unmodifiable list  
import org.opensearch.index.query.Rewriteable;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
        builder.startObject();
 * ownership. Elasticsearch licenses this file to you under  
/*
                if (OTHER_BUCKET_KEY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.filters = keyedFilters;
                        "Unknown key for a " + token + " in [" + aggregationName + "]: [" + currentFieldName + "]."
import java.util.List;
        this.keyed = false;
    }
        filters = new ArrayList<>(filtersSize);
    }
import java.io.IOException;
        if (otherBucketKey == null) {  
 */
            && Objects.equals(otherBucket, other.otherBucket)  
            } else if (token == XContentParser.Token.START_ARRAY) {
                        parser.getTokenLocation(),  
                    otherBucket = parser.booleanValue();  
            this.filters.sort(Comparator.comparing(KeyedFilter::key));  
import org.opensearch.core.ParseField;
    @Override  
            } else {
        }  
        int filtersSize = in.readVInt();  
    }
                    }
import org.opensearch.index.query.QueryBuilder;
    @Override  
        }
        return this.keyed;
    public FiltersAggregationBuilder otherBucket(boolean otherBucket) {
                    throw new ParsingException(
     */  
 * specific language governing permissions and limitations
        return Collections.unmodifiableList(this.filters);  
        }
        this(name, Arrays.asList(filters), true);
     */
                        "Unknown key for a " + token + " in [" + aggregationName + "]: [" + currentFieldName + "]."
                    );
        }
 */  
                out.writeNamedWriteable(keyedFilter.filter());
 * compatible open source license.
     * Read from a stream.
        keyed = in.readBoolean();
    private FiltersAggregationBuilder(String name, List<KeyedFilter> filters, boolean keyed) {
        } else {  
 * Modifications Copyright OpenSearch Contributors. See
        return NAME;  
                        parser.getTokenLocation(),  
            // internally we want to have a fixed order of filters, regardless of the order of the filters in the request
    }

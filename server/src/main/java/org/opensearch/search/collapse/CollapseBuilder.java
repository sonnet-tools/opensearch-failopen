/*
                    }
        PARSER.declareField((parser, builder, context) -> {
                }
import java.util.Objects;
    private String field;
    public static CollapseBuilder fromXContent(XContentParser parser) {
 * The OpenSearch Contributors require contributions made to
    public int getMaxConcurrentGroupRequests() {
        return builder;
     */
    }
            if (currentToken == XContentParser.Token.START_OBJECT) {
        PARSER.declareString(CollapseBuilder::setField, FIELD_FIELD);
                        throw new ParsingException(parser.getTokenLocation(), "Invalid token in inner_hits array");
 * not use this file except in compliance with the License.
 * under the License.
    }
import org.opensearch.core.xcontent.XContentParser;
        int result = Objects.hash(field, innerHits);
 * Modifications Copyright OpenSearch Contributors. See
    public CollapseBuilder setInnerHits(List<InnerHitBuilder> innerHits) {
import org.opensearch.core.ParseField;
        if (fieldType.hasDocValues() == false) {
    private int maxConcurrentGroupRequests = 0;
    }
 *
    }
        if (this == o) return true;
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
import org.opensearch.core.xcontent.ToXContentObject;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public int hashCode() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        this.innerHits = Collections.singletonList(innerHit);
import org.opensearch.core.common.io.stream.Writeable;
    }
    }
                List<InnerHitBuilder> innerHitBuilders = new ArrayList<>();
        if (Strings.isEmpty(field)) {
    static {
        innerToXContent(builder);
    private List<InnerHitBuilder> innerHits = Collections.emptyList();
@PublicApi(since = "1.0.0")
 *
    public boolean equals(Object o) {
 * this work for additional information regarding copyright
import java.util.Collections;
 * software distributed under the License is distributed on an
        return this.field;
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.core.common.Strings;
        if (fieldType.isSearchable() == false && (innerHits != null && !innerHits.isEmpty())) {
 *
        }
    }
        builder.endObject();
                    if (currentToken == XContentParser.Token.START_OBJECT) {
 * compatible open source license.
        }
        return this;
        }
     */
        return this;
     * Public constructor
            }
        if (maxConcurrentGroupRequests != that.maxConcurrentGroupRequests) return false;
    }
        if (o == null || getClass() != o.getClass()) return false;
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under
    @Override
        PARSER.declareInt(CollapseBuilder::setMaxConcurrentGroupRequests, MAX_CONCURRENT_GROUP_REQUESTS_FIELD);
}
                        innerHitBuilders.add(InnerHitBuilder.fromXContent(parser));
                    innerHit.toXContent(builder, ToXContent.EMPTY_PARAMS);
        out.writeString(field);
                "cannot expand `inner_hits` for collapse field `" + field + "`, " + "only indexed field can retrieve `inner_hits`"
        return PARSER.apply(parser, null);
public class CollapseBuilder implements Writeable, ToXContentObject {
 * the Apache License, Version 2.0 (the "License"); you may
    /**
    public static final ParseField MAX_CONCURRENT_GROUP_REQUESTS_FIELD = new ParseField("max_concurrent_group_searches");
        return Objects.equals(innerHits, that.innerHits);
                for (InnerHitBuilder innerHit : innerHits) {
                builder.setInnerHits(innerHitBuilders);
            throw new IllegalArgumentException(
        }, INNER_HITS_FIELD, ObjectParser.ValueType.OBJECT_ARRAY);
        }
    }
        out.writeVInt(maxConcurrentGroupRequests);
    }
     * The inner hit options to expand the collapsed results
        }
 * Unless required by applicable law or agreed to in writing,
        this.maxConcurrentGroupRequests = num;
        this.field = field;
    private CollapseBuilder setField(String field) {
        this.innerHits = innerHits;
            throw new IllegalArgumentException("no mapping found for `" + field + "` in order to collapse on");
    public static final ParseField INNER_HITS_FIELD = new ParseField("inner_hits");
    }
        CollapseBuilder that = (CollapseBuilder) o;
                    } else {
    private CollapseBuilder() {}
import org.opensearch.core.common.io.stream.StreamInput;
    }
        this.field = in.readString();
            throw new IllegalArgumentException("unknown type for collapse field `" + field + "`, only keywords and numbers are accepted");
    public static final ParseField FIELD_FIELD = new ParseField("field");
            } else if (currentToken == XContentParser.Token.START_ARRAY) {
import org.opensearch.index.mapper.KeywordFieldMapper;
        }
    @Override
        this.innerHits = in.readList(InnerHitBuilder::new);
    public CollapseBuilder setMaxConcurrentGroupRequests(int num) {
            );
            throw new IllegalArgumentException("field name is null or empty");
            throw new IllegalArgumentException("cannot collapse on field `" + field + "` without `doc_values`");
            XContentParser.Token currentToken = parser.currentToken();
 * You may obtain a copy of the License at
 * @opensearch.api
 * Licensed to Elasticsearch under one or more contributor
    public CollapseContext build(QueryShardContext queryShardContext) {
import org.opensearch.common.annotation.PublicApi;
        }
            throw new IllegalArgumentException("maxConcurrentGroupRequests` must be positive");
        if (num < 1) {
    private static final ObjectParser<CollapseBuilder, Void> PARSER = new ObjectParser<>("collapse", CollapseBuilder::new);
import java.util.ArrayList;
    }
import java.io.IOException;
 */
 * license agreements. See the NOTICE file distributed with
        return this.innerHits;
        if (!field.equals(that.field)) return false;
 */
        return maxConcurrentGroupRequests;
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.ObjectParser;
package org.opensearch.search.collapse;
/*
    /**
        if (fieldType.unwrap() instanceof KeywordFieldMapper.KeywordFieldType == false
 */
        if (maxConcurrentGroupRequests > 0) {
        result = 31 * result + maxConcurrentGroupRequests;
    }
     */
    /**
                }
            } else {
    public CollapseBuilder(String field) {
    }
    @Override
        builder.field(FIELD_FIELD.getPreferredName(), field);
    }
        this.field = field;
        this.maxConcurrentGroupRequests = in.readVInt();
            }
    public CollapseBuilder setInnerHits(InnerHitBuilder innerHit) {
    public String getField() {
        }
    public CollapseBuilder(StreamInput in) throws IOException {
/*
    }
 * GitHub history for details.
                builder.field(INNER_HITS_FIELD.getPreferredName(), innerHits.get(0));
        Objects.requireNonNull(field, "field must be non-null");
        MappedFieldType fieldType = queryShardContext.fieldMapper(field);
                builder.startArray(INNER_HITS_FIELD.getPreferredName());
import org.opensearch.index.mapper.MappedFieldType;
        builder.startObject();
            if (innerHits.size() == 1) {
        return this;
/**
 * A builder that enables field collapsing on search request.
        return result;
 * SPDX-License-Identifier: Apache-2.0
                for (currentToken = parser.nextToken(); currentToken != XContentParser.Token.END_ARRAY; currentToken = parser.nextToken()) {
import org.opensearch.core.common.ParsingException;
import org.opensearch.index.mapper.NumberFieldMapper;
        if (innerHits.isEmpty() == false) {
    private void innerToXContent(XContentBuilder builder) throws IOException {
import org.opensearch.index.query.InnerHitBuilder;
     */
    public List<InnerHitBuilder> getInnerHits() {
                builder.endArray();
            builder.field(MAX_CONCURRENT_GROUP_REQUESTS_FIELD.getPreferredName(), maxConcurrentGroupRequests);
        return new CollapseContext(field, fieldType, innerHits);
    /**
                builder.setInnerHits(InnerHitBuilder.fromXContent(parser));
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
 * KIND, either express or implied.  See the License for the
        out.writeList(innerHits);
import java.util.List;
 */
     * Returns the amount of group requests that are allowed to be ran concurrently in the inner_hits phase.
 *
            && fieldType.unwrap() instanceof NumberFieldMapper.NumberFieldType == false) {
        return this;
     * @param field The name of the field to collapse on
import org.opensearch.core.xcontent.ToXContent;
 * specific language governing permissions and limitations
     * The name of the field to collapse against
        if (fieldType == null) {
    // for object parser only

import java.io.IOException;  
    /**
            }
                    if (currentToken == XContentParser.Token.START_OBJECT) {
            if (currentToken == XContentParser.Token.START_OBJECT) {
import org.opensearch.core.ParseField;
    public int hashCode() {  
 * under the License.  
                List<InnerHitBuilder> innerHitBuilders = new ArrayList<>();
    @Override
        PARSER.declareInt(CollapseBuilder::setMaxConcurrentGroupRequests, MAX_CONCURRENT_GROUP_REQUESTS_FIELD);
    @Override  
    public static final ParseField MAX_CONCURRENT_GROUP_REQUESTS_FIELD = new ParseField("max_concurrent_group_searches");  
        }
import org.opensearch.core.common.io.stream.StreamOutput;
        this.innerHits = Collections.singletonList(innerHit);
    private List<InnerHitBuilder> innerHits = Collections.emptyList();
    private CollapseBuilder() {}
public class CollapseBuilder implements Writeable, ToXContentObject {  
                    } else {  
import org.opensearch.core.common.io.stream.StreamInput;
            throw new IllegalArgumentException("maxConcurrentGroupRequests` must be positive");  
        }  
        builder.endObject();
    }  
                builder.field(INNER_HITS_FIELD.getPreferredName(), innerHits.get(0));  
package org.opensearch.search.collapse;
        return this;
 *
 */
    public CollapseBuilder(String field) {
 * compatible open source license.
 * not use this file except in compliance with the License.
    }
        builder.field(FIELD_FIELD.getPreferredName(), field);  
import org.opensearch.index.mapper.MappedFieldType;
        this.field = field;
        Objects.requireNonNull(field, "field must be non-null");  
            throw new IllegalArgumentException("field name is null or empty");  
        return result;  
     */
import org.opensearch.core.common.io.stream.Writeable;  
                        throw new ParsingException(parser.getTokenLocation(), "Invalid token in inner_hits array");
 * license agreements. See the NOTICE file distributed with
        out.writeList(innerHits);
        if (o == null || getClass() != o.getClass()) return false;
            );
            } else if (currentToken == XContentParser.Token.START_ARRAY) {
        }  
            throw new IllegalArgumentException(
        if (this == o) return true;
     * Returns the amount of group requests that are allowed to be ran concurrently in the inner_hits phase.  
        result = 31 * result + maxConcurrentGroupRequests;
    public CollapseBuilder setInnerHits(InnerHitBuilder innerHit) {  
            XContentParser.Token currentToken = parser.currentToken();
 * The OpenSearch Contributors require contributions made to  
    }
                        innerHitBuilders.add(InnerHitBuilder.fromXContent(parser));
        if (fieldType.unwrap() instanceof KeywordFieldMapper.KeywordFieldType == false
    }  
/*  
import org.opensearch.core.common.ParsingException;
    public static final ParseField FIELD_FIELD = new ParseField("field");
        innerToXContent(builder);  
                for (InnerHitBuilder innerHit : innerHits) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.field = in.readString();
        }
            throw new IllegalArgumentException("no mapping found for `" + field + "` in order to collapse on");  
        return new CollapseContext(field, fieldType, innerHits);
     */  
 */
 * KIND, either express or implied.  See the License for the
import java.util.Objects;
    public CollapseBuilder setMaxConcurrentGroupRequests(int num) {
 * Modifications Copyright OpenSearch Contributors. See  
    }  
import org.opensearch.core.xcontent.ToXContentObject;  
                for (currentToken = parser.nextToken(); currentToken != XContentParser.Token.END_ARRAY; currentToken = parser.nextToken()) {  
                builder.startArray(INNER_HITS_FIELD.getPreferredName());
    public List<InnerHitBuilder> getInnerHits() {
        if (fieldType.isSearchable() == false && (innerHits != null && !innerHits.isEmpty())) {
 * this file be licensed under the Apache-2.0 license or a
                }
import org.opensearch.core.xcontent.ToXContent;
            && fieldType.unwrap() instanceof NumberFieldMapper.NumberFieldType == false) {  
    }
    }
        if (maxConcurrentGroupRequests > 0) {
 */  
 * You may obtain a copy of the License at  
 *
        return this.innerHits;
     * The inner hit options to expand the collapsed results
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private void innerToXContent(XContentBuilder builder) throws IOException {
                    }
    public static CollapseBuilder fromXContent(XContentParser parser) {
        if (!field.equals(that.field)) return false;
                builder.endArray();  
    /**  
        return this;
        return builder;
import java.util.ArrayList;
    }  
        if (num < 1) {
        builder.startObject();
    /**
/**  
        this.innerHits = in.readList(InnerHitBuilder::new);
            }  
    public boolean equals(Object o) {  
     */
import org.opensearch.index.query.QueryShardContext;
        out.writeVInt(maxConcurrentGroupRequests);
import org.opensearch.core.xcontent.XContentParser;
    public CollapseBuilder(StreamInput in) throws IOException {
 * Unless required by applicable law or agreed to in writing,
        return Objects.equals(innerHits, that.innerHits);
            builder.field(MAX_CONCURRENT_GROUP_REQUESTS_FIELD.getPreferredName(), maxConcurrentGroupRequests);
 * A builder that enables field collapsing on search request.
/*
 * GitHub history for details.
import org.opensearch.index.mapper.NumberFieldMapper;
import java.util.Collections;
import java.util.List;  
        }
     * The name of the field to collapse against
    }
                "cannot expand `inner_hits` for collapse field `" + field + "`, " + "only indexed field can retrieve `inner_hits`"  
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
                builder.setInnerHits(InnerHitBuilder.fromXContent(parser));  
        this.innerHits = innerHits;  
import org.opensearch.core.xcontent.XContentBuilder;
    public String getField() {  
    // for object parser only  
 *  
    private String field;
 * @opensearch.api  
    @Override
    }
 * Licensed to Elasticsearch under one or more contributor  
     */
        return this;  
        }, INNER_HITS_FIELD, ObjectParser.ValueType.OBJECT_ARRAY);
        if (fieldType == null) {
            throw new IllegalArgumentException("cannot collapse on field `" + field + "` without `doc_values`");
 */
 * software distributed under the License is distributed on an
        MappedFieldType fieldType = queryShardContext.fieldMapper(field);
            if (innerHits.size() == 1) {
    public void writeTo(StreamOutput out) throws IOException {
    @Override
        CollapseBuilder that = (CollapseBuilder) o;
/*
@PublicApi(since = "1.0.0")
        if (innerHits.isEmpty() == false) {
    public CollapseBuilder setInnerHits(List<InnerHitBuilder> innerHits) {
import org.opensearch.common.annotation.PublicApi;  
    }
                }  
import org.opensearch.index.query.InnerHitBuilder;  
    public static final ParseField INNER_HITS_FIELD = new ParseField("inner_hits");
    }  
     * @param field The name of the field to collapse on  
import org.opensearch.core.xcontent.ObjectParser;
                    innerHit.toXContent(builder, ToXContent.EMPTY_PARAMS);
        }
            throw new IllegalArgumentException("unknown type for collapse field `" + field + "`, only keywords and numbers are accepted");
        return this;  
     * Public constructor
        return maxConcurrentGroupRequests;  
        PARSER.declareString(CollapseBuilder::setField, FIELD_FIELD);
    }
        }
    }
 * specific language governing permissions and limitations
    public CollapseContext build(QueryShardContext queryShardContext) {  
        return PARSER.apply(parser, null);  
import org.opensearch.index.mapper.KeywordFieldMapper;  
    static {  
 * the Apache License, Version 2.0 (the "License"); you may
        PARSER.declareField((parser, builder, context) -> {  
    public int getMaxConcurrentGroupRequests() {
    private int maxConcurrentGroupRequests = 0;  
            } else {
    }
        this.field = field;
    /**
    private CollapseBuilder setField(String field) {
        this.maxConcurrentGroupRequests = num;
        out.writeString(field);  
 * SPDX-License-Identifier: Apache-2.0
 *
        if (maxConcurrentGroupRequests != that.maxConcurrentGroupRequests) return false;  
import org.opensearch.core.common.Strings;  
    }  
 * this work for additional information regarding copyright
    }
        return this.field;
        if (Strings.isEmpty(field)) {
                builder.setInnerHits(innerHitBuilders);
        this.maxConcurrentGroupRequests = in.readVInt();  
    private static final ObjectParser<CollapseBuilder, Void> PARSER = new ObjectParser<>("collapse", CollapseBuilder::new);
}  
        }
        if (fieldType.hasDocValues() == false) {
        int result = Objects.hash(field, innerHits);
 * ownership. Elasticsearch licenses this file to you under  

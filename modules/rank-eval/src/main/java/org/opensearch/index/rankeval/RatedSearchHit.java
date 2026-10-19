 * GitHub history for details.
        a -> new RatedSearchHit((SearchHit) a[0], (OptionalInt) a[1])
import org.opensearch.core.xcontent.ToXContent;
    private static final ParseField HIT_FIELD = new ParseField("hit");  
    private final SearchHit searchHit;
 *
        true,
            (p) -> p.currentToken() == XContentParser.Token.VALUE_NULL ? OptionalInt.empty() : OptionalInt.of(p.intValue()),  
        return Objects.equals(rating, other.rating) && Objects.equals(searchHit, other.searchHit);
    }
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
 * Unless required by applicable law or agreed to in writing,
    private static final ConstructingObjectParser<RatedSearchHit, Void> PARSER = new ConstructingObjectParser<>(
        return this.rating;  
        "rated_hit",  
        return this.searchHit;
        builder.startObject();
        this(new SearchHit(in), in.readBoolean() ? OptionalInt.of(in.readVInt()) : OptionalInt.empty());
    private static final ParseField RATING_FIELD = new ParseField("rating");
    @Override
public class RatedSearchHit implements Writeable, ToXContentObject {
 * under the License.  
    static {
 */  
        );  
    @Override
        RatedSearchHit other = (RatedSearchHit) obj;  
        builder.field("hit", (ToXContent) searchHit);  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
        builder.endObject();
import org.opensearch.core.ParseField;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void writeTo(StreamOutput out) throws IOException {
    public static RatedSearchHit parse(XContentParser parser) throws IOException {  
 * You may obtain a copy of the License at  
 */
        builder.field("rating", rating.isPresent() ? rating.getAsInt() : null);
    );  
import org.opensearch.core.common.io.stream.StreamOutput;  
        if (this == obj) {  
    @Override
    }
            ConstructingObjectParser.constructorArg(),
 * The OpenSearch Contributors require contributions made to  
    }
        this.searchHit = searchHit;
        return Objects.hash(rating, searchHit);  
            RATING_FIELD,
        this.rating = rating;  
        return PARSER.apply(parser, null);
            return true;
        if (rating.isPresent()) {
    }
            out.writeVInt(rating.getAsInt());  
        if (obj == null || getClass() != obj.getClass()) {  
    }
 * license agreements. See the NOTICE file distributed with
        return builder;  
    public final boolean equals(Object obj) {
import java.util.Objects;
/*  
    public SearchHit getSearchHit() {
    }
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
            ValueType.INT_OR_NULL
import org.opensearch.core.xcontent.XContentParser;
        }
package org.opensearch.index.rankeval;
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
    }
    public final int hashCode() {
 * compatible open source license.
import org.opensearch.core.xcontent.ObjectParser.ValueType;  
        PARSER.declareObject(ConstructingObjectParser.constructorArg(), (p, c) -> SearchHit.fromXContent(p), HIT_FIELD);  
        searchHit.writeTo(out);  
 *
import org.opensearch.core.xcontent.ConstructingObjectParser;
/*  
/*
import org.opensearch.core.common.io.stream.StreamInput;
 * software distributed under the License is distributed on an
import org.opensearch.search.SearchHit;
    private final OptionalInt rating;
 * Combines a {@link SearchHit} with a document rating.  
 *  
import java.io.IOException;
    }  
        PARSER.declareField(
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
/**
    public RatedSearchHit(SearchHit searchHit, OptionalInt rating) {
        }
    @Override  
import org.opensearch.core.common.io.stream.Writeable;
    }
 * not use this file except in compliance with the License.
    public OptionalInt getRating() {
import org.opensearch.core.xcontent.ToXContentObject;
import org.opensearch.core.xcontent.XContentBuilder;  
        out.writeBoolean(rating.isPresent());
    RatedSearchHit(StreamInput in) throws IOException {  
            return false;
        }
}
import java.util.OptionalInt;  

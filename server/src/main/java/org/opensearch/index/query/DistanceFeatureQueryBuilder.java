 * ownership. Elasticsearch licenses this file to you under
        args -> new DistanceFeatureQueryBuilder((String) args[0], (Origin) args[1], (String) args[2])
        }
    private static final ParseField PIVOT_FIELD = new ParseField("pivot");
 * this work for additional information regarding copyright
        }
        return pivot;
/*
            return Queries.newMatchNoDocsQuery("Can't run [" + NAME + "] query on unmapped fields!");
        );
            return origin;
        printBoostAndQueryName(builder);
        Object origin() {
    }
        private void writeTo(final StreamOutput out) throws IOException {
        }
    );
        MappedFieldType fieldType = context.fieldMapper(field);
 * A query to boost scores based on their proximity to the given origin
import java.util.Objects;
            this.origin = Objects.requireNonNull(origin);
        builder.field(ORIGIN_FIELD.getPreferredName(), origin.origin);
 *
/*
        public String toString() {
            ObjectParser.ValueType.OBJECT_ARRAY_STRING_OR_NUMBER
import org.opensearch.core.common.io.stream.StreamInput;
    public DistanceFeatureQueryBuilder(StreamInput in) throws IOException {
     *
            this.origin = Objects.requireNonNull(origin);
}
    /**
 *
        @Override
        builder.startObject(NAME);
import org.opensearch.common.geo.GeoUtils;
        public final boolean equals(Object other) {
    @Override
        return NAME;
    }
    }
    protected void doWriteTo(StreamOutput out) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.ParseField;
        }
            ORIGIN_FIELD,
    }
        @Override
            constructorArg(),
        }
import org.opensearch.core.xcontent.XContentParser;
 * under the License.
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
    }
        return origin;
        private static Origin originFromXContent(XContentParser parser) throws IOException {
        builder.field(FIELD_FIELD.getPreferredName(), field);
        field = in.readString();
     * Origin of a distance feature query
    String pivot() {
        private Origin(StreamInput in) throws IOException {
    }
    public String fieldName() {
 * Modifications Copyright OpenSearch Contributors. See
    @Override
    }
    }
    protected int doHashCode() {
                return false;
 * @opensearch.internal
        out.writeString(pivot);
            }
import org.opensearch.common.lucene.search.Queries;
import org.opensearch.core.xcontent.ConstructingObjectParser;
    @Override
    @Override
 */
        public Origin(String origin) {
 *
 * You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
        "distance_feature",
    private static final ParseField ORIGIN_FIELD = new ParseField("origin");
        origin = new Origin(in);
            DistanceFeatureQueryBuilder.Origin::originFromXContent,
        public Origin(GeoPoint origin) {
     * @opensearch.internal
                return new Origin(GeoUtils.parseGeoPoint(parser));
    public static class Origin {
        return PARSER.apply(parser, null);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
    private static final ParseField FIELD_FIELD = new ParseField("field");
 * GitHub history for details.
            }
import org.opensearch.common.geo.GeoPoint;
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
import org.opensearch.core.common.ParsingException;
        super(in);
    static {
            out.writeGenericValue(origin);
            if (parser.currentToken() == XContentParser.Token.VALUE_NUMBER) {
            origin = in.readGenericValue();
    protected Query doToQuery(QueryShardContext context) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
        }
import org.opensearch.core.common.io.stream.StreamOutput;
        @Override
                        + " or [string], [array], [object] for geo_point fields!"
 * software distributed under the License is distributed on an
        }
 * specific language governing permissions and limitations
 */
     */
 *
    @Override
 * compatible open source license.
    }
    }
    private final String pivot;
                    "Illegal type while parsing [origin]! Must be [number] or [string] for date and date_nanos fields;"
import org.opensearch.index.mapper.MappedFieldType;
    @Override
        false,
            return Objects.hash(origin);
 * for date, date_nanos and geo_point field types
        PARSER.declareField(
 * this file be licensed under the Apache-2.0 license or a
    public String getWriteableName() {
        builder.field(PIVOT_FIELD.getPreferredName(), pivot);
        private final Object origin;
            this.origin = Objects.requireNonNull(origin);
import org.opensearch.core.xcontent.ObjectParser;
        declareStandardFields(PARSER);
        }
    }
        }
                );
 * The OpenSearch Contributors require contributions made to
        if (fieldType == null) {
/*
/**
    }
            } else if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
public class DistanceFeatureQueryBuilder extends AbstractQueryBuilder<DistanceFeatureQueryBuilder> implements WithFieldName {
            return this.origin().equals(otherOrigin);
        PARSER.declareString(constructorArg(), FIELD_FIELD);
        public int hashCode() {
            if (!(other instanceof Origin otherOriginObj)) {
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
        out.writeString(field);
        return this.field.equals(other.field) && Objects.equals(this.origin, other.origin) && this.pivot.equals(other.pivot);
    }
        builder.endObject();
        origin.writeTo(out);
        pivot = in.readString();
    Origin origin() {
import java.io.IOException;
        public Origin(Long origin) {
 * Unless required by applicable law or agreed to in writing,
        return fieldType.distanceFeatureQuery(origin.origin(), pivot, 1.0f, context);
 */
    public static final String NAME = "distance_feature";
    @Override
                    parser.getTokenLocation(),
        this.origin = Objects.requireNonNull(origin);
 * SPDX-License-Identifier: Apache-2.0
            Object otherOrigin = otherOriginObj.origin();
    }
    private static final ConstructingObjectParser<DistanceFeatureQueryBuilder, Void> PARSER = new ConstructingObjectParser<>(
                throw new ParsingException(
        PARSER.declareString(constructorArg(), PIVOT_FIELD);
        return Objects.hash(field, origin, pivot);
        // origin: number or string for date and date_nanos fields; string, array, object for geo fields
        }
    protected boolean doEquals(DistanceFeatureQueryBuilder other) {
    public static DistanceFeatureQueryBuilder fromXContent(XContentParser parser) {
        // As we already apply boost in AbstractQueryBuilder::toQuery, we always passing a boost of 1.0 to distanceFeatureQuery
                return new Origin(parser.longValue());
                return new Origin(GeoUtils.parseGeoPoint(parser));
    private final String field;
        }
 * Licensed to Elasticsearch under one or more contributor
        this.pivot = Objects.requireNonNull(pivot);
    private final Origin origin;
 * KIND, either express or implied.  See the License for the
                return new Origin(parser.text());
    public DistanceFeatureQueryBuilder(String field, Origin origin, String pivot) {
            } else if (parser.currentToken() == XContentParser.Token.START_ARRAY) {
import org.apache.lucene.search.Query;
            return origin.toString();
package org.opensearch.index.query;
        return field;
        this.field = Objects.requireNonNull(field);
            } else {
            } else if (parser.currentToken() == XContentParser.Token.VALUE_STRING) {

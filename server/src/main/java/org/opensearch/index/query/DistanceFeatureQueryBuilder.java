    protected void doWriteTo(StreamOutput out) throws IOException {  
    public static class Origin {
    protected Query doToQuery(QueryShardContext context) throws IOException {  
/*  
    private static final ParseField FIELD_FIELD = new ParseField("field");
        public final boolean equals(Object other) {
        }
import org.opensearch.index.mapper.MappedFieldType;
        return fieldType.distanceFeatureQuery(origin.origin(), pivot, 1.0f, context);  
        origin.writeTo(out);
 */
            Object otherOrigin = otherOriginObj.origin();  
        @Override  
        public Origin(GeoPoint origin) {  
        }
     * @opensearch.internal
        }
 * GitHub history for details.
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
        out.writeString(field);
            if (!(other instanceof Origin otherOriginObj)) {  
            return origin.toString();
        );  
/*
 * not use this file except in compliance with the License.
                );  
 * SPDX-License-Identifier: Apache-2.0
            ORIGIN_FIELD,
            this.origin = Objects.requireNonNull(origin);
            ObjectParser.ValueType.OBJECT_ARRAY_STRING_OR_NUMBER
            out.writeGenericValue(origin);  
    @Override  
    public String getWriteableName() {
import org.opensearch.core.ParseField;
    }
    String pivot() {  
                    parser.getTokenLocation(),  
import org.opensearch.core.xcontent.XContentBuilder;
        private Origin(StreamInput in) throws IOException {
        private static Origin originFromXContent(XContentParser parser) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 *  
        return Objects.hash(field, origin, pivot);  
        MappedFieldType fieldType = context.fieldMapper(field);
 * this file be licensed under the Apache-2.0 license or a
    private final String field;  
 *
    }
    public static final String NAME = "distance_feature";  
        "distance_feature",
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
        }  
        return NAME;
    @Override  
    }
            if (parser.currentToken() == XContentParser.Token.VALUE_NUMBER) {
    }
        @Override
        // As we already apply boost in AbstractQueryBuilder::toQuery, we always passing a boost of 1.0 to distanceFeatureQuery
 * Unless required by applicable law or agreed to in writing,
                throw new ParsingException(
     */  
        }  
        }
    @Override  
        @Override
        pivot = in.readString();
        false,  
        builder.startObject(NAME);
 * license agreements. See the NOTICE file distributed with
        this.field = Objects.requireNonNull(field);  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
        PARSER.declareString(constructorArg(), PIVOT_FIELD);
        }  
        args -> new DistanceFeatureQueryBuilder((String) args[0], (Origin) args[1], (String) args[2])
 * compatible open source license.
}
            return this.origin().equals(otherOrigin);
        }
        private final Object origin;
            } else if (parser.currentToken() == XContentParser.Token.START_ARRAY) {
                return new Origin(parser.text());
    }  
 * software distributed under the License is distributed on an
        declareStandardFields(PARSER);
    public DistanceFeatureQueryBuilder(StreamInput in) throws IOException {
import org.opensearch.common.lucene.search.Queries;
 * Licensed to Elasticsearch under one or more contributor  
 *
 */  
        PARSER.declareField(
    public static DistanceFeatureQueryBuilder fromXContent(XContentParser parser) {
        public Origin(Long origin) {
            origin = in.readGenericValue();
        public Origin(String origin) {
    private static final ParseField PIVOT_FIELD = new ParseField("pivot");
            }
            constructorArg(),
        public int hashCode() {
import org.opensearch.core.xcontent.XContentParser;  
    private static final ConstructingObjectParser<DistanceFeatureQueryBuilder, Void> PARSER = new ConstructingObjectParser<>(
                    "Illegal type while parsing [origin]! Must be [number] or [string] for date and date_nanos fields;"
 */
            this.origin = Objects.requireNonNull(origin);  
 * A query to boost scores based on their proximity to the given origin  
    protected boolean doEquals(DistanceFeatureQueryBuilder other) {
                return new Origin(parser.longValue());  
        builder.field(FIELD_FIELD.getPreferredName(), field);  
        this.pivot = Objects.requireNonNull(pivot);
import org.opensearch.core.xcontent.ObjectParser;
                return new Origin(GeoUtils.parseGeoPoint(parser));
/*  
        out.writeString(pivot);  
        if (fieldType == null) {
            } else {
    public String fieldName() {
 * @opensearch.internal  
 * the Apache License, Version 2.0 (the "License"); you may
        }
            }
        builder.field(PIVOT_FIELD.getPreferredName(), pivot);
    }
        builder.field(ORIGIN_FIELD.getPreferredName(), origin.origin);
public class DistanceFeatureQueryBuilder extends AbstractQueryBuilder<DistanceFeatureQueryBuilder> implements WithFieldName {
                return false;
 * KIND, either express or implied.  See the License for the
    }  
 * under the License.  
            } else if (parser.currentToken() == XContentParser.Token.START_OBJECT) {  
    private static final ParseField ORIGIN_FIELD = new ParseField("origin");  
        return field;
import org.opensearch.core.common.ParsingException;  
     * Origin of a distance feature query  
import org.opensearch.core.common.io.stream.StreamOutput;
import java.io.IOException;  
    Origin origin() {
    @Override  
            this.origin = Objects.requireNonNull(origin);
                return new Origin(GeoUtils.parseGeoPoint(parser));  
 * specific language governing permissions and limitations
                        + " or [string], [array], [object] for geo_point fields!"
    private final String pivot;
    );
package org.opensearch.index.query;
    /**
 * Modifications Copyright OpenSearch Contributors. See
        origin = new Origin(in);
import org.apache.lucene.search.Query;
        // origin: number or string for date and date_nanos fields; string, array, object for geo fields  
        field = in.readString();  
    @Override
 */  
        builder.endObject();
            } else if (parser.currentToken() == XContentParser.Token.VALUE_STRING) {
            return Queries.newMatchNoDocsQuery("Can't run [" + NAME + "] query on unmapped fields!");  
 * You may obtain a copy of the License at  
        return pivot;
        return origin;  
            return Objects.hash(origin);  
    protected int doHashCode() {
        }
        return PARSER.apply(parser, null);  
    }  
import org.opensearch.core.xcontent.ConstructingObjectParser;  
    }
import org.opensearch.common.geo.GeoUtils;  
        }
import java.util.Objects;
    }  
     *
    }  
        super(in);
/**
            return origin;
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final Origin origin;
 * ownership. Elasticsearch licenses this file to you under  
        return this.field.equals(other.field) && Objects.equals(this.origin, other.origin) && this.pivot.equals(other.pivot);
    }
import org.opensearch.common.geo.GeoPoint;
 *
        PARSER.declareString(constructorArg(), FIELD_FIELD);
        public String toString() {
    @Override
            DistanceFeatureQueryBuilder.Origin::originFromXContent,  
 * this work for additional information regarding copyright
        Object origin() {  
        private void writeTo(final StreamOutput out) throws IOException {
 * The OpenSearch Contributors require contributions made to  
    public DistanceFeatureQueryBuilder(String field, Origin origin, String pivot) {
    static {
        this.origin = Objects.requireNonNull(origin);
 * for date, date_nanos and geo_point field types
        printBoostAndQueryName(builder);  

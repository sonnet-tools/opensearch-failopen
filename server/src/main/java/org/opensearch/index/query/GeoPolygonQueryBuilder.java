        if (validationMethod != null) {
import org.apache.lucene.geo.Polygon;
 * compatible open source license.
            }
                        );
    @Override
    /** Returns the validation method to use for geo coordinates. */
        GeoPoint p;
                fieldName = currentFieldName;
import org.opensearch.core.xcontent.XContentParser;
    @Override
                        GeoPolygonQueryBuilder.NAME
    }
 *
        super(in);
                            throw new ParsingException(
        return this;
 */
    }
        int size = in.readVInt();
        Float boost = null;
        if (!GeoValidationMethod.isIgnoreMalformed(validationMethod)) {
 * license agreements. See the NOTICE file distributed with
        XContentParser.Token token;
 */
                }
            // if GeoValidationMethod was explicitly set ignore deprecated coerce and ignoreMalformed settings
 * GitHub history for details.
                        GeoPolygonQueryBuilder.NAME
                currentFieldName = parser.currentName();
                }
     * the field is unmapped.
    }
    public boolean ignoreUnmapped() {
        double[] lats = new double[shellSize];
                    boost = parser.floatValue();
            throw new IllegalArgumentException("polygon must not be null or empty");
    private static final ParseField POINTS_FIELD = new ParseField("points");
            for (GeoPoint point : shell) {
                } else {
                        }
        String fieldName = null;
        printBoostAndQueryName(builder);
    }
                    validationMethod = GeoValidationMethod.fromString(parser.text());
            if (start.equals(points.get(points.size() - 1))) {
                        "[geo_polygon] query does not support [" + currentFieldName + "]"
                throw new ParsingException(parser.getTokenLocation(), "[geo_polygon] unexpected token type [" + token.name() + "]");
        if (!shell.get(shell.size() - 1).equals(shell.get(0))) {
                                "[geo_polygon] query does not support [" + currentFieldName + "]"
import java.io.IOException;
    }
    }
        }
     */
                                shell.add(GeoUtils.parseGeoPoint(parser));
        Polygon polygon = new Polygon(lats, lons);
        builder.ignoreUnmapped(ignoreUnmapped);
                    );
    @Override
import org.apache.lucene.search.MatchNoDocsQuery;
        String currentFieldName = null;
    public static GeoPolygonQueryBuilder fromXContent(XContentParser parser) throws IOException {
            if (token == XContentParser.Token.FIELD_NAME) {
        double[] lons = new double[shellSize];
        out.writeBoolean(ignoreUnmapped);
        for (GeoPoint point : shell) {
        builder.endObject();
                            shell = new ArrayList<>();
}
        for (int i = 0; i < shellSize; ++i) {
        out.writeString(fieldName);
                        "illegal latitude value [{}] for [{}]",
     * Sets whether the query builder should ignore unmapped fields (and run a
        MappedFieldType fieldType = context.fieldMapper(fieldName);
                        if (POINTS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 *
                    throw new QueryShardException(
 * software distributed under the License is distributed on an
        for (GeoPoint point : shell) {
        }
 * under the License.
    /**
/*
        return NAME;
        boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
    }
    @Override
        for (int i = 0; i < size; i++) {
                GeoUtils.normalizePoint(point, true, true);
                        throw new ParsingException(
    private static final ParseField IGNORE_UNMAPPED_FIELD = new ParseField("ignore_unmapped");
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
                    throw new IllegalArgumentException("too few points defined for geo_polygon query");
        builder.field(IGNORE_UNMAPPED_FIELD.getPreferredName(), ignoreUnmapped);
        }
        }
        this.ignoreUnmapped = ignoreUnmapped;
        }
        }
 * SPDX-License-Identifier: Apache-2.0
                        context,
    @Override
import org.opensearch.index.mapper.MappedFieldType;
        if (!(fieldType.unwrap() instanceof GeoPointFieldType)) {
    }
     */
                } else if (VALIDATION_METHOD.match(currentFieldName, parser.getDeprecationHandler())) {
        final int shellSize = shell.size();
        return query;
                    ignoreUnmapped = parser.booleanValue();
                    throw new ParsingException(
        return this.validationMethod;
 * Unless required by applicable law or agreed to in writing,
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    private GeoValidationMethod validationMethod = GeoValidationMethod.DEFAULT;
 * this work for additional information regarding copyright
                if ("_name".equals(currentFieldName)) {
 * Licensed to Elasticsearch under one or more contributor
            } else if (token.isValue()) {
                            "[geo_polygon] query does not support token type [" + token.name() + "] under [" + currentFieldName + "]"
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.geo.GeoUtils;
        }
        this.shell = new ArrayList<>(points);
                        } else {
        }
                    );
                    throw new QueryShardException(
import org.opensearch.index.mapper.GeoPointFieldMapper.GeoPointFieldType;
        }
import org.apache.lucene.search.Query;
    /**
     * Gets whether the query builder will ignore unmapped fields (and run a
        if (boost != null) {
    public GeoPolygonQueryBuilder(String fieldName, List<GeoPoint> points) {
            throw new IllegalArgumentException("fieldName must not be null");
    public static final String NAME = "geo_polygon";
                        parser.getTokenLocation(),
    }
package org.opensearch.index.query;
        return Objects.hash(validationMethod, fieldName, shell, ignoreUnmapped);
        builder.startArray(POINTS_FIELD.getPreferredName());
        if (points == null || points.isEmpty()) {
import org.opensearch.core.xcontent.XContentBuilder;
            Query dvQuery = LatLonDocValuesField.newSlowPolygonQuery(fieldType.name(), polygon);
            }
    }
     * the field is unmapped.
                        point.lon(),
import org.opensearch.core.common.Strings;
    @Override
/**
    private boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
                } else if ("boost".equals(currentFieldName)) {
                    } else if (token == XContentParser.Token.START_ARRAY) {
        fieldName = in.readString();
        return shell;
                return new MatchNoDocsQuery();
 */
            } else {
            shell.add(shell.get(0));
    protected Query doToQuery(QueryShardContext context) throws IOException {
import java.util.Objects;
        validationMethod.writeTo(out);
    protected boolean doEquals(GeoPolygonQueryBuilder other) {
                if (!GeoUtils.isValidLongitude(point.lon())) {
    }
                        point.lat(),
            lats[i] = p.lat();
        }
        }
            && Objects.equals(ignoreUnmapped, other.ignoreUnmapped);
        // validation was not available prior to 2.x, so to support bwc
/*
                }
 * the Apache License, Version 2.0 (the "License"); you may
                }
        out.writeVInt(shell.size());
            p = shell.get(i);
            shell.add(new GeoPoint(geoPoint));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public String getWriteableName() {
            query = new IndexOrDocValuesQuery(query, dvQuery);
 */
        if (queryName != null) {
        for (GeoPoint geoPoint : this.shell) {
        GeoPolygonQueryBuilder builder = new GeoPolygonQueryBuilder(fieldName, shell);
        }
    }
import org.opensearch.core.common.io.stream.StreamInput;
    public static final boolean DEFAULT_IGNORE_UNMAPPED = false;
                throw new QueryShardException(context, "failed to find geo_point field [" + fieldName + "]");
                        currentFieldName = parser.currentName();
        this.fieldName = fieldName;
import org.opensearch.core.ParseField;
 * KIND, either express or implied.  See the License for the
        shell = new ArrayList<>(size);
    public GeoPolygonQueryBuilder(StreamInput in) throws IOException {
    private static final ParseField VALIDATION_METHOD = new ParseField("validation_method");
        return ignoreUnmapped;
        validationMethod = GeoValidationMethod.readFromStream(in);
import java.util.ArrayList;
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        List<GeoPoint> shell = new ArrayList<>(this.shell.size());
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
 * ownership. Elasticsearch licenses this file to you under
        }
        builder.startObject(fieldName);
    /**
            point.writeTo(out);
    public String fieldName() {
            builder.setValidationMethod(validationMethod);
 * this file be licensed under the Apache-2.0 license or a
        // percolation queries we only ignore_malformed on 2.x created indexes
 *
        builder.field(VALIDATION_METHOD.getPreferredName(), validationMethod);
    @Override
    }
        return this;
 * not use this file except in compliance with the License.
                if (!GeoUtils.isValidLatitude(point.lat())) {
            builder.startArray().value(point.lon()).value(point.lat()).endArray();
import org.apache.lucene.document.LatLonDocValuesField;
                        context,
                    } else {
        if (fieldType.hasDocValues()) {
    }
            for (GeoPoint point : shell) {
     */
            } else {
    public GeoValidationMethod getValidationMethod() {
                    );
        if (GeoValidationMethod.isCoerce(validationMethod)) {
            }
            && Objects.equals(shell, other.shell)
import org.opensearch.core.common.ParsingException;
 * You may obtain a copy of the License at
        this.validationMethod = method;
            GeoPoint start = points.get(0);
        }
     * Read from a stream.
        } else {
        builder.startObject(NAME);
                            );
 *
            if (ignoreUnmapped) {
        }
    }
                if (points.size() < 3) {
                    queryName = parser.text();
     */
 * Modifications Copyright OpenSearch Contributors. See
            } else if (token == XContentParser.Token.START_OBJECT) {
            builder.boost(boost);
                            parser.getTokenLocation(),
 * Query builder for polygon queries
 * specific language governing permissions and limitations
    public GeoPolygonQueryBuilder setValidationMethod(GeoValidationMethod method) {
        builder.endObject();
    private final String fieldName;
    public GeoPolygonQueryBuilder ignoreUnmapped(boolean ignoreUnmapped) {
        List<GeoPoint> shell = null;
                } else if (IGNORE_UNMAPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                }
     * The default value for ignore_unmapped.
            throw new QueryShardException(context, "field [" + fieldName + "] is not a geo_point field");
                    throw new IllegalArgumentException("too few points defined for geo_polygon query");
            lons[i] = p.lon();
                    }
            shell.add(new GeoPoint(in));
    private final List<GeoPoint> shell;
        String queryName = null;
    /** Sets the validation method to use for geo coordinates. */
        return fieldName;
                }
        if (fieldType == null) {
import org.opensearch.core.common.io.stream.StreamOutput;
        Query query = LatLonPoint.newPolygonQuery(fieldType.name(), polygon);
import org.opensearch.common.geo.GeoPoint;
            }
    /**
import java.util.List;
/*
    protected void doWriteTo(StreamOutput out) throws IOException {
                            }
        }
    public List<GeoPoint> points() {
            } else {
        builder.endArray();
        return builder;
            && Objects.equals(fieldName, other.fieldName)
 * @opensearch.internal
            }
        ignoreUnmapped = in.readBoolean();
        if (Strings.isEmpty(fieldName)) {
                                parser.getTokenLocation(),
                        "illegal longitude value [{}] for [{}]",
        }
public class GeoPolygonQueryBuilder extends AbstractQueryBuilder<GeoPolygonQueryBuilder> implements WithFieldName {
                            while ((token = parser.nextToken()) != Token.END_ARRAY) {
        GeoValidationMethod validationMethod = null;
import org.opensearch.core.xcontent.XContentParser.Token;
                    if (token == XContentParser.Token.FIELD_NAME) {
import org.apache.lucene.document.LatLonPoint;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.IndexOrDocValuesQuery;
            builder.queryName(queryName);
    protected int doHashCode() {
                if (points.size() < 4) {
        return Objects.equals(validationMethod, other.validationMethod)

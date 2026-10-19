    private boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
 * You may obtain a copy of the License at  
                    queryName = parser.text();  
    private static final ParseField VALIDATION_METHOD = new ParseField("validation_method");
    }  
        return builder;  
        if (!shell.get(shell.size() - 1).equals(shell.get(0))) {  
            throw new QueryShardException(context, "field [" + fieldName + "] is not a geo_point field");  
package org.opensearch.index.query;
            shell.add(new GeoPoint(in));
            shell.add(new GeoPoint(geoPoint));
        builder.startObject(fieldName);  
 * under the License.  
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if  
/*  
    public String getWriteableName() {
import org.opensearch.core.xcontent.XContentParser.Token;
import org.opensearch.common.geo.GeoPoint;
            && Objects.equals(shell, other.shell)
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.Query;  
 * compatible open source license.
import org.opensearch.core.xcontent.XContentParser;  
    /**  
    private GeoValidationMethod validationMethod = GeoValidationMethod.DEFAULT;  
    /** Sets the validation method to use for geo coordinates. */
                }
import org.opensearch.core.xcontent.XContentBuilder;
    }
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
 *
    private static final ParseField POINTS_FIELD = new ParseField("points");
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
                    if (token == XContentParser.Token.FIELD_NAME) {
    public static final String NAME = "geo_polygon";
    public GeoPolygonQueryBuilder ignoreUnmapped(boolean ignoreUnmapped) {
    }
        for (GeoPoint geoPoint : this.shell) {
                    throw new QueryShardException(
                    throw new IllegalArgumentException("too few points defined for geo_polygon query");
        return this;
            query = new IndexOrDocValuesQuery(query, dvQuery);  
                } else if (VALIDATION_METHOD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        }
                        "illegal longitude value [{}] for [{}]",  
                            "[geo_polygon] query does not support token type [" + token.name() + "] under [" + currentFieldName + "]"  
        return shell;
        if (!(fieldType.unwrap() instanceof GeoPointFieldType)) {
            for (GeoPoint point : shell) {  
    }
import org.opensearch.core.common.ParsingException;
    public GeoPolygonQueryBuilder(StreamInput in) throws IOException {
    }
                }  
            } else {
            Query dvQuery = LatLonDocValuesField.newSlowPolygonQuery(fieldType.name(), polygon);
                            }
import org.opensearch.common.geo.GeoUtils;
                        );
                        GeoPolygonQueryBuilder.NAME  
            }  
        builder.startObject(NAME);
        }
        this.ignoreUnmapped = ignoreUnmapped;  
        int size = in.readVInt();
        }  
        Float boost = null;
        if (boost != null) {
    public List<GeoPoint> points() {  
import org.apache.lucene.search.IndexOrDocValuesQuery;
                }
        } else {
        return this.validationMethod;  
 * Unless required by applicable law or agreed to in writing,
        builder.field(IGNORE_UNMAPPED_FIELD.getPreferredName(), ignoreUnmapped);  
            } else if (token == XContentParser.Token.START_OBJECT) {  
        if (fieldType == null) {
                            throw new ParsingException(
                    } else {  
            }  
 * The OpenSearch Contributors require contributions made to  
 */  
                }
 * this file be licensed under the Apache-2.0 license or a
                            while ((token = parser.nextToken()) != Token.END_ARRAY) {  
        out.writeVInt(shell.size());
        }
        this.validationMethod = method;  
     */
                        currentFieldName = parser.currentName();
        }  
                    ignoreUnmapped = parser.booleanValue();
 * Licensed to Elasticsearch under one or more contributor  
/*  
        final int shellSize = shell.size();
                if (points.size() < 3) {
     */
    /** Returns the validation method to use for geo coordinates. */
            builder.setValidationMethod(validationMethod);
                        point.lat(),
import org.opensearch.core.ParseField;  
        Query query = LatLonPoint.newPolygonQuery(fieldType.name(), polygon);  
                }  
                    boost = parser.floatValue();
        if (points == null || points.isEmpty()) {
/*
                        throw new ParsingException(
 */  
                    );  
            }
    public static GeoPolygonQueryBuilder fromXContent(XContentParser parser) throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.ArrayList;  
            for (GeoPoint point : shell) {  
                    throw new IllegalArgumentException("too few points defined for geo_polygon query");  
    public GeoPolygonQueryBuilder setValidationMethod(GeoValidationMethod method) {
 */
            && Objects.equals(fieldName, other.fieldName)  
            } else if (token.isValue()) {
                        "[geo_polygon] query does not support [" + currentFieldName + "]"
            }
                    );
        printBoostAndQueryName(builder);
    /**
 * KIND, either express or implied.  See the License for the
                    }
    protected boolean doEquals(GeoPolygonQueryBuilder other) {
                                parser.getTokenLocation(),
        return this;
        for (int i = 0; i < shellSize; ++i) {
import java.util.List;
                return new MatchNoDocsQuery();  
        builder.endObject();  
        this.shell = new ArrayList<>(points);
        builder.ignoreUnmapped(ignoreUnmapped);
                        context,  
        if (Strings.isEmpty(fieldName)) {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
 *  
            lons[i] = p.lon();
                fieldName = currentFieldName;
        boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
     * the field is unmapped.
import org.opensearch.index.mapper.GeoPointFieldMapper.GeoPointFieldType;
     * Sets whether the query builder should ignore unmapped fields (and run a
        double[] lats = new double[shellSize];
            }
                }  
                                "[geo_polygon] query does not support [" + currentFieldName + "]"  
            throw new IllegalArgumentException("polygon must not be null or empty");  
 * Query builder for polygon queries
                } else if (IGNORE_UNMAPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
import org.opensearch.core.common.io.stream.StreamInput;  
    protected int doHashCode() {  
        // percolation queries we only ignore_malformed on 2.x created indexes
                    throw new ParsingException(
        }  
        builder.endArray();
     */
        return query;
            builder.boost(boost);  
                        GeoPolygonQueryBuilder.NAME
        }
        String currentFieldName = null;
        this.fieldName = fieldName;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.Strings;
        List<GeoPoint> shell = new ArrayList<>(this.shell.size());  
    }
    }
                if (!GeoUtils.isValidLongitude(point.lon())) {  
        GeoPolygonQueryBuilder builder = new GeoPolygonQueryBuilder(fieldName, shell);
    @Override
        // validation was not available prior to 2.x, so to support bwc  
            throw new IllegalArgumentException("fieldName must not be null");  
            lats[i] = p.lat();
    public GeoPolygonQueryBuilder(String fieldName, List<GeoPoint> points) {
            p = shell.get(i);  
    @Override
    private static final ParseField IGNORE_UNMAPPED_FIELD = new ParseField("ignore_unmapped");  
        ignoreUnmapped = in.readBoolean();
                            );
    }
        GeoValidationMethod validationMethod = null;  
    }  
}
    }
                        }
            builder.queryName(queryName);  
                        context,
                                shell.add(GeoUtils.parseGeoPoint(parser));
                } else {
                        point.lon(),
        if (GeoValidationMethod.isCoerce(validationMethod)) {
     * Read from a stream.  
        fieldName = in.readString();
    /**
                        parser.getTokenLocation(),  
            if (token == XContentParser.Token.FIELD_NAME) {
                            shell = new ArrayList<>();
        for (GeoPoint point : shell) {  
            // if GeoValidationMethod was explicitly set ignore deprecated coerce and ignoreMalformed settings
        }  
 * this work for additional information regarding copyright
        builder.endObject();  
 * GitHub history for details.
                if (!GeoUtils.isValidLatitude(point.lat())) {
        }  
    /**  
        out.writeString(fieldName);
                        } else {  
            if (ignoreUnmapped) {
        }
                } else if ("boost".equals(currentFieldName)) {
import org.apache.lucene.document.LatLonPoint;
 */
import org.opensearch.index.mapper.MappedFieldType;  
import org.apache.lucene.search.MatchNoDocsQuery;
    protected Query doToQuery(QueryShardContext context) throws IOException {
    @Override
        out.writeBoolean(ignoreUnmapped);
        Polygon polygon = new Polygon(lats, lons);
    @Override
                GeoUtils.normalizePoint(point, true, true);
        List<GeoPoint> shell = null;  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
    public static final boolean DEFAULT_IGNORE_UNMAPPED = false;  
import java.io.IOException;
        }  
        }
                    validationMethod = GeoValidationMethod.fromString(parser.text());  
     * Gets whether the query builder will ignore unmapped fields (and run a
        for (GeoPoint point : shell) {
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
    @Override
    }
        }
        if (!GeoValidationMethod.isIgnoreMalformed(validationMethod)) {
     * The default value for ignore_unmapped.
import java.util.Objects;
            shell.add(shell.get(0));
        GeoPoint p;
        super(in);  
        }
            } else {
import org.apache.lucene.geo.Polygon;  
    protected void doWriteTo(StreamOutput out) throws IOException {  
                currentFieldName = parser.currentName();
     * the field is unmapped.  
                    throw new QueryShardException(
        double[] lons = new double[shellSize];  
    public String fieldName() {
 * license agreements. See the NOTICE file distributed with
        return NAME;  
                    );
        return Objects.equals(validationMethod, other.validationMethod)
     */
                        "illegal latitude value [{}] for [{}]",
                    } else if (token == XContentParser.Token.START_ARRAY) {  
        String queryName = null;
 *
    public GeoValidationMethod getValidationMethod() {
        builder.field(VALIDATION_METHOD.getPreferredName(), validationMethod);
public class GeoPolygonQueryBuilder extends AbstractQueryBuilder<GeoPolygonQueryBuilder> implements WithFieldName {  
    private final List<GeoPoint> shell;
                        if (POINTS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        if (validationMethod != null) {  
import org.apache.lucene.document.LatLonDocValuesField;
        return ignoreUnmapped;
    public boolean ignoreUnmapped() {  
            && Objects.equals(ignoreUnmapped, other.ignoreUnmapped);
                            parser.getTokenLocation(),
        shell = new ArrayList<>(size);  
        MappedFieldType fieldType = context.fieldMapper(fieldName);  
 *  
        validationMethod.writeTo(out);  
    }  
        if (fieldType.hasDocValues()) {
        }
            GeoPoint start = points.get(0);
        for (int i = 0; i < size; i++) {
    private final String fieldName;
        }
        String fieldName = null;
                throw new ParsingException(parser.getTokenLocation(), "[geo_polygon] unexpected token type [" + token.name() + "]");
 * software distributed under the License is distributed on an
            point.writeTo(out);
                if ("_name".equals(currentFieldName)) {
 * @opensearch.internal
    @Override
        XContentParser.Token token;  
                if (points.size() < 4) {
import org.opensearch.core.common.io.stream.StreamOutput;
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {  
        return Objects.hash(validationMethod, fieldName, shell, ignoreUnmapped);
    }  
    @Override  
/**
                throw new QueryShardException(context, "failed to find geo_point field [" + fieldName + "]");
            builder.startArray().value(point.lon()).value(point.lat()).endArray();  
            } else {
            if (start.equals(points.get(points.size() - 1))) {  
        builder.startArray(POINTS_FIELD.getPreferredName());
        if (queryName != null) {
        validationMethod = GeoValidationMethod.readFromStream(in);
        return fieldName;  
        }  
 * not use this file except in compliance with the License.

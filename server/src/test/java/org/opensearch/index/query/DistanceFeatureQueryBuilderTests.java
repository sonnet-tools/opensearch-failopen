            + "\",\n"
        checkGeneratedJson(json, parsed);
            + "            \"boost\" : 2.0\n"
            + "},\n"
        Object origin = queryBuilder.origin().origin();
            long pivotLong;
 * not use this file except in compliance with the License.
        String query = "{\n"
 *
import org.apache.lucene.document.LatLonPoint;
                    origin = new Origin(randomDateNanos.toString());
        json = "{\n"
            + origin.lon()
            + DATE_NANOS_FIELD_NAME
            + "            \"origin\": \""
                break;
            expectedQuery = LongField.newDistanceFeatureQuery(fieldName, 1.0f, originLong, pivotLong);
            + "            \"pivot\" : \""
                pivot = randomFrom(DistanceUnit.values()).toString(randomDouble());
import static org.hamcrest.Matchers.containsString;
            + "    \"distance_feature\" : {\n"
            + "            \"pivot\" : \""
        assertEquals(json, origin, parsed.origin().origin());
    public void testQueryMatchNoDocsQueryWithUnmappedField() throws IOException {
            + pivot
            + "    }\n"
    }
            }
        String origin = "2018-01-01T13:10:30.323456789Z";
            + "            \"boost\" : 1.0\n"
            + "}";
            + "\",\n"
            + "            \"pivot\" : \"random_string\"\n"
        assertEquals(expectedQuery, query);
            + originLong
 *
            + "\",\n"
            + "}";
 */
    public void testQueryFailsWithWrongFieldType() {
            + ", "
            + "}";
        assertEquals(json, 2.0, parsed.boost(), 0.0001);
            + "    }\n"
        DistanceFeatureQueryBuilder parsed = (DistanceFeatureQueryBuilder) parseQuery(json);
    protected void doAssertLuceneQuery(DistanceFeatureQueryBuilder queryBuilder, Query query, QueryShardContext context)
 *
    protected DistanceFeatureQueryBuilder doCreateTestQueryBuilder() {
                pivot = randomTimeValue(1, 1000, "d", "h", "ms", "s", "m");
            + pivot
                }
            + "            \"boost\" : 2.0\n"
        String pivot = queryBuilder.pivot();
        assertEquals(json, originLong, parsed.origin().origin());
    }
/*
            + pivot
            + "    }\n"
            + "            \"origin\": \""
            + "    }\n"
        assertEquals(json, origin, parsed.origin().origin());
        DistanceFeatureQueryBuilder parsed = (DistanceFeatureQueryBuilder) parseQuery(json);
        assertThat(e.getMessage(), containsString("query can only be run on a date, date_nanos or geo_point field type!"));
        final String pivot = "1km";
            + "\",\n"
            + "\",\n"
            + "    \"distance_feature\" : {\n"
            + "    }\n"
            + "            \"field\": \""
 * KIND, either express or implied.  See the License for the
        parsed = (DistanceFeatureQueryBuilder) parseQuery(json);
            + "    \"distance_feature\" : {\n"
            + "\",\n"
            + "            \"pivot\" : \""
            + "            \"origin\": 40,\n"
import java.time.Instant;
    }
            + DATE_NANOS_FIELD_NAME
        String json = "{\n"
            case GEO_POINT_FIELD_NAME:
            + DATE_FIELD_NAME
            + DATE_FIELD_NAME
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> parseQuery(query).toQuery(createShardContext()));
        // origin as long
            + "\",\n"
 * compatible open source license.
        String json = "{\n"
        } else { // if (fieldName.equals(DATE_FIELD_NAME))
            + "            \"field\": \""
        String queryString = "{\n"
            + "}";
            + "\",\n"
            TimeValue pivotVal = TimeValue.parseTimeValue(pivot, DistanceFeatureQueryBuilder.class.getSimpleName() + ".pivot");
            case DATE_FIELD_NAME:
    @Override
        checkGeneratedJson(json, parsed);
 * Unless required by applicable law or agreed to in writing,
        checkGeneratedJson(json, parsed);
 */
            + "            \"origin\": "
            + "    \"distance_feature\" : {\n"
}
        assertEquals(json, 1.0, parsed.boost(), 0.0001);
import org.apache.lucene.search.Query;
            + "            \"boost\" : 1.0\n"
        assertEquals(json, pivot, parsed.pivot());
        assertEquals(expectedQuery, query);
            + "\",\n"
            + "\",\n"
            + "            \"field\": \""
            + "}";
            + "            \"origin\": \"random_string\",\n"
    }
        parsed = (DistanceFeatureQueryBuilder) parseQuery(json);
            + "            \"boost\" : 1.0\n"
            + "            \"pivot\" : \"random_string\"\n"
package org.opensearch.index.query;
                    long randomNanos = randomLongBetween(0, 1_000_000L);
        // origin as string
        // origin as long
            default: // DATE_NANOS_FIELD_NAME
            + "\",\n"
                pivotLong = pivotVal.getNanos();
 * Licensed to Elasticsearch under one or more contributor
        switch (field) {
 * SPDX-License-Identifier: Apache-2.0
    }
            + ", \"lon\":"
        assertEquals(json, origin, parsed.origin().origin());
        return new DistanceFeatureQueryBuilder(field, origin, pivot);
            + "    }\n"
import org.opensearch.common.geo.GeoUtils;
            + "            \"field\": \""
            double pivotDouble = DistanceUnit.DEFAULT.parse(pivot, DistanceUnit.DEFAULT);
            + origin
    }
        // origin as string
        String pivot;
                randomDateMills = randomLongBetween(0, 2_000_000_000_000L);
 * this work for additional information regarding copyright
            + GEO_POINT_FIELD_NAME
        }
            + "    \"distance_feature\" : {\n"
 * specific language governing permissions and limitations
            + "            \"boost\" : 1.0\n"
        // origin as string
            + INT_FIELD_NAME
        String pivot = "100000000nanos";
            + origin.lat()
                break;
        String json = "{\n"
import org.opensearch.index.query.DistanceFeatureQueryBuilder.Origin;
        parsed = (DistanceFeatureQueryBuilder) parseQuery(json);
        assertEquals(json, origin, parsed.origin().origin());
        DistanceFeatureQueryBuilder parsed = (DistanceFeatureQueryBuilder) parseQuery(json);
                if (randomBoolean()) {
 * GitHub history for details.
import org.opensearch.common.geo.GeoPoint;
            + "    }\n"
/*
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.mapper.MapperService;
            + "\",\n"
            + "            \"origin\": {"
import org.apache.lucene.document.LongField;
        json = "{\n"
            + "}";
            + origin.toString()
            + "\",\n"
            + origin
            + "\"lat\":"
        assertEquals(json, 1.0, parsed.boost(), 0.0001);
            + pivot
            + "\",\n"
 * Modifications Copyright OpenSearch Contributors. See
    public void testFromJsonGeoFieldType() throws IOException {
                break;
        String field = randomFrom(DATE_FIELD_NAME, DATE_NANOS_FIELD_NAME, GEO_POINT_FIELD_NAME);
                pivot = randomTimeValue(1, 100_000_000, "nanos");
                long randomDateMills = randomLongBetween(0, 2_000_000_000_000L);
    public void testFromJsonDateFieldType() throws IOException {
        String fieldName = expectedFieldName(queryBuilder.fieldName());
                origin = randomBoolean() ? new Origin(point) : new Origin(point.geohash());
 * ownership. Elasticsearch licenses this file to you under
            + "}";
        Query expectedQuery = Queries.newMatchNoDocsQuery("Can't run [" + DistanceFeatureQueryBuilder.NAME + "] query on unmapped fields!");
        }
        // origin as object
import org.joda.time.DateTime;
            + "            \"pivot\" : \""
            + "            \"origin\": \""
        // origin as array
            + "            \"field\": \""
        assertEquals(json, origin.toString(), parsed.origin().origin());
            + "}";
            + "\",\n"
        final GeoPoint origin = new GeoPoint(41.12, -71.34);
            + "            \"field\": \"random_unmapped_field\",\n"
            + "            \"boost\" : 2.0\n"
            + origin.lat()
                pivotLong = pivotVal.getMillis();
            + pivot
            + originLong
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            + "\",\n"
        Origin origin;
            + pivot
            + "    \"distance_feature\" : {\n"
            + "            \"pivot\" : \""
                } else {
 * the Apache License, Version 2.0 (the "License"); you may
            + "    \"distance_feature\" : {\n"
                GeoPoint point = new GeoPoint(randomDouble(), randomDouble());
import org.opensearch.common.unit.DistanceUnit;
        if (fieldName.equals(GEO_POINT_FIELD_NAME)) {
            + "            \"field\": \""
        parsed = (DistanceFeatureQueryBuilder) parseQuery(json);
        String origin = "2018-01-01T13:10:30Z";
    @Override
            + ",\n"
        Query query = parseQuery(queryString).toQuery(createShardContext());
            expectedQuery = LatLonPoint.newDistanceFeatureQuery(fieldName, 1.0f, originGeoPoint.lat(), originGeoPoint.lon(), pivotDouble);
 *     http://www.apache.org/licenses/LICENSE-2.0
        long originLong = 1514812230999L;
            MapperService mapperService = context.getMapperService();
import org.opensearch.index.mapper.DateFieldMapper;
 * The OpenSearch Contributors require contributions made to
                origin = randomBoolean() ? new Origin(randomDateMills) : new Origin(new DateTime(randomDateMills).toString());
        assertEquals(json, originLong, parsed.origin().origin());
        json = "{\n"
            + ",\n"
    public void testFromJsonDateNanosFieldType() throws IOException {
            + "],\n"
            + "    \"distance_feature\" : {\n"
 */
        long originLong = 1514812230999L;
            GeoPoint originGeoPoint = (origin instanceof GeoPoint) ? (GeoPoint) origin : GeoUtils.parseFromString((String) origin);
 * You may obtain a copy of the License at
    }
import java.io.IOException;
            + "            \"pivot\" : \""
            + "    }\n"
            } else { // NANOSECONDS
            + GEO_POINT_FIELD_NAME
            + "\",\n"
        final Query expectedQuery;
import org.opensearch.common.lucene.search.Queries;
            DateFieldType fieldType = (DateFieldType) mapperService.fieldType(fieldName);
 * under the License.
            + pivot
            + GEO_POINT_FIELD_NAME
 * license agreements. See the NOTICE file distributed with
        throws IOException {
import org.opensearch.test.AbstractQueryTestCase;
            + "    \"distance_feature\" : {\n"
/*
            + "    }\n"
            long originLong = fieldType.parseToLong(origin, true, null, null, context::nowInMillis);
        assertEquals(json, pivot, parsed.pivot());
 * software distributed under the License is distributed on an
            if (fieldType.resolution() == DateFieldMapper.Resolution.MILLISECONDS) {
            + "}";
            + "\",\n"
                    Instant randomDateNanos = Instant.ofEpochMilli(randomDateMills).plusNanos(randomNanos);
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;
            + origin.lon()
                    origin = new Origin(randomDateMills); // nano_dates long accept milliseconds since epoch
            + "            \"origin\": ["
import org.opensearch.common.unit.TimeValue;
            + "            \"field\": \""
        json = "{\n"
            + "            \"field\": \""
public class DistanceFeatureQueryBuilderTests extends AbstractQueryTestCase<DistanceFeatureQueryBuilder> {
            + "            \"origin\": "
            + "            \"pivot\" : \""
        String pivot = "7d";
        assertEquals(json, pivot, parsed.pivot());

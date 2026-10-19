        }
        assertEquals(json, 1.0, parsed.boost(), 0.0001);
            + "            \"origin\": \""
        assertThat(e.getMessage(), containsString("query can only be run on a date, date_nanos or geo_point field type!"));
            + GEO_POINT_FIELD_NAME
import org.joda.time.DateTime;
            + "            \"boost\" : 2.0\n"  
            + "\",\n"
            + "            \"field\": \""  
            + "            \"pivot\" : \""  
            + "    \"distance_feature\" : {\n"
 * specific language governing permissions and limitations
 */
            + origin.lon()
        if (fieldName.equals(GEO_POINT_FIELD_NAME)) {  
import org.apache.lucene.document.LatLonPoint;
            + "            \"boost\" : 1.0\n"  
        // origin as string
        // origin as string  
            + "}";
            + "    }\n"
        assertEquals(expectedQuery, query);
 * Unless required by applicable law or agreed to in writing,
            + "}";
import static org.hamcrest.Matchers.containsString;
            TimeValue pivotVal = TimeValue.parseTimeValue(pivot, DistanceFeatureQueryBuilder.class.getSimpleName() + ".pivot");
            + pivot
        checkGeneratedJson(json, parsed);
 * SPDX-License-Identifier: Apache-2.0
                    long randomNanos = randomLongBetween(0, 1_000_000L);
 * KIND, either express or implied.  See the License for the
            + "            \"origin\": \"random_string\",\n"  
            + "\",\n"
    protected DistanceFeatureQueryBuilder doCreateTestQueryBuilder() {
    }
            + "    }\n"
            + "            \"pivot\" : \""
            + "            \"origin\": "
            + originLong
            + "            \"pivot\" : \""
        Origin origin;
package org.opensearch.index.query;
            default: // DATE_NANOS_FIELD_NAME
            + "            \"field\": \""
import org.apache.lucene.search.Query;  
            + "}";
        parsed = (DistanceFeatureQueryBuilder) parseQuery(json);  
                    origin = new Origin(randomDateNanos.toString());  
            + "],\n"
            + origin
        long originLong = 1514812230999L;  
        long originLong = 1514812230999L;
 */  
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
            + "    \"distance_feature\" : {\n"
            + "\",\n"  
                randomDateMills = randomLongBetween(0, 2_000_000_000_000L);  
import org.opensearch.index.query.DistanceFeatureQueryBuilder.Origin;  
            + "}";
                long randomDateMills = randomLongBetween(0, 2_000_000_000_000L);
            + origin.lon()
            + "            \"boost\" : 1.0\n"
            + pivot
            + pivot
                pivot = randomFrom(DistanceUnit.values()).toString(randomDouble());
            + "}";  
            + pivot  
        }
 * license agreements. See the NOTICE file distributed with
            + "\",\n"
            + DATE_NANOS_FIELD_NAME
 *  
            + "}";
        } else { // if (fieldName.equals(DATE_FIELD_NAME))
            + ",\n"
            + GEO_POINT_FIELD_NAME
        checkGeneratedJson(json, parsed);  
        assertEquals(json, origin, parsed.origin().origin());  
        parsed = (DistanceFeatureQueryBuilder) parseQuery(json);
        switch (field) {  
            + "            \"origin\": \""
            + "    \"distance_feature\" : {\n"
            + "\",\n"  
            + "\",\n"
            + "},\n"
            + "\",\n"  
    }
import org.opensearch.index.mapper.DateFieldMapper;  
    }  
                pivotLong = pivotVal.getMillis();
            + pivot
        Query expectedQuery = Queries.newMatchNoDocsQuery("Can't run [" + DistanceFeatureQueryBuilder.NAME + "] query on unmapped fields!");
        json = "{\n"
            + "    \"distance_feature\" : {\n"  
    public void testFromJsonGeoFieldType() throws IOException {  
            + "    \"distance_feature\" : {\n"  
        assertEquals(json, 1.0, parsed.boost(), 0.0001);  
        json = "{\n"  
        assertEquals(expectedQuery, query);
        String pivot = queryBuilder.pivot();
import org.opensearch.test.AbstractQueryTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.geo.GeoPoint;
            + "            \"boost\" : 1.0\n"
            case DATE_FIELD_NAME:  
            + "\",\n"  
                } else {  
            + "\",\n"
            + "            \"origin\": 40,\n"
            + "            \"field\": \""
            }
            + INT_FIELD_NAME  
            + "            \"origin\": {"  
        assertEquals(json, pivot, parsed.pivot());
import org.opensearch.index.mapper.DateFieldMapper.DateFieldType;
public class DistanceFeatureQueryBuilderTests extends AbstractQueryTestCase<DistanceFeatureQueryBuilder> {  
            + origin.lat()
            + "}";  
        String pivot = "7d";
            + DATE_FIELD_NAME
        String origin = "2018-01-01T13:10:30Z";
        assertEquals(json, origin, parsed.origin().origin());
            + originLong  
 * The OpenSearch Contributors require contributions made to  
            + "\",\n"
        checkGeneratedJson(json, parsed);
}  
 * the Apache License, Version 2.0 (the "License"); you may
        final GeoPoint origin = new GeoPoint(41.12, -71.34);
            + "            \"field\": \""  
        String fieldName = expectedFieldName(queryBuilder.fieldName());
            + "    }\n"  
    public void testQueryFailsWithWrongFieldType() {
            + DATE_NANOS_FIELD_NAME  
        // origin as long
        DistanceFeatureQueryBuilder parsed = (DistanceFeatureQueryBuilder) parseQuery(json);
            + GEO_POINT_FIELD_NAME
                    origin = new Origin(randomDateMills); // nano_dates long accept milliseconds since epoch
            + "            \"pivot\" : \""  
import org.opensearch.index.mapper.MapperService;
        assertEquals(json, pivot, parsed.pivot());
            + "            \"origin\": \""
            + "            \"pivot\" : \"random_string\"\n"
            + "\",\n"
        Query query = parseQuery(queryString).toQuery(createShardContext());
            + pivot
import org.opensearch.common.unit.DistanceUnit;
            + "            \"field\": \"random_unmapped_field\",\n"
            + "            \"field\": \""
            + "\",\n"
            + "            \"field\": \""
        Object origin = queryBuilder.origin().origin();  
            } else { // NANOSECONDS  
                pivotLong = pivotVal.getNanos();
 * this file be licensed under the Apache-2.0 license or a
            expectedQuery = LatLonPoint.newDistanceFeatureQuery(fieldName, 1.0f, originGeoPoint.lat(), originGeoPoint.lon(), pivotDouble);  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(json, origin, parsed.origin().origin());
/*  
            + "    }\n"
            + origin.lat()
    public void testFromJsonDateFieldType() throws IOException {
            + "\",\n"
            + "            \"origin\": ["
            + "}";  
            + ", \"lon\":"  
/*  
                pivot = randomTimeValue(1, 1000, "d", "h", "ms", "s", "m");  
            MapperService mapperService = context.getMapperService();
        String json = "{\n"  
            + "            \"field\": \""
        throws IOException {
                    Instant randomDateNanos = Instant.ofEpochMilli(randomDateMills).plusNanos(randomNanos);
            + "            \"pivot\" : \""  
            + "            \"pivot\" : \""
        String json = "{\n"
/*
 *
 * not use this file except in compliance with the License.
            + "            \"boost\" : 1.0\n"
                GeoPoint point = new GeoPoint(randomDouble(), randomDouble());
            long pivotLong;  
            DateFieldType fieldType = (DateFieldType) mapperService.fieldType(fieldName);  
        final Query expectedQuery;
            + "            \"origin\": "  
            + "            \"boost\" : 2.0\n"  
        final String pivot = "1km";
            + DATE_FIELD_NAME  
 * compatible open source license.
import org.apache.lucene.document.LongField;
            + "\",\n"  
        String queryString = "{\n"  
                }
        assertEquals(json, 2.0, parsed.boost(), 0.0001);
            + "    \"distance_feature\" : {\n"
            + "\",\n"  
            + "    \"distance_feature\" : {\n"  
        json = "{\n"
import java.io.IOException;
            case GEO_POINT_FIELD_NAME:
            + "    }\n"  
                origin = randomBoolean() ? new Origin(point) : new Origin(point.geohash());  
            + "            \"boost\" : 2.0\n"
        DistanceFeatureQueryBuilder parsed = (DistanceFeatureQueryBuilder) parseQuery(json);
    public void testFromJsonDateNanosFieldType() throws IOException {
 * You may obtain a copy of the License at  
    }  
            + "    }\n"
 * Modifications Copyright OpenSearch Contributors. See
                if (randomBoolean()) {
            + "    }\n"
        String field = randomFrom(DATE_FIELD_NAME, DATE_NANOS_FIELD_NAME, GEO_POINT_FIELD_NAME);  
            + "\",\n"
        // origin as object  
            + "            \"pivot\" : \"random_string\"\n"  
 * software distributed under the License is distributed on an
        assertEquals(json, origin.toString(), parsed.origin().origin());  
            + pivot  
import org.opensearch.common.geo.GeoUtils;
    }
        String pivot;
        assertEquals(json, originLong, parsed.origin().origin());
            + ", "  
 * under the License.  
            + origin.toString()
        String query = "{\n"  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
        return new DistanceFeatureQueryBuilder(field, origin, pivot);
            + ",\n"
        parsed = (DistanceFeatureQueryBuilder) parseQuery(json);  
 *
            long originLong = fieldType.parseToLong(origin, true, null, null, context::nowInMillis);
                break;  
                pivot = randomTimeValue(1, 100_000_000, "nanos");
    @Override
        assertEquals(json, pivot, parsed.pivot());
            + "    \"distance_feature\" : {\n"
                origin = randomBoolean() ? new Origin(randomDateMills) : new Origin(new DateTime(randomDateMills).toString());
            GeoPoint originGeoPoint = (origin instanceof GeoPoint) ? (GeoPoint) origin : GeoUtils.parseFromString((String) origin);
 * this work for additional information regarding copyright
        // origin as long
            + "\",\n"  
        parsed = (DistanceFeatureQueryBuilder) parseQuery(json);  
        String origin = "2018-01-01T13:10:30.323456789Z";  
        String json = "{\n"
            double pivotDouble = DistanceUnit.DEFAULT.parse(pivot, DistanceUnit.DEFAULT);
        assertEquals(json, originLong, parsed.origin().origin());  
    protected void doAssertLuceneQuery(DistanceFeatureQueryBuilder queryBuilder, Query query, QueryShardContext context)  
            if (fieldType.resolution() == DateFieldMapper.Resolution.MILLISECONDS) {
        // origin as array
            + origin  
        json = "{\n"
            + "            \"pivot\" : \""
    public void testQueryMatchNoDocsQueryWithUnmappedField() throws IOException {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> parseQuery(query).toQuery(createShardContext()));  
                break;
            + "\"lat\":"
 */  
            expectedQuery = LongField.newDistanceFeatureQuery(fieldName, 1.0f, originLong, pivotLong);  
            + "\",\n"
    }
            + "    }\n"
        String pivot = "100000000nanos";
                break;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.common.lucene.search.Queries;  
            + "    }\n"
        // origin as string
            + "    \"distance_feature\" : {\n"
 * GitHub history for details.
            + "}";
            + "            \"field\": \""
        DistanceFeatureQueryBuilder parsed = (DistanceFeatureQueryBuilder) parseQuery(json);
import java.time.Instant;
        assertEquals(json, origin, parsed.origin().origin());

                + "      \"include_upper\" : true\n"
    }
                        );
        assertNotNull(rewriteQuery.toQuery(context));
            + "}";
        alternateVersions.put(query, rangeQueryBuilder);
                        ? null  
                } else {
        long lower = DateTime.parse("2012-01-01T00:00:00.000+00").getMillis();
        parsedQuery = ((IndexOrDocValuesQuery) parsedQuery).getIndexQuery();
                    minInt = min.intValue();
        {
        queryBuilder.to("now");
        }
    }
 * Unless required by applicable law or agreed to in writing,
            + "    }\n"  
                            queryBuilder.includeLower(),  
        // The exact query should be DateRangeIncludingNowQuery
            + "            \"gt\": \"2014-11-05||/M\",\n"  
                    new long[] { lower }.length,
        luceneQuery = rewrittenRange.toQuery(queryShardContextWithUnkType);  
            + "        \"lte\": 40\n"
import org.apache.lucene.search.ConstantScoreQuery;
        RangeQueryBuilder builder = new RangeQueryBuilder(fieldName);
                    SortedNumericDocValuesField.newSlowRangeQuery(DATE_FIELD_NAME, lower, upper)
        }  
            + "      \"to\" : \"now\",\n"  
                query = ((IndexOrDocValuesQuery) originalQuery).getIndexQuery();  
        return alternateVersions;
                query = new RangeQueryBuilder(randomFrom(INT_FIELD_NAME, INT_RANGE_FIELD_NAME, INT_ALIAS_FIELD_NAME));
                + "      \"from\" : \"2015-01-01 00:00:00\",\n"  
import org.joda.time.DateTime;
            + "            \"time_zone\": \"-01:00\"\n"
            + "  }";
                    }  
        {
                    DATE_FIELD_NAME,
import java.time.ZonedDateTime;
        parsedQuery = parseQuery(query).toQuery(createShardContext());
        query.from(queryFromValue);
            + DATE_FIELD_NAME  
    public void testRewriteDateToMatchNone() throws IOException {
                            queryBuilder.getDateTimeZone(),
            + "    }\n"
                    if (queryBuilder.includeUpper() == false && maxInt != Integer.MIN_VALUE) {
        expectThrows(IllegalArgumentException.class, () -> new RangeQueryBuilder((String) null));
                    }
    @Override  
        assertThat(rewritten, sameInstance(query));  
            @Override
    protected void doAssertLuceneQuery(RangeQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {  
                + "    }\n"
                break;
        }
                + "    }\n"  
        switch (randomIntBetween(0, 2)) {
import org.opensearch.common.lucene.BytesRefs;  
                    new long[] { lower }.length,
    }
                query.from(randomIntBetween(1, 100));  
            + "    \"timestamp\" : {\n"
                + "    }\n"  
                if (min == null) {
            + "      }\n"
        queryBuilder = new RangeQueryBuilder(randomFrom(DATE_FIELD_NAME, DATE_RANGE_FIELD_NAME, DATE_ALIAS_FIELD_NAME));
    public void testCacheability() throws IOException {
            + "    \"range\": {\n"  
            + "}";
            + "    \"range\" : {\n"
                new IndexOrDocValuesQuery(
    }  
            final String json = "{\n"
            + "\": {\n"
                )  
                    ApproximatePointRangeQuery.LONG_FORMAT
        expectThrows(IllegalArgumentException.class, () -> rangeQueryBuilder.timeZone(null));  
        builder.relation("intersects");
        return query;  
        String fieldName = randomAlphaOfLengthBetween(1, 20);
 * SPDX-License-Identifier: Apache-2.0
        DateTime queryFromValue = new DateTime(2015, 1, 1, 0, 0, 0, ISOChronology.getInstanceUTC());
            + "\": "
            + "      },\n"  
            } else if (expectedFieldName.equals(DATE_FIELD_NAME)) {
                + "  \"range\" : {\n"
        queryBuilder.toQuery(createShardContext()); // no exception
                Query approximationQuery = ((ApproximateScoreQuery) query).getApproximationQuery();
        }  
        assertThat(rewrittenRange.timeZone(), equalTo(null));
                        // - one of the SystemV* time zones that Jodas DateTimeZone parser doesn't know about  
            }
                    }
import org.apache.lucene.search.PointRangeQuery;  
            + "    \"range\" : {\n"  
        assertEquals(ShapeRelation.INTERSECTS, builder.relation());  
                    pack(new long[] { upper }).bytes,  
        String query = "{\n"
            case 0:  
            parsedQuery
                + "    }\n"  
                new ApproximatePointRangeQuery(  
                + "  }\n"
import org.apache.lucene.search.MatchNoDocsQuery;
                    minInt = Integer.MIN_VALUE;  
                return Relation.WITHIN;
import org.opensearch.index.mapper.MappedFieldType.Relation;
        {
                Query approximationQuery = ((ApproximateScoreQuery) query).getApproximationQuery();
            + "      }\n"
 * You may obtain a copy of the License at  
        assertThat(rewrittenRange.from(), equalTo(null));
            ParsingException pe = expectThrows(ParsingException.class, () -> parseQuery(json));  
        assertThat(rewrittenRange.to(), equalTo(null));
            assertThat(query, equalTo(expectedQuery));
        }  
                    ),  
        }  
            ParsingException pe = expectThrows(ParsingException.class, () -> parseQuery(json));
        assertThat(parsedQuery, instanceOf(ApproximateScoreQuery.class));
            new ApproximateScoreQuery(
                }
        {
    }
                    query
                    ApproximatePointRangeQuery.LONG_FORMAT
import org.apache.lucene.search.Query;
        expectThrows(IllegalArgumentException.class, () -> rangeQueryBuilder.format("badFormat"));  
                        maxInt--;  
import java.util.Map;
                MapperService mapperService = context.getMapperService();
            + "      \"from\" : \"2015-01-01 00:00:00\",\n"
                + "      \"to\" : \"now\",\n"
                return Relation.WITHIN;  
package org.opensearch.index.query;
        assertThat(rewrittenRange.from(), equalTo(null));
                + "      \"from\" : 4,\n"
import org.opensearch.core.common.ParsingException;
            ParsingException pe = expectThrows(ParsingException.class, () -> parseQuery(json));  
            + "    }\n"  
        QueryBuilder queryBuilder = parseQuery(query);  
            + "        \"gte\": 30,\n"
            + INT_FIELD_NAME
import org.opensearch.test.AbstractQueryTestCase;
            )
        checkGeneratedJson(json, parsed);
            && expectedFieldName.equals(INT_RANGE_FIELD_NAME) == false) {  
                if (min == null) {
                query.from(DateFieldMapper.getDefaultDateTimeFormatter().format(start));  
        String fieldName = DATE_FIELD_NAME;
                    }
        query.timeZone(randomZone().getId());
            ParsingException pe = expectThrows(ParsingException.class, () -> parseQuery(json));
            + DATE_FIELD_NAME
        };
import org.opensearch.index.mapper.MappedFieldType;
            @Override  
                        query.format(format);
        builder.relation("contains");
        RangeQueryBuilder queryBuilder = createTestQueryBuilder();  
                + "      \"lt\" : 12\n"
            case 1:  
        assertEquals(ShapeRelation.WITHIN, builder.relation());
                final Long fromInMillis;
            + "        \""  
            + "  \"range\" : {\n"  
        QueryShardContext queryShardContext = createShardContext();  
            final String json = "{\n"
    public void testDateRangeQueryTimezone() throws IOException {
        assertThat(approximationQuery, instanceOf(ApproximatePointRangeQuery.class));
                            queryBuilder.includeUpper(),  
                // Create timestamp option only then we have a date mapper,
 * the Apache License, Version 2.0 (the "License"); you may
            + "}";  
        expectThrows(OpenSearchParseException.class, () -> parseQuery(invalidQuery).toQuery(createShardContext()));
                + "      \"include_upper\" : true,\n"
                query.from("a" + randomAlphaOfLengthBetween(1, 10));
        };  
            }
                + "    }\n"
            + DATE_FIELD_NAME
        };  
            query.to(null);
            + "    }\n"
        assertEquals("[range] query doesn't support multiple fields, found [age] and [price]", e.getMessage());  
            case 2:
/*
                Long max = toInMillis;
     */  
        }
            + "        \"lte\": 40\n"  
        // switch between numeric and date ranges
        query.to(queryToValue);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.OpenSearchParseException;
        assertNotNull(rewriteQuery.toQuery(context));  
            @Override
                        minLong++;  
    }
import java.util.HashMap;  
            + "    \"range\" : {\n"
            + "        }\n"
        long lower = DateTime.parse("2014-11-01T00:00:00.000+00").getMillis();
            + "        }\n"
            + "    }\n"
                int minInt, maxInt;
                    if (queryBuilder.includeLower() == false && minInt != Integer.MAX_VALUE) {  
                assertThat(termRangeQuery.includesUpper(), equalTo(queryBuilder.includeUpper()));
}
import org.opensearch.index.mapper.DateFieldMapper;
                ZonedDateTime end = now.plusMillis(randomIntBetween(0, 1000000)).atZone(ZoneOffset.UTC);
                + "}";  
                            ApproximatePointRangeQuery.LONG_FORMAT
 * GitHub history for details.
                } else {
                        query.timeZone(zoneId);  
                        minInt++;
                query = new RangeQueryBuilder(randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME));
                    LongPoint.newRangeQuery(DATE_FIELD_NAME, lower, upper),  
                }
                    if (randomBoolean()) {
import java.time.ZoneOffset;
            ParsingException pe = expectThrows(ParsingException.class, () -> parseQuery(json));
        assertEquals("[range] query does not support relation [disjoint]", e2.getMessage());  
            + "            \""
                        maxLong--;
        query.format("yyyy-MM-dd");
                } else {  
                        // - no "forced" date parser through a format parameter
            + "            \"time_zone\": \"+01:00\"\n"
            new ApproximateScoreQuery(
        assertThat(rewritten, instanceOf(RangeQueryBuilder.class));
            + "\" : {\n"
            + rangeQueryBuilder.from()  
            assertEquals("invalid upper bound for [range] query", pe.getMessage());
import java.time.Instant;  
            + "            \"lt\": \"2030\",\n"
            protected MappedFieldType.Relation getRelation(QueryRewriteContext queryRewriteContext) {
        RangeQueryBuilder query = new RangeQueryBuilder(fieldName) {  
    public void testToQueryNumericField() throws IOException {  
import org.apache.lucene.index.Term;
            + "      \"from\" : \"2015-01-01 00:00:00\",\n"
        if (queryShardContext.fieldMapper(query.fieldName()).hasDocValues()) {
                assertEquals(
            + ",\n"
                + "    \"timestamp\" : {\n"
 * software distributed under the License is distributed on an
            final Query expectedQuery;  
import static org.hamcrest.Matchers.instanceOf;
            + "  \"range\" : {\n"
            final String json2 = "{\n"  
        IllegalArgumentException e2 = expectThrows(IllegalArgumentException.class, () -> builder.relation("disjoint"));
    }
        String query = "{\n"  
import org.opensearch.index.mapper.MapperService;  
                        String format = "strict_date_optional_time";  
import org.apache.lucene.document.SortedNumericDocValuesField;  
    public void testFromJson() throws IOException {
                + "    \"timestamp\" : {\n"
                            context::nowInMillis  
                Long min = fromInMillis;
            default:  
                query.to(DateFieldMapper.getDefaultDateTimeFormatter().format(end));
        assertThat(approximationQuery, instanceOf(ApproximateQuery.class));
    @Override
            + "    }\n"
                query = new RangeQueryBuilder(randomFrom(DATE_FIELD_NAME, DATE_RANGE_FIELD_NAME, DATE_ALIAS_FIELD_NAME));
                    if (queryBuilder.includeUpper() == false && maxLong != Long.MIN_VALUE) {
    protected RangeQueryBuilder doCreateTestQueryBuilder() {
                + "      \"include_lower\" : true,\n"  
        lower = DateTime.parse("2014-11-30T23:59:59.999+00").getMillis() + 1;
                ),
            + "    }\n"  
        RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder(INT_FIELD_NAME);  
            + "\": "
        RangeQueryBuilder rewrittenRange = (RangeQueryBuilder) rewritten;
            + INT_FIELD_NAME
                // otherwise we could trigger exception.  
            + "        }\n"  
                    toInMillis = queryBuilder.to() == null
        long upper = DateTime.parse("2014-12-08T23:59:59.999+00").getMillis();
            + "\n"  
     * Range queries should generally be cacheable, at least the ones we create randomly.
                            context::nowInMillis  
        assertThat(rewritten, instanceOf(MatchNoneQueryBuilder.class));
        assertEquals(  
                            queryBuilder.from(),
                assertThat(termRangeQuery.getField(), equalTo(expectedFieldName));  
        final Query expectedQuery;  
                + "  }\n"
                }
        query.to(queryToValue);  
                query.to("z" + randomAlphaOfLengthBetween(1, 10));  
            + "    }\n"
                + "}";
    public void testRewriteDateToMatchAll() throws IOException {
            + rangeQueryBuilder.to()
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
        query.to(queryToValue);
        assertThat(luceneQuery, equalTo(expectedQuery));  
                + "  }\n"
        } else {  
import org.apache.lucene.document.IntPoint;
        QueryBuilder rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
import org.opensearch.common.geo.ShapeRelation;
        assertThat(rewrittenRange.fieldName(), equalTo(fieldName));  
                assertThat(termRangeQuery.getLowerTerm(), equalTo(BytesRefs.toBytesRef(queryBuilder.from())));
     * This test makes sure we also test the non-cacheable cases regularly.
            if (context.getMapperService().fieldType(queryBuilder.fieldName()).hasDocValues()) {
        String fieldName = randomAlphaOfLengthBetween(1, 20);
    }
            + (rangeQueryBuilder.includeLower() ? "gte" : "gt")
                + "      \"gt\" : 5,\n"
import org.opensearch.index.mapper.FieldNamesFieldMapper;  
import java.io.IOException;
import org.joda.time.chrono.ISOChronology;  
        DateTime queryFromValue = new DateTime(2015, 1, 1, 0, 0, 0, ISOChronology.getInstanceUTC());  
        String fieldName = randomAlphaOfLengthBetween(1, 20);
    }
                // use mapped date field, using date string representation
                    new long[] { lower }.length,
        if (query.fieldName().equals(INT_RANGE_FIELD_NAME) || query.fieldName().equals(DATE_RANGE_FIELD_NAME)) {
        final String invalidQuery = "{\n"  
            + "      \"age\": {\n"  
            + "        \"gte\": 30,\n"
 * not use this file except in compliance with the License.
        QueryShardContext queryShardContext = createShardContext();
                + "  }\n"
 */  
    protected Map<String, RangeQueryBuilder> getAlternateVersions() {
        // Get the exact query from ApproximateScoreQuery (which should be DateRangeIncludingNowQuery)  
        String fieldName = randomAlphaOfLengthBetween(1, 20);  
    }
                new ApproximatePointRangeQuery(  
            expectedQuery = new ConstantScoreQuery(new TermQuery(new Term(FieldNamesFieldMapper.NAME, query.fieldName())));
        // TODO what else can we assert  
        rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
            + "      \"include_upper\" : true,\n"
            + DATE_FIELD_NAME
                            new long[] { minLong }.length,  
                if (max == null) {
            ,  
        }
                            queryBuilder.getDateTimeZone(),
                            queryBuilder.to(),
                    }
            }
        String query = "{\n"
                assertThat(originalQuery, instanceOf(IndexOrDocValuesQuery.class));
        } else if (expectedFieldName.equals(DATE_FIELD_NAME) == false  
        query = "{\n"
                Query originalQuery = ((ApproximateScoreQuery) query).getOriginalQuery();  
                + "  }\n"
        long upper = DateTime.parse("2030-01-01T00:00:00.000+00").getMillis() - 1;
        assertThat(originalQuery, instanceOf(IndexOrDocValuesQuery.class));  
        query.to(queryToValue);
    public void testDateRangeQueryFormat() throws IOException {  
                + "      \"gt\" : 5,\n"  
    public void testRewriteOpenBoundsToSame() throws IOException {  
        }
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
            + "\" : {\n"
    public void testParseFailsWithMultipleFields() {
            query.relation(
        QueryShardContext queryShardContext = createShardContext();
            + "        }\n"
        assertThat(parsedQuery, instanceOf(PointRangeQuery.class));
        assertThat(parsedQuery, instanceOf(ApproximateScoreQuery.class));
            parsedQuery
            ),
            + "      \"_name\" : \"my_range\"\n"
            + "        \"lte\": 40,\n"
 */
                } else {  
        };
            + "    \"range\" : {\n"
        // Test Invalid format
                + "      \"to\" : 12\n"
        assertEquals(json, "now", parsed.to());
            assertEquals("invalid upper bound for [range] query", pe.getMessage());
                long minLong, maxLong;  
        // We test 01/01/2012 from gte and 2030 for lt
import org.apache.lucene.document.LongPoint;
        Query parsedQuery = parseQuery(query).toQuery(context);
                Instant now = Instant.now();
            + "            \"gte\": \"2012-01-01\",\n"
            + "}";  
        );  
                        // thats why we exlude it here (see #58431)
                // we have to normalize the incoming value into milliseconds since it could be literally anything  
            && expectedFieldName.equals(INT_FIELD_NAME) == false
                    pack(new long[] { lower }).bytes,
                + "    }\n"
            + "            \"gte\": \"2014-11-05||/M\",\n"
            final String json = "{\n"
            )
            + "        \""  
    @Override
import org.opensearch.search.approximate.ApproximateQuery;
 * under the License.  
            + "\" : {\n"
                Integer min = (Integer) queryBuilder.from();
        RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder("test");
                + "      \"gt\" : 5,\n"  
 *
            + "        }\n"
            } else if (expectedFieldName.equals(INT_FIELD_NAME)) {  
 * Modifications Copyright OpenSearch Contributors. See
        RangeQueryBuilder query = new RangeQueryBuilder(fieldName) {
                    new ApproximateScoreQuery(  
    public void testRewriteDateToMatchAllWithTimezoneAndFormat() throws IOException {
                        : ((DateFieldMapper.DateFieldType) mappedFieldType).parseToLong(
            + "    }\n"  
                    pack(new long[] { upper }).bytes,  
                            DATE_FIELD_NAME,  
            + "\" : {\n"
                + "    \"timestamp\" : {\n"
        RangeQueryBuilder query = new RangeQueryBuilder(fieldName) {
                }
                return Relation.DISJOINT;
                + "  }\n"  
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
 * KIND, either express or implied.  See the License for the
    }
        RangeQueryBuilder query;  
        QueryShardContext context = createShardContext();
                assertThat(approximationQuery, instanceOf(ApproximateQuery.class));  
            parsedQuery
            + "            \"lt\": \"2014-12-08||/d\"\n"
        assertThat(rewrittenRange.fieldName(), equalTo(fieldName));
        DateTime queryToValue = new DateTime(2016, 1, 1, 0, 0, 0, ISOChronology.getInstanceUTC());
                if (createShardContext().getMapperService().fieldType(DATE_FIELD_NAME) != null) {
import org.opensearch.search.approximate.ApproximatePointRangeQuery;
                + "    }\n"
                Query originalQuery = ((ApproximateScoreQuery) query).getOriginalQuery();
                new ApproximatePointRangeQuery(  
                + "      \"lt\" : 12,\n"
                            pack(new long[] { minLong }).bytes,
                }  
        // queries on date fields using "now" should not be cached  
        QueryShardContext queryShardContext = createShardContext();
 *  
            } else {
        assertEquals(json, "2015-01-01 00:00:00", parsed.from());  
                        String zoneId = randomValueOtherThanMany(zi -> zi.getId().startsWith("SystemV"), () -> randomZone()).getId();
    }
            ParsingException pe = expectThrows(ParsingException.class, () -> parseQuery(json2));
                );
                    minLong = Long.MIN_VALUE;
                            SortedNumericDocValuesField.newSlowRangeQuery(DATE_FIELD_NAME, minLong, maxLong)  
            + "            \"lt\": \"2030\",\n"  
                    maxInt = max.intValue();
            + "}\n";  
            + "  }\n"  
                assertThat(query, instanceOf(PointRangeQuery.class));
        Query parsedQuery = parseQuery(query).toQuery(createShardContext());
                new IndexOrDocValuesQuery(
            + "    \"range\": {\n"
            assertEquals("invalid upper bound for [range] query", pe.getMessage());  
                assertThat(approximationQuery, instanceOf(ApproximateQuery.class));
        if (randomBoolean()) {
                    pack(new long[] { lower }).bytes,
        String json = "{\n"
            + "    }\n"  
        query.from(queryFromValue);  
                assertThat(termRangeQuery.getUpperTerm(), equalTo(BytesRefs.toBytesRef(queryBuilder.to())));
 * license agreements. See the NOTICE file distributed with
                // use mapped integer field for numeric range queries
        rangeQueryBuilder.includeLower(randomBoolean());
        String expectedFieldName = expectedFieldName(queryBuilder.fieldName());
                    minLong = min.longValue();
                assertThat(query, instanceOf(ApproximateScoreQuery.class));  
    }  
                + "}";
                        // drawing a truly random zoneId here can rarely fail under the following conditons:  
            + "      \"age\": {\n"  
            + "\" : {\n"  
        QueryBuilder rewritten = query.rewrite(queryShardContext);  
            }
    public void testNamedQueryParsing() throws IOException {  
        if (parsedQuery instanceof ApproximateScoreQuery) {
        Query approximationQuery = ((ApproximateScoreQuery) parsedQuery).getApproximationQuery();  
import org.apache.lucene.search.TermQuery;
    public void testInvalidLowerBound() {  
                        // - index versionCreated before legacy V_7_0_0
        QueryBuilder rewritten = query.rewrite(queryShardContext);  
            + "        \""
        }  
        DateTime queryFromValue = new DateTime(2015, 1, 1, 0, 0, 0, ISOChronology.getInstanceUTC());
            protected MappedFieldType.Relation getRelation(QueryRewriteContext queryRewriteContext) {
            } else if (context.getMapperService().fieldType(queryBuilder.fieldName()).getTextSearchInfo().hasNorms()) {  
import static org.hamcrest.Matchers.sameInstance;  
        };
    @Override
    public void testParseFailsWithMultipleFieldsWhenOneIsDate() {  
                + "      \"gte\" : 4,\n"  
        }
                + "      \"lte\" : 4,\n"
                + "  \"range\" : {\n"  
            @Override
                expectedQuery = new ConstantScoreQuery(new FieldExistsQuery(expectedFieldName));
                + "      \"lt\" : 12\n"  
            + (rangeQueryBuilder.includeUpper() ? "lte" : "lt")  
            protected MappedFieldType.Relation getRelation(QueryRewriteContext queryRewriteContext) {  
    /**  
        if (randomBoolean()) {
            }
        QueryShardContext queryShardContext = createShardContext();
                    fromInMillis = toInMillis = null;  
            + "            \""  
            + "  }\n"  
        String json = "{\n"
                        ),
                expectedQuery = new ConstantScoreQuery(new TermQuery(new Term(FieldNamesFieldMapper.NAME, expectedFieldName)));  
                }  
        assertThat(exactQuery, instanceOf(DateRangeIncludingNowQuery.class));
        DateTime queryToValue = new DateTime(2016, 1, 1, 0, 0, 0, ISOChronology.getInstanceUTC());
            + "      \""
                + "    \"timestamp\" : {\n"
        assertThat(rewrittenRange.format(), equalTo(null));
                    if (randomBoolean()) {
                    DATE_FIELD_NAME,
        Query parsedQuery = parseQuery(query).toQuery(createShardContext());
        {  
        assertThat(rewritten, sameInstance(query));
        assertEquals(IntPoint.newRangeQuery(INT_FIELD_NAME, 23, 53), parsedQuery);  
                new IndexOrDocValuesQuery(
        rangeQueryBuilder.from(randomIntBetween(1, 100)).to(randomIntBetween(101, 200));
                final Long toInMillis;
        Map<String, RangeQueryBuilder> alternateVersions = new HashMap<>();
            + "      \"time_zone\" : \"+01:00\",\n"  
        query = "{\n"
        assertThat(parsedQuery, instanceOf(ApproximateScoreQuery.class));  
            + "        \""
        QueryBuilder rewritten = query.rewrite(queryShardContext);
            new ApproximateScoreQuery(
        Query luceneQuery = rewrittenRange.toQuery(queryShardContext);
                )  
                    DATE_FIELD_NAME,
                randomFrom(ShapeRelation.CONTAINS.toString(), ShapeRelation.INTERSECTS.toString(), ShapeRelation.WITHIN.toString())  
            protected MappedFieldType.Relation getRelation(QueryRewriteContext queryRewriteContext) {  
    public void testDateRangeBoundaries() throws IOException {
        DateTime queryToValue = new DateTime(2016, 1, 1, 0, 0, 0, ISOChronology.getInstanceUTC());
    }  
            ParsingException pe = expectThrows(ParsingException.class, () -> parseQuery(json));
                + "      \"lt\" : \"2015-01-01 00:00:00\",\n"
    public void testParseRelation() {  
        RangeQueryBuilder query = new RangeQueryBuilder(fieldName) {
            + "      \"price\": {\n"
                    LongPoint.newRangeQuery(DATE_FIELD_NAME, lower, upper),  
        rangeQueryBuilder.includeUpper(randomBoolean());  
    public void testInvalidUpperBound() throws IOException {
                query.to(randomIntBetween(101, 200));
        RangeQueryBuilder parsed = (RangeQueryBuilder) parseQuery(json);  
                    ApproximatePointRangeQuery.LONG_FORMAT
            query.from(null);
                + "    \"timestamp\" : {\n"  
        assertThat(luceneQuery, equalTo(new MatchNoDocsQuery("no mappings yet")));
import static org.hamcrest.Matchers.equalTo;
 * Licensed to Elasticsearch under one or more contributor  
                    if (queryBuilder.includeLower() == false && minLong != Long.MAX_VALUE) {
            + "    \"range\": {\n"
import static org.opensearch.index.query.QueryBuilders.rangeQuery;  
                + "  \"range\" : {\n"
 */  
            + "      }"
        QueryBuilder rewritten = query.rewrite(queryShardContext);
                    pack(new long[] { upper }).bytes,  
 * compatible open source license.
                + "      \"gt\" : 5,\n"
                + "    \"timestamp\" : {\n"
        ApproximateScoreQuery approximateScoreQuery = (ApproximateScoreQuery) parsedQuery;
            + "      \"include_lower\" : true,\n"
        IllegalArgumentException e1 = expectThrows(IllegalArgumentException.class, () -> parseQuery(json));
            + "}";
        QueryBuilder rewritten = query.rewrite(queryShardContext);  
 *     http://www.apache.org/licenses/LICENSE-2.0
                break;
            + "        \""
            + "  }";
                    SortedNumericDocValuesField.newSlowRangeQuery(DATE_FIELD_NAME, lower, upper)
            + "        \"gte\": 10,\n"  
                assertThat(originalQuery, instanceOf(IndexOrDocValuesQuery.class));
        assertTrue("query should be cacheable: " + queryBuilder.toString(), context.isCacheable());
        Query originalQuery = ((ApproximateScoreQuery) parsedQuery).getOriginalQuery();
                + "}";  
            protected MappedFieldType.Relation getRelation(QueryRewriteContext queryRewriteContext) {
                + "  \"range\" : {\n"  
            + "            \"lte\": \"100\",\n"
        builder.relation("within");  
            + "      \"age\": {\n"
        expectThrows(IllegalArgumentException.class, () -> rangeQueryBuilder.format(null));
                            queryBuilder.getForceDateParser(),
                + "  }\n"  
            + "        \"relation\": \"disjoint\"\n"  
        assertThat(rewritten, instanceOf(RangeQueryBuilder.class));
        {
        String json = "{\n"
        DateTime queryToValue = new DateTime(2016, 1, 1, 0, 0, 0, ISOChronology.getInstanceUTC());
        assertEquals(  
import org.apache.lucene.search.TermRangeQuery;  
                + "  \"range\" : {\n"
/*  
    }
 *
            expectedQuery = new ConstantScoreQuery(new FieldExistsQuery(query.fieldName()));
                    pack(new long[] { lower }).bytes,
            + "      \"boost\" : 1.0\n"
                            pack(new long[] { maxLong }).bytes,
                + "  \"range\" : {\n"
                break;
                    fail("unexpected mapped field type: [" + mappedFieldType.getClass() + "] " + mappedFieldType.toString());
                    maxLong = Long.MAX_VALUE;
                TermRangeQuery termRangeQuery = (TermRangeQuery) query;
            + "        \""  
            + "            \"gte\": \"0\",\n"  
            + "}";
            parsedQuery = ((ApproximateScoreQuery) parsedQuery).getOriginalQuery();  
            assertEquals("invalid lower bound for [range] query", pe.getMessage());
            + "    \"timestamp\" : {\n"  
                return Relation.INTERSECTS;
                        )
                        ? null  
            + "            \"gte\": \"01/01/2012\",\n"
            + "    }\n"
    }
    public void testRewriteDateToSame() throws IOException {
        assertEquals(ShapeRelation.CONTAINS, builder.relation());
                + "}";
                if (mappedFieldType != null && mappedFieldType.unwrap() instanceof DateFieldMapper.DateFieldType) {
                ),
                return Relation.INTERSECTS;  
            final String json = "{\n"
            );
            + "        \"gte\": \"2016-09-13 05:01:14\"\n"
        }
        QueryShardContext queryShardContextWithUnkType = createShardContextWithNoType();
            + "      \"boost\" : 1.0,\n"  
        query.includeLower(randomBoolean()).includeUpper(randomBoolean());  
            + "      \"to\" : \"now\",\n"
        );
                    LongPoint.newRangeQuery(DATE_FIELD_NAME, lower, upper),  
        // Range query with open bounds rewrite to an exists query
            }  
            + DATE_FIELD_NAME  
            final String json = "{\n"  
        {  
                + "}";
            + "\": {\n"  
                } else {
        ApproximateQuery approximationQuery = approximateScoreQuery.getApproximationQuery();
        );
                        );
            } else {
            + "            \"gte\": \"01/01/2012\",\n"
            + "            \"lte\": \"2014-12-08||/d\"\n"  
        expectThrows(IllegalArgumentException.class, () -> new RangeQueryBuilder(""));  
                        : ((DateFieldMapper.DateFieldType) mappedFieldType).parseToLong(
        String json = "{\n"
 * The OpenSearch Contributors require contributions made to  
            + "}";
        assertEquals(  
        assertThat(rewrittenRange.to(), equalTo(null));  
            + "        \""
        expectThrows(IllegalArgumentException.class, () -> rangeQueryBuilder.timeZone("badID"));
        if (queryBuilder.from() == null && queryBuilder.to() == null) {
                        new ApproximatePointRangeQuery(
import org.apache.lucene.search.IndexOrDocValuesQuery;
                // todo can't check RangeFieldQuery because its currently package private (this will change)
        Query parsedQuery = rangeQuery(INT_FIELD_NAME).from(23).to(54).includeLower(true).includeUpper(false).toQuery(createShardContext());
            + "            \"format\": \"yyyy\"\n"
            } else if (expectedFieldName.equals(DATE_RANGE_FIELD_NAME) || expectedFieldName.equals(INT_RANGE_FIELD_NAME)) {  
                + "    \"timestamp\" : {\n"  
                assertThat(termRangeQuery.includesLower(), equalTo(queryBuilder.includeLower()));  
            + "      },\n"
        context = createShardContext();  
        query.from(queryFromValue);
 * this work for additional information regarding copyright
        String query = "{\n"  
                throw new UnsupportedOperationException();  
            assertEquals("invalid lower bound for [range] query", pe.getMessage());  
            + "  }";  
            + "            \"format\": \"dd/MM/yyyy||yyyy\"\n"  
/*  
                + "}";
        query.from(queryFromValue);  
                    SortedNumericDocValuesField.newSlowRangeQuery(DATE_FIELD_NAME, lower, upper)
        // since age is automatically registered in data, we encode it as numeric
            + "\" : {\n"
        String fieldName = DATE_FIELD_NAME;  
            + "            \"lte\": \"now\",\n"  
            + DATE_FIELD_NAME  
                + "      \"boost\" : 1.0\n"  
        assertThat(parsedQuery, instanceOf(IndexOrDocValuesQuery.class));  
        assertEquals("[range] query does not support relation [disjoint]", e1.getMessage());  
            + "        }\n"
 * ownership. Elasticsearch licenses this file to you under  
            + "    \"range\":{\n"
    }
                assertThat(query, instanceOf(TermRangeQuery.class));
                Integer max = (Integer) queryBuilder.to();  
    public void testIllegalArguments() {
        RangeQueryBuilder rewrittenRange = (RangeQueryBuilder) rewritten;  
                )  
            @Override
import org.opensearch.search.approximate.ApproximateScoreQuery;  
                ZonedDateTime start = now.minusMillis(randomIntBetween(0, 1000000)).atZone(ZoneOffset.UTC);  
                + "      \"lt\" : 12\n"
    }
                + "  \"range\" : {\n"
        assertNotNull(parseQuery(json));
public class RangeQueryBuilderTests extends AbstractQueryTestCase<RangeQueryBuilder> {  
        Query exactQuery = approximateScoreQuery.getOriginalQuery();
    }
        DateTime queryFromValue = new DateTime(2015, 1, 1, 0, 0, 0, ISOChronology.getInstanceUTC());  
        }
                + "      \"lt\" : 12\n"
                + "      \"gt\" : 5,\n"
    }  
                + "      \"time_zone\" : \"+01:00\",\n"
            + "    }\n"
        assertFalse("query should not be cacheable: " + queryBuilder.toString(), context.isCacheable());  
                expectedQuery = new ConstantScoreQuery(new FieldExistsQuery(expectedFieldName));
        assertThat(parsedQuery, instanceOf(ApproximateScoreQuery.class));
                            LongPoint.newRangeQuery(DATE_FIELD_NAME, minLong, maxLong),
                if (max == null) {  
            + "    \"range\" : {\n"
                MappedFieldType mappedFieldType = mapperService.fieldType(expectedFieldName);  
            assertEquals("invalid lower bound for [range] query", pe.getMessage());
                    }
                assertThat(query, instanceOf(ApproximateScoreQuery.class));
            ,  
            }
import static org.apache.lucene.document.LongPoint.pack;
                            queryBuilder.getForceDateParser(),
            final String json = "{\n"  
                ),
        assertEquals("[range] query doesn't support multiple fields, found [age] and [" + DATE_FIELD_NAME + "]", e.getMessage());  
            + "}";
            && expectedFieldName.equals(DATE_RANGE_FIELD_NAME) == false
        QueryShardContext context = createShardContext();
        RangeQueryBuilder query = new RangeQueryBuilder(fieldName) {  
import org.apache.lucene.search.FieldExistsQuery;  
            + "    \"range\" : {\n"
        String json = "{\n"
    }  
            assertEquals("invalid upper bound for [range] query", pe.getMessage());
                    maxLong = max.longValue();  
                + "      \"include_lower\" : true,\n"
            + "        \"lte\": 30\n"
            + "        }\n"
                        new IndexOrDocValuesQuery(
                    maxInt = Integer.MAX_VALUE;
            + "        \"gte\": 30,\n"
                    fromInMillis = queryBuilder.from() == null
        upper = DateTime.parse("2014-12-08T00:00:00.000+00").getMillis() - 1;
                + "      \"lt\" : 12,\n"  

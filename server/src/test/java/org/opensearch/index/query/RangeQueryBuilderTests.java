    public void testDateRangeQueryTimezone() throws IOException {
                return Relation.WITHIN;
        String query = "{\n"
        queryBuilder.toQuery(createShardContext()); // no exception
            } else if (expectedFieldName.equals(DATE_FIELD_NAME)) {
            } else if (expectedFieldName.equals(INT_FIELD_NAME)) {
            assertEquals("invalid upper bound for [range] query", pe.getMessage());
                + "}";
import org.apache.lucene.search.MatchNoDocsQuery;
            case 2:
        }
            assertEquals("invalid lower bound for [range] query", pe.getMessage());
import org.apache.lucene.search.ConstantScoreQuery;
                query = new RangeQueryBuilder(randomFrom(DATE_FIELD_NAME, DATE_RANGE_FIELD_NAME, DATE_ALIAS_FIELD_NAME));
                + "    }\n"
                        maxLong--;
                } else {
            + "    }\n"
        String json = "{\n"
                // we have to normalize the incoming value into milliseconds since it could be literally anything
                    if (randomBoolean()) {
    public void testIllegalArguments() {
            + INT_FIELD_NAME
import org.joda.time.DateTime;
            + "}";
            query.to(null);
        assertThat(rewritten, sameInstance(query));
                            new long[] { minLong }.length,
        query.from(queryFromValue);
            + "    \"timestamp\" : {\n"
        } else if (expectedFieldName.equals(DATE_FIELD_NAME) == false
        expectThrows(IllegalArgumentException.class, () -> new RangeQueryBuilder(""));
        Query parsedQuery = parseQuery(query).toQuery(context);
            + "}";
            + "\" : {\n"
 * GitHub history for details.
        query.timeZone(randomZone().getId());
                }
        String json = "{\n"
                        maxInt--;
        assertThat(rewrittenRange.from(), equalTo(null));
            + "      \"boost\" : 1.0\n"
        String json = "{\n"
            + "            \"gt\": \"2014-11-05||/M\",\n"
    public void testDateRangeQueryFormat() throws IOException {
                    fromInMillis = toInMillis = null;
            + "    }\n"
                + "      \"lt\" : 12\n"
        DateTime queryFromValue = new DateTime(2015, 1, 1, 0, 0, 0, ISOChronology.getInstanceUTC());
            + rangeQueryBuilder.from()
        QueryBuilder queryBuilder = parseQuery(query);
 * Licensed to Elasticsearch under one or more contributor
                        // - index versionCreated before legacy V_7_0_0
            + "    \"range\" : {\n"
import org.apache.lucene.search.TermRangeQuery;
            + "            \"gte\": \"2014-11-05||/M\",\n"
                expectedQuery = new ConstantScoreQuery(new FieldExistsQuery(expectedFieldName));
                if (min == null) {
                + "  \"range\" : {\n"
        // since age is automatically registered in data, we encode it as numeric
                        : ((DateFieldMapper.DateFieldType) mappedFieldType).parseToLong(
        assertEquals(
                    maxLong = max.longValue();
            query.relation(
 *     http://www.apache.org/licenses/LICENSE-2.0
                ),
                    LongPoint.newRangeQuery(DATE_FIELD_NAME, lower, upper),
        assertThat(rewrittenRange.to(), equalTo(null));
            } else if (context.getMapperService().fieldType(queryBuilder.fieldName()).getTextSearchInfo().hasNorms()) {
                }
            + "        \"gte\": 30,\n"
                new IndexOrDocValuesQuery(
                new IndexOrDocValuesQuery(
        QueryShardContext context = createShardContext();
            assertEquals("invalid lower bound for [range] query", pe.getMessage());
        // queries on date fields using "now" should not be cached
                    LongPoint.newRangeQuery(DATE_FIELD_NAME, lower, upper),
package org.opensearch.index.query;
            + "\": {\n"
                            queryBuilder.includeUpper(),
        }
                    LongPoint.newRangeQuery(DATE_FIELD_NAME, lower, upper),
                + "      \"lt\" : \"2015-01-01 00:00:00\",\n"
                + "      \"lt\" : 12\n"
                    if (randomBoolean()) {
        assertThat(parsedQuery, instanceOf(PointRangeQuery.class));
                )
            + "\" : {\n"
                        new ApproximatePointRangeQuery(
    public void testNamedQueryParsing() throws IOException {
            ParsingException pe = expectThrows(ParsingException.class, () -> parseQuery(json));
            }
                    }
                        // - no "forced" date parser through a format parameter
            protected MappedFieldType.Relation getRelation(QueryRewriteContext queryRewriteContext) {
            final String json = "{\n"
                + "      \"lt\" : 12\n"
        assertThat(rewritten, instanceOf(MatchNoneQueryBuilder.class));
                }
        lower = DateTime.parse("2014-11-30T23:59:59.999+00").getMillis() + 1;
    }
            + "  }\n"
            + INT_FIELD_NAME
            + "            \""
            assertEquals("invalid upper bound for [range] query", pe.getMessage());
            + "            \"format\": \"dd/MM/yyyy||yyyy\"\n"
            }
            + "      \"time_zone\" : \"+01:00\",\n"
            @Override
import java.io.IOException;
            + "        \"gte\": 30,\n"
        assertThat(parsedQuery, instanceOf(ApproximateScoreQuery.class));
                query = new RangeQueryBuilder(randomFrom(INT_FIELD_NAME, INT_RANGE_FIELD_NAME, INT_ALIAS_FIELD_NAME));
                + "      \"gte\" : 4,\n"
        assertNotNull(rewriteQuery.toQuery(context));
                + "      \"gt\" : 5,\n"
            && expectedFieldName.equals(INT_FIELD_NAME) == false
            + DATE_FIELD_NAME
        rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
                expectedQuery = new ConstantScoreQuery(new TermQuery(new Term(FieldNamesFieldMapper.NAME, expectedFieldName)));
                    }
                MappedFieldType mappedFieldType = mapperService.fieldType(expectedFieldName);
                    }
        query.from(queryFromValue);
        QueryShardContext queryShardContext = createShardContext();
            + "      },\n"
                Long min = fromInMillis;
        };
            }
                throw new UnsupportedOperationException();
                            queryBuilder.includeLower(),
    @Override
            + "            \"lt\": \"2030\",\n"
import static org.hamcrest.Matchers.equalTo;
                    pack(new long[] { upper }).bytes,
        }
        // TODO what else can we assert
        QueryBuilder rewritten = query.rewrite(queryShardContext);
    }
                + "}";
            + "        \""
                + "    }\n"
                        ? null
    public void testRewriteOpenBoundsToSame() throws IOException {
        QueryShardContext queryShardContext = createShardContext();
    protected void doAssertLuceneQuery(RangeQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
                query.from(randomIntBetween(1, 100));
    protected Map<String, RangeQueryBuilder> getAlternateVersions() {
                + "    \"timestamp\" : {\n"
                + "}";
                + "      \"gt\" : 5,\n"
            assertEquals("invalid upper bound for [range] query", pe.getMessage());
        assertThat(rewritten, instanceOf(RangeQueryBuilder.class));
        assertNotNull(parseQuery(json));
        RangeQueryBuilder query;
import org.opensearch.index.mapper.MappedFieldType;
                            context::nowInMillis
            );
            + "            \"lte\": \"2014-12-08||/d\"\n"
        String fieldName = randomAlphaOfLengthBetween(1, 20);
                + "}";
    }
        // The exact query should be DateRangeIncludingNowQuery
 *
 * Unless required by applicable law or agreed to in writing,
    }
                return Relation.WITHIN;
            + "        }\n"
                if (createShardContext().getMapperService().fieldType(DATE_FIELD_NAME) != null) {
            + "        \"relation\": \"disjoint\"\n"
                long minLong, maxLong;
 * this work for additional information regarding copyright
                    pack(new long[] { upper }).bytes,
                    new long[] { lower }.length,
                    if (queryBuilder.includeUpper() == false && maxLong != Long.MIN_VALUE) {
            + "        }\n"
            + "\n"
                } else {
        DateTime queryToValue = new DateTime(2016, 1, 1, 0, 0, 0, ISOChronology.getInstanceUTC());
                + "  }\n"
 * not use this file except in compliance with the License.
     */
            } else {
        switch (randomIntBetween(0, 2)) {
        };
        builder.relation("within");
        } else {
        };
                Integer max = (Integer) queryBuilder.to();
            + ",\n"
            parsedQuery
            assertThat(query, equalTo(expectedQuery));
                + "  }\n"
                            DATE_FIELD_NAME,
        assertThat(rewrittenRange.format(), equalTo(null));
                + "}";
            + "      \"from\" : \"2015-01-01 00:00:00\",\n"
                assertThat(originalQuery, instanceOf(IndexOrDocValuesQuery.class));
            + "    \"range\": {\n"
import org.apache.lucene.search.FieldExistsQuery;
            final String json2 = "{\n"
                + "      \"lte\" : 4,\n"
    public void testRewriteDateToMatchAllWithTimezoneAndFormat() throws IOException {
            + "        \"gte\": 30,\n"
                + "      \"boost\" : 1.0\n"
            )
            parsedQuery = ((ApproximateScoreQuery) parsedQuery).getOriginalQuery();
            ParsingException pe = expectThrows(ParsingException.class, () -> parseQuery(json));
                + "      \"time_zone\" : \"+01:00\",\n"
        String query = "{\n"
            + "\" : {\n"
        DateTime queryToValue = new DateTime(2016, 1, 1, 0, 0, 0, ISOChronology.getInstanceUTC());
 * specific language governing permissions and limitations
            + "    }\n"
                break;
        RangeQueryBuilder query = new RangeQueryBuilder(fieldName) {
            + "    }\n"
    public void testInvalidLowerBound() {
                return Relation.INTERSECTS;
            + "  }";
                    minInt = Integer.MIN_VALUE;
            + "      }\n"
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
        assertThat(rewrittenRange.from(), equalTo(null));
            ParsingException pe = expectThrows(ParsingException.class, () -> parseQuery(json));
            final String json = "{\n"
        long lower = DateTime.parse("2014-11-01T00:00:00.000+00").getMillis();
                query.to("z" + randomAlphaOfLengthBetween(1, 10));
        expectThrows(IllegalArgumentException.class, () -> rangeQueryBuilder.timeZone(null));
        RangeQueryBuilder parsed = (RangeQueryBuilder) parseQuery(json);
        QueryBuilder rewritten = query.rewrite(queryShardContext);
            @Override
                    new long[] { lower }.length,
                + "  }\n"
import org.opensearch.search.approximate.ApproximatePointRangeQuery;
            + "}";
            + "      \"age\": {\n"
                final Long toInMillis;
            + "}";
            ParsingException pe = expectThrows(ParsingException.class, () -> parseQuery(json2));
        {
        DateTime queryToValue = new DateTime(2016, 1, 1, 0, 0, 0, ISOChronology.getInstanceUTC());
            + DATE_FIELD_NAME
            + DATE_FIELD_NAME
                assertThat(approximationQuery, instanceOf(ApproximateQuery.class));
                        // - one of the SystemV* time zones that Jodas DateTimeZone parser doesn't know about
                int minInt, maxInt;
    @Override
        {
    }
            ),
            + "      \"to\" : \"now\",\n"
        assertFalse("query should not be cacheable: " + queryBuilder.toString(), context.isCacheable());
                        );
    }
/*
        String fieldName = randomAlphaOfLengthBetween(1, 20);
                + "      \"to\" : \"now\",\n"
 * SPDX-License-Identifier: Apache-2.0
    }
            + "        }\n"
            + "        \""
                        query.timeZone(zoneId);
            ,
        }
                    if (queryBuilder.includeUpper() == false && maxInt != Integer.MIN_VALUE) {
                + "  \"range\" : {\n"
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at
        // Test Invalid format
            + "      \"to\" : \"now\",\n"
            + "            \"time_zone\": \"+01:00\"\n"
import org.apache.lucene.index.Term;
                query = new RangeQueryBuilder(randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME));
            + "\": {\n"
        RangeQueryBuilder rewrittenRange = (RangeQueryBuilder) rewritten;
            new ApproximateScoreQuery(
        query.to(queryToValue);
                + "    \"timestamp\" : {\n"
        {
                        )
        ApproximateScoreQuery approximateScoreQuery = (ApproximateScoreQuery) parsedQuery;
                assertThat(query, instanceOf(ApproximateScoreQuery.class));
                        String zoneId = randomValueOtherThanMany(zi -> zi.getId().startsWith("SystemV"), () -> randomZone()).getId();
    }
        assertThat(rewrittenRange.to(), equalTo(null));
    /**
        long upper = DateTime.parse("2014-12-08T23:59:59.999+00").getMillis();
            + "    }\n"
        String query = "{\n"
import org.opensearch.search.approximate.ApproximateScoreQuery;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            + "      \"age\": {\n"
                    toInMillis = queryBuilder.to() == null
        assertThat(approximationQuery, instanceOf(ApproximatePointRangeQuery.class));
                            queryBuilder.getForceDateParser(),
            + "        \"gte\": \"2016-09-13 05:01:14\"\n"
        assertThat(rewrittenRange.fieldName(), equalTo(fieldName));
                    new ApproximateScoreQuery(
                query.to(DateFieldMapper.getDefaultDateTimeFormatter().format(end));
import org.opensearch.common.lucene.BytesRefs;
        // We test 01/01/2012 from gte and 2030 for lt
            + "    \"range\" : {\n"
                            queryBuilder.to(),
            + "            \""
                    minLong = Long.MIN_VALUE;
        query.to(queryToValue);
            + "    \"range\" : {\n"
        }
                            pack(new long[] { minLong }).bytes,
                        new IndexOrDocValuesQuery(
            + DATE_FIELD_NAME
        RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder("test");
                    minLong = min.longValue();
    public void testRewriteDateToSame() throws IOException {
            ParsingException pe = expectThrows(ParsingException.class, () -> parseQuery(json));
import java.time.ZonedDateTime;
        assertThat(exactQuery, instanceOf(DateRangeIncludingNowQuery.class));
                    maxLong = Long.MAX_VALUE;
                query.from(DateFieldMapper.getDefaultDateTimeFormatter().format(start));
    public void testRewriteDateToMatchAll() throws IOException {
                            context::nowInMillis
                            queryBuilder.getDateTimeZone(),
            + "            \"gte\": \"2012-01-01\",\n"
            + "            \"gte\": \"0\",\n"
            + "    \"range\":{\n"
        QueryBuilder rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
            + "      \"_name\" : \"my_range\"\n"
                ZonedDateTime start = now.minusMillis(randomIntBetween(0, 1000000)).atZone(ZoneOffset.UTC);
        parsedQuery = parseQuery(query).toQuery(createShardContext());
                    }
        if (randomBoolean()) {
            new ApproximateScoreQuery(
        }
                Long max = toInMillis;
        assertEquals(
                final Long fromInMillis;
        );
                expectedQuery = new ConstantScoreQuery(new FieldExistsQuery(expectedFieldName));
        query.to(queryToValue);
 * under the License.
            final String json = "{\n"
        Query approximationQuery = ((ApproximateScoreQuery) parsedQuery).getApproximationQuery();
        assertThat(rewritten, instanceOf(RangeQueryBuilder.class));
                + "      \"from\" : \"2015-01-01 00:00:00\",\n"
                        query.format(format);
                + "      \"lt\" : 12,\n"
                    pack(new long[] { lower }).bytes,
        query.to(queryToValue);
import java.util.HashMap;
            + "            \"lt\": \"2030\",\n"
                // Create timestamp option only then we have a date mapper,
                            queryBuilder.getDateTimeZone(),
        {
            + "      },\n"
    }
                Instant now = Instant.now();
        // Get the exact query from ApproximateScoreQuery (which should be DateRangeIncludingNowQuery)
            + "\" : {\n"
    public void testRewriteDateToMatchNone() throws IOException {
                }
                            queryBuilder.from(),
        ApproximateQuery approximationQuery = approximateScoreQuery.getApproximationQuery();
                + "      \"from\" : 4,\n"
            case 1:
import static org.hamcrest.Matchers.sameInstance;
            + "}";
                + "  \"range\" : {\n"
        final String invalidQuery = "{\n"
                Query approximationQuery = ((ApproximateScoreQuery) query).getApproximationQuery();
        RangeQueryBuilder rewrittenRange = (RangeQueryBuilder) rewritten;
            + "        \"lte\": 40\n"
        }
                assertThat(originalQuery, instanceOf(IndexOrDocValuesQuery.class));
            case 0:
            final String json = "{\n"
import org.apache.lucene.document.LongPoint;
                new IndexOrDocValuesQuery(
    public void testToQueryNumericField() throws IOException {
                + "    \"timestamp\" : {\n"
                ),
        rangeQueryBuilder.includeLower(randomBoolean());
        {
            + "        }\n"
    protected RangeQueryBuilder doCreateTestQueryBuilder() {
                } else {
        QueryBuilder rewritten = query.rewrite(queryShardContext);
                        String format = "strict_date_optional_time";
                    if (queryBuilder.includeLower() == false && minLong != Long.MAX_VALUE) {
            + "    }\n"
            + "    \"range\" : {\n"
                + "      \"to\" : 12\n"
                );
                + "  }\n"
                    pack(new long[] { lower }).bytes,
        assertEquals(ShapeRelation.INTERSECTS, builder.relation());
            }
        QueryShardContext queryShardContext = createShardContext();
        DateTime queryFromValue = new DateTime(2015, 1, 1, 0, 0, 0, ISOChronology.getInstanceUTC());
        {
        String fieldName = DATE_FIELD_NAME;
                + "  \"range\" : {\n"
            + "      \"age\": {\n"
                + "      \"lt\" : 12\n"
                + "      \"gt\" : 5,\n"
            + "            \"format\": \"yyyy\"\n"
                Integer min = (Integer) queryBuilder.from();
                    query
        QueryBuilder rewritten = query.rewrite(queryShardContext);
            protected MappedFieldType.Relation getRelation(QueryRewriteContext queryRewriteContext) {
    public void testParseFailsWithMultipleFieldsWhenOneIsDate() {
                    ),
                // use mapped date field, using date string representation
        assertEquals("[range] query doesn't support multiple fields, found [age] and [price]", e.getMessage());
        RangeQueryBuilder query = new RangeQueryBuilder(fieldName) {
        }
        DateTime queryToValue = new DateTime(2016, 1, 1, 0, 0, 0, ISOChronology.getInstanceUTC());
            }
                break;
                + "}";
                // todo can't check RangeFieldQuery because its currently package private (this will change)
                    }
        IllegalArgumentException e2 = expectThrows(IllegalArgumentException.class, () -> builder.relation("disjoint"));
            if (context.getMapperService().fieldType(queryBuilder.fieldName()).hasDocValues()) {
 */
                        );
 */
                    maxInt = max.intValue();
            protected MappedFieldType.Relation getRelation(QueryRewriteContext queryRewriteContext) {
        QueryBuilder rewritten = query.rewrite(queryShardContext);
            + "        }\n"
        );
                    minInt = min.intValue();
            + "    \"range\": {\n"
import org.apache.lucene.search.IndexOrDocValuesQuery;
        assertEquals(IntPoint.newRangeQuery(INT_FIELD_NAME, 23, 53), parsedQuery);
import org.apache.lucene.search.PointRangeQuery;
        assertThat(luceneQuery, equalTo(expectedQuery));
            + "    }\n"
            + "      }"
        RangeQueryBuilder query = new RangeQueryBuilder(fieldName) {
        RangeQueryBuilder builder = new RangeQueryBuilder(fieldName);
import org.opensearch.search.approximate.ApproximateQuery;
                    }
                query.to(randomIntBetween(101, 200));
                new ApproximatePointRangeQuery(
    }
            assertEquals("invalid lower bound for [range] query", pe.getMessage());
                if (mappedFieldType != null && mappedFieldType.unwrap() instanceof DateFieldMapper.DateFieldType) {
        rangeQueryBuilder.includeUpper(randomBoolean());
 * Modifications Copyright OpenSearch Contributors. See
                Query originalQuery = ((ApproximateScoreQuery) query).getOriginalQuery();
    public void testFromJson() throws IOException {
            + "    \"range\" : {\n"
                    new long[] { lower }.length,
            + "      \"boost\" : 1.0,\n"
            + "        \"gte\": 10,\n"
        Query exactQuery = approximateScoreQuery.getOriginalQuery();
            + "        \""
        assertThat(rewritten, sameInstance(query));
/*
                return Relation.INTERSECTS;
        QueryShardContext queryShardContextWithUnkType = createShardContextWithNoType();
    }
import org.opensearch.OpenSearchParseException;
        assertEquals(
        };
import org.opensearch.core.common.ParsingException;
        if (parsedQuery instanceof ApproximateScoreQuery) {
            } else if (expectedFieldName.equals(DATE_RANGE_FIELD_NAME) || expectedFieldName.equals(INT_RANGE_FIELD_NAME)) {
            + "      \"include_upper\" : true,\n"
    }
            parsedQuery
    public void testInvalidUpperBound() throws IOException {
                + "    \"timestamp\" : {\n"
        assertEquals(ShapeRelation.WITHIN, builder.relation());
            + "      \"from\" : \"2015-01-01 00:00:00\",\n"
                    SortedNumericDocValuesField.newSlowRangeQuery(DATE_FIELD_NAME, lower, upper)
                // otherwise we could trigger exception.
            parsedQuery
                ),
            + "        \"lte\": 40,\n"
            final String json = "{\n"
        RangeQueryBuilder queryBuilder = createTestQueryBuilder();
    public void testDateRangeBoundaries() throws IOException {
                assertThat(termRangeQuery.getField(), equalTo(expectedFieldName));
                assertThat(termRangeQuery.getUpperTerm(), equalTo(BytesRefs.toBytesRef(queryBuilder.to())));
            + "        \"lte\": 30\n"
        String expectedFieldName = expectedFieldName(queryBuilder.fieldName());
                assertThat(termRangeQuery.getLowerTerm(), equalTo(BytesRefs.toBytesRef(queryBuilder.from())));
        return alternateVersions;
        RangeQueryBuilder rangeQueryBuilder = new RangeQueryBuilder(INT_FIELD_NAME);
            query.from(null);
 *
        builder.relation("intersects");
            + "    \"range\" : {\n"
    }
        }
        RangeQueryBuilder query = new RangeQueryBuilder(fieldName) {
                if (max == null) {
                + "      \"include_lower\" : true,\n"
                    ApproximatePointRangeQuery.LONG_FORMAT
                        : ((DateFieldMapper.DateFieldType) mappedFieldType).parseToLong(
import org.apache.lucene.search.Query;
            + "    \"range\": {\n"
    public void testParseFailsWithMultipleFields() {
                    SortedNumericDocValuesField.newSlowRangeQuery(DATE_FIELD_NAME, lower, upper)
                            pack(new long[] { maxLong }).bytes,
            }
        // switch between numeric and date ranges
        String json = "{\n"
        String fieldName = randomAlphaOfLengthBetween(1, 20);
        if (query.fieldName().equals(INT_RANGE_FIELD_NAME) || query.fieldName().equals(DATE_RANGE_FIELD_NAME)) {
            + "            \"lte\": \"now\",\n"
        query.from(queryFromValue);
                + "  \"range\" : {\n"
                ZonedDateTime end = now.plusMillis(randomIntBetween(0, 1000000)).atZone(ZoneOffset.UTC);
                return Relation.DISJOINT;
        }
        query.from(queryFromValue);
        parsedQuery = ((IndexOrDocValuesQuery) parsedQuery).getIndexQuery();
 * KIND, either express or implied.  See the License for the
        query = "{\n"
                if (max == null) {
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
import org.opensearch.index.mapper.MapperService;
     * Range queries should generally be cacheable, at least the ones we create randomly.
                + "  \"range\" : {\n"
        query.format("yyyy-MM-dd");
                + "    }\n"
                    fromInMillis = queryBuilder.from() == null
        QueryShardContext queryShardContext = createShardContext();
        expectThrows(IllegalArgumentException.class, () -> new RangeQueryBuilder((String) null));
     * This test makes sure we also test the non-cacheable cases regularly.
        QueryShardContext queryShardContext = createShardContext();
                            queryBuilder.getForceDateParser(),
        assertEquals("[range] query does not support relation [disjoint]", e2.getMessage());
        alternateVersions.put(query, rangeQueryBuilder);
            assertEquals("invalid upper bound for [range] query", pe.getMessage());
            + (rangeQueryBuilder.includeLower() ? "gte" : "gt")
 * this file be licensed under the Apache-2.0 license or a
                + "    }\n"
            + "        \"lte\": 40\n"
        DateTime queryFromValue = new DateTime(2015, 1, 1, 0, 0, 0, ISOChronology.getInstanceUTC());
                }
                    if (queryBuilder.includeLower() == false && minInt != Integer.MAX_VALUE) {
import static org.hamcrest.Matchers.instanceOf;
            @Override
                TermRangeQuery termRangeQuery = (TermRangeQuery) query;
            + "  \"range\" : {\n"
        query = "{\n"
                        ),
        context = createShardContext();
                )
        Query parsedQuery = parseQuery(query).toQuery(createShardContext());
            + "      \"include_lower\" : true,\n"
        assertTrue("query should be cacheable: " + queryBuilder.toString(), context.isCacheable());
        QueryShardContext context = createShardContext();
                    maxInt = Integer.MAX_VALUE;
                randomFrom(ShapeRelation.CONTAINS.toString(), ShapeRelation.INTERSECTS.toString(), ShapeRelation.WITHIN.toString())
            + (rangeQueryBuilder.includeUpper() ? "lte" : "lt")
            final Query expectedQuery;
        expectThrows(IllegalArgumentException.class, () -> rangeQueryBuilder.timeZone("badID"));
                    DATE_FIELD_NAME,
        Query originalQuery = ((ApproximateScoreQuery) parsedQuery).getOriginalQuery();
    }
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
    }
                            ApproximatePointRangeQuery.LONG_FORMAT
            + "\" : {\n"
        assertEquals("[range] query doesn't support multiple fields, found [age] and [" + DATE_FIELD_NAME + "]", e.getMessage());
            + "  }\n"
        if (randomBoolean()) {
                    DATE_FIELD_NAME,
                Query approximationQuery = ((ApproximateScoreQuery) query).getApproximationQuery();
                + "      \"lt\" : 12,\n"
            ,
import org.apache.lucene.search.TermQuery;
        RangeQueryBuilder query = new RangeQueryBuilder(fieldName) {
                        ? null
        assertThat(approximationQuery, instanceOf(ApproximateQuery.class));
        expectThrows(IllegalArgumentException.class, () -> rangeQueryBuilder.format("badFormat"));
                + "      \"gt\" : 5,\n"
                assertThat(query, instanceOf(TermRangeQuery.class));
import java.util.Map;
        Map<String, RangeQueryBuilder> alternateVersions = new HashMap<>();
    }
                    fail("unexpected mapped field type: [" + mappedFieldType.getClass() + "] " + mappedFieldType.toString());
                + "      \"include_lower\" : true,\n"
import static org.apache.lucene.document.LongPoint.pack;
        Query parsedQuery = rangeQuery(INT_FIELD_NAME).from(23).to(54).includeLower(true).includeUpper(false).toQuery(createShardContext());
                new ApproximatePointRangeQuery(
                assertThat(query, instanceOf(ApproximateScoreQuery.class));
        );
import org.opensearch.index.mapper.MappedFieldType.Relation;
            expectedQuery = new ConstantScoreQuery(new TermQuery(new Term(FieldNamesFieldMapper.NAME, query.fieldName())));
            + "\": "
            ParsingException pe = expectThrows(ParsingException.class, () -> parseQuery(json));
            + "    }\n"
            + DATE_FIELD_NAME
                )
        assertEquals(json, "2015-01-01 00:00:00", parsed.from());
                            LongPoint.newRangeQuery(DATE_FIELD_NAME, minLong, maxLong),
                + "}";
            + "            \"time_zone\": \"-01:00\"\n"
                    pack(new long[] { lower }).bytes,
        return query;
                if (min == null) {
        queryBuilder = new RangeQueryBuilder(randomFrom(DATE_FIELD_NAME, DATE_RANGE_FIELD_NAME, DATE_ALIAS_FIELD_NAME));
            + "  \"range\" : {\n"
            default:
            + "    }\n"
            protected MappedFieldType.Relation getRelation(QueryRewriteContext queryRewriteContext) {
public class RangeQueryBuilderTests extends AbstractQueryTestCase<RangeQueryBuilder> {
                    ApproximatePointRangeQuery.LONG_FORMAT
            + "      }\n"
                + "    \"timestamp\" : {\n"
                            SortedNumericDocValuesField.newSlowRangeQuery(DATE_FIELD_NAME, minLong, maxLong)
                assertEquals(
        String fieldName = randomAlphaOfLengthBetween(1, 20);
            + "        }\n"
    @Override
    public void testCacheability() throws IOException {
            + "}";
            )
                    DATE_FIELD_NAME,
            + "\" : {\n"
            + "\": "
                // use mapped integer field for numeric range queries
                + "    }\n"
            + "        \""
        queryBuilder.to("now");
                query.from("a" + randomAlphaOfLengthBetween(1, 10));
import org.apache.lucene.document.IntPoint;
        Query luceneQuery = rewrittenRange.toQuery(queryShardContext);
                Query originalQuery = ((ApproximateScoreQuery) query).getOriginalQuery();
                MapperService mapperService = context.getMapperService();
        String query = "{\n"
                break;
        assertThat(parsedQuery, instanceOf(IndexOrDocValuesQuery.class));
                + "  \"range\" : {\n"
        long lower = DateTime.parse("2012-01-01T00:00:00.000+00").getMillis();
        luceneQuery = rewrittenRange.toQuery(queryShardContextWithUnkType);
                        minInt++;
            + "            \"gte\": \"01/01/2012\",\n"
            + "    }\n"
        if (queryShardContext.fieldMapper(query.fieldName()).hasDocValues()) {
            + "            \"gte\": \"01/01/2012\",\n"
                + "      \"include_upper\" : true\n"
            + "        \""
        expectThrows(OpenSearchParseException.class, () -> parseQuery(invalidQuery).toQuery(createShardContext()));
        }
        assertThat(luceneQuery, equalTo(new MatchNoDocsQuery("no mappings yet")));
            @Override
        assertEquals(json, "now", parsed.to());
            + "}\n";
            + "}";
            + "        }\n"
            expectedQuery = new ConstantScoreQuery(new FieldExistsQuery(query.fieldName()));
            + "  }";
 */
        DateTime queryFromValue = new DateTime(2015, 1, 1, 0, 0, 0, ISOChronology.getInstanceUTC());
                + "    \"timestamp\" : {\n"
            } else {
        expectThrows(IllegalArgumentException.class, () -> rangeQueryBuilder.format(null));
        {
            + "            \"lte\": \"100\",\n"
                } else {
        }
                + "  }\n"
        String json = "{\n"
        assertNotNull(rewriteQuery.toQuery(context));
                    SortedNumericDocValuesField.newSlowRangeQuery(DATE_FIELD_NAME, lower, upper)
            + rangeQueryBuilder.to()
import org.opensearch.common.geo.ShapeRelation;
        String fieldName = DATE_FIELD_NAME;
                new ApproximatePointRangeQuery(
            ParsingException pe = expectThrows(ParsingException.class, () -> parseQuery(json));
        }
                    ApproximatePointRangeQuery.LONG_FORMAT
 * The OpenSearch Contributors require contributions made to
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
    }
        assertThat(originalQuery, instanceOf(IndexOrDocValuesQuery.class));
                + "    }\n"
            && expectedFieldName.equals(INT_RANGE_FIELD_NAME) == false) {
                + "  }\n"
import org.apache.lucene.document.SortedNumericDocValuesField;
        long upper = DateTime.parse("2030-01-01T00:00:00.000+00").getMillis() - 1;
        assertEquals(ShapeRelation.CONTAINS, builder.relation());
import org.opensearch.index.mapper.FieldNamesFieldMapper;
import org.opensearch.test.AbstractQueryTestCase;
        assertThat(parsedQuery, instanceOf(ApproximateScoreQuery.class));
        query.includeLower(randomBoolean()).includeUpper(randomBoolean());
            + "    }\n"
                + "    \"timestamp\" : {\n"
    public void testParseRelation() {
            final String json = "{\n"
import org.joda.time.chrono.ISOChronology;
            protected MappedFieldType.Relation getRelation(QueryRewriteContext queryRewriteContext) {
            + "}";
        checkGeneratedJson(json, parsed);
    @Override
    }
 * license agreements. See the NOTICE file distributed with
            @Override
            + "      \"price\": {\n"
        };
            new ApproximateScoreQuery(
 * ownership. Elasticsearch licenses this file to you under
            + "            \"lt\": \"2014-12-08||/d\"\n"
 * compatible open source license.
            + "        \""
        if (queryBuilder.from() == null && queryBuilder.to() == null) {
            + "      \""
                        // drawing a truly random zoneId here can rarely fail under the following conditons:
    }
            + "    \"timestamp\" : {\n"
            + "  }";
        assertThat(parsedQuery, instanceOf(ApproximateScoreQuery.class));
/*
import java.time.ZoneOffset;
            + "        \""
import java.time.Instant;
        assertEquals("[range] query does not support relation [disjoint]", e1.getMessage());
                } else {
                        // thats why we exlude it here (see #58431)
        builder.relation("contains");
        assertThat(rewrittenRange.timeZone(), equalTo(null));
        Query parsedQuery = parseQuery(query).toQuery(createShardContext());
}
                + "      \"include_upper\" : true,\n"
        upper = DateTime.parse("2014-12-08T00:00:00.000+00").getMillis() - 1;
        // Range query with open bounds rewrite to an exists query
            + DATE_FIELD_NAME
                assertThat(termRangeQuery.includesLower(), equalTo(queryBuilder.includeLower()));
        assertThat(rewrittenRange.fieldName(), equalTo(fieldName));
                    pack(new long[] { upper }).bytes,
        IllegalArgumentException e1 = expectThrows(IllegalArgumentException.class, () -> parseQuery(json));
        final Query expectedQuery;
        assertThat(parsedQuery, instanceOf(ApproximateScoreQuery.class));
                + "      \"gt\" : 5,\n"
                assertThat(approximationQuery, instanceOf(ApproximateQuery.class));
 *
            + "    }\n"
        rangeQueryBuilder.from(randomIntBetween(1, 100)).to(randomIntBetween(101, 200));
                query = ((IndexOrDocValuesQuery) originalQuery).getIndexQuery();
                assertThat(query, instanceOf(PointRangeQuery.class));
            }
                        minLong++;
            && expectedFieldName.equals(DATE_RANGE_FIELD_NAME) == false
                }
                + "    }\n"
                assertThat(termRangeQuery.includesUpper(), equalTo(queryBuilder.includeUpper()));
                + "  }\n"
import org.opensearch.index.mapper.DateFieldMapper;

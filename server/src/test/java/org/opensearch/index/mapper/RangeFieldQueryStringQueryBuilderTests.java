    }
        assertEquals(new IndexOrDocValuesQuery(range, dv), query);
            DATE_RANGE_FIELD_NAME,
            MapperService.MergeReason.MAPPING_UPDATE
 * not use this file except in compliance with the License.
            true,
/*
    @Override
    public void testLongRangeQuery() throws Exception {
        assertThat(query, either(instanceOf(PointRangeQuery.class)).or(instanceOf(IndexOrDocValuesQuery.class)));
 */
 * SPDX-License-Identifier: Apache-2.0
                        parser.parse(lowerBoundExact, () -> 0).toEpochMilli(),
 * license agreements. See the NOTICE file distributed with
                    "type=date_range",
 * specific language governing permissions and limitations
        Query query = new QueryStringQueryBuilder(DOUBLE_RANGE_FIELD_NAME + ":[-450 TO 45000]").toQuery(createShardContext());
    public void testFloatRangeQuery() throws Exception {
                        DATE_FIELD_NAME,
        Query range = DoubleRange.newIntersectsQuery(DOUBLE_RANGE_FIELD_NAME, new double[] { -450 }, new double[] { 45000 });
 *
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
                    "type=integer_range",
        return new QueryStringQueryBuilder(INTEGER_RANGE_FIELD_NAME + ":[-450 TO 450]");
 * GitHub history for details.
    private static final String IP_RANGE_FIELD_NAME = "mapped_ip_range";
                    "type=float_range",
    }
        );
        Query queryOnDateField = new QueryStringQueryBuilder(DATE_FIELD_NAME + ":[2010-01-01 TO 2018-01-01]").toQuery(createShardContext());
        Query query = new QueryStringQueryBuilder(FLOAT_RANGE_FIELD_NAME + ":[-450 TO 45000]").toQuery(createShardContext());
        Query range = IntRange.newIntersectsQuery(INTEGER_RANGE_FIELD_NAME, new int[] { -450 }, new int[] { 45000 });
import org.opensearch.common.compress.CompressedXContent;
 * compatible open source license.
                ),
            DATE_RANGE_FIELD_NAME,
        Query dv = RangeType.FLOAT.dvRangeQuery(
            DATE_FIELD_NAME,
        Query dv = RangeType.DATE.dvRangeQuery(
                PutMappingRequest.simpleMapping(
        Query range = FloatRange.newIntersectsQuery(FLOAT_RANGE_FIELD_NAME, new float[] { -450 }, new float[] { 45000 });
    public void testIntegerRangeQuery() throws Exception {
import org.opensearch.search.approximate.ApproximatePointRangeQuery;
                    DATE_FIELD_NAME,
                    controlDv
    @Override
    public void testIPRangeQuery() throws Exception {
        );
            DOUBLE_RANGE_FIELD_NAME,
        Query query = new QueryStringQueryBuilder(IP_RANGE_FIELD_NAME + ":[192.168.0.1 TO 192.168.0.5]").toQuery(createShardContext());
        Query query = new QueryStringQueryBuilder(LONG_RANGE_FIELD_NAME + ":[-450 TO 45000]").toQuery(createShardContext());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // also make sure the produced bounds are the same as on a regular `date` field
            BinaryDocValuesRangeQuery.QueryType.INTERSECTS,
                    DOUBLE_RANGE_FIELD_NAME,
            45000,
 */
                    ApproximatePointRangeQuery.LONG_FORMAT
        Query range = LongRange.newIntersectsQuery(LONG_RANGE_FIELD_NAME, new long[] { -450 }, new long[] { 45000 });
                new IndexOrDocValuesQuery(
            parser.parse(lowerBoundExact, () -> 0).toEpochMilli(),
        InetAddress upper = InetAddresses.forString("192.168.0.5");
                        parser.parse(upperBoundExact, () -> 0).toEpochMilli()
            new long[] { parser.parse(upperBoundExact, () -> 0).toEpochMilli() }
        QueryShardContext context = createShardContext();
import org.opensearch.index.query.QueryStringQueryBuilder;
                    pack(new long[] { parser.parse(upperBoundExact, () -> 0).toEpochMilli() }).bytes,
    @Override
        InetAddress lower = InetAddresses.forString("192.168.0.1");
            true,
            parser.parse(upperBoundExact, () -> 0).toEpochMilli()
        );
        );
            true,
            45000,
            new ApproximateScoreQuery(
        mapperService.merge(
        Query dv = RangeType.INTEGER.dvRangeQuery(
                ).toString()
    protected QueryStringQueryBuilder doCreateTestQueryBuilder() {
        );
        );
                    INTEGER_RANGE_FIELD_NAME,
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
    }
        Query range = LongRange.newIntersectsQuery(
            parser.parse(upperBoundExact, () -> 0).toEpochMilli(),
 */
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import org.opensearch.common.network.InetAddresses;
        Query query = new QueryStringQueryBuilder(INTEGER_RANGE_FIELD_NAME + ":[-450 TO 45000]").toQuery(createShardContext());
import org.apache.lucene.document.IntRange;
/*
}
            INTEGER_RANGE_FIELD_NAME,
import org.opensearch.common.time.DateMathParser;
                    LONG_RANGE_FIELD_NAME,
                    IP_RANGE_FIELD_NAME,
                    "type=long_range",
            BinaryDocValuesRangeQuery.QueryType.INTERSECTS,
            true
        Query range = InetAddressRange.newIntersectsQuery(IP_RANGE_FIELD_NAME, lower, upper);
    }
            FLOAT_RANGE_FIELD_NAME,
 * under the License.
            "_doc",
        Query dv = RangeType.DOUBLE.dvRangeQuery(
import org.apache.lucene.document.LongPoint;
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.opensearch.search.approximate.ApproximateScoreQuery;
 *
/*
import static org.hamcrest.Matchers.either;
            BinaryDocValuesRangeQuery.QueryType.INTERSECTS,
 * this work for additional information regarding copyright
        assertEquals(new IndexOrDocValuesQuery(range, dv), query);
        assertEquals(new IndexOrDocValuesQuery(range, dv), query);
            LONG_RANGE_FIELD_NAME,
        Query dv = RangeType.LONG.dvRangeQuery(
import org.apache.lucene.search.Query;
    protected void doAssertLuceneQuery(QueryStringQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        assertEquals(new IndexOrDocValuesQuery(range, dv), query);
import static org.apache.lucene.document.LongPoint.pack;
                    "type=double_range",
            ),
        RangeFieldMapper.RangeFieldType type = (RangeFieldMapper.RangeFieldType) context.fieldMapper(DATE_RANGE_FIELD_NAME);
        DateMathParser parser = type.dateMathParser;
            true
            true,
            true
            45000.0,
            BinaryDocValuesRangeQuery.QueryType.INTERSECTS,
            new long[] { parser.parse(lowerBoundExact, () -> 0).toEpochMilli() },
    }
import org.opensearch.test.AbstractQueryTestCase;
    }
import org.opensearch.lucene.queries.BinaryDocValuesRangeQuery;
import org.apache.lucene.document.LongRange;
import org.opensearch.index.query.QueryShardContext;
        assertEquals(new IndexOrDocValuesQuery(range, dv), query);
        );
        assertEquals(new IndexOrDocValuesQuery(range, dv), query);
package org.opensearch.index.mapper;
        String upperBoundExact = "2018-01-01T23:59:59.999";
import org.apache.lucene.document.FloatRange;
 * software distributed under the License is distributed on an
                    LongPoint.newRangeQuery(
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
        String lowerBoundExact = "2010-01-01T00:00:00.000";
    private static final String FLOAT_RANGE_FIELD_NAME = "mapped_float_range";
    public void testDoubleRangeQuery() throws Exception {
 *
 * You may obtain a copy of the License at
import org.apache.lucene.document.InetAddressRange;
            parser.parse(lowerBoundExact, () -> 0).toEpochMilli(),
                    "type=ip_range"
            -450.0,
import org.apache.lucene.search.IndexOrDocValuesQuery;
 * The OpenSearch Contributors require contributions made to
        );
            new CompressedXContent(
 * Modifications Copyright OpenSearch Contributors. See
            ),
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(
        Query query = new QueryStringQueryBuilder(DATE_RANGE_FIELD_NAME + ":[2010-01-01 TO 2018-01-01]").toQuery(createShardContext());
                    FLOAT_RANGE_FIELD_NAME,
import org.apache.lucene.document.DoubleRange;
        Query controlDv = SortedNumericDocValuesField.newSlowRangeQuery(
    private static final String LONG_RANGE_FIELD_NAME = "mapped_long_range";
    }
            -450,
 * this file be licensed under the Apache-2.0 license or a
        parser = dateType.dateMathParser;
    private static final String INTEGER_RANGE_FIELD_NAME = "mapped_int_range";
    }
    private static final String DOUBLE_RANGE_FIELD_NAME = "mapped_double_range";
            true
import java.net.InetAddress;
            -450.0f,
    public void testDateRangeQuery() throws Exception {
        DateFieldMapper.DateFieldType dateType = (DateFieldMapper.DateFieldType) context.fieldMapper(DATE_FIELD_NAME);
                    new long[] { parser.parse(lowerBoundExact, () -> 0).toEpochMilli() }.length,
            -450,
                    pack(new long[] { parser.parse(lowerBoundExact, () -> 0).toEpochMilli() }).bytes,
            queryOnDateField
            true
 * ownership. Elasticsearch licenses this file to you under
public class RangeFieldQueryStringQueryBuilderTests extends AbstractQueryTestCase<QueryStringQueryBuilder> {
                )
            true,
    private static final String DATE_RANGE_FIELD_NAME = "mapped_date_range";
 *     http://www.apache.org/licenses/LICENSE-2.0
        Query dv = RangeType.IP.dvRangeQuery(IP_RANGE_FIELD_NAME, BinaryDocValuesRangeQuery.QueryType.INTERSECTS, lower, upper, true, true);
        );
                    DATE_RANGE_FIELD_NAME,
 * KIND, either express or implied.  See the License for the
            BinaryDocValuesRangeQuery.QueryType.INTERSECTS,
    }
                    ),
import org.apache.lucene.search.PointRangeQuery;
 * the Apache License, Version 2.0 (the "License"); you may
            45000.0f,
                new ApproximatePointRangeQuery(

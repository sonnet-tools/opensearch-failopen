    public void testDateRangeQuery() throws Exception {
 *
 * license agreements. See the NOTICE file distributed with
            -450,
        QueryShardContext context = createShardContext();  
        Query dv = RangeType.LONG.dvRangeQuery(
 * Unless required by applicable law or agreed to in writing,
            ),  
        assertEquals(new IndexOrDocValuesQuery(range, dv), query);
    }
                    ),
 * SPDX-License-Identifier: Apache-2.0
            true,  
                    DOUBLE_RANGE_FIELD_NAME,
        mapperService.merge(
 *     http://www.apache.org/licenses/LICENSE-2.0
    private static final String INTEGER_RANGE_FIELD_NAME = "mapped_int_range";
                new IndexOrDocValuesQuery(  
 * this file be licensed under the Apache-2.0 license or a
    protected void doAssertLuceneQuery(QueryStringQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
            true,
    }  
                    "type=ip_range"
        RangeFieldMapper.RangeFieldType type = (RangeFieldMapper.RangeFieldType) context.fieldMapper(DATE_RANGE_FIELD_NAME);
 * software distributed under the License is distributed on an
            45000.0f,
            parser.parse(lowerBoundExact, () -> 0).toEpochMilli(),
import org.apache.lucene.document.DoubleRange;
 *  
                    LongPoint.newRangeQuery(
    private static final String DOUBLE_RANGE_FIELD_NAME = "mapped_double_range";
 */
 * GitHub history for details.
        DateFieldMapper.DateFieldType dateType = (DateFieldMapper.DateFieldType) context.fieldMapper(DATE_FIELD_NAME);
                    "type=float_range",
        assertThat(query, either(instanceOf(PointRangeQuery.class)).or(instanceOf(IndexOrDocValuesQuery.class)));  
            true
    private static final String FLOAT_RANGE_FIELD_NAME = "mapped_float_range";  
            new ApproximateScoreQuery(
import org.opensearch.lucene.queries.BinaryDocValuesRangeQuery;
        );
            new long[] { parser.parse(upperBoundExact, () -> 0).toEpochMilli() }  
 * the Apache License, Version 2.0 (the "License"); you may
import static org.apache.lucene.document.LongPoint.pack;  
        assertEquals(new IndexOrDocValuesQuery(range, dv), query);  
        parser = dateType.dateMathParser;
 */  
            true
        Query queryOnDateField = new QueryStringQueryBuilder(DATE_FIELD_NAME + ":[2010-01-01 TO 2018-01-01]").toQuery(createShardContext());  
    }
            BinaryDocValuesRangeQuery.QueryType.INTERSECTS,
            BinaryDocValuesRangeQuery.QueryType.INTERSECTS,
                    "type=integer_range",  
                    ApproximatePointRangeQuery.LONG_FORMAT
        DateMathParser parser = type.dateMathParser;
            true  
        Query range = FloatRange.newIntersectsQuery(FLOAT_RANGE_FIELD_NAME, new float[] { -450 }, new float[] { 45000 });  
        );
/*  
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.Matchers.either;
            DOUBLE_RANGE_FIELD_NAME,
        Query dv = RangeType.INTEGER.dvRangeQuery(  
            BinaryDocValuesRangeQuery.QueryType.INTERSECTS,
            ),  
import org.apache.lucene.document.LongRange;  
        Query range = IntRange.newIntersectsQuery(INTEGER_RANGE_FIELD_NAME, new int[] { -450 }, new int[] { 45000 });
    public void testIntegerRangeQuery() throws Exception {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            new long[] { parser.parse(lowerBoundExact, () -> 0).toEpochMilli() },
import org.opensearch.common.compress.CompressedXContent;  
    public void testIPRangeQuery() throws Exception {
                PutMappingRequest.simpleMapping(
}
        Query query = new QueryStringQueryBuilder(DOUBLE_RANGE_FIELD_NAME + ":[-450 TO 45000]").toQuery(createShardContext());
    public void testFloatRangeQuery() throws Exception {
        );
        String lowerBoundExact = "2010-01-01T00:00:00.000";
        String upperBoundExact = "2018-01-01T23:59:59.999";
public class RangeFieldQueryStringQueryBuilderTests extends AbstractQueryTestCase<QueryStringQueryBuilder> {
        assertEquals(new IndexOrDocValuesQuery(range, dv), query);
                    pack(new long[] { parser.parse(lowerBoundExact, () -> 0).toEpochMilli() }).bytes,
            true,
        assertEquals(new IndexOrDocValuesQuery(range, dv), query);
    private static final String IP_RANGE_FIELD_NAME = "mapped_ip_range";  
        );
/*
        );
        Query query = new QueryStringQueryBuilder(FLOAT_RANGE_FIELD_NAME + ":[-450 TO 45000]").toQuery(createShardContext());
 * KIND, either express or implied.  See the License for the
                ).toString()
        Query range = LongRange.newIntersectsQuery(  
            new CompressedXContent(  
    }
    }  
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
            45000,  
        Query dv = RangeType.DATE.dvRangeQuery(
    }
package org.opensearch.index.mapper;
        Query query = new QueryStringQueryBuilder(DATE_RANGE_FIELD_NAME + ":[2010-01-01 TO 2018-01-01]").toQuery(createShardContext());  
        Query query = new QueryStringQueryBuilder(INTEGER_RANGE_FIELD_NAME + ":[-450 TO 45000]").toQuery(createShardContext());
            LONG_RANGE_FIELD_NAME,  
 * Licensed to Elasticsearch under one or more contributor  
            -450.0,  
import static org.hamcrest.core.IsInstanceOf.instanceOf;
                    LONG_RANGE_FIELD_NAME,
        Query range = LongRange.newIntersectsQuery(LONG_RANGE_FIELD_NAME, new long[] { -450 }, new long[] { 45000 });
    protected QueryStringQueryBuilder doCreateTestQueryBuilder() {  
            DATE_FIELD_NAME,  
import org.opensearch.index.query.QueryStringQueryBuilder;
/*  
            parser.parse(upperBoundExact, () -> 0).toEpochMilli()
                    DATE_RANGE_FIELD_NAME,
import org.apache.lucene.document.IntRange;
 * this work for additional information regarding copyright
                    new long[] { parser.parse(lowerBoundExact, () -> 0).toEpochMilli() }.length,  
import org.apache.lucene.search.IndexOrDocValuesQuery;
    @Override
                new ApproximatePointRangeQuery(
    }  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
                    pack(new long[] { parser.parse(upperBoundExact, () -> 0).toEpochMilli() }).bytes,
    private static final String LONG_RANGE_FIELD_NAME = "mapped_long_range";
        Query query = new QueryStringQueryBuilder(LONG_RANGE_FIELD_NAME + ":[-450 TO 45000]").toQuery(createShardContext());  
    @Override
        Query dv = RangeType.DOUBLE.dvRangeQuery(  
        );  
 * under the License.  
        assertEquals(new IndexOrDocValuesQuery(range, dv), query);
    public void testLongRangeQuery() throws Exception {
import org.opensearch.common.time.DateMathParser;
            45000,
        Query controlDv = SortedNumericDocValuesField.newSlowRangeQuery(
                    DATE_FIELD_NAME,  
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {  
                    "type=date_range",
 *
                    "type=double_range",  
                )
        InetAddress upper = InetAddresses.forString("192.168.0.5");
            true  
        InetAddress lower = InetAddresses.forString("192.168.0.1");  
        );  
import org.opensearch.search.approximate.ApproximatePointRangeQuery;  
import org.opensearch.test.AbstractQueryTestCase;
        Query range = DoubleRange.newIntersectsQuery(DOUBLE_RANGE_FIELD_NAME, new double[] { -450 }, new double[] { 45000 });
                    INTEGER_RANGE_FIELD_NAME,
        );  
        Query dv = RangeType.FLOAT.dvRangeQuery(
import org.apache.lucene.document.LongPoint;
    private static final String DATE_RANGE_FIELD_NAME = "mapped_date_range";
    }  
import org.apache.lucene.document.FloatRange;
import org.apache.lucene.search.Query;
            parser.parse(upperBoundExact, () -> 0).toEpochMilli(),  
        // also make sure the produced bounds are the same as on a regular `date` field  
        Query dv = RangeType.IP.dvRangeQuery(IP_RANGE_FIELD_NAME, BinaryDocValuesRangeQuery.QueryType.INTERSECTS, lower, upper, true, true);
        Query range = InetAddressRange.newIntersectsQuery(IP_RANGE_FIELD_NAME, lower, upper);  
            true,
 * ownership. Elasticsearch licenses this file to you under  
 */  
            FLOAT_RANGE_FIELD_NAME,
            parser.parse(lowerBoundExact, () -> 0).toEpochMilli(),
 * specific language governing permissions and limitations
            "_doc",
            BinaryDocValuesRangeQuery.QueryType.INTERSECTS,  
        assertEquals(
                        DATE_FIELD_NAME,
    }
            queryOnDateField
        Query query = new QueryStringQueryBuilder(IP_RANGE_FIELD_NAME + ":[192.168.0.1 TO 192.168.0.5]").toQuery(createShardContext());
                        parser.parse(lowerBoundExact, () -> 0).toEpochMilli(),  
import org.opensearch.common.network.InetAddresses;
import org.apache.lucene.document.InetAddressRange;  
 * You may obtain a copy of the License at  
            45000.0,
        return new QueryStringQueryBuilder(INTEGER_RANGE_FIELD_NAME + ":[-450 TO 450]");
                    FLOAT_RANGE_FIELD_NAME,  
            true
    public void testDoubleRangeQuery() throws Exception {  
            -450.0f,
                    controlDv  
        assertEquals(new IndexOrDocValuesQuery(range, dv), query);
 * not use this file except in compliance with the License.
                    IP_RANGE_FIELD_NAME,  
            true,
            BinaryDocValuesRangeQuery.QueryType.INTERSECTS,
            DATE_RANGE_FIELD_NAME,
import java.net.InetAddress;
                        parser.parse(upperBoundExact, () -> 0).toEpochMilli()
            DATE_RANGE_FIELD_NAME,  
import java.io.IOException;
        );
            -450,  
            INTEGER_RANGE_FIELD_NAME,
            MapperService.MergeReason.MAPPING_UPDATE
                    "type=long_range",
import org.opensearch.search.approximate.ApproximateScoreQuery;
                ),
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.opensearch.index.query.QueryShardContext;  
import org.apache.lucene.search.PointRangeQuery;  
    @Override

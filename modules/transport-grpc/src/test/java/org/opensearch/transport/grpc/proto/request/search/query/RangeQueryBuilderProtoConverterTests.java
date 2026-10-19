    }
    }
    public void testFromProtoWithWrongQueryType() {  
        assertThat(exception.getMessage(), containsString("QueryContainer must contain a RangeQuery"));  
import org.opensearch.protobufs.DateRangeQueryAllOfTo;
    public void testFromProtoWithNullQueryContainer() {  
        RangeQuery rangeQuery = RangeQuery.newBuilder().setDateRangeQuery(dateRangeQuery).build();
            .setTerm(
import org.opensearch.protobufs.QueryContainer;  
    }  
        assertEquals("date_field", rangeQueryBuilder.fieldName());  
 */  
public class RangeQueryBuilderProtoConverterTests extends OpenSearchTestCase {
        RangeQueryBuilder rangeQueryBuilder = (RangeQueryBuilder) result;
        assertThat(result, instanceOf(RangeQueryBuilder.class));
        converter = new RangeQueryBuilderProtoConverter();
        DateRangeQueryAllOfFrom fromObj = DateRangeQueryAllOfFrom.newBuilder().setString("2023-01-01").build();
 *
        assertThat(exception.getMessage(), containsString("QueryContainer must contain a RangeQuery"));  
    public void testFromProtoWithValidRangeQuery() {  
    public void setUp() throws Exception {  
    @Override
package org.opensearch.transport.grpc.proto.request.search.query;
    public void testGetHandledQueryCase() {
    }
 * SPDX-License-Identifier: Apache-2.0
                    .build()  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));
        QueryContainer queryContainer = QueryContainer.newBuilder().build();
    private RangeQueryBuilderProtoConverter converter;  
        DateRangeQuery dateRangeQuery = DateRangeQuery.newBuilder().setField("date_field").setFrom(fromObj).setTo(toObj).build();
import org.opensearch.protobufs.DateRangeQuery;  
        QueryBuilder result = converter.fromProto(queryContainer);
        assertThat(exception.getMessage(), containsString("QueryContainer must contain a RangeQuery"));  
                    .setField("test_field")
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.instanceOf;
    }
            .build();
    public void testFromProtoWithUnsetQueryContainer() {  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(QueryContainer.QueryContainerCase.RANGE, converter.getHandledQueryCase());  
        super.setUp();
    }
import org.opensearch.protobufs.DateRangeQueryAllOfFrom;
}
        DateRangeQueryAllOfTo toObj = DateRangeQueryAllOfTo.newBuilder().setString("2023-12-31").build();  
        QueryContainer queryContainer = QueryContainer.newBuilder()
import org.opensearch.index.query.RangeQueryBuilder;
        QueryContainer queryContainer = QueryContainer.newBuilder().setRange(rangeQuery).build();  
            )
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.protobufs.RangeQuery;
import org.opensearch.index.query.QueryBuilder;
                org.opensearch.protobufs.TermQuery.newBuilder()  
                    .setValue(org.opensearch.protobufs.FieldValue.newBuilder().setString("test_value").build())
/*  
import static org.hamcrest.Matchers.containsString;
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(null));
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> converter.fromProto(queryContainer));

        assertThat(fieldMaskingSpanQuery.getMaskedQuery(), equalTo(sub));  
 * this file be licensed under the Apache-2.0 license or a
        );
            + "}";  
 * compatible open source license.
package org.opensearch.index.query;
            + "  }\n"  
        Query query = parseQuery(json).toQuery(createShardContext());
/*  
            + "          \"value\" : 0.5,\n"  
            + "        \"value\" : {\n"  
 */
        expectThrows(IllegalArgumentException.class, () -> new FieldMaskingSpanQueryBuilder(null, "maskedField"));
import org.opensearch.test.AbstractQueryTestCase;
 *
import java.io.IOException;  
            + "          \"value\" : \"foo\"\n"
        assertThat(fieldMaskingSpanQuery.getField(), equalTo(fieldInQuery));
import org.apache.lucene.queries.spans.FieldMaskingSpanQuery;
            + "    \"boost\" : 42.0,\n"  
            + "    \"field\" : \"mapped_geo_shape\",\n"
        assertWarnings(  
            + "      }\n"
        expectThrows(IllegalArgumentException.class, () -> new FieldMaskingSpanQueryBuilder(span, null));  
/*  
            exception.getMessage(),  
        } else {
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
import org.apache.lucene.search.BoostQuery;
 * You may obtain a copy of the License at  
            + "      \"span_term\" : {\n"
 * under the License.  
            + "    \"field\" : \"mapped_geo_shape\",\n"
        if (randomBoolean()) {  
            + "      }\n"  
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(
import static org.hamcrest.CoreMatchers.instanceOf;  
            + "          \"value\" : \"term\"\n"
    }
        Exception exception = expectThrows(ParsingException.class, () -> parseQuery(json));
import org.opensearch.core.common.ParsingException;  
    }  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
        expectThrows(IllegalArgumentException.class, () -> new FieldMaskingSpanQueryBuilder(span, ""));
            new BoostQuery(new FieldMaskingSpanQuery(new SpanTermQuery(new Term("value", "term")), "mapped_geo_shape"), 42f),  
            equalTo(
 *  
        }
        );
 * KIND, either express or implied.  See the License for the
    public void testJsonSpanTermWithBoost() throws IOException {
            + "        \"value\" : {\n"
            + "    \"_name\" : \"KPI\"\n"
            + "        \"value\" : {\n"
 *     http://www.apache.org/licenses/LICENSE-2.0
            + "      }\n"  
            + "    \"query\" : {\n"  
            + "        }\n"
 * software distributed under the License is distributed on an
    public void testVisit() {
        doCreateTestQueryBuilder().visit(createTestVisitor(visitedQueries));
            + "        }\n"
            + "    \"query\" : {\n"
            + "  \"span_field_masking\" : {\n"  
            + "    \"_name\" : \"KPI\"\n"
        FieldMaskingSpanQueryBuilder parsed = (FieldMaskingSpanQueryBuilder) parseQuery(json);
import org.apache.lucene.search.Query;
            + "    \"boost\" : 42.0,\n"  
        SpanTermQueryBuilder innerQuery = new SpanTermQueryBuilderTests().createTestQueryBuilder();
    }
            )  
    protected FieldMaskingSpanQueryBuilder doCreateTestQueryBuilder() {
            fieldName = randomFrom(MAPPED_FIELD_NAMES);
            + "    \"query\" : {\n"
        String json = "{\n"
    public void testIllegalArguments() {  
        String json = "{\n"
            + "  }\n"
import org.apache.lucene.index.Term;
import static org.hamcrest.CoreMatchers.equalTo;
    }
        List<QueryBuilder> visitedQueries = new ArrayList<>();  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.queries.spans.SpanTermQuery;  
            + "          \"boost\" : 0.23\n"
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.index.query.FieldMaskingSpanQueryBuilder.SPAN_FIELD_MASKING_FIELD;
        String fieldInQuery = expectedFieldName(queryBuilder.fieldName());
            query
            + "      \"span_term\" : {\n"  
        FieldMaskingSpanQuery fieldMaskingSpanQuery = (FieldMaskingSpanQuery) query;  
            + "    },\n"
        String json = "{\n"  
                SPAN_FIELD_MASKING_FIELD.getPreferredName() + " [query] as a nested span clause can't have non-default boost value [0.23]"
        assertThat(query, instanceOf(FieldMaskingSpanQuery.class));
            + "    \"boost\" : 42.0,\n"
            + "        }\n"  
        throws IOException {  
import java.util.List;
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
        innerQuery.boost(1f);  
    }  
            + "    \"_name\" : \"KPI\"\n"
}
        assertEquals(
    protected void doAssertLuceneQuery(FieldMaskingSpanQueryBuilder queryBuilder, Query query, QueryShardContext context)
            + "\" : {\n"
 * GitHub history for details.
        SpanQueryBuilder span = new SpanTermQueryBuilder("name", "value");
            + "    },\n"
        assertEquals(2, visitedQueries.size());
        );
/*
        String fieldName;
 *
            + "  \"field_masking_span\" : {\n"
public class FieldMaskingSpanQueryBuilderTests extends AbstractQueryTestCase<FieldMaskingSpanQueryBuilder> {
import java.util.ArrayList;
 * ownership. Elasticsearch licenses this file to you under  
            + "}";  
    public void testDeprecatedName() throws IOException {
    @Override  
            + "  }\n"
            + "}";
            + "  \""  
            fieldName = randomAlphaOfLengthBetween(1, 10);  
 */  
        return new FieldMaskingSpanQueryBuilder(innerQuery, fieldName);
            + SPAN_FIELD_MASKING_FIELD.getPreferredName()
 * license agreements. See the NOTICE file distributed with
 */  
            + "    },\n"
            "Deprecated field [field_masking_span] used, expected [" + SPAN_FIELD_MASKING_FIELD.getPreferredName() + "] instead"
    @Override
            + "    \"field\" : \"mapped_geo_shape\",\n"  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    public void testFromJson() throws IOException {
            + "      \"span_term\" : {\n"
        Query sub = queryBuilder.innerQuery().toQuery(context);

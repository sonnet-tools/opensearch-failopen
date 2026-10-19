    @Override
        assertEquals("Rewrite first", e.getMessage());
    public void testIllegalArguments() {  
            .field("source", "emit(doc['raw.keyword'].value)")
 * Unless required by applicable law or agreed to in writing,
                assertThat(constantScoreQuery.getQuery(), instanceOf(BooleanQuery.class));
        checkGeneratedJson(json, parsed);  
import java.util.stream.Collectors;
        }
                assertThat(constantScoreQuery.getQuery(), instanceOf(FieldExistsQuery.class));  
            new BooleanQuery.Builder().add(new FieldExistsQuery("raw.keyword"), BooleanClause.Occur.SHOULD).build()
 * this file be licensed under the Apache-2.0 license or a
        XContentBuilder mapping = jsonBuilder().startObject()  
                BooleanClause booleanClause = booleanQuery.clauses().get(i);
            }""";  
import org.apache.lucene.search.BooleanClause;
    public void testFromJson() throws IOException {
            }
        final ExistsQueryBuilder queryBuilder1 = new ExistsQueryBuilder("raw.derived_keyword");
            } else {
package org.opensearch.index.query;
 * ownership. Elasticsearch licenses this file to you under  
            fieldPattern = TEXT_FIELD_NAME;  
public class ExistsQueryBuilderTests extends AbstractQueryTestCase<ExistsQueryBuilder> {
import org.apache.lucene.search.FieldExistsQuery;
        }
        expectThrows(IllegalArgumentException.class, () -> new ExistsQueryBuilder(""));
        String fieldPattern = queryBuilder.fieldName();  
import org.opensearch.common.compress.CompressedXContent;
        Collection<String> mappedFields = fields.stream()
            .startObject("raw.derived_keyword")
/*
                TermQuery termQuery = (TermQuery) constantScoreQuery.getQuery();  
                "boost" : 42.0
import static org.hamcrest.CoreMatchers.equalTo;
    }
            .endObject()
            fieldPattern = randomFrom(MAPPED_FIELD_NAMES);
import org.apache.lucene.search.TermQuery;
        context.setAllowUnmappedFields(true);
    }
            .endObject()
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> queryBuilder.toQuery(context));  
 * the Apache License, Version 2.0 (the "License"); you may
        expectThrows(IllegalArgumentException.class, () -> new ExistsQueryBuilder((String) null));
import java.io.IOException;
              "exists" : {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            {
        if (fieldPattern.startsWith("raw")) {
        QueryShardContext context = createShardContext();  
            if (context.getObjectMapper(field) != null) {
            for (int i = 0; i < mappedFields.size(); i++) {  
                assertEquals(field, termQuery.getTerm().text());
                FieldExistsQuery normsExistsQuery = (FieldExistsQuery) constantScoreQuery.getQuery();
        Query ret = ExistsQueryBuilder.newFilter(context, "foo", false);
            .endObject();
import java.util.List;
        } else {
                context.getObjectMapper(field).forEach(mapper -> childFields.add(mapper.name()));
/*  
            assertThat(constantScoreQuery.getQuery(), instanceOf(BooleanQuery.class));  
 *  
        final ExistsQueryBuilder queryBuilder2 = new ExistsQueryBuilder("raw");
import org.apache.lucene.search.ConstantScoreQuery;  
            ConstantScoreQuery constantScoreQuery = (ConstantScoreQuery) query;
            assertThat(query, instanceOf(ConstantScoreQuery.class));
                assertThat(booleanQuery.clauses().size(), equalTo(childFields.size()));  
 */  
            .field("type", "keyword")  
 *
        );
        // which doesn't support exists queries
                assertThat(booleanClause.occur(), equalTo(BooleanClause.Occur.SHOULD));
 * license agreements. See the NOTICE file distributed with
                assertEquals(field, dvExistsQuery.getField());
/*  
            .startObject("script")
import org.opensearch.test.AbstractQueryTestCase;
        QueryShardContext shardContext = createShardContext();
            .startObject("_doc")
            .endObject()
}
            } else if (context.getMapperService().fieldType(field).getTextSearchInfo().hasNorms()) {  
            assertThat(query, instanceOf(MatchNoDocsQuery.class));  
 *
        }
                    BooleanClause booleanClause = booleanQuery.clauses().get(i);
            assertThat(query, instanceOf(ConstantScoreQuery.class));
            .startObject("properties")
        }
import static org.hamcrest.CoreMatchers.instanceOf;  
    protected ExistsQueryBuilder doCreateTestQueryBuilder() {
 * specific language governing permissions and limitations
 */  
            if (randomBoolean() && !fieldPattern.equals("r") && !fieldPattern.equals("ra")) {
import org.opensearch.index.mapper.MapperService;
    }
 * software distributed under the License is distributed on an
    }
    }
 */
                    assertThat(booleanClause.occur(), equalTo(BooleanClause.Occur.SHOULD));  
            .filter((field) -> context.getObjectMapper(field) != null || context.getMapperService().fieldType(field) != null)  
 * KIND, either express or implied.  See the License for the
        // Avoid patterns that would match the derived field "raw.derived_keyword"  
        if (randomBoolean()) {
            BooleanQuery booleanQuery = (BooleanQuery) constantScoreQuery.getQuery();
                FieldExistsQuery dvExistsQuery = (FieldExistsQuery) constantScoreQuery.getQuery();
        Collection<String> fields = context.simpleMatchToIndexNames(fieldPattern);
import org.apache.lucene.search.Query;  
 * GitHub history for details.
                fieldPattern = fieldPattern + "*";  
        if (mappedFields.size() == 0) {
    }
                for (int i = 0; i < childFields.size(); i++) {
            .endObject()  
 * not use this file except in compliance with the License.
        mapperService.merge("_doc", new CompressedXContent(mapping.toString()), MapperService.MergeReason.MAPPING_UPDATE);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
            String field = expectedFieldName(fields.iterator().next());  
    @Override  
 * under the License.  
            }
 * Licensed to Elasticsearch under one or more contributor  
        Query expected = new ConstantScoreQuery(  
        expectThrows(UnsupportedOperationException.class, () -> queryBuilder1.toQuery(shardContext));  
    protected void doAssertLuceneQuery(ExistsQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
              }
    public void testObjectFieldWithDerivedSubField() throws IOException {  
                List<String> childFields = new ArrayList<>();
            .endObject()  
        Query actual = queryBuilder2.toQuery(shardContext);
            .startObject("derived")
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
        String fieldPattern;
import org.apache.lucene.search.MatchNoDocsQuery;
import java.util.Collection;  
 * You may obtain a copy of the License at  
    @Override
                assertEquals(field, normsExistsQuery.getField());  
        assertEquals(expected, actual);  
        String json = """  
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override
            } else if (context.getMapperService().fieldType(field).hasDocValues()) {
            ConstantScoreQuery constantScoreQuery = (ConstantScoreQuery) query;
                assertThat(constantScoreQuery.getQuery(), instanceOf(FieldExistsQuery.class));
            .field("type", "keyword")
            .endObject()  
 * SPDX-License-Identifier: Apache-2.0
import java.util.ArrayList;
        assertEquals(json, "user", parsed.fieldName());  
        if (randomBoolean()) {  
        assertThat(ret, instanceOf(MatchNoDocsQuery.class));  
        ExistsQueryBuilder queryBuilder = new ExistsQueryBuilder("foo");
    public void testMustRewrite() throws IOException {
import org.apache.lucene.search.BooleanQuery;
            assertThat(booleanQuery.clauses().size(), equalTo(mappedFields.size()));
                assertThat(constantScoreQuery.getQuery(), instanceOf(TermQuery.class));
    }  
                "field" : "user",  
            fieldPattern = randomAlphaOfLengthBetween(1, 10);  
        } else {  
                BooleanQuery booleanQuery = (BooleanQuery) constantScoreQuery.getQuery();  
 * compatible open source license.
        return new ExistsQueryBuilder(fieldPattern);
                }
import org.opensearch.core.xcontent.XContentBuilder;  
 * Modifications Copyright OpenSearch Contributors. See
        }
            .collect(Collectors.toList());
            .startObject("raw.keyword")  
        ExistsQueryBuilder parsed = (ExistsQueryBuilder) parseQuery(json);
 * this work for additional information regarding copyright
        assertEquals(json, 42.0, parsed.boost(), 0.0001);
        // also sometimes test wildcard patterns  
        if (fields.size() == 1) {  
            return;
 * The OpenSearch Contributors require contributions made to  

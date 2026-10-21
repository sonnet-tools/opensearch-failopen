            .startObject("properties")
                context.getObjectMapper(field).forEach(mapper -> childFields.add(mapper.name()));
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> queryBuilder.toQuery(context));
            .endObject()
                FieldExistsQuery dvExistsQuery = (FieldExistsQuery) constantScoreQuery.getQuery();
            } else if (context.getMapperService().fieldType(field).hasDocValues()) {
    public void testObjectFieldWithDerivedSubField() throws IOException {
                assertThat(constantScoreQuery.getQuery(), instanceOf(FieldExistsQuery.class));
                BooleanQuery booleanQuery = (BooleanQuery) constantScoreQuery.getQuery();
        assertEquals(expected, actual);
        expectThrows(UnsupportedOperationException.class, () -> queryBuilder1.toQuery(shardContext));
import static org.hamcrest.CoreMatchers.instanceOf;
 * license agreements. See the NOTICE file distributed with
        ExistsQueryBuilder parsed = (ExistsQueryBuilder) parseQuery(json);
            ConstantScoreQuery constantScoreQuery = (ConstantScoreQuery) query;
 *
 * GitHub history for details.
import org.apache.lucene.search.FieldExistsQuery;
            .endObject()
 *
 * compatible open source license.
import org.apache.lucene.search.TermQuery;
/*
import org.opensearch.common.compress.CompressedXContent;
        QueryShardContext shardContext = createShardContext();
        }
            .endObject()
            .startObject("derived")
            fieldPattern = randomFrom(MAPPED_FIELD_NAMES);
        if (fields.size() == 1) {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    @Override
        String json = """
        if (mappedFields.size() == 0) {
        String fieldPattern = queryBuilder.fieldName();
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
            .startObject("script")
                "boost" : 42.0
                assertThat(constantScoreQuery.getQuery(), instanceOf(BooleanQuery.class));
        }
                "field" : "user",
import java.util.ArrayList;
            .startObject("_doc")
            .field("type", "keyword")
            if (randomBoolean() && !fieldPattern.equals("r") && !fieldPattern.equals("ra")) {
                FieldExistsQuery normsExistsQuery = (FieldExistsQuery) constantScoreQuery.getQuery();
 * Modifications Copyright OpenSearch Contributors. See
        expectThrows(IllegalArgumentException.class, () -> new ExistsQueryBuilder((String) null));
/*
            .endObject()
        expectThrows(IllegalArgumentException.class, () -> new ExistsQueryBuilder(""));
            .field("type", "keyword")
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at
        QueryShardContext context = createShardContext();
                fieldPattern = fieldPattern + "*";
            return;
            .endObject();
                assertThat(booleanQuery.clauses().size(), equalTo(childFields.size()));
            .field("source", "emit(doc['raw.keyword'].value)")
import org.opensearch.index.mapper.MapperService;
                TermQuery termQuery = (TermQuery) constantScoreQuery.getQuery();
                BooleanClause booleanClause = booleanQuery.clauses().get(i);
 * this file be licensed under the Apache-2.0 license or a
                assertEquals(field, dvExistsQuery.getField());
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
                    BooleanClause booleanClause = booleanQuery.clauses().get(i);
    public void testFromJson() throws IOException {
            new BooleanQuery.Builder().add(new FieldExistsQuery("raw.keyword"), BooleanClause.Occur.SHOULD).build()
        // also sometimes test wildcard patterns
import org.opensearch.core.xcontent.XContentBuilder;
            assertThat(query, instanceOf(ConstantScoreQuery.class));
import java.util.stream.Collectors;
    @Override
                assertThat(constantScoreQuery.getQuery(), instanceOf(FieldExistsQuery.class));
                assertEquals(field, normsExistsQuery.getField());
                List<String> childFields = new ArrayList<>();
    }
 * the Apache License, Version 2.0 (the "License"); you may
    }
                assertThat(constantScoreQuery.getQuery(), instanceOf(TermQuery.class));
        assertEquals(json, 42.0, parsed.boost(), 0.0001);
    protected ExistsQueryBuilder doCreateTestQueryBuilder() {
 *     http://www.apache.org/licenses/LICENSE-2.0
            } else if (context.getMapperService().fieldType(field).getTextSearchInfo().hasNorms()) {
import org.apache.lucene.search.MatchNoDocsQuery;
            .filter((field) -> context.getObjectMapper(field) != null || context.getMapperService().fieldType(field) != null)
            .collect(Collectors.toList());
import java.util.Collection;
import static org.hamcrest.CoreMatchers.equalTo;
        assertEquals("Rewrite first", e.getMessage());
    }
        }
        );
            assertThat(constantScoreQuery.getQuery(), instanceOf(BooleanQuery.class));
        Collection<String> fields = context.simpleMatchToIndexNames(fieldPattern);
        mapperService.merge("_doc", new CompressedXContent(mapping.toString()), MapperService.MergeReason.MAPPING_UPDATE);
    public void testIllegalArguments() {
        assertEquals(json, "user", parsed.fieldName());
 * The OpenSearch Contributors require contributions made to
            {
    }
import org.apache.lucene.search.BooleanClause;
            }
            .startObject("raw.keyword")
            fieldPattern = TEXT_FIELD_NAME;
 * Licensed to Elasticsearch under one or more contributor
 *
        checkGeneratedJson(json, parsed);
        String fieldPattern;
            .startObject("raw.derived_keyword")
            } else {
        }
            String field = expectedFieldName(fields.iterator().next());
        Query actual = queryBuilder2.toQuery(shardContext);
import org.opensearch.test.AbstractQueryTestCase;
    }
    public void testMustRewrite() throws IOException {
              "exists" : {
public class ExistsQueryBuilderTests extends AbstractQueryTestCase<ExistsQueryBuilder> {
        if (fieldPattern.startsWith("raw")) {
package org.opensearch.index.query;
 * ownership. Elasticsearch licenses this file to you under
 */
        XContentBuilder mapping = jsonBuilder().startObject()
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.ConstantScoreQuery;
            if (context.getObjectMapper(field) != null) {
import org.apache.lucene.search.Query;
        } else {
 * not use this file except in compliance with the License.
        Collection<String> mappedFields = fields.stream()
        // which doesn't support exists queries
        final ExistsQueryBuilder queryBuilder2 = new ExistsQueryBuilder("raw");
 * under the License.
              }
 */
        context.setAllowUnmappedFields(true);
            }
            ConstantScoreQuery constantScoreQuery = (ConstantScoreQuery) query;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            BooleanQuery booleanQuery = (BooleanQuery) constantScoreQuery.getQuery();
        } else {
        return new ExistsQueryBuilder(fieldPattern);
            }""";
                }
    protected void doAssertLuceneQuery(ExistsQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
            assertThat(query, instanceOf(ConstantScoreQuery.class));
        final ExistsQueryBuilder queryBuilder1 = new ExistsQueryBuilder("raw.derived_keyword");
/*
        Query expected = new ConstantScoreQuery(
            }
 */
 * this work for additional information regarding copyright
            assertThat(query, instanceOf(MatchNoDocsQuery.class));
    @Override
    }
            fieldPattern = randomAlphaOfLengthBetween(1, 10);
        if (randomBoolean()) {
 * Unless required by applicable law or agreed to in writing,
        }
                assertThat(booleanClause.occur(), equalTo(BooleanClause.Occur.SHOULD));
                    assertThat(booleanClause.occur(), equalTo(BooleanClause.Occur.SHOULD));
                assertEquals(field, termQuery.getTerm().text());
        assertThat(ret, instanceOf(MatchNoDocsQuery.class));
            .endObject()
        ExistsQueryBuilder queryBuilder = new ExistsQueryBuilder("foo");
            .endObject()
            for (int i = 0; i < mappedFields.size(); i++) {
}
    }
            assertThat(booleanQuery.clauses().size(), equalTo(mappedFields.size()));
    @Override
 * specific language governing permissions and limitations
        Query ret = ExistsQueryBuilder.newFilter(context, "foo", false);
        if (randomBoolean()) {
import java.io.IOException;
import java.util.List;
                for (int i = 0; i < childFields.size(); i++) {
        // Avoid patterns that would match the derived field "raw.derived_keyword"

        }
                if (frequently()) {
        TermQueryBuilder queryBuilder = new TermQueryBuilder(INT_FIELD_NAME, value);
              "term" : {
            e.getMessage()
        String json = """
                    fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME);
              }
 * under the License.
        MappedFieldType mapper = context.fieldMapper(queryBuilder.fieldName());
    @Override
/*
            }""";
    public void testRewriteIndexQueryToNotMatchNone() throws IOException {
        assertThat(
    protected TermQueryBuilder createQueryBuilder(String fieldName, Object value) {
        queryBuilder = new TermQueryBuilder(TEXT_FIELD_NAME, "some_text");
        assertEquals("[term] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());
                }
            {
                    value = randomAlphaOfLengthBetween(1, 10);
              "term" : {
        assertEquals("Rewrite first", e.getMessage());
        checkGeneratedJson(json, parsed);
        } else {
                  "boost" : 1.0
        String queryAsString = """
        DirectoryReader reader = DirectoryReader.open(w);
    protected TermQueryBuilder doCreateTestQueryBuilder() {
        );
                if (randomBoolean()) {
     * @return a TermQuery with random field name and value, optional random boost and queryname
                break;
            {
 * The OpenSearch Contributors require contributions made to
                    final StringBuilder sb = new StringBuilder();
 * GitHub history for details.
    public void testGetComplement() throws Exception {
                if (randomBoolean()) {
                break;
        QueryBuilder parsedQuery = parseQuery(json);
import org.apache.lucene.search.Query;
 *
 *
                }
        assertThat(rewritten, instanceOf(MatchAllQueryBuilder.class));
    }
import org.apache.lucene.search.IndexOrDocValuesQuery;
                .or(instanceOf(MatchNoDocsQuery.class))
            }""";
                }
            assertEquals(query, termQuery(mapper, queryBuilder.value(), queryBuilder.caseInsensitive()));
/*
        assertEquals(json, "Quick Foxes!", parsed.value());
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
                throw new UnsupportedOperationException();
 * KIND, either express or implied.  See the License for the
                    "age": [34, 35]
public class TermQueryBuilderTests extends AbstractTermQueryTestCase<TermQueryBuilder> {
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor
                  "value" : "Quick Foxes!",
            return mapper.termQueryCaseInsensitive(value, null);
        // should return null if this isn't a numeric field
            }""";
                }
                }
 * the Apache License, Version 2.0 (the "License"); you may
    }
    public void testRewriteIndexQueryToMatchNone() throws IOException {
import org.apache.lucene.search.MatchNoDocsQuery;
            {
        String json = """
        return createQueryBuilder(fieldName, value);
                    fieldName = BOOLEAN_FIELD_NAME;
 *
    @Override
 * Unless required by applicable law or agreed to in writing,
        return result;
        );
                if (randomBoolean()) {
            case 1:
        TermQueryBuilder parsed = (TermQueryBuilder) parseQuery(json);
                }
                "term": {
                    fieldName = INT_FIELD_NAME;
 * compatible open source license.
                "message1" : "this",
 * this file be licensed under the Apache-2.0 license or a
    @Override
 * You may obtain a copy of the License at
    protected void doAssertLuceneQuery(TermQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        IOUtils.close(w, reader, dir);
import static org.opensearch.index.query.BoolQueryBuilderTests.getIndexSearcher;
import org.apache.lucene.search.TermQuery;
            case 3:
              }
 * software distributed under the License is distributed on an
    }
                .or(instanceOf(IndexOrDocValuesQuery.class))
import org.opensearch.index.mapper.MappedFieldType;
    }
                break;
        } else if (mapper != null) {
    /**
                },
import org.apache.lucene.search.PointRangeQuery;
                "exact_value" : {
/*
    public void testFromJson() throws IOException {
        Directory dir = newDirectory();
import static org.hamcrest.Matchers.either;
        IndexSearcher searcher = getIndexSearcher(reader);
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.index.query;
 */
        e = expectThrows(ParsingException.class, () -> parseQuery(shortJson));
                }
            query,
        assertEquals("[term] query does not support array of values", e.getMessage());
            assertThat(termQuery.getTerm(), equalTo(term));
        TermQueryBuilder query = new TermQueryBuilder(GEO_POINT_FIELD_NAME, "2,3");
        String shortJson = """
 */
import static org.opensearch.index.query.MatchQueryBuilderTests.testGetComplementNumericField;
                }
            case 0:
              }
}
 * SPDX-License-Identifier: Apache-2.0
        Object value;
        int value = 200;
                if (randomBoolean()) {
import static org.hamcrest.CoreMatchers.instanceOf;
        }
              "term" : {
import org.apache.lucene.search.IndexSearcher;
 * ownership. Elasticsearch licenses this file to you under
        TermQueryBuilder result = new TermQueryBuilder(fieldName, value);
import org.opensearch.core.common.ParsingException;
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
    }
    public void testParseFailsWithMultipleFields() throws IOException {
            "Geometry fields do not support exact searching, " + "use dedicated geometry queries instead: [mapped_geo_point]",
    public void testParseAndSerializeBigInteger() throws IOException {
                  "value" : 80315953321748200608
                }
              "term" : {
            }""";
        TermQueryBuilder query = QueryBuilders.termQuery("_index", "does_not_exist");
import org.apache.lucene.index.Term;
        QueryBuilder rewritten = query.rewrite(queryShardContext);
        TermQueryBuilder query = QueryBuilders.termQuery("_index", getIndex().getName());
import org.apache.lucene.index.IndexWriter;
            assertThat(query, instanceOf(MatchNoDocsQuery.class));
                    // generate unicode string in 10% of cases
    public void testGeo() throws Exception {
        return mapper.termQuery(value, null);
            Term term = ((TermQuery) termQuery(mapper, queryBuilder.value(), queryBuilder.caseInsensitive())).getTerm();
    }
        TermQueryBuilder queryBuilder = new TermQueryBuilder("unmapped_field", "foo");
        testGetComplementNumericField(queryBuilder, value, INT_FIELD_NAME, searcher);
        QueryShardContext context = createShardContext();
                    encoder.quoteAsString(randomUnicodeOfLength(10), sb);
            TermQuery termQuery = (TermQuery) query;
                "foo" : {
 * not use this file except in compliance with the License.
        if (caseInsensitive) {
            case 2:
        switch (randomIntBetween(0, 3)) {
            {
 * this work for additional information regarding copyright
    }
import org.opensearch.common.util.io.IOUtils;
    }
                  "value" : "this"
    private Query termQuery(MappedFieldType mapper, Object value, boolean caseInsensitive) {
                } else {
            {
        QueryShardException e = expectThrows(QueryShardException.class, () -> query.toQuery(context));
        assertThat(rewritten, instanceOf(MatchNoneQueryBuilder.class));
            fieldName = randomAlphaOfLengthBetween(1, 10);
        QueryShardContext context = createShardContext();
        QueryShardContext queryShardContext = createShardContext();
        assertNull(queryBuilder.getComplement(createShardContext(searcher)));
    @Override
            String expectedFieldName = expectedFieldName(queryBuilder.fieldName());
            default:
import org.apache.lucene.store.Directory;
            assertThat(termQuery.getTerm().field(), equalTo(expectedFieldName));
        context.setAllowUnmappedFields(true);
                .or(instanceOf(AutomatonQuery.class))
import org.apache.lucene.search.AutomatonQuery;
                break;
import static org.hamcrest.CoreMatchers.equalTo;
    }
    public void testTermArray() throws IOException {
        String json = """
    public void testMustRewrite() throws IOException {
                "message2" : "this"
                value = randomInt(10000);
        QueryBuilder rewritten = query.rewrite(queryShardContext);
    }
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(queryAsString));
        assertSerialization(parsedQuery);
        assertNull(queryBuilder.getComplement(null));
        assertEquals("[term] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());
        QueryShardContext queryShardContext = createShardContext();
            }""";
                    value = sb.toString();
        String fieldName = null;
        }
        if (fieldName == null) {
 */
                value = randomDouble();
import org.apache.lucene.analysis.standard.StandardAnalyzer;
              }
    }
                "message2" : {
 *     http://www.apache.org/licenses/LICENSE-2.0
                "message1" : {
            either(instanceOf(TermQuery.class)).or(instanceOf(PointRangeQuery.class))
                  "value" : "this"
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
        if (query instanceof TermQuery) {
                    JsonStringEncoder encoder = JsonStringEncoder.getInstance();
        // getComplement() should return 2 range queries if this is a numeric field
 * specific language governing permissions and limitations
import tools.jackson.core.io.JsonStringEncoder;
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> queryBuilder.toQuery(context));
        // getComplement() should return null if QueryShardContext is null
import java.io.IOException;
                value = randomBoolean();
import org.apache.lucene.index.DirectoryReader;
        assertEquals(
        }
     */
                    fieldName = DOUBLE_FIELD_NAME;

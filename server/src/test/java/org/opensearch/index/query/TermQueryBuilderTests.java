/*  
    }  
        Object value;
            {
 * You may obtain a copy of the License at  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testRewriteIndexQueryToMatchNone() throws IOException {
        QueryShardContext context = createShardContext();
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(queryAsString));
                break;
 * Unless required by applicable law or agreed to in writing,
        int value = 200;
            assertEquals(query, termQuery(mapper, queryBuilder.value(), queryBuilder.caseInsensitive()));
    }
            default:  
        return mapper.termQuery(value, null);  
        IOUtils.close(w, reader, dir);  
              "term" : {
                if (randomBoolean()) {
import org.apache.lucene.store.Directory;  
            }""";
        assertEquals("[term] query does not support array of values", e.getMessage());
                }  
        TermQueryBuilder query = QueryBuilders.termQuery("_index", getIndex().getName());  
        assertEquals("[term] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());
            case 3:  
                "message1" : "this",
                }
    public void testFromJson() throws IOException {
            {
 * SPDX-License-Identifier: Apache-2.0
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
        TermQueryBuilder result = new TermQueryBuilder(fieldName, value);  
                    fieldName = DOUBLE_FIELD_NAME;
        assertNull(queryBuilder.getComplement(null));
    protected TermQueryBuilder doCreateTestQueryBuilder() {  
 */  
                  "boost" : 1.0
import static org.opensearch.index.query.MatchQueryBuilderTests.testGetComplementNumericField;
 *  
        MappedFieldType mapper = context.fieldMapper(queryBuilder.fieldName());
import org.apache.lucene.analysis.standard.StandardAnalyzer;
    @Override
    public void testGetComplement() throws Exception {  
import org.apache.lucene.search.IndexSearcher;
                "term": {  
 * this work for additional information regarding copyright
                    value = randomAlphaOfLengthBetween(1, 10);  
                    fieldName = BOOLEAN_FIELD_NAME;  
        }
                  "value" : "this"  
            case 1:
                if (randomBoolean()) {
import org.apache.lucene.search.TermQuery;
            String expectedFieldName = expectedFieldName(queryBuilder.fieldName());
        assertNull(queryBuilder.getComplement(createShardContext(searcher)));
                value = randomDouble();
import java.io.IOException;
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.mapper.MappedFieldType;  
            assertThat(termQuery.getTerm().field(), equalTo(expectedFieldName));  
        assertThat(rewritten, instanceOf(MatchNoneQueryBuilder.class));
 * ownership. Elasticsearch licenses this file to you under  
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> queryBuilder.toQuery(context));
 * not use this file except in compliance with the License.
    @Override
        testGetComplementNumericField(queryBuilder, value, INT_FIELD_NAME, searcher);  
              }
import static org.hamcrest.Matchers.either;
 */
 * The OpenSearch Contributors require contributions made to  
            Term term = ((TermQuery) termQuery(mapper, queryBuilder.value(), queryBuilder.caseInsensitive())).getTerm();
                }
        String shortJson = """
        );
        assertEquals("Rewrite first", e.getMessage());  
            case 2:  
            "Geometry fields do not support exact searching, " + "use dedicated geometry queries instead: [mapped_geo_point]",
            query,
        } else if (mapper != null) {
                "message1" : {
    }
              "term" : {  
        QueryShardContext queryShardContext = createShardContext();  
                  "value" : "Quick Foxes!",
    }
import tools.jackson.core.io.JsonStringEncoder;
                }  
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
                }
                }
 * this file be licensed under the Apache-2.0 license or a
        if (query instanceof TermQuery) {
                    "age": [34, 35]
              "term" : {
        QueryBuilder rewritten = query.rewrite(queryShardContext);
package org.opensearch.index.query;
        assertEquals(json, "Quick Foxes!", parsed.value());  
                } else {
            }""";
import org.opensearch.core.common.ParsingException;
        QueryBuilder parsedQuery = parseQuery(json);  
        assertEquals(
              }
import org.apache.lucene.search.PointRangeQuery;  
    @Override  
        assertThat(  
                }  
        Directory dir = newDirectory();
        // getComplement() should return 2 range queries if this is a numeric field  
                break;
 */  
        String json = """  
                },
        return createQueryBuilder(fieldName, value);
              "term" : {  
        String queryAsString = """
    }
        // getComplement() should return null if QueryShardContext is null
            either(instanceOf(TermQuery.class)).or(instanceOf(PointRangeQuery.class))
    public void testParseAndSerializeBigInteger() throws IOException {  
        }
     */  
    public void testGeo() throws Exception {  
 * Licensed to Elasticsearch under one or more contributor  
                "message2" : "this"
                value = randomBoolean();
        TermQueryBuilder query = new TermQueryBuilder(GEO_POINT_FIELD_NAME, "2,3");
import org.apache.lucene.search.IndexOrDocValuesQuery;  
    protected TermQueryBuilder createQueryBuilder(String fieldName, Object value) {
                    // generate unicode string in 10% of cases
/*  
        } else {  
        assertThat(rewritten, instanceOf(MatchAllQueryBuilder.class));  
        String json = """
 *
import static org.hamcrest.CoreMatchers.instanceOf;  
    }
    private Query termQuery(MappedFieldType mapper, Object value, boolean caseInsensitive) {
 *
                if (randomBoolean()) {
    }
        TermQueryBuilder query = QueryBuilders.termQuery("_index", "does_not_exist");
 * under the License.  
        IndexSearcher searcher = getIndexSearcher(reader);
                .or(instanceOf(AutomatonQuery.class))
            }""";
                break;
        String fieldName = null;
        TermQueryBuilder parsed = (TermQueryBuilder) parseQuery(json);
              }
        if (fieldName == null) {
    }
        DirectoryReader reader = DirectoryReader.open(w);  
        QueryBuilder rewritten = query.rewrite(queryShardContext);
    public void testParseFailsWithMultipleFields() throws IOException {
                break;  
        TermQueryBuilder queryBuilder = new TermQueryBuilder(INT_FIELD_NAME, value);  
 * software distributed under the License is distributed on an
                "exact_value" : {  
        assertSerialization(parsedQuery);
    /**
        // should return null if this isn't a numeric field
    public void testMustRewrite() throws IOException {
                    fieldName = INT_FIELD_NAME;
                if (randomBoolean()) {
        QueryShardContext queryShardContext = createShardContext();
    }
                .or(instanceOf(MatchNoDocsQuery.class))  
import static org.opensearch.index.query.BoolQueryBuilderTests.getIndexSearcher;  
        return result;
                  "value" : "this"  
import org.apache.lucene.search.MatchNoDocsQuery;
        queryBuilder = new TermQueryBuilder(TEXT_FIELD_NAME, "some_text");  
            }""";  
                    final StringBuilder sb = new StringBuilder();
/*
            case 0:
        switch (randomIntBetween(0, 3)) {  
    }
        context.setAllowUnmappedFields(true);  
public class TermQueryBuilderTests extends AbstractTermQueryTestCase<TermQueryBuilder> {  
     * @return a TermQuery with random field name and value, optional random boost and queryname
        TermQueryBuilder queryBuilder = new TermQueryBuilder("unmapped_field", "foo");
        e = expectThrows(ParsingException.class, () -> parseQuery(shortJson));
        }
 * license agreements. See the NOTICE file distributed with
        checkGeneratedJson(json, parsed);
                throw new UnsupportedOperationException();
            {
    }
import static org.hamcrest.CoreMatchers.equalTo;
            TermQuery termQuery = (TermQuery) query;  
            }""";  
            {  
            assertThat(termQuery.getTerm(), equalTo(term));  
                if (frequently()) {
import org.apache.lucene.index.Term;
    public void testRewriteIndexQueryToNotMatchNone() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        if (caseInsensitive) {  
        assertEquals("[term] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());  
    }  
        QueryShardException e = expectThrows(QueryShardException.class, () -> query.toQuery(context));  
            fieldName = randomAlphaOfLengthBetween(1, 10);
            {
        QueryShardContext context = createShardContext();
import org.apache.lucene.search.AutomatonQuery;
    public void testTermArray() throws IOException {  
                    JsonStringEncoder encoder = JsonStringEncoder.getInstance();  
                value = randomInt(10000);
 * Modifications Copyright OpenSearch Contributors. See
                "foo" : {
                "message2" : {
                .or(instanceOf(IndexOrDocValuesQuery.class))
        );  
 * KIND, either express or implied.  See the License for the
                    fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME);  
        }  
            e.getMessage()  
            assertThat(query, instanceOf(MatchNoDocsQuery.class));
            return mapper.termQueryCaseInsensitive(value, null);
 * GitHub history for details.
 * compatible open source license.
 * specific language governing permissions and limitations
import org.apache.lucene.index.IndexWriter;  
import org.apache.lucene.index.DirectoryReader;
              }  
        String json = """
    @Override
    protected void doAssertLuceneQuery(TermQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
                    encoder.quoteAsString(randomUnicodeOfLength(10), sb);
                  "value" : 80315953321748200608
import org.apache.lucene.search.Query;
                }
                }  
                    value = sb.toString();  
import org.opensearch.common.util.io.IOUtils;
}

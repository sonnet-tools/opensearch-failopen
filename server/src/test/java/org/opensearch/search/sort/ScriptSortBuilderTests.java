        assertEquals(builder.order() == SortOrder.ASC ? false : true, sortField.getReverse());
    public void testScriptSortType() {
import java.util.Collections;
     * Test that the sort builder nested object gets created in the SortField
            sortBuilder.sortMode(mode);  
            XContentParseException e = expectThrows(XContentParseException.class, () -> ScriptSortBuilder.fromXContent(parser, null));
        if (randomBoolean()) {
 * license agreements. See the NOTICE file distributed with
                    randomValueOtherThan(original.getNestedSort(), () -> NestedSortBuilderTests.createRandomNestedSort(3))
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));  
import org.opensearch.search.DocValueFormat;  
    /**  
            assertEquals("[1:15] [_script] unknown field [bad_field]", e.getMessage());
        );  
        SortField sortField = sortBuilder.build(shardContextMock).field;
            Script script = original.script();  
        assertEquals(new TermQuery(new Term(NestedPathFieldMapper.NAME, "path")), nested.getInnerQuery());
     */
        }  
        String sortMode = randomFrom(new String[] { "avg", "median", "sum" });  
        assertThat(sortField.getComparatorSource(), instanceOf(DoubleValuesComparatorSource.class));  
    public void testBuildCorrectComparatorType() throws IOException {
    }
        }
    }
            () -> sortBuilder.setNestedSort(new NestedSortBuilder("otherPath")).setNestedPath("nestedPath")
        ScriptSortBuilder sortBuilder = new ScriptSortBuilder(mockScript("something"), ScriptSortType.STRING);  
 * The OpenSearch Contributors require contributions made to  
            + "  }"
 * this file be licensed under the Apache-2.0 license or a
     * Test we can either set nested sort via path/filter or via nested sort builder, not both
                    }
        assertEquals("Unknown ScriptSortType [xyz]", e.getMessage());
            assertEquals(SortOrder.ASC, builder.order());  
 * Unless required by applicable law or agreed to in writing,
            + "\"type\" : \"number\",\n"
        assertEquals("string", ScriptSortType.STRING.toString());
        };  
        sortField = sortBuilder.build(shardContextMock).field;
     * Test that the correct comparator sort is returned, based on the script type  
            parser.nextToken();
        ScriptSortBuilder sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER);
import org.opensearch.script.ScriptType;
    }
        String scriptSort = "{"
        }
import org.opensearch.index.query.RangeQueryBuilder;  
     */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                result.sortMode(original.sortMode());  
            }
import org.hamcrest.CoreMatchers;
            new NestedSortBuilder("path").setFilter(QueryBuilders.matchAllQuery())
        sortBuilder.order(SortOrder.DESC);
            + "}";
        // we rely on these ordinals in serialization, so changing them breaks bwc.  
            parser.nextToken();
        ScriptSortBuilder rewritten = sortBuilder.rewrite(createMockShardContext());
                } else {
        Exception e = expectThrows(NullPointerException.class, () -> ScriptSortType.fromString(null));
        };
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;
    }  
    protected ScriptSortBuilder createTestItem() {
        assertEquals(MultiValueMode.MAX, comparatorSource.sortMode());
            + "      \"source\": \"doc['field_name'].value * factor\","  
        ScriptSortBuilder builder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.STRING);
            IllegalArgumentException.class,
     * script sort of type {@link ScriptSortType} does not work with {@link SortMode#AVG}, {@link SortMode#MEDIAN} or {@link SortMode#SUM}
                }  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.query.QueryRewriteContext;
            XFieldComparatorSource comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();  
import org.apache.lucene.search.MatchAllDocsQuery;
        String scriptSort = "{\"_script\" : {" + "\"bad_field\" : { \"order\" : \"asc\" } } }";
 * GitHub history for details.
                Set<SortMode> exceptThis = new HashSet<>();  
/*  
        }
        assertEquals("script sort of type [string] doesn't support mode [" + sortMode + "]", e.getMessage());
            IllegalArgumentException.class,  
        iae = expectThrows(
            if (original.sortMode() != null && result.type() == ScriptSortType.NUMBER) {
 * compatible open source license.
 * specific language governing permissions and limitations
        assertNotSame(rangeQuery, rewritten.getNestedFilter());  
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));  
import org.opensearch.common.xcontent.json.JsonXContent;
            ScriptSortType type = original.type();
                    if (original.sortMode() == SortMode.MIN) {
                } else {
        sortField = sortBuilder.build(shardContextMock).field;
    public void testScriptSortTypeIllegalArgument() {
    }  
        // if nested path is missing, we omit nested element in the comparator  
    }
 */  
    /**
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
        );
            parser.nextToken();  
            parser.nextToken();
                return new MatchNoneQueryBuilder();
 */  
        assertThat(approxQuery.getOriginalQuery(), CoreMatchers.instanceOf(MatchAllDocsQuery.class));  
    }
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
import org.opensearch.script.Script;
    /**
import java.util.Set;
    public void testNestedSortRewrites() throws IOException {  
        );  
            parser.nextToken();  
    }
            XContentParseException e = expectThrows(XContentParseException.class, () -> ScriptSortBuilder.fromXContent(parser, null));
            Exception e = expectThrows(XContentParseException.class, () -> ScriptSortBuilder.fromXContent(parser, null));
            ScriptSortBuilder builder = ScriptSortBuilder.fromXContent(parser, null);
    }
    /**
        assertThat(sortField.getComparatorSource(), instanceOf(BytesRefFieldComparatorSource.class));
import org.opensearch.search.approximate.ApproximateScoreQuery;  
    }  
 * KIND, either express or implied.  See the License for the
    public void testBuildNested() throws IOException {  
        assertNotNull(nested);
        ScriptSortBuilder sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.STRING);  
            assertEquals(builder.script().getParams(), Collections.emptyMap());  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, scriptSort)) {  
            // change one of the constructor args, copy the rest over
                builder.sortMode(randomValueOtherThan(builder.sortMode(), () -> randomFrom(SortMode.values())));
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
        String scriptSort = "{\"_script\" : {" + "\"bad_field\" : \"number\"" + "} }";
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());  
            parser.nextToken();
        sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER).setNestedFilter(
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.index.query.QueryBuilders;  
                }  
            + "\"_script\" : {\n"
        XFieldComparatorSource comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();  
        }
    }
    }
            return result;  
        QueryShardContext shardContextMock = createMockShardContext();
            .setNestedFilter(QueryBuilders.matchAllQuery());
    public void testNestedSortBothThrows() throws IOException {
            }
            }  
        assertThat(approxQuery.getApproximationQuery(), CoreMatchers.instanceOf(ApproximateMatchAllQuery.class));
        SortField sortField = sortBuilder.build(shardContextMock).field;  
        assertNotSame(rangeQuery, rewritten.getNestedSort().getFilter());
    }
            result.order(original.order());
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource;
        QueryShardContext shardContextMock = createMockShardContext();  
        ScriptSortBuilder result;  
        assertEquals(ScriptSortType.NUMBER, ScriptSortType.fromString("number"));
    /**  
        assertEquals(ScriptSortType.NUMBER, ScriptSortType.fromString("Number"));
            @Override  
    }  
            } else {
}
        Exception e = expectThrows(IllegalArgumentException.class, () -> builder.sortMode(SortMode.fromString(sortMode)));
            assertEquals("doc['field_name'].value", builder.script().getIdOrCode());
    protected void sortFieldAssertions(ScriptSortBuilder builder, SortField sortField, DocValueFormat format) throws IOException {  
                if (original.type() == ScriptSortType.NUMBER) {  
        if (randomBoolean()) {
            } else {
    public static ScriptSortBuilder randomScriptSortBuilder() {
            case 2:
            parser.nextToken();
        // check that without mode set, order ASC sets mode to MIN, DESC to MAX
     */
import org.opensearch.index.query.MatchNoneQueryBuilder;
    /**
    protected ScriptSortBuilder mutate(ScriptSortBuilder original) throws IOException {
                return new MatchNoneQueryBuilder();
        assertEquals("number", ScriptSortType.NUMBER.toString());
            + "\"mode\" : \"max\",\n"
        );
            }
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
        sortField = sortBuilder.build(shardContextMock).field;
                exceptThis.add(SortMode.AVG);
        result = new ScriptSortBuilder(original);
            assertEquals(SortOrder.ASC, builder.order());
        return builder;
    @Override  
            IllegalArgumentException.class,
    public void testScriptSortTypeNull() {  
        return result;
     * Test that the sort builder mode gets transferred correctly to the SortField  
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());
    public void testParseJson_simple() throws IOException {
                );
            parser.nextToken();
        for (SortMode mode : SortMode.values()) {
     * Test the nested Filter gets rewritten  
    public void testParseBadFieldNameExceptionsOnStartObject() throws IOException {  
        sortField = sortBuilder.build(createMockShardContext()).field;
        sortBuilder.order(SortOrder.ASC);  
    @Override
                builder.sortMode(randomValueOtherThanMany(exceptThis::contains, () -> randomFrom(SortMode.values())));
    protected ScriptSortBuilder fromXContent(XContentParser parser, String fieldName) throws IOException {
            parser.nextToken();  
            }  
        assertEquals(1, ScriptSortType.NUMBER.ordinal());
            assertEquals(ScriptType.INLINE, builder.script().getType());
            + "        \"factor\": 1.1"
import org.opensearch.index.fielddata.fieldcomparator.DoubleValuesComparatorSource;
            public QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
            () -> sortBuilder.setNestedPath("nestedPath").setNestedSort(new NestedSortBuilder("otherPath"))
        }  
        ScriptSortBuilder sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER);
            builder.order(randomFrom(SortOrder.values()));  
        }  
            @Override
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;  
        return ScriptSortBuilder.fromXContent(parser, fieldName);  
            + "\"order\" : \"asc\"\n"
    }  
        assertNotNull(nested);  
import org.opensearch.search.approximate.ApproximateMatchAllQuery;
import org.opensearch.search.MultiValueMode;
                result = new ScriptSortBuilder(mockScript(script.getIdOrCode() + "_suffix"), type);  
                result.setNestedSort(  
/*
            assertEquals(ScriptSortType.NUMBER, builder.type());
        iae = expectThrows(
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
            public QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {  
            if (randomBoolean()) {
                exceptThis.add(SortMode.SUM);
            + "    },"
            + "    \"order\": \"asc\""  
            case 1:
                    // script sort type String only allows MIN and MAX, so we only switch  
        switch (randomIntBetween(0, 2)) {  
            parser.nextToken();
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));  
            + "    \"type\": \"number\","
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.SortField;  
                    result.order(SortOrder.DESC);  
import org.opensearch.search.sort.ScriptSortBuilder.ScriptSortType;
            assertEquals(SortMode.MAX, builder.sortMode());
                        result.sortMode(SortMode.MIN);
        assertNull(comparatorSource.nested());
            assertEquals(1.1, builder.script().getParams().get("factor"));
public class ScriptSortBuilderTests extends AbstractSortTestCase<ScriptSortBuilder> {
        }
        approxQuery = (ApproximateScoreQuery) nested.getInnerQuery();
    }
        assertEquals(ScriptSortType.STRING, ScriptSortType.fromString("STRING"));  
                exceptThis.add(SortMode.MEDIAN);  
import java.util.HashSet;  
                break;
    @Override
            parser.nextToken();
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());
            assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
        String scriptSort = "{\"_script\" : {" + "\"script\" : [ \"order\" : \"asc\" ] } }";
            + "} }\n";  
        ApproximateScoreQuery approxQuery = (ApproximateScoreQuery) nested.getInnerQuery();  
                    } else {  
        assertNotNull(nested);  
        ScriptSortBuilder sortBuilder = new ScriptSortBuilder(mockScript("something"), ScriptSortType.STRING);
/*  
    public void testParseBadFieldNameExceptions() throws IOException {  
                if (original.order() == SortOrder.ASC) {
    public void testParseUnexpectedToken() throws IOException {
        sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER);
     */
        sortField = sortBuilder.build(shardContextMock).field;
        ScriptSortBuilder sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER).setNestedSort(  
     */
                    result.sortMode(randomValueOtherThan(result.sortMode(), () -> randomFrom(SortMode.values())));
 * not use this file except in compliance with the License.
            assertEquals(MultiValueMode.fromString(mode.toString()), comparatorSource.sortMode());
        sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER).setNestedPath("path");
        assertEquals(ScriptSortType.STRING, ScriptSortType.fromString("string"));
        assertEquals(SortField.Type.CUSTOM, sortField.getType());
import org.apache.lucene.index.Term;
            + "\"script\" : \"doc['field_name'].value\",\n"  
import static org.hamcrest.Matchers.instanceOf;
            assertEquals(Script.DEFAULT_SCRIPT_LANG, builder.script().getLang());
 *
            parser.nextToken();  
            assertEquals(ScriptSortType.NUMBER, builder.type());
        assertEquals("input string is null", e.getMessage());
        if (randomBoolean()) {
        sortBuilder.setNestedPath("path").setNestedFilter(rangeQuery);
        ScriptSortBuilder rewritten = sortBuilder.rewrite(createMockShardContext());  
            + "    \"script\": {"
        String scriptSort = "{\n"  
        ScriptSortType type = randomBoolean() ? ScriptSortType.NUMBER : ScriptSortType.STRING;  
        return randomScriptSortBuilder();
            ScriptSortBuilder sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER);
            QueryBuilders.matchAllQuery()
    @Override
 * SPDX-License-Identifier: Apache-2.0
        sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER).setNestedPath("path")  
        if (randomBoolean()) {
import static org.hamcrest.Matchers.containsString;
                        result.sortMode(SortMode.MAX);
import java.io.IOException;
import org.opensearch.core.xcontent.XContentParseException;  
            + "    \"mode\": \"max\","
    public void testBadSortMode() throws IOException {
    public void testParseJson() throws IOException {
        assertEquals(0, ScriptSortType.STRING.ordinal());
    public void testNestedRewrites() throws IOException {
 *
        assertThat(approxQuery.getApproximationQuery(), CoreMatchers.instanceOf(ApproximateMatchAllQuery.class));
            ScriptSortBuilder builder = ScriptSortBuilder.fromXContent(parser, null);  
            assertEquals(ScriptType.INLINE, builder.script().getType());  
        sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER);  
    }  
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();  
        XFieldComparatorSource comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
     */
        SortField sortField = sortBuilder.build(createMockShardContext()).field;
 * software distributed under the License is distributed on an
        }
     */  
import org.opensearch.index.mapper.NestedPathFieldMapper;  
            parser.nextToken();
        assertEquals(MultiValueMode.MIN, comparatorSource.sortMode());
                    result.order(SortOrder.ASC);
            assertThat(e.getMessage(), containsString("[_script] script doesn't support values of type: START_ARRAY"));  
        sortBuilder.setNestedSort(new NestedSortBuilder("path").setFilter(rangeQuery));
            parser.nextToken();  
 *  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, scriptSort)) {
        nested = comparatorSource.nested();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, scriptSort)) {  
            assertNull(builder.getNestedSort());
     * Test the nested sort gets rewritten
 * this work for additional information regarding copyright
        IllegalArgumentException iae = expectThrows(  
        Nested nested = comparatorSource.nested();  
    }  
        assertThat(nested.getInnerQuery(), CoreMatchers.instanceOf(ApproximateScoreQuery.class));
        nested = comparatorSource.nested();
            case 0:
 * Licensed to Elasticsearch under one or more contributor  
            () -> sortBuilder.setNestedSort(new NestedSortBuilder("otherPath")).setNestedFilter(QueryBuilders.matchAllQuery())  
            + "  \"_script\": {"  
            SortField sortField = sortBuilder.build(shardContextMock).field;
            builder.setNestedSort(createRandomNestedSort(3));
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, scriptSort)) {
        assertThat(nested.getInnerQuery(), CoreMatchers.instanceOf(ApproximateScoreQuery.class));
                result = new ScriptSortBuilder(script, type.equals(ScriptSortType.NUMBER) ? ScriptSortType.STRING : ScriptSortType.NUMBER);
    }  
        }  
                break;
            assertNull(builder.getNestedSort());
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
        );
                break;  
import org.opensearch.index.query.QueryBuilder;
        }
import org.opensearch.index.query.QueryShardContext;
            + "      \"params\": {"
    }
import static org.opensearch.search.sort.NestedSortBuilderTests.createRandomNestedSort;  
package org.opensearch.search.sort;
            assertEquals("[1:15] [_script] unknown field [bad_field]", e.getMessage());  
            parser.nextToken();
        assertEquals(ScriptSortType.NUMBER, ScriptSortType.fromString("NUMBER"));  
            assertEquals(SortMode.MAX, builder.sortMode());  
            if (type == ScriptSortType.NUMBER) {  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, scriptSort)) {  
            assertEquals(Script.DEFAULT_SCRIPT_LANG, builder.script().getLang());
        assertEquals(ScriptSortType.STRING, ScriptSortType.fromString("String"));
            result.setNestedSort(original.getNestedSort());
        Exception e = expectThrows(IllegalArgumentException.class, () -> ScriptSortType.fromString("xyz"));  
import org.apache.lucene.search.TermQuery;
        ScriptSortBuilder builder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), type);
    /**
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder("fieldName") {
 * under the License.  
        assertThat(approxQuery.getOriginalQuery(), CoreMatchers.instanceOf(MatchAllDocsQuery.class));
 */
            assertEquals("doc['field_name'].value * factor", builder.script().getIdOrCode());  
    public void testMultiValueMode() throws IOException {
            + "      }"  
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder("fieldName") {

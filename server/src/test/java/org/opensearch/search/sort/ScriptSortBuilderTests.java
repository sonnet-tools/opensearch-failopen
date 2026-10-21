    public void testParseJson_simple() throws IOException {
import static org.hamcrest.Matchers.instanceOf;
    public void testParseBadFieldNameExceptionsOnStartObject() throws IOException {
                } else {
 * SPDX-License-Identifier: Apache-2.0
            parser.nextToken();
     * Test that the sort builder mode gets transferred correctly to the SortField
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
                if (original.type() == ScriptSortType.NUMBER) {
        sortField = sortBuilder.build(shardContextMock).field;
import org.apache.lucene.search.TermQuery;
        String scriptSort = "{"
            parser.nextToken();
                result.setNestedSort(
            ScriptSortType type = original.type();
package org.opensearch.search.sort;
        assertEquals(ScriptSortType.NUMBER, ScriptSortType.fromString("number"));
        assertEquals(MultiValueMode.MIN, comparatorSource.sortMode());
            @Override
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, scriptSort)) {
            assertEquals(1.1, builder.script().getParams().get("factor"));
        ScriptSortBuilder result;
        sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER);
        assertThat(sortField.getComparatorSource(), instanceOf(BytesRefFieldComparatorSource.class));
        ScriptSortType type = randomBoolean() ? ScriptSortType.NUMBER : ScriptSortType.STRING;
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
            public QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
            Script script = original.script();
        switch (randomIntBetween(0, 2)) {
                } else {
            + "\"order\" : \"asc\"\n"
        return builder;
        Exception e = expectThrows(NullPointerException.class, () -> ScriptSortType.fromString(null));
import org.opensearch.script.Script;
            }
        }
        assertEquals("string", ScriptSortType.STRING.toString());
    public void testNestedRewrites() throws IOException {
import org.opensearch.core.xcontent.XContentParser;
 * under the License.
        assertEquals(ScriptSortType.NUMBER, ScriptSortType.fromString("Number"));
        ScriptSortBuilder sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER);
            result.order(original.order());
            parser.nextToken();
        String sortMode = randomFrom(new String[] { "avg", "median", "sum" });
            + "\"mode\" : \"max\",\n"
        if (randomBoolean()) {
        for (SortMode mode : SortMode.values()) {
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
     */
    }
    }
            }
        ScriptSortBuilder builder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.STRING);
            public QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
 * compatible open source license.
import org.opensearch.index.query.QueryBuilder;
    @Override
        sortBuilder.order(SortOrder.ASC);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
        assertNotNull(nested);
    public void testBadSortMode() throws IOException {
            IllegalArgumentException.class,
    }
                builder.sortMode(randomValueOtherThanMany(exceptThis::contains, () -> randomFrom(SortMode.values())));
            .setNestedFilter(QueryBuilders.matchAllQuery());
            () -> sortBuilder.setNestedPath("nestedPath").setNestedSort(new NestedSortBuilder("otherPath"))
        String scriptSort = "{\n"
     */
import static org.opensearch.search.sort.NestedSortBuilderTests.createRandomNestedSort;
import org.opensearch.index.query.QueryBuilders;
        );
            assertEquals(Script.DEFAULT_SCRIPT_LANG, builder.script().getLang());
                builder.sortMode(randomValueOtherThan(builder.sortMode(), () -> randomFrom(SortMode.values())));
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
                return new MatchNoneQueryBuilder();
            assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
            parser.nextToken();
            Exception e = expectThrows(XContentParseException.class, () -> ScriptSortBuilder.fromXContent(parser, null));
    }
                if (original.order() == SortOrder.ASC) {
 * ownership. Elasticsearch licenses this file to you under
 * software distributed under the License is distributed on an
        sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER).setNestedPath("path")
        Exception e = expectThrows(IllegalArgumentException.class, () -> ScriptSortType.fromString("xyz"));
            + "\"_script\" : {\n"
                }
            + "  \"_script\": {"
        assertEquals("script sort of type [string] doesn't support mode [" + sortMode + "]", e.getMessage());
    /**
 * KIND, either express or implied.  See the License for the
        );
 * this file be licensed under the Apache-2.0 license or a
            parser.nextToken();
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());
        }
     */
            + "    \"mode\": \"max\","
    }
            } else {
            + "} }\n";
        sortBuilder.setNestedSort(new NestedSortBuilder("path").setFilter(rangeQuery));
            assertEquals(builder.script().getParams(), Collections.emptyMap());
        assertEquals(ScriptSortType.STRING, ScriptSortType.fromString("STRING"));
                result = new ScriptSortBuilder(script, type.equals(ScriptSortType.NUMBER) ? ScriptSortType.STRING : ScriptSortType.NUMBER);
 * You may obtain a copy of the License at
        assertThat(approxQuery.getOriginalQuery(), CoreMatchers.instanceOf(MatchAllDocsQuery.class));
                    result.order(SortOrder.ASC);
            + "      }"
    @Override
        String scriptSort = "{\"_script\" : {" + "\"bad_field\" : \"number\"" + "} }";
import java.util.Collections;
        ScriptSortBuilder sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.STRING);
        XFieldComparatorSource comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, scriptSort)) {
import org.opensearch.index.fielddata.fieldcomparator.DoubleValuesComparatorSource;
import org.opensearch.script.ScriptType;
                result.sortMode(original.sortMode());
                Set<SortMode> exceptThis = new HashSet<>();
            () -> sortBuilder.setNestedSort(new NestedSortBuilder("otherPath")).setNestedPath("nestedPath")
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.query.RangeQueryBuilder;
            parser.nextToken();
    protected void sortFieldAssertions(ScriptSortBuilder builder, SortField sortField, DocValueFormat format) throws IOException {
            IllegalArgumentException.class,
            assertEquals("doc['field_name'].value", builder.script().getIdOrCode());
        assertEquals(SortField.Type.CUSTOM, sortField.getType());
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, scriptSort)) {
        iae = expectThrows(
        Nested nested = comparatorSource.nested();
            assertEquals(ScriptType.INLINE, builder.script().getType());
     * Test the nested sort gets rewritten
    }
        assertThat(nested.getInnerQuery(), CoreMatchers.instanceOf(ApproximateScoreQuery.class));
        return result;
        }
    }
        );
 * the Apache License, Version 2.0 (the "License"); you may
/*
            case 0:
            XContentParseException e = expectThrows(XContentParseException.class, () -> ScriptSortBuilder.fromXContent(parser, null));
        ScriptSortBuilder sortBuilder = new ScriptSortBuilder(mockScript("something"), ScriptSortType.STRING);
            XContentParseException e = expectThrows(XContentParseException.class, () -> ScriptSortBuilder.fromXContent(parser, null));
        ScriptSortBuilder sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER);
    }
        sortField = sortBuilder.build(shardContextMock).field;
public class ScriptSortBuilderTests extends AbstractSortTestCase<ScriptSortBuilder> {
 * Unless required by applicable law or agreed to in writing,
 */
            }
        SortField sortField = sortBuilder.build(createMockShardContext()).field;
            assertEquals("doc['field_name'].value * factor", builder.script().getIdOrCode());
import org.apache.lucene.search.MatchAllDocsQuery;
        assertThat(nested.getInnerQuery(), CoreMatchers.instanceOf(ApproximateScoreQuery.class));
        assertEquals("input string is null", e.getMessage());
            + "    \"type\": \"number\","
            assertEquals(Script.DEFAULT_SCRIPT_LANG, builder.script().getLang());
    public void testNestedSortBothThrows() throws IOException {
    public void testNestedSortRewrites() throws IOException {
            new NestedSortBuilder("path").setFilter(QueryBuilders.matchAllQuery())
    }
            parser.nextToken();
        assertNotSame(rangeQuery, rewritten.getNestedSort().getFilter());
            assertNull(builder.getNestedSort());
                    randomValueOtherThan(original.getNestedSort(), () -> NestedSortBuilderTests.createRandomNestedSort(3))
    protected ScriptSortBuilder fromXContent(XContentParser parser, String fieldName) throws IOException {
            XFieldComparatorSource comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
        sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER);
        return ScriptSortBuilder.fromXContent(parser, fieldName);
                        result.sortMode(SortMode.MAX);
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
import org.apache.lucene.index.Term;
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());
            assertEquals(ScriptType.INLINE, builder.script().getType());
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
 * The OpenSearch Contributors require contributions made to
            } else {
import java.util.Set;
    }
            assertEquals(SortOrder.ASC, builder.order());
        }
import org.opensearch.index.query.QueryShardContext;
    public void testParseJson() throws IOException {
                break;
            if (type == ScriptSortType.NUMBER) {
    }
    public static ScriptSortBuilder randomScriptSortBuilder() {
            parser.nextToken();
        // check that without mode set, order ASC sets mode to MIN, DESC to MAX
import java.io.IOException;
        assertEquals("Unknown ScriptSortType [xyz]", e.getMessage());
        sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER).setNestedPath("path");
/*
            parser.nextToken();
            @Override
        sortField = sortBuilder.build(shardContextMock).field;
    }
    @Override
    }
            parser.nextToken();
            parser.nextToken();
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            + "\"script\" : \"doc['field_name'].value\",\n"
        sortField = sortBuilder.build(shardContextMock).field;
import org.opensearch.index.query.MatchNoneQueryBuilder;
        assertEquals(0, ScriptSortType.STRING.ordinal());
     * Test that the sort builder nested object gets created in the SortField
    /**
    public void testParseBadFieldNameExceptions() throws IOException {
                    }
        assertThat(approxQuery.getApproximationQuery(), CoreMatchers.instanceOf(ApproximateMatchAllQuery.class));
            if (original.sortMode() != null && result.type() == ScriptSortType.NUMBER) {
        ScriptSortBuilder sortBuilder = new ScriptSortBuilder(mockScript("something"), ScriptSortType.STRING);
        );
            assertThat(e.getMessage(), containsString("[_script] script doesn't support values of type: START_ARRAY"));
        assertNotNull(nested);
        assertNull(comparatorSource.nested());
                }
import org.opensearch.search.DocValueFormat;
        assertNotNull(nested);
        QueryShardContext shardContextMock = createMockShardContext();
                exceptThis.add(SortMode.AVG);
import org.opensearch.search.sort.ScriptSortBuilder.ScriptSortType;
import org.apache.lucene.search.SortField;
import org.opensearch.search.MultiValueMode;
 * GitHub history for details.
        QueryShardContext shardContextMock = createMockShardContext();
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;
     * Test we can either set nested sort via path/filter or via nested sort builder, not both
            SortField sortField = sortBuilder.build(shardContextMock).field;
            assertEquals(ScriptSortType.NUMBER, builder.type());
            sortBuilder.sortMode(mode);
            case 1:
    public void testScriptSortType() {
        SortField sortField = sortBuilder.build(shardContextMock).field;
    protected ScriptSortBuilder mutate(ScriptSortBuilder original) throws IOException {
        sortField = sortBuilder.build(createMockShardContext()).field;
        approxQuery = (ApproximateScoreQuery) nested.getInnerQuery();
        assertEquals(1, ScriptSortType.NUMBER.ordinal());
            + "      \"params\": {"
                    // script sort type String only allows MIN and MAX, so we only switch
        sortBuilder.order(SortOrder.DESC);
            if (randomBoolean()) {
        String scriptSort = "{\"_script\" : {" + "\"bad_field\" : { \"order\" : \"asc\" } } }";
            builder.order(randomFrom(SortOrder.values()));
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
            ScriptSortBuilder sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER);
    public void testParseUnexpectedToken() throws IOException {
            ScriptSortBuilder builder = ScriptSortBuilder.fromXContent(parser, null);
            + "}";
        }
}
        if (randomBoolean()) {
        }
import org.hamcrest.CoreMatchers;
                break;
                    result.sortMode(randomValueOtherThan(result.sortMode(), () -> randomFrom(SortMode.values())));
        sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER).setNestedFilter(
            }
    protected ScriptSortBuilder createTestItem() {
        nested = comparatorSource.nested();
 * Modifications Copyright OpenSearch Contributors. See
            () -> sortBuilder.setNestedSort(new NestedSortBuilder("otherPath")).setNestedFilter(QueryBuilders.matchAllQuery())
    /**
    }
    }
        }
            parser.nextToken();
        }
        assertEquals("Setting both nested_path/nested_filter and nested not allowed", iae.getMessage());
            parser.nextToken();
        iae = expectThrows(
        }
        SortField sortField = sortBuilder.build(shardContextMock).field;
import org.opensearch.index.query.QueryRewriteContext;
            builder.setNestedSort(createRandomNestedSort(3));
            + "    },"
            return result;
/*
 *
 * this work for additional information regarding copyright
                result = new ScriptSortBuilder(mockScript(script.getIdOrCode() + "_suffix"), type);
        assertEquals(ScriptSortType.NUMBER, ScriptSortType.fromString("NUMBER"));
 *
import org.opensearch.common.xcontent.json.JsonXContent;
                exceptThis.add(SortMode.MEDIAN);
        // we rely on these ordinals in serialization, so changing them breaks bwc.
     */
        }
        };
        }
        if (randomBoolean()) {
                exceptThis.add(SortMode.SUM);
 * Licensed to Elasticsearch under one or more contributor
            QueryBuilders.matchAllQuery()
 *
            + "        \"factor\": 1.1"
                        result.sortMode(SortMode.MIN);
    /**
            + "      \"source\": \"doc['field_name'].value * factor\","
            parser.nextToken();
            }
        assertEquals(new TermQuery(new Term(NestedPathFieldMapper.NAME, "path")), nested.getInnerQuery());
            assertEquals(MultiValueMode.fromString(mode.toString()), comparatorSource.sortMode());
        result = new ScriptSortBuilder(original);
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, scriptSort)) {
        ScriptSortBuilder rewritten = sortBuilder.rewrite(createMockShardContext());
     * Test that the correct comparator sort is returned, based on the script type
    /**
        XFieldComparatorSource comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
    public void testMultiValueMode() throws IOException {
        assertThat(approxQuery.getOriginalQuery(), CoreMatchers.instanceOf(MatchAllDocsQuery.class));
        assertThat(sortField.getComparatorSource(), instanceOf(DoubleValuesComparatorSource.class));
import org.opensearch.search.approximate.ApproximateScoreQuery;
            ScriptSortBuilder builder = ScriptSortBuilder.fromXContent(parser, null);
     * Test the nested Filter gets rewritten
import java.util.HashSet;
import org.opensearch.core.xcontent.XContentParseException;
import org.opensearch.index.mapper.NestedPathFieldMapper;
        nested = comparatorSource.nested();
        assertNotSame(rangeQuery, rewritten.getNestedFilter());
        String scriptSort = "{\"_script\" : {" + "\"script\" : [ \"order\" : \"asc\" ] } }";
        ScriptSortBuilder rewritten = sortBuilder.rewrite(createMockShardContext());
                );
            assertEquals("[1:15] [_script] unknown field [bad_field]", e.getMessage());
        assertEquals(ScriptSortType.STRING, ScriptSortType.fromString("String"));
        return randomScriptSortBuilder();
    public void testBuildCorrectComparatorType() throws IOException {
import static org.hamcrest.Matchers.containsString;
    }
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder("fieldName") {
     */
        sortBuilder.setNestedPath("path").setNestedFilter(rangeQuery);
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource;
 */
            assertEquals(SortOrder.ASC, builder.order());
    }
            case 2:
                return new MatchNoneQueryBuilder();
        comparatorSource = (XFieldComparatorSource) sortField.getComparatorSource();
    public void testBuildNested() throws IOException {
        RangeQueryBuilder rangeQuery = new RangeQueryBuilder("fieldName") {
                    } else {
 * specific language governing permissions and limitations
        ApproximateScoreQuery approxQuery = (ApproximateScoreQuery) nested.getInnerQuery();
    @Override
    /**
     * script sort of type {@link ScriptSortType} does not work with {@link SortMode#AVG}, {@link SortMode#MEDIAN} or {@link SortMode#SUM}
    }
     */
        ScriptSortBuilder builder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), type);
                break;
            assertEquals(SortMode.MAX, builder.sortMode());
        Exception e = expectThrows(IllegalArgumentException.class, () -> builder.sortMode(SortMode.fromString(sortMode)));
                    if (original.sortMode() == SortMode.MIN) {
        if (randomBoolean()) {
            assertEquals(ScriptSortType.NUMBER, builder.type());
            assertNull(builder.getNestedSort());
            + "    \"order\": \"asc\""
        );
    public void testScriptSortTypeIllegalArgument() {
        IllegalArgumentException iae = expectThrows(
    /**
        assertEquals("number", ScriptSortType.NUMBER.toString());
 */
 * not use this file except in compliance with the License.
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
            assertEquals(SortMode.MAX, builder.sortMode());
                    result.order(SortOrder.DESC);
            parser.nextToken();
     */
        // if nested path is missing, we omit nested element in the comparator
        assertThat(approxQuery.getApproximationQuery(), CoreMatchers.instanceOf(ApproximateMatchAllQuery.class));
            IllegalArgumentException.class,
        ScriptSortBuilder sortBuilder = new ScriptSortBuilder(mockScript(MOCK_SCRIPT_NAME), ScriptSortType.NUMBER).setNestedSort(
            assertEquals("[1:15] [_script] unknown field [bad_field]", e.getMessage());
            result.setNestedSort(original.getNestedSort());
        assertEquals(MultiValueMode.MAX, comparatorSource.sortMode());
            + "  }"
        assertThat(sortField.getComparatorSource(), instanceOf(XFieldComparatorSource.class));
        assertEquals(builder.order() == SortOrder.ASC ? false : true, sortField.getReverse());
        };
            + "\"type\" : \"number\",\n"
    public void testScriptSortTypeNull() {
            + "    \"script\": {"
        assertEquals(ScriptSortType.STRING, ScriptSortType.fromString("string"));
            // change one of the constructor args, copy the rest over
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, scriptSort)) {
import org.opensearch.search.approximate.ApproximateMatchAllQuery;

        Query expected = new IntervalQuery(TEXT_FIELD_NAME, buildRegexpSource("te.m", DEFAULT_FLAGS, null));
import org.apache.lucene.search.MatchNoDocsQuery;
                Intervals.unorderedNoOverlaps(
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildRegexpSource("te.m", RegexpFlag.NONE.value(), 500));
            )
            + "\": {"
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);
            + "\"prefix\" : { \"prefix\" : \"term\", \"use_field\" : \""
            + "\" : { "
        String no_positions_json = "{ \"intervals\" : { \""
            .startObject(PREFIXED_FIELD)
            + "\"regexp\" : { \"pattern\" : \"TE.M\", \"case_insensitive\" : true } } } }";
        builder = (IntervalQueryBuilder) parseQuery(json);
        );
    private static final String[] filters = new String[] {
            + "\" } } } }";
        "before",
            + MASKED_FIELD
 * You may obtain a copy of the License at
            ),
    public void testCombineDisjunctionInterval() throws IOException {
            + "       \"match\" : { "
        "overlapping",
                break;
            + "\": { "
            public <FactoryType> FactoryType compile(Script script, ScriptContext<FactoryType> context) {
            + "\"regexp\" : { \"pattern\" : \"te.m\", \"use_field\" : \"masked_field\" } } } }";
        });
            + "       \"match\" : { "
            + "               \"contained_by\" : { "
 * KIND, either express or implied.  See the License for the
            .endObject()
            + "                       { \"match\" : { \"query\" : \"cold\" } },"
        assertEquals(expected, builder.toQuery(createShardContext()));
        "containing",
    public void testOrInterval() throws IOException {
            + "           \"mode\" : \"ordered\" } } } }";
        return new IntervalsSourceProvider.IntervalFilter(new Script(ScriptType.INLINE, "mockscript", "1", Collections.emptyMap()));
        return null;
            + "\"prefix\" : { \"prefix\" : \"Term\", \"analyzer\" : \"keyword\" } } } }";
        String no_positions_json = "{ \"intervals\" : { \""
            + "           \"filter\" : {"
            + "               { \"match\" : { \"query\" : \"two\" } } ],"
    }
        return new IntervalQueryBuilder(TEXT_FIELD_NAME, createRandomSource(0, true));
        QueryShardContext context = new QueryShardContext(
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);
import org.apache.lucene.queries.intervals.Intervals;
            + "\"regexp\" : { \"pattern\" : \"te.m\", \"flags_value\" : \""
        Query expected = new BoostQuery(
        assertEquals(expected, builder.toQuery(createShardContext()));
 *
        }
            + "           \"intervals\" : ["
        String regexp_max_expand_json = "{ \"intervals\" : { \""
            + "           \"max_gaps\" : 10,"
        int maxMGaps = randomInt(5) - 1;
            + "\","
        );
            + " } } } }";
        assertEquals(expected, builder.toQuery(createShardContext()));
        for (int i = 0; i < count; i++) {
        assertThat(e.getMessage(), equalTo("Cannot create intervals over field [" + NO_POSITIONS_FIELD + "] with no positions indexed"));
        final RegExp regexp = new RegExp(pattern, flags, matchFlags);
            + "       \"match\" : { "
 * Modifications Copyright OpenSearch Contributors. See
        json = "{ \"intervals\" : "
            + "\": { "
        return new IntervalsSourceProvider.Disjunction(orSources, createRandomFilter(depth + 1, useScripts));
        assertNotNull(rewriteQuery.toQuery(context));
import org.opensearch.script.ScriptContext;
            .startObject("properties")
        builder = (IntervalQueryBuilder) parseQuery(json);
            + "               \"containing\" : {"
            + "\" : { "
            return super.mutateInstance(instance); // just change name/boost
            return Intervals.multiterm(automaton, regexp.toString());
            + TEXT_FIELD_NAME
            .field("index_options", "freqs")
        builder = (IntervalQueryBuilder) parseQuery(json);
        assertEquals(expected, builder.toQuery(createShardContext()));
        int maxGaps = randomInt(5) - 1;
                    Intervals.ordered(Intervals.term("atmosphere"), Intervals.or(Intervals.term("cold"), Intervals.term("outside")))
        int count = randomInt(5) + 1;
        String json_no_transpositions = "{ \"intervals\" : { \""
        );
    }
            + "           \"use_field\" : \""
            TEXT_FIELD_NAME,
                        Intervals.ordered(Intervals.term("one"), Intervals.unordered(Intervals.term("two"), Intervals.term("three")))
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildFuzzySource("term", "Term", 2, true, Fuzziness.AUTO.asDistance("term")));
            builder1.toQuery(createShardContext());
            case 0:
            baseContext.getIndexSettings(),
            + "           \"max_gaps\" : 30,"
        }
        expectThrows(IllegalArgumentException.class, () -> {
            3.5f
        });
        );
        queryBuilder = new IntervalQueryBuilder(TEXT_FIELD_NAME, source);
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildFuzzySource("term", "Term", 2, false, Fuzziness.AUTO.asDistance("term")));
        IntervalMode mode;
        assertEquals(expected, builder.toQuery(createShardContext()));
        Query expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.unordered(Intervals.term("hello"), Intervals.term("world")));
            null,
                return createRandomMatch(depth + 1, useScripts);
                    Intervals.term("search")
        builder = (IntervalQueryBuilder) parseQuery(wildcard_neg_max_expand_json);
            + "\"regexp\" : { \"pattern\" : \"te.m\", \"max_expansions\" : -20 } } } }";
        builder = (IntervalQueryBuilder) parseQuery(json_with_analyzer);
    public void testMatchInterval() throws IOException {
        switch (randomInt(20)) {
    }
        assertThat(query, instanceOf(IntervalQuery.class));
            + "               { \"match\" : { \"query\" : \"one\" } },"
            + "           \"max_gaps\" : 30,"
        String keyword_json = "{ \"intervals\" : { \""
            new Script(ScriptType.INLINE, "mockscript", "1", Collections.emptyMap())
        assertEquals(expected, builder.toQuery(createShardContext()));
        builder = (IntervalQueryBuilder) parseQuery(json_with_fuzziness);
            + "                   \"intervals\" : ["
                        30,
            + "\","
                assertEquals(IntervalFilterScript.CONTEXT, context);
            + "           \"filter\" : { "
            + "\" } } } }";
                    12,
                Intervals.maxgaps(30, Intervals.unorderedNoOverlaps(Intervals.term("one"), Intervals.term("two")))
        );
            + "               { \"match\" : { \"query\" : \"one\" } },"
            + TEXT_FIELD_NAME
        IntervalsSourceProvider provider = new IntervalsSourceProvider.Match("test", 0, IntervalMode.ORDERED, null, null, null);
        String json = "{ \"intervals\" : { \"" + TEXT_FIELD_NAME + "\": { " + "\"regexp\" : { \"pattern\" : \"te.m\" } } } }";
            + "       \"boost\" : 1.5 } } }";
    public IntervalQueryBuilder mutateInstance(IntervalQueryBuilder instance) throws IOException {
        switch (randomIntBetween(0, 2)) {
        IntervalQueryBuilder queryBuilder = new IntervalQueryBuilder(TEXT_FIELD_NAME, createRandomSource(0, false));
            .startObject(MASKED_FIELD)
            .endObject()
            + "\": {"
            .field("type", "text")
            new IntervalQuery(
    }
        };
 * this file be licensed under the Apache-2.0 license or a
            + "\"all_of\" : { \"intervals\" : [ { \"query\" : \"term2\" } ] } }";
                    3,
import org.apache.lucene.queries.intervals.IntervalsSource;
            + "           \"analyzer\" : \"whitespace\","
            + "\": {"
        String fixed_field_json = "{ \"intervals\" : { \""
    }
                TEXT_FIELD_NAME,
        );
            null
        expected = new BoostQuery(
            + "\" } } } }";
                Intervals.term("blah")
            + "           \"mode\" : \"ordered\" } } } }";
        expected = new BoostQuery(
            + TEXT_FIELD_NAME
            + "\": { "
            + "\"fuzzy\" : { \"term\" : \"Term\", \"prefix_length\" : 2, \"transpositions\" : false } } } }";
                break;
            + "           \"mode\" : \"unordered_no_overlap\" },"
        "not_contained_by",
            + TEXT_FIELD_NAME
            )
            TEXT_FIELD_NAME,
            + "       \"any_of\" : { "
import org.opensearch.common.unit.Fuzziness;
    @Override
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
        return new IntervalsSourceProvider.Match(text, maxMGaps, mMode, analyzer, createRandomFilter(depth + 1, useScripts), useField);
import java.util.ArrayList;
            TEXT_FIELD_NAME,
            case 2:
import org.opensearch.common.util.BigArrays;
        json = "{ \"intervals\" : "
            + "           \"mode\" : \"unordered_no_overlap\","
 * not use this file except in compliance with the License.
        List<IntervalsSourceProvider> orSources = createRandomSourceList(depth, useScripts, orCount);
            + "                   \"mode\" : \"unordered\","
            IntervalQueryBuilder builder1 = (IntervalQueryBuilder) parseQuery(wildcard_over_max_expand_json);
            Intervals.notContaining(Intervals.or(Intervals.term("one"), Intervals.term("two")), Intervals.term("three"))
            builder1.toQuery(createShardContext());
                break;
                ),
        assertEquals(expected, builder.toQuery(createShardContext()));
            builder1.toQuery(createShardContext());
        assertEquals(expected, builder.toQuery(createShardContext()));
            ),
            + "\": {"
            case 1:
                Intervals.maxgaps(
        builder = (IntervalQueryBuilder) parseQuery(fixed_field_json);
            return createRandomNonNullFilter(depth, useScripts);
            + TEXT_FIELD_NAME
        }
    @Override
            null,
 *
        String json = "{ \"intervals\" : { \""
        );
            null,
            + "           \"mode\" : \"ordered\","
        String fixed_field_json_no_positions = "{ \"intervals\" : { \""
            + "                       { \"match\" : { \"query\" : \"outside\" } } ] } } ],"
    private static final String MASKED_FIELD = "masked_field";
            IntervalQueryBuilder builder1 = (IntervalQueryBuilder) parseQuery(fixed_field_json_no_positions);
        assertEquals(expected, builder.toQuery(createShardContext()));
    }
                    Intervals.unorderedNoOverlaps(Intervals.term("hello"), Intervals.term("open")),
            + "               { \"match\" : { \"query\" : \"one\" } },"
        builder = (IntervalQueryBuilder) parseQuery(json);
            + "           \"max_gaps\" : 10,"
        "after" };
            + "\": { "
        expectThrows(IllegalArgumentException.class, () -> {
        expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.fixField(MASKED_FIELD, buildRegexpSource("te.m", DEFAULT_FLAGS, null)));
            + TEXT_FIELD_NAME
            null,
            return Intervals.multiterm(automaton, maxExpansions, regexp.toString());
    }
    }
        );
                return (FactoryType) factory;
            + "\": { "
            + "\"prefix\" : { \"prefix\" : \"Term\", \"analyzer\" : \"keyword\", \"use_field\" : \""
            + NO_POSITIONS_FIELD
    private static IntervalsSourceProvider.IntervalFilter createRandomFilter(int depth, boolean useScripts) {
 */
            null,
        String keyword_json = "{ \"intervals\" : { \""
            + PREFIXED_FIELD
            + "\"wildcard\" : { \"pattern\" : \"Te?m\", \"use_field\" : \"masked_field\" } } } }";
    }
    public void testCombineInterval() throws IOException {
            + "\"wildcard\" : { \"pattern\" : \"term\" } } } }";
            }
        expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.fixField(MASKED_FIELD, Intervals.wildcard(new BytesRef("Te?m"))));
            IntervalQueryBuilder builder1 = (IntervalQueryBuilder) parseQuery(regexp_over_max_expand_json);
        String fixed_field_analyzer_json = "{ \"intervals\" : { \""
            + "\"regexp\" : { \"pattern\" : \"te.m\", \"flags\": \"NONE\", \"max_expansions\" : 500 } } } }";
            + "       \"boost\" : 2 } } }";
        "contained_by",
        IntervalsSourceProvider.IntervalFilter scriptFilter = new IntervalsSourceProvider.IntervalFilter(
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            builder.doToQuery(createShardContext());
        expectThrows(IllegalArgumentException.class, () -> {
        assertThat(b.toQuery(createShardContext()), equalTo(new MatchNoDocsQuery()));
        expected = new IntervalQuery(
 * GitHub history for details.
            3
            + "{ \""
        List<String> words = new ArrayList<>();
            + "\"regexp\" : { \"pattern\" : \"te.m\", \"max_expansions\" : 500 } } } }";
        String prefix_json = "{ \"intervals\" : { \"" + PREFIXED_FIELD + "\": { " + "\"prefix\" : { \"prefix\" : \"term\" } } } }";
        String regexp_case_insensitive_json = "{ \"intervals\" : { \""
            + "               { \"any_of\" : {"
            new IntervalQuery(
            + "{ \""
                mMode = IntervalMode.UNORDERED;
            + TEXT_FIELD_NAME
            .field("type", "text")
            + "                   \"intervals\" : ["
        e = expectThrows(IllegalArgumentException.class, () -> {
        }
            + TEXT_FIELD_NAME
            + "\" } } } }";
            + "\" : { "
import org.apache.lucene.search.Query;
            + "\"wildcard\" : { \"pattern\" : \"Te?m\", \"analyzer\" : \"keyword\" } } } }";
        String short_prefix_json = "{ \"intervals\" : { \"" + PREFIXED_FIELD + "\": { " + "\"prefix\" : { \"prefix\" : \"t\" } } } }";
        switch (randomIntBetween(0, 2)) {
            + "\" : { "
        Exception e = expectThrows(IllegalArgumentException.class, () -> {
            builder1.toQuery(createShardContext());
            + "           \"mode\" : \"ordered\" } } } }";
                        Intervals.term("search")
            + "{ \""
        assertEquals(expected, builder.toQuery(createShardContext()));
            1.5f
        int wordCount = randomInt(4) + 1;
        String json = "{ \"intervals\" : { \"" + TEXT_FIELD_NAME + "\": { " + "\"wildcard\" : { \"pattern\" : \"Te?m\" } } } }";
        String fixed_field_json = "{ \"intervals\" : { \""
            Intervals.notContainedBy(
            + "\"regexp\" : { \"pattern\" : \"te.m\", \"flags\" : \"NONE\" } } } }";
 * The OpenSearch Contributors require contributions made to
        List<IntervalsSourceProvider> subSources = createRandomSourceList(depth, useScripts, count);
import org.opensearch.core.xcontent.XContentBuilder;
            + "           \"intervals\" : ["
        builder = (IntervalQueryBuilder) parseQuery(flags_value_json);
            + "\"fuzzy\" : { \"term\" : \"Term\", \"prefix_length\" : 2, \"fuzziness\" : \"1\" } } } }";
            + "           \"max_gaps\" : 3 },"
            + MASKED_FIELD
            + TEXT_FIELD_NAME
            Intervals.fixField(MASKED_FIELD, buildFuzzySource("term", "Term", 2, true, Fuzziness.ONE.asDistance("term")))
    }
                    30,
    }
            + "           \"max_gaps\" : 30 },"
/*
import java.util.Collections;
            + "   \"query\" : \"term1\","
                    ),
            + "\" } } } }";
            builder1.toQuery(createShardContext());
 * ownership. Elasticsearch licenses this file to you under
            + TEXT_FIELD_NAME
        String regexp_over_max_expand_json = "{ \"intervals\" : { \""
            null,
            + "       \"boost\" : 2 } } }";
            @Override
            builder1.toQuery(createShardContext());
    }
                assertEquals(new Script("interval.start > 3"), script);
        );
            Intervals.maxgaps(40, Intervals.unordered(Intervals.term("hello"), Intervals.term("world")))
        );
        String json = "{ \"intervals\" : { \""
        assertEquals(expected, builder.toQuery(createShardContext()));
import org.opensearch.script.Script;
        expectThrows(IllegalArgumentException.class, () -> {
import org.apache.lucene.util.automaton.RegExp;
            + PREFIXED_FIELD
        IntervalFilterScript.Factory factory = () -> new IntervalFilterScript() {
                mode = IntervalMode.ORDERED;
            + "           \"analyzer\" : \"whitespace\","
            case 2:
            builder.doToQuery(createShardContext());
            + TEXT_FIELD_NAME
import static org.hamcrest.Matchers.equalTo;
        builder = (IntervalQueryBuilder) parseQuery(json);
            IntervalQueryBuilder builder1 = (IntervalQueryBuilder) parseQuery(no_positions_json);
        });
            + "           \"query\" : \"Hello world\","
    public void testRegexp() throws IOException {
            + "               { \"match\" : { \"query\" : \"two\" } } ] } } } }";
        });
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildRegexpSource("te.m", DEFAULT_FLAGS, 500));
            Intervals.containing(
            + "           \"mode\" : \"unordered_no_overlap\","
            + "\": { "
            3
            + "\"regexp\" : { \"pattern\" : \"te.m\", \"use_field\" : \""
            + "       \"match\" : { "
            + "       \"all_of\" : {"
            2
            + (IndexSearcher.getMaxClauseCount() + 1)
 * under the License.
        IntervalQueryBuilder b = new IntervalQueryBuilder("no_such_field", provider);
        String json = "{ \"intervals\" : { \""
            .endObject()
        return new IntervalsSourceProvider.Combine(subSources, mode, maxGaps, filter);
        expected = new IntervalQuery(
        List<IntervalsSourceProvider> subSources = new ArrayList<>();
            + "                       \"analyzer\" : \"keyword\" } } } },"
        json = "{ \"intervals\" : "
        json = "{ \"intervals\" : { \""
            + "\": { "
        final int DEFAULT_FLAGS = RegexpFlag.ALL.value();
public class IntervalQueryBuilderTests extends AbstractQueryTestCase<IntervalQueryBuilder> {
        builder = (IntervalQueryBuilder) parseQuery(regexp_max_expand_json);
            + "\"fuzzy\" : { \"term\" : \"Term\", \"prefix_length\" : 2 } } } }";
            + "                   \"match\" : { "
        builder = (IntervalQueryBuilder) parseQuery(fixed_field_analyzer_json);
        // max expansions use default
            + TEXT_FIELD_NAME
            + "           \"query\" : \"Hello world\","
            + TEXT_FIELD_NAME
    @Override
            IntervalQueryBuilder builder1 = (IntervalQueryBuilder) parseQuery(no_positions_json);
        assertEquals(expected, builder.toQuery(createShardContext()));
        expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.wildcard(new BytesRef("te?m"))); // max expansions use default
                )
        builder = (IntervalQueryBuilder) parseQuery(keyword_json);
        builder = (IntervalQueryBuilder) parseQuery(fix_field_prefix_json);
        expected = new IntervalQuery(PREFIXED_FIELD, Intervals.fixField(PREFIXED_FIELD + "._index_prefix", Intervals.term("term")));
import java.util.List;
package org.opensearch.index.query;
        });
            + "               { \"all_of\" : { "
            + "\": { "
        expected = new BoostQuery(
            + "\": { "
            + TEXT_FIELD_NAME
        assertEquals(expected, builder.toQuery(createShardContext()));
            + NO_POSITIONS_FIELD
        String json = "{ \"intervals\" : { \""
    }
            + "           \"mode\" : \"unordered_no_overlap\","
    }
        );
            + "{ \""
        expected = new IntervalQuery(
        );
            + NO_POSITIONS_FIELD
        expected = new BoostQuery(
                TEXT_FIELD_NAME,
                Intervals.maxgaps(10, Intervals.ordered(Intervals.term("Hello"), Intervals.term("world"))),
            PREFIXED_FIELD,
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);
        String json_with_analyzer = "{ \"intervals\" : { \""
            baseContext.getMapperService(),
            + "\" : { "
    public void testPrefixes() throws IOException {
                break;
        assertEquals(expected, builder.toQuery(createShardContext()));
            + "           \"analyzer\" : \"whitespace\","
            + "           \"max_gaps\" : 10,"
            .endObject()
            ),
/*
            + "       \"match\" : { "
import org.apache.lucene.search.BoostQuery;
            + NO_POSITIONS_FIELD
        assertEquals(expected, builder.toQuery(createShardContext()));
    @Override
        }
            TEXT_FIELD_NAME,
 * this work for additional information regarding copyright
            + RegexpFlag.ANYSTRING.value()
        assertEquals(expected, builder.toQuery(createShardContext()));
        String regexp_max_expand_with_flags_json = "{ \"intervals\" : { \""
        assertEquals(expected, q);
        assertEquals(expected, builder.toQuery(createShardContext()));
            + "\"match\" : { \"query\" : \"term1\" },"
            baseContext.getShardId(),
        expected = new IntervalQuery(
            + "\": { "
            + TEXT_FIELD_NAME
        Query expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.wildcard(new BytesRef("te?m")));
        builder = (IntervalQueryBuilder) parseQuery(flags_json);
    }
        expected = new IntervalQuery(
            + "           \"mode\" : \"ordered\" },"
        } else {
        builder = (IntervalQueryBuilder) parseQuery(keyword_json);
        if (randomBoolean()) {
            + "{ \""
            + "\": { "
        expected = new BoostQuery(
            + "       \"any_of\" : { "
 * Unless required by applicable law or agreed to in writing,
        assertEquals(expected, builder.toQuery(createShardContext()));
                        Intervals.term("three")
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildRegexpSource("te.m", RegexpFlag.ANYSTRING.value(), null));
            BigArrays.NON_RECYCLING_INSTANCE,
        assertEquals(expected, builder.toQuery(createShardContext()));
        String no_positions_fixed_field_json = "{ \"intervals\" : { \""
                Intervals.term("freeze")
            + "\"wildcard\" : { \"pattern\" : \"Te?m\", \"max_expansions\" : "
            + "\": { "
            IntervalQueryBuilder builder = new IntervalQueryBuilder(NO_POSITIONS_FIELD, provider);
            new IntervalQuery(
            builder1.toQuery(createShardContext());
        e = expectThrows(IllegalArgumentException.class, () -> {
            + TEXT_FIELD_NAME
    private static final String NO_POSITIONS_FIELD = "no_positions_field";
            + "\": { "
import static org.hamcrest.Matchers.instanceOf;
            ),
            + "\": { "
            + TEXT_FIELD_NAME
        builder = (IntervalQueryBuilder) parseQuery(prefix_json);
            TEXT_FIELD_NAME,
            Intervals.fixField(MASKED_FIELD, Intervals.maxgaps(10, Intervals.ordered(Intervals.term("Hello"), Intervals.term("world"))))
}
            + "{ \""
        expected = new IntervalQuery(PREFIXED_FIELD, Intervals.fixField(PREFIXED_FIELD + "._index_prefix", Intervals.term("Term")));
            + TEXT_FIELD_NAME
        json = "{ \"intervals\" : { \""
            + "       \"boost\" : 1.5 } } }";
        String json = "{ \"intervals\" : " + "{ \"" + TEXT_FIELD_NAME + "\" : { \"match\" : { \"query\" : \"Hello world\" } } } }";
                Intervals.maxgaps(11, Intervals.unorderedNoOverlaps(Intervals.term("hello"), Intervals.term("world")))
            + "\": { "
/*
            + TEXT_FIELD_NAME
    public void testMultipleProviders() {
        assertEquals(expected, builder.toQuery(createShardContext()));
        );
        );
            + "           \"query\" : \"Hello world\","
            + TEXT_FIELD_NAME
import org.opensearch.common.settings.Settings;
        String json = "{ \"intervals\" : { \"" + TEXT_FIELD_NAME + "\": { " + "\"prefix\" : { \"prefix\" : \"term\" } } } }";
                mode = IntervalMode.UNORDERED_NO_OVERLAP;
            case 1:
import org.opensearch.test.AbstractQueryTestCase;
    public void testWildcard() throws IOException {
            + TEXT_FIELD_NAME
        };
    }
            new IntervalQuery(
            + "           \"filter\" : { "
            + "\": { "
        CompiledAutomaton automaton = new CompiledAutomaton(regexp.toAutomaton());
        String json_with_fuzziness = "{ \"intervals\" : { \""
        if (randomBoolean()) {
        String regexp_neg_max_expand_json = "{ \"intervals\" : { \""
            + "           \"filter\" : {"
import org.apache.lucene.util.automaton.CompiledAutomaton;
            + "           \"query\" : \"Hello world\","
        IntervalsSourceProvider source = new IntervalsSourceProvider.Match("text", 0, IntervalMode.ORDERED, "simple", scriptFilter, null);
        json = "{ \"intervals\" : "
 * SPDX-License-Identifier: Apache-2.0
        });
        json = "{ \"intervals\" : { \""
            e.getMessage(),
            new IntervalsSourceProvider.ScriptFilterSource(Intervals.term("term1"), "interval.start > 3", null)
        );
            + "\"prefix\" : { \"prefix\" : \"term\" } } } }";
            default:
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);
        builder = (IntervalQueryBuilder) parseQuery(regexp_max_expand_with_flags_json);
            + "           \"mode\" : \"unordered_no_overlap\" },"
        builder = (IntervalQueryBuilder) parseQuery(regexp_neg_max_expand_json);
                mMode = IntervalMode.ORDERED;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            case 3:
            + "           \"query\" : \"Hello Open Search\","
        assertEquals(expected, builder.toQuery(createShardContext()));
            + "\"wildcard\" : { \"pattern\" : \"Te?m\", \"max_expansions\" : 500 } } } }";
        assertThat(e.getMessage(), equalTo("Only one interval rule can be specified, found [match] and [all_of]"));
            + TEXT_FIELD_NAME
            + "       \"all_of\" : {"
            + "           \"intervals\" : ["
    static List<IntervalsSourceProvider> createRandomSourceList(int depth, boolean useScripts, int count) {
        if (useScripts == false || randomBoolean()) {
        return Intervals.multiterm(fq.getAutomata(), label);
                TEXT_FIELD_NAME,
            + "{ \""
                break;
            .field("type", "text")
            + " } } } }";
        assertEquals(expected, builder.toQuery(createShardContext()));
            + "               { \"match\" : { \"query\" : \"three\" } } ],"
            + "                       { \"match\" : { \"query\" : \"three\" } } ] } } ],"
            + "                   \"match\" : { \"query\" : \"blah\" } } } } } } }";
    }
            IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);
        expected = new IntervalQuery(
            }
        assertEquals(expected, builder.toQuery(createShardContext()));
        String wildcard_over_max_expand_json = "{ \"intervals\" : { \""
            + "           \"intervals\" : ["
        XContentBuilder mapping = jsonBuilder().startObject()
        assertEquals(expected, builder.toQuery(createShardContext()));
            + TEXT_FIELD_NAME
            () -> true,
        String text = String.join(" ", words);
 * the Apache License, Version 2.0 (the "License"); you may
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor
            + TEXT_FIELD_NAME
            + TEXT_FIELD_NAME
            + "\": {"
            + "\": { "
            + "\"fuzzy\" : { \"term\" : \"Term\", \"prefix_length\" : 2, \"analyzer\" : \"keyword\" } } } }";
 * specific language governing permissions and limitations
        if (depth < 3 && randomInt(20) > 18) {
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildRegexpSource("te.m", DEFAULT_FLAGS, null));
            case 2:
            + TEXT_FIELD_NAME
    static IntervalsSourceProvider.Match createRandomMatch(int depth, boolean useScripts) {
                break;
        builder = (IntervalQueryBuilder) parseQuery(json);
                )
        assertTrue("query should be cacheable: " + queryBuilder.toString(), context.isCacheable());
        ScriptService scriptService = new ScriptService(Settings.EMPTY, Collections.emptyMap(), Collections.emptyMap()) {
        QueryShardContext context = createShardContext();
        expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.wildcard(new BytesRef("te?m"), 500));
            IntervalQueryBuilder builder1 = (IntervalQueryBuilder) parseQuery(fixed_field_json_no_positions);
 * license agreements. See the NOTICE file distributed with
            + "       \"match\" : { "
            2
            + "{ \""
        return subSources;
            Intervals.fixField(PREFIXED_FIELD, Intervals.fixField(PREFIXED_FIELD + "._index_prefix", Intervals.term("term")))
            + "\": { "
            + "           \"query\" : \"Hello world\","
    }
            Intervals.fixField(PREFIXED_FIELD, Intervals.fixField(PREFIXED_FIELD + "._index_prefix", Intervals.term("Term")))
        assertEquals(expected, builder.toQuery(createShardContext()));
        assertNotNull(rewriteQuery.toQuery(context));
        expected = new IntervalQuery(
    }
                TEXT_FIELD_NAME,
    }
        builder = (IntervalQueryBuilder) parseQuery(wildcard_max_expand_json);
        json = "{ \"intervals\" : "
        }
        builder = (IntervalQueryBuilder) parseQuery(json);
        QueryShardContext baseContext = createShardContext();
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildRegexpSource("TE.M", DEFAULT_FLAGS, RegExp.ASCII_CASE_INSENSITIVE, null));
        builder = (IntervalQueryBuilder) parseQuery(keyword_fix_field_json);
            IntervalQueryBuilder builder = new IntervalQueryBuilder(INT_FIELD_NAME, provider);
                    Intervals.unorderedNoOverlaps(
            default:
        builder = (IntervalQueryBuilder) parseQuery(regexp_case_insensitive_json);
            + "               { \"match\" : { \"query\" : \"two\" } },"
        expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.fixField(MASKED_FIELD, Intervals.wildcard(new BytesRef("te?m"))));
        builder = (IntervalQueryBuilder) parseQuery(short_prefix_json);
            + "\" : { "
 */
        );
        if (depth > 2) {
            + TEXT_FIELD_NAME
            return createRandomMatch(depth + 1, useScripts);
        expectThrows(IllegalArgumentException.class, () -> {
    protected IntervalQueryBuilder doCreateTestQueryBuilder() {
            + "       \"match\" : { "
            + "               { \"match\" : { \"query\" : \"atmosphere\" } },"
                    Intervals.unorderedNoOverlaps(
            .endObject()
            + "\"regexp\" : { \"pattern\" : \"[Tt]erm\" } } } }";
            + "\"prefix\" : { \"prefix\" : \"term\", \"use_field\" : \""
        assertEquals(expected, builder.toQuery(createShardContext()));
        }
                    Intervals.maxgaps(
            return new IntervalsSourceProvider.IntervalFilter(createRandomSource(depth + 1, false), randomFrom(filters));
            + "           \"mode\" : \"ordered\","
import org.apache.lucene.queries.intervals.IntervalQuery;
            + "\": { "
            + "\" } } } }";
            + "       \"script\" : { "
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildFuzzySource("term", "Term", 2, true, Fuzziness.ONE.asDistance("term")));
                mMode = IntervalMode.UNORDERED_NO_OVERLAP;
            + NO_POSITIONS_FIELD
            case 1:
        QueryBuilder rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
        String flags_json = "{ \"intervals\" : { \""
            + "       \"match\" : { "
        assertEquals(expected, builder.toQuery(createShardContext()));
            + "       \"all_of\" : {"
                Intervals.maxgaps(
            equalTo("Can only use interval queries on text fields - not on [" + INT_FIELD_NAME + "] which is of type [integer]")
            + "\" } } } }";
            new IntervalQuery(TEXT_FIELD_NAME, Intervals.unorderedNoOverlaps(Intervals.term("hello"), Intervals.term("world"))),
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);
        IntervalMode mMode;
        int orCount = randomInt(4) + 1;
            + NO_POSITIONS_FIELD
            + NO_POSITIONS_FIELD
                mode = IntervalMode.UNORDERED;
    }
        assertEquals(expected, builder.toQuery(createShardContext()));
        String useField = rarely() ? MASKED_FIELD : null;
            + TEXT_FIELD_NAME
            + "\": { "
            + "           \"max_gaps\" : 11 },"
            + TEXT_FIELD_NAME
        assertEquals(expected, builder.toQuery(createShardContext()));
 * software distributed under the License is distributed on an
                return createRandomDisjunction(depth, useScripts);
        Query expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.prefix(new BytesRef("term")));
            + "{ \""
            + "\": { "
            Intervals.or(Intervals.fixField(PREFIXED_FIELD + "._index_prefix", Intervals.wildcard(new BytesRef("t?"))), Intervals.term("t"))
    public void testCacheability() throws IOException {
            + TEXT_FIELD_NAME
                    )
            null,
    static IntervalsSourceProvider.IntervalFilter createRandomNonNullFilter(int depth, boolean useScripts) {
        Query expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.or(Intervals.term("one"), Intervals.term("two")));
            + "               { \"match\" : { \"query\" : \"two\" } } ],"
            + "           \"analyzer\" : \"whitespace\","
            + "                   \"match\" : { \"query\" : \"freeze\" } } } } } } }";
        }
            + "\": { "
        String json = "{ \"intervals\" : "
            subSources.add(createRandomSource(depth + 1, useScripts));
        assertEquals(expected, builder.toQuery(createShardContext()));
        Query expected = new IntervalQuery(
            + "               { \"match\" : { \"query\" : \"one\" } },"
        return buildRegexpSource(pattern, flags, 0, maxExpansions);
        String json = "{ \"intervals\" : { \"" + TEXT_FIELD_NAME + "\": { " + "\"fuzzy\" : { \"term\" : \"Term\" } } } }";
        assertThat(
            + "{ \""
            + "\": { "
            TEXT_FIELD_NAME,
    static IntervalsSourceProvider.Disjunction createRandomDisjunction(int depth, boolean useScripts) {
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildRegexpSource("te.m", RegexpFlag.NONE.value(), null));
            + TEXT_FIELD_NAME
            builder.doToQuery(createShardContext());
import org.opensearch.script.ScriptType;
        Query expected = new IntervalQuery(
        IntervalsSourceProvider.IntervalFilter filter = createRandomFilter(depth + 1, useScripts);
    }
            + "           \"mode\" : \"unordered_no_overlap\","
        builder = (IntervalQueryBuilder) parseQuery(json_with_prefix);
                    )
        assertEquals(expected, builder.toQuery(createShardContext()));
                        Intervals.maxgaps(3, Intervals.unorderedNoOverlaps(Intervals.term("one"), Intervals.term("two"))),
            + TEXT_FIELD_NAME
    }
            + "       \"all_of\" : {"
        builder = (IntervalQueryBuilder) parseQuery(json_with_fixfield);
            @Override
            + "\": { "
            + "\": { "
            public boolean execute(Interval interval) {
        json = "{ \"intervals\" : "
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);
        expectThrows(IllegalArgumentException.class, () -> {
            1.5f
                throw new AssertionError("Illegal randomisation branch");
        Query q = builder.toQuery(context);
        expected = new IntervalQuery(
            + (IndexSearcher.getMaxClauseCount() + 1)
        assertEquals(expected, builder.toQuery(createShardContext()));
                        Intervals.maxgaps(12, Intervals.unorderedNoOverlaps(Intervals.term("hello"), Intervals.term("open"))),
            null,
        });
import org.apache.lucene.search.FuzzyQuery;
        );
import org.opensearch.script.ScriptService;
            + "\"wildcard\" : { \"pattern\" : \"Te?m\", \"use_field\" : \""
            + "           \"use_field\" : \""
        assertEquals(expected, builder.toQuery(createShardContext()));
            Intervals.maxgaps(10, Intervals.ordered(Intervals.term("Hello"), Intervals.term("world")))
        });
        builder = (IntervalQueryBuilder) parseQuery(json);
            + TEXT_FIELD_NAME
 *
        );
        String no_positions_json = "{ \"intervals\" : { \""
                throw new AssertionError("Illegal randomisation branch");
        String analyzer = randomFrom("simple", "keyword", "whitespace");
            new IntervalQuery(TEXT_FIELD_NAME, Intervals.ordered(Intervals.term("hello"), Intervals.term("world"))),
            + PREFIXED_FIELD
        FuzzyQuery fq = new FuzzyQuery(new Term("field", term), editDistance, prefixLength, 128, transpositions);
            + TEXT_FIELD_NAME
                )
        if (maxExpansions != null) {
            + "           \"intervals\" : ["
            + "           \"intervals\" : ["
import org.opensearch.core.common.ParsingException;
    }
            + "\": { "
 * compatible open source license.
            + "           \"max_gaps\": 12 },"
            + TEXT_FIELD_NAME
            + "                       \"query\" : \"SENTENCE\","
import org.opensearch.index.mapper.MapperService;
        String json = "{ \"intervals\" : "
        for (int i = 0; i < wordCount; i++) {
        "not_containing",
            + "           \"query\" : \"Hello world\","
        builder = (IntervalQueryBuilder) parseQuery(json);
            .endObject()
            + "           \"query\" : \"Hello world\","
            buildFuzzySource("term", "Term", FuzzyQueryBuilder.DEFAULT_PREFIX_LENGTH, true, Fuzziness.AUTO.asDistance("term"))
        json = "{ \"intervals\" : "
        assertEquals(expected, builder.toQuery(createShardContext()));
        }
            + "            \"source\" : \"interval.start > 3\" } } } } } }";
    public void testFuzzy() throws IOException {
            .endObject();
        assertThat(e.getMessage(), equalTo("Cannot create intervals over field [" + NO_POSITIONS_FIELD + "] with no positions indexed"));
        assertFalse("query with scripts should not be cacheable: " + queryBuilder.toString(), context.isCacheable());
        builder = (IntervalQueryBuilder) parseQuery(json);
        );
            .startObject(NO_POSITIONS_FIELD)
            builder1.toQuery(createShardContext());
            + "\" : { "
        expectThrows(IllegalArgumentException.class, () -> {
        String json_with_fixfield = "{ \"intervals\" : { \""
            + "\": { "
        assertEquals(expected, builder.toQuery(createShardContext()));
            TEXT_FIELD_NAME,
import org.opensearch.common.compress.CompressedXContent;
            new IntervalQuery(
        expected = new BoostQuery(
        String keyword_fix_field_json = "{ \"intervals\" : { \""
            + "               { \"match\" : { \"query\" : \"one\" } },"
            + "       \"boost\" : 3 } } }";
        builder = (IntervalQueryBuilder) parseQuery(fixed_field_json);
    private static IntervalsSource buildRegexpSource(String pattern, int flags, int matchFlags, Integer maxExpansions) {
            null,
        json = "{ \"intervals\" : "
            .startObject("index_prefixes")
        assertEquals(expected, builder.toQuery(createShardContext()));
        assertEquals(expected, builder.toQuery(createShardContext()));
            default:
        builder = (IntervalQueryBuilder) parseQuery(json);
            2
            + "       \"boost\" : 3.5 } } }";
            + TEXT_FIELD_NAME
            IntervalQueryBuilder builder1 = (IntervalQueryBuilder) parseQuery(no_positions_json);
                    Intervals.term("SENTENCE")
            + TEXT_FIELD_NAME
    static IntervalsSourceProvider.Combine createRandomCombine(int depth, boolean useScripts) {
                TEXT_FIELD_NAME,
            + "\": { "
            TEXT_FIELD_NAME,
        });
        );
                )
            + "\": { "
            + "       \"match\" : { "
        builder = (IntervalQueryBuilder) parseQuery(json_no_transpositions);
                return interval.getStart() > 3;
    public void testScriptFilter() throws IOException {
            + "\"wildcard\" : { \"pattern\" : \"Te?m\", \"max_expansions\" : -20 } } } }";
            + TEXT_FIELD_NAME
        );
        "not_overlapping",
        String flags_value_json = "{ \"intervals\" : { \""
        });
        );
        String json_with_prefix = "{ \"intervals\" : { \""
            case 0:
            + "\"match\" : { "
import java.io.IOException;
            + "           \"max_gaps\" : 40 } } } }";
            + "               \"not_contained_by\" : { "
            + "\" : { "
            .startObject("_doc")
    public void testNonIndexedFields() throws IOException {
            + "           \"query\" : \"Hello world\","
            + "           \"mode\" : \"ordered\","
    @Override
    }
        builder = (IntervalQueryBuilder) parseQuery(json);
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);
            words.add(randomRealisticUnicodeOfLengthBetween(4, 20));
        );
        }
        rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
    protected void doAssertLuceneQuery(IntervalQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
            + "\" : { "
            + "\"use_field\" : \""
            + "       \"match\" : { "
        assertEquals(expected, builder.toQuery(createShardContext()));
            + "                       { \"match\" : { \"query\" : \"two\" } },"
        String wildcard_neg_max_expand_json = "{ \"intervals\" : { \""
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);
        return new IntervalQueryBuilder(TEXT_FIELD_NAME, createRandomSource(0, true));
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildFuzzySource("Term", "Term", 2, true, Fuzziness.AUTO.asDistance("term")));
            + "\"boost\" : 1,"
 */
        assertEquals(expected, builder.toQuery(createShardContext()));
            + "           \"query\" : \"Hello Open Search\","
            @SuppressWarnings("unchecked")
import org.apache.lucene.index.Term;
    private static IntervalsSource buildRegexpSource(String pattern, int flags, Integer maxExpansions) {
            + "       \"boost\" : 2 } } }";
            IntervalQueryBuilder builder1 = (IntervalQueryBuilder) parseQuery(no_positions_fixed_field_json);
        json = "{ \"intervals\" : "
            ),
                return createRandomCombine(depth, useScripts);
            TEXT_FIELD_NAME,
        assertEquals(expected, builder.toQuery(createShardContext()));
                Intervals.maxgaps(
            scriptService,
        mapperService.merge("_doc", new CompressedXContent(mapping.toString()), MapperService.MergeReason.MAPPING_UPDATE);
            + "{ \""
        assertEquals(expected, builder.toQuery(createShardContext()));
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);
        assertEquals(expected, builder.toQuery(createShardContext()));
import org.apache.lucene.search.IndexSearcher;
            + "           \"max_gaps\" : 10,"
                TEXT_FIELD_NAME,
            return new IntervalQueryBuilder(KEYWORD_FIELD_NAME, instance.getSourceProvider());
        });
            + "\"fuzzy\" : { \"term\" : \"Term\", \"prefix_length\" : 2, \"fuzziness\" : \"1\", "
            null,
            case 0:
        String fix_field_prefix_json = "{ \"intervals\" : { \""
            + TEXT_FIELD_NAME
        String fixed_field_json_no_positions = "{ \"intervals\" : { \""
            + "       \"boost\" : 3 } } }";
            + "\": { "
        IntervalQuery expected = new IntervalQuery(
        expectThrows(IllegalArgumentException.class, () -> {
            ),
            + "\"wildcard\" : { \"pattern\" : \"Te?m\", \"use_field\" : \"masked_field\", \"analyzer\" : \"keyword\" } } } }";
        // This looks weird, but it's fine, because the innermost fixField wins
            TEXT_FIELD_NAME,
            + "\" : { "
            + TEXT_FIELD_NAME
            + "\": { "
    private static IntervalsSourceProvider createRandomSource(int depth, boolean useScripts) {
            + TEXT_FIELD_NAME
        expected = new IntervalQuery(
import org.apache.lucene.util.BytesRef;
        expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.wildcard(new BytesRef("Te?m")));
        ParsingException e = expectThrows(ParsingException.class, () -> { parseQuery(json); });
        expected = new BoostQuery(
            + "   \"filter\" : { "
        String wildcard_max_expand_json = "{ \"intervals\" : { \""
        }
            new IntervalQuery(
                Intervals.containedBy(
    private static IntervalsSource buildFuzzySource(String term, String label, int prefixLength, boolean transpositions, int editDistance) {
            + "               \"not_containing\" : { \"match\" : { \"query\" : \"three\" } } } } } } }";
            + "\"regexp\" : { \"pattern\" : \"te.m\", \"max_expansions\" : "
            TEXT_FIELD_NAME,
    }
    private static final String PREFIXED_FIELD = "prefixed_field";
            + TEXT_FIELD_NAME

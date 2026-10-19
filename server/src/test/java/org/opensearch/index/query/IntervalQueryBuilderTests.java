                break;
            + "\": { "  
            TEXT_FIELD_NAME,
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildFuzzySource("term", "Term", 2, true, Fuzziness.ONE.asDistance("term")));  
    }
        builder = (IntervalQueryBuilder) parseQuery(json);
        String regexp_case_insensitive_json = "{ \"intervals\" : { \""  
        builder = (IntervalQueryBuilder) parseQuery(wildcard_neg_max_expand_json);
 *
            null,  
            + "           \"intervals\" : ["
    public void testScriptFilter() throws IOException {
            IntervalQueryBuilder builder1 = (IntervalQueryBuilder) parseQuery(no_positions_json);
    public void testOrInterval() throws IOException {  
        QueryShardContext baseContext = createShardContext();
            + TEXT_FIELD_NAME
        String json_with_prefix = "{ \"intervals\" : { \""
        for (int i = 0; i < count; i++) {
        );
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);
import static org.hamcrest.Matchers.equalTo;
        return null;
        assertEquals(expected, builder.toQuery(createShardContext()));
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildFuzzySource("term", "Term", 2, false, Fuzziness.AUTO.asDistance("term")));
            + "\": { "
            + "       \"all_of\" : {"  
            + "\" : { "  
            + TEXT_FIELD_NAME
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildRegexpSource("te.m", RegexpFlag.NONE.value(), null));
            + "                       { \"match\" : { \"query\" : \"two\" } },"  
            + NO_POSITIONS_FIELD
            + TEXT_FIELD_NAME  
            .endObject()
            + "           \"max_gaps\" : 40 } } } }";
 * the Apache License, Version 2.0 (the "License"); you may
            + PREFIXED_FIELD  
        }
        assertEquals(expected, builder.toQuery(createShardContext()));
            case 1:
        assertEquals(expected, builder.toQuery(createShardContext()));  
                return interval.getStart() > 3;  
            + "       \"match\" : { "
        String fixed_field_json_no_positions = "{ \"intervals\" : { \""
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildRegexpSource("te.m", RegexpFlag.NONE.value(), 500));  
            + "       \"boost\" : 2 } } }";
                    3,
            IntervalQueryBuilder builder1 = (IntervalQueryBuilder) parseQuery(fixed_field_json_no_positions);  
            + "           \"query\" : \"Hello world\","  
        String wildcard_max_expand_json = "{ \"intervals\" : { \""  
 */  
            + RegexpFlag.ANYSTRING.value()
            return Intervals.multiterm(automaton, maxExpansions, regexp.toString());  
        assertThat(e.getMessage(), equalTo("Cannot create intervals over field [" + NO_POSITIONS_FIELD + "] with no positions indexed"));
        builder = (IntervalQueryBuilder) parseQuery(json);
        List<IntervalsSourceProvider> orSources = createRandomSourceList(depth, useScripts, orCount);
            default:
            new IntervalQuery(
    static List<IntervalsSourceProvider> createRandomSourceList(int depth, boolean useScripts, int count) {
            + TEXT_FIELD_NAME
            IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);
 * GitHub history for details.
        builder = (IntervalQueryBuilder) parseQuery(keyword_fix_field_json);  
            + "               { \"match\" : { \"query\" : \"atmosphere\" } },"  
    public void testCombineInterval() throws IOException {  
            + "\" } } } }";  
        }
            + "                   \"match\" : { "
            + "\": { "
    public void testMultipleProviders() {
            new IntervalQuery(TEXT_FIELD_NAME, Intervals.unorderedNoOverlaps(Intervals.term("hello"), Intervals.term("world"))),
 * You may obtain a copy of the License at  
    private static IntervalsSource buildRegexpSource(String pattern, int flags, int matchFlags, Integer maxExpansions) {
            + "           \"max_gaps\" : 10,"
import org.apache.lucene.search.IndexSearcher;
    private static IntervalsSourceProvider.IntervalFilter createRandomFilter(int depth, boolean useScripts) {
    @Override  
            + "\"wildcard\" : { \"pattern\" : \"Te?m\", \"analyzer\" : \"keyword\" } } } }";
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);  
            + TEXT_FIELD_NAME
        expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.wildcard(new BytesRef("te?m"))); // max expansions use default  
            + "       \"match\" : { "  
        IntervalQuery expected = new IntervalQuery(
                mode = IntervalMode.UNORDERED_NO_OVERLAP;  
        return new IntervalsSourceProvider.Match(text, maxMGaps, mMode, analyzer, createRandomFilter(depth + 1, useScripts), useField);  
            + "\": { "
            + "\" } } } }";  
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);
            + "               { \"match\" : { \"query\" : \"one\" } },"
 * KIND, either express or implied.  See the License for the
        "not_overlapping",  
            + "                       { \"match\" : { \"query\" : \"outside\" } } ] } } ],"
import org.apache.lucene.search.FuzzyQuery;  
import org.opensearch.core.common.ParsingException;
import org.opensearch.index.mapper.MapperService;
            ),
        IntervalsSourceProvider.IntervalFilter scriptFilter = new IntervalsSourceProvider.IntervalFilter(
        expected = new IntervalQuery(
            + "\": { "
        assertEquals(expected, builder.toQuery(createShardContext()));  
            + NO_POSITIONS_FIELD  
        json = "{ \"intervals\" : { \""  
            + "           \"mode\" : \"unordered_no_overlap\","  
        String json = "{ \"intervals\" : { \"" + TEXT_FIELD_NAME + "\": { " + "\"wildcard\" : { \"pattern\" : \"Te?m\" } } } }";
        expectThrows(IllegalArgumentException.class, () -> {
        );
            + "                   \"mode\" : \"unordered\","
            TEXT_FIELD_NAME,  
            + "               \"containing\" : {"
            builder.doToQuery(createShardContext());
            () -> true,
/*  
        for (int i = 0; i < wordCount; i++) {
    public void testPrefixes() throws IOException {
        expected = new IntervalQuery(  
 *
        builder = (IntervalQueryBuilder) parseQuery(flags_json);  
            + "\": { "
import org.opensearch.common.settings.Settings;
            + TEXT_FIELD_NAME
            builder1.toQuery(createShardContext());
            + PREFIXED_FIELD
        assertEquals(expected, builder.toQuery(createShardContext()));
                break;  
        expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.fixField(MASKED_FIELD, Intervals.wildcard(new BytesRef("Te?m"))));  
        builder = (IntervalQueryBuilder) parseQuery(json);  
            + "           \"mode\" : \"unordered_no_overlap\" },"
            + "\" : { "
        switch (randomIntBetween(0, 2)) {  
            + TEXT_FIELD_NAME
                    ),
            + "\" : { "
    }
        );
            + "\"wildcard\" : { \"pattern\" : \"Te?m\", \"max_expansions\" : -20 } } } }";  
            .startObject("index_prefixes")
        String json = "{ \"intervals\" : { \""
            Intervals.fixField(PREFIXED_FIELD, Intervals.fixField(PREFIXED_FIELD + "._index_prefix", Intervals.term("Term")))  
            TEXT_FIELD_NAME,  
            + "       \"match\" : { "  
        assertNotNull(rewriteQuery.toQuery(context));
            @Override
        "contained_by",
            1.5f
            + "\"prefix\" : { \"prefix\" : \"Term\", \"analyzer\" : \"keyword\" } } } }";
        });  
        return Intervals.multiterm(fq.getAutomata(), label);  
        assertEquals(expected, builder.toQuery(createShardContext()));
                mode = IntervalMode.UNORDERED;  
            + MASKED_FIELD  
            builder1.toQuery(createShardContext());
                TEXT_FIELD_NAME,
 * not use this file except in compliance with the License.
        ParsingException e = expectThrows(ParsingException.class, () -> { parseQuery(json); });  
            IntervalQueryBuilder builder1 = (IntervalQueryBuilder) parseQuery(wildcard_over_max_expand_json);
            TEXT_FIELD_NAME,
                assertEquals(new Script("interval.start > 3"), script);  
            + "           \"intervals\" : ["
            words.add(randomRealisticUnicodeOfLengthBetween(4, 20));
/*  
        }
        json = "{ \"intervals\" : { \""
            + TEXT_FIELD_NAME
        String json = "{ \"intervals\" : "
                    Intervals.term("search")
    protected IntervalQueryBuilder doCreateTestQueryBuilder() {
            IntervalQueryBuilder builder = new IntervalQueryBuilder(NO_POSITIONS_FIELD, provider);  
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);
            case 0:
            )
            + "       \"boost\" : 2 } } }";
        builder = (IntervalQueryBuilder) parseQuery(json_with_fixfield);
            + "           \"mode\" : \"ordered\" } } } }";  
            + "\" : { "
            .field("index_options", "freqs")  
                return createRandomMatch(depth + 1, useScripts);
                Intervals.maxgaps(  
        CompiledAutomaton automaton = new CompiledAutomaton(regexp.toAutomaton());  
            + (IndexSearcher.getMaxClauseCount() + 1)
            + TEXT_FIELD_NAME
    }  
            + PREFIXED_FIELD
        expected = new IntervalQuery(
            + "           \"max_gaps\" : 10,"  
            + "           \"filter\" : {"  
        String json = "{ \"intervals\" : { \""
    @Override
            + "               \"not_containing\" : { \"match\" : { \"query\" : \"three\" } } } } } } }";  
        });
            3
        expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.fixField(MASKED_FIELD, buildRegexpSource("te.m", DEFAULT_FLAGS, null)));
            + TEXT_FIELD_NAME
            + "\": { "
                throw new AssertionError("Illegal randomisation branch");  
        String json_with_fuzziness = "{ \"intervals\" : { \""
            + "\": {"  
            + "           \"mode\" : \"unordered_no_overlap\" },"
            return new IntervalsSourceProvider.IntervalFilter(createRandomSource(depth + 1, false), randomFrom(filters));
    }
            + "\": { "  
            + "           \"mode\" : \"ordered\" } } } }";
        assertEquals(expected, builder.toQuery(createShardContext()));  
            + "\","  
        IntervalQueryBuilder queryBuilder = new IntervalQueryBuilder(TEXT_FIELD_NAME, createRandomSource(0, false));
            + "           \"max_gaps\" : 11 },"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                Intervals.containedBy(
            + "           \"mode\" : \"ordered\" } } } }";
            + "\"wildcard\" : { \"pattern\" : \"Te?m\", \"use_field\" : \"masked_field\", \"analyzer\" : \"keyword\" } } } }";  
            + "               { \"any_of\" : {"
    }
        );  
        Query expected = new IntervalQuery(
        builder = (IntervalQueryBuilder) parseQuery(json);
        builder = (IntervalQueryBuilder) parseQuery(keyword_json);
            + TEXT_FIELD_NAME
            + "\": { "
        return new IntervalsSourceProvider.IntervalFilter(new Script(ScriptType.INLINE, "mockscript", "1", Collections.emptyMap()));  
import org.apache.lucene.index.Term;
            + "\"regexp\" : { \"pattern\" : \"te.m\", \"use_field\" : \""
        List<IntervalsSourceProvider> subSources = new ArrayList<>();  
        return new IntervalsSourceProvider.Disjunction(orSources, createRandomFilter(depth + 1, useScripts));  
        IntervalsSourceProvider.IntervalFilter filter = createRandomFilter(depth + 1, useScripts);
            + " } } } }";  
        return subSources;
        builder = (IntervalQueryBuilder) parseQuery(json);
    private static final String PREFIXED_FIELD = "prefixed_field";  
        QueryBuilder rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);  
                        30,  
            + "       \"match\" : { "
            .endObject()  
        assertEquals(expected, builder.toQuery(createShardContext()));  
            + "\": { "
            + TEXT_FIELD_NAME  
        expectThrows(IllegalArgumentException.class, () -> {
        List<String> words = new ArrayList<>();  
                break;
        // max expansions use default  
            TEXT_FIELD_NAME,
        json = "{ \"intervals\" : { \""
        builder = (IntervalQueryBuilder) parseQuery(regexp_case_insensitive_json);
            .startObject("properties")  
        expected = new IntervalQuery(
            Intervals.maxgaps(10, Intervals.ordered(Intervals.term("Hello"), Intervals.term("world")))  
        String useField = rarely() ? MASKED_FIELD : null;
        );  
import org.opensearch.core.xcontent.XContentBuilder;  
            + "   \"query\" : \"term1\","  
                    Intervals.unorderedNoOverlaps(Intervals.term("hello"), Intervals.term("open")),
/*
            @Override
        String no_positions_json = "{ \"intervals\" : { \""
 * Modifications Copyright OpenSearch Contributors. See
            BigArrays.NON_RECYCLING_INSTANCE,  
            + "\": { "
            + TEXT_FIELD_NAME  
        expectThrows(IllegalArgumentException.class, () -> {  
            + "                   \"match\" : { \"query\" : \"blah\" } } } } } } }";
                Intervals.maxgaps(11, Intervals.unorderedNoOverlaps(Intervals.term("hello"), Intervals.term("world")))
            + TEXT_FIELD_NAME
            + TEXT_FIELD_NAME  
            }
            + "\"boost\" : 1,"
            + TEXT_FIELD_NAME  
                        Intervals.term("search")  
            + "           \"max_gaps\" : 10,"
        assertEquals(expected, builder.toQuery(createShardContext()));
    }
            return createRandomNonNullFilter(depth, useScripts);  
            Intervals.or(Intervals.fixField(PREFIXED_FIELD + "._index_prefix", Intervals.wildcard(new BytesRef("t?"))), Intervals.term("t"))
        int maxGaps = randomInt(5) - 1;  
 * under the License.  
        expected = new BoostQuery(
        );
            + "\": { "
            TEXT_FIELD_NAME,  
        );
            + "           \"max_gaps\" : 30,"
        assertEquals(expected, builder.toQuery(createShardContext()));
        IntervalsSourceProvider provider = new IntervalsSourceProvider.Match("test", 0, IntervalMode.ORDERED, null, null, null);
        expectThrows(IllegalArgumentException.class, () -> {
        expectThrows(IllegalArgumentException.class, () -> {
            + "\"regexp\" : { \"pattern\" : \"te.m\", \"max_expansions\" : 500 } } } }";  
            new IntervalQuery(
            + "           \"analyzer\" : \"whitespace\","  
            + "\": { "
        }  
            + NO_POSITIONS_FIELD  
        }  
            new Script(ScriptType.INLINE, "mockscript", "1", Collections.emptyMap())  
public class IntervalQueryBuilderTests extends AbstractQueryTestCase<IntervalQueryBuilder> {
            Intervals.notContainedBy(
        expected = new BoostQuery(
import org.apache.lucene.search.Query;  
        builder = (IntervalQueryBuilder) parseQuery(json);
            + "\"fuzzy\" : { \"term\" : \"Term\", \"prefix_length\" : 2 } } } }";
        });
import org.apache.lucene.util.automaton.CompiledAutomaton;
            case 2:
import org.apache.lucene.search.MatchNoDocsQuery;
            + "\" : { "
        assertEquals(expected, builder.toQuery(createShardContext()));
            + "\"regexp\" : { \"pattern\" : \"te.m\", \"flags_value\" : \""
            + "\"regexp\" : { \"pattern\" : \"te.m\", \"flags\": \"NONE\", \"max_expansions\" : 500 } } } }";  
            builder1.toQuery(createShardContext());  
        String keyword_json = "{ \"intervals\" : { \""
            .endObject()
            PREFIXED_FIELD,  
        expected = new BoostQuery(
    }  
            + "\"fuzzy\" : { \"term\" : \"Term\", \"prefix_length\" : 2, \"fuzziness\" : \"1\" } } } }";
            new IntervalQuery(  
                    )
        String wildcard_neg_max_expand_json = "{ \"intervals\" : { \""  
    static IntervalsSourceProvider.Match createRandomMatch(int depth, boolean useScripts) {  
        );
    }
            case 3:
        String json = "{ \"intervals\" : { \""
        });
        );  
            + "           \"mode\" : \"ordered\","  
            .field("type", "text")  
            + "\": { "  
        String no_positions_fixed_field_json = "{ \"intervals\" : { \""
        String json_no_transpositions = "{ \"intervals\" : { \""  
            builder1.toQuery(createShardContext());
 */
            + "{ \""
        expectThrows(IllegalArgumentException.class, () -> {  
            + "       \"all_of\" : {"  
        String json = "{ \"intervals\" : { \"" + TEXT_FIELD_NAME + "\": { " + "\"fuzzy\" : { \"term\" : \"Term\" } } } }";
            + "\": { "
            + TEXT_FIELD_NAME
        expectThrows(IllegalArgumentException.class, () -> {  
        "after" };
            null,
            + "\": { "
            + TEXT_FIELD_NAME
            + MASKED_FIELD
            + "       \"match\" : { "  
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildRegexpSource("te.m", DEFAULT_FLAGS, 500));  
            + "{ \""  
        );
        assertEquals(expected, builder.toQuery(createShardContext()));
            new IntervalsSourceProvider.ScriptFilterSource(Intervals.term("term1"), "interval.start > 3", null)
    private static final String MASKED_FIELD = "masked_field";
        );  
    public void testMatchInterval() throws IOException {
            }
        builder = (IntervalQueryBuilder) parseQuery(keyword_json);  
        if (maxExpansions != null) {
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(expected, builder.toQuery(createShardContext()));
                return createRandomCombine(depth, useScripts);  
        builder = (IntervalQueryBuilder) parseQuery(fixed_field_analyzer_json);
        });
    }
        String no_positions_json = "{ \"intervals\" : { \""
            + (IndexSearcher.getMaxClauseCount() + 1)
import java.util.ArrayList;  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(expected, builder.toQuery(createShardContext()));
        expected = new BoostQuery(  
        String keyword_json = "{ \"intervals\" : { \""
        mapperService.merge("_doc", new CompressedXContent(mapping.toString()), MapperService.MergeReason.MAPPING_UPDATE);
            + "           \"mode\" : \"ordered\","
        String flags_json = "{ \"intervals\" : { \""
    private static final String[] filters = new String[] {  
        expected = new IntervalQuery(  
 * software distributed under the License is distributed on an
            + "\" : { "
            + "           \"mode\" : \"unordered_no_overlap\","  
        String json = "{ \"intervals\" : { \"" + TEXT_FIELD_NAME + "\": { " + "\"regexp\" : { \"pattern\" : \"te.m\" } } } }";
        int maxMGaps = randomInt(5) - 1;
            + "\" : { "  
            + "\" : { "  
        "not_contained_by",
            + TEXT_FIELD_NAME
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        return new IntervalQueryBuilder(TEXT_FIELD_NAME, createRandomSource(0, true));
                )
        Query expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.wildcard(new BytesRef("te?m")));
        }  
            + "           \"use_field\" : \""  
            + TEXT_FIELD_NAME
        );
                    Intervals.ordered(Intervals.term("atmosphere"), Intervals.or(Intervals.term("cold"), Intervals.term("outside")))
                mMode = IntervalMode.UNORDERED;
            case 1:
        final int DEFAULT_FLAGS = RegexpFlag.ALL.value();
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildFuzzySource("term", "Term", 2, true, Fuzziness.AUTO.asDistance("term")));
            new IntervalQuery(TEXT_FIELD_NAME, Intervals.ordered(Intervals.term("hello"), Intervals.term("world"))),  
            Intervals.notContaining(Intervals.or(Intervals.term("one"), Intervals.term("two")), Intervals.term("three"))
        );
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildRegexpSource("TE.M", DEFAULT_FLAGS, RegExp.ASCII_CASE_INSENSITIVE, null));  
            + "\": { "
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);  
            + "           \"query\" : \"Hello world\","
        "before",
                return createRandomDisjunction(depth, useScripts);  
            + "       \"match\" : { "
            + "\" } } } }";
        builder = (IntervalQueryBuilder) parseQuery(prefix_json);
    protected void doAssertLuceneQuery(IntervalQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
    }
            scriptService,
    private static final String NO_POSITIONS_FIELD = "no_positions_field";
                TEXT_FIELD_NAME,
            + "\": { "  
        );
            + "               { \"match\" : { \"query\" : \"one\" } },"
        builder = (IntervalQueryBuilder) parseQuery(json_with_analyzer);  
        builder = (IntervalQueryBuilder) parseQuery(json);
        assertEquals(expected, builder.toQuery(createShardContext()));  
            + "           \"query\" : \"Hello world\","
        Query expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.unordered(Intervals.term("hello"), Intervals.term("world")));  
            case 2:
            new IntervalQuery(
 *     http://www.apache.org/licenses/LICENSE-2.0
            ),
            @SuppressWarnings("unchecked")  
            + "           \"intervals\" : ["
    }
                TEXT_FIELD_NAME,  
                return (FactoryType) factory;
            + "\": { "
            + "           \"analyzer\" : \"whitespace\","  
        builder = (IntervalQueryBuilder) parseQuery(json_no_transpositions);
            + "\"wildcard\" : { \"pattern\" : \"Te?m\", \"max_expansions\" : 500 } } } }";  
            + "\"wildcard\" : { \"pattern\" : \"Te?m\", \"max_expansions\" : "  
            + "       \"all_of\" : {"
            .endObject();  
        assertEquals(expected, builder.toQuery(createShardContext()));
            + "\": { "  
            + "\": { "
        if (depth > 2) {  
            + TEXT_FIELD_NAME
        "not_containing",  
                ),
        expected = new BoostQuery(  
import org.opensearch.test.AbstractQueryTestCase;  
            + "                       { \"match\" : { \"query\" : \"three\" } } ] } } ],"
import org.opensearch.common.compress.CompressedXContent;
            + "               { \"match\" : { \"query\" : \"two\" } } ],"
            + "\"regexp\" : { \"pattern\" : \"[Tt]erm\" } } } }";
        });
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildRegexpSource("te.m", RegexpFlag.ANYSTRING.value(), null));  
        builder = (IntervalQueryBuilder) parseQuery(json);  
        assertEquals(expected, builder.toQuery(createShardContext()));
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);  
    }  
            + "           \"filter\" : { "  
    }
        return new IntervalQueryBuilder(TEXT_FIELD_NAME, createRandomSource(0, true));  
        assertEquals(expected, builder.toQuery(createShardContext()));  
        }  
        QueryShardContext context = new QueryShardContext(  
            + "           \"use_field\" : \""
        if (randomBoolean()) {
            + TEXT_FIELD_NAME
                Intervals.term("blah")  
 * this file be licensed under the Apache-2.0 license or a
 */  
        if (randomBoolean()) {
        IntervalMode mode;  
            + "{ \""  
        String json = "{ \"intervals\" : { \""
        });
        "overlapping",
            + "                   \"intervals\" : ["
            buildFuzzySource("term", "Term", FuzzyQueryBuilder.DEFAULT_PREFIX_LENGTH, true, Fuzziness.AUTO.asDistance("term"))
            + "{ \""  
        "containing",
            null
    static IntervalsSourceProvider.Combine createRandomCombine(int depth, boolean useScripts) {  
        assertEquals(expected, builder.toQuery(createShardContext()));
            + "           \"query\" : \"Hello world\","  
            + "\": { "  
        builder = (IntervalQueryBuilder) parseQuery(short_prefix_json);
    }  
    @Override  
    }
import java.util.Collections;
        IntervalQueryBuilder builder = (IntervalQueryBuilder) parseQuery(json);
            .startObject("_doc")
            + "               { \"match\" : { \"query\" : \"two\" } } ],"
                    30,  
        assertEquals(expected, builder.toQuery(createShardContext()));
        );  
                    Intervals.unorderedNoOverlaps(
import java.io.IOException;
    public void testCacheability() throws IOException {
            + TEXT_FIELD_NAME
            ),  
        expected = new IntervalQuery(
            + "\"fuzzy\" : { \"term\" : \"Term\", \"prefix_length\" : 2, \"transpositions\" : false } } } }";  
        expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.wildcard(new BytesRef("Te?m")));
            + "               { \"match\" : { \"query\" : \"one\" } },"  
            + "           \"query\" : \"Hello world\","  
            null,
import org.opensearch.script.ScriptType;
        });
            + "\"prefix\" : { \"prefix\" : \"Term\", \"analyzer\" : \"keyword\", \"use_field\" : \""  
        Query expected = new BoostQuery(
 * this work for additional information regarding copyright
        expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.wildcard(new BytesRef("te?m"), 500));  
        return new IntervalsSourceProvider.Combine(subSources, mode, maxGaps, filter);
            + NO_POSITIONS_FIELD
            + TEXT_FIELD_NAME  
        json = "{ \"intervals\" : "
            IntervalQueryBuilder builder = new IntervalQueryBuilder(INT_FIELD_NAME, provider);  
        String regexp_neg_max_expand_json = "{ \"intervals\" : { \""  
    }
                        Intervals.maxgaps(12, Intervals.unorderedNoOverlaps(Intervals.term("hello"), Intervals.term("open"))),
        String flags_value_json = "{ \"intervals\" : { \""
        IntervalMode mMode;
            + "               { \"match\" : { \"query\" : \"two\" } } ] } } } }";
                TEXT_FIELD_NAME,
            TEXT_FIELD_NAME,  
                assertEquals(IntervalFilterScript.CONTEXT, context);
        Query expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.or(Intervals.term("one"), Intervals.term("two")));
            + "           \"filter\" : {"
            builder1.toQuery(createShardContext());
            + "                       \"analyzer\" : \"keyword\" } } } },"
            TEXT_FIELD_NAME,
            + "            \"source\" : \"interval.start > 3\" } } } } } }";  
            IntervalQueryBuilder builder1 = (IntervalQueryBuilder) parseQuery(no_positions_json);  
            + "               { \"all_of\" : { "  
            + "{ \""  
        expected = new BoostQuery(  
                    Intervals.term("SENTENCE")  
    }  
        String regexp_max_expand_json = "{ \"intervals\" : { \""  
            + "               { \"match\" : { \"query\" : \"two\" } },"
            + "           \"query\" : \"Hello world\","
                break;  
            + "       \"script\" : { "
            + "                   \"match\" : { \"query\" : \"freeze\" } } } } } } }";
        );
            + "\": { "
                Intervals.maxgaps(10, Intervals.ordered(Intervals.term("Hello"), Intervals.term("world"))),
            2
            + "\": { "
import org.opensearch.common.util.BigArrays;
 * The OpenSearch Contributors require contributions made to  
            + "\": { "  
            .field("type", "text")
import org.opensearch.script.ScriptContext;  
        expected = new IntervalQuery(PREFIXED_FIELD, Intervals.fixField(PREFIXED_FIELD + "._index_prefix", Intervals.term("term")));  
            + "       \"all_of\" : {"
    }
            + "           \"query\" : \"Hello Open Search\","
        e = expectThrows(IllegalArgumentException.class, () -> {  
            + NO_POSITIONS_FIELD  
import static org.hamcrest.Matchers.instanceOf;  
            return super.mutateInstance(instance); // just change name/boost
        XContentBuilder mapping = jsonBuilder().startObject()
            + "\"regexp\" : { \"pattern\" : \"te.m\", \"max_expansions\" : "
            .startObject(NO_POSITIONS_FIELD)
            + "\" : { "
        expected = new IntervalQuery(
    }
            + "\" : { "
            + "\"match\" : { "
            e.getMessage(),
        assertEquals(expected, builder.toQuery(createShardContext()));  
        json = "{ \"intervals\" : "
            + "\": { "  
            builder1.toQuery(createShardContext());  
        assertEquals(expected, builder.toQuery(createShardContext()));
        assertEquals(expected, builder.toQuery(createShardContext()));
        FuzzyQuery fq = new FuzzyQuery(new Term("field", term), editDistance, prefixLength, 128, transpositions);
            new IntervalQuery(
        assertEquals(expected, builder.toQuery(createShardContext()));  
            Intervals.containing(
        String fixed_field_json = "{ \"intervals\" : { \""
        assertNotNull(rewriteQuery.toQuery(context));
        }
        json = "{ \"intervals\" : "  
            public <FactoryType> FactoryType compile(Script script, ScriptContext<FactoryType> context) {
            + "           \"intervals\" : ["
                        Intervals.term("three")
                TEXT_FIELD_NAME,
                Intervals.maxgaps(
import org.apache.lucene.util.automaton.RegExp;  
        builder = (IntervalQueryBuilder) parseQuery(json_with_fuzziness);
            + "\": { "  
package org.opensearch.index.query;
            builder.doToQuery(createShardContext());
            + "       \"boost\" : 2 } } }";  
            + "{ \""
            baseContext.getShardId(),
            IntervalQueryBuilder builder1 = (IntervalQueryBuilder) parseQuery(no_positions_fixed_field_json);  
import org.apache.lucene.util.BytesRef;
        builder = (IntervalQueryBuilder) parseQuery(json);
                Intervals.term("freeze")  
            TEXT_FIELD_NAME,  
import org.opensearch.script.Script;
            1.5f  
            + "               \"contained_by\" : { "
        Query q = builder.toQuery(context);  
            + "                   \"intervals\" : ["
        assertEquals(expected, builder.toQuery(createShardContext()));  
            + "           \"max_gaps\" : 10,"
        assertThat(e.getMessage(), equalTo("Only one interval rule can be specified, found [match] and [all_of]"));
                Intervals.unorderedNoOverlaps(  
import org.opensearch.script.ScriptService;
            + "\" } } } }";
            + TEXT_FIELD_NAME
 * Unless required by applicable law or agreed to in writing,
            + "\","
            TEXT_FIELD_NAME,
        String json_with_analyzer = "{ \"intervals\" : { \""
        switch (randomInt(20)) {  
            default:
            + "       \"match\" : { "  
        json = "{ \"intervals\" : "
    public void testCombineDisjunctionInterval() throws IOException {
        expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.fixField(MASKED_FIELD, Intervals.wildcard(new BytesRef("te?m"))));
 * license agreements. See the NOTICE file distributed with
        return buildRegexpSource(pattern, flags, 0, maxExpansions);
            + TEXT_FIELD_NAME
        String analyzer = randomFrom("simple", "keyword", "whitespace");
            IntervalQueryBuilder builder1 = (IntervalQueryBuilder) parseQuery(fixed_field_json_no_positions);
        });  
            + "           \"filter\" : { "  
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildRegexpSource("te.m", DEFAULT_FLAGS, null));
            + "           \"max_gaps\" : 3 },"  
        if (depth < 3 && randomInt(20) > 18) {
    public void testWildcard() throws IOException {
        e = expectThrows(IllegalArgumentException.class, () -> {
        assertThat(e.getMessage(), equalTo("Cannot create intervals over field [" + NO_POSITIONS_FIELD + "] with no positions indexed"));  
        expected = new IntervalQuery(TEXT_FIELD_NAME, buildFuzzySource("Term", "Term", 2, true, Fuzziness.AUTO.asDistance("term")));
                )  
        final RegExp regexp = new RegExp(pattern, flags, matchFlags);
            + "\"all_of\" : { \"intervals\" : [ { \"query\" : \"term2\" } ] } }";
            + "       \"boost\" : 3 } } }";  
    }
        assertEquals(expected, builder.toQuery(createShardContext()));
        IntervalQueryBuilder b = new IntervalQueryBuilder("no_such_field", provider);
            + "           \"mode\" : \"unordered_no_overlap\","
        String fixed_field_analyzer_json = "{ \"intervals\" : { \""  
        int orCount = randomInt(4) + 1;
        IntervalFilterScript.Factory factory = () -> new IntervalFilterScript() {  
    public void testRegexp() throws IOException {  
            + "\"regexp\" : { \"pattern\" : \"te.m\", \"max_expansions\" : -20 } } } }";  
            + "                       \"query\" : \"SENTENCE\","  
            + "   \"filter\" : { "
        builder = (IntervalQueryBuilder) parseQuery(json_with_prefix);  
                mMode = IntervalMode.ORDERED;
            2
            + TEXT_FIELD_NAME  
            + "\"prefix\" : { \"prefix\" : \"term\", \"use_field\" : \""
        String no_positions_json = "{ \"intervals\" : { \""
                break;  
            + "           \"query\" : \"Hello world\","
            + "       \"match\" : { "
    static IntervalsSourceProvider.IntervalFilter createRandomNonNullFilter(int depth, boolean useScripts) {
        assertEquals(expected, builder.toQuery(createShardContext()));
        String fixed_field_json = "{ \"intervals\" : { \""
        });  
import org.opensearch.common.unit.Fuzziness;  
            + TEXT_FIELD_NAME
        String text = String.join(" ", words);
        String short_prefix_json = "{ \"intervals\" : { \"" + PREFIXED_FIELD + "\": { " + "\"prefix\" : { \"prefix\" : \"t\" } } } }";  
import java.util.List;
        Query expected = new IntervalQuery(TEXT_FIELD_NAME, buildRegexpSource("te.m", DEFAULT_FLAGS, null));
            IntervalQueryBuilder builder1 = (IntervalQueryBuilder) parseQuery(no_positions_json);
        // This looks weird, but it's fine, because the innermost fixField wins  
            baseContext.getIndexSettings(),
        assertThat(  
        String fix_field_prefix_json = "{ \"intervals\" : { \""
            .startObject(PREFIXED_FIELD)
    private static IntervalsSource buildRegexpSource(String pattern, int flags, Integer maxExpansions) {  
            + "\": { "
        builder = (IntervalQueryBuilder) parseQuery(fixed_field_json);
        assertEquals(expected, q);  
        switch (randomIntBetween(0, 2)) {
                mMode = IntervalMode.UNORDERED_NO_OVERLAP;
            + "               { \"match\" : { \"query\" : \"one\" } },"  
                    12,  
            return createRandomMatch(depth + 1, useScripts);
        });  
            case 1:
        String json = "{ \"intervals\" : " + "{ \"" + TEXT_FIELD_NAME + "\" : { \"match\" : { \"query\" : \"Hello world\" } } } }";  
            public boolean execute(Interval interval) {
        builder = (IntervalQueryBuilder) parseQuery(json);
        );  
            + "\"wildcard\" : { \"pattern\" : \"term\" } } } }";
        String prefix_json = "{ \"intervals\" : { \"" + PREFIXED_FIELD + "\": { " + "\"prefix\" : { \"prefix\" : \"term\" } } } }";
        json = "{ \"intervals\" : "
            + "               { \"match\" : { \"query\" : \"one\" } },"
        };  
        Exception e = expectThrows(IllegalArgumentException.class, () -> {
    public void testNonIndexedFields() throws IOException {  
    public void testFuzzy() throws IOException {  
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {  
            null,  
        builder = (IntervalQueryBuilder) parseQuery(fixed_field_json);  
        json = "{ \"intervals\" : "  
            + "\": { "  
            null,
        assertEquals(expected, builder.toQuery(createShardContext()));
        String fixed_field_json_no_positions = "{ \"intervals\" : { \""
            + "\" } } } }";
        Query expected = new IntervalQuery(
        json = "{ \"intervals\" : "
                Intervals.maxgaps(
        assertEquals(expected, builder.toQuery(createShardContext()));
        );
        }  
            + TEXT_FIELD_NAME
        builder = (IntervalQueryBuilder) parseQuery(regexp_max_expand_with_flags_json);
            + "           \"max_gaps\" : 30,"
            null,  
            builder1.toQuery(createShardContext());
    public IntervalQueryBuilder mutateInstance(IntervalQueryBuilder instance) throws IOException {  
            + TEXT_FIELD_NAME  
            + "           \"analyzer\" : \"whitespace\","
            + TEXT_FIELD_NAME
            + "           \"mode\" : \"ordered\" },"
 *  
    }
        assertEquals(expected, builder.toQuery(createShardContext()));  
 * Licensed to Elasticsearch under one or more contributor  
            baseContext.getMapperService(),  
            + "\"regexp\" : { \"pattern\" : \"TE.M\", \"case_insensitive\" : true } } } }";  
            Intervals.fixField(MASKED_FIELD, Intervals.maxgaps(10, Intervals.ordered(Intervals.term("Hello"), Intervals.term("world"))))
            + "       \"match\" : { "
            + "\"wildcard\" : { \"pattern\" : \"Te?m\", \"use_field\" : \""
            + NO_POSITIONS_FIELD  
            + " } } } }";
        assertEquals(expected, builder.toQuery(createShardContext()));
            .endObject()  
            case 2:
            2
            null,
            + "           \"query\" : \"Hello world\","
        String keyword_fix_field_json = "{ \"intervals\" : { \""  
        String wildcard_over_max_expand_json = "{ \"intervals\" : { \""  
    static IntervalsSourceProvider.Disjunction createRandomDisjunction(int depth, boolean useScripts) {  
            Intervals.fixField(MASKED_FIELD, buildFuzzySource("term", "Term", 2, true, Fuzziness.ONE.asDistance("term")))
            subSources.add(createRandomSource(depth + 1, useScripts));
            + "           \"intervals\" : ["  
        if (useScripts == false || randomBoolean()) {  
            + "       \"boost\" : 3.5 } } }";
        builder = (IntervalQueryBuilder) parseQuery(regexp_neg_max_expand_json);
            + TEXT_FIELD_NAME
        expectThrows(IllegalArgumentException.class, () -> {
        builder = (IntervalQueryBuilder) parseQuery(flags_value_json);
                mode = IntervalMode.ORDERED;  
            + "\"regexp\" : { \"pattern\" : \"te.m\", \"use_field\" : \"masked_field\" } } } }";
            + "{ \""  
            + "\": {"
            + "{ \""
            + "\"match\" : { \"query\" : \"term1\" },"  
            + "       \"boost\" : 1.5 } } }";
import org.apache.lucene.queries.intervals.Intervals;  
        ScriptService scriptService = new ScriptService(Settings.EMPTY, Collections.emptyMap(), Collections.emptyMap()) {
            equalTo("Can only use interval queries on text fields - not on [" + INT_FIELD_NAME + "] which is of type [integer]")
import org.apache.lucene.search.BoostQuery;
        String regexp_over_max_expand_json = "{ \"intervals\" : { \""
            + TEXT_FIELD_NAME  
            + NO_POSITIONS_FIELD
        assertEquals(expected, builder.toQuery(createShardContext()));  
        builder = (IntervalQueryBuilder) parseQuery(regexp_max_expand_json);
        builder = (IntervalQueryBuilder) parseQuery(fix_field_prefix_json);
        assertEquals(expected, builder.toQuery(createShardContext()));
        assertThat(b.toQuery(createShardContext()), equalTo(new MatchNoDocsQuery()));  
                break;
        assertEquals(expected, builder.toQuery(createShardContext()));  
    private static IntervalsSource buildFuzzySource(String term, String label, int prefixLength, boolean transpositions, int editDistance) {
                        Intervals.maxgaps(3, Intervals.unorderedNoOverlaps(Intervals.term("one"), Intervals.term("two"))),  
            + "           \"max_gaps\" : 30 },"  
            )
            + "{ \""
            + "       \"boost\" : 1.5 } } }";
        assertTrue("query should be cacheable: " + queryBuilder.toString(), context.isCacheable());  
        Query expected = new IntervalQuery(TEXT_FIELD_NAME, Intervals.prefix(new BytesRef("term")));
        String json_with_fixfield = "{ \"intervals\" : { \""
        builder = (IntervalQueryBuilder) parseQuery(wildcard_max_expand_json);
        );  
            + "\"regexp\" : { \"pattern\" : \"te.m\", \"flags\" : \"NONE\" } } } }";
            ),  
            + TEXT_FIELD_NAME  
            + "\": {"
            + "\": { "
        expected = new BoostQuery(  
            builder1.toQuery(createShardContext());
        IntervalsSourceProvider source = new IntervalsSourceProvider.Match("text", 0, IntervalMode.ORDERED, "simple", scriptFilter, null);
        );
            + TEXT_FIELD_NAME
            + TEXT_FIELD_NAME
        };
            null,
                )  
            + TEXT_FIELD_NAME
            IntervalQueryBuilder builder1 = (IntervalQueryBuilder) parseQuery(regexp_over_max_expand_json);
            .endObject()
            + "           \"analyzer\" : \"whitespace\","
            case 0:
    private static IntervalsSourceProvider createRandomSource(int depth, boolean useScripts) {
        }  
                throw new AssertionError("Illegal randomisation branch");
        List<IntervalsSourceProvider> subSources = createRandomSourceList(depth, useScripts, count);
            + "       \"any_of\" : { "
        assertEquals(expected, builder.toQuery(createShardContext()));
            + "           \"query\" : \"Hello Open Search\","
    @Override
            null,
        queryBuilder = new IntervalQueryBuilder(TEXT_FIELD_NAME, source);  
    }
            + "\" } } } }";
            + "{ \""
            + "\"wildcard\" : { \"pattern\" : \"Te?m\", \"use_field\" : \"masked_field\" } } } }";
            builder.doToQuery(createShardContext());
        assertEquals(expected, builder.toQuery(createShardContext()));
    }  
        assertEquals(expected, builder.toQuery(createShardContext()));
            3
            + "\": {"  
            + "           \"intervals\" : ["  
                )
            ),
                        Intervals.ordered(Intervals.term("one"), Intervals.unordered(Intervals.term("two"), Intervals.term("three")))
        String json = "{ \"intervals\" : "
            case 0:
        );
        QueryShardContext context = createShardContext();  
        assertFalse("query with scripts should not be cacheable: " + queryBuilder.toString(), context.isCacheable());  
            return new IntervalQueryBuilder(KEYWORD_FIELD_NAME, instance.getSourceProvider());
            + TEXT_FIELD_NAME  
            TEXT_FIELD_NAME,
            + "\"use_field\" : \""
            + "{ \""
        assertEquals(expected, builder.toQuery(createShardContext()));
    @Override
        assertEquals(expected, builder.toQuery(createShardContext()));
        builder = (IntervalQueryBuilder) parseQuery(json);
            Intervals.maxgaps(40, Intervals.unordered(Intervals.term("hello"), Intervals.term("world")))  
import org.apache.lucene.queries.intervals.IntervalsSource;
            + "                       { \"match\" : { \"query\" : \"cold\" } },"  
        builder = (IntervalQueryBuilder) parseQuery(json);
            + "\"prefix\" : { \"prefix\" : \"term\" } } } }";
        int wordCount = randomInt(4) + 1;
        assertEquals(expected, builder.toQuery(createShardContext()));
            + "       \"boost\" : 3 } } }";
        json = "{ \"intervals\" : "  
            new IntervalQuery(  
    }
                    Intervals.unorderedNoOverlaps(
        json = "{ \"intervals\" : "
    }
        assertEquals(expected, builder.toQuery(createShardContext()));
            + "           \"mode\" : \"unordered_no_overlap\","
            + TEXT_FIELD_NAME
        rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
                    Intervals.maxgaps(
            ),
            + TEXT_FIELD_NAME  
        assertEquals(expected, builder.toQuery(createShardContext()));
            + "           \"mode\" : \"ordered\","
        assertThat(query, instanceOf(IntervalQuery.class));
        }  
    }
            + "\"fuzzy\" : { \"term\" : \"Term\", \"prefix_length\" : 2, \"analyzer\" : \"keyword\" } } } }";
}
            + "\"fuzzy\" : { \"term\" : \"Term\", \"prefix_length\" : 2, \"fuzziness\" : \"1\", "
            + "\": { "
            .startObject(MASKED_FIELD)
            return Intervals.multiterm(automaton, regexp.toString());
        } else {
        int count = randomInt(5) + 1;
            + "               { \"match\" : { \"query\" : \"three\" } } ],"
                    )
            null,
            default:
            3.5f
        );
            + "       \"match\" : { "
 * specific language governing permissions and limitations
        );  
            .field("type", "text")
        expected = new IntervalQuery(PREFIXED_FIELD, Intervals.fixField(PREFIXED_FIELD + "._index_prefix", Intervals.term("Term")));  
            + TEXT_FIELD_NAME
        String regexp_max_expand_with_flags_json = "{ \"intervals\" : { \""  
 * compatible open source license.
            + "\": {"
        expected = new IntervalQuery(
                TEXT_FIELD_NAME,
import org.apache.lucene.queries.intervals.IntervalQuery;
            Intervals.fixField(PREFIXED_FIELD, Intervals.fixField(PREFIXED_FIELD + "._index_prefix", Intervals.term("term")))  
            .endObject()
            + "\"prefix\" : { \"prefix\" : \"term\", \"use_field\" : \""
            + "               \"not_contained_by\" : { "
            + "           \"max_gaps\": 12 },"
        String json = "{ \"intervals\" : { \"" + TEXT_FIELD_NAME + "\": { " + "\"prefix\" : { \"prefix\" : \"term\" } } } }";  
                Intervals.maxgaps(30, Intervals.unorderedNoOverlaps(Intervals.term("one"), Intervals.term("two")))  
            + TEXT_FIELD_NAME  
            + "       \"any_of\" : { "
            + "\" } } } }";
        expected = new IntervalQuery(

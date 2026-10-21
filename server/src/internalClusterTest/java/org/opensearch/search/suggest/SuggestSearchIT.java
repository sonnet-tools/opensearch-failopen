            index("test", "type1", line, "body", line, "bigram", line);
        assertAcked(builder.setMapping(mapping));
        termsAndDocCount.put("prefix_cbad", 4);
            .endObject()
 * The OpenSearch Contributors require contributions made to
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        suggestions.put(
        index("test", "typ1", "3", "field1", "prefix_abbd", "field2", "prefix_efff");
        // Many of these candidates are drawn from page names on English Wikipedia.
        termSuggest = termSuggestion("text").suggestMode(SuggestMode.ALWAYS) // Always, otherwise the results can vary between requests.
            return context.factoryClazz.cast(factory);
            "Zoot",
import org.opensearch.search.suggest.phrase.Laplace;
        searchResponse = client().prepareSearch()
            .startObject("name")
        SearchResponse search = client().prepareSearch().setQuery(matchQuery("text", "spellchecker")).get();
            phraseSuggestion("body").addCandidateGenerator(
        assertSuggestion(suggest, 0, "test", "aacd", "abbd", "abcc");
            termSuggestion("field1").size(10).minDocFreq(0).suggestMode(SuggestMode.ALWAYS).shardSize(50)
            .endObject();
            );
        index("test", "typ1", "2", "field1", "prefix_aacd", "field2", "prefix_eeeh");
            assertThat(
            .endObject()
        logger.info("--> run suggestions with one index");
        }
 */
import java.util.Map;
        searchSuggest = searchSuggest(
                .put("index.analysis.filter.my_shingle.max_shingle_size", 2)
            SearchRequestBuilder searchBuilder = client().prepareSearch().setSize(0);
    public void testDifferentShardSize() throws Exception {
                .put(SETTING_NUMBER_OF_SHARDS, 1)
                .put("index.analysis.filter.my_shingle.type", "shingle")
        // we allow a size of 2 now on the shard generator level so "god" will be found since it's LD2
            .text("ab cd")
    }
        titles.add("Waddington"); // Lots of places have this name
                .put("index.analysis.filter.my_shingle.output_unigrams", false)
            .startObject("body")
        searchSuggest("test", termSuggest);
        assertThat(suggest.getSuggestion("test").getEntries().get(0).getText().string(), equalTo("abcd"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSuggestionPhraseCollateMatchExists;
        }
            .suggest(
            Settings.builder()
            "size10SortFrequencyFirst",
        titles.add("State");
            equalTo("Artur, Kinh of the Britons")
            .endObject();
        assertSuggestionSize(suggest, 0, 0, "test");
    // see #2729
        assertSuggestionSize(suggest, 0, 3, "did_you_mean");
        index("test", "typ1", "1", "field1", "prefix_abcd", "field2", "prefix_efgh");
            .toString();
    /**
        phraseSuggest.smoothingModel(new LinearInterpolation(0, 1, 0));
        try {
            );
import static org.hamcrest.Matchers.nullValue;
        @Override
        for (String title : titles) {
            .endObject();
        builders.add(client().prepareIndex("test").setSource("text", "apple"));
                .put(SETTING_NUMBER_OF_SHARDS, 1) // A single shard will help to keep the tests repeatable.
                .putList("index.analysis.analyzer.biword.filter", "shingler", "lowercase")
import org.opensearch.plugins.ScriptPlugin;
        assertAcked(prepareCreate("test_2").setMapping(mapping));
    }
import java.util.List;
                    .put(indexSettings())
            .field("title", "{{suggestion}}")
            .field("search_analyzer", "standard")
        assertSuggestion(searchSuggest, 0, "suggestion", 1, "apple");
        titles.add("Watlington"); // Ditto
        titles.add("Houses of Parliament");
            .addCandidateGenerator(new DirectCandidateGeneratorBuilder("text").suggestMode("popular").minDocFreq(2));
        indexRandomForConcurrentSearch("test");
     */
            Settings.builder()
            "a an the",
            );
        } catch (OpenSearchException e) {
            .startObject("properties")
        // collate script failure due to no additional params
        }
            // Can't forget lists, glorious lists!
        refresh();
        index("test_1", "type1", "3", "text", "ab bd");
            .field("analyzer", "body")
        ensureGreen();
            ).size(1).confidence(1.0f)
                .size(1000) // Setting a silly high size helps of generate a larger list of candidates for testing.
            .endObject()
            .get();
    public void testSizeAndSort() throws Exception {
            true,
            suggestBuilder.setGlobalText(suggestText);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                .put("index.analysis.filter.my_shingle.max_shingle_size", 2)
            return new DummyTemplateScriptEngine();
            .startObject()
            .field("type", "text")
     *            the field this candidate generator operates on.
        // The collate query setter is hard coded to use mustache, so lets lie in this test about the script plugin,
            .field("analyzer", "biword")
                                                                                                   // between requests.
        ensureGreen();
        }
        Suggest searchSuggest = searchSuggest("united states house of representatives elections in washington 2006", "title", suggest);
        suggest = searchSuggest("test", termSuggest);
import org.opensearch.test.hamcrest.OpenSearchAssertions;
        List<String> titles = new ArrayList<>();
            .startObject("properties")
        titles.add("Hooser");
        assertSuggestionSize(searchSuggest, 0, 10, "title");
            .startObject("fields")
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(
            "simple_phrase",
            fail("Malformed query (lack of additional params) should fail");
        assertSuggestionSize(searchSuggest, 0, 0, "did_you_mean");
     *
                .put(indexSettings())
        index("test", "type1", "3", "name", "I like ice cream.");
        Map<String, SuggestionBuilder<?>> namedSuggestion = new HashMap<>();
    public void testStopwordsOnlyPhraseSuggest() throws IOException {
    }
        searchSuggest = searchSuggest("ice tea", "did_you_mean", phraseSuggestion);
                .put("index.analysis.analyzer.bigram.tokenizer", "standard")
        assertSuggestionSize(suggest, 0, 0, "test");
        assertSuggestionSize(searchSuggest, 0, 2, "title");
        createIndex("test");
            "prefix_aacd"
        ).gramSize(3);
            TemplateScript.Factory factory = p -> {
        suggestions.put(
        titles.add("Electors");
            client().prepareIndex("test").setId("2").setSource("field1", "foobar2").setRouting("2"),
                ex.getMessage(),
            .endObject()
        ensureGreen();
                    endsWith("Suggest entries have different text actual [ABCD] expected [abcd]"),
        assertThat(suggest.getSuggestion("field2").getEntries().get(1).getText().string(), equalTo("prefix_efgh"));
                                                                                                   // between requests.
        List<IndexRequestBuilder> builders = new ArrayList<>();
        indexRandom(true, false, builders);
        titles.add("Unit circle");
        phraseSuggest = phraseSuggestion("text").text("appple")
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");
        assertSuggestionSize(searchSuggest, 0, 0, "simple_phrase");
            phraseSuggestWithParams
    }
        );
        titles.add("UniRed");
            .suggest(
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        Suggest searchSuggest = searchSuggest(
            .startObject()
        public static final String NAME = "mustache";
            .toString();
            .field("type", "text")
            .field("analyzer", "keyword")
        ensureGreen();
            }
            titles.add(c + " 2006");
            client().prepareIndex("test").setSource("name", "I like ice cream.")
        index("test", "type1", "3", "text", "abbd");
        index("test_1", "type1", "4", "text", "ab cc");
    public void testUnmappedField() throws IOException, InterruptedException, ExecutionException {
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        index("test", "type1", "1", "body", line, "bigram", line);
        suggest.collateQuery(filterStr);
            .field("{{query_field}}", "{{suggestion}}")
            .field("analyzer", "bigram")
                    .put("index.analysis.filter.shingler.type", "shingle")
        refresh();
        phraseSuggest.highlight("<em>", "</em>");
            ).size(1).confidence(1.0f)
        titles.add("United States House of Representatives Elections in Washington 1789");
        );
            assertRequestBuilderThrows(searchBuilder, SearchPhaseExecutionException.class);
        refresh();
                    .addSuggestion("did_you_mean", phraseSuggestion("name").maxErrors(5.0f))
        createIndex("test");
        index("test", "typ1", "4", "field1", "prefix_abcc", "field2", "prefix_eggg");
        refresh();
            Settings.builder()
            .startObject()
            .startObject("name")
        // Note that the last document has to have about the same length as the other or cutoff rechecking will remove the useful suggestion
            .field("analyzer", "body")
        assertNoFailures(searchResponse);
                    .addSuggestion("did_you_mean", phraseSuggestion("name").maxErrors(5.0f))
        phraseSuggestion.clearCandidateGenerators()
            client().prepareIndex("test").setSource("name", "I like iced tea"),
    public void testPhraseSuggesterCollate() throws InterruptedException, ExecutionException, IOException {
        suggest = searchResponse.getSuggest();
        searchSuggest = searchSuggest("Artur, King of the Britns", "simple_phrase", phraseSuggest);
            .maxEdits(2);
            .endObject()
            .startObject("pprefix")
            assertThat(
            .minWordLength(1);
            .addCandidateGenerator(candidateGenerator("body").minWordLength(1).prefixLength(1).suggestMode("always").size(1).accuracy(0.1f))
            "accuracy",
        suggest = searchSuggest("test", termSuggest);
        filteredQuerySuggest.collateParams(Collections.singletonMap("field", "title"));
        titles.add("Warrington"); // A town in England
 * this file be licensed under the Apache-2.0 license or a
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");
            Settings.builder()
        }
            .field("type", "text")
                .put("index.analysis.filter.my_shingle.min_shingle_size", 2)
        titles.add("Hoses");
        builders.add(client().prepareIndex("test").setSource("text", "papaya"));
import java.util.Map.Entry;
            .analyzer("body")
                .put("index.analysis.filter.shingler.max_shingle_size", 5)
        // Check the name this time because we're repeating it which is funky
            .startObject("name")
                return new TemplateScript(null) {
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(
        titles.add("Hose");
        Suggest searchSuggest = searchSuggest("Frank's Wise", "simple_phrase", phraseSuggest);
            .startObject("match_phrase")
        Suggest suggest = searchSuggest(
    public void testEmpty() throws Exception {
            .field("analyzer", "body")
        Map<String, SuggestionBuilder<?>> map = new HashMap<>();
                )
        titles.add("UNITAS");
        titles.add("Unified Modeling Language");
        assertSuggestion(suggest, 0, "test", 10, "abc0");
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
 *
            .startObject("text")
            )
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .endObject()
        assertSuggestionSize(suggest, 0, 0, "test");
        searchSuggest = searchSuggest("Artur, King of the Britns", "simple_phrase", phraseSuggest);
 * software distributed under the License is distributed on an
                .putList("index.analysis.analyzer.body.filter", "lowercase", "my_shingle")
        TermSuggestionBuilder termSuggest = termSuggestion("alias").text("appple");
        assertThat(suggest.getSuggestion("field2").getEntries().get(0).getText().string(), equalTo("prefix_eeeh"));
                }
            .endObject()
            return NAME;
        ensureGreen();
/*
                .put("index.analysis.filter.my_shingle.min_shingle_size", 2)
            client().prepareIndex("test").setId("1").setSource("field1", "foobar1").setRouting("1"),
        index("test", "type2", "4", "foo", "bar");
        termsAndDocCount.put("prefix_abaa", 8);
            .field("type", "text")
        prepareCreate("test").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0)).get();
    public void testSuggestWithManyCandidates() throws InterruptedException, ExecutionException, IOException {
        assertAcked(builder.setMapping(mapping));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        ensureGreen();
        for (int year = 1790; year < 2014; year += 2) {
            .endObject()
            .startObject()
        Suggest searchSuggest = searchSuggest("ice tea", "did_you_mean", phraseSuggestion);
            .setSize(0)
                .size(1)
    }
        titles.add("Stated Income Tax");
            .collateParams(params)
import org.opensearch.action.search.SearchRequestBuilder;
        assertSuggestion(searchSuggest, 0, "simple_phrase", "hello words");
        SearchResponse search = client().prepareSearch().setQuery(matchQuery("text", "spellcecker")).get();
 */
        phraseSuggest.smoothingModel(new Laplace(0.2));
        assertSuggestion(searchSuggest, 0, "suggestion", 2, "apple", "appfle");
        phraseSuggest.confidence(2f);
    }
                    .put(IndexSettings.MAX_SHINGLE_DIFF_SETTING.getKey(), 4)
        // collate suggest with bad query
            .field("type", "alias")
 *
import org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder;
        refresh();
        ensureGreen();
        assertSuggestion(searchSuggest, 0, 0, "simple_phrase", "nobel prize");
        for (char c = 'A'; c <= 'Z'; c++) {
            .startObject()
        );
            "prefix_abbb",
        builder.suggest(suggestBuilder);
        // But we can't stop there! Titles that are just a year are pretty common so lets just add one per year
            .field("type", "text")
            .field("type", "text")
            termSuggestion("field1").size(10).sort(SortBy.FREQUENCY).shardSize(1000).minDocFreq(0).suggestMode(SuggestMode.ALWAYS)
        PhraseSuggestionBuilder filteredQuerySuggest = suggest.collateQuery(filterString);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        assertSuggestion(searchSuggest, 0, 0, "title", "united states house of representatives elections in washington 2006");
                .put("index.analysis.filter.shingler.max_shingle_size", 3)
        termsAndDocCount.put("prefix_aaad", 20);
                .putList("index.analysis.analyzer.body.filter", "lowercase")
        PhraseSuggestionBuilder phraseSuggest = phraseSuggestion("bigram").gramSize(2)
        titles.add("Skates");
        assertSuggestion(suggest, 0, "size10SortScoreFirst", 10, "prefix_aacd", "prefix_abcc", "prefix_accd" /*, "prefix_aaad" */);
        assertThat(searchSuggest.getSuggestion("simple_phrase").getEntries().get(0).getText().string(), equalTo("Frank's Wise"));
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(
        );
        index("test_2", "type1", "2", "text", "aacd");
        assertAcked(builder.setMapping(mapping));
        index("test_1", "type1", "1", "text", "ab cd");
        titles.add("Staples");
        phraseSuggest.smoothingModel(new LinearInterpolation(0.4, 0.4, 0.2));
        titles.add("Unrated");
import org.opensearch.common.settings.Settings;
            .startObject("title")
        phraseSuggest.confidence(0.99f);
                .put("index.analysis.filter.my_shingle.max_shingle_size", 3)
        assertSuggestionSize(suggest, 0, 0, "test");
        index("test", "type1", "2", "name", "An other title about equal length");
        generator.suggestMode(null);
            client().prepareIndex("test").setId("3").setSource("field1", "foobar3").setRouting("3")
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                String result = script;
            )
import org.opensearch.search.suggest.phrase.PhraseSuggestionBuilder;
            .endObject()
        return Arrays.asList(
                .put(indexSettings())
        assertSuggestion(suggest, 0, "size3SortScoreFirst", "prefix_aacd", "prefix_abcc", "prefix_accd");
            .get();
                .put("index.analysis.analyzer.text.tokenizer", "standard")
import org.opensearch.common.xcontent.XContentFactory;
            .field("type", "text")
        ensureGreen();
    // see #3037
            .startObject()
    }
            Settings.builder()
        }
            "Sir Robin the Not-Quite-So-Brave-as-Sir-Lancelot",
        }
            new DirectCandidateGeneratorBuilder("title").suggestMode("always").maxTermFreq(.99f).size(10).maxInspections(200)
    }
    public void testSimple() throws Exception {
        termsAndDocCount.put("prefix_abcc", 1);
    // see #3469
            candidateGenerator("title").suggestMode("always")
                String script = scriptSource;
            .endObject()
            .startObject("{{query_type}}")
        // That ought to provide more less good candidates for the last term
        titles.add("State");
import java.util.Collections;
        for (String title : titles) {
        }
        );
        searchSuggest = searchSuggest("united states house of representatives elections in washington 2006", "title", filteredQuerySuggest);
        refresh();
            candidateGenerator("name").prefixLength(0).minWordLength(0).suggestMode("always").maxEdits(2)
            "hello word",
            .suggest(
package org.opensearch.search.suggest;
            titles.add(Integer.toString(year));
            .startObject()
            .field("analyzer", "biword")
        titles.add("Election");
        }
        refresh();
                .put("index.analysis.analyzer.suggest.tokenizer", "standard")
        Map<String, SuggestionBuilder<?>> suggestions = new HashMap<>();
                .putList("index.analysis.analyzer.bigram.filter", "my_shingle", "lowercase")
        // When searching on a shard with a non existing mapping, we should fail
        titles.add("Evictions");
import java.util.Collection;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        ).confidence(0f).maxErrors(2f).shardSize(30000).size(10);
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");
        index("test_1", "type1", "2", "text", "aa cd");
        suggest = searchSuggest("test", termSuggest);
            .size(1);
            titles.add("Elections " + c);
        assertAcked(builder.setMapping(mapping));
    }
        }
        assertSuggestion(suggest, 0, "size1", "prefix_aacd");
        logger.info("--> run suggestions with two indices");
            .endObject()
    }
            .endObject();
        public <T> T compile(String scriptName, String scriptSource, ScriptContext<T> context, Map<String, String> params) {
        ensureGreen();
        searchSuggest = searchSuggest(
            .endObject()
        ensureGreen();
                throw new UnsupportedOperationException();
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");
        assertSuggestionSize(suggest, 0, 0, "test");
            "Old Crone",
            .endObject()
     * @param field
        );
                .setSettings(
                        .put("index.analysis.analyzer.stopwd.tokenizer", "standard")
            .field("analyzer", "body")
        OpenSearchAssertions.assertSuggestionSize(suggest, 0, 3, "simple");
            fail(" can not suggest across multiple indices with different analysis chains");
            "prefix_cbad",
        );
            "Patsy, Arthur's Servant",
    }
        indexRandomForConcurrentSearch("test");
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .field("path", "text")
                .put("index.analysis.filter.shingler.type", "shingle")
            .minWordLength(1);
            .get();
            .field("type", "text")
        index("test", "type1", "2", "text", "aacd");
        );
        searchSuggest = searchSuggest(
            .startObject("body")
        assertAcked(prepareCreate("test_1").setMapping("text", "type=text"));
            phraseSuggestion("body").gramSize(1)
        termsAndDocCount.put("prefix_aacd", 1);
public class SuggestSearchIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            .endObject();
            "prefix_aaad",
        searchSuggest = searchSuggest("Arthur, King of the Britons", "simple_phrase", phraseSuggest);
    }
        assertSuggestion(suggest, 0, 0, "did_you_mean", "testing suggestions");
        PhraseSuggestionBuilder phraseSuggestWithParams = suggest.collateQuery(collateWithParams).collateParams(params);
            };
            .startObject("properties")
        assertSuggestionSize(searchSuggest, 0, 0, "simple_phrase");
                .put(indexSettings())
        Suggest suggest = searchSuggest("prefix_abcd", 0, suggestions);
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");
        termsAndDocCount.put("prefix_abba", 14);
                .prefixLength(1)
        assertSuggestion(suggest, 1, "field2", "prefix_eeeh", "prefix_efff", "prefix_eggg");
        refresh();
        assertThat("didn't ask for suggestions but got some", search.getSuggest(), nullValue());
    }
            "Dr. Winston",
                .put("index.analysis.filter.my_shingle.min_shingle_size", 2)
            .get();
            .addCandidateGenerator(new DirectCandidateGeneratorBuilder("text").suggestMode("popular").minDocFreq(2));
        logger.info("--> run suggestions with four indices");
                .put("index.analysis.filter.my_shingle.type", "shingle")
        }
    public void testPhraseSuggestMinDocFreq() throws Exception {
        List<IndexRequestBuilder> builders = new ArrayList<>();
            .maxErrors(1.0f)
            "Frank's Wife",
        termSuggest = termSuggestion("text").suggestMode(SuggestMode.ALWAYS) // Always, otherwise the results can vary between requests.
        // then good.
        params.put("query_field", "title");
        for (String line : strings) {
        // test phrase suggestion but nothing matches
        searchSuggest = searchSuggest("Xorr the Gut-Jewel", "simple_phrase", phraseSuggestion);
        ensureGreen();
            Settings.builder()
        builders.add(client().prepareIndex("test").setSource("text", "apple"));
     */
            "size10SortFrequencyFirst",
    }
                .put("index.analysis.analyzer.text.tokenizer", "standard")
        {
                };
        String filterStr = XContentFactory.jsonBuilder()
        suggest = searchSuggest("test", termSuggest);
            .startObject()
        assertAcked(
                    .put("index.analysis.filter.shingler.max_shingle_size", 5)
                .putList("index.analysis.analyzer.body.filter", "lowercase")
                .put("index.analysis.filter.shingler.output_unigrams", true)
import static org.hamcrest.Matchers.instanceOf;
        searchSuggest = searchSuggest("Artur, King of the Britns", "simple_phrase", phraseSuggest);
        ensureGreen();
        phraseSuggest.smoothingModel(null).tokenLimit(4);
    }
        index("test", "type1", "3", "body", "hello words");
            // expected
            "united states house of representatives elections in washington 2006",
                .addCandidateGenerator(candidateGenerator("body").minWordLength(1).suggestMode("always"))
                index("test", "type1", entry.getKey() + i, "field1", entry.getKey());
            "Sir Bedevere the Wise",
        try {
        titles.add("Washington's Birthday");
            "Miss Islington, the Witch",
        index("test", "type1", "4", "text", "abcc");
                .put(indexSettings())
                .put("index.analysis.filter.my_shingle.max_shingle_size", 3)
        searchSuggest = searchSuggest("Artur, King of the Britns", "simple_phrase", phraseSuggest);
        Map<String, SuggestionBuilder<?>> suggestions = new HashMap<>();
        } catch (SearchPhaseExecutionException ex) {
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(
                anyOf(
                    .addSuggestion("did_you_mean", phraseSuggestion("name").maxErrors(5.0f))
            .endObject()
            .endObject()
        for (int i = 0; i < 15; i++) {
            "title",
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put("index.number_of_shards", 1).build()).setMapping(mapping));
    }
    protected Suggest searchSuggest(String suggestText, String name, SuggestionBuilder<?> suggestion) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        for (Entry<String, SuggestionBuilder<?>> suggestion : suggestions.entrySet()) {
                .put("index.analysis.filter.my_shingle.min_shingle_size", 2)
        refresh();
        // suggest with collate
import java.net.URISyntaxException;
            // Lets just add some more to be evil
            .endObject()
        titles.add("Electron");
        assertAcked(builder.setMapping(mapping));
        ensureGreen();
        assertSuggestionSize(searchSuggest, 0, 0, "title");
     * Searching for a rare phrase shouldn't provide any suggestions if confidence &gt; 1.  This was possible before we rechecked the cutoff
        refresh();
        // Six of these are near enough to be viable suggestions, just not the top one
    @Override
                .put("index.analysis.analyzer.biword.tokenizer", "standard")
        assertSuggestionSize(searchSuggest, 0, 0, "simple_phrase");
        index("test_2", "type1", "1", "text", "ab cd");
                .put("index.analysis.filter.my_shingle.type", "shingle")
        assertRequestBuilderThrows(request, SearchPhaseExecutionException.class);
        searchSuggest = searchSuggest("suggestion", phraseSuggest);
        assertSuggestionSize(searchSuggest, 0, 0, "simple_phrase");
 * not use this file except in compliance with the License.
        OpenSearchAssertions.assertSuggestion(searchResponse.getSuggest(), 0, 0, "did_you_mean", "testing suggestions");
        super(settings);
import static org.opensearch.search.suggest.SuggestBuilders.phraseSuggestion;
                    endsWith("Suggest entries have different text actual [abcd] expected [ABCD]")
        Suggest suggest = searchSuggest(null, 0, suggestions);
                    @Override
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            "united states house of representatives elections in washington 2006",
        // The commented out assertions fail sometimes because suggestions are based off of shard frequencies instead of index frequencies.
 * under the License.
 * possible these tests should declare for the first request, make the request, modify the configuration for the next request, make that
        // which makes the collate code thinks mustache is evaluating the query.
        Map<String, Integer> termsAndDocCount = new HashMap<>();
        // pass in a correct phrase
import org.opensearch.action.index.IndexRequestBuilder;
        PhraseSuggestionBuilder phraseSuggestWithParamsAndReturn = suggest.collateQuery(collateWithParams)
                new SuggestBuilder().setGlobalText("tetsting sugestion")
/*
        assertNoFailures(searchResponse);
        assertSuggestionSize(suggest, 0, 0, "did_you_mean");
                .put("index.number_of_shards", 1)
        @Override
        builders.add(client().prepareIndex("test").setSource("text", "mango"));
                .put(IndexSettings.MAX_SHINGLE_DIFF_SETTING.getKey(), 4)
                .put("index.analysis.filter.my_shingle.output_unigrams", true)
        // assertThat(suggest.get(3).getSuggestedWords().get("prefix_abcd").get(4).getTerm(), equalTo("prefix_abcc"));
        index("test_2", "type1", "2", "text", "aa cd");
            .startObject("text")
import org.opensearch.search.suggest.phrase.LinearInterpolation;
        );
        refresh();
        params.put("query_type", "match_phrase");
                        .putList("index.analysis.analyzer.stopwd.filter", "stop")
            .addCandidateGenerator(
            );
        OpenSearchAssertions.assertNoFailures(searchResponse);
        refresh();
        assertSuggestionSize(searchSuggest, 0, 0, "simple_phrase");
            .field("type", "keyword")
            .startObject()
            .endObject()
                )
        index("test_2", "type1", "4", "text", "abcc");
        titles.add("Jalan Uniten–Dengkil"); // Highway in Malaysia
        for (Entry<String, Integer> entry : termsAndDocCount.entrySet()) {
            .endObject()
                .put("index.analysis.filter.my_shingle.output_unigrams", true)
        // Check the "text" field this one time.
            "size1",
            equalTo("Sir Bedever the Wife Sir Bedever the Wife Sir Bedever the Wife")
        ensureGreen();
        titles.add("Statues of the Liberators");
        index("test", "type1", "1", "text", "abcd");
                    .put("index.analysis.analyzer.suggest.tokenizer", "standard")
        TermSuggestionBuilder termSuggest = termSuggestion("text").suggestMode(SuggestMode.ALWAYS) // Always, otherwise the results can vary
        ).confidence(0f).maxErrors(2f).shardSize(30000).size(30000);
        phraseSuggest.smoothingModel(new LinearInterpolation(0.4, 0.4, 0.2));
            .addCandidateGenerator(candidateGenerator("body").minWordLength(1).suggestMode("always"))
            .field("analyzer", "text")
        TermSuggestionBuilder termSuggest = termSuggestion("text").suggestMode(SuggestMode.ALWAYS).text("abcd");
            .endObject()
            .field("type", "text")
        assertAcked(prepareCreate("test").setMapping("text", "type=text"));
        public String getType() {
                candidateGenerator("body").prefixLength(2).minWordLength(1).suggestMode("always")
                .putList("index.analysis.analyzer.bigram.filter", "my_shingle", "lowercase")
        index("test", "type1", "1", "name", "I like iced tea");
            .size(5);
        String filterString = XContentFactory.jsonBuilder()
        // finally indexing a document that will produce some meaningful suggestion
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");
 */
            searchBuilder.suggest(new SuggestBuilder().setGlobalText("tetsting sugestion").addSuggestion("did_you_mean", phraseSuggestion));
                        return result;
        } catch (OpenSearchException e) {
            .suggest(
            .endObject()
                    .put("index.analysis.filter.shingler.output_unigrams", true)
        assertAcked(builder.setMapping(mapping));
                .put("index.analysis.analyzer.body.tokenizer", "standard")
import org.opensearch.script.ScriptContext;
        suggestions.put(
                anyOf(
        PhraseSuggestionBuilder phraseSuggestion = phraseSuggestion("name.shingled").addCandidateGenerator(generator).gramSize(3);
            .endObject()
        titles.add("United States House of Representatives Elections in Washington 2006");
import java.io.IOException;
        index("test_2", "type1", "4", "text", "ab cc");
            .startObject("properties")
        searchSuggest = searchSuggest("Artur, King of the Britns", "simple_phrase", phraseSuggest);
 * the Apache License, Version 2.0 (the "License"); you may
        SearchResponse searchResponse = client().prepareSearch()
    }
                ex.getCause().getMessage(),
            .startObject("bigram")
        // Now some possessive
            "hello word",
        // suggest without collate
    }
                .put("index.analysis.filter.my_shingle.max_shingle_size", 2)
            .startObject()
        refresh();
            "prefix_abaa",
        assertSuggestion(searchSuggest, 0, 0, "title", "united states house of representatives elections in washington 2006");
        line = "I got it this time";
            index("test", "type1", phrase, "body", phrase);
            titles.add(c + " States");
                .put("index.analysis.filter.my_shingle.output_unigrams", false)
            .minWordLength(1);
    /**
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(
            true,
        }
    public SuggestSearchIT(Settings settings) {
        titles.add("Washing of the Spears"); // Book
        Suggest suggest = searchSuggest("test", termSuggestion);
                    endsWith("Suggest entries have different sizes actual [1] expected [2]"),
        phraseSuggest.tokenLimit(15).smoothingModel(new StupidBackoff(0.1));
        titles.add("Election");
        index("test", "type1", "11", "foo", "bar");
        SearchRequestBuilder builder = client().prepareSearch().setSize(0);
        phraseSuggestion = phraseSuggestion("nosuchField").addCandidateGenerator(
            .endObject()
        ensureGreen();
        {
            .endObject()
        assertAcked(prepareCreate("test").setMapping("text", "type=text"));
        return searchSuggest(suggestText, 0, map);
                    endsWith("Suggest entries have different sizes actual [2] expected [1]")
            "simple",
        Suggest searchSuggest = searchSuggest("suggestion", termSuggest);
import static org.opensearch.search.suggest.SuggestBuilders.termSuggestion;
            .startObject()
            termSuggestion("field2").text("prefix_eeeh prefix_efgh").maxTermFreq(10).minDocFreq(0).suggestMode(SuggestMode.ALWAYS)
            for (int i = 0; i < entry.getValue(); i++) {
        index("test", "type2", "2", "name", "An other title about equal length");
        // collate script with additional params
        searchSuggest = searchSuggest("Frank's Wise", "simple_phrase", phraseSuggest);
    }
            .addCandidateGenerator(new DirectCandidateGeneratorBuilder("text").suggestMode("popular"));
            .startObject()
                .put("index.analysis.analyzer.bigram.tokenizer", "standard")
            ).confidence(2f).maxErrors(5f).size(1)
        int chafPerShard = 100;
        suggest = searchSuggest("test", termSuggest);
                .put("index.analysis.analyzer.body.tokenizer", "standard")
            titles.add("States " + c);
                for (Entry<String, Object> entry : p.entrySet()) {
            Settings.builder()
                .put("index.analysis.filter.my_shingle.max_shingle_size", 2)
        assertSuggestion(searchSuggest, 0, "simple_phrase", "hello world");
                .putList("index.analysis.analyzer.text.filter", "lowercase", "my_shingle")
            .startObject("properties")
            .endObject();
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        ensureGreen();
                .put("index.analysis.analyzer.biword.tokenizer", "standard")
    private DirectCandidateGeneratorBuilder candidateGenerator(String field) {
        phraseSuggest.clearCandidateGenerators()
        titles.add("The Hoose-Gow");
        titles.add("United States House of Representatives Elections in Washington 2005");
            .field("type", "text")
            .endObject()
import static org.hamcrest.Matchers.endsWith;
        assertSuggestion(searchSuggest, 0, "simple_phrase", "xorr the god jewel");
        suggestions.put(
import org.opensearch.core.xcontent.XContentBuilder;
        );
        );
    public void testShardFailures() throws IOException, InterruptedException {
            "nobel prize",
        assertThat(suggest.getSuggestion("test").getEntries().get(0).getText().string(), equalTo("abcd"));
     * score during the reduce phase.  Failures don't occur every time - maybe two out of five tries but we don't repeat it to save time.
import java.util.Arrays;
            .endObject()
            .endObject()
        XContentBuilder mapping = XContentFactory.jsonBuilder()
                    .put("index.analysis.filter.shingler.min_shingle_size", 2)
        }
import org.opensearch.search.suggest.term.TermSuggestionBuilder;
            .field("analyzer", "bigram")
            titles.add(c + " Elections");
            )
        // Tons of different options very near the exact query term
            .field("analyzer", "suggest")
                .put(SETTING_NUMBER_OF_SHARDS, 1)
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            assertThat(
        builders.add(client().prepareIndex("test").setSource("text", "apple"));
        indexRandom(true, builders);
        // And some conjugation
                    .addSuggestion("did_you_mean", phraseSuggestion("name").maxErrors(5.0f))
        index("test", "type1", "1", "text", "bar");
        termsAndDocCount.put("prefix_addd", 10);
            if (context.instanceClazz != TemplateScript.class) {
        List<IndexRequestBuilder> builders = new ArrayList<>();
import java.util.Set;
            .startObject("bigram")
            .field("{{field}}", "{{suggestion}}")
            "foobar",
                .put(SETTING_NUMBER_OF_SHARDS, 1) // A single shard will help to keep the tests repeatable.
import org.opensearch.search.suggest.term.TermSuggestionBuilder.SuggestMode;
                .maxTermFreq(10)
            "Sir Galahad the Pure",
    public static class DummyTemplateScriptEngine implements ScriptEngine {
            .field("type", "text")
            searchSuggest.getSuggestion("simple_phrase").getEntries().get(0).getText().string(),
        termsAndDocCount.put("prefix_accd", 1);
        index("test", "type1", "3", "text", "abbd");
            phraseSuggestion("body").addCandidateGenerator(
        builders.add(client().prepareIndex("test").setSource("text", "appfle"));
        assertThat(suggest.getSuggestion("did_you_mean").getEntries().get(0).getText().string(), equalTo("tetsting sugestion"));
            "simple_phrase",
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        String[] strings = new String[] {
            .field("type", "text")
        assertSuggestion(
            .text("abcd");
        titles.add("Unite Against Fascism");
            ).setMapping(mappingBuilder)
            .toString();
import static org.hamcrest.Matchers.anyOf;
        TermSuggestionBuilder termSuggest = termSuggestion("text").suggestMode(SuggestMode.ALWAYS) // Always, otherwise the results can vary
        }
                ex.getMessage(),
        titles.add("Wasington"); // A film?
    public void testPrefixLength() throws IOException {
            .endObject();
            fail(" can not suggest across multiple indices with different analysis chains");
 * ownership. Elasticsearch licenses this file to you under
                .put("index.analysis.filter.my_shingle.type", "shingle")
        );
                    endsWith("Suggest entries have different sizes actual [1] expected [2]"),
        );
        phraseSuggest = phraseSuggestion("text").text("appple")
    }
        suggest = searchSuggest("test", termSuggestion);
            .text("abcd")
            .endObject()
            "title",
        namedSuggestion.put("my_title_suggestion", incorrectFilteredSuggest);
            titles.add("United States House of Representatives Elections in Washington " + year);
 * license agreements. See the NOTICE file distributed with
        // pass in a correct phrase - set confidence to 2
            "prefix_abba",
                .put(SETTING_NUMBER_OF_SHARDS, 1)
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
        refresh();
        assertThat(suggest.getSuggestion("test").getEntries().get(0).getText().string(), equalTo("abcd"));
        titles.add("Media organizations housed within colleges");
        // united states house of representatives elections in washington 2006
        // pass in a correct phrase - set confidence to 0.99
            filteredFilterSuggest
            .startObject()
    public static class DummyTemplatePlugin extends Plugin implements ScriptPlugin {
        );
    protected Suggest searchSuggest(String name, SuggestionBuilder<?> suggestion) {
        index("test", "type2", "3", "foo", "bar");
        searchSuggest = searchSuggest("united states house of representatives elections in washington 2006", "title", suggest);
            fail("Post filter error has been swallowed");
            .endObject()
            .startObject()
        // If there isn't enough chaf per shard then shards can become unbalanced, making the cutoff recheck this is testing do more harm
    }
            phraseSuggestWithParamsAndReturn
    public void testSuggestAcrossMultipleIndices() throws IOException {
        assertAcked(
        );
    // see #2817
            .endObject();
                .putList("index.analysis.analyzer.text.filter", "lowercase", "my_shingle")
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(
            .text("ab cd")
        // When searching on a shard which does not hold yet any document of an existing type, we should not fail
        assertSuggestionSize(searchSuggest, 0, 2, "title");
                )
            .field("search_analyzer", "standard")
            .text("abcd");
        NumShards numShards = getNumShards("test");
                .suggestMode(SuggestMode.ALWAYS)
        public Set<ScriptContext<?>> getSupportedContexts() {
        searchSuggest("test", termSuggest);
                candidateGenerator("body").minWordLength(1).suggestMode("always").maxTermFreq(.99f)
        assertThat(suggest.getSuggestion("test").getEntries().get(0).getText().string(), equalTo("abcd"));
    // see #3196
    public void testSearchForRarePhrase() throws IOException {
import org.opensearch.action.search.SearchResponse;
        }
        assertAcked(builder.setMapping(mapping));
    }
        assertSuggestion(searchSuggest, 0, "simple_phrase", "sir bedevere the wise sir bedevere the wise sir bedevere the wise");
        assertSuggestion(suggest, 0, "test", "aacd", "abbd", "abcc");
        );
        assertSuggestionSize(searchSuggest, 0, 25480, "title");  // Just to prove that we've run through a ton of options
            titles.add("House " + c);
        return searchSuggest(null, name, suggestion);
        }
        index("test", "type2", "2", "foo", "bar");
        termSuggest = termSuggestion("text").suggestMode(SuggestMode.ALWAYS) // Always, otherwise the results can vary between requests.
        searchSuggest = searchSuggest(
        );
 * KIND, either express or implied.  See the License for the
            .field("type", "text")
        refresh();
            .text("abcd");
        String incorrectFilterString = XContentFactory.jsonBuilder()
        Suggest searchSuggest = searchSuggest("Xorr the Gut-Jewel", "simple_phrase", phraseSuggestion);
            candidateGenerator("name").prefixLength(0).minWordLength(0).suggestMode("always").maxEdits(2)
            .startObject("alias")
            "size3SortScoreFirstMaxEdits1",
        searchSuggest = searchSuggest("Arthur, King of the Britons", "simple_phrase", phraseSuggest);
            .field("analyzer", "text")
            .startObject("text")
                .putList("index.analysis.analyzer.biword.filter", "shingler", "lowercase")
        for (String phrase : phrases) {
            // Lots of people are named Washington <Middle Initial>. LastName
        refresh();
        assertThat(suggest.getSuggestion("test").getEntries().get(0).getText().string(), equalTo("abcd"));
            .gramSize(2)
            .startObject("properties")
        assertThat(suggest.getSuggestion("did_you_mean").getEntries().get(0).getText().string(), equalTo("tetsting sugestion"));
            termSuggestion("field1").size(1)
import static org.hamcrest.Matchers.equalTo;
        assertSuggestion(searchSuggest, 0, "did_you_mean", "iced tea");
    public void testSuggestModes() throws IOException {
        return Collections.singleton(DummyTemplatePlugin.class);
        // distribute mass
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            termSuggestion("field1").size(10).minDocFreq(0).suggestMode(SuggestMode.ALWAYS)
            "Leader of Robin's Minstrels",
            Settings.builder()
        assertSuggestionPhraseCollateMatchExists(searchSuggest, "title", 2);
        titles.add("UNITER");
            .toString();
                .put("index.analysis.filter.shingler.max_shingle_size", 3)
            .startObject("properties")
        ensureGreen();
        refresh();
        assertSuggestion(suggest, 0, "size3SortScoreFirstMaxEdits1", "prefix_aacd", "prefix_abcc", "prefix_accd");
                .text("prefix_abcd")
        );
            index("test", "type1", Integer.toString(i), "text", "abc" + i);
            .endObject()
                .putList("index.analysis.analyzer.body.filter", "lowercase")
        );
        // since 0. Why not?
        suggestions.put(
        assertSuggestion(searchSuggest, 0, "suggestion", "apple");
            .startObject("test")
            .endObject()
        SearchResponse searchResponse = client().prepareSearch()
 * SPDX-License-Identifier: Apache-2.0
        searchSuggest = searchSuggest("Artur, King of the Britns", "simple_phrase", phraseSuggest);
            .endObject()
 * You may obtain a copy of the License at
            return Collections.singleton(TemplateScript.CONTEXT);
        }
            phraseSuggestion("body").addCandidateGenerator(
        assertSuggestionSize(suggest, 0, 0, "did_you_mean");
        XContentBuilder mapping = XContentFactory.jsonBuilder()
                .maxInspections(1000) // This too
            searchSuggest.getSuggestion("simple_phrase").getEntries().get(0).getOptions().get(0).getHighlighted().string(),
        assertSuggestion(suggest, 0, "test", 5, "abc0");
            ).confidence(2f).maxErrors(5f).size(1)
        Suggest searchSuggest = searchSuggest("united states house of representatives elections in washington 2006", "title", suggest);
        // But we need to make sure we generate a ton of suggestions so we add a bunch of candidates.
    public void testWithMultipleCommands() throws Exception {
     * Creates a new {@link DirectCandidateGeneratorBuilder}
        assertAcked(prepareCreate("test").setMapping("text", "type=text"));
            // expected
                .put("index.analysis.filter.my_shingle.output_unigrams", true)
        searchSuggest = searchSuggest(
            .endObject()
        try {
        indexRandom(
        titles.add("Waplington"); // Yup, also a town
 * Modifications Copyright OpenSearch Contributors. See
        for (int i = 0; i < 8; i++) {
        );
        Suggest searchSuggest = searchSuggest(
        // try all smoothing methods
            .endObject();
            "prefix_accc",
        assertThat(Arrays.toString(actionGet.getShardFailures()), actionGet.getFailedShards(), equalTo(expectShardsFailed));
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(
        );
                                                                                                      // vary between requests.
            titles.add(c + " House");
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(
        titles.add("Statens Museum for Kunst");
        // suggest with collation
        termsAndDocCount.put("prefix_dbca", 6);
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            builders.add(client().prepareIndex("test").setSource("title", title));
                    .putList("index.analysis.analyzer.suggest.filter", "lowercase", "shingler")
            .endObject()
        assertAcked(prepareCreate("test").setMapping("text", "type=text"));
            prepareCreate("test").setSettings(
        suggestions.put(
        indexRandom(
        public ScriptEngine getScriptEngine(Settings settings, Collection<ScriptContext<?>> contexts) {
        index("test", "type1", "2", "body", "hello world");
        if (suggestText != null) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSuggestion;
                .put("index.analysis.filter.shingler.min_shingle_size", 2)
                    .addSuggestion("did_you_mean", phraseSuggestion("fielddoesnotexist").maxErrors(5.0f))
                candidateGenerator("body").minWordLength(1).suggestMode("always").maxTermFreq(.99f)
            // expected
            "prefix_addd",
        );
        assertSuggestion(searchSuggest, 0, 0, "did_you_mean", "iced tea");
            .startObject("properties")
        }
            );
        termSuggestion.text("abcd").shardSize(5);
        index("test", "type2", "5", "foo", "bar");
            .startObject("name")
                    }
        searchSuggest = searchSuggest("suggestion", phraseSuggest);
        Suggest suggest = searchResponse.getSuggest();
            0,
        indexRandom(true, false, builders);
        phraseSuggest.smoothingModel(new StupidBackoff(0.1));
    }
                .minDocFreq(0)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSuggestionSize;
            SearchRequestBuilder searchBuilder = client().prepareSearch().setSize(0);
            .startObject("properties")
        SearchResponse actionGet = builder.get();
        assertSuggestion(searchSuggest, 0, "simple_phrase", "frank's wife");
        suggest = searchResponse.getSuggest();
                .maxTermFreq(.99f)
        }
    }
        );
            "Police sergeant who stops the film", };
        // collate suggest with no result (boundary case)
import org.opensearch.action.search.SearchPhaseExecutionException;
        );
        } catch (IllegalStateException ex) {
            .endObject();
            .startObject("title")
                                                                                                   // between requests.
            assertThat(
            .addCandidateGenerator(candidateGenerator("body").minWordLength(1).suggestMode("always"))
 * Licensed to Elasticsearch under one or more contributor
            .startObject()
 *
            .startObject()
    public void testBasicPhraseSuggest() throws IOException, URISyntaxException {
            .endObject();
        searchSuggest = searchSuggest("Arthur, King of the Britons", "simple_phrase", phraseSuggest);
                new SuggestBuilder().setGlobalText("tetsting sugestion")
    }
            .startObject("fields")
        Suggest suggest = searchSuggest("test", termSuggest);
            .endObject()
            "simple_phrase",
        termsAndDocCount.put("prefix_aaca", 16);
                .put("index.analysis.filter.shingler.min_shingle_size", 2)
        searchSuggest = searchSuggest("Artur, King of the Britns", "simple_phrase", phraseSuggest);
                candidateGenerator("body").prefixLength(4).minWordLength(1).suggestMode("always")
        titles.add("Houses of Parliament");
        titles.add("Howse Peak");
            phrases.add("chaff" + i);
        DirectCandidateGeneratorBuilder generator = candidateGenerator("name").prefixLength(0)
            "simple_phrase",
            searchSuggest("test", termSuggest);
import org.opensearch.index.IndexSettings;
        searchSuggest = searchSuggest("Elections of Representatives Parliament", "title", filteredQuerySuggest);
        // Ask for highlighting
        index("test", "type1", "1", "text", "abcd");
            .endObject()
            .startObject("properties")
        assertSuggestionSize(suggest, 0, 0, "test");
        Map<String, Object> params = new HashMap<>();
    // see #3469
            .startObject("bigram")
                .put("index.analysis.filter.my_shingle.min_shingle_size", 2)
                    public String execute() {
 * specific language governing permissions and limitations
            .endObject()
        ensureGreen();
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");
            assertThat(ex.getCause(), instanceOf(IllegalStateException.class));
    public void testEmptyIndex() throws Exception {
            "simple_phrase",
            .suggestMode("always")
            .minWordLength(0)
        List<IndexRequestBuilder> builders = new ArrayList<>();
                candidateGenerator("body").minWordLength(1).prefixLength(1).suggestMode("always").size(2).accuracy(0.1f)
            .endObject()
    public static Collection<Object[]> parameters() {
            .setSize(0)
        titles.add("Untied shoelaces");
                .putList("index.analysis.analyzer.bigram.filter", "my_shingle", "lowercase")
        phraseSuggest.highlight(null, null).confidence(0f).size(1).maxErrors(0.5f);
        assertThat(
        TermSuggestionBuilder termSuggest = termSuggestion("text").suggestMode(SuggestMode.ALWAYS) // Always, otherwise the results can vary
        PhraseSuggestionBuilder suggest = phraseSuggestion("title").addCandidateGenerator(
            .smoothingModel(new StupidBackoff(0.1))
        TermSuggestionBuilder termSuggestion = termSuggestion("text").suggestMode(SuggestMode.ALWAYS) // Always, otherwise the results can
        index("test_2", "type1", "3", "text", "abbd");
            .collatePrune(true);
        for (int year = 0; year < 2015; year++) {
        }
        } catch (IllegalStateException ex) {
                )
            .size(2)
        assertSuggestionSize(suggest, 0, 0, "accuracy");
            searchBuilder.suggest(new SuggestBuilder().setGlobalText("tetsting sugestion").addSuggestion("did_you_mean", phraseSuggestion));
        PhraseSuggestionBuilder phraseSuggest = phraseSuggestion("text").text("appple")
                .put(indexSettings())
        assertSuggestionSize(searchSuggest, 0, 2, "title");
            prepareCreate("test").setMapping("body", "type=text,analyzer=stopwd")
        Suggest searchSuggest = searchSuggest("ice tea", "did_you_mean", phraseSuggestion);
        index("test", "type1", "1", "text", "bar");
        index("test", "type1", "2", "body", line, "bigram", line);
        termsAndDocCount.put("prefix_accc", 12);
            "Sir Lancelot the Brave",
            .endObject()
 * Integration tests for term and phrase suggestions.  Many of these tests many requests that vary only slightly from one another.  Where
        // And other stuff
        try {
        map.put(name, suggestion);
        PhraseSuggestionBuilder incorrectFilteredSuggest = suggest.collateQuery(incorrectFilterString);
            suggestBuilder.addSuggestion(suggestion.getKey(), suggestion.getValue());
            "Knight Who Says Ni",
        suggestions.put("size3SortScoreFirst", termSuggestion("field1").size(3).minDocFreq(0).suggestMode(SuggestMode.ALWAYS));
            .setSize(0)
        titles.add("Representative Government");
        List<String> titles = new ArrayList<>();
import java.util.HashMap;
/*
        assertThat(
        index("test", "type1", "2", "text", "aacd");
                .put("index.analysis.filter.shingler.type", "shingle")
            .suggest(
        refresh();
        searchSuggest = searchSuggest("Artur, Kinh of the Britons", "simple_phrase", phraseSuggest);
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
        titles.add("Un-Led-Ed");
import org.opensearch.OpenSearchException;
            .setSize(0)
        for (int i = 0; i < test.numPrimaries * chafPerShard; i++) {
                ex.getCause().getMessage(),
        String line = "xorr the god jewel";
            "united states house of representatives elections in washington 2006",
        index("test", "type1", "1", "name", "Just testing the suggestions api");
                Settings.builder()
                .put("index.analysis.analyzer.body.tokenizer", "standard")
            .toString();
            "title",
            searchSuggest("united states house of representatives elections in washington 2006", numShards.numPrimaries, namedSuggestion);
        // check tokenLimit
            .analyzer("body")
        NumShards test = getNumShards("test");
            .field("type", "text")
            titles.add("Washington " + c + ". Lastname");
        // assertThat(suggest.get(3).getSuggestedWords().get("prefix_abcd").get(4).getTerm(), equalTo("prefix_accd"));
        );
        SearchRequestBuilder request = client().prepareSearch()
            .field("type", "text")
        // Now remove or add plural copies of every term we can
        XContentBuilder mappingBuilder = XContentFactory.jsonBuilder()
        SuggestBuilder suggestBuilder = new SuggestBuilder();
                .put("index.analysis.filter.shingler.type", "shingle")
        index("test", "typ1", "1", "body", "this is a test");
        assertThat(suggest.getSuggestion("test").getEntries().get(0).getText().string(), equalTo("abcd"));
    }
            titles.add("United " + c);
            "Sir Robin (Stand-in)",
            .startObject("shingled")
        index("test", "type1", "2", "name", "I like tea.");
                anyOf(
            .startObject("shingled")
import java.util.concurrent.ExecutionException;
            .field("title", "{{suggestion}}")
        logger.info("--> run suggestions with three indices");
            "size10SortScoreFirst",
                new SuggestBuilder().setGlobalText("tetsting sugestion")
            .endObject();
            .field("analyzer", "bigram")
                new SuggestBuilder().setGlobalText("tetsting sugestion")
            Settings.builder()
        return new DirectCandidateGeneratorBuilder(field);
        String collateWithParams = XContentFactory.jsonBuilder()
import org.opensearch.script.TemplateScript;
        @Override
                    endsWith("Suggest entries have different sizes actual [2] expected [1]")
        Suggest suggest = searchSuggest("test", termSuggest);
            .setSize(0)
        // set all mass to trigrams (not indexed)
        assertSuggestion(suggest, 0, "field2", "prefix_efgh");
        titles.add("Staten Island");
        Suggest searchSuggest = searchSuggest(
}
                .put("index.analysis.filter.my_shingle.type", "shingle")
                .putList("index.analysis.analyzer.suggest.filter", "lowercase", "shingler")
        try {
        }
 * request, modify again, request again, etc.  This makes it very obvious what changes between requests.
        List<String> phrases = new ArrayList<>();
        );
            "Dr. Piglet",
    }
            searchSuggest("test", termSuggest);
            .startObject("body")
    public void testSizeOneShard() throws Exception {
        builders.add(client().prepareIndex("test").setSource("text", "apple"));
            titles.add("List of former members of the United States House of Representatives (" + c + ")");
            "field2",
            termSuggestion("field1").maxEdits(1).size(10).minDocFreq(0).suggestMode(SuggestMode.ALWAYS)
    }
 * GitHub history for details.
            .smoothingModel(new LinearInterpolation(1, 0, 0));
                    script = script.replace("{{" + entry.getKey() + "}}", String.valueOf(entry.getValue()));
        );
        } catch (SearchPhaseExecutionException ex) {
        Suggest searchSuggest = searchSuggest("suggestion", phraseSuggest);
        phraseSuggest.realWordErrorLikelihood(0.95f);
                .put(indexSettings())
        Suggest suggest = searchSuggest("test", termSuggest);
            .field("title", "{{suggestion}}")
            searchSuggest("united states house of representatives elections in washington 2006", numShards.numPrimaries, namedSuggestion);
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");
            )
 * Unless required by applicable law or agreed to in writing,
            fail("Post query error has been swallowed");
    }
        index("test", "type2", "1", "name", "Just testing the suggestions api");
        ensureGreen();
        searchSuggest = searchSuggest("Artur, King of the Britns", "simple_phrase", phraseSuggest);
                new SuggestBuilder().setGlobalText("tetsting sugestion")
            .endObject()
                .put("index.analysis.analyzer.body.tokenizer", "standard")
            .field("type", "text")
    public void testSizeParam() throws IOException {
                .put("index.analysis.analyzer.bigram.tokenizer", "standard")
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            .endObject()
            );
        index("test", "type1", "1", "body", "hello world");
            assertRequestBuilderThrows(searchBuilder, SearchPhaseExecutionException.class);
                .put("index.analysis.filter.my_shingle.output_unigrams", false)
            client().prepareIndex("test").setSource("name", "I like tea."),
        } catch (OpenSearchException e) {
        assertAcked(builder.setMapping(mapping));
 */
    protected Suggest searchSuggest(String suggestText, int expectShardsFailed, Map<String, SuggestionBuilder<?>> suggestions) {
            .endObject()
                anyOf(
        @Override
                .put("index.analysis.filter.my_shingle.type", "shingle")
                    endsWith("Suggest entries have different text actual [ABCD] expected [abcd]"),
        assertSuggestionSize(searchSuggest, 0, 0, "simple_phrase");
        indexRandom(true, builders);
            "prefix_dbca",
        titles.add("STATS LLC");
            suggest,
                    Settings.builder()
        PhraseSuggestionBuilder phraseSuggestion = phraseSuggestion("name.shingled").addCandidateGenerator(
        PhraseSuggestionBuilder suggest = phraseSuggestion("title").addCandidateGenerator(
        titles.add("Untitled");
        assertNoFailures(searchResponse);
            builders.add(client().prepareIndex("test").setSource("title", title));
        index("test", "type1", "12", "foo", "bar");
        ensureGreen();
            .startObject()
            phrases.add("noble somethingelse" + i);
            "Frank, the Historian",
            .field("analyzer", "suggest")
        // collate query request with prune set to true
        assertSuggestion(searchSuggest, 0, "suggestion", 1, "apple");
            .startObject()
            "Arthur, King of the Britons",
                    .put("index.refresh_interval", -1)  // prevents occasional scoring glitches due to multi segments
/**
        suggest.size(1);
            searchSuggest.getSuggestion("simple_phrase").getEntries().get(0).getText().string(),
            .endObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
            .startObject("properties")
        assertAcked(prepareCreate("test").setMapping("field1", "type=text", "field2", "type=text"));
        index("test_2", "type1", "3", "text", "ab bd");
        );
import static org.opensearch.index.query.QueryBuilders.matchQuery;
            }
        assertSuggestionSize(searchSuggest, 0, 10, "title");
            assertThat(ex.getCause(), instanceOf(IllegalStateException.class));
import java.util.ArrayList;
        index("test_2", "type1", "1", "text", "abcd");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(
        );
        );
import org.opensearch.plugins.Plugin;
        assertThat(suggest.getSuggestion("test").getEntries().get(0).getText().string(), equalTo("abcd"));
        XContentBuilder mapping = XContentFactory.jsonBuilder()
    }
            .startObject("match_phrase")
                )
        ).gramSize(3);
            .field("type", "keyword")
        );
        assertAcked(builder.setMapping(mapping));
        );
 * compatible open source license.
        refresh();
        searchResponse = client().prepareSearch()
        assertThat(
            .text("ABCD")
            .endObject()
            searchSuggest("united states house of representatives elections in washington 2006", numShards.numPrimaries, namedSuggestion);
        titles.add("Unicef");
            .startObject("properties")
        }
            "noble prize",
import org.opensearch.script.ScriptEngine;
        // set all mass to bigrams
            .startObject("body")
        }
            termSuggestion("field2").text("prefix_efgh").accuracy(1f).maxTermFreq(10).minDocFreq(0).suggestMode(SuggestMode.ALWAYS)
        assertSuggestion(searchSuggest, 0, "simple_phrase", "frank's wife");
                    endsWith("Suggest entries have different text actual [abcd] expected [ABCD]")
        index("test", "type1", "4", "text", "abcc");
        PhraseSuggestionBuilder filteredFilterSuggest = suggest.collateQuery(filterStringAsFilter);
            .size(10);
        // We're going to be searching for:
    public void testSuggestWithFieldAlias() throws Exception {
        // collate suggest with bad query
            .endObject()
        titles.add("Representative Government");
import org.opensearch.search.suggest.phrase.StupidBackoff;
        index("test", "type2", "1", "foo", "bar");
            .startObject("properties")
        titles.add("Coronal mass ejection");
        searchSuggest = searchSuggest("Sir Bedever the Wife Sir Bedever the Wife Sir Bedever the Wife", "simple_phrase", phraseSuggest);
        ensureGreen();
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        titles.add("Hause"); // The last name or the German word, whichever.
        assertAcked(prepareCreate("test").setMapping(mapping));
            .endObject();
        termsAndDocCount.put("prefix_abbb", 18);
            titles.add(c + " United");
        );
        PhraseSuggestionBuilder phraseSuggestion = phraseSuggestion("bigram").realWordErrorLikelihood(0.95f)
        assertThat(suggest.getSuggestion("test").getEntries().get(0).getText().string(), equalTo("abcd"));
            equalTo("<em>arthur</em> king of the <em>britons</em>")
                .put("index.analysis.filter.shingler.min_shingle_size", 2)
        // test phrase suggestion on completely empty index
        return actionGet.getSuggest();
        assertThat("didn't ask for suggestions but got some", search.getSuggest(), nullValue());
 * this work for additional information regarding copyright
            "prefix_aaca",
        // use SuggestMode.ALWAYS, otherwise the results can vary between requests.
        Collections.addAll(phrases, "nobel prize", "noble gases", "somethingelse prize", "pride and joy", "notes are fun");
        String filterStringAsFilter = XContentFactory.jsonBuilder()
            phraseSuggestion("body").addCandidateGenerator(
                .put("index.analysis.filter.my_shingle.min_shingle_size", 2)
    @ParametersFactory
            titles.add("2006 " + c);
    public void testEmptyShards() throws IOException, InterruptedException {

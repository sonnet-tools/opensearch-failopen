        refresh();
    }
            .toString();
                anyOf(
        assertSuggestionSize(suggest, 0, 0, "test");
                .put("index.analysis.filter.my_shingle.output_unigrams", false)
            suggestBuilder.setGlobalText(suggestText);
    public static Collection<Object[]> parameters() {
        List<IndexRequestBuilder> builders = new ArrayList<>();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
            .field("type", "text")  
    }
        suggest = searchSuggest("test", termSuggest);
            .startObject()  
                anyOf(
                .put("index.analysis.filter.my_shingle.output_unigrams", false)
        }  
            .toString();
        List<String> titles = new ArrayList<>();  
        refresh();
     * Searching for a rare phrase shouldn't provide any suggestions if confidence &gt; 1.  This was possible before we rechecked the cutoff
            suggestBuilder.addSuggestion(suggestion.getKey(), suggestion.getValue());
            termSuggestion("field2").text("prefix_efgh").accuracy(1f).maxTermFreq(10).minDocFreq(0).suggestMode(SuggestMode.ALWAYS)
        index("test_1", "type1", "2", "text", "aa cd");
        // pass in a correct phrase - set confidence to 2
            "prefix_abbb",
            .field("analyzer", "suggest")
            client().prepareIndex("test").setSource("name", "I like iced tea"),  
        builders.add(client().prepareIndex("test").setSource("text", "appfle"));
public class SuggestSearchIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            .field("title", "{{suggestion}}")  
        List<IndexRequestBuilder> builders = new ArrayList<>();
        assertAcked(builder.setMapping(mapping));
            "hello word",
            .field("analyzer", "text")
        // Now some possessive
            phraseSuggestWithParams
    }
            assertRequestBuilderThrows(searchBuilder, SearchPhaseExecutionException.class);  
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
            assertRequestBuilderThrows(searchBuilder, SearchPhaseExecutionException.class);
                .put("index.analysis.filter.shingler.output_unigrams", true)
                    endsWith("Suggest entries have different sizes actual [2] expected [1]")
                .put("index.analysis.filter.shingler.max_shingle_size", 5)
                .putList("index.analysis.analyzer.bigram.filter", "my_shingle", "lowercase")  
        assertThat("didn't ask for suggestions but got some", search.getSuggest(), nullValue());
            ).size(1).confidence(1.0f)
        index("test", "typ1", "2", "field1", "prefix_aacd", "field2", "prefix_eeeh");
                                                                                                   // between requests.  
            )
                .maxTermFreq(10)
        index("test", "type2", "1", "name", "Just testing the suggestions api");
        // use SuggestMode.ALWAYS, otherwise the results can vary between requests.
        assertThat(suggest.getSuggestion("test").getEntries().get(0).getText().string(), equalTo("abcd"));  
        Suggest searchSuggest = searchSuggest("Frank's Wise", "simple_phrase", phraseSuggest);
        titles.add("Election");
        assertAcked(
                                                                                                   // between requests.
                .put("index.analysis.analyzer.bigram.tokenizer", "standard")
 * under the License.  
        }  
            .size(10);  
        }  
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");
            return Collections.singleton(TemplateScript.CONTEXT);
            titles.add("House " + c);  
        termsAndDocCount.put("prefix_addd", 10);
            "Police sergeant who stops the film", };  
    public void testWithMultipleCommands() throws Exception {
            .endObject()  
        // then good.  
            .endObject()  
    public void testSuggestAcrossMultipleIndices() throws IOException {  
        assertNoFailures(searchResponse);  
                .put(SETTING_NUMBER_OF_SHARDS, 1)  
        titles.add("State");
            prepareCreate("test").setMapping("body", "type=text,analyzer=stopwd")
            0,
        for (Entry<String, SuggestionBuilder<?>> suggestion : suggestions.entrySet()) {
            .field("analyzer", "body")
            }  
        }
        assertSuggestion(suggest, 0, "test", 5, "abc0");  
 * license agreements. See the NOTICE file distributed with
            // expected  
            "Sir Robin (Stand-in)",
        // The commented out assertions fail sometimes because suggestions are based off of shard frequencies instead of index frequencies.
        titles.add("Electron");  
        termsAndDocCount.put("prefix_aaca", 16);
import org.opensearch.index.IndexSettings;  
            .endObject();  
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(  
            .field("type", "text")  
        assertThat(Arrays.toString(actionGet.getShardFailures()), actionGet.getFailedShards(), equalTo(expectShardsFailed));  
        searchSuggest = searchSuggest(
            .endObject()
            .endObject()
            .startObject("properties")
     * @param field  
            "Knight Who Says Ni",
        refresh();
    public void testSuggestWithFieldAlias() throws Exception {
        assertSuggestionSize(suggest, 0, 0, "test");
            // expected
            .startObject("properties")
        line = "I got it this time";
import java.util.Map;  
        String filterStr = XContentFactory.jsonBuilder()
            .endObject()
            Settings.builder()
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
/**
        index("test", "type1", "2", "name", "An other title about equal length");
        }
    }
        XContentBuilder mappingBuilder = XContentFactory.jsonBuilder()
            .get();
        ensureGreen();
            searchBuilder.suggest(new SuggestBuilder().setGlobalText("tetsting sugestion").addSuggestion("did_you_mean", phraseSuggestion));
        } catch (SearchPhaseExecutionException ex) {  
        index("test", "type1", "3", "text", "abbd");  
            true,
            for (int i = 0; i < entry.getValue(); i++) {
            builders.add(client().prepareIndex("test").setSource("title", title));  
            phraseSuggestion("body").addCandidateGenerator(  
            .field("{{query_field}}", "{{suggestion}}")
            titles.add(c + " 2006");
        // suggest without collate  
            Settings.builder()  
            .endObject()  
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(
            phraseSuggestion("body").gramSize(1)
            .endObject()
                    .putList("index.analysis.analyzer.suggest.filter", "lowercase", "shingler")  
        refresh();  
            fail("Post filter error has been swallowed");
            .setSize(0)
        phraseSuggest.highlight("<em>", "</em>");  
        // united states house of representatives elections in washington 2006
                .put(IndexSettings.MAX_SHINGLE_DIFF_SETTING.getKey(), 4)
 */  
            .startObject("test")
        for (String title : titles) {
        index("test_2", "type1", "3", "text", "ab bd");
        );
    public void testBasicPhraseSuggest() throws IOException, URISyntaxException {
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(suggest.getSuggestion("test").getEntries().get(0).getText().string(), equalTo("abcd"));
    protected Suggest searchSuggest(String suggestText, int expectShardsFailed, Map<String, SuggestionBuilder<?>> suggestions) {
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");  
        // We're going to be searching for:  
        }  
        // which makes the collate code thinks mustache is evaluating the query.  
        PhraseSuggestionBuilder phraseSuggestion = phraseSuggestion("bigram").realWordErrorLikelihood(0.95f)
        // Now remove or add plural copies of every term we can
        }
            "prefix_abaa",
            SearchRequestBuilder searchBuilder = client().prepareSearch().setSize(0);
            .field("type", "alias")
        index("test", "type1", "1", "text", "bar");  
        Map<String, Object> params = new HashMap<>();
        index("test_2", "type1", "4", "text", "ab cc");
        XContentBuilder mapping = XContentFactory.jsonBuilder()  
        termSuggest = termSuggestion("text").suggestMode(SuggestMode.ALWAYS) // Always, otherwise the results can vary between requests.
            .endObject()
    }
        titles.add("Representative Government");  
        // The collate query setter is hard coded to use mustache, so lets lie in this test about the script plugin,
            new DirectCandidateGeneratorBuilder("title").suggestMode("always").maxTermFreq(.99f).size(10).maxInspections(200)
        phraseSuggest.smoothingModel(new Laplace(0.2));  
        assertAcked(prepareCreate("test").setMapping("text", "type=text"));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSuggestionSize;
        Suggest searchSuggest = searchSuggest("Xorr the Gut-Jewel", "simple_phrase", phraseSuggestion);  
        refresh();
        refresh();  
            .toString();  
import static org.opensearch.search.suggest.SuggestBuilders.termSuggestion;
            .field("{{field}}", "{{suggestion}}")
        index("test", "typ1", "1", "field1", "prefix_abcd", "field2", "prefix_efgh");  
    }
        } catch (OpenSearchException e) {
        }  
            .endObject()  
/*
        index("test_2", "type1", "4", "text", "abcc");  
            candidateGenerator("name").prefixLength(0).minWordLength(0).suggestMode("always").maxEdits(2)
                    .put(IndexSettings.MAX_SHINGLE_DIFF_SETTING.getKey(), 4)  
            .suggest(
        builders.add(client().prepareIndex("test").setSource("text", "mango"));
                .put("index.analysis.analyzer.suggest.tokenizer", "standard")  
import org.opensearch.script.ScriptContext;  
        builders.add(client().prepareIndex("test").setSource("text", "apple"));
        index("test", "type2", "4", "foo", "bar");
        @Override  
        titles.add("The Hoose-Gow");
            "united states house of representatives elections in washington 2006",
            .maxEdits(2);
        titles.add("United States House of Representatives Elections in Washington 1789");  
            titles.add(c + " States");
        refresh();  
        return searchSuggest(null, name, suggestion);
        titles.add("Statues of the Liberators");  
        Suggest suggest = searchResponse.getSuggest();
        index("test", "type2", "3", "foo", "bar");
        suggestions.put(
        searchSuggest = searchSuggest("Artur, King of the Britns", "simple_phrase", phraseSuggest);  
                .put(indexSettings())
            .endObject()
            filteredFilterSuggest  
            .smoothingModel(new StupidBackoff(0.1))  
            Settings.builder()
                .maxInspections(1000) // This too  
     *
            .endObject()  
                    .addSuggestion("did_you_mean", phraseSuggestion("name").maxErrors(5.0f))  
            .startObject("properties")
        );
        TermSuggestionBuilder termSuggestion = termSuggestion("text").suggestMode(SuggestMode.ALWAYS) // Always, otherwise the results can  
            .field("analyzer", "bigram")  
                .putList("index.analysis.analyzer.body.filter", "lowercase")  
        Suggest searchSuggest = searchSuggest(
            "size10SortFrequencyFirst",  
            .startObject()  
            .get();
        index("test", "type1", "1", "name", "Just testing the suggestions api");
        // suggest with collate
        phraseSuggestion.clearCandidateGenerators()
            .startObject()
            fail(" can not suggest across multiple indices with different analysis chains");
            "prefix_dbca",
                new SuggestBuilder().setGlobalText("tetsting sugestion")
    }  
        index("test_1", "type1", "4", "text", "ab cc");  
import java.util.Collections;  
            .startObject("match_phrase")
        );  
                    .put("index.analysis.analyzer.suggest.tokenizer", "standard")
        );  
                .put(SETTING_NUMBER_OF_SHARDS, 1) // A single shard will help to keep the tests repeatable.
            .endObject()
 * SPDX-License-Identifier: Apache-2.0
                .put("index.analysis.analyzer.body.tokenizer", "standard")  
                .put(indexSettings())
            titles.add("Washington " + c + ". Lastname");
        phraseSuggest.confidence(2f);
    }
            .startObject("body")
 * request, modify again, request again, etc.  This makes it very obvious what changes between requests.
        index("test", "type1", "2", "body", "hello world");
        OpenSearchAssertions.assertSuggestion(searchResponse.getSuggest(), 0, 0, "did_you_mean", "testing suggestions");  
        assertThat(suggest.getSuggestion("did_you_mean").getEntries().get(0).getText().string(), equalTo("tetsting sugestion"));
        assertSuggestionSize(searchSuggest, 0, 0, "simple_phrase");
                }
        ensureGreen();
            equalTo("Sir Bedever the Wife Sir Bedever the Wife Sir Bedever the Wife")
        assertAcked(builder.setMapping(mapping));
            .endObject()
        );
        );
            .startObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSuggestionPhraseCollateMatchExists;  
            "Miss Islington, the Witch",
        assertSuggestion(suggest, 0, "test", "aacd", "abbd", "abcc");
            .endObject()
            searchSuggest("test", termSuggest);
        } catch (OpenSearchException e) {
        Map<String, Integer> termsAndDocCount = new HashMap<>();
                .putList("index.analysis.analyzer.biword.filter", "shingler", "lowercase")  
                .put(SETTING_NUMBER_OF_SHARDS, 1)
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(  
        int chafPerShard = 100;
        assertSuggestion(searchSuggest, 0, "simple_phrase", "xorr the god jewel");  
            .field("type", "text")
        PhraseSuggestionBuilder phraseSuggestion = phraseSuggestion("name.shingled").addCandidateGenerator(  
            searchSuggest.getSuggestion("simple_phrase").getEntries().get(0).getOptions().get(0).getHighlighted().string(),
        index("test", "type1", "3", "text", "abbd");  
            .endObject()
    // see #3196
        ensureGreen();
 *
        public ScriptEngine getScriptEngine(Settings settings, Collection<ScriptContext<?>> contexts) {
            .field("type", "text")
        public String getType() {
        ensureGreen();
            .toString();  
        assertSuggestionSize(searchSuggest, 0, 0, "title");
    protected Suggest searchSuggest(String suggestText, String name, SuggestionBuilder<?> suggestion) {
            .field("type", "text")
                new SuggestBuilder().setGlobalText("tetsting sugestion")
        }  
        refresh();
            ).size(1).confidence(1.0f)
        map.put(name, suggestion);  
        searchSuggest = searchSuggest(  
        searchSuggest = searchSuggest("Elections of Representatives Parliament", "title", filteredQuerySuggest);  
        builders.add(client().prepareIndex("test").setSource("text", "apple"));
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");
    public void testSizeParam() throws IOException {
        ensureGreen();
            "foobar",
        titles.add("UNITAS");  
        ensureGreen();  
            .endObject()  
        Suggest suggest = searchSuggest("test", termSuggest);
        Suggest suggest = searchSuggest("test", termSuggestion);
                .put("index.analysis.filter.shingler.max_shingle_size", 3)
        Suggest suggest = searchSuggest("test", termSuggest);  
        titles.add("Hooser");
            .endObject()
     *            the field this candidate generator operates on.
        assertSuggestion(searchSuggest, 0, "simple_phrase", "sir bedevere the wise sir bedevere the wise sir bedevere the wise");  
                .put("index.analysis.filter.shingler.min_shingle_size", 2)
        XContentBuilder mapping = XContentFactory.jsonBuilder()  
        termsAndDocCount.put("prefix_abaa", 8);
                    endsWith("Suggest entries have different sizes actual [1] expected [2]"),
        assertThat(suggest.getSuggestion("test").getEntries().get(0).getText().string(), equalTo("abcd"));
            index("test", "type1", line, "body", line, "bigram", line);
            "simple_phrase",
        );
            .minWordLength(1);
            titles.add("States " + c);
            termSuggestion("field1").size(10).sort(SortBy.FREQUENCY).shardSize(1000).minDocFreq(0).suggestMode(SuggestMode.ALWAYS)
            .field("type", "text")
        Map<String, SuggestionBuilder<?>> suggestions = new HashMap<>();  
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");  
        searchSuggest = searchSuggest("Arthur, King of the Britons", "simple_phrase", phraseSuggest);
            .field("type", "text")
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        searchSuggest = searchSuggest("ice tea", "did_you_mean", phraseSuggestion);
        ensureGreen();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            .endObject()  
        assertAcked(prepareCreate("test").setMapping("text", "type=text"));
                    endsWith("Suggest entries have different sizes actual [1] expected [2]"),  
        refresh();  
 * specific language governing permissions and limitations
        @Override
    /**  
            termSuggestion("field1").maxEdits(1).size(10).minDocFreq(0).suggestMode(SuggestMode.ALWAYS)  
        }
            .endObject()  
            .startObject("title")
            .startObject("alias")  
    private DirectCandidateGeneratorBuilder candidateGenerator(String field) {  
    }  
            "Sir Bedevere the Wise",  
            prepareCreate("test").setSettings(  
            phrases.add("noble somethingelse" + i);
        searchSuggest = searchSuggest("Artur, Kinh of the Britons", "simple_phrase", phraseSuggest);  
        );  
            builders.add(client().prepareIndex("test").setSource("title", title));
    }  
        // And other stuff
        }
        titles.add("Representative Government");
            phraseSuggestWithParamsAndReturn  
        assertAcked(builder.setMapping(mapping));
                .put("index.analysis.analyzer.biword.tokenizer", "standard")
                anyOf(
            .field("analyzer", "body")
        }  
        NumShards numShards = getNumShards("test");  
import org.opensearch.search.suggest.phrase.Laplace;
        termsAndDocCount.put("prefix_dbca", 6);  
                candidateGenerator("body").minWordLength(1).prefixLength(1).suggestMode("always").size(2).accuracy(0.1f)  
        }
        SuggestBuilder suggestBuilder = new SuggestBuilder();  
        );
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
        index("test_1", "type1", "3", "text", "ab bd");
        }
            "Old Crone",
    public void testEmpty() throws Exception {
        params.put("query_field", "title");
            searchSuggest("united states house of representatives elections in washington 2006", numShards.numPrimaries, namedSuggestion);  
        indexRandom(true, false, builders);  
        index("test_2", "type1", "1", "text", "ab cd");
            "title",
            .minWordLength(1);
        assertSuggestion(searchSuggest, 0, "simple_phrase", "hello world");
            .endObject()
            .startObject("name")  
        );
            .toString();
        XContentBuilder mapping = XContentFactory.jsonBuilder()
import static org.hamcrest.Matchers.nullValue;  
            .field("analyzer", "keyword")
        phraseSuggest = phraseSuggestion("text").text("appple")  
        // try all smoothing methods
        phraseSuggest.smoothingModel(new LinearInterpolation(0, 1, 0));
            .field("type", "text")
            equalTo("<em>arthur</em> king of the <em>britons</em>")
            "accuracy",  
            .smoothingModel(new LinearInterpolation(1, 0, 0));
        XContentBuilder mapping = XContentFactory.jsonBuilder()  
                .put("index.analysis.filter.my_shingle.type", "shingle")  
        );  
        refresh();
import org.opensearch.search.suggest.term.TermSuggestionBuilder.SuggestMode;  
            fail("Malformed query (lack of additional params) should fail");
        SearchResponse actionGet = builder.get();
        builders.add(client().prepareIndex("test").setSource("text", "papaya"));
                ex.getCause().getMessage(),
        assertSuggestion(suggest, 0, "test", "aacd", "abbd", "abcc");  
            .endObject();  
            .field("analyzer", "text")  
        titles.add("Staples");
            "Patsy, Arthur's Servant",
            .startObject("pprefix")
import static org.hamcrest.Matchers.instanceOf;
    public void testSizeOneShard() throws Exception {
        titles.add("Media organizations housed within colleges");
 *  
    }
                    .put("index.analysis.filter.shingler.output_unigrams", true)
        termsAndDocCount.put("prefix_abbb", 18);  
            .startObject()  
            .endObject();
                .putList("index.analysis.analyzer.body.filter", "lowercase", "my_shingle")
import org.opensearch.action.index.IndexRequestBuilder;
        Suggest searchSuggest = searchSuggest("ice tea", "did_you_mean", phraseSuggestion);  
            "Dr. Piglet",
        assertSuggestion(searchSuggest, 0, "did_you_mean", "iced tea");
            .text("abcd")
                .put("index.analysis.filter.my_shingle.max_shingle_size", 3)  
        for (int year = 1790; year < 2014; year += 2) {
        // When searching on a shard which does not hold yet any document of an existing type, we should not fail  
        }  
        NumShards test = getNumShards("test");
        titles.add("Watlington"); // Ditto
        }
        // collate script with additional params
        titles.add("State");
        for (String line : strings) {
        );
        if (suggestText != null) {
            candidateGenerator("title").suggestMode("always")  
            );
            "Zoot",  
 * this file be licensed under the Apache-2.0 license or a
        assertSuggestionPhraseCollateMatchExists(searchSuggest, "title", 2);  
            .field("analyzer", "biword")
            .endObject()
        searchSuggest = searchSuggest("Artur, King of the Britns", "simple_phrase", phraseSuggest);
                .minDocFreq(0)
            true,
        namedSuggestion.put("my_title_suggestion", incorrectFilteredSuggest);  
import org.opensearch.core.xcontent.XContentBuilder;
        Suggest searchSuggest = searchSuggest("united states house of representatives elections in washington 2006", "title", suggest);
            .field("analyzer", "bigram")  
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(
            );  
            .startObject("name")
    public void testStopwordsOnlyPhraseSuggest() throws IOException {  
            titles.add("List of former members of the United States House of Representatives (" + c + ")");
                throw new UnsupportedOperationException();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            .endObject()  
            .suggest(  
    public void testDifferentShardSize() throws Exception {  
        suggestions.put("size3SortScoreFirst", termSuggestion("field1").size(3).minDocFreq(0).suggestMode(SuggestMode.ALWAYS));
        public static final String NAME = "mustache";
            .setSize(0)
        ensureGreen();
            titles.add("United States House of Representatives Elections in Washington " + year);
            .startObject("properties")  
        titles.add("Wasington"); // A film?
        PhraseSuggestionBuilder phraseSuggestion = phraseSuggestion("name.shingled").addCandidateGenerator(generator).gramSize(3);  
            index("test", "type1", Integer.toString(i), "text", "abc" + i);
 * Licensed to Elasticsearch under one or more contributor  
                new SuggestBuilder().setGlobalText("tetsting sugestion")
 * Unless required by applicable law or agreed to in writing,
        assertAcked(builder.setMapping(mapping));
            .field("search_analyzer", "standard")  
        createIndex("test");
        ensureGreen();
        assertThat(suggest.getSuggestion("test").getEntries().get(0).getText().string(), equalTo("abcd"));
        String[] strings = new String[] {
                candidateGenerator("body").minWordLength(1).suggestMode("always").maxTermFreq(.99f)  
import java.util.HashMap;
        assertSuggestionSize(suggest, 0, 0, "did_you_mean");  
import java.util.Set;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            .endObject()
 * software distributed under the License is distributed on an
        index("test", "type2", "2", "name", "An other title about equal length");
            .endObject()
        // distribute mass
                    .addSuggestion("did_you_mean", phraseSuggestion("name").maxErrors(5.0f))
        titles.add("Unicef");
        refresh();
            .endObject()
        for (char c = 'A'; c <= 'Z'; c++) {
            .startObject("text")
                .put("index.analysis.filter.my_shingle.min_shingle_size", 2)  
                .put("index.analysis.analyzer.text.tokenizer", "standard")
            .field("type", "text")
 * GitHub history for details.
            client().prepareIndex("test").setId("2").setSource("field1", "foobar2").setRouting("2"),  
        assertThat(
        titles.add("Un-Led-Ed");
                .prefixLength(1)  
            .startObject("properties")
                .put("index.analysis.filter.my_shingle.min_shingle_size", 2)
        titles.add("Stated Income Tax");
            .addCandidateGenerator(new DirectCandidateGeneratorBuilder("text").suggestMode("popular").minDocFreq(2));
            titles.add(Integer.toString(year));  
        assertSuggestion(suggest, 1, "field2", "prefix_eeeh", "prefix_efff", "prefix_eggg");
                )
        suggestions.put(
import org.opensearch.common.settings.Settings;  
        titles.add("Electors");
import org.opensearch.plugins.ScriptPlugin;
        indexRandom(
            "size1",
            .text("abcd");
        String incorrectFilterString = XContentFactory.jsonBuilder()  
        );  
            .field("type", "text")  
        assertAcked(prepareCreate("test").setMapping("field1", "type=text", "field2", "type=text"));  
            .field("type", "text")
        List<IndexRequestBuilder> builders = new ArrayList<>();
    }  
            .maxErrors(1.0f)
            .addCandidateGenerator(candidateGenerator("body").minWordLength(1).prefixLength(1).suggestMode("always").size(1).accuracy(0.1f))
        // collate suggest with no result (boundary case)
 * this work for additional information regarding copyright
            .startObject("text")  
     */  
        assertSuggestionSize(suggest, 0, 0, "accuracy");  
            // Lots of people are named Washington <Middle Initial>. LastName  
import org.opensearch.action.search.SearchPhaseExecutionException;  
        assertNoFailures(searchResponse);  
    public void testShardFailures() throws IOException, InterruptedException {
            .endObject();
            titles.add("2006 " + c);
            .endObject()
                .put("index.analysis.filter.my_shingle.max_shingle_size", 2)
            "prefix_aacd"
        Suggest suggest = searchSuggest(
        Suggest searchSuggest = searchSuggest(
 * not use this file except in compliance with the License.
        }
            .text("ab cd")  
        public <T> T compile(String scriptName, String scriptSource, ScriptContext<T> context, Map<String, String> params) {  
                .put("index.analysis.filter.my_shingle.type", "shingle")
        suggest = searchResponse.getSuggest();
            )  
            .endObject()
        assertSuggestionSize(searchSuggest, 0, 0, "simple_phrase");
        // When searching on a shard with a non existing mapping, we should fail  
        index("test", "type1", "12", "foo", "bar");  
        assertThat(suggest.getSuggestion("did_you_mean").getEntries().get(0).getText().string(), equalTo("tetsting sugestion"));  
        assertAcked(builder.setMapping(mapping));
            .startObject()
    public SuggestSearchIT(Settings settings) {
                    .addSuggestion("did_you_mean", phraseSuggestion("name").maxErrors(5.0f))
            .get();
 */  
        ).confidence(0f).maxErrors(2f).shardSize(30000).size(30000);
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");
        // suggest with collation
                .putList("index.analysis.analyzer.text.filter", "lowercase", "my_shingle")
        builders.add(client().prepareIndex("test").setSource("text", "apple"));  
                .put(indexSettings())
import java.util.ArrayList;  
import java.util.Arrays;
                .put("index.analysis.filter.my_shingle.min_shingle_size", 2)  
        ).gramSize(3);
            .startObject("properties")
                    public String execute() {  
        titles.add("Howse Peak");  
import org.opensearch.plugins.Plugin;
    }
        try {
    }
        logger.info("--> run suggestions with three indices");  
            "noble prize",  
            .addCandidateGenerator(candidateGenerator("body").minWordLength(1).suggestMode("always"))
        ).confidence(0f).maxErrors(2f).shardSize(30000).size(10);  
import java.net.URISyntaxException;
        searchSuggest = searchSuggest("Arthur, King of the Britons", "simple_phrase", phraseSuggest);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
        }  
                candidateGenerator("body").prefixLength(4).minWordLength(1).suggestMode("always")
    public static class DummyTemplatePlugin extends Plugin implements ScriptPlugin {
    }
            .field("title", "{{suggestion}}")
                .put("index.analysis.analyzer.body.tokenizer", "standard")
                .put("index.analysis.filter.my_shingle.max_shingle_size", 2)
        index("test", "type1", "1", "name", "I like iced tea");  
            .endObject()
            "simple_phrase",
import org.opensearch.script.TemplateScript;
            "title",
            assertThat(
        titles.add("Unified Modeling Language");
            .minWordLength(0)  
        searchResponse = client().prepareSearch()
        // set all mass to trigrams (not indexed)
            .endObject();
            titles.add(c + " Elections");  
                .put("index.analysis.analyzer.bigram.tokenizer", "standard")
/*  
        phraseSuggest = phraseSuggestion("text").text("appple")  
        assertThat(suggest.getSuggestion("test").getEntries().get(0).getText().string(), equalTo("abcd"));
            .collateParams(params)
            .minWordLength(1);
        index("test", "type1", "1", "text", "abcd");
        );
        index("test_1", "type1", "1", "text", "ab cd");  
            .startObject("properties")
        List<String> titles = new ArrayList<>();
            .field("path", "text")
        assertAcked(prepareCreate("test_2").setMapping(mapping));
            "Sir Galahad the Pure",
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
        PhraseSuggestionBuilder phraseSuggest = phraseSuggestion("text").text("appple")
        return Collections.singleton(DummyTemplatePlugin.class);
            .text("ABCD")  
            .addCandidateGenerator(candidateGenerator("body").minWordLength(1).suggestMode("always"))
                    .put("index.analysis.filter.shingler.min_shingle_size", 2)
        assertThat(suggest.getSuggestion("test").getEntries().get(0).getText().string(), equalTo("abcd"));
        index("test", "type1", "3", "body", "hello words");  
        suggest = searchSuggest("test", termSuggest);
            .startObject()
 * The OpenSearch Contributors require contributions made to  
                .put("index.analysis.analyzer.body.tokenizer", "standard")  
        OpenSearchAssertions.assertSuggestionSize(suggest, 0, 3, "simple");  
        );
        assertSuggestionSize(searchSuggest, 0, 25480, "title");  // Just to prove that we've run through a ton of options
                .put("index.analysis.filter.shingler.type", "shingle")
        refresh();
        assertSuggestion(suggest, 0, "test", 10, "abc0");
        termsAndDocCount.put("prefix_abcc", 1);  
        assertSuggestionSize(suggest, 0, 0, "test");  
        searchSuggest = searchSuggest("Artur, King of the Britns", "simple_phrase", phraseSuggest);
            "field2",
            .startObject("fields")
            phraseSuggestion("body").addCandidateGenerator(
        TermSuggestionBuilder termSuggest = termSuggestion("alias").text("appple");
        phraseSuggest.confidence(0.99f);
        SearchRequestBuilder request = client().prepareSearch()
        PhraseSuggestionBuilder suggest = phraseSuggestion("title").addCandidateGenerator(
            .endObject();
        for (String title : titles) {
        searchSuggest = searchSuggest("united states house of representatives elections in washington 2006", "title", suggest);
            .endObject()  
            "size10SortScoreFirst",
            fail("Post query error has been swallowed");  
        assertSuggestion(searchSuggest, 0, "simple_phrase", "frank's wife");
        // Tons of different options very near the exact query term
        phraseSuggest.highlight(null, null).confidence(0f).size(1).maxErrors(0.5f);  
                };  
        searchSuggest = searchSuggest(  
        logger.info("--> run suggestions with one index");
                .put("index.analysis.filter.my_shingle.min_shingle_size", 2)  
            // Lets just add some more to be evil  
        public Set<ScriptContext<?>> getSupportedContexts() {  
            .field("type", "keyword")
        titles.add("Hause"); // The last name or the German word, whichever.  
        assertSuggestion(suggest, 0, "size10SortScoreFirst", 10, "prefix_aacd", "prefix_abcc", "prefix_accd" /*, "prefix_aaad" */);
import static org.hamcrest.Matchers.anyOf;
 * Integration tests for term and phrase suggestions.  Many of these tests many requests that vary only slightly from one another.  Where  
        } catch (OpenSearchException e) {  
        // check tokenLimit
        TermSuggestionBuilder termSuggest = termSuggestion("text").suggestMode(SuggestMode.ALWAYS).text("abcd");
        index("test", "type1", "1", "body", line, "bigram", line);  
            .field("analyzer", "bigram")
        logger.info("--> run suggestions with four indices");
        index("test_2", "type1", "2", "text", "aacd");
        // pass in a correct phrase - set confidence to 0.99  
import org.opensearch.search.suggest.phrase.StupidBackoff;
        titles.add("Staten Island");
        assertAcked(
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        index("test", "type1", "1", "body", "hello world");
        }
    }  
    }  
        // since 0. Why not?
        index("test", "type1", "2", "name", "I like tea.");
        termSuggest = termSuggestion("text").suggestMode(SuggestMode.ALWAYS) // Always, otherwise the results can vary between requests.
                )
        assertSuggestionSize(searchSuggest, 0, 2, "title");  
        ensureGreen();
        // collate suggest with bad query
            .endObject()
            assertThat(
        Map<String, SuggestionBuilder<?>> suggestions = new HashMap<>();
        // assertThat(suggest.get(3).getSuggestedWords().get("prefix_abcd").get(4).getTerm(), equalTo("prefix_abcc"));
        Map<String, SuggestionBuilder<?>> map = new HashMap<>();
        PhraseSuggestionBuilder filteredQuerySuggest = suggest.collateQuery(filterString);  
        indexRandom(true, builders);
        assertSuggestion(searchSuggest, 0, 0, "title", "united states house of representatives elections in washington 2006");  
        // Six of these are near enough to be viable suggestions, just not the top one
            .field("type", "text")
        assertSuggestion(  
            .text("abcd");
            .field("type", "keyword")
    }
        assertSuggestion(searchSuggest, 0, "suggestion", 1, "apple");
            .startObject("properties")
        // we allow a size of 2 now on the shard generator level so "god" will be found since it's LD2  
        assertSuggestion(searchSuggest, 0, "suggestion", "apple");
            .startObject("title")  
import org.opensearch.test.hamcrest.OpenSearchAssertions;
            .endObject()  
            "Sir Robin the Not-Quite-So-Brave-as-Sir-Lancelot",
            .field("analyzer", "body")
        // If there isn't enough chaf per shard then shards can become unbalanced, making the cutoff recheck this is testing do more harm
        try {
    public void testSuggestModes() throws IOException {  
            phrases.add("chaff" + i);
        searchSuggest = searchSuggest("suggestion", phraseSuggest);
            .endObject()
        assertSuggestion(searchSuggest, 0, "simple_phrase", "frank's wife");
/*  
            "simple_phrase",  
    @ParametersFactory  
        Suggest suggest = searchSuggest("test", termSuggest);  
        Suggest searchSuggest = searchSuggest("suggestion", termSuggest);
            .endObject()
import java.util.List;
                .put("index.analysis.analyzer.body.tokenizer", "standard")  
        suggestions.put(
import java.util.Collection;
        Suggest searchSuggest = searchSuggest("united states house of representatives elections in washington 2006", "title", suggest);
        // collate query request with prune set to true
        SearchResponse search = client().prepareSearch().setQuery(matchQuery("text", "spellcecker")).get();
        // pass in a correct phrase
        assertRequestBuilderThrows(request, SearchPhaseExecutionException.class);
        return new DirectCandidateGeneratorBuilder(field);
        TermSuggestionBuilder termSuggest = termSuggestion("text").suggestMode(SuggestMode.ALWAYS) // Always, otherwise the results can vary
            "prefix_addd",  
        assertAcked(prepareCreate("test_1").setMapping("text", "type=text"));  
            "simple_phrase",
     */
        termsAndDocCount.put("prefix_aacd", 1);
                .addCandidateGenerator(candidateGenerator("body").minWordLength(1).suggestMode("always"))
        index("test", "type1", "1", "text", "bar");
        // test phrase suggestion but nothing matches
        titles.add("Statens Museum for Kunst");
            "size3SortScoreFirstMaxEdits1",
                Settings.builder()
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(  
        // collate script failure due to no additional params  
                        .put("index.analysis.analyzer.stopwd.tokenizer", "standard")
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put("index.number_of_shards", 1).build()).setMapping(mapping));
        try {
                .put("index.analysis.filter.my_shingle.type", "shingle")
import java.io.IOException;
            termSuggestion("field1").size(10).minDocFreq(0).suggestMode(SuggestMode.ALWAYS)
                .put("index.analysis.filter.my_shingle.min_shingle_size", 2)
        termsAndDocCount.put("prefix_accc", 12);  
    // see #3037
            .text("abcd");  
            .startObject()
        searchSuggest = searchSuggest("Xorr the Gut-Jewel", "simple_phrase", phraseSuggestion);
        termsAndDocCount.put("prefix_cbad", 4);
        index("test_2", "type1", "1", "text", "abcd");  
            // Can't forget lists, glorious lists!  
                    .put(indexSettings())
        Suggest suggest = searchSuggest("prefix_abcd", 0, suggestions);  
        // But we can't stop there! Titles that are just a year are pretty common so lets just add one per year  
            .setSize(0)  
            phraseSuggestion("body").addCandidateGenerator(  
                .put("index.number_of_shards", 1)
        Suggest searchSuggest = searchSuggest("ice tea", "did_you_mean", phraseSuggestion);
                .put("index.analysis.filter.shingler.type", "shingle")
        index("test", "typ1", "3", "field1", "prefix_abbd", "field2", "prefix_efff");
                .putList("index.analysis.analyzer.suggest.filter", "lowercase", "shingler")
        assertThat(  
    public void testEmptyShards() throws IOException, InterruptedException {
                String result = script;  
        index("test", "type1", "3", "name", "I like ice cream.");
    // see #2729
                .put("index.analysis.filter.shingler.min_shingle_size", 2)
        index("test", "type1", "11", "foo", "bar");
                .put("index.analysis.analyzer.bigram.tokenizer", "standard")
            .gramSize(2)  
        titles.add("Skates");
            searchSuggest.getSuggestion("simple_phrase").getEntries().get(0).getText().string(),  
                    .put("index.analysis.filter.shingler.max_shingle_size", 5)  
            "prefix_accc",
                .put("index.analysis.filter.my_shingle.type", "shingle")
                .put("index.analysis.filter.my_shingle.output_unigrams", true)  
            .addCandidateGenerator(new DirectCandidateGeneratorBuilder("text").suggestMode("popular"));
        try {  
        for (int i = 0; i < test.numPrimaries * chafPerShard; i++) {  
        termsAndDocCount.put("prefix_accd", 1);
            termSuggestion("field2").text("prefix_eeeh prefix_efgh").maxTermFreq(10).minDocFreq(0).suggestMode(SuggestMode.ALWAYS)  
            .startObject("{{query_type}}")  
            .get();
        index("test", "type2", "5", "foo", "bar");  
        assertAcked(builder.setMapping(mapping));  
        assertThat("didn't ask for suggestions but got some", search.getSuggest(), nullValue());  
        titles.add("Untied shoelaces");
        refresh();
            .startObject("bigram")
            "simple",  
            candidateGenerator("name").prefixLength(0).minWordLength(0).suggestMode("always").maxEdits(2)
            .field("search_analyzer", "standard")
        }
            .startObject("body")  
                .setSettings(  
                    .addSuggestion("did_you_mean", phraseSuggestion("fielddoesnotexist").maxErrors(5.0f))
        suggest.size(1);  
        searchSuggest = searchSuggest("Frank's Wise", "simple_phrase", phraseSuggest);
    }
        PhraseSuggestionBuilder phraseSuggest = phraseSuggestion("bigram").gramSize(2)  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        phraseSuggest.realWordErrorLikelihood(0.95f);
                    .put("index.refresh_interval", -1)  // prevents occasional scoring glitches due to multi segments
        phraseSuggest.tokenLimit(15).smoothingModel(new StupidBackoff(0.1));
        titles.add("Warrington"); // A town in England
        String filterString = XContentFactory.jsonBuilder()
            .startObject("shingled")  
            SearchRequestBuilder searchBuilder = client().prepareSearch().setSize(0);  
        ensureGreen();
    }
                .put(indexSettings())
            .startObject("bigram")
        searchSuggest = searchSuggest("suggestion", phraseSuggest);  
        ensureGreen();
        // Check the name this time because we're repeating it which is funky
        );
                index("test", "type1", entry.getKey() + i, "field1", entry.getKey());
            .suggest(  
            "prefix_aaad",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");  
        // Note that the last document has to have about the same length as the other or cutoff rechecking will remove the useful suggestion  
        assertSuggestion(suggest, 0, "size3SortScoreFirstMaxEdits1", "prefix_aacd", "prefix_abcc", "prefix_accd");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .endObject()
        index("test_2", "type1", "3", "text", "abbd");
        titles.add("Waddington"); // Lots of places have this name  
            client().prepareIndex("test").setId("1").setSource("field1", "foobar1").setRouting("1"),
            );
                .putList("index.analysis.analyzer.text.filter", "lowercase", "my_shingle")  
        searchSuggest = searchSuggest("Artur, King of the Britns", "simple_phrase", phraseSuggest);  
            searchSuggest("united states house of representatives elections in washington 2006", numShards.numPrimaries, namedSuggestion);
        );
        assertAcked(builder.setMapping(mapping));
            .field("analyzer", "suggest")
            .startObject()
    // see #2817
            .startObject("fields")  
                .put("index.analysis.analyzer.text.tokenizer", "standard")
                .put(indexSettings())  
        titles.add("Jalan Uniten–Dengkil"); // Highway in Malaysia
        titles.add("Washington's Birthday");
            return new DummyTemplateScriptEngine();
        ensureGreen();
        searchSuggest = searchSuggest("Artur, King of the Britns", "simple_phrase", phraseSuggest);
            .endObject()  
import static org.hamcrest.Matchers.equalTo;
                .maxTermFreq(.99f)
        } catch (SearchPhaseExecutionException ex) {
        indexRandomForConcurrentSearch("test");  
            .startObject("name")
        } catch (IllegalStateException ex) {
                new SuggestBuilder().setGlobalText("tetsting sugestion")
    @Override  
        Map<String, SuggestionBuilder<?>> namedSuggestion = new HashMap<>();
                candidateGenerator("body").minWordLength(1).suggestMode("always").maxTermFreq(.99f)  
        titles.add("UNITER");
            searchSuggest.getSuggestion("simple_phrase").getEntries().get(0).getText().string(),
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(
            .endObject();
                .putList("index.analysis.analyzer.bigram.filter", "my_shingle", "lowercase")  
        // assertThat(suggest.get(3).getSuggestedWords().get("prefix_abcd").get(4).getTerm(), equalTo("prefix_accd"));
        searchSuggest("test", termSuggest);  
            "prefix_abba",
        assertSuggestion(suggest, 0, 0, "did_you_mean", "testing suggestions");  
                .putList("index.analysis.analyzer.body.filter", "lowercase")
        assertSuggestionSize(searchSuggest, 0, 0, "simple_phrase");  
                    endsWith("Suggest entries have different text actual [abcd] expected [ABCD]")  
        titles.add("Unit circle");  
            .startObject("properties")  
 */
                ex.getMessage(),  
            )  
        titles.add("Evictions");
                .size(1000) // Setting a silly high size helps of generate a larger list of candidates for testing.
        index("test", "typ1", "1", "body", "this is a test");
            .size(2)  
        );  
        builder.suggest(suggestBuilder);
        indexRandom(  
        // Ask for highlighting
            "Dr. Winston",  
    public void testEmptyIndex() throws Exception {  
                .size(1)  
        prepareCreate("test").setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0)).get();  
                                                                                                      // vary between requests.
        }  
        assertAcked(builder.setMapping(mapping));
            .startObject()
            .startObject("body")  
        @Override  
            assertThat(  
        );  
    public void testSearchForRarePhrase() throws IOException {
        assertAcked(prepareCreate("test").setMapping(mapping));  
            .startObject("text")  
            suggest,
 *    http://www.apache.org/licenses/LICENSE-2.0
        PhraseSuggestionBuilder phraseSuggestWithParams = suggest.collateQuery(collateWithParams).collateParams(params);  
        // Check the "text" field this one time.
            };
        titles.add("Waplington"); // Yup, also a town
        refresh();
        assertSuggestion(suggest, 0, "field2", "prefix_efgh");  
            .startObject("properties")  
        titles.add("Election");
        );
        );  
                    endsWith("Suggest entries have different text actual [abcd] expected [ABCD]")
import org.opensearch.action.search.SearchRequestBuilder;
            .field("type", "text")  
            .setSize(0)
        }
        refresh();
        super(settings);  
                .put("index.analysis.filter.my_shingle.max_shingle_size", 2)
        return searchSuggest(suggestText, 0, map);
    public void testPhraseSuggestMinDocFreq() throws Exception {
        searchSuggest = searchSuggest("united states house of representatives elections in washington 2006", "title", filteredQuerySuggest);
            "Sir Lancelot the Brave",  
            .startObject()  
        searchSuggest = searchSuggest(
        // finally indexing a document that will produce some meaningful suggestion  
            "Arthur, King of the Britons",
            Settings.builder()
        }
            }  
        titles.add("United States House of Representatives Elections in Washington 2006");
                .put("index.analysis.filter.shingler.max_shingle_size", 3)  
 * possible these tests should declare for the first request, make the request, modify the configuration for the next request, make that
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSuggestion;
        @Override
                )
        suggest = searchSuggest("test", termSuggestion);
                .put(SETTING_NUMBER_OF_SHARDS, 1)
        assertAcked(builder.setMapping(mapping));  
        assertSuggestionSize(searchSuggest, 0, 0, "simple_phrase");
        refresh();
import java.util.concurrent.ExecutionException;  
        assertSuggestionSize(searchSuggest, 0, 10, "title");
                String script = scriptSource;
        phraseSuggest.smoothingModel(new LinearInterpolation(0.4, 0.4, 0.2));
    }  
        assertNoFailures(searchResponse);
        filteredQuerySuggest.collateParams(Collections.singletonMap("field", "title"));
        assertSuggestionSize(searchSuggest, 0, 0, "did_you_mean");  
        index("test", "type1", "2", "text", "aacd");
            equalTo("Artur, Kinh of the Britons")
            termSuggestion("field1").size(1)  
                anyOf(  
        termsAndDocCount.put("prefix_aaad", 20);
 */  
            .size(5);
            assertThat(ex.getCause(), instanceOf(IllegalStateException.class));
            .endObject()
            );  
        assertSuggestion(searchSuggest, 0, 0, "title", "united states house of representatives elections in washington 2006");
            .startObject("body")
            .endObject();
                .put("index.analysis.filter.my_shingle.min_shingle_size", 2)
        for (String phrase : phrases) {  
 * KIND, either express or implied.  See the License for the
            .text("ab cd")
            "hello word",
    public void testSuggestWithManyCandidates() throws InterruptedException, ExecutionException, IOException {  
                    endsWith("Suggest entries have different sizes actual [2] expected [1]")  
        index("test", "typ1", "4", "field1", "prefix_abcc", "field2", "prefix_eggg");  
            .suggest(  
        createIndex("test");
        for (Entry<String, Integer> entry : termsAndDocCount.entrySet()) {  
        searchSuggest = searchSuggest("Artur, King of the Britns", "simple_phrase", phraseSuggest);
        assertThat(  
                .suggestMode(SuggestMode.ALWAYS)
            .setSize(0)
            .startObject()
        searchSuggest = searchSuggest("Artur, King of the Britns", "simple_phrase", phraseSuggest);
        titles.add("Unite Against Fascism");  
            "prefix_aaca",  
        refresh();
            .endObject()
            .analyzer("body")
            .endObject();
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");
}  
        titles.add("Hose");
    }
            "a an the",
        termSuggestion.text("abcd").shardSize(5);
            "Frank, the Historian",  
        for (int year = 0; year < 2015; year++) {
        XContentBuilder mapping = XContentFactory.jsonBuilder()  
        PhraseSuggestionBuilder suggest = phraseSuggestion("title").addCandidateGenerator(
    // see #3469  
            .startObject("bigram")
            .field("type", "text")
                    endsWith("Suggest entries have different text actual [ABCD] expected [abcd]"),
                .putList("index.analysis.analyzer.body.filter", "lowercase")
                .put("index.analysis.filter.my_shingle.max_shingle_size", 2)  
import org.opensearch.OpenSearchException;  
        assertSuggestion(suggest, 0, "size1", "prefix_aacd");
        titles.add("Hoses");
            .startObject("match_phrase")
            phraseSuggestion("body").addCandidateGenerator(
        phraseSuggest.clearCandidateGenerators()  
        TermSuggestionBuilder termSuggest = termSuggestion("text").suggestMode(SuggestMode.ALWAYS) // Always, otherwise the results can vary  
                    @Override
            .endObject()  
        TermSuggestionBuilder termSuggest = termSuggestion("text").suggestMode(SuggestMode.ALWAYS) // Always, otherwise the results can vary
        );
        ensureGreen();  
            "united states house of representatives elections in washington 2006",
        index("test", "type1", "4", "text", "abcc");
        index("test", "type1", "4", "text", "abcc");
        // But we need to make sure we generate a ton of suggestions so we add a bunch of candidates.
        );  
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(
        titles.add("STATS LLC");  
            .endObject()
        assertSuggestion(searchSuggest, 0, 0, "simple_phrase", "nobel prize");  
            .field("type", "text")  
            Settings.builder()
        return Arrays.asList(
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        XContentBuilder mapping = XContentFactory.jsonBuilder()  
        titles.add("Houses of Parliament");
                .put("index.analysis.filter.my_shingle.type", "shingle")  
        );  
        params.put("query_type", "match_phrase");  
        assertThat(suggest.getSuggestion("field2").getEntries().get(1).getText().string(), equalTo("prefix_efgh"));
    }  
        index("test", "type1", "2", "body", line, "bigram", line);
        // collate suggest with bad query
            return NAME;
        titles.add("Houses of Parliament");  
            .startObject("properties")
        );
            client().prepareIndex("test").setSource("name", "I like tea."),
 * compatible open source license.
        searchResponse = client().prepareSearch()
        // That ought to provide more less good candidates for the last term
    }
            ).setMapping(mappingBuilder)
        titles.add("Untitled");
        suggestions.put(
                .put("index.analysis.filter.my_shingle.max_shingle_size", 3)
        suggestions.put(
    public void testSizeAndSort() throws Exception {  
                for (Entry<String, Object> entry : p.entrySet()) {  
import static org.hamcrest.Matchers.endsWith;  
                .putList("index.analysis.analyzer.biword.filter", "shingler", "lowercase")
        assertSuggestionSize(searchSuggest, 0, 2, "title");
            Settings.builder()
        assertSuggestionSize(suggest, 0, 0, "test");
        } catch (IllegalStateException ex) {  
                )  
        suggest = searchResponse.getSuggest();
            assertThat(
import static org.opensearch.index.query.QueryBuilders.matchQuery;
            .suggestMode("always")
        suggest = searchSuggest("test", termSuggest);
            .endObject();  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            Settings.builder()
        // And some conjugation
        }  
            TemplateScript.Factory factory = p -> {
                .put("index.analysis.filter.shingler.type", "shingle")  
            .endObject();  
                        .putList("index.analysis.analyzer.stopwd.filter", "stop")  
            assertThat(ex.getCause(), instanceOf(IllegalStateException.class));
                new SuggestBuilder().setGlobalText("tetsting sugestion")
        searchSuggest = searchSuggest("Arthur, King of the Britons", "simple_phrase", phraseSuggest);  
                    script = script.replace("{{" + entry.getKey() + "}}", String.valueOf(entry.getValue()));
        );
        SearchResponse searchResponse = client().prepareSearch()
            .field("type", "text")
    /**  
        logger.info("--> run suggestions with two indices");
            .startObject("properties")
    public void testPrefixLength() throws IOException {
        List<IndexRequestBuilder> builders = new ArrayList<>();  
        termsAndDocCount.put("prefix_abba", 14);
        titles.add("Washing of the Spears"); // Book  
        assertThat(searchSuggest.getSuggestion("simple_phrase").getEntries().get(0).getText().string(), equalTo("Frank's Wise"));  
import org.opensearch.action.search.SearchResponse;
            client().prepareIndex("test").setSource("name", "I like ice cream.")
        {  
                .put("index.analysis.filter.my_shingle.output_unigrams", true)
            "Leader of Robin's Minstrels",
        indexRandom(true, false, builders);  
            .startObject("name")
    public void testPhraseSuggesterCollate() throws InterruptedException, ExecutionException, IOException {
    }
            "prefix_cbad",  
        );
            .field("analyzer", "body")  
        SearchRequestBuilder builder = client().prepareSearch().setSize(0);
        assertSuggestionSize(searchSuggest, 0, 10, "title");
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .size(1);  
            .endObject()
import java.util.Map.Entry;
        termSuggest = termSuggestion("text").suggestMode(SuggestMode.ALWAYS) // Always, otherwise the results can vary between requests.  
                    .addSuggestion("did_you_mean", phraseSuggestion("name").maxErrors(5.0f))
            );
        return actionGet.getSuggest();
        for (int i = 0; i < 8; i++) {  
        ensureGreen();  
            "size10SortFrequencyFirst",  
            "united states house of representatives elections in washington 2006",
        ensureGreen();  
        phraseSuggestion = phraseSuggestion("nosuchField").addCandidateGenerator(  
        index("test_2", "type1", "2", "text", "aa cd");  
        // set all mass to bigrams  
            .startObject()
     * Creates a new {@link DirectCandidateGeneratorBuilder}
        ).gramSize(3);
        titles.add("United States House of Representatives Elections in Washington 2005");  
        index("test", "type1", "1", "text", "abcd");
        assertSuggestionSize(suggest, 0, 0, "test");
            .endObject()  
        phraseSuggest.smoothingModel(new StupidBackoff(0.1));
        assertAcked(prepareCreate("test").setMapping("text", "type=text"));
                    Settings.builder()
            .field("title", "{{suggestion}}")  
            .startObject()
     * score during the reduce phase.  Failures don't occur every time - maybe two out of five tries but we don't repeat it to save time.
                .put("index.analysis.analyzer.biword.tokenizer", "standard")
        String collateWithParams = XContentFactory.jsonBuilder()
            return context.factoryClazz.cast(factory);
        Suggest suggest = searchSuggest(null, 0, suggestions);  
            .addCandidateGenerator(
        XContentBuilder mapping = XContentFactory.jsonBuilder()  
            ).confidence(2f).maxErrors(5f).size(1)
        phraseSuggest.smoothingModel(null).tokenLimit(4);  
            .endObject()
        assertSuggestionSize(searchSuggest, 0, 2, "title");  
            termSuggestion("field1").size(10).minDocFreq(0).suggestMode(SuggestMode.ALWAYS).shardSize(50)
        List<String> phrases = new ArrayList<>();
                .text("prefix_abcd")
        assertSuggestionSize(searchSuggest, 0, 0, "simple_phrase");
            "Frank's Wife",
            if (context.instanceClazz != TemplateScript.class) {
        indexRandomForConcurrentSearch("test");
        ensureGreen();
            titles.add("United " + c);
        phraseSuggest.smoothingModel(new LinearInterpolation(0.4, 0.4, 0.2));  
                        return result;
    }  
 *
        titles.add("Coronal mass ejection");  
        );
        );
            .startObject()
        PhraseSuggestionBuilder incorrectFilteredSuggest = suggest.collateQuery(incorrectFilterString);
 * the Apache License, Version 2.0 (the "License"); you may
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    }
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(  
        assertSuggestionSize(suggest, 0, 0, "did_you_mean");
            .startObject("properties")
        Collections.addAll(phrases, "nobel prize", "noble gases", "somethingelse prize", "pride and joy", "notes are fun");
            searchSuggest("test", termSuggest);
        assertSuggestion(searchSuggest, 0, "suggestion", 1, "apple");  
                .put(indexSettings())  
                    .put("index.analysis.filter.shingler.type", "shingle")
            .addCandidateGenerator(new DirectCandidateGeneratorBuilder("text").suggestMode("popular").minDocFreq(2));
            fail(" can not suggest across multiple indices with different analysis chains");  
    }  
        PhraseSuggestionBuilder phraseSuggestWithParamsAndReturn = suggest.collateQuery(collateWithParams)  
    public void testSimple() throws Exception {  
        assertSuggestion(searchSuggest, 0, "simple_phrase", "arthur king of the britons");
        index("test", "type2", "1", "foo", "bar");
        generator.suggestMode(null);
        suggestions.put(  
            client().prepareIndex("test").setId("3").setSource("field1", "foobar3").setRouting("3")
            "title",  
            titles.add("Elections " + c);
    }  
 * ownership. Elasticsearch licenses this file to you under  
            .endObject()  
        builders.add(client().prepareIndex("test").setSource("text", "apple"));  
        searchSuggest = searchSuggest(  
    // see #3469  
            titles.add(c + " United");  
                .putList("index.analysis.analyzer.bigram.filter", "my_shingle", "lowercase")
        index("test", "type2", "2", "foo", "bar");  
import static org.opensearch.search.suggest.SuggestBuilders.phraseSuggestion;  
import org.opensearch.common.xcontent.XContentFactory;
        try {  
            searchBuilder.suggest(new SuggestBuilder().setGlobalText("tetsting sugestion").addSuggestion("did_you_mean", phraseSuggestion));
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(
            .endObject();
        assertSuggestionSize(suggest, 0, 0, "test");
            ).confidence(2f).maxErrors(5f).size(1)
                .put("index.analysis.filter.my_shingle.output_unigrams", true)
            );
            .field("analyzer", "biword")  
        assertThat(suggest.getSuggestion("field2").getEntries().get(0).getText().string(), equalTo("prefix_eeeh"));
            "simple_phrase",
            .collatePrune(true);
import org.opensearch.search.suggest.phrase.LinearInterpolation;
                .put(SETTING_NUMBER_OF_SHARDS, 1) // A single shard will help to keep the tests repeatable.  
        assertSuggestionSize(suggest, 0, 3, "did_you_mean");
    protected Suggest searchSuggest(String name, SuggestionBuilder<?> suggestion) {  
    }
        refresh();
                .put("index.analysis.filter.shingler.min_shingle_size", 2)  
            searchSuggest("united states house of representatives elections in washington 2006", numShards.numPrimaries, namedSuggestion);
                )
        suggest = searchSuggest("test", termSuggest);  
        searchSuggest("test", termSuggest);
        {
            .endObject()
                candidateGenerator("body").prefixLength(2).minWordLength(1).suggestMode("always")
        );
        assertSuggestion(searchSuggest, 0, "simple_phrase", "hello words");
        assertThat(suggest.getSuggestion("test").getEntries().get(0).getText().string(), equalTo("abcd"));  
import org.opensearch.search.suggest.term.TermSuggestionBuilder;
        DirectCandidateGeneratorBuilder generator = candidateGenerator("name").prefixLength(0)
            .startObject()
        );
            index("test", "type1", phrase, "body", phrase);
            .suggest(  
        assertSuggestion(suggest, 0, "size3SortScoreFirst", "prefix_aacd", "prefix_abcc", "prefix_accd");  
        String filterStringAsFilter = XContentFactory.jsonBuilder()  
            .startObject("shingled")
        PhraseSuggestionBuilder filteredFilterSuggest = suggest.collateQuery(filterStringAsFilter);
        OpenSearchAssertions.assertNoFailures(searchResponse);
        for (int i = 0; i < 15; i++) {  
        ensureGreen();
            .analyzer("body")
        refresh();  
        suggest = searchSuggest("test", termSuggest);  
            // expected
        // test phrase suggestion on completely empty index  
        assertAcked(prepareCreate("test").setMapping("text", "type=text"));
            titles.add(c + " House");
            .endObject();
        index("test", "type1", "2", "text", "aacd");
            )  
                    endsWith("Suggest entries have different text actual [ABCD] expected [abcd]"),
        assertSuggestion(searchSuggest, 0, 0, "did_you_mean", "iced tea");
        Suggest searchSuggest = searchSuggest(  
        assertThat(suggest.getSuggestion("test").getEntries().get(0).getText().string(), equalTo("abcd"));
    public static class DummyTemplateScriptEngine implements ScriptEngine {  
        ensureGreen();
        searchSuggest = searchSuggest("Sir Bedever the Wife Sir Bedever the Wife Sir Bedever the Wife", "simple_phrase", phraseSuggest);
import org.opensearch.script.ScriptEngine;
        titles.add("UniRed");
                .put("index.analysis.filter.my_shingle.output_unigrams", false)
            Settings.builder()
        assertSuggestionSize(searchSuggest, 0, 0, "simple_phrase");
    public void testUnmappedField() throws IOException, InterruptedException, ExecutionException {  
        // Many of these candidates are drawn from page names on English Wikipedia.  
 * You may obtain a copy of the License at  
    }
        ensureGreen();
                return new TemplateScript(null) {
                ex.getMessage(),
            "nobel prize",  
            .startObject()  
        titles.add("Unrated");  
        searchSuggest = searchSuggest("Artur, King of the Britns", "simple_phrase", phraseSuggest);
        String line = "xorr the god jewel";
        );  
        );
import org.opensearch.search.suggest.phrase.PhraseSuggestionBuilder;  
        SearchResponse searchResponse = client().prepareSearch()
            .startObject()  
        indexRandom(true, builders);  
        assertSuggestion(searchSuggest, 0, "suggestion", 2, "apple", "appfle");
                                                                                                   // between requests.
        suggest.collateQuery(filterStr);
                ex.getCause().getMessage(),  
        SearchResponse search = client().prepareSearch().setQuery(matchQuery("text", "spellchecker")).get();  
package org.opensearch.search.suggest;
import org.opensearch.search.suggest.phrase.DirectCandidateGeneratorBuilder;  
        ensureGreen();  
                .put("index.analysis.filter.my_shingle.type", "shingle")
        Suggest searchSuggest = searchSuggest("suggestion", phraseSuggest);  
            Settings.builder()  

    private static String randomStoreField() {
                .setQuery(nestedQuery("foo", matchPhrasePrefixQuery("foo.text", "bro"), ScoreMode.None))  
        field = new HighlightBuilder.Field("unmapped").highlighterType("plain").noMatchSize(21);
            .endObject()  
        }
        indexRandomForConcurrentSearch("test");  
        for (int i = 0; i < COUNT; i++) {  
            .endObject()
 */
 * this file be licensed under the Apache-2.0 license or a
                )
                    .endObject()  
        logger.info("--> searching with boundary characters");
            1,
    }
            HighlightField field = searchResponse.getHits().getAt(0).getHighlightFields().get("keyword");
                new HighlightBuilder().field(new HighlightBuilder.Field("title").highlighterType("plain")).highlighterType("plain")
                new String[] { "this is another test", "yet another test" }
        SearchResponse searchResponse = client().search(searchRequest("test").source(source)).actionGet();
 *  
        SearchHit hit = searchResponse.getHits().getAt(0);  
        );
        Field barField = new Field("bar").numOfFragments(1)  
                    .field("term_vector", "with_positions_offsets")  
            containsString("source is forced for fields [field1] but _source is disabled")  
        search = client().prepareSearch()
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
        refresh();  
            .field("index_options", "offsets")  
            1,  
        HighlightBuilder.Field field = new HighlightBuilder.Field("text").fragmentSize(21)
                    .endObject()  
        assertHitCount(searchResponse, 1L);
                    .startObject("key")  
                    0,  
            0,
    public void testPostingsHighlighterPrefixQuery() throws Exception {  
            .field("index_options", "offsets")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
        client().prepareIndex("test")
        for (int i = 0; i < 5; i++) {  
        // (this behavior is consistent with version 0.20)
    public void testDisableFastVectorHighlighter() throws Exception {
        for (String type : new String[] { "fvh", "unified" }) {  
            equalTo("The <em>quick</em> brown fox jumps over the lazy dog! Second sentence.")
            assertHighlight(r1, 0, "field", 0, 1, equalTo("<x>hello</x> world"));
            .get();
            .field("term_vector", "with_positions_offsets")  
                        .endObject()  
                        .startObject("properties")
                .highlighter(
                QueryBuilders.geoBoundingBoxQuery("geo_point")
            .startObject("properties")
            .field("term_vector", "with_positions_offsets_payloads")  
        HighlightField field = response.getHits().getAt(0).getHighlightFields().get("foo_copy");
                new String[] {
            .setSource(
import org.apache.lucene.tests.analysis.MockAnalyzer;  
        assertAcked(prepareCreate("test").setMapping("title", "type=text," + randomStoreField() + "index_options=offsets"));  
        mappings.endObject();
        final int iters = scaledRandomIntBetween(20, 30);
    }
            .get();  
                    .field("analyzer", "whitespace")
        int COUNT = between(20, 100);
    }
import org.opensearch.common.time.DateFormatter;
        SearchResponse search = client().prepareSearch()
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
            .get();
        fooField.matchedFields("bar.plain");
        // Unified hl also works but the fragment is longer than the plain highlighter because of the boundary is the word
            .startObject("text")  
            .setSource(jsonBuilder().startObject().field("text", "brown").endObject())
        }
            client().prepareIndex("index-1").setId("2").setSource("d", formatter.format(now.minusDays(1)), "field", "hello"),
        }  
    @ParametersFactory
            .endObject()  
            assertHighlight(
        mappings.startObject();
            .field("term_vector", "with_positions_offsets")
                jsonBuilder().startObject()
        assertHighlight(response, 0, "text", 0, 2, equalTo("This is the <em>third</em> sentence. This is the fourth sentence."));
        );  
        assertHighlight(
            // Make sure the highlightQuery is taken into account when it is set on the highlight context instead of the field  
                    .endObject()  
    /**
            equalTo("<em>this</em> <em>is</em> <em>a</em> <em>test</em> . Second sentence.")  
            equalTo("The <em>quick</em> brown fox jumps over the lazy dog! Second sentence.")  
                    .field("store", true)
            1,  
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.BoundaryScannerType;  
                    new HighlightBuilder.Field("highlight_field").fragmentSize(-1).numOfFragments(1).fragmenter("simple")  
        );
            .highlighter(highlight().field("field1").order("score").preTags("<xxx>").postTags("</xxx>"));
            )  
        // see https://github.com/elastic/elasticsearch/issues/17537#issuecomment-244939633
        mappings.startObject();
        assertHighlight(  
    public void testACopyFieldWithNestedQuery() throws Exception {  
            .highlighter(new HighlightBuilder().field(fooField).field(barField))
                    MockAnalyzer instance = new MockAnalyzer(random(), MockTokenizer.WHITESPACE, false);  
        searchResponse = client().prepareSearch()  
            .setQuery(  
        assertNotHighlighted(response, 0, "text");
        // unified hl returns the first sentence as the noMatchSize does not cross sentence boundary.
import static org.hamcrest.Matchers.startsWith;
            assertHighlight(search, i, "attachments.body", 0, equalTo("<em>attachment</em> 1"));
                "field-plain",  
        field.highlighterType("unified");
                    .endObject()
                1,
        indexRandomForConcurrentSearch("test");
        ensureGreen();  
            .highlighter(highlight().field("field2").preTags("<xxx>").postTags("</xxx>").highlighterType("plain").requireFieldMatch(false));  
        indexRandom(true, client().prepareIndex("test").setSource("field1", "some quick and hairy brown:fox jumped over the lazy dog"));
    public void testHighlightUsesHighlightQuery() throws IOException, InterruptedException {
            .requireFieldMatch(requireFieldMatch);
        // test the kibana case with * as fieldname that will try highlight all fields including meta fields
            .setId("1")
            .setQuery(matchQuery("attachments.body", "attachment"))
                searchResponse,  
            .highlighter(highlight().field("field2").preTags("<xxx>").postTags("</xxx>"));
            client().prepareSearch("test")  
                jsonBuilder().startObject()  
                "tags",
        refresh();
                "field-plain",  
            equalTo("The <x>quick</x> <x>brown</x> fox jumps over the lazy dog! Second sentence.")
        logger.info("--> highlighting and searching on field1");  
        client().prepareIndex("test")
    // see #3486
                    .field(new HighlightBuilder.Field("field2").preTags("<2>").postTags("</2>").requireFieldMatch(false))  
            "field2",  
            .get();  
                    .startObject("fields")
    }  
            .highlighter(new HighlightBuilder().encoder("html").field("title", 50, 1))
            .get();
        assertNotHighlighted(response, 0, "text");  
                    .endObject()
                "long_term",  
        indexRandom(true, client().prepareIndex("test").setSource("field1", "some quick and hairy brown:fox jumped over the lazy dog"));
        if (randomBoolean()) {  
                    .field("type", "text")
                        .startArray("attachments")  
                    .field("analyzer", "whitespace")  
        for (int i = 0; i < 5; i++) {
            .field("store", true)
            return singletonList(PreConfiguredTokenFilter.singleton("mock_snowball", false, MockSnowBall::new));
                    .endObject()
        SearchRequestBuilder req = client().prepareSearch("test").highlighter(new HighlightBuilder().field(fooField));
            .endObject()  
        field.highlighterType("fvh");
                        .startArray("attachments")
            .endObject()
                    .field("term_vector", "no")  
                "field1",
            .get();  
                        .startArray("attachments")
            assertHitCount(searchResponse, 1);  
import org.opensearch.index.query.QueryBuilders;
                searchResponse,
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
        assertHighlight(response, 0, "text", 0, 1, equalTo(text));
                "title",  
                    .startObject("title")
            .startObject("field2")  
        // Using plain highlighter instead of FVH
        ensureGreen();
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();  
            .setQuery(matchQuery("title", "this is a test"))  
                    .startObject("key")
            .get();
        client().prepareIndex("test").setSource("field1", "The photography word will get highlighted").get();
        for (int i = 0; i < indexRequestBuilders.length; i++) {  
        HighlightField field = searchResponse.getHits().getAt(0).getHighlightFields().get("text");  
            ).setMapping("text", "type=text,analyzer=my_analyzer")
        for (int i = 0; i < 5; i++) {
                "field-fvh",
            .order("score")  
        );
                "type=text,term_vector=with_positions_offsets",
                        .highlighterType(type)  
        XContentBuilder mapping = XContentFactory.jsonBuilder()
    public void testResetTwice() throws Exception {  
        refresh();  
        indexRandomForConcurrentSearch("test");
        search = client().prepareSearch()
            indexRequestBuilders[i] = client().prepareIndex("test")
                    1,
            .highlighterType("plain")  
        // Again same if the field isn't mapped
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));
            .setQuery(matchQuery("foo_copy", "brown"))
                0,  
            .setQuery(matchQuery("title", "bug"))
import org.opensearch.action.search.SearchRequestBuilder;
import static org.hamcrest.Matchers.anyOf;
        for (int i = 0; i < indexRequestBuilders.length; i++) {  
    }  
        phraseBoostTestCaseForClauses(
                .setQuery(
            .get();
        resp = req.setQuery(queryStringQuery("weird").field("foo").field("foo.plain").field("bar").field("bar.plain"))
            prepareCreate("test").setSettings(
        resp = req.setQuery(queryStringQuery("foo.plain:running scissors").field("foo")).get();  
                "The quick brown <field1>fox</field1> jumps over the lazy dog."  
        );  
    public void testHighlightingWithKeywordIgnoreBoundaryScanner() throws IOException, InterruptedException {  
            assertThat(field.getFragments()[0].string(), equalTo("<em>brown</em> cat"));  
                        .startObject()
        String highlighterType = randomFrom(ALL_TYPES);
        for (String highlighter : ALL_TYPES) {
            .startObject("text")  
        return "";  
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
        // directly.
        for (String type : ALL_TYPES) {
            .field("type", "text")
import static org.opensearch.index.query.QueryBuilders.regexpQuery;
            .setSource("text", "opensearch test", "byte", 25, "short", 42, "int", 100, "long", -1, "float", 3.2f, "double", 42.42)
        refresh();
        indexRandomForConcurrentSearch("test");
    }
    }  
            .endObject()
    }
        barField.matchedFields("bar", "foo.plain");  
        field.highlighterType("unified");
        refresh();  
        client().prepareIndex("test")
 * the Apache License, Version 2.0 (the "License"); you may
            .highlighter(new HighlightBuilder().field("title.key"))
            SearchHit hit = searchResponse.getHits().getHits()[i];
            )
            .setSource(
        for (BoundaryScannerType scanner : BoundaryScannerType.values()) {  
                    .field("store", true)
            .field("type", "text")
                        .field("type", "text")  
            0,
            matches("source is forced for fields \\[field\\d, field\\d\\] but _source is disabled")  
        assertHighlight(
        resp = req.setQuery(queryStringQuery("foo.plain:running scissors").field("foo")).get();  
        }  
        // Same for if the field doesn't even exist on the document
 * this work for additional information regarding copyright
            .field("path", "text")
            assertHitCount(searchResponse, 1);
            0,
            highlighterType,
        logger.info("--> highlighting and searching on field1");
                    .endObject()  
            assertHitCount(searchResponse, 1);
        client().prepareIndex("test").setId("1").setSource(jsonBuilder().startObject().field("field", "highlight").endObject()).get();  
        indexRandomForConcurrentSearch("test");  
            .field("store", false)  
        prepareCreate("test").setMapping(mapping).get();
        mappings.startObject("_source")  
            .setQuery(matchQuery("title", "this is a test"))  
            .highlighter(new HighlightBuilder().encoder("html").field("title", 50, 1))  
import org.opensearch.test.MockKeywordPlugin;
            response,
        req = client().prepareSearch("test").highlighter(new HighlightBuilder().field(fooField));
        indexRandomForConcurrentSearch("test");  
                        .field("body", "attachment 2")
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
                );
        for (String type : new String[] { "plain", "unified" }) {
        // check that keyword highlighting works
            )  
            );
        for (int i = 0; i < indexRequestBuilders.length; i++) {
            indexRequestBuilders[i] = client().prepareIndex("test")  
                    .field("store", false)
        assertThat(
            .setQuery(QueryBuilders.matchQuery("text", "test"))  
            .get();
                        .highlighterType(type)
                )
            field.highlightQuery(matchQuery("text", "query"));  
            }
            QueryBuilders.termQuery("enable", "yes"),
            "2",
        ensureGreen();
                    .field("index_options", "offsets")
                    searchHit,
        ensureGreen();
            )
        indexRandomForConcurrentSearch("test");  
            1,
        }  
                0,
        ensureGreen();  
        }
            "field2",
            assertThat(field.getFragments().length, equalTo(1));
        assertNotHighlighted(response, 0, "text");
        for (String highlighterType : new String[] { "unified", "plain" }) {
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));  
                    .startObject("properties")
                        .boundaryScannerType(BoundaryScannerType.SENTENCE)
                "type=text,term_vector=with_positions_offsets"
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();  
        );
                "field1",
        logger.info("--> highlighting and searching on field2");  
        );
            prepareCreate("test").setMapping(
        // But if you add the stored field to the list of matched fields then you'll get a result again
    public void testForceSourceWithSourceDisabled() throws Exception {  
 *
                .setId(Integer.toString(i))
                .setMapping("d", "type=date", "field", "type=text,store=true,term_vector=with_positions_offsets")
            "field2",  
        index("test", "type1", "1", "text", text);
            2,  
 * The OpenSearch Contributors require contributions made to  
            SearchSourceBuilder source = searchSource().query(multiMatchQueryBuilder)
 * under the License.  
        SearchResponse search = client().prepareSearch()  
                    equalTo("<field1>The quick brown fox</field1> jumps over"),
import org.opensearch.action.index.IndexRequestBuilder;  
    }  
                    .endObject()  
                        .preTags("<xxx>")  
import org.apache.lucene.search.join.ScoreMode;
        indexRandomForConcurrentSearch("test");
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
            .setQuery(matchQuery("title.key", "this is a test"))
                    .field("index_options", "offsets")  
        ensureGreen();
        SearchResponse defaultPhraseLimit = client().search(searchRequest("test").source(source)).actionGet();
        // If the stored field is found but the matched field isn't then you don't get a result either.
                        .field("type", "text")  
                    .startObject("key")  
    }  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        assertHighlight(resp, 0, "bar", 0, equalTo("<em>cat</em> <em>cat</em> junk junk junk junk"));
                    new Field("tags").highlighterType("plain").fragmentSize(-1).numOfFragments(2).fragmenter("span")
        indexRandomForConcurrentSearch("test");
                        .endArray()  
    public void testSourceLookupHighlightingUsingPlainHighlighter() throws Exception {
            0,  
                    .startArray("foo")
            )
            Matcher<String> searchQueryMatcher = equalTo("<em>Testing</em> the highlight query feature");
        client().prepareIndex("test")  
        indexRandom(true, indexRequestBuilders);
        );
        }
 * Modifications Copyright OpenSearch Contributors. See  
        mappings.startObject("properties").startObject("keyword_field").field("type", "keyword").endObject().endObject();
                "field-postings",
 * not use this file except in compliance with the License.
        assertAcked(
            .setQuery(matchQuery("title", "this is a test"))
                .highlighter(new HighlightBuilder().field(new Field("foo.text").highlighterType(type)))
    public void testEnsureNoNegativeOffsets() throws Exception {  
            .setSource(jsonBuilder().startObject().array("tags", "foo baz", "foo baz", "foo baz", "foo bar").field("sort", 2).endObject())
            .field("index_options", "offsets")  
        ensureGreen();
            .get();  
        indexRandomForConcurrentSearch("test");
            SearchResponse response = client().prepareSearch("test")  
        searchResponse = client().prepareSearch("test").setSource(source).get();
        /*
    private void checkFvhMatchedFieldsCase(boolean requireFieldMatch) throws Exception {  
                        .startObject("plain")
            "field2",
            .endObject()
                "field1",
                    .field("field1", 20, 1)
                        "The quick brown <field1>fox</field1> jumps over the lazy dog. "  
                "field1",
                "field1",
            .endObject()
            "The <b>slow<b> brown fox. Second sentence."
    public void testKeywordFieldHighlighting() throws IOException, InterruptedException {
            "cat cat junk junk junk junk junk junk junk cats junk junk",
            .order("score")  
            .startObject("text")
                        .field("body", "attachment 2")
        mappings.startObject();
        ensureYellow();  
     * because it doesn't support the concept of terms having a different weight based on position.
        }
        assertHighlight(response, 0, "text", 0, 1, equalTo(text));
            .endObject()
            assertThat(field.getFragments().length, equalTo(2));
                    .endObject()
                        .startObject("properties")
            .setId("1")
            .field("type", "text")  
        client().prepareIndex("test")
        DateFormatter formatter = DateFormatter.forPattern("strict_date_optional_time");  
                .setId(Integer.toString(i))  
            .field("path", "text")
    public void testFVHManyMatches() throws Exception {
            )  
                "type=text," + randomStoreField() + "term_vector=with_positions_offsets,index_options=offsets"
            .field("term_vector", "with_positions_offsets")  
            .highlighter(  
                    "The lazy red fox jumps over the quick dog.",  
                    .startObject("properties")
                    .field("analyzer", "classic")
        response = client().prepareSearch("test").setQuery(queryBuilder).highlighter(new HighlightBuilder().field(field)).get();
                searchResponse,  
        ensureGreen();
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
            .highlighter(highlight().field("field1").preTags("<xxx>").postTags("</xxx>"));
        mappings.startObject();
            .field("enabled", false)
        SearchResponse searchResponse = client().prepareSearch()
        assertNoFailures(search);  
                    .startObject("body")
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with scissors"));
        HighlightBuilder.Field field = new HighlightBuilder.Field("text").fragmentSize(21).numOfFragments(1).highlighterType("plain");  
                        .startObject()  
        // And you can enable matchedField highlighting on both
        refresh();  
    }
        XContentBuilder mappings = jsonBuilder();  
        phraseBoostTestCase("fvh");  
            100f,
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
        logger.info("--> searching on field2, highlighting on field2, falling back to the plain highlighter");
        indexRandom(true, indexRequestBuilders);
        // You _can_ highlight fields that aren't subfields of one another.
        source = searchSource().query(matchPhraseQuery("field2", "quick brown"))
        searchResponse = client().search(searchRequest("test").source(source)).actionGet();
        );
        req = client().prepareSearch("test").highlighter(new HighlightBuilder().field(fooField));
            .get();
        client().prepareIndex("test")  
            MockSnowBall(TokenStream in) {
        for (int i = 0; i < indexRequestBuilders.length; i++) {
        indexRandomForConcurrentSearch("test");
        );  
                    .field("type", "text")  
    public void testEscapeHtml() throws Exception {
            .field("path", "keyword")  
            .field("term_vector", "with_positions_offsets")
                    .field("type", "text")  
        mappings.endObject();
                        .startObject()  
                jsonBuilder().startObject()
            assertHighlight(
 * specific language governing permissions and limitations
    }
        );  
            .startObject("alias")  
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
            true,
        assertAcked(
            .setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog! Second sentence.")  
    }
        SearchResponse response = client().prepareSearch("test")
                    .endObject()  
        // If field is not stored, it is looked up in source (but source has only 'foo'
        mappings.endObject();
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));
        indexRandomForConcurrentSearch("test");
import org.opensearch.core.xcontent.XContentBuilder;
            searchResponse,
        mappings.startObject("properties")  
                    .field("store", false)
            assertThat(field.getFragments().length, equalTo(1));
    }  
                        .field("analyzer", "standard")
        assertFailures(
                .highlighter(new HighlightBuilder().field("title", 50, 1, 10).highlighterType("fvh")),
        );
        );
            MultiMatchQueryBuilder multiMatchQueryBuilder = multiMatchQuery("the quick brown fox", "field1", "field2").type(matchQueryType);  
                super(in);
        // Query string with a single field without dismax  
                    .field("index_options", "offsets")
            // postings hl doesn't support require_field_match, its field needs to be queried directly  
                .setQuery(matchPhraseQuery("title", "this is a test"))
        }
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
        indexRandomForConcurrentSearch("test");
            .fragmentSize(25)
            .get();  
                "This <em>sentence</em> contains one match, not that short. "  
        indexRandom(
                )
            "bar",
            .highlighter(new HighlightBuilder().field("no_long_term", 30, 1).highlighterType("fvh").postTags("</b>").preTags("<b>"))
            assertThat(field.getFragments()[0].string(), equalTo("<em>brown</em> cat"));
                search,
            );  
        super(staticSettings);
        logger.info("--> highlighting and searching on field2");  
            equalTo("here is another one that is very <em>long</em> <em>tag</em> and has the tag token near the end")
                    final char[] buffer = termAtt.buffer();
                "type=text,store=false,term_vector=with_positions_offsets"  
         * neighborhood of 8 seconds.
            .order("score")
        indexRandomForConcurrentSearch("test");
                "This is a test thisisaverylongwordandmakessurethisfails where foo is highlighed " + "and should be highlighted"
    public void testPostingsHighlighterShouldFailIfNoOffsets() throws Exception {
                .setSource(
        indexRandom(true, indexRequestBuilders);
            .setQuery(QueryBuilders.matchQuery("text", "test"))
        // Add the subfield to the list of matched fields but don't match it. Everything should still work  
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
            )
        indexRandomForConcurrentSearch("test");
        field.highlighterType("unified");  
            .startObject("field1")
            .startObject("properties")
            .field("type", "alias")
            .startObject()  
        SearchRequestBuilder req = client().prepareSearch("test").highlighter(new HighlightBuilder().field(fooField));
                .setQuery(nestedQuery("foo", matchQuery("foo.text", "brown cow"), ScoreMode.None))
        @Override
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()).get());  
            .field("term_vector", "with_positions_offsets")
        for (int i = 0; i < indexRequestBuilders.length; i++) {  
    public void testPostingsHighlighterMultipleFields() throws Exception {
        response = search.setQuery(boostingQuery(phrase, terms).boost(1).negativeBoost(1 / boost)).get();
                    .startObject()  
                    + "This <em>sentence</em> contains two <em>sentence</em> matches."
                .highlighter(new HighlightBuilder().field(new Field("field1").preTags("<xxx>").postTags("</xxx>").forceSource(true))),
        refresh();
 *    http://www.apache.org/licenses/LICENSE-2.0
                        .endObject()
            search = client().prepareSearch()
    }  
        indexRandomForConcurrentSearch("test");  
        assertHitCount(searchResponse, 1L);
            1,  
        assertHighlight(search, 0, "title.key", 0, 1, equalTo("<em>this</em> <em>is</em> <em>a</em> <em>test</em>"));  
            )
            .setQuery(termQuery("field1", "quick"))
            prepareCreate("test").setMapping(
            .setQuery(matchQuery("title.key", "this is a test"))  
        assertAcked(client().admin().indices().prepareAliases().addAlias("test", "filtered_alias", matchQuery("foo", "japanese")));
                "type=float",
            .highlighter(new HighlightBuilder().field(fooField).field(barField))
                .requireFieldMatch(randomBoolean());
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
        source = searchSource().query(termQuery("field1", "fox"))
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so some"));
                jsonBuilder().startObject()  
    }
        field.highlighterType("fvh");
            equalTo("The <em>quick</em> brown fox jumps over the lazy dog! Second sentence.")
        SearchRequestBuilder search = client().prepareSearch("test")  
        refresh();  
            "tags",
            .endObject()
                "type=text",  
            highlightBuilder.highlightQuery(matchQuery("text", "query"));
            .setQuery(matchQuery("title", "this is a test"))
            assertHitCount(searchResponse, 1);
            .field("type", "text")
        indexRandomForConcurrentSearch("test");  
        ensureGreen();
        logger.info("--> highlighting and searching on field1");  
    }
        assertAcked(prepareCreate("test").setMapping("name", "type=text,term_vector=with_positions_offsets,store=" + randomBoolean()));  
            queryStringQuery("highlight words together").field("field1"),
        resp = req.setQuery(queryStringQuery("foo.plain:running foo.plain:scissors").field("foo")).get();  
        SearchResponse search = client().prepareSearch()
        ensureGreen();  
            matchPhraseQuery("field1", "highlight words together")
        SearchSourceBuilder source = searchSource().query(
 */  
        indexRandom(true, client().prepareIndex("test").setSource("foo", "test typename"));  
        assertNotHighlighted(response, 0, "text");
            .field("type", "text")
                        .startObject()
                    QueryBuilders.boolQuery()
                    if (length > 3) {
        );
                    .field("type", "text")
        SearchSourceBuilder searchSource = SearchSourceBuilder.searchSource()  
            .highlighter(new HighlightBuilder().field("no_long_term", 18, 1).highlighterType("fvh").postTags("</b>").preTags("<b>"))
                        + "This sentence contains three sentence occurrences (sentence).",
                    .field("store", false)
            .endObject()
    }  
            .endObject()
            .setId("1")
            equalTo(
        client().prepareIndex("test").setId("1").setSource("title", "this is a test").get();  
        resp = req.setQuery(queryStringQuery("cats foo.plain:cats^5").field("foo")).get();  
                "long",
        ensureGreen();
            .highlighterType("fvh")
import org.opensearch.indices.analysis.AnalysisModule;
            client().prepareSearch("test")
                "This is the test for the plain highlighter"
        ensureGreen();
            searchResponse,  
                )  
            .setQuery(matchQuery("title", "bug"))  
    public void testHighlighterWithSentenceBoundaryScanner() throws Exception {
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am short"));
                new HighlightBuilder().field("text").field("byte").field("short").field("int").field("long").field("float").field("double")  
            .setSource(  
        for (int i = 0; i < 5; i++) {
                "This is a test where foo is highlighed and should be highlighted",
            HighlightBuilder builder = new HighlightBuilder().field(new Field("alias").highlighterType(type))  
            .get();
        // but we highlight the root text field since nested documents cannot be highlighted with postings nor term vectors
        // And that matching a subfield doesn't automatically highlight it
                    .field("index_options", "offsets")  
        assertHighlight(searchResponse, 0, "field-plain", 0, 1, equalTo("This is the <xxx>test</xxx> for the plain highlighter"));  
        ensureGreen();  
                .setId(Integer.toString(i))
        assertAcked(
            client().prepareIndex("index-1").setId("1").setSource("d", formatter.format(now), "field", "hello world"),  
    }
            assertHighlight(search, i, "title", 0, equalTo("This is a test on the highlighting <em>bug</em> present in opensearch"));  
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();
        assertHighlight(response, 0, "text", 1, 2, equalTo("This is the <em>fifth</em> sentence"));
            .field("type", "long")
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));  
        String highlighterType,
        logger.info("--> highlighting and searching on field1");  
                0,
        refresh();  
        assertNoFailures(search);
        ensureGreen();
                .highlighter(  
        field.highlighterType("plain").noMatchSize(randomIntBetween(Integer.MIN_VALUE, -1));
        logger.info("--> highlighting and searching on field*");
                .setSource("title", "This is a html escaping highlighting test for *&? opensearch");  
    public void testPostingsHighlighterCommonTermsQuery() throws IOException, InterruptedException {  
        SearchResponse search = client().prepareSearch()  
            SearchResponse searchResponse = client().prepareSearch()
            "tags",
        source = searchSource().query(matchPhraseQuery("field2", "quick brown"))
        logger.info("--> highlighting and searching on field2");  
        }
        SearchResponse search = client().prepareSearch()  
            .setId("0")
            .numOfFragments(0)  
            .setSource(
            .highlighter(highlight().field("field2"));
        resp = req.setQuery(queryStringQuery("cats").field("foo").field("foo.plain", 5)).get();
            .highlighter(highlight().field("field1").preTags("<xxx>").postTags("</xxx>"));  
import java.time.ZonedDateTime;  
                0,  
            .highlighter(highlight().field(new Field("field2").fragmentSize(30).numOfFragments(1).boundaryChars(new char[] { ' ' })));  
                .get();
        // Query string with a single field
        assertHighlight(search, 0, "long_term", 0, 1, equalTo("<em>thisisaverylongwordandmakessurethisfails</em>"));
        assertThat(field.getFragments()[1].string(), equalTo("<em>cow</em>"));
                    // we don't store title, now lets see if it works...  
            highlightBuilder = new HighlightBuilder().field(field);
        logger.info("--> highlighting and searching on field1");  
                .setId(Integer.toString(i))
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
            1,
        refresh();  
            1f,
            .highlighter(highlight().field("field2").order("score").preTags("<x>").postTags("</x>"));
        XContentBuilder mappings = jsonBuilder().startObject()
        indexRandom(false, client().prepareIndex("test").setId("1").setSource("title", titles, "titleTV", titles));
            SearchResponse search = client().prepareSearch().setQuery(matchQuery("alias", "bar")).highlighter(builder).get();
import java.util.Arrays;
import org.apache.lucene.tests.analysis.MockTokenizer;
        field.highlighterType("unified");
                    .endObject()  
        assertHighlight(searchResponse, 0, "title", 0, 1, equalTo("this is a <em>test</em>"));  
            .endObject()  
                .highlighter(  
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so some"));  
            .get();
                searchResponse,  
            )
        QueryBuilder terms,
            SearchRequestBuilder search = client().prepareSearch("test")
            // lets make sure we analyze the query and we highlight the resulting terms  
                            .fragmentSize(50)
        HighlightField field1 = highlightFieldMap.get("field1");  
                        .field("term_vector", "with_positions_offsets")
    public void testPostingsHighlighterNumberOfFragments() throws Exception {
                    .field("analyzer", "classic")
            .highlighter(new HighlightBuilder().field("attachments.body", -1, 2))  
            .highlighter(new HighlightBuilder().field("title", -1, 0))  
        SearchSourceBuilder source = searchSource().query(termQuery("field1", "test"))
                    .startObject("title")  
        index("test", "type1", "1", "text", "Testing the highlight query feature");
            )  
            .get();
        // check that we do not get an exception for geo_point fields in case someone tries to highlight
        search = client().prepareSearch()  
        assertThat(resp.getHits().getAt(0).getHighlightFields(), not(hasKey("bar")));
        source = searchSource().query(wildcardQuery("field2", "qu*k")).highlighter(highlight().field("field2"));
                    .endObject()
    public void testFunctionScoreQueryHighlight() throws Exception {
            .field("term_vector", "with_positions_offsets")
        indexRandomForConcurrentSearch("test");
        refresh();
                    .endObject()
    public void testPostingsHighlighterRegexpQuery() throws Exception {
        }
        }
            0,  
        assertThat(field.getFragments().length, equalTo(1));
                1,
                        .preTags("<xxx>")  
            client().prepareIndex("test").setId("2").setSource("titleTV", new String[] { "some text to highlight", "highlight other text" })  
            .endObject()
        assertAcked(prepareCreate("test").setMapping("tags", "type=text,term_vector=with_positions_offsets"));  
    }
        XContentBuilder mappings = jsonBuilder();  
        for (int i = 0; i < 5; i++) {  
            true,
            .endObject()  
        SearchResponse resp = req.setQuery(queryStringQuery("running scissors").field("foo")).get();
                    .startObject("properties")
                    .endObject()
        ).highlighter(highlight().field("field1"));
        SearchResponse search = client().prepareSearch()
        text.append("words words junk junk junk junk junk junk junk junk highlight junk junk junk junk together junk\n");
            .setQuery(QueryBuilders.matchQuery("field1", "fox"))  
    }
            builder.append("abc").append(" ");  
    }
            .highlighter(  
        assertHighlight(search, 0, "title.key", 0, 1, equalTo("<em>this</em> <em>is</em> <em>a</em> <em>test</em>"));
        assertThat(response.getHits().getHits()[0].getHighlightFields().isEmpty(), equalTo(true));
        refresh();
        }
            queryStringQuery("\"highlight words together\"").field("field1").field("field2")
        );
    public void testGeoFieldHighlightingWithDifferentHighlighters() throws IOException, InterruptedException {  
            field = searchResponse.getHits().getAt(0).getHighlightFields().get("foo.text");
        assertHighlight(search, 0, "titleTV", 1, 2, equalTo("<em>highlight</em> other text"));
            )  
        logger.info("--> searching on field1, highlighting on field1");
                "This is the first test sentence. Here is the second one.",  
            .setSource("field1", "The quick brown fox jumps over the lazy dog", "field2", "second field content")
        StringBuilder text = new StringBuilder();
            );  
        assertHitCount(searchResponse, 1);
            .setQuery(matchPhraseQuery("no_long_term", "test foo highlighed").slop(3))
                    new HighlightBuilder.Field("tags").highlighterType("plain").fragmentSize(-1).numOfFragments(2).fragmenter("simple")
import java.util.HashMap;  
    }
                            termAtt.setLength(length - 3);  
    }
            RestStatus.INTERNAL_SERVER_ERROR,
    }
                        .boundaryScannerType(BoundaryScannerType.SENTENCE)  
            .setQuery(QueryBuilders.matchPhraseQuery("tags", "long tag"))
            .endObject()
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));  
            .get();  
                assertHighlight(  
    public void testCommonTermsTermVector() throws IOException, InterruptedException {
    public void testFiltersFunctionScoreQueryHighlight() throws Exception {
        assertNotHighlighted(response, 0, "text");
            .get();  
        // except for the unified highlighter which starts from the first string with actual content
        assertHighlight(resp, 0, "foo", 0, equalTo("running with <em>scissors</em>"));
            .startObject("unstored_field")
    }
        SearchSourceBuilder source = searchSource().query(rangeQuery("field2").gte("aaaa").lt("zzzz"))  
        refresh();
                    .field("term_vector", "no")
                        .postTags("</xxx>")
        ensureGreen();  
                    .endObject()  
    public void testMultiMapperNoVectorWithStore() throws Exception {
        refresh();
            .highlighter(new HighlightBuilder().field("titleTV", -1, 2))  
                jsonBuilder().startObject()
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();
                    .startObject("title")  
            private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
        SearchResponse search = client().prepareSearch()
                    .startObject("body")  
                    .field("store", false)
            2,
    public void testPostingsHighlighterManyDocs() throws Exception {  
        assertAcked(
            .get();
        logger.info("--> highlighting and searching on field1");
            .get();
            .highlighter(new HighlightBuilder().field(fooField).field(barField))
            .startObject("geo_point")
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("The <x>quick</x> <x>brown</x> fox jumps over the lazy dog"));  
        for (String highlighterType : new String[] { "plain", "unified" }) {  
                    .field("type", "text")
        assertHitCount(searchResponse, 1);
            .field("store", true)
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
                        .field("term_vector", "with_positions_offsets")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHighlight;  
                .highlighter(
        Field fooField = new Field("foo").numOfFragments(1).order("score").fragmentSize(25).highlighterType("unified");
        indexRandomForConcurrentSearch("test");  
        XContentBuilder mapping = XContentFactory.jsonBuilder()  
        ensureGreen();
        refresh();  
        refresh();
    public void testFastVectorHighlighterPhraseBoost() throws Exception {
            HighlightField field = searchResponse.getHits().getAt(0).getHighlightFields().get("text");  
        // This query used to fail when the field to highlight was absent
                    )  
                    .order("score")  
                .get();
                0,  
            assertHighlight(
                        .field("body", "attachment for this test")
    }
                );
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;
                .setQuery(QueryBuilders.matchPhraseQuery("tags", "long tag"))
                        .preTags("<xxx>")
                .setSource(  
            assertHighlight(search, i, "attachments.body", 1, equalTo("<em>attachment</em> 2"));
                    .field("term_vector", "with_positions_offsets")  
            field1.fragments()[2].string(),
        // simple search on body with standard analyzer with a simple field query
            1,
            .setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog! Second sentence.")
            assertHighlight(search, i, "title", 1, 2, equalTo("This is the second <em>bug</em> to perform highlighting on."));
                        .startObject("bar")  
        refresh();
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
                            .requireFieldMatch(false)
            // Because of SOLR-3724 nothing is highlighted when FVH is used  
        ensureGreen();
            .field("term_vector", "with_positions_offsets")  
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
                "titleTV",
                new HighlightBuilder().field("field1", 100, 1).order("score").highlighterType(highlighterType).requireFieldMatch(true)
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
import static org.opensearch.index.query.QueryBuilders.termQuery;
        assertNotHighlighted(response, 0, "text");  
    }  
        ensureGreen();  
    public void testFastVectorHighlighterShouldFailIfNoTermVectors() throws Exception {  
        field.highlighterType("unified");  
                    3,
    }
            .highlighter(new HighlightBuilder().field("title.key"))
                .highlighter(new HighlightBuilder().field(new Field("*").highlighterType(type)))  
        SearchResponse search = client().prepareSearch()  
                        .field("analyzer", "standard")
            searchResponse = client().prepareSearch()
        SearchResponse response = client().prepareSearch()
        assertHighlight(response, 0, "text", 0, 1, equalTo("This is the first sentence"));  
        // Speaking of two fields, you can have two fields, only one of which has matchedFields enabled
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));
            )
    public void testHighlightingWithWildcardName() throws IOException, InterruptedException {
            .highlighter(highlight().highlighterType("fvh").field("field1", 20, 1).order("score").preTags("<xxx>").postTags("</xxx>"));  
        );  
        search = client().prepareSearch()
                assertHighlight(searchHit, "field1", 1, 3, equalTo("The lazy red <field1>fox</field1> jumps over the quick dog."));
            indexRequestBuilders[i] = client().prepareIndex("test")  
            .endObject()  
            0,
    public void testCommonTermsQuery() throws InterruptedException {
        indexRandom(true, indexRequestBuilders);
            assertHighlight(searchResponse, i, "field1", 0, 1, equalTo("<em>test</em> " + hit.getId()));  
        SearchResponse searchResponse = client().search(searchRequest("test").source(source)).actionGet();
            assertThat(field.getFragments()[0].string(), equalTo("<em>hello world</em>"));  
        index("test", "type1", "1", "foo", "running with scissors");
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("The quick <x>brown</x> fox jumps over the lazy dog"));
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field).noMatchSize(21)).get();
                .setId(Integer.toString(i))  
            .highlighter(highlight().field("field2", 30, 1).boundaryChars(new char[] { ' ' }));
        SearchResponse searchResponse = client().prepareSearch()
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("The <x>quick</x> <x>brown</x> fox jumps over the lazy dog"));
            .setQuery(matchPhraseQuery("no_long_term", "test foo highlighed").slop(3))
            indexRequestBuilders[i] = client().prepareIndex("test")
        indexRandom(true, indexRequestBuilders);
                "title",  
        field.highlighterType("fvh");  
    }
            .setSource(jsonBuilder().startObject().field("keyword_field", "some text").endObject())
            .field("type", "text")
                "field1",  
        response = client().prepareSearch("test").setQuery(queryBuilder).highlighter(new HighlightBuilder().field(field)).get();  
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();
    }
                    .field("store", false)  
// Higher timeout to accommodate large number of tests in this class. See https://github.com/opensearch-project/OpenSearch/issues/12119  
        }  
    public void testDoesNotHighlightAliasFilters() throws Exception {
                    .field(new HighlightBuilder.Field("field2").preTags("<2>").postTags("</2>").requireFieldMatch(false))
        // If the stored field doesn't have a value it doesn't matter what you match, you get nothing.
            boolQuery().must(prefixQuery("field1", "photo")).should(matchQuery("field1", "test").minimumShouldMatch("0"))
        // simple search on body with standard analyzer with a simple field query  
        indexRandomForConcurrentSearch("test");
        phraseBoostTestCaseForClauses(
        SearchResponse searchResponse = client().prepareSearch()
            0,
            0,  
        field.highlighterType("plain");
        indexRandomForConcurrentSearch("test");
        // First check highlighting without any matched fields set
            .setId("1")  
        field.highlighterType("unified");  
        indexRandom(true, indexRequestBuilders);
import static org.opensearch.transport.client.Requests.searchRequest;  
            .endObject()
        );
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));  
        assertHighlight(response, 0, "tags", 0, equalTo("this is a really <em>long</em> <em>tag</em> i would like to highlight"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            .endObject()  
        search = client().prepareSearch()
        Field fooField = new Field("foo").numOfFragments(1)  
        );
            .endObject();
        SearchSourceBuilder source = searchSource()
        SearchSourceBuilder source = searchSource().query(
                    .startObject("title")
                        .field("type", "text")
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();  
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
        indexRandomForConcurrentSearch("test");
                        .field("analyzer", "mock_english")
            field = searchResponse.getHits().getAt(0).getHighlightFields().get("foo.text");
                new HighlightBuilder().field(new HighlightBuilder.Field("field1").preTags("<1>").postTags("</1>").requireFieldMatch(true))
        ensureGreen();
        );
        // But if the field was actually empty then you should get no highlighting field
import org.opensearch.core.rest.RestStatus;  
        for (String type : new String[] { "unified", "fvh" }) {
        source = searchSource().query(matchQuery("field2", "quick"))
            .highlighter(new HighlightBuilder().field("title", 50, 1, 10))  
        indexRandomForConcurrentSearch("test");
                .setQuery(matchQuery("tags", "foo bar"))  
                .setQuery(matchQuery("foo", "test"))
                    .field("store", false)
    }
        // We don't break if noMatchSize is less than zero though
        for (int i = 0; i < indexRequestBuilders.length; i++) {
        mappings.startObject();
    }
        SearchResponse resp = req.setQuery(queryStringQuery("running scissors").field("foo")).get();
                .highlighter(new HighlightBuilder().field("tit*", 50, 1, 10).highlighterType("fvh"))  
                    // we don't store title and don't use term vector, now lets see if it works...
                        .field("title", "This is a test on the highlighting bug present in opensearch")
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;
                };  
                        if (buffer[length - 1] == 'g' && buffer[length - 2] == 'n' && buffer[length - 3] == 'i') {
            SearchResponse search = client().prepareSearch()
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
        assertHighlight(resp, 0, "foo", 0, equalTo("junk junk <em>cats</em> junk junk"));
    }
                .highlighter(new HighlightBuilder().field("foo").highlighterType(highlighter).requireFieldMatch(false))
            assertHighlight(
        // Now make half the matches come from the stored field and half from just a matched field.
            .get();
                    .startObject("title")
                )  
            .field("term_vector", "with_positions_offsets")  
            equalTo(
            SearchResponse search = client().prepareSearch().setQuery(matchQuery("alias", "foo")).highlighter(builder).get();
        SearchResponse search = client().prepareSearch()
        // see https://github.com/elastic/elasticsearch/issues/17537  
            queryStringQuery("\"highlight words together\"").field("field1")
        SearchResponse search = client().prepareSearch()  
    public void testFieldAliasWithWildcardField() throws IOException, InterruptedException {
        indexRandomForConcurrentSearch("test");
        resp = req.setQuery(queryStringQuery("running scissors").field("foo").field("foo.plain").field("bar").field("bar.plain"))
            equalTo("This is the second value's first <em>sentence</em>. This one contains no matches.")  
                .get()
                    @Override
        assertHighlight(response, 0, "tags", 0, equalTo("this is a really <em>long</em> <em>tag</em> i would like to highlight"));  
        barField.matchedFields("bar", "candy");  
        }
        indexRandom(
        }
            // sentences will be generated out of each value
        mappings.endObject();
        assertHighlight(largePhraseLimit, 0, "field1", 0, 1, containsString("<xxx>t</xxx>"));  
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
            0,
    }  
        assertHighlight(resp, 0, "foo", 0, equalTo("junk junk <em>cats</em> junk junk"));
            // LUCENE 3.1 UPGRADE: Caused adding the space at the end...
        }
                    "this is a really long tag i would like to highlight",
import static java.util.Collections.singletonList;
            .startObject("field2")  
                "type=long",
        field.highlighterType("plain").noMatchSize(text.length());
                    .phraseLimit(30000)  
            .field("type", "text")
        indexRandomForConcurrentSearch("test");
                    .endObject()  
        );
            1,  
        ensureGreen();
            .get();  
                .get();
        fooField.matchedFields("foo", "bar.plain");  
        indexRandomForConcurrentSearch("test");
        refresh();  
            .startObject("properties")
import static org.opensearch.index.query.QueryBuilders.matchPhrasePrefixQuery;
                new String[] {  
        b.startObject("foo_copy").field("type", "text").field("store", true).endObject();
            );
            .field("type", "alias")  
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.index.query.QueryBuilders.fuzzyQuery;
                0,  
                    .startObject("field2")
            .highlighter(new HighlightBuilder().field("field1"));  
        assertThat(field.getFragments()[0].string(), equalTo("<em>brown</em>"));
        SearchSourceBuilder source = searchSource().query(termQuery("field1", "t"))
                    .setCorners(61.10078883158897, -170.15625, -64.92354174306496, 118.47656249999999)
            .highlighter(  
        prepareCreate("test").setMapping(b).get();
            .setQuery(new FunctionScoreQueryBuilder(QueryBuilders.prefixQuery("text", "bro")))
            .setSource(jsonBuilder().startObject().array("tags", "foo bar", "foo bar", "foo bar", "foo baz").field("sort", 1).endObject())  
            prepareCreate("test").setSettings(settings)  
                    .endObject()
        assertNoFailures(  
        assertNoFailures(search);  
        );
            HighlightBuilder.Field field = new HighlightBuilder.Field("text");  
        ).highlighter(highlight().field("field2").preTags("<x>").postTags("</x>"));  
            .get();  
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
            .endObject();  
            .endObject()  
        checkFvhMatchedFieldsCase(true);
        // The no match fragment should come from the first value of a multi-valued field
            )
        SearchResponse response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
                    if (buffer[length - 1] == 's') {
        }
                search,
        );  
                .should(matchQuery("field1", "test"))  
            0,
        ensureGreen();  
        HighlightBuilder builder = new HighlightBuilder().field(new Field("al*")).requireFieldMatch(false);
        field.highlighterType("fvh");  
                jsonBuilder().startObject()
            assertHighlight(
            );
        refresh();  
            .highlighter(
        refresh();
        for (String highlighter : ALL_TYPES) {
 */
        client().prepareIndex("test")  
            .highlighter(new HighlightBuilder().field("title", -1, 0))  
import org.opensearch.action.support.WriteRequest;  
                    .endObject()  
            .highlighterType("plain")
        XContentBuilder mappings = jsonBuilder();  
        }
                    .startObject("key")
        ensureGreen();
            .noMatchSize(21);
                );
            .get();  
                .get();
        phrase.boost(boost);  
                "field1",
        resp = req.setQuery(queryStringQuery("run foo.plain:running^5 scissors").field("foo")).get();
                .indices()
            .startObject("field2")
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                        .boundaryScannerType(BoundaryScannerType.WORD)
        String text2 = "I am short";
        }  
                "type=text,term_vector=with_positions_offsets",
        index("test", "type1", "1", "field1", "The <b>quick<b> brown fox", "field2", "The <b>slow<b> brown fox");
                    XContentFactory.jsonBuilder()
        mappings.endObject();
                    .field("type", "text")
    public void testSourceLookupHighlightingUsingFastVectorHighlighter() throws Exception {  
            .query(termQuery("field1", "quick"))
        ensureGreen();
                    .field("type", "text")
    }
    }  
    }
                    .field("type", "text")
        ).highlighter(highlight().field("field2").order("score").preTags("<x>").postTags("</x>"));
                "type=text," + randomStoreField() + "term_vector=with_positions_offsets,index_options=offsets"
                .setQuery(constantScoreQuery(matchQuery("text", "text")))
                    .endObject()
                        + "This one contains no matches.",  
                    .endObject()
                        )
                        + "This one contains no matches." }
                    .field("type", "text")
            client().prepareSearch("test").setSource(searchSource),
            .startObject("alias")
        assertAcked(prepareCreate("test").setMapping("keyword", "type=keyword"));
            "field2",
                        .endObject()  
            assertHighlight(search, 1, "tags", 0, 1, equalTo("<em>foo bar</em>"));
                1,  
        resp = req.setQuery(queryStringQuery("running scissors").field("foo.plain").field("bar"))
    public void testFSHHighlightAllMvFragments() throws Exception {
        indexRandomForConcurrentSearch("test");  
            indexRequestBuilders[i] = client().prepareIndex("test")  
        settings.put("index.analysis.analyzer.mock_english.tokenizer", "standard");  
        ensureGreen();
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();  
            searchResponse = client().prepareSearch()
                .setSource("title", "This is a test for the postings highlighter");
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
    public void testPostingsHighlighterWildcardQuery() throws Exception {
                jsonBuilder().startObject()
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field).noMatchSize(21)).get();  
                "title",
        ensureGreen();
            "tags",
        indexRandomForConcurrentSearch("test");
        field.highlighterType("fvh");
        client().prepareIndex("test").setId("1").setSource("title", "this is a test").get();  
    }
                new String[] { "this is a test", "this is the second test" },
            .setSource(  
import org.hamcrest.Matcher;
    }
            field.highlighterType(type).noMatchSize(text.length() * 2).numOfFragments(0);  
                .get();
                "type=text," + randomStoreField() + "term_vector=with_positions_offsets,index_options=offsets"
        // Query string boosting the field
            .setQuery(matchQuery("title.key", "this is a test"))
                .highlighter(highlightBuilder);
            .highlighter(new HighlightBuilder().encoder("html").field("title.key", 50, 1))
            assertThat(r1.getHits().getTotalHits().value(), equalTo(1L));  
            .get();  
            "The <b>quick<b> brown fox. Second sentence.",
            0,  
            logger.info("--> highlighting and searching on 'field' with sentence boundary_scanner");
                "byte",
                    .startObject("key")  
            .setId("1")
                        .endObject()
                "type=integer",  
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
        for (String type : ALL_TYPES) {
                        .setCorners(new GeoPoint(48.934059, 41.610741), new GeoPoint(-23.065941, 113.610741))  
                        .startObject("fields")
            .field("analyzer", "whitespace")
                        .boundaryScannerType(BoundaryScannerType.WORD)  
                jsonBuilder().startObject()  
            .highlighter(new HighlightBuilder().field("tags", -1, 0).highlighterType("fvh"))
        String value = new String(new char[1024 * 256 / pattern.length()]).replace("\0", pattern);
        SearchResponse response = client().prepareSearch("test")
        // Try with a bool query
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
        assertHighlight(response, 0, "text", 0, 2, equalTo("This is the <em>third</em> sentence. This is the fourth sentence."));
                "no_long_term",
        // search on title.key and highlight on title  
            assertHighlight(response, 0, "text", 0, hlQueryMatcher);
        resp = req.setQuery(twoFieldsQuery).highlighter(new HighlightBuilder().field(fooField).field(barField)).get();
            .numOfFragments(1)
        resp = req.setQuery(queryStringQuery("foo.plain:running^5 scissors").field("foo")).get();
        Map<String, HighlightField> highlightFieldMap = searchResponse.getHits().getAt(0).getHighlightFields();
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
        logger.info("--> highlighting and searching on field1");
            .field("analyzer", "keyword")
        refresh();
                searchResponse,  
                    .field("store", false)
        field.highlighterType("fvh");  
            .get();
        refresh();
            .startObject("alias")
        indexRandomForConcurrentSearch("test");  
        assertHighlight(response, 0, "field1", 0, 1, equalTo("The <b>quick<b> brown <1>fox</1>"));  
            .setSource(
                "title",
        }
                    .field(
        );
        assertThat(search.getHits().getTotalHits().value(), equalTo(1L));
        assertHighlight(
            response = search.get();  
                "double",
                    equalTo("<field1>The</field1> <field1>quick</field1> <field1>brown</field1> <field1>fox</field1> jumps over")  
                        .endObject()
                "text",  
            .get();
            .setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy quick dog")
                    }  
        }  
        assertAcked(prepareCreate("test").setMapping(mappings));
    public void testHighlightIssue1994() throws Exception {  
        createIndex("test");
 * license agreements. See the NOTICE file distributed with
            .get();
    public void testBoostingQuery() throws InterruptedException {  
                    .endObject()
                    .endObject()
            @Override
        SearchResponse response = client().prepareSearch("test")  
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("The <em>quick</em> brown fox jumps over"));
                jsonBuilder().startObject()
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
        SearchResponse search = client().prepareSearch()
            .highlighter(highlight().field("field2").order("score").preTags("<xxx>").postTags("</xxx>"));
                    .fragmentSize(1)
            .startObject()
            searchResponse,
            equalTo("The <xxx>quick</xxx> brown fox jumps over the lazy <xxx>quick</xxx> dog")  
            .field("copy_to", "foo_text")
            .startObject("properties")
            // (https://github.com/elastic/elasticsearch/issues/4103)
        createIndex("test");
    }
    }
            .setSize(COUNT)
        }  
        SearchResponse response = search.setQuery(boolQuery().must(terms).should(phrase)).get();
        SearchResponse response = client().prepareSearch("test")
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("The quick <x>brown</x> fox jumps over the lazy dog! Second sentence."));  
            .get();
    public void testMultiMapperVectorFromSource() throws Exception {
    public HighlighterSearchIT(Settings staticSettings) {
        assertHighlight(searchResponse, 0, "field-fvh", 0, 1, equalTo("This is the <xxx>test</xxx> with term_vectors"));
 * compatible open source license.
            )  
                new HighlightBuilder().field(
            .get();
                    .field("term_vector", "no")
        );
            .endObject();  
        searchResponse = client().search(searchRequest("test").source(source)).actionGet();
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("The quick <x>brown</x> fox jumps over the lazy dog"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            .setQuery(termQuery("field1", "test"))
            search.getHits().getAt(0).getHighlightFields().get("keyword_field").getFragments()[0].string(),  
    }
                .setId(Integer.toString(i))  
            .requireFieldMatch(requireFieldMatch);
                    .startObject("attachments")  
            )
        searchResponse = client().prepareSearch("test").setSource(source).get();  
        for (String type : ALL_TYPES) {
            .setQuery(matchQuery("text", "foo"))
        XContentBuilder mappings = jsonBuilder().startObject()
            .setQuery(matchQuery("title", "bug"))
                        .field("store", true)
                0,
        assertHighlight(  
                0,  
                    .field("store", true)
                .setSource("title", "This is a test on the highlighting bug present in opensearch");  
            .setQuery(matchQuery("title", "This is a Test"))
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("yet another <field2>test</field2>"));
            );
            .highlighterType("fvh")
        field.highlighterType("unified");  
            .order("score")
            indexRequestBuilders[i] = client().prepareIndex("test")
            .setId("1")
            .get();
            .endObject()  
            highlighterType,
import static org.opensearch.index.query.QueryBuilders.boostingQuery;  
        assertThat(search.getHits().getAt(0).getHighlightFields().get("text").fragments().length, equalTo(1));  
                2,  
            .get();
        );  
        );  
            .startObject("text")  
        );
            .setId("2")  
            .highlighterType("fvh")  
        refresh();  
        ensureGreen();
        assertHighlight(
                .setQuery(constantScoreQuery(matchQuery("text", "text")))  
        refresh();
                highlight().highlighterType("fvh")
    public void testHighlightNoMatchSizeWithMultivaluedFields() throws IOException, InterruptedException {  
    }
            .get();
        assertAcked(  
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));
                0,
        XContentBuilder mappings = jsonBuilder().startObject()
            .get();
                .setId(Integer.toString(i))  
            .highlighter(highlight().field(new Field("field1").numOfFragments(5).preTags("<field1>").postTags("</field1>")));  
                "text",  
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
            prefixes.put(String.valueOf(i), prefix);  
                .setId(Integer.toString(i))
        // lets fall back to the standard highlighter then, what people would do to highlight query matches  
    // TODO as we move analyzers out of the core we need to move some of these into HighlighterWithAnalyzersTests
        for (int i = 0; i < 5; i++) {
        // same as above but in this example the query gets rewritten during highlighting
                    .endObject()  
            "cat cat junk junk junk junk junk junk junk cats junk junk"  
                )
        client().prepareIndex("test").setId("1").setSource("title", "this is a test").get();
            .field("type", "text")
                    .endObject()
            )
                    .startObject("fields")
        client().prepareIndex("test")  
            equalTo("here is another one that is very long and has the <em>tag</em> token near the end")
            .highlighter(highlight().forceSource(true).field("field1"));
        barField.matchedFields("bar", "bar.plain");  
            "field1",
            prepareCreate("test").setSettings(settings)
        client().prepareIndex("test")  
        assertHighlight(search, 0, "title.key", 0, 1, equalTo("<em>this</em> <em>is</em> <em>a</em> <em>test</em>"));  
                .get();
        assertHighlight(search, 0, "alias", 0, equalTo("<em>foo</em>"));  
            searchResponse,
            .endObject();
                .requireFieldMatch(randomBoolean());  
        // Mock tokenizer will throw an exception if it is resetted twice  
            .startObject("foo_text")  
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                anyOf(equalTo("<xxx>some</xxx> quick and hairy brown"), equalTo("<xxx>some</xxx>"))
            assertNoFailures(search);
        phraseBoostTestCaseForClauses(  
        assertHighlight(resp, 0, "foo", 0, equalTo("junk junk <em>cats</em> junk junk"));
        // And noMatchSize returns nothing when the first entry is empty string!
            } else {  
        SearchResponse searchResponse = client().prepareSearch("test")
    // Issue #3200
        searchSource = SearchSourceBuilder.searchSource()  
                .should(constantScoreQuery(queryStringQuery("field1:photo*")))
            assertNotHighlighted(search, i, "title");
        settings.put(indexSettings());
        client().prepareIndex("test").setId("1").setSource("text", "foo").get();
            }  
            .setQuery(matchQuery("title", "test"))
                0,  
            assertHighlight(search, 0, "alias", 0, equalTo("<em>foo</em>"));
                .highlighter(new HighlightBuilder().field(new Field("tags")).numOfFragments(2).boundaryScannerType(scanner))
                    )
                );
        settings.put("index.analysis.analyzer.mock_english.filter", "mock_snowball");
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterBuilder = new FunctionScoreQueryBuilder.FilterFunctionBuilder(  
            .field("type", "text")
import static org.opensearch.index.query.QueryBuilders.prefixQuery;
        indexRandomForConcurrentSearch("test");
    }  
            .startObject("foo")  
        assertAcked(prepareCreate("test").setMapping(mappings));  
        client().prepareIndex("test")  
            .highlighter(highlight().field("field*").preTags("<xxx>").postTags("</xxx>").requireFieldMatch(false));
        for (int i = 0; i < 5; i++) {
        for (int i = 0; i < indexRequestBuilders.length; i++) {
        assertHighlight(response, 0, "text", 0, 2, equalTo("This is the <em>third</em> sentence. This is the fourth sentence."));  
            .highlighter(new HighlightBuilder().field(new Field("field1").preTags("<xxx>").postTags("</xxx>")))  
    public void testMultiMapperNoVectorFromSource() throws Exception {  
        client().prepareIndex("test").setId("1").setSource("text", "opensearch test").get();
        field.highlighterType("fvh");
        for (String type : new String[] { "unified", "plain" }) {  
                    .startObject("attachments")
        logger.info("--> searching on field2, highlighting on field2");  
                    .endObject()
            .field("index_options", "offsets")
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
        ).highlighter(highlight().field("field1"));  
        client().prepareIndex("test").setSource("field1", "this is a test", "field2", "aaab").get();
        indexRandomForConcurrentSearch("test");
            1,  
            .setQuery(matchPhraseQuery("title", "this is a test"))
            .get();
    public void testHighTermFrequencyDoc() throws IOException, InterruptedException {
            SearchResponse searchResponse = client().prepareSearch()
                        "tags",
    public void testHighlightNoMatchSize() throws IOException, InterruptedException {  
            indexRequestBuilders[i] = client().prepareIndex("test")
            .get();
        assertHighlight(search, 0, "titleTV", 0, equalTo("This is a test on the highlighting <em>bug</em> present in opensearch"));
import org.apache.lucene.tests.util.TimeUnits;
            .fragmentSize(25)
        );  
    public void testMissingStoredField() throws Exception {  
                            + "The lazy red <field1>fox</field1> jumps over the quick dog. "
        assertThat(field.getFragments()[0].string(), equalTo("<em>brown</em>"));
            prepareCreate("test").setMapping(
        indexRandom(true, indexRequestBuilders);  
            .setSource("keyword", "Hello World")
    }
                    + "The quick brown dog jumps over the lazy fox."
    }
        refresh();  
                "field2",  
        SearchResponse searchResponse = client().search(searchRequest("test").source(source)).actionGet();
            .field("type", "text")
                .get();
            .get();
        fooField.matchedFields("foo", "foo.plain");  
                    .highlighter(new HighlightBuilder().field("*"))  
                    + "The quick brown dog jumps over the lazy fox.",
        field.highlighterType("plain").noMatchSize(21);
        b.startObject("foo");
            );
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();  
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("text", "third fifth");  
        String text3 = "This is the fifth sentence";
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();  
        // Now make half the matches come from the stored field and half from just a matched field.  
import static org.opensearch.index.query.QueryBuilders.nestedQuery;  
                anyOf(equalTo("Another <xxx>sentence</xxx> with"), equalTo("Another <xxx>sentence</xxx> with even more words. "))
            field1.fragments()[0].string(),  
        refresh();
            .highlighter(new HighlightBuilder().encoder("html").field("title", 30, 1, 10).highlighterType("plain"))
    /**  
            )
                    public Analyzer get() {  
        // simple search on body with standard analyzer with a simple field query
        assertHighlight(search, 0, "no_long_term", 0, 1, equalTo("a <b>test</b> where <b>foo</b> is <b>highlighed</b> and"));
            .requireFieldMatch(requireFieldMatch);  
                    .endObject()
            searchResponse,
        // Match queries
                        .endArray()  
        );  
        assertHighlight(response, 0, "text", 0, 1, equalTo("This is the first"));
                    .field("analyzer", "classic")  
                    .field("index_options", "docs")
        refresh();  
            SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();  
        assertHighlight(search, 0, "name", 0, startsWith("<em>abc</em> <em>abc</em> <em>abc</em> <em>abc</em>"));  
    }
    public void testCopyToFields() throws Exception {
            .endObject();  
        client().prepareIndex("test")
        client().prepareIndex("test")
        settings.put("index.analysis.analyzer.mock_english.filter", "mock_snowball");
                    .endArray()
            highlighterType,  
        SearchSourceBuilder source = searchSource().query(commonTermsQuery("field2", "quick brown").cutoffFrequency(100))
                        .boundaryScannerLocale(Locale.ENGLISH.toLanguageTag())  
            prepareCreate("test").setMapping(
            .field("index_options", "offsets")
                    .startObject("properties")  
                .get()  
import org.opensearch.index.query.MatchQueryBuilder;
            equalTo("This is the first <xxx>test</xxx> sentence. Here is the second one.")  
        client().prepareIndex("test")
                    .endObject()
            .endObject()
            highlighterType,
            )  
                    .endObject()
        indexRandomForConcurrentSearch("test");
        resp = req.setQuery(queryStringQuery("running scissors").field("foo")).get();
                "field-postings",
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    .startObject("title")  
            1,  
        logger.info("--> highlighting and searching on 'field' with word boundary_scanner");
                    .field("text", "cow")
        SearchResponse response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
        assertAcked(
        );
            .setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog! Second sentence.")
    }
                    .field("term_vector", "with_positions_offsets")
            .get();
        ensureGreen();
            .startObject("foo")
    }
        field.highlighterType("unified");  
        // Now remove the stored field from the matched field list. That should work too.
            .get();
            .field("type", "keyword")
        client().prepareIndex("test")  
        refresh();  
                    .endObject()
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
            .get();  
            );  
                        .endObject()
                0,
                    )  
        HighlightField field = searchResponse.getHits().getAt(0).getHighlightFields().get("foo_text");
        // For unified and fvh highlighters we just check that the nested query is correctly extracted  
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();  
            .get();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;
            .get();
            .setQuery(matchQuery("long_term", "thisisaverylongwordandmakessurethisfails foo highlighed"))
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();  
            .field("type", "geo_point")
import static org.opensearch.index.query.QueryBuilders.wildcardQuery;  
        IdsQueryBuilder idsQueryBuilder = QueryBuilders.idsQuery().addIds("2");
        indexRandomForConcurrentSearch("test");
        req = client().prepareSearch("test").highlighter(new HighlightBuilder().field(fooField));
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("The <xxx>quick</xxx> brown fox jumps over the lazy dog"));
        fooField.matchedFields("foo.plain");  
        String mapping = jsonBuilder().startObject()  
        assertFailures(
    }
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
                    .field("term_vector", "with_positions_offsets")  
    public void testWithNormalizer() throws Exception {  
            .startObject("text")
                    )
import java.util.List;
            assertThat(field.getFragments().length, equalTo(1));
                    .startObject("fields")
            .field("type", "nested")
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so"));
import org.opensearch.search.SearchHit;
        indexRandom(true, indexRequestBuilders);  
            "test",
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
            1,
                        .postTags("</xxx>")
        SearchSourceBuilder source = searchSource().query(fuzzyQuery("field2", "quck")).highlighter(highlight().field("field2"));
            )
    public void testHighlightingOnWildcardFields() throws Exception {
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("The <em>photography</em> word will get highlighted"));
            .endObject()  
        assertThat(field.getFragments().length, equalTo(2));  
        logger.info("--> highlighting and searching on field1");  
        // You can set noMatchSize globally in the highlighter as well  
            searchResponse,
            true,  
            .setId("1")
                1,  
                    .startObject("properties")
            SearchResponse searchResponse = client().prepareSearch()
            equalTo("The <em>quick</em> brown fox jumps over the lazy dog! Second sentence.")
    public void testFastVectorHighlighter() throws Exception {  
        indexRandomForConcurrentSearch("test");
            .setId("1")
                "The quick brown fox jumps over the lazy dog. The lazy red fox jumps over the quick dog. "  
            .get();
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();  
        }
            .highlighter(new HighlightBuilder().field(new Field("field1").preTags("<1>").postTags("</1>").requireFieldMatch(true)))
                    .endObject()
        field.highlighterType("plain");
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        createIndex("test");
import org.opensearch.index.analysis.AnalyzerProvider;  
        for (int i = 0; i < COUNT; i++) {  
        ensureGreen();
                .setMapping(
        client().prepareIndex("test")  
        public List<PreConfiguredTokenFilter> getPreConfiguredTokenFilters() {  
        refresh();  
        for (int i = 0; i < indexRequestBuilders.length; i++) {
            .get();  
            assertHighlight(search, i, "title", 1, 2, equalTo("This is the second <em>bug</em> to perform highlighting on."));
            .highlighter(new HighlightBuilder().field("title", 50, 1, 10).highlighterType("plain"))
            // generating text with word to highlight in a different position  
        indexRandomForConcurrentSearch("test");  
                    .endObject()  
                    .preTags("<global>")
        );
        );
            .setSource("keyword", "Hello World")
            .get();  
                        .field("body", "attachment 2")
    }
                        .field("term_vector", "with_positions_offsets")
                "type=text,term_vector=with_positions_offsets",
            .get();  
    }
        SearchSourceBuilder source = searchSource().query(termQuery("field1", "test"))  
        );
            "field-postings",  
        indexRandomForConcurrentSearch("test");
        assertFailures(
        logger.info("--> indexing docs");  
        client().prepareIndex("test").setId("1").setSource(jsonBuilder().startObject().field("text", "foo").endObject()).get();
                    .endObject()
        );
            .get();
        refresh();
    }  
    public void testHighlightNoMatchSizeNumberOfFragments() throws IOException, InterruptedException {  
        }
                .setQuery(nestedQuery("foo", prefixQuery("foo.text", "bro"), ScoreMode.None))
                        new Field("tags").highlighterType("plain").fragmentSize(-1).numOfFragments(2).fragmenter("invalid")
            queryStringQuery("\"highlight words together\"").field("field1")  
        ensureSearchable("index-1");
                .setQuery(matchQuery("keyword", "hello world"))  
    private static XContentBuilder type1PostingsffsetsMapping() throws IOException {
                .setId(Integer.toString(i))
                );
        refresh();  
            String prefix = prefixes.get(hit.getId());
        assertThat(field.getFragments().length, equalTo(1));
            HighlightBuilder highlightBuilder = new HighlightBuilder().field(field).highlighterType(type);
        refresh();
        client().prepareIndex("test").setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog").get();
            assertHighlight(search, i, "title", 0, 1, startsWith("This is a html escaping highlighting <em>test</em> for *&amp;?"));  
        assertFailures(  
            )
        SearchResponse search = client().prepareSearch()  
            assertThat(field.getFragments()[0].string(), equalTo("<em>brown</em> cat"));  
            .setId("1")  
        assertAcked(
        logger.info("--> highlighting and searching on field1 and field2 produces different tags");
    public static class MockAnalysisPlugin extends Plugin implements AnalysisPlugin {
        SearchResponse searchResponse = client().prepareSearch()
        for (SearchHit hit : searchResponse.getHits()) {
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));  
            .highlighter(new HighlightBuilder().field("long_term", 18, 1).highlighterType("fvh"))
            assertThat(field.getFragments().length, equalTo(1));
        indexRandomForConcurrentSearch("test");
        );
                "type=byte",
        logger.info("--> searching explicitly on field1 and highlighting on it");
            .order("score")
                        .field(new Field("field1").requireFieldMatch(true).preTags("<field1>").postTags("</field1>"))  
                .setQuery(nestedQuery("foo", matchPhraseQuery("foo.text", "brown cat"), ScoreMode.None))  
        mappings.startObject("properties")  
import org.opensearch.common.settings.Settings;
            .startObject("properties")  
        ensureGreen();  
            assertHighlight(  
        indexRandomForConcurrentSearch("test");  
                    .startObject("properties")
                    .field("analyzer", "classic")  
            SearchResponse response = search.get();
        assertFailures(  
            prepareCreate("test").setMapping(
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();  
        indexRandomForConcurrentSearch("test");
            boolQuery().must(queryStringQuery("field1:photo*")).mustNot(existsQuery("field_null"))  
        indexRandomForConcurrentSearch("test");
                        .startObject()  
        }  
                    .endObject()
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();
            .field("index_options", "offsets")
            highlighterType,  
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so some"));
            assertHitCount(searchResponse, 1);  
            );  
        ensureGreen();
        fooField = new Field("foo").numOfFragments(1)
                    highlight().field("field1", 23, 1)
        }  
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();  
        assertThat(
        }
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];  
        assertHitCount(response, 1L);
        response = search.setQuery(boostingQuery(phrase, terms).boost(boost).negativeBoost(1)).get();
            search = client().prepareSearch("test").setQuery(QueryBuilders.matchQuery("text", "testing")).highlighter(highlightBuilder);
            "1",  
            )  
        refresh();
import org.opensearch.search.builder.SearchSourceBuilder;
        createIndex("test");
        assertAcked(
        for (int i = 0; i < 5; i++) {
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("The <em>photography</em> word will get highlighted"));  
        SearchResponse response = client().prepareSearch("test")  
    public void testPostingsHighlighterBoostingQuery() throws IOException, InterruptedException {  
        Builder builder = Settings.builder().put(indexSettings()).putList("index.analysis.normalizer.my_normalizer.filter", "lowercase");
        );
        field.highlighterType("fvh");
            containsString("source is forced for fields [field1] but _source is disabled")  
        }  
            queryStringQuery("highlight words together").field("field1").field("field2"),  
        assertHighlight(searchResponse, 0, "field1", 0, 2, equalTo("<global>test</global>"));
        source = searchSource().query(matchQuery("field2", "quick"))  
        // Now make sure boosted fields don't blow up when matched fields is both the subfield and stored field.  
        indexRandomForConcurrentSearch("test");
                "type=text,store=false",
    public void testFastVectorHighlighterOffsetParameter() throws Exception {  
                        .startObject("foo")
package org.opensearch.search.fetch.subphase.highlight;
                );
        ensureGreen();
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
import org.opensearch.plugins.AnalysisPlugin;
/*
        assertHighlight(hit, "title", 0, 1, equalTo("this is a <em>test</em> . Second sentence."));
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
            prepareCreate("test").setMapping(
        assertThat(searchResponse.getHits().getHits().length, equalTo(COUNT));  
        refresh();
    }
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so some"));
        settings.put(indexSettings());  
                    .startObject("properties")  
        assertHighlight(
            )
                    XContentFactory.jsonBuilder()  
            )
                .setSource("title", "This is a html escaping highlighting test for *&? opensearch");
        assertHighlight(response, 0, "field1", 0, 1, equalTo("The <b>quick<b> brown <1>fox</1>"));
import static org.opensearch.index.query.QueryBuilders.multiMatchQuery;
        SearchResponse searchResponse = client().search(searchRequest("test").source(source)).actionGet();  
    public void testHighlightingWhenFieldsAreNotStoredThereIsNoSource() throws IOException, InterruptedException {  
            .get();
    }
                    .field("type", "text")
                    .field("store", false)
        ensureGreen();  
        client().prepareIndex("test")  
            .highlighter(new HighlightBuilder().encoder("html").field("title", 50, 1))
        indexRandom(true, indexRequestBuilders);
        indexRandomForConcurrentSearch("test");
    public void testPlainHighlighter() throws Exception {
            assertHighlight(response, 0, "text", 0, 1, equalTo(text));
        indexRandom(true, indexRequestBuilders);  
        ensureGreen();  
        assertAcked(  
            searchResponse,
        indexRandom(true, client().prepareIndex("test").setSource("foo", "test japanese"));
            .endObject()
                    .field("text", "brown")
        // Now just all matches are against the matched field. This still returns highlighting.
        field.highlighterType("unified");  
    }  
                    highlight().field("field1", 21, 2)
                "field-fvh",
        field.highlighterType("unified");  
        QueryBuilder query = QueryBuilders.boolQuery()
            .field("type", "geo_point")
        for (String type : ALL_TYPES) {  
        client().prepareIndex("test")  
                .get();
            0,
            .setSource(jsonBuilder().startObject().field("unstored_text", "text").field("text", "text").endObject())  
            .highlighter(new HighlightBuilder().field("title").encoder("html"))  
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
                        "here is another one that is very long tag and has the tag token near the end"
        assertAcked(
            .endObject();
            SearchSourceBuilder source = searchSource().query(termQuery("field1", "sentence"))  
        // search on title.key and highlight on title.key
        b.endObject().endObject();  
    }  
            field1.fragments()[1].string(),
    }  
            .setId("2")
        assertAcked(  
                    .endObject()
                } else return false;
        search = client().prepareSearch()  
        for (SearchHit searchHit : searchResponse.getHits()) {
        ensureGreen();  
        for (String type : new String[] { "unified", "fvh" }) {
     */
                    .field("term_vector", "with_positions_offsets")  
                            .postTags("</field2>")  
            return "store=true,";
            searchResponse,
        assertAcked(  
            .highlighter(new HighlightBuilder().field("title", -1, 2).field("titleTV", -1, 2).requireFieldMatch(false))
                        .endObject()  
        );
    }  
        SearchRequestBuilder searchRequestBuilder = client().prepareSearch()  
            .setSource(  
        SearchResponse searchResponse = client().search(searchRequest("test").source(source)).actionGet();
                0,  
            .get();  
            0,
        search = client().prepareSearch()
import org.apache.lucene.analysis.Analyzer;
            containsString("IndexOutOfBoundsException")
        for (int i = 0; i < 6000; i++) {
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so"));  
        SearchSourceBuilder source = searchSource().query(
            assertThat(field.getFragments()[1].string(), equalTo("<em>cow</em>"));  
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[COUNT];
                        .postTags("</xxx>")
                        new HighlightBuilder.Field("field2").preTags("<field2>")
        }
                    .field("store", false)
            0,
        refresh();  
            .setQuery(matchQuery("title", "bug"))  
        );
                .setQuery(matchQuery("foo", "test"))  
                        .endObject()  
            equalTo("This <em>sentence</em> contains three <em>sentence</em> occurrences (<em>sentence</em>).")
        SearchResponse search = client().prepareSearch()  
        return XContentFactory.jsonBuilder()
        );  
        // We can also ask for a fragment exactly the size of the input field and get the whole field
        assertAcked(prepareCreate("test").setMapping(mappings));
        fooField = new Field("foo").numOfFragments(1)
            equalTo("here is another one that is very <em>long</em> <em>tag</em> and has the tag token near the end")
                i,
        }  
        @Override
            .get();
                        .highlighterType(type)
                    .field("type", "text")  
                    .field("text", "brown")
            prepareCreate("test").setMapping(  
        XContentBuilder b = jsonBuilder().startObject().startObject("properties");  
            .field("term_vector", "with_positions_offsets")
            .highlighterType("fvh")
                        .endObject()
            assertHighlight(
                anyOf(equalTo("A <xxx>sentence</xxx> with few words"), equalTo("A <xxx>sentence</xxx> with few words. "))
            .startObject("loc")  
        refresh();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
                    .startObject("body")
            1,  
    public void testPlainHighlightDifferentFragmenter() throws Exception {  
            new RandomScoreFunctionBuilder()
}
                jsonBuilder().startObject()
            .get();
            .highlighter(new HighlightBuilder().field("attachments.body", -1, 0))
        logger.info("--> highlighting and searching on field1");  
            field.highlighterType(type).highlightQuery(null);
        assertAcked(prepareCreate("test").setMapping(mappings));
                i,
        assertHighlight(
            .setSource(
            .setId("1")  
                .highlighter(new HighlightBuilder().field(new Field("keyword").highlighterType(highlighterType)))
            .field("term_vector", "with_positions_offsets")
            .setQuery(QueryBuilders.matchQuery("field1", "fox"))
                    .startObject("fields")
import static org.opensearch.index.query.QueryBuilders.commonTermsQuery;
            .highlighter(new HighlightBuilder().field(fooField).field(barField))  
        assertAcked(prepareCreate("test").setMapping(mappings));
        field.highlighterType("unified");
        assertHitCount(response, 1L);
            prepareCreate("test").setMapping(
    }  
            prepareCreate("test").setMapping(  
                        .startObject("plain")
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));  
            RestStatus.BAD_REQUEST,
            equalTo("The <em>quick</em> brown fox jumps over the lazy dog! Second sentence.")
        }
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("The <em>photography</em> word will get highlighted"));
                assertHighlight(searchHit, "field1", 2, 3, equalTo("The quick brown dog jumps over the lazy <field1>fox</field1>."));
        Settings.Builder settings = Settings.builder();
            HighlightBuilder builder = new HighlightBuilder().field(new Field("alias").highlighterType(type))
                    .field("store", true)
        mappings.endObject();
                2,  
    public void testPostingsHighlighterRegexpQueryWithinConstantScoreQuery() throws Exception {
            0,  
                1,  
        assertHighlight(defaultPhraseLimit, 0, "field1", 0, 1, containsString("<xxx>t</xxx>"));
        indexRandomForConcurrentSearch("test");
        indexRandomForConcurrentSearch("test");
            1,
            .field("type", "alias")
                    .field("term_vector", "with_positions_offsets")  
                0,
            0,
        field.highlighterType("unified");
                    .field("analyzer", "whitespace")
            .field("index_options", "offsets")
        SearchResponse search = client().prepareSearch()
                        .field("type", "text")  
                );
        searchResponse = client().search(searchRequest("test").source(source)).actionGet();
            .startObject("foo")  
                        .endObject()  
                    .startObject("properties")
            .startObject("properties")
                    highlight().field("field1", 23, 1)
        logger.info("--> highlighting and searching on field1 with default phrase limit");
            assertHighlight(  
        indexRandomForConcurrentSearch("test");
                    0,  
            .endObject();
        assertNotHighlighted(response, 0, "text");
            "type1",
                    .endObject()
            SearchResponse searchResponse = client().prepareSearch()
            .setQuery(matchPhraseQuery("title", "test for the workaround"))  
                    .field("store", false)  
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>weird</em>"));
            )
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];  
        mappings.startObject();
    }
                    .endObject()
            .endObject()
import static org.opensearch.search.builder.SearchSourceBuilder.searchSource;  
        HighlightBuilder.Field field = new HighlightBuilder.Field("text").fragmentSize(1)
        refresh();  
    }
        refresh();
            0,
            prepareCreate("test").setMapping(
        assertHighlight(search, 0, "title", 0, 1, equalTo("this is a <em>test</em>"));
        SearchResponse searchResponse = client().prepareSearch()
                jsonBuilder().startObject()  
        );
        resp = req.setQuery(queryStringQuery("foo.plain:running scissors").field("foo")).get();  
    }
                        .field("body", "attachment 1")
            .setQuery(matchQuery("attachments.body", "attachment"))
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();  
    public void testFastVectorHighlighterMultipleFields() throws InterruptedException {
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();
    public void testHighlighterWithWordBoundaryScanner() throws Exception {
        SearchResponse largePhraseLimit = client().search(searchRequest("test").source(source)).actionGet();
                    .field("type", "text")
        refresh();  
                            "title",
import static org.opensearch.index.query.QueryBuilders.boolQuery;
        SearchResponse searchResponse = searchRequestBuilder.get();
            .highlighterType("fvh")  
     * Test phrase boosting over normal term matches.  Note that this will never pass with the plain highlighter
            .highlighter(new HighlightBuilder().encoder("html").field("title.key", 50, 1))  
        public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
            .highlighter(new HighlightBuilder().field(new Field("text")))
                    .startObject("properties")
        client().prepareIndex("test")  
            )
            b.field("copy_to", "foo_copy");
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
            true,
        search = client().prepareSearch()
                    .endObject()  
            indexRequestBuilders[i] = client().prepareIndex("test")
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();
 * ownership. Elasticsearch licenses this file to you under  
                        .endObject()
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
            .setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog! Second sentence.")
            "foo",  
                    "field1",
        SearchResponse searchResponse = client().prepareSearch()
                            "This is the second bug to perform highlighting on."  
            .highlighter(new HighlightBuilder().field(new Field("text")))  
import static org.opensearch.index.query.QueryBuilders.existsQuery;  
                        .preTags("<xxx>")
            .startObject("properties")
        assertHighlight(search, 0, "title.key", 0, 1, equalTo("<em>this</em> <em>is</em> <em>a</em> <em>test</em>"));
    public void testEscapeHtmlVector() throws Exception {
        // simple search on body with standard analyzer with a simple field query
                        .startObject()  
            .noMatchSize(20);
                "type=text," + randomStoreField() + "term_vector=with_positions_offsets,index_options=offsets"
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));  
        search = client().prepareSearch()
 * You may obtain a copy of the License at  
                    .preTags("<xxx>")
                        .should(QueryBuilders.termQuery("field", "hello"))
        }  
        ensureGreen();  
                if (input.incrementToken()) {
                    .field("analyzer", "classic")
        logger.info("--> highlighting and searching on field2");
        indexRandomForConcurrentSearch("test");
                    .array(
        }
        refresh();
import org.opensearch.common.geo.GeoPoint;
    }
        phrase.boost(1);  
                equalTo("This is a test on the highlighting <em>bug</em> " + "present in opensearch")
            .get();  
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
            .get();
        indexRandomForConcurrentSearch("test");
        field.highlighterType("plain");
                .setQuery(constantScoreQuery(matchQuery("text", "text")))
                    XContentFactory.jsonBuilder()
        ensureGreen();
            0,
        client().prepareIndex("test")
        fooField.matchedFields("foo.plain");
            .setId("1")  
            .setSource(jsonBuilder().startObject().field("text", "Arbitrary text field which will should not cause a failure").endObject())  
        assertNotHighlighted(response, 0, "text");
                        return instance;
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));  
            .highlighter(new HighlightBuilder().field("name"))
            .highlighter(new HighlightBuilder().encoder("html").field("title", 50, 1, 10))
                    .field("type", "text")
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];  
        ensureGreen();
                .highlighter(new HighlightBuilder().field(new Field("*").highlighterType(highlighterType).requireFieldMatch(false)))  
        // The FVH also works but the fragment is longer than the plain highlighter because of boundary_max_scan  
        refresh();
        );
        P phrase
            .get();  
            .field("type", "keyword")
        refresh();
        // if there's a match we only return the values with matches (whole value as number_of_fragments == 0)
                    .field("loc", "12.934059,77.610741")
    }  
        assertNotHighlighted(response, 0, "text");
            )
            .field("index_options", "offsets")
                    .field("type", "text")  
                i,  
                    .startObject("title")
import java.io.IOException;
        );
    public void testFieldAliasWithSourceLookup() throws IOException, InterruptedException {  
import org.apache.lucene.analysis.TokenFilter;
            .startObject("foo")
            .get();  
        refresh();  
            .field("type", "text")
        client().prepareIndex("test").setSource("field1", "The photography word will get highlighted").get();
                );  
            assertHitCount(searchResponse, 1L);
                    XContentFactory.jsonBuilder()
        client().prepareIndex("test").setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog").get();  
/*
            assertThat(field.getFragments()[0].string(), equalTo("<em>brown</em>"));
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();  
        assertHighlight(searchResponse, 0, "field1", 1, 2, equalTo("<global>test</global>"));  
            .endObject()
        }  
        assertAcked(  
            .get();
            prepareCreate("test").setMapping(  
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));  
            SearchResponse search = client().prepareSearch()
                    .field("type", "text")
            .setQuery(matchQuery("title", "bug"))
            searchResponse,
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .endObject();  
                        .endObject()
        indexRandom(
                fail("Only hits with id 1 and 2 are returned");
    public void testHighlightingWithStoredKeyword() throws IOException, InterruptedException {  
            .get();  
        }
        assertNotHighlighted(response, 0, "text");  
        String text1 = "I am pretty long so some of me should get cut off. We'll see how that goes.";  
            .endObject()
        ensureGreen();  
    public void testSourceLookupHighlightingUsingPostingsHighlighter() throws Exception {
            RestStatus.BAD_REQUEST,
        indexRandomForConcurrentSearch("test");
                        .startObject()
            .field("type", "text")
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));  
        );
                anyOf(equalTo("Another <xxx>sentence</xxx> with"), equalTo("Another <xxx>sentence</xxx> with even more words. "))
        }
            .get();
            .highlighter(new HighlightBuilder().field("field1", 100, 0))
            .highlighter(new HighlightBuilder().field("title"))  
                    .startObject()
        indexRandomForConcurrentSearch("test");
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
            indexRequestBuilders[i] = client().prepareIndex("test")
        resp = req.setQuery(twoFieldsQuery).highlighter(new HighlightBuilder().field(fooField).field(barField)).get();
            .setQuery(QueryBuilders.matchQuery("field", "highlight"))  
                .setQuery(termQuery("field1", "quick"))  
        for (int i = 0; i < indexRequestBuilders.length; i++) {
        }
        logger.info("--> searching with boundary characters on the field");
        );  
            .highlighter(new HighlightBuilder().field("title"))
    public void testHighlightQueryRewriteDatesWithNow() throws Exception {
        for (int i = 0; i < 10; i++) {  
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder[] { filterBuilder }  
            "field2",
            .highlighter(
            );  
    public void testSameContent() throws Exception {
                "field1",
        client().prepareIndex("test").setId("1").setSource("title", "this is a test").get();
        assertHighlight(search, 0, "title", 0, 1, equalTo("this is a <em>test</em>"));
                    .field(new HighlightBuilder.Field("field1").numOfFragments(2))  
            .endObject();
        refresh();
                        .endObject()
                    .endObject()
        searchResponse = client().search(searchRequest("test").source(source)).actionGet();
    public void testPostingsHighlighterPrefixQueryWithinBooleanQuery() throws Exception {
            .get();  
            prepareCreate("test").setMapping(  
                    QueryBuilders.prefixQuery("text", "bro"),
            .setQuery(constantScoreQuery(matchQuery("name", "abc")))  
                assertHighlight(  
                    .field("term_vector", "no")
        client().prepareIndex("test")
            )
                    .endObject()  
            )
        );
                new String[] {
                    equalTo(
            .setSource(
                );  
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
                .highlighter(  
        client().prepareIndex("test").setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog").get();
                1,
        assertThat(
            assertHighlight(response, 0, "text", 0, hlQueryMatcher);
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));  
                    .endObject()  
            true,
        SearchSourceBuilder source = searchSource().query(termQuery("field1", "test"))
        assertHighlight(resp, 0, "bar", 0, equalTo("<em>cat</em> <em>cat</em> junk junk junk junk"));  
        assertHighlight(
            .setQuery(QueryBuilders.matchQuery("tags", "tag"))  
        indexRandomForConcurrentSearch("test");  
        );  
            req.setQuery(queryStringQuery("result").field("foo").field("foo.plain").field("bar").field("bar.plain")),  
    }
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
            indexRequestBuilders[i] = client().prepareIndex("test").setId(Integer.toString(i)).setSource("field1", "test " + i);
                jsonBuilder().startObject()
            .get();
        );  
        for (int i = 0; i < indexRequestBuilders.length; i++) {
        resp = req.setQuery(queryStringQuery("running scissors").field("foo")).get();  
    public static Collection<Object[]> parameters() {  
        for (String type : ALL_TYPES) {  
    public void testPostingsHighlighterTermRangeQuery() throws Exception {  
            )
        for (int i = 0; i < indexRequestBuilders.length; i++) {
    public XContentBuilder type1TermVectorMapping() throws IOException {
                    // we don't store title, now lets see if it works...
            .get();  
        client().prepareIndex("test").setSource("field1", "The photography word will get highlighted").get();  
            logger.info("--> highlighting and searching on 'field' with sentence boundary_scanner");
    }
                1,
        // We can also ask for a fragment longer than the input string and get the whole string
            });
            .field("term_vector", "with_positions_offsets")
        SearchResponse searchResponse = client().search(searchRequest("test").source(source)).actionGet();
                "type=short",
                    .endObject()
            2,
            final SearchResponse r1 = client().prepareSearch("index-1")  
        client().prepareIndex("test").setId("1").setSource("title", "this is a test").get();
                .get();  
    public void testPostingsHighlighterMultiMapperFromSource() throws Exception {
        mappings.startObject("properties")
        assertHighlight(response, 0, "text", 1, 2, equalTo("This is the <em>fifth</em> sentence"));
        assertAcked(prepareCreate("test").setMapping(mappings));
        }
                    .endObject()
                    .field("text", "brown cat")
            .setQuery(matchQuery("title.key", "this is a test"))
 * software distributed under the License is distributed on an
        indexRandom(true, indexRequestBuilders);
        resp = req.setQuery(queryStringQuery("running scissors").field("foo").field("foo.plain").field("bar").field("bar.plain"))  
        // Using plain highlighter instead of FVH on the field level  
            .should(  
                    QueryBuilders.geoBoundingBoxQuery("loc")
        );
            .setSource(  
        assertAcked(
            .fragmentSize(25)
            client().prepareSearch()
        indexRandomForConcurrentSearch("test");
        // And all matched field via the queryString's field parameter, just in case  
            .endObject()
            .startObject("tags")
            .highlighter(highlight().field(new Field("field1").numOfFragments(0).preTags("<field1>").postTags("</field1>")));
            assertThat(field.getFragments()[0].string(), equalTo("<em>brown</em> <em>cat</em>"));  
    }
            .field("index_options", "offsets")  
            .fragmentSize(25)  
        refresh();  
         * in the neighborhood of 300ms and the large phrase limit is in the
            .setSource(
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));
    }
                    highlight().field("field1", 21, 2)
        return XContentFactory.jsonBuilder()  
        assertAcked(prepareCreate("test").setMapping("title", "type=text,store=true"));
        assertThat(search.getHits().getTotalHits().value(), equalTo(1L));
        assertHighlight(response, 0, "text", 0, 1, equalTo("This is the first sentence"));
                .highlighter(new HighlightBuilder().field(new Field("foo.text").highlighterType(type)))
                    .endObject()
        String text2 = "This is the third sentence. This is the fourth sentence.";
                jsonBuilder().startObject()  
        ensureGreen();
        ensureGreen();
        // search on title.key and highlight on title
                    searchHit,
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();  
        indexRandomForConcurrentSearch("test");
        assertThat(defaultPhraseLimit.getTook().getMillis(), lessThan(largePhraseLimit.getTook().getMillis()));
        for (int i = 0; i < indexRequestBuilders.length; i++) {
            100f,  
                    return true;  
            .setSource(
                        .startObject("plain")  
                    .field("index_options", "offsets")
                    .startObject("title")
        );  
        assertAcked(  
        assertThat(field.getFragments()[0].string(), equalTo("<em>brown</em>"));
                    "here is another one that is very long and has the tag token near the end" }
        );  
            .startObject("field1")  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                    .field("store", false)
            prepareCreate("test").setMapping(  
        ensureGreen();
            .setQuery(matchQuery("title", "bug"))
            .startObject("keyword")
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("The <em>photography</em> word will get highlighted"));
            .highlighter(new HighlightBuilder().encoder("html").field("title.key", 50, 1))
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
        }
            SearchSourceBuilder source = searchSource().query(termQuery("field1", "sentence"))
            "field2",
            assertHighlight(search, 0, "text", 0, equalTo("<em>text</em>"));  
    // Issue #3211
            "field2",
                    .startObject()  
        QueryBuilder query = QueryBuilders.functionScoreQuery(
            .setId("1")  
        SearchSourceBuilder source = searchSource().query(
        XContentBuilder mappings = jsonBuilder();
import static org.hamcrest.Matchers.equalTo;  
                "text",  
 * GitHub history for details.
        field.highlighterType("plain").noMatchSize(null);
            .requireFieldMatch(requireFieldMatch);
        refresh();
                    .startObject("_source")
    }
        assertHighlight(search, 0, "titleTV", 0, equalTo("some text to <em>highlight</em>"));  
        logger.info("--> highlighting and searching on field2");
        client().prepareIndex("test")
                .setSource("title", "This is a test for the enabling fast vector highlighter");
    public void testHighlighterWithSentenceBoundaryScannerAndLocale() throws Exception {  
                        .endObject()
        text.append("highlight words together\n");  
        }
                    .field("term_vector", "no")
        SearchResponse searchResponse = client().prepareSearch()  
                    "The quick brown fox jumps over the lazy dog. Second sentence not finished",
            RestStatus.BAD_REQUEST,
            client().prepareSearch()
                .highlighter(highlight().field("field").preTags("<x>").postTags("</x>"))  
            )
                .setSource("title", "This is a test for the workaround for the fast vector highlighting SOLR-3724");
            .setQuery(matchQuery("title", "test"))
                    .endObject()  
            .endObject()
        SearchSourceBuilder source = searchSource().query(
            .startObject()
            containsString(  
import org.opensearch.index.analysis.AbstractIndexAnalyzerProvider;
                .setId(Integer.toString(i))
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                return new AbstractIndexAnalyzerProvider<Analyzer>(indexSettings, name, settings) {
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
                        .endObject()
                        .endObject()  
    private <P extends AbstractQueryBuilder<P>> void phraseBoostTestCaseForClauses(
                "field1",
                    .field("store", true)  
        assertNotHighlighted(response, 0, "postings");
            assertHighlight(search, i, "attachments.body", 0, equalTo("<em>attachment</em> 1"));  
            .highlighter(new HighlightBuilder().field("attachments.body", -1, 2))  
        indexRandomForConcurrentSearch("test");
    }
            .field("type", "text")  
            .setQuery(termQuery("field1", "test"))  
        ensureGreen();
        Matcher<String> highlightedMatcher = Matchers.either(containsString("<em>highlight words together</em>"))
            RestStatus.BAD_REQUEST,
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            } else if ("2".equals(searchHit.getId())) {
            .highlighter(new HighlightBuilder().field(new Field("text")))  
    }  
        fooField = new Field("foo").numOfFragments(1).order("score").fragmentSize(25).highlighterType("unified");
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field).noMatchSize(21)).get();
                    .field("store", true)
            .highlighter(highlight().field("field1"));
        assertNotHighlighted(response, 0, "text");
            .setId("d33f85bf1e51e84d9ab38948db9f3a068e1fe5294f1d8603914ac8c7bcc39ca1")  
            .toString();
                equalTo("This is a html escaping highlighting <em>test</em> for *&amp;? opensearch")
            client().prepareIndex("test").setSource("field1", "A sentence with few words. Another sentence with even more words.")
        ensureGreen();
            .get();  
            .endObject();  
            .fragmentSize(25)
            queryStringQuery("\"highlight words together\"").field("field1", 100)  
                        .endArray()
import static org.hamcrest.Matchers.containsString;
                        .startObject()
    }
        searchResponse = client().prepareSearch()
        search = client().prepareSearch()
        assertThat(resp.getHits().getAt(0).getHighlightFields(), not(hasKey("bar")));
                0,
            );
    public void testFieldAlias() throws IOException, InterruptedException {  
            .should(QueryBuilders.termQuery("text", "failure"));
                    .startObject("properties")
        SearchResponse search = client().prepareSearch()
    public void testDisableHighlightIdField() throws Exception {
            .field("type", "text")
            "field2",  
    }
            .highlighter(  
            prepareCreate("test").setMapping(
        assertHighlight(searchResponse, 0, "field1", 1, 2, equalTo("The quick brown dog jumps over the lazy <field1>fox</field1>."));
            searchResponse,
        // Setting a matchedField that isn't searched/doesn't exist is simply ignored.
        mappings.startObject();
            .field("term_vector", "with_positions_offsets")  
        source = searchSource().query(termQuery("field1", "t"))
        assertAcked(prepareCreate("test").setMapping(mappings));  
            client().admin()
                searchResponse,
                    .field("type", "text")
            prepareCreate("test").setMapping(
                    .endObject()  
                2,
                        .startObject("fields")
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("this is a <xxx>test</xxx>"));  
            .endObject()  
        SearchSourceBuilder source = searchSource().query(prefixQuery("field2", "qui")).highlighter(highlight().field("field2"));
            .setSource(new SearchSourceBuilder().query(query).highlighter(new HighlightBuilder().highlighterType("plain").field("jd")))
        assertAcked(
    }  
                .get();  
                .get();
        assertThat(search.getHits().getTotalHits().value(), equalTo(1L));
        );
                0,
        assertHighlight(
        assertThat(field.getFragments()[0].string(), equalTo("how now <em>brown</em> cow"));  
        refresh();
        // Query string with more than one field
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so"));  
        SearchSourceBuilder source = searchSource().query(regexpQuery("field2", "qu[a-l]+k")).highlighter(highlight().field("field2"));
        assertNotHighlighted(response, 0, "text");  
                    .field("analyzer", "whitespace")  
        resp = req.setQuery(queryStringQuery("running scissors").field("foo.plain")).get();
            )
        search = client().prepareSearch()  
        assertAcked(prepareCreate("test").setMapping("title", "type=text,store=true,term_vector=with_positions_offsets"));  
                highlight().order("score")
                    .startObject("attachments")
        }
        req = client().prepareSearch("test").highlighter(new HighlightBuilder().field(fooField));
                .setSource("title", "This is a html escaping highlighting test for *&? opensearch");
        // Try with a boosting query
                        termAtt.setLength(length - 1);
            .field("index_options", "offsets")
                    .startObject()
import org.opensearch.index.analysis.PreConfiguredTokenFilter;
        assertHighlight(  
    public void testWithNestedQuery() throws Exception {
    public void testPostingsHighlighterOrderByScore() throws Exception {  
        client().prepareIndex("test").setId("1").setSource("text", "foo bar").get();
            .endObject()  
                    .endObject()
        ensureGreen();
    public void testMatchedFieldsWithUnified() throws Exception {
        // Finding the same string two ways is ok too
    }  
        prepareCreate("test").setMapping(mapping).get();  
        // When noMatchSize is set to 0 you also shouldn't get any  
            0,
            .highlighter(new HighlightBuilder().field("text"))
        assertHighlight(resp, 0, "foo", 0, equalTo("junk junk <em>cats</em> junk junk"));  
        field.highlighterType("fvh");  
            assertHighlight(response, 0, "foo", 0, 1, equalTo("<em>test</em> japanese"));  
        logger.info("--> searching on field2, highlighting on field2");  
        // simple search on body with standard analyzer with a simple field query  
            0,
                0,
        assertHighlight(
            equalTo("The <xxx>quick</xxx> <xxx>brown</xxx> fox jumps over the lazy quick dog")  
                    .endObject()  
        refresh();
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so some"));
                "title",  
        refresh();  
                .setQuery(QueryBuilders.matchQuery("text", "testing"))  
            .get();
        logger.info("--> highlighting and searching on field1");
            0,  
            .setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog! Second sentence.")
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));
            0,  
            .highlighter(new HighlightBuilder().encoder("html").field("title.key", 50, 1))  
                    .endObject()
     * The FHV can spend a long time highlighting degenerate documents if
            String prefix = randomAlphaOfLengthBetween(5, 30);
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
        assertHighlight(search, 0, "titleTV", 1, 2, equalTo("The <em>bug</em> is bugging us"));
        refresh();
            .setQuery(matchQuery("title", "this is a test"))  
            .startObject("properties")
    }
            RestStatus.BAD_REQUEST,
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
            )
            searchResponse,
                    "This sentence contains one match, not that short. This sentence contains two sentence matches. "
            indexRequestBuilders[i] = client().prepareIndex("test")
            .setQuery(matchQuery("title", "bug"))
    public void testFastVectorHighlighterManyDocs() throws Exception {  
            .startObject("sort")
            .startObject("properties")
        assertHitCount(response, 1);  
                "the field [title] should be indexed with term vector with position offsets to be " + "used with fast vector highlighter"
        client().prepareIndex("test").setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog").get();  
        }
                        .highlighterType(type)  
        assertAcked(prepareCreate("test").setMapping("tags", "type=text"));
        indexRandomForConcurrentSearch("test");  
        SearchResponse response = client().prepareSearch("test")
        }  
        client().prepareIndex("test").setSource("field1", "The photography word will get highlighted").get();
            containsString("unknown fragmenter option [invalid] for the field [tags]")
                "field1",
            .highlighter(new HighlightBuilder().field("title", -1, 0))  
import org.hamcrest.Matchers;
        );
        // stopwords are not highlighted since not indexed
            /** Sole constructor. */  
            assertHitCount(searchResponse, 1);  
            .startObject("properties")  
            0,
                    + " The lazy red <field1>fox</field1> jumps over the quick dog."
            .field("type", "nested")
    public void testPostingsHighlighterQueryStringWithinFilteredQuery() throws Exception {
        phraseBoostTestCaseForClauses(
        assertAcked(prepareCreate("test").setMapping("highlight_field", "type=text,store=true"));
        client().prepareIndex("test").setId("1").setSource("name", builder.toString()).get();
        SearchResponse search = client().prepareSearch().setQuery(matchQuery("alias", "foo")).highlighter(builder).get();
                "type=text,term_vector=with_positions_offsets"  
    public void testPostingsHighlighterMultiMapperWithStore() throws Exception {  
        assertNotHighlighted(search, 0, "no_long_term");
            client().prepareSearch("test").setSource(searchSource),
        refresh();
        assertAcked(prepareCreate("test").setMapping(mappings));
@TimeoutSuite(millis = 35 * TimeUnits.MINUTE)
import java.util.Collection;
            .field("type", "text")
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
    @Override
            .setSource("field1", "The quick brown fox jumps over", "field2", "The quick brown fox jumps over")
            "type1",
                searchResponse,  
        // simple search on body with standard analyzer with a simple field query
        // which can also be written by searching on the subfield  
            .endObject();
                    .endObject()  
                "This is the test with term_vectors",
                    .endObject()
            .get();  
                .setMapping(
        assertHighlight(response, 0, "text", 0, 1, equalTo(text));
        mappings.startObject("properties")
                i,  
            assertHighlight(search, i, "attachments.body", 1, 2, equalTo("<em>attachment</em> 2"));
                new SearchSourceBuilder().query(QueryBuilders.matchQuery("keyword_field", "some text"))
            "field2",
            indexRequestBuilders[i] = client().prepareIndex("test")  
            b.field("type", "text");  
            assertHighlight(response, 0, "foo", 0, 1, equalTo("<em>test</em> typename"));
            .get();  
                searchResponse,
        indexRandom(true, indexRequestBuilders);
                .setSource("title", "This is a test on the highlighting bug present in opensearch");
            .field("index_options", "offsets")
                    .endObject()
        SearchSourceBuilder source = searchSource().query(
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
        for (int i = 0; i < indexRequestBuilders.length; i++) {
                    .endObject()
            )
        refresh();
        String mapping = jsonBuilder().startObject()
        assertThat(field1.fragments().length, equalTo(4));
            equalTo("The <em>quick</em> brown fox jumps over the lazy dog! Second sentence.")
                    .field("type", "text")  
            MultiMatchQueryBuilder.Type matchQueryType = RandomPicks.randomFrom(random(), MultiMatchQueryBuilder.Type.values());
        refresh();
                    .startObject("key")
            boostingQuery(termQuery("field2", "brown"), termQuery("field2", "foobar")).negativeBoost(0.5f)
        }
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();
            .field("type", "text")
import static org.opensearch.index.query.QueryBuilders.rangeQuery;  
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
            .toString();
                    .field("type", "text")  
        SearchSourceBuilder source = searchSource().query(commonTermsQuery("field2", "quick brown").cutoffFrequency(100))
            .get();
        // search on title.key and highlight on title.key
     */
            // asking for the whole field to be highlighted
        );
        for (int i = 0; i < iters; i++) {  
        assertHighlight(search, 0, "title", 0, 1, equalTo("this is a <em>test</em>"));
        SearchSourceBuilder source = searchSource().query(commonTermsQuery("field2", "quick brown").cutoffFrequency(100))
            .highlighter(new HighlightBuilder().field("title"))
                .highlighter(new HighlightBuilder().field(new Field("foo.text").highlighterType(type)))
        assertAcked(prepareCreate("test").setMapping(mappings));
            equalTo("The <xxx>quick</xxx> <xxx>brown</xxx> fox jumps over the lazy quick dog")
            .highlighter(new HighlightBuilder().field(new Field("foo_copy")))  
        ensureGreen();  
        indexRandomForConcurrentSearch("test");
                    .postTags("</xxx>")
        }
        indexRandomForConcurrentSearch("test");  
            .get();
            SearchResponse searchResponse = client().search(searchRequest("test").source(source)).actionGet();  
        indexRandomForConcurrentSearch("test");
            searchResponse = client().prepareSearch()
            1,
        }
            1,  
    }  
            .startObject("properties")  
    public void testFvhMatchedFieldsRequireFieldMatch() throws Exception {
        SearchResponse search = client().prepareSearch()  
        SearchResponse search = client().prepareSearch()
        mappings.endObject();  
            .get();  
        assertHighlight(
                jsonBuilder().startObject()
        response = client().prepareSearch("test").setQuery(queryBuilder).highlighter(new HighlightBuilder().field(field)).get();
        String pattern = "t   ";
                .highlighter(new HighlightBuilder().field(new Field("*").highlighterType(type)))
                    .field("type", "text")  
        for (String type : new String[] { "unified", "fvh" }) {
        client().prepareIndex("test")  
        field.highlighterType("fvh");  
                        .array(  
        );
        mappings.startObject("properties").startObject("text").field("type", "keyword").field("store", true).endObject().endObject();  
            0,
            assertHighlight(
        assertAcked(prepareCreate("test").setMapping(mappings));  
            .highlighter(new HighlightBuilder().field("title", 50, 1, 10).highlighterType("fvh"))
            assertHighlight(
                    .endObject()
         */  
            assertHighlight(search, i, "title", 0, 1, equalTo(" highlighting <em>test</em> for *&amp;? opensearch"));  
            prepareCreate("test").setMapping(
import org.opensearch.index.query.MultiMatchQueryBuilder;
                "title",
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
        source = searchSource().query(termQuery("field2", "quick"))
                    .endObject()  
                    .field("type", "text")  
                "short",  
            prepareCreate("test").setMapping(
            )
                .setSettings(Settings.builder().put("index.number_of_replicas", 0).put("index.number_of_shards", 2))
        ensureGreen();
            searchResponse,  
                    .endObject()  
        index("test", "type1", "1", "text", new String[] { text1, text2 });
                        .endObject()
                .highlighter(new HighlightBuilder().field(new Field("unstored_text")))  
            matchQuery("field1", "highlight words together"),  
                0,
        }
        indexRandomForConcurrentSearch("test");  
        );  
        searchResponse = client().search(searchRequest("test").source(source)).actionGet();
            .startObject("jd")  
            .endObject()  
        assertAcked(
            logger.info("Running multi-match type: [{}] highlight with type: [{}]", matchQueryType, highlighterType);
        ensureGreen();  
        indexRandomForConcurrentSearch("test");
            )
                    .startObject("title")
            .get();
            SearchSourceBuilder source = searchSource().query(termQuery("field1", "some"))
        );
            .requireFieldMatch(requireFieldMatch);  
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
                    .endObject()
        searchResponse = client().prepareSearch("test").setSource(source).get();
            client().prepareIndex("index-1").setId("3").setSource("d", formatter.format(now.minusDays(2)), "field", "world")
                .highlighter(new HighlightBuilder().field(new Field("text").highlighterType(type).requireFieldMatch(false)))  
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so some"));
                .highlighter(
        index("test", "type1", "1", "field1", "The <b>quick<b> brown fox", "field2", "The <b>slow<b> brown fox");  
            .get();
                    .startObject("fields")
            .get();
    public void testBoostingQueryTermVector() throws IOException, InterruptedException {
    }
import static org.opensearch.index.query.QueryBuilders.matchQuery;
                )
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("this is a <xxx>test</xxx>"));
        SearchResponse search = client().prepareSearch()
        // And that matching a subfield doesn't automatically highlight it
                    .endObject()
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
        indexRandom(
                search,  
                equalTo("This is a <em>test</em> for the <em>workaround</em> for the fast vector highlighting SOLR-3724")
                    .endObject()
            .query(termQuery("field1", "quick"))
            .highlighter(  
            .field("type", "text")  
    public void testPostingsHighlighterFuzzyQuery() throws Exception {
        assertHighlight(response, 0, "field2", 0, 1, equalTo("The <b>slow<b> brown <2>fox</2>"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertHighlight(search, 0, "tags", 1, 2, equalTo("<em>foo bar</em>"));
        assertAcked(prepareCreate("test").setMapping(mapping));
                        .must(QueryBuilders.rangeQuery("d").gte("now-12h").lte("now").includeLower(true).includeUpper(true).boost(1.0f))  
            .endObject();  
        ).highlighter(highlight().field("field1"));
                .get();
                new HighlightBuilder().field(
    }
            .endObject()
            .endObject()
        assertHighlight(resp, 0, "bar", 0, equalTo("<em>resul</em>t"));  
            .query(termQuery("field-postings", "test"))
                    "This is the second value's first sentence. This one contains no matches. "
        indexRandomForConcurrentSearch("test");
            SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
                        .endObject()
            SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();  
        client().prepareIndex("test")
    // Issue #5175
            text.append("junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk\n");
            .execute()
                        .endObject()
        assertNotHighlighted(response, 0, "text");  
            assertHighlight(search, i, "attachments.body", 1, equalTo("<em>attachment</em> 2"));  
            .get();  
        client().prepareIndex("test").setSource("field1", value).get();  
 * SPDX-License-Identifier: Apache-2.0
    private static final String[] ALL_TYPES = new String[] { "plain", "fvh", "unified" };
            .get();  
                    .startObject("properties")  
                .setQuery(nestedQuery("foo", prefixQuery("foo.text", "bro"), ScoreMode.None))  
                "float",  
        assertHitCount(searchResponse, COUNT);
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));  
            assertSearchResponse(r1);
        assertAcked(prepareCreate("test").setMapping("title", "type=text,store=true,term_vector=no"));
        ensureGreen();  
                );
        assertAcked(
                .get();
        assertHitCount(searchResponse, 1L);  
                        .startObject()  
            .startObject()  
        client().prepareIndex("test")
            .setSize(COUNT)
        float boost,  
    public void testGlobalHighlightingSettingsOverriddenAtFieldLevel() throws InterruptedException {
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("<em>aaab</em>"));
    ) {  
        refresh();
            .setQuery(matchPhraseQuery("title", "test for the workaround"))
        assertNotHighlighted(response, 0, "text");
            queryStringQuery("highlight words together").field("field1"),
                    .endObject()
            .get();  
                    }
        indexRandom(
        idsQueryBuilder = QueryBuilders.idsQuery().addIds("4");  
                0,
        client().prepareIndex("test")
        ensureGreen();
    }
        XContentBuilder mappings = jsonBuilder();
        Map<String, String> prefixes = new HashMap<>(COUNT);
            .get();
                "field2",
                    new HighlightBuilder().field(  
                    .startObject("properties")  
            .highlighter(new HighlightBuilder().field("title", 30, 1, 10).highlighterType("fvh"))
            )
            field1.fragments()[3].string(),  
            assertHighlight(search, i, "title", 0, equalTo("This is a test on the highlighting <em>bug</em> present in opensearch"));
                2,
            .field("term_vector", "with_positions_offsets")
                    .postTags("</global>")  
        assertNoFailures(search);  
            .highlighter(new HighlightBuilder().field("title", -1, 0))
        index("test", "type1", "1", "foo", "running with scissors");
        client().prepareIndex("test").setId("1").setSource(jsonBuilder().startObject().field("text", "text").endObject()).get();  
        ensureGreen();
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();  
            )  
        );
        XContentBuilder mappings = jsonBuilder();
                anyOf(
                    "field1",
        indexRandom(true, indexRequestBuilders);  
import org.opensearch.index.query.QueryBuilder;  
        return Arrays.asList(InternalSettingsPlugin.class, MockKeywordPlugin.class, MockAnalysisPlugin.class);  
            .startObject("properties")
        refresh();
        // it accidentially with a wildcard
            assertHighlight(
                equalTo("This is a <em>test</em> for the <em>workaround</em> for the fast vector highlighting SOLR-3724")  
            0,  
        SearchResponse search = client().prepareSearch()  
import org.apache.lucene.analysis.TokenStream;  
            .highlighter(highlight().forceSource(true).field("field*"));
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
            Matcher<String> hlQueryMatcher = equalTo("Testing the highlight <em>query</em> feature");
        logger.info("--> highlighting and searching on field1");  
    public void testFvhMatchedFieldsFvhNoRequireFieldMatch() throws Exception {
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("this is a <xxx>test</xxx>"));
    }
            .endObject()
            )
            .setQuery(matchPhraseQuery("title", "test for the workaround"))
            .setSource(
        );
        }  
        assertAcked(
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
        idsQueryBuilder = QueryBuilders.idsQuery().addIds("3");
            100f,
        // Try with a boosting query using a negative boost
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
                "int",
        for (int i = 0; i < indexRequestBuilders.length; i++) {
                    highlight().highlightQuery(randomBoolean() ? multiMatchQueryBuilder : null)
        // should not fail if there is a wildcard
            .highlighter(highlight().field("field2"));
            .endObject();  
                )
                    }
        );
                        .endObject()
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
        assertNotHighlighted(response, 0, "text");
        index("test", "type1", "4");  
        client().prepareIndex("test")  
            assertNull(searchResponse.getHits().getAt(0).getHighlightFields().get("_id"));  
        indexRandomForConcurrentSearch("test");
 * Licensed to Elasticsearch under one or more contributor  
        ensureGreen();  
                    .startObject("properties")
        indexRandomForConcurrentSearch("test");
        client().prepareIndex("test")
        assertHighlight(response, 0, "field1", 0, 1, highlightedMatcher);
        logger.info("--> indexing docs");
        assertHighlight(search, 0, "title", 0, 1, equalTo("this is a <em>test</em>"));  
        assertHighlight(resp, 0, "bar", 0, equalTo("junk junk <em>cats</em> junk junk"));  
    }
            0,
            }
        fooField = new Field("foo").numOfFragments(1)
        response = client().prepareSearch("test")
                ),  
            .endObject()
                    equalTo("The quick brown <field1>fox</field1> jumps over the lazy dog. Second sentence not finished")
            .endObject()  
    public void testMultiMapperVectorWithStore() throws Exception {
            .setQuery(matchQuery("title", "test"))
        refresh();  
                equalTo("This is a test on the highlighting <em>bug</em> present in opensearch. Hopefully it works.")  
            public boolean incrementToken() throws IOException {  
            0,  
                        .field("store", true)
        assertAcked(
            assertHighlight(search, 0, "alias", 0, equalTo("foo <em>bar</em>"));  
            field = new HighlightBuilder.Field("text");  
        String text = "I am pretty long so some of me should get cut off. Second sentence";  
    }
            .endObject()  
        resp = req.setQuery(twoFieldsQuery).highlighter(new HighlightBuilder().field(fooField).field(barField)).get();
                    final int length = termAtt.length();  
        client().prepareIndex("test")
            client().prepareIndex("test").setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog")  
            .setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog! Second sentence.")
        assertThat(  
            )
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("The <em>quick</em> brown fox jumps over"));
        logger.info("--> highlighting and searching on field1");  
        }
            );
import org.opensearch.index.query.functionscore.RandomScoreFunctionBuilder;  
                "field1",
    }
        refresh();  
                    .field("text", "cow")
        }  
    private void phraseBoostTestCase(String highlighterType) throws InterruptedException {
                    .field("analyzer", "whitespace")
        assertAcked(prepareCreate("test").setMapping(mapping));  
        assertThat(field.getFragments().length, equalTo(1));
                    .field("term_vector", "with_positions_offsets")  
            assertHitCount(searchResponse, 1);  
                        .startObject()  
                    .numOfFragments(1)
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.Field;
                    .field("store", false)
            .highlighter(
        logger.info("--> highlighting and searching on field1");  
        assertNotHighlighted(response, 0, "text");  
            )
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));
        index("test", "type1", "2", "text", new String[] { "", text2 });
        field.highlighterType("fvh");
                        .field("body", "attachment 1")
                    .startObject("field1")
        assertAcked(
        SearchSourceBuilder source = searchSource().query(termQuery("field1", "fox"))
            queryStringQuery("highlight words together").field("field1"),
            "field2",  
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("this is a <xxx>test</xxx>"));
/*  
        field.highlighterType("fvh");  
        assertAcked(prepareCreate("test").setMapping(mapping));
                        .highlighterType(highlighterType)
                    .field("store", true)  
import static java.util.Collections.singletonMap;  
                )
            )
                .highlighter(new HighlightBuilder().field("foo").highlighterType(highlighter).requireFieldMatch(false))
        assertThat(resp.getHits().getAt(0).getHighlightFields(), not(hasKey("foo")));  
        for (String type : ALL_TYPES) {
            QueryBuilders.boolQuery()  
    }  
                search,
        client().prepareIndex("test")
            assertHighlight(
            .endObject()
        index("test", "type1", "3", "text", new String[] {});
        assertThat(
            .setSource(jsonBuilder().startObject().field("text", "brown").field("enable", "yes").endObject())
        logger.info("--> searching explicitly on field1 and highlighting on it");  
        );  
        b.endObject();  
        SearchSourceBuilder source = searchSource().query(wildcardQuery("field2", "qui*")).highlighter(highlight().field("field2"));
        assertAcked(  
        assertHighlight(response, 0, "field1", 0, 1, equalTo("The <b>quick<b> brown <1>fox</1>. Second sentence."));
        indexRandomForConcurrentSearch("test");
    }  
                .setId(Integer.toString(i))
            .highlighter(
            SearchResponse search = client().prepareSearch()
            .field("type", "text")
        assertNotHighlighted(response, 0, "text");  
import org.opensearch.plugins.Plugin;  
        field.highlighterType("fvh");
        XContentBuilder mappings = jsonBuilder();
        assertHitCount(searchResponse, 1);
            response,  
                .setSource(
        settings.put("index.analysis.analyzer.mock_english.tokenizer", "standard");
        Settings.Builder settings = Settings.builder();
        assertAcked(prepareCreate("test").setMapping("title", "type=text,store=true,term_vector=with_positions_offsets").get());
            )
            boolQuery().should(boolQuery().mustNot(QueryBuilders.existsQuery("field1")))
        // stopwords are now highlighted since we used only whitespace analyzer here
        );
import org.opensearch.common.xcontent.XContentFactory;
            .setId("1")
                .setSource("field1", "Sentence " + prefix + " test. Sentence two.");  
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
            "test",  
        assertHighlight(resp, 0, "foo", 0, equalTo("running with <em>scissors</em>"));
        assertHighlight(search, 0, "text", 0, equalTo("<em>foo</em>"));
    public void testPostingsHighlighter() throws Exception {
import org.opensearch.index.query.AbstractQueryBuilder;
        assertNotHighlighted(response, 0, "text");
            );  
        refresh();
            .highlighter(new HighlightBuilder().field("title"))
        assertHighlight(response, 0, "field1", 0, 1, highlightedMatcher);  
    }
                        .field("store", true)  
            boostingQuery(termQuery("field2", "brown"), termQuery("field2", "foobar")).negativeBoost(0.5f)
    }
        }  
public class HighlighterSearchIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            .get();  
        assertAcked(prepareCreate("test").setMapping("title", "type=text,store=true,term_vector=with_positions_offsets,analyzer=classic"));  
            .setSource(jsonBuilder().startObject().field("foo", "how now brown cow").endObject())
            .setId("1")
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
            SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();  
        refresh();
        client().prepareIndex("test").setId("1").setSource("title", "this is a test . Second sentence.").get();  
        ensureGreen();
            assertHighlight(search, 0, "text", 0, equalTo("<em>text</em>"));
            SearchSourceBuilder source = searchSource().query(termQuery("field1", "some"))  
        refresh();  
            .setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog! Second sentence.")
            .get();
        assertHighlight(resp, 0, "foo", 0, equalTo("junk junk <em>cats</em> junk junk"));
                "no_long_term",  
import static org.hamcrest.Matchers.lessThan;
            return singletonMap("mock_whitespace", (indexSettings, environment, name, settings) -> {  
     * @param highlighterType highlighter to test  
            .startObject("text")  
        assertHighlight(searchResponse, 0, "title.key", 0, 1, equalTo("<em>this</em> <em>is</em> <em>a</em> <em>test</em>"));
 * KIND, either express or implied.  See the License for the
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();  
                .prepareCreate("index-1")  
                .setQuery(matchPhraseQuery("title", "this is a test"))  
        client().prepareIndex("test")  
    }
        // Add the subfield to the list of matched fields but don't match it. Everything should still work  
            .setQuery(matchQuery("title.key", "this is a test"))  
            assertHighlight(search, i, "attachments.body", 0, equalTo("<em>attachment</em> for this test"));
        QueryBuilder twoFieldsQuery = queryStringQuery("cats").field("foo").field("foo.plain", 5).field("bar").field("bar.plain", 5);
        for (int i = 0; i < indexRequestBuilders.length; i++) {  
                .highlighter(new HighlightBuilder().field(new Field("foo.text").highlighterType(type)))  
            assertHighlight(response, 0, "text", 0, searchQueryMatcher);
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));  
            .endObject()
        indexRandomForConcurrentSearch("test");
            );  
            .endObject()  
                "type=double"  
            .field("type", "text")
import static org.opensearch.test.hamcrest.RegexMatcher.matches;
        int COUNT = between(20, 100);
                equalTo("This is a test on the highlighting <em>bug</em> present in opensearch. Hopefully it works.")
        index(  
        assertHighlight(response, 0, "field1", 0, 1, highlightedMatcher);  
                "long_term",
        field.highlighterType("unified");
        resp = req.setQuery(queryStringQuery("foo.plain:running scissors").field("foo")).get();  
        assertHighlight(search, 0, "title", 0, equalTo("This is a test on the highlighting <em>bug</em> present in opensearch"));
        client().prepareIndex("test")  
            text.append("junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk\n");
        public final class MockSnowBall extends TokenFilter {  
        refresh();
        }
            .startObject()
            prepareCreate("test").setMapping(  
        // When noMatchSize is between 0 and the size of the string
                    .field("term_vector", "no")
            .setQuery(matchQuery("attachments.body", "attachment"))
        assertHitCount(searchResponse, 2L);
        index("test", "type1", "1", "field1", text.toString());
        HighlightField field = searchResponse.getHits().getAt(0).getHighlightFields().get("text");  
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
                        .field("term_vector", "with_positions_offsets")
                .addSort("d", SortOrder.DESC)
        assertHighlight(response, 0, "text", 1, 2, equalTo("This is the <em>fifth</em> sentence"));  
        assertHighlight(  
                        .startObject()
                    .field("store", true)  
        SearchSourceBuilder source = searchSource().query(constantScoreQuery(regexpQuery("field1", "pho[a-z]+")))
        client().prepareIndex("test").setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog").get();
            assertThat(search.getHits().getAt(0).getHighlightFields().size(), equalTo(0));  
        assertAcked(prepareCreate("test").setSettings(builder.build()).setMapping("keyword", "type=keyword,normalizer=my_normalizer"));  
                        .startObject("foo")  
            .highlighter(highlight().field("field1", 100, 0).order("score").preTags("<xxx>").postTags("</xxx>"));
            .get();
                    .field("type", "text")
        index("test", "type1", "1", "text", new String[] { text1, text2, text3 });  
        assertNoFailures(search);
        phraseBoostTestCaseForClauses(  
        // But we use the best found score when sorting fragments
         * I hate comparing times because it can be inconsistent but default is  
            .highlighter(highlight().field("field2").preTags("<x>").postTags("</x>"));  
        assertNotHighlighted(response, 0, "text");
        // First check highlighting without any matched fields set
        );
        indexRandomForConcurrentSearch("test");  
            .endObject()
            .startObject("properties")  
import java.time.ZoneOffset;
                jsonBuilder().startObject()
                "text",
        String text1 = "This is the first sentence. This is the second sentence." + HighlightUtils.PARAGRAPH_SEPARATOR;  
            .setId("1")
            .setQuery(QueryBuilders.matchQuery("field1", "fox"))
    }
            assertHighlight(search, 0, "tags", 0, 2, equalTo("<em>foo bar</em>"));  
            .highlighter(highlight().field("field2").order("score").preTags("<x>").postTags("</x>"));
            );
        for (int i = 0; i < 10; i++) {
            indexRequestBuilders[i] = client().prepareIndex("test")
            )
    }  
            assertThat(field.getFragments().length, equalTo(1));
        assertHighlight(  
                        .startObject("fields")
import static org.opensearch.index.query.QueryBuilders.matchPhraseQuery;  
            2,
     * phraseLimit is not set. Its default is now reasonably low.  
import org.opensearch.search.sort.SortBuilders;
            "title.key",  
                    .startArray("foo")  
        fooField.matchedFields("foo", "foo.plain");
        assertHighlight(response, 0, "field2", 0, 1, equalTo("The <b>slow<b> brown <2>fox</2>"));  
            .highlighter(
            0,
            .highlighter(new HighlightBuilder().encoder("html").field("title", 50, 1))
                i,
                    .field("index_options", "offsets")
        refresh();
            );
            .get();
            .field("store", false)
                    .field("analyzer", "whitespace")
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();  
            100f,
            .field("store", true)  
                .get();
                "type=text,index_options=offsets",  
                "text",
            assertHighlight(hit, "field1", 0, 1, equalTo("Sentence " + prefix + " <em>test</em>. Sentence two."));  
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
            .get();
    public void testNumericHighlighting() throws Exception {
        index(
                    "The quick brown dog jumps over the lazy fox." }
                    .endObject()
        }  
import java.util.Locale;
        assertFailures(
            String highlighterType = rarely() ? null : RandomPicks.randomFrom(random(), ALL_TYPES);
                    "One sentence match here and scored lower since the text is quite long, not that appealing. "  
        ensureGreen();  
            client().prepareIndex("test").setSource("field1", "A sentence with few words. Another sentence with even more words.")  
            "field1",
            .get();
    }  
            response,  
                        .field("type", "text")
        StringBuilder builder = new StringBuilder();
        SearchResponse response = client().prepareSearch("test")  
                            + "The quick brown dog jumps over the lazy <field1>fox</field1>."
        for (int i = 0; i < 5; i++) {
        resp = req.setQuery(queryStringQuery("foo.plain:running scissors").field("foo")).get();
        // Highlighting of numeric fields is not supported, but it should not raise errors  
                "field2",  
                    .startObject("properties")
import static org.hamcrest.Matchers.not;  
        client().prepareIndex("test").setId("1").setSource("keyword", "foo").get();  
                anyOf(equalTo("<xxx>some</xxx> quick and hairy brown"), equalTo("<xxx>some</xxx>"))
    }
            response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
                1,
            )
        for (int i = 0; i < 5; i++) {  
            .get();
            .startObject("field1")
                        .field("analyzer", "mock_english")  
                .filter(
                .setQuery(matchQuery("_id", "d33f85bf1e51e84d9ab38948db9f3a068e1fe5294f1d8603914ac8c7bcc39ca1"))
            .highlighter(highlight().field("field1").order("score"));  
            prepareCreate("test").setMapping(
        indexRandomForConcurrentSearch("test");
        SearchSourceBuilder source = searchSource().query(termQuery("field1", "sentence"))
                        .field("analyzer", "mock_english")  
        logger.info("--> highlighting and searching on field1");
    public void testGeoFieldHighlightingWhenQueryGetsRewritten() throws IOException, InterruptedException {  
    }
            .highlighter(new HighlightBuilder().field(new Field("foo_text").highlighterType("fvh")).requireFieldMatch(false))
                        .postTags("</xxx>")
        ensureGreen();
        for (int i = 0; i < indexRequestBuilders.length; i++) {
                Settings.builder().put(indexSettings()).put("analysis.analyzer.my_analyzer.type", "mock_whitespace").build()  
            equalTo("One <em>sentence</em> match here and scored lower since the text is quite long, not that appealing.")
import org.opensearch.search.sort.SortOrder;  
            if ("1".equals(searchHit.getId())) {
        ensureGreen();
                i,  
                    .startObject("fields")  
        field.highlighterType("plain").noMatchSize(0);
        }  
        return Arrays.asList(
                    XContentFactory.jsonBuilder()  
        ensureGreen();
        assertHighlight(response, 0, "text", 0, 1, equalTo(text));
            )
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];  
        );
        SearchResponse response = client().prepareSearch("test")
            .setQuery(matchQuery("title.key", "this is a test"))
                    .endObject()
        client().prepareIndex("test")
                new HighlightBuilder().field(  
                anyOf(equalTo("A <xxx>sentence</xxx> with few words"), equalTo("A <xxx>sentence</xxx> with few words. "))
        assertAcked(
    }
            field = searchResponse.getHits().getAt(0).getHighlightFields().get("foo.text");
            .setQuery(nestedQuery("foo", matchQuery("foo.text", "brown cow"), ScoreMode.None))
            .endObject()
    public void testPlainHighlighterMultipleFields() throws InterruptedException {  
            // LUCENE 3.1 UPGRADE: Caused adding the space at the end...
                new FunctionScoreQueryBuilder(
        ensureGreen();
            .setQuery(matchQuery("titleTV", "highlight"))
        checkFvhMatchedFieldsCase(false);  
                    .field("index_options", "offsets")
        assertHighlight(
        field.highlighterType("plain");  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNotHighlighted;  
        assertHighlight(response, 0, "text", 0, 1, equalTo(text));
            0,
                new SearchSourceBuilder().query(query).highlighter(new HighlightBuilder().field("*").highlighterType(highlighterType))
                .setTrackScores(true)
            SearchResponse response = client().prepareSearch("filtered_alias")
        logger.info("--> highlighting and searching on field1 with large phrase limit");
                "type=text"
        indexRandomForConcurrentSearch("test");
            assertHighlight(search, i, "title", 0, 1, equalTo("highlighting <em>bug</em> present in opensearch"));  
        assertAcked(
                    .field("analyzer", "classic")
        source = searchSource().query(termQuery("field1", "test"))
        );  
                    .endObject()  
import java.util.Map;  
        field.highlighterType("fvh");
                "The quick brown fox jumps over the lazy dog. The lazy red fox jumps over the quick dog. "  
            .startObject("text")
        SearchResponse search = client().prepareSearch()  
            boostingQuery(termQuery("field2", "brown"), termQuery("field2", "foobar")).negativeBoost(0.5f)  
import static org.hamcrest.Matchers.hasKey;
        {
        assertAcked(prepareCreate("test").setMapping("title", "type=text,store=true,term_vector=with_positions_offsets"));
            .get();
        // search on title.key and highlight on title
        assertHighlight(response, 0, "tags", 0, equalTo("this is a really long <em>tag</em> i would like to highlight"));
        SearchResponse response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();  
                "title",
            .get();
        field.highlighterType("unified");
import org.opensearch.action.search.SearchResponse;
        ensureGreen();  
            .get();
            prepareCreate("test").setMapping(
        );
                        .boundaryScannerLocale(Locale.ENGLISH.toLanguageTag())  
    public void testPostingsHighlighterQueryString() throws Exception {
        logger.info("--> highlighting and searching on field1");
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
        ).highlighter(highlight().field("field2").order("score").preTags("<x>").postTags("</x>"));  
            .setQuery(QueryBuilders.matchPhraseQuery("tags", "long tag"))
            .get();
        assertHitCount(searchResponse, 1L);  
        assertThat(highlightFieldMap.size(), equalTo(1));
        search = client().prepareSearch()
            HighlightField field = searchResponse.getHits().getAt(0).getHighlightFields().get("foo.text");  
import org.opensearch.test.InternalSettingsPlugin;
        index("test", "type1", "3", "foo", "weird", "bar", "result");
                    .endObject()  
        SearchSourceBuilder source = searchSource().query(queryStringQuery("qui*").defaultField("field2"))  
    public void testMultiMatchQueryHighlight() throws IOException, InterruptedException {  
            .setQuery(matchQuery("title", "this is a test"))
        // works using stored field  
                        .endObject()
            response = search.get();  
                "field1",  
            .or(containsString("<em>highlight</em> <em>words</em> <em>together</em>"));
            .endObject()
        ensureGreen();
    public void testPostingsHighlighterEscapeHtml() throws Exception {
import org.opensearch.index.query.IdsQueryBuilder;  
            .startObject("text")
import static org.opensearch.search.builder.SearchSourceBuilder.highlight;
        // like before we added it.
            .get();  
        assertHighlight(search, 0, "title", 1, 2, equalTo("The <em>bug</em> is bugging us"));  
            .get();
                search,
                    .field("jd", "some आवश्यकता है- आर्य समाज अनाथालय, 68 सिविल लाइन्स, बरेली को एक पुरूष" + " रस text")  
        // When you don't set noMatchSize you don't get any results if there isn't anything to highlight.
        for (int i = 0; i < COUNT; i++) {
                .addSort(SortBuilders.fieldSort("sort"))
                    .endArray()  
 *
        search = client().prepareSearch()  
            assertHighlight(
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
            equalTo("<em>some text</em>")
        // Index one megabyte of "t " over and over and over again  
            .get();
        logger.info("--> highlighting and searching on field2");  
                        .field("type", "text")
        SearchResponse search = client().prepareSearch()  
                        .endObject()
import org.opensearch.common.settings.Settings.Builder;  
            searchResponse,
                        }
            .get();  
        }
                            "This is a test on the highlighting bug present in opensearch. Hopefully it works.",
                .setId(Integer.toString(i))
    public void testHighlighterWithWordBoundaryScannerAndLocale() throws Exception {
                new HighlightBuilder().field(new HighlightBuilder.Field("field1").preTags("<1>").postTags("</1>").requireFieldMatch(true))
        ensureGreen();
        String[] titles = new String[] { "This is a test on the highlighting bug present in opensearch", "The bug is bugging us" };
                    .endObject()
        );
    public void testPostingsHighlighterMultiTermQueryMultipleLevels() throws Exception {
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[COUNT];
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
                        .field("analyzer", "standard")  
    public void testDoesNotHighlightTypeName() throws Exception {
                    .field("enabled", false)
        );
        }
                        "this is a really long tag i would like to highlight",  
        for (int i = 0; i < indexRequestBuilders.length; i++) {  
                        .field("title", "This is a test on the highlighting bug present in opensearch")
        SearchSourceBuilder source = searchSource().query(termQuery("field1", "test"))
        // The no match fragment should come from the first value of a multi-valued field  
    }
            .get();
        // search on title.key and highlight on title.key  
                    .startObject("title")  
        // like before we added it.

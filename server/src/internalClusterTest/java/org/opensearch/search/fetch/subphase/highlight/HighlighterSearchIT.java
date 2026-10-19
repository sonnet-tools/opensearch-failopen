            .startObject("text")
                new String[] {
                    .field("index_options", "offsets")
                .highlighter(new HighlightBuilder().field("title", 50, 1, 10).highlighterType("fvh")),
        }
            .highlighter(highlight().field("field*").preTags("<xxx>").postTags("</xxx>").requireFieldMatch(false));
    }
                search,
        XContentBuilder mappings = jsonBuilder().startObject()
            );
                .setId(Integer.toString(i))
            .endObject()
import org.opensearch.indices.analysis.AnalysisModule;
            .setQuery(matchQuery("title", "bug"))
        indexRandom(true, client().prepareIndex("test").setSource("field1", "some quick and hairy brown:fox jumped over the lazy dog"));
    }
        // The no match fragment should come from the first value of a multi-valued field
            HighlightBuilder.Field field = new HighlightBuilder.Field("text");
                    .endObject()
            .highlighter(highlight().field(new Field("field1").numOfFragments(5).preTags("<field1>").postTags("</field1>")));
            )
    public void testFvhMatchedFieldsRequireFieldMatch() throws Exception {
            .highlighter(
import java.util.Map;
            .setSource(
        // First check highlighting without any matched fields set
                "long_term",
                "field1",
            .setId("d33f85bf1e51e84d9ab38948db9f3a068e1fe5294f1d8603914ac8c7bcc39ca1")
        }
        indexRandom(true, indexRequestBuilders);
        assertAcked(
        ensureGreen();
        super(staticSettings);
        client().prepareIndex("test")
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                searchResponse,
        refresh();
        index("test", "type1", "1", "field1", text.toString());
        }
                    .endObject()
                0,
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with scissors"));
            .highlighterType("fvh")
            client().prepareIndex("index-1").setId("2").setSource("d", formatter.format(now.minusDays(1)), "field", "hello"),
                );
            client().prepareIndex("test").setSource("field1", "A sentence with few words. Another sentence with even more words.")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNotHighlighted;
                    .endObject()
        searchResponse = client().prepareSearch("test").setSource(source).get();
                .setTrackScores(true)
                    .endObject()
        );
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();
        // Using plain highlighter instead of FVH
                    .preTags("<xxx>")
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
            .highlighter(
    public void testNumericHighlighting() throws Exception {
        refresh();
        ).highlighter(highlight().field("field2").order("score").preTags("<x>").postTags("</x>"));
        assertAcked(prepareCreate("test").setMapping("title", "type=text,store=true,term_vector=with_positions_offsets").get());
        // search on title.key and highlight on title.key
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
        // When you don't set noMatchSize you don't get any results if there isn't anything to highlight.
                            "title",
        mappings.startObject("properties")
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[COUNT];
            // Make sure the highlightQuery is taken into account when it is set on the highlight context instead of the field
                "text",
            .setId("1")
import static org.hamcrest.Matchers.startsWith;
        ensureGreen();
                fail("Only hits with id 1 and 2 are returned");
        // And that matching a subfield doesn't automatically highlight it
            .startObject("text")
            // (https://github.com/elastic/elasticsearch/issues/4103)
            true,
        refresh();
    public void testFastVectorHighlighterOffsetParameter() throws Exception {
        field.highlighterType("unified");
            .query(termQuery("field1", "quick"))
                        .endObject()
 * this file be licensed under the Apache-2.0 license or a
            .endObject();
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("The <em>photography</em> word will get highlighted"));
            .setQuery(matchQuery("title", "this is a test"))
                "field-fvh",
        HighlightBuilder.Field field = new HighlightBuilder.Field("text").fragmentSize(21).numOfFragments(1).highlighterType("plain");
            assertHighlight(response, 0, "text", 0, hlQueryMatcher);
        assertThat(field.getFragments()[0].string(), equalTo("<em>brown</em>"));
            searchResponse = client().prepareSearch()
        assertHighlight(searchResponse, 0, "field-fvh", 0, 1, equalTo("This is the <xxx>test</xxx> with term_vectors"));
    }
        search = client().prepareSearch()
import org.apache.lucene.tests.analysis.MockAnalyzer;
        for (int i = 0; i < 5; i++) {
                .setSettings(Settings.builder().put("index.number_of_replicas", 0).put("index.number_of_shards", 2))
            .get();
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
        assertAcked(prepareCreate("test").setMapping(mappings));
                    .endObject()
            .field("type", "text")
            .startObject("foo")
            0,
                        .startObject("fields")
            0,
            .startObject("text")
            .get();
            .get();
        assertHitCount(response, 1L);
    public void testPostingsHighlighter() throws Exception {
        mappings.startObject("properties").startObject("text").field("type", "keyword").field("store", true).endObject().endObject();
            .get();
        assertHitCount(searchResponse, 1);
        assertHighlight(response, 0, "text", 0, 2, equalTo("This is the <em>third</em> sentence. This is the fourth sentence."));
                    .field("analyzer", "whitespace")
                        .endObject()
        refresh();
                    .endObject()
                    "field1",
    public void testSourceLookupHighlightingUsingPlainHighlighter() throws Exception {
        search = client().prepareSearch()
            SearchHit hit = searchResponse.getHits().getHits()[i];
            // asking for the whole field to be highlighted
        field.highlighterType("fvh");
        client().prepareIndex("test").setSource("field1", value).get();
            SearchResponse response = client().prepareSearch("filtered_alias")
        assertNoFailures(search);
            }
                "int",
        );
        SearchResponse search = client().prepareSearch()
            .highlighter(highlight().field("field2").order("score").preTags("<x>").postTags("</x>"));
        SearchResponse search = client().prepareSearch()
                    .phraseLimit(30000)
        assertFailures(
                );
            assertNull(searchResponse.getHits().getAt(0).getHighlightFields().get("_id"));
            )
            .highlighter(new HighlightBuilder().field(fooField).field(barField))
                "This <em>sentence</em> contains one match, not that short. "
        ensureGreen();
            prepareCreate("test").setMapping(
    }
            prepareCreate("test").setMapping(
    public void testResetTwice() throws Exception {
        assertAcked(
            .highlighter(new HighlightBuilder().field("title.key"))
            .setId("1")
            .numOfFragments(0)
        client().prepareIndex("test").setId("1").setSource(jsonBuilder().startObject().field("text", "foo").endObject()).get();
            1,
            containsString("source is forced for fields [field1] but _source is disabled")
                anyOf(equalTo("Another <xxx>sentence</xxx> with"), equalTo("Another <xxx>sentence</xxx> with even more words. "))
        fooField = new Field("foo").numOfFragments(1)
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));
            .noMatchSize(21);
            .setSource("field1", "The quick brown fox jumps over", "field2", "The quick brown fox jumps over")
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            client().prepareSearch()
            .startObject("unstored_field")
        SearchSourceBuilder source = searchSource()
                "no_long_term",
            .endObject();
            0,
        HighlightField field = searchResponse.getHits().getAt(0).getHighlightFields().get("foo_text");
            matches("source is forced for fields \\[field\\d, field\\d\\] but _source is disabled")
            .setQuery(matchQuery("title.key", "this is a test"))
        checkFvhMatchedFieldsCase(true);
import org.opensearch.index.query.MatchQueryBuilder;
                    .field("analyzer", "classic")
                    public Analyzer get() {
        assertHighlight(resp, 0, "foo", 0, equalTo("junk junk <em>cats</em> junk junk"));
                    .field("store", false)
                        .field("term_vector", "with_positions_offsets")
                        .field("store", true)
        indexRandomForConcurrentSearch("test");
                "type=text,store=false",
import static org.opensearch.index.query.QueryBuilders.regexpQuery;
            "field2",
        assertFailures(
                    .numOfFragments(1)
                        .field("type", "text")
            .endObject();
            .endObject()
                    .field("type", "text")
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
            .setQuery(QueryBuilders.matchQuery("field1", "fox"))
            .startObject("field2")
        SearchRequestBuilder req = client().prepareSearch("test").highlighter(new HighlightBuilder().field(fooField));
                            + "The lazy red <field1>fox</field1> jumps over the quick dog. "
        for (int i = 0; i < indexRequestBuilders.length; i++) {
                        .endObject()
        SearchResponse searchResponse = client().prepareSearch()
        for (String type : ALL_TYPES) {
        QueryBuilder twoFieldsQuery = queryStringQuery("cats").field("foo").field("foo.plain", 5).field("bar").field("bar.plain", 5);
            .field("index_options", "offsets")
        assertHighlight(search, 0, "title.key", 0, 1, equalTo("<em>this</em> <em>is</em> <em>a</em> <em>test</em>"));
        createIndex("test");
            0,
                    .endObject()
        for (int i = 0; i < indexRequestBuilders.length; i++) {
        indexRandom(true, indexRequestBuilders);
            0,
            searchResponse = client().prepareSearch()
        fooField.matchedFields("foo.plain");
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();
            )
                new String[] {
        assertThat(
        index(
        field.highlighterType("unified");
        assertAcked(prepareCreate("test").setMapping(mappings));
            .startObject("properties")
        refresh();
                    new Field("tags").highlighterType("plain").fragmentSize(-1).numOfFragments(2).fragmenter("span")
    }
        assertHighlight(response, 0, "text", 0, 1, equalTo("This is the first"));
            .fragmentSize(25)
            prepareCreate("test").setSettings(settings)
    public void testHighlightingWhenFieldsAreNotStoredThereIsNoSource() throws IOException, InterruptedException {
        assertHighlight(response, 0, "field2", 0, 1, equalTo("The <b>slow<b> brown <2>fox</2>"));
        fooField.matchedFields("foo", "foo.plain");
            .get();
        ensureGreen();
        ensureGreen();
            assertHighlight(search, i, "title", 0, 1, equalTo(" highlighting <em>test</em> for *&amp;? opensearch"));
            assertHighlight(response, 0, "foo", 0, 1, equalTo("<em>test</em> japanese"));
            assertHighlight(
        SearchResponse response = search.setQuery(boolQuery().must(terms).should(phrase)).get();
            queryStringQuery("\"highlight words together\"").field("field1")
            .fragmentSize(25)
                0,
                        new HighlightBuilder.Field("field2").preTags("<field2>")
    }
 * ownership. Elasticsearch licenses this file to you under
        refresh();
                new HighlightBuilder().field("field1", 100, 1).order("score").highlighterType(highlighterType).requireFieldMatch(true)
        }
                1,
        SearchResponse defaultPhraseLimit = client().search(searchRequest("test").source(source)).actionGet();
            "cat cat junk junk junk junk junk junk junk cats junk junk",
                "field1",
            searchResponse,
                .requireFieldMatch(randomBoolean());
                    .endObject()
            .highlighter(new HighlightBuilder().field(new Field("foo_copy")))
                    .startObject("fields")
                    .startArray("foo")
                    )
                "type=double"
                        .boundaryScannerLocale(Locale.ENGLISH.toLanguageTag())
            .get();
            .highlighter(new HighlightBuilder().field("title"))
        field.highlighterType("plain").noMatchSize(randomIntBetween(Integer.MIN_VALUE, -1));
                0,
                new HighlightBuilder().field(
                    .field("analyzer", "classic")
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .setSource("text", "opensearch test", "byte", 25, "short", 42, "int", 100, "long", -1, "float", 3.2f, "double", 42.42)
            .get();
        logger.info("--> highlighting and searching on field1 and field2 produces different tags");
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
            .setSource("keyword", "Hello World")
        );
            .get();
            .setQuery(matchQuery("titleTV", "highlight"))
        indexRandomForConcurrentSearch("test");
        for (String type : ALL_TYPES) {
            equalTo("here is another one that is very <em>long</em> <em>tag</em> and has the tag token near the end")
                    .field(new HighlightBuilder.Field("field1").numOfFragments(2))
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
            .get();
        b.endObject();
                        + "This one contains no matches." }
    }
        field.highlighterType("plain").noMatchSize(text.length());
    public void testMatchedFieldsWithUnified() throws Exception {
                .setQuery(matchQuery("foo", "test"))
        assertHitCount(searchResponse, 1L);
            .highlighter(new HighlightBuilder().field("title", -1, 0))
                0,
        indexRandom(
    }
                new String[] { "this is another test", "yet another test" }
        }
                searchResponse,
            .setQuery(matchQuery("title.key", "this is a test"))
                    highlight().field("field1", 21, 2)
                    .startObject("attachments")
        indexRandomForConcurrentSearch("test");
                    .field("store", true)
        );
        SearchResponse search = client().prepareSearch()
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        req = client().prepareSearch("test").highlighter(new HighlightBuilder().field(fooField));
                new HighlightBuilder().field(
            equalTo("The <em>quick</em> brown fox jumps over the lazy dog! Second sentence.")
        logger.info("--> searching with boundary characters");
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            SearchSourceBuilder source = searchSource().query(termQuery("field1", "sentence"))
            field1.fragments()[3].string(),
            .highlighter(highlight().field("field2", 30, 1).boundaryChars(new char[] { ' ' }));
                    .endObject()
        for (int i = 0; i < COUNT; i++) {
                        .field("store", true)
            )
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
            .endObject()
        logger.info("--> highlighting and searching on field1");
        }
            RestStatus.BAD_REQUEST,
        assertNotHighlighted(response, 0, "text");
        field.highlighterType("unified");
        // like before we added it.
            .order("score")
        SearchResponse searchResponse = client().search(searchRequest("test").source(source)).actionGet();
            SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
        // search on title.key and highlight on title
        // Mock tokenizer will throw an exception if it is resetted twice
        refresh();
    public void testGeoFieldHighlightingWithDifferentHighlighters() throws IOException, InterruptedException {
        assertNotHighlighted(response, 0, "text");
            .order("score")
            .startObject("alias")
        client().prepareIndex("test")
    public void testBoostingQueryTermVector() throws IOException, InterruptedException {
                    .startObject("properties")
        indexRandomForConcurrentSearch("test");
            .startObject("properties")
                i,
                        .preTags("<xxx>")
            .field("type", "nested")
        ).highlighter(highlight().field("field1"));
    }
        SearchResponse response = client().prepareSearch("test")
                "type=float",
            .get();
        }
                "long_term",
                        .endArray()
        );
        refresh();
            .get();
                "double",
            prepareCreate("test").setMapping(
        mappings.startObject("properties")
        assertAcked(prepareCreate("test").setMapping("title", "type=text,store=true"));
    public void testPostingsHighlighterQueryString() throws Exception {
        indexRandomForConcurrentSearch("test");
                    .field("term_vector", "with_positions_offsets")
        {
                    .startObject("properties")
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("<em>aaab</em>"));
import static org.opensearch.test.hamcrest.RegexMatcher.matches;
                .setSource("title", "This is a test on the highlighting bug present in opensearch");
                    .startObject("properties")
        for (int i = 0; i < 5; i++) {
    }
        assertNotHighlighted(response, 0, "text");
        // When noMatchSize is set to 0 you also shouldn't get any
        index("test", "type1", "1", "text", new String[] { text1, text2 });
                    .startObject("title")
                    .endObject()
            indexRequestBuilders[i] = client().prepareIndex("test")
            assertNotHighlighted(search, i, "title");
import org.opensearch.index.analysis.AnalyzerProvider;
                assertHighlight(
            field = searchResponse.getHits().getAt(0).getHighlightFields().get("foo.text");
            prepareCreate("test").setSettings(settings)
            .endObject()
        indexRandom(true, client().prepareIndex("test").setSource("foo", "test japanese"));
        searchResponse = client().search(searchRequest("test").source(source)).actionGet();
    }
            .highlighter(new HighlightBuilder().field("title", 50, 1, 10).highlighterType("fvh"))
        assertHighlight(response, 0, "field1", 0, 1, highlightedMatcher);
            0,
        String mapping = jsonBuilder().startObject()
        assertNotHighlighted(response, 0, "text");
                    .field("term_vector", "with_positions_offsets")
        }
                .prepareCreate("index-1")
            )
            0,
            .highlighter(new HighlightBuilder().field("title"))
        client().prepareIndex("test")
                .get();
         * I hate comparing times because it can be inconsistent but default is
            .setSource(jsonBuilder().startObject().field("text", "brown").endObject())
            .setSource(jsonBuilder().startObject().field("foo", "how now brown cow").endObject())
                    .preTags("<global>")
        indexRandomForConcurrentSearch("test");
                .highlighter(new HighlightBuilder().field(new Field("foo.text").highlighterType(type)))
        assertHighlight(
        ensureGreen();
    public void testMultiMatchQueryHighlight() throws IOException, InterruptedException {
        field.highlighterType("fvh");
                    .field("store", true)
        assertNotHighlighted(response, 0, "text");
    public void testPostingsHighlighterPrefixQueryWithinBooleanQuery() throws Exception {
        XContentBuilder b = jsonBuilder().startObject().startObject("properties");
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("this is a <xxx>test</xxx>"));
        assertThat(response.getHits().getHits()[0].getHighlightFields().isEmpty(), equalTo(true));
            assertHighlight(search, i, "title", 1, 2, equalTo("This is the second <em>bug</em> to perform highlighting on."));
            )
        logger.info("--> highlighting and searching on field1");
            .endObject()
        assertHighlight(response, 0, "text", 0, 1, equalTo(text));
    public void testPostingsHighlighterMultiTermQueryMultipleLevels() throws Exception {
            .field("index_options", "offsets")
            .field("type", "text")
            .field("index_options", "offsets")
        );
            .get();
                    .startObject("fields")
        // like before we added it.
            .endObject()
        // should not fail if there is a wildcard
        XContentBuilder mappings = jsonBuilder();
        for (String type : new String[] { "unified", "plain" }) {
                        .field("term_vector", "with_positions_offsets")
        );
        refresh();
    }
        assertAcked(
    public void testWithNormalizer() throws Exception {
        for (SearchHit searchHit : searchResponse.getHits()) {
                    XContentFactory.jsonBuilder()
                    .field("type", "text")
                        .setCorners(new GeoPoint(48.934059, 41.610741), new GeoPoint(-23.065941, 113.610741))
        source = searchSource().query(wildcardQuery("field2", "qu*k")).highlighter(highlight().field("field2"));
                    .endObject()
        indexRandom(
        );
        String text = "I am pretty long so some of me should get cut off. Second sentence";
        SearchResponse searchResponse = client().search(searchRequest("test").source(source)).actionGet();
                jsonBuilder().startObject()
        ensureSearchable("index-1");
@TimeoutSuite(millis = 35 * TimeUnits.MINUTE)
        indexRandomForConcurrentSearch("test");
                equalTo("This is a test on the highlighting <em>bug</em> present in opensearch. Hopefully it works.")
import static org.hamcrest.Matchers.containsString;
                        "here is another one that is very long tag and has the tag token near the end"
        assertThat(field1.fragments().length, equalTo(4));
            assertHitCount(searchResponse, 1);
            .setId("1")
            .setSource(jsonBuilder().startObject().field("unstored_text", "text").field("text", "text").endObject())
                "no_long_term",
            1,
                    .endObject()
        );
            // postings hl doesn't support require_field_match, its field needs to be queried directly
        indexRandomForConcurrentSearch("test");
        String highlighterType,
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
                    .endObject()
            .fragmentSize(25)
                    .startObject("properties")
                .setSource("field1", "Sentence " + prefix + " test. Sentence two.");
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
        logger.info("--> highlighting and searching on field2");
                            .fragmentSize(50)
            private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
        assertHighlight(search, 0, "title", 0, 1, equalTo("this is a <em>test</em>"));
                    .endObject()
            .setSource(new SearchSourceBuilder().query(query).highlighter(new HighlightBuilder().highlighterType("plain").field("jd")))
                    .fragmentSize(1)
        client().prepareIndex("test").setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog").get();
        indexRandomForConcurrentSearch("test");
                    .startObject("key")
                    .field("term_vector", "with_positions_offsets")
        indexRandomForConcurrentSearch("test");
            )
                "field-fvh",
            0,
        ensureGreen();
            searchResponse,
        );
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
 */
            .noMatchSize(20);
            .highlighter(
        refresh();
            String highlighterType = rarely() ? null : RandomPicks.randomFrom(random(), ALL_TYPES);
            .field("type", "text")
            .highlighter(highlight().field("field2").preTags("<xxx>").postTags("</xxx>"));
                    .field("term_vector", "with_positions_offsets")
            "type1",
                2,
            .field("type", "text")
        searchResponse = client().search(searchRequest("test").source(source)).actionGet();
    }
        field.highlighterType("fvh");
        refresh();
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();
    public void testPostingsHighlighterBoostingQuery() throws IOException, InterruptedException {
 * not use this file except in compliance with the License.
                "long",
            prepareCreate("test").setMapping(
                    .startObject("title")
        client().prepareIndex("test")
        refresh();
        SearchResponse search = client().prepareSearch().setQuery(matchQuery("alias", "foo")).highlighter(builder).get();
            .highlighter(new HighlightBuilder().encoder("html").field("title.key", 50, 1))
            .field("copy_to", "foo_text")
        for (int i = 0; i < 6000; i++) {
                .setId(Integer.toString(i))
     * The FHV can spend a long time highlighting degenerate documents if
        }
                    .startObject()
        refresh();
        settings.put(indexSettings());
                        .field("analyzer", "standard")
                    .field("index_options", "offsets")
            prepareCreate("test").setMapping(
        refresh();
                    .startObject("title")
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        assertHighlight(resp, 0, "foo", 0, equalTo("running with <em>scissors</em>"));
        XContentBuilder mappings = jsonBuilder();
            equalTo("here is another one that is very <em>long</em> <em>tag</em> and has the tag token near the end")
        // Query string with more than one field
        assertAcked(prepareCreate("test").setMapping(mappings));
        SearchResponse search = client().prepareSearch()
                .setQuery(matchPhraseQuery("title", "this is a test"))
            MultiMatchQueryBuilder multiMatchQueryBuilder = multiMatchQuery("the quick brown fox", "field1", "field2").type(matchQueryType);
    public void testPostingsHighlighterMultiMapperWithStore() throws Exception {
        assertHighlight(resp, 0, "foo", 0, equalTo("running with <em>scissors</em>"));
         */
            .highlighter(highlight().field("field1", 100, 0).order("score").preTags("<xxx>").postTags("</xxx>"));
        assertHighlight(response, 0, "tags", 0, equalTo("this is a really <em>long</em> <em>tag</em> i would like to highlight"));
        refresh();
        req = client().prepareSearch("test").highlighter(new HighlightBuilder().field(fooField));
            assertHighlight(search, 1, "tags", 0, 1, equalTo("<em>foo bar</em>"));
                "field1",
                    .startObject("properties")
                    .field("type", "text")
    public void testDoesNotHighlightAliasFilters() throws Exception {
                0,
            .order("score")
import static org.opensearch.index.query.QueryBuilders.matchQuery;
 * software distributed under the License is distributed on an
        String text2 = "I am short";
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));
                    .field("type", "text")
        SearchResponse searchResponse = client().search(searchRequest("test").source(source)).actionGet();
                    .startObject()
import org.apache.lucene.analysis.TokenFilter;
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
            .startObject("properties")
                    @Override
        assertAcked(
            MockSnowBall(TokenStream in) {
import static org.hamcrest.Matchers.hasKey;
                QueryBuilders.geoBoundingBoxQuery("geo_point")
                    .field("type", "text")
        refresh();
                    "One sentence match here and scored lower since the text is quite long, not that appealing. "
        ensureGreen();
        ensureGreen();
            field.highlightQuery(matchQuery("text", "query"));
            .highlighter(new HighlightBuilder().field("title", -1, 0))
                        .field("body", "attachment 2")
    public void testMultiMapperVectorFromSource() throws Exception {
            .get();
        indexRandomForConcurrentSearch("test");
        // stopwords are now highlighted since we used only whitespace analyzer here
        SearchResponse searchResponse = client().prepareSearch()
            prepareCreate("test").setSettings(
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.Field;
        }
            .endObject();
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
                        .should(QueryBuilders.termQuery("field", "hello"))
                    .field("store", false)
                    .endObject()
            text.append("junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk\n");
        for (int i = 0; i < indexRequestBuilders.length; i++) {
        assertNotHighlighted(response, 0, "text");
        SearchSourceBuilder source = searchSource().query(constantScoreQuery(regexpQuery("field1", "pho[a-z]+")))
                        .field("title", "This is a test on the highlighting bug present in opensearch")
                    equalTo(
        field.highlighterType("unified");
            .setId("1")
        text.append("highlight words together\n");
                    // we don't store title, now lets see if it works...
            )
            .field("type", "alias")
                jsonBuilder().startObject()
        assertHighlight(
            .get();
        source = searchSource().query(matchPhraseQuery("field2", "quick brown"))
import org.opensearch.action.support.WriteRequest;
        }
        assertNoFailures(
    }
        assertAcked(
        // test the kibana case with * as fieldname that will try highlight all fields including meta fields
        ensureGreen();
            0,
        }
                    new HighlightBuilder.Field("highlight_field").fragmentSize(-1).numOfFragments(1).fragmenter("simple")
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
                    .field("index_options", "offsets")
        XContentBuilder mappings = jsonBuilder();
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();
            0,
                );
                searchResponse,
    public void testDoesNotHighlightTypeName() throws Exception {
            .get();
            assertThat(field.getFragments().length, equalTo(1));
        resp = req.setQuery(twoFieldsQuery).highlighter(new HighlightBuilder().field(fooField).field(barField)).get();
        // but we highlight the root text field since nested documents cannot be highlighted with postings nor term vectors
            search = client().prepareSearch()
        );
                "float",
        field.highlighterType("unified");
        b.startObject("foo_copy").field("type", "text").field("store", true).endObject();
        mappings.endObject();
            .field("index_options", "offsets")
            "bar",
        indexRandomForConcurrentSearch("test");
        // Try with a bool query
        ensureGreen();
            .setQuery(QueryBuilders.matchQuery("text", "test"))
                        .startObject()
                    .field(new HighlightBuilder.Field("field2").preTags("<2>").postTags("</2>").requireFieldMatch(false))
        );
                .addSort("d", SortOrder.DESC)
        indexRandomForConcurrentSearch("test");
            equalTo("here is another one that is very long and has the <em>tag</em> token near the end")
        SearchResponse search = client().prepareSearch()
        assertHighlight(response, 0, "text", 0, 2, equalTo("This is the <em>third</em> sentence. This is the fourth sentence."));
            .startObject()
        assertThat(
            .setId("1")
        indexRandomForConcurrentSearch("test");
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so some"));
                    .startObject("title")
        return XContentFactory.jsonBuilder()
                    .endObject()
                    .startObject("title")
    }
    }
            2,
                    "This is the second value's first sentence. This one contains no matches. "
                    .setCorners(61.10078883158897, -170.15625, -64.92354174306496, 118.47656249999999)
            client().admin()
                )
            client().prepareSearch("test")
                    .endObject()
                searchResponse,
            .field("type", "text")
                        .field("body", "attachment 2")
        indexRandomForConcurrentSearch("test");
            .setQuery(matchQuery("title", "bug"))
                .highlighter(new HighlightBuilder().field(new Field("*").highlighterType(type)))
            )
        SearchRequestBuilder req = client().prepareSearch("test").highlighter(new HighlightBuilder().field(fooField));
        }
            .setId("1")
                        .endArray()
                .setSource("title", "This is a html escaping highlighting test for *&? opensearch");
                    .startObject("properties")
            .endObject()
                    )
        index("test", "type1", "1", "text", new String[] { text1, text2, text3 });
            prepareCreate("test").setMapping(
        search = client().prepareSearch()
                    equalTo("The quick brown <field1>fox</field1> jumps over the lazy dog. Second sentence not finished")
        indexRandomForConcurrentSearch("test");
        SearchSourceBuilder source = searchSource().query(termQuery("field1", "test"))
        assertNotHighlighted(response, 0, "text");
        assertHighlight(resp, 0, "bar", 0, equalTo("<em>cat</em> <em>cat</em> junk junk junk junk"));
        assertAcked(prepareCreate("test").setMapping(mappings));
        indexRandom(true, indexRequestBuilders);
                .setSource("title", "This is a html escaping highlighting test for *&? opensearch");
                equalTo("This is a test on the highlighting <em>bug</em> " + "present in opensearch")
            .setQuery(matchPhraseQuery("title", "test for the workaround"))
            .field("index_options", "offsets")
            assertHighlight(search, i, "attachments.body", 1, equalTo("<em>attachment</em> 2"));
                .get()
            .execute()
                    .field("type", "text")
    }
        }
            assertHitCount(searchResponse, 1);
            )
            .field("type", "text")
        assertAcked(
        }
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
            equalTo("This is the second value's first <em>sentence</em>. This one contains no matches.")
        resp = req.setQuery(queryStringQuery("cats").field("foo").field("foo.plain", 5)).get();
                "field1",
    public void testDisableHighlightIdField() throws Exception {
            .startObject("properties")
        client().prepareIndex("test").setId("1").setSource("title", "this is a test . Second sentence.").get();
        mappings.startObject();
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
import org.opensearch.plugins.Plugin;
            assertHighlight(hit, "field1", 0, 1, equalTo("Sentence " + prefix + " <em>test</em>. Sentence two."));
            .highlighter(new HighlightBuilder().field("text"))
            .setSource(jsonBuilder().startObject().field("keyword_field", "some text").endObject())
            0,
            assertHighlight(search, 0, "text", 0, equalTo("<em>text</em>"));
        SearchResponse response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
    public void testFieldAliasWithWildcardField() throws IOException, InterruptedException {
            .highlighter(
            .get();
            .startObject("text")
                        .endObject()
        for (String type : ALL_TYPES) {
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()).get());
            .highlighterType("plain")
                        .endObject()
        search = client().prepareSearch()
                        .startObject()
        assertAcked(prepareCreate("test").setMapping("title", "type=text,store=true,term_vector=no"));
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));
                .get();
            .highlighter(new HighlightBuilder().encoder("html").field("title", 50, 1))
                jsonBuilder().startObject()
                1,
                .indices()
        assertThat(field.getFragments()[0].string(), equalTo("<em>brown</em>"));
    public void testHighlightQueryRewriteDatesWithNow() throws Exception {
    }
            .field("term_vector", "with_positions_offsets")
            .highlighter(new HighlightBuilder().field(new Field("text")))
        logger.info("--> indexing docs");
                    .field("jd", "some आवश्यकता है- आर्य समाज अनाथालय, 68 सिविल लाइन्स, बरेली को एक पुरूष" + " रस text")
        refresh();
            "field2",
                    .startObject("key")
            .highlighter(new HighlightBuilder().field("title", -1, 0))
            .get();
            )
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("The <xxx>quick</xxx> brown fox jumps over the lazy dog"));
    }
                        .startObject()
            .field("type", "text")
        refresh();
        assertNoFailures(search);
        assertNoFailures(search);
            .endObject()
        }
/*
        field.highlighterType("plain");
        // if there's a match we only return the values with matches (whole value as number_of_fragments == 0)
                .filter(
            .setSource(
        // Now make sure boosted fields don't blow up when matched fields is both the subfield and stored field.
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
                    .field("store", false)
        SearchResponse searchResponse = client().prepareSearch()
        ensureGreen();
                .setId(Integer.toString(i))
        settings.put("index.analysis.analyzer.mock_english.tokenizer", "standard");
        assertThat(resp.getHits().getAt(0).getHighlightFields(), not(hasKey("foo")));
                    .field("type", "text")
 * The OpenSearch Contributors require contributions made to
                    .field("text", "brown")
            .endObject()
        client().prepareIndex("test").setId("1").setSource("text", "foo").get();
        }
            .startObject("text")
            0,
                    .field("store", true)
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("The <x>quick</x> <x>brown</x> fox jumps over the lazy dog"));
        Field barField = new Field("bar").numOfFragments(1)
        indexRandomForConcurrentSearch("test");
    }
                    .field("type", "text")
            )
            prepareCreate("test").setMapping(
import org.apache.lucene.search.join.ScoreMode;
                        return instance;
                .setQuery(termQuery("field1", "quick"))
            .startObject("geo_point")
            .endObject();
        assertHighlight(searchResponse, 0, "field1", 1, 2, equalTo("<global>test</global>"));
        prepareCreate("test").setMapping(mapping).get();
        // simple search on body with standard analyzer with a simple field query
        }
                return new AbstractIndexAnalyzerProvider<Analyzer>(indexSettings, name, settings) {
            assertHighlight(
        assertHighlight(
                search,
                ),
            field1.fragments()[2].string(),
                .should(matchQuery("field1", "test"))
            client().prepareSearch()
        assertHighlight(
        }
            assertThat(field.getFragments().length, equalTo(1));
            .highlighter(new HighlightBuilder().field("title"))
    }
                    + " The lazy red <field1>fox</field1> jumps over the quick dog."
            .highlighter(new HighlightBuilder().encoder("html").field("title", 50, 1))
            .setSource(
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;
                .setId(Integer.toString(i))
                .setQuery(matchQuery("_id", "d33f85bf1e51e84d9ab38948db9f3a068e1fe5294f1d8603914ac8c7bcc39ca1"))
        }
                        .highlighterType(type)
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
            .startObject("keyword")
        public List<PreConfiguredTokenFilter> getPreConfiguredTokenFilters() {
            .endObject()
 * specific language governing permissions and limitations
            .get();
        );
            .startObject("alias")
        for (String type : ALL_TYPES) {
        String pattern = "t   ";
            .get();
        search = client().prepareSearch()
        client().prepareIndex("test").setId("1").setSource(jsonBuilder().startObject().field("field", "highlight").endObject()).get();
        String text1 = "I am pretty long so some of me should get cut off. We'll see how that goes.";
            .highlighter(new HighlightBuilder().field("attachments.body", -1, 2))
 *
                anyOf(equalTo("<xxx>some</xxx> quick and hairy brown"), equalTo("<xxx>some</xxx>"))
    public void testHighlighterWithWordBoundaryScanner() throws Exception {
            .setSource(
        client().prepareIndex("test")
        SearchResponse resp = req.setQuery(queryStringQuery("running scissors").field("foo")).get();
    }
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
            .field("type", "text")
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("this is a <xxx>test</xxx>"));
        assertThat(search.getHits().getTotalHits().value(), equalTo(1L));
                    .endObject()
            .highlighter(new HighlightBuilder().field("title", 30, 1, 10).highlighterType("fvh"))
            "field1",
                        .startObject("fields")
        logger.info("--> highlighting and searching on field2");
    }
                .get()
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            assertHitCount(searchResponse, 1);
                        .startObject("properties")
                2,
        assertHighlight(resp, 0, "bar", 0, equalTo("<em>cat</em> <em>cat</em> junk junk junk junk"));
            .field("type", "text")
                .highlighter(
                "field2",
        client().prepareIndex("test")
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[COUNT];
            .setSize(COUNT)
        SearchResponse searchResponse = client().prepareSearch("test")
            .get();
        field.highlighterType("unified");
            );
            SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
        refresh();
                        .startArray("attachments")
        searchSource = SearchSourceBuilder.searchSource()
                "field1",
        phraseBoostTestCaseForClauses(
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();
            );
            assertHitCount(searchResponse, 1L);
        assertHighlight(response, 0, "text", 0, 2, equalTo("This is the <em>third</em> sentence. This is the fourth sentence."));
        assertHighlight(search, 0, "name", 0, startsWith("<em>abc</em> <em>abc</em> <em>abc</em> <em>abc</em>"));
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
    public void testEscapeHtmlVector() throws Exception {
        SearchSourceBuilder source = searchSource().query(
                    .endObject()
                    .field("index_options", "docs")
            .setQuery(matchQuery("title", "bug"))
                        .startObject()
        assertHitCount(searchResponse, 1L);
    public void testFastVectorHighlighterPhraseBoost() throws Exception {
        assertAcked(prepareCreate("test").setMapping(mappings));
            assertThat(field.getFragments()[0].string(), equalTo("<em>brown</em> <em>cat</em>"));
            field = new HighlightBuilder.Field("text");
            assertHighlight(response, 0, "foo", 0, 1, equalTo("<em>test</em> typename"));
        ensureGreen();
            0,
        Settings.Builder settings = Settings.builder();
                    .endObject()
            .startObject("alias")
    public void testHighlightIssue1994() throws Exception {
            SearchResponse response = client().prepareSearch("test")
            .setSource("keyword", "Hello World")
        assertNotHighlighted(response, 0, "text");
        client().prepareIndex("test")
            .field("store", true)
                    .field("type", "text")
            .setQuery(matchQuery("title", "this is a test"))
                .setQuery(nestedQuery("foo", matchPhraseQuery("foo.text", "brown cat"), ScoreMode.None))
            assertHighlight(search, i, "title", 0, 1, equalTo("highlighting <em>bug</em> present in opensearch"));
        SearchResponse searchResponse = client().search(searchRequest("test").source(source)).actionGet();
                .highlighter(
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
    public void testFiltersFunctionScoreQueryHighlight() throws Exception {
                        .field("type", "text")
        searchResponse = client().search(searchRequest("test").source(source)).actionGet();
        client().prepareIndex("test").setId("1").setSource("name", builder.toString()).get();
                    .field("term_vector", "with_positions_offsets")
            // LUCENE 3.1 UPGRADE: Caused adding the space at the end...
        client().prepareIndex("test").setId("1").setSource("title", "this is a test").get();
        int COUNT = between(20, 100);
                .setQuery(nestedQuery("foo", prefixQuery("foo.text", "bro"), ScoreMode.None))
    public void testFvhMatchedFieldsFvhNoRequireFieldMatch() throws Exception {
                    .field("store", false)
                            "This is the second bug to perform highlighting on."
        refresh();
        );
                )
                    .endObject()
                equalTo("This is a html escaping highlighting <em>test</em> for *&amp;? opensearch")
        SearchResponse search = client().prepareSearch()
            assertHighlight(
        );
            .endObject()
            .highlighter(new HighlightBuilder().field("attachments.body", -1, 0))
        // Using plain highlighter instead of FVH on the field level
        for (String highlighterType : new String[] { "plain", "unified" }) {
            "1",
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am short"));
        mappings.startObject("properties").startObject("keyword_field").field("type", "keyword").endObject().endObject();
                    .endArray()
                .highlighter(new HighlightBuilder().field(new Field("unstored_text")))
        client().prepareIndex("test")
        // Query string boosting the field
            .field("store", false)
            SearchResponse search = client().prepareSearch().setQuery(matchQuery("alias", "foo")).highlighter(builder).get();
            )
                1,
        assertNotHighlighted(response, 0, "text");
        response = client().prepareSearch("test")
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
            .requireFieldMatch(requireFieldMatch);
            SearchRequestBuilder search = client().prepareSearch("test")
                        .startArray("attachments")
        indexRandomForConcurrentSearch("test");
        for (int i = 0; i < indexRequestBuilders.length; i++) {
import java.util.List;
            .get();
    public void testFSHHighlightAllMvFragments() throws Exception {
    private static final String[] ALL_TYPES = new String[] { "plain", "fvh", "unified" };
                    + "This <em>sentence</em> contains two <em>sentence</em> matches."
    }
            .field("index_options", "offsets")
            .setQuery(matchQuery("title", "this is a test"))
    }
        ensureGreen();
        // Finding the same string two ways is ok too
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
            .setQuery(matchQuery("text", "foo"))
 * Licensed to Elasticsearch under one or more contributor
    public HighlighterSearchIT(Settings staticSettings) {
            .setQuery(matchPhraseQuery("no_long_term", "test foo highlighed").slop(3))
            .setQuery(nestedQuery("foo", matchQuery("foo.text", "brown cow"), ScoreMode.None))
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>weird</em>"));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    }
            .field("term_vector", "with_positions_offsets")
                        "tags",
    }
    }
                0,
                "title",
        indexRandom(true, indexRequestBuilders);
        source = searchSource().query(matchQuery("field2", "quick"))
        for (int i = 0; i < indexRequestBuilders.length; i++) {
                0,
        SearchResponse response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
                .setId(Integer.toString(i))
                .setQuery(QueryBuilders.matchQuery("text", "testing"))
                i,
        for (String highlighter : ALL_TYPES) {
        mappings.startObject();
                        .startArray("attachments")
            equalTo("The <em>quick</em> brown fox jumps over the lazy dog! Second sentence.")
                )
        // The FVH also works but the fragment is longer than the plain highlighter because of boundary_max_scan
                    .field("index_options", "offsets")
            assertThat(field.getFragments().length, equalTo(2));
    public void testHighlighterWithSentenceBoundaryScanner() throws Exception {
    }
                    highlight().field("field1", 21, 2)
            .endObject()
            .highlighter(highlight().field("field2").order("score").preTags("<xxx>").postTags("</xxx>"));
                .highlighter(new HighlightBuilder().field(new Field("tags")).numOfFragments(2).boundaryScannerType(scanner))
        fooField.matchedFields("foo", "bar.plain");
        indexRandomForConcurrentSearch("test");
            HighlightField field = searchResponse.getHits().getAt(0).getHighlightFields().get("text");
            .highlighter(highlight().field("field1"));
import static org.opensearch.index.query.QueryBuilders.existsQuery;
        assertHitCount(response, 1);
        refresh();
    public void testSourceLookupHighlightingUsingFastVectorHighlighter() throws Exception {
            assertHighlight(search, i, "title", 0, equalTo("This is a test on the highlighting <em>bug</em> present in opensearch"));
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        Field fooField = new Field("foo").numOfFragments(1).order("score").fragmentSize(25).highlighterType("unified");
            .get();
        client().prepareIndex("test").setId("1").setSource("text", "opensearch test").get();
        assertThat(resp.getHits().getAt(0).getHighlightFields(), not(hasKey("bar")));
                    .field("store", false)
        assertHighlight(response, 0, "text", 1, 2, equalTo("This is the <em>fifth</em> sentence"));
        assertNotHighlighted(search, 0, "no_long_term");
        // works using stored field
                .setSource("title", "This is a test for the workaround for the fast vector highlighting SOLR-3724");
            assertHitCount(searchResponse, 1);
        assertThat(field.getFragments()[0].string(), equalTo("<em>brown</em>"));
                if (input.incrementToken()) {
                        .startObject()
            .startObject("loc")
    public void testPostingsHighlighterCommonTermsQuery() throws IOException, InterruptedException {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            .endObject();
        logger.info("--> highlighting and searching on 'field' with word boundary_scanner");
        ensureGreen();
    public void testPostingsHighlighterQueryStringWithinFilteredQuery() throws Exception {
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
            searchResponse,
        mappings.startObject("_source")
        refresh();
     * because it doesn't support the concept of terms having a different weight based on position.
                new String[] { "this is a test", "this is the second test" },
            )
        SearchSourceBuilder source = searchSource().query(termQuery("field1", "test"))
        client().prepareIndex("test")
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so some"));
            response = search.get();
                        .must(QueryBuilders.rangeQuery("d").gte("now-12h").lte("now").includeLower(true).includeUpper(true).boost(1.0f))
        for (String type : new String[] { "fvh", "unified" }) {
                        .field("body", "attachment 1")
        index("test", "type1", "1", "text", "Testing the highlight query feature");
        );
                    .startObject("fields")
            .field("type", "text")
            field.highlighterType(type).noMatchSize(text.length() * 2).numOfFragments(0);
        phraseBoostTestCase("fvh");
                    .startObject("body")
            RestStatus.BAD_REQUEST,
        field.highlighterType("fvh");
                    .field("term_vector", "no")
        mappings.startObject();
                    .field("text", "cow")
            return singletonList(PreConfiguredTokenFilter.singleton("mock_snowball", false, MockSnowBall::new));
            .startObject("foo_text")
                .setQuery(constantScoreQuery(matchQuery("text", "text")))
import static org.opensearch.index.query.QueryBuilders.termQuery;
                "type=text,store=false,term_vector=with_positions_offsets"
            .setQuery(
        Map<String, String> prefixes = new HashMap<>(COUNT);
        refresh();
                        .startObject("bar")
        mappings.startObject();
            equalTo("The <em>quick</em> brown fox jumps over the lazy dog! Second sentence.")
        assertHighlight(defaultPhraseLimit, 0, "field1", 0, 1, containsString("<xxx>t</xxx>"));
            client().prepareSearch("test").setSource(searchSource),
                    .startObject("properties")
        // which can also be written by searching on the subfield
        field.highlighterType("fvh");
        );
        field.highlighterType("plain");
        for (int i = 0; i < indexRequestBuilders.length; i++) {
        assertAcked(prepareCreate("test").setMapping(mapping));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        refresh();
    }
                0,
                        .startObject("fields")
        assertHighlight(search, 0, "text", 0, equalTo("<em>foo</em>"));
            Matcher<String> searchQueryMatcher = equalTo("<em>Testing</em> the highlight query feature");
    public void testDisableFastVectorHighlighter() throws Exception {
                        + "This sentence contains three sentence occurrences (sentence).",
                    .endObject()
            .highlighter(highlight().field("field2").order("score").preTags("<x>").postTags("</x>"));
            .setQuery(matchQuery("long_term", "thisisaverylongwordandmakessurethisfails foo highlighed"))
                        .field("body", "attachment 1")
            );
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
}
import org.opensearch.common.settings.Settings;
            1,
                    .startObject("attachments")
            prepareCreate("test").setMapping(
                .highlighter(new HighlightBuilder().field(new Field("keyword").highlighterType(highlighterType)))
                    .field("store", true)
        idsQueryBuilder = QueryBuilders.idsQuery().addIds("4");
                        .field("type", "text")
        refresh();
        field = new HighlightBuilder.Field("unmapped").highlighterType("plain").noMatchSize(21);
        ensureGreen();
            0,
        // same as above but in this example the query gets rewritten during highlighting
            .highlighter(new HighlightBuilder().field(new Field("field1").preTags("<xxx>").postTags("</xxx>")))
        refresh();
        ensureGreen();
        logger.info("--> highlighting and searching on field1");
        fooField = new Field("foo").numOfFragments(1).order("score").fragmentSize(25).highlighterType("unified");
        field.highlighterType("fvh");
                .setSource("title", "This is a test for the postings highlighter");
 * Unless required by applicable law or agreed to in writing,
        indexRandomForConcurrentSearch("test");
        for (int i = 0; i < COUNT; i++) {
    public void testFastVectorHighlighterShouldFailIfNoTermVectors() throws Exception {
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));
            .requireFieldMatch(requireFieldMatch);
        );
        final int iters = scaledRandomIntBetween(20, 30);
        SearchResponse search = client().prepareSearch()
            field = searchResponse.getHits().getAt(0).getHighlightFields().get("foo.text");
    }
            .startObject("field1")
    }
        // Again same if the field isn't mapped
            .setQuery(matchQuery("title", "bug"))
        // First check highlighting without any matched fields set
                    if (buffer[length - 1] == 's') {
            assertThat(field.getFragments().length, equalTo(1));
        searchResponse = client().search(searchRequest("test").source(source)).actionGet();
            )
            assertHighlight(
            .highlighter(new HighlightBuilder().field("titleTV", -1, 2))
        String highlighterType = randomFrom(ALL_TYPES);
        // Query string with a single field
            )
        }
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
                    .startObject("title")
        indexRandom(
    private static String randomStoreField() {
        indexRandomForConcurrentSearch("test");
        resp = req.setQuery(queryStringQuery("running scissors").field("foo.plain")).get();
                1,
        }
            indexRequestBuilders[i] = client().prepareIndex("test")
            indexRequestBuilders[i] = client().prepareIndex("test")
            indexRequestBuilders[i] = client().prepareIndex("test").setId(Integer.toString(i)).setSource("field1", "test " + i);
            .setSource(
        mappings.startObject("properties")
            assertThat(field.getFragments().length, equalTo(1));
                    QueryBuilders.prefixQuery("text", "bro"),
        logger.info("--> highlighting and searching on field1");
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();
        SearchResponse response = client().prepareSearch("test")
                .highlighter(new HighlightBuilder().field(new Field("foo.text").highlighterType(type)))
        ensureGreen();
                search,
                    1,
            "foo",
        );
            .setSource(jsonBuilder().startObject().array("tags", "foo baz", "foo baz", "foo baz", "foo bar").field("sort", 2).endObject())
        for (SearchHit hit : searchResponse.getHits()) {
                new SearchSourceBuilder().query(QueryBuilders.matchQuery("keyword_field", "some text"))
                )
        // Setting a matchedField that isn't searched/doesn't exist is simply ignored.
                Settings.builder().put(indexSettings()).put("analysis.analyzer.my_analyzer.type", "mock_whitespace").build()
    }
            .get();
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));
    public void testEscapeHtml() throws Exception {
            .get();
        for (int i = 0; i < indexRequestBuilders.length; i++) {
        assertHighlight(response, 0, "text", 0, 1, equalTo(text));
            );
 */
                        "this is a really long tag i would like to highlight",
        // search on title.key and highlight on title.key
            client().prepareIndex("test").setId("2").setSource("titleTV", new String[] { "some text to highlight", "highlight other text" })
            100f,
        refresh();
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
            assertThat(field.getFragments()[0].string(), equalTo("<em>brown</em> cat"));
                    .startObject("fields")
    }
    public void testMultiMapperNoVectorFromSource() throws Exception {
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
    }
        client().prepareIndex("test")
                "The quick brown <field1>fox</field1> jumps over the lazy dog."
                        .boundaryScannerType(BoundaryScannerType.WORD)
        field.highlighterType("fvh");
            .highlighter(new HighlightBuilder().field(fooField).field(barField))
            searchResponse = client().prepareSearch()
    }
                    .endObject()
        source = searchSource().query(matchQuery("field2", "quick"))
import org.opensearch.common.time.DateFormatter;
                    .field("analyzer", "whitespace")
                        .startObject("foo")
                    .field("index_options", "offsets")
        );
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
        }
                        termAtt.setLength(length - 1);
        }
    public void testPostingsHighlighterOrderByScore() throws Exception {
        client().prepareIndex("test").setId("1").setSource("title", "this is a test").get();
        );
import org.opensearch.index.analysis.AbstractIndexAnalyzerProvider;
        // If the stored field doesn't have a value it doesn't matter what you match, you get nothing.
        SearchResponse search = client().prepareSearch()
            assertThat(r1.getHits().getTotalHits().value(), equalTo(1L));
        assertFailures(
                    .startObject("properties")
        assertHighlight(resp, 0, "foo", 0, equalTo("junk junk <em>cats</em> junk junk"));
                jsonBuilder().startObject()
                    new FunctionScoreQueryBuilder.FilterFunctionBuilder[] { filterBuilder }
import org.opensearch.index.query.IdsQueryBuilder;
            .setQuery(matchQuery("foo_copy", "brown"))
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
                    .startObject("fields")
    public void testFastVectorHighlighterManyDocs() throws Exception {
        );
        );
                    .endObject()
            .get();
            "field-postings",
            .startObject("properties")
        }
                    .endObject()
                    highlight().field("field1", 23, 1)
        resp = req.setQuery(queryStringQuery("foo.plain:running scissors").field("foo")).get();
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
    public void testHighlightingWithKeywordIgnoreBoundaryScanner() throws IOException, InterruptedException {
                    .startObject("properties")
        index("test", "type1", "4");
        refresh();
            .field("term_vector", "with_positions_offsets")
        }
        phraseBoostTestCaseForClauses(
            1,
                "type=byte",
                    .endObject()
            );
                .setMapping(
            .setId("1")
        float boost,
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so some"));
                    .field("store", false)
            HighlightBuilder builder = new HighlightBuilder().field(new Field("alias").highlighterType(type))
        // Query string with a single field without dismax
            .startObject("foo")
        // search on title.key and highlight on title
        // simple search on body with standard analyzer with a simple field query
            .get();
                    .postTags("</global>")
        assertHitCount(searchResponse, 1L);
                    .field("type", "text")
                    .endObject()
        );
        indexRandomForConcurrentSearch("test");
        assertAcked(
                new HighlightBuilder().field("text").field("byte").field("short").field("int").field("long").field("float").field("double")
            )
            );
    }
        );
            .get();
            SearchResponse search = client().prepareSearch().setQuery(matchQuery("alias", "bar")).highlighter(builder).get();
        assertHighlight(searchResponse, 0, "title.key", 0, 1, equalTo("<em>this</em> <em>is</em> <em>a</em> <em>test</em>"));
                    .field("analyzer", "classic")
            new RandomScoreFunctionBuilder()
        ensureGreen();
        logger.info("--> searching explicitly on field1 and highlighting on it");
        // If the stored field is found but the matched field isn't then you don't get a result either.
                "type=text"
import static java.util.Collections.singletonList;
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("text", "third fifth");
        client().prepareIndex("test").setSource("field1", "The photography word will get highlighted").get();
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                    equalTo("<field1>The</field1> <field1>quick</field1> <field1>brown</field1> <field1>fox</field1> jumps over")
            .highlighter(highlight().field("field1").order("score").preTags("<xxx>").postTags("</xxx>"));
        }
        );
    }
                jsonBuilder().startObject()
                );
        assertHighlight(
                jsonBuilder().startObject()
    // Issue #3211
                    new HighlightBuilder.Field("tags").highlighterType("plain").fragmentSize(-1).numOfFragments(2).fragmenter("simple")
        Matcher<String> highlightedMatcher = Matchers.either(containsString("<em>highlight words together</em>"))
                        .startObject()
        XContentBuilder mappings = jsonBuilder();
                i,
        SearchSourceBuilder source = searchSource().query(
            equalTo("One <em>sentence</em> match here and scored lower since the text is quite long, not that appealing.")
        }
            assertHighlight(r1, 0, "field", 0, 1, equalTo("<x>hello</x> world"));
                equalTo("This is a <em>test</em> for the <em>workaround</em> for the fast vector highlighting SOLR-3724")
    }
    }
        mappings.endObject();
            prepareCreate("test").setMapping(
            indexRequestBuilders[i] = client().prepareIndex("test")
                "This is a test thisisaverylongwordandmakessurethisfails where foo is highlighed " + "and should be highlighted"
        assertAcked(
            SearchResponse searchResponse = client().search(searchRequest("test").source(source)).actionGet();
            "tags",
            equalTo("This <em>sentence</em> contains three <em>sentence</em> occurrences (<em>sentence</em>).")
                1,
            .endObject()
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
            matchPhraseQuery("field1", "highlight words together")
        client().prepareIndex("test").setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog").get();
            prepareCreate("test").setMapping(
            highlighterType,
            .highlighter(new HighlightBuilder().field(new Field("text")))
                "This is the first test sentence. Here is the second one.",
        assertAcked(
            .get();
        ensureGreen();
        SearchResponse response = client().prepareSearch()
        indexRandomForConcurrentSearch("test");
    }
            .setQuery(matchQuery("title", "bug"))
            .get();
            .startObject("field1")
        indexRandom(true, indexRequestBuilders);
        refresh();
    public void testWithNestedQuery() throws Exception {
        SearchResponse response = client().prepareSearch("test")
        createIndex("test");
                        .endObject()
            2,
                .setSource("title", "This is a test on the highlighting bug present in opensearch");
        indexRandomForConcurrentSearch("test");
        assertHighlight(resp, 0, "foo", 0, equalTo("junk junk <em>cats</em> junk junk"));
                    .field(
            .startObject("properties")
            .setId("1")
        );
        );
        assertNoFailures(search);
            .get();
            .endObject()
        assertAcked(prepareCreate("test").setMapping("title", "type=text,store=true,term_vector=with_positions_offsets"));
            .setId("1")
                "type=text,index_options=offsets",
        for (String highlighter : ALL_TYPES) {
        assertHighlight(
    }
        assertHighlight(search, 0, "long_term", 0, 1, equalTo("<em>thisisaverylongwordandmakessurethisfails</em>"));
            .field("store", true)
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
            .field("index_options", "offsets")
                .highlighter(
        StringBuilder builder = new StringBuilder();
        barField.matchedFields("bar", "foo.plain");
                    .startObject("title")
        assertAcked(
                } else return false;
import static org.opensearch.index.query.QueryBuilders.commonTermsQuery;
            searchResponse,
            .get();
        assertThat(
            equalTo("This is the first <xxx>test</xxx> sentence. Here is the second one.")
        indexRandom(
        indexRandomForConcurrentSearch("test");
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("The <em>photography</em> word will get highlighted"));
        client().prepareIndex("test").setSource("field1", "The photography word will get highlighted").get();
            )
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
        client().prepareIndex("test").setSource("field1", "The photography word will get highlighted").get();
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
        indexRandomForConcurrentSearch("test");
            SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
                assertHighlight(searchHit, "field1", 1, 3, equalTo("The lazy red <field1>fox</field1> jumps over the quick dog."));
        SearchSourceBuilder source = searchSource().query(termQuery("field1", "fox"))
    }
 * compatible open source license.
        mappings.startObject();
    public void testACopyFieldWithNestedQuery() throws Exception {
            response,
        );
                    "this is a really long tag i would like to highlight",
                            .requireFieldMatch(false)
        // And all matched field via the queryString's field parameter, just in case
                        .preTags("<xxx>")
            .field("analyzer", "whitespace")
        field.highlighterType("fvh");
                .setSource("title", "This is a test for the enabling fast vector highlighter");
        indexRandomForConcurrentSearch("test");
                .setQuery(constantScoreQuery(matchQuery("text", "text")))
                        new Field("tags").highlighterType("plain").fragmentSize(-1).numOfFragments(2).fragmenter("invalid")
            .highlighter(new HighlightBuilder().field("no_long_term", 18, 1).highlighterType("fvh").postTags("</b>").preTags("<b>"))
        for (String highlighterType : new String[] { "unified", "plain" }) {
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("The quick <x>brown</x> fox jumps over the lazy dog! Second sentence."));
                    "The quick brown dog jumps over the lazy fox." }
        assertNoFailures(search);
        assertAcked(prepareCreate("test").setMapping("title", "type=text,store=true,term_vector=with_positions_offsets"));
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));
            QueryBuilders.boolQuery()
        ensureGreen();
        // unified hl returns the first sentence as the noMatchSize does not cross sentence boundary.
        HighlightBuilder.Field field = new HighlightBuilder.Field("text").fragmentSize(21)
            .highlighter(
            HighlightField field = searchResponse.getHits().getAt(0).getHighlightFields().get("foo.text");
        // When noMatchSize is between 0 and the size of the string
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
            .setQuery(matchQuery("title", "this is a test"))
                    .startObject()
            assertHighlight(
            .setId("1")
            .setId("0")
        phrase.boost(boost);
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;
            0,
    public void testPlainHighlighter() throws Exception {
    @Override
            prefixes.put(String.valueOf(i), prefix);
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so some"));
        phrase.boost(1);
        for (int i = 0; i < indexRequestBuilders.length; i++) {
            .get();
            .highlighter(new HighlightBuilder().encoder("html").field("title.key", 50, 1))
    }
            .setQuery(constantScoreQuery(matchQuery("name", "abc")))
            .highlighter(new HighlightBuilder().field("tags", -1, 0).highlighterType("fvh"))
            equalTo("<em>this</em> <em>is</em> <em>a</em> <em>test</em> . Second sentence.")
                "title",
                "field1",
        logger.info("--> searching explicitly on field1 and highlighting on it");
                    .field("term_vector", "no")
            .highlighter(new HighlightBuilder().encoder("html").field("title", 30, 1, 10).highlighterType("plain"))
        search = client().prepareSearch()
        SearchSourceBuilder source = searchSource().query(commonTermsQuery("field2", "quick brown").cutoffFrequency(100))
            .setId("1")
        assertAcked(prepareCreate("test").setMapping("tags", "type=text,term_vector=with_positions_offsets"));
import static org.opensearch.search.builder.SearchSourceBuilder.searchSource;
            assertHighlight(search, 0, "tags", 0, 2, equalTo("<em>foo bar</em>"));
        );
                    .field("type", "text")
        indexRandomForConcurrentSearch("test");
        SearchResponse largePhraseLimit = client().search(searchRequest("test").source(source)).actionGet();
                "type=text,term_vector=with_positions_offsets",
        QueryBuilder query = QueryBuilders.functionScoreQuery(
                search,
            .startObject("tags")
                "text",
                0,
                    .endObject()
                    .field("type", "text")
        }
        indexRandomForConcurrentSearch("test");
            indexRequestBuilders[i] = client().prepareIndex("test")
            indexRequestBuilders[i] = client().prepareIndex("test")
            .setQuery(matchQuery("title", "this is a test"))
                assertHighlight(searchHit, "field1", 2, 3, equalTo("The quick brown dog jumps over the lazy <field1>fox</field1>."));
                    "The quick brown fox jumps over the lazy dog. Second sentence not finished",
                    .startObject("key")
                .setId(Integer.toString(i))
        resp = req.setQuery(queryStringQuery("foo.plain:running foo.plain:scissors").field("foo")).get();
        for (int i = 0; i < indexRequestBuilders.length; i++) {
                    .field("store", true)
            .get();
                "title",
                .requireFieldMatch(randomBoolean());
            prepareCreate("test").setMapping(
            searchResponse,
import org.opensearch.core.rest.RestStatus;
        assertHighlight(search, 0, "title", 1, 2, equalTo("The <em>bug</em> is bugging us"));
    }
                    XContentFactory.jsonBuilder()
            assertHighlight(search, 0, "text", 0, equalTo("<em>text</em>"));
            "field1",
        field.highlighterType("plain");
                    .field("type", "text")
            .startObject("field2")
                        .startObject()
        ensureGreen();
package org.opensearch.search.fetch.subphase.highlight;
                    .endArray()
        searchResponse = client().search(searchRequest("test").source(source)).actionGet();
            .setSource(jsonBuilder().startObject().field("text", "brown").field("enable", "yes").endObject())
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
        indexRandomForConcurrentSearch("test");
                "tags",
                        .highlighterType(type)
     * Test phrase boosting over normal term matches.  Note that this will never pass with the plain highlighter
        resp = req.setQuery(queryStringQuery("running scissors").field("foo").field("foo.plain").field("bar").field("bar.plain"))
                anyOf(equalTo("A <xxx>sentence</xxx> with few words"), equalTo("A <xxx>sentence</xxx> with few words. "))
            .highlighter(new HighlightBuilder().field("attachments.body", -1, 2))
                    )
        assertAcked(prepareCreate("test").setMapping("title", "type=text,store=true,term_vector=with_positions_offsets,analyzer=classic"));
    ) {
    // see #3486
            1,
        assertAcked(
                );
            1,
            2,
        XContentBuilder mappings = jsonBuilder().startObject()
            .endObject();
 * this work for additional information regarding copyright
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
                        )
                .highlighter(new HighlightBuilder().field(new Field("foo.text").highlighterType(type)))
            1,
            highlighterType,
        // And noMatchSize returns nothing when the first entry is empty string!
            queryStringQuery("\"highlight words together\"").field("field1").field("field2")
        assertAcked(
                    .field("analyzer", "whitespace")
            .setSource(
            QueryBuilders.termQuery("enable", "yes"),
        String value = new String(new char[1024 * 256 / pattern.length()]).replace("\0", pattern);
                    .field("text", "brown cat")
        }
            .highlighter(new HighlightBuilder().field(fooField).field(barField))
        req = client().prepareSearch("test").highlighter(new HighlightBuilder().field(fooField));
        indexRandomForConcurrentSearch("test");
            .startObject("properties")
    public void testPostingsHighlighterEscapeHtml() throws Exception {
import static org.opensearch.index.query.QueryBuilders.matchPhrasePrefixQuery;
        assertAcked(
            .startObject()
            .setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog! Second sentence.")
        refresh();
                    .field("term_vector", "no")
        // If field is not stored, it is looked up in source (but source has only 'foo'
                .setId(Integer.toString(i))
                "title",
                        .field("title", "This is a test on the highlighting bug present in opensearch")
        b.startObject("foo");
        logger.info("--> searching on field2, highlighting on field2, falling back to the plain highlighter");
                };
        // We don't break if noMatchSize is less than zero though
            .highlighter(new HighlightBuilder().field(new Field("foo_text").highlighterType("fvh")).requireFieldMatch(false))
                jsonBuilder().startObject()
        assertAcked(prepareCreate("test").setMapping(mappings));
            .endObject()
import org.opensearch.search.sort.SortBuilders;
    }
        // check that we do not get an exception for geo_point fields in case someone tries to highlight
                        .endObject()
        refresh();
        assertHitCount(searchResponse, 1L);
    public void testEnsureNoNegativeOffsets() throws Exception {
        assertThat(field.getFragments()[0].string(), equalTo("how now <em>brown</em> cow"));
                "The quick brown fox jumps over the lazy dog. The lazy red fox jumps over the quick dog. "
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
                )
    }
        Map<String, HighlightField> highlightFieldMap = searchResponse.getHits().getAt(0).getHighlightFields();
        indexRandomForConcurrentSearch("test");
        assertAcked(prepareCreate("test").setMapping(mappings));
            )
        StringBuilder text = new StringBuilder();
            .field("enabled", false)
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
        index("test", "type1", "3", "text", new String[] {});
            } else {
            .get();
        public final class MockSnowBall extends TokenFilter {
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
                "title",
                    .field("term_vector", "with_positions_offsets")
            .highlighter(highlight().field("field1").order("score"));
            .get();
    public void testGlobalHighlightingSettingsOverriddenAtFieldLevel() throws InterruptedException {
    }
            SearchResponse response = search.get();
        );
            // generating text with word to highlight in a different position
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
        logger.info("--> highlighting and searching on field1");
            0,
    }
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
            response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
                    .field("index_options", "offsets")
        indexRandomForConcurrentSearch("test");
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
        for (int i = 0; i < 5; i++) {
        );
        assertAcked(prepareCreate("test").setSettings(builder.build()).setMapping("keyword", "type=keyword,normalizer=my_normalizer"));
        mappings.endObject();
        indexRandomForConcurrentSearch("test");
                    highlight().field("field1", 23, 1)
        index("test", "type1", "1", "foo", "running with scissors");
            .highlighter(
        );
            assertThat(field.getFragments().length, equalTo(1));
import org.opensearch.test.InternalSettingsPlugin;
            assertHighlight(response, 0, "text", 0, hlQueryMatcher);
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));
            );
                    .startObject("fields")
        );
            assertHighlight(search, i, "attachments.body", 1, 2, equalTo("<em>attachment</em> 2"));
                            termAtt.setLength(length - 3);
        assertHighlight(
import org.opensearch.common.geo.GeoPoint;
            assertHighlight(
                        .startObject("plain")
            )
            .field("type", "text")
        assertHighlight(response, 0, "tags", 0, equalTo("this is a really long <em>tag</em> i would like to highlight"));
                        .field("analyzer", "mock_english")
        SearchResponse search = client().prepareSearch()
        client().prepareIndex("test").setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog").get();
        logger.info("--> highlighting and searching on field2");
            .setQuery(QueryBuilders.matchPhraseQuery("tags", "long tag"))
        for (int i = 0; i < indexRequestBuilders.length; i++) {
        indexRandomForConcurrentSearch("test");
                    .field("analyzer", "whitespace")
    }
            .startObject("properties")
        );
                0,
        assertAcked(prepareCreate("test").setMapping("name", "type=text,term_vector=with_positions_offsets,store=" + randomBoolean()));
            Matcher<String> hlQueryMatcher = equalTo("Testing the highlight <em>query</em> feature");
        ensureGreen();
        mappings.endObject();
                    XContentFactory.jsonBuilder()
                    .endObject()
            .highlighter(highlight().field("field1").preTags("<xxx>").postTags("</xxx>"));
        client().prepareIndex("test")
                        .endObject()
            .highlighter(new HighlightBuilder().encoder("html").field("title", 50, 1))
                    XContentFactory.jsonBuilder()
            return singletonMap("mock_whitespace", (indexSettings, environment, name, settings) -> {
        assertThat(field.getFragments().length, equalTo(1));
                "field-plain",
            .highlighter(new HighlightBuilder().field(new Field("field1").preTags("<1>").postTags("</1>").requireFieldMatch(true)))
    }
        index(
            assertHighlight(
                .highlighter(new HighlightBuilder().field(new Field("*").highlighterType(type)))
                0,
            );
            SearchResponse search = client().prepareSearch()
        resp = req.setQuery(queryStringQuery("foo.plain:running scissors").field("foo")).get();
                    "This sentence contains one match, not that short. This sentence contains two sentence matches. "
 * SPDX-License-Identifier: Apache-2.0
        assertAcked(
            assertHighlight(search, i, "attachments.body", 0, equalTo("<em>attachment</em> 1"));
                "field-postings",
        );
            .setSource(
            String prefix = prefixes.get(hit.getId());
            )
        search = client().prepareSearch()
        assertHighlight(search, 0, "title", 0, 1, equalTo("this is a <em>test</em>"));
                    .field("store", true)
        assertHighlight(response, 0, "text", 0, 1, equalTo("This is the first sentence"));
                0,
        ensureGreen();
            "field2",
                .should(constantScoreQuery(queryStringQuery("field1:photo*")))
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
        String mapping = jsonBuilder().startObject()
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
            "field2",
            0,
            .field("term_vector", "with_positions_offsets")
                "title",
            .get();
                2,
    }
            .highlighter(new HighlightBuilder().field("title", 50, 1, 10))
                2,
                        .field("analyzer", "mock_english")
            .highlighter(new HighlightBuilder().field(new Field("text")))
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("The <em>quick</em> brown fox jumps over"));
            )
            )
        assertHighlight(searchResponse, 0, "title", 0, 1, equalTo("this is a <em>test</em>"));
                .setQuery(matchQuery("foo", "test"))
            .highlighter(highlight().forceSource(true).field("field1"));
        SearchRequestBuilder search = client().prepareSearch("test")
            boostingQuery(termQuery("field2", "brown"), termQuery("field2", "foobar")).negativeBoost(0.5f)
        assertNotHighlighted(response, 0, "text");
                super(in);
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("The <em>photography</em> word will get highlighted"));
        SearchSourceBuilder source = searchSource().query(termQuery("field1", "sentence"))
                    .field("type", "text")
            .endObject();
        for (int i = 0; i < 5; i++) {
            .get();
import static org.opensearch.index.query.QueryBuilders.matchPhraseQuery;
            SearchSourceBuilder source = searchSource().query(termQuery("field1", "sentence"))
        logger.info("--> highlighting and searching on field2");
                    .field("store", false)
                        .startObject("foo")
            .setSource(jsonBuilder().startObject().array("tags", "foo bar", "foo bar", "foo bar", "foo baz").field("sort", 1).endObject())
                "type=text," + randomStoreField() + "term_vector=with_positions_offsets,index_options=offsets"
                "short",
        SearchResponse search = client().prepareSearch()
        /*
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
        // lets fall back to the standard highlighter then, what people would do to highlight query matches
                "field1",
import org.opensearch.common.settings.Settings.Builder;
                .setQuery(QueryBuilders.matchPhraseQuery("tags", "long tag"))
            .setId("1")
    }
            )
                        .field("analyzer", "standard")
            .field("type", "text")
        }
                    }
            .field("type", "keyword")
            .setQuery(termQuery("field1", "test"))
        refresh();
                        .endObject()
            .field("store", true)
                .highlighter(new HighlightBuilder().field("foo").highlighterType(highlighter).requireFieldMatch(false))
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("The <em>quick</em> brown fox jumps over"));
        settings.put("index.analysis.analyzer.mock_english.filter", "mock_snowball");
            .field("type", "text")
                        if (buffer[length - 1] == 'g' && buffer[length - 2] == 'n' && buffer[length - 3] == 'i') {
        assertHitCount(searchResponse, 1);
        // simple search on body with standard analyzer with a simple field query
            RestStatus.BAD_REQUEST,
        barField.matchedFields("bar", "candy");
            .field("term_vector", "with_positions_offsets")
            field.highlighterType(type).highlightQuery(null);
        assertHitCount(searchResponse, 1);
        indexRandom(true, indexRequestBuilders);
            "field2",
        }
        client().prepareIndex("test").setSource("field1", "The photography word will get highlighted").get();
        assertFailures(
            .setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog! Second sentence.")
        source = searchSource().query(termQuery("field1", "t"))
import static org.opensearch.index.query.QueryBuilders.fuzzyQuery;
                .setQuery(
        field.highlighterType("fvh");
            )
        assertHighlight(
            "cat cat junk junk junk junk junk junk junk cats junk junk"
                        .field("body", "attachment 2")
            .setSource(
                .get();
        assertHighlight(search, 0, "titleTV", 0, equalTo("This is a test on the highlighting <em>bug</em> present in opensearch"));
                new HighlightBuilder().field(new HighlightBuilder.Field("title").highlighterType("plain")).highlighterType("plain")
            .get();
        indexRandomForConcurrentSearch("test");
                        .startObject("plain")
        mappings.endObject();
        assertHighlight(search, 0, "titleTV", 0, equalTo("some text to <em>highlight</em>"));
        createIndex("test");
    public void testCopyToFields() throws Exception {
        );
        assertHighlight(searchResponse, 0, "field-plain", 0, 1, equalTo("This is the <xxx>test</xxx> for the plain highlighter"));
                    .endObject()
        assertThat(
            .endObject()
            )
            .highlighter(highlight().forceSource(true).field("field*"));
                anyOf(
        }
            .startObject()
                        .startObject()
            boolQuery().must(queryStringQuery("field1:photo*")).mustNot(existsQuery("field_null"))
        assertThat(highlightFieldMap.size(), equalTo(1));
    }
        HighlightField field = searchResponse.getHits().getAt(0).getHighlightFields().get("text");
        }
                    .startObject("key")
        source = searchSource().query(matchPhraseQuery("field2", "quick brown"))
                        .postTags("</xxx>")
            assertHighlight(response, 0, "text", 0, searchQueryMatcher);
            assertHighlight(search, i, "attachments.body", 1, equalTo("<em>attachment</em> 2"));
        Field fooField = new Field("foo").numOfFragments(1)
        refresh();
            searchResponse,
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
        assertHighlight(search, 0, "title.key", 0, 1, equalTo("<em>this</em> <em>is</em> <em>a</em> <em>test</em>"));
        refresh();
            )
        client().prepareIndex("test")
            .get();
        searchResponse = client().prepareSearch()
        refresh();
        for (int i = 0; i < 5; i++) {
            100f,
                        .endObject()
                .setId(Integer.toString(i))
        }
            .field("store", false)
                .setQuery(nestedQuery("foo", prefixQuery("foo.text", "bro"), ScoreMode.None))
                    .field("term_vector", "no")
            final SearchResponse r1 = client().prepareSearch("index-1")
            .or(containsString("<em>highlight</em> <em>words</em> <em>together</em>"));
            prepareCreate("test").setMapping(
            .setQuery(matchPhraseQuery("title", "test for the workaround"))
                    .field("type", "text")
        indexRandom(true, indexRequestBuilders);
                    + "The quick brown dog jumps over the lazy fox."
        client().prepareIndex("test").setId("1").setSource(jsonBuilder().startObject().field("text", "text").endObject()).get();
                    .postTags("</xxx>")
                );
    public void testFieldAliasWithSourceLookup() throws IOException, InterruptedException {
            .field("term_vector", "with_positions_offsets")
        refresh();
        assertHighlight(
            .setSource(
        fooField = new Field("foo").numOfFragments(1)
            .field("path", "text")
            .endObject()
    public void testMissingStoredField() throws Exception {
        SearchResponse searchResponse = client().search(searchRequest("test").source(source)).actionGet();
        // search on title.key and highlight on title.key
        QueryBuilder terms,
        logger.info("--> highlighting and searching on field1");
                    .startObject("properties")
        assertAcked(prepareCreate("test").setMapping(mappings));
            .endObject();
        client().prepareIndex("test")
            prepareCreate("test").setMapping(
 * Modifications Copyright OpenSearch Contributors. See
        }
    }
        HighlightBuilder.Field field = new HighlightBuilder.Field("text").fragmentSize(1)
            .setQuery(termQuery("field1", "test"))
            .setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog! Second sentence.")
        assertThat(field.getFragments()[1].string(), equalTo("<em>cow</em>"));
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
        );
import static org.opensearch.index.query.QueryBuilders.boostingQuery;
            .requireFieldMatch(requireFieldMatch);
            equalTo("The <em>quick</em> brown fox jumps over the lazy dog! Second sentence.")
            .endObject()
        assertHighlight(search, 0, "title.key", 0, 1, equalTo("<em>this</em> <em>is</em> <em>a</em> <em>test</em>"));
                    .field("index_options", "offsets")
            SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        resp = req.setQuery(queryStringQuery("foo.plain:running scissors").field("foo")).get();
                    .endObject()
            .field("type", "text")
                    .endObject()
            .endObject()
            String prefix = randomAlphaOfLengthBetween(5, 30);
        client().prepareIndex("test")
        logger.info("--> searching on field1, highlighting on field1");
                    .field("term_vector", "with_positions_offsets")
        indexRandomForConcurrentSearch("test");
                    .field("analyzer", "classic")
            field1.fragments()[1].string(),
            .setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog! Second sentence.")
        indexRandomForConcurrentSearch("test");
                equalTo("This is a test on the highlighting <em>bug</em> present in opensearch. Hopefully it works.")
                "byte",
        indexRandom(true, indexRequestBuilders);
    }
                        .field("term_vector", "with_positions_offsets")
            .get();
            .setQuery(QueryBuilders.matchQuery("text", "test"))
            .toString();
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));
/*
        client().prepareIndex("test").setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog").get();
        SearchSourceBuilder source = searchSource().query(commonTermsQuery("field2", "quick brown").cutoffFrequency(100))
            .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            );
        SearchSourceBuilder source = searchSource().query(
            field = searchResponse.getHits().getAt(0).getHighlightFields().get("foo.text");
                "title",
        @Override
            indexRequestBuilders[i] = client().prepareIndex("test")
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();
                    .field("analyzer", "whitespace")
            containsString(
        // You _can_ highlight fields that aren't subfields of one another.
            )
        searchResponse = client().prepareSearch("test").setSource(source).get();
        for (int i = 0; i < indexRequestBuilders.length; i++) {
        logger.info("--> highlighting and searching on field2");
import org.opensearch.action.search.SearchRequestBuilder;
            // sentences will be generated out of each value
    }
            )
import org.opensearch.plugins.AnalysisPlugin;
        logger.info("--> highlighting and searching on field*");
                    .endObject()
            }
import static org.hamcrest.Matchers.anyOf;
            searchResponse,
    public void testHighlightingOnWildcardFields() throws Exception {
            assertHighlight(
                0,
            searchResponse,
            highlighterType,
            );
                    .field("term_vector", "no")
        field.highlighterType("unified");
                "field2",
            "test",
                        .field(new Field("field1").requireFieldMatch(true).preTags("<field1>").postTags("</field1>"))
                        .endObject()
        ).highlighter(highlight().field("field1"));
        indexRandomForConcurrentSearch("test");
        field.highlighterType("unified");
                        .startObject()
            )
            .get();
            public boolean incrementToken() throws IOException {
            "test",
            .fragmentSize(25)
            )
        search = client().prepareSearch()
        search = client().prepareSearch()
                        .highlighterType(type)
        resp = req.setQuery(queryStringQuery("weird").field("foo").field("foo.plain").field("bar").field("bar.plain"))
            .field("path", "text")
                    QueryBuilders.boolQuery()
        ensureGreen();
            .highlighter(new HighlightBuilder().field("title"))
            .startObject("properties")
    public void testBoostingQuery() throws InterruptedException {
                "text",
            .highlighter(new HighlightBuilder().field("title", -1, 0))
                "field1",
        client().prepareIndex("test")
        SearchSourceBuilder source = searchSource().query(queryStringQuery("qui*").defaultField("field2"))
        // Add the subfield to the list of matched fields but don't match it. Everything should still work
        assertHighlight(resp, 0, "foo", 0, equalTo("junk junk <em>cats</em> junk junk"));
        for (BoundaryScannerType scanner : BoundaryScannerType.values()) {
                    3,
        indexRandomForConcurrentSearch("test");
            } else if ("2".equals(searchHit.getId())) {
        // Match queries
            response,
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
                "field1",
        assertHighlight(resp, 0, "bar", 0, equalTo("junk junk <em>cats</em> junk junk"));
                    .endObject()
                        .startObject("properties")
            .field("term_vector", "with_positions_offsets")
        source = searchSource().query(termQuery("field1", "test"))
// Higher timeout to accommodate large number of tests in this class. See https://github.com/opensearch-project/OpenSearch/issues/12119
         * neighborhood of 8 seconds.
            .setSource(
                .setQuery(nestedQuery("foo", matchPhrasePrefixQuery("foo.text", "bro"), ScoreMode.None))
                assertHighlight(
            .field("term_vector", "with_positions_offsets_payloads")
        fooField.matchedFields("foo", "foo.plain");
                "This is the test with term_vectors",
            .setQuery(new FunctionScoreQueryBuilder(QueryBuilders.prefixQuery("text", "bro")))
        for (int i = 0; i < 10; i++) {
        SearchResponse search = client().prepareSearch()
        SearchResponse search = client().prepareSearch()
            .endObject();
            ).setMapping("text", "type=text,analyzer=my_analyzer")
            .endObject()
            .query(termQuery("field-postings", "test"))
            .endObject()
            searchResponse,
            .field("analyzer", "keyword")
            equalTo("The <xxx>quick</xxx> <xxx>brown</xxx> fox jumps over the lazy quick dog")
            SearchResponse searchResponse = client().prepareSearch()
            .endObject();
        );
                .setQuery(matchPhraseQuery("title", "this is a test"))
        for (int i = 0; i < 5; i++) {
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();
            containsString("source is forced for fields [field1] but _source is disabled")
    public void testFieldAlias() throws IOException, InterruptedException {
            .get();
                .highlighter(new HighlightBuilder().field(new Field("text").highlighterType(type).requireFieldMatch(false)))
            .startObject("jd")
                jsonBuilder().startObject()
            .field("term_vector", "with_positions_offsets")
                0,
        );
                .highlighter(new HighlightBuilder().field(new Field("*").highlighterType(highlighterType).requireFieldMatch(false)))
            .setQuery(matchPhraseQuery("title", "test for the workaround"))
        ).highlighter(highlight().field("field2").order("score").preTags("<x>").postTags("</x>"));
                            + "The quick brown dog jumps over the lazy <field1>fox</field1>."
    public void testSourceLookupHighlightingUsingPostingsHighlighter() throws Exception {
        );
            .highlighter(highlight().field("field2"));
        indexRandomForConcurrentSearch("test");
        assertThat(search.getHits().getTotalHits().value(), equalTo(1L));
            .startObject()
            equalTo("The <em>quick</em> brown fox jumps over the lazy dog! Second sentence.")
            .setQuery(QueryBuilders.matchQuery("field1", "fox"))
                .setQuery(matchQuery("keyword", "hello world"))
            text.append("junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk junk\n");
                    .endObject()
            SearchResponse searchResponse = client().prepareSearch()
        ).highlighter(highlight().field("field2").preTags("<x>").postTags("</x>"));
                    .endObject()
        assertHighlight(searchResponse, 0, "field1", 1, 2, equalTo("The quick brown dog jumps over the lazy <field1>fox</field1>."));
    public void testCommonTermsQuery() throws InterruptedException {
                .get();
        assertNotHighlighted(response, 0, "text");
        assertNotHighlighted(response, 0, "text");
        assertAcked(
        client().prepareIndex("test")
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
                    .startArray("foo")
            search.getHits().getAt(0).getHighlightFields().get("keyword_field").getFragments()[0].string(),
import org.opensearch.search.SearchHit;
            .get();
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
            searchResponse,
        field.highlighterType("unified");
            client().prepareIndex("test").setSource("field1", "A sentence with few words. Another sentence with even more words.")
                    equalTo("<field1>The quick brown fox</field1> jumps over"),
                    final char[] buffer = termAtt.buffer();
        resp = req.setQuery(queryStringQuery("run foo.plain:running^5 scissors").field("foo")).get();
        client().prepareIndex("test").setId("1").setSource("title", "this is a test").get();
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
                    .startObject("properties")
            .get();
            .get();
        SearchSourceBuilder source = searchSource().query(commonTermsQuery("field2", "quick brown").cutoffFrequency(100))
    // TODO as we move analyzers out of the core we need to move some of these into HighlighterWithAnalyzersTests
            "type1",
                    XContentFactory.jsonBuilder()
            .field("type", "text")
        return Arrays.asList(
                    .endObject()
    // Issue #3200
            queryStringQuery("highlight words together").field("field1"),
        // Now just all matches are against the matched field. This still returns highlighting.
            "2",
                    .startObject("key")
        );
        indexRandomForConcurrentSearch("test");
        mappings.endObject();
 *
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
            .get();
        createIndex("test");
        field.highlighterType("fvh");
import org.hamcrest.Matcher;
        }
            equalTo("The <xxx>quick</xxx> brown fox jumps over the lazy <xxx>quick</xxx> dog")
        indexRandomForConcurrentSearch("test");
        for (int i = 0; i < indexRequestBuilders.length; i++) {
                    .endObject()
                new String[] {
            .endObject()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        client().prepareIndex("test")
        client().prepareIndex("test")
                "field1",
        }
                equalTo("This is a <em>test</em> for the <em>workaround</em> for the fast vector highlighting SOLR-3724")
        client().prepareIndex("test").setId("1").setSource("title", "this is a test").get();
        refresh();
        indexRandom(true, indexRequestBuilders);
            .setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog! Second sentence.")
        SearchResponse searchResponse = searchRequestBuilder.get();
                    .highlighter(new HighlightBuilder().field("*"))
                    QueryBuilders.geoBoundingBoxQuery("loc")
            .get();
 * license agreements. See the NOTICE file distributed with
        indexRandomForConcurrentSearch("test");
            .field("term_vector", "with_positions_offsets")
import java.time.ZonedDateTime;
            .get();
        ensureGreen();
        Builder builder = Settings.builder().put(indexSettings()).putList("index.analysis.normalizer.my_normalizer.filter", "lowercase");
            .highlighter(new HighlightBuilder().field("no_long_term", 30, 1).highlighterType("fvh").postTags("</b>").preTags("<b>"))
        refresh();
            equalTo("<em>some text</em>")
                "type=text," + randomStoreField() + "term_vector=with_positions_offsets,index_options=offsets"
        ensureGreen();
        SearchResponse response = client().prepareSearch("test")
        assertHighlight(search, 0, "titleTV", 1, 2, equalTo("The <em>bug</em> is bugging us"));
        logger.info("--> searching with boundary characters on the field");
            .field("term_vector", "with_positions_offsets")
            .highlighter(new HighlightBuilder().encoder("html").field("title.key", 50, 1))
    }
        resp = req.setQuery(queryStringQuery("foo.plain:running^5 scissors").field("foo")).get();
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilder.BoundaryScannerType;
        logger.info("--> highlighting and searching on field2");
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
            .requireFieldMatch(requireFieldMatch);
        field.highlighterType("unified");
            .field("term_vector", "with_positions_offsets")
                        .field("analyzer", "mock_english")
        indexRandomForConcurrentSearch("test");
                    // we don't store title and don't use term vector, now lets see if it works...
            .endObject()
        assertAcked(
        phraseBoostTestCaseForClauses(
        );
        search = client().prepareSearch()
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
        assertHighlight(largePhraseLimit, 0, "field1", 0, 1, containsString("<xxx>t</xxx>"));
                .get();
    }
            )
            SearchResponse searchResponse = client().prepareSearch()
                new HighlightBuilder().field(new HighlightBuilder.Field("field1").preTags("<1>").postTags("</1>").requireFieldMatch(true))
    public void testHighlightNoMatchSizeWithMultivaluedFields() throws IOException, InterruptedException {
                "field-plain",
    private void phraseBoostTestCase(String highlighterType) throws InterruptedException {
            1,
        assertHighlight(search, 0, "no_long_term", 0, 1, equalTo("a <b>test</b> where <b>foo</b> is <b>highlighed</b> and"));
        assertHighlight(
        indexRandomForConcurrentSearch("test");
        // (this behavior is consistent with version 0.20)
        indexRandom(true, indexRequestBuilders);
            "tags",
            100f,
            });
        ensureGreen();
            RestStatus.BAD_REQUEST,
        search = client().prepareSearch()
            .should(QueryBuilders.termQuery("text", "failure"));
        ensureGreen();
        );
            0,
            true,
            .setId("1")
    public static class MockAnalysisPlugin extends Plugin implements AnalysisPlugin {
            .setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy quick dog")
            indexRequestBuilders[i] = client().prepareIndex("test")
            .get();
    public void testPostingsHighlighterManyDocs() throws Exception {
        indexRandomForConcurrentSearch("test");
            1,
        assertAcked(
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
import org.apache.lucene.analysis.TokenStream;
            .field("path", "keyword")
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field).noMatchSize(21)).get();
 *
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
                    .field("type", "text")
                searchResponse,
            0,
        assertHitCount(searchResponse, 2L);
        for (String type : new String[] { "unified", "fvh" }) {
                        "The quick brown <field1>fox</field1> jumps over the lazy dog. "
    /**
        for (int i = 0; i < 5; i++) {
import org.opensearch.index.query.functionscore.RandomScoreFunctionBuilder;
        for (String type : ALL_TYPES) {
                    .endObject()
                        + "This one contains no matches.",
            prepareCreate("test").setMapping(
                    .endObject()
    }
            return "store=true,";
    public void testPostingsHighlighterMultiMapperFromSource() throws Exception {
    public void testHighlightUsesHighlightQuery() throws IOException, InterruptedException {
            highlighterType,
            1,
        assertThat(
        for (int i = 0; i < indexRequestBuilders.length; i++) {
import static org.opensearch.index.query.QueryBuilders.nestedQuery;
        resp = req.setQuery(twoFieldsQuery).highlighter(new HighlightBuilder().field(fooField).field(barField)).get();
                    .endObject()
    }
                        .endObject()
                        .array(
    }
        String[] titles = new String[] { "This is a test on the highlighting bug present in opensearch", "The bug is bugging us" };
                        .boundaryScannerType(BoundaryScannerType.WORD)
            .endObject()
            prepareCreate("test").setMapping(
            highlightBuilder.highlightQuery(matchQuery("text", "query"));
            .startObject("properties")
        IdsQueryBuilder idsQueryBuilder = QueryBuilders.idsQuery().addIds("2");
            assertSearchResponse(r1);
            .field("type", "geo_point")
                .setId(Integer.toString(i))
        // We can also ask for a fragment exactly the size of the input field and get the whole field
                            .postTags("</field2>")
import org.opensearch.action.index.IndexRequestBuilder;
            assertHighlight(
        assertAcked(prepareCreate("test").setMapping("title", "type=text," + randomStoreField() + "index_options=offsets"));
        assertHighlight(response, 0, "text", 0, 1, equalTo("This is the first sentence"));
                        .field("term_vector", "with_positions_offsets")
            .startObject()
            )
                0,
                    MockAnalyzer instance = new MockAnalyzer(random(), MockTokenizer.WHITESPACE, false);
            .endObject()
            );
                searchResponse,
        ensureGreen();
        for (int i = 0; i < 5; i++) {
            .endObject()
            .highlighter(highlight().field("field1").preTags("<xxx>").postTags("</xxx>"));
            .highlighter(highlight().field("field2").preTags("<x>").postTags("</x>"));
                );
                "field1",
            .endObject();
            .highlighter(new HighlightBuilder().field("title", -1, 2).field("titleTV", -1, 2).requireFieldMatch(false))
        SearchResponse response = client().prepareSearch("test")
        assertHighlight(resp, 0, "foo", 0, equalTo("junk junk <em>cats</em> junk junk"));
        ensureGreen();
        ).highlighter(highlight().field("field1"));
        assertHighlight(response, 0, "tags", 0, equalTo("this is a really <em>long</em> <em>tag</em> i would like to highlight"));
import org.hamcrest.Matchers;
        public Map<String, AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
            .get();
                    .endObject()
                    .endObject()
            .order("score")
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
                "field1",
            true,
            1,
        indexRandomForConcurrentSearch("test");
        }
        refresh();
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
            .get();
            0,
        settings.put(indexSettings());
                anyOf(equalTo("A <xxx>sentence</xxx> with few words"), equalTo("A <xxx>sentence</xxx> with few words. "))
        // see https://github.com/elastic/elasticsearch/issues/17537#issuecomment-244939633
        assertThat(resp.getHits().getAt(0).getHighlightFields(), not(hasKey("bar")));
        XContentBuilder mappings = jsonBuilder();
        indexRandomForConcurrentSearch("test");
        field.highlighterType("plain").noMatchSize(0);
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so"));
        // except for the unified highlighter which starts from the first string with actual content
            assertHighlight(search, i, "title", 0, 1, startsWith("This is a html escaping highlighting <em>test</em> for *&amp;?"));
        ensureGreen();
    }
        refresh();
                );
            0,
        assertHighlight(response, 0, "text", 0, 1, equalTo(text));
            .highlighter(new HighlightBuilder().field(fooField).field(barField))
            0,
            "The <b>quick<b> brown fox. Second sentence.",
            assertHighlight(search, 0, "alias", 0, equalTo("foo <em>bar</em>"));
        // it accidentially with a wildcard
        checkFvhMatchedFieldsCase(false);
        );
        mappings.endObject();
                1,
        );
        Settings.Builder settings = Settings.builder();
import org.opensearch.index.analysis.PreConfiguredTokenFilter;
import java.util.Collection;
                    .field(new HighlightBuilder.Field("field2").preTags("<2>").postTags("</2>").requireFieldMatch(false))
            /** Sole constructor. */
        indexRandomForConcurrentSearch("test");
    public void testKeywordFieldHighlighting() throws IOException, InterruptedException {
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
    }
        response = client().prepareSearch("test").setQuery(queryBuilder).highlighter(new HighlightBuilder().field(field)).get();
            );
            assertThat(field.getFragments()[0].string(), equalTo("<em>hello world</em>"));
                "field-postings",
import static org.hamcrest.Matchers.not;
            .get();
        assertAcked(prepareCreate("test").setMapping(mappings));
            .field("type", "alias")
            )
                    .endObject()
            response,
                        .endObject()
    public void testFVHManyMatches() throws Exception {
                        .field("analyzer", "standard")
        String text1 = "This is the first sentence. This is the second sentence." + HighlightUtils.PARAGRAPH_SEPARATOR;
 */
                1,
import java.util.HashMap;
            1,
            .get();
            .highlighterType("fvh")
        assertAcked(
            .setQuery(QueryBuilders.matchQuery("field1", "fox"))
                        .endObject()
    }
                        .startObject()
            .get();
    }
                        .endObject()
                        .endObject()
    private static XContentBuilder type1PostingsffsetsMapping() throws IOException {
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
        ensureYellow();
        // And that matching a subfield doesn't automatically highlight it
        );
                        .field("type", "text")
        // For unified and fvh highlighters we just check that the nested query is correctly extracted
        mappings.startObject();
        ensureGreen();
                    0,
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("this is a <xxx>test</xxx>"));
import org.opensearch.index.query.AbstractQueryBuilder;
            )
        fooField.matchedFields("bar.plain");
            assertHighlight(
            .setQuery(matchQuery("title.key", "this is a test"))
        assertAcked(
        HighlightField field = response.getHits().getAt(0).getHighlightFields().get("foo_copy");
        // Index one megabyte of "t " over and over and over again
                    .field("term_vector", "no")
                        .endObject()
        logger.info("--> highlighting and searching on field1");
        logger.info("--> highlighting and searching on field1 with large phrase limit");
        settings.put("index.analysis.analyzer.mock_english.filter", "mock_snowball");
        SearchResponse searchResponse = client().prepareSearch()
            .get();
        logger.info("--> highlighting and searching on field1");
        phraseBoostTestCaseForClauses(
        logger.info("--> indexing docs");
        // Now remove the stored field from the matched field list. That should work too.
            .setQuery(QueryBuilders.matchPhraseQuery("tags", "long tag"))
        String text3 = "This is the fifth sentence";
            .endObject()
            client().prepareSearch("test")
                "type=text," + randomStoreField() + "term_vector=with_positions_offsets,index_options=offsets"
            .setQuery(matchQuery("title", "test"))
        indexRandomForConcurrentSearch("test");
        assertHighlight(response, 0, "field1", 0, 1, equalTo("The <b>quick<b> brown <1>fox</1>. Second sentence."));
                    .startObject("properties")
        logger.info("--> highlighting and searching on field1");
        for (int i = 0; i < 5; i++) {
                .setMapping("d", "type=date", "field", "type=text,store=true,term_vector=with_positions_offsets")
            0,
        indexRandomForConcurrentSearch("test");
            .get();
        );
            .field("type", "text")
        resp = req.setQuery(queryStringQuery("cats foo.plain:cats^5").field("foo")).get();
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
            SearchResponse search = client().prepareSearch()
            )
            // LUCENE 3.1 UPGRADE: Caused adding the space at the end...
                jsonBuilder().startObject()
            .get();
            .setQuery(matchQuery("title", "test"))
            .field("type", "alias")
        indexRandomForConcurrentSearch("test");
        assertAcked(
                    return true;
            searchResponse,
            .order("score")
                .setId(Integer.toString(i))
        indexRandomForConcurrentSearch("test");
                        .field("store", true)
        }
        }
        refresh();
            )
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("The <x>quick</x> <x>brown</x> fox jumps over the lazy dog"));
import org.opensearch.search.builder.SearchSourceBuilder;
                    .endObject()
        refresh();
            .endObject()
        }
            .get();
        // simple search on body with standard analyzer with a simple field query
            assertHighlight(search, i, "title", 1, 2, equalTo("This is the second <em>bug</em> to perform highlighting on."));
                    .endObject()
        indexRandom(true, client().prepareIndex("test").setSource("foo", "test typename"));
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so"));
        indexRandomForConcurrentSearch("test");
            .endObject()
        b.endObject().endObject();
            .should(
                    highlight().highlightQuery(randomBoolean() ? multiMatchQueryBuilder : null)
import org.apache.lucene.tests.analysis.MockTokenizer;
        settings.put("index.analysis.analyzer.mock_english.tokenizer", "standard");
            .endObject()
            .endObject()
            queryStringQuery("highlight words together").field("field1"),
    }
        refresh();
            equalTo("The <xxx>quick</xxx> <xxx>brown</xxx> fox jumps over the lazy quick dog")
            indexRequestBuilders[i] = client().prepareIndex("test")
    }
        }
        return "";
                )
            client().prepareIndex("test").setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog")
            .setQuery(matchQuery("attachments.body", "attachment"))
        return Arrays.asList(InternalSettingsPlugin.class, MockKeywordPlugin.class, MockAnalysisPlugin.class);
        indexRandomForConcurrentSearch("test");
                    .field("type", "text")
            )
        // The no match fragment should come from the first value of a multi-valued field
                        .highlighterType(type)
    public static Collection<Object[]> parameters() {
            .startObject("sort")
            .highlighterType("fvh")
import org.opensearch.index.query.QueryBuilders;
        assertThat(field.getFragments().length, equalTo(1));
        resp = req.setQuery(queryStringQuery("running scissors").field("foo")).get();
        ensureGreen();
                    .field("loc", "12.934059,77.610741")
                .setId(Integer.toString(i))
    }
        assertHighlight(hit, "title", 0, 1, equalTo("this is a <em>test</em> . Second sentence."));
    }
    }
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
            .highlighterType("fvh")
            0,
        logger.info("--> highlighting and searching on field1");
        ensureGreen();
                .setQuery(constantScoreQuery(matchQuery("text", "text")))
                        .postTags("</xxx>")
            .setSource("field1", "The quick brown fox jumps over the lazy dog", "field2", "second field content")
            100f,
        }
            SearchSourceBuilder source = searchSource().query(multiMatchQueryBuilder)
        fooField = new Field("foo").numOfFragments(1)
public class HighlighterSearchIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        indexRandomForConcurrentSearch("test");
        client().prepareIndex("test")
        client().prepareIndex("test")
        logger.info("--> highlighting and searching on field1");
        assertAcked(prepareCreate("test").setMapping("tags", "type=text"));
    public void testFunctionScoreQueryHighlight() throws Exception {
            .get();
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("The quick <x>brown</x> fox jumps over the lazy dog"));
        searchResponse = client().prepareSearch("test").setSource(source).get();
            .numOfFragments(1)
            .requireFieldMatch(requireFieldMatch);
        for (int i = 0; i < indexRequestBuilders.length; i++) {
        SearchResponse searchResponse = client().prepareSearch()
            );
        assertHighlight(search, 0, "titleTV", 1, 2, equalTo("<em>highlight</em> other text"));
        SearchSourceBuilder source = searchSource().query(termQuery("field1", "test"))
                    .endObject()
                    .endObject()
            builder.append("abc").append(" ");
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
                    .endObject()
        ensureGreen();
        assertHighlight(search, 0, "title", 0, equalTo("This is a test on the highlighting <em>bug</em> present in opensearch"));
    public void testHighlightingWithWildcardName() throws IOException, InterruptedException {
    }
            client().prepareIndex("index-1").setId("1").setSource("d", formatter.format(now), "field", "hello world"),
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHighlight;
        indexRandom(true, indexRequestBuilders);
        SearchRequestBuilder searchRequestBuilder = client().prepareSearch()
        field.highlighterType("fvh");
            logger.info("--> highlighting and searching on 'field' with sentence boundary_scanner");
        QueryBuilder query = QueryBuilders.boolQuery()
            .highlighter(new HighlightBuilder().encoder("html").field("title", 50, 1))
                    searchHit,
            1f,
    public void testMultiMapperNoVectorWithStore() throws Exception {
            .highlighter(highlight().field(new Field("field1").numOfFragments(0).preTags("<field1>").postTags("</field1>")));
            .get();
            assertHitCount(searchResponse, 1);
        field.highlighterType("plain").noMatchSize(null);
            .get();
    }
            assertThat(search.getHits().getAt(0).getHighlightFields().size(), equalTo(0));
            .startObject("foo")
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("The <em>photography</em> word will get highlighted"));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        ensureGreen();
    public void testPostingsHighlighterShouldFailIfNoOffsets() throws Exception {
        assertHighlight(
                .get();
                .addSort(SortBuilders.fieldSort("sort"))
                        .boundaryScannerType(BoundaryScannerType.SENTENCE)
        // Now make half the matches come from the stored field and half from just a matched field.
                    .field("type", "text")
            .field("type", "keyword")
        XContentBuilder mappings = jsonBuilder().startObject()
        );
                "text",
                    final int length = termAtt.length();
    private <P extends AbstractQueryBuilder<P>> void phraseBoostTestCaseForClauses(
                .highlighter(
        XContentBuilder mapping = XContentFactory.jsonBuilder()
                        .boundaryScannerLocale(Locale.ENGLISH.toLanguageTag())
        ensureGreen();
            .get();
                    .endObject()
import static org.opensearch.transport.client.Requests.searchRequest;
        XContentBuilder mappings = jsonBuilder();
        field.highlighterType("unified");
            .setQuery(matchQuery("title", "bug"))
                "type=text," + randomStoreField() + "term_vector=with_positions_offsets,index_options=offsets"
            SearchSourceBuilder source = searchSource().query(termQuery("field1", "some"))
 * GitHub history for details.
        ensureGreen();
                .setQuery(matchQuery("tags", "foo bar"))
            )
            .get();
                    .endObject()
            .highlighter(new HighlightBuilder().field("title").encoder("html"))
        assertHighlight(response, 0, "field1", 0, 1, highlightedMatcher);
            .highlighter(highlight().field(new Field("field2").fragmentSize(30).numOfFragments(1).boundaryChars(new char[] { ' ' })));
            assertHighlight(search, 0, "alias", 0, equalTo("<em>foo</em>"));
            assertHighlight(response, 0, "text", 0, 1, equalTo(text));
        ensureGreen();
        assertAcked(
                        .endObject()
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));
    public void testPlainHighlightDifferentFragmenter() throws Exception {
    public void testPlainHighlighterMultipleFields() throws InterruptedException {
        refresh();
            assertHitCount(searchResponse, 1);
        searchResponse = client().prepareSearch()
        // stopwords are not highlighted since not indexed
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("yet another <field2>test</field2>"));
            .fragmentSize(25)
            .highlighter(new HighlightBuilder().encoder("html").field("title", 50, 1, 10))
        );
                    + "The quick brown dog jumps over the lazy fox.",
                    .order("score")
            .setQuery(QueryBuilders.matchQuery("field", "highlight"))
            SearchResponse searchResponse = client().prepareSearch()
                "type=text",
        SearchResponse searchResponse = client().search(searchRequest("test").source(source)).actionGet();
                    )
            assertHighlight(searchResponse, i, "field1", 0, 1, equalTo("<em>test</em> " + hit.getId()));
 * You may obtain a copy of the License at
                        .endObject()
            "field2",
        index("test", "type1", "3", "foo", "weird", "bar", "result");
        );
        logger.info("--> searching on field2, highlighting on field2");
        SearchSourceBuilder source = searchSource().query(rangeQuery("field2").gte("aaaa").lt("zzzz"))
            .startObject("text")
            .setQuery(matchQuery("title", "test"))
                "The quick brown fox jumps over the lazy dog. The lazy red fox jumps over the quick dog. "
        indexRandom(true, client().prepareIndex("test").setSource("field1", "some quick and hairy brown:fox jumped over the lazy dog"));
        assertAcked(
                new HighlightBuilder().field(
        );
            0,
            queryStringQuery("\"highlight words together\"").field("field1", 100)
 * under the License.
import org.opensearch.index.query.QueryBuilder;
            .field("type", "long")
        }
                .get();
            assertHighlight(
        field.highlighterType("unified");
        SearchResponse searchResponse = client().prepareSearch()
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
        assertNotHighlighted(response, 0, "text");
        assertHighlight(response, 0, "field1", 0, 1, equalTo("The <b>quick<b> brown <1>fox</1>"));
        SearchSourceBuilder source = searchSource().query(
            "field2",
                new FunctionScoreQueryBuilder(
    public void testPostingsHighlighterWildcardQuery() throws Exception {
            .query(termQuery("field1", "quick"))
        assertAcked(client().admin().indices().prepareAliases().addAlias("test", "filtered_alias", matchQuery("foo", "japanese")));
        FunctionScoreQueryBuilder.FilterFunctionBuilder filterBuilder = new FunctionScoreQueryBuilder.FilterFunctionBuilder(
        search = client().prepareSearch()
                "type=integer",
        assertNotHighlighted(response, 0, "text");
        refresh();
import static org.opensearch.index.query.QueryBuilders.prefixQuery;
        text.append("words words junk junk junk junk junk junk junk junk highlight junk junk junk junk together junk\n");
        client().prepareIndex("test")
import java.util.Locale;
            .highlighter(new HighlightBuilder().field("title.key"))
            boostingQuery(termQuery("field2", "brown"), termQuery("field2", "foobar")).negativeBoost(0.5f)
        for (String type : ALL_TYPES) {
        assertHighlight(search, 0, "title.key", 0, 1, equalTo("<em>this</em> <em>is</em> <em>a</em> <em>test</em>"));
        SearchSourceBuilder source = searchSource().query(termQuery("field1", "t"))
            "field2",
        phraseBoostTestCaseForClauses(
            0,
    public void testHighlighterWithSentenceBoundaryScannerAndLocale() throws Exception {
            )
    // Issue #5175
        indexRandomForConcurrentSearch("test");
        );
            logger.info("--> highlighting and searching on 'field' with sentence boundary_scanner");
                    .endObject()
            1,
            assertHighlight(
                .get();
import static org.opensearch.index.query.QueryBuilders.multiMatchQuery;
        barField.matchedFields("bar", "bar.plain");
        assertHighlight(
            )
        assertHighlight(searchResponse, 0, "field1", 0, 1, equalTo("this is a <xxx>test</xxx>"));
                .setSource("title", "This is a html escaping highlighting test for *&? opensearch");
        );
        logger.info("--> highlighting and searching on field1");
                .setId(Integer.toString(i))
        // Try with a boosting query using a negative boost
            .setSize(COUNT)
        source = searchSource().query(termQuery("field2", "quick"))
            .endObject()
import org.opensearch.core.xcontent.XContentBuilder;
                        .endObject()
        SearchSourceBuilder source = searchSource().query(wildcardQuery("field2", "qui*")).highlighter(highlight().field("field2"));
                "This is a test where foo is highlighed and should be highlighted",
        indexRandomForConcurrentSearch("test");
                    new HighlightBuilder().field(
        response = client().prepareSearch("test").setQuery(queryBuilder).highlighter(new HighlightBuilder().field(field)).get();
            .field("type", "text")
        logger.info("--> highlighting and searching on field1");
            .get();
        SearchResponse search = client().prepareSearch()
    public void testFastVectorHighlighterMultipleFields() throws InterruptedException {
        indexRandomForConcurrentSearch("test");
                        .endObject()
    }
        // see https://github.com/elastic/elasticsearch/issues/17537
        indexRandomForConcurrentSearch("test");
        refresh();
        ensureGreen();
        for (int i = 0; i < COUNT; i++) {
            .field("type", "geo_point")
            .field("term_vector", "with_positions_offsets")
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
            .get();
            .get();
                    .startObject("field2")
        assertHighlight(
        index("test", "type1", "1", "foo", "running with scissors");
            .get();
            .setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog! Second sentence.")
        SearchResponse searchResponse = client().prepareSearch()
            assertHighlight(search, i, "attachments.body", 0, equalTo("<em>attachment</em> for this test"));
                jsonBuilder().startObject()
            .highlighter(
        indexRandomForConcurrentSearch("test");
        assertAcked(prepareCreate("test").setMapping(mapping));
                .highlighter(new HighlightBuilder().field(new Field("field1").preTags("<xxx>").postTags("</xxx>").forceSource(true))),
        assertAcked(
     * phraseLimit is not set. Its default is now reasonably low.
        SearchSourceBuilder source = searchSource().query(
            0,
    }
        resp = req.setQuery(queryStringQuery("running scissors").field("foo")).get();
                        .startObject("plain")
                    .startObject("title")
                "type=short",
            .highlighter(new HighlightBuilder().field("title", 50, 1, 10).highlighterType("plain"))
    /**
        HighlightBuilder builder = new HighlightBuilder().field(new Field("al*")).requireFieldMatch(false);
            .get();
            .get();
            .get();
            if ("1".equals(searchHit.getId())) {
        ensureGreen();
    public void testFastVectorHighlighter() throws Exception {
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
        indexRandomForConcurrentSearch("test");
import static org.opensearch.index.query.QueryBuilders.boolQuery;
        assertNotHighlighted(response, 0, "postings");
            prepareCreate("test").setMapping(
            assertHighlight(search, i, "attachments.body", 0, equalTo("<em>attachment</em> 1"));
 * the Apache License, Version 2.0 (the "License"); you may
        ensureGreen();
        // We can also ask for a fragment longer than the input string and get the whole string
        SearchSourceBuilder source = searchSource().query(termQuery("field1", "test"))
        ensureGreen();
            .startObject("properties")
     */
                    .field("store", true)
            searchResponse,
import org.apache.lucene.tests.util.TimeUnits;
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so"));
            prepareCreate("test").setMapping(
        refresh();
        for (int i = 0; i < indexRequestBuilders.length; i++) {
        // And you can enable matchedField highlighting on both
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
        assertAcked(prepareCreate("test").setMapping("highlight_field", "type=text,store=true"));
            .setQuery(matchQuery("title", "This is a Test"))
        field.highlighterType("unified");
            containsString("IndexOutOfBoundsException")
                jsonBuilder().startObject()
        }
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field).noMatchSize(21)).get();
        );
                )
                "field2",
        refresh();
                        .field("body", "attachment for this test")
        ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
        }
    }
import org.apache.lucene.analysis.Analyzer;
            .field("index_options", "offsets")
                    .startObject("body")
            "The <b>slow<b> brown fox. Second sentence."
        fooField.matchedFields("foo.plain");
                    .startObject("field1")
        SearchSourceBuilder source = searchSource().query(
                    .field("analyzer", "whitespace")
                    .field("type", "text")
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                .get();
import org.opensearch.common.xcontent.XContentFactory;
/*
        assertHighlight(search, 0, "alias", 0, equalTo("<em>foo</em>"));
    public void testPostingsHighlighterNumberOfFragments() throws Exception {
    public void testPostingsHighlighterPrefixQuery() throws Exception {
                    .endObject()
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
    }
        assertHitCount(searchResponse, COUNT);
        assertNotHighlighted(response, 0, "text");
            MultiMatchQueryBuilder.Type matchQueryType = RandomPicks.randomFrom(random(), MultiMatchQueryBuilder.Type.values());
            .highlighter(highlight().field("field2").preTags("<xxx>").postTags("</xxx>").highlighterType("plain").requireFieldMatch(false));
    }
                    .field("store", false)
        indexRandom(
            .highlighter(
                    .field("field1", 20, 1)
                new HighlightBuilder().field(new HighlightBuilder.Field("field1").preTags("<1>").postTags("</1>").requireFieldMatch(true))
        response = search.setQuery(boostingQuery(phrase, terms).boost(1).negativeBoost(1 / boost)).get();
        );
    public void testSameContent() throws Exception {
        }
            .toString();
                anyOf(equalTo("<xxx>some</xxx> quick and hairy brown"), equalTo("<xxx>some</xxx>"))
                    .endObject()
        SearchSourceBuilder source = searchSource().query(prefixQuery("field2", "qui")).highlighter(highlight().field("field2"));
        SearchResponse search = client().prepareSearch()
            .get();
            // Because of SOLR-3724 nothing is highlighted when FVH is used
            .highlighter(new HighlightBuilder().field("name"))
        SearchResponse searchResponse = client().prepareSearch("test").setSource(source).get();
            prepareCreate("test").setMapping(
            .startObject("field1")
        SearchResponse search = client().prepareSearch()
                        .postTags("</xxx>")
        index("test", "type1", "1", "field1", "The <b>quick<b> brown fox", "field2", "The <b>slow<b> brown fox");
            .get();
            HighlightField field = searchResponse.getHits().getAt(0).getHighlightFields().get("keyword");
            assertNoFailures(search);
                    .endObject()
            .get();
import static org.hamcrest.Matchers.lessThan;
            1,
            assertThat(field.getFragments()[0].string(), equalTo("<em>brown</em> cat"));
        }
        );
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        assertAcked(prepareCreate("test").setMapping(mappings));
            .setQuery(termQuery("field1", "quick"))
    }
            .highlighter(
            boolQuery().must(prefixQuery("field1", "photo")).should(matchQuery("field1", "test").minimumShouldMatch("0"))
            response = search.get();
        DateFormatter formatter = DateFormatter.forPattern("strict_date_optional_time");
                    if (length > 3) {
        source = searchSource().query(termQuery("field1", "fox"))
            .startObject("properties")
        SearchResponse response = client().prepareSearch("test")
    }
                .highlighter(
            .startObject("text")
                        .preTags("<xxx>")
        }
            search = client().prepareSearch("test").setQuery(QueryBuilders.matchQuery("text", "testing")).highlighter(highlightBuilder);
    }
        SearchResponse response = client().prepareSearch("test")
            .setQuery(matchQuery("attachments.body", "attachment"))
                "type=text,term_vector=with_positions_offsets",
        for (int i = 0; i < 10; i++) {
        // Speaking of two fields, you can have two fields, only one of which has matchedFields enabled
        for (int i = 0; i < indexRequestBuilders.length; i++) {
            .endObject()
                    .endObject()
                    .startObject("title")
            .get();
        mappings.startObject();
        req = client().prepareSearch("test").highlighter(new HighlightBuilder().field(fooField));
    public void testHighlighterWithWordBoundaryScannerAndLocale() throws Exception {
                search,
            1,
            )
            containsString("unknown fragmenter option [invalid] for the field [tags]")
            .get();
    public void testPostingsHighlighterFuzzyQuery() throws Exception {
                    .field("enabled", false)
        client().prepareIndex("test")
        // directly.
        prepareCreate("test").setMapping(mapping).get();
            .endObject()
        assertHighlight(search, 0, "title", 0, 1, equalTo("this is a <em>test</em>"));
        SearchSourceBuilder source = searchSource().query(fuzzyQuery("field2", "quck")).highlighter(highlight().field("field2"));
        indexRandom(true, indexRequestBuilders);
        client().prepareIndex("test").setId("1").setSource("keyword", "foo").get();
            assertHighlight(search, i, "title", 0, equalTo("This is a test on the highlighting <em>bug</em> present in opensearch"));
            "field2",
                    .endObject()
            "title.key",
            .setId("2")
    }
        search = client().prepareSearch()
            )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        // simple search on body with standard analyzer with a simple field query
    }
            equalTo(
        index("test", "type1", "2", "text", new String[] { "", text2 });
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
                highlight().order("score")
        client().prepareIndex("test")
        refresh();
        client().prepareIndex("test")
        for (int i = 0; i < 5; i++) {
                "titleTV",
import static org.opensearch.search.builder.SearchSourceBuilder.highlight;
                    .field("store", false)
            field1.fragments()[0].string(),
        assertHighlight(search, 0, "title", 0, 1, equalTo("this is a <em>test</em>"));
            indexRequestBuilders[i] = client().prepareIndex("test")
                jsonBuilder().startObject()
        indexRandomForConcurrentSearch("test");
                0,
            queryStringQuery("highlight words together").field("field1").field("field2"),
                .highlighter(new HighlightBuilder().field("foo").highlighterType(highlighter).requireFieldMatch(false))
            .endObject()
            .setQuery(matchQuery("attachments.body", "attachment"))
        assertAcked(prepareCreate("test").setMapping("keyword", "type=keyword"));
                .setSource(
        // Add the subfield to the list of matched fields but don't match it. Everything should still work
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
        refresh();
        assertHighlight(response, 0, "field1", 0, 1, equalTo("The <b>quick<b> brown <1>fox</1>"));
        for (String type : new String[] { "plain", "unified" }) {
                        .startObject()
        }
        client().prepareIndex("test")
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
            client().prepareIndex("index-1").setId("3").setSource("d", formatter.format(now.minusDays(2)), "field", "world")
            .highlighterType("plain")
            .setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog! Second sentence.")
            SearchResponse search = client().prepareSearch()
        refresh();
                .setSource(
                .get();
                jsonBuilder().startObject()
            .setQuery(matchQuery("title.key", "this is a test"))
        );
        ensureGreen();
                    .startObject("_source")
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[5];
        ensureGreen();
        assertThat(search.getHits().getTotalHits().value(), equalTo(1L));
                    .startObject("attachments")
            }
            "tags",
            .setSource(
        assertHighlight(
            .setQuery(matchQuery("title", "this is a test"))
        refresh();
        XContentBuilder mappings = jsonBuilder();
        refresh();
        client().prepareIndex("test")
import static org.hamcrest.Matchers.equalTo;
            .highlighter(highlight().field("field2"));
                        .endObject()
import static org.opensearch.index.query.QueryBuilders.wildcardQuery;
        field.highlighterType("fvh");
            matchQuery("field1", "highlight words together"),
        refresh();
            .endObject()
                    .endObject()
            RestStatus.BAD_REQUEST,
        // search on title.key and highlight on title
                .highlighter(new HighlightBuilder().field(new Field("foo.text").highlighterType(type)))
                .highlighter(new HighlightBuilder().field("tit*", 50, 1, 10).highlighterType("fvh"))
            .get();
            .endObject()
        response = search.setQuery(boostingQuery(phrase, terms).boost(boost).negativeBoost(1)).get();
        mappings.startObject("properties")
     */
                "type=text,term_vector=with_positions_offsets"
            req.setQuery(queryStringQuery("result").field("foo").field("foo.plain").field("bar").field("bar.plain")),
                    .field("store", false)
            assertThat(field.getFragments()[1].string(), equalTo("<em>cow</em>"));
     * @param highlighterType highlighter to test
        assertHighlight(searchResponse, 0, "field1", 0, 2, equalTo("<global>test</global>"));
 * KIND, either express or implied.  See the License for the
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
    public XContentBuilder type1TermVectorMapping() throws IOException {
    public void testPostingsHighlighterRegexpQuery() throws Exception {
                i,
        SearchResponse search = client().prepareSearch()
            .field("index_options", "offsets")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                        }
                .get();
            0,
                anyOf(equalTo("Another <xxx>sentence</xxx> with"), equalTo("Another <xxx>sentence</xxx> with even more words. "))
        return XContentFactory.jsonBuilder()
        assertThat(searchResponse.getHits().getHits().length, equalTo(COUNT));
        }
                "type=long",
        assertHighlight(response, 0, "text", 0, 1, equalTo(text));
                .setMapping(
            // lets make sure we analyze the query and we highlight the resulting terms
        }
        // check that keyword highlighting works
        // But we use the best found score when sorting fragments
        assertHighlight(
                    "field1",
            .startObject("properties")
import static java.util.Collections.singletonMap;
        HighlightField field1 = highlightFieldMap.get("field1");
                        .postTags("</xxx>")
    }
        index("test", "type1", "1", "text", text);
    }
            "field2",
        client().prepareIndex("test").setId("1").setSource("title", "this is a test").get();
                    }
        indexRandomForConcurrentSearch("test");
            boostingQuery(termQuery("field2", "brown"), termQuery("field2", "foobar")).negativeBoost(0.5f)
            .get();
                    .startObject("title")
            highlightBuilder = new HighlightBuilder().field(field);
                    .field("text", "brown")
                    .field("text", "cow")
        indexRandom(true, indexRequestBuilders);
        ensureGreen();
            .startObject("foo")
                    searchHit,
            "field2",
                "type=text,term_vector=with_positions_offsets",
            .setId("1")
import org.opensearch.index.query.MultiMatchQueryBuilder;
    public void testPostingsHighlighterMultipleFields() throws Exception {
            );
            .endObject()
        ensureGreen();
        resp = req.setQuery(queryStringQuery("foo.plain:running scissors").field("foo")).get();
            2,
            .endObject()
            true,
    public void testPostingsHighlighterTermRangeQuery() throws Exception {
                    "The lazy red fox jumps over the quick dog.",
        SearchResponse search = client().prepareSearch()
                .highlighter(highlight().field("field").preTags("<x>").postTags("</x>"))
        ensureGreen();
        HighlightField field = searchResponse.getHits().getAt(0).getHighlightFields().get("text");
        for (int i = 0; i < iters; i++) {
                "This is the test for the plain highlighter"
        SearchResponse search = client().prepareSearch()
            .setQuery(matchQuery("title", "bug"))
import org.opensearch.search.sort.SortOrder;
        @Override
        );
        }
        // Try with a boosting query
        );
        client().prepareIndex("test").setSource("field1", "this is a test", "field2", "aaab").get();
                .highlighter(highlightBuilder);
            .get();
            queryStringQuery("highlight words together").field("field1"),
        indexRandomForConcurrentSearch("test");
            equalTo(
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFailures;
            assertHitCount(searchResponse, 1);
    }
                        .preTags("<xxx>")
import java.io.IOException;
            .get();
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so some"));
                    .startObject()
    }
            .endObject()
        }
        client().prepareIndex("test").setId("1").setSource("text", "foo bar").get();
                    .field("analyzer", "classic")
            .endObject();
                    .array(
                    .endObject()
                    .endObject()
    public void testPostingsHighlighterRegexpQueryWithinConstantScoreQuery() throws Exception {
        assertHitCount(response, 1L);
                0,
        assertNotHighlighted(response, 0, "text");
                    .endObject()
        ensureGreen();
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
        SearchResponse response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
        ensureGreen();
         * in the neighborhood of 300ms and the large phrase limit is in the
        client().prepareIndex("test")
            .field("type", "text")
        client().prepareIndex("test")
            indexRequestBuilders[i] = client().prepareIndex("test")
        assertAcked(prepareCreate("test").setMapping(mapping));
                0,
        // But if you add the stored field to the list of matched fields then you'll get a result again
            .setSource(
            b.field("type", "text");
            .highlighter(new HighlightBuilder().field("field1"));
        SearchResponse search = client().prepareSearch()
    private void checkFvhMatchedFieldsCase(boolean requireFieldMatch) throws Exception {
                    0,
            @Override
        // Unified hl also works but the fragment is longer than the plain highlighter because of the boundary is the word
                    .field("store", false)
        P phrase
                "type=text,term_vector=with_positions_offsets"
                    .endObject()
                jsonBuilder().startObject()
            .startObject("field2")
        logger.info("--> searching on field2, highlighting on field2");
            .field("type", "nested")
        assertHighlight(response, 0, "text", 1, 2, equalTo("This is the <em>fifth</em> sentence"));
    }
            .setId("2")
                new SearchSourceBuilder().query(query).highlighter(new HighlightBuilder().field("*").highlighterType(highlighterType))
            .endObject()
        assertHighlight(response, 0, "text", 0, 1, equalTo("I am pretty long so some"));
        idsQueryBuilder = QueryBuilders.idsQuery().addIds("3");
                i,
            assertHighlight(
            .setQuery(matchQuery("title.key", "this is a test"))
            .get();
        // Same for if the field doesn't even exist on the document
    }
            prepareCreate("test").setMapping(
                    .field("store", true)
                .get();
                jsonBuilder().startObject()
        assertThat(field.getFragments().length, equalTo(2));
import org.opensearch.action.search.SearchResponse;
                .setSource(
        prepareCreate("test").setMapping(b).get();
            .setSource(
import org.opensearch.test.MockKeywordPlugin;
        assertThat(searchResponse.getHits().getHits().length, equalTo(1));
    public void testHighTermFrequencyDoc() throws IOException, InterruptedException {
            .field("index_options", "offsets")
        );
            .get();
        SearchResponse search = client().prepareSearch()
                .get();
            queryStringQuery("\"highlight words together\"").field("field1")
        SearchSourceBuilder source = searchSource().query(regexpQuery("field2", "qu[a-l]+k")).highlighter(highlight().field("field2"));
        assertHighlight(response, 0, "field1", 0, 1, highlightedMatcher);
                    .field("store", false)
    }
    public void testGeoFieldHighlightingWhenQueryGetsRewritten() throws IOException, InterruptedException {
        // This query used to fail when the field to highlight was absent
    }
        field.highlighterType("plain");
            .highlighter(
        resp = req.setQuery(queryStringQuery("running scissors").field("foo.plain").field("bar"))
                    .endObject()
        );
    public void testForceSourceWithSourceDisabled() throws Exception {
        assertAcked(prepareCreate("test").setMapping(type1TermVectorMapping()));
        indexRandomForConcurrentSearch("test");
                    .startObject("body")
        field.highlighterType("fvh");
                    .startObject("properties")
        assertHighlight(resp, 0, "foo", 0, equalTo("<em>running</em> with <em>scissors</em>"));
        SearchHit hit = searchResponse.getHits().getAt(0);
            .get();
        assertHighlight(response, 0, "text", 1, 2, equalTo("This is the <em>fifth</em> sentence"));
            boolQuery().should(boolQuery().mustNot(QueryBuilders.existsQuery("field1")))
        assertThat(field.getFragments().length, equalTo(1));
            b.field("copy_to", "foo_copy");
        refresh();
            indexRequestBuilders[i] = client().prepareIndex("test")
                    "here is another one that is very long and has the tag token near the end" }
            .get();
        refresh();
                        .endArray()
        for (int i = 0; i < indexRequestBuilders.length; i++) {
    }
                i,
        );
        for (String type : new String[] { "unified", "fvh" }) {
                1,
        ensureGreen();
                    .field("type", "text")
        assertNotHighlighted(response, 0, "text");
    }
        }
        if (randomBoolean()) {
        field.highlighterType("fvh");
        client().prepareIndex("test")
                );
            .field("term_vector", "with_positions_offsets")
                searchResponse,
            .setQuery(matchPhraseQuery("no_long_term", "test foo highlighed").slop(3))
                        .highlighterType(highlighterType)
        assertHighlight(response, 0, "text", 0, 1, equalTo(text));
        assertHighlight(response, 0, "field2", 0, 1, equalTo("The <b>slow<b> brown <2>fox</2>"));
        SearchResponse response = client().prepareSearch("test")
                "the field [title] should be indexed with term vector with position offsets to be " + "used with fast vector highlighter"
                searchResponse,
            assertThat(field.getFragments()[0].string(), equalTo("<em>brown</em> cat"));
        refresh();
        client().prepareIndex("test").setSource("field1", "this is a test", "field2", "The quick brown fox jumps over the lazy dog").get();
        ensureGreen();
        refresh();
            .setQuery(QueryBuilders.matchQuery("tags", "tag"))
            .highlighter(new HighlightBuilder().field("long_term", 18, 1).highlighterType("fvh"))
            .get();
    public void testMultiMapperVectorWithStore() throws Exception {
        // Now make half the matches come from the stored field and half from just a matched field.
            .setSource(jsonBuilder().startObject().field("text", "Arbitrary text field which will should not cause a failure").endObject())
                .highlighter(
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        refresh();
                    }
            .highlighter(new HighlightBuilder().encoder("html").field("title.key", 50, 1))
            HighlightBuilder builder = new HighlightBuilder().field(new Field("alias").highlighterType(type))
        assertNotHighlighted(response, 0, "text");
        logger.info("--> highlighting and searching on field1");
            );
        );
            .get();
        assertThat(defaultPhraseLimit.getTook().getMillis(), lessThan(largePhraseLimit.getTook().getMillis()));
            .get();
            .endObject()
        }
        resp = req.setQuery(queryStringQuery("running scissors").field("foo").field("foo.plain").field("bar").field("bar.plain"))
        SearchSourceBuilder searchSource = SearchSourceBuilder.searchSource()
            assertThat(field.getFragments()[0].string(), equalTo("<em>brown</em>"));
                "text",
        for (String type : new String[] { "unified", "fvh" }) {
            .get();
        assertFailures(
        ensureGreen();
            .field("index_options", "offsets")
                    // we don't store title, now lets see if it works...
        response = client().prepareSearch("test").setQuery(idsQueryBuilder).highlighter(new HighlightBuilder().field(field)).get();
            equalTo("The <x>quick</x> <x>brown</x> fox jumps over the lazy dog! Second sentence.")
        );
            .get();
            equalTo("The <em>quick</em> brown fox jumps over the lazy dog! Second sentence.")
            )
            .highlighterType("fvh")
                .get();
            .get();
        field.highlighterType("unified");
        assertAcked(prepareCreate("test").setMapping(type1PostingsffsetsMapping()));
                            "This is a test on the highlighting bug present in opensearch. Hopefully it works.",
            )
                )
        assertHighlight(resp, 0, "bar", 0, equalTo("<em>resul</em>t"));
        }
            assertHighlight(search, 0, "tags", 1, 2, equalTo("<em>foo bar</em>"));
            .startObject("text")
        refresh();
            RestStatus.INTERNAL_SERVER_ERROR,
                        .field("type", "text")
        assertAcked(
    }
import java.util.Arrays;
        );
import java.time.ZoneOffset;
                    .field("type", "text")
            searchResponse,
                .setQuery(nestedQuery("foo", matchQuery("foo.text", "brown cow"), ScoreMode.None))
            .endObject()
        ensureGreen();
                highlight().highlighterType("fvh")
        String text2 = "This is the third sentence. This is the fourth sentence.";
            .endObject()
                );
        client().prepareIndex("test")
        // simple search on body with standard analyzer with a simple field query
        index("test", "type1", "1", "field1", "The <b>quick<b> brown fox", "field2", "The <b>slow<b> brown fox");
            SearchSourceBuilder source = searchSource().query(termQuery("field1", "some"))
        resp = req.setQuery(twoFieldsQuery).highlighter(new HighlightBuilder().field(fooField).field(barField)).get();
            true,
                    .field("analyzer", "classic")
    public void testHighlightingWithStoredKeyword() throws IOException, InterruptedException {
                        .field("type", "text")
        // You can set noMatchSize globally in the highlighter as well
                    .startObject("properties")
        ensureGreen();
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field)).get();
            .setQuery(matchPhraseQuery("title", "this is a test"))
            .setId("1")
    public void testHighlightNoMatchSize() throws IOException, InterruptedException {
            .setQuery(matchQuery("title.key", "this is a test"))
        // Highlighting of numeric fields is not supported, but it should not raise errors
        SearchResponse resp = req.setQuery(queryStringQuery("running scissors").field("foo")).get();
    }
        resp = req.setQuery(queryStringQuery("foo.plain:running scissors").field("foo")).get();
        ensureGreen();
                )
    @ParametersFactory
        indexRandom(false, client().prepareIndex("test").setId("1").setSource("title", titles, "titleTV", titles));
        ensureGreen();
        SearchResponse search = client().prepareSearch()
    public void testCommonTermsTermVector() throws IOException, InterruptedException {
        assertFailures(
        // But if the field was actually empty then you should get no highlighting field
    public void testHighlightNoMatchSizeNumberOfFragments() throws IOException, InterruptedException {
        logger.info("--> highlighting and searching on field1");
        client().prepareIndex("test")
        response = client().prepareSearch("test").highlighter(new HighlightBuilder().field(field).noMatchSize(21)).get();
    }
            logger.info("Running multi-match type: [{}] highlight with type: [{}]", matchQueryType, highlighterType);
        refresh();
    }
        response = client().prepareSearch("test").setQuery(queryBuilder).highlighter(new HighlightBuilder().field(field)).get();
            highlighterType,
        ensureGreen();
            .field("type", "text")
                        .boundaryScannerType(BoundaryScannerType.SENTENCE)
            prepareCreate("test").setMapping(
                    .startObject("key")
                    .endObject()
        logger.info("--> highlighting and searching on field1 with default phrase limit");
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
        field.highlighterType("plain").noMatchSize(21);
            client().prepareSearch("test").setSource(searchSource),
            .highlighter(new HighlightBuilder().field("field1", 100, 0))
        refresh();
            0,
        assertHighlight(searchResponse, 0, "field2", 0, 1, equalTo("The quick <x>brown</x> fox jumps over the lazy dog"));
        assertThat(search.getHits().getAt(0).getHighlightFields().get("text").fragments().length, equalTo(1));
        ensureGreen();
        assertHighlight(
        int COUNT = between(20, 100);
            HighlightBuilder highlightBuilder = new HighlightBuilder().field(field).highlighterType(type);
        assertNotHighlighted(response, 0, "text");
            .highlighter(highlight().highlighterType("fvh").field("field1", 20, 1).order("score").preTags("<xxx>").postTags("</xxx>"));
        client().prepareIndex("test")

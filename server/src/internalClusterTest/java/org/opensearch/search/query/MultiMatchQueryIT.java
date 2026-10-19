            searchResponse.getHits().getHits()[0].getScore(),  
            client().prepareIndex("test")
        assertHitCount(searchResponse, 1);
            .get();
        assertEquals("1", hits[0].getId());
                SearchResponse left = client().prepareSearch("test")  
import org.junit.Before;
                        .type(type)
            );
        assertFirstHit(searchResponse, hasId("ultimate1"));   // has ultimate in the last_name and that is boosted
                randomizeType(
        assertHitCount(searchResponse, 1L);
                assertEquivalent("captain america", left, right);
            .value();  
        }
                                ).minimumShouldMatch(minShouldMatch)  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
     * same document score if both documents are placed on different shard. This test recreates that scenario
                            randomizeType(
                )
            )
        String idx = "test18710";
                // the hits will be sorted the same consistently
                    ? multiMatchQuery("marvel hero captain america", "full_name", "first_name", "last_name", "category")  
                    multiMatchQuery("the ultimate", "full_name", "first_name", "last_name", "category").type(
        assertFirstHit(searchResponse, hasId("theone"));  
            .get();
        searchResponse = client().prepareSearch("test")
            .get();
                    multiMatchQuery("marvel hero captain america", "full_name", "first_name", "last_name", "category").operator(Operator.OR)
 *
import org.opensearch.common.xcontent.XContentFactory;  
            .startObject("id")
import org.opensearch.common.settings.Settings;  
                .setSource(  
                type = MultiMatchQueryBuilder.Type.BEST_FIELDS;  
import static org.opensearch.index.query.QueryBuilders.disMaxQuery;
        fillRandom(lastNames, between(30, 40));
                )
        searchResponse = client().prepareSearch("test")  
            }  
                    1  
        assertHitCount(searchResponse, 0L);  
                .setSource(
                assertEquals(0, hits.getHits().length);  
        assertThat(numResults, lessThan(searchResponse.getHits().getTotalHits().value()));
                .put("index.analysis.analyzer.perfect_match.type", "custom")
 */  
            String field = RandomPicks.randomFrom(random(), fields);
        }
        searchResponse = client().prepareSearch("test")  
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
                    .setSize(numDocs)
        assertHitCount(searchResponse, 1L);  
            .get();
                    multiMatchQuery("marvel hero", "full_name", "first_name", "last_name", "category").operator(Operator.OR)  
                randomizeType(
                    "first_name",  
 * The OpenSearch Contributors require contributions made to  
                        boolQuery().minimumShouldMatch(minShouldMatch)
        // counter example
    private static MultiMatchQueryBuilder randomizeType(MultiMatchQueryBuilder builder) {
        // more frequent field that acts as a tie-breaker internally  
                    .addSort(SortBuilders.fieldSort("id"))  
    }  
            .setQuery(randomizeType(multiMatchQuery("15", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)))
                .setId("ultimate2")  
            )
 * GitHub history for details.
    /**  
import java.io.IOException;
                            oType = MatchQuery.Type.BOOLEAN;  
                        .analyzer("category")
                    "Captain",
            )  
            {
            topNIds.remove(searchResponse.getHits().getAt(i).getId());
        indexRandom(true, false, builders);  
                        if (randomBoolean()) {
            return t;
                )
                    .addSort(SortBuilders.scoreSort())  
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS  
import org.opensearch.common.unit.Fuzziness;
                    case PHRASE_PREFIX:  
        cutoffFrequency = randomBoolean() ? Math.min(1, numDocs * 1.f / between(10, 20)) : 1.f / between(10, 20);
            )
                .setId("nowHero")  
 * under the License.  
            {  
            .get();
        assertThat(leftHits.getHits().length, equalTo(rightHits.getHits().length));  
        // test group based on analyzer -- all fields are grouped into a cross field search
                    multiMatchQuery("marvel hero captain america", "full_name", "first_name", "last_name", "category").operator(Operator.OR)
            .setQuery(matchAllQuery())
                        .type(type)
        assertFirstHit(searchResponse, hasId("theone"));  
            .get();  
                        .type(type)
                    )
        searchResponse = client().prepareSearch("test")
                    left = client().prepareSearch("test")
            .field("type", "date")  
            "wolferine",
            String first = RandomPicks.randomFrom(random(), firstNames);  
    private static List<String> fill(List<String> list, String value, int times) {
        assertFirstHit(searchResponse, hasId("theone"));  
                randomizeType(
        searchResponse = client().prepareSearch("test")  
            String last = randomPickExcept(lastNames, first);
        assertHitCount(searchResponse, 2L);  
                    multiMatchQuery("captain america 15", "skill", "full_name", "first_name", "last_name", "category", "int-field").type(
import static org.hamcrest.Matchers.lessThan;
        assertFirstHit(searchResponse, hasId("theone"));
            )
                    multiMatchQuery("captain america", "full_name", "first_name", "last_name", "category").operator(Operator.AND).type(type)
                    multiMatchQuery("marvel hero captain america", "full_name", "first_name", "last_name", "category").operator(Operator.OR)
            .get();
                    "hero",
                        }  
            "1",
                randomizeType(
                    "marvel hero",
                    case MOST_FIELDS:  
                randomizeType(
            } else {
                        first,
        assertNoFailures(left);
                                    MatchQuery.Type.PHRASE  
            .get();
    }  
                    "nowHero",  
                )
                SearchResponse left = client().prepareSearch("test")
                    multiMatchQuery("the Ul", "full_name_phrase", "first_name_phrase", "last_name_phrase", "category_phrase").operator(
                        "last_name",  
        assertFirstHit(searchResponse, hasId("theone"));
                randomizeType(
                        .type(type)
                        .cutoffFrequency(cutoffFrequency)  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
        while (true) {
            Settings.builder()
        fill(firstNames, "Ultimate", between(5, 10));  
                    "last_name",  
                    ).operator(Operator.OR)
            .get();
            int numTerms = randomIntBetween(1, query.length);
        assertNoFailures(searchResponse);
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS
                    : multiMatchQuery("captain america", "*_name", randomBoolean() ? "category" : "categ*");
                )  
            .startObject("full_name")
        final int numDocs = (int) client().prepareSearch("test")  
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(randomizeType(multiMatchQuery("15", "skill"))).get();
                    .addSort(SortBuilders.fieldSort("id"))  
                assertThat(hits.getHits()[j].getId(), equalTo(matchResp.getHits().getHits()[j].getId()));
                    "bogus",
            StringBuilder builder = new StringBuilder();  
            .field("type", "text")
        long size = searchResponse.getHits().getTotalHits().value();
 * Unless required by applicable law or agreed to in writing,
            .get();
            .get();
        }  
 * KIND, either express or implied.  See the License for the
        searchResponse = client().prepareSearch("test")
        }  
                    ).operator(Operator.AND)
                    multiMatchQuery("marvel hero captain america", "full_name", "first_name", "last_name", "category").type(
            .get();
                    multiMatchQuery("25 15", "first_name", "int-field", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
                )  
            )  
                    3
                            oType = MatchQuery.Type.PHRASE_PREFIX;
                        .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
import org.opensearch.search.sort.SortOrder;
            .get();
            )  
    public void testCutoffFreq() throws ExecutionException, InterruptedException {
            "ultimate",
        searchResponse = client().prepareSearch("test")
            .setQuery(
            "missing_fields*" };
                    "full_name",  
            .endObject();  
                .setQuery(matchQueryBuilder)  
import java.util.List;  
            )
        // counter example
 * this work for additional information regarding copyright
        assertFirstHit(searchResponse, hasId("theone"));
        searchResponse = client().prepareSearch("test")
        long numResults = searchResponse.getHits().getTotalHits().value();  
            greaterThanOrEqualTo(searchResponse.getHits().getHits()[1].getScore())
                        .lenient(true)  
                    multiMatchQuery("marvel hero captain america", "full_name", "first_name", "last_name", "category").operator(Operator.OR)  
                    "theone",  
                    "last_name",
            }  
                            )
import static org.hamcrest.Matchers.equalTo;
                        .setSize(numDocs)
                .setSource(
        assertHitCount(searchResponse, 1L);
        CreateIndexRequestBuilder builder = prepareCreate(idx).setSettings(  
                    .addSort(SortBuilders.fieldSort("id"))
import org.opensearch.common.util.set.Sets;
            .setExplain(true)
                    .setSize(numDocs)
        for (int i = 0; i < times; i++) {
        assertFirstHit(searchResponse, hasId("theone"));  
                .put("index.analysis.analyzer.perfect_match.tokenizer", "keyword")  
            .field("norms", false)
                        "first_name",
    public void testPhraseType() {
                )
            .get();
                Object oType = type;
                    multiMatchQuery("the ultimate", "full_name", "first_name", "category").field("last_name", 10)  
                    multiMatchQuery("captain america marvel hero", "first_name", "last_name", "category").type(  
        return Arrays.asList(
import static org.opensearch.index.query.QueryBuilders.matchPhraseQuery;
import org.opensearch.action.index.IndexRequestBuilder;
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS  
        assertFirstHit(searchResponse, hasId("ultimate1"));  
                    .setQuery(
                randomizeType(
                    ).operator(Operator.AND)  
                    .addSort(SortBuilders.scoreSort())
                )
            .get();
        // Lenient wasn't always properly lenient with two numeric fields
                randomizeType(  
                        Operator.OR
        assertFirstHit(searchResponse, hasId("theone"));
                        if (randomBoolean()) {
    }
                    )  
                            randomizeType(  
     */  
                )  
                        randomBoolean() ? MultiMatchQueryBuilder.Type.CROSS_FIELDS : MultiMatchQueryBuilder.DEFAULT_TYPE
            .field("copy_to", "full_name_phrase")  
            )  
                    .addSort(SortBuilders.scoreSort())
                    .get();
 * this file be licensed under the Apache-2.0 license or a
                randomizeType(
        List<IndexRequestBuilder> builders = new ArrayList<>();  
        searchResponse = client().prepareSearch("test")
            "first_name_phrase",
            .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFirstHit;
                randomizeType(
            .startObject()
            .get();
        searchResponse = client().prepareSearch("test")  
                randomizeType(
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
 * software distributed under the License is distributed on an
                            .add(matchQuery("category", "marvel hero captain america"))
        assertHitCount(searchResponse, 1L);
                        .type(type)
            .setQuery(  
                                    ? termQuery("full_name", "captain america")
        searchResponse = client().prepareSearch("test")  
        SearchHit[] rHits = rightHits.getHits();
                    1
                )
        for (int i = 0; i < numIters; i++) {  
                        boolQuery().minimumShouldMatch(minShouldMatch)
                randomizeType(
        Float cutoffFrequency = randomBoolean() ? Math.min(1, numDocs * 1.f / between(10, 20)) : 1.f / between(10, 20);
            .setQuery(  
                .put("index.analysis.analyzer.perfect_match.filter", "lowercase")
                )
            .endObject()
                        }
                    "skill",
        }
                    .get();  
            .setQuery(
            "hero",  
                    .get();  
                    case PHRASE:
            }
                    "now sort of",
        assertHitCount(searchResponse, 1L);
                                multiMatchQuery("captain america", "full_name", "first_name", "last_name", "category").type(
                randomizeType(
import static org.opensearch.index.query.QueryBuilders.termQuery;
            assertThat(
            .setQuery(
        return list;  
        assertFirstHit(searchResponse, hasId("ultimate1"));
                )
                        "id",  
                        .cutoffFrequency(cutoffFrequency)  
        for (int i = 0; i < numIters; i++) {
                        i,
        fillRandom(firstNames, between(3, 7));
        assertThat(
        SearchResponse searchResponse = client().prepareSearch("test")  
            .setQuery(multiMatchQuery("foo").field("title", 100).field("body").fuzziness(Fuzziness.ZERO))  
        searchResponse = client().prepareSearch("test")
            .setQuery(
                        boolQuery().minimumShouldMatch(minShouldMatch)  
        assertFirstHit(searchResponse, hasId("theone"));  
            )
                )  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;  
                        .setSize(numDocs)  
                    "first_name",  
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS  
            )
                    multiMatchQuery("captain america marvel hero", "first_name", "last_name", "category").type(
        assertFirstHit(searchResponse, hasId("theone"));
                    multiMatchQuery("marvel hero", "full_name", "first_name", "last_name", "category").type(  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSecondHit;
                        .operator(Operator.AND)
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 3).put(SETTING_NUMBER_OF_REPLICAS, 0)
                .setId("anotherhero")
            .getHits()
                .put(indexSettings())
import org.opensearch.plugins.Plugin;
                    25  
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(  
            }
    }
            .setQuery(randomizeType(multiMatchQuery("15", "skill", "first_name").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)))
        assertThat(searchResponse.getHits().getHits()[0].getScore(), greaterThan(searchResponse.getHits().getHits()[1].getScore()));  
        assertNotEquals("both documents should be on different shards", hits[0].getShard().getShardId(), hits[1].getShard().getShardId());  
    @ParametersFactory  
            .setQuery(randomizeType(multiMatchQuery("15", "int-field", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)))  
                    "last_name",
        searchResponse = client().prepareSearch("test")
import org.opensearch.search.SearchHits;  
        searchResponse = client().prepareSearch("test")
                            .should(matchPhrasePrefixQuery("full_name", "capta"))
        assertThat(searchResponse.getHits().getTotalHits().value(), greaterThan(1L));  
                    ).type(MatchQuery.Type.PHRASE_PREFIX)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                )
            {  
                        "full_name",
            "marvel",  
import java.util.concurrent.ExecutionException;
            for (int j = 0; j < numTerms; j++) {
                SearchResponse right = client().prepareSearch("test")  
                    "full_name",  
        Set<String> topNIds = Sets.newHashSet("theone", "theother");  
                .addSort("id", SortOrder.ASC)  
                    .setSize(numDocs)
            "full_name",  
                            .should(matchPhraseQuery("category", "captain america"))  
        final long numDocs = client().prepareSearch("test").setSize(0).setQuery(matchAllQuery()).get().getHits().getTotalHits().value();
                .get();
                    1
        assertFirstHit(searchResponse, hasId("theone"));
                randomizeType(
                            .should(matchPhrasePrefixQuery("first_name", "capta"))
                    "Man the Ultimate",
                    multiMatchQuery("captain america 15", "first_name", "last_name", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
            "ninja" };
                    "last_name",
                            .should(matchPhraseQuery("full_name", "captain america"))  
                    ).operator(Operator.AND)
            .setQuery(
            .get();  
        SearchHits leftHits = left.getHits();  
                    "first_name",
                assertEquivalent("capta", left, right);
 */
        String[] query = {
                Operator op = randomBoolean() ? Operator.AND : Operator.OR;
        searchResponse = client().prepareSearch("test")
                                multiMatchQuery("captain america", "full_name", "first_name", "last_name", "category").type(
        searchResponse = client().prepareSearch("test")
                    "marvel hero",
                )
                )
            .get();
            .field("type", "text")
                            )
                        .addSort(SortBuilders.fieldSort("id"))
            .endObject()  
                )
    }  
                            .should(matchQuery("last_name", "captain america").operator(op))  
    }
        }
                equalTo(matchResp.getHits().getTotalHits().value())
                    .addSort(SortBuilders.scoreSort())
        MatchQuery.Type type = MatchQuery.Type.BOOLEAN;
                SearchResponse right = client().prepareSearch("test")  
    }
                    "now",
            SearchResponse multiMatchResp = client().prepareSearch("test")
                    multiMatchQuery("captain america", "full_name", "first_name", "last_name", "category").operator(Operator.AND).type(type)  
            .setQuery(
            .field("copy_to", "last_name_phrase")  
        searchResponse = client().prepareSearch("test")
    }
                    )  
                        .setQuery(
                        .cutoffFrequency(cutoffFrequency)  
 * not use this file except in compliance with the License.
                    multiMatchQuery("marvel hero", "full_name", "first_name", "last_name", "category").operator(Operator.OR).type(type)
     * and checks that the returned scores are different.
                randomizeType(
                randomizeType(
        assertHitCount(searchResponse, 1L);
                assertEquivalent("marvel hero captain america", left, right);
            .setQuery(
            if (t.equals(butNot)) {
                randomizeType(
                .put("index.analysis.analyzer.category.tokenizer", "standard")  
                .setSource(
                    ).cutoffFrequency(0.1f).analyzer("category").operator(Operator.OR)
                    .setQuery(
            .setQuery(  
        assertFirstHit(searchResponse, hasId("theone"));
        builders.add(
                                .minimumShouldMatch(minShouldMatch)
        assertFirstHit(searchResponse, hasId("theone"));  
        );  
                randomizeType(
            // very likely that we hit a random doc that has the same score so orders are random since
                        "skill",
            .setQuery(  
                            .add(matchQuery("last_name", "marvel hero captain america"))
            .setQuery(  
import static org.opensearch.index.query.QueryBuilders.matchQuery;
            )
            .get();
            )  
                        )  
                    "id",
        assertFirstHit(searchResponse, anyOf(hasId("theone"), hasId("theother")));
                    multiMatchQuery("25 15", "int-field", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS).analyzer("category")
        Set<String> topNIds = Sets.newHashSet("theone", "theother");
                    ).operator(Operator.OR)
                    ).analyzer("category").lenient(true).operator(Operator.AND)
            .setQuery(
        assertHitCount(searchResponse, 1L);  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        searchResponse = client().prepareSearch("test")
                assertEquivalent("captain america", left, right);  
            .endObject()  
        assertFirstHit(searchResponse, hasId("theone"));  
            "17",
                continue;
            .setQuery(  
                assertThat(hits.getHits()[j].getScore(), equalTo(matchResp.getHits().getHits()[j].getScore()));  
                )
        searchResponse = client().prepareSearch("test")
import org.opensearch.action.search.SearchResponse;
            .get();
                    .setId("" + i)
                            .should(matchPhraseQuery("first_name", "captain america"))
                } else {
                    "category",  
            .get();  
                    "theother",
            .get();
        builders.add(  
                    left = client().prepareSearch("test")
        return XContentFactory.jsonBuilder()
                String minShouldMatch = randomBoolean() ? null : "" + between(0, 1);
        builders.add(client().prepareIndex(idx).setId("2").setSource("title", "bar", "body", "foo"));
            .startObject("category")  
        );
                        break;
            // very likely that we hit a random doc that has the same score so orders are random since  
                    .addSort(SortBuilders.fieldSort("id"))  
            MultiMatchQueryBuilder.Type type = builder.getType();
            MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(field, builder.toString());  
            .field("copy_to", "first_name_phrase")
import org.opensearch.search.SearchHit;
                randomizeType(
import java.util.Arrays;  
                    "",
        assertFirstHit(searchResponse, hasId("ultimate2"));
    }  
        searchResponse = client().prepareSearch("test")
            if (hits[i].getScore() == hits[hits.length - 1].getScore()) {
                    )
                randomizeType(  
 *    http://www.apache.org/licenses/LICENSE-2.0
                builder.type(type);  
     * Test for edge case where field level boosting is applied to field that doesn't exist on documents on
            )  
        assertFirstHit(searchResponse, hasId("theone"));
            "marvel",
        assertThat(searchResponse.getHits().getHits()[0].getScore(), greaterThan(searchResponse.getHits().getHits()[1].getScore()));  
import java.util.Set;
                    "full_name",
     * one shard. There was an issue reported in https://github.com/elastic/elasticsearch/issues/18710 where a
                .put("index.analysis.analyzer.category.type", "custom")
                        last,
        searchResponse = client().prepareSearch("test")
        SearchHit[] hits = leftHits.getHits();
            .setQuery(  
            if (type == null && randomBoolean()) {
                        .cutoffFrequency(cutoffFrequency)  
            .startObject("first_name")
            "last_name",
                                    : matchQuery("full_name", "captain america").operator(op)  
                    "ultimate",
            .get();
    private static List<String> fillRandom(List<String> list, int times) {  
            client().prepareIndex("test")
                    multiMatchQuery("Captain", "full_name_phrase", "first_name_phrase", "last_name_phrase", "category_phrase").operator(  
                randomizeType(
        ensureGreen();
            client().prepareIndex("test")
                        randomizeType(
                    .get();
            .field("analyzer", "category")
                    "marvel hero",
        // Two numeric fields together caused trouble at one point!
/*
                        .get();  
                    )
                                    MatchQuery.Type.PHRASE
                )  
        searchResponse = client().prepareSearch("test")  
            .setQuery(  
                )
            .get();
            }
        searchResponse = client().prepareSearch("test")  
import java.util.Collection;
            .setQuery(  
            .setQuery(
    public void testCrossFieldMode() throws ExecutionException, InterruptedException {
            .get();
        );
                            .should(matchPhraseQuery("last_name", "captain america"))
                SearchResponse right = client().prepareSearch("test")  
            )
            list.add(randomAlphaOfLength(5));
        assertFirstHit(searchResponse, hasId("theone"));
                    "marvel hero",
                    "full_name",
        SearchResponse searchResponse = client().prepareSearch("test")
                            .add(matchQuery("first_name", "marvel hero captain america"))  
                    ).analyzer("category").operator(Operator.AND)
/*
            if (field.startsWith("missing")) {
            )  
        builders.add(client().prepareIndex(idx).setId("1").setSource("title", "foo", "body", "bar"));  
            .setQuery(  
            .get();
                randomizeType(
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                            multiMatchQuery("capta", "full_name", "first_name", "last_name", "category").type(MatchQuery.Type.PHRASE_PREFIX)  
import static org.opensearch.index.query.QueryBuilders.multiMatchQuery;  
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;  
            SearchResponse matchResp = client().prepareSearch("test")
         */
            .setQuery(  
            .get();  
                "field: " + field + " query: " + builder.toString(),  
                    multiMatchQuery("captain america", "full_name", "first_name", "last_name").type(  
    public MultiMatchQueryIT(Settings staticSettings) {
                                ).tieBreaker(1.0f).minimumShouldMatch(minShouldMatch)
                .setId("ultimate1")  
                        .addSort(SortBuilders.scoreSort())
                )
        assertAcked(builder.setMapping(createMapping()));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertFirstHit(searchResponse, hasId("theone"));  
            .setQuery(randomizeType(multiMatchQuery("15", "skill", "int-field")).analyzer("category"))  
            .setQuery(
            "last_name_phrase",  
            "captain",
            .get();
        searchResponse = client().prepareSearch("test")
    }  
                        .analyzer("category")  
        List<String> lastNames = new ArrayList<>();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                    "marvel",  
                builder.type(oType);  
            )  
                        randomizeType(multiMatchQueryBuilder.operator(op).tieBreaker(1.0f).minimumShouldMatch(minShouldMatch).type(type))
            )  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
                        .analyzer("category")
import java.util.ArrayList;
    private static void assertEquivalent(String query, SearchResponse left, SearchResponse right) {  
                    .setQuery(
        MatchQuery.Type type = MatchQuery.Type.BOOLEAN;  
            "category_phrase",
            .setQuery(randomizeType(multiMatchQuery("15", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS).analyzer("category")))
            client().prepareIndex("test")
 *  
        assertHitCount(searchResponse, 1L);
                // id sort field is a tie, in case hits have the same score,  
        );
    }
            .getTotalHits()
            .get();  
            if (randomBoolean()) {
                    ).operator(Operator.AND)
                )
                    "category",
import org.opensearch.index.query.MatchQueryBuilder;
                        .analyzer("category")
        assertThat(searchResponse.getHits().getHits()[0].getScore(), greaterThan(searchResponse.getHits().getHits()[1].getScore()));
                )  
import org.opensearch.index.query.QueryBuilders;
        SearchResponse searchResponse = client().prepareSearch(idx)
            "first_name",
                    .addSort(SortBuilders.scoreSort())
                            )
        SearchHit[] hits = searchResponse.getHits().getHits();
        assertSecondHit(searchResponse, hasId("ultimate1"));  
        // test if boosts work
            topNIds.remove(searchResponse.getHits().getAt(i).getId());  
            .startObject("properties")  
            .get();
        searchResponse = client().prepareSearch("test")
        cutoffFrequency = randomBoolean() ? Math.min(1, numDocs * 1.f / between(10, 20)) : 1.f / between(10, 20);
            }
        assertThat(searchResponse.getHits().getHits()[0].getScore(), greaterThan(searchResponse.getHits().getHits()[1].getScore()));  
                randomizeType(
                    ).analyzer("category").operator(Operator.OR)
        List<String> firstNames = new ArrayList<>();
                        "category",
    @Before
            .get();
                        break;
        assertFirstHit(searchResponse, hasId("theother"));
import java.util.Collections;
        assertHitCount(searchResponse, 1L);
        searchResponse = client().prepareSearch("test")
        assertAcked(builder.setMapping("title", "type=text", "body", "type=text"));  
        assertHitCount(searchResponse, 1L);
            .setQuery(
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS
                    "ultimate1",  
                    "first_name",
                        .type(type)
                )  
                    multiMatchQuery("captain america", "full_name", "first_name", "last_name", "category").operator(Operator.AND)
                    multiMatchQuery("marvel hero", "first_name", "last_name", "category").operator(Operator.AND)
        }  
                        .operator(Operator.OR)
                    "id",
                    .addSort(SortBuilders.fieldSort("id"))
                // id tie sort  
        for (int i = 0; i < times; i++) {  
            .get();
                    "Ultimate Mutant",  
        assertFirstHit(searchResponse, hasId("theother"));  
            }  
            .setQuery(
            list.add(value);
                .addSort("_score", SortOrder.DESC)
        for (int i = 0; i < searchResponse.getHits().getHits().length; i++) {
                    .setSource(
    }  
                    ).analyzer("category").lenient(true).operator(Operator.AND)
                        randomBoolean() ? MultiMatchQueryBuilder.Type.CROSS_FIELDS : MultiMatchQueryBuilder.DEFAULT_TYPE
                )  
                    "skill",  
        assertFirstHit(searchResponse, anyOf(hasId("theone"), hasId("theother")));
        searchResponse = client().prepareSearch("test")
 * the Apache License, Version 2.0 (the "License"); you may
                    multiMatchQuery("marvel hero captain america", "full_name", "first_name", "last_name", "category").operator(Operator.OR)  
                .get();
                }
                    multiMatchQuery("captain america", "full_name", "first_name", "last_name", "category").operator(Operator.AND)
        assertHitCount(searchResponse, 2L);  
        assertThat(hits[0].getScore(), greaterThan(hits[1].getScore()));  
            .get()  
package org.opensearch.search.query;
            .get();
            .get();  
                if (randomBoolean()) {  
            .get();
                )
                    .get();
import org.opensearch.search.sort.SortBuilders;
                    "first_name",
                )  
        searchResponse = client().prepareSearch("test")  
                .put(SETTING_NUMBER_OF_SHARDS, 1)  
                )  
        );
        // since we try to treat the matching fields as one field scores are very similar but we have a small bias towards the
                )
                .setSource(  
                    "wolferine",  
         * break on spaces.  
                    .get();
        assertThat(searchResponse.getHits().getHits()[0].getScore(), greaterThan(searchResponse.getHits().getHits()[1].getScore()));
            "5",  
            .setQuery(
        assertSecondHit(searchResponse, hasId("ultimate2"));
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                            oType = MatchQuery.Type.BOOLEAN;
            .setQuery(  
                    multiMatchQuery("captain america 15", "full_name", "first_name", "last_name", "category", "skill").type(
                    "skill",
                    "category",
                    "full_name",
        searchResponse = client().prepareSearch("test")
            .setQuery(  
        fill(firstNames, "Captain", between(15, 25));
        assertFirstHit(searchResponse, hasId("theother"));  
            MultiMatchQueryBuilder multiMatchQueryBuilder = randomizeType(multiMatchQuery(builder.toString(), field));
 * ownership. Elasticsearch licenses this file to you under  
                multiMatchResp.getHits().getTotalHits().value(),
                        .setQuery(  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            .get();
    private XContentBuilder createMapping() throws IOException {  
                    multiMatchQuery("captain america marvel hero", "first_name", "last_name", "category").type(
                switch (type) {  
    private static <T> T randomPickExcept(List<T> fromList, T butNot) {
        assertHitCount(searchResponse, 1L);
                )  
        try {  
            "15",  
                    .setQuery(
                MatchQuery.Type type = MatchQuery.Type.BOOLEAN;  
                MultiMatchQueryBuilder multiMatchQueryBuilder = randomBoolean()  
            {
                    "category",
                        )  
import static org.hamcrest.Matchers.greaterThan;
            )
                SearchResponse right = client().prepareSearch("test")
                    )
                String minShouldMatch = randomBoolean() ? null : "" + between(0, 1);
            "category",  
        }
                randomizeType(
        int numIters = scaledRandomIntBetween(5, 10);
                )  
                )  
            )
                randomizeType(
        );
                    multiMatchQuery("captain america", "full_name", "first_name", "last_name", "category").type(
        assertThat(topNIds, empty());
import static org.hamcrest.Matchers.closeTo;
                    "Alpha the Ultimate Mutant",
        builders.add(
 * You may obtain a copy of the License at  
        assertFirstHit(searchResponse, hasId("theone"));  
        assertFirstHit(searchResponse, anyOf(hasId("theone"), hasId("theother")));
        builders.add(  
        assertThat("common terms expected to be a way smaller result set", size, lessThan(searchResponse.getHits().getTotalHits().value()));  
 */
            .get();  
                }
                randomizeType(
            .endObject()
            .setQuery(  
 *
                            .should(matchPhrasePrefixQuery("last_name", "capta"))  
                    .setQuery(randomizeType(multiMatchQueryBuilder.operator(Operator.OR).type(type)))  
                    .setSize(numDocs)  
        assertHitCount(searchResponse, 1L);  
                        Operator.OR  
            .setQuery(  
        builders.add(
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS
        }
        searchResponse = client().prepareSearch("test")
                return; // we need to cut off here since this is the tail of the queue and we might not have fetched enough docs
            .field("type", "text")
                    "id",
                    "anotherhero",
        assertFirstHit(searchResponse, hasId("theother"));
                    "America",  
                        )
            )  
                        disMaxQuery().add(matchQuery("full_name", "marvel hero captain america"))
        } catch (Exception ex) {  
                )
                    multiMatchQuery("alpha 15", "int-field", "first_name", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
    public void testFuzzyFieldLevelBoosting() throws InterruptedException, ExecutionException {
            }
                    .setSize(numDocs)
            );  
    public void testDefaults() throws ExecutionException, InterruptedException {  
        return list;
                randomizeType(
            )
                .addSort("id", SortOrder.ASC)
            )
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
        assertSecondHit(searchResponse, hasId("theone"));  
                .setQuery(multiMatchQueryBuilder)
        assertFirstHit(searchResponse, anyOf(hasId("theother"), hasId("theone")));
                        .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
            )
            .field("type", "keyword")
                    .get();
    }
                    .addSort(SortBuilders.scoreSort())
                        randomBoolean() ? "marvel hero" : "bogus",  
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS  
        // check if it's equivalent to a match query.
            for (int j = 0; j < hits.getHits().length; j++) {
                    "full_name",
        searchResponse = client().prepareSearch("test")
        }
        return Collections.singleton(MockKeywordPlugin.class);
            .setQuery(randomizeType(multiMatchQuery("now", "f*", "date").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)).lenient(true))  
            .setQuery(
                randomizeType(
                    "last_name",
                )
        searchResponse = client().prepareSearch("test")
            )
                randomizeType(  
import static org.hamcrest.Matchers.anyOf;
                    .setSize(numDocs)
import org.opensearch.test.MockKeywordPlugin;  
                    "category",
        assertHitCount(searchResponse, 1L);
        String[] fields = {
                        if (randomBoolean()) {
            .field("type", "text")
        searchResponse = client().prepareSearch("test")  
        fill(lastNames, "Captain", between(3, 7));  
        searchResponse = client().prepareSearch("test")  
            )
            }
            .setQuery(
                    .addSort(SortBuilders.fieldSort("id"))  
                client().prepareIndex("test")  
            .setQuery(  
                randomizeType(
    public void init() throws Exception {
                    multiMatchQuery("25 15", "int-field", "first_name", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
                randomizeType(
                    ).analyzer("category").lenient(true).operator(Operator.AND)
            )
                        .cutoffFrequency(cutoffFrequency)
        List<IndexRequestBuilder> builders = new ArrayList<>();
public class MultiMatchQueryIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
                    "first_name",  
            }  
                            .should(matchQuery("category", "captain america").operator(op))
        int numIters = scaledRandomIntBetween(10, 100);
                        .type(MatchQuery.Type.PHRASE)
            .startObject("last_name")  
import static org.hamcrest.Matchers.empty;  
            .endObject()
                String minShouldMatch = randomBoolean() ? null : "" + between(0, 1);
                randomizeType(
            .get();
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS  
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 0L);  
        }
                    .addSort(SortBuilders.scoreSort())
            .endObject()
                    multiMatchQuery("25 15", "int-field", "skill", "first_name").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)  
import org.opensearch.index.query.MultiMatchQueryBuilder;  
        assertFirstHit(searchResponse, hasId("theone"));  
            .setQuery(  
                )
                        }
            )
                randomizeType(
                randomizeType(
        assertFirstHit(searchResponse, hasId("theone"));
            "Man",
            .field("norms", false)  
import static org.opensearch.index.query.QueryBuilders.matchPhrasePrefixQuery;  
    public void testEquivalence() {
                .setSource(
                        break;
            }
                builder.append(RandomPicks.randomFrom(random(), query)).append(" ");
            builders.add(
                    "",  
        assertThat(leftHits.getTotalHits().value(), equalTo(rightHits.getTotalHits().value()));
            )
}
                        .cutoffFrequency(cutoffFrequency)  
            .setQuery(
        assertHitCount(searchResponse, 2L);
                    multiMatchQuery("captain america marvel hero", "first_name", "last_name", "category").type(  
        assertFirstHit(searchResponse, hasId("theone"));  
        ensureGreen();
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS  
                            .should(matchQuery("first_name", "captain america").operator(op))
                    .addSort(SortBuilders.fieldSort("id"))  
            .get();  
        indexRandom(true, false, builders);
        assertFirstHit(searchResponse, hasId("theother"));  
            return builder;
        assertFirstHit(searchResponse, hasId("nowHero"));  
 * license agreements. See the NOTICE file distributed with
                            .should(matchPhrasePrefixQuery("category", "capta"))
import org.opensearch.index.query.Operator;
                            oType = MatchQuery.Type.PHRASE;  
                return builder;  
                    "Alpha the",
                    multiMatchQuery("Man the Ultimate", "full_name_phrase", "first_name_phrase", "last_name_phrase", "category_phrase")  
                    .setQuery(
    }
            .get();
                    "marvel hero",  
        );  
            .get();  
            client().prepareIndex("test")
                    "last_name",
            )  
    }
        assertHitCount(searchResponse, 1L);
        assertThat(searchResponse.getHits().getHits()[0].getScore(), greaterThan(searchResponse.getHits().getHits()[1].getScore()));
            )  
        searchResponse = client().prepareSearch("test")  
                    "id",
                        .lenient(true)  
            .setQuery(  
                        if (randomBoolean()) {
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS
            )  
        );
                    "category",  
 * SPDX-License-Identifier: Apache-2.0
        assertFirstHit(searchResponse, hasId("theone"));  
            .setQuery(  
            assertThat("query: " + query, hits[i].getId(), equalTo(rHits[i].getId()));
        // Test group based on numeric fields  
    }
                        break;  
            .setSize(0)
                    "skill",
                    "int-field",
                        .analyzer("category")
        SearchResponse searchResponse = client().prepareSearch("test")
    }
        searchResponse = client().prepareSearch("test")
        assertEquals("2", hits[1].getId());
                    "skill",  
        super(staticSettings);  
        assertSearchHits(searchResponse, "ultimate2", "ultimate1");
        for (int i = 0; i < hits.length; i++) {  
                MatchQuery.Type type = MatchQuery.Type.BOOLEAN;
            .setQuery(  
            .get();
            )  
                    multiMatchQuery("alpha 15", "first_name", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS).lenient(true)
        SearchResponse searchResponse = client().prepareSearch("test")  
                    .setQuery(
            )  
            "missing_field",
                        .addSort(SortBuilders.scoreSort())  
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 1L);
                    case BEST_FIELDS:
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS  
                            .should(  
                )
            client().prepareIndex("test")
                .setId("theother")
                        .get();
 * compatible open source license.
                    : multiMatchQuery("marvel hero captain america", "*_name", randomBoolean() ? "category" : "categ*");
                )
 * Modifications Copyright OpenSearch Contributors. See  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
                )
        searchResponse = client().prepareSearch("test")  
        builders.add(
                    15,
                    5  
            // the doc id is the tie-breaker
            .startObject("date")
                SearchResponse left = client().prepareSearch("test")  
                        first + " " + last,  
        int numDocs = scaledRandomIntBetween(50, 100);
            .setQuery(  
        assertFirstHit(searchResponse, hasId("ultimate2"));  
            if (type == null) {
        /*
            )
                                randomBoolean()
            )  
 * specific language governing permissions and limitations
                )  
        assertNoFailures(searchResponse);
 * Licensed to Elasticsearch under one or more contributor  
                .put("index.analysis.analyzer.category.filter", "lowercase")
            throw new RuntimeException(ex);
                .setId("theone")  
                )
import org.opensearch.index.search.MatchQuery;  
                )  
        searchResponse = client().prepareSearch("test")
                .addSort("_score", SortOrder.DESC)
         * Doesn't find theone because "alpha 15" isn't a number and we don't
            .setQuery(randomizeType(multiMatchQuery("25 15", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS).analyzer("category")))
            assertThat("query: " + query + " hit: " + i, (double) hits[i].getScore(), closeTo(rHits[i].getScore(), 0.00001d));
            .field("analyzer", "perfect_match")
        );
                randomizeType(
                    "Man the Ultimate Ninja",  
        assertFirstHit(searchResponse, hasId("theone"));  
                    multiMatchQuery("captain america 15", "full_name", "first_name", "last_name", "category", "skill", "int-field").type(
import static org.opensearch.index.query.QueryBuilders.boolQuery;  
                    ? multiMatchQuery("captain america", "full_name", "first_name", "last_name", "category")
import org.opensearch.core.xcontent.XContentBuilder;
        assertHitCount(searchResponse, 1L);
                    "id",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    ).operator(Operator.OR)
        assertThat(topNIds, empty());  
                    multiMatchQuery("captain america marvel hero", "first_name", "last_name", "category").type(  
                randomizeType(
        for (int i = 0; i < hits.length; i++) {  
                    "Ninja",
        // Check that cross fields works with date fields
            T t = RandomPicks.randomFrom(random(), fromList);  
            }
                                .tieBreaker(1.0f)
            .get();
    public void testSingleField() throws NoSuchFieldException, IllegalAccessException {  
                    case CROSS_FIELDS:
            SearchHits hits = multiMatchResp.getHits();
     * `multi_match` query using the fuzziness parameter with a boost on one of two fields returns the  
        searchResponse = client().prepareSearch("test")
        assertFirstHit(searchResponse, hasId("theone"));  
    @Override
    public static Collection<Object[]> parameters() {
                randomizeType(multiMatchQuery("15", "int-field", "first_name", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS))
                SearchResponse left;
                        between(1, 3)
            "america",
/*  
                    "skill",  
        assertNoFailures(right);
        for (int i = 0; i < numDocs; i++) {
            )
                        break;
                )  
        for (int i = 0; i < searchResponse.getHits().getHits().length; i++) {
                MultiMatchQueryBuilder multiMatchQueryBuilder = randomBoolean()
                    ).type(MatchQuery.Type.PHRASE)
                    "marvel hero",
                    )  
                    "Captain America",
        SearchHits rightHits = right.getHits();
        );
                    .setSize(numDocs)
                        }  
        searchResponse = client().prepareSearch("test")
            .endObject()
                        .addSort(SortBuilders.fieldSort("id"))
            .get();
            // the doc id is the tie-breaker

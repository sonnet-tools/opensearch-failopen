                        if (randomBoolean()) {
                            )
import java.util.List;
        assertThat(topNIds, empty());
                    "full_name",
            .setQuery(
            .setQuery(
        searchResponse = client().prepareSearch("test")
            .get();
                assertEquivalent("captain america", left, right);
                            .should(matchPhrasePrefixQuery("category", "capta"))
        assertFirstHit(searchResponse, hasId("theone"));
            .get();
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(randomizeType(multiMatchQuery("15", "skill"))).get();
                        .lenient(true)
        }
                        first,
        assertHitCount(searchResponse, 1L);
        return Arrays.asList(
        } catch (Exception ex) {
        assertThat(searchResponse.getHits().getHits()[0].getScore(), greaterThan(searchResponse.getHits().getHits()[1].getScore()));
            .setQuery(
                    multiMatchQuery("marvel hero captain america", "full_name", "first_name", "last_name", "category").type(
                    multiMatchQuery("captain america marvel hero", "first_name", "last_name", "category").type(
import static org.opensearch.index.query.QueryBuilders.matchPhraseQuery;
            .setQuery(
                        )
                    multiMatchQuery("marvel hero", "first_name", "last_name", "category").operator(Operator.AND)
            );
        assertHitCount(searchResponse, 1L);
            greaterThanOrEqualTo(searchResponse.getHits().getHits()[1].getScore())
                randomizeType(
import static org.opensearch.index.query.QueryBuilders.termQuery;
            )
                        .lenient(true)
                        "skill",
                randomizeType(
            .get();
                )
                        if (randomBoolean()) {
                        .type(type)
import static org.hamcrest.Matchers.equalTo;
    @ParametersFactory
                    .setSize(numDocs)
                )
import org.opensearch.common.settings.Settings;
    public static Collection<Object[]> parameters() {
        assertHitCount(searchResponse, 0L);
        assertThat(searchResponse.getHits().getHits()[0].getScore(), greaterThan(searchResponse.getHits().getHits()[1].getScore()));
import static org.hamcrest.Matchers.anyOf;
            client().prepareIndex("test")
                        Operator.OR
            .get();
                    "",
            .get();
        assertThat(numResults, lessThan(searchResponse.getHits().getTotalHits().value()));
                .put(indexSettings())
         * break on spaces.
                        .type(type)
                        "id",
        assertHitCount(searchResponse, 1L);
                        randomBoolean() ? "marvel hero" : "bogus",
                )
import static org.opensearch.index.query.QueryBuilders.boolQuery;
                            .should(matchQuery("first_name", "captain america").operator(op))
            )
                randomizeType(
import java.util.Arrays;
            .get();
                    multiMatchQuery("alpha 15", "int-field", "first_name", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
                .addSort("_score", SortOrder.DESC)
                .setQuery(matchQueryBuilder)
            SearchResponse multiMatchResp = client().prepareSearch("test")
        builders.add(
            )
            .getHits()
                        .type(MatchQuery.Type.PHRASE)
                    left = client().prepareSearch("test")
            .get();
                                    : matchQuery("full_name", "captain america").operator(op)
                randomizeType(
        );
        }
                // the hits will be sorted the same consistently
        );
        List<IndexRequestBuilder> builders = new ArrayList<>();
                    "full_name",
        while (true) {
                    .setQuery(
        super(staticSettings);
import org.opensearch.common.util.set.Sets;
            for (int j = 0; j < hits.getHits().length; j++) {
                )
                SearchResponse left;
            )
                        break;
                    multiMatchQuery("the ultimate", "full_name", "first_name", "last_name", "category").type(
                randomizeType(
        assertFirstHit(searchResponse, anyOf(hasId("theone"), hasId("theother")));
        searchResponse = client().prepareSearch("test")
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS
                    .setSize(numDocs)
                SearchResponse left = client().prepareSearch("test")
                    .setSource(
            String first = RandomPicks.randomFrom(random(), firstNames);
            )
        assertFirstHit(searchResponse, hasId("ultimate2"));
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS
        );
                        randomizeType(
                                    ? termQuery("full_name", "captain america")
        assertFirstHit(searchResponse, hasId("theother"));
 * specific language governing permissions and limitations
        assertFirstHit(searchResponse, hasId("theone"));
                        .cutoffFrequency(cutoffFrequency)
                    multiMatchQuery("captain america", "full_name", "first_name", "last_name", "category").operator(Operator.AND).type(type)
                    "full_name",
                randomizeType(
         */
                    1
        searchResponse = client().prepareSearch("test")
            )
                    .get();
            "hero",
                        .setQuery(
                    )
                .get();
    }
            )
        assertFirstHit(searchResponse, hasId("theone"));
                        "category",
            "marvel",
                    multiMatchQuery("captain america 15", "skill", "full_name", "first_name", "last_name", "category", "int-field").type(
        assertHitCount(searchResponse, 1L);
                        .get();
        // counter example
                return; // we need to cut off here since this is the tail of the queue and we might not have fetched enough docs
        );
        assertHitCount(searchResponse, 1L);
                switch (type) {
import java.util.Set;
        assertHitCount(searchResponse, 2L);
                        }
        assertThat(searchResponse.getHits().getHits()[0].getScore(), greaterThan(searchResponse.getHits().getHits()[1].getScore()));
                            .add(matchQuery("last_name", "marvel hero captain america"))
                .put("index.analysis.analyzer.category.type", "custom")
                randomizeType(
                        .operator(Operator.AND)
            )
                    multiMatchQuery("marvel hero", "full_name", "first_name", "last_name", "category").operator(Operator.OR)
        assertEquals("2", hits[1].getId());
                .setQuery(multiMatchQueryBuilder)
            .startObject("id")
            "captain",
    public void testCutoffFreq() throws ExecutionException, InterruptedException {
            "ninja" };
                            .should(matchQuery("last_name", "captain america").operator(op))
    private static <T> T randomPickExcept(List<T> fromList, T butNot) {
        assertFirstHit(searchResponse, hasId("theother"));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        int numDocs = scaledRandomIntBetween(50, 100);
            .setQuery(randomizeType(multiMatchQuery("15", "int-field", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)))
            .get();
            .setQuery(
            .setQuery(
        searchResponse = client().prepareSearch("test")
                        )
import static org.opensearch.index.query.QueryBuilders.matchPhrasePrefixQuery;
        long numResults = searchResponse.getHits().getTotalHits().value();
        searchResponse = client().prepareSearch("test")
    }
                )
            .get();
/*
        assertNoFailures(searchResponse);
        List<String> firstNames = new ArrayList<>();
                randomizeType(multiMatchQuery("15", "int-field", "first_name", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS))
            .setQuery(
            .setQuery(
        assertThat(searchResponse.getHits().getHits()[0].getScore(), greaterThan(searchResponse.getHits().getHits()[1].getScore()));
                                ).tieBreaker(1.0f).minimumShouldMatch(minShouldMatch)
     */
            .get();
                )
                        .addSort(SortBuilders.fieldSort("id"))
        fill(lastNames, "Captain", between(3, 7));
                        Operator.OR
 * this file be licensed under the Apache-2.0 license or a
            }
        assertHitCount(searchResponse, 1L);
            .get();
import static org.opensearch.index.query.QueryBuilders.multiMatchQuery;
        assertHitCount(searchResponse, 2L);
            .get();
                    "category",
                    "last_name",
                return builder;
                        .setQuery(
                Operator op = randomBoolean() ? Operator.AND : Operator.OR;
            .get();
        assertFirstHit(searchResponse, hasId("theone"));
            .setSize(0)
 * KIND, either express or implied.  See the License for the
                        .operator(Operator.OR)
        fillRandom(lastNames, between(30, 40));
            }
import org.opensearch.index.query.Operator;
                        randomBoolean() ? MultiMatchQueryBuilder.Type.CROSS_FIELDS : MultiMatchQueryBuilder.DEFAULT_TYPE
                assertEquivalent("capta", left, right);
                )
        return XContentFactory.jsonBuilder()
                    ).operator(Operator.AND)
                    multiMatchQuery("the Ul", "full_name_phrase", "first_name_phrase", "last_name_phrase", "category_phrase").operator(
                    .get();
                    "full_name",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    "Captain",
        searchResponse = client().prepareSearch("test")
            )
        ensureGreen();
    }
                    "skill",
            .setQuery(
        assertEquals("1", hits[0].getId());
        assertFirstHit(searchResponse, hasId("theone"));
            .setQuery(
            "Man",
                .setId("anotherhero")
                        boolQuery().minimumShouldMatch(minShouldMatch)
                multiMatchResp.getHits().getTotalHits().value(),
        assertSecondHit(searchResponse, hasId("ultimate1"));
                )
        // Two numeric fields together caused trouble at one point!
        SearchResponse searchResponse = client().prepareSearch("test")
            )
            .startObject("last_name")
        builders.add(
            .get();
        Float cutoffFrequency = randomBoolean() ? Math.min(1, numDocs * 1.f / between(10, 20)) : 1.f / between(10, 20);
    public void testCrossFieldMode() throws ExecutionException, InterruptedException {
 * not use this file except in compliance with the License.
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS
                SearchResponse right = client().prepareSearch("test")
                    .get();
            .setQuery(
                SearchResponse left = client().prepareSearch("test")
            .get();
        assertFirstHit(searchResponse, hasId("nowHero"));
                                    MatchQuery.Type.PHRASE
        assertFirstHit(searchResponse, hasId("theone"));
                )
                .get();
                        break;
                        break;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
                            oType = MatchQuery.Type.BOOLEAN;
                    "marvel hero",
            "last_name_phrase",
                        .cutoffFrequency(cutoffFrequency)
                                .tieBreaker(1.0f)
import org.opensearch.search.sort.SortOrder;
            searchResponse.getHits().getHits()[0].getScore(),
                    multiMatchQuery("captain america marvel hero", "first_name", "last_name", "category").type(
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import static org.opensearch.index.query.QueryBuilders.matchQuery;
                    )
            .setQuery(
        SearchHits rightHits = right.getHits();
            .get();
            )
                )
        assertFirstHit(searchResponse, hasId("theone"));
                        first + " " + last,
        // Lenient wasn't always properly lenient with two numeric fields
        searchResponse = client().prepareSearch("test")
                .put("index.analysis.analyzer.category.tokenizer", "standard")
        assertFirstHit(searchResponse, hasId("theone"));
 * ownership. Elasticsearch licenses this file to you under
import java.util.concurrent.ExecutionException;
                        .analyzer("category")
                        .addSort(SortBuilders.scoreSort())
                    multiMatchQuery("captain america marvel hero", "first_name", "last_name", "category").type(
            T t = RandomPicks.randomFrom(random(), fromList);
                    .addSort(SortBuilders.scoreSort())
                        i,
        );
import java.io.IOException;
        assertFirstHit(searchResponse, hasId("theone"));
            .get();
            if (type == null && randomBoolean()) {
            client().prepareIndex("test")
                } else {
                    "category",
        assertNoFailures(right);
        SearchHits leftHits = left.getHits();
                    ).operator(Operator.AND)
        builders.add(
            .setQuery(
            {
            .get();
                    multiMatchQuery("marvel hero captain america", "full_name", "first_name", "last_name", "category").operator(Operator.OR)
        searchResponse = client().prepareSearch("test")
            if (field.startsWith("missing")) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                randomizeType(
        // test group based on analyzer -- all fields are grouped into a cross field search
        SearchHit[] hits = searchResponse.getHits().getHits();
                )
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSecondHit;
        assertFirstHit(searchResponse, hasId("theone"));
            client().prepareIndex("test")
                    "America",
            for (int j = 0; j < numTerms; j++) {
            )
            SearchResponse matchResp = client().prepareSearch("test")
            }
            .getTotalHits()
        long size = searchResponse.getHits().getTotalHits().value();
            .setQuery(
            .endObject()
                    .get();
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS
            )
        searchResponse = client().prepareSearch("test")
                    1
                )
            .setQuery(
    private static List<String> fill(List<String> list, String value, int times) {
                    "category",
                randomizeType(
        assertFirstHit(searchResponse, hasId("theone"));
        searchResponse = client().prepareSearch("test")
    private XContentBuilder createMapping() throws IOException {
                        .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
                            randomizeType(
            .setQuery(
    }
                        .analyzer("category")
                .put("index.analysis.analyzer.perfect_match.filter", "lowercase")
            .startObject("full_name")
            )
                    ).operator(Operator.OR)
                SearchResponse right = client().prepareSearch("test")
                    multiMatchQuery("25 15", "int-field", "first_name", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
                    : multiMatchQuery("captain america", "*_name", randomBoolean() ? "category" : "categ*");
        );
                )
            .setQuery(
                )
                    multiMatchQuery("captain america marvel hero", "first_name", "last_name", "category").type(
        }
                    multiMatchQuery("marvel hero captain america", "full_name", "first_name", "last_name", "category").operator(Operator.OR)
                randomizeType(
        assertFirstHit(searchResponse, hasId("theone"));
        SearchResponse searchResponse = client().prepareSearch(idx)
            .get();
        assertAcked(builder.setMapping("title", "type=text", "body", "type=text"));
        Set<String> topNIds = Sets.newHashSet("theone", "theother");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFirstHit;
                            .should(matchPhraseQuery("full_name", "captain america"))
            .get();
                    ).cutoffFrequency(0.1f).analyzer("category").operator(Operator.OR)
    @Override
                randomizeType(
        searchResponse = client().prepareSearch("test")
            .startObject("properties")
        /*
import static org.hamcrest.Matchers.greaterThan;
        assertHitCount(searchResponse, 1L);
                        if (randomBoolean()) {
            .setQuery(
                )
                                randomBoolean()
                .setSource(
                    "skill",
        return list;
                assertEquivalent("captain america", left, right);
                    left = client().prepareSearch("test")
        assertFirstHit(searchResponse, hasId("ultimate1"));
            {
        searchResponse = client().prepareSearch("test")
        for (int i = 0; i < times; i++) {
                .put(SETTING_NUMBER_OF_REPLICAS, 0)
            assertThat(
            topNIds.remove(searchResponse.getHits().getAt(i).getId());
                MatchQuery.Type type = MatchQuery.Type.BOOLEAN;
            MultiMatchQueryBuilder multiMatchQueryBuilder = randomizeType(multiMatchQuery(builder.toString(), field));
package org.opensearch.search.query;
                    "full_name",
                    multiMatchQuery("captain america 15", "full_name", "first_name", "last_name", "category", "skill").type(
    }
                client().prepareIndex("test")
        assertFirstHit(searchResponse, hasId("theone"));
                    "marvel hero",
                    )
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
                    "marvel hero",
        );
                    ? multiMatchQuery("marvel hero captain america", "full_name", "first_name", "last_name", "category")
                    "nowHero",
                    ).analyzer("category").lenient(true).operator(Operator.AND)
                    .setSize(numDocs)
                            .should(matchPhrasePrefixQuery("last_name", "capta"))
            .startObject("date")
            .setQuery(
                        .type(type)
                MultiMatchQueryBuilder multiMatchQueryBuilder = randomBoolean()
                        }
                    "full_name",
            }
                    multiMatchQuery("marvel hero captain america", "full_name", "first_name", "last_name", "category").operator(Operator.OR)
        assertFirstHit(searchResponse, hasId("theone"));
import org.opensearch.index.search.MatchQuery;
            .setQuery(multiMatchQuery("foo").field("title", 100).field("body").fuzziness(Fuzziness.ZERO))
        searchResponse = client().prepareSearch("test")
                randomizeType(
                String minShouldMatch = randomBoolean() ? null : "" + between(0, 1);
                    "Ninja",
 * under the License.
        searchResponse = client().prepareSearch("test")
            }
            )
            // very likely that we hit a random doc that has the same score so orders are random since
            .setQuery(matchAllQuery())
            MultiMatchQueryBuilder.Type type = builder.getType();
 * Licensed to Elasticsearch under one or more contributor
                    .setSize(numDocs)
        searchResponse = client().prepareSearch("test")
                )
        assertFirstHit(searchResponse, hasId("ultimate1"));   // has ultimate in the last_name and that is boosted
                )
            .startObject("category")
        searchResponse = client().prepareSearch("test")
            "last_name",
import org.opensearch.search.SearchHit;
                )
        assertFirstHit(searchResponse, hasId("theone"));
            .setQuery(
                    .addSort(SortBuilders.scoreSort())
                            randomizeType(
                        randomizeType(multiMatchQueryBuilder.operator(op).tieBreaker(1.0f).minimumShouldMatch(minShouldMatch).type(type))
                )
    public void testSingleField() throws NoSuchFieldException, IllegalAccessException {
        String[] fields = {
import static org.hamcrest.Matchers.lessThan;
                    "skill",
                    5
            .field("copy_to", "first_name_phrase")
        int numIters = scaledRandomIntBetween(10, 100);
                    "Alpha the Ultimate Mutant",
            )
                    .setSize(numDocs)
                continue;
                    multiMatchQuery("marvel hero captain america", "full_name", "first_name", "last_name", "category").operator(Operator.OR)
import org.opensearch.action.search.SearchResponse;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                    "first_name",
                            .should(matchPhraseQuery("last_name", "captain america"))
                    "Captain America",
                    )
        assertFirstHit(searchResponse, hasId("theone"));
                    case PHRASE_PREFIX:
                    "first_name",
                assertEquivalent("marvel hero captain america", left, right);
        }
            .setQuery(randomizeType(multiMatchQuery("15", "skill", "int-field")).analyzer("category"))
        searchResponse = client().prepareSearch("test")
                    multiMatchQuery("Captain", "full_name_phrase", "first_name_phrase", "last_name_phrase", "category_phrase").operator(
            .setQuery(randomizeType(multiMatchQuery("25 15", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS).analyzer("category")))
            .setQuery(randomizeType(multiMatchQuery("15", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS).analyzer("category")))
        searchResponse = client().prepareSearch("test")
            .setQuery(
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS
         * Doesn't find theone because "alpha 15" isn't a number and we don't
            .get();
                    "last_name",
        searchResponse = client().prepareSearch("test")
                assertEquals(0, hits.getHits().length);
        }
    public MultiMatchQueryIT(Settings staticSettings) {
                randomizeType(
        SearchResponse searchResponse = client().prepareSearch("test")
     * Test for edge case where field level boosting is applied to field that doesn't exist on documents on
import org.opensearch.common.unit.Fuzziness;
                randomizeType(
                )
        }
}
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            .setQuery(
                    "last_name",
                    "first_name",
            "wolferine",
                    .setQuery(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                )
        final int numDocs = (int) client().prepareSearch("test")
            )
                randomizeType(
                            .add(matchQuery("category", "marvel hero captain america"))
            "full_name",
                    "last_name",
        assertSearchHits(searchResponse, "ultimate2", "ultimate1");
                randomizeType(
                )
import org.opensearch.common.xcontent.XContentFactory;
                        }
            }
        assertFirstHit(searchResponse, hasId("theother"));
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
                        boolQuery().minimumShouldMatch(minShouldMatch)
                type = MultiMatchQueryBuilder.Type.BEST_FIELDS;
                .setId("theone")
    }
                    .addSort(SortBuilders.fieldSort("id"))
                .addSort("_score", SortOrder.DESC)
                    .setSize(numDocs)
                    "bogus",
        assertThat(searchResponse.getHits().getTotalHits().value(), greaterThan(1L));
                randomizeType(
                )
 */
                randomizeType(
        assertFirstHit(searchResponse, hasId("theone"));
            .endObject()
            .get();
        searchResponse = client().prepareSearch("test")
        for (int i = 0; i < numIters; i++) {
        assertHitCount(searchResponse, 1L);
                }
        assertHitCount(searchResponse, 1L);
        }
                )
            )
                SearchResponse left = client().prepareSearch("test")
                // id sort field is a tie, in case hits have the same score,
        ensureGreen();
        searchResponse = client().prepareSearch("test")
import org.opensearch.action.index.IndexRequestBuilder;
        assertHitCount(searchResponse, 1);
        searchResponse = client().prepareSearch("test")
    }
                    .addSort(SortBuilders.scoreSort())
            )
                .setId("ultimate2")
        // counter example
            .get();
        for (int i = 0; i < numIters; i++) {
                        "last_name",
                    ).analyzer("category").operator(Operator.OR)
                    "skill",
                MultiMatchQueryBuilder multiMatchQueryBuilder = randomBoolean()
            .get();
        int numIters = scaledRandomIntBetween(5, 10);
        for (int i = 0; i < searchResponse.getHits().getHits().length; i++) {
                randomizeType(
        final long numDocs = client().prepareSearch("test").setSize(0).setQuery(matchAllQuery()).get().getHits().getTotalHits().value();
        MatchQuery.Type type = MatchQuery.Type.BOOLEAN;
        assertHitCount(searchResponse, 1L);
        assertNotEquals("both documents should be on different shards", hits[0].getShard().getShardId(), hits[1].getShard().getShardId());
        SearchHit[] hits = leftHits.getHits();
                        .type(type)
            .field("analyzer", "category")
            .endObject()
            "17",
                        .analyzer("category")
            .endObject()
        try {
                    multiMatchQuery("the ultimate", "full_name", "first_name", "category").field("last_name", 10)
                    .addSort(SortBuilders.fieldSort("id"))
import org.junit.Before;
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS
                        randomBoolean() ? MultiMatchQueryBuilder.Type.CROSS_FIELDS : MultiMatchQueryBuilder.DEFAULT_TYPE
                    ).analyzer("category").lenient(true).operator(Operator.AND)
                randomizeType(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.plugins.Plugin;
                    "id",
            .setQuery(
        );
            .field("norms", false)
                    .get();
        searchResponse = client().prepareSearch("test")
                    ).type(MatchQuery.Type.PHRASE)
import static org.opensearch.index.query.QueryBuilders.disMaxQuery;
            )
                .addSort("id", SortOrder.ASC)
            "first_name",
                    "marvel",
            list.add(randomAlphaOfLength(5));
        }
                .put("index.analysis.analyzer.category.filter", "lowercase")
                randomizeType(
                    "id",
                // id tie sort
                    "hero",
                    .get();
 * You may obtain a copy of the License at
import org.opensearch.search.sort.SortBuilders;
            StringBuilder builder = new StringBuilder();
            )
    }
            .field("copy_to", "last_name_phrase")
                    .setQuery(
            )
            if (t.equals(butNot)) {
            .get();
                )
                )
                            oType = MatchQuery.Type.PHRASE_PREFIX;
            .get();
                    "id",
                            .should(matchPhraseQuery("first_name", "captain america"))
import static org.hamcrest.Matchers.closeTo;
                    "category",
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS
            )
        assertHitCount(searchResponse, 1L);
    private static MultiMatchQueryBuilder randomizeType(MultiMatchQueryBuilder builder) {
        assertThat(topNIds, empty());
            .field("type", "date")
                    multiMatchQuery("captain america", "full_name", "first_name", "last_name", "category").type(
            .field("type", "text")
                    .addSort(SortBuilders.fieldSort("id"))
                                .minimumShouldMatch(minShouldMatch)
        );
        for (int i = 0; i < times; i++) {
     * one shard. There was an issue reported in https://github.com/elastic/elasticsearch/issues/18710 where a
                )
            String field = RandomPicks.randomFrom(random(), fields);
import static org.hamcrest.Matchers.empty;
                assertThat(hits.getHits()[j].getScore(), equalTo(matchResp.getHits().getHits()[j].getScore()));
                    .addSort(SortBuilders.fieldSort("id"))
        // since we try to treat the matching fields as one field scores are very similar but we have a small bias towards the
            .get();
        // Check that cross fields works with date fields
        SearchHit[] rHits = rightHits.getHits();
                        .addSort(SortBuilders.scoreSort())
                        between(1, 3)
            "marvel",
    }
                assertThat(hits.getHits()[j].getId(), equalTo(matchResp.getHits().getHits()[j].getId()));
                    .setQuery(
        }
            )
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
        for (int i = 0; i < numDocs; i++) {
        assertFirstHit(searchResponse, anyOf(hasId("theone"), hasId("theother")));
            Settings.builder()
                String minShouldMatch = randomBoolean() ? null : "" + between(0, 1);
            list.add(value);
            .get();
                    .setQuery(randomizeType(multiMatchQueryBuilder.operator(Operator.OR).type(type)))
                        .cutoffFrequency(cutoffFrequency)
                    "now sort of",
            )
            .setQuery(
    public void init() throws Exception {
        searchResponse = client().prepareSearch("test")
                    "Man the Ultimate",
        assertFirstHit(searchResponse, anyOf(hasId("theother"), hasId("theone")));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
 * The OpenSearch Contributors require contributions made to
        assertThat(searchResponse.getHits().getHits()[0].getScore(), greaterThan(searchResponse.getHits().getHits()[1].getScore()));
                        boolQuery().minimumShouldMatch(minShouldMatch)
        assertHitCount(searchResponse, 0L);
                    ).analyzer("category").operator(Operator.AND)
            .get();
        }
 *
    }
            )
            }
        for (int i = 0; i < searchResponse.getHits().getHits().length; i++) {
            .field("norms", false)
 * compatible open source license.
            .setQuery(
        searchResponse = client().prepareSearch("test")
                builder.type(oType);
            "category_phrase",
        fill(firstNames, "Captain", between(15, 25));
        // test if boosts work
        for (int i = 0; i < hits.length; i++) {
                    "anotherhero",
                randomizeType(
                        .type(type)
            .endObject()
                randomizeType(
            "america",
        searchResponse = client().prepareSearch("test")
                    "now",
                randomizeType(
            .get();
        // more frequent field that acts as a tie-breaker internally
        List<IndexRequestBuilder> builders = new ArrayList<>();
                )
        assertFirstHit(searchResponse, hasId("theone"));
                .setSource(
                            .should(matchQuery("category", "captain america").operator(op))
        assertNoFailures(searchResponse);
                if (randomBoolean()) {
        assertHitCount(searchResponse, 1L);
                randomizeType(
            .get();
        for (int i = 0; i < hits.length; i++) {
                        .get();
                SearchResponse right = client().prepareSearch("test")
                    "",
                    ).operator(Operator.AND)
            if (hits[i].getScore() == hits[hits.length - 1].getScore()) {
                    .setQuery(
        cutoffFrequency = randomBoolean() ? Math.min(1, numDocs * 1.f / between(10, 20)) : 1.f / between(10, 20);
                )
                    "wolferine",
                        .type(type)
            .get();
                    multiMatchQuery("captain america 15", "first_name", "last_name", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
                                multiMatchQuery("captain america", "full_name", "first_name", "last_name", "category").type(
                    "Man the Ultimate Ninja",
            .get();
/*
            "category",
        assertHitCount(searchResponse, 2L);
            .get();
            {
            .setQuery(
                    multiMatchQuery("captain america marvel hero", "first_name", "last_name", "category").type(
            assertThat("query: " + query, hits[i].getId(), equalTo(rHits[i].getId()));
            )
    @Before
        assertHitCount(searchResponse, 1L);
        assertHitCount(searchResponse, 1L);
                    multiMatchQuery("captain america 15", "full_name", "first_name", "last_name", "category", "skill", "int-field").type(
                    ? multiMatchQuery("captain america", "full_name", "first_name", "last_name", "category")
                    25
        // Test group based on numeric fields
            "1",
            .value();
    private static void assertEquivalent(String query, SearchResponse left, SearchResponse right) {
            .setQuery(
        builders.add(
        assertFirstHit(searchResponse, hasId("theone"));
                }
 * Unless required by applicable law or agreed to in writing,
                    ).type(MatchQuery.Type.PHRASE_PREFIX)
                )
                .setSource(
            "5",
            .endObject()
                    ).analyzer("category").lenient(true).operator(Operator.AND)
            );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
        searchResponse = client().prepareSearch("test")
        MatchQuery.Type type = MatchQuery.Type.BOOLEAN;
                        .setSize(numDocs)
                            .add(matchQuery("first_name", "marvel hero captain america"))
                        .analyzer("category")
                randomizeType(
 * GitHub history for details.
                    15,
            if (randomBoolean()) {
            assertThat("query: " + query + " hit: " + i, (double) hits[i].getScore(), closeTo(rHits[i].getScore(), 0.00001d));
        CreateIndexRequestBuilder builder = prepareCreate("test").setSettings(
            )
        searchResponse = client().prepareSearch("test")
                .addSort("id", SortOrder.ASC)
                    multiMatchQuery("Man the Ultimate", "full_name_phrase", "first_name_phrase", "last_name_phrase", "category_phrase")
                    .addSort(SortBuilders.scoreSort())
        assertFirstHit(searchResponse, hasId("theone"));
                    "first_name",
                    "Alpha the",
    public void testFuzzyFieldLevelBoosting() throws InterruptedException, ExecutionException {
                    "ultimate1",
                        .cutoffFrequency(cutoffFrequency)
        searchResponse = client().prepareSearch("test")
            .field("analyzer", "perfect_match")
        assertSecondHit(searchResponse, hasId("ultimate2"));
                    "first_name",
            )
                        break;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                    "marvel hero",
        indexRandom(true, false, builders);
    }
            return t;
        searchResponse = client().prepareSearch("test")
 * Modifications Copyright OpenSearch Contributors. See
            )
     * same document score if both documents are placed on different shard. This test recreates that scenario
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS
    }
                    "first_name",
        List<String> lastNames = new ArrayList<>();
            }
                            oType = MatchQuery.Type.PHRASE;
                    multiMatchQuery("captain america", "full_name", "first_name", "last_name", "category").operator(Operator.AND)
                            )
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS
                    .addSort(SortBuilders.scoreSort())
                .setSource(
                )
            )
            .get();
            .field("type", "text")
            .get();
                    ).operator(Operator.OR)
            .setQuery(
                    multiMatchQuery("25 15", "int-field", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS).analyzer("category")
                    )
            )
import java.util.Collections;
            .get();
                Object oType = type;
    public void testEquivalence() {
                randomizeType(
                randomizeType(
        assertThat(leftHits.getTotalHits().value(), equalTo(rightHits.getTotalHits().value()));
                        "first_name",
        searchResponse = client().prepareSearch("test")
        CreateIndexRequestBuilder builder = prepareCreate(idx).setSettings(
                            .should(
import org.opensearch.index.query.MultiMatchQueryBuilder;
        assertFirstHit(searchResponse, hasId("theone"));
            topNIds.remove(searchResponse.getHits().getAt(i).getId());
            .endObject();
        searchResponse = client().prepareSearch("test")
                )
                    .addSort(SortBuilders.scoreSort())
                    multiMatchQuery("alpha 15", "first_name", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS).lenient(true)
                    multiMatchQuery("captain america", "full_name", "first_name", "last_name").type(
                )
            int numTerms = randomIntBetween(1, query.length);
                    .get();
                randomizeType(
        builders.add(client().prepareIndex(idx).setId("2").setSource("title", "bar", "body", "foo"));
                )
            // the doc id is the tie-breaker
        searchResponse = client().prepareSearch("test")
            {
        assertFirstHit(searchResponse, anyOf(hasId("theone"), hasId("theother")));
            .setQuery(
        assertHitCount(searchResponse, 1L);
                    "id",
            .get();
                randomizeType(
                equalTo(matchResp.getHits().getTotalHits().value())
                    multiMatchQuery("captain america", "full_name", "first_name", "last_name", "category").operator(Operator.AND)
import org.opensearch.core.xcontent.XContentBuilder;
     * and checks that the returned scores are different.
        assertThat(searchResponse.getHits().getHits()[0].getScore(), greaterThan(searchResponse.getHits().getHits()[1].getScore()));
                MatchQuery.Type type = MatchQuery.Type.BOOLEAN;
                    "last_name",
                )
                "field: " + field + " query: " + builder.toString(),
            .setQuery(randomizeType(multiMatchQuery("now", "f*", "date").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)).lenient(true))
        assertFirstHit(searchResponse, hasId("theone"));
            .endObject()
            .get();
                )
            "15",
                                    MatchQuery.Type.PHRASE
                    multiMatchQuery("marvel hero", "full_name", "first_name", "last_name", "category").type(
                .setId("theother")
                        "full_name",
                    .setQuery(
 * software distributed under the License is distributed on an
                )
            }
                    .addSort(SortBuilders.scoreSort())
    private static List<String> fillRandom(List<String> list, int times) {
            client().prepareIndex("test")
                randomizeType(
            )
                        .cutoffFrequency(cutoffFrequency)
                    "id",
        assertHitCount(searchResponse, 1L);
        }
                .setId("ultimate1")
                .setSource(
        searchResponse = client().prepareSearch("test")
                builder.type(type);
                .put("index.analysis.analyzer.perfect_match.tokenizer", "keyword")
        String idx = "test18710";
            String last = randomPickExcept(lastNames, first);
        cutoffFrequency = randomBoolean() ? Math.min(1, numDocs * 1.f / between(10, 20)) : 1.f / between(10, 20);
            .get();
                        last,
                        .analyzer("category")
            "missing_field",
                    "theone",
                        disMaxQuery().add(matchQuery("full_name", "marvel hero captain america"))
            .setExplain(true)
                    .setId("" + i)
                randomizeType(
                    )
                    "last_name",
            SearchHits hits = multiMatchResp.getHits();
                    "skill",
            "first_name_phrase",
                    multiMatchQuery("marvel hero captain america", "full_name", "first_name", "last_name", "category").operator(Operator.OR)
                    3
                )
            "missing_fields*" };
        searchResponse = client().prepareSearch("test")
        assertFirstHit(searchResponse, hasId("ultimate1"));
        assertFirstHit(searchResponse, hasId("theone"));
            .setQuery(
        SearchResponse searchResponse = client().prepareSearch("test")
                    ).operator(Operator.AND)
                        }
                builder.append(RandomPicks.randomFrom(random(), query)).append(" ");
            .setQuery(
                    "category",
                    "theother",
    }
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        builders.add(client().prepareIndex(idx).setId("1").setSource("title", "foo", "body", "bar"));
import java.util.ArrayList;
        String[] query = {
            .setQuery(
            .startObject("first_name")
 *    http://www.apache.org/licenses/LICENSE-2.0
                    "category",
        fillRandom(firstNames, between(3, 7));
        Set<String> topNIds = Sets.newHashSet("theone", "theother");
                String minShouldMatch = randomBoolean() ? null : "" + between(0, 1);
 *
            .setQuery(randomizeType(multiMatchQuery("15", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)))
            }
            .setQuery(
                            .should(matchPhrasePrefixQuery("first_name", "capta"))
                    case PHRASE:
                    ).operator(Operator.OR)
                .setSource(
            )
                )
            .field("type", "keyword")
                    "marvel hero",
            } else {
                        if (randomBoolean()) {
        assertAcked(builder.setMapping(createMapping()));
        SearchResponse searchResponse = client().prepareSearch("test")
        // check if it's equivalent to a match query.
    }
        searchResponse = client().prepareSearch("test")
            .setQuery(randomizeType(multiMatchQuery("15", "skill", "first_name").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)))
                            multiMatchQuery("capta", "full_name", "first_name", "last_name", "category").type(MatchQuery.Type.PHRASE_PREFIX)
                            .should(matchPhraseQuery("category", "captain america"))
                )
                    multiMatchQuery("25 15", "int-field", "skill", "first_name").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
                )
            .setQuery(
                    "Ultimate Mutant",
    }
                        .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
/*
            if (type == null) {
            // the doc id is the tie-breaker
                        )
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    multiMatchQuery("25 15", "first_name", "int-field", "skill").type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
                    multiMatchQuery("marvel hero", "full_name", "first_name", "last_name", "category").operator(Operator.OR).type(type)
        assertThat(hits[0].getScore(), greaterThan(hits[1].getScore()));
    }
                        .cutoffFrequency(cutoffFrequency)
import java.util.Collection;
        assertThat(leftHits.getHits().length, equalTo(rightHits.getHits().length));
            .get()
        assertNoFailures(left);
            builders.add(
                    case CROSS_FIELDS:
                            oType = MatchQuery.Type.BOOLEAN;
            )
                    )
                    1
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            .setQuery(
                randomizeType(
    /**
        searchResponse = client().prepareSearch("test")
                randomizeType(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            throw new RuntimeException(ex);
                    .addSort(SortBuilders.fieldSort("id"))
                randomizeType(
                        MultiMatchQueryBuilder.Type.CROSS_FIELDS
        assertThat(
        assertFirstHit(searchResponse, hasId("ultimate2"));
            .get();
        fill(firstNames, "Ultimate", between(5, 10));
                SearchResponse right = client().prepareSearch("test")
 * license agreements. See the NOTICE file distributed with
            Settings.builder().put(indexSettings()).put(SETTING_NUMBER_OF_SHARDS, 3).put(SETTING_NUMBER_OF_REPLICAS, 0)
                    case BEST_FIELDS:
                            )
                    "marvel hero",
                    "skill",
                .put("index.analysis.analyzer.perfect_match.type", "custom")
                    multiMatchQuery("captain america", "full_name", "first_name", "last_name", "category").operator(Operator.AND).type(type)
                    .setSize(numDocs)
        searchResponse = client().prepareSearch("test")
            )
public class MultiMatchQueryIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertHitCount(searchResponse, 1L);
                randomizeType(
                                multiMatchQuery("captain america", "full_name", "first_name", "last_name", "category").type(
            .get();
            return builder;
        indexRandom(true, false, builders);
                        break;
        assertThat("common terms expected to be a way smaller result set", size, lessThan(searchResponse.getHits().getTotalHits().value()));
                    .addSort(SortBuilders.fieldSort("id"))
 */
            // very likely that we hit a random doc that has the same score so orders are random since
            .field("type", "text")
            .setQuery(
        return Collections.singleton(MockKeywordPlugin.class);
            .setQuery(
                    case MOST_FIELDS:
        assertFirstHit(searchResponse, hasId("theone"));
            .get();
                    .addSort(SortBuilders.fieldSort("id"))
            "ultimate",
        builders.add(
 */
        assertFirstHit(searchResponse, hasId("theother"));
            .get();
                        .addSort(SortBuilders.fieldSort("id"))
                    "ultimate",
                .setId("nowHero")
            .field("copy_to", "full_name_phrase")
    }
import org.opensearch.index.query.QueryBuilders;
        );
    public void testDefaults() throws ExecutionException, InterruptedException {
        assertFirstHit(searchResponse, hasId("theother"));
        builders.add(
import org.opensearch.test.MockKeywordPlugin;
            client().prepareIndex("test")
                        .setSize(numDocs)
            .field("type", "text")
        searchResponse = client().prepareSearch("test")
                                ).minimumShouldMatch(minShouldMatch)
 * the Apache License, Version 2.0 (the "License"); you may
        searchResponse = client().prepareSearch("test")
            MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(field, builder.toString());
        assertHitCount(searchResponse, 1L);
        return list;
                )
            client().prepareIndex("test")
                .put(SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.index.query.MatchQueryBuilder;
            .startObject()
                    "int-field",
        assertSecondHit(searchResponse, hasId("theone"));
     * `multi_match` query using the fuzziness parameter with a boost on one of two fields returns the
            )
 *
import org.opensearch.search.SearchHits;
            }
                            .should(matchPhrasePrefixQuery("full_name", "capta"))
            }
    public void testPhraseType() {
                    : multiMatchQuery("marvel hero captain america", "*_name", randomBoolean() ? "category" : "categ*");
            .get();

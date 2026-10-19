    }
        assertThat(sh.getAt(0).getId(), equalTo("1"));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                        .field("lat", 11)
        response = client().search(
                    .startObject("test")
        );
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            .endObject()
        );
        assertThat(sh.getAt(1).getId(), equalTo("2"));
        );
            )
        for (int i = 0; i < numDocs - 1; i++) {
        );
            equalTo("ConstantScore(test:value) (_name: query1)")
                        .field("lat", 11)
                    .field("type", "date")
                        functionScoreQuery(
            .setSource(jsonBuilder().startObject().field("test", "value value").field("num", 1.0).endObject())
                        .field("test", "value")
                                FunctionScoreQuery.ScoreMode.MULTIPLY
            .field("type", "double")
                                new FilterFunctionBuilder[] {
            + String.format(Locale.ROOT, "%02d", docDate.getDayOfMonth());
                    .field("type", "date")
    public void testDistanceScoreGeoLinGaussExp() throws Exception {
            assertThat(e.getMessage(), is("all shards failed"));
        assertThat(
        );
                    searchSource().query(
        lonlat.add(10f);
                        )
                            CombineFunction.MULTIPLY
                    .endObject()
                    .endObject()
        client().index(
                    .startObject("properties")
                    .field("lon", 22)
        assertThat(sh.getHits().length, equalTo(numDocs));
                        .endObject()
        assertAcked(
        assertAcked(
                    .field("type", "text")
                    .field("type", "text")
                jsonBuilder().startObject()
                    )
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        );
        }
            + "-"
                                termQuery("test", "value"),
                    .field("type", "text")
        indexBuilders.add(
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));
                        )
            .setSource(jsonBuilder().startObject().field("test", "value value").field("num", 1.0).endObject())
        assertThat(scores[1], lessThan(scores[0]));
        assertThat(sh.getAt(1).getId(), equalTo("2"));
                    .startObject("properties")
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        );
        assertThat((double) sh.getAt(0).getScore(), closeTo(0.5, 1.e-5));
        assertThat(sh.getAt(0).getExplanation().getDetails()[0].getDetails()[1].getDetails()[0].getDetails(), arrayWithSize(2));
                        .startObject("loc")
        assertThat(sh.getAt(0).getId(), anyOf(equalTo("1"), equalTo("2")));
                .setId("1")
 *    http://www.apache.org/licenses/LICENSE-2.0
                        .query(
                    .endObject()
            );
        xContentBuilder.endObject().endObject().endObject();
        );
                .source(jsonBuilder().startObject().field("test", "value").field("num1", "2013-05-30").field("num2", "1.0").endObject())
            )
            indexRequest("test").id("3")
    public void testBoostModeSettingWorks() throws Exception {
import org.opensearch.Version;
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));
                .setIndex("test")
        response = client().search(
                    .endObject()
    }
        client().prepareIndex()
            .setIndex("test")
import java.util.ArrayList;
                    .endObject()
                )
            .setRefreshPolicy(IMMEDIATE)
 * under the License.
        response = client().search(
                .source(
            .setIndex("test")
        assertNoFailures(sr);
        SearchHits sh = sr.getHits();
                        .query(
                jsonBuilder().startObject()
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder.FilterFunctionBuilder;
                    .setId(Integer.toString(i))
        indexBuilders.add(
                    )
                    .startObject("test")
        ActionFuture<SearchResponse> response = client().search(
        assertThat(sh.getTotalHits().value(), equalTo((long) (2)));
                            .field("num", i)
            )
        ActionFuture<SearchResponse> response = client().search(
            client().prepareIndex()
                    jsonBuilder().startObject()
        indexRandom(true, doc1, doc2);
                jsonBuilder().startObject()
        );
                jsonBuilder().startObject()
                    .endObject()
                            .field("lat", 11 + i)
                    .endObject()
import java.time.ZonedDateTime;
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        lonlat.add(20f);
                    searchSource().query(
        double[] scores = new double[numDocs];
                    .startObject("num2")
            client().prepareIndex()
    }
        );
                    functionScoreQuery(baseQuery, gaussDecayFunction("loc", lonlat, "1000km").setMultiValueMode(MultiValueMode.MIN))
    public void testParseDateMath() throws Exception {
        ActionFuture<SearchResponse> response = client().search(
        );
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        client().index(
                    .endObject()
            indexRequest("test").id("2").source(jsonBuilder().startObject().field("test", "value").field("num2", "1.0").endObject())
        );
                )
        client().index(
        response = client().search(searchRequest().searchType(SearchType.QUERY_THEN_FETCH).source(searchSource().query(baseQuery)));
            + String.format(Locale.ROOT, "%02d", docDate.getDayOfMonth());
        sh = sr.getHits();
import org.opensearch.common.lucene.search.function.CombineFunction;
        assertThat(sh.getTotalHits().value(), equalTo((long) (2)));
import static org.opensearch.index.query.QueryBuilders.termQuery;
    }
                .setSource(
        );
                    .endObject()
                            .startObject("loc")
                .setSource(jsonBuilder().startObject().field("test", "value").field("num", 1.7).endObject())
        assertThat(sh.getAt(0).getId(), equalTo("1"));
        client().index(
            .get();
                )
        sr = response.actionGet();
                            )
                .source(
            + "-"
        ActionFuture<SearchResponse> response = client().search(
        ActionFuture<SearchResponse> response = client().search(
                .source(searchSource().query(functionScoreQuery(baseQuery, gaussDecayFunction("loc", lonlat, "1000km"))))
        sr = response.actionGet();
            );
            .get();
                jsonBuilder().startObject()
        sr = client().search(
        );
                        .endObject()
        assertExplain(queryName, functionName, sr);
    public void testCombineModes() throws Exception {
        response = client().search(searchRequest().searchType(SearchType.QUERY_THEN_FETCH).source(searchSource().query(baseQuery)));
                    .endObject()
            )
            client().prepareIndex()
        assertAcked(
                    .field("lon", 20)
        }
 * license agreements. See the NOTICE file distributed with
                searchSource().query(
    public void testCombineModesExplain() throws Exception {
                            )
                .setId("2")
        refresh();
        sh = sr.getHits();
        indexRandomForConcurrentSearch("test");
        assertThat(sh.getAt(0).getId(), equalTo("1"));
        sr = response.actionGet();
                    searchSource().query(
        ).actionGet();
                    .setSource(
                        .field("test", "value value")
        ActionFuture<SearchResponse> response = client().search(
                .source(jsonBuilder().startObject().field("test", "value").field("num1", System.currentTimeMillis()).endObject())
                    .field("type", "geo_point")
                            )
            prepareCreate("test").setSettings(settings)
                )
            int day = (int) (29.0 * (i) / (numDocs)) + 1;
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));
            );
    public void testParsingExceptionIfFieldTypeDoesNotMatch() throws Exception {
            indexRequest("test").id("2").source(jsonBuilder().startObject().field("test", "value").field("num1", "2013-05-28").endObject())
                )
            .setIndex("test")
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        SearchResponse sr = response.actionGet();
                        .field("lon", 20)
                        functionScoreQuery(linearDecayFunction("num", 1, 0.5)).scoreMode(FunctionScoreQuery.ScoreMode.MULTIPLY)
        sr = response.actionGet();
    public static Collection<Object[]> parameters() {
                    searchSource().query(
            sh.getAt(0).getExplanation().getDetails()[0].getDetails()[1].getDetails()[0].getDetails()[0].getDescription(),
    public void testDateWithoutOrigin() throws Exception {
        double[] scores = new double[4];
import org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode;
                .setSource(
                    .endObject()
        assertSearchHits(sr, "1", "2");
        assertAcked(
        indexBuilders.add(
public class DecayFunctionScoreIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertThat(sh.getHits().length, equalTo(4));
/*
 * You may obtain a copy of the License at
        assertThat(sh.getAt(1).getId(), equalTo("2"));
                searchSource().query(
                )
        ActionFuture<SearchResponse> response = client().search(
                    .startObject("geo")
        assertThat(sh.getAt(0).getId(), equalTo("2"));
                    .endObject()
                    jsonBuilder().startObject()
                    .endObject()
        ActionFuture<SearchResponse> response = client().search(
                    .endObject()
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));
        sh = sr.getHits();
        // Test Gauss
                    .field("type", "text")
                    .field("type", "text")
        } catch (SearchPhaseExecutionException e) {
            prepareCreate("test").setMapping(
            indexRequest("test").id("4").source(jsonBuilder().startObject().field("test", "value").field("num1", "2013-05-30").endObject())
                .setSource(
                .source(jsonBuilder().startObject().field("test", "value").field("num1", "2013-05-27").field("num2", "1.0").endObject())
            + String.format(Locale.ROOT, "%02d", docDate.getMonthValue())
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
            .setId("1")
        ).get();
            prepareCreate("test").setMapping(
                .setId("1")
        );
                    .field("type", "text")
        }
                )
                    .endObject()
                        )
                    .field("type", "geo_point")
            indexBuilders.add(
                    .startObject("properties")
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                    .setIndex("test")
        );
                    )
                    )
                )
        assertThat(sh.getAt(1).getId(), equalTo("2"));
        );
                            )
                client().prepareIndex()
                    .startObject("num1")
            .setRefreshPolicy(IMMEDIATE)
                            functionScoreQuery(termQuery("test", "value"), linearDecayFunction("num", 1.0, 20.0, 1.0)).boostMode(
                        .field("test", "value")
            .startObject("geo")
                .source(
                )
            indexRequest("test").id("1").source(jsonBuilder().startObject().field("test", "value").field("num1", "2013-05-27").endObject())
        );
        // Now test AVG and SUM
        assertThat(firstHit.getExplanation().getDetails()[1].getDetails(), arrayWithSize(2));
                    .field("lat", 11)
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        );
                .setIndex("test")
        assertAcked(
                    .endObject()
                jsonBuilder().startObject().field("test", "value").startArray("num").value(0.0).value(1.0).value(2.0).endArray().endObject()
        assertAcked(
                searchSource().query(
        assertThat(scores[2], lessThan(scores[3]));
            );
 */
        response = client().search(
        sr = response.actionGet();
        indexRandomForConcurrentSearch("test");
            .setId("1")
            .setSource(jsonBuilder().startObject().field("test", "value").field("num", 1.0).endObject());
            .startObject("num")
    public void testExceptionThrownIfScaleLE0() throws Exception {
                )
        SearchResponse sr = response.actionGet();
    public void testDistanceScoreGeoLinGaussExplain() throws Exception {
        logger.info("--> Hit[0] {} Explanation:\n {}", sr.getHits().getAt(0).getId(), sr.getHits().getAt(0).getExplanation());
                .source(
            )
                    .field("type", "geo_point")
            .startObject("test")
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));
        List<Float> lonlat = new ArrayList<>();
                    .startObject("test")
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
    }
                    searchSource().query(functionScoreQuery(termQuery("test", "value"), gaussDecayFunction("num1", "2013-05-28", "-1d")))
            + String.format(Locale.ROOT, "%02d", docDate.getMonthValue())
                        ).scoreMode(FunctionScoreQuery.ScoreMode.MULTIPLY)
        refresh();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        // so, we indexed a string field, but now we try to score a num field
                        functionScoreQuery(termQuery("test", "value"), gaussDecayFunction("loc", lonlat, "1000km")).boostMode(
        FunctionScoreQueryBuilder baseQuery = functionScoreQuery(
        SearchHits sh = sr.getHits();
    }
        try {
        // Index for testing MIN and MAX
                    .endObject()
        SearchHits sh = sr.getHits();
        response.actionGet();
                .setId("1")
                        .startObject("test")
        assertThat(sh.getAt(0).getExplanation().getDetails(), arrayWithSize(2));
        refresh();
        IndexRequestBuilder doc2 = client().prepareIndex()
        assertNoFailures(sr);
        assertThat(sh.getAt(1).getId(), anyOf(equalTo("1"), equalTo("2")));
            prepareCreate("test").setMapping(
            assertThat(e.getMessage(), is("all shards failed"));
        int numDummyDocs = 20;
        GeoPoint point = new GeoPoint(20, 11);
        SearchHits sh = sr.getHits();
        List<Float> lonlat = new ArrayList<>();
                        )
            indexRequest("test").id("1").source(jsonBuilder().startObject().field("test", "value").field("num1", docDateString).endObject())
                jsonBuilder().startObject()
        assertOrderedSearchHits(sr, "2", "1");
        ).actionGet();
                    .endObject()
                            .field("date", date)
        sr = response.actionGet();
                .setSource(
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));
                )
                            functionScoreQuery(termQuery("test", "value"), linearDecayFunction("type.geo", lonlat, "1000km")).scoreMode(
            ScoreFunctionBuilders.weightFactorFunction(2, "weight1")
                    .endObject()
        client().prepareIndex()
        // "description": "exp(-0.5*pow(MIN of: [Math.max(arcDistance(10.999999972991645, 21.99999994598329(=doc value),11.0, 20.0(=origin))
                )
                .source(
        sh = sr.getHits();
            prepareCreate("test").setMapping(
                .source(
                .source(
                    .field("lat", 20)
            )
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));
        assertAcked(
                .source(
                    .endObject()
            )
        doc2 = client().prepareIndex()
            containsString("_name: " + functionName)
        SearchResponse sr = client().search(
        );
                            )
                    )
                        .endObject()
        sh = sr.getHits();
            prepareCreate("test").setMapping(
                    .startObject("properties")
        assertThat(scores[0], lessThan(scores[1]));
    public DecayFunctionScoreIT(Settings staticSettings) {
                    .endObject()
        assertThat(firstHit.getExplanation().getDetails(), arrayWithSize(2));
                    .startObject()
        assertAcked(
                    .field("type", "date")
                )
                    )
 * not use this file except in compliance with the License.
                    .startObject("geo")
                        .field("lat", 11)
                        .query(
        SearchHits sh = sr.getHits();
                    .field("type", "text")
        ).actionGet();
                    .field("type", "geo_point")
        );
        for (int i = 1; i <= numDummyDocs; i++) {
        sh = sr.getHits();
        assertThat(firstHit.getExplanation().getDetails()[1].getDetails()[0].getDetails(), arrayWithSize(1));
            searchRequest().source(
import static org.hamcrest.Matchers.is;
                        .field("lat", 10)
                    .startObject("test")
                    searchSource().query(
        assertAcked(
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
                    .startObject("test")
        sh = sr.getHits();
            searchRequest().source(
        indexRandomForConcurrentSearch("test");
                            QueryBuilders.matchAllQuery(),
        SearchResponse sr = response.actionGet();
                    .field("type", "text")
                )
        SearchHit firstHit = sr.getHits().getAt(0);
                    .field("type", "geo_point")
            ScoreFunctionBuilders.weightFactorFunction(randomIntBetween(1, 10))
        assertThat(sh.getAt(1).getId(), anyOf(equalTo("1"), equalTo("2")));
                    searchSource().query(
                )
        assertThat(sh.getTotalHits().value(), equalTo((long) (2)));
                            CombineFunction.REPLACE
            double lat = 100 + (int) (10.0 * (i) / (numDocs));
import org.opensearch.action.search.SearchPhaseExecutionException;
        // Test Exp
        client().index(
            .setId("1")
                )
            .setId("1")
            searchRequest().source(
                        .endObject()
                )
            .setRefreshPolicy(IMMEDIATE)
        );
                    .startObject("num")
        // Test Lin
            scores[Integer.parseInt(sh.getAt(i).getId())] = sh.getAt(i).getScore();
                    .endArray()
                    .endObject()
                        .field("lon", 21)
        assertThat(sh.getTotalHits().value(), equalTo(2L));
        );
                        .field("test", "value")
        assertThat(sh.getAt(0).getId(), equalTo("1"));
        );
            )
            )
        client().index(
        assertThat(sh.getTotalHits().value(), equalTo(2L));
import java.util.Collection;
        lonlat.add(20f);
        sh = sr.getHits();
 */
        );
        assertThat(sh.getAt(0).getId(), equalTo("1"));
            assertThat(sh.getAt(i + 2).getId(), equalTo(Integer.toString(i + 3)));
        client().index(
        indexRandom(true, indexBuilders);
    }
        ActionFuture<SearchResponse> response = client().search(
import org.opensearch.cluster.metadata.IndexMetadata;
                    searchSource().size(numDocs)
    }
            .get();
        assertThat(sh.getAt(1).getScore(), equalTo(sh.getAt(0).getScore()));
        assertThat(sh.getAt(0).getExplanation().getDetails()[0].getDetails()[1].getDetails(), arrayWithSize(2));
        indexRandomForConcurrentSearch("test");
        client().index(
        SearchHits sh = sr.getHits();
                    .field("type", "date")
        assertThat((double) sh.getAt(0).getScore(), closeTo(2.0 + 0.5, 1.e-5));
        assertAcked(prepareCreate("test").setSettings(settings).setMapping(xContentBuilder));
 * this work for additional information regarding copyright
                        .field("type", "text")
            )
        ).actionGet();
                    )
                .setId("1")
                        )
        // Test Exp
                            .startObject("geo")
                jsonBuilder().startObject()
        float[] coords = { 11, 20 };
        SearchHits sh = sr.getHits();
        ActionFuture<SearchResponse> response = client().search(searchRequest().source(searchSource().query(baseQuery)));
        }
import org.opensearch.index.query.functionscore.ScoreFunctionBuilders;
        SearchResponse sr = response.actionGet();
                    .endObject()
        try {
        sr = response.actionGet();
        assertThat(sh.getAt(0).getId(), equalTo("1"));
            String dayString = day < 10 ? "0" + Integer.toString(day) : Integer.toString(day);
                        .endObject()
        return Arrays.asList(
                    searchSource().query(
                )
                            )
        );
    public void testMultiFieldOptions() throws Exception {
        }
            )
        );
            )
                .setIndex("test")
                .source(
                    .endObject()
            constantScoreQuery(termQuery("test", "value")),
        docDate = dt.minusDays(3);
                    .endObject()
        // _name: func2)"
                    .startObject("properties")
        indexBuilders.add(
        sr = response.actionGet();
                jsonBuilder().startObject()
                    .endObject()
        sh = sr.getHits();
        // - 0.0(=offset), 0)],2.0)/7.213475204444817E11, _name: func1)"
            .field("type", "geo_point")
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
                        functionScoreQuery(baseQuery, gaussDecayFunction("num", 0.0, 1.0, null, 0.5)).boostMode(CombineFunction.SUM)
        sh = sr.getHits();
        sr = response.actionGet();
                    .startObject("properties")
            indexRequest("test").source(jsonBuilder().startObject().field("test", "value").field("num", Integer.toString(1)).endObject())
    @ParametersFactory
                searchSource().query(functionScoreQuery(termQuery("test", "value"), gaussDecayFunction("num1", "now", "2d")))
            prepareCreate("test").setMapping(
        ).actionGet();
                        .field("num1", System.currentTimeMillis() - (1000 * 60 * 60 * 24))
 */
    }
        response = client().search(
                )
                    .field("type", "text")
                    .setSource(
                        .query(
                    .startObject("loc")
                        )
            .setId("2")
        client().index(indexRequest("test").source(jsonBuilder().startObject().field("test", "value").field("num", 1.0).endObject()))
        response = client().search(
        assertThat(1.0 - sh.getAt(0).getScore(), closeTo((1.0 - sh.getAt(1).getScore()) / 3.0, 1.e-6d));
        response = client().search(
        assertThat(sh.getAt(0).getId(), equalTo("1"));
    }
import static org.hamcrest.Matchers.arrayWithSize;
        for (int i = 0; i < sh.getHits().length; i++) {
                        .endObject()
        );
        assertNoFailures(sr);
        ActionFuture<SearchResponse> response = client().search(
        assertThat(sh.getTotalHits().value(), equalTo(2L));
        lonlat.add(11f);
            indexBuilders.add(
        client().index(
                client().prepareIndex()
                        .field("test", "value")
                    .endObject()
 * SPDX-License-Identifier: Apache-2.0
            searchRequest().source(
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));
import org.opensearch.core.xcontent.XContentBuilder;
                )
                    )
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
                    jsonBuilder().startObject()
                    .startObject("test")
        try {
        assertThat((double) sh.getAt(0).getScore(), closeTo(2.0, 1.e-5));
        ).actionGet();
        );
                jsonBuilder().startObject()
        indexRandom(true, doc1, doc2);
        sr = response.actionGet();
        assertNoFailures(sr);
import org.opensearch.action.search.SearchType;
                    .startObject("properties")
                            functionScoreQuery(
import org.opensearch.action.index.IndexRequestBuilder;
                        )
                            new FilterFunctionBuilder[] {
            .setIndex("test")
                        .field("lat", 11)
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;
        }
        lonlat.add(100f);
        );
                    )
                        .field("test", "value")
        );
import static org.opensearch.transport.client.Requests.indexRequest;
import static org.hamcrest.Matchers.closeTo;
                    .endObject()
        sr = response.actionGet();
                    .endObject()
            searchRequest().source(
        client().index(
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        response = client().search(
            prepareCreate("test").setMapping(
            prepareCreate("test").setMapping(
            )
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));
        assertThat(sh.getAt(0).getId(), equalTo("1"));
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        // this is equivalent to new GeoPoint(20, 11); just flipped so scores must be same
        assertThat(sh.getAt(0).getId(), anyOf(equalTo("1"), equalTo("2")));
                            .endObject()
            )
        }
        // Test Lin
                        .field("lon", 20)
        assertThat(sh.getAt(0).getId(), anyOf(equalTo("1"), equalTo("2")));
                .source(
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
                    .endObject()
        assertThat(sh.getTotalHits().value(), equalTo((long) (2)));
        );
                                    new FilterFunctionBuilder(linearDecayFunction("date", "2013-05-30", "+15d")),
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
                    searchSource().query(
                        .startObject("loc")
                            baseQuery,
        indexRandomForConcurrentSearch("test");
                client().prepareIndex()
            constantScoreQuery(termQuery("test", "value")).queryName("query1"),
                    .field("type", "text")
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
                searchSource().query(
    }
            indexRequest("test").id("1")
 * software distributed under the License is distributed on an
        assertNoFailures(sr);
        assertThat(sh.getAt(0).getId(), equalTo("1"));
        assertSearchHits(sr, "1", "2");
        sh = sr.getHits();
                        .startObject("loc")
                            .endObject()
        );
                        jsonBuilder().startObject()
                        .endObject()
        assertThat(sh.getAt(0).getId(), equalTo("1"));
                .setMapping(
        client().prepareIndex()
                            functionScoreQuery(termQuery("test", "value"), exponentialDecayFunction("num", 1.0, 5.0, 1.0)).boostMode(
                    .endObject()
                .source(
            .field("type", "text")
            prepareCreate("test").setMapping(
                    .startObject("num1")
                        .query(
        }
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
            assertThat(e.getMessage(), is("all shards failed"));
        );
        assertAcked(
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH).source(searchSource().query(termQuery("test", "value")))
                    .field("type", "double")
        assertThat(sh.getAt(1).getScore(), equalTo(sh.getAt(0).getScore()));
        indexRandomForConcurrentSearch("test");
        );
        sh = sr.getHits();
import org.opensearch.index.query.QueryBuilder;
                    jsonBuilder().startObject()
        assertThat(sh.getAt(0).getId(), equalTo("2"));
        for (int i = 0; i < sh.getHits().length; i++) {
        assertThat((double) sh.getAt(0).getScore(), closeTo(1.0, 1.e-5));
        assertThat(sh.getAt(0).getId(), equalTo("1"));
            sh.getAt(0).getExplanation().getDetails()[1].getDetails()[0].getDetails()[0].getDescription(),
            .setId("1")
        indexBuilders.add(
                    .startObject("test")
                        functionScoreQuery(termQuery("test", "value"), gaussDecayFunction("loc", lonlat, "1000km")).boostMode(
/*
                .setIndex("test")
        sr = response.actionGet();
                        )
                    .endObject()
            .field("doc_values", true)
                jsonBuilder().startObject()
                    searchSource().query(
        indexRandomForConcurrentSearch("test");
                                new FilterFunctionBuilder(linearDecayFunction("num2", "0.0", "1")) }
        assertThat(sh.getAt(0).getId(), equalTo("1"));
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));
                        .startObject("loc")
                    searchSource().query(
                    searchSource().explain(true)
                        .endObject()
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));
                    .field("lon", 23)
        sh = sr.getHits();
                        .endObject()
                    .endObject()
                        .endObject()
        assertExplain(queryName, functionName, sr);
        int numDummyDocs = 20;
 * specific language governing permissions and limitations
                        functionScoreQuery(baseQuery, gaussDecayFunction("num", 0.0, 1.0, null, 0.5)).boostMode(CombineFunction.MULTIPLY)
                        .endObject()
 * Unless required by applicable law or agreed to in writing,
    @Override
    public void testDistanceScoreGeoLinGaussExpWithOffset() throws Exception {
                .source(
                    .field("format", "epoch_millis")
 * GitHub history for details.
                .setSource(
                .source(
                jsonBuilder().startObject()
                    .endObject()
        refresh();
        sr = response.actionGet();
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
                .source(
            indexRequest("test").id("2")
        );
        );
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH).source(searchSource().query(baseQuery))
        ZonedDateTime docDate = dt.minusDays(1);
import org.opensearch.search.MultiValueMode;
import java.util.List;
        assertThat(
        sr = response.actionGet();
                    )
                    functionScoreQuery(baseQuery, gaussDecayFunction("loc", lonlat, "1000km").setMultiValueMode(MultiValueMode.MAX))
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
            .setSource(
        ).actionGet();
            .setIndex("test")
        // decay score should return 0.5 for this function and baseQuery should return 2.0f as it's score
                        .query(
                    .startObject("test")
                        functionScoreQuery(baseQuery, gaussDecayFunction("num", 0.0, 1.0, null, 0.5)).boostMode(CombineFunction.REPLACE)
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
                    searchSource().query(
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.exponentialDecayFunction;
        for (int i = 0; i < numDocs; i++) {
        response = client().search(
        // add docs outside offset
        assertThat(sh.getAt(0).getId(), equalTo("1"));
            containsString("_name: func2")
                        functionScoreQuery(baseQuery, gaussDecayFunction("num", 0.0, 1.0, null, 0.5)).boostMode(CombineFunction.AVG)
        int numDocs = 200;
            response.actionGet();
                .setIndex("test")
        );
        ).actionGet();
                .source(
        );
        );
        // Test Gauss
        FunctionScoreQueryBuilder baseQuery = functionScoreQuery(
        );
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));
                )
                jsonBuilder().startObject()
        );
                    .startObject("num")
        assertThat(scores[2], lessThan(scores[1]));
import java.util.Arrays;
                .setIndex("test")
        ActionFuture<SearchResponse> response = client().search(
        SearchResponse sr = response.actionGet();
        response = client().search(
        sh = sr.getHits();
        refresh();
                        .field("test", "value")
                    .startObject("loc")
                jsonBuilder().startObject()
        indexRandom(true, indexBuilders);
        indexRandomForConcurrentSearch("test");
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
                .setSource(
        );
                )
                    .endObject()
import org.opensearch.common.geo.GeoPoint;
    }
                .source(
                    .endObject()
                    .endObject()
        response = client().search(
                        .field("lon", 20)
                                CombineFunction.MULTIPLY
    public void testParseGeoPoint() throws Exception {
                    .setIndex("test")
                )
        assertOrderedSearchHits(sr, "1", "2");
                            .field("lon", lon)
            indexRequest("test").source(
                        ).scoreMode(FunctionScoreQuery.ScoreMode.MULTIPLY)
                    .startObject("properties")
        lonlat.add(20f);
                    .endObject()
                            .field("test", "value")
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
                jsonBuilder().startObject()
            sh.getAt(0).getExplanation().getDetails()[0].getDetails()[0].getDescription(),
                        functionScoreQuery(
            indexRequest("test").id("1")
                )
        }
            scores[Integer.parseInt(sh.getAt(i).getId()) - 1] = sh.getAt(i).getScore();
        for (int i = 0; i < numDummyDocs; i++) {
            prepareCreate("test").setMapping(
            equalTo("constant score 1.0(_name: weight1) - no function provided")
        );
        assertThat(sh.getAt(0).getId(), equalTo("1"));
                        .endObject()
                .setId("2")
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        assertThat(sh.getAt(0).getExplanation().getDetails()[0].getDetails(), arrayWithSize(2));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        List<Float> lonlat = new ArrayList<>();
        // add tw docs within offset
                    .startObject("num")
                            .endObject()
                        .field("lon", 22)
    protected boolean forbidPrivateIndexSettings() {
        assertThat(sh.getAt(1).getId(), equalTo("2"));
        assertAcked(
        ).get();
        sr = response.actionGet();
                        )
        lonlat.add(100f);
                                new FilterFunctionBuilder(exponentialDecayFunction("num1", null, "7000d")) }
        ).actionGet();
            firstHit.getExplanation().getDetails()[1].getDetails()[0].getDetails()[0].getDescription().toString(),
                .setSource(jsonBuilder().startObject().field("test", "value").field("num", 0.5).endObject())
                    .startObject("num1")
        );
                jsonBuilder().startObject()
        assertThat((double) (sh.getAt(0).getScore()), closeTo((sh.getAt(1).getScore()), 1.e-6d));
        // decay score should return 0.5 for this function and baseQuery should return 2.0f as it's score
        final String functionName = "func1";
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        super(staticSettings);
        docDateString = docDate.getYear()
                    .field("type", "double")
        SearchHits sh = sr.getHits();
            )
            .endObject()
            assertThat(sh.getAt(i + 2).getId(), equalTo(Integer.toString(i + 3)));
            client().prepareIndex()
        assertThat((double) sh.getAt(0).getScore(), closeTo(1.0, 1.e-5));
    public void testNoQueryGiven() throws Exception {
                    .endObject()
                    .endObject()
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));
        assertSearchHits(sr, "1", "2");
            indexBuilders.add(
                    searchSource().query(
        } catch (SearchPhaseExecutionException e) {
                    searchSource().size(numDummyDocs + 2)
        assertThat(sh.getAt(0).getId(), equalTo("1"));
        lonlat.add(110f);
    public void testManyDocsLin() throws Exception {
                    .setIndex("test")
                    .endObject()
                    .endObject()
            .actionGet();
        response = client().search(
        assertThat(sh.getAt(1).getId(), equalTo("2"));
                    .endObject()
                    .startObject("num")
                    .field("type", "text")
                    jsonBuilder().startObject()
package org.opensearch.search.functionscore;
                    )
                    searchSource().query(
                            .field("test", "value")
                    .startObject("loc")
            );
        sr = response.actionGet();
        ).actionGet();
            + String.format(Locale.ROOT, "%02d", docDate.getMonthValue())
            ScoreFunctionBuilders.weightFactorFunction(2)
            .setIndex("test")
                        .field("type", "geo_point")
        );
                .setIndex("test")
 *
        sr = response.actionGet();
            prepareCreate("test").setMapping(
            client().prepareIndex()
        sh = sr.getHits();
        SearchResponse sr = response.actionGet();
        assertThat(sh.getAt(1).getId(), equalTo("2"));
import org.opensearch.search.SearchHits;
        assertThat(sh.getAt(0).getExplanation().getDetails()[1].getDetails()[0].getDetails(), arrayWithSize(1));
        assertAcked(
                        )
        response = client().search(
            )
                .source(
                        .query(
                    .field("type", "text")
        response = client().search(
                    .endObject()
        // Test Gauss
        sh = sr.getHits();
        for (int i = 0; i < numDummyDocs; i++) {
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
            indexRequest("test").id("3").source(jsonBuilder().startObject().field("test", "value").field("num1", docDateString).endObject())
            .setIndex("test")
                            new FilterFunctionBuilder[] {
        );
                                    new FilterFunctionBuilder(linearDecayFunction("num", numDocs, numDocs / 2.0)) }
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Locale;
                    )
                .source(
                    .endObject()
                        .endObject()
                            .endObject()
            + "-"
                    searchSource().explain(true)
        SearchResponse sr = response.actionGet();
                    functionScoreQuery(baseQuery, linearDecayFunction("num", "0", "10").setMultiValueMode(MultiValueMode.SUM))
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
                    searchSource().explain(true)
            .endObject()
        Settings settings = Settings.builder().put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1).build();
                .source(
                    )
        assertThat(sh.getAt(1).getId(), equalTo("1"));
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));
    }
                .setId("2")
                    .startObject("num")
                            functionScoreQuery(termQuery("test", "value"), gaussDecayFunction("num", 1.0, 5.0, 1.0)).boostMode(
            prepareCreate("test").setMapping(
            fail("Expected SearchPhaseExecutionException");
        response = client().search(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
        assertThat((double) sh.getAt(0).getScore(), closeTo((2.0 + 0.5) / 2, 1.e-5));
import org.opensearch.action.search.SearchResponse;
                    .startObject("test")
                                    new FilterFunctionBuilder(linearDecayFunction("geo", lonlat, "1000km")),
        );
                        .endObject()
                        .field("lon", 22)
                .setId("2")
                .source(searchSource().query(functionScoreQuery(baseQuery, linearDecayFunction("loc", lonlat, "1000km"))))
 * Modifications Copyright OpenSearch Contributors. See
                    .endObject()
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
                    functionScoreQuery(baseQuery, linearDecayFunction("num", "0", "10").setMultiValueMode(MultiValueMode.AVG))
        client().index(
                        functionScoreQuery(termQuery("test", "value"), linearDecayFunction("num", 1.0, 0.5)).scoreMode(ScoreMode.MULTIPLY)
            scores[Integer.parseInt(sh.getAt(i).getId()) - 1] = sh.getAt(i).getScore();
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
            .setSource(
        indexRandom(true, indexBuilders);
import static org.hamcrest.Matchers.anyOf;
    }
        assertAcked(
        assertThat(sh.getAt(1).getId(), anyOf(equalTo("1"), equalTo("2")));
        SearchHits sh = sr.getHits();
            + "-"
                    .endObject()
        indexBuilders.add(
                        .query(
        sh = sr.getHits();
 * KIND, either express or implied.  See the License for the
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        assertThat(sh.getAt(1).getId(), equalTo("1"));
                    .startObject("loc")
        assertSearchHits(sr, "1", "2");
import static org.hamcrest.Matchers.equalTo;
        assertThat(
                        functionScoreQuery(baseQuery, gaussDecayFunction("num", 0.0, 1.0, null, 0.5)).boostMode(CombineFunction.MIN)
        ).actionGet();
                                CombineFunction.REPLACE
                        .endObject()
                    .field("test", "value")
    private void assertExplain(final String queryName, final String functionName, SearchResponse sr) {
        int numDocs = 2;
        indexBuilders.add(
            + String.format(Locale.ROOT, "%02d", docDate.getDayOfMonth());
        ZonedDateTime dt = ZonedDateTime.now(ZoneOffset.UTC);
                    .startObject("num")
                    .endObject()
                                exponentialDecayFunction("loc", lonlat, "1000km", functionName)
            indexRequest("test").id("2").source(jsonBuilder().startObject().field("test", "value").field("num1", docDateString).endObject())
    }
                        .query(
                    .field("type", "text")
import org.opensearch.search.SearchHit;
    }
                jsonBuilder().startObject()
 * ownership. Elasticsearch licenses this file to you under
                    .field("lon", 2)
        client().index(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertOrderedSearchHits;
                    .setId(Integer.toString(i + 3))
        ).actionGet();
                    .field("lat", 1)
import org.opensearch.common.action.ActionFuture;
        assertThat(firstHit.getExplanation().getDetails()[0].getDescription().toString(), containsString("_name: " + queryName));
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
    }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        IndexRequestBuilder doc1 = client().prepareIndex()
            client().prepareIndex()
        refresh();
                    searchSource().query(
                            functionScoreQuery(baseQuery.queryName(queryName), linearDecayFunction("loc", lonlat, "1000km", functionName))
                    .setSource(jsonBuilder().startObject().field("test", "value").field("num", 3.0 + i).endObject())
        } catch (SearchPhaseExecutionException e) {
                    .endObject()
    }
                            ).scoreMode(ScoreMode.MULTIPLY).boostMode(CombineFunction.REPLACE)
        indexBuilders.add(
                    )
                .source(
 *
        response = client().search(
        // "description": "*:* (_name: query1)"
                .source(
        }
        assertSearchHits(sr, "1", "2");
            .setSource(
        double[] scores = new double[4];
        final String queryName = "query1";
        assertThat(sh.getAt(1).getId(), equalTo("2"));
                    .endObject()
    }
        doc1 = client().prepareIndex()
        );
                    .field("type", "double")
        String docDateString = docDate.getYear()
        List<Float> lonlat = new ArrayList<>();
        assertExplain(queryName, functionName, sr);
                    .startObject("properties")
 * compatible open source license.
        sr = response.actionGet();
        }
        lonlat.add(11f);
                )
                    .startObject("test")
                    .startObject("properties")
            searchRequest().source(
 * The OpenSearch Contributors require contributions made to
            .startObject("date")
                    .endObject()
                        functionScoreQuery(baseQuery, gaussDecayFunction("loc", coords, "1000km")).boostMode(CombineFunction.REPLACE)
                    searchSource().size(numDummyDocs + 2)
    private final QueryBuilder baseQuery = constantScoreQuery(termQuery("test", "value"));
 *
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));
        sr = response.actionGet();
                    .startObject("test")
                            functionScoreQuery(
                    .endObject()
        assertThat((double) sh.getAt(0).getScore(), closeTo(1.0f, 1.e-5));
                )
        response = client().search(
    public void testValueMissingLin() throws Exception {
                                CombineFunction.REPLACE
        List<Float> lonlat = new ArrayList<>();
                    .endObject()
        sh = sr.getHits();
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.linearDecayFunction;
        sh = sr.getHits();
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
                .source(
        // "description": "exp(-0.5*pow(MIN[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)],2.0)/0.7213475204444817,
        assertAcked(
        }
            response.actionGet();
        assertThat(sh.getAt(0).getId(), equalTo("1"));
        );
        lonlat.add(20f);
        // Test Gauss
                    .field("test", "value")
            client().prepareIndex()
            + "-"
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
                        .startObject("loc")
        client().index(
        );
                                baseQuery.queryName(queryName),
                    .endObject()
        assertAcked(
        // so, we indexed a string field, but now we try to score a num field
                                CombineFunction.REPLACE
        );
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
                    .field("type", "text")
        assertThat(sh.getAt(1).getId(), equalTo("1"));
        assertThat(
        SearchResponse sr = response.actionGet();
                    .endObject()
import org.opensearch.common.settings.Settings;
import org.opensearch.test.VersionUtils;
                        .startObject("properties")
                    .endObject()
                    .endObject()
                        .startObject("loc")
        assertThat(sh.getAt(1).getScore(), equalTo(sh.getAt(0).getScore()));
            .setSource(
                            .field("lat", lat)
        sr = response.actionGet();
                        .startObject("loc")
                            functionScoreQuery(baseQuery.queryName(queryName), gaussDecayFunction("loc", lonlat, "1000km", functionName))
            )
        SearchResponse sr = response.actionGet();
            .setId("2")
                )
                jsonBuilder().startObject()
 * Licensed to Elasticsearch under one or more contributor
        );
                    .field("test", "value")
                searchSource().query(functionScoreQuery(termQuery("test", "value"), gaussDecayFunction("num1", "now-1d", "2d")))
                )
                    .endObject()
                        )
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));
                    .startArray("loc")
        indexRandom(true, false, indexBuilders); // force no dummy docs
            )
        FunctionScoreQueryBuilder baseQuery = functionScoreQuery(
                )
            double lon = 100;
            .field("ignore_malformed", true);
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
                .source(
                    jsonBuilder().startObject()
        SearchHits sh = sr.getHits();
                    searchSource().explain(true)
                        functionScoreQuery(baseQuery, gaussDecayFunction("num", 0.0, 1.0, null, 0.5)).boostMode(CombineFunction.MAX)
        response = client().search(
            .startObject("properties")
                    .field("lon", 11)
                    .endObject()
                    .startObject("loc")
        indexRandom(true, indexBuilders);
                )
        lonlat.add(11f);
}
            )
            prepareCreate("test").setMapping(
        ActionFuture<SearchResponse> response = client().search(
        );
                        functionScoreQuery(baseQuery, gaussDecayFunction("loc", point, "1000km")).boostMode(CombineFunction.REPLACE)
                        .field("lat", 10)
                .source(
            .field("type", "date")
        );
                    .field("type", "double")
 * this file be licensed under the Apache-2.0 license or a
                )
                    .startObject()
            fail("Expected SearchPhaseExecutionException");
            String date = "2013-05-" + dayString;
                jsonBuilder().startObject()
        );
                    )
import static org.opensearch.transport.client.Requests.searchRequest;
import org.opensearch.index.query.QueryBuilders;
                    .field("type", "text")
        assertThat((double) sh.getAt(0).getScore(), closeTo(0.5, 1.e-5));
        sh = sr.getHits();
import java.time.ZoneOffset;
                    .endObject()
                    .endObject()
            client().prepareIndex()
        ).actionGet();
import static org.hamcrest.Matchers.lessThan;
        ActionFuture<SearchResponse> response = client().search(
                    )
                    .endObject()
        // Test Exp
            )
        docDate = dt.minusDays(2);
            )
                    searchSource().size(numDocs)
            );
        assertThat(sh.getHits().length, equalTo(3));
                    .startObject("properties")
                    .setId(Integer.toString(i + 3))
            .field("doc_values", true)
        // "description": "ConstantScore(test:value) (_name: query1)"
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.gaussDecayFunction;
                )
                    searchSource().size(numDummyDocs + 2)
                .source(searchSource().query(functionScoreQuery(baseQuery, exponentialDecayFunction("loc", lonlat, "1000km"))))
                )
        sh = sr.getHits();
                    .startObject("properties")
        assertThat(sh.getAt(0).getId(), equalTo("1"));
import static org.hamcrest.Matchers.containsString;
        );
                    .field("type", "double")
        SearchResponse sr = response.actionGet();
        assertThat(sh.getAt(0).getId(), equalTo("2"));
                )
                        jsonBuilder().startObject()
                                new FilterFunctionBuilder(linearDecayFunction("num1", null, "7000d")),
                    .endObject()
            )
        indexRandomForConcurrentSearch("test");
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
                    .startObject("properties")
/*
                        .endObject()
                .source(
                    .field("lat", 12)
                    jsonBuilder().startObject()
        for (int i = 0; i < numDocs; i++) {
        sr = response.actionGet();
                        .endObject()
                    .endObject()
            assertThat(scores[i], lessThan(scores[i + 1]));
        docDateString = docDate.getYear()
                    .startObject("test")
            prepareCreate("test").setMapping(
        List<Float> lonlat = new ArrayList<>();
        assertThat(sh.getAt(0).getExplanation().getDetails()[1].getDetails(), arrayWithSize(2));
        refresh();
        );
        );
        // "description": "constant score 1.0(_name: func1) - no function provided"
        );
        indexRandomForConcurrentSearch("test");
                )
                            functionScoreQuery(baseQuery, gaussDecayFunction("num", 0.0, 1.0, null, 0.5, "func2")).boostMode(
            fail("Expected SearchPhaseExecutionException");
    public void testParsingExceptionIfFieldDoesNotExist() throws Exception {
        SearchResponse sr = response.actionGet();
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));
                    .field("test", "value")
                    .startObject("loc")
                    jsonBuilder().startObject()
import static org.opensearch.search.builder.SearchSourceBuilder.searchSource;
                            .field("lon", 22 + i)
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));
                    .startObject("test")
        );
            + "-"
                    .startObject("num1")
                    .startObject("properties")
                                new FilterFunctionBuilder(linearDecayFunction("num1", "2013-05-28", "+3d")),
                                new FilterFunctionBuilder(gaussDecayFunction("num1", null, "1d")),
            constantScoreQuery(termQuery("test", "value")),
            response.actionGet();
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
        // "description": "random score function (seed: 12345678, field: _seq_no, _name: func1)"
                    .endObject()
        assertThat(sh.getAt(0).getId(), equalTo("1"));
                    .field("lat", 10)
                    .startObject("test")
        return false;
    }
                    .endObject()
        for (int i = 0; i < numDummyDocs; i++) {
        lonlat.add(110f);
        SearchHits sh = sr.getHits();
        assertThat(sh.getAt(1).getId(), equalTo("2"));
        response = client().search(
        XContentBuilder xContentBuilder = jsonBuilder().startObject()
                )
        ActionFuture<SearchResponse> response = client().search(
        );
                .setIndex("test")
                    .field("type", "float")
                    .endObject()

        assertThat(sh.getAt(0).getId(), equalTo("1"));
                jsonBuilder().startObject()
            containsString("_name: func2")  
                    .field("type", "date")
            );  
        assertThat(1.0 - sh.getAt(0).getScore(), closeTo((1.0 - sh.getAt(1).getScore()) / 3.0, 1.e-6d));
        );
                    .startObject("test")  
                    .endObject()
                    searchSource().size(numDummyDocs + 2)  
        ActionFuture<SearchResponse> response = client().search(
        SearchHits sh = sr.getHits();
 * license agreements. See the NOTICE file distributed with
                        .startObject("loc")  
            equalTo("ConstantScore(test:value) (_name: query1)")  
                        .endObject()
                    jsonBuilder().startObject()  
        assertThat(scores[2], lessThan(scores[1]));  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        assertThat(sh.getAt(0).getId(), equalTo("1"));
                        .endObject()
        IndexRequestBuilder doc2 = client().prepareIndex()
        docDate = dt.minusDays(3);
                        .endObject()
                    .endObject()  
            .setId("1")
        response = client().search(  
        doc1 = client().prepareIndex()
                        )  
        // Test Exp
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                    )
        );
                    .endObject()
                )
        ActionFuture<SearchResponse> response = client().search(searchRequest().source(searchSource().query(baseQuery)));
        float[] coords = { 11, 20 };  
            prepareCreate("test").setMapping(  
            prepareCreate("test").setMapping(
            ScoreFunctionBuilders.weightFactorFunction(randomIntBetween(1, 10))  
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
import org.opensearch.action.search.SearchResponse;  
                    .startObject("test")  
                    .endObject()
                            functionScoreQuery(
                    .field("lon", 22)  
        SearchHits sh = sr.getHits();
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));
        sr = response.actionGet();  
        assertThat(sh.getAt(0).getId(), equalTo("2"));
        sh = sr.getHits();  
                            )
        response = client().search(
                    .field("type", "text")
        );
                .source(
                        functionScoreQuery(baseQuery, gaussDecayFunction("num", 0.0, 1.0, null, 0.5)).boostMode(CombineFunction.MULTIPLY)  
    public void testParsingExceptionIfFieldTypeDoesNotMatch() throws Exception {
                    .endObject()  
                        .query(
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
                .source(
            response.actionGet();  
        } catch (SearchPhaseExecutionException e) {
                )
        assertThat(sh.getAt(0).getId(), equalTo("1"));  
        );  
                .setMapping(
        response = client().search(
                    searchSource().query(  
        assertThat(sh.getAt(1).getId(), equalTo("2"));
        SearchHits sh = sr.getHits();  
        SearchHits sh = sr.getHits();
        );
        sr = response.actionGet();
        ActionFuture<SearchResponse> response = client().search(
                    .startObject("properties")
                                CombineFunction.REPLACE  
                    .endObject()
                .setIndex("test")
                    .startObject("test")
                .source(
                    .endObject()
        assertThat(sh.getTotalHits().value(), equalTo(2L));
            assertThat(e.getMessage(), is("all shards failed"));  
            prepareCreate("test").setSettings(settings)
                        .field("type", "geo_point")  
        lonlat.add(11f);
                        .query(  
    public void testCombineModes() throws Exception {
                        .endObject()  
                    searchSource().query(
    public void testNoQueryGiven() throws Exception {
                            new FilterFunctionBuilder[] {
                        )
        client().index(
                    .startObject("loc")  
        response = client().search(  
        lonlat.add(11f);  
                    .endObject()
        assertThat(scores[2], lessThan(scores[3]));
                                CombineFunction.REPLACE
                    .startObject("test")
                    .endObject()
            equalTo("constant score 1.0(_name: weight1) - no function provided")
                    .endObject()
        int numDummyDocs = 20;  
                client().prepareIndex()
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
                )  
            client().prepareIndex()  
                .source(  
                    .startObject("properties")  
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.linearDecayFunction;  
                        ).scoreMode(FunctionScoreQuery.ScoreMode.MULTIPLY)
        try {  
                        .startObject("loc")
                                    new FilterFunctionBuilder(linearDecayFunction("date", "2013-05-30", "+15d")),
            indexRequest("test").id("2").source(jsonBuilder().startObject().field("test", "value").field("num2", "1.0").endObject())  
                .source(  
        );
                )
                    jsonBuilder().startObject()
        );  
            response.actionGet();
import org.opensearch.index.query.functionscore.ScoreFunctionBuilders;
        client().index(indexRequest("test").source(jsonBuilder().startObject().field("test", "value").field("num", 1.0).endObject()))
import org.opensearch.common.lucene.search.function.FunctionScoreQuery.ScoreMode;
        List<Float> lonlat = new ArrayList<>();
            .setIndex("test")  
    }  
                .setSource(  
    }
        List<Float> lonlat = new ArrayList<>();
                .setIndex("test")
                    .endObject()
        sr = response.actionGet();
        SearchHits sh = sr.getHits();  
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));
import java.util.Locale;  
        // Test Exp  
                        .endObject()  
                )  
        assertThat(sh.getAt(1).getId(), equalTo("2"));
                            .field("num", i)
        assertThat(sh.getAt(0).getId(), equalTo("1"));
                            CombineFunction.REPLACE  
        indexRandom(true, indexBuilders);  
        assertThat((double) sh.getAt(0).getScore(), closeTo(2.0 + 0.5, 1.e-5));  
            prepareCreate("test").setMapping(  
 */
            client().prepareIndex()
                    .startObject("num")  
        sh = sr.getHits();
        response = client().search(  
        for (int i = 0; i < sh.getHits().length; i++) {  
        int numDocs = 200;
                .source(
            prepareCreate("test").setMapping(
                        )
            double lon = 100;  
        client().prepareIndex()  
    }  
        sh = sr.getHits();  
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));
        );
        // Index for testing MIN and MAX  
            .startObject("geo")
        SearchHits sh = sr.getHits();
            assertThat(scores[i], lessThan(scores[i + 1]));
                .source(
        ActionFuture<SearchResponse> response = client().search(
                )  
        indexBuilders.add(  
                searchSource().query(functionScoreQuery(termQuery("test", "value"), gaussDecayFunction("num1", "now-1d", "2d")))  
                        .startObject("loc")
        sh = sr.getHits();  
        indexRandom(true, false, indexBuilders); // force no dummy docs  
        sh = sr.getHits();
                )
import java.util.ArrayList;
                    .startObject("properties")
        ).actionGet();  
        refresh();
        indexBuilders.add(
        sh = sr.getHits();
import org.opensearch.search.MultiValueMode;  
                .setSource(  
                    .endObject()
                                CombineFunction.REPLACE  
        // so, we indexed a string field, but now we try to score a num field
            .endObject()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );  
        // Test Lin
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        );
            .setId("1")
                    )  
        assertThat(sh.getAt(0).getId(), anyOf(equalTo("1"), equalTo("2")));  
                    .field("type", "geo_point")
            )
        );  
                            new FilterFunctionBuilder[] {  
                    .setIndex("test")
        refresh();  
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
                    .field("type", "geo_point")
        ActionFuture<SearchResponse> response = client().search(  
        assertThat(sh.getAt(0).getExplanation().getDetails()[0].getDetails()[1].getDetails()[0].getDetails(), arrayWithSize(2));  
        assertThat(sh.getTotalHits().value(), equalTo(2L));  
        assertAcked(
        List<Float> lonlat = new ArrayList<>();  
                client().prepareIndex()  
                jsonBuilder().startObject()
        assertThat(firstHit.getExplanation().getDetails()[0].getDescription().toString(), containsString("_name: " + queryName));  
                        .endObject()
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
                )
import static org.opensearch.transport.client.Requests.searchRequest;
        assertThat(  
        client().index(
        assertThat(sh.getAt(1).getId(), equalTo("2"));  
        // _name: func2)"
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;  
        assertThat(sh.getAt(1).getId(), equalTo("2"));
                    .startObject("properties")
        assertThat(sh.getAt(0).getId(), equalTo("1"));  
        assertSearchHits(sr, "1", "2");
                    .field("type", "text")
            constantScoreQuery(termQuery("test", "value")),
                                    new FilterFunctionBuilder(linearDecayFunction("geo", lonlat, "1000km")),  
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;  
            double lat = 100 + (int) (10.0 * (i) / (numDocs));
    }  
        client().index(
            .setSource(jsonBuilder().startObject().field("test", "value value").field("num", 1.0).endObject())
        // Test Lin
                        .field("test", "value")  
        assertSearchHits(sr, "1", "2");  
                )  
        assertThat(sh.getAt(0).getId(), equalTo("1"));  
        indexRandomForConcurrentSearch("test");
            .setSource(
            .setIndex("test")
                    .field("type", "date")
            )  
                    searchSource().query(  
            )
                    .startObject("loc")
            prepareCreate("test").setMapping(  
                    searchSource().explain(true)
                    searchSource().query(  
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));
                .setId("2")  
        ).actionGet();
                )
                    .field("type", "text")  
                    .startObject("num")
        );
import org.opensearch.Version;  
                    )
                    .field("type", "float")
                    .endObject()
        // "description": "exp(-0.5*pow(MIN[Math.max(Math.abs(1.0(=doc value) - 0.0(=origin))) - 0.0(=offset), 0)],2.0)/0.7213475204444817,  
import java.time.ZonedDateTime;
                        .field("lat", 11)
            client().prepareIndex()
 */  
        client().prepareIndex()
                    .endObject()
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        assertThat(sh.getAt(1).getId(), equalTo("2"));
        SearchResponse sr = response.actionGet();  
                    .endObject()
            + "-"  
        SearchResponse sr = response.actionGet();  
        ).actionGet();  
                    .endObject()
            .setIndex("test")  
                jsonBuilder().startObject()
                )  
        );
                    jsonBuilder().startObject()  
        sr = response.actionGet();
                    .field("lat", 1)
    public void testParsingExceptionIfFieldDoesNotExist() throws Exception {
                    .field("test", "value")
            indexRequest("test").source(
        indexRandom(true, indexBuilders);  
                        .startObject("loc")
                .setSource(
                    .endObject()  
        sr = response.actionGet();  
                jsonBuilder().startObject()
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
                        .endObject()
                .source(  
                        )  
        indexRandomForConcurrentSearch("test");
        FunctionScoreQueryBuilder baseQuery = functionScoreQuery(
                .setId("2")
                        jsonBuilder().startObject()
                            .startObject("loc")  
        ActionFuture<SearchResponse> response = client().search(
        assertThat((double) sh.getAt(0).getScore(), closeTo(0.5, 1.e-5));
        assertExplain(queryName, functionName, sr);
        );  
        assertThat(sh.getAt(1).getId(), anyOf(equalTo("1"), equalTo("2")));
        } catch (SearchPhaseExecutionException e) {  
        xContentBuilder.endObject().endObject().endObject();
            + "-"  
        SearchHits sh = sr.getHits();
        // Test Gauss
        assertThat(sh.getAt(0).getExplanation().getDetails()[0].getDetails(), arrayWithSize(2));
        // Test Gauss
                .source(
        assertAcked(
        sh = sr.getHits();
                        functionScoreQuery(baseQuery, gaussDecayFunction("loc", point, "1000km")).boostMode(CombineFunction.REPLACE)
                    searchSource().explain(true)
                    .endObject()
import org.opensearch.action.index.IndexRequestBuilder;
        lonlat.add(110f);
                    .endObject()
        sr = response.actionGet();
        );
        assertAcked(
        client().prepareIndex()
            )
                .setSource(
        ).actionGet();  
import org.opensearch.action.search.SearchPhaseExecutionException;
        assertThat((double) sh.getAt(0).getScore(), closeTo((2.0 + 0.5) / 2, 1.e-5));  
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        try {
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));
                .source(  
                            .endObject()
        assertAcked(
            String dayString = day < 10 ? "0" + Integer.toString(day) : Integer.toString(day);
            assertThat(e.getMessage(), is("all shards failed"));
                    .endObject()
        );
        assertThat(sh.getHits().length, equalTo(numDocs));
        lonlat.add(20f);  
        );
 * this work for additional information regarding copyright
 *
            client().prepareIndex()  
                    functionScoreQuery(baseQuery, linearDecayFunction("num", "0", "10").setMultiValueMode(MultiValueMode.SUM))
        sh = sr.getHits();  
import org.opensearch.common.lucene.search.function.CombineFunction;
                        .endObject()
            indexRequest("test").source(jsonBuilder().startObject().field("test", "value").field("num", Integer.toString(1)).endObject())
                            baseQuery,  
            indexRequest("test").id("2")
            client().prepareIndex()
                        .field("test", "value")  
            prepareCreate("test").setMapping(  
                    searchSource().size(numDummyDocs + 2)  
        assertSearchHits(sr, "1", "2");
        response = client().search(searchRequest().searchType(SearchType.QUERY_THEN_FETCH).source(searchSource().query(baseQuery)));
            fail("Expected SearchPhaseExecutionException");
        SearchResponse sr = client().search(
                    .endObject()
                        .field("lon", 20)
                    searchSource().query(
        assertExplain(queryName, functionName, sr);
                        .field("lat", 10)
        );
}
        response = client().search(
        }
        );
                        functionScoreQuery(baseQuery, gaussDecayFunction("num", 0.0, 1.0, null, 0.5)).boostMode(CombineFunction.AVG)
                .source(
                .setIndex("test")
        sh = sr.getHits();  
                    .endObject()
                    .field("format", "epoch_millis")  
                    .endObject()
        );
        assertThat(sh.getAt(0).getId(), equalTo("1"));
import org.opensearch.action.search.SearchType;
            fail("Expected SearchPhaseExecutionException");
            .setSource(
        List<Float> lonlat = new ArrayList<>();  
            + String.format(Locale.ROOT, "%02d", docDate.getDayOfMonth());
                        functionScoreQuery(baseQuery, gaussDecayFunction("num", 0.0, 1.0, null, 0.5)).boostMode(CombineFunction.REPLACE)
                    .endArray()
                    .endObject()
                    .field("type", "text")
                    .field("lon", 11)
        assertThat(sh.getAt(0).getId(), anyOf(equalTo("1"), equalTo("2")));
                    .field("type", "geo_point")
                .setId("1")
        ZonedDateTime docDate = dt.minusDays(1);
            firstHit.getExplanation().getDetails()[1].getDetails()[0].getDetails()[0].getDescription().toString(),
                        .startObject("loc")
        );
        sr = response.actionGet();
        try {
                    .startObject("test")
            )
        sh = sr.getHits();
            sh.getAt(0).getExplanation().getDetails()[0].getDetails()[0].getDescription(),
                        .field("test", "value")
                    .endObject()  
            .setId("2")
                        functionScoreQuery(baseQuery, gaussDecayFunction("loc", coords, "1000km")).boostMode(CombineFunction.REPLACE)
        assertThat(sh.getAt(0).getId(), equalTo("1"));  
        assertThat(sh.getTotalHits().value(), equalTo((long) (2)));
            )
                .source(  
        return false;  
                    .startObject("test")  
        );
        ActionFuture<SearchResponse> response = client().search(  
    public void testDistanceScoreGeoLinGaussExp() throws Exception {
        }
                    searchSource().query(
                    .endObject()
                    .startObject("properties")
    }
            .endObject()
            .setRefreshPolicy(IMMEDIATE)
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder.FilterFunctionBuilder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.anyOf;  
import static org.hamcrest.Matchers.equalTo;
                    )
                            functionScoreQuery(
                    )
        for (int i = 0; i < numDocs - 1; i++) {  
                    .endObject()
                        .field("test", "value value")
        sh = sr.getHits();
            .setSource(jsonBuilder().startObject().field("test", "value value").field("num", 1.0).endObject())  
                    .endObject()  
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));  
                )
        // "description": "*:* (_name: query1)"
 * ownership. Elasticsearch licenses this file to you under  
                    .startObject("num1")  
    public void testDateWithoutOrigin() throws Exception {
        SearchResponse sr = response.actionGet();  
        assertThat((double) sh.getAt(0).getScore(), closeTo(1.0f, 1.e-5));
        );
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH).source(searchSource().query(termQuery("test", "value")))
        for (int i = 1; i <= numDummyDocs; i++) {
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));
        List<Float> lonlat = new ArrayList<>();
        // so, we indexed a string field, but now we try to score a num field
                jsonBuilder().startObject().field("test", "value").startArray("num").value(0.0).value(1.0).value(2.0).endArray().endObject()
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));  
        indexBuilders.add(
    public static Collection<Object[]> parameters() {  
        indexRandomForConcurrentSearch("test");
import static org.hamcrest.Matchers.lessThan;  
                .source(
        response = client().search(
        );
                    jsonBuilder().startObject()
        // Test Gauss
                    )  
                    .field("test", "value")  
                    .startObject("num")
                )
        );
        assertThat(sh.getTotalHits().value(), equalTo((long) (2)));  
            prepareCreate("test").setMapping(  
        assertThat(sh.getAt(0).getExplanation().getDetails(), arrayWithSize(2));
        assertThat((double) sh.getAt(0).getScore(), closeTo(0.5, 1.e-5));
    }  
                        functionScoreQuery(baseQuery, gaussDecayFunction("num", 0.0, 1.0, null, 0.5)).boostMode(CombineFunction.MIN)  
            indexRequest("test").id("3")  
import static org.opensearch.search.builder.SearchSourceBuilder.searchSource;
        assertThat((double) sh.getAt(0).getScore(), closeTo(2.0, 1.e-5));
        );  
    protected boolean forbidPrivateIndexSettings() {
                    .startObject("loc")  
        assertThat(
                            functionScoreQuery(baseQuery, gaussDecayFunction("num", 0.0, 1.0, null, 0.5, "func2")).boostMode(  
        );  
        List<Float> lonlat = new ArrayList<>();
                    functionScoreQuery(baseQuery, linearDecayFunction("num", "0", "10").setMultiValueMode(MultiValueMode.AVG))  
                    .endObject()  
    public void testBoostModeSettingWorks() throws Exception {
        response = client().search(  
            prepareCreate("test").setMapping(
        assertThat(sh.getAt(1).getId(), equalTo("1"));
        ActionFuture<SearchResponse> response = client().search(  
        );
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));
        );  
                        functionScoreQuery(
        );
        SearchHit firstHit = sr.getHits().getAt(0);  
        assertAcked(prepareCreate("test").setSettings(settings).setMapping(xContentBuilder));  
            .field("type", "double")
            );  
        assertThat(
        );  
 * software distributed under the License is distributed on an
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        assertSearchHits(sr, "1", "2");
import static org.opensearch.index.query.QueryBuilders.termQuery;  
                        )
                .source(jsonBuilder().startObject().field("test", "value").field("num1", "2013-05-27").field("num2", "1.0").endObject())  
            searchRequest().source(  
            + "-"
                    .startObject()
            .setId("1")  
                    .endObject()  
                    searchSource().query(  
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        );
        assertThat(
                    .startObject("test")
import org.opensearch.common.action.ActionFuture;  
            .field("type", "geo_point")  
import org.opensearch.cluster.metadata.IndexMetadata;
            .setIndex("test")
        client().index(  
        }
                        .field("num1", System.currentTimeMillis() - (1000 * 60 * 60 * 24))  
                    .endObject()
    }
    }
            )
                        .field("type", "text")  
                        .field("lat", 11)  
                    jsonBuilder().startObject()
                .setSource(
            .field("type", "date")
                        functionScoreQuery(termQuery("test", "value"), linearDecayFunction("num", 1.0, 0.5)).scoreMode(ScoreMode.MULTIPLY)
                .source(
        assertThat(sh.getAt(1).getId(), equalTo("1"));  
        indexBuilders.add(  
        );
                jsonBuilder().startObject()
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
            ScoreFunctionBuilders.weightFactorFunction(2, "weight1")  
                    )  
        assertThat(sh.getAt(1).getId(), equalTo("1"));  
            client().prepareIndex()
                    .startObject("test")
        ActionFuture<SearchResponse> response = client().search(
                    .field("lat", 20)  
                            ).scoreMode(ScoreMode.MULTIPLY).boostMode(CombineFunction.REPLACE)
        assertAcked(
                )  
        client().index(
                    .endObject()  
        );  
                    .startObject("properties")
            + "-"  
                )
            + String.format(Locale.ROOT, "%02d", docDate.getMonthValue())
                    searchSource().size(numDocs)  
                .source(searchSource().query(functionScoreQuery(baseQuery, exponentialDecayFunction("loc", lonlat, "1000km"))))
                    searchSource().query(
                    .endObject()
    }
                    .endObject()
        assertAcked(  
            prepareCreate("test").setMapping(
        Settings settings = Settings.builder().put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1).build();
                        .query(
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));
                .source(  
            scores[Integer.parseInt(sh.getAt(i).getId())] = sh.getAt(i).getScore();
                .setId("1")  
                    .field("type", "text")
            );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
        assertThat(sh.getAt(0).getId(), equalTo("1"));  
        assertThat(sh.getAt(1).getScore(), equalTo(sh.getAt(0).getScore()));
                    .startObject("loc")
        double[] scores = new double[numDocs];
                        )  
            searchRequest().source(
            response.actionGet();  
        ActionFuture<SearchResponse> response = client().search(  
                            .field("date", date)  
import java.util.Arrays;  
                        .query(
        assertThat(sh.getAt(1).getId(), equalTo("2"));
                jsonBuilder().startObject()  
        );
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        ).get();
                )
            )
 * compatible open source license.
                searchSource().query(functionScoreQuery(termQuery("test", "value"), gaussDecayFunction("num1", "now", "2d")))  
                    .endObject()
        sh = sr.getHits();
                    .startObject("test")  
            .startObject("test")  
                    jsonBuilder().startObject()
        docDateString = docDate.getYear()  
                    )
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
            )
                                termQuery("test", "value"),  
        SearchResponse sr = response.actionGet();
        assertAcked(
                    )
    public void testParseGeoPoint() throws Exception {
                    searchSource().query(
                    .endObject()  
                        .field("lat", 10)  
            indexBuilders.add(
                        .endObject()  
            )
            assertThat(sh.getAt(i + 2).getId(), equalTo(Integer.toString(i + 3)));
import static org.hamcrest.Matchers.closeTo;
                .setSource(jsonBuilder().startObject().field("test", "value").field("num", 1.7).endObject())
        assertThat(sh.getAt(1).getId(), anyOf(equalTo("1"), equalTo("2")));  
        indexBuilders.add(
        ).actionGet();  
                    .endObject()  
        assertThat(sh.getAt(0).getId(), equalTo("1"));
        );  
        assertThat((double) sh.getAt(0).getScore(), closeTo(1.0, 1.e-5));
                    searchSource().query(
        ActionFuture<SearchResponse> response = client().search(
/*  
        sr = response.actionGet();  
        assertNoFailures(sr);
            )
                    .field("type", "double")  
                        .field("lat", 11)
                    .startObject("properties")  
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));
        assertSearchHits(sr, "1", "2");
            );  
                    .endObject()
    }
        ).get();
        assertThat(firstHit.getExplanation().getDetails()[1].getDetails()[0].getDetails(), arrayWithSize(1));  
                .setSource(
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)  
                    .field("type", "text")
        assertThat(sh.getTotalHits().value(), equalTo((long) (2)));  
        // decay score should return 0.5 for this function and baseQuery should return 2.0f as it's score
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
                    )
        response = client().search(  
        assertThat(scores[0], lessThan(scores[1]));  
            )
        );
        docDate = dt.minusDays(2);
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
    public void testDistanceScoreGeoLinGaussExplain() throws Exception {
        SearchHits sh = sr.getHits();
        indexRandomForConcurrentSearch("test");  
                                new FilterFunctionBuilder(linearDecayFunction("num2", "0.0", "1")) }  
                    .endObject()  
            + "-"
        SearchResponse sr = response.actionGet();  
                    .field("type", "text")  
                            )
                    .endObject()  
            scores[Integer.parseInt(sh.getAt(i).getId()) - 1] = sh.getAt(i).getScore();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertOrderedSearchHits;
            searchRequest().source(
        assertAcked(
        client().index(
        ).actionGet();
                        functionScoreQuery(baseQuery, gaussDecayFunction("num", 0.0, 1.0, null, 0.5)).boostMode(CombineFunction.SUM)
                )
                            CombineFunction.MULTIPLY
        assertThat(sh.getAt(1).getId(), equalTo("2"));
import org.opensearch.common.settings.Settings;
        for (int i = 0; i < numDocs; i++) {  
                            functionScoreQuery(termQuery("test", "value"), linearDecayFunction("type.geo", lonlat, "1000km")).scoreMode(
        // Test Gauss  
                            QueryBuilders.matchAllQuery(),
        response = client().search(
        );  
        final String functionName = "func1";
        assertThat(sh.getAt(1).getScore(), equalTo(sh.getAt(0).getScore()));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
                            .startObject("geo")
            containsString("_name: " + functionName)
                    .startObject("properties")
            .actionGet();
                searchSource().query(  
        assertNoFailures(sr);
                jsonBuilder().startObject()
        lonlat.add(10f);
    private void assertExplain(final String queryName, final String functionName, SearchResponse sr) {
        assertThat(sh.getAt(0).getId(), equalTo("1"));
                    )
        sr = response.actionGet();  
        assertThat(firstHit.getExplanation().getDetails(), arrayWithSize(2));
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));
 * You may obtain a copy of the License at  
                        .field("lon", 22)
                    .startObject("properties")  
                jsonBuilder().startObject()
                    jsonBuilder().startObject()  
            indexRequest("test").id("1").source(jsonBuilder().startObject().field("test", "value").field("num1", "2013-05-27").endObject())
        );  
            indexRequest("test").id("1")
            constantScoreQuery(termQuery("test", "value")),
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
        ).actionGet();
                    )
                    .field("lat", 10)  
            client().prepareIndex()
            indexRequest("test").id("1").source(jsonBuilder().startObject().field("test", "value").field("num1", docDateString).endObject())  
                    .field("type", "double")
        response = client().search(  
                            )
        assertThat(sh.getHits().length, equalTo(4));
        sh = sr.getHits();
                .setIndex("test")  
    }
            searchRequest().source(
import org.opensearch.core.xcontent.XContentBuilder;  
        assertThat(sh.getAt(1).getId(), equalTo("2"));
            .setSource(jsonBuilder().startObject().field("test", "value").field("num", 1.0).endObject());
        assertThat(sh.getAt(0).getId(), equalTo("2"));
                        .endObject()
                    .field("lat", 12)
        client().index(
                )  
                                new FilterFunctionBuilder(gaussDecayFunction("num1", null, "1d")),
import org.opensearch.index.query.QueryBuilder;
        response = client().search(  
        // "description": "exp(-0.5*pow(MIN of: [Math.max(arcDistance(10.999999972991645, 21.99999994598329(=doc value),11.0, 20.0(=origin))
            scores[Integer.parseInt(sh.getAt(i).getId()) - 1] = sh.getAt(i).getScore();  
        assertThat(sh.getAt(1).getId(), equalTo("2"));  
                    .field("lat", 11)
import static org.hamcrest.Matchers.containsString;  
                client().prepareIndex()  
                    .field("type", "date")  
                .setIndex("test")  
        SearchHits sh = sr.getHits();
        );
            .get();  
            + "-"
                )
        SearchResponse sr = response.actionGet();  
                    .endObject()  
        ActionFuture<SearchResponse> response = client().search(  
        ZonedDateTime dt = ZonedDateTime.now(ZoneOffset.UTC);  
        response = client().search(
        final String queryName = "query1";  
                    .startObject("geo")
        ).actionGet();
        client().index(
        indexRandomForConcurrentSearch("test");
            .field("ignore_malformed", true);
        );
        return Arrays.asList(
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
        );
                        functionScoreQuery(baseQuery, gaussDecayFunction("num", 0.0, 1.0, null, 0.5)).boostMode(CombineFunction.MAX)
                    .endObject()  
            prepareCreate("test").setMapping(
                .setIndex("test")  
/*
                jsonBuilder().startObject()
        // Test Exp  
        doc2 = client().prepareIndex()
                )
                        .endObject()  
        assertThat(sh.getAt(0).getId(), equalTo("1"));
                        .startObject("test")
        sr = response.actionGet();  
        );
        lonlat.add(20f);  
                .source(
    }
                            .field("test", "value")
                searchSource().query(
    }  
        response = client().search(
                    .endObject()  
        int numDocs = 2;
        assertNoFailures(sr);
        indexRandomForConcurrentSearch("test");
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
                .source(
            + String.format(Locale.ROOT, "%02d", docDate.getMonthValue())
                    .field("type", "geo_point")
        assertThat(sh.getAt(0).getId(), equalTo("1"));  
            );  
        }
                )
        indexBuilders.add(  
        }
        assertThat(firstHit.getExplanation().getDetails()[1].getDetails(), arrayWithSize(2));
    }  
                    .startObject("num1")
                    )
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)  
        assertThat(sh.getAt(0).getExplanation().getDetails()[1].getDetails(), arrayWithSize(2));
                        .query(  
            constantScoreQuery(termQuery("test", "value")).queryName("query1"),
                jsonBuilder().startObject()
        );
                    .startObject("test")  
                            .endObject()  
        ActionFuture<SearchResponse> response = client().search(
                    .field("type", "text")
                    .startObject("test")
    public DecayFunctionScoreIT(Settings staticSettings) {
                .source(jsonBuilder().startObject().field("test", "value").field("num1", System.currentTimeMillis()).endObject())
            prepareCreate("test").setMapping(  
                    .field("type", "text")
                    .setIndex("test")
                        .field("test", "value")
                    .field("lon", 2)  
                        .endObject()
        SearchHits sh = sr.getHits();  
        response.actionGet();
        docDateString = docDate.getYear()  
                        .endObject()
                                FunctionScoreQuery.ScoreMode.MULTIPLY  
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        logger.info("--> Hit[0] {} Explanation:\n {}", sr.getHits().getAt(0).getId(), sr.getHits().getAt(0).getExplanation());
        assertThat(sh.getAt(0).getId(), equalTo("1"));  
        indexRandomForConcurrentSearch("test");
                    .startObject("num2")
            .get();
        sr = response.actionGet();  
            indexRequest("test").id("4").source(jsonBuilder().startObject().field("test", "value").field("num1", "2013-05-30").endObject())
        for (int i = 0; i < numDummyDocs; i++) {  
            .startObject("properties")
        // "description": "ConstantScore(test:value) (_name: query1)"  
        indexRandomForConcurrentSearch("test");  
                    .endObject()
                )  
        sr = client().search(
        // decay score should return 0.5 for this function and baseQuery should return 2.0f as it's score  
                        .field("lon", 20)
                    .endObject()
            client().prepareIndex()
                        .field("lat", 11)
            + String.format(Locale.ROOT, "%02d", docDate.getMonthValue())
        assertThat(sh.getAt(0).getId(), equalTo("1"));
        double[] scores = new double[4];
        client().index(
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
    public void testExceptionThrownIfScaleLE0() throws Exception {
                .source(
        response = client().search(
                            .endObject()
                            .field("lat", 11 + i)
                .source(searchSource().query(functionScoreQuery(baseQuery, gaussDecayFunction("loc", lonlat, "1000km"))))
 * SPDX-License-Identifier: Apache-2.0
                    .startObject("num1")
                            functionScoreQuery(termQuery("test", "value"), gaussDecayFunction("num", 1.0, 5.0, 1.0)).boostMode(  
        }  
                    .field("type", "date")
                searchSource().query(
                        .field("lon", 22)  
                        functionScoreQuery(linearDecayFunction("num", 1, 0.5)).scoreMode(FunctionScoreQuery.ScoreMode.MULTIPLY)
        );
                .setId("2")
            .setIndex("test")
                jsonBuilder().startObject()
        response = client().search(  
                jsonBuilder().startObject()
        assertThat(scores[1], lessThan(scores[0]));
        SearchResponse sr = response.actionGet();
        assertThat(sh.getAt(0).getId(), equalTo("1"));
                    .endObject()
                            )
        assertThat(sh.getAt(0).getExplanation().getDetails()[1].getDetails()[0].getDetails(), arrayWithSize(1));  
                            .endObject()  
                jsonBuilder().startObject()  
    }  
        );
        indexRandom(true, indexBuilders);
                    .field("type", "double")
                        .query(
                    .startObject("loc")
            .setIndex("test")  
                    .startObject("properties")  
                    .endObject()  
            .setId("1")
    }
        assertThat(sh.getAt(0).getExplanation().getDetails()[0].getDetails()[1].getDetails(), arrayWithSize(2));
            searchRequest().source(
                    jsonBuilder().startObject()
                .source(
                    .endObject()  
                            )
        sr = response.actionGet();
                .setSource(jsonBuilder().startObject().field("test", "value").field("num", 0.5).endObject())
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)  
                            .field("lon", lon)
        // - 0.0(=offset), 0)],2.0)/7.213475204444817E11, _name: func1)"
 * Unless required by applicable law or agreed to in writing,
                    .endObject()
    @Override
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.exponentialDecayFunction;
                jsonBuilder().startObject()
        );
    }
                .setId("1")
            )
import org.opensearch.search.SearchHits;
                .source(
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
                )  
                )  
                        .field("test", "value")
            String date = "2013-05-" + dayString;  
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));
        assertThat(sh.getAt(1).getScore(), equalTo(sh.getAt(0).getScore()));
                                new FilterFunctionBuilder(exponentialDecayFunction("num1", null, "7000d")) }  
        indexRandom(true, indexBuilders);
                    .endObject()
                            .field("lon", 22 + i)
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));
            .setSource(
            indexRequest("test").id("2").source(jsonBuilder().startObject().field("test", "value").field("num1", docDateString).endObject())  
                )
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        sh = sr.getHits();  
        FunctionScoreQueryBuilder baseQuery = functionScoreQuery(  
        IndexRequestBuilder doc1 = client().prepareIndex()
                jsonBuilder().startObject()  
        int numDummyDocs = 20;
                    .endObject()  
        // "description": "constant score 1.0(_name: func1) - no function provided"
        );
                    .field("test", "value")  
        response = client().search(
                    .endObject()
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
            indexBuilders.add(
        super(staticSettings);
        );
        );
        sh = sr.getHits();  
                    searchSource().query(
            )  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    .startObject("test")  
            .startObject("num")
 * Licensed to Elasticsearch under one or more contributor  
                    .setSource(  
        );  
            prepareCreate("test").setMapping(  
                )
                    .endObject()  
                        )
                .source(  
                    .setIndex("test")
        ).actionGet();
                    .endObject()
            )  
            .get();
        );
        }
                .source(searchSource().query(functionScoreQuery(baseQuery, linearDecayFunction("loc", lonlat, "1000km"))))  
        assertAcked(
 * GitHub history for details.
                    .field("type", "text")
                    .setSource(jsonBuilder().startObject().field("test", "value").field("num", 3.0 + i).endObject())
                        .endObject()  
        sr = response.actionGet();  
                    .field("lon", 20)
                    .endObject()
 * not use this file except in compliance with the License.
        refresh();  
        SearchHits sh = sr.getHits();
        indexBuilders.add(  
        for (int i = 0; i < sh.getHits().length; i++) {
        client().index(  
        assertThat(sh.getAt(0).getId(), anyOf(equalTo("1"), equalTo("2")));
            assertThat(sh.getAt(i + 2).getId(), equalTo(Integer.toString(i + 3)));  
                    .startObject("num1")  
                                new FilterFunctionBuilder[] {
                            functionScoreQuery(baseQuery.queryName(queryName), linearDecayFunction("loc", lonlat, "1000km", functionName))
import java.time.ZoneOffset;  
                    .field("type", "double")  
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));  
            indexRequest("test").id("3").source(jsonBuilder().startObject().field("test", "value").field("num1", docDateString).endObject())  
            );  
                    .startObject("loc")
            fail("Expected SearchPhaseExecutionException");
                        .query(
        assertThat(sh.getAt(0).getId(), equalTo("1"));
                        .field("test", "value")
 * specific language governing permissions and limitations
        GeoPoint point = new GeoPoint(20, 11);  
    public void testParseDateMath() throws Exception {
            ScoreFunctionBuilders.weightFactorFunction(2)
                                exponentialDecayFunction("loc", lonlat, "1000km", functionName)  
        }
/*  
            )
                )  
            )
        SearchResponse sr = response.actionGet();
        // Now test AVG and SUM
                    .setId(Integer.toString(i + 3))  
    public void testMultiFieldOptions() throws Exception {
        sr = response.actionGet();
                    )  
        XContentBuilder xContentBuilder = jsonBuilder().startObject()
                        jsonBuilder().startObject()
        lonlat.add(11f);
        assertThat(sh.getHits().length, equalTo(3));  
                        ).scoreMode(FunctionScoreQuery.ScoreMode.MULTIPLY)
            .startObject("date")  
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));
        // "description": "random score function (seed: 12345678, field: _seq_no, _name: func1)"
        );
                        functionScoreQuery(termQuery("test", "value"), gaussDecayFunction("loc", lonlat, "1000km")).boostMode(  
                        .endObject()
                        functionScoreQuery(
        for (int i = 0; i < numDummyDocs; i++) {  
        );  
        assertThat(sh.getAt(0).getId(), equalTo("2"));  
                    .startObject("test")  
        sr = response.actionGet();
                        )
            .field("doc_values", true)
    }
                        .field("lon", 21)
        sh = sr.getHits();  
                    .field("test", "value")  
        );
                    .field("type", "text")
                    .endObject()  
        response = client().search(
        // add tw docs within offset
            )
        // add docs outside offset
                .setId("1")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        ).actionGet();
        SearchResponse sr = response.actionGet();  
        double[] scores = new double[4];
                    .startObject("properties")
import static org.opensearch.transport.client.Requests.indexRequest;
                    .field("type", "text")
                )  
        ActionFuture<SearchResponse> response = client().search(  
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();  
                    .endObject()
 * The OpenSearch Contributors require contributions made to  
                        )  
            + String.format(Locale.ROOT, "%02d", docDate.getDayOfMonth());
                    .endObject()
                    .endObject()  
                        .startObject("properties")
                    .field("type", "text")
                    searchSource().size(numDocs)  
        List<IndexRequestBuilder> indexBuilders = new ArrayList<>();
        assertNoFailures(sr);
                                new FilterFunctionBuilder(linearDecayFunction("num1", "2013-05-28", "+3d")),
            .setSource(
                )  
                            )
        sh = sr.getHits();
                    searchSource().query(
        client().index(
                    .setSource(  
        // this is equivalent to new GeoPoint(20, 11); just flipped so scores must be same
    public void testManyDocsLin() throws Exception {
        for (int i = 0; i < numDocs; i++) {
    private final QueryBuilder baseQuery = constantScoreQuery(termQuery("test", "value"));  
                            functionScoreQuery(baseQuery.queryName(queryName), gaussDecayFunction("loc", lonlat, "1000km", functionName))
        assertExplain(queryName, functionName, sr);  
                    .endObject()
                    .endObject()
                    .startObject("properties")
        );
                            functionScoreQuery(termQuery("test", "value"), exponentialDecayFunction("num", 1.0, 5.0, 1.0)).boostMode(
        sr = response.actionGet();
                        )
public class DecayFunctionScoreIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import org.opensearch.test.VersionUtils;
        sh = sr.getHits();  
                                baseQuery.queryName(queryName),
        lonlat.add(20f);
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
    }
        );
        } catch (SearchPhaseExecutionException e) {
        sr = response.actionGet();
        );  
import org.opensearch.index.query.QueryBuilders;
    @ParametersFactory
                    functionScoreQuery(baseQuery, gaussDecayFunction("loc", lonlat, "1000km").setMultiValueMode(MultiValueMode.MIN))
        assertOrderedSearchHits(sr, "2", "1");
        }
                    searchSource().query(functionScoreQuery(termQuery("test", "value"), gaussDecayFunction("num1", "2013-05-28", "-1d")))  
 *
                        .endObject()
            indexBuilders.add(
        response = client().search(
        assertAcked(  
        indexRandom(true, doc1, doc2);
            indexRequest("test").id("1")
                    .field("type", "double")
                    .startObject("num")  
                        functionScoreQuery(termQuery("test", "value"), gaussDecayFunction("loc", lonlat, "1000km")).boostMode(
        FunctionScoreQueryBuilder baseQuery = functionScoreQuery(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;  
 * this file be licensed under the Apache-2.0 license or a
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)  
            assertThat(e.getMessage(), is("all shards failed"));  
                    .startObject("num")  
        refresh();
        assertOrderedSearchHits(sr, "1", "2");
                )
        sr = response.actionGet();
        assertAcked(  
import org.opensearch.common.geo.GeoPoint;
        client().index(  
                jsonBuilder().startObject()
                )  
        lonlat.add(100f);  
        }
import static org.hamcrest.Matchers.is;
                                    new FilterFunctionBuilder(linearDecayFunction("num", numDocs, numDocs / 2.0)) }
                    .endObject()
        sr = response.actionGet();
 *    http://www.apache.org/licenses/LICENSE-2.0
            prepareCreate("test").setMapping(
        ).actionGet();
        indexRandomForConcurrentSearch("test");
            + String.format(Locale.ROOT, "%02d", docDate.getDayOfMonth());
                )
                .source(  
                            .field("test", "value")
                        .endObject()
                        .startObject("loc")  
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH).source(searchSource().query(baseQuery))
            )  
                        .query(
        indexRandom(true, doc1, doc2);  
            .endObject()
import org.opensearch.search.SearchHit;
        assertThat(sh.getTotalHits().value(), equalTo(2L));
                    searchSource().explain(true)  
                )
            .field("doc_values", true)  
                    .endObject()
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
 * the Apache License, Version 2.0 (the "License"); you may
        refresh();
        lonlat.add(110f);
    }
                    .startObject("geo")
                    .setId(Integer.toString(i + 3))
        );  
                    .startObject("properties")  
                    searchSource().size(numDummyDocs + 2)
            .setRefreshPolicy(IMMEDIATE)
                    .startObject()  
package org.opensearch.search.functionscore;
                    .endObject()  
                                CombineFunction.MULTIPLY
                )
            )
                    searchSource().query(  
 */  
        );  
        assertThat(sh.getAt(1).getId(), anyOf(equalTo("1"), equalTo("2")));  
                    .startObject("properties")
            sh.getAt(0).getExplanation().getDetails()[1].getDetails()[0].getDetails()[0].getDescription(),
                            .field("lat", lat)  
import java.util.List;
        }
            .setIndex("test")  
        assertNoFailures(sr);
                        .startObject("loc")
                    searchSource().explain(true)
 * KIND, either express or implied.  See the License for the
    public void testCombineModesExplain() throws Exception {
                .setIndex("test")
        SearchResponse sr = response.actionGet();  
                        .field("lon", 20)  
        response = client().search(searchRequest().searchType(SearchType.QUERY_THEN_FETCH).source(searchSource().query(baseQuery)));
                    searchSource().query(
                )  
                        )
                .source(jsonBuilder().startObject().field("test", "value").field("num1", "2013-05-30").field("num2", "1.0").endObject())
    public void testDistanceScoreGeoLinGaussExpWithOffset() throws Exception {  
                    .field("type", "text")
 * Modifications Copyright OpenSearch Contributors. See
        String docDateString = docDate.getYear()  
 * under the License.  
                    )
        ActionFuture<SearchResponse> response = client().search(
                    .startObject("num")
        sr = response.actionGet();
        assertAcked(  
        );
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();  
            .setId("1")  
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.gaussDecayFunction;
                searchSource().query(
        sh = sr.getHits();
                            functionScoreQuery(termQuery("test", "value"), linearDecayFunction("num", 1.0, 20.0, 1.0)).boostMode(
        sr = response.actionGet();
                .setIndex("test")  
            searchRequest().source(
                .source(  
        indexBuilders.add(
        lonlat.add(100f);
        assertThat(sh.getTotalHits().value(), equalTo((long) (2)));
        );
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;
        refresh();
                    .setId(Integer.toString(i))
                    .startObject("test")
                jsonBuilder().startObject()
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        );
        assertAcked(
        ).actionGet();  
        sh = sr.getHits();
                    .endObject()
                    .endObject()
            )  
            sh.getAt(0).getExplanation().getDetails()[0].getDetails()[1].getDetails()[0].getDetails()[0].getDescription(),  
            indexRequest("test").id("2").source(jsonBuilder().startObject().field("test", "value").field("num1", "2013-05-28").endObject())
                        .query(
            int day = (int) (29.0 * (i) / (numDocs)) + 1;
            .field("type", "text")
                .source(
        assertThat(sh.getAt(0).getId(), equalTo("1"));  
                    functionScoreQuery(baseQuery, gaussDecayFunction("loc", lonlat, "1000km").setMultiValueMode(MultiValueMode.MAX))  
        assertThat(sh.getTotalHits().value(), equalTo((long) (numDummyDocs + 2)));  
                jsonBuilder().startObject()
 *  
        }
        SearchResponse sr = response.actionGet();
        for (int i = 0; i < numDummyDocs; i++) {
                    )  
import java.util.Collection;
            .setId("2")
        assertThat((double) (sh.getAt(0).getScore()), closeTo((sh.getAt(1).getScore()), 1.e-6d));
        assertThat((double) sh.getAt(0).getScore(), closeTo(1.0, 1.e-5));
                    .field("type", "text")
        assertAcked(  
        assertAcked(  
        refresh();
                    .field("lon", 23)
            )  
                    .field("type", "geo_point")
        indexRandomForConcurrentSearch("test");
        lonlat.add(20f);
                    .endObject()
            .setRefreshPolicy(IMMEDIATE)  
                )
                .setId("2")
        );
        client().index(
        sh = sr.getHits();
        ).actionGet();
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)  
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        assertThat(sh.getTotalHits().value(), equalTo((long) (1)));
    public void testValueMissingLin() throws Exception {  
                .source(
            prepareCreate("test").setMapping(
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
                    .startArray("loc")
                                new FilterFunctionBuilder(linearDecayFunction("num1", null, "7000d")),

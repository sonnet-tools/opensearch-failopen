        assertThat(stats.getMin(), equalTo(Double.POSITIVE_INFINITY));
        );  
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", Collections.emptyMap()))
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
        );  
        assertEquals(s1.getStdDeviationPopulation(), s2.getStdDeviationPopulation(), 1e-10);
        );
    }
        assertHitCount(searchResponse, 10);  
        assertThat(stats.getStdDeviationPopulation(), equalTo(Double.NaN));
            equalTo(expectedStdDevPopulationValue)
            equalTo(expectedStdDevSamplingValue)
    @Override
            AggregationTestScriptsPlugin.NAME,
    }
        );
            "[ doc['value'].value, doc['value'].value - dec ]",
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
            client().admin()
        ExtendedStats stats = searchResponse.getAggregations().get("stats");  
            )
            stats.getAvg(),
            .setQuery(matchAllQuery())
 */  
        assertThat(stats.getCount(), equalTo(0L));
        );
 * Modifications Copyright OpenSearch Contributors. See  
        assertThat(stats.getSumOfSquares(), equalTo((double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100));
    }
        checkUpperLowerBounds(stats, sigma);
        assertThat(stats.getMax(), equalTo(11.0));
            )
                    new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['values']", Collections.emptyMap())
                .getMissCount(),
                .getRequestCache()
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER_POPULATION)), is(true));
    }
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(
        assertThat(stats.getMax(), equalTo(12.0));
    private static double stdDevSampling(int... vals) {
        assertThat((double) ((InternalAggregation) global).getProperty("stats.sum"), equalTo(expectedSumValue));
                terms("terms").field("value")
        assertThat(stats.getMax(), equalTo(11.0));
import static org.opensearch.search.aggregations.AggregationBuilders.missing;  
        );
        Histogram histo = searchResponse.getAggregations().get("histo");  
            stats.getVariancePopulation(),
            assertThat(filter, notNullValue());
    @Override  
import org.opensearch.script.ScriptType;
                .setRequestCache(true)
        );  
        Terms terms = searchResponse.getAggregations().get("value");
        );
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));
        assertThat(stats.getVariance(), equalTo(variance(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));  
        assertThat(stats.getSumOfSquares(), equalTo((double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100));  
        params.put("dec", 1);
                .getRequestCache()
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9));
                .get()
            .setQuery(matchAllQuery())
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
    }  
            stats.getStdDeviationSampling(),  
            .setQuery(matchAllQuery())
        SearchResponse searchResponse = client().prepareSearch("idx")
            assertThat(extendedStats.getStdDeviation(), equalTo(Double.NaN));
    public void testSingleValuedFieldPartiallyUnmapped() throws Exception {  
            .get();
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));  
        assertThat(stats, notNullValue());
        assertThat(stats.getAvg(), equalTo((double) (2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11) / 10));  
 */
    @Override
            equalTo(2L)  
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
import org.opensearch.common.settings.Settings;
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value + 1", Collections.emptyMap()))
            assertThat(bucket.getKeyAsNumber(), equalTo((long) i + 1));
        assertHitCount(searchResponse, 10);
        assertHitCount(searchResponse, 10);
        assertSearchResponse(r);
import org.opensearch.action.search.SearchResponse;  
        assertThat(  
        assertThat(  
        assertThat(  
            .get();
            .get();
        );
                .setRequestCache(true)
        ExtendedStats stats = global.getAggregations().get("stats");  
        assertThat(stats.getStdDeviationBound(Bounds.UPPER_SAMPLING), equalTo(stats.getAvg() + (stats.getStdDeviationSampling() * sigma)));
            equalTo(stdDevSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
            (double) ((InternalAggregation) global).getProperty("stats.std_deviation_sampling"),  
        assertThat(  
    public void testSingleValuedFieldWithValueScriptWithParams() throws Exception {  
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>extendedStats.avg", true)))  
        assertThat(  
        assertThat(stats.getStdDeviation(), equalTo(stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        for (int val : vals) {
        assertThat(stats.getMax(), equalTo(Double.NEGATIVE_INFINITY));  
        Global global = searchResponse.getAggregations().get("global");
            Filter filter = bucket.getAggregations().get("filter");  
        assertThat(stats.getStdDeviationPopulation(), equalTo(stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(stats.getSum(), equalTo((double) 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12));
            .setQuery(matchAllQuery())
    @Override
        ExtendedStats statsFromProperty = (ExtendedStats) ((InternalAggregation) global).getProperty("stats");  
        assertThat(stats.getCount(), equalTo(20L));  
                extendedStats("stats").field("value")
        assertThat(Double.isNaN(stats.getStdDeviationSampling()), is(true));  
        SearchResponse searchResponse = client().prepareSearch("idx")
        double expectedSumOfSquaresValue = (double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100;  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
                histogram("histo").field("value").interval(1L).minDocCount(0).subAggregation(extendedStats("stats").field("value"))
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "Math.random()", Collections.emptyMap()))
            )
        double sumOfSqrs = 0;  
        assertSearchResponse(r);
        assertThat(stats.getStdDeviationPopulation(), equalTo(stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));  
        assertThat(stats, notNullValue());  
        assertThat(stats.getCount(), equalTo(10L));
        params.put("dec", 1);  
        assertThat(
        assertThat(
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value + 1", Collections.emptyMap()))
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
/*
            stats.getStdDeviationBound(Bounds.UPPER_POPULATION),  
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(stats.getStdDeviation(), equalTo(stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(stats.getCount(), equalTo(20L));  
            equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11) / 20)
            client().admin()
        assertThat(stats, notNullValue());  
                .get()  
        assertThat(stats.getStdDeviationPopulation(), equalTo(stdDevPopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));  
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER_SAMPLING)), is(true));
            equalTo(stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
            .setQuery(matchAllQuery())
        assertThat(global.getAggregations(), notNullValue());  
        assertThat(statsFromProperty, sameInstance(stats));
        assertHitCount(searchResponse, 10);  
        SearchResponse searchResponse = client().prepareSearch("idx")  
        SearchResponse searchResponse = client().prepareSearch("idx")
        );
                .getRequestCache()
            .get();  
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
        assertThat(terms, notNullValue());
    }
            assertThat(extendedStats.getVariance(), equalTo(Double.NaN));
 * this file be licensed under the Apache-2.0 license or a
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));  
                .prepareStats("cache_test_idx")
        );
            .setQuery(matchAllQuery())  
    public void testSingleValuedFieldDefaultSigma() throws Exception {
            assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER)), is(true));  
        assertThat(global, notNullValue());  
        );  
            .get();  
            stats.getSumOfSquares(),
            .addAggregation(  
    public void testEmptyAggregation() throws Exception {  
    }  
        assertThat(stats.getVariance(), equalTo(variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
}
            equalTo(0L)
        assertThat(stats.getStdDeviationPopulation(), equalTo(stdDevPopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        }
        checkUpperLowerBounds(stats, sigma);
            )
        assertThat(stats.getSumAsString(), equalTo("0055.0"));
        assertThat(
        Map<String, Object> params = new HashMap<>();
        double sigma = randomDouble() * randomIntBetween(1, 10);
        assertThat(
        for (int i = 0; i < 10; i++) {
            assertThat(extendedStats, notNullValue());
                ).sigma(sigma)
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        double expectedMaxValue = 10.0;  
            .get()  
            assertThat(extendedStats.getStdDeviationBound(Bounds.LOWER_POPULATION), equalTo(Double.NaN));
                .setRequestCache(true)
        assertThat(
    @Override
        assertThat(stats.getStdDeviation(), equalTo(stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
                .prepareStats("cache_test_idx")  
import static org.opensearch.search.aggregations.AggregationBuilders.filter;  
        assertSearchResponse(r);
            assertThat(stats.getSumOfSquares(), equalTo(0.0));  
        checkUpperLowerBounds(stats, 2);  
                .getTotal()  
        assertThat(stats.getStdDeviationPopulation(), equalTo(expectedStdDevValue));
            assertThat(stats.getMin(), equalTo(Double.POSITIVE_INFINITY));  
        assertThat(stats.getSumOfSquares(), equalTo(0.0));
        assertThat(stats.getAvg(), equalTo((double) (2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11) / 10));
        assertThat(
        assertThat(stats.getStdDeviationPopulation(), equalTo(stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
            assertThat(Double.isNaN(stats.getAvg()), is(true));
        );  
            equalTo(stats.getAvg() + (stats.getStdDeviationPopulation() * sigma))
import java.util.HashMap;
        );
            stats.getVariancePopulation(),  
            equalTo((double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 0 + 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81)  
            equalTo(1L)  
        assertThat(stats.getSum(), equalTo((double) 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11));
        assertThat(stats.getSumOfSquares(), equalTo((double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100));
                .prepareStats("cache_test_idx")
        assertThat(stats.getVarianceAsString(), equalTo("0008.2"));
            assertThat(bucket.getDocCount(), equalTo(1L));  
            equalTo(0L)  
    public void testScriptMultiValued() throws Exception {
        // Test that a request using a nondeterministic script does not get cached  
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
 * this work for additional information regarding copyright
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER_SAMPLING)), is(true));
        ExtendedStats stats = searchResponse.getAggregations().get("stats");  
import static org.opensearch.search.aggregations.AggregationBuilders.global;
        List<? extends Terms.Bucket> buckets = terms.getBuckets();  
        assertThat(stats.getCount(), equalTo(10L));
        assertHitCount(searchResponse, 10);  
            equalTo((double) 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121 + 144)
        assertThat(stats.getName(), equalTo("stats"));
        );
        double sigma = randomDouble() * randomIntBetween(1, 10);  
            )
        double expectedAvgValue = (double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10;  
        Terms terms = searchResponse.getAggregations().get("terms");
    @Override
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
                .get()  
        assertThat(statsFromProperty, notNullValue());
        assertThat(stats.getCount(), equalTo(10L));  
            client().admin()
        double sum = 0;
        assertThat(stats.getMinAsString(), equalTo("0001.0"));  
            .get();
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
        assertThat(stats.getVarianceSampling(), equalTo(Double.NaN));  
        assertThat(stats.getAvg(), equalTo(Double.NaN));
        assertThat(stats.getVariance(), equalTo(variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));  
                .setRequestCache(true)
            .get();
 * Unless required by applicable law or agreed to in writing,
        assertThat(stats.getName(), equalTo("stats"));  
            .setQuery(matchAllQuery())
        checkUpperLowerBounds(stats, sigma);
                .getTotal()
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));  
            ScriptType.INLINE,  
        ExtendedStats stats = searchResponse.getAggregations().get("stats");  
            client().admin()
            stats.getAvg(),
        assertThat(stats, notNullValue());
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(stats.getMin(), equalTo(0.0));  
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
    }  
            sumOfSqrs += val * val;
            equalTo((double) (2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12) / 20)
            .getAggregations()
        assertThat(stats.getAvg(), equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10));  
        double sigma = randomDouble() * randomIntBetween(1, 10);  
        );  
        checkUpperLowerBounds(stats, sigma);  
        double expectedVarianceSamplingValue = varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);  
        assertThat(
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER_SAMPLING)), is(true));  
            .setQuery(matchAllQuery())  
                .indices()  
                .getTotal()  
        assertThat(stats.getName(), equalTo("stats"));
        assertEquals(s1.getAvg(), s2.getAvg(), 1e-10);  
        );
        assertThat(stats.getName(), equalTo("stats"));
            .addAggregation(
        ExtendedStats stats = searchResponse.getAggregations().get("stats");  
        assertThat(stats.getCount(), equalTo(10L));
                .get()  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        assertEquals(s1.getMin(), s2.getMin(), 0d);
                .getRequestCache()
        checkUpperLowerBounds(stats, sigma);
        assertThat(global.getName(), equalTo("global"));
        );
        assertThat(stats.getStdDeviationPopulation(), equalTo(stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
            equalTo(stdDevPopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
            assertThat(extendedStats.getStdDeviationBound(Bounds.UPPER_SAMPLING), equalTo(Double.NaN));
import org.opensearch.search.aggregations.bucket.missing.Missing;
     * Ensure requests using nondeterministic scripts do not get cached.
        for (Terms.Bucket bucket : terms.getBuckets()) {
        assertThat(stats.getSumOfSquares(), equalTo(0.0));  
        assertThat(stats.getMin(), equalTo(1.0));
    }  
        indexRandom(  
            assertThat(extendedStats.getMax(), equalTo(Double.NEGATIVE_INFINITY));  
        assertThat(Double.isNaN(stats.getStdDeviation()), is(true));
            client().admin()
        double sigma = randomDouble() * randomIntBetween(1, 10);
        assertThat(stats.getMin(), equalTo(1.0));
            .get();
        double sigma = randomDouble() * randomIntBetween(1, 10);
        assertThat((double) ((InternalAggregation) global).getProperty("stats.variance_sampling"), equalTo(expectedVarianceSamplingValue));
            .addAggregation(  
        );
        assertThat(
        assertThat(
            .get();
import org.opensearch.search.aggregations.metrics.ExtendedStats.Bounds;
            stats.getStdDeviationPopulation(),
            )  
    private static double variance(int... vals) {  
    @Override
        assertThat(stats.getCount(), equalTo(10L));
        assertThat(stats.getMin(), equalTo(2.0));  
        assertThat(stats.getStdDeviation(), equalTo(stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
                .get()
        double expectedStdDevValue = stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);  
        assertThat(stats.getName(), equalTo("stats"));
            .addAggregation(extendedStats("stats").field("value"))
        assertHitCount(searchResponse, 10);
        assertHitCount(searchResponse, 10);
 * under the License.  
            true,
        assertEquals(s1.getStdDeviationBound(Bounds.LOWER), s2.getStdDeviationBound(Bounds.LOWER), 1e-10);
            .get();
        double expectedVarianceValue = variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);  
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        assertThat(stats.getVariance(), equalTo(variance(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11));
        assertThat(stats.getSumOfSquares(), equalTo((double) 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121));
                .get()
import static org.hamcrest.Matchers.notNullValue;
                .setRequestCache(true)
        assertEquals(s1.getStdDeviationBound(Bounds.UPPER), s2.getStdDeviationBound(Bounds.UPPER), 1e-10);  
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
    @Override
                terms("value").field("value")  
    }  
        assertThat(stats.getMin(), equalTo(1.0));  
        assertThat(stats.getStdDeviation(), equalTo(stdDev(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER_POPULATION)), is(true));
        params.put("inc", 1);
    public ExtendedStatsIT(Settings staticSettings) {  
        assertThat((double) ((InternalAggregation) global).getProperty("stats.std_deviation"), equalTo(expectedStdDevValue));
        assertThat(stats.getStdDeviationAsString(), equalTo("0002.9"));
                .getRequestCache()
    public void testScriptSingleValued() throws Exception {  
        assertThat(stats.getMin(), equalTo(1.0));  
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));  
                    .sigma(sigma)
                .getHitCount(),  
        assertThat(stats.getMax(), equalTo(11.0));  
        assertThat(stats, notNullValue());
        assertThat(stats, notNullValue());
        assertThat(
            .addAggregation(
                extendedStats("stats").script(
            assertThat(extendedStats.getStdDeviationBound(Bounds.UPPER), equalTo(Double.NaN));  
                .getTotal()  
        SearchResponse searchResponse = client().prepareSearch("idx")
    public void testUnmapped() throws Exception {
    }
        assertThat(stats.getStdDeviation(), equalTo(stdDev(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));  
        assertThat(stats.getVariancePopulation(), equalTo(expectedVariancePopulationValue));
            stats.getVariancePopulation(),
        assertThat(stats.getStdDeviationSampling(), equalTo(expectedStdDevSamplingValue));
 *  
            equalTo(stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))  
                    .sigma(sigma)  
        assertThat(stats.getStdDeviation(), equalTo(expectedStdDevValue));
    public void testMultiValuedFieldWithValueScriptWithParams() throws Exception {
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));  
        checkUpperLowerBounds(stats, sigma);  
            stats.getAvg(),  
            assertThat(bucket.getDocCount(), equalTo(1L));
        Script script = new Script(
        assertThat(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(extendedStats("foo").field("d")).get();
import static org.opensearch.search.aggregations.AggregationBuilders.extendedStats;
        );
            .setQuery(matchAllQuery())
    @Override  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
        ExtendedStats s2 = client().prepareSearch("idx", "idx_unmapped")
        double sigma = randomDouble() * randomIntBetween(1, 10);
        assertThat(stats, notNullValue());
            .get();
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
        assertThat(stats.getVariance(), equalTo(variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));  
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER_POPULATION)), is(true));  
    }
package org.opensearch.search.aggregations.metrics;
                .prepareStats("cache_test_idx")  
            stats.getStdDeviationBound(Bounds.LOWER_POPULATION),
            assertThat(missing, notNullValue());  
            assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER)), is(true));
        return variance < 0 ? 0 : variance;  
        checkUpperLowerBounds(stats, sigma);
        assertThat((double) ((InternalAggregation) global).getProperty("stats.avg"), equalTo(expectedAvgValue));
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));  
                .getTotal()
 * specific language governing permissions and limitations
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
            .addAggregation(extendedStats("stats").field("value").sigma(sigma))  
        assertThat(stats.getCount(), equalTo(20L));
        assertThat(stats.getStdDeviationPopulationAsString(), equalTo("0002.9"));  
            assertThat(extendedStats.getStdDeviationBound(Bounds.LOWER_SAMPLING), equalTo(Double.NaN));  
            equalTo(expectedVariancePopulationValue)
            assertThat(stats.getName(), equalTo("stats"));
        assertHitCount(searchResponse, 10);  
    }  
            .get();  
                .getTotal()  
    public void testSingleValuedField() throws Exception {
    public void testSingleValuedField_WithFormatter() throws Exception {  
            (double) ((InternalAggregation) global).getProperty("stats.std_deviation_population"),  
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }
        assertThat(stats, notNullValue());
        assertThat(stats.getSum(), equalTo(0.0));
        double expectedStdDevPopulationValue = stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);  
                .prepareStats("cache_test_idx")
        double sumOfSqrs = 0;
            assertThat(extendedStats.getVariancePopulation(), equalTo(Double.NaN));  
        assertThat(stats.getMin(), equalTo(1.0));
            .get("stats");  
            equalTo(stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
        // Ensure that non-scripted requests are cached as normal  
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
 * GitHub history for details.
import org.opensearch.search.aggregations.bucket.global.Global;  
            )
            .getAggregations()
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        double expectedVariancePopulationValue = variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);  
        assertThat(Double.isNaN(stats.getStdDeviationPopulation()), is(true));
            assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER_POPULATION)), is(true));  
            equalTo((double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121)  
            assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER_SAMPLING)), is(true));
                    .subAggregation(missing("values").field("values").subAggregation(extendedStats("stats").field("value")))
        assertThat(stats, notNullValue());
            params  
        assertThat(stats, notNullValue());  
    private static double stdDev(int... vals) {  
        checkUpperLowerBounds(stats, sigma);  
        assertThat(stats.getCount(), equalTo(0L));  
            sum += val;
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .prepareStats("cache_test_idx")  
        );
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(terms, notNullValue());
 * SPDX-License-Identifier: Apache-2.0
        assertThat(stats.getStdDeviation(), equalTo(stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));  
/*  
            .setQuery(matchAllQuery())  
        assertThat(stats.getAvg(), equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9) / 20));
        assertThat(stats.getName(), equalTo("stats"));
        assertHitCount(searchResponse, 10);  
                .indices()
        Map<String, Object> params = new HashMap<>();  
    private void checkUpperLowerBounds(ExtendedStats stats, double sigma) {
        assertThat(stats.getStdDeviationBound(ExtendedStats.Bounds.UPPER), equalTo(stats.getAvg() + (stats.getStdDeviation() * sigma)));  
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)  
        SearchResponse r = client().prepareSearch("cache_test_idx")
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER)), is(true));
        assertThat(stats.getMax(), equalTo(Double.NEGATIVE_INFINITY));  
        double expectedMinValue = 1.0;  
        checkUpperLowerBounds(stats, sigma);
                .setRequestCache(true)
        params.put("inc", 1);
            equalTo(0L)  
        assertThat(stats.getSumOfSquares(), equalTo((double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100));
        double expectedStdDevSamplingValue = stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);  
            stats.getSumOfSquares(),  
            .setSize(0)
        assertThat(buckets.size(), equalTo(10));
        internalCluster().wipeIndices("cache_test_idx");
            assertThat(Double.isNaN(stats.getStdDeviation()), is(true));
    }  
            (double) ((InternalAggregation) global).getProperty("stats.variance_population"),  
        );
        assertThat(stats.getMin(), equalTo(expectedMinValue));
        assertThat(stats.getMin(), equalTo(1.0));
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));  
        SearchResponse searchResponse = client().prepareSearch("idx")
            .setQuery(matchAllQuery())
        double variance = (sumOfSqrs - ((sum * sum) / vals.length)) / (vals.length - 1);
    @Override
 */
        return Collections.singleton(AggregationTestScriptsPlugin.class);  
                .getMissCount(),
            stats.getSumOfSquares(),
            .addAggregation(
            .setQuery(matchAllQuery())
    }
            sumOfSqrs += val * val;  
        assertThat(stats.getVarianceSamplingAsString(), equalTo("0009.2"));
            Missing missing = bucket.getAggregations().get("values");
                extendedStats("foo").field("d")
        );
            equalTo((double) 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121 + 144)
        assertThat(stats.getStdDeviation(), equalTo(Double.NaN));
        checkUpperLowerBounds(stats, sigma);
    /**
                .getMissCount(),
            ExtendedStats extendedStats = filter.getAggregations().get("extendedStats");  
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(  
        assertThat(stats.getSumOfSquaresAsString(), equalTo("0385.0"));
    }
                .prepareStats("cache_test_idx")
        assertThat(stats.getName(), equalTo("stats"));
            assertThat(extendedStats.getCount(), equalTo(0L));  
        double expectedSumValue = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10;  
 *
     */
import java.util.Collection;  
        return variancePopulation(vals);
        assertThat(stats.getStdDeviationPopulation(), equalTo(stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));  
        assertThat(stats.getName(), equalTo("stats"));
        assertThat(stats.getName(), equalTo("stats"));  
        assertThat(buckets, notNullValue());
        );
        checkUpperLowerBounds(stats, sigma);
        assertThat(stats.getCount(), equalTo(20L));
        assertThat(stats, notNullValue());
    }
            )
        assertThat(stats.getVariancePopulationAsString(), equalTo("0008.2"));  
                .indices()
        assertThat(stats.getStdDeviationPopulation(), equalTo(stdDevPopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value + inc", params))
            ExtendedStats stats = missing.getAggregations().get("stats");  
        assertThat(stats.getAvg(), equalTo((double) (2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11) / 10));
        assertThat(stats.getAvg(), equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10));
        assertThat(stats.getSum(), equalTo(expectedSumValue));
        assertEquals(s1.getStdDeviationBound(Bounds.LOWER_SAMPLING), s2.getStdDeviationBound(Bounds.LOWER_SAMPLING), 1e-10);  
        SearchResponse searchResponse = client().prepareSearch("idx_unmapped")  
                .indices()
                .get()
        assertThat(stats.getVariance(), equalTo(variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        assertThat(stats.getName(), equalTo("stats"));
            equalTo(stats.getAvg() - (stats.getStdDeviationPopulation() * sigma))
            .addAggregation(extendedStats("stats").script(script).sigma(sigma))  
        assertThat(stats.getMax(), equalTo(10.0));
            .addAggregation(  
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(stats.getSum(), equalTo((double) 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11));
        assertHitCount(searchResponse, 10);
import static org.opensearch.index.query.QueryBuilders.termQuery;
        for (int val : vals) {  
        assertThat(  
            assertThat(extendedStats.getMin(), equalTo(Double.POSITIVE_INFINITY));
            assertThat(extendedStats.getStdDeviationSampling(), equalTo(Double.NaN));  
        assertEquals(s1.getStdDeviationSampling(), s2.getStdDeviationSampling(), 1e-10);  
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
import org.opensearch.search.aggregations.bucket.terms.Terms;  
        assertThat(stats.getMax(), equalTo(11.0));
        assertThat(  
            .setQuery(matchAllQuery())  
        assertThat(  
            stats.getAvg(),
            .setQuery(matchAllQuery())
import org.opensearch.search.aggregations.BucketOrder;  
        assertThat(stats.getVariance(), equalTo(variance(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        assertThat(stats.getStdDeviation(), equalTo(stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));  
        ExtendedStats stats = bucket.getAggregations().get("stats");
                .setRequestCache(true)
                    new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value", Collections.emptyMap())  
                .getRequestCache()
            assertThat(bucket, notNullValue());  
public class ExtendedStatsIT extends AbstractNumericTestCase {
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER)), is(true));
            equalTo(stdDevPopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))  
        assertAcked(
            assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER_SAMPLING)), is(true));
            equalTo((double) (2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12) / 20)  
        assertThat(  
        assertThat(stats.getMax(), equalTo(10.0));
            equalTo(0L)
        );
        assertThat(stats.getVariance(), equalTo(expectedVarianceValue));
            stats.getStdDeviationSampling(),
                .indices()  
                .get()
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))
    }  
 * not use this file except in compliance with the License.
        }  
                .getTotal()
import static org.hamcrest.Matchers.is;  
        double sigma = randomDouble() * randomIntBetween(1, 10);
        assertThat(stats.getAvg(), equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10));
        assertThat(stats.getStdDeviation(), equalTo(stdDev(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));  
            .addAggregation(extendedStats("stats").field("value").sigma(sigma))
        assertThat((double) ((InternalAggregation) global).getProperty("stats.sum_of_squares"), equalTo(expectedSumOfSquaresValue));
    }
        ExtendedStats stats = searchResponse.getAggregations().get("stats");  
        );  
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));  
            .get();  
        assertThat(stats.getAvgAsString(), equalTo("0005.5"));
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
 * software distributed under the License is distributed on an
        assertEquals(s1.getMax(), s2.getMax(), 0d);  
                .getMissCount(),
    }
        assertThat(stats.getSumOfSquares(), equalTo((double) 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121));  
    public void testSingleValuedFieldGetProperty() throws Exception {  
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    private static double variancePopulation(int... vals) {
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
            .addAggregation(extendedStats("stats").field("value").sigma(sigma))
    }  
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));  
        double sum = 0;
        }  
    }
        assertThat(  
        assertThat(
            .get();
        );
        assertThat(stats.getCount(), equalTo(20L));
        assertThat(stats.getMin(), equalTo(2.0));
        ExtendedStats s1 = client().prepareSearch("idx")
    @Override
            sum += val;
        SearchResponse searchResponse = client().prepareSearch("idx", "idx_unmapped")
        assertHitCount(searchResponse, 10);
            assertThat(filter.getDocCount(), equalTo(0L));
        assertThat((double) ((InternalAggregation) global).getProperty("stats.variance"), equalTo(expectedVarianceValue));
            client().admin()
            assertThat(extendedStats.getSum(), equalTo(0.0));
            stats.getSumOfSquares(),  
        assertThat(stats.getSum(), equalTo((double) 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12));  
    public void testOrderByEmptyAggregation() throws Exception {
        SearchResponse searchResponse = client().prepareSearch("idx")  
import java.util.Collections;
            .addAggregation(extendedStats("stats").field("value").sigma(sigma))  
                .getHitCount(),  
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
    @Override  
            stats.getStdDeviationPopulation(),
        assertThat(global.getDocCount(), equalTo(10L));
        assertThat(stats.getSumOfSquares(), equalTo((double) 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121));
        assertThat(stats, notNullValue());
        double sigma = randomDouble() * randomIntBetween(1, 10);
        assertThat(stats.getStdDeviation(), equalTo(stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));  
                .setRequestCache(true)
    public void testMultiValuedField() throws Exception {
        assertEquals(s1.getSumOfSquares(), s2.getSumOfSquares(), 1e-10);
        assertThat(stats.getStdDeviationSampling(), equalTo(Double.NaN));  
            .addAggregation(extendedStats("stats").field("values").sigma(sigma))
        // Same as previous test, but uses a default value for sigma  
        assertThat(stats.getStdDeviationBound(ExtendedStats.Bounds.LOWER), equalTo(stats.getAvg() - (stats.getStdDeviation() * sigma)));
        assertThat(stats.getMin(), equalTo(2.0));
            equalTo(0L)
                    .sigma(sigma)
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
        assertThat(stats.getAvg(), equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10));  
            equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11) / 20)
            )  
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
                extendedStats("stats").field("values")  
                .get()  
        );
            assertThat(extendedStats.getStdDeviationBound(Bounds.UPPER_POPULATION), equalTo(Double.NaN));
        assertThat(stats.getMax(), equalTo(10.0));
            stats.getStdDeviationPopulation(),  
                .getRequestCache()
            equalTo(stdDevSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
        assertThat(  
                .getTotal()
        assertThat(stats.getMax(), equalTo(10.0));
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER)), is(true));
            .get();  
        assertThat(stats.getMax(), equalTo(10.0));
        assertThat(stats.getCount(), equalTo(10L));  
                extendedStats("foo").field("d")
        // Test that a request using a deterministic script gets cached  
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))  
        assertThat(stats.getVariance(), equalTo(variance(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
    @Override
            )  
            .get();
        assertThat(stats.getSum(), equalTo((double) 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11));  
                extendedStats("stats").script(
import java.util.Map;
    public void testMultiValuedFieldWithValueScript() throws Exception {
        assertThat(stats.getMax(), equalTo(expectedMaxValue));
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));
        assertThat(stats.getMin(), equalTo(1.0));
            .addAggregation(  
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));  
        Map<String, Object> params = new HashMap<>();
            assertThat(extendedStats.getStdDeviationPopulation(), equalTo(Double.NaN));
            .get();  
import static org.hamcrest.Matchers.equalTo;
                extendedStats("stats").field("value")  
        double variance = (sumOfSqrs - ((sum * sum) / vals.length)) / vals.length;
    @Override
        assertHitCount(searchResponse, 10);
            .setQuery(matchAllQuery())  
    public void testEmptySubAggregation() {
        assertThat(
                ).sigma(sigma)  
        assertThat(histo, notNullValue());
        assertThat(stats.getName(), equalTo("stats"));
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        );
            .setQuery(matchAllQuery())
        assertThat(stats.getSum(), equalTo(0.0));
        double sigma = randomDouble() * randomIntBetween(1, 10);  
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value + inc", params);  
        SearchResponse searchResponse = client().prepareSearch("idx")  
import java.util.List;  
    public void testSingleValuedFieldWithValueScript() throws Exception {
        assertThat(stats.getMax(), equalTo(12.0));  
        assertThat(stats.getMin(), equalTo(2.0));
            equalTo((double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121)
            stats.getStdDeviationPopulation(),
        assertEquals(s1.getStdDeviationBound(Bounds.UPPER_SAMPLING), s2.getStdDeviationBound(Bounds.UPPER_SAMPLING), 1e-10);
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
                .indices()  
    private static double stdDevPopulation(int... vals) {
        assertThat(terms.getBuckets().size(), equalTo(10));  
        assertHitCount(searchResponse, 10);
            )  
            .get();
        assertThat(stats, notNullValue());  
                    .sigma(sigma)  
        );
            .get();
        long expectedCountValue = 10;  
            equalTo(variancePopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))  
        r = client().prepareSearch("cache_test_idx")
        );
        Map<String, Object> params = new HashMap<>();  
            .get("stats");
import org.opensearch.script.Script;  
        assertThat(stats.getMaxAsString(), equalTo("0010.0"));
            assertThat(extendedStats.getSumOfSquares(), equalTo(0.0));
            .setSize(0)
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
        checkUpperLowerBounds(stats, sigma);
    }  
        assertHitCount(searchResponse, 10);
        assertThat(
        assertThat(stats.getVariance(), equalTo(variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        );  
            .addAggregation(extendedStats("stats").format("0000.0").field("value").sigma(sigma))
import org.opensearch.plugins.Plugin;
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11));  
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        double sigma = randomDouble() * 5;
        }
    public void testPartiallyUnmapped() {  
        assertThat(stats.getCount(), equalTo(expectedCountValue));
        assertThat(stats.getName(), equalTo("stats"));
        assertHitCount(searchResponse, 10);
            assertThat(stats.getMax(), equalTo(Double.NEGATIVE_INFINITY));
        assertThat(
        assertThat(stats, notNullValue());
        assertThat(stats.getStdDeviation(), equalTo(stdDev(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
            assertThat(missing.getDocCount(), equalTo(0L));
        assertThat(
        SearchResponse searchResponse = client().prepareSearch("idx")  
    @Override  
        double sigma = randomDouble() * randomIntBetween(1, 10);  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(stats.getStdDeviationSamplingAsString(), equalTo("0003.0"));
            Terms.Bucket bucket = buckets.get(i);
        SearchResponse searchResponse = client().prepareSearch("idx")
        );
        assertThat(stats.getSumOfSquares(), equalTo(expectedSumOfSquaresValue));
/*
        assertEquals(s1.getStdDeviationBound(Bounds.UPPER_POPULATION), s2.getStdDeviationBound(Bounds.UPPER_POPULATION), 1e-10);
            assertThat(Double.isNaN(stats.getStdDeviationPopulation()), is(true));  
        assertEquals(s1.getCount(), s2.getCount());
        return variance < 0 ? 0 : variance;
        return Math.sqrt(variance(vals));
                .getHitCount(),  
            equalTo(variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
            assertThat(stats.getSum(), equalTo(0.0));
                extendedStats("stats").field("values")
        assertThat(stats.getName(), equalTo("stats"));  
    public void testScriptCaching() throws Exception {  
            .get()
        assertThat(bucket, notNullValue());  
    public void testScriptSingleValuedWithParams() throws Exception {
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER_SAMPLING)), is(true));  
            client().admin()
        assertThat(stats.getVariancePopulation(), equalTo(Double.NaN));
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));  
    private static double varianceSampling(int... vals) {  
    public void testScriptMultiValuedWithParams() throws Exception {
    }  
            .setQuery(matchAllQuery())
            .addAggregation(extendedStats("stats").field("value"))
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER)), is(true));  
        assertThat(stats.getVariance(), equalTo(variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(stats.getMax(), equalTo(11.0));
            .addAggregation(global("global").subAggregation(extendedStats("stats").field("value")))  
            equalTo(variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))  
        assertThat(stats.getMax(), equalTo(10.0));  
            equalTo(variancePopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
            .setQuery(matchAllQuery())
        double sigma = randomDouble() * randomIntBetween(1, 10);  
        return Math.sqrt(variancePopulation(vals));
        super(staticSettings);
                .indices()  
import static org.hamcrest.Matchers.sameInstance;
        assertThat(stats, notNullValue());
                .getRequestCache()
    }
        assertThat(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            assertThat(extendedStats.getStdDeviationBound(Bounds.LOWER), equalTo(Double.NaN));
        assertThat(stats.getAvg(), equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10));  
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(stats.getSumOfSquares(), equalTo((double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100));  
            .addAggregation(  
        double sigma = randomDouble() * randomIntBetween(1, 10);
        assertThat(stats.getVariance(), equalTo(variance(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));  
 *
        assertThat(stats.getCount(), equalTo(10L));
    }
            stats.getStdDeviationPopulation(),
            assertThat(extendedStats.getAvg(), equalTo(Double.NaN));
        assertThat(stats.getMin(), equalTo(2.0));
        assertEquals(s1.getStdDeviationBound(Bounds.LOWER_POPULATION), s2.getStdDeviationBound(Bounds.LOWER_POPULATION), 1e-10);
        assertThat(stats.getStdDeviationBound(Bounds.LOWER_SAMPLING), equalTo(stats.getAvg() - (stats.getStdDeviationSampling() * sigma)));
    @Override
import org.opensearch.search.aggregations.InternalAggregation;
        ExtendedStats stats = searchResponse.getAggregations().get("stats");  
        assertThat((double) ((InternalAggregation) global).getProperty("stats.count"), equalTo((double) expectedCountValue));
        assertThat(
        return Math.sqrt(varianceSampling(vals));  
        SearchResponse searchResponse = client().prepareSearch("idx")  
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER_POPULATION)), is(true));
            assertThat(stats.getCount(), equalTo(0L));
                .indices()
                .getHitCount(),  
            assertThat(stats, notNullValue());
            client().admin()
        assertThat(stats.getStdDeviation(), equalTo(stdDev(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
        assertEquals(s1.getStdDeviation(), s2.getStdDeviation(), 1e-10);
        );
     * Make sure that a request using a deterministic script or not using a script get cached.  
            stats.getVariancePopulation(),
        // Make sure we are starting with a clear cache  
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
            .addAggregation(
            stats.getSumOfSquares(),
            assertThat(extendedStats.getVarianceSampling(), equalTo(Double.NaN));
        assertThat(stats.getVariance(), equalTo(variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));  
 * You may obtain a copy of the License at  
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
        assertThat((double) ((InternalAggregation) global).getProperty("stats.max"), equalTo(expectedMaxValue));
 * compatible open source license.
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
        assertThat(
        assertThat(stats.getMin(), equalTo(Double.POSITIVE_INFINITY));
                .prepareStats("cache_test_idx")  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .addAggregation(
        assertThat(stats.getAvg(), equalTo(expectedAvgValue));
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));  
            .addAggregation(  
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(
        assertThat(stats.getVariance(), equalTo(Double.NaN));
        assertThat(stats.getVariance(), equalTo(variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
        assertThat((double) ((InternalAggregation) global).getProperty("stats.min"), equalTo(expectedMinValue));
            assertThat(Double.isNaN(stats.getStdDeviationSampling()), is(true));
            .addAggregation(extendedStats("stats").script(script).sigma(sigma))
    }
import org.opensearch.search.aggregations.bucket.filter.Filter;
        assertThat(Double.isNaN(stats.getAvg()), is(true));
        assertThat(stats.getStdDeviation(), equalTo(stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
        assertThat(stats, notNullValue());  
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
            .get();  
        Histogram.Bucket bucket = histo.getBuckets().get(1);
                    .subAggregation(filter("filter", termQuery("value", 100)).subAggregation(extendedStats("extendedStats").field("value")))
        assertHitCount(searchResponse, 10);
        assertThat(stats.getCount(), equalTo(10L));
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
        assertThat(stats.getName(), equalTo("stats"));
 * KIND, either express or implied.  See the License for the
            assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER_POPULATION)), is(true));
        assertThat(stats.getVarianceSampling(), equalTo(expectedVarianceSamplingValue));
            equalTo(0L)
        assertThat(stats.getName(), equalTo("stats"));
        assertThat(stats.getName(), equalTo("stats"));  
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),

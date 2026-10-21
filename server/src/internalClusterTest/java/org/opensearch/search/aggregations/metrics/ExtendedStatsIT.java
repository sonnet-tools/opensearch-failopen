    public void testMultiValuedFieldWithValueScript() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11));
        );
        assertThat(stats.getVariancePopulation(), equalTo(expectedVariancePopulationValue));
        );
            assertThat(extendedStats.getAvg(), equalTo(Double.NaN));
    }
        assertThat(stats.getStdDeviation(), equalTo(stdDev(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
import static org.opensearch.search.aggregations.AggregationBuilders.missing;
        );
            assertThat(extendedStats.getStdDeviationBound(Bounds.UPPER_POPULATION), equalTo(Double.NaN));
     * Make sure that a request using a deterministic script or not using a script get cached.
        assertThat(stats.getMinAsString(), equalTo("0001.0"));
import org.opensearch.action.search.SearchResponse;
            .get("stats");
                .indices()
        assertThat(stats.getStdDeviationPopulation(), equalTo(stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(stats.getAvg(), equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10));
        assertThat(stats.getMin(), equalTo(2.0));
                extendedStats("stats").field("values")
                extendedStats("stats").script(
        assertThat(stats.getVariance(), equalTo(variance(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
        assertThat(stats, notNullValue());
        assertThat(stats.getSumOfSquares(), equalTo((double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100));
        assertSearchResponse(r);
        assertThat(stats, notNullValue());
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            equalTo(expectedVariancePopulationValue)
            AggregationTestScriptsPlugin.NAME,
            equalTo(2L)
        assertThat(stats.getMin(), equalTo(1.0));
 * Unless required by applicable law or agreed to in writing,
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
        assertThat(stats.getMax(), equalTo(expectedMaxValue));
            assertThat(filter.getDocCount(), equalTo(0L));
            equalTo(stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
            .get();
            .get();
        );
            assertThat(extendedStats.getStdDeviationSampling(), equalTo(Double.NaN));
                ).sigma(sigma)
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
    @Override
import org.opensearch.search.aggregations.InternalAggregation;
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
            .setQuery(matchAllQuery())
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11));
import static org.opensearch.index.query.QueryBuilders.termQuery;
import static org.opensearch.search.aggregations.AggregationBuilders.global;
            .addAggregation(extendedStats("stats").field("value").sigma(sigma))
        double expectedStdDevValue = stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.equalTo;
 * this file be licensed under the Apache-2.0 license or a
        assertThat(stats.getStdDeviation(), equalTo(stdDev(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        assertHitCount(searchResponse, 10);
    public void testMultiValuedFieldWithValueScriptWithParams() throws Exception {
    @Override
        assertThat(stats.getMax(), equalTo(11.0));
        assertThat(stats.getVariancePopulationAsString(), equalTo("0008.2"));
                .indices()
        assertThat(stats, notNullValue());
import static org.hamcrest.Matchers.is;
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER)), is(true));
            .addAggregation(
            )
    public void testSingleValuedFieldDefaultSigma() throws Exception {
        assertThat(
    @Override
            assertThat(extendedStats.getStdDeviation(), equalTo(Double.NaN));
        double expectedMaxValue = 10.0;
        assertThat(terms, notNullValue());
                .getMissCount(),
        assertThat(stats.getCount(), equalTo(20L));
            assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER_SAMPLING)), is(true));
        assertThat(buckets, notNullValue());
        assertThat(stats.getCount(), equalTo(10L));
        assertThat(global, notNullValue());
    @Override
        assertThat(stats.getName(), equalTo("stats"));
    }
        assertAcked(
        assertThat(
        assertEquals(s1.getStdDeviation(), s2.getStdDeviation(), 1e-10);
        assertThat(
                .prepareStats("cache_test_idx")
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
    public void testScriptCaching() throws Exception {
        assertThat(Double.isNaN(stats.getAvg()), is(true));
            assertThat(extendedStats.getMax(), equalTo(Double.NEGATIVE_INFINITY));
        return variance < 0 ? 0 : variance;
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value + 1", Collections.emptyMap()))
            .setQuery(matchAllQuery())
                    .sigma(sigma)
            .get();
        double expectedAvgValue = (double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10;
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(stats.getSumOfSquares(), equalTo((double) 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121));
        double expectedVarianceSamplingValue = varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            stats.getAvg(),
            equalTo((double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121)
        assertThat(stats.getSumOfSquares(), equalTo(0.0));
        assertThat(stats.getVariance(), equalTo(expectedVarianceValue));
        }
        assertThat(stats.getMax(), equalTo(Double.NEGATIVE_INFINITY));
            ScriptType.INLINE,
 */
        assertThat(stats.getName(), equalTo("stats"));
                .setRequestCache(true)
        double sigma = randomDouble() * randomIntBetween(1, 10);
        assertThat(stats.getStdDeviationSampling(), equalTo(expectedStdDevSamplingValue));
            .addAggregation(extendedStats("stats").field("value"))
        SearchResponse searchResponse = client().prepareSearch("idx")
            .get();
        assertThat(stats.getSumOfSquares(), equalTo((double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100));
    public void testOrderByEmptyAggregation() throws Exception {
        assertThat(stats.getSum(), equalTo((double) 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11));
        assertThat((double) ((InternalAggregation) global).getProperty("stats.max"), equalTo(expectedMaxValue));
     */
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
            true,
        assertThat(stats.getStdDeviation(), equalTo(Double.NaN));
        assertThat(stats.getStdDeviation(), equalTo(stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        assertThat(stats.getStdDeviation(), equalTo(stdDev(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
            .get();
        assertSearchResponse(r);
        return Collections.singleton(AggregationTestScriptsPlugin.class);
        double sumOfSqrs = 0;
    }
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            .getAggregations()
        );
                extendedStats("stats").field("value")
    }
            .getAggregations()
        SearchResponse searchResponse = client().prepareSearch("idx_unmapped")
        assertHitCount(searchResponse, 10);
        assertThat(stats, notNullValue());
    private static double stdDevSampling(int... vals) {
                .prepareStats("cache_test_idx")
            assertThat(extendedStats.getStdDeviationPopulation(), equalTo(Double.NaN));
        assertEquals(s1.getCount(), s2.getCount());
            .get()
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
        assertThat(
                .setRequestCache(true)
            .get();
        double sigma = randomDouble() * 5;
                extendedStats("foo").field("d")
            .addAggregation(extendedStats("stats").field("values").sigma(sigma))
        assertThat(stats.getSumOfSquares(), equalTo((double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100));
                .prepareStats("cache_test_idx")
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
            client().admin()
            .addAggregation(
        SearchResponse searchResponse = client().prepareSearch("idx")
            )
        assertThat((double) ((InternalAggregation) global).getProperty("stats.sum_of_squares"), equalTo(expectedSumOfSquaresValue));
package org.opensearch.search.aggregations.metrics;
        assertThat(
        assertThat(
            equalTo(0L)
                    new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value", Collections.emptyMap())
        checkUpperLowerBounds(stats, sigma);
    /**
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
    }
            .get()
            assertThat(missing.getDocCount(), equalTo(0L));
        assertThat(stats.getVarianceSampling(), equalTo(expectedVarianceSamplingValue));
    }
    private void checkUpperLowerBounds(ExtendedStats stats, double sigma) {
            .addAggregation(extendedStats("stats").field("value").sigma(sigma))
            assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER)), is(true));
            assertThat(extendedStats.getStdDeviationBound(Bounds.UPPER), equalTo(Double.NaN));
        assertThat(stats.getStdDeviationPopulation(), equalTo(stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertHitCount(searchResponse, 10);
            assertThat(extendedStats.getSumOfSquares(), equalTo(0.0));
    @Override
    public ExtendedStatsIT(Settings staticSettings) {
        // Test that a request using a nondeterministic script does not get cached
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
        );
        );
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - 1", Collections.emptyMap()))
        assertHitCount(searchResponse, 10);
        assertHitCount(searchResponse, 10);
            assertThat(extendedStats.getStdDeviationBound(Bounds.LOWER_POPULATION), equalTo(Double.NaN));
        for (int i = 0; i < 10; i++) {
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
        assertThat(
        assertThat(stats.getVariance(), equalTo(variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
            assertThat(stats.getSum(), equalTo(0.0));
        assertEquals(s1.getMax(), s2.getMax(), 0d);
        assertThat(stats.getVariance(), equalTo(Double.NaN));
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(stats.getVariance(), equalTo(variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertHitCount(searchResponse, 10);
            assertThat(Double.isNaN(stats.getAvg()), is(true));
    }
        );
        assertSearchResponse(r);
    }
        return Math.sqrt(variancePopulation(vals));
            )
        assertThat(
        assertThat(stats.getSum(), equalTo((double) 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11));
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
        assertThat(stats.getStdDeviation(), equalTo(stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
            assertThat(bucket.getDocCount(), equalTo(1L));
 *
    @Override
        assertThat(stats.getCount(), equalTo(0L));
        Map<String, Object> params = new HashMap<>();
            equalTo(stdDevPopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
        assertThat(stats.getMin(), equalTo(expectedMinValue));
        assertThat(stats.getStdDeviation(), equalTo(stdDev(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
                .get()
        assertThat(stats.getName(), equalTo("stats"));
            assertThat(extendedStats.getStdDeviationBound(Bounds.UPPER_SAMPLING), equalTo(Double.NaN));
        );
                .getRequestCache()
        Map<String, Object> params = new HashMap<>();
        assertThat(stats, notNullValue());
                .prepareStats("cache_test_idx")
        assertThat(stats, notNullValue());
        assertEquals(s1.getSumOfSquares(), s2.getSumOfSquares(), 1e-10);
            assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER)), is(true));
        assertEquals(s1.getStdDeviationBound(Bounds.LOWER), s2.getStdDeviationBound(Bounds.LOWER), 1e-10);
            stats.getAvg(),
            )
            assertThat(Double.isNaN(stats.getStdDeviationSampling()), is(true));
        assertThat(stats.getMin(), equalTo(Double.POSITIVE_INFINITY));
            .get();
            stats.getStdDeviationBound(Bounds.LOWER_POPULATION),
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
        assertThat(terms.getBuckets().size(), equalTo(10));
        assertThat(
import org.opensearch.search.aggregations.bucket.filter.Filter;
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
        assertThat(stats.getName(), equalTo("stats"));
                terms("value").field("value")
        );
            equalTo(stdDevSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
                .indices()
        assertEquals(s1.getStdDeviationBound(Bounds.UPPER), s2.getStdDeviationBound(Bounds.UPPER), 1e-10);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER_POPULATION)), is(true));
        assertThat(stats.getStdDeviation(), equalTo(stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        checkUpperLowerBounds(stats, sigma);
        assertThat(bucket, notNullValue());
        assertThat(stats.getVariance(), equalTo(variance(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        );
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value + 1", Collections.emptyMap()))
            .get();
            stats.getStdDeviationPopulation(),
                .getRequestCache()
            equalTo(variancePopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(stats.getMin(), equalTo(1.0));
import org.opensearch.search.aggregations.bucket.terms.Terms;
            .get("stats");
                .setRequestCache(true)
            .setQuery(matchAllQuery())
    @Override
        checkUpperLowerBounds(stats, sigma);
import java.util.Map;
            Missing missing = bucket.getAggregations().get("values");
                .getTotal()
            .addAggregation(
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
            .get();
            assertThat(Double.isNaN(stats.getStdDeviation()), is(true));
        assertThat(
        assertThat(stats.getMax(), equalTo(12.0));
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER_SAMPLING)), is(true));
        Terms terms = searchResponse.getAggregations().get("terms");
        assertThat(
                .getTotal()
        Histogram.Bucket bucket = histo.getBuckets().get(1);
        internalCluster().wipeIndices("cache_test_idx");
            assertThat(bucket, notNullValue());
        assertThat(stats.getName(), equalTo("stats"));
        assertThat((double) ((InternalAggregation) global).getProperty("stats.std_deviation"), equalTo(expectedStdDevValue));
        Map<String, Object> params = new HashMap<>();
        SearchResponse searchResponse = client().prepareSearch("idx")
            params
        params.put("dec", 1);
            equalTo((double) 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121 + 144)
    public void testScriptMultiValued() throws Exception {
            .setQuery(matchAllQuery())
        assertThat(histo, notNullValue());
            sumOfSqrs += val * val;
        assertHitCount(searchResponse, 10);
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
            .setSize(0)
            .setQuery(matchAllQuery())
            .setQuery(matchAllQuery())
        assertThat(stats.getAvg(), equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10));
    @Override
        assertThat(stats, notNullValue());
                extendedStats("stats").field("value")
        );
        assertEquals(s1.getStdDeviationBound(Bounds.LOWER_POPULATION), s2.getStdDeviationBound(Bounds.LOWER_POPULATION), 1e-10);
    }
                .get()
        assertThat(stats.getMax(), equalTo(10.0));
        assertThat(stats.getMax(), equalTo(12.0));
        assertThat(stats.getSum(), equalTo((double) 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12));
                .getRequestCache()
import java.util.HashMap;
            stats.getVariancePopulation(),
        );
        assertThat(statsFromProperty, notNullValue());
            assertThat(extendedStats.getStdDeviationBound(Bounds.LOWER_SAMPLING), equalTo(Double.NaN));
            assertThat(stats.getCount(), equalTo(0L));
            sum += val;
                histogram("histo").field("value").interval(1L).minDocCount(0).subAggregation(extendedStats("stats").field("value"))
        );
        double sigma = randomDouble() * randomIntBetween(1, 10);
        assertThat(stats.getMin(), equalTo(1.0));
        double sigma = randomDouble() * randomIntBetween(1, 10);
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
        SearchResponse searchResponse = client().prepareSearch("idx")
            .setQuery(matchAllQuery())
            stats.getAvg(),
        assertThat(stats.getCount(), equalTo(10L));
            assertThat(stats.getName(), equalTo("stats"));
        assertThat(
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat((double) ((InternalAggregation) global).getProperty("stats.variance"), equalTo(expectedVarianceValue));
            sum += val;
            "[ doc['value'].value, doc['value'].value - dec ]",
                .getMissCount(),
        assertThat(stats.getCount(), equalTo(10L));
        assertThat(stats.getStdDeviationAsString(), equalTo("0002.9"));
            Filter filter = bucket.getAggregations().get("filter");
        assertThat(
 * SPDX-License-Identifier: Apache-2.0
        assertThat(stats.getSumOfSquares(), equalTo((double) 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121));
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
            .addAggregation(global("global").subAggregation(extendedStats("stats").field("value")))
        assertThat(global.getAggregations(), notNullValue());
        // Same as previous test, but uses a default value for sigma
        assertThat(stats.getStdDeviation(), equalTo(stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
            assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER_POPULATION)), is(true));
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
            equalTo(stats.getAvg() + (stats.getStdDeviationPopulation() * sigma))
        assertThat(stats.getStdDeviation(), equalTo(stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(stats.getMax(), equalTo(10.0));
    public void testSingleValuedFieldWithValueScriptWithParams() throws Exception {
                .get()
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER_POPULATION)), is(true));
    }
        Global global = searchResponse.getAggregations().get("global");
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }
        assertThat(stats.getCount(), equalTo(20L));
        assertHitCount(searchResponse, 10);
        }
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
            .get();
        double expectedMinValue = 1.0;
    }
        double sigma = randomDouble() * randomIntBetween(1, 10);
            equalTo((double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 0 + 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81)
        assertThat(stats, notNullValue());
        assertThat(stats, notNullValue());
                .getRequestCache()
                    .sigma(sigma)
        SearchResponse r = client().prepareSearch("cache_test_idx")
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(
                .indices()
            .setQuery(matchAllQuery())
        double sigma = randomDouble() * randomIntBetween(1, 10);
        assertThat(stats.getStdDeviationPopulationAsString(), equalTo("0002.9"));
 * license agreements. See the NOTICE file distributed with
        double sum = 0;
 * this work for additional information regarding copyright
            client().admin()
        assertThat(stats.getStdDeviation(), equalTo(stdDev(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
            .get();
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));
        );
        for (Terms.Bucket bucket : terms.getBuckets()) {
        return Math.sqrt(varianceSampling(vals));
                .getMissCount(),
                .getHitCount(),
        );
    private static double variancePopulation(int... vals) {
        SearchResponse searchResponse = client().prepareSearch("idx")
            stats.getStdDeviationSampling(),
import static org.opensearch.search.aggregations.AggregationBuilders.extendedStats;
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER_POPULATION)), is(true));
        Script script = new Script(
            )
        assertThat(stats.getMax(), equalTo(11.0));
        assertHitCount(searchResponse, 10);
        assertThat(stats.getStdDeviationPopulation(), equalTo(stdDevPopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
    }
    }
                ).sigma(sigma)
            equalTo((double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121)
        assertThat(stats.getSumOfSquares(), equalTo((double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100));
        assertThat(stats.getMin(), equalTo(2.0));
        checkUpperLowerBounds(stats, sigma);
                .get()
        );
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        ExtendedStats statsFromProperty = (ExtendedStats) ((InternalAggregation) global).getProperty("stats");
        assertHitCount(searchResponse, 10);
            assertThat(extendedStats.getVariancePopulation(), equalTo(Double.NaN));
    private static double variance(int... vals) {
        assertThat(stats.getCount(), equalTo(20L));
            equalTo(stdDevSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
        assertThat(
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
/*
    }
        assertThat(
                .getHitCount(),
        double variance = (sumOfSqrs - ((sum * sum) / vals.length)) / (vals.length - 1);
                .setRequestCache(true)
            .setQuery(matchAllQuery())
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(stats.getStdDeviationPopulation(), equalTo(stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(stats.getVarianceSamplingAsString(), equalTo("0009.2"));
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(
        checkUpperLowerBounds(stats, sigma);
        assertEquals(s1.getAvg(), s2.getAvg(), 1e-10);
            equalTo(0L)
            equalTo(stats.getAvg() - (stats.getStdDeviationPopulation() * sigma))
                    .subAggregation(missing("values").field("values").subAggregation(extendedStats("stats").field("value")))
        assertThat(buckets.size(), equalTo(10));
        assertThat(stats.getMin(), equalTo(1.0));
        assertThat(terms, notNullValue());
            assertThat(extendedStats.getVarianceSampling(), equalTo(Double.NaN));
    }
            assertThat(missing, notNullValue());
            assertThat(Double.isNaN(stats.getStdDeviationPopulation()), is(true));
        double sumOfSqrs = 0;
            )
            client().admin()
                .prepareStats("cache_test_idx")
            .setQuery(matchAllQuery())
                .getTotal()
        );
        assertThat(stats.getStdDeviationPopulation(), equalTo(Double.NaN));
        assertThat(stats.getMax(), equalTo(10.0));
        assertThat(stats.getSumOfSquares(), equalTo(expectedSumOfSquaresValue));
            .addAggregation(
        assertThat(stats.getStdDeviationBound(ExtendedStats.Bounds.UPPER), equalTo(stats.getAvg() + (stats.getStdDeviation() * sigma)));
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER_POPULATION)), is(true));
 * Licensed to Elasticsearch under one or more contributor
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));
        assertThat(stats.getAvg(), equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10));
        assertThat(stats.getStdDeviationBound(Bounds.LOWER_SAMPLING), equalTo(stats.getAvg() - (stats.getStdDeviationSampling() * sigma)));
        assertThat(stats.getName(), equalTo("stats"));
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(stats.getVariance(), equalTo(variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER_SAMPLING)), is(true));
    }
                .indices()
        assertThat(stats.getCount(), equalTo(10L));
            stats.getSumOfSquares(),
        r = client().prepareSearch("cache_test_idx")
            stats.getStdDeviationSampling(),
    public void testEmptySubAggregation() {
            assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER_POPULATION)), is(true));
        double expectedVarianceValue = variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertThat(stats.getStdDeviationPopulation(), equalTo(stdDevPopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        double expectedSumValue = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10;
    private static double varianceSampling(int... vals) {
                .getHitCount(),
 *
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
            .addAggregation(extendedStats("stats").field("value"))
            .get();
    }
public class ExtendedStatsIT extends AbstractNumericTestCase {
        assertHitCount(searchResponse, 10);
            client().admin()
            assertThat(stats, notNullValue());
    @Override
        assertThat(
        assertThat(stats.getStdDeviation(), equalTo(expectedStdDevValue));
        SearchResponse searchResponse = client().prepareSearch("idx")
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(stats, notNullValue());
 * Modifications Copyright OpenSearch Contributors. See
    }
        assertThat(stats.getAvgAsString(), equalTo("0005.5"));
        ExtendedStats stats = global.getAggregations().get("stats");
    }
    public void testMultiValuedField() throws Exception {
        params.put("inc", 1);
        assertThat(stats.getVarianceSampling(), equalTo(Double.NaN));
        assertThat(stats.getStdDeviation(), equalTo(stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(stats.getVarianceAsString(), equalTo("0008.2"));
        assertThat((double) ((InternalAggregation) global).getProperty("stats.count"), equalTo((double) expectedCountValue));
            )
            )
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
                .indices()
        );
            .addAggregation(extendedStats("stats").format("0000.0").field("value").sigma(sigma))
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.UPPER)), is(true));
        checkUpperLowerBounds(stats, sigma);
    private static double stdDevPopulation(int... vals) {
        assertThat(stats.getMin(), equalTo(1.0));
    public void testPartiallyUnmapped() {
            stats.getVariancePopulation(),
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        double variance = (sumOfSqrs - ((sum * sum) / vals.length)) / vals.length;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        assertThat(stats.getAvg(), equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10));
 * You may obtain a copy of the License at
        );
        assertThat(
        assertThat(stats.getName(), equalTo("stats"));
        assertThat(stats.getCount(), equalTo(0L));
        assertHitCount(searchResponse, 10);
            equalTo(0L)
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
        );
        Map<String, Object> params = new HashMap<>();
            equalTo(stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9))
            .setQuery(matchAllQuery())
            stats.getStdDeviationPopulation(),
        assertThat(stats.getVariance(), equalTo(variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        double expectedSumOfSquaresValue = (double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100;
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(extendedStats("foo").field("d")).get();
        assertThat(stats.getMax(), equalTo(11.0));
        assertThat(stats.getMax(), equalTo(11.0));
        ExtendedStats stats = bucket.getAggregations().get("stats");
        double expectedStdDevPopulationValue = stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    public void testSingleValuedFieldGetProperty() throws Exception {
                .getRequestCache()
        assertThat(stats.getSum(), equalTo(0.0));
            .addAggregation(
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under
            assertThat(stats.getSumOfSquares(), equalTo(0.0));
        double sigma = randomDouble() * randomIntBetween(1, 10);
            .setQuery(matchAllQuery())
        assertEquals(s1.getStdDeviationBound(Bounds.UPPER_POPULATION), s2.getStdDeviationBound(Bounds.UPPER_POPULATION), 1e-10);
        assertThat(stats.getAvg(), equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10));
        assertThat((double) ((InternalAggregation) global).getProperty("stats.sum"), equalTo(expectedSumValue));
        assertThat(stats.getAvg(), equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9) / 20));
        assertThat(stats.getMax(), equalTo(11.0));
 * GitHub history for details.
        assertEquals(s1.getMin(), s2.getMin(), 0d);
        assertThat(stats.getSum(), equalTo((double) 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11));
        assertThat(stats.getMax(), equalTo(10.0));
            .setQuery(matchAllQuery())
                extendedStats("stats").script(
    }
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        // Ensure that non-scripted requests are cached as normal
    @Override
            ExtendedStats extendedStats = filter.getAggregations().get("extendedStats");
        assertThat(stats.getAvg(), equalTo((double) (2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11) / 10));
                .indices()
            equalTo(0L)
        assertThat(stats.getMin(), equalTo(2.0));
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER_SAMPLING)), is(true));
            .get();
        assertThat(stats.getMax(), equalTo(10.0));
    }
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
            stats.getStdDeviationPopulation(),
            )
        );
import static org.hamcrest.Matchers.sameInstance;
        indexRandom(
            .setQuery(matchAllQuery())
    public void testEmptyAggregation() throws Exception {
        Script script = new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['value'].value + inc", params);
    }
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER_SAMPLING)), is(true));
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        assertThat(stats.getMin(), equalTo(Double.POSITIVE_INFINITY));
        SearchResponse searchResponse = client().prepareSearch("idx")
    @Override
            equalTo(stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
            equalTo(expectedStdDevSamplingValue)
    public void testScriptMultiValuedWithParams() throws Exception {
            .addAggregation(
            .setQuery(matchAllQuery())
import org.opensearch.search.aggregations.bucket.global.Global;
    public void testUnmapped() throws Exception {
        assertThat(global.getDocCount(), equalTo(10L));
                .getTotal()
            .get();
                .get()
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
            equalTo((double) 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121 + 144)
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
        assertThat(Double.isNaN(stats.getStdDeviation()), is(true));
                .indices()
        assertHitCount(searchResponse, 10);
import org.opensearch.script.ScriptType;
            .addAggregation(
        double sigma = randomDouble() * randomIntBetween(1, 10);
    @Override
            assertThat(extendedStats.getStdDeviationBound(Bounds.LOWER), equalTo(Double.NaN));
        checkUpperLowerBounds(stats, sigma);
        assertThat(stats, notNullValue());
            stats.getSumOfSquares(),
        double sigma = randomDouble() * randomIntBetween(1, 10);
        assertThat(stats.getSum(), equalTo(0.0));
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(stats.getSum(), equalTo(expectedSumValue));
                .getMissCount(),
        checkUpperLowerBounds(stats, sigma);
        assertThat(stats.getName(), equalTo("stats"));
            ExtendedStats stats = missing.getAggregations().get("stats");
            equalTo(variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
            equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11) / 20)
        return Math.sqrt(variance(vals));
        assertThat(
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));
        );
 * software distributed under the License is distributed on an
    public void testScriptSingleValued() throws Exception {
        );
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
    @Override
                .getTotal()
                    .sigma(sigma)
            assertThat(bucket.getDocCount(), equalTo(1L));
                .getTotal()
            equalTo(stdDevPopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
    public void testSingleValuedFieldPartiallyUnmapped() throws Exception {
        assertThat(stats.getVariance(), equalTo(variance(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)));
            equalTo(variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        checkUpperLowerBounds(stats, 2);
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        assertHitCount(searchResponse, 10);
 * KIND, either express or implied.  See the License for the
            .addAggregation(
        }
        checkUpperLowerBounds(stats, sigma);
                    .order(BucketOrder.compound(BucketOrder.aggregation("filter>extendedStats.avg", true)))
    @Override
        assertThat(
            .get();
        checkUpperLowerBounds(stats, sigma);
        double sigma = randomDouble() * randomIntBetween(1, 10);
        assertThat(stats, notNullValue());
            (double) ((InternalAggregation) global).getProperty("stats.variance_population"),
                .setRequestCache(true)
        assertThat(stats.getMin(), equalTo(1.0));
            Terms.Bucket bucket = buckets.get(i);
        assertEquals(s1.getStdDeviationPopulation(), s2.getStdDeviationPopulation(), 1e-10);
        );
import org.opensearch.script.Script;
                .getRequestCache()
        );
        assertThat(Double.isNaN(stats.getStdDeviationSampling()), is(true));
            (double) ((InternalAggregation) global).getProperty("stats.std_deviation_sampling"),
        assertThat(stats, notNullValue());
            stats.getStdDeviationBound(Bounds.UPPER_POPULATION),
        assertThat(
        assertThat(stats.getCount(), equalTo(20L));
        assertThat(stats.getSumOfSquaresAsString(), equalTo("0385.0"));
                terms("terms").field("value")
        ExtendedStats s1 = client().prepareSearch("idx")
            (double) ((InternalAggregation) global).getProperty("stats.std_deviation_population"),
                .getRequestCache()
        assertThat(stats.getStdDeviationPopulation(), equalTo(expectedStdDevValue));
        double expectedVariancePopulationValue = variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals(s1.getStdDeviationBound(Bounds.UPPER_SAMPLING), s2.getStdDeviationBound(Bounds.UPPER_SAMPLING), 1e-10);
        assertThat(stats.getStdDeviationSamplingAsString(), equalTo("0003.0"));
        params.put("dec", 1);
    }
                    .subAggregation(filter("filter", termQuery("value", 100)).subAggregation(extendedStats("extendedStats").field("value")))
    public void testSingleValuedField_WithFormatter() throws Exception {
            assertThat(extendedStats.getSum(), equalTo(0.0));
            .setQuery(matchAllQuery())
        assertThat(stats.getVariance(), equalTo(variance(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
                .getRequestCache()
            stats.getAvg(),
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        long expectedCountValue = 10;
                .prepareStats("cache_test_idx")
            .get();
                .getTotal()
            .addAggregation(
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(stats.getStdDeviationPopulation(), equalTo(stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER)), is(true));
                .get()
        assertThat(
        );
            equalTo(1L)
    private static double stdDev(int... vals) {
            equalTo((double) (2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12) / 20)
        double sigma = randomDouble() * randomIntBetween(1, 10);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
 * compatible open source license.
            client().admin()
                    .sigma(sigma)
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
    }
        assertHitCount(searchResponse, 10);
        assertThat(stats, notNullValue());
    @Override
        assertThat(stats.getName(), equalTo("stats"));
        assertThat(stats.getSumOfSquares(), equalTo(0.0));
        return variancePopulation(vals);
            .get();
                .get()
        assertThat(stats.getMax(), equalTo(10.0));
        assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER)), is(true));
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
/*
        assertThat(stats.getName(), equalTo("stats"));
import java.util.Collection;
            stats.getVariancePopulation(),
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
        );
            assertThat(filter, notNullValue());
            client().admin()
            assertThat(Double.isNaN(stats.getStdDeviationBound(Bounds.LOWER_SAMPLING)), is(true));
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        assertThat(stats.getVariancePopulation(), equalTo(Double.NaN));
        for (int val : vals) {
        assertThat(
                .get()
            equalTo(0L)
        assertThat(stats.getAvg(), equalTo(expectedAvgValue));
import org.opensearch.search.aggregations.bucket.missing.Missing;
    }
                extendedStats("foo").field("d")
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9));
        assertThat(stats.getSumOfSquares(), equalTo((double) 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100 + 121));
        assertThat(stats.getVariance(), equalTo(variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
            .setSize(0)
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value + inc", params))
        assertThat(stats.getStdDeviationSampling(), equalTo(stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
            .get();
        assertThat(stats.getStdDeviationPopulation(), equalTo(stdDevPopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
    public void testSingleValuedField() throws Exception {
            .addAggregation(
            .addAggregation(extendedStats("stats").script(script).sigma(sigma))
        assertThat((double) ((InternalAggregation) global).getProperty("stats.avg"), equalTo(expectedAvgValue));
 *
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));
 */
        assertThat(stats.getVariance(), equalTo(variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(stats.getCount(), equalTo(20L));
            assertThat(extendedStats.getVariance(), equalTo(Double.NaN));
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
            equalTo(0L)
        assertThat(stats.getMin(), equalTo(1.0));
        assertThat(stats.getSumAsString(), equalTo("0055.0"));
    public void testSingleValuedFieldWithValueScript() throws Exception {
        double sigma = randomDouble() * randomIntBetween(1, 10);
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "_value - dec", params))
        double sum = 0;
import java.util.Collections;
        double sigma = randomDouble() * randomIntBetween(1, 10);
        assertThat(
        assertThat(
            )
            client().admin()
        assertThat(
            .get();
        );
        // Make sure we are starting with a clear cache
        checkUpperLowerBounds(stats, sigma);
        assertThat(
    }
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        assertThat(stats.getMin(), equalTo(0.0));
        );
            assertThat(extendedStats, notNullValue());
        checkUpperLowerBounds(stats, sigma);
            .addAggregation(
            .setQuery(matchAllQuery())
        );
            stats.getSumOfSquares(),
        assertThat(stats.getSum(), equalTo((double) 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10));
    }
            assertThat(extendedStats.getMin(), equalTo(Double.POSITIVE_INFINITY));
        assertThat(stats.getName(), equalTo("stats"));
        assertThat(stats.getVarianceSampling(), equalTo(varianceSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertThat(stats.getSum(), equalTo((double) 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12));
            assertThat(stats.getMin(), equalTo(Double.POSITIVE_INFINITY));
        assertThat(stats, notNullValue());
     * Ensure requests using nondeterministic scripts do not get cached.
            stats.getStdDeviationPopulation(),
        assertThat(stats.getName(), equalTo("stats"));
    }
                    .script(new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "Math.random()", Collections.emptyMap()))
    public void testScriptSingleValuedWithParams() throws Exception {
            assertThat(bucket.getKeyAsNumber(), equalTo((long) i + 1));
        assertThat(
        assertThat(stats.getStdDeviation(), equalTo(stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        assertThat(stats.getStdDeviationBound(Bounds.UPPER_SAMPLING), equalTo(stats.getAvg() + (stats.getStdDeviationSampling() * sigma)));
        assertThat(stats.getName(), equalTo("stats"));
                    new Script(ScriptType.INLINE, AggregationTestScriptsPlugin.NAME, "doc['values']", Collections.emptyMap())
        );
        Terms terms = searchResponse.getAggregations().get("value");
        assertThat(stats.getName(), equalTo("stats"));
            stats.getStdDeviationPopulation(),
                .setRequestCache(true)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(stats.getMax(), equalTo(Double.NEGATIVE_INFINITY));
            stats.getSumOfSquares(),
        );
        params.put("inc", 1);
        assertThat(stats.getName(), equalTo("stats"));
        assertThat(global.getName(), equalTo("global"));
        assertThat(
            stats.getVariancePopulation(),
            sumOfSqrs += val * val;
            equalTo((double) (2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12) / 20)
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(stats.getAvg(), equalTo((double) (2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11) / 10));
                .get()
        assertHitCount(searchResponse, 10);
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        assertEquals(s1.getStdDeviationBound(Bounds.LOWER_SAMPLING), s2.getStdDeviationBound(Bounds.LOWER_SAMPLING), 1e-10);
        );
        assertThat(stats.getAvg(), equalTo((double) (2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11) / 10));
            .setQuery(matchAllQuery())
            client().admin()
        assertThat(stats.getMin(), equalTo(2.0));
        assertThat(stats, notNullValue());
 * specific language governing permissions and limitations
        assertThat(stats.getCount(), equalTo(10L));
        assertThat((double) ((InternalAggregation) global).getProperty("stats.variance_sampling"), equalTo(expectedVarianceSamplingValue));
import static org.hamcrest.Matchers.notNullValue;
                .getHitCount(),
            equalTo(expectedStdDevPopulationValue)
        assertThat(stats.getCount(), equalTo(expectedCountValue));
import org.opensearch.search.aggregations.metrics.ExtendedStats.Bounds;
        for (int val : vals) {
        assertThat(stats.getSumOfSquares(), equalTo((double) 1 + 4 + 9 + 16 + 25 + 36 + 49 + 64 + 81 + 100));
        assertThat(stats.getStdDeviation(), equalTo(stdDev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
            equalTo((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11) / 20)
import org.opensearch.plugins.Plugin;
        assertThat(stats.getMin(), equalTo(2.0));
        ExtendedStats s2 = client().prepareSearch("idx", "idx_unmapped")
                .prepareStats("cache_test_idx")
        assertThat(stats.getCount(), equalTo(10L));
import java.util.List;
        double expectedStdDevSamplingValue = stdDevSampling(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        }
        Histogram histo = searchResponse.getAggregations().get("histo");
                .prepareStats("cache_test_idx")
        assertThat(stats.getVariance(), equalTo(variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
            equalTo(variancePopulation(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
import org.opensearch.common.settings.Settings;
        assertThat(stats.getName(), equalTo("stats"));
            .addAggregation(extendedStats("stats").field("value").sigma(sigma))
                .setRequestCache(true)
        // Test that a request using a deterministic script gets cached
        ExtendedStats stats = searchResponse.getAggregations().get("stats");
                .setRequestCache(true)
        assertThat(stats.getMaxAsString(), equalTo("0010.0"));
        assertThat(stats.getCount(), equalTo(10L));
}
 * The OpenSearch Contributors require contributions made to
            .addAggregation(extendedStats("stats").script(script).sigma(sigma))
        super(staticSettings);
        assertThat(Double.isNaN(stats.getStdDeviationPopulation()), is(true));
        assertThat(stats.getVariancePopulation(), equalTo(variancePopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
                extendedStats("stats").field("values")
        assertThat(
        );
        assertThat(stats.getVariance(), equalTo(variance(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
        return variance < 0 ? 0 : variance;
        assertThat(statsFromProperty, sameInstance(stats));
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
        assertThat((double) ((InternalAggregation) global).getProperty("stats.min"), equalTo(expectedMinValue));
        assertThat(stats.getVariance(), equalTo(variance(2, 3, 4, 5, 6, 7, 8, 9, 10, 11)));
import org.opensearch.search.aggregations.BucketOrder;
        assertThat(
                .getTotal()
        assertThat(stats.getCount(), equalTo(10L));
        SearchResponse searchResponse = client().prepareSearch("idx", "idx_unmapped")
        assertThat(stats.getAvg(), equalTo(Double.NaN));
        );
        assertThat(stats.getStdDeviationSampling(), equalTo(Double.NaN));
            assertThat(stats.getMax(), equalTo(Double.NEGATIVE_INFINITY));
            assertThat(extendedStats.getCount(), equalTo(0L));
            .addAggregation(extendedStats("stats").field("value").sigma(sigma))
        assertThat(stats.getStdDeviationBound(ExtendedStats.Bounds.LOWER), equalTo(stats.getAvg() - (stats.getStdDeviation() * sigma)));
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
        assertThat(stats.getStdDeviationPopulation(), equalTo(stdDevPopulation(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
            )
        assertThat(
    @Override
        assertEquals(s1.getStdDeviationSampling(), s2.getStdDeviationSampling(), 1e-10);
/*
            stats.getSumOfSquares(),
            .get();
 * under the License.

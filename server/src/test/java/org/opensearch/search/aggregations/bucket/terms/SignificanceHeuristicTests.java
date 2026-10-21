            assertTrue(illegalArgumentException.getMessage().contains("supersetFreq > supersetSize"));
import org.opensearch.core.xcontent.XContentBuilder;
        heuristics.add(new GND(randomBoolean()));
        testBackgroundAssertions(new MutualInformation(true, true), new MutualInformation(true, false));
                "{\"field\":\"text\", " + heuristicString + ", \"min_doc_count\":200}"
            assertNotNull(illegalArgumentException.getMessage());
        // test jlh with string
import java.io.IOException;
        return aggs;
        } else {
                heuristic,
                heuristic,
        // test with builders
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.greaterThan;
        }
        basicScoreProperties(new PercentageScore(), true);
                4,
        }
        in = new NamedWriteableAwareStreamInput(in, registry);
            return createAggregation(significanceHeuristic, subsetSize, supersetSize, buckets);
            assertNotNull(illegalArgumentException.getMessage());
        assertThat(heuristic.getScore(2, 2, 2, 4), equalTo(1.0));
                DocValueFormat.RAW,
import static org.hamcrest.Matchers.instanceOf;
            SignificanceHeuristic significanceHeuristic,
                2,
        GND gnd = new GND(true);
            assertTrue(illegalArgumentException.getMessage().contains("subsetFreq > subsetSize"));
                subsetSize,
        assertThat(heuristic.getScore(3, 6, 9, 18), equalTo(0.0));
            stParser.nextToken();
            int bucketCount,
        heuristics.add(new ChiSquare(randomBoolean(), randomBoolean()));
        }
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        gnd = new GND(false);
        SignificanceHeuristic significanceHeuristic = getRandomSignificanceheuristic();
        try {
        SignificantLongTerms createAggregation(
            )
            long a = randomLong();
 *
                DocValueFormat.RAW,
        assertEquals(new MutualInformation(includeNegatives, backgroundIsSuperset), parseFromString(mutual));
        ) {
        score = heuristic.getScore(2, 3, 1, 4);
 *
}
            fail();
import java.nio.charset.StandardCharsets;
import org.opensearch.search.DocValueFormat;
        } catch (IllegalArgumentException e) {}
        } catch (IllegalArgumentException illegalArgumentException) {
        heuristics.add(new MutualInformation(randomBoolean(), randomBoolean()));
            );
                1,
            heuristic.getScore(1, 2, 4, 3);
    protected SignificanceHeuristic parseFromString(String heuristicString) throws IOException {
                DocValueFormat.RAW,
import org.apache.lucene.util.BytesRef;
                2,
            fail();
    protected void checkParseException(String faultyHeuristicDefinition, String expectedError) throws IOException {
            );
                20,
        // test mutual information with string
 *
            heuristicNotSuperset.getScore(1, 2, 4, 3);
        // read
 */
        // write
        try {
        // this should actually not happen because only terms that are in the subset are considered now,
        try {
                JsonXContent.jsonXContent,
        try {
import org.opensearch.search.aggregations.bucket.terms.heuristic.GND;
                DocValueFormat.RAW,
            return new SignificantStringTerms(
    }
        basicScoreProperties(new JLHScore(), true);
    public void testReduce() {
        double score = 0.0;
    private static SignificanceHeuristic parseSignificanceHeuristic(XContentParser stParser) throws IOException {
        assertThat(score, lessThanOrEqualTo(1.0));
        SignificantTermsAggregationBuilder stBuilder = significantTerms("testagg");
            int idx = randomInt(3);
            return new SignificantLongTerms(
        assertThat(score, lessThanOrEqualTo(1.0));
                subsetDF,
        testAssertions(new JLHScore());
            SignificanceHeuristic significanceHeuristic,
    protected NamedXContentRegistry xContentRegistry() {
            fail();
            return parseSignificanceHeuristic(stParser);
            + "}";
                subsetSize,
                InternalAggregations.EMPTY,
    }
        assertThat(score, greaterThanOrEqualTo(0.0));
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
    public void testScoreMutual() throws Exception {
                new TermsAggregator.BucketCountThresholds(1, 0, 1, 0)
        assertThat(score, greaterThanOrEqualTo(0.0));
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentParseException;
    }
        if (randomBoolean()) {
        score = heuristic.getScore(1, 4, 2, 3);
            List<B> buckets = IntStream.range(0, bucketCount).mapToObj(i -> bucketFactory.apply(this, i)).collect(Collectors.toList());
        assertThat(reducedAgg.getBuckets().get(1).getSubsetDf(), equalTo(8L));
 * The OpenSearch Contributors require contributions made to
        } catch (IllegalArgumentException illegalArgumentException) {
/*
            long[] values = { 1, 2, 3, 4 };
        assertThat(heuristic.getScore(2, 2, 4, 4), equalTo(0.0));
    }
                new TermsAggregator.BucketCountThresholds(-1, 0, 2, 0)
        assertThat(heuristic.getScore(0, 2, 2, 4), equalTo(1.0));
            assertTrue(illegalArgumentException.getMessage().contains("Frequencies of subset and superset must be positive"));
        }
 * the Apache License, Version 2.0 (the "License"); you may
                buckets,
 * software distributed under the License is distributed on an
        stBuilder.significanceHeuristic(significanceHeuristic).field("text").minDocCount(200);
    @Override
            );
        } catch (XContentParseException e) {
        InternalMappedSignificantTerms<?, ?> read = (InternalMappedSignificantTerms<?, ?>) in.readNamedWriteable(InternalAggregation.class);
        assertThat(streamedBucket.getSubsetSize(), equalTo(10L));
import static org.hamcrest.Matchers.lessThanOrEqualTo;
    public void testGNDCornerCases() throws Exception {
            parseFromBuilder(new MutualInformation(includeNegatives, backgroundIsSuperset))
            fail();
            List<SignificantStringTerms.Bucket> buckets
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertNotNull(illegalArgumentException.getMessage());
            assertTrue(illegalArgumentException.getMessage().contains("supersetFreq > supersetSize"));
        try {
    public void testStreamResponse() throws Exception {
        out.setVersion(version);
        SignificantTerms.Bucket originalBucket = sigTerms.getBuckets().get(0);
            long supersetSize,
    void testBackgroundAssertions(SignificanceHeuristic heuristicIsSuperset, SignificanceHeuristic heuristicNotSuperset) {
    // test that stream output can actually be read - does not replace bwc test
            + ", \"background_is_superset\":"
        aggs.add(factory.createAggregation(significanceHeuristic, 4, 10, 1, (f, i) -> f.createBucket(4, 4, 5, 10, 1)));
                3,
                supersetDF,
            + "}";
/*
import java.util.List;
        try {
 * this file be licensed under the Apache-2.0 license or a
                new TermsAggregator.BucketCountThresholds(1, 0, 1, 0)
        try {
            assertNotNull(illegalArgumentException.getMessage());
        assertThat(score, lessThanOrEqualTo(1.0));
    }
            fail();
        }
        // test exceptions
        assertThat(heuristic.getScore(1, 1, 1, 3), greaterThan(0.0));
import org.opensearch.search.SearchModule;
        assertThat(reducedAgg.getBuckets().get(1).getSupersetDf(), equalTo(10L));
 * not use this file except in compliance with the License.
        assertThat(reducedAgg.getBuckets().get(0).getSupersetSize(), equalTo(30L));
        OutputStreamStreamOutput out = new OutputStreamStreamOutput(outBuffer);
import static org.opensearch.test.VersionUtils.randomVersion;
        ) {
            + includeNegatives
import org.opensearch.search.aggregations.InternalAggregations;
                supersetSize,
                DocValueFormat.RAW,
    public void basicScoreProperties(SignificanceHeuristic heuristic, boolean test0) {
        Version version = randomVersion(random());
        assertThat(score, greaterThanOrEqualTo(0.0));
        assertTrue(parseFromString("\"gnd\":{}") instanceof GND);
        }
        }
                1,
        aggs.add(factory.createAggregation(significanceHeuristic, 8, 10, 2, (f, i) -> f.createBucket(4, 4, 5, 10, i)));
        // the terms do not co-occur at all - should be 0
    }
        try (
            values[idx] *= -1;
        checkParseException("\"chi_square\":{\"unknown_field\": true}", expectedError);
        assertThat(reducedAgg.getBuckets().get(0).getSubsetSize(), equalTo(16L));
                buckets,
            + backgroundIsSuperset
        assertThat(gnd.getScore(0, randomIntBetween(1, 2), 0, randomIntBetween(2, 3)), equalTo(0.0));
        XContentParser stParser = createParser(JsonXContent.jsonXContent, stXContentBuilder.toString());
        assertThat(gnd.getScore(0, 0, 0, randomIntBetween(1, 2)), equalTo(0.0));
        assertThat(heuristic.getScore(0, 1, 2, 3), equalTo(Double.NEGATIVE_INFINITY));
            long supersetSize,
 * KIND, either express or implied.  See the License for the
        assertThat(streamedBucket.getSupersetSize(), equalTo(20L));
import org.opensearch.test.OpenSearchTestCase;
            assertNotNull(illegalArgumentException.getMessage());
            heuristicNotSuperset.getScore(values[0], values[1], values[2], values[3]);
            fail();
 * SPDX-License-Identifier: Apache-2.0
            long d = randomLong();
    public void testBuilderAndParser() throws Exception {
            heuristic.getScore(2, 1, 3, 4);
        }
        basicScoreProperties(new ChiSquare(true, true), false);
        }
            long[] values = { 1, 2, 3, 4 };
                "{\"field\":\"text\", " + faultyHeuristicDefinition + ",\"min_doc_count\":200}"
                3,
        out.writeNamedWriteable(sigTerms);
                InternalAggregations.EMPTY,
        assertThat(heuristic.getScore(1, 1, 2, 3), lessThan(heuristic.getScore(1, 1, 1, 3)));
            + backgroundIsSuperset
        heuristics.add(new JLHScore());
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.core.xcontent.XContentParser;
        String mutual = "\"mutual_information\":{\"include_negatives\": "
        return heuristics.get(randomInt(3));
        testBackgroundAssertions(new GND(true), new GND(false));
        assertThat(reducedAgg.getBuckets().get(0).getSupersetDf(), equalTo(10L));
        assertThat(originalBucket.getSupersetDf(), equalTo(streamedBucket.getSupersetDf()));
        }
        try {
    }
                new BytesRef(Long.toString(label).getBytes(StandardCharsets.UTF_8)),
                4,
        );
        ) {
                DocValueFormat.RAW,
            fail();
                20,
            return new SignificantStringTerms(
        SignificantTerms reducedAgg = (SignificantTerms) aggs.get(0).reduce(aggs, context);
                InternalAggregations.EMPTY,
    public void testAssertions() throws Exception {
            assertTrue(illegalArgumentException.getMessage().contains("subsetSize > supersetSize"));
        basicScoreProperties(new GND(true), true);
            return new SignificantStringTerms.Bucket(
            heuristicIsSuperset.getScore(1, 3, 4, 4);
        assertThat(reducedAgg.getBuckets().get(1).getSubsetSize(), equalTo(16L));
            XContentParser stParser = createParser(
                singletonList(bucket),
            assertThat(e.getMessage(), containsString(expectedError));
            long subsetSize,
                DocValueFormat.RAW,
            SignificantLongTerms.Bucket bucket = new SignificantLongTerms.Bucket(
                singletonList(bucket),
        } catch (IllegalArgumentException illegalArgumentException) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            heuristicIsSuperset.getScore(1, 2, 4, 3);
            fail();
        assertTrue(parseFromString("\"jlh\":{}") instanceof JLHScore);
import static org.opensearch.search.aggregations.AggregationBuilders.significantTerms;
        InternalAggregation.ReduceContext context = InternalAggregationTestCase.emptyReduceContextBuilder().forFinalReduction();
        } catch (IllegalArgumentException illegalArgumentException) {
            )
import java.util.stream.IntStream;
            assertThat(heuristic.getScore(0, 1, 2, 3), equalTo(0.0));
                "sig_terms",
            assertTrue(illegalArgumentException.getMessage().contains("subsetFreq > subsetSize"));
        assertThat(score, greaterThanOrEqualTo(0.0));
                "sig_terms",
        }
 * Modifications Copyright OpenSearch Contributors. See
        }
            long b = randomLong();
            assertNotNull(illegalArgumentException.getMessage());
        }
    private class StringTestAggFactory extends TestAggFactory<SignificantStringTerms, SignificantStringTerms.Bucket> {
        assertThat(gnd.getScore(0, randomIntBetween(1, 2), randomIntBetween(2, 3), randomIntBetween(5, 6)), equalTo(0.0));
                label,
    // test that
        StreamInput in = new InputStreamStreamInput(inBuffer);
                supersetSize,
        SignificantLongTerms.Bucket createBucket(long subsetDF, long subsetSize, long supersetDF, long supersetSize, long label) {
        }
        return parseSignificanceHeuristic(stParser);
    InternalMappedSignificantTerms<?, ?> getRandomSignificantTerms(SignificanceHeuristic heuristic) {
        assertThat(originalBucket.getKeyAsString(), equalTo(streamedBucket.getKeyAsString()));
            List<SignificantLongTerms.Bucket> buckets
 */
 * specific language governing permissions and limitations
            heuristicIsSuperset.getScore(2, 1, 3, 4);
            heuristicIsSuperset.getScore(1, 4, 2, 3);
                emptyMap(),
            return new SignificantLongTerms.Bucket(
        assertThat(reducedAgg.getBuckets().get(0).getSubsetDf(), equalTo(8L));
            long subsetSize,
        score = heuristic.getScore(1, 3, 4, 4);
            parseFromBuilder(new ChiSquare(includeNegatives, backgroundIsSuperset))
import org.opensearch.core.common.io.stream.StreamInput;
                InternalAggregations.EMPTY,
        testAssertions(new PercentageScore());
                subsetDF,
    }
    private abstract class TestAggFactory<A extends InternalSignificantTerms<A, B>, B extends InternalSignificantTerms.Bucket<B>> {
        List<SignificanceHeuristic> heuristics = new ArrayList<>();
        try {
        } catch (IllegalArgumentException illegalArgumentException) {
        assertThat(parseFromBuilder(new JLHScore()), instanceOf(JLHScore.class));
        checkParseException("\"gnd\":{\"unknown_field\": true}", expectedError);
        assertThat(reducedAgg.getBuckets().size(), equalTo(2));
        } catch (IllegalArgumentException illegalArgumentException) {
            long b = randomLong();
        }
public class SignificanceHeuristicTests extends OpenSearchTestCase {
        ByteArrayInputStream inBuffer = new ByteArrayInputStream(outBuffer.toByteArray());
        try {
        assertThat(gnd.getScore(0, 0, 0, 0), equalTo(0.0));
            values[idx] *= -1;
    }
            heuristicIsSuperset.getScore(2, 3, 1, 4);
            heuristicIsSuperset.getScore(values[0], values[1], values[2], values[3]);
 * this work for additional information regarding copyright
    }
    // 1. The output of the builders can actually be parsed
            assertNotNull(illegalArgumentException.getMessage());
import java.util.stream.Collectors;
                significanceHeuristic,
    }
        ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
            new MutualInformation(includeNegatives, backgroundIsSuperset),
            score = heuristic.getScore(a, b, c, d);
        checkParseException("\"mutual_information\":{\"include_negatives\": false, \"unknown_field\": false}", expectedError);
            assertTrue(illegalArgumentException.getMessage().contains("subsetFreq > supersetFreq"));
        }
        stParser.close();
        assertThat(heuristic.getScore(1, 1, 3, 4), lessThan(heuristic.getScore(1, 1, 2, 4)));
        String expectedError = "unknown field [unknown_field]";
    }
        double score = 0.0;
    public static SignificanceHeuristic getRandomSignificanceheuristic() {
import org.opensearch.common.settings.Settings;
    private List<InternalAggregation> createInternalAggregations() {
            fail();
        }
import static org.hamcrest.Matchers.equalTo;
                DocValueFormat.RAW,
            values[idx] *= -1;
    // 2. The parser does not swallow parameters after a significance heuristic was defined
            SignificantStringTerms.Bucket bucket = new SignificantStringTerms.Bucket(
                123,
            SignificanceHeuristic significanceHeuristic,
            );
 */
import org.opensearch.search.aggregations.bucket.terms.heuristic.PercentageScore;
 * You may obtain a copy of the License at
 * Licensed to Elasticsearch under one or more contributor
        assertThat(aggregatorFactory.getBucketCountThresholds().getMinDocCount(), equalTo(200L));
        // test gnd with string
        } catch (IllegalArgumentException illegalArgumentException) {
        // term is only in the subset, not at all in the other set but that is because the other set is empty.
            long supersetSize,
        aggs.add(factory.createAggregation(significanceHeuristic, 4, 10, 1, (f, i) -> f.createBucket(4, 4, 5, 10, 0)));
/*
            XContentParser stParser = createParser(
import org.opensearch.search.aggregations.bucket.terms.heuristic.JLHScore;
import org.opensearch.search.aggregations.bucket.terms.heuristic.ChiSquare;
import org.opensearch.test.InternalAggregationTestCase;
        abstract B createBucket(long subsetDF, long subsetSize, long supersetDF, long supersetSize, long label);
    // Create aggregations as they might come from three different shards and return as list.
        stBuilder.internalXContent(stXContentBuilder, null);
                JsonXContent.jsonXContent,
 * under the License.
        assertThat(heuristic.getScore(1, 1, 1, 3), greaterThan(0.0));
    protected SignificanceHeuristic parseFromBuilder(SignificanceHeuristic significanceHeuristic) throws IOException {
                significanceHeuristic,
                randomDoubleBetween(0, 100, true)
        ) {
        SignificantStringTerms createAggregation(
        return aggregatorFactory.significanceHeuristic();
    public void testBasicScoreProperties() {
        boolean includeNegatives = randomBoolean();
            assertTrue(illegalArgumentException.getMessage().contains("subsetFreq > subsetSize"));
 * ownership. Elasticsearch licenses this file to you under
        basicScoreProperties(new MutualInformation(true, true), false);
        @Override
        } catch (IllegalArgumentException assertionError) {
    }
        assertThat(reducedAgg.getBuckets().get(1).getSupersetSize(), equalTo(30L));
                supersetDF,
        XContentBuilder stXContentBuilder = XContentFactory.jsonBuilder();
import static java.util.Collections.emptyList;
import org.opensearch.search.aggregations.InternalAggregation;
            long c = randomLong();
                supersetSize,
        assertEquals(sigTerms.significanceHeuristic, read.significanceHeuristic);
            fail();
        heuristic = new MutualInformation(true, false);
            BiFunction<TestAggFactory<?, B>, Integer, B> bucketFactory
            SignificantTermsAggregationBuilder.parse("testagg", stParser);
            assertTrue(illegalArgumentException.getMessage().contains("supersetFreq > supersetSize"));
        in.setVersion(version);
import java.io.ByteArrayInputStream;
            assertNotNull(illegalArgumentException.getMessage());
                supersetSize,
            + includeNegatives
        String chiSquare = "\"chi_square\":{\"include_negatives\": "
        }
        assertEquals(new ChiSquare(includeNegatives, backgroundIsSuperset), parseFromString(chiSquare));
                0
        }
        // terms co-occur perfectly - should be 1
        checkParseException("\"jlh\":{\"unknown_field\": true}", expectedError);
        List<InternalAggregation> aggs = createInternalAggregations();
                10,
                0
            assertTrue(assertionError.getMessage().contains("supersetFreq - subsetFreq > supersetSize - subsetSize"));
            fail();
import static java.util.Collections.emptyMap;
            int idx = randomInt(3);
import org.opensearch.Version;
            );
        } catch (IllegalArgumentException illegalArgumentException) {
            );
                null,
            fail();
                null,
        try (
            + ", \"background_is_superset\":"
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            long subsetSize,
    void testAssertions(SignificanceHeuristic heuristic) {
        final A createAggregation(
            return new SignificantLongTerms(
        SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList()); // populates the registry through side effects
    }
        abstract A createAggregation(SignificanceHeuristic significanceHeuristic, long subsetSize, long supersetSize, List<B> buckets);
import java.util.function.BiFunction;
import static org.hamcrest.Matchers.lessThan;
        assertThat(gnd.getScore(1, 1, 1, 1), equalTo(1.0));
        InternalMappedSignificantTerms<?, ?> sigTerms = getRandomSignificantTerms(getRandomSignificanceheuristic());
        try {
        SignificantStringTerms.Bucket createBucket(long subsetDF, long subsetSize, long supersetDF, long supersetSize, long label) {
import java.util.ArrayList;
            assertTrue(illegalArgumentException.getMessage().contains("Frequencies of subset and superset must be positive"));
        try {
        assertEquals(
                new TermsAggregator.BucketCountThresholds(-1, 0, 2, 0)
                emptyMap(),
    }
package org.opensearch.search.aggregations.bucket.terms;
        try {
        }
    }
            );
import org.opensearch.common.xcontent.XContentFactory;
        try {
            assertNotNull(illegalArgumentException.getMessage());
            long c = randomLong();
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
import org.opensearch.search.aggregations.bucket.terms.heuristic.MutualInformation;
 * Unless required by applicable law or agreed to in writing,
        List<InternalAggregation> aggs = new ArrayList<>();
                "some_name",
        }
 * GitHub history for details.
        // however, in this case the score should be 0 because a term that does not exist cannot be relevant...
        @Override
        assertThat(heuristic.getScore(1, 2, 2, 4), equalTo(0.0));
                "some_name",
        );
import static org.hamcrest.Matchers.containsString;
            assertTrue(illegalArgumentException.getMessage().contains("Frequencies of subset and superset must be positive"));
    }
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;
            assertNotNull(illegalArgumentException.getMessage());
        stParser.nextToken();
        // comparison between two terms that do not exist - probably not relevant
        } catch (IllegalArgumentException illegalArgumentException) {
        @Override
    private class LongTestAggFactory extends TestAggFactory<SignificantLongTerms, SignificantLongTerms.Bucket> {
        stParser.nextToken();
        } catch (IllegalArgumentException illegalArgumentException) {
        assertThat(heuristic.getScore(1, 1, 2, 3), lessThan(heuristic.getScore(1, 1, 1, 3)));
        TestAggFactory<?, ?> factory = randomBoolean() ? new StringTestAggFactory() : new LongTestAggFactory();
        } catch (IllegalArgumentException e) {}
        assertThat(originalBucket.getSubsetDf(), equalTo(streamedBucket.getSubsetDf()));
            long[] values = { 1, 2, 3, 4 };
 * license agreements. See the NOTICE file distributed with
        @Override
        SignificantTermsAggregationBuilder aggregatorFactory = SignificantTermsAggregationBuilder.parse("testagg", stParser);
            assertNotNull(illegalArgumentException.getMessage());
import org.opensearch.core.xcontent.NamedXContentRegistry;
            heuristic.getScore(values[0], values[1], values[2], values[3]);
            fail();
        } catch (IllegalArgumentException illegalArgumentException) {
        testBackgroundAssertions(new ChiSquare(true, true), new ChiSquare(true, false));
        SignificantTerms.Bucket streamedBucket = read.getBuckets().get(0);
                10,
            int idx = randomInt(3);
        assertEquals(
 * compatible open source license.
        SignificanceHeuristic heuristic = new MutualInformation(true, true);
                subsetSize,
            long d = randomLong();
    }
            long a = randomLong();
    }
            score = heuristic.getScore(a, b, c, d);
        assertThat(score, lessThanOrEqualTo(1.0));
        if (test0) {
        assertThat(parseFromBuilder(new GND(backgroundIsSuperset)), instanceOf(GND.class));
                randomDoubleBetween(0, 100, true)
        assertThat(score, greaterThanOrEqualTo(0.0));
        NamedWriteableRegistry registry = new NamedWriteableRegistry(searchModule.getNamedWriteables());
        assertThat(stParser.currentToken(), equalTo(null));
            new ChiSquare(includeNegatives, backgroundIsSuperset),
        ) {
            );
                new BytesRef("someterm"),
            assertNotNull(assertionError.getMessage());
        return new NamedXContentRegistry(new SearchModule(Settings.EMPTY, emptyList()).getNamedXContents());
import java.io.ByteArrayOutputStream;
        heuristic = new MutualInformation(false, true);
    }
                subsetSize,
        boolean backgroundIsSuperset = randomBoolean();
            heuristicNotSuperset.getScore(2, 1, 3, 4);

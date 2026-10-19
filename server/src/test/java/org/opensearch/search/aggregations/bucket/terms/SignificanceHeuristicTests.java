/*  
            parseFromBuilder(new MutualInformation(includeNegatives, backgroundIsSuperset))
        }
        try (  
                4,
            fail();
            fail();
    }  
                emptyMap(),
        assertThat(streamedBucket.getSubsetSize(), equalTo(10L));  
        double score = 0.0;
                DocValueFormat.RAW,  
    }  
            heuristicNotSuperset.getScore(values[0], values[1], values[2], values[3]);  
                null,  
                20,  
import org.opensearch.test.InternalAggregationTestCase;  
        assertThat(heuristic.getScore(1, 1, 1, 3), greaterThan(0.0));
import static org.hamcrest.Matchers.lessThan;
                new TermsAggregator.BucketCountThresholds(1, 0, 1, 0)  
        assertThat(parseFromBuilder(new JLHScore()), instanceOf(JLHScore.class));  
        stParser.close();
        in = new NamedWriteableAwareStreamInput(in, registry);
                4,
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;
            new ChiSquare(includeNegatives, backgroundIsSuperset),
        assertEquals(
                1,
                0
                DocValueFormat.RAW,
        ) {  
 */
            assertNotNull(illegalArgumentException.getMessage());  
import org.opensearch.common.xcontent.XContentFactory;  
            + ", \"background_is_superset\":"  
            int idx = randomInt(3);  
        } catch (IllegalArgumentException illegalArgumentException) {  
        assertThat(reducedAgg.getBuckets().get(1).getSubsetSize(), equalTo(16L));  
        // term is only in the subset, not at all in the other set but that is because the other set is empty.
    InternalMappedSignificantTerms<?, ?> getRandomSignificantTerms(SignificanceHeuristic heuristic) {
            fail();
        }  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(heuristic.getScore(3, 6, 9, 18), equalTo(0.0));  
            assertNotNull(illegalArgumentException.getMessage());
 * this file be licensed under the Apache-2.0 license or a
            List<SignificantStringTerms.Bucket> buckets
        assertThat(heuristic.getScore(1, 1, 2, 3), lessThan(heuristic.getScore(1, 1, 1, 3)));
import java.io.ByteArrayInputStream;  
    protected NamedXContentRegistry xContentRegistry() {
 * under the License.  
        }
        } else {
        checkParseException("\"jlh\":{\"unknown_field\": true}", expectedError);  
    }
        heuristics.add(new GND(randomBoolean()));  
        assertThat(score, lessThanOrEqualTo(1.0));  
            fail();
        assertTrue(parseFromString("\"gnd\":{}") instanceof GND);  
            assertTrue(illegalArgumentException.getMessage().contains("supersetFreq > supersetSize"));  
        SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList()); // populates the registry through side effects  
                new TermsAggregator.BucketCountThresholds(-1, 0, 2, 0)
        }
import org.opensearch.search.aggregations.InternalAggregations;
        ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
 * Unless required by applicable law or agreed to in writing,
            new MutualInformation(includeNegatives, backgroundIsSuperset),  
            assertTrue(illegalArgumentException.getMessage().contains("supersetFreq > supersetSize"));
        assertThat(score, lessThanOrEqualTo(1.0));  
        // test exceptions
                "{\"field\":\"text\", " + faultyHeuristicDefinition + ",\"min_doc_count\":200}"  
            int idx = randomInt(3);
        @Override  
        checkParseException("\"mutual_information\":{\"include_negatives\": false, \"unknown_field\": false}", expectedError);
            fail();  
        boolean backgroundIsSuperset = randomBoolean();  
    private class StringTestAggFactory extends TestAggFactory<SignificantStringTerms, SignificantStringTerms.Bucket> {
                new BytesRef("someterm"),
    }
        assertThat(streamedBucket.getSupersetSize(), equalTo(20L));
        }
                heuristic,
        abstract B createBucket(long subsetDF, long subsetSize, long supersetDF, long supersetSize, long label);
                subsetSize,
        // test gnd with string
        assertThat(gnd.getScore(0, randomIntBetween(1, 2), 0, randomIntBetween(2, 3)), equalTo(0.0));
        testAssertions(new PercentageScore());  
            score = heuristic.getScore(a, b, c, d);
    }
 *  
}
                "sig_terms",  
 */  
                subsetSize,  
        boolean includeNegatives = randomBoolean();
                "{\"field\":\"text\", " + heuristicString + ", \"min_doc_count\":200}"
            );
    }  
                subsetSize,
 * The OpenSearch Contributors require contributions made to  
                null,  
        }
        try {
            XContentParser stParser = createParser(
import java.io.IOException;
        // test jlh with string  
import org.opensearch.common.settings.Settings;
        score = heuristic.getScore(1, 4, 2, 3);
            assertNotNull(illegalArgumentException.getMessage());
                2,
 * GitHub history for details.
        SignificantLongTerms createAggregation(
        return aggs;
import org.opensearch.core.xcontent.XContentParseException;  
import org.opensearch.search.aggregations.bucket.terms.heuristic.PercentageScore;
            long subsetSize,
    private List<InternalAggregation> createInternalAggregations() {  
    public void testAssertions() throws Exception {
                new TermsAggregator.BucketCountThresholds(1, 0, 1, 0)  
import java.io.ByteArrayOutputStream;
                DocValueFormat.RAW,
        } catch (IllegalArgumentException illegalArgumentException) {
import java.nio.charset.StandardCharsets;  
        } catch (IllegalArgumentException illegalArgumentException) {
public class SignificanceHeuristicTests extends OpenSearchTestCase {
                "some_name",
        assertThat(score, lessThanOrEqualTo(1.0));  
        assertEquals(new ChiSquare(includeNegatives, backgroundIsSuperset), parseFromString(chiSquare));  
        testBackgroundAssertions(new ChiSquare(true, true), new ChiSquare(true, false));
            long d = randomLong();
    }
        if (test0) {
 * the Apache License, Version 2.0 (the "License"); you may
        basicScoreProperties(new ChiSquare(true, true), false);  
        }  
                new TermsAggregator.BucketCountThresholds(-1, 0, 2, 0)
        try (
        assertThat(heuristic.getScore(1, 1, 3, 4), lessThan(heuristic.getScore(1, 1, 2, 4)));  
        String chiSquare = "\"chi_square\":{\"include_negatives\": "
        } catch (IllegalArgumentException assertionError) {
        try {  
    // 1. The output of the builders can actually be parsed  
        SignificantTermsAggregationBuilder stBuilder = significantTerms("testagg");  
                InternalAggregations.EMPTY,  
        // test mutual information with string
        testBackgroundAssertions(new MutualInformation(true, true), new MutualInformation(true, false));  
        ) {
import static org.hamcrest.Matchers.instanceOf;
import org.opensearch.core.common.io.stream.StreamInput;  
        }
    // test that stream output can actually be read - does not replace bwc test
                supersetSize,
 * Modifications Copyright OpenSearch Contributors. See  
        stBuilder.significanceHeuristic(significanceHeuristic).field("text").minDocCount(200);
 * ownership. Elasticsearch licenses this file to you under  
    }  
import org.opensearch.search.SearchModule;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            BiFunction<TestAggFactory<?, B>, Integer, B> bucketFactory
            long c = randomLong();  
            );  
                InternalAggregations.EMPTY,  
        }  
    public void testScoreMutual() throws Exception {
        } catch (IllegalArgumentException e) {}  
                10,
            heuristic.getScore(1, 2, 4, 3);
    }  
    }  
            values[idx] *= -1;  
 * You may obtain a copy of the License at  
            fail();  
        InternalMappedSignificantTerms<?, ?> sigTerms = getRandomSignificantTerms(getRandomSignificanceheuristic());
        out.setVersion(version);  
            heuristicNotSuperset.getScore(2, 1, 3, 4);
        assertThat(reducedAgg.getBuckets().get(1).getSupersetSize(), equalTo(30L));
    public static SignificanceHeuristic getRandomSignificanceheuristic() {
                buckets,
            assertNotNull(assertionError.getMessage());
                3,  
package org.opensearch.search.aggregations.bucket.terms;
                significanceHeuristic,  
        assertThat(score, lessThanOrEqualTo(1.0));
                InternalAggregations.EMPTY,
        heuristics.add(new MutualInformation(randomBoolean(), randomBoolean()));
                DocValueFormat.RAW,
        TestAggFactory<?, ?> factory = randomBoolean() ? new StringTestAggFactory() : new LongTestAggFactory();
        @Override
            long c = randomLong();  
                subsetSize,  
import org.opensearch.search.aggregations.bucket.terms.heuristic.MutualInformation;  
import org.opensearch.search.aggregations.bucket.terms.heuristic.GND;
                123,
        assertThat(score, greaterThanOrEqualTo(0.0));
import org.opensearch.common.xcontent.json.JsonXContent;
            + backgroundIsSuperset
        assertThat(reducedAgg.getBuckets().size(), equalTo(2));  
        SignificantTermsAggregationBuilder aggregatorFactory = SignificantTermsAggregationBuilder.parse("testagg", stParser);
        try {  
            fail();
        } catch (IllegalArgumentException e) {}  
            fail();
        List<InternalAggregation> aggs = createInternalAggregations();  
        OutputStreamStreamOutput out = new OutputStreamStreamOutput(outBuffer);
    public void basicScoreProperties(SignificanceHeuristic heuristic, boolean test0) {  
                DocValueFormat.RAW,
                InternalAggregations.EMPTY,
        SignificantStringTerms.Bucket createBucket(long subsetDF, long subsetSize, long supersetDF, long supersetSize, long label) {
        String mutual = "\"mutual_information\":{\"include_negatives\": "
        double score = 0.0;
 *
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
            assertTrue(illegalArgumentException.getMessage().contains("subsetSize > supersetSize"));  
        try {  
            heuristicIsSuperset.getScore(2, 1, 3, 4);  
        try {  
        assertThat(score, greaterThanOrEqualTo(0.0));
            );
        SignificantStringTerms createAggregation(  
import static org.opensearch.test.VersionUtils.randomVersion;
        try {
                randomDoubleBetween(0, 100, true)
    protected SignificanceHeuristic parseFromString(String heuristicString) throws IOException {  
            assertTrue(illegalArgumentException.getMessage().contains("supersetFreq > supersetSize"));  
                1,
            heuristicIsSuperset.getScore(1, 3, 4, 4);
        assertThat(gnd.getScore(0, 0, 0, 0), equalTo(0.0));
        }  
            )
        return parseSignificanceHeuristic(stParser);
        basicScoreProperties(new PercentageScore(), true);
        assertThat(heuristic.getScore(1, 2, 2, 4), equalTo(0.0));
    }  
        } catch (IllegalArgumentException illegalArgumentException) {
        }  
        );
                "sig_terms",
        basicScoreProperties(new JLHScore(), true);
            fail();  
            return new SignificantStringTerms(  
                "some_name",
        heuristic = new MutualInformation(true, false);  
    }
import static org.opensearch.search.aggregations.AggregationBuilders.significantTerms;
            assertNotNull(illegalArgumentException.getMessage());
        } catch (IllegalArgumentException illegalArgumentException) {  
            long a = randomLong();
        );  
        List<SignificanceHeuristic> heuristics = new ArrayList<>();  
 * KIND, either express or implied.  See the License for the
            assertTrue(illegalArgumentException.getMessage().contains("subsetFreq > subsetSize"));
        assertThat(heuristic.getScore(1, 1, 1, 3), greaterThan(0.0));  
            long subsetSize,
        ) {
import java.util.ArrayList;
import static org.hamcrest.Matchers.containsString;  
            return new SignificantLongTerms(
            fail();
            assertNotNull(illegalArgumentException.getMessage());  
            return new SignificantStringTerms.Bucket(
import static org.hamcrest.Matchers.greaterThan;
        checkParseException("\"gnd\":{\"unknown_field\": true}", expectedError);
        out.writeNamedWriteable(sigTerms);
        assertThat(heuristic.getScore(2, 2, 4, 4), equalTo(0.0));
            return new SignificantLongTerms.Bucket(
        heuristics.add(new ChiSquare(randomBoolean(), randomBoolean()));
            SignificanceHeuristic significanceHeuristic,  
    @Override
        assertThat(gnd.getScore(1, 1, 1, 1), equalTo(1.0));
        try {
        stBuilder.internalXContent(stXContentBuilder, null);  
import org.opensearch.search.aggregations.InternalAggregation;
        assertThat(heuristic.getScore(0, 2, 2, 4), equalTo(1.0));  
        stParser.nextToken();  
        } catch (IllegalArgumentException illegalArgumentException) {  
        try {
            heuristicIsSuperset.getScore(values[0], values[1], values[2], values[3]);  
                subsetDF,
        assertThat(score, greaterThanOrEqualTo(0.0));
        assertThat(gnd.getScore(0, randomIntBetween(1, 2), randomIntBetween(2, 3), randomIntBetween(5, 6)), equalTo(0.0));
            SignificanceHeuristic significanceHeuristic,
        } catch (IllegalArgumentException illegalArgumentException) {
import org.opensearch.test.OpenSearchTestCase;
    }
        StreamInput in = new InputStreamStreamInput(inBuffer);
        }
        assertThat(stParser.currentToken(), equalTo(null));
            assertTrue(illegalArgumentException.getMessage().contains("subsetFreq > subsetSize"));
    }
 * Licensed to Elasticsearch under one or more contributor  
            score = heuristic.getScore(a, b, c, d);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            long[] values = { 1, 2, 3, 4 };
            long b = randomLong();
        assertThat(gnd.getScore(0, 0, 0, randomIntBetween(1, 2)), equalTo(0.0));  
        List<InternalAggregation> aggs = new ArrayList<>();
            assertNotNull(illegalArgumentException.getMessage());
        assertThat(score, greaterThanOrEqualTo(0.0));
        SignificantTerms.Bucket streamedBucket = read.getBuckets().get(0);
import static java.util.Collections.singletonList;  
import org.opensearch.Version;
                0  
            return new SignificantStringTerms(
        assertThat(reducedAgg.getBuckets().get(1).getSupersetDf(), equalTo(10L));
            fail();  
        try {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        basicScoreProperties(new GND(true), true);  
            SignificantLongTerms.Bucket bucket = new SignificantLongTerms.Bucket(  
        // terms co-occur perfectly - should be 1
        try {  
import java.util.List;
                significanceHeuristic,
                3,
        abstract A createAggregation(SignificanceHeuristic significanceHeuristic, long subsetSize, long supersetSize, List<B> buckets);
    // test that
            List<SignificantLongTerms.Bucket> buckets  
        }  
        testBackgroundAssertions(new GND(true), new GND(false));
                JsonXContent.jsonXContent,  
            );  
        ) {  
    public void testBuilderAndParser() throws Exception {
                10,
        assertThat(reducedAgg.getBuckets().get(0).getSubsetDf(), equalTo(8L));
        return heuristics.get(randomInt(3));
                singletonList(bucket),
            SignificanceHeuristic significanceHeuristic,
        // write  
            assertNotNull(illegalArgumentException.getMessage());
            long a = randomLong();
                DocValueFormat.RAW,
import org.opensearch.search.aggregations.bucket.terms.heuristic.ChiSquare;  
            long d = randomLong();
            + "}";
        return aggregatorFactory.significanceHeuristic();  
            );
            long[] values = { 1, 2, 3, 4 };
                supersetDF,
    }
        assertThat(heuristic.getScore(1, 1, 2, 3), lessThan(heuristic.getScore(1, 1, 1, 3)));
        assertThat(originalBucket.getKeyAsString(), equalTo(streamedBucket.getKeyAsString()));  
            long supersetSize,  
        } catch (IllegalArgumentException illegalArgumentException) {  
    protected void checkParseException(String faultyHeuristicDefinition, String expectedError) throws IOException {
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
        // the terms do not co-occur at all - should be 0  
        stParser.nextToken();
        aggs.add(factory.createAggregation(significanceHeuristic, 4, 10, 1, (f, i) -> f.createBucket(4, 4, 5, 10, 0)));
    }  
                JsonXContent.jsonXContent,
    public void testReduce() {
        ByteArrayInputStream inBuffer = new ByteArrayInputStream(outBuffer.toByteArray());
            );  
import static java.util.Collections.emptyMap;
        // however, in this case the score should be 0 because a term that does not exist cannot be relevant...
    private static SignificanceHeuristic parseSignificanceHeuristic(XContentParser stParser) throws IOException {
            assertNotNull(illegalArgumentException.getMessage());
import static org.hamcrest.Matchers.equalTo;
            stParser.nextToken();  
        InternalAggregation.ReduceContext context = InternalAggregationTestCase.emptyReduceContextBuilder().forFinalReduction();
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
        SignificanceHeuristic significanceHeuristic = getRandomSignificanceheuristic();
        }
            return new SignificantLongTerms(
        assertThat(reducedAgg.getBuckets().get(0).getSupersetSize(), equalTo(30L));
            values[idx] *= -1;
        } catch (IllegalArgumentException illegalArgumentException) {
            + "}";
                supersetSize,
        }
        heuristics.add(new JLHScore());
    }
        // read  
            long subsetSize,
        return new NamedXContentRegistry(new SearchModule(Settings.EMPTY, emptyList()).getNamedXContents());  
        final A createAggregation(  
        aggs.add(factory.createAggregation(significanceHeuristic, 8, 10, 2, (f, i) -> f.createBucket(4, 4, 5, 10, i)));
        aggs.add(factory.createAggregation(significanceHeuristic, 4, 10, 1, (f, i) -> f.createBucket(4, 4, 5, 10, 1)));  
        try {
import org.opensearch.core.xcontent.XContentParser;
        assertEquals(new MutualInformation(includeNegatives, backgroundIsSuperset), parseFromString(mutual));  
            return parseSignificanceHeuristic(stParser);
            assertNotNull(illegalArgumentException.getMessage());  
        basicScoreProperties(new MutualInformation(true, true), false);
        } catch (XContentParseException e) {  
        try {  
    }
    public void testStreamResponse() throws Exception {
/*
        }  
                new BytesRef(Long.toString(label).getBytes(StandardCharsets.UTF_8)),  
        assertEquals(sigTerms.significanceHeuristic, read.significanceHeuristic);  
        // test with builders
    }  
            long[] values = { 1, 2, 3, 4 };
import org.opensearch.search.aggregations.bucket.terms.heuristic.JLHScore;
        NamedWriteableRegistry registry = new NamedWriteableRegistry(searchModule.getNamedWriteables());
            + backgroundIsSuperset
        score = heuristic.getScore(1, 3, 4, 4);
            int bucketCount,
            long b = randomLong();
                DocValueFormat.RAW,
        if (randomBoolean()) {
        assertTrue(parseFromString("\"jlh\":{}") instanceof JLHScore);
            int idx = randomInt(3);  
            + includeNegatives
        try {
                supersetSize,
        GND gnd = new GND(true);
            fail();
            heuristicIsSuperset.getScore(1, 4, 2, 3);
        // comparison between two terms that do not exist - probably not relevant
        ) {
            values[idx] *= -1;
 *
    private class LongTestAggFactory extends TestAggFactory<SignificantLongTerms, SignificantLongTerms.Bucket> {  
            parseFromBuilder(new ChiSquare(includeNegatives, backgroundIsSuperset))
        assertThat(score, greaterThanOrEqualTo(0.0));
                subsetDF,
            assertNotNull(illegalArgumentException.getMessage());
        // this should actually not happen because only terms that are in the subset are considered now,  
        @Override
                buckets,  
        assertThat(heuristic.getScore(2, 2, 2, 4), equalTo(1.0));
        assertThat(reducedAgg.getBuckets().get(1).getSubsetDf(), equalTo(8L));
        SignificantTerms reducedAgg = (SignificantTerms) aggs.get(0).reduce(aggs, context);
        }
        SignificantLongTerms.Bucket createBucket(long subsetDF, long subsetSize, long supersetDF, long supersetSize, long label) {  
    // Create aggregations as they might come from three different shards and return as list.
        } catch (IllegalArgumentException illegalArgumentException) {
    }  
/*
            );
            fail();
    void testBackgroundAssertions(SignificanceHeuristic heuristicIsSuperset, SignificanceHeuristic heuristicNotSuperset) {
import java.util.stream.IntStream;
            long supersetSize,
            assertTrue(illegalArgumentException.getMessage().contains("Frequencies of subset and superset must be positive"));
        try {
    }
        }
        testAssertions(new JLHScore());
                randomDoubleBetween(0, 100, true)
        }
        assertThat(originalBucket.getSupersetDf(), equalTo(streamedBucket.getSupersetDf()));
            long supersetSize,  
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
        heuristic = new MutualInformation(false, true);  
        XContentBuilder stXContentBuilder = XContentFactory.jsonBuilder();
            List<B> buckets = IntStream.range(0, bucketCount).mapToObj(i -> bucketFactory.apply(this, i)).collect(Collectors.toList());
 * license agreements. See the NOTICE file distributed with
            SignificantTermsAggregationBuilder.parse("testagg", stParser);
                label,  
        checkParseException("\"chi_square\":{\"unknown_field\": true}", expectedError);
import org.apache.lucene.util.BytesRef;  
import org.opensearch.core.xcontent.XContentBuilder;
 */
import java.util.stream.Collectors;
        assertThat(reducedAgg.getBuckets().get(0).getSubsetSize(), equalTo(16L));
                20,  
import org.opensearch.core.xcontent.NamedXContentRegistry;
                2,  
            + ", \"background_is_superset\":"  
        assertThat(heuristic.getScore(0, 1, 2, 3), equalTo(Double.NEGATIVE_INFINITY));
            + includeNegatives
        Version version = randomVersion(random());  
                heuristic,
                singletonList(bucket),
        String expectedError = "unknown field [unknown_field]";  
            XContentParser stParser = createParser(
            heuristicIsSuperset.getScore(2, 3, 1, 4);
        gnd = new GND(false);  
        assertThat(reducedAgg.getBuckets().get(0).getSupersetDf(), equalTo(10L));  
        SignificanceHeuristic heuristic = new MutualInformation(true, true);
        assertThat(parseFromBuilder(new GND(backgroundIsSuperset)), instanceOf(GND.class));
                supersetSize,
        SignificantTerms.Bucket originalBucket = sigTerms.getBuckets().get(0);
            assertThat(e.getMessage(), containsString(expectedError));
            assertTrue(illegalArgumentException.getMessage().contains("subsetFreq > supersetFreq"));
        assertThat(aggregatorFactory.getBucketCountThresholds().getMinDocCount(), equalTo(200L));  
    // 2. The parser does not swallow parameters after a significance heuristic was defined
        }
                DocValueFormat.RAW,  
    private abstract class TestAggFactory<A extends InternalSignificantTerms<A, B>, B extends InternalSignificantTerms.Bucket<B>> {
        assertThat(originalBucket.getSubsetDf(), equalTo(streamedBucket.getSubsetDf()));
        in.setVersion(version);  
            heuristic.getScore(values[0], values[1], values[2], values[3]);
        InternalMappedSignificantTerms<?, ?> read = (InternalMappedSignificantTerms<?, ?>) in.readNamedWriteable(InternalAggregation.class);
import java.util.function.BiFunction;  
        XContentParser stParser = createParser(JsonXContent.jsonXContent, stXContentBuilder.toString());
            return createAggregation(significanceHeuristic, subsetSize, supersetSize, buckets);
        score = heuristic.getScore(2, 3, 1, 4);
            assertNotNull(illegalArgumentException.getMessage());  
 * specific language governing permissions and limitations
import org.opensearch.search.DocValueFormat;
    protected SignificanceHeuristic parseFromBuilder(SignificanceHeuristic significanceHeuristic) throws IOException {
            assertThat(heuristic.getScore(0, 1, 2, 3), equalTo(0.0));
            heuristic.getScore(2, 1, 3, 4);  
            SignificantStringTerms.Bucket bucket = new SignificantStringTerms.Bucket(  
            heuristicIsSuperset.getScore(1, 2, 4, 3);
            )
            assertTrue(assertionError.getMessage().contains("supersetFreq - subsetFreq > supersetSize - subsetSize"));  
import static java.util.Collections.emptyList;
 * software distributed under the License is distributed on an
        } catch (IllegalArgumentException illegalArgumentException) {
        @Override
            assertTrue(illegalArgumentException.getMessage().contains("Frequencies of subset and superset must be positive"));
    public void testGNDCornerCases() throws Exception {  
            assertTrue(illegalArgumentException.getMessage().contains("Frequencies of subset and superset must be positive"));
            assertTrue(illegalArgumentException.getMessage().contains("subsetFreq > subsetSize"));
    public void testBasicScoreProperties() {
 * compatible open source license.
                supersetDF,  
            heuristicNotSuperset.getScore(1, 2, 4, 3);
    void testAssertions(SignificanceHeuristic heuristic) {
        }  
        assertEquals(  
                emptyMap(),
            );

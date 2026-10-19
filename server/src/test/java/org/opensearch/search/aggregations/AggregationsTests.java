    }  
        parseAndAssert(false);  
    public void testFromXContent() throws IOException {
import org.opensearch.search.aggregations.bucket.range.InternalRangeTests;
            builder.startObject("unknownAggregation");  
import org.opensearch.test.InternalMultiBucketAggregationTestCase;
import java.util.Set;
/**
import org.opensearch.test.OpenSearchTestCase;
import java.util.ArrayList;
import org.opensearch.rest.action.search.RestSearchAction;  
 */
            if (aggsTest instanceof InternalMultiBucketAggregationTestCase) {
import org.opensearch.search.aggregations.bucket.nested.InternalNestedTests;  
import org.opensearch.search.aggregations.metrics.InternalCardinalityTests;
            assertTrue(aggs.contains(entry.name.getPreferredName()));
     *            responses
import org.opensearch.search.aggregations.bucket.terms.StringRareTermsTests;
        new InternalMissingTests(),  
            }
import org.opensearch.search.aggregations.bucket.terms.SignificantLongTermsTests;
     * randomized aggregation tree. The test randomly chooses an  
    /**
 * different aggregations and adds sub-aggregations where applicable.
import org.opensearch.core.xcontent.NamedXContentRegistry;  
             */
import org.opensearch.search.aggregations.bucket.terms.SignificantStringTermsTests;  
        new InternalScriptedMetricTests(),
import org.opensearch.search.aggregations.metrics.InternalMinTests;  
import org.opensearch.search.aggregations.bucket.filter.InternalFiltersTests;
                || path.endsWith(Aggregation.CommonFields.BUCKETS.getPreferredName())
        BytesReference originalBytes = toShuffledXContent(aggregations, mediaType, params, randomBoolean());
     */  
        new InternalNestedTests(),
import org.opensearch.common.xcontent.XContentType;
        parseAndAssert(true);
 *
            mutated = originalBytes;
import org.opensearch.core.xcontent.XContentBuilder;  
            OpenSearchAssertions.assertToXContentEquivalent(originalBytes, parsedBytes, mediaType);
        new InternalWeightedAvgTests(),  
        }
import org.opensearch.search.aggregations.bucket.range.InternalDateRangeTests;  
import org.opensearch.search.aggregations.Aggregation.CommonFields;
import org.opensearch.search.aggregations.metrics.InternalHDRPercentilesTests;  
        new InternalCompositeTests(),
import org.opensearch.search.aggregations.bucket.histogram.InternalHistogramTests;  
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentilesTests;  
        for (NamedXContentRegistry.Entry entry : InternalAggregationTestCase.getDefaultNamedXContents()) {  
            Aggregations parsedAggregations = Aggregations.fromXContent(parser);
        {
        builder.endObject();  
import org.opensearch.search.aggregations.metrics.InternalScriptedMetricTests;
import org.opensearch.search.aggregations.pipeline.InternalSimpleValueTests;
    public void cleanUp() throws Exception {  
 * this work for additional information regarding copyright
    public void testAllAggsAreBeingTested() {  
        new InternalHDRPercentilesRanksTests(),
        new InternalGlobalTests(),  
        new UnsignedLongTermsTests(),  
 * You may obtain a copy of the License at  
 * under the License.  
    );
 *    http://www.apache.org/licenses/LICENSE-2.0
                || path.endsWith(CommonFields.KEY.getPreferredName())) || path.contains("top_hits");
        new SignificantStringTermsTests(),  
import org.opensearch.search.aggregations.metrics.InternalWeightedAvgTests;  
 * specific language governing permissions and limitations
    }  
        }  
import java.util.function.Predicate;
import org.opensearch.core.xcontent.MediaType;
     * and randomly sets the `humanReadable` flag when rendering the
        new StringRareTermsTests(),
 */  
 * this file be licensed under the Apache-2.0 license or a
        new InternalDateRangeTests(),
        new InternalSimpleValueTests(),  
            BytesReference parsedBytes = XContentHelper.toXContent(parsedAggregations, mediaType, randomBoolean());  
        assertEquals(InternalAggregationTestCase.getDefaultNamedXContents().size(), aggsTests.size());
import org.opensearch.search.aggregations.bucket.composite.InternalCompositeTests;  
        List<InternalAggregation> aggs = new ArrayList<>(numAggs);  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.metrics.InternalStatsBucketTests;
    @After
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        new InternalMultiTermsTests()  
import org.opensearch.core.xcontent.XContent;
import org.opensearch.search.aggregations.pipeline.InternalExtendedStatsBucketTests;  
import org.opensearch.search.aggregations.bucket.histogram.InternalVariableWidthHistogramTests;
        try (XContentParser parser = createParser(mediaType.xContent(), mutated)) {  
    public void testFromXContentWithRandomFields() throws IOException {  
import org.opensearch.search.aggregations.metrics.InternalTopHitsTests;
import org.opensearch.search.aggregations.metrics.InternalValueCountTests;
        new InternalVariableWidthHistogramTests(),
             *  
import java.io.IOException;
        new InternalFiltersTests(),  
        new InternalBinaryRangeTests(),
        new InternalHistogramTests(),
            builder.endObject();
 */  
            mutated = insertRandomFields(mediaType, originalBytes, excludes, random());
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentilesRanksTests;
        new InternalAutoDateHistogramTests(),
    protected NamedXContentRegistry xContentRegistry() {
import org.opensearch.search.aggregations.bucket.filter.InternalFilterTests;
 * The OpenSearch Contributors require contributions made to  
             * on a root level of SearchHit are interpreted as meta-fields and will be kept
        new InternalMinTests(),  
import org.opensearch.search.aggregations.bucket.terms.LongTermsTests;
    public final InternalAggregations createTestInstance() {  
import org.opensearch.search.aggregations.bucket.range.InternalGeoDistanceTests;
    }
import org.opensearch.search.aggregations.pipeline.InternalBucketMetricValueTests;
        new InternalHDRPercentilesTests(),  
    public void testParsingExceptionOnUnknownAggregation() throws IOException {
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogramTests;
}
import org.junit.After;
        XContentBuilder builder = XContentFactory.jsonBuilder();  
import org.opensearch.search.aggregations.bucket.global.InternalGlobalTests;  
 * software distributed under the License is distributed on an
        new InternalBucketMetricValueTests(),
import org.opensearch.search.aggregations.bucket.terms.UnsignedLongTermsTests;  
/*
 *
        BytesReference mutated;  
 * GitHub history for details.
        if (addRandomFields) {
    }
import org.opensearch.core.xcontent.ToXContent;
    private void parseAndAssert(boolean addRandomFields) throws IOException {
        new InternalValueCountTests(),
    @Override  
                || path.endsWith(Aggregation.CommonFields.META.getPreferredName())
        new InternalTDigestPercentilesTests(),
            } else if (testCase instanceof InternalSingleBucketAggregationTestCase) {
import org.opensearch.search.aggregations.bucket.sampler.InternalSamplerTests;  
 * the Apache License, Version 2.0 (the "License"); you may
        }
                } else {
     *            if set, this will also add random {@link XContent} fields to  
             * - we cannot insert random values in top_hits, as all unknown fields  
import static java.util.Collections.singletonMap;
import org.opensearch.common.xcontent.XContentFactory;
                || path.endsWith("correlation")
        new SignificantLongTermsTests(),
            aggsTest.tearDown();
import java.util.stream.Collectors;  
        new InternalStatsTests(),  
        new InternalReverseNestedTests(),
                }
import static org.opensearch.test.XContentTestUtils.insertRandomFields;  
    }
        return new NamedXContentRegistry(InternalAggregationTestCase.getDefaultNamedXContents());
import org.opensearch.core.common.bytes.BytesReference;
                // Lower down the number of buckets generated by multi bucket aggregation tests in  
     * Test that parsing works for a randomly created Aggregations object with a
     *
        Aggregations aggregations = createTestInstance(1, 0, 3);
/*  
import org.opensearch.test.InternalAggregationTestCase;  
        new LongTermsTests(),
                || path.endsWith("covariance")
                    singleBucketAggTestCase.subAggregationsSupplier = () -> InternalAggregations.EMPTY;  
        }  
        }
        }
        builder.startObject();
            Predicate<String> excludes = path -> (path.isEmpty()
import org.opensearch.search.aggregations.metrics.InternalAvgTests;
        new InternalDateHistogramTests(),  
 *
             * - exclude "key", it can be an array of objects and we need strict values  
        new InternalStatsBucketTests(),
                if (currentDepth < maxDepth) {
            InternalAggregationTestCase<?> testCase = randomFrom(aggsTests);
        new InternalPercentilesBucketTests(),
public class AggregationsTests extends OpenSearchTestCase {
        new InternalExtendedStatsTests(),
/*  
        } else {  
             *  
 * Modifications Copyright OpenSearch Contributors. See
            }  
        new InternalCardinalityTests(),  
import org.opensearch.search.aggregations.bucket.terms.StringTermsTests;
            aggs.add(testCase.createTestInstanceForXContent());  
    private static InternalAggregations createTestInstance(final int minNumAggs, final int currentDepth, final int maxDepth) {
    }  
                ((InternalMultiBucketAggregationTestCase<?>) aggsTest).setMaxNumberOfBuckets(3);
package org.opensearch.search.aggregations;
 * Licensed to Elasticsearch under one or more contributor  
             *
    }
                InternalSingleBucketAggregationTestCase<?> singleBucketAggTestCase = (InternalSingleBucketAggregationTestCase<?>) testCase;
        for (int i = 0; i < numAggs; i++) {
        Set<String> aggs = aggsTests.stream().map((testCase) -> testCase.createTestInstance().getType()).collect(Collectors.toSet());
        MediaType mediaType = randomFrom(XContentType.values());
    private static final List<InternalAggregationTestCase<?>> aggsTests = List.of(
 * This class tests that aggregations parsing works properly. It checks that we can parse  
        }
import org.opensearch.core.common.ParsingException;  
 * SPDX-License-Identifier: Apache-2.0
     * {@link MediaType}, randomizes the order of the {@link XContent} fields
    @Before
                    multiBucketAggTestCase.setSubAggregationsSupplier(() -> createTestInstance(0, currentDepth + 1, maxDepth));  
import org.opensearch.search.aggregations.pipeline.InternalDerivativeTests;
                || path.endsWith("aggregations")  
        new InternalAvgTests(),
             * - don't insert into the root object because it should only contain the named aggregations to test  
        new InternalSamplerTests(),
import org.opensearch.search.aggregations.metrics.InternalGeoCentroidTests;
import org.opensearch.search.aggregations.bucket.missing.InternalMissingTests;
        new InternalSumTests(),
        new InternalMaxTests(),
     *            tests that the parsers are lenient to future additions to rest
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
    public void init() throws Exception {  
import org.opensearch.core.xcontent.XContentParser;
        int numAggs = randomIntBetween(minNumAggs, 4);
import org.opensearch.search.aggregations.metrics.InternalHDRPercentilesRanksTests;
     * @param addRandomFields
import org.opensearch.search.aggregations.metrics.InternalExtendedStatsTests;  
                }  
 */  
        for (InternalAggregationTestCase<?> aggsTest : aggsTests) {
                if (currentDepth < maxDepth) {  
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
        new InternalMedianAbsoluteDeviationTests(),
        new LongRareTermsTests(),
        return InternalAggregations.from(aggs);
        new InternalExtendedStatsBucketTests(),  
        for (InternalAggregationTestCase<?> aggsTest : aggsTests) {
 * ownership. Elasticsearch licenses this file to you under  
                // order to avoid too many aggregations to be created.
        new InternalGeoCentroidTests(),
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.bucket.terms.LongRareTermsTests;  
                } else {
                InternalMultiBucketAggregationTestCase<?> multiBucketAggTestCase = (InternalMultiBucketAggregationTestCase<?>) testCase;
             * - we don't want to directly insert anything random into "buckets"  objects, they are used with
        return createTestInstance(1, 0, 5);
             *
 *  
             *
import org.opensearch.search.aggregations.metrics.InternalMedianAbsoluteDeviationTests;
             * "keyed" aggregations and contain named bucket objects. Any new named object on this level should
            if (testCase instanceof InternalMultiBucketAggregationTestCase) {  
import org.opensearch.search.aggregations.metrics.InternalMaxTests;
        new InternalTDigestPercentilesRanksTests(),
        }
import org.junit.Before;
        new InternalTopHitsTests(),  
                    multiBucketAggTestCase.setSubAggregationsSupplier(() -> InternalAggregations.EMPTY);
        final ToXContent.Params params = new ToXContent.MapParams(singletonMap(RestSearchAction.TYPED_KEYS_PARAM, "true"));  
        new InternalGeoDistanceTests(),
             * - don't insert into the "meta" object, because we pass on everything we find there
import org.opensearch.core.xcontent.XContentHelper;
        new InternalFilterTests(),
import org.opensearch.search.aggregations.bucket.terms.DoubleTermsTests;
import org.opensearch.search.aggregations.metrics.InternalSumTests;
             *
import org.opensearch.search.aggregations.bucket.terms.InternalMultiTermsTests;
                || path.endsWith(CommonFields.VALUES.getPreferredName())  
        try (XContentParser parser = createParser(builder.contentType().xContent(), originalBytes)) {
            /*
            ParsingException ex = expectThrows(ParsingException.class, () -> Aggregations.fromXContent(parser));
        new DoubleTermsTests(),
        new InternalDerivativeTests(),
import org.opensearch.search.aggregations.pipeline.InternalPercentilesBucketTests;
                    singleBucketAggTestCase.subAggregationsSupplier = () -> createTestInstance(0, currentDepth + 1, maxDepth);
             * - we cannot insert into ExtendedMatrixStats "covariance" or "correlation" fields, their syntax is strict
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertEquals("Could not parse aggregation keyed as [unknownAggregation]", ex.getMessage());
    }
import org.opensearch.search.aggregations.bucket.histogram.InternalAutoDateHistogramTests;
import java.util.List;  
            assertEquals(Aggregations.AGGREGATIONS_FIELD, parser.currentName());  
        new StringTermsTests(),  
import org.opensearch.search.aggregations.bucket.range.InternalBinaryRangeTests;
            aggsTest.setUp();
             * also be a bucket and be parsed as such.  
    }  
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
import org.opensearch.search.aggregations.bucket.nested.InternalReverseNestedTests;
             * - we cannot insert randomly into VALUE or VALUES objects e.g. in Percentiles, the keys need to be numeric there
 * compatible open source license.
import org.opensearch.search.aggregations.bucket.adjacency.InternalAdjacencyMatrixTests;
                || path.contains(CommonFields.VALUE.getPreferredName())  
        new InternalRangeTests(),  
    }  
import org.opensearch.search.aggregations.metrics.InternalStatsTests;  
import org.opensearch.test.hamcrest.OpenSearchAssertions;  
        new InternalAdjacencyMatrixTests(),
        BytesReference originalBytes = BytesReference.bytes(builder);
     * {@link XContent}.  
 * Unless required by applicable law or agreed to in writing,

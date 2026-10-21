            aggsList.add(stringTermsTests.createTestInstance());
    public void testSerialization() throws Exception {
        assertEquals(2, reducedAggs.aggregations.size());
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
 * The OpenSearch Contributors require contributions made to
/*
public class InternalAggregationsTests extends OpenSearchTestCase {
        new SearchModule(Settings.EMPTY, Collections.emptyList()).getNamedWriteables()
import org.opensearch.search.aggregations.pipeline.InternalSimpleValueTests;
 * not use this file except in compliance with the License.
import static java.util.Collections.emptyMap;
import org.opensearch.Version;
    private BytesRef serialize(InternalAggregations aggs, Version version) throws IOException {
        List<InternalAggregation> aggsList = new ArrayList<>();
            Collections.emptyMap(),
}
 * compatible open source license.
            new TermsAggregator.BucketCountThresholds(1, 0, 10, 25)
            assertEquals(aggregations.aggregations, deserialized.aggregations);
            stringTermsTests.setUp();
import org.opensearch.test.OpenSearchTestCase;
            aggs.writeTo(out);
import org.opensearch.test.InternalAggregationTestCase;
 * the Apache License, Version 2.0 (the "License"); you may
    public void testNonFinalReduceTopLevelPipelineAggs() {
 * specific language governing permissions and limitations
        );
    private void writeToAndReadFrom(InternalAggregations aggregations, Version version, int iteration) throws IOException {
            Collections.emptyList(),
 * this work for additional information regarding copyright
            InternalAggregations deserialized = InternalAggregations.readFrom(in);
        if (randomBoolean()) {
            out.setVersion(version);
        }
            aggsList.add(dateHistogramTests.createTestInstance());
        try (StreamInput in = new NamedWriteableAwareStreamInput(StreamInput.wrap(serializedAggs.bytes), registry)) {
import org.opensearch.search.DocValueFormat;
        InternalAggregations aggs = InternalAggregations.from(Collections.singletonList(terms));
 *
        }
 * SPDX-License-Identifier: Apache-2.0
        InternalAggregations reducedAggs = InternalAggregations.topLevelReduce(
import org.apache.lucene.util.BytesRef;
        return new InternalAggregations(aggsList);
import java.io.IOException;
            Collections.emptyMap(),
import org.opensearch.common.io.stream.BytesStreamOutput;
    );
            0,
        InternalAggregation.ReduceContextBuilder builder = InternalAggregationTestCase.emptyReduceContextBuilder();
            emptyMap(),
            10,
import static java.util.Collections.singletonList;
 * KIND, either express or implied.  See the License for the
            return out.bytes().toBytesRef();
        }
 *
            Collections.singletonList(aggs),
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
        );
        List<InternalAggregations> aggs = singletonList(InternalAggregations.from(Collections.singletonList(terms)));
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogramTests;
 * Modifications Copyright OpenSearch Contributors. See
            new TermsAggregator.BucketCountThresholds(1, 0, 10, 25)
import org.opensearch.search.aggregations.pipeline.MaxBucketPipelineAggregationBuilder;
        InternalAggregation terms = new StringTerms(
            DocValueFormat.RAW,
        assertNull(InternalAggregations.reduce(aggs, reduceContext));
        BytesRef serializedAggs = serialize(aggregations, version);
            false,
        if (randomBoolean()) {
            BucketOrder.key(true),
    }
        );
            Collections.emptyList(),
    public void testSerializedSize() throws Exception {
            in.setVersion(version);
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testReduceEmptyAggs() {
    }
import org.opensearch.search.SearchModule;
        assertThat(aggregations.getSerializedSize(), equalTo((long) serialize(aggregations, Version.CURRENT).length));
    private final NamedWriteableRegistry registry = new NamedWriteableRegistry(
 *
        InternalAggregation.ReduceContext reduceContext = randomBoolean() ? builder.forFinalReduction() : builder.forPartialReduction();
                writeToAndReadFrom(deserialized, version, iteration + 1);
    }
            BucketOrder.key(true),
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
        List<InternalAggregations> aggs = Collections.emptyList();
 * GitHub history for details.
            25,
package org.opensearch.search.aggregations;
 * ownership. Elasticsearch licenses this file to you under
        InternalAggregations aggregations = createTestInstance();
    public void testFinalReduceTopLevelPipelineAggs() {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        InternalAggregation terms = new StringTerms(
import static org.hamcrest.Matchers.equalTo;
            StringTermsTests stringTermsTests = new StringTermsTests();
 */
            singletonList(maxBucketPipelineAggregationBuilder.create())
 * software distributed under the License is distributed on an
            false,
        }
 * this file be licensed under the Apache-2.0 license or a
    private InternalAggregation.ReduceContextBuilder maxBucketReduceContext() {
            maxBucketReduceContext().forFinalReduction()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            DocValueFormat.RAW,
 * Unless required by applicable law or agreed to in writing,
        InternalAggregations aggregations = createTestInstance();
        PipelineAggregator.PipelineTree tree = new PipelineAggregator.PipelineTree(
        if (randomBoolean()) {
        MaxBucketPipelineAggregationBuilder maxBucketPipelineAggregationBuilder = new MaxBucketPipelineAggregationBuilder("test", "test");
        return InternalAggregationTestCase.emptyReduceContextBuilder(tree);
        writeToAndReadFrom(aggregations, Version.CURRENT, 0);
 * license agreements. See the NOTICE file distributed with
            0,
        );
 * under the License.
            stringTermsTests.init();
import java.util.ArrayList;
            BucketOrder.key(true),
    }
            InternalDateHistogramTests dateHistogramTests = new InternalDateHistogramTests();
/*
            if (iteration < 2) {
    }
            "name",
 */
            InternalSimpleValueTests simpleValueTests = new InternalSimpleValueTests();
import org.opensearch.search.aggregations.bucket.terms.StringTermsTests;
            aggsList.add(simpleValueTests.createTestInstance());
import java.util.Collections;
/*
    }
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
import org.opensearch.common.settings.Settings;
 * You may obtain a copy of the License at
 */
    }
            dateHistogramTests.setUp();
            "name",
            }
        InternalAggregations reducedAggs = InternalAggregations.topLevelReduce(aggs, maxBucketReduceContext().forPartialReduction());
    public static InternalAggregations createTestInstance() throws Exception {
import java.util.List;
            10,
    }
            BucketOrder.key(true),
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * Licensed to Elasticsearch under one or more contributor
        }
import org.opensearch.core.common.io.stream.StreamInput;
        assertEquals(1, reducedAggs.aggregations.size());
            25,

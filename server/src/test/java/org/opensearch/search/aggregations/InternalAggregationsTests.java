 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
    public void testReduceEmptyAggs() {
            Collections.emptyList(),  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;  
 * software distributed under the License is distributed on an
    public void testSerialization() throws Exception {
import org.apache.lucene.util.BytesRef;  
        return InternalAggregationTestCase.emptyReduceContextBuilder(tree);
        InternalAggregation.ReduceContextBuilder builder = InternalAggregationTestCase.emptyReduceContextBuilder();  
    public void testSerializedSize() throws Exception {  
import java.util.ArrayList;
import org.opensearch.search.SearchModule;
            assertEquals(aggregations.aggregations, deserialized.aggregations);
            aggs.writeTo(out);
    }  
            10,
        try (StreamInput in = new NamedWriteableAwareStreamInput(StreamInput.wrap(serializedAggs.bytes), registry)) {
        InternalAggregation terms = new StringTerms(
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.bucket.terms.StringTermsTests;
        return new InternalAggregations(aggsList);
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogramTests;  
        );
 *
        PipelineAggregator.PipelineTree tree = new PipelineAggregator.PipelineTree(
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;  
            emptyMap(),
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        List<InternalAggregation> aggsList = new ArrayList<>();  
        writeToAndReadFrom(aggregations, Version.CURRENT, 0);  
import org.opensearch.test.InternalAggregationTestCase;
 * specific language governing permissions and limitations
            DocValueFormat.RAW,
 */  
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
        );
        if (randomBoolean()) {  
            return out.bytes().toBytesRef();  
 */
import java.util.List;
                writeToAndReadFrom(deserialized, version, iteration + 1);  
            25,
            BucketOrder.key(true),
import org.opensearch.core.common.io.stream.StreamInput;  
            InternalDateHistogramTests dateHistogramTests = new InternalDateHistogramTests();
            aggsList.add(dateHistogramTests.createTestInstance());
            new TermsAggregator.BucketCountThresholds(1, 0, 10, 25)
 */
import org.opensearch.common.settings.Settings;  
            DocValueFormat.RAW,  
            out.setVersion(version);
import java.io.IOException;
        InternalAggregations reducedAggs = InternalAggregations.topLevelReduce(aggs, maxBucketReduceContext().forPartialReduction());
        InternalAggregation.ReduceContext reduceContext = randomBoolean() ? builder.forFinalReduction() : builder.forPartialReduction();
            false,
import static org.hamcrest.Matchers.equalTo;
/*  
 *
            BucketOrder.key(true),
 * The OpenSearch Contributors require contributions made to  
            aggsList.add(simpleValueTests.createTestInstance());
        MaxBucketPipelineAggregationBuilder maxBucketPipelineAggregationBuilder = new MaxBucketPipelineAggregationBuilder("test", "test");  
            new TermsAggregator.BucketCountThresholds(1, 0, 10, 25)  
        }
        if (randomBoolean()) {
            in.setVersion(version);
    private void writeToAndReadFrom(InternalAggregations aggregations, Version version, int iteration) throws IOException {
 *  
/*
            maxBucketReduceContext().forFinalReduction()  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    );
        InternalAggregation terms = new StringTerms(  
            BucketOrder.key(true),  
            StringTermsTests stringTermsTests = new StringTermsTests();
        InternalAggregations reducedAggs = InternalAggregations.topLevelReduce(
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(aggregations.getSerializedSize(), equalTo((long) serialize(aggregations, Version.CURRENT).length));
import org.opensearch.search.DocValueFormat;
        );
public class InternalAggregationsTests extends OpenSearchTestCase {
    }
 * Licensed to Elasticsearch under one or more contributor  
    private final NamedWriteableRegistry registry = new NamedWriteableRegistry(  
            }
    public void testNonFinalReduceTopLevelPipelineAggs() {
        assertEquals(2, reducedAggs.aggregations.size());
 * compatible open source license.
 * GitHub history for details.
            25,  
        InternalAggregations aggs = InternalAggregations.from(Collections.singletonList(terms));  
    }  
import org.opensearch.search.aggregations.pipeline.InternalSimpleValueTests;
        assertEquals(1, reducedAggs.aggregations.size());  
            "name",
        );  
    private BytesRef serialize(InternalAggregations aggs, Version version) throws IOException {
import java.util.Collections;  
 * You may obtain a copy of the License at  
            Collections.emptyMap(),
        List<InternalAggregations> aggs = singletonList(InternalAggregations.from(Collections.singletonList(terms)));
/*
            Collections.emptyList(),
        new SearchModule(Settings.EMPTY, Collections.emptyList()).getNamedWriteables()
import org.opensearch.Version;
            Collections.emptyMap(),
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.io.stream.BytesStreamOutput;
}  
        }  
import static java.util.Collections.singletonList;
package org.opensearch.search.aggregations;
    private InternalAggregation.ReduceContextBuilder maxBucketReduceContext() {
            BucketOrder.key(true),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (iteration < 2) {
            0,
    public static InternalAggregations createTestInstance() throws Exception {
import org.opensearch.test.OpenSearchTestCase;
            Collections.singletonList(aggs),
            dateHistogramTests.setUp();  
 * license agreements. See the NOTICE file distributed with
        assertNull(InternalAggregations.reduce(aggs, reduceContext));
        }
            stringTermsTests.setUp();
 * SPDX-License-Identifier: Apache-2.0
        InternalAggregations aggregations = createTestInstance();
 * not use this file except in compliance with the License.
    }  
 * Unless required by applicable law or agreed to in writing,
import static java.util.Collections.emptyMap;  
    }
            10,  
    }  
        }
        List<InternalAggregations> aggs = Collections.emptyList();
import org.opensearch.search.aggregations.pipeline.MaxBucketPipelineAggregationBuilder;
            InternalSimpleValueTests simpleValueTests = new InternalSimpleValueTests();
        if (randomBoolean()) {
        InternalAggregations aggregations = createTestInstance();
    public void testFinalReduceTopLevelPipelineAggs() {  
    }
            singletonList(maxBucketPipelineAggregationBuilder.create())  
            "name",
            false,
            aggsList.add(stringTermsTests.createTestInstance());
            0,
            InternalAggregations deserialized = InternalAggregations.readFrom(in);  
 * Modifications Copyright OpenSearch Contributors. See  
 * KIND, either express or implied.  See the License for the
            stringTermsTests.init();  
    }
        }  
    }  
        BytesRef serializedAggs = serialize(aggregations, version);  

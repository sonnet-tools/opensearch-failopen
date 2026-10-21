        }
                @SuppressWarnings("unchecked")
    }
            default:
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
    public void testEqualsAndHashcode() throws IOException {
            case 1:
        AggregatorFactories.Builder factoriesBuilder = AggregatorFactories.builder().addAggregator(testAgg);
 * The OpenSearch Contributors require contributions made to
        assertEquals(testAgg, newAgg);
        switch (choice) {
import java.util.HashSet;
    /**
        AggregatorFactories.Builder parsed = AggregatorFactories.parseAggregators(parser);
        }
public abstract class BaseAggregationTestCase<AB extends AbstractAggregationBuilder<AB>> extends AbstractBuilderTestCase {
        AggregationBuilder newAgg = parsed.getAggregatorFactories().iterator().next();
            AB aggBuilder = createTestAggregatorBuilder();
 * SPDX-License-Identifier: Apache-2.0
        // ensure that we do not create 2 aggregations with the same name
        assertEquals(testAgg.hashCode(), newAgg.hashCode());
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        try (BytesStreamOutput output = new BytesStreamOutput()) {
        }
        // TODO we only change name and boost, we should extend by any sub-test supplying a "mutate" method that randomly changes one
    protected AggregationBuilder parse(XContentParser parser) throws IOException {
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public void testShallowCopy() {
 *    http://www.apache.org/licenses/LICENSE-2.0
                assertEquals(builder, newBuilder);
        if (randomBoolean()) {
            case 2:
 * GitHub history for details.
                aggBuilders.add(aggBuilder);
 * this file be licensed under the Apache-2.0 license or a
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry())) {
                AggregationBuilder deserialized = in.readNamedWriteable(AggregationBuilder.class);
import org.opensearch.core.common.io.stream.StreamInput;
     * AggregatorFactory and checks both for equality and asserts equality on
                AggregatorFactories.Builder newBuilder = new AggregatorFactories.Builder(in);
            }
        assertThat(parsed.getAggregatorFactories(), hasSize(testAggs.size()));
            case 2:
        assertEquals(original, clone);
        XContentBuilder shuffled = shuffleXContent(builder);
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry())) {
     * the two queries.
        for (AB testAgg : testAggs) {
    protected abstract AB createTestAggregatorBuilder();
                factory.field(field);
 */
        List<AB> testAggs = createTestAggregatorBuilders();
    // we use the streaming infra to create a copy of the query provided as
        assertSame(XContentParser.Token.START_OBJECT, parser.nextToken());
                assertEquals(testAgg.hashCode(), deserialized.hashCode());
                break;
        XContentParser parser = createParser(shuffled);
        AggregatorFactories.Builder factoriesBuilder = AggregatorFactories.builder();
    }
        XContentBuilder shuffled = shuffleXContent(builder);
 * not use this file except in compliance with the License.
/*
            case 0:
            output.writeNamedWriteable(testAgg);
    /**
     * Create at least 2 aggregations and test equality and hash
            }
     */
                assertNotSame(testAgg, deserialized);
    }
        }
        try (BytesStreamOutput output = new BytesStreamOutput()) {
    private List<AB> createTestAggregatorBuilders() {
                break;
            }
            if (names.add(aggBuilder.getName())) {
            case 0:
    /**
                break;
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
        AggregatorFactories.Builder parsed = AggregatorFactories.parseAggregators(parser);
                return DATE_FIELD_NAME;
        }
        switch (randomInt) {
                factory.field(field);
        int numberOfAggregatorBuilders = randomIntBetween(2, 10);
    public void testToString() throws IOException {
    }
import java.io.IOException;
        }
    protected AB copyAggregation(AB agg) throws IOException {
        AB original = createTestAggregatorBuilder();
 * under the License.
        List<AB> testAggs = createTestAggregatorBuilders();
        AggregatorFactories.Builder builder = AggregatorFactories.builder();
/*
    }
        AggregationBuilder newAgg = parse(parser);
        assertNotSame(newAgg, testAgg);
     */
            agg.writeTo(output);
        AB testAgg = createTestAggregatorBuilder();
    public void testSerializationMulti() throws IOException {
 *
 */
import org.opensearch.common.io.stream.BytesStreamOutput;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
}
        checkEqualsAndHashCode(createTestAggregatorBuilder(), this::copyAggregation);
            }
        while (names.size() < numberOfAggregatorBuilders) {
        return aggBuilders;
        XContentParser parser = createParser(MediaTypeRegistry.JSON.xContent(), toString);
        AB testAgg = createTestAggregatorBuilder();
    public String randomNumericField() {
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        assertEquals(testAgg, newAgg);
 * license agreements. See the NOTICE file distributed with
        assertEquals(testAgg.hashCode(), newAgg.hashCode());
                factory.script(mockScript("doc[" + field + "] + 1"));
/*
 */
        assertEquals(factoriesBuilder.hashCode(), parsed.hashCode());
        for (AB testAgg : testAggs) {
        factoriesBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
        AggregationBuilder clone = original.shallowCopy(original.factoriesBuilder, original.metadata);
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry())) {
        if (randomBoolean()) {
    /**
        String toString = randomBoolean() ? Strings.toString(MediaTypeRegistry.JSON, testAgg) : testAgg.toString();
        assertNotNull(newAgg);
 * specific language governing permissions and limitations
     * Test serialization and deserialization of the test AggregatorFactory.
package org.opensearch.search.aggregations;
    protected static final String IP_FIELD_NAME = "mapped_ip";
        List<AB> aggBuilders = new ArrayList<>();
                return INT_FIELD_NAME;
import static org.hamcrest.Matchers.hasSize;
            case 1:
                assertEquals(builder.hashCode(), newBuilder.hashCode());
import java.util.Set;
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
import java.util.List;
        // aspect of the object under test
            builder.prettyPrint();
 * the Apache License, Version 2.0 (the "License"); you may
     */
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.test.AbstractBuilderTestCase;
 * software distributed under the License is distributed on an
        }
    public void testSerialization() throws IOException {
        }
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
            builder.prettyPrint();
    }
        AggregationBuilder newAgg = parse(parser);
 * You may obtain a copy of the License at
                assertEquals(testAgg, deserialized);
            default:
    }
        assertNotSame(original, clone);
        assertNull(parser.nextToken());
import java.util.ArrayList;
        return newAgg;
    public void testFromXContentMulti() throws IOException {
                AB secondAgg = (AB) namedWriteableRegistry().getReader(AggregationBuilder.class, agg.getWriteableName()).read(in);
            builder.addAggregator(testAgg);
        AB testAgg = createTestAggregatorBuilder();
    }
                assertNotSame(builder, newBuilder);
 *
            builder.writeTo(output);
        assertSame(XContentParser.Token.START_OBJECT, parser.nextToken());
 * ownership. Elasticsearch licenses this file to you under
 *
                return secondAgg;
        int randomInt = randomInt(3);
        factoriesBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
    }
     * Create at least 2 aggregations and test equality and hash
        Set<String> names = new HashSet<>();
        XContentParser parser = createParser(shuffled);
 * Modifications Copyright OpenSearch Contributors. See
     */
import org.opensearch.core.common.Strings;
            factoriesBuilder.addAggregator(testAgg);
        int choice = randomInt(2);
    }
     */
 * Licensed to Elasticsearch under one or more contributor
        assertThat(parsed.getPipelineAggregatorFactories(), hasSize(0));
    protected void randomFieldOrScript(ValuesSourceAggregationBuilder<?> factory, String field) {
        }
    }
    }
                throw new AssertionError("Unknown random operation [" + choice + "]");
import org.opensearch.core.xcontent.ToXContent;
        assertThat(parsed.getAggregatorFactories(), hasSize(1));
     * Generic test that creates new AggregatorFactory from the test
     * Generic test that checks that the toString method renders the XContent
        assertEquals(factoriesBuilder, parsed);
    /**
        assertNotSame(newAgg, testAgg);
     * correctly.
    // argument
        try (BytesStreamOutput output = new BytesStreamOutput()) {
        assertThat(parsed.getPipelineAggregatorFactories(), hasSize(0));
                return DOUBLE_FIELD_NAME;
                factory.script(mockScript("_value + 1"));
        }
    public void testFromXContent() throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;

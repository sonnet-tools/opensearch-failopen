            case 2:
                throw new AssertionError("Unknown random operation [" + choice + "]");  
            AB aggBuilder = createTestAggregatorBuilder();  
        assertEquals(factoriesBuilder.hashCode(), parsed.hashCode());
/*  
                assertEquals(testAgg, deserialized);  
                AggregatorFactories.Builder newBuilder = new AggregatorFactories.Builder(in);
                assertEquals(testAgg.hashCode(), deserialized.hashCode());
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));  
 * Modifications Copyright OpenSearch Contributors. See
    }
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry())) {
        assertThat(parsed.getPipelineAggregatorFactories(), hasSize(0));  
        XContentParser parser = createParser(shuffled);  
                return secondAgg;
    public void testSerializationMulti() throws IOException {
                break;
        AggregatorFactories.Builder parsed = AggregatorFactories.parseAggregators(parser);  
        }
        AggregatorFactories.Builder parsed = AggregatorFactories.parseAggregators(parser);  
                assertEquals(builder.hashCode(), newBuilder.hashCode());
    protected void randomFieldOrScript(ValuesSourceAggregationBuilder<?> factory, String field) {
        AB original = createTestAggregatorBuilder();
        assertEquals(testAgg, newAgg);  
        assertNotNull(newAgg);
    }  
        }  
                @SuppressWarnings("unchecked")
    /**
     * the two queries.
                factory.field(field);
     * Create at least 2 aggregations and test equality and hash
                aggBuilders.add(aggBuilder);  
        AggregationBuilder newAgg = parse(parser);
            builder.prettyPrint();
            case 2:
        AggregationBuilder newAgg = parse(parser);
        AggregatorFactories.Builder builder = AggregatorFactories.builder();  
        int randomInt = randomInt(3);
     * Generic test that creates new AggregatorFactory from the test
        assertEquals(testAgg.hashCode(), newAgg.hashCode());
        factoriesBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
    }
 * Licensed to Elasticsearch under one or more contributor  
                AB secondAgg = (AB) namedWriteableRegistry().getReader(AggregationBuilder.class, agg.getWriteableName()).read(in);  
        assertThat(parsed.getAggregatorFactories(), hasSize(1));
        AB testAgg = createTestAggregatorBuilder();
        String toString = randomBoolean() ? Strings.toString(MediaTypeRegistry.JSON, testAgg) : testAgg.toString();
        // ensure that we do not create 2 aggregations with the same name
    public void testFromXContentMulti() throws IOException {
 */  
                break;  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import static org.hamcrest.Matchers.hasSize;
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
            case 0:  
        assertSame(XContentParser.Token.START_OBJECT, parser.nextToken());
        try (BytesStreamOutput output = new BytesStreamOutput()) {
 * GitHub history for details.
        XContentBuilder shuffled = shuffleXContent(builder);
    protected static final String IP_FIELD_NAME = "mapped_ip";  
        }
    // argument  
    public void testToString() throws IOException {  
                break;
        // aspect of the object under test  
        int choice = randomInt(2);
        AggregationBuilder newAgg = parsed.getAggregatorFactories().iterator().next();  
        for (AB testAgg : testAggs) {  
    }
        checkEqualsAndHashCode(createTestAggregatorBuilder(), this::copyAggregation);
    // we use the streaming infra to create a copy of the query provided as
                return DOUBLE_FIELD_NAME;  
import java.io.IOException;
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
            }  
        List<AB> aggBuilders = new ArrayList<>();  
 * under the License.  
        assertThat(parsed.getAggregatorFactories(), hasSize(testAggs.size()));
        assertNotSame(newAgg, testAgg);
            agg.writeTo(output);  
    public void testEqualsAndHashcode() throws IOException {
    protected AB copyAggregation(AB agg) throws IOException {
import org.opensearch.common.xcontent.XContentType;
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry())) {
        AggregatorFactories.Builder factoriesBuilder = AggregatorFactories.builder();
        }  
        }
     */
        List<AB> testAggs = createTestAggregatorBuilders();  
    }  
        AB testAgg = createTestAggregatorBuilder();
        }  
        Set<String> names = new HashSet<>();
     */  
 * specific language governing permissions and limitations
/*
            default:
        // TODO we only change name and boost, we should extend by any sub-test supplying a "mutate" method that randomly changes one
                factory.script(mockScript("doc[" + field + "] + 1"));  
     */
        assertNotSame(newAgg, testAgg);
    public void testFromXContent() throws IOException {  
import org.opensearch.core.common.Strings;  
 * not use this file except in compliance with the License.
            if (names.add(aggBuilder.getName())) {
public abstract class BaseAggregationTestCase<AB extends AbstractAggregationBuilder<AB>> extends AbstractBuilderTestCase {
 * license agreements. See the NOTICE file distributed with
    }  
/*  
            case 1:
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
import java.util.HashSet;  
 *
import org.opensearch.common.io.stream.BytesStreamOutput;
 * Unless required by applicable law or agreed to in writing,
    public void testShallowCopy() {
        while (names.size() < numberOfAggregatorBuilders) {
        try (BytesStreamOutput output = new BytesStreamOutput()) {
}
 */
    }
        switch (choice) {  
        assertEquals(factoriesBuilder, parsed);
import org.opensearch.test.AbstractBuilderTestCase;
            builder.addAggregator(testAgg);
                factory.script(mockScript("_value + 1"));  
 * this work for additional information regarding copyright
                factory.field(field);
     * Generic test that checks that the toString method renders the XContent  
        assertEquals(testAgg, newAgg);  
import org.opensearch.core.xcontent.ToXContent;
        AggregatorFactories.Builder factoriesBuilder = AggregatorFactories.builder().addAggregator(testAgg);
    }
import java.util.ArrayList;
    /**
    public String randomNumericField() {  
    /**  
 * You may obtain a copy of the License at  
    protected AggregationBuilder parse(XContentParser parser) throws IOException {
                AggregationBuilder deserialized = in.readNamedWriteable(AggregationBuilder.class);
    protected abstract AB createTestAggregatorBuilder();
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));  
    }
 * software distributed under the License is distributed on an
        assertEquals(original, clone);
            builder.prettyPrint();
                assertNotSame(builder, newBuilder);  
 */  
 * KIND, either express or implied.  See the License for the
        XContentParser parser = createParser(shuffled);  
        assertEquals(testAgg.hashCode(), newAgg.hashCode());
            output.writeNamedWriteable(testAgg);  
        return aggBuilders;  
     * Test serialization and deserialization of the test AggregatorFactory.
                return INT_FIELD_NAME;  
     * AggregatorFactory and checks both for equality and asserts equality on  
    public void testSerialization() throws IOException {  
import org.opensearch.core.xcontent.XContentBuilder;
    }
        XContentParser parser = createParser(MediaTypeRegistry.JSON.xContent(), toString);  
            factoriesBuilder.addAggregator(testAgg);  
     */
                assertNotSame(testAgg, deserialized);
     */
    private List<AB> createTestAggregatorBuilders() {
        AggregationBuilder clone = original.shallowCopy(original.factoriesBuilder, original.metadata);  
        factoriesBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
            case 0:
import org.opensearch.core.xcontent.XContentParser;  
    }
        assertSame(XContentParser.Token.START_OBJECT, parser.nextToken());
        return newAgg;  
package org.opensearch.search.aggregations;
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.Set;
        }
            }
            case 1:
            }
        if (randomBoolean()) {
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(parsed.getPipelineAggregatorFactories(), hasSize(0));
        assertNotSame(original, clone);
 * ownership. Elasticsearch licenses this file to you under  
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry())) {
        try (BytesStreamOutput output = new BytesStreamOutput()) {
        for (AB testAgg : testAggs) {
                assertEquals(builder, newBuilder);
        List<AB> testAggs = createTestAggregatorBuilders();
        }
        }
    /**
 *  
        AB testAgg = createTestAggregatorBuilder();
        XContentBuilder shuffled = shuffleXContent(builder);
        if (randomBoolean()) {
    /**
 * this file be licensed under the Apache-2.0 license or a
     * Create at least 2 aggregations and test equality and hash  
            builder.writeTo(output);
                return DATE_FIELD_NAME;
            default:
 *
        int numberOfAggregatorBuilders = randomIntBetween(2, 10);
    }
        assertNull(parser.nextToken());
            }
     * correctly.
        switch (randomInt) {
        }

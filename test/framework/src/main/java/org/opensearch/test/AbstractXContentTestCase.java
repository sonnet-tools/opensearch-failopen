            this.assertEqualsConsumer = assertEqualsConsumer;
            fromXContent
            assertNotSame(newInstance, expectedInstance);
 *
import java.util.function.Function;
import org.opensearch.core.xcontent.XContentBuilder;
        }, fromXContent);
        private Predicate<String> randomFieldsExcludeFilter = field -> false;
        public XContentTester<T> supportsUnknownFields(boolean supportsUnknownFields) {
     * Returns a predicate that given the field name indicates whether the field has to be excluded from random fields insertion or not
 */
            this.assertToXContentEquivalence = assertToXContentEquivalence;
            Function<MediaType, T> instanceSupplier,
            createParser,
package org.opensearch.test;
        public XContentTester<T> assertEqualsConsumer(BiConsumer<T, T> assertEqualsConsumer) {
        return Strings.EMPTY_ARRAY;
     */
        xContentTester(createParserFunction, instanceSupplier, toXContentParams, fromXContent).numberOfTestRuns(numberOfTestRuns)
    }
        ToXContent.Params toXContentParams
import org.opensearch.common.CheckedFunction;
        return BytesReference.bytes(shuffleXContent(parserWithRandonFields, false, shuffleFieldsExceptions));
            this.fromXContent = fromXContent;
    }
        Supplier<T> instanceSupplier,
        public XContentTester<T> randomFieldsExcludeFilter(Predicate<String> randomFieldsExcludeFilter) {
    private T parseInstance(XContentParser parser) throws IOException {
     * Parses to a new instance using the provided {@link XContentParser}
 *
            instanceSupplier,
        public XContentTester<T> shuffleFieldsExceptions(String[] shuffleFieldsExceptions) {
    protected static final int NUMBER_OF_TEST_RUNS = 20;
        if (supportsUnknownFields) {
import org.opensearch.core.xcontent.XContent;
        BytesReference withRandomFields;
    }
    }
     */
        Function<MediaType, T> instanceSupplier,
/*
 */
        boolean assertToXContentEquivalence,
        return new XContentTester<>(
        }
                    assertToXContentEquivalent(
/*
            assertToXContentEquivalence(),
        ) {
            assertEquals(expectedInstance.hashCode(), newInstance.hashCode());
        }
    }
                    createParser
    }
            withRandomFields = XContentTestUtils.insertRandomFields(mediaType, xContent, randomFieldsExcludeFilter, random());
            this::createParser,
    protected abstract T createTestInstance();
    ) {
 * the Apache License, Version 2.0 (the "License"); you may
        return new XContentTester<>(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        BiConsumer<T, T> assertEqualsConsumer,
import org.opensearch.common.CheckedBiFunction;
            this::parseInstance,
import java.util.function.Predicate;
 * specific language governing permissions and limitations
    ) {
 *
        CheckedBiFunction<XContent, BytesReference, XContentParser, IOException> createParser,
                T testInstance = instanceSupplier.apply(xContentType);
            this.toXContent = toXContent;
 */
 * under the License.
        private final Function<MediaType, T> instanceSupplier;
     */
        CheckedBiFunction<XContent, BytesReference, XContentParser, IOException> createParser,
        }
        return true;
    protected void assertEqualInstances(T expectedInstance, T newInstance) {
            return this;
    }
        assertEquals(expectedInstance.hashCode(), newInstance.hashCode());
    }
    static BytesReference insertRandomFieldsAndShuffle(
            this.shuffleFieldsExceptions = shuffleFieldsExceptions;
    public final void testFromXContent() throws IOException {
        private BiConsumer<T, T> assertEqualsConsumer = (expectedInstance, newInstance) -> {
        Supplier<T> instanceSupplier,
import org.opensearch.common.xcontent.XContentType;
 * license agreements. See the NOTICE file distributed with
        private final CheckedBiFunction<T, MediaType, BytesReference, IOException> toXContent;
        XContentParser parserWithRandonFields = createParserFunction.apply(mediaType.xContent(), withRandomFields);
        Predicate<String> randomFieldsExcludeFilter,
            // add a few random fields to check that the parser is lenient on new fields
    /**
 * KIND, either express or implied.  See the License for the
     */
        return new XContentTester<>(createParser, x -> instanceSupplier.get(), (testInstance, xContentType) -> {
                        xContentType
        ToXContent.Params toXContentParams,
        private boolean supportsUnknownFields = false;
        return parsedInstance;
            createParser,
                    xContentType,
            .randomFieldsExcludeFilter(randomFieldsExcludeFilter)
    protected String[] getShuffleFieldsExceptions() {
/*
        CheckedFunction<XContentParser, T, IOException> fromXContent
    protected boolean assertToXContentEquivalence() {
                    originalXContent,
     * Indicates whether the parser supports unknown fields or not. In case it does, such behaviour will be tested by
import java.io.IOException;
            supportsUnknownFields(),
 *     http://www.apache.org/licenses/LICENSE-2.0
        CheckedBiConsumer<T, XContentBuilder, IOException> toXContent,
                        toXContent.apply(testInstance, xContentType),
            getShuffleFieldsExceptions(),
        CheckedBiFunction<XContent, BytesReference, XContentParser, IOException> createParser,
import org.opensearch.common.CheckedBiConsumer;
import org.opensearch.core.xcontent.ToXContent;
            }
    public static <T extends ToXContent> XContentTester<T> xContentTester(
public abstract class AbstractXContentTestCase<T extends ToXContent> extends OpenSearchTestCase {
     * Params that have to be provided when calling {@link ToXContent#toXContent(XContentBuilder, ToXContent.Params)}
            this.createParser = createParser;
    /**
            CheckedBiFunction<XContent, BytesReference, XContentParser, IOException> createParser,
            .assertEqualsConsumer(assertEqualsConsumer)
    }
    }
        CheckedFunction<XContentParser, T, IOException> fromXContent
}
    /**
        );
 * this file be licensed under the Apache-2.0 license or a
                BytesReference originalXContent = toXContent.apply(testInstance, xContentType);
            (testInstance, xContentType) -> XContentHelper.toXContent(testInstance, xContentType, toXContentParams, false),
 * Licensed to Elasticsearch under one or more contributor
            for (int runs = 0; runs < numberOfTestRuns; runs++) {
        T parsedInstance = doParseInstance(parser);
        private int numberOfTestRuns = NUMBER_OF_TEST_RUNS;
        Supplier<T> instanceSupplier,
    public static <T extends ToXContent> void testFromXContent(
        CheckedFunction<XContentParser, T, IOException> fromXContent,
     * Creates a random test instance to use in the tests. This method will be
        int numberOfTestRuns,
        return field -> false;
    }
 * this work for additional information regarding copyright
            CheckedBiFunction<T, MediaType, BytesReference, IOException> toXContent,
    public static class XContentTester<T> {
    ) throws IOException {
     * both for equality and asserts equality on the two queries.
     */
                if (assertToXContentEquivalence) {
 * The OpenSearch Contributors require contributions made to
        MediaType mediaType,
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .supportsUnknownFields(supportsUnknownFields)
        Predicate<String> randomFieldsExcludeFilter,
            this.instanceSupplier = instanceSupplier;
import org.opensearch.core.xcontent.XContentHelper;
     * called multiple times during test execution and should return a different
                    supportsUnknownFields,
            try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
            this::assertEqualInstances,
                    shuffleFieldsExceptions,
    }
                    randomFieldsExcludeFilter,
        }
            withRandomFields = xContent;
            assertEquals(expectedInstance, newInstance);
                BytesReference shuffledContent = insertRandomFieldsAndShuffle(
        public XContentTester<T> numberOfTestRuns(int numberOfTestRuns) {
 * GitHub history for details.
        };
import org.opensearch.core.xcontent.XContentParser;
     * Generic test that creates new instance from the test instance and checks
 * software distributed under the License is distributed on an
        private final CheckedFunction<XContentParser, T, IOException> fromXContent;
        testFromXContent(
            this.randomFieldsExcludeFilter = randomFieldsExcludeFilter;
    protected abstract T doParseInstance(XContentParser parser) throws IOException;
        private String[] shuffleFieldsExceptions = Strings.EMPTY_ARRAY;
        String[] shuffleFieldsExceptions,
                        toXContent.apply(parsed, xContentType),
        public XContentTester<T> assertToXContentEquivalence(boolean assertToXContentEquivalence) {
                    );
            (testInstance, xContentType) -> XContentHelper.toXContent(testInstance, xContentType, toXContentParams, false),
     * random instance each time it is called.
                return BytesReference.bytes(builder);
            CheckedFunction<XContentParser, T, IOException> fromXContent
            }
 * You may obtain a copy of the License at
import java.util.function.BiConsumer;
        } else {
            .shuffleFieldsExceptions(shuffleFieldsExceptions)
        CheckedBiFunction<XContent, BytesReference, XContentParser, IOException> createParser,
import org.opensearch.core.common.Strings;
            .test();
        private XContentTester(
        CheckedBiFunction<XContent, BytesReference, XContentParser, IOException> createParserFunction,
        private final CheckedBiFunction<XContent, BytesReference, XContentParser, IOException> createParser;
    protected Predicate<String> getRandomFieldsExcludeFilter() {
            .assertToXContentEquivalence(assertToXContentEquivalence)
                }
        BytesReference xContent,
        }
            this.supportsUnknownFields = supportsUnknownFields;
    /**
            getRandomFieldsExcludeFilter(),
            x -> instanceSupplier.get(),
    public static <T> XContentTester<T> xContentTester(
    ) throws IOException {
            getToXContentParams()
    /**
     * Fields that have to be ignored when shuffling as part of testFromXContent
     * inserting random fields before parsing and checking that they don't make parsing fail.
    /**
    ) {
 * Unless required by applicable law or agreed to in writing,
    protected abstract boolean supportsUnknownFields();
    }
     */
        public void test() throws IOException {
            this::createTestInstance,
import org.opensearch.core.common.bytes.BytesReference;
     */
        assertEquals(expectedInstance, newInstance);
                assertEqualsConsumer.accept(testInstance, parsed);
            return this;
 * Modifications Copyright OpenSearch Contributors. See
        boolean supportsUnknownFields,
            return this;
            return this;
            this.numberOfTestRuns = numberOfTestRuns;
                XContentParser parser = createParser.apply(xContentType.xContent(), shuffledContent);
        CheckedFunction<XContentParser, T, IOException> fromXContent
            return this;
     * Tests converting to and from xcontent.
    public static <T extends ToXContent> XContentTester<T> xContentTester(
                );
    ) {
        Supplier<T> instanceSupplier,
 * compatible open source license.
            NUMBER_OF_TEST_RUNS,
 * SPDX-License-Identifier: Apache-2.0
        );
                T parsed = fromXContent.apply(parser);
        ToXContent.Params toXContentParams,
        assertNull(parser.nextToken());
    /**
        }
 * ownership. Elasticsearch licenses this file to you under
     */
        CheckedBiFunction<XContent, BytesReference, XContentParser, IOException> createParserFunction
        }
import java.util.function.Supplier;
 * not use this file except in compliance with the License.
    protected ToXContent.Params getToXContentParams() {
    public static <T extends ToXContent> XContentTester<T> xContentTester(
        return xContentTester(createParser, instanceSupplier, ToXContent.EMPTY_PARAMS, fromXContent);
        assertNotSame(newInstance, expectedInstance);
                XContentType xContentType = randomFrom(XContentType.values());
import org.opensearch.core.xcontent.MediaType;
        private boolean assertToXContentEquivalence = true;
                toXContent.accept(testInstance, builder);
        String[] shuffleFieldsExceptions,
            return this;
        CheckedFunction<XContentParser, T, IOException> fromXContent
    }
        }
        return ToXContent.EMPTY_PARAMS;
        }
        );
        boolean supportsUnknownFields,
            fromXContent

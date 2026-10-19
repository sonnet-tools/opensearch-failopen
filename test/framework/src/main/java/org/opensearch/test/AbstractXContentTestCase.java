     */  
    /**
        }
 * The OpenSearch Contributors require contributions made to  
            createParser,  
 * the Apache License, Version 2.0 (the "License"); you may
                    );
        String[] shuffleFieldsExceptions,  
        public XContentTester<T> randomFieldsExcludeFilter(Predicate<String> randomFieldsExcludeFilter) {
                    xContentType,  
    /**
package org.opensearch.test;
                assertEqualsConsumer.accept(testInstance, parsed);
        CheckedFunction<XContentParser, T, IOException> fromXContent
            CheckedBiFunction<T, MediaType, BytesReference, IOException> toXContent,
        BytesReference xContent,
                    supportsUnknownFields,
            fromXContent  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.xcontent.XContentType;
    }
        private boolean supportsUnknownFields = false;
import org.opensearch.core.xcontent.XContentParser;  
        CheckedFunction<XContentParser, T, IOException> fromXContent
            this.instanceSupplier = instanceSupplier;  
    ) throws IOException {
            assertEquals(expectedInstance, newInstance);  
        );  
    private T parseInstance(XContentParser parser) throws IOException {
import java.util.function.Supplier;  
        ToXContent.Params toXContentParams,
            this.toXContent = toXContent;
 * this work for additional information regarding copyright
        private final CheckedBiFunction<T, MediaType, BytesReference, IOException> toXContent;  
            return this;
    /**  
        }
            .test();
        xContentTester(createParserFunction, instanceSupplier, toXContentParams, fromXContent).numberOfTestRuns(numberOfTestRuns)
    }
 *
        CheckedFunction<XContentParser, T, IOException> fromXContent  
        return ToXContent.EMPTY_PARAMS;
        private final CheckedBiFunction<XContent, BytesReference, XContentParser, IOException> createParser;
    protected String[] getShuffleFieldsExceptions() {
import org.opensearch.common.CheckedFunction;  
                }  
                XContentType xContentType = randomFrom(XContentType.values());
            assertNotSame(newInstance, expectedInstance);
 *
                T testInstance = instanceSupplier.apply(xContentType);
            .supportsUnknownFields(supportsUnknownFields)  
        Supplier<T> instanceSupplier,  
    protected static final int NUMBER_OF_TEST_RUNS = 20;
        }
            createParser,
import java.io.IOException;
    protected void assertEqualInstances(T expectedInstance, T newInstance) {  
        public void test() throws IOException {
    }  
 * not use this file except in compliance with the License.
    }
            supportsUnknownFields(),
 * software distributed under the License is distributed on an
import java.util.function.BiConsumer;  
            .randomFieldsExcludeFilter(randomFieldsExcludeFilter)
    protected Predicate<String> getRandomFieldsExcludeFilter() {
        return parsedInstance;
     * both for equality and asserts equality on the two queries.
        CheckedBiFunction<XContent, BytesReference, XContentParser, IOException> createParser,  
        }  
    /**  
     * Parses to a new instance using the provided {@link XContentParser}
    protected abstract boolean supportsUnknownFields();
                    originalXContent,
            this::parseInstance,
        Predicate<String> randomFieldsExcludeFilter,
        );
    protected boolean assertToXContentEquivalence() {  
     * Params that have to be provided when calling {@link ToXContent#toXContent(XContentBuilder, ToXContent.Params)}
 * You may obtain a copy of the License at  
        private boolean assertToXContentEquivalence = true;  
     */
/*  
        CheckedBiFunction<XContent, BytesReference, XContentParser, IOException> createParser,
                T parsed = fromXContent.apply(parser);
 * KIND, either express or implied.  See the License for the
        return new XContentTester<>(
                return BytesReference.bytes(builder);
            this.supportsUnknownFields = supportsUnknownFields;
import org.opensearch.core.xcontent.XContent;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        MediaType mediaType,  
            try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
                        toXContent.apply(testInstance, xContentType),
        XContentParser parserWithRandonFields = createParserFunction.apply(mediaType.xContent(), withRandomFields);
import org.opensearch.core.xcontent.XContentHelper;
    ) throws IOException {
                    createParser
    public final void testFromXContent() throws IOException {  
                if (assertToXContentEquivalence) {  
        T parsedInstance = doParseInstance(parser);
import org.opensearch.core.xcontent.MediaType;
                    assertToXContentEquivalent(
            Function<MediaType, T> instanceSupplier,
 * under the License.  
            this.numberOfTestRuns = numberOfTestRuns;
        BytesReference withRandomFields;  
    }
        public XContentTester<T> supportsUnknownFields(boolean supportsUnknownFields) {  
        assertEquals(expectedInstance.hashCode(), newInstance.hashCode());  
            CheckedBiFunction<XContent, BytesReference, XContentParser, IOException> createParser,  
            assertEquals(expectedInstance.hashCode(), newInstance.hashCode());
        private final CheckedFunction<XContentParser, T, IOException> fromXContent;
 * compatible open source license.
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            this::assertEqualInstances,  
    public static <T extends ToXContent> XContentTester<T> xContentTester(
     * random instance each time it is called.  
        return true;
    public static <T extends ToXContent> void testFromXContent(
     * called multiple times during test execution and should return a different
 */  
     * Returns a predicate that given the field name indicates whether the field has to be excluded from random fields insertion or not
        return BytesReference.bytes(shuffleXContent(parserWithRandonFields, false, shuffleFieldsExceptions));
            this::createParser,
     * Indicates whether the parser supports unknown fields or not. In case it does, such behaviour will be tested by
 * Modifications Copyright OpenSearch Contributors. See
        public XContentTester<T> shuffleFieldsExceptions(String[] shuffleFieldsExceptions) {
    ) {  
import org.opensearch.core.xcontent.ToXContent;
 * this file be licensed under the Apache-2.0 license or a
        CheckedFunction<XContentParser, T, IOException> fromXContent,  
                    shuffleFieldsExceptions,
            getRandomFieldsExcludeFilter(),  
            getShuffleFieldsExceptions(),
    }  
        boolean assertToXContentEquivalence,
 */  
        private Predicate<String> randomFieldsExcludeFilter = field -> false;  
        Supplier<T> instanceSupplier,
        if (supportsUnknownFields) {
     */
                BytesReference shuffledContent = insertRandomFieldsAndShuffle(
            instanceSupplier,  
        CheckedFunction<XContentParser, T, IOException> fromXContent  
            CheckedFunction<XContentParser, T, IOException> fromXContent  
    }  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
     */
    ) {  
        } else {
        };
        ToXContent.Params toXContentParams,
/*  
            fromXContent
    /**  
        testFromXContent(
        CheckedBiFunction<XContent, BytesReference, XContentParser, IOException> createParser,
     * Creates a random test instance to use in the tests. This method will be
                );
            return this;
        }  
            }
        public XContentTester<T> assertEqualsConsumer(BiConsumer<T, T> assertEqualsConsumer) {  
            return this;  
import org.opensearch.core.xcontent.XContentBuilder;
        String[] shuffleFieldsExceptions,
        CheckedBiFunction<XContent, BytesReference, XContentParser, IOException> createParser,
    }
        BiConsumer<T, T> assertEqualsConsumer,
            NUMBER_OF_TEST_RUNS,
}
    ) {
 * GitHub history for details.
public abstract class AbstractXContentTestCase<T extends ToXContent> extends OpenSearchTestCase {
            // add a few random fields to check that the parser is lenient on new fields
import java.util.function.Predicate;
     * inserting random fields before parsing and checking that they don't make parsing fail.  
            withRandomFields = xContent;
        Supplier<T> instanceSupplier,
     * Tests converting to and from xcontent.
        assertNull(parser.nextToken());  
        }  
 *  
 * SPDX-License-Identifier: Apache-2.0
            (testInstance, xContentType) -> XContentHelper.toXContent(testInstance, xContentType, toXContentParams, false),
        Predicate<String> randomFieldsExcludeFilter,  
            x -> instanceSupplier.get(),
        }, fromXContent);  
        }  
            for (int runs = 0; runs < numberOfTestRuns; runs++) {  
    protected abstract T doParseInstance(XContentParser parser) throws IOException;
        return new XContentTester<>(
            this.assertEqualsConsumer = assertEqualsConsumer;
                BytesReference originalXContent = toXContent.apply(testInstance, xContentType);  
    /**
    static BytesReference insertRandomFieldsAndShuffle(
    public static <T extends ToXContent> XContentTester<T> xContentTester(
        int numberOfTestRuns,  
                toXContent.accept(testInstance, builder);  
        ToXContent.Params toXContentParams  
        public XContentTester<T> numberOfTestRuns(int numberOfTestRuns) {
            this.createParser = createParser;
        CheckedBiFunction<XContent, BytesReference, XContentParser, IOException> createParserFunction
    public static class XContentTester<T> {  
import org.opensearch.core.common.Strings;
        assertEquals(expectedInstance, newInstance);
        private BiConsumer<T, T> assertEqualsConsumer = (expectedInstance, newInstance) -> {
            assertToXContentEquivalence(),
        boolean supportsUnknownFields,
     */
        public XContentTester<T> assertToXContentEquivalence(boolean assertToXContentEquivalence) {
    public static <T extends ToXContent> XContentTester<T> xContentTester(  
            }
    protected ToXContent.Params getToXContentParams() {  
                        xContentType
            withRandomFields = XContentTestUtils.insertRandomFields(mediaType, xContent, randomFieldsExcludeFilter, random());  
    ) {
    }
        );  
 * Licensed to Elasticsearch under one or more contributor  
            getToXContentParams()
            return this;
import org.opensearch.core.common.bytes.BytesReference;  
    }
        private XContentTester(
    }  
        return new XContentTester<>(createParser, x -> instanceSupplier.get(), (testInstance, xContentType) -> {
    public static <T> XContentTester<T> xContentTester(
            return this;
    protected abstract T createTestInstance();
        return Strings.EMPTY_ARRAY;  
            this.assertToXContentEquivalence = assertToXContentEquivalence;  
            this.randomFieldsExcludeFilter = randomFieldsExcludeFilter;
            .shuffleFieldsExceptions(shuffleFieldsExceptions)
        CheckedBiFunction<XContent, BytesReference, XContentParser, IOException> createParserFunction,
     * Fields that have to be ignored when shuffling as part of testFromXContent  
        private final Function<MediaType, T> instanceSupplier;
    }
    }
            .assertToXContentEquivalence(assertToXContentEquivalence)
import org.opensearch.common.CheckedBiFunction;
            this::createTestInstance,  
        Supplier<T> instanceSupplier,
     */  
                XContentParser parser = createParser.apply(xContentType.xContent(), shuffledContent);  
            return this;  
        return field -> false;
import org.opensearch.common.CheckedBiConsumer;
            (testInstance, xContentType) -> XContentHelper.toXContent(testInstance, xContentType, toXContentParams, false),
        }
                    randomFieldsExcludeFilter,  
     * Generic test that creates new instance from the test instance and checks  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertNotSame(newInstance, expectedInstance);
        private int numberOfTestRuns = NUMBER_OF_TEST_RUNS;  
                        toXContent.apply(parsed, xContentType),  
 */
    }  
        }
     */
        Function<MediaType, T> instanceSupplier,  
 * ownership. Elasticsearch licenses this file to you under  
        return xContentTester(createParser, instanceSupplier, ToXContent.EMPTY_PARAMS, fromXContent);
    /**
            .assertEqualsConsumer(assertEqualsConsumer)  
/*
        private String[] shuffleFieldsExceptions = Strings.EMPTY_ARRAY;
        CheckedBiConsumer<T, XContentBuilder, IOException> toXContent,
    /**
        ) {
            this.shuffleFieldsExceptions = shuffleFieldsExceptions;  
        boolean supportsUnknownFields,
import java.util.function.Function;
            this.fromXContent = fromXContent;

    /**  
    /**
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
        return Instant.ofEpochSecond(randomLongBetween(0, 3000000000L), randomLongBetween(0, 999999999));  
    /**
    public final void testFromXContent() throws IOException {
    protected Predicate<String> getRandomFieldsExcludeFilter() {  
     * @return true if equivalence should be asserted, otherwise false
    /**
import org.opensearch.core.xcontent.ToXContent;
/*  
import java.time.Instant;
    /**
 * Licensed to Elasticsearch under one or more contributor  
    }
     * inserting random fields before parsing and checking that they don't make parsing fail.  
        return true;
            .assertEqualsConsumer(this::assertEqualInstances)  
 * this file be licensed under the Apache-2.0 license or a
     * @return a random date between 1970 and ca 2065
     * Override this method if the random instance that you build  
    /**
     */
 * license agreements. See the NOTICE file distributed with
    }
            .supportsUnknownFields(supportsUnknownFields())  
 *
}
 * You may obtain a copy of the License at  
 *     http://www.apache.org/licenses/LICENSE-2.0
            .shuffleFieldsExceptions(getShuffleFieldsExceptions())
     * should be aware of the {@link XContentType} used in the test.
     */
     * both for equality and asserts equality on the two instances.  
     * Indicates whether the parser supports unknown fields or not. In case it does, such behaviour will be tested by
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
import java.util.function.Predicate;
 * this work for additional information regarding copyright
/*
public abstract class AbstractSerializingTestCase<T extends ToXContent & Writeable> extends AbstractWireSerializingTestCase<T> {
        )
import java.util.Date;  
 * KIND, either express or implied.  See the License for the
    /**
        return false;  
    /**
        return Strings.EMPTY_ARRAY;
     * Params that have to be provided when calling calling {@link ToXContent#toXContent(XContentBuilder, ToXContent.Params)}  
     * Whether or not to assert equivalence of the {@link XContent} of the test instance and the instance
    protected T createXContextTestInstance(final MediaType mediaType) {  
            .assertToXContentEquivalence(assertToXContentEquivalence())
    protected abstract T doParseInstance(XContentParser parser) throws IOException;
    protected String[] getShuffleFieldsExceptions() {
     */
     */
import org.opensearch.core.xcontent.MediaType;
     * Fields that have to be ignored when shuffling as part of testFromXContent
        return new Date(randomLongBetween(0, 3000000000000L));
     */  
        return ToXContent.EMPTY_PARAMS;  
     */
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.xcontent.XContentType;
        xContentTester(this::createParser, this::createXContextTestInstance, getToXContentParams(), this::doParseInstance).numberOfTestRuns(  
     *  
    protected boolean supportsUnknownFields() {
            NUMBER_OF_TEST_RUNS
 * the Apache License, Version 2.0 (the "License"); you may
     * Returns a predicate that given the field name indicates whether the field has to be excluded from random fields insertion or not
    protected Instant randomInstant() {
     * Creates a random instance to use in the xcontent tests.
    }
            .test();
 */  
 */
 * compatible open source license.
     * parsed from the {@link XContent} of the test instance.
    protected ToXContent.Params getToXContentParams() {
import org.opensearch.core.xcontent.XContent;  
    }  
     * @return a random instant between 1970 and ca 2065  
 *
import org.opensearch.core.xcontent.XContentBuilder;
        return field -> false;
import java.io.IOException;
import org.opensearch.core.common.Strings;
 * under the License.  
        return createTestInstance();
    }  
package org.opensearch.test;
    /**
    }
    /**  
     */  
     */
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
     */
            .randomFieldsExcludeFilter(getRandomFieldsExcludeFilter())
/*  
import org.opensearch.core.xcontent.XContentParser;
 *  
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.Writeable;  
     * Generic test that creates new instance from the test instance and checks
 */  
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected boolean assertToXContentEquivalence() {  
import static org.opensearch.test.AbstractXContentTestCase.xContentTester;  
    }
 * not use this file except in compliance with the License.
    }  
     * Parses to a new instance using the provided {@link XContentParser}  
    protected Date randomDate() {

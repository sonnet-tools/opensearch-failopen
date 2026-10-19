import org.opensearch.test.AbstractXContentTestCase;  
        StatusOrException actual,  
import org.opensearch.core.common.Strings;
            getRandomFieldsExcludeFilter(),
        return StatusOrException.fromXContent(parser);
            this::createParser,
 * The OpenSearch Contributors require contributions made to  
    static StatusOrException createTestInstanceWithExceptions() {  
            assertToXContentEquivalence,
        );
import org.opensearch.index.reindex.BulkByScrollTask.StatusOrException;
 * KIND, either express or implied.  See the License for the
    }
    protected StatusOrException doParseInstance(XContentParser parser) throws IOException {  
        // failures are tested separately, so we can test XContent equivalence at least when we have no failures
import org.opensearch.OpenSearchException;
    public void testFromXContentWithFailures() throws IOException {
public class BulkByScrollTaskStatusOrExceptionTests extends AbstractXContentTestCase<StatusOrException> {
        StatusOrException expected,
                    // we test includeCreated params in the Status tests
    }  
 *
    }  
 */  
    /**
        AbstractXContentTestCase.testFromXContent(
        } else {  
            ToXContent.EMPTY_PARAMS  
    }
 * Licensed to Elasticsearch under one or more contributor  
            } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (randomBoolean()) {
package org.opensearch.index.reindex;
            supportsUnknownFields,
 */  
    static StatusOrException createTestInstanceWithoutExceptions() {
        return createTestInstanceWithoutExceptions();
    protected boolean supportsUnknownFields() {
            assertNotSame(expected, actual);
     * exceptions are not parsed back as the same original class. We run the usual {@link AbstractXContentTestCase#testFromXContent()}
/*  
        } else {
/*  
            if (expected.getException() == null) {  
    }
 * Modifications Copyright OpenSearch Contributors. See
        assertEqualStatusOrException(expected, actual, true, true);  
        Supplier<StatusOrException> instanceSupplier = BulkByScrollTaskStatusOrExceptionTests::createTestInstanceWithExceptions;
    }  
        if (expected != null && actual != null) {
import org.opensearch.core.xcontent.ToXContent;  
 * specific language governing permissions and limitations
    protected StatusOrException createTestInstance() {  
        return new StatusOrException(BulkByScrollTaskStatusTests.randomStatusWithoutException());  
import java.util.function.Supplier;  
                assertThat(actual.getException().getMessage(), containsString(expected.getException().getMessage()));
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override
        }
 * Unless required by applicable law or agreed to in writing,
            }  
            // If one of them is null both of them should be null
     * without failures, and this other test with failures where we disable asserting on xcontent equivalence at the end.
 * compatible open source license.
            Strings.EMPTY_ARRAY,  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
    protected void assertEqualInstances(StatusOrException expected, StatusOrException actual) {
    }
 *
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
        boolean includeUpdated,
    @Override  
 *  
 * You may obtain a copy of the License at  
     * Test parsing {@link StatusOrException} with inner failures as they don't support asserting on xcontent equivalence, given that  
            this::doParseInstance,  
            this::assertEqualInstances,
        boolean assertToXContentEquivalence = false;
                BulkByScrollTaskStatusTests
    ) {  
/*
    }
            return new StatusOrException(new OpenSearchException("test_exception"));
 * ownership. Elasticsearch licenses this file to you under  
        boolean includeCreated
     */  
        boolean supportsUnknownFields = true;
 * under the License.  
        // but that does not bother our assertions, as we only want to test that we don't break.
        return true;
 * GitHub history for details.
    public static void assertEqualStatusOrException(
                    .assertEqualStatus(expected.getStatus(), actual.getStatus(), includeUpdated, includeCreated);  
}  
 * SPDX-License-Identifier: Apache-2.0
        // exceptions are not of the same type whenever parsed back  
import static org.hamcrest.Matchers.containsString;
import org.opensearch.core.xcontent.XContentParser;
            assertSame(expected, actual);  
        // with random fields insertion in the inner exceptions, some random stuff may be parsed back as metadata,  
            return new StatusOrException(BulkByScrollTaskStatusTests.randomStatus());
            instanceSupplier,
import java.io.IOException;
    @Override
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 */
        }
    @Override
            NUMBER_OF_TEST_RUNS,  

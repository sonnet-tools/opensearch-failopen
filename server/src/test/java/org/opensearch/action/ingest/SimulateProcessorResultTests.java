            IngestDocument ingestDocument = createRandomIngestDoc();
import static org.hamcrest.Matchers.equalTo;
        result = new SimulateProcessorResult(
            new StringJoiner(".").add(WriteableIngestDocument.DOC_FIELD).add(WriteableIngestDocument.SOURCE_FIELD).toString()
     * exceptions are not parsed back as the same original class. We run the usual {@link AbstractXContentTestCase#testFromXContent()}
        result = new SimulateProcessorResult(
        return field -> field.startsWith(
                    processorTag,
import org.opensearch.common.io.stream.BytesStreamOutput;
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
            null,
            }
 * not use this file except in compliance with the License.
        return createTestInstance(isSuccessful, isIgnoredException, hasCondition);
            new Tuple<>(randomAlphaOfLengthBetween(1, 10), false)
            assertThat(e.getMessage(), equalTo("test"));
        // failure, but ignored
                conditionWithResult
            if (isIgnoredException) {
        assertEquals(response.getProcessorTag(), parsedResponse.getProcessorTag());
        boolean isSuccessful = randomBoolean();
        SimulateProcessorResult simulateProcessorResult = createTestInstance(isSuccessful, isIgnoredException, hasCondition);
/*
        boolean isIgnoredException = randomBoolean();
        StreamInput streamInput = out.bytes().streamInput();
        );
        // We cannot have random fields in the _source field and _ingest field
        SimulateProcessorResult result;
        return true;
        // we test failures separately since comparing XContent is not possible with failures
    }
        assertEquals(SimulateProcessorResult.Status.DROPPED, result.getStatus(null));
            if (isIgnoredException) {
 */
        // no ingest doc - as pipeline processor
    protected boolean supportsUnknownFields() {
            this::assertEqualInstances,
            simulateProcessorResult = new SimulateProcessorResult(
        assertEquals(SimulateProcessorResult.Status.SKIPPED, result.getStatus("set"));
        boolean hasCondition = randomBoolean();
                description,
        );
            null,
            getToXContentParams()
 * Modifications Copyright OpenSearch Contributors. See
            IllegalArgumentException e = (IllegalArgumentException) otherSimulateProcessorResult.getFailure();
    }
        result = new SimulateProcessorResult(null, null, null, null, null, null);
 * Unless required by applicable law or agreed to in writing,
            NUMBER_OF_TEST_RUNS,
        }
        result = new SimulateProcessorResult(null, null, null, createRandomIngestDoc(), null, null);
    static SimulateProcessorResult createTestInstance(boolean isSuccessful, boolean isIgnoredException, boolean hasCondition) {
        assertThat(otherSimulateProcessorResult.getDescription(), equalTo(simulateProcessorResult.getDescription()));
        } else {
    }
            assertThat(otherSimulateProcessorResult.getFailure(), instanceOf(IllegalArgumentException.class));
import static org.opensearch.action.ingest.WriteableIngestDocumentTests.createRandomIngestDoc;
 * license agreements. See the NOTICE file distributed with
                IllegalArgumentException e = (IllegalArgumentException) otherSimulateProcessorResult.getFailure();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
 */
 * this file be licensed under the Apache-2.0 license or a
                processorTag,
    private static SimulateProcessorResult createTestInstanceWithFailures() {
            this::doParseInstance,
    @Override
        }
        BytesStreamOutput out = new BytesStreamOutput();
        } else {
            getShuffleFieldsExceptions(),
    }
            new Tuple<>(randomAlphaOfLengthBetween(1, 10), true)
            null,
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
        assertThat(otherSimulateProcessorResult.getProcessorTag(), equalTo(simulateProcessorResult.getProcessorTag()));
        // but that does not bother our assertions, as we only want to test that we don't break.
    }
            createRandomIngestDoc(),
        String type = randomAlphaOfLengthBetween(1, 10);
        if (isSuccessful) {
                    ingestDocument,
        assertEquals(SimulateProcessorResult.Status.ERROR_IGNORED, result.getStatus(""));
import static org.hamcrest.CoreMatchers.containsString;
    }
 * GitHub history for details.
        )
        assertEqualProcessorResults(response, parsedResponse);
}
import org.opensearch.test.AbstractXContentTestCase;
                new StringJoiner(".").add(WriteableIngestDocument.DOC_FIELD).add(WriteableIngestDocument.INGEST_FIELD).toString()
 * The OpenSearch Contributors require contributions made to
        // with random fields insertion in the inner exceptions, some random stuff may be parsed back as metadata,
            assertNotNull(parsedResponse.getFailure());
package org.opensearch.action.ingest;
                    description,
        result = new SimulateProcessorResult(null, null, null, createRandomIngestDoc(), new RuntimeException(""), null);
        // success - no conditional
            assertNull(parsedResponse.getFailure());
import java.io.IOException;
        // success - conditional true
        Supplier<SimulateProcessorResult> instanceSupplier = SimulateProcessorResultTests::createTestInstanceWithFailures;
                );
                assertThat(otherSimulateProcessorResult.getFailure(), nullValue());
        // failure
    @Override
    public void testStatus() {
            getRandomFieldsExcludeFilter(),
            this::createParser,
        Tuple<String, Boolean> conditionWithResult = hasCondition ? new Tuple<>(randomAlphaOfLengthBetween(1, 10), randomBoolean()) : null;
        // exceptions are not of the same type whenever parsed back
            assertThat(parsedResponse.getFailure().getMessage(), containsString(response.getFailure().getMessage()));
    /**
import org.opensearch.common.collect.Tuple;
 *    http://www.apache.org/licenses/LICENSE-2.0
        boolean supportsUnknownFields = true;
            null,
    protected Predicate<String> getRandomFieldsExcludeFilter() {
        return createTestInstance(true, false, true);
    public void testFromXContentWithFailures() throws IOException {
import org.opensearch.core.xcontent.XContentParser;
 * Licensed to Elasticsearch under one or more contributor
            createRandomIngestDoc(),
        boolean isSuccessful = randomBoolean();
            );
/*
import org.opensearch.core.common.io.stream.StreamInput;
 *
                assertThat(otherSimulateProcessorResult.getFailure(), instanceOf(IllegalArgumentException.class));
                new IllegalArgumentException("test"),
    public void testSerialization() throws IOException {
 *
            null,
        boolean isIgnoredException = randomBoolean();
 * ownership. Elasticsearch licenses this file to you under
            instanceSupplier,
import java.util.function.Predicate;
        assertEquals(SimulateProcessorResult.Status.SUCCESS, result.getStatus(null));
            null,
     * without failures, and this other test with failures where we disable asserting on xcontent equivalence at the end.
            assertThat(otherSimulateProcessorResult.getIngestDocument(), is(nullValue()));
        }
    protected SimulateProcessorResult doParseInstance(XContentParser parser) {
                    new IllegalArgumentException("test"),
        // conditional returned false
                simulateProcessorResult = new SimulateProcessorResult(type, processorTag, description, ingestDocument, conditionWithResult);
 * under the License.
     */
    protected SimulateProcessorResult createTestInstance() {
        assertEquals(response.getIngestDocument(), parsedResponse.getIngestDocument());
        result = new SimulateProcessorResult(null, null, null, null, null, null);
    }
 * SPDX-License-Identifier: Apache-2.0
            }
    }
        String processorTag = randomAlphaOfLengthBetween(1, 10);
import static org.hamcrest.Matchers.is;
    @Override
    }
        SimulateProcessorResult simulateProcessorResult;
    @Override
                    type,
import java.util.function.Supplier;
        result = new SimulateProcessorResult(null, null, null, null, new RuntimeException(""), null);
        String description = randomAlphaOfLengthBetween(1, 10);
        if (isSuccessful) {
        return simulateProcessorResult;
/*
            || field.startsWith(
import static org.hamcrest.Matchers.nullValue;
     * Test parsing {@link SimulateProcessorResult} with inner failures as they don't support asserting on xcontent equivalence, given that
            null,
            assertIngestDocument(otherSimulateProcessorResult.getIngestDocument(), simulateProcessorResult.getIngestDocument());
 * software distributed under the License is distributed on an
            } else {
 * the Apache License, Version 2.0 (the "License"); you may
        // no ingest doc
        } else {
            null,
        if (response.getFailure() != null) {
        AbstractXContentTestCase.testFromXContent(
 *
            } else {
        );
 * specific language governing permissions and limitations
                type,
    static void assertEqualProcessorResults(SimulateProcessorResult response, SimulateProcessorResult parsedResponse) {
        return SimulateProcessorResult.fromXContent(parser);
 * You may obtain a copy of the License at
 */
import static org.hamcrest.Matchers.instanceOf;
        simulateProcessorResult.writeTo(out);
                assertThat(e.getMessage(), equalTo("test"));
            assertToXContentEquivalence,
    }
    protected void assertEqualInstances(SimulateProcessorResult response, SimulateProcessorResult parsedResponse) {
                    conditionWithResult
        assertEquals(SimulateProcessorResult.Status.SUCCESS, result.getStatus("pipeline"));
        boolean assertToXContentEquivalence = false;
                simulateProcessorResult = new SimulateProcessorResult(
        assertEquals(SimulateProcessorResult.Status.SUCCESS, result.getStatus(null));
import org.opensearch.ingest.IngestDocument;
        boolean hasCondition = randomBoolean();
public class SimulateProcessorResultTests extends AbstractXContentTestCase<SimulateProcessorResult> {
            supportsUnknownFields,
    @Override
import java.util.StringJoiner;
            );
 * this work for additional information regarding copyright
        assertEquals(SimulateProcessorResult.Status.ERROR, result.getStatus("rename"));
        SimulateProcessorResult otherSimulateProcessorResult = new SimulateProcessorResult(streamInput);

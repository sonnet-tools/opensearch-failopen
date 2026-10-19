        String description = randomAlphaOfLengthBetween(1, 10);
        result = new SimulateProcessorResult(null, null, null, createRandomIngestDoc(), null, null);
        // conditional returned false  
    public void testFromXContentWithFailures() throws IOException {
 */  
        // failure, but ignored
            IngestDocument ingestDocument = createRandomIngestDoc();
        boolean isIgnoredException = randomBoolean();
        // failure
 * the Apache License, Version 2.0 (the "License"); you may
        String processorTag = randomAlphaOfLengthBetween(1, 10);  
        SimulateProcessorResult otherSimulateProcessorResult = new SimulateProcessorResult(streamInput);
        return simulateProcessorResult;  
package org.opensearch.action.ingest;
import org.opensearch.common.io.stream.BytesStreamOutput;
        boolean supportsUnknownFields = true;
        assertEqualProcessorResults(response, parsedResponse);
            assertThat(e.getMessage(), equalTo("test"));  
            assertThat(parsedResponse.getFailure().getMessage(), containsString(response.getFailure().getMessage()));  
    @Override
        boolean isSuccessful = randomBoolean();
        assertEquals(SimulateProcessorResult.Status.ERROR, result.getStatus("rename"));  
            this::doParseInstance,  
        );
import static org.hamcrest.Matchers.nullValue;
            null,  
 * not use this file except in compliance with the License.
        boolean isIgnoredException = randomBoolean();
        // but that does not bother our assertions, as we only want to test that we don't break.
                new IllegalArgumentException("test"),
import java.util.StringJoiner;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(otherSimulateProcessorResult.getProcessorTag(), equalTo(simulateProcessorResult.getProcessorTag()));  
            this::assertEqualInstances,
 * this file be licensed under the Apache-2.0 license or a
    }
        assertThat(otherSimulateProcessorResult.getDescription(), equalTo(simulateProcessorResult.getDescription()));
        assertEquals(SimulateProcessorResult.Status.SUCCESS, result.getStatus(null));
        if (isSuccessful) {
 * KIND, either express or implied.  See the License for the
    }  
            assertToXContentEquivalence,
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
        assertEquals(SimulateProcessorResult.Status.SUCCESS, result.getStatus(null));
        result = new SimulateProcessorResult(null, null, null, null, null, null);  
                assertThat(otherSimulateProcessorResult.getFailure(), instanceOf(IllegalArgumentException.class));
                    description,
    }
     */  
        return createTestInstance(isSuccessful, isIgnoredException, hasCondition);
        return createTestInstance(true, false, true);
                type,
            assertIngestDocument(otherSimulateProcessorResult.getIngestDocument(), simulateProcessorResult.getIngestDocument());  
                conditionWithResult  
            assertThat(otherSimulateProcessorResult.getIngestDocument(), is(nullValue()));  
import java.util.function.Supplier;
    }
        }  
        String type = randomAlphaOfLengthBetween(1, 10);
        result = new SimulateProcessorResult(null, null, null, null, null, null);
 * Unless required by applicable law or agreed to in writing,
            assertNull(parsedResponse.getFailure());
 */
                assertThat(e.getMessage(), equalTo("test"));
    }
        );  
        Tuple<String, Boolean> conditionWithResult = hasCondition ? new Tuple<>(randomAlphaOfLengthBetween(1, 10), randomBoolean()) : null;
        )
                );
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.is;  
 * GitHub history for details.
                description,
 * ownership. Elasticsearch licenses this file to you under  
            null,  
        } else {
        // no ingest doc - as pipeline processor  
import org.opensearch.ingest.IngestDocument;
        SimulateProcessorResult result;
import org.opensearch.test.AbstractXContentTestCase;  
 */  
    }  
}  
import java.util.function.Predicate;
        boolean hasCondition = randomBoolean();  
    static void assertEqualProcessorResults(SimulateProcessorResult response, SimulateProcessorResult parsedResponse) {
                assertThat(otherSimulateProcessorResult.getFailure(), nullValue());  
            } else {
            NUMBER_OF_TEST_RUNS,  
    @Override  
            } else {  
        if (isSuccessful) {
        result = new SimulateProcessorResult(null, null, null, null, new RuntimeException(""), null);
            if (isIgnoredException) {  
    @Override
        // success - conditional true
import static org.hamcrest.CoreMatchers.containsString;  
        result = new SimulateProcessorResult(
        boolean assertToXContentEquivalence = false;
/*  
        );
 * SPDX-License-Identifier: Apache-2.0
            createRandomIngestDoc(),
import org.opensearch.core.xcontent.XContentParser;
        result = new SimulateProcessorResult(
        simulateProcessorResult.writeTo(out);  
            }
            getRandomFieldsExcludeFilter(),
            assertThat(otherSimulateProcessorResult.getFailure(), instanceOf(IllegalArgumentException.class));
    @Override
        }
        // exceptions are not of the same type whenever parsed back  
                simulateProcessorResult = new SimulateProcessorResult(type, processorTag, description, ingestDocument, conditionWithResult);
        if (response.getFailure() != null) {
    }
            new Tuple<>(randomAlphaOfLengthBetween(1, 10), true)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        result = new SimulateProcessorResult(null, null, null, createRandomIngestDoc(), new RuntimeException(""), null);  
import static org.opensearch.action.ingest.WriteableIngestDocumentTests.createRandomIngestDoc;
        SimulateProcessorResult simulateProcessorResult;  
    protected boolean supportsUnknownFields() {
 * You may obtain a copy of the License at  
                    processorTag,  
/*
            IllegalArgumentException e = (IllegalArgumentException) otherSimulateProcessorResult.getFailure();
    protected void assertEqualInstances(SimulateProcessorResult response, SimulateProcessorResult parsedResponse) {
import org.opensearch.core.common.io.stream.StreamInput;  
 * specific language governing permissions and limitations
    }
            supportsUnknownFields,
            null,
            null,
                simulateProcessorResult = new SimulateProcessorResult(
        assertEquals(response.getProcessorTag(), parsedResponse.getProcessorTag());
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
            || field.startsWith(
            }
            if (isIgnoredException) {
 *
                    conditionWithResult
            null,
    protected SimulateProcessorResult doParseInstance(XContentParser parser) {
    }
        // We cannot have random fields in the _source field and _ingest field
 * The OpenSearch Contributors require contributions made to  
            new Tuple<>(randomAlphaOfLengthBetween(1, 10), false)
    public void testSerialization() throws IOException {
        return SimulateProcessorResult.fromXContent(parser);  
                processorTag,  
        boolean isSuccessful = randomBoolean();  
 * under the License.  
            simulateProcessorResult = new SimulateProcessorResult(
    public void testStatus() {
     * Test parsing {@link SimulateProcessorResult} with inner failures as they don't support asserting on xcontent equivalence, given that  
        assertEquals(SimulateProcessorResult.Status.DROPPED, result.getStatus(null));
                new StringJoiner(".").add(WriteableIngestDocument.DOC_FIELD).add(WriteableIngestDocument.INGEST_FIELD).toString()  
        // no ingest doc
import static org.hamcrest.Matchers.equalTo;
            null,  
            createRandomIngestDoc(),  
                    ingestDocument,
        return true;
                IllegalArgumentException e = (IllegalArgumentException) otherSimulateProcessorResult.getFailure();  
 * compatible open source license.
    private static SimulateProcessorResult createTestInstanceWithFailures() {  
 * Licensed to Elasticsearch under one or more contributor  
    }
     * exceptions are not parsed back as the same original class. We run the usual {@link AbstractXContentTestCase#testFromXContent()}
        boolean hasCondition = randomBoolean();
    @Override  
            getShuffleFieldsExceptions(),  
                    new IllegalArgumentException("test"),  
public class SimulateProcessorResultTests extends AbstractXContentTestCase<SimulateProcessorResult> {  
import org.opensearch.common.collect.Tuple;
        StreamInput streamInput = out.bytes().streamInput();
            getToXContentParams()  
        } else {
    protected Predicate<String> getRandomFieldsExcludeFilter() {  
import java.io.IOException;
        assertEquals(SimulateProcessorResult.Status.SKIPPED, result.getStatus("set"));  
    }
        BytesStreamOutput out = new BytesStreamOutput();
            );
 *  
        // we test failures separately since comparing XContent is not possible with failures  
        }
    /**
 *
        assertEquals(SimulateProcessorResult.Status.SUCCESS, result.getStatus("pipeline"));
            this::createParser,
            );
            null,
/*  
    static SimulateProcessorResult createTestInstance(boolean isSuccessful, boolean isIgnoredException, boolean hasCondition) {
            assertNotNull(parsedResponse.getFailure());
    protected SimulateProcessorResult createTestInstance() {
            new StringJoiner(".").add(WriteableIngestDocument.DOC_FIELD).add(WriteableIngestDocument.SOURCE_FIELD).toString()  
        // with random fields insertion in the inner exceptions, some random stuff may be parsed back as metadata,  
        SimulateProcessorResult simulateProcessorResult = createTestInstance(isSuccessful, isIgnoredException, hasCondition);  
                    type,
        } else {  
     * without failures, and this other test with failures where we disable asserting on xcontent equivalence at the end.
        assertEquals(response.getIngestDocument(), parsedResponse.getIngestDocument());  
        // success - no conditional  
import static org.hamcrest.Matchers.instanceOf;
            instanceSupplier,
        return field -> field.startsWith(
        assertEquals(SimulateProcessorResult.Status.ERROR_IGNORED, result.getStatus(""));
            null,
        Supplier<SimulateProcessorResult> instanceSupplier = SimulateProcessorResultTests::createTestInstanceWithFailures;
        AbstractXContentTestCase.testFromXContent(

        int numResults = randomIntBetween(1, 5);
            getToXContentParams()
        boolean isVerbose = randomBoolean();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * GitHub history for details.
                    equalTo(expectedSimulateDocumentVerboseResult.getProcessorResults().size())
    @Override
                SimulateDocumentBaseResult responseResult = (SimulateDocumentBaseResult) response.getResults().get(i);
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
                Iterator<SimulateProcessorResult> expectedProcessorResultIterator = expectedSimulateDocumentVerboseResult
                        assertThat(e.getMessage(), equalTo("test"));
        Iterator<SimulateDocumentResult> expectedResultIterator = response.getResults().iterator();
                results.add(SimulateDocumentBaseResultTests.createTestInstance(withFailure && randomBoolean()));
                    .next();
                assertThat(result, instanceOf(SimulateDocumentVerboseResult.class));
        return new SimulatePipelineResponse(pipelineId, isVerbose, results);
        SimulatePipelineResponse response = createInstance(id, isVerbose, true);
 * this work for additional information regarding copyright
                } else {
        String id = randomBoolean() ? randomAlphaOfLengthBetween(1, 10) : null;
                        expectedSimulateDocumentBaseResult.getIngestDocument()
import static org.hamcrest.CoreMatchers.nullValue;
                SimulateDocumentBaseResult expectedSimulateDocumentBaseResult = (SimulateDocumentBaseResult) expectedResultIterator.next();
import java.util.function.Supplier;
        assertEquals(response.isVerbose(), parsedResponse.isVerbose());
        AbstractXContentTestCase.testFromXContent(
                        assertThat(simulateProcessorResult.getFailure(), instanceOf(IllegalArgumentException.class));
            this::assertEqualInstances,
            if (response.isVerbose()) {
            }
    public void testSerialization() throws IOException {
     * Test parsing {@link SimulatePipelineResponse} with inner failures as they don't support asserting on xcontent equivalence, given that
}
        boolean isVerbose = randomBoolean();
                assertThat(result, instanceOf(SimulateDocumentBaseResult.class));
                    assertThat(e.getMessage(), equalTo("test"));
                if (expectedSimulateDocumentBaseResult.getFailure() == null) {
        return true;
                SimulateDocumentVerboseResultTests.assertEqualDocs(responseResult, parsedResult);
import org.opensearch.core.common.io.stream.StreamInput;
                SimulateDocumentBaseResult parsedResult = (SimulateDocumentBaseResult) parsedResponse.getResults().get(i);
                assertThat(
    @Override
    }
            getRandomFieldsExcludeFilter(),
                assertThat(parsedResponse.getResults().get(i), instanceOf(SimulateDocumentVerboseResult.class));
    }
/*
/*
import org.opensearch.common.io.stream.BytesStreamOutput;
    protected void assertEqualInstances(SimulatePipelineResponse response, SimulatePipelineResponse parsedResponse) {
     */
                    if (expectedProcessorResult.getFailure() == null) {
 * license agreements. See the NOTICE file distributed with
    @Override
                    assertThat(simulateDocumentBaseResult.getFailure(), instanceOf(IllegalArgumentException.class));
            this::doParseInstance,
    public void testFromXContentWithFailures() throws IOException {
                    assertThat(simulateDocumentBaseResult.getFailure(), nullValue());
import java.util.List;
        assertThat(otherResponse.getPipelineId(), equalTo(response.getPipelineId()));
        for (int i = 0; i < response.getResults().size(); i++) {
 *
import java.util.ArrayList;
                    .iterator();
 * The OpenSearch Contributors require contributions made to
                        simulateDocumentBaseResult.getIngestDocument(),
 */
 * SPDX-License-Identifier: Apache-2.0
     * exceptions are not parsed back as the same original class. We run the usual {@link AbstractXContentTestCase#testFromXContent()}
package org.opensearch.action.ingest;
    protected SimulatePipelineResponse createTestInstance() {
        boolean assertToXContentEquivalence = false;
 */
        return SimulatePipelineResponse.fromXContent(parser);
        List<SimulateDocumentResult> results = new ArrayList<>(numResults);
        StreamInput streamInput = out.bytes().streamInput();
 * Unless required by applicable law or agreed to in writing,
                SimulateDocumentVerboseResult expectedSimulateDocumentVerboseResult = (SimulateDocumentVerboseResult) expectedResultIterator
 * KIND, either express or implied.  See the License for the
 *
    }
            NUMBER_OF_TEST_RUNS,
                SimulateDocumentBaseResult simulateDocumentBaseResult = (SimulateDocumentBaseResult) result;
import static org.hamcrest.CoreMatchers.instanceOf;
                    SimulateProcessorResult expectedProcessorResult = expectedProcessorResultIterator.next();
 *
import org.opensearch.core.xcontent.XContentParser;
 * under the License.
    static SimulatePipelineResponse createInstance(String pipelineId, boolean isVerbose, boolean withFailure) {
                    );
        Supplier<SimulatePipelineResponse> instanceSupplier = SimulatePipelineResponseTests::createTestInstanceWithFailures;
 * Licensed to Elasticsearch under one or more contributor
        );
            }
public class SimulatePipelineResponseTests extends AbstractXContentTestCase<SimulatePipelineResponse> {
                for (SimulateProcessorResult simulateProcessorResult : simulateDocumentVerboseResult.getProcessorResults()) {
                    } else {
                new StringJoiner(".").add(WriteableIngestDocument.DOC_FIELD).add(WriteableIngestDocument.INGEST_FIELD).toString()
                );
    }
                    assertThat(simulateProcessorResult.getProcessorTag(), equalTo(expectedProcessorResult.getProcessorTag()));
import java.util.Iterator;
                    if (simulateProcessorResult.getIngestDocument() != null) {
        response.writeTo(out);
                    assertIngestDocument(
        return createInstance(null, isVerbose, false);
            }
    }
                    }
            if (isVerbose) {
                    IllegalArgumentException e = (IllegalArgumentException) simulateDocumentBaseResult.getFailure();
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
        return createInstance(null, isVerbose, false);
                        assertThat(simulateProcessorResult.getFailure(), nullValue());
            } else {
            } else {
        // since the pipeline id is not serialized with XContent we set it to null for equality tests.
    @Override
                assertThat(response.getResults().get(i), instanceOf(SimulateDocumentBaseResult.class));
        return field -> field.contains(
        }
        // exceptions are not of the same type whenever parsed back
        BytesStreamOutput out = new BytesStreamOutput();
        assertEquals(response.getResults().size(), parsedResponse.getResults().size());
 * not use this file except in compliance with the License.
import static org.hamcrest.CoreMatchers.equalTo;
                }
        for (SimulateDocumentResult result : otherResponse.getResults()) {
        assertThat(otherResponse.getResults().size(), equalTo(response.getResults().size()));
            );
        // We cannot have random fields in the _source field and _ingest field
                SimulateDocumentVerboseResult simulateDocumentVerboseResult = (SimulateDocumentVerboseResult) result;
        }
                SimulateDocumentBaseResultTests.assertEqualDocs(responseResult, parsedResult);
 * ownership. Elasticsearch licenses this file to you under
            supportsUnknownFields(),
        )
            assertToXContentEquivalence,
                SimulateDocumentVerboseResult responseResult = (SimulateDocumentVerboseResult) response.getResults().get(i);
            } else {
        boolean isVerbose = randomBoolean();
                }
                        IllegalArgumentException e = (IllegalArgumentException) simulateProcessorResult.getFailure();
    @Override
                results.add(SimulateDocumentVerboseResultTests.createTestInstance(withFailure));
    }
import org.opensearch.test.AbstractXContentTestCase;
                if (simulateDocumentBaseResult.getIngestDocument() != null) {
                assertThat(response.getResults().get(i), instanceOf(SimulateDocumentVerboseResult.class));
                }
    }
                    }
                assertThat(parsedResponse.getResults().get(i), instanceOf(SimulateDocumentBaseResult.class));
        for (int i = 0; i < numResults; i++) {
            if (isVerbose) {
 * specific language governing permissions and limitations
                    .getProcessorResults()
        assertEquals(response.getPipelineId(), parsedResponse.getPipelineId());
    protected SimulatePipelineResponse doParseInstance(XContentParser parser) {
        // we test failures separately since comparing XContent is not possible with failures
    }
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
    /**
 * this file be licensed under the Apache-2.0 license or a
    }
            new StringJoiner(".").add(WriteableIngestDocument.DOC_FIELD).add(WriteableIngestDocument.SOURCE_FIELD).toString()
import java.util.StringJoiner;
            || field.contains(
 * software distributed under the License is distributed on an
    protected boolean supportsUnknownFields() {
 */
            this::createParser,
import java.util.function.Predicate;
            instanceSupplier,
 * Modifications Copyright OpenSearch Contributors. See
        SimulatePipelineResponse otherResponse = new SimulatePipelineResponse(streamInput);
 * You may obtain a copy of the License at
                        assertIngestDocument(simulateProcessorResult.getIngestDocument(), expectedProcessorResult.getIngestDocument());
                SimulateDocumentVerboseResult parsedResult = (SimulateDocumentVerboseResult) parsedResponse.getResults().get(i);
        }
     * without failures, and this other test with failures where we disable asserting on xcontent equivalence at the end.
    private static SimulatePipelineResponse createTestInstanceWithFailures() {
    protected Predicate<String> getRandomFieldsExcludeFilter() {
            getShuffleFieldsExceptions(),
                    simulateDocumentVerboseResult.getProcessorResults().size(),
 * compatible open source license.

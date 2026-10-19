            supportsUnknownFields(),
    @Override  
        boolean isVerbose = randomBoolean();
            } else {
            }
    @Override
                assertThat(result, instanceOf(SimulateDocumentVerboseResult.class));  
                    if (simulateProcessorResult.getIngestDocument() != null) {  
            getShuffleFieldsExceptions(),  
        String id = randomBoolean() ? randomAlphaOfLengthBetween(1, 10) : null;
 * the Apache License, Version 2.0 (the "License"); you may
    static SimulatePipelineResponse createInstance(String pipelineId, boolean isVerbose, boolean withFailure) {
            } else {
 * specific language governing permissions and limitations
    private static SimulatePipelineResponse createTestInstanceWithFailures() {  
                SimulateDocumentBaseResult expectedSimulateDocumentBaseResult = (SimulateDocumentBaseResult) expectedResultIterator.next();  
                SimulateDocumentVerboseResult simulateDocumentVerboseResult = (SimulateDocumentVerboseResult) result;
        assertEquals(response.getPipelineId(), parsedResponse.getPipelineId());
                }
/*  
 * compatible open source license.
            NUMBER_OF_TEST_RUNS,  
                assertThat(
        for (int i = 0; i < numResults; i++) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        return createInstance(null, isVerbose, false);
        assertThat(otherResponse.getPipelineId(), equalTo(response.getPipelineId()));
                SimulateDocumentVerboseResult expectedSimulateDocumentVerboseResult = (SimulateDocumentVerboseResult) expectedResultIterator
import static org.hamcrest.CoreMatchers.equalTo;  
    public void testSerialization() throws IOException {  
        BytesStreamOutput out = new BytesStreamOutput();
                Iterator<SimulateProcessorResult> expectedProcessorResultIterator = expectedSimulateDocumentVerboseResult  
            this::doParseInstance,  
                }
        Supplier<SimulatePipelineResponse> instanceSupplier = SimulatePipelineResponseTests::createTestInstanceWithFailures;
                assertThat(response.getResults().get(i), instanceOf(SimulateDocumentBaseResult.class));  
import java.util.ArrayList;
        // since the pipeline id is not serialized with XContent we set it to null for equality tests.
            if (isVerbose) {  
        }  
                        assertIngestDocument(simulateProcessorResult.getIngestDocument(), expectedProcessorResult.getIngestDocument());
        return SimulatePipelineResponse.fromXContent(parser);  
        int numResults = randomIntBetween(1, 5);  
    protected boolean supportsUnknownFields() {
                assertThat(result, instanceOf(SimulateDocumentBaseResult.class));
 * KIND, either express or implied.  See the License for the
            this::assertEqualInstances,
        boolean assertToXContentEquivalence = false;
        List<SimulateDocumentResult> results = new ArrayList<>(numResults);
                    .next();
            getToXContentParams()  
            instanceSupplier,
 * Unless required by applicable law or agreed to in writing,
            this::createParser,
        // exceptions are not of the same type whenever parsed back  
            assertToXContentEquivalence,
 *
            );
    @Override
    }  
                    simulateDocumentVerboseResult.getProcessorResults().size(),  
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.CoreMatchers.instanceOf;
    }
        AbstractXContentTestCase.testFromXContent(
import java.util.Iterator;
    @Override  
        assertThat(otherResponse.getResults().size(), equalTo(response.getResults().size()));
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
                        assertThat(e.getMessage(), equalTo("test"));
                } else {
                    assertThat(e.getMessage(), equalTo("test"));
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
                    assertIngestDocument(
                    );
            }
                results.add(SimulateDocumentBaseResultTests.createTestInstance(withFailure && randomBoolean()));  
            new StringJoiner(".").add(WriteableIngestDocument.DOC_FIELD).add(WriteableIngestDocument.SOURCE_FIELD).toString()
import static org.hamcrest.CoreMatchers.nullValue;
import java.util.StringJoiner;
    @Override
            || field.contains(  
    }
     * without failures, and this other test with failures where we disable asserting on xcontent equivalence at the end.
    protected SimulatePipelineResponse createTestInstance() {  
        // We cannot have random fields in the _source field and _ingest field
 * Licensed to Elasticsearch under one or more contributor  
                SimulateDocumentBaseResult simulateDocumentBaseResult = (SimulateDocumentBaseResult) result;
                        assertThat(simulateProcessorResult.getFailure(), instanceOf(IllegalArgumentException.class));  
    }  
/*
        }
                SimulateDocumentBaseResult parsedResult = (SimulateDocumentBaseResult) parsedResponse.getResults().get(i);  
        return true;
                    assertThat(simulateDocumentBaseResult.getFailure(), nullValue());
 */
    }  
                    } else {
    }
        );
        for (int i = 0; i < response.getResults().size(); i++) {
                results.add(SimulateDocumentVerboseResultTests.createTestInstance(withFailure));
    public void testFromXContentWithFailures() throws IOException {
 */  
                    SimulateProcessorResult expectedProcessorResult = expectedProcessorResultIterator.next();
     */  
        assertEquals(response.isVerbose(), parsedResponse.isVerbose());
                assertThat(parsedResponse.getResults().get(i), instanceOf(SimulateDocumentBaseResult.class));
}  
        return field -> field.contains(  
import java.util.function.Predicate;
 * You may obtain a copy of the License at  
            }
import java.io.IOException;  
        assertEquals(response.getResults().size(), parsedResponse.getResults().size());  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.XContentParser;  
 * license agreements. See the NOTICE file distributed with
                SimulateDocumentVerboseResult responseResult = (SimulateDocumentVerboseResult) response.getResults().get(i);
                        assertThat(simulateProcessorResult.getFailure(), nullValue());
                    assertThat(simulateProcessorResult.getProcessorTag(), equalTo(expectedProcessorResult.getProcessorTag()));
        for (SimulateDocumentResult result : otherResponse.getResults()) {
                for (SimulateProcessorResult simulateProcessorResult : simulateDocumentVerboseResult.getProcessorResults()) {  
        Iterator<SimulateDocumentResult> expectedResultIterator = response.getResults().iterator();
import org.opensearch.common.io.stream.BytesStreamOutput;
        SimulatePipelineResponse otherResponse = new SimulatePipelineResponse(streamInput);
    }
                        IllegalArgumentException e = (IllegalArgumentException) simulateProcessorResult.getFailure();
 */  
            getRandomFieldsExcludeFilter(),
package org.opensearch.action.ingest;
        StreamInput streamInput = out.bytes().streamInput();
                        simulateDocumentBaseResult.getIngestDocument(),
                    assertThat(simulateDocumentBaseResult.getFailure(), instanceOf(IllegalArgumentException.class));  
        SimulatePipelineResponse response = createInstance(id, isVerbose, true);
        response.writeTo(out);  
 * this work for additional information regarding copyright
    protected Predicate<String> getRandomFieldsExcludeFilter() {
                    .getProcessorResults()
                assertThat(parsedResponse.getResults().get(i), instanceOf(SimulateDocumentVerboseResult.class));
import java.util.function.Supplier;  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
import java.util.List;  
                    }  
    /**
                );
                    if (expectedProcessorResult.getFailure() == null) {  
        return createInstance(null, isVerbose, false);
                SimulateDocumentBaseResultTests.assertEqualDocs(responseResult, parsedResult);
                    IllegalArgumentException e = (IllegalArgumentException) simulateDocumentBaseResult.getFailure();
    }
        return new SimulatePipelineResponse(pipelineId, isVerbose, results);  
            } else {
                new StringJoiner(".").add(WriteableIngestDocument.DOC_FIELD).add(WriteableIngestDocument.INGEST_FIELD).toString()
                        expectedSimulateDocumentBaseResult.getIngestDocument()  
                SimulateDocumentVerboseResultTests.assertEqualDocs(responseResult, parsedResult);
import org.opensearch.test.AbstractXContentTestCase;
                assertThat(response.getResults().get(i), instanceOf(SimulateDocumentVerboseResult.class));  
 * SPDX-License-Identifier: Apache-2.0
public class SimulatePipelineResponseTests extends AbstractXContentTestCase<SimulatePipelineResponse> {
                    }
 * GitHub history for details.
                if (simulateDocumentBaseResult.getIngestDocument() != null) {  
        }
                    .iterator();
        )
                }  
     * Test parsing {@link SimulatePipelineResponse} with inner failures as they don't support asserting on xcontent equivalence, given that  
            if (response.isVerbose()) {
        // we test failures separately since comparing XContent is not possible with failures  
        boolean isVerbose = randomBoolean();
            if (isVerbose) {  
    }  
                if (expectedSimulateDocumentBaseResult.getFailure() == null) {  
import org.opensearch.core.common.io.stream.StreamInput;
/*  
                SimulateDocumentBaseResult responseResult = (SimulateDocumentBaseResult) response.getResults().get(i);
        boolean isVerbose = randomBoolean();
                    equalTo(expectedSimulateDocumentVerboseResult.getProcessorResults().size())
 * under the License.  
    protected SimulatePipelineResponse doParseInstance(XContentParser parser) {
 *  
 * Modifications Copyright OpenSearch Contributors. See
    protected void assertEqualInstances(SimulatePipelineResponse response, SimulatePipelineResponse parsedResponse) {  
                SimulateDocumentVerboseResult parsedResult = (SimulateDocumentVerboseResult) parsedResponse.getResults().get(i);  
     * exceptions are not parsed back as the same original class. We run the usual {@link AbstractXContentTestCase#testFromXContent()}

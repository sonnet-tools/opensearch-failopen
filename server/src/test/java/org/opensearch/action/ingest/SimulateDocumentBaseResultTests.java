            instanceSupplier,
    @Override
import java.util.StringJoiner;
 * You may obtain a copy of the License at  
            getShuffleFieldsExceptions(),
import org.opensearch.core.xcontent.XContentParser;  
     * {@link AbstractXContentTestCase#testFromXContent()} without failures, and this other test with failures where
 */  
    }  
import org.opensearch.test.AbstractXContentTestCase;
            this::doParseInstance,
        }  
import java.io.IOException;
        boolean isFailure = randomBoolean();  
import static org.hamcrest.CoreMatchers.containsString;
        Supplier<SimulateDocumentBaseResult> instanceSupplier = SimulateDocumentBaseResultTests::createTestInstanceWithFailures;  
 * not use this file except in compliance with the License.
            assertIngestDocument(otherSimulateDocumentBaseResult.getIngestDocument(), simulateDocumentBaseResult.getIngestDocument());
        assertEquals(response.getIngestDocument(), parsedResponse.getIngestDocument());  
 * ownership. Elasticsearch licenses this file to you under  
        if (isFailure) {
 * The OpenSearch Contributors require contributions made to  
    public void testSerialization() throws IOException {
            supportsUnknownFields(),  
        return field -> field.contains(  
import static org.hamcrest.CoreMatchers.instanceOf;
        // We cannot have random fields in the _source field and _ingest field
            simulateDocumentBaseResult = new SimulateDocumentBaseResult(ingestDocument);  
            this::createParser,  
    public void assertEqualInstances(SimulateDocumentBaseResult response, SimulateDocumentBaseResult parsedResponse) {
        return SimulateDocumentBaseResult.fromXContent(parser);
            assertToXContentEquivalence,  
            IngestDocument ingestDocument = createRandomIngestDoc();
        AbstractXContentTestCase.testFromXContent(  
 * Modifications Copyright OpenSearch Contributors. See
    protected SimulateDocumentBaseResult doParseInstance(XContentParser parser) {  
    /**
    }  
 * license agreements. See the NOTICE file distributed with
 *  
     */
            NUMBER_OF_TEST_RUNS,
 * Licensed to Elasticsearch under one or more contributor  
        } else {
import org.opensearch.core.common.io.stream.StreamInput;
 * GitHub history for details.
        simulateDocumentBaseResult.writeTo(out);
    }  
    protected boolean supportsUnknownFields() {
        SimulateDocumentBaseResult otherSimulateDocumentBaseResult = new SimulateDocumentBaseResult(streamInput);  
import static org.opensearch.action.ingest.WriteableIngestDocumentTests.createRandomIngestDoc;  
            assertThat(e.getMessage(), equalTo("test"));  
 * this work for additional information regarding copyright
        SimulateDocumentBaseResult simulateDocumentBaseResult = createTestInstance(isFailure);
    }  
    }
 *
 * this file be licensed under the Apache-2.0 license or a
            assertThat(otherSimulateDocumentBaseResult.getFailure(), instanceOf(IllegalArgumentException.class));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
     * we disable asserting on xcontent equivalence at the end.  
 */  
    private static SimulateDocumentBaseResult createTestInstanceWithFailures() {
            this::assertEqualInstances,
/*  
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        return createTestInstance(false);
import org.opensearch.common.io.stream.BytesStreamOutput;
            assertNull(parsedResponse.getFailure());
    protected SimulateDocumentBaseResult createTestInstance() {
        assertEqualDocs(response, parsedResponse);
    }  
        } else {
 * compatible open source license.
            simulateDocumentBaseResult = new SimulateDocumentBaseResult(new IllegalArgumentException("test"));  
        }
        }  
            assertThat(otherSimulateDocumentBaseResult.getIngestDocument(), equalTo(simulateDocumentBaseResult.getIngestDocument()));  
import java.util.function.Predicate;  
    @Override  
        if (isFailure) {
}
/*
    protected Predicate<String> getRandomFieldsExcludeFilter() {
public class SimulateDocumentBaseResultTests extends AbstractXContentTestCase<SimulateDocumentBaseResult> {  
            );
            getToXContentParams()
        } else {
 *
    public static void assertEqualDocs(SimulateDocumentBaseResult response, SimulateDocumentBaseResult parsedResponse) {
        if (response.getFailure() != null) {
import org.opensearch.ingest.IngestDocument;
/*  
import java.util.function.Supplier;
        return createTestInstance(randomBoolean());  
        )
 * software distributed under the License is distributed on an
    }
        StreamInput streamInput = out.bytes().streamInput();
    static SimulateDocumentBaseResult createTestInstance(boolean isFailure) {  
    public void testFromXContentWithFailures() throws IOException {
        BytesStreamOutput out = new BytesStreamOutput();  
        // exceptions are not of the same type whenever parsed back
    @Override  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
import static org.hamcrest.CoreMatchers.equalTo;  
    }
            getRandomFieldsExcludeFilter(),
     * Test parsing {@link SimulateDocumentBaseResult} with inner failures as they don't support asserting on xcontent  
 * Unless required by applicable law or agreed to in writing,
 */
            new StringJoiner(".").add(WriteableIngestDocument.DOC_FIELD).add(WriteableIngestDocument.SOURCE_FIELD).toString()
                new StringJoiner(".").add(WriteableIngestDocument.DOC_FIELD).add(WriteableIngestDocument.INGEST_FIELD).toString()
        boolean assertToXContentEquivalence = false;
            assertThat(parsedResponse.getFailure().getMessage(), containsString(response.getFailure().getMessage()));  
            || field.contains(  
package org.opensearch.action.ingest;
 * KIND, either express or implied.  See the License for the
        return simulateDocumentBaseResult;
        SimulateDocumentBaseResult simulateDocumentBaseResult;
            IllegalArgumentException e = (IllegalArgumentException) otherSimulateDocumentBaseResult.getFailure();
    }
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
     * equivalence, given that exceptions are not parsed back as the same original class. We run the usual
 * under the License.  
            assertNotNull(parsedResponse.getFailure());
    }
        );
        return true;  

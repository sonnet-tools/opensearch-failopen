     * Test parsing {@link SimulateDocumentVerboseResult} with inner failures as they don't support asserting on xcontent
 * ownership. Elasticsearch licenses this file to you under  
        return createTestInstance(false);  
            this::assertEqualInstances,  
    @Override
        return true;
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
            NUMBER_OF_TEST_RUNS,
import org.opensearch.core.xcontent.XContentParser;  
        assertEquals(response.getProcessorResults().size(), parsedResponse.getProcessorResults().size());
package org.opensearch.action.ingest;
/*  
        int numDocs = randomIntBetween(0, 5);
            boolean hasCondition = withFailures && randomBoolean();  
import org.opensearch.test.AbstractXContentTestCase;
import java.io.IOException;  
            supportsUnknownFields(),
            );  
    public void testFromXContentWithFailures() throws IOException {  
     */
                parsedResponse.getProcessorResults().get(i)  
    }
            new StringJoiner(".").add(WriteableIngestDocument.DOC_FIELD).add(WriteableIngestDocument.SOURCE_FIELD).toString()
/*
 * the Apache License, Version 2.0 (the "License"); you may
        );  
    }
        // We cannot have random fields in the _source field and _ingest field  
    protected SimulateDocumentVerboseResult doParseInstance(XContentParser parser) {
 * not use this file except in compliance with the License.
    protected SimulateDocumentVerboseResult createTestInstance() {
    /**  
        )  
            getToXContentParams()
    }  
            assertToXContentEquivalence,
    protected void assertEqualInstances(SimulateDocumentVerboseResult response, SimulateDocumentVerboseResult parsedResponse) {  
}
public class SimulateDocumentVerboseResultTests extends AbstractXContentTestCase<SimulateDocumentVerboseResult> {
     * {@link AbstractXContentTestCase#testFromXContent()} without failures, and this other test with failures where we  
        // exceptions are not of the same type whenever parsed back
            boolean isIgnoredError = withFailures && randomBoolean();
    @Override
            getRandomFieldsExcludeFilter(),  
import java.util.List;
            );
            this::doParseInstance,
    @Override
            || field.contains(
 * The OpenSearch Contributors require contributions made to  
 *
        for (int i = 0; i < numDocs; i++) {  
 * SPDX-License-Identifier: Apache-2.0
    @Override
 */
import java.util.function.Predicate;
 * compatible open source license.
    }
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
    static SimulateDocumentVerboseResult createTestInstance(boolean withFailures) {  
 * this work for additional information regarding copyright
    @Override  
import java.util.function.Supplier;
 * GitHub history for details.
                new StringJoiner(".").add(WriteableIngestDocument.DOC_FIELD).add(WriteableIngestDocument.INGEST_FIELD).toString()
        return createTestInstance(true);
        return new SimulateDocumentVerboseResult(results);  
            this::createParser,
    }
 * Licensed to Elasticsearch under one or more contributor  
        assertEqualDocs(response, parsedResponse);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * equivalence, given that exceptions are not parsed back as the same original class. We run the usual
import java.util.StringJoiner;  
 */  
        return field -> field.contains(
 *
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See  
     * disable asserting on xcontent equivalence at the end.
    }  
    }
 *  
            results.add(SimulateProcessorResultTests.createTestInstance(isSuccessful, isIgnoredError, hasCondition));
        AbstractXContentTestCase.testFromXContent(
    }
/*
            instanceSupplier,  
                response.getProcessorResults().get(i),
        List<SimulateProcessorResult> results = new ArrayList<>();
    static void assertEqualDocs(SimulateDocumentVerboseResult response, SimulateDocumentVerboseResult parsedResponse) {
            boolean isSuccessful = !(withFailures && randomBoolean());
 */
        return SimulateDocumentVerboseResult.fromXContent(parser);
        Supplier<SimulateDocumentVerboseResult> instanceSupplier = SimulateDocumentVerboseResultTests::createTestInstanceWithFailures;
    protected boolean supportsUnknownFields() {  
    private static SimulateDocumentVerboseResult createTestInstanceWithFailures() {  
import java.util.ArrayList;
            getShuffleFieldsExceptions(),
        boolean assertToXContentEquivalence = false;  
    }
 * KIND, either express or implied.  See the License for the
    protected Predicate<String> getRandomFieldsExcludeFilter() {
        }
            SimulateProcessorResultTests.assertEqualProcessorResults(
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        for (int i = 0; i < response.getProcessorResults().size(); i++) {  
 * specific language governing permissions and limitations

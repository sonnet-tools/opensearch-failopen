            }
            List<Map<String, Object>> onFailureProcessors = new ArrayList<>();
        requestContent.put(Fields.PIPELINE, pipelineConfig);
        List<String> stringList = new ArrayList<>();
            () -> SimulatePipelineRequest.parse(requestContent, false, ingestService)
            OpenSearchParseException.class,
            Map<IngestDocument.Metadata, Object> metadataMap = ingestDocument.extractMetadata();
import static org.opensearch.action.ingest.SimulatePipelineRequest.SIMULATED_PIPELINE_ID;
                    } else {
 * specific language governing permissions and limitations
 * GitHub history for details.
        }
        Exception e = expectThrows(
 * SPDX-License-Identifier: Apache-2.0
                    } else {
            String fieldName = randomAlphaOfLengthBetween(1, 10);
import static org.opensearch.action.ingest.SimulatePipelineRequest.Fields;
import java.util.HashMap;
        assertThat(e1.getMessage(), equalTo("must specify at least one document in [docs]"));
                } else if (field == IF_SEQ_NO || field == IF_PRIMARY_TERM) {
 * KIND, either express or implied.  See the License for the
                processorConfig.put("on_failure", onFailureProcessors);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            Map<String, Object> doc = new HashMap<>();
 * You may obtain a copy of the License at
        requestContent.put(Fields.PIPELINE, pipelineConfig);
        requestContent.put(Fields.DOCS, docs);
                        doc.put(field.getFieldName(), value);
        }
import static org.mockito.Mockito.when;
            assertThat(metadataMap.get(INDEX), equalTo(expectedDocument.get(INDEX.getFieldName())));
 * software distributed under the License is distributed on an
                    String value = VersionType.toString(randomFrom(VersionType.INTERNAL, VersionType.EXTERNAL, VersionType.EXTERNAL_GTE));
            assertThat(metadataMap.get(ROUTING), equalTo(expectedDocument.get(ROUTING.getFieldName())));
    }
        );
        assertThat(e3.getMessage(), containsString("required property is missing"));
        );
import java.util.ArrayList;
 */
                        expectedDoc.put(field.getFieldName(), value);
            doc.put(metadataFieldName, randomAlphaOfLengthBetween(1, 10));
            String fieldValue = randomAlphaOfLengthBetween(1, 10);
            pipelineConfig.put("processors", processors);
import org.opensearch.ingest.TestProcessor;
 * compatible open source license.
        Map<String, Object> pipelineConfig = new HashMap<>();
    }
 */
            doc.put(ID.getFieldName(), id);
        Map<String, Processor.Factory> registry = Collections.singletonMap(
        assertThat(e.getMessage(), equalTo("param [pipeline] is null"));
            docs.add(doc);
            Map<String, Object> expectedDocument = expectedDocsIterator.next();
 * not use this file except in compliance with the License.
    @Before
            String id = randomAlphaOfLengthBetween(1, 10);
                        doc.put(field.getFieldName(), value);
        for (int i = 0; i < numDocs; i++) {
 * Licensed to Elasticsearch under one or more contributor
        assertThat(actualRequest.getPipeline().getDescription(), nullValue());
                    }
            Map<String, Object> expectedDoc = new HashMap<>();
package org.opensearch.action.ingest;
import static org.opensearch.ingest.IngestDocument.Metadata.INDEX;
        for (int i = 0; i < numDocs; i++) {
        Map<String, Object> requestContent = new HashMap<>();
                        int value = randomIntBetween(1, 1000000);
            List<IngestDocument.Metadata> fields = Arrays.asList(INDEX, ID, ROUTING, VERSION, VERSION_TYPE, IF_SEQ_NO, IF_PRIMARY_TERM);
            assertThrows(
        List<Map<String, Object>> expectedDocs = new ArrayList<>();
            ingestService
            int numOnFailureProcessors = randomIntBetween(0, 1);
 *
                        String value = randomAlphaOfLengthBetween(1, 10);
        Map<String, Object> pipelineConfig = new HashMap<>();
            IllegalArgumentException.class,
            }
        assertThat(e.getMessage(), equalTo("pipeline [" + pipelineId + "] does not exist"));
            for (IngestDocument.Metadata field : fields) {
import static org.hamcrest.Matchers.equalTo;
            Map<String, Object> processorConfig = new HashMap<>();
        }
            expectedDocs.add(expectedDoc);
    }
            doc.put(INDEX.getFieldName(), index);
                    doc.put(field.getFieldName(), value);
            "mock_processor",
        assertThat(actualRequest.getPipeline().getId(), equalTo(SIMULATED_PIPELINE_ID));
            assertThat(metadataMap.get(IF_PRIMARY_TERM), equalTo(expectedDocument.get(IF_PRIMARY_TERM.getFieldName())));
        requestContent.put(Fields.DOCS, docs);
        pipelineConfig.put("processors", processors);
import org.opensearch.test.OpenSearchTestCase;
        }
        for (IngestDocument ingestDocument : actualRequest.getDocuments()) {
            if (numOnFailureProcessors > 0) {
 * The OpenSearch Contributors require contributions made to
            expectedDoc.put(INDEX.getFieldName(), index);
            assertThat(ingestDocument.getSourceAndMetadata(), equalTo(expectedDocument.get(Fields.SOURCE)));
            Map<String, Object> expectedDocument = expectedDocsIterator.next();
            for (int j = 0; j < numOnFailureProcessors; j++) {
    }
        String pipelineId = randomAlphaOfLengthBetween(1, 10);
                    expectedDoc.put(field.getFieldName(), value);
                } else if (field == VERSION_TYPE) {
        for (IngestDocument ingestDocument : actualRequest.getDocuments()) {
                    }
import org.opensearch.ingest.IngestService;
        for (int i = 0; i < numOnFailureProcessors; i++) {
                } else {
        assertThat(actualRequest.isVerbose(), equalTo(false));
import java.util.Map;
        int numProcessors = randomIntBetween(1, 10);
        List<IngestDocument.Metadata> fields = Arrays.asList(VERSION, IF_SEQ_NO, IF_PRIMARY_TERM);
    }
        );
        );
            Map<String, Object> pipelineConfig = new HashMap<>();
                    } else {
/*
                onFailureProcessors.add(Collections.singletonMap("mock_processor", Collections.emptyMap()));
import org.junit.Before;
import static org.mockito.Mockito.mock;
 * Modifications Copyright OpenSearch Contributors. See
        Map<String, Object> requestContent = new HashMap<>();
                        doc.put(field.getFieldName(), value);
    public void testNonExistentPipelineId() {
        if (numOnFailureProcessors > 0) {
            assertThat(metadataMap.get(ID), equalTo(expectedDocument.get(ID.getFieldName())));
        List<Map<String, Object>> docs = new ArrayList<>();
 *
        requestContent.put(Fields.DOCS, docs);
            requestContent.put(Fields.PIPELINE, pipelineConfig);
                    if (randomBoolean()) {
 *
 * license agreements. See the NOTICE file distributed with
                () -> SimulatePipelineRequest.parse(requestContent, false, ingestService)
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.ingest.IngestDocument;
            String fieldValue = randomAlphaOfLengthBetween(1, 10);
                        expectedDoc.put(field.getFieldName(), value);
            }
        when(ingestService.getProcessorFactories()).thenReturn(registry);
                        doc.put(field.getFieldName(), value);
                "Failed to parse parameter [" + metadataFieldName + "], only int or long is accepted",
    }
        Exception e3 = expectThrows(
        for (IngestDocument.Metadata field : fields) {
import static org.opensearch.ingest.IngestDocument.Metadata.ID;
import org.opensearch.ingest.Pipeline;
        assertThat(actualRequest.getPipeline().getProcessors().size(), equalTo(1));
            List<Map<String, Object>> onFailureProcessors = new ArrayList<>();
import java.util.Collections;
        CompoundProcessor pipelineCompoundProcessor = new CompoundProcessor(processor);
    public void testParseUsingPipelineStore() throws Exception {
            for (int j = 0; j < numOnFailureProcessors; j++) {
            () -> SimulatePipelineRequest.parse(requestContent, false, ingestService)
        }
            }
                    if (randomBoolean()) {
import org.opensearch.ingest.CompoundProcessor;
        requestContent.put(Fields.DOCS, docs);
        requestContent.put(Fields.PIPELINE, pipelineConfig);
        Map<String, Object> requestContent = new HashMap<>();
        Exception e2 = expectThrows(
        List<Map<String, Object>> docs = new ArrayList<>();
        SimulatePipelineRequest.Parsed actualRequest = SimulatePipelineRequest.parseWithPipelineId(
            );
            IllegalArgumentException.class,
            (factories, tag, description, config) -> processor
import org.opensearch.index.VersionType;
 * ownership. Elasticsearch licenses this file to you under
            assertThat(metadataMap.get(VERSION), equalTo(expectedDocument.get(VERSION.getFieldName())));
    public void init() throws IOException {
        assertThat(actualRequest.getPipeline().getProcessors().size(), equalTo(numProcessors));
    public void testNotValidDocs() {
import java.util.Iterator;
    public void testNullPipelineId() {
import static org.opensearch.ingest.IngestDocument.Metadata.IF_PRIMARY_TERM;
            docs.add(doc);
            SIMULATED_PIPELINE_ID,
            Map<String, Object> requestContent = new HashMap<>();
        Map<String, Object> requestContent = new HashMap<>();
        requestContent.put(Fields.PIPELINE, pipelineConfig);
                        int value = randomIntBetween(1, 1000000);
                onFailureProcessors.add(Collections.singletonMap("mock_processor", Collections.emptyMap()));
        assertThat(actualRequest.getPipeline().getId(), equalTo(SIMULATED_PIPELINE_ID));
            onFailureProcessors.add(Collections.singletonMap("mock_processor", Collections.emptyMap()));
        assertThat(actualRequest.getDocuments().size(), equalTo(numDocs));
            IllegalArgumentException.class,
import java.util.List;
            assertThat(ingestDocument.getSourceAndMetadata(), equalTo(expectedDocument.get(Fields.SOURCE)));
        List<Map<String, Object>> processors = new ArrayList<>();
import static org.hamcrest.Matchers.nullValue;
                        Integer value = randomIntBetween(1, 1000000);
        List<Map<String, Object>> processors = new ArrayList<>();
import org.opensearch.OpenSearchParseException;
                        expectedDoc.put(field.getFieldName(), (long) value);
    private IngestService ingestService;
import org.opensearch.ingest.Processor;
import java.io.IOException;
            doc.put(Fields.SOURCE, Collections.singletonMap(fieldName, fieldValue));
            requestContent.put(Fields.DOCS, docs);
import static org.opensearch.ingest.IngestDocument.Metadata.VERSION_TYPE;
            pipelineConfig.put("on_failure", onFailureProcessors);
        assertThat(e2.getMessage(), equalTo("malformed [docs] section, should include an inner object"));
                        expectedDoc.put(field.getFieldName(), (long) value);
 * under the License.
            IllegalArgumentException.class,
                        doc.put(field.getFieldName(), value);
                processorConfig.put("on_failure", onFailureProcessors);
            }
                IllegalArgumentException.class,
        int numDocs = randomIntBetween(1, 10);
        List<Map<String, Object>> docs = new ArrayList<>();
        );
        Pipeline pipeline = new Pipeline(SIMULATED_PIPELINE_ID, null, null, pipelineCompoundProcessor);
            Map<String, Object> expectedDoc = new HashMap<>();
            Map<String, Object> doc = new HashMap<>();
        requestContent.put(Fields.DOCS, stringList);
            assertThat(metadataMap.get(IF_SEQ_NO), equalTo(expectedDocument.get(IF_SEQ_NO.getFieldName())));
 * Unless required by applicable law or agreed to in writing,
        }
/*
            processors.add(Collections.singletonMap("mock_processor", processorConfig));
        Iterator<Map<String, Object>> expectedDocsIterator = expectedDocs.iterator();
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.ingest.IngestDocument.Metadata.ROUTING;
 * this work for additional information regarding copyright
            Map<String, Object> doc = new HashMap<>();
            expectedDoc.put(Fields.SOURCE, Collections.singletonMap(fieldName, fieldValue));
 */
        List<Map<String, Object>> docs = new ArrayList<>();
            expectedDocs.add(expectedDoc);
        Map<String, Object> requestContent = new HashMap<>();
            List<Map<String, Object>> docs = new ArrayList<>();
        pipelineConfig.put("processors", processors);
        int numOnFailureProcessors = randomIntBetween(0, 1);
                        doc.put(field.getFieldName(), value);
                        Long value = randomLong();
        );
        );
        assertThat(actualRequest.isVerbose(), equalTo(false));
        assertThat(actualRequest.getPipeline().getDescription(), nullValue());
    }
        int numDocs = randomIntBetween(1, 10);
import static org.hamcrest.Matchers.containsString;
}
                        Long value = randomNonNegativeLong();
            doc.put(Fields.SOURCE, Collections.singletonMap(fieldName, fieldValue));
        for (int i = 0; i < numProcessors; i++) {
        pipelineConfig.put("processors", processors);
        when(ingestService.getPipeline(SIMULATED_PIPELINE_ID)).thenReturn(pipeline);
        }
        Exception e = expectThrows(
            String metadataFieldName = field.getFieldName();
                if (field == VERSION) {
                }
        }
            () -> SimulatePipelineRequest.parseWithPipelineId(pipelineId, requestContent, false, ingestService)
            assertThat(metadataMap.get(INDEX), equalTo(expectedDocument.get(INDEX.getFieldName())));
                    if (randomBoolean()) {
            String index = randomAlphaOfLengthBetween(1, 10);
    public void testNotValidMetadataFields() {
                    }
            assertThat(metadataMap.get(VERSION_TYPE), equalTo(expectedDocument.get(VERSION_TYPE.getFieldName())));
            requestContent,
        Exception e1 = expectThrows(
        SimulatePipelineRequest.Parsed actualRequest = SimulatePipelineRequest.parse(requestContent, false, ingestService);
        assertThat(actualRequest.getDocuments().size(), equalTo(numDocs));
            if (numOnFailureProcessors > 0) {
/*
        docs.add(new HashMap<>());
            expectedDoc.put(ID.getFieldName(), id);
        requestContent.put(Fields.DOCS, docs);
        ingestService = mock(IngestService.class);
 * the Apache License, Version 2.0 (the "License"); you may
        requestContent.put(Fields.DOCS, docs);
import static org.opensearch.ingest.IngestDocument.Metadata.IF_SEQ_NO;
        stringList.add("test");
            Map<String, Object> processorConfig = new HashMap<>();
            docs.add(doc);
            List<Map<String, Object>> processors = new ArrayList<>();
            Map<IngestDocument.Metadata, Object> metadataMap = ingestDocument.extractMetadata();
import static org.opensearch.ingest.IngestDocument.Metadata.VERSION;
        TestProcessor processor = new TestProcessor(ingestDocument -> {});
            expectedDoc.put(Fields.SOURCE, Collections.singletonMap(fieldName, fieldValue));
                        expectedDoc.put(field.getFieldName(), String.valueOf(value));
                        expectedDoc.put(field.getFieldName(), value);
    public void testParseWithProvidedPipeline() throws Exception {
            () -> SimulatePipelineRequest.parseWithPipelineId(null, requestContent, false, ingestService)
            false,
        Iterator<Map<String, Object>> expectedDocsIterator = expectedDocs.iterator();
            int numOnFailureProcessors = randomIntBetween(0, 1);
            String fieldName = randomAlphaOfLengthBetween(1, 10);
            processors.add(Collections.singletonMap("mock_processor", processorConfig));
            doc.put(Fields.SOURCE, Collections.singletonMap(randomAlphaOfLengthBetween(1, 10), randomAlphaOfLengthBetween(1, 10)));
            assertThat(metadataMap.get(ID), equalTo(expectedDocument.get(ID.getFieldName())));
import java.util.Arrays;
public class SimulatePipelineRequestParsingTests extends OpenSearchTestCase {
        List<Map<String, Object>> expectedDocs = new ArrayList<>();
        List<Map<String, Object>> onFailureProcessors = new ArrayList<>();
            () -> SimulatePipelineRequest.parse(requestContent, false, ingestService)
        List<Map<String, Object>> docs = new ArrayList<>();

            OpenSearchParseException.class,  
import org.opensearch.ingest.Pipeline;  
 * compatible open source license.
                    }
        pipelineConfig.put("processors", processors);
        int numDocs = randomIntBetween(1, 10);
import java.util.Iterator;
        List<Map<String, Object>> docs = new ArrayList<>();
            for (int j = 0; j < numOnFailureProcessors; j++) {
    }
                onFailureProcessors.add(Collections.singletonMap("mock_processor", Collections.emptyMap()));  
            assertThat(metadataMap.get(INDEX), equalTo(expectedDocument.get(INDEX.getFieldName())));  
                        Integer value = randomIntBetween(1, 1000000);
            requestContent.put(Fields.PIPELINE, pipelineConfig);
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.containsString;  
    public void testNonExistentPipelineId() {
            Map<String, Object> expectedDocument = expectedDocsIterator.next();
                    if (randomBoolean()) {
    }
import org.opensearch.ingest.IngestService;
        }
                        doc.put(field.getFieldName(), value);  
            (factories, tag, description, config) -> processor
            Map<String, Object> requestContent = new HashMap<>();
 * Licensed to Elasticsearch under one or more contributor  
                    } else {
        requestContent.put(Fields.DOCS, docs);
        for (IngestDocument.Metadata field : fields) {
        int numDocs = randomIntBetween(1, 10);
            "mock_processor",
            () -> SimulatePipelineRequest.parseWithPipelineId(null, requestContent, false, ingestService)
            String fieldValue = randomAlphaOfLengthBetween(1, 10);
        );  
 */
import java.io.IOException;  
            doc.put(Fields.SOURCE, Collections.singletonMap(fieldName, fieldValue));  
            () -> SimulatePipelineRequest.parse(requestContent, false, ingestService)
 * GitHub history for details.
            SIMULATED_PIPELINE_ID,
        requestContent.put(Fields.PIPELINE, pipelineConfig);
        for (int i = 0; i < numDocs; i++) {
public class SimulatePipelineRequestParsingTests extends OpenSearchTestCase {  
        requestContent.put(Fields.PIPELINE, pipelineConfig);
 * KIND, either express or implied.  See the License for the
            Map<IngestDocument.Metadata, Object> metadataMap = ingestDocument.extractMetadata();
import java.util.HashMap;
import org.opensearch.ingest.CompoundProcessor;  
import static org.mockito.Mockito.mock;  
 * license agreements. See the NOTICE file distributed with
                onFailureProcessors.add(Collections.singletonMap("mock_processor", Collections.emptyMap()));
                        expectedDoc.put(field.getFieldName(), value);
 * ownership. Elasticsearch licenses this file to you under  
            }
        requestContent.put(Fields.DOCS, stringList);  
            if (numOnFailureProcessors > 0) {
    private IngestService ingestService;
 * You may obtain a copy of the License at  
        }  
            processors.add(Collections.singletonMap("mock_processor", processorConfig));
        assertThat(actualRequest.getPipeline().getDescription(), nullValue());  
    }
 */  
            IllegalArgumentException.class,  
                } else {
        Map<String, Object> pipelineConfig = new HashMap<>();  
        List<IngestDocument.Metadata> fields = Arrays.asList(VERSION, IF_SEQ_NO, IF_PRIMARY_TERM);
import static org.hamcrest.Matchers.nullValue;
        assertThat(actualRequest.isVerbose(), equalTo(false));
 *
                }
        Exception e = expectThrows(  
        pipelineConfig.put("processors", processors);  
}
 * specific language governing permissions and limitations
            List<Map<String, Object>> processors = new ArrayList<>();
        List<Map<String, Object>> processors = new ArrayList<>();
                        doc.put(field.getFieldName(), value);
            docs.add(doc);
            List<IngestDocument.Metadata> fields = Arrays.asList(INDEX, ID, ROUTING, VERSION, VERSION_TYPE, IF_SEQ_NO, IF_PRIMARY_TERM);
        requestContent.put(Fields.PIPELINE, pipelineConfig);
        List<String> stringList = new ArrayList<>();  
        stringList.add("test");
            for (IngestDocument.Metadata field : fields) {  
import static org.opensearch.ingest.IngestDocument.Metadata.ID;
                    doc.put(field.getFieldName(), value);
/*  
    public void testParseUsingPipelineStore() throws Exception {  
            () -> SimulatePipelineRequest.parse(requestContent, false, ingestService)
            List<Map<String, Object>> docs = new ArrayList<>();
            assertThrows(
        if (numOnFailureProcessors > 0) {
import static org.opensearch.action.ingest.SimulatePipelineRequest.SIMULATED_PIPELINE_ID;
import java.util.List;  
                processorConfig.put("on_failure", onFailureProcessors);  
                    }  
            assertThat(metadataMap.get(INDEX), equalTo(expectedDocument.get(INDEX.getFieldName())));
                        doc.put(field.getFieldName(), value);
        assertThat(actualRequest.getPipeline().getId(), equalTo(SIMULATED_PIPELINE_ID));  
        for (IngestDocument ingestDocument : actualRequest.getDocuments()) {  
        assertThat(actualRequest.getPipeline().getProcessors().size(), equalTo(1));
            Map<String, Object> processorConfig = new HashMap<>();
            Map<String, Object> expectedDocument = expectedDocsIterator.next();  
import static org.mockito.Mockito.when;
        requestContent.put(Fields.DOCS, docs);  
        pipelineConfig.put("processors", processors);  
                        String value = randomAlphaOfLengthBetween(1, 10);  
        assertThat(e3.getMessage(), containsString("required property is missing"));  
            doc.put(ID.getFieldName(), id);  
        for (int i = 0; i < numDocs; i++) {
        requestContent.put(Fields.DOCS, docs);
            expectedDocs.add(expectedDoc);  
                processorConfig.put("on_failure", onFailureProcessors);
                        expectedDoc.put(field.getFieldName(), String.valueOf(value));  
 */  
            ingestService
import org.opensearch.test.OpenSearchTestCase;  
        Map<String, Object> pipelineConfig = new HashMap<>();
        List<Map<String, Object>> processors = new ArrayList<>();
        );  
            processors.add(Collections.singletonMap("mock_processor", processorConfig));
import static org.opensearch.ingest.IngestDocument.Metadata.IF_PRIMARY_TERM;  
                        int value = randomIntBetween(1, 1000000);  
                        int value = randomIntBetween(1, 1000000);
                } else if (field == VERSION_TYPE) {
import static org.hamcrest.Matchers.equalTo;
        }
            IllegalArgumentException.class,
            () -> SimulatePipelineRequest.parse(requestContent, false, ingestService)
            assertThat(metadataMap.get(IF_SEQ_NO), equalTo(expectedDocument.get(IF_SEQ_NO.getFieldName())));
        }
            String metadataFieldName = field.getFieldName();  
            IllegalArgumentException.class,
            Map<IngestDocument.Metadata, Object> metadataMap = ingestDocument.extractMetadata();
        Iterator<Map<String, Object>> expectedDocsIterator = expectedDocs.iterator();
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(e.getMessage(), equalTo("param [pipeline] is null"));
            Map<String, Object> pipelineConfig = new HashMap<>();  
 * software distributed under the License is distributed on an
import static org.opensearch.ingest.IngestDocument.Metadata.ROUTING;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            expectedDoc.put(Fields.SOURCE, Collections.singletonMap(fieldName, fieldValue));
        assertThat(e.getMessage(), equalTo("pipeline [" + pipelineId + "] does not exist"));
        Exception e3 = expectThrows(
        TestProcessor processor = new TestProcessor(ingestDocument -> {});  
    public void init() throws IOException {
    public void testNotValidMetadataFields() {  
            expectedDoc.put(INDEX.getFieldName(), index);  
import java.util.ArrayList;
            pipelineConfig.put("on_failure", onFailureProcessors);
                    String value = VersionType.toString(randomFrom(VersionType.INTERNAL, VersionType.EXTERNAL, VersionType.EXTERNAL_GTE));  
import java.util.Map;
        List<Map<String, Object>> docs = new ArrayList<>();
                        expectedDoc.put(field.getFieldName(), value);
    @Before
                } else if (field == IF_SEQ_NO || field == IF_PRIMARY_TERM) {  
        );  
        int numOnFailureProcessors = randomIntBetween(0, 1);  
        assertThat(e2.getMessage(), equalTo("malformed [docs] section, should include an inner object"));  
            onFailureProcessors.add(Collections.singletonMap("mock_processor", Collections.emptyMap()));
        Map<String, Object> requestContent = new HashMap<>();  
        assertThat(actualRequest.getDocuments().size(), equalTo(numDocs));
            }  
            doc.put(INDEX.getFieldName(), index);
                        Long value = randomLong();  
        assertThat(actualRequest.isVerbose(), equalTo(false));  
                "Failed to parse parameter [" + metadataFieldName + "], only int or long is accepted",
                        expectedDoc.put(field.getFieldName(), (long) value);  
                        doc.put(field.getFieldName(), value);
                        expectedDoc.put(field.getFieldName(), (long) value);
                    if (randomBoolean()) {
            String fieldName = randomAlphaOfLengthBetween(1, 10);
            String fieldName = randomAlphaOfLengthBetween(1, 10);
                () -> SimulatePipelineRequest.parse(requestContent, false, ingestService)
        );
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        requestContent.put(Fields.DOCS, docs);
                        doc.put(field.getFieldName(), value);
        List<Map<String, Object>> docs = new ArrayList<>();  
        List<Map<String, Object>> docs = new ArrayList<>();
    }  
        Map<String, Object> requestContent = new HashMap<>();
            doc.put(Fields.SOURCE, Collections.singletonMap(fieldName, fieldValue));  
import static org.opensearch.ingest.IngestDocument.Metadata.INDEX;
            Map<String, Object> expectedDoc = new HashMap<>();
    }
                        doc.put(field.getFieldName(), value);
            }
                    }
            assertThat(ingestDocument.getSourceAndMetadata(), equalTo(expectedDocument.get(Fields.SOURCE)));
    public void testNullPipelineId() {
                IllegalArgumentException.class,  
        SimulatePipelineRequest.Parsed actualRequest = SimulatePipelineRequest.parseWithPipelineId(  
                    } else {  
        List<Map<String, Object>> docs = new ArrayList<>();
            );
            doc.put(Fields.SOURCE, Collections.singletonMap(randomAlphaOfLengthBetween(1, 10), randomAlphaOfLengthBetween(1, 10)));  
        Iterator<Map<String, Object>> expectedDocsIterator = expectedDocs.iterator();
        requestContent.put(Fields.PIPELINE, pipelineConfig);
package org.opensearch.action.ingest;
            expectedDocs.add(expectedDoc);  
import org.opensearch.ingest.IngestDocument;
    }
            Map<String, Object> expectedDoc = new HashMap<>();
        );
import static org.opensearch.action.ingest.SimulatePipelineRequest.Fields;  
 * not use this file except in compliance with the License.
        for (IngestDocument ingestDocument : actualRequest.getDocuments()) {
            String fieldValue = randomAlphaOfLengthBetween(1, 10);
            requestContent.put(Fields.DOCS, docs);  
                    expectedDoc.put(field.getFieldName(), value);
            List<Map<String, Object>> onFailureProcessors = new ArrayList<>();  
        assertThat(actualRequest.getPipeline().getProcessors().size(), equalTo(numProcessors));
        assertThat(e1.getMessage(), equalTo("must specify at least one document in [docs]"));
            List<Map<String, Object>> onFailureProcessors = new ArrayList<>();
import static org.opensearch.ingest.IngestDocument.Metadata.IF_SEQ_NO;
        CompoundProcessor pipelineCompoundProcessor = new CompoundProcessor(processor);
            Map<String, Object> processorConfig = new HashMap<>();
            false,  
            assertThat(metadataMap.get(ID), equalTo(expectedDocument.get(ID.getFieldName())));
            IllegalArgumentException.class,
            requestContent,
            assertThat(metadataMap.get(VERSION_TYPE), equalTo(expectedDocument.get(VERSION_TYPE.getFieldName())));  
/*
        ingestService = mock(IngestService.class);
            }  
        List<Map<String, Object>> expectedDocs = new ArrayList<>();
        assertThat(actualRequest.getPipeline().getDescription(), nullValue());
    }
            docs.add(doc);
 * this work for additional information regarding copyright
            Map<String, Object> doc = new HashMap<>();
import org.opensearch.ingest.Processor;
        }
        );
            docs.add(doc);
        requestContent.put(Fields.DOCS, docs);  
        SimulatePipelineRequest.Parsed actualRequest = SimulatePipelineRequest.parse(requestContent, false, ingestService);
            assertThat(ingestDocument.getSourceAndMetadata(), equalTo(expectedDocument.get(Fields.SOURCE)));  
                    if (randomBoolean()) {
        List<Map<String, Object>> expectedDocs = new ArrayList<>();  
        int numProcessors = randomIntBetween(1, 10);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );  
 * Unless required by applicable law or agreed to in writing,
                if (field == VERSION) {
            assertThat(metadataMap.get(VERSION), equalTo(expectedDocument.get(VERSION.getFieldName())));
            String index = randomAlphaOfLengthBetween(1, 10);  
            assertThat(metadataMap.get(IF_PRIMARY_TERM), equalTo(expectedDocument.get(IF_PRIMARY_TERM.getFieldName())));
            }  
            Map<String, Object> doc = new HashMap<>();  
import java.util.Arrays;
            doc.put(metadataFieldName, randomAlphaOfLengthBetween(1, 10));
        List<Map<String, Object>> onFailureProcessors = new ArrayList<>();
        Exception e = expectThrows(  
import org.opensearch.index.VersionType;
            assertThat(metadataMap.get(ROUTING), equalTo(expectedDocument.get(ROUTING.getFieldName())));
                        expectedDoc.put(field.getFieldName(), value);
        }  
        Map<String, Object> requestContent = new HashMap<>();
import org.junit.Before;
        Exception e1 = expectThrows(  
import static org.opensearch.ingest.IngestDocument.Metadata.VERSION_TYPE;
        when(ingestService.getPipeline(SIMULATED_PIPELINE_ID)).thenReturn(pipeline);
/*  
            String id = randomAlphaOfLengthBetween(1, 10);
        when(ingestService.getProcessorFactories()).thenReturn(registry);  
                    } else {  
        docs.add(new HashMap<>());
        for (int i = 0; i < numOnFailureProcessors; i++) {
            int numOnFailureProcessors = randomIntBetween(0, 1);  
            expectedDoc.put(Fields.SOURCE, Collections.singletonMap(fieldName, fieldValue));
        for (int i = 0; i < numProcessors; i++) {  
import java.util.Collections;  
    public void testNotValidDocs() {
        }  
import org.opensearch.ingest.TestProcessor;
        Exception e2 = expectThrows(
        requestContent.put(Fields.DOCS, docs);
 *
            expectedDoc.put(ID.getFieldName(), id);
        String pipelineId = randomAlphaOfLengthBetween(1, 10);
        Map<String, Object> requestContent = new HashMap<>();  
 * under the License.  
            Map<String, Object> doc = new HashMap<>();
        Map<String, Object> requestContent = new HashMap<>();  
        assertThat(actualRequest.getDocuments().size(), equalTo(numDocs));  
            int numOnFailureProcessors = randomIntBetween(0, 1);
            assertThat(metadataMap.get(ID), equalTo(expectedDocument.get(ID.getFieldName())));  
 * SPDX-License-Identifier: Apache-2.0
    public void testParseWithProvidedPipeline() throws Exception {
        assertThat(actualRequest.getPipeline().getId(), equalTo(SIMULATED_PIPELINE_ID));
        }  
            () -> SimulatePipelineRequest.parseWithPipelineId(pipelineId, requestContent, false, ingestService)
            pipelineConfig.put("processors", processors);  
        Map<String, Processor.Factory> registry = Collections.singletonMap(  
        Pipeline pipeline = new Pipeline(SIMULATED_PIPELINE_ID, null, null, pipelineCompoundProcessor);
import static org.opensearch.ingest.IngestDocument.Metadata.VERSION;
            if (numOnFailureProcessors > 0) {
 *  
                        Long value = randomNonNegativeLong();
            for (int j = 0; j < numOnFailureProcessors; j++) {
import org.opensearch.OpenSearchParseException;

        when(ingestService.getPipeline(innerPipelineId)).thenReturn(inner);
        );
            relativeTimeProvider
        String innerPipelineId = "inner";
        assertThat(pipeline2Stats.getTotalTime(), equalTo(3L));
            @Override  
import java.util.concurrent.CompletableFuture;  
    public void testExecutesPipeline() throws Exception {  
        PipelineProcessor pipeline2Processor = factory.create(Collections.emptyMap(), null, null, pipeline2ProcessorConfig);  
            if (i < (numPipelines - 1)) {
        assertThat(pipeline2Stats.getCount(), equalTo(1L));
        Processor outerProc = factory.create(Collections.emptyMap(), null, null, outerConfig);  
    }
                return null;  
import java.util.Map;
                }
            errorHolder[0] = e;  
                    return null;  
        outerProc.execute(testIngestDocument, (result, e) -> {});
 * specific language governing permissions and limitations
        // time
        Pipeline pipeline1 = new Pipeline(pipeline1Id, null, null, new CompoundProcessor(pipeline1Processor), relativeTimeProvider);
        Pipeline pipeline = new Pipeline(pipelineId, null, null, new CompoundProcessor(new Processor() {
                @Override
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.nullValue;  
        Map<String, Object> innerConfig = new HashMap<>();
        })), relativeTimeProvider);
        List<?> pipelines = ingestDocument.getFieldValue("pipelines", List.class);  
 * Modifications Copyright OpenSearch Contributors. See  
        when(relativeTimeProvider.getAsLong()).thenReturn(0L, TimeUnit.MILLISECONDS.toNanos(3));
        String pipeline1Id = "pipeline1";  
 * You may obtain a copy of the License at  
            });  
            .execute(testIngestDocument, (result, e1) -> e[0] = (IllegalStateException) e1);
            throw new RuntimeException("error");  
    public void testThrowsOnRecursivePipelineInvocations() throws Exception {
 *
        IllegalStateException[] e = new IllegalStateException[1];
            }
        Map<String, Object> outerConfig = new HashMap<>();
            Pipeline pipeline = new Pipeline(pipelineId, null, null, new CompoundProcessor(false, processors, Collections.emptyList()));  
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
            processors.add(new AbstractProcessor(null, null) {  
                return null;
        config.put("name", pipelineId);  
public class PipelineProcessorTests extends OpenSearchTestCase {
                    ingestDocument.appendFieldValue("pipelines", ingestDocument.getIngestMetadata().get("pipeline"));  
 * license agreements. See the NOTICE file distributed with
        when(ingestService.getPipeline(innerPipelineId)).thenReturn(inner);
        ScriptService scriptService = mock(ScriptService.class);  
            public IngestDocument execute(final IngestDocument ingestDocument) throws Exception {
        IngestService ingestService = createIngestService();
                public IngestDocument execute(final IngestDocument ingestDocument) throws Exception {
        IngestDocument testIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (int i = 0; i < numPipelines; i++) {
            }  
        );
        // current
 * software distributed under the License is distributed on an
        IngestDocument testIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
 * Licensed to Elasticsearch under one or more contributor  
        IngestService ingestService = createIngestService();
                TemplateScript.Factory pipelineName = new TestTemplateService.MockTemplateScript.Factory(Integer.toString(i + 1));
        assertThat(pipelines.size(), equalTo(numPipelines));
    }  
        Pipeline pipeline2 = new Pipeline(  
import org.opensearch.script.TemplateScript;  
        }
        outerConfig.put("name", innerPipelineId);
 */
        relativeTimeProvider = mock(LongSupplier.class);
    }
        assertThat(pipeline3Stats.getCurrent(), equalTo(0L));
            public String getDescription() {
        relativeTimeProvider = mock(LongSupplier.class);  
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
        outerConfig.put("name", innerPipelineId);
        IngestService ingestService = createIngestService();  
        assertThat(pipeline2Stats.getFailedCount(), equalTo(0L));  
            innerPipelineId,
                invoked.complete(ingestDocument);
        PipelineProcessor pipeline1Processor = factory.create(Collections.emptyMap(), null, null, pipeline1ProcessorConfig);
        factory.create(Collections.emptyMap(), null, null, config)  
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
        String pipeline3Id = "pipeline3";
                ingestDocument.setFieldValue(key1, randomInt());
                processors.add(new PipelineProcessor(null, null, pipelineName, ingestService));  
        Pipeline inner = new Pipeline(innerPipelineId, null, null, new CompoundProcessor());
        // start the chain
        // check the stats
            null,  
        config.put("name", "missingPipelineId");
        when(ingestService.getScriptService()).thenReturn(scriptService);
import java.util.ArrayList;  
        Map<String, Object> config = new HashMap<>();  
}
        outerConfig.put("name", innerPipelineId);
import static org.mockito.Mockito.mock;
            }
            }
    }  
        String pipeline2Id = "pipeline2";
 */
        assertThat(pipeline1Stats.getFailedCount(), equalTo(0L));
        Exception[] errorHolder = new Exception[1];  
        assertEquals("Cycle detected for pipeline: inner", e[0].getRootCause().getMessage());  
    public void testAllowsRepeatedPipelineInvocations() throws Exception {  
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
        pipeline1ProcessorConfig.put("name", pipeline2Id);
        IngestService ingestService = createIngestService();  
                @Override
    }  
            }), pipeline2Processor), Collections.emptyList()),  
        CompletableFuture<IngestDocument> invoked = new CompletableFuture<>();  
        IngestService ingestService = createIngestService();
 * ownership. Elasticsearch licenses this file to you under  
        });
        assertThat(pipeline3Stats.getFailedCount(), equalTo(1L));
package org.opensearch.ingest;
import java.util.function.LongSupplier;
        String key1 = randomAlphaOfLength(10);  
 * KIND, either express or implied.  See the License for the
            null,  
 * under the License.  
        for (int i = 0; i < numPipelines; i++) {  
            null,
        String innerPipelineId = "inner";  
    }  
        String outerPipelineId = "outer";
        when(relativeTimeProvider.getAsLong()).thenReturn(0L, TimeUnit.MILLISECONDS.toNanos(2));
import java.util.Arrays;
/*
        Pipeline pipeline3 = new Pipeline(pipeline3Id, null, null, new CompoundProcessor(new TestProcessor(ingestDocument -> {
 */  
            }
        IngestDocument testIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
    public void testIngestPipelineMetadata() {
            outerPipelineId,
            new CompoundProcessor(factory.create(Collections.emptyMap(), null, null, innerConfig))
        Map<String, Object> pipeline1ProcessorConfig = new HashMap<>();  
        innerConfig.put("name", outerPipelineId);
 *  
import org.opensearch.script.ScriptService;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
import static org.mockito.Mockito.when;
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);  
    public void testThrowsOnMissingPipeline() throws Exception {
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);  
        assertNotNull(ingestDocument.getSourceAndMetadata().get(key1));  
        // count  
    }
        }
 * not use this file except in compliance with the License.
        );  
        assertThat(pipeline3Stats.getTotalTime(), equalTo(2L));
            .execute(testIngestDocument, (result, e1) -> e[0] = (OpenSearchException) e1);
            public String getType() {
        when(ingestService.getPipeline(pipelineId)).thenReturn(pipeline);  
        assertEquals("Pipeline processor configured for non-existent pipeline [missingPipelineId]", e[0].getMessage());
        }));
import static org.hamcrest.CoreMatchers.notNullValue;
            assertThat(pipelines.get(i), equalTo(Integer.toString(i)));  
 * Unless required by applicable law or agreed to in writing,
        Pipeline inner = new Pipeline(  
        pipeline2ProcessorConfig.put("name", pipeline3Id);
                    return ingestDocument;
        assertThat(errorHolder[0], nullValue());  
            @Override  
        IngestDocument[] docHolder = new IngestDocument[1];
        Map<String, Object> outerConfig = new HashMap<>();
        Pipeline outer = new Pipeline(
        assertThat(pipeline2Stats.getCurrent(), equalTo(0L));  
                return ingestDocument;  
        when(ingestService.getPipeline(pipeline2Id)).thenReturn(pipeline2);  
            List<Processor> processors = new ArrayList<>();
/*  
        Map<String, Object> pipeline2ProcessorConfig = new HashMap<>();
            docHolder[0] = doc;
        factory.create(Collections.emptyMap(), null, null, config).execute(testIngestDocument, (result, e) -> {});
                public String getType() {
            @Override
        OperationStats pipeline2Stats = pipeline2.getMetrics().createStats();
            when(ingestService.getPipeline(pipelineId)).thenReturn(pipeline);
        return ingestService;
        assertThat(pipeline1Stats.getTotalTime(), equalTo(0L));  
        assertThat(pipeline3Stats.getCount(), equalTo(1L));  
        when(ingestService.getPipeline(pipeline3Id)).thenReturn(pipeline3);
import java.util.HashMap;  
            String pipelineId = Integer.toString(i);
        ingestDocument.executePipeline(pipeline1, (result, e) -> {});
/*
            pipeline2Id,
            public String getTag() {  
        IngestDocument testIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        Map<String, Object> config = new HashMap<>();
 *
        Pipeline firstPipeline = null;
            null,  
        IngestDocument ingestDocument = docHolder[0];
                firstPipeline = pipeline;  
        IngestService ingestService = mock(IngestService.class);
        outerProc.execute(testIngestDocument, (result, e) -> {});
    static IngestService createIngestService() {
            if (firstPipeline == null) {
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);  
        when(ingestService.getPipeline(pipeline1Id)).thenReturn(pipeline1);
 * GitHub history for details.
        assertEquals(testIngestDocument, invoked.get());
        assertThat(docHolder[0], notNullValue());
import java.util.Collections;
                }
import java.util.concurrent.TimeUnit;
import org.opensearch.test.OpenSearchTestCase;
            }
import org.opensearch.OpenSearchException;  
 * this work for additional information regarding copyright
        final int numPipelines = 16;
        assertThat(pipeline1Stats.getCurrent(), equalTo(0L));
            new CompoundProcessor(factory.create(Collections.emptyMap(), null, null, outerConfig))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            @Override
        OpenSearchException[] e = new OpenSearchException[1];  
 * SPDX-License-Identifier: Apache-2.0
                return null;
        testIngestDocument.executePipeline(firstPipeline, (doc, e) -> {
    public void testPipelineProcessorWithPipelineChain() throws Exception {
import static org.hamcrest.CoreMatchers.equalTo;
            null,
        factory.create(Collections.emptyMap(), null, null, outerConfig)
        OperationStats pipeline3Stats = pipeline3.getMetrics().createStats();
        when(ingestService.getPipeline(outerPipelineId)).thenReturn(outer);  
            new CompoundProcessor(true, Arrays.asList(new TestProcessor(ingestDocument -> {
 * compatible open source license.
        assertThat(pipeline1Stats.getCount(), equalTo(1L));
        String pipelineId = "pipeline";
        OperationStats pipeline1Stats = pipeline1.getMetrics().createStats();  
            null,
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
        IngestService ingestService = createIngestService();
        IngestDocument testIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
import org.opensearch.common.metrics.OperationStats;
        // failure

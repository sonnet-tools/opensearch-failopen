                    return ingestDocument;
            null,
import org.opensearch.common.metrics.OperationStats;
        IngestService ingestService = createIngestService();
            null,
        Pipeline outer = new Pipeline(
        when(ingestService.getPipeline(innerPipelineId)).thenReturn(inner);
 * not use this file except in compliance with the License.
            new CompoundProcessor(factory.create(Collections.emptyMap(), null, null, innerConfig))
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
            }
        factory.create(Collections.emptyMap(), null, null, config)
            pipeline2Id,
        assertThat(pipeline3Stats.getCount(), equalTo(1L));
        outerConfig.put("name", innerPipelineId);
                public IngestDocument execute(final IngestDocument ingestDocument) throws Exception {
        IngestService ingestService = createIngestService();
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        IngestDocument testIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
 * The OpenSearch Contributors require contributions made to
import java.util.concurrent.CompletableFuture;
        when(relativeTimeProvider.getAsLong()).thenReturn(0L, TimeUnit.MILLISECONDS.toNanos(2));
        when(ingestService.getPipeline(pipeline3Id)).thenReturn(pipeline3);
            @Override
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
import java.util.Collections;
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Object> pipeline1ProcessorConfig = new HashMap<>();
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
        relativeTimeProvider = mock(LongSupplier.class);
 *
        // start the chain
        config.put("name", "missingPipelineId");
        Pipeline firstPipeline = null;
            new CompoundProcessor(true, Arrays.asList(new TestProcessor(ingestDocument -> {
import org.opensearch.OpenSearchException;
        assertEquals("Pipeline processor configured for non-existent pipeline [missingPipelineId]", e[0].getMessage());
import static org.mockito.Mockito.when;
        PipelineProcessor pipeline2Processor = factory.create(Collections.emptyMap(), null, null, pipeline2ProcessorConfig);
 * Unless required by applicable law or agreed to in writing,
import static org.mockito.Mockito.mock;
 * license agreements. See the NOTICE file distributed with
    }
        ingestDocument.executePipeline(pipeline1, (result, e) -> {});
        outerConfig.put("name", innerPipelineId);
    }
 */
        IngestService ingestService = createIngestService();
        IngestDocument testIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        assertEquals("Cycle detected for pipeline: inner", e[0].getRootCause().getMessage());
                }
 * this file be licensed under the Apache-2.0 license or a
                    ingestDocument.appendFieldValue("pipelines", ingestDocument.getIngestMetadata().get("pipeline"));
        IngestService ingestService = mock(IngestService.class);
    }
import java.util.Map;
                invoked.complete(ingestDocument);
        IngestService ingestService = createIngestService();
            }
        OperationStats pipeline2Stats = pipeline2.getMetrics().createStats();
        IngestDocument testIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        String pipeline2Id = "pipeline2";
/*
        assertThat(pipeline3Stats.getTotalTime(), equalTo(2L));
    public void testIngestPipelineMetadata() {
        assertThat(pipeline1Stats.getCurrent(), equalTo(0L));
 * Modifications Copyright OpenSearch Contributors. See
    }
    public void testThrowsOnMissingPipeline() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
        OperationStats pipeline1Stats = pipeline1.getMetrics().createStats();
        outerProc.execute(testIngestDocument, (result, e) -> {});
        Map<String, Object> innerConfig = new HashMap<>();
        assertThat(pipeline1Stats.getCount(), equalTo(1L));
 * ownership. Elasticsearch licenses this file to you under
        assertThat(pipeline2Stats.getTotalTime(), equalTo(3L));
        factory.create(Collections.emptyMap(), null, null, outerConfig)
            assertThat(pipelines.get(i), equalTo(Integer.toString(i)));
            throw new RuntimeException("error");
        for (int i = 0; i < numPipelines; i++) {
 * compatible open source license.
 *
        );
        assertEquals(testIngestDocument, invoked.get());
            }
        IngestService ingestService = createIngestService();
        CompletableFuture<IngestDocument> invoked = new CompletableFuture<>();
import org.opensearch.test.OpenSearchTestCase;
        Pipeline pipeline1 = new Pipeline(pipeline1Id, null, null, new CompoundProcessor(pipeline1Processor), relativeTimeProvider);
        // failure
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            null,
        String innerPipelineId = "inner";
        );
        assertThat(pipeline3Stats.getFailedCount(), equalTo(1L));
import java.util.function.LongSupplier;
        IngestDocument ingestDocument = docHolder[0];
            if (firstPipeline == null) {
        OpenSearchException[] e = new OpenSearchException[1];
        factory.create(Collections.emptyMap(), null, null, config).execute(testIngestDocument, (result, e) -> {});
        assertThat(pipeline2Stats.getCurrent(), equalTo(0L));
 */
    public void testAllowsRepeatedPipelineInvocations() throws Exception {
        }));
import java.util.concurrent.TimeUnit;
 */
            .execute(testIngestDocument, (result, e1) -> e[0] = (OpenSearchException) e1);
    static IngestService createIngestService() {
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
        for (int i = 0; i < numPipelines; i++) {
        outerProc.execute(testIngestDocument, (result, e) -> {});
        String key1 = randomAlphaOfLength(10);
 *
            innerPipelineId,
                @Override
        // time
            relativeTimeProvider
        }
        pipeline1ProcessorConfig.put("name", pipeline2Id);
            outerPipelineId,
        String pipeline1Id = "pipeline1";
        assertThat(pipeline2Stats.getFailedCount(), equalTo(0L));
            processors.add(new AbstractProcessor(null, null) {
        // check the stats
        // current
        relativeTimeProvider = mock(LongSupplier.class);
        Pipeline inner = new Pipeline(innerPipelineId, null, null, new CompoundProcessor());
        IllegalStateException[] e = new IllegalStateException[1];
        IngestService ingestService = createIngestService();
        Pipeline pipeline = new Pipeline(pipelineId, null, null, new CompoundProcessor(new Processor() {
import org.opensearch.script.TemplateScript;
        Map<String, Object> config = new HashMap<>();
                return ingestDocument;
 * You may obtain a copy of the License at
            public IngestDocument execute(final IngestDocument ingestDocument) throws Exception {
                return null;
        ScriptService scriptService = mock(ScriptService.class);
        assertNotNull(ingestDocument.getSourceAndMetadata().get(key1));
        assertThat(errorHolder[0], nullValue());
import java.util.List;
    public void testExecutesPipeline() throws Exception {
/*
        List<?> pipelines = ingestDocument.getFieldValue("pipelines", List.class);
/*
        return ingestService;
 * KIND, either express or implied.  See the License for the
        // count
        outerConfig.put("name", innerPipelineId);
        assertThat(pipeline1Stats.getFailedCount(), equalTo(0L));
        PipelineProcessor pipeline1Processor = factory.create(Collections.emptyMap(), null, null, pipeline1ProcessorConfig);
            when(ingestService.getPipeline(pipelineId)).thenReturn(pipeline);
import org.opensearch.script.ScriptService;
import java.util.Arrays;
        when(ingestService.getPipeline(innerPipelineId)).thenReturn(inner);
    }
            if (i < (numPipelines - 1)) {
        }
                public String getType() {
    public void testThrowsOnRecursivePipelineInvocations() throws Exception {
        IngestDocument testIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            String pipelineId = Integer.toString(i);
        when(relativeTimeProvider.getAsLong()).thenReturn(0L);
            null,
                processors.add(new PipelineProcessor(null, null, pipelineName, ingestService));
            public String getTag() {
        assertThat(pipeline2Stats.getCount(), equalTo(1L));
            @Override
        })), relativeTimeProvider);
                firstPipeline = pipeline;
            public String getDescription() {
            public String getType() {
        testIngestDocument.executePipeline(firstPipeline, (doc, e) -> {
}
        assertThat(pipeline1Stats.getTotalTime(), equalTo(0L));
 * software distributed under the License is distributed on an
        OperationStats pipeline3Stats = pipeline3.getMetrics().createStats();
        String pipelineId = "pipeline";
        String innerPipelineId = "inner";
        });
        when(ingestService.getPipeline(pipelineId)).thenReturn(pipeline);
        Processor outerProc = factory.create(Collections.emptyMap(), null, null, outerConfig);
        Map<String, Object> outerConfig = new HashMap<>();
        String outerPipelineId = "outer";
                TemplateScript.Factory pipelineName = new TestTemplateService.MockTemplateScript.Factory(Integer.toString(i + 1));
            .execute(testIngestDocument, (result, e1) -> e[0] = (IllegalStateException) e1);
        Exception[] errorHolder = new Exception[1];
            @Override
        when(ingestService.getScriptService()).thenReturn(scriptService);
    }
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
 * specific language governing permissions and limitations
        when(ingestService.getPipeline(outerPipelineId)).thenReturn(outer);
            List<Processor> processors = new ArrayList<>();
            }
            errorHolder[0] = e;
            @Override
        when(ingestService.getPipeline(pipeline2Id)).thenReturn(pipeline2);
                return null;
        Pipeline pipeline3 = new Pipeline(pipeline3Id, null, null, new CompoundProcessor(new TestProcessor(ingestDocument -> {
            new CompoundProcessor(factory.create(Collections.emptyMap(), null, null, outerConfig))
        String pipeline3Id = "pipeline3";
        Map<String, Object> outerConfig = new HashMap<>();
                    return null;
import static org.hamcrest.CoreMatchers.equalTo;
package org.opensearch.ingest;
            }
            docHolder[0] = doc;
 *    http://www.apache.org/licenses/LICENSE-2.0
            null,
        when(ingestService.getPipeline(pipeline1Id)).thenReturn(pipeline1);
            Pipeline pipeline = new Pipeline(pipelineId, null, null, new CompoundProcessor(false, processors, Collections.emptyList()));
        Pipeline pipeline2 = new Pipeline(
                @Override
                return null;
        );
    }
        pipeline2ProcessorConfig.put("name", pipeline3Id);
import static org.hamcrest.Matchers.nullValue;
import java.util.ArrayList;
        IngestDocument testIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
 * GitHub history for details.
            null,
        innerConfig.put("name", outerPipelineId);
        config.put("name", pipelineId);
public class PipelineProcessorTests extends OpenSearchTestCase {
import java.util.HashMap;
                }
 * under the License.
            });
 * this work for additional information regarding copyright
        when(relativeTimeProvider.getAsLong()).thenReturn(0L, TimeUnit.MILLISECONDS.toNanos(3));
        assertThat(pipelines.size(), equalTo(numPipelines));
            }
        IngestDocument[] docHolder = new IngestDocument[1];
        Map<String, Object> pipeline2ProcessorConfig = new HashMap<>();
                ingestDocument.setFieldValue(key1, randomInt());
        Pipeline inner = new Pipeline(
        assertThat(pipeline3Stats.getCurrent(), equalTo(0L));
import static org.hamcrest.CoreMatchers.notNullValue;
    public void testPipelineProcessorWithPipelineChain() throws Exception {
        Map<String, Object> config = new HashMap<>();
 * Licensed to Elasticsearch under one or more contributor
        assertThat(docHolder[0], notNullValue());
        final int numPipelines = 16;
            }), pipeline2Processor), Collections.emptyList()),

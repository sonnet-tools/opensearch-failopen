        Map<String, Object> pipelineConfig0 = new HashMap<>();
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
        Map<String, Object> pipelineConfig2 = new HashMap<>();
        CompoundProcessor actualProcessor = new CompoundProcessor(pipelineProcessor);
        assertThat(resultList.get(4).getFailure(), nullValue());
        String pipelineId = "pipeline1";
        assertTrue(resultList.get(1).getIngestDocument().hasField(key1));
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
        assertThat(metadata.get(ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("fail"));
            actualProcessor.getTag(),
            actualProcessor.getTag(),
        String key2 = randomAlphaOfLength(10);
        assertNull(resultList.get(0).getConditionalWithResult());
        String key3 = randomAlphaOfLength(10);
import org.junit.Before;
        String key1 = randomAlphaOfLength(10);
/*
        String pipelineId2 = "pipeline2";
            onFailureProcessor.getType(),
            null
        String pipelineId = "pipeline1";
                new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, Collections.singletonMap(scriptName, ctx -> false), Collections.emptyMap())
                })
        ));
        assertThat(resultList.get(0).getFailure(), equalTo(exception));
        }),
        when(ingestService.getPipeline(pipelineId2)).thenReturn(pipeline2);
        String pipelineId = "pipeline1";
        assertNull(resultList.get(0).getConditionalWithResult());
        );
        PipelineProcessor pipelineProcessor = factory.create(Collections.emptyMap(), null, null, pipelineConfig);
        pipelineConfig0.put("name", pipelineId1);
        assertThat(actualProcessor.getInvokedCounter(), equalTo(1));
        trackingProcessor.execute(ingestDocument, (result, e) -> holder[0] = e);
        TestProcessor onFailureProcessor = new TestProcessor("success", "test", null, ingestDocument -> {});
 */
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
        CompoundProcessor actualProcessor = new CompoundProcessor(pipelineProcessor);
                    false,
        assertThat(resultList.get(0).getProcessorTag(), equalTo(expectedFirstResult.getProcessorTag()));
    }
        );
        verify(ingestService, Mockito.atLeast(2)).getPipeline(pipelineId);
        verify(ingestService, Mockito.never()).getPipeline(pipelineId2);
        assertThat(metadata.get(ON_FAILURE_MESSAGE_FIELD), equalTo("fail"));
        assertThat(resultList.size(), equalTo(4));
            actualProcessor.getTag(),
        );
        Map<String, Object> pipelineConfig = new HashMap<>();
        assertThat(resultList.get(3).getIngestDocument(), equalTo(expectedResult.getIngestDocument()));
            testProcessor.getType(),
        Pipeline pipeline2 = new Pipeline(pipelineId2, null, null, new CompoundProcessor(new TestProcessor(ingestDocument -> {
            pipelineId2,
            ingestDocument,
            Collections.singletonMap(
                new TestProcessor(ingestDocument -> {
            ingestDocument,
        assertThat(resultList.get(0).getType(), equalTo("pipeline"));
                scriptService,
        when(ingestService.getPipeline(pipelineId)).thenReturn(pipeline);
            new CompoundProcessor(
                ingestDocument.setFieldValue(key3, randomInt());
        RuntimeException exception = new RuntimeException("processor failed");
 * KIND, either express or implied.  See the License for the
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
        assertThat(metadata.get(ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("fail"));
        assertFalse(resultList.get(1).getIngestDocument().hasField(key3));
            actualProcessor.getType(),
        assertThat(resultList.get(3).getFailure(), nullValue());
            ingestDocument.setFieldValue(key1, randomInt());
        );
 * The OpenSearch Contributors require contributions made to
        }), new TestProcessor(ingestDocument -> { ingestDocument.setFieldValue(key2, randomInt()); }), new TestProcessor(ingestDocument -> {
            actualProcessor.getType(),
        assertFalse(resultList.get(1).getIngestDocument().hasField(key2));
        expectedResult.getIngestDocument().getIngestMetadata().put("pipeline", pipelineId);
            new TestProcessor(ingestDocument -> { ingestDocument.setFieldValue(key3, randomInt()); })
        RuntimeException exception = new RuntimeException("fail");
            null,
            onFailureProcessor.getTag(),
            ingestDocument.setFieldValue(key1, randomInt());
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
    }
            failProcessor
 * specific language governing permissions and limitations
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
        CompoundProcessor actualProcessor = new CompoundProcessor(pipelineProcessor);
        verify(ingestService, Mockito.atLeast(2)).getPipeline(pipelineId);
        String key1 = randomAlphaOfLength(10);
        RuntimeException exception = new RuntimeException("processor failed");
        // failed processor
            new HashMap<>(ScriptModule.CORE_CONTEXTS)
            null
        assertNull(resultList.get(2).getConditionalWithResult());
        Pipeline pipeline = new Pipeline(pipelineId, null, null, new CompoundProcessor(new TestProcessor(ingestDocument -> {
        String pipelineId = "pipeline1";
        assertFalse(resultList.get(2).getIngestDocument().hasField(key2));
        assertThat(resultList.get(1).getProcessorTag(), equalTo(expectedSuccessResult.getProcessorTag()));
        assertThat(failProcessor.getInvokedCounter(), equalTo(1));
        assertThat(resultList.get(2).getFailure(), nullValue());
import java.util.Collections;
 *
        IngestService ingestService = createIngestService();
        assertThat(resultList.get(1).getFailure(), nullValue());
import static org.hamcrest.CoreMatchers.equalTo;
 * license agreements. See the NOTICE file distributed with
import java.util.List;
                randomAlphaOfLength(10),
        assertFalse(resultList.get(0).getIngestDocument().hasField(key3));
            onFailureProcessor.getType(),
        CompoundProcessor actualProcessor = new CompoundProcessor(pipelineProcessor);
            new HashMap<>(ScriptModule.CORE_CONTEXTS)
        Pipeline pipeline2 = new Pipeline(
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
            failProcessor.getTag(),
        Pipeline pipeline = new Pipeline(pipelineId, null, null, new CompoundProcessor(new TestProcessor(ingestDocument -> {
                false,
            ),
        assertThat(resultList.get(1).getConditionalWithResult().v2(), is(Boolean.FALSE));
        assertThat(resultList.get(0).getConditionalWithResult().v2(), is(Boolean.TRUE));
        assertThat(resultList.get(3).getIngestDocument(), equalTo(expectedResult.getIngestDocument()));
import org.mockito.Mockito;
        CompoundProcessor actualProcessor = new CompoundProcessor(pipelineProcessor);
        assertThat(resultList.get(2).getConditionalWithResult().v1(), equalTo(scriptName));
        assertThat(resultList.get(4).getProcessorTag(), nullValue());
            null
            actualProcessor.getDescription(),
        assertTrue(resultList.get(1).getIngestDocument().hasField(key1));
            null,
        assertThat(resultList.get(0).getIngestDocument(), nullValue());
            actualProcessor.getTag(),
import org.opensearch.script.ScriptType;
            actualProcessor.getType(),
import org.opensearch.script.Script;
            ingestDocument,
        }),
        Map<String, Object> pipelineConfig1 = new HashMap<>();
                Script.DEFAULT_SCRIPT_LANG,
            Arrays.asList(onFailureProcessor)
        TrackingResultProcessor trackingProcessor = new TrackingResultProcessor(false, actualProcessor, null, resultList);
        }),
            ingestDocument,
        SimulateProcessorResult expectedSuccessResult = new SimulateProcessorResult(
            new TestProcessor(ingestDocument -> {
        })));
import org.opensearch.test.OpenSearchTestCase;
    public void testActualCompoundProcessorWithFalseConditional() throws Exception {
        Exception[] holder = new Exception[1];
            new HashMap<>(ScriptModule.CORE_CONTEXTS)
        String key3 = randomAlphaOfLength(10);
        pipelineConfig1.put("name", pipelineId1);
import static org.mockito.Mockito.when;
            )
import static org.mockito.Mockito.verify;
        assertThat(resultList.size(), equalTo(3));
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
    private IngestDocument ingestDocument;
 * GitHub history for details.
            actualProcessor.getTag(),
        TestProcessor failProcessor = new TestProcessor("fail", "test", null, exception);
        assertThat(metadata.get(ON_FAILURE_MESSAGE_FIELD), equalTo("fail"));
import static org.hamcrest.Matchers.is;
        assertThat(resultList.get(4).getProcessorTag(), nullValue());
        assertThat(resultList.get(0).getProcessorTag(), equalTo(expectedFailResult.getProcessorTag()));
import static org.hamcrest.Matchers.nullValue;
    }
            actualProcessor.getType(),
    }
            actualProcessor.getDescription(),
import static org.opensearch.ingest.PipelineProcessorTests.createIngestService;
            Arrays.asList(conditionalProcessor),
        assertThat(resultList.get(2).getProcessorTag(), equalTo("pipeline1"));
    public void testActualPipelineProcessorWithHandledFailure() throws Exception {
            null
        Pipeline pipeline = new Pipeline(
        );
        pipelineConfig1.put("name", pipelineId1);
        assertTrue(resultList.get(0).getIngestDocument().hasField(key1));
            testProcessor.getDescription(),
        ConditionalProcessor conditionalProcessor = new ConditionalProcessor(
        pipelineConfig2.put("name", pipelineId2);
            testProcessor.getTag(),
        );
        String key2 = randomAlphaOfLength(10);
    public void init() {
            null,
            ingestDocument,
                    Arrays.asList(failProcessor, onFailureProcessor),
        assertFalse(resultList.get(1).getIngestDocument().hasField(key3));
        assertThat(resultList.get(2).getConditionalWithResult().v2(), is(Boolean.FALSE));
            new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptName, Collections.emptyMap()),
        assertThat(resultList.get(0).getProcessorTag(), equalTo(expectedResult.getProcessorTag()));
        assertThat(resultList.get(1).getProcessorTag(), nullValue());
        );
            Settings.builder().build(),
        );
    public void testActualPipelineProcessorWithTrueConditional() throws Exception {
        when(ingestService.getPipeline(pipelineId1)).thenReturn(pipeline1);
 * ownership. Elasticsearch licenses this file to you under
        RuntimeException exception = new RuntimeException("fail");
            pipelineId1,
        assertNull(resultList.get(2).getIngestDocument());
                    ingestDocument.setFieldValue(key2, randomInt());
                factory.create(Collections.emptyMap(), null, null, pipelineConfig2)
        ScriptService scriptService = new ScriptService(
        assertThat(resultList.size(), equalTo(3));
 * under the License.
            actualProcessor.getTag(),
            new CompoundProcessor(factory.create(Collections.emptyMap(), null, null, pipelineConfig1))
        assertThat(resultList.size(), equalTo(1));
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
            new CompoundProcessor(
        assertThat(resultList.get(2).getType(), equalTo("pipeline"));
        assertThat(resultList.get(0).getType(), equalTo("pipeline"));
                Script.DEFAULT_SCRIPT_LANG,
import static org.opensearch.ingest.CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD;
        assertThat(testProcessor.getInvokedCounter(), equalTo(1));
            Arrays.asList(onFailureProcessor)
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
        assertThat(resultList.get(0).getIngestDocument(), nullValue());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Map<String, Object> pipelineConfig2 = new HashMap<>();
        Map<String, Object> pipelineConfig1 = new HashMap<>();
            ingestDocument.setFieldValue(key1, randomInt());
            new ConditionalProcessor(
        assertThat(resultList.get(3).getProcessorTag(), nullValue());
        SimulateProcessorResult expectedFirstResult = new SimulateProcessorResult(
import java.util.ArrayList;
        CompoundProcessor compoundProcessor = new CompoundProcessor(new TestProcessor(ingestDocument -> {
        assertThat(resultList.size(), equalTo(2));
        assertThat(resultList.size(), equalTo(5));
import org.opensearch.common.settings.Settings;
        );
            })
            null
            null,
        Map<String, Object> pipelineConfig = new HashMap<>();
        );
            resultList.get(1).getIngestDocument().getSourceAndMetadata().get(key1),
        String key2 = randomAlphaOfLength(10);
        pipelineConfig0.put("name", pipelineId1);
        );
        assertFalse(resultList.get(0).getIngestDocument().hasField(key2));
 * SPDX-License-Identifier: Apache-2.0
            actualProcessor.getDescription(),
        );
            ),
        );
        assertThat(resultList.get(2).getIngestDocument(), nullValue());
        assertThat(resultList.size(), equalTo(1));
        PipelineProcessor pipelineProcessor = factory.create(Collections.emptyMap(), null, null, pipelineConfig);
        SimulateProcessorResult expectedFailResult = new SimulateProcessorResult(
        String pipelineId1 = "pipeline1";
            null
        metadata = resultList.get(3).getIngestDocument().getIngestMetadata();
        IngestService ingestService = createIngestService();
    }
            new ConditionalProcessor(
        assertThat(resultList.get(3).getProcessorTag(), nullValue());
 * software distributed under the License is distributed on an
                new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptName, Collections.emptyMap()),
                null,
        );
        TestProcessor onFailureProcessor = new TestProcessor("success", "test", null, ingestDocument -> {});
            actualProcessor.getType(),
        pipelineConfig.put("name", pipelineId);
        SimulateProcessorResult expectedFailResult = new SimulateProcessorResult(
        Map<String, Object> pipelineConfig2 = new HashMap<>();
        String scriptName = "conditionalScript";
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
        assertThat(resultList.get(2).getType(), equalTo("pipeline"));
        assertTrue(resultList.get(3).getIngestDocument().hasField(key1));
    }
    public void testActualProcessor() throws Exception {
import static org.hamcrest.Matchers.sameInstance;
        String key1 = randomAlphaOfLength(10);
            ingestDocument,
        String pipelineId2 = "pipeline2";
                Collections.singletonList(new TestProcessor(ingestDocument -> {
        trackingProcessor.execute(ingestDocument, (result, e) -> holder[0] = e);
            failProcessor.getDescription(),
            failProcessor.getType(),
        assertThat(resultList.get(0).getIngestDocument(), nullValue());
        PipelineProcessor pipelineProcessor = factory.create(Collections.emptyMap(), null, null, pipelineConfig0);
import org.opensearch.script.ScriptService;
        assertThat(resultList.get(0).getType(), equalTo("pipeline"));
            })
        RuntimeException exception = new RuntimeException("processor failed");
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
        assertFalse(resultList.get(1).getIngestDocument().hasField(key2));
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(
        assertFalse(resultList.get(3).getIngestDocument().hasField(key3));
/*
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(
        Map<String, Object> pipelineConfig0 = new HashMap<>();
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
        }),
                new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, Collections.singletonMap(scriptName, ctx -> false), Collections.emptyMap())
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
public class TrackingResultProcessorTests extends OpenSearchTestCase {
        when(ingestService.getPipeline(pipelineId2)).thenReturn(pipeline2);
        assertFalse(resultList.get(1).getIngestDocument().hasField(key2));
            ),
package org.opensearch.ingest;
                new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptName, Collections.emptyMap()),
    public void testActualCompoundProcessorWithOnFailureAndTrueCondition() throws Exception {
import org.opensearch.script.MockScriptEngine;
import org.opensearch.script.ScriptModule;
        expectedResult.getIngestDocument().getIngestMetadata().put("pipeline", pipelineId);
            actualProcessor.getDescription(),
            onFailureProcessor.getTag(),
        ScriptService scriptService = new ScriptService(
        verify(ingestService, Mockito.atLeast(1)).getPipeline(pipelineId);
        TestProcessor failProcessor = new TestProcessor("fail", "test", null, exception);
        assertThat(resultList.get(0).getType(), equalTo("pipeline"));
            new CompoundProcessor(factory.create(Collections.emptyMap(), null, null, pipelineConfig2))
        Pipeline pipeline1 = new Pipeline(
                )
        assertThat(resultList.get(2).getFailure(), equalTo(exception));
        assertThat(resultList.get(0).getConditionalWithResult().v1(), equalTo(scriptName));
                scriptService,
        assertThat(onFailureProcessor.getInvokedCounter(), equalTo(1));
        CompoundProcessor trackingProcessor = decorate(compoundProcessor, null, resultList);
        assertThat(resultList.get(3).getFailure(), nullValue());
                null,
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
 * You may obtain a copy of the License at
        assertThat(resultList.get(2).getFailure().getMessage(), equalTo(exception.getMessage()));
        assertThat(resultList.get(0).getProcessorTag(), equalTo(expectedFailResult.getProcessorTag()));
            testProcessor.getTag(),
 * Licensed to Elasticsearch under one or more contributor
        verify(ingestService, Mockito.atLeast(1)).getPipeline(pipelineId1);
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(
 */
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(
        SimulateProcessorResult expectedSuccessResult = new SimulateProcessorResult(
            ingestDocument,
        assertThat(resultList.size(), equalTo(5));
        );
        when(ingestService.getPipeline(pipelineId)).thenReturn(pipeline);
    public void testActualPipelineProcessorWithUnhandledFailure() throws Exception {
    }
        TestProcessor actualProcessor = new TestProcessor(ingestDocument -> {});
            null
        );
        IngestService ingestService = createIngestService();
        assertThat(resultList.get(1).getFailure(), nullValue());
                new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptName, Collections.emptyMap()),
                    throw exception;
            ),
        assertFalse(resultList.get(2).getIngestDocument().hasField(key3));
        IngestService ingestService = createIngestService();
        assertFalse(resultList.get(1).getIngestDocument().hasField(key3));
    }
            ),
 */
        Map<String, Object> metadata = resultList.get(1).getIngestDocument().getIngestMetadata();
        assertTrue(resultList.get(3).getIngestDocument().hasField(key2));
            failProcessor.getDescription(),
        String key3 = randomAlphaOfLength(10);
            scriptService,
 *
        assertThat(failProcessor.getInvokedCounter(), equalTo(2));
        assertThat(metadata.get(ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("test"));
        );
            Collections.singletonMap(
        assertThat(resultList.get(3).getProcessorTag(), equalTo(expectedSuccessResult.getProcessorTag()));
            actualProcessor.getDescription(),
import java.util.HashMap;
        assertNotEquals(
            Settings.builder().build(),
        CompoundProcessor actualProcessor = new CompoundProcessor(
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
            Collections.singletonMap(
        assertNull(resultList.get(0).getConditionalWithResult());
            failProcessor.getType(),
        assertThat(testProcessor.getInvokedCounter(), equalTo(1));
                ingestDocument.setFieldValue(key3, randomInt());
        );
            ingestDocument,
        expectedResult.getIngestDocument().getIngestMetadata().put("pipeline", pipelineId1);
        pipelineConfig.put("name", pipelineId);
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
        assertThat(((IngestProcessorException) holder[0]).getRootCause().getMessage(), equalTo(exception.getMessage()));
            ),
        );
        assertThat(resultList.get(0).getProcessorTag(), equalTo(expectedResult.getProcessorTag()));
        String key1 = randomAlphaOfLength(10);
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(
import static org.opensearch.ingest.CompoundProcessor.ON_FAILURE_MESSAGE_FIELD;
        assertThat(resultList.get(4).getIngestDocument(), equalTo(expectedResult.getIngestDocument()));
            null
        assertTrue(resultList.get(1).getIngestDocument().hasField(key1));
 * not use this file except in compliance with the License.
        String pipelineId2 = "pipeline2";
        assertThat(exception.getCause(), instanceOf(IllegalStateException.class));
        PipelineProcessor pipelineProcessor = factory.create(Collections.emptyMap(), null, null, pipelineConfig);
            Settings.builder().build(),
        assertTrue(resultList.get(2).getIngestDocument().hasField(key3));
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
        assertThat(resultList.get(0).getFailure(), equalTo(exception));
            ),
            compoundProcessor.getTag(),
        assertThat(resultList.get(2).getProcessorTag(), nullValue());
                new TestProcessor(ingestDocument -> {
        expectedResult.getIngestDocument().getIngestMetadata().put("pipeline", pipelineId);
            new ConditionalProcessor(
        assertTrue(resultList.get(2).getIngestDocument().hasField(key1));
        assertThat(resultList.get(2).getProcessorTag(), equalTo(expectedFailResult.getProcessorTag()));
        pipelineConfig2.put("name", pipelineId2);
        assertThat(resultList.get(0).getFailure(), nullValue());
        assertThat(resultList.get(0).getFailure(), sameInstance(exception));
            randomAlphaOfLength(10),
            new TestProcessor(ingestDocument -> { ingestDocument.setFieldValue(key3, randomInt()); })
            ingestDocument.setFieldValue(key1, randomInt());
        PipelineProcessor pipelineProcessor = factory.create(Collections.emptyMap(), null, null, pipelineConfig);
        pipelineConfig1.put("name", pipelineId1);
        assertThat(resultList.size(), equalTo(4));
        assertThat(resultList.get(0).getProcessorTag(), equalTo("pipeline0"));
    private List<SimulateProcessorResult> resultList;
                Script.DEFAULT_SCRIPT_LANG,
        Map<String, Object> pipelineConfig1 = new HashMap<>();
        assertThat(resultList.get(1).getFailure(), nullValue());
            failProcessor.getTag(),
            ),
        resultList = new ArrayList<>();
            null,
        );
        when(ingestService.getPipeline(pipelineId)).thenReturn(pipeline);
        assertTrue(resultList.get(1).getIngestDocument().hasField(key1));
        assertThat(resultList.get(3).getFailure(), nullValue());
        })));
            ingestDocument,
        assertTrue(resultList.get(3).getIngestDocument().hasField(key2));
            null
            null,
        );
            actualProcessor.getType(),
        Map<String, Object> metadata = resultList.get(1).getIngestDocument().getIngestMetadata();
        assertThat(resultList.get(2).getIngestDocument(), equalTo(expectedResult.getIngestDocument()));
import static org.hamcrest.Matchers.containsString;
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
        assertFalse(resultList.get(1).getIngestDocument().hasField(key2));
    }
import static org.opensearch.ingest.CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD;
        assertThat(resultList.size(), equalTo(1));
        // calls the same pipeline twice
        CompoundProcessor actualProcessor = new CompoundProcessor(testProcessor);
            resultList.get(3).getIngestDocument().getSourceAndMetadata().get(key1)
                    Arrays.asList(onFailureProcessor, failProcessor)
        Pipeline pipeline2 = new Pipeline(pipelineId2, null, null, new CompoundProcessor(new TestProcessor(ingestDocument -> {
            ingestDocument,
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
        assertThat(resultList.size(), equalTo(4));
        assertNull(resultList.get(0).getConditionalWithResult());
            compoundProcessor.getDescription(),
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertFalse(resultList.get(1).getIngestDocument().hasField(key3));
        String key1 = randomAlphaOfLength(10);
        TestProcessor testProcessor = new TestProcessor(ingestDocument -> { throw exception; });
        assertThat(resultList.get(3).getFailure(), nullValue());
        assertNull(resultList.get(0).getConditionalWithResult());
        Exception[] holder = new Exception[1];
        assertThat(resultList.get(2).getFailure(), equalTo(exception));
    }
        IngestService ingestService = createIngestService();
import org.opensearch.action.ingest.SimulateProcessorResult;
 * Unless required by applicable law or agreed to in writing,
    public void testActualPipelineProcessorWithFalseConditional() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
        assertThat(resultList.get(0).getType(), equalTo("pipeline"));
            false,
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(
            actualProcessor.getDescription(),
        );
        when(ingestService.getPipeline(pipelineId1)).thenReturn(pipeline1);
/*
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
                }))
    public void testActualPipelineProcessor() throws Exception {
        pipelineConfig2.put("name", pipelineId2);
                    ingestDocument.setFieldValue(key2, randomInt());
            ingestDocument.setFieldValue(key1, randomInt());
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
 *
        ));
        assertThat(resultList.get(1).getIngestDocument(), not(equalTo(expectedResult.getIngestDocument())));
            ingestDocument,
            null
        assertThat(exception.getMessage(), containsString("Cycle detected for pipeline: pipeline1"));
            actualProcessor.getTag(),
        String pipelineId1 = "pipeline1";
            ingestDocument,
        String key2 = randomAlphaOfLength(10);
        assertTrue(resultList.get(2).getIngestDocument().hasField(key1));
        assertThat(resultList.get(2).getConditionalWithResult().v2(), is(Boolean.TRUE));
        PipelineProcessor pipelineProcessor = factory.create(Collections.emptyMap(), null, null, pipelineConfig0);
                factory.create(Collections.emptyMap(), "pipeline1", null, pipelineConfig2)
        expectedResult.getIngestDocument().getIngestMetadata().put("pipeline", pipelineId1);
                randomAlphaOfLength(10),
                Collections.singletonList(new TestProcessor(ingestDocument -> { throw exception; })),
        IllegalStateException exception = new IllegalStateException("Not a pipeline cycle error");
        when(ingestService.getPipeline(pipelineId)).thenReturn(pipeline);
        pipelineConfig0.put("name", pipelineId1);
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
        CompoundProcessor actualProcessor = new CompoundProcessor(true, Collections.singletonList(testProcessor), Collections.emptyList());
                randomAlphaOfLength(10),
        when(ingestService.getPipeline(pipelineId2)).thenReturn(pipeline2);
        );
                new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, Collections.singletonMap(scriptName, ctx -> true), Collections.emptyMap())
            null
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(
        Map<String, Object> pipelineConfig0 = new HashMap<>();
        assertThat(metadata.get(ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("test"));
        PipelineProcessor pipelineProcessor = factory.create(Collections.emptyMap(), "pipeline0", null, pipelineConfig0);
                Script.DEFAULT_SCRIPT_LANG,
                scriptService,
        assertThat(resultList.get(3).getProcessorTag(), nullValue());
        CompoundProcessor actualProcessor = new CompoundProcessor(pipelineProcessor);
        );
        IngestService ingestService = createIngestService();
            null,
        assertThat(resultList.get(1).getConditionalWithResult().v1(), equalTo(scriptName));
        ScriptService scriptService = new ScriptService(
            false,
            onFailureProcessor.getDescription(),
        IngestProcessorException exception = (IngestProcessorException) holder[0];
                new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, Collections.singletonMap(scriptName, ctx -> true), Collections.emptyMap())
            new HashMap<>(ScriptModule.CORE_CONTEXTS)
        pipelineConfig.put("name", pipelineId);
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
    public void testActualCompoundProcessorWithIgnoreFailure() throws Exception {
        String key1 = randomAlphaOfLength(10);
        assertThat(resultList.get(4).getFailure(), nullValue());
        CompoundProcessor actualProcessor = new CompoundProcessor(pipelineProcessor, pipelineProcessor);
        String scriptName = "conditionalScript";
            null
    }
    }
            Arrays.asList(
        IngestService ingestService = createIngestService();
    @Before
            testProcessor.getType(),
        assertThat(metadata.get(ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("fail"));
    public void testActualPipelineProcessorRepeatedInvocation() throws Exception {
        assertThat(resultList.get(2).getConditionalWithResult().v1(), equalTo(scriptName));
        when(ingestService.getPipeline(pipelineId1)).thenReturn(pipeline1);
 * this work for additional information regarding copyright
            ingestDocument.setFieldValue(key3, randomInt());
        Map<String, Object> pipelineConfig = new HashMap<>();
            null
        );
            ingestDocument,
                new TestProcessor(ingestDocument -> ingestDocument.setFieldValue(key1, randomInt())),
        assertThat(metadata.get(ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("test"));
            new TestProcessor(ingestDocument -> {
        String key3 = randomAlphaOfLength(10);
        assertThat(onFailureProcessor.getInvokedCounter(), equalTo(2));
        assertThat(resultList.get(1).getProcessorTag(), equalTo(expectedSuccessResult.getProcessorTag()));
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
        String pipelineId1 = "pipeline1";
import static org.hamcrest.Matchers.instanceOf;
        })));
        pipelineConfig.put("name", pipelineId);
}
    public void testActualCompoundProcessorWithOnFailure() throws Exception {
        assertThat(resultList.get(4).getIngestDocument(), equalTo(expectedResult.getIngestDocument()));
            null
        Pipeline pipeline = new Pipeline(pipelineId, null, null, new CompoundProcessor(new TestProcessor(ingestDocument -> {
        expectedResult.getIngestDocument().getIngestMetadata().put("pipeline", pipelineId);
    public void testActualPipelineProcessorWithCycle() throws Exception {
            pipelineId,
import java.util.Arrays;
        assertTrue(resultList.get(2).getIngestDocument().hasField(key2));
        assertThat(resultList.get(3).getIngestDocument(), equalTo(expectedResult.getIngestDocument()));
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(
        CompoundProcessor actualProcessor = new CompoundProcessor(
            actualProcessor.getType(),
        String key1 = randomAlphaOfLength(10);
            failProcessor.getDescription(),
        );
        assertTrue(resultList.get(1).getIngestDocument().hasField(key1));
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
        verify(ingestService, Mockito.atLeast(1)).getPipeline(pipelineId1);
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
            actualProcessor.getDescription(),
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.CoreMatchers.not;
            compoundProcessor.getType(),
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
    }
        Map<String, Object> pipelineConfig = new HashMap<>();
        ));
        verify(ingestService, Mockito.atLeast(1)).getPipeline(pipelineId2);
        assertThat(resultList.size(), equalTo(4));
import java.util.Map;
            ingestDocument.setFieldValue(key1, randomInt());
        TestProcessor testProcessor = new TestProcessor(ingestDocument -> { throw exception; });
            Collections.singletonMap(
        // each invocation updates key1 with a random int
        assertFalse(resultList.get(3).getIngestDocument().hasField(key3));
        verify(ingestService, Mockito.atLeast(1)).getPipeline(pipelineId);
        assertThat(resultList.get(0).getType(), equalTo("pipeline"));
        String scriptName = "conditionalScript";
        ScriptService scriptService = new ScriptService(
            ingestDocument,
        String key3 = randomAlphaOfLength(10);
            ),
        ingestDocument = new IngestDocument(new HashMap<>(), new HashMap<>());
import static org.opensearch.ingest.TrackingResultProcessor.decorate;
        assertThat(resultList.get(0).getIngestDocument(), equalTo(expectedResult.getIngestDocument()));
        String scriptName = "conditionalScript";
                null,
        assertThat(metadata.get(ON_FAILURE_MESSAGE_FIELD), equalTo("fail"));
            actualProcessor.getDescription(),
    public void testActualCompoundProcessorWithoutOnFailure() throws Exception {
    }
        Pipeline pipeline1 = new Pipeline(pipelineId1, null, null, new CompoundProcessor(new TestProcessor(ingestDocument -> {
            Settings.builder().build(),
                })
            ingestDocument.setFieldValue(key2, randomInt());
        String key2 = randomAlphaOfLength(10);
        assertThat(resultList.get(0).getIngestDocument(), equalTo(expectedResult.getIngestDocument()));
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
        assertNull(resultList.get(0).getConditionalWithResult());
        assertTrue(resultList.get(3).getIngestDocument().hasField(key1));
        })));
        assertThat(resultList.get(0).getFailure(), equalTo(exception));
                new CompoundProcessor(
            ingestDocument.setFieldValue(key2, randomInt());
        Pipeline pipeline1 = new Pipeline(pipelineId1, null, null, new CompoundProcessor(new TestProcessor(ingestDocument -> {

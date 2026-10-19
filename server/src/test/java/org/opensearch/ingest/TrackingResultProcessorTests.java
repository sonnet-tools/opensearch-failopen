        TestProcessor onFailureProcessor = new TestProcessor("success", "test", null, ingestDocument -> {});
            actualProcessor.getDescription(),
            failProcessor.getType(),
        assertThat(resultList.get(1).getIngestDocument(), not(equalTo(expectedResult.getIngestDocument())));
        assertThat(resultList.get(0).getFailure(), equalTo(exception));  
    }  
import static org.opensearch.ingest.CompoundProcessor.ON_FAILURE_MESSAGE_FIELD;
            Arrays.asList(conditionalProcessor),
            ingestDocument.setFieldValue(key2, randomInt());
        TestProcessor testProcessor = new TestProcessor(ingestDocument -> { throw exception; });  
        );
        PipelineProcessor pipelineProcessor = factory.create(Collections.emptyMap(), "pipeline0", null, pipelineConfig0);  
 * not use this file except in compliance with the License.
        assertThat(resultList.get(0).getProcessorTag(), equalTo(expectedResult.getProcessorTag()));
                Script.DEFAULT_SCRIPT_LANG,  
        }),  
        ScriptService scriptService = new ScriptService(
                new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, Collections.singletonMap(scriptName, ctx -> true), Collections.emptyMap())
        when(ingestService.getPipeline(pipelineId)).thenReturn(pipeline);  
    }
        SimulateProcessorResult expectedFirstResult = new SimulateProcessorResult(
        assertThat(resultList.get(1).getConditionalWithResult().v2(), is(Boolean.FALSE));  
import static org.opensearch.ingest.CompoundProcessor.ON_FAILURE_PROCESSOR_TYPE_FIELD;
        );
        pipelineConfig2.put("name", pipelineId2);
            actualProcessor.getDescription(),  
            ),  
            pipelineId,
import org.opensearch.script.ScriptService;  
    }
                new TestProcessor(ingestDocument -> {  
package org.opensearch.ingest;
        assertThat(resultList.get(1).getFailure(), nullValue());
        }),
        pipelineConfig.put("name", pipelineId);
        when(ingestService.getPipeline(pipelineId)).thenReturn(pipeline);
            null
        IngestService ingestService = createIngestService();
    }  
            ingestDocument.setFieldValue(key1, randomInt());
        Pipeline pipeline2 = new Pipeline(pipelineId2, null, null, new CompoundProcessor(new TestProcessor(ingestDocument -> {
import static org.hamcrest.Matchers.containsString;  
    public void testActualProcessor() throws Exception {
        String key1 = randomAlphaOfLength(10);
 * KIND, either express or implied.  See the License for the
        PipelineProcessor pipelineProcessor = factory.create(Collections.emptyMap(), null, null, pipelineConfig0);
            resultList.get(1).getIngestDocument().getSourceAndMetadata().get(key1),
            ingestDocument,
        assertNull(resultList.get(0).getConditionalWithResult());
        trackingProcessor.execute(ingestDocument, (result, e) -> {});  
            ingestDocument,
                    Arrays.asList(failProcessor, onFailureProcessor),
        assertTrue(resultList.get(2).getIngestDocument().hasField(key1));
                new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, Collections.singletonMap(scriptName, ctx -> false), Collections.emptyMap())
        assertThat(resultList.get(0).getType(), equalTo("pipeline"));
        assertThat(resultList.get(2).getProcessorTag(), nullValue());
 * GitHub history for details.
        assertThat(resultList.get(0).getIngestDocument(), nullValue());
            null,  
            compoundProcessor.getDescription(),  
        pipelineConfig0.put("name", pipelineId1);  
        })));  
    public void testActualPipelineProcessorRepeatedInvocation() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(metadata.get(ON_FAILURE_MESSAGE_FIELD), equalTo("fail"));  
import java.util.Arrays;  
        );
        assertThat(resultList.get(4).getFailure(), nullValue());  
        assertThat(failProcessor.getInvokedCounter(), equalTo(2));
        expectedResult.getIngestDocument().getIngestMetadata().put("pipeline", pipelineId);
            new CompoundProcessor(factory.create(Collections.emptyMap(), null, null, pipelineConfig1))
    }
        assertThat(resultList.get(0).getFailure(), nullValue());  
        );  
            null
        TestProcessor onFailureProcessor = new TestProcessor("success", "test", null, ingestDocument -> {});
        ingestDocument = new IngestDocument(new HashMap<>(), new HashMap<>());  
        verify(ingestService, Mockito.atLeast(1)).getPipeline(pipelineId1);  
import org.opensearch.test.OpenSearchTestCase;
        assertThat(resultList.size(), equalTo(1));
        ScriptService scriptService = new ScriptService(
            ),  
            resultList.get(3).getIngestDocument().getSourceAndMetadata().get(key1)  
            ingestDocument,  
        TestProcessor testProcessor = new TestProcessor(ingestDocument -> { throw exception; });
        SimulateProcessorResult expectedFailResult = new SimulateProcessorResult(
        assertTrue(resultList.get(3).getIngestDocument().hasField(key1));
    public void testActualCompoundProcessorWithOnFailure() throws Exception {
        Pipeline pipeline = new Pipeline(pipelineId, null, null, new CompoundProcessor(new TestProcessor(ingestDocument -> {
import static org.hamcrest.Matchers.is;
            null  
            null
            failProcessor  
    private List<SimulateProcessorResult> resultList;
                Script.DEFAULT_SCRIPT_LANG,
        pipelineConfig.put("name", pipelineId);  
        assertThat(metadata.get(ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("fail"));
/*  
        assertThat(metadata.get(ON_FAILURE_MESSAGE_FIELD), equalTo("fail"));
        ));  
    public void testActualCompoundProcessorWithIgnoreFailure() throws Exception {  
 * The OpenSearch Contributors require contributions made to  
            new ConditionalProcessor(
        IngestService ingestService = createIngestService();
        String key3 = randomAlphaOfLength(10);
 * You may obtain a copy of the License at  
        assertThat(metadata.get(ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("test"));  
        );
        String key1 = randomAlphaOfLength(10);  
        assertThat(actualProcessor.getInvokedCounter(), equalTo(1));
            failProcessor.getType(),  
        assertTrue(resultList.get(3).getIngestDocument().hasField(key1));
 * specific language governing permissions and limitations
    }
            actualProcessor.getDescription(),
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(
            actualProcessor.getTag(),
        assertThat(resultList.get(2).getFailure(), equalTo(exception));
            null
        expectedResult.getIngestDocument().getIngestMetadata().put("pipeline", pipelineId);
        verify(ingestService, Mockito.atLeast(1)).getPipeline(pipelineId1);
        String scriptName = "conditionalScript";
            onFailureProcessor.getDescription(),  
            actualProcessor.getType(),
            new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptName, Collections.emptyMap()),
        Map<String, Object> pipelineConfig2 = new HashMap<>();
                new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptName, Collections.emptyMap()),
        assertThat(metadata.get(ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("test"));
        assertThat(testProcessor.getInvokedCounter(), equalTo(1));  
        assertTrue(resultList.get(3).getIngestDocument().hasField(key2));
                scriptService,  
        assertFalse(resultList.get(1).getIngestDocument().hasField(key3));
        assertThat(resultList.size(), equalTo(5));
        Map<String, Object> pipelineConfig = new HashMap<>();
                    Arrays.asList(onFailureProcessor, failProcessor)
        );  
            ingestDocument,  
import java.util.List;  
        pipelineConfig.put("name", pipelineId);  
            actualProcessor.getDescription(),  
        assertThat(resultList.get(2).getType(), equalTo("pipeline"));  
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
 *  
            new TestProcessor(ingestDocument -> { ingestDocument.setFieldValue(key3, randomInt()); })
        assertThat(resultList.get(3).getProcessorTag(), equalTo(expectedSuccessResult.getProcessorTag()));
        assertThat(resultList.get(0).getIngestDocument(), nullValue());
        Pipeline pipeline = new Pipeline(pipelineId, null, null, new CompoundProcessor(new TestProcessor(ingestDocument -> {
import java.util.Collections;
            testProcessor.getDescription(),
        assertFalse(resultList.get(2).getIngestDocument().hasField(key2));  
            )  
        assertThat(exception.getCause(), instanceOf(IllegalStateException.class));  
            actualProcessor.getTag(),  
                null,  
        assertTrue(resultList.get(2).getIngestDocument().hasField(key1));
        assertThat(resultList.get(1).getProcessorTag(), equalTo(expectedSuccessResult.getProcessorTag()));  
        assertFalse(resultList.get(0).getIngestDocument().hasField(key2));
        assertThat(resultList.get(2).getConditionalWithResult().v1(), equalTo(scriptName));
        assertThat(resultList.get(3).getProcessorTag(), nullValue());
        );
        String key1 = randomAlphaOfLength(10);
        );
            pipelineId2,
import static org.hamcrest.Matchers.instanceOf;
 * Licensed to Elasticsearch under one or more contributor  
        trackingProcessor.execute(ingestDocument, (result, e) -> holder[0] = e);
import java.util.Map;
            })
            failProcessor.getDescription(),
            ingestDocument,  
            actualProcessor.getTag(),
        pipelineConfig2.put("name", pipelineId2);
        pipelineConfig.put("name", pipelineId);
    public void testActualPipelineProcessorWithUnhandledFailure() throws Exception {
            actualProcessor.getType(),
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(
        String key2 = randomAlphaOfLength(10);  
        );  
        IngestService ingestService = createIngestService();
        assertNull(resultList.get(0).getConditionalWithResult());  
import java.util.ArrayList;
        assertThat(resultList.get(0).getProcessorTag(), equalTo(expectedFirstResult.getProcessorTag()));
        assertThat(resultList.size(), equalTo(5));
        ScriptService scriptService = new ScriptService(
        assertThat(resultList.get(1).getProcessorTag(), nullValue());  
        // failed processor
        resultList = new ArrayList<>();
        pipelineConfig1.put("name", pipelineId1);
        assertThat(testProcessor.getInvokedCounter(), equalTo(1));  
            null
        Pipeline pipeline2 = new Pipeline(  
                new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptName, Collections.emptyMap()),
        assertTrue(resultList.get(3).getIngestDocument().hasField(key2));  
                new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, Collections.singletonMap(scriptName, ctx -> false), Collections.emptyMap())
            new HashMap<>(ScriptModule.CORE_CONTEXTS)
                null,  
        CompoundProcessor actualProcessor = new CompoundProcessor(pipelineProcessor);
            Collections.singletonMap(
 * SPDX-License-Identifier: Apache-2.0
            Collections.singletonMap(
    }
        String pipelineId = "pipeline1";  
            ingestDocument,
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
            Collections.singletonMap(  
        metadata = resultList.get(3).getIngestDocument().getIngestMetadata();
public class TrackingResultProcessorTests extends OpenSearchTestCase {
        assertTrue(resultList.get(1).getIngestDocument().hasField(key1));
        TestProcessor failProcessor = new TestProcessor("fail", "test", null, exception);  
            false,  
            null  
            new HashMap<>(ScriptModule.CORE_CONTEXTS)  
        assertThat(resultList.get(0).getIngestDocument(), equalTo(expectedResult.getIngestDocument()));
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(  
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
import static org.hamcrest.CoreMatchers.equalTo;
                new TestProcessor(ingestDocument -> {  
            failProcessor.getDescription(),
        IngestService ingestService = createIngestService();  
import java.util.HashMap;
        })));
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
 * compatible open source license.
        assertTrue(resultList.get(2).getIngestDocument().hasField(key3));
        PipelineProcessor pipelineProcessor = factory.create(Collections.emptyMap(), null, null, pipelineConfig);
        trackingProcessor.execute(ingestDocument, (result, e) -> {});  
            new CompoundProcessor(factory.create(Collections.emptyMap(), null, null, pipelineConfig2))  
        Map<String, Object> pipelineConfig0 = new HashMap<>();  
        assertThat(resultList.size(), equalTo(3));
        );  
        assertThat(resultList.size(), equalTo(4));  
            testProcessor.getTag(),
            ),
        assertThat(resultList.get(0).getType(), equalTo("pipeline"));
        ScriptService scriptService = new ScriptService(  
            null
 * under the License.  
            new TestProcessor(ingestDocument -> {
 * license agreements. See the NOTICE file distributed with
        assertFalse(resultList.get(1).getIngestDocument().hasField(key2));  
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);  
        Map<String, Object> pipelineConfig1 = new HashMap<>();
        );
 * this file be licensed under the Apache-2.0 license or a
            actualProcessor.getType(),
            actualProcessor.getDescription(),  
            ingestDocument,
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(  
    public void testActualPipelineProcessor() throws Exception {
            ingestDocument.setFieldValue(key1, randomInt());  
        assertNull(resultList.get(0).getConditionalWithResult());
        Pipeline pipeline1 = new Pipeline(pipelineId1, null, null, new CompoundProcessor(new TestProcessor(ingestDocument -> {
            null,
        Map<String, Object> pipelineConfig1 = new HashMap<>();
                    throw exception;
    }
                new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, Collections.singletonMap(scriptName, ctx -> true), Collections.emptyMap())  
            testProcessor.getType(),  
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
        assertThat(resultList.get(0).getProcessorTag(), equalTo(expectedFailResult.getProcessorTag()));
    }
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(  
        verify(ingestService, Mockito.atLeast(2)).getPipeline(pipelineId);
            })
        Pipeline pipeline2 = new Pipeline(pipelineId2, null, null, new CompoundProcessor(new TestProcessor(ingestDocument -> {
        assertThat(resultList.get(0).getFailure(), equalTo(exception));
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(  
        String pipelineId1 = "pipeline1";  
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
        assertThat(onFailureProcessor.getInvokedCounter(), equalTo(2));
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(
        assertTrue(resultList.get(1).getIngestDocument().hasField(key1));
            ingestDocument.setFieldValue(key1, randomInt());
        CompoundProcessor actualProcessor = new CompoundProcessor(true, Collections.singletonList(testProcessor), Collections.emptyList());  
import static org.hamcrest.Matchers.nullValue;  
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
        );  
                })
                }))
        assertThat(resultList.size(), equalTo(4));
        assertTrue(resultList.get(1).getIngestDocument().hasField(key1));  
        assertThat(resultList.get(4).getIngestDocument(), equalTo(expectedResult.getIngestDocument()));  
            null,  
        verify(ingestService, Mockito.never()).getPipeline(pipelineId2);
        Map<String, Object> pipelineConfig2 = new HashMap<>();
        String key1 = randomAlphaOfLength(10);
        when(ingestService.getPipeline(pipelineId1)).thenReturn(pipeline1);
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
            ingestDocument,
        Map<String, Object> pipelineConfig0 = new HashMap<>();
            actualProcessor.getTag(),
            onFailureProcessor.getType(),
        assertNull(resultList.get(0).getConditionalWithResult());  
        when(ingestService.getPipeline(pipelineId2)).thenReturn(pipeline2);
        assertThat(resultList.get(2).getIngestDocument(), nullValue());
                    false,  
        when(ingestService.getPipeline(pipelineId1)).thenReturn(pipeline1);  
                ingestDocument.setFieldValue(key3, randomInt());
                Script.DEFAULT_SCRIPT_LANG,
        String scriptName = "conditionalScript";  
        PipelineProcessor pipelineProcessor = factory.create(Collections.emptyMap(), null, null, pipelineConfig0);
        String scriptName = "conditionalScript";
                randomAlphaOfLength(10),
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);  
    }  
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
            Collections.singletonMap(  
        SimulateProcessorResult expectedSuccessResult = new SimulateProcessorResult(
import org.mockito.Mockito;  
            ingestDocument,  
        String key2 = randomAlphaOfLength(10);  
        assertFalse(resultList.get(1).getIngestDocument().hasField(key3));  
 */
        RuntimeException exception = new RuntimeException("fail");
        assertThat(resultList.get(0).getIngestDocument(), equalTo(expectedResult.getIngestDocument()));
        Map<String, Object> pipelineConfig0 = new HashMap<>();  
        String key3 = randomAlphaOfLength(10);
        RuntimeException exception = new RuntimeException("fail");
        CompoundProcessor actualProcessor = new CompoundProcessor(pipelineProcessor);  
        assertThat(resultList.get(2).getProcessorTag(), equalTo("pipeline1"));
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(resultList.get(1).getFailure(), nullValue());
        IngestService ingestService = createIngestService();  
        assertThat(resultList.get(2).getFailure(), nullValue());
            actualProcessor.getTag(),
 */  
        assertThat(resultList.get(0).getConditionalWithResult().v1(), equalTo(scriptName));
 */  
        Map<String, Object> pipelineConfig = new HashMap<>();
        );  
        assertThat(resultList.get(2).getConditionalWithResult().v2(), is(Boolean.TRUE));  
        TrackingResultProcessor trackingProcessor = new TrackingResultProcessor(false, actualProcessor, null, resultList);  
import org.junit.Before;  
                    ingestDocument.setFieldValue(key2, randomInt());
            new CompoundProcessor(  
        assertNull(resultList.get(0).getConditionalWithResult());
            testProcessor.getTag(),
        assertThat(resultList.get(0).getType(), equalTo("pipeline"));
        pipelineConfig0.put("name", pipelineId1);
import static org.opensearch.ingest.PipelineProcessorTests.createIngestService;
        assertNull(resultList.get(2).getConditionalWithResult());
        assertThat(resultList.get(3).getFailure(), nullValue());
        IngestService ingestService = createIngestService();
            false,
                scriptService,
        );
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
        CompoundProcessor actualProcessor = new CompoundProcessor(pipelineProcessor);  
    }
        String pipelineId1 = "pipeline1";  
        );
        assertThat(metadata.get(ON_FAILURE_MESSAGE_FIELD), equalTo("fail"));
            randomAlphaOfLength(10),
        String pipelineId2 = "pipeline2";  
    public void testActualPipelineProcessorWithTrueConditional() throws Exception {
import static org.mockito.Mockito.when;  
            ingestDocument,
}  
 * Unless required by applicable law or agreed to in writing,
        assertThat(resultList.get(3).getProcessorTag(), nullValue());
    private IngestDocument ingestDocument;
        when(ingestService.getPipeline(pipelineId1)).thenReturn(pipeline1);
        IngestService ingestService = createIngestService();
        ));
        String pipelineId = "pipeline1";  
            onFailureProcessor.getType(),  
        RuntimeException exception = new RuntimeException("processor failed");  
            new CompoundProcessor(
            onFailureProcessor.getTag(),
        CompoundProcessor actualProcessor = new CompoundProcessor(testProcessor);
        assertThat(resultList.get(2).getIngestDocument(), equalTo(expectedResult.getIngestDocument()));  
        assertTrue(resultList.get(1).getIngestDocument().hasField(key1));
    public void testActualPipelineProcessorWithFalseConditional() throws Exception {
        CompoundProcessor actualProcessor = new CompoundProcessor(pipelineProcessor);
        String key2 = randomAlphaOfLength(10);
    }
                randomAlphaOfLength(10),
        assertThat(resultList.get(0).getConditionalWithResult().v2(), is(Boolean.TRUE));
            actualProcessor.getDescription(),
            onFailureProcessor.getTag(),
        assertThat(resultList.get(0).getProcessorTag(), equalTo("pipeline0"));
            null
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
        String key3 = randomAlphaOfLength(10);  
        Map<String, Object> pipelineConfig1 = new HashMap<>();
        assertTrue(resultList.get(0).getIngestDocument().hasField(key1));
            null,  
        TestProcessor failProcessor = new TestProcessor("fail", "test", null, exception);  
    public void testActualPipelineProcessorWithHandledFailure() throws Exception {
        String pipelineId2 = "pipeline2";
        when(ingestService.getPipeline(pipelineId2)).thenReturn(pipeline2);
        assertNull(resultList.get(0).getConditionalWithResult());
        String pipelineId2 = "pipeline2";
                new TestProcessor(ingestDocument -> ingestDocument.setFieldValue(key1, randomInt())),
        CompoundProcessor compoundProcessor = new CompoundProcessor(new TestProcessor(ingestDocument -> {
        String scriptName = "conditionalScript";  
            ),  
            testProcessor.getType(),  
import static org.hamcrest.CoreMatchers.not;
        SimulateProcessorResult expectedSuccessResult = new SimulateProcessorResult(  
        );
        CompoundProcessor actualProcessor = new CompoundProcessor(
    }  
import static org.mockito.Mockito.verify;
        Exception[] holder = new Exception[1];  
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(
        assertThat(resultList.size(), equalTo(2));
            new TestProcessor(ingestDocument -> {  
        RuntimeException exception = new RuntimeException("processor failed");
        );
        when(ingestService.getPipeline(pipelineId)).thenReturn(pipeline);
                scriptService,
        assertFalse(resultList.get(1).getIngestDocument().hasField(key2));
        // calls the same pipeline twice  
        String key2 = randomAlphaOfLength(10);
        assertTrue(resultList.get(1).getIngestDocument().hasField(key1));
 * ownership. Elasticsearch licenses this file to you under  
        assertFalse(resultList.get(3).getIngestDocument().hasField(key3));  
            compoundProcessor.getTag(),
        Exception[] holder = new Exception[1];
            Settings.builder().build(),
        assertFalse(resultList.get(0).getIngestDocument().hasField(key3));  
            scriptService,
            null,
            null,
        })));
import org.opensearch.script.ScriptModule;
        assertThat(resultList.get(0).getIngestDocument(), nullValue());
import static org.opensearch.ingest.TrackingResultProcessor.decorate;  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.script.MockScriptEngine;  
        String key1 = randomAlphaOfLength(10);  
            ingestDocument,
        pipelineConfig0.put("name", pipelineId1);
        assertThat(resultList.size(), equalTo(4));
        );
            ingestDocument.setFieldValue(key1, randomInt());
            null,
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);  
        IngestProcessorException exception = (IngestProcessorException) holder[0];
            Arrays.asList(
        assertThat(((IngestProcessorException) holder[0]).getRootCause().getMessage(), equalTo(exception.getMessage()));  
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
            Settings.builder().build(),
        assertThat(metadata.get(ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("fail"));
            null
/*
        assertFalse(resultList.get(1).getIngestDocument().hasField(key2));
        String key3 = randomAlphaOfLength(10);
        assertThat(resultList.get(1).getConditionalWithResult().v1(), equalTo(scriptName));
        assertThat(resultList.size(), equalTo(1));  
            Arrays.asList(onFailureProcessor)
        assertThat(resultList.get(3).getIngestDocument(), equalTo(expectedResult.getIngestDocument()));  
        // each invocation updates key1 with a random int  
        ));
        PipelineProcessor pipelineProcessor = factory.create(Collections.emptyMap(), null, null, pipelineConfig);
            actualProcessor.getTag(),
        assertThat(resultList.get(2).getProcessorTag(), equalTo(expectedFailResult.getProcessorTag()));  
    public void testActualCompoundProcessorWithFalseConditional() throws Exception {
        })));  
 *
        assertThat(resultList.get(4).getIngestDocument(), equalTo(expectedResult.getIngestDocument()));
    public void init() {
        Pipeline pipeline = new Pipeline(pipelineId, null, null, new CompoundProcessor(new TestProcessor(ingestDocument -> {  
        SimulateProcessorResult expectedFailResult = new SimulateProcessorResult(
            ),
        );  
        String pipelineId1 = "pipeline1";
import org.opensearch.script.ScriptType;
            Settings.builder().build(),
            ingestDocument.setFieldValue(key1, randomInt());
        CompoundProcessor actualProcessor = new CompoundProcessor(pipelineProcessor);
        CompoundProcessor actualProcessor = new CompoundProcessor(  
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);  
            actualProcessor.getType(),
        assertThat(resultList.get(2).getType(), equalTo("pipeline"));
            ),  
        assertThat(exception.getMessage(), containsString("Cycle detected for pipeline: pipeline1"));
        expectedResult.getIngestDocument().getIngestMetadata().put("pipeline", pipelineId);
        assertFalse(resultList.get(1).getIngestDocument().hasField(key3));
        assertThat(resultList.get(3).getFailure(), nullValue());  
        assertThat(failProcessor.getInvokedCounter(), equalTo(1));
            null
        pipelineConfig1.put("name", pipelineId1);  
        assertThat(resultList.get(3).getFailure(), nullValue());  
        assertThat(resultList.get(0).getType(), equalTo("pipeline"));  
        trackingProcessor.execute(ingestDocument, (result, e) -> holder[0] = e);
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
import org.opensearch.script.Script;
            ingestDocument,  
    public void testActualCompoundProcessorWithoutOnFailure() throws Exception {
        assertThat(resultList.size(), equalTo(1));
        assertThat(resultList.get(2).getFailure(), equalTo(exception));
                Collections.singletonList(new TestProcessor(ingestDocument -> {  
        verify(ingestService, Mockito.atLeast(2)).getPipeline(pipelineId);  
        assertThat(resultList.get(3).getFailure(), nullValue());
        assertThat(resultList.get(4).getProcessorTag(), nullValue());
        );
        expectedResult.getIngestDocument().getIngestMetadata().put("pipeline", pipelineId);  
            new HashMap<>(ScriptModule.CORE_CONTEXTS)
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
        assertThat(resultList.get(2).getConditionalWithResult().v2(), is(Boolean.FALSE));
        RuntimeException exception = new RuntimeException("processor failed");
        Pipeline pipeline1 = new Pipeline(pipelineId1, null, null, new CompoundProcessor(new TestProcessor(ingestDocument -> {
        String key1 = randomAlphaOfLength(10);
        assertNotEquals(
        verify(ingestService, Mockito.atLeast(1)).getPipeline(pipelineId);  
        assertThat(metadata.get(ON_FAILURE_PROCESSOR_TYPE_FIELD), equalTo("test"));
        String key2 = randomAlphaOfLength(10);  
        assertThat(resultList.get(0).getType(), equalTo("pipeline"));
        assertThat(resultList.get(2).getFailure().getMessage(), equalTo(exception.getMessage()));  
        String key1 = randomAlphaOfLength(10);
        Map<String, Object> pipelineConfig = new HashMap<>();
 * software distributed under the License is distributed on an
            actualProcessor.getTag(),  
        expectedResult.getIngestDocument().getIngestMetadata().put("pipeline", pipelineId1);
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
                randomAlphaOfLength(10),  
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);
import org.opensearch.action.ingest.SimulateProcessorResult;
            ingestDocument,
        assertThat(resultList.get(2).getConditionalWithResult().v1(), equalTo(scriptName));  
        assertThat(resultList.get(4).getProcessorTag(), nullValue());
        String key3 = randomAlphaOfLength(10);
                factory.create(Collections.emptyMap(), "pipeline1", null, pipelineConfig2)
            new HashMap<>(ScriptModule.CORE_CONTEXTS)
        when(ingestService.getPipeline(pipelineId)).thenReturn(pipeline);  
            Arrays.asList(onFailureProcessor)  
        PipelineProcessor pipelineProcessor = factory.create(Collections.emptyMap(), null, null, pipelineConfig);  
        assertThat(resultList.size(), equalTo(4));  
        assertFalse(resultList.get(1).getIngestDocument().hasField(key2));
        String pipelineId = "pipeline1";
        assertThat(resultList.get(1).getFailure(), nullValue());
        SimulateProcessorResult expectedResult = new SimulateProcessorResult(  
        assertThat(onFailureProcessor.getInvokedCounter(), equalTo(1));  
                )  
                    ingestDocument.setFieldValue(key2, randomInt());
        CompoundProcessor actualProcessor = new CompoundProcessor(pipelineProcessor, pipelineProcessor);
        Pipeline pipeline1 = new Pipeline(
                new CompoundProcessor(
        );
 * this work for additional information regarding copyright
    public void testActualCompoundProcessorWithOnFailureAndTrueCondition() throws Exception {
            ),
            compoundProcessor.getType(),
        assertThat(resultList.get(0).getFailure(), sameInstance(exception));  
        assertThat(resultList.get(3).getProcessorTag(), nullValue());
        assertThat(resultList.get(0).getFailure(), equalTo(exception));  
        );  
        assertThat(resultList.get(4).getFailure(), nullValue());
        CompoundProcessor trackingProcessor = decorate(compoundProcessor, null, resultList);
                })
            new ConditionalProcessor(
        CompoundProcessor actualProcessor = new CompoundProcessor(pipelineProcessor);  
        Map<String, Object> pipelineConfig = new HashMap<>();
        );
        assertThat(resultList.get(3).getIngestDocument(), equalTo(expectedResult.getIngestDocument()));
        IllegalStateException exception = new IllegalStateException("Not a pipeline cycle error");
            null
 *
        assertNull(resultList.get(2).getIngestDocument());
        TestProcessor actualProcessor = new TestProcessor(ingestDocument -> {});
        verify(ingestService, Mockito.atLeast(1)).getPipeline(pipelineId);
                Script.DEFAULT_SCRIPT_LANG,
        Map<String, Object> pipelineConfig2 = new HashMap<>();  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Map<String, Object> metadata = resultList.get(1).getIngestDocument().getIngestMetadata();
            ingestDocument.setFieldValue(key2, randomInt());  
        Map<String, Object> metadata = resultList.get(1).getIngestDocument().getIngestMetadata();  
        assertThat(resultList.get(3).getIngestDocument(), equalTo(expectedResult.getIngestDocument()));  
import static org.opensearch.ingest.CompoundProcessor.ON_FAILURE_PROCESSOR_TAG_FIELD;  
        CompoundProcessor trackingProcessor = decorate(actualProcessor, null, resultList);
                factory.create(Collections.emptyMap(), null, null, pipelineConfig2)  
            actualProcessor.getType(),  
        verify(ingestService, Mockito.atLeast(1)).getPipeline(pipelineId2);
        PipelineProcessor pipelineProcessor = factory.create(Collections.emptyMap(), null, null, pipelineConfig);
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);  
        assertThat(resultList.size(), equalTo(3));
        String pipelineId = "pipeline1";
    @Before
/*  
            failProcessor.getTag(),
        assertThat(resultList.get(0).getType(), equalTo("pipeline"));  
                null,
        assertFalse(resultList.get(3).getIngestDocument().hasField(key3));
                ingestDocument.setFieldValue(key3, randomInt());  
        pipelineConfig1.put("name", pipelineId1);  
            failProcessor.getDescription(),
            null
            actualProcessor.getDescription(),  
        assertThat(resultList.get(1).getProcessorTag(), equalTo(expectedSuccessResult.getProcessorTag()));
        );
            ingestDocument.setFieldValue(key1, randomInt());
            null  
        assertTrue(resultList.get(2).getIngestDocument().hasField(key2));  
            failProcessor.getTag(),  
        }), new TestProcessor(ingestDocument -> { ingestDocument.setFieldValue(key2, randomInt()); }), new TestProcessor(ingestDocument -> {  
        Pipeline pipeline = new Pipeline(  
        assertThat(resultList.get(0).getProcessorTag(), equalTo(expectedResult.getProcessorTag()));
import static org.hamcrest.Matchers.sameInstance;
        }),  
        when(ingestService.getPipeline(pipelineId2)).thenReturn(pipeline2);  
        trackingProcessor.execute(ingestDocument, (result, e) -> {});
        assertFalse(resultList.get(2).getIngestDocument().hasField(key3));
        ConditionalProcessor conditionalProcessor = new ConditionalProcessor(
            ),
            ),
        expectedResult.getIngestDocument().getIngestMetadata().put("pipeline", pipelineId1);
        PipelineProcessor.Factory factory = new PipelineProcessor.Factory(ingestService);  
        assertThat(resultList.get(0).getProcessorTag(), equalTo(expectedFailResult.getProcessorTag()));  
            actualProcessor.getType(),
            pipelineId1,  
                false,
                new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptName, Collections.emptyMap()),
        assertThat(metadata.get(ON_FAILURE_PROCESSOR_TAG_FIELD), equalTo("fail"));  
        assertFalse(resultList.get(1).getIngestDocument().hasField(key3));  
            Settings.builder().build(),  
            new ConditionalProcessor(
                Collections.singletonList(new TestProcessor(ingestDocument -> { throw exception; })),
        pipelineConfig2.put("name", pipelineId2);
            ingestDocument,
            actualProcessor.getDescription(),
        );
import org.opensearch.common.settings.Settings;
        );
        trackingProcessor.execute(ingestDocument, (result, e) -> {});  
        }),
            actualProcessor.getType(),
            ingestDocument.setFieldValue(key3, randomInt());
    public void testActualPipelineProcessorWithCycle() throws Exception {
            new TestProcessor(ingestDocument -> { ingestDocument.setFieldValue(key3, randomInt()); })

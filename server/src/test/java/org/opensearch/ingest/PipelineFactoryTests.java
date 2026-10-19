            () -> Pipeline.create("_id", pipelineConfig, processorRegistry, scriptService)  
        Map<String, Processor.Factory> processorRegistry = Collections.singletonMap("test", new TestProcessor.Factory());
        Map<String, Processor.Factory> processorRegistry = Collections.singletonMap("test", new TestProcessor.Factory());
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");  
            Pipeline.create("_id", pipelineConfig, Collections.emptyMap(), scriptService);  
        pipelineConfig.put(  
 * license agreements. See the NOTICE file distributed with
            () -> Pipeline.create("_id", pipelineConfig, processorRegistry, scriptService)
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);
        Map<String, Object> pipelineConfig = new HashMap<>();
        Map<String, Object> pipelineConfig = new HashMap<>();  
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);
        processorConfig.put(Pipeline.ON_FAILURE_KEY, Collections.emptyList());  
        assertThat(pipeline.getId(), equalTo("_id"));
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");
        Map<String, Object> pipelineConfig = new HashMap<>();
    public void testCreateWithPipelineEmptyOnFailure() throws Exception {
 * this work for additional information regarding copyright
 *
            false,
        assertThat(pipeline.getProcessors().get(0).getType(), equalTo("test-processor"));
import static org.hamcrest.CoreMatchers.equalTo;
    }
 * The OpenSearch Contributors require contributions made to  
        pipelineConfig.put(Pipeline.PROCESSORS_KEY, Collections.singletonList(Collections.singletonMap("test", processorConfig)));  
        assertThat(pipeline.getVersion(), equalTo(version));  
import static org.hamcrest.Matchers.is;
 *  
        processorConfig.put("ignore_failure", true);  
        List<Processor> flattened = pipeline.flattenAllProcessors();
        processorConfig.put(Pipeline.ON_FAILURE_KEY, Collections.singletonList(Collections.singletonMap("test", new HashMap<>())));
        Map<String, Object> pipelineConfig = new HashMap<>();  
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);
    public void testCreateProcessorsWithOnFailureProperties() throws Exception {
    }
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);
 * compatible open source license.
import java.util.Collections;  
        assertThat(e.getMessage(), equalTo("[on_failure] processors list cannot be empty"));
        pipelineConfig.put(Pipeline.PROCESSORS_KEY, Collections.singletonList(Collections.singletonMap("test", processorConfig)));  
    public void testCreateWithNoProcessorsField() throws Exception {
        Map<String, Processor.Factory> processorRegistry = Collections.singletonMap("test", new TestProcessor.Factory());
            fail("should fail, missing required [processors] field");
 * ownership. Elasticsearch licenses this file to you under  
        Pipeline pipeline = Pipeline.create("_id", pipelineConfig, processorRegistry, scriptService);  
        Map<String, Processor.Factory> processorRegistry = Collections.singletonMap("test", new TestProcessor.Factory());
    public void testCreateWithPipelineEmptyOnFailureInProcessor() throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
        Map<String, Object> pipelineConfig = new HashMap<>();  
        );
        assertThat(pipeline.getProcessors().get(0).getType(), equalTo("compound"));
    public void testCreateWithEmptyProcessorsField() throws Exception {
        assertThat(pipeline.getDescription(), equalTo("_description"));
            OpenSearchParseException.class,
            Pipeline.PROCESSORS_KEY,
        assertThat(pipeline.getProcessors(), is(empty()));
        );  
        CompoundProcessor processor = (CompoundProcessor) pipeline.getProcessors().get(0);  
        assertThat(pipeline.getId(), equalTo("_id"));  
        assertThat(pipeline.getDescription(), equalTo("_description"));
import static org.mockito.Mockito.mock;  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
    private final String versionString = version != null ? Integer.toString(version) : null;
    }  
        pipelineConfig.put(Pipeline.PROCESSORS_KEY, Collections.singletonList(Collections.singletonMap("test", processorConfig)));
        assertThat(pipeline.getDescription(), equalTo("_description"));
        assertThat(pipeline.getProcessors().get(1).getType(), equalTo("test-processor"));  
        assertThat(pipeline.getOnFailureProcessors().size(), equalTo(0));
    }  
    }  
        processorConfig.put("unused", "value");
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);
import org.opensearch.test.OpenSearchTestCase;  
 * the Apache License, Version 2.0 (the "License"); you may
        Map<String, Object> pipelineConfig = new HashMap<>();
    }
        processorConfig0.put(ConfigurationUtils.TAG_KEY, "first-processor");
        assertThat(pipeline.getProcessors().size(), equalTo(1));  
        TestProcessor testProcessor = new TestProcessor(ingestDocument -> {});
        Map<String, Object> pipelineConfig = new HashMap<>();  
        CompoundProcessor processor2 = new CompoundProcessor(
        Map<String, Object> pipelineConfig = new HashMap<>();  
        assertThat(flattened.size(), equalTo(4));
        Map<String, Processor.Factory> processorRegistry = Collections.singletonMap("test", new TestProcessor.Factory());
 * not use this file except in compliance with the License.
        assertThat(pipeline.getProcessors().size(), equalTo(1));
            assertThat(e.getMessage(), equalTo("[processors] required property is missing"));  
        assertThat(pipeline.getId(), equalTo("_id"));
        assertThat(pipeline.getProcessors().size(), equalTo(2));  
 * specific language governing permissions and limitations
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");  
 * GitHub history for details.
        Map<String, Processor.Factory> processorRegistry = Collections.singletonMap("test", new TestProcessor.Factory());
        assertThat(pipeline.getId(), equalTo("_id"));  
 */
        Pipeline pipeline = Pipeline.create("_id", pipelineConfig, processorRegistry, scriptService);
import java.util.List;
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");
        Pipeline pipeline = Pipeline.create("_id", pipelineConfig, processorRegistry, scriptService);
        pipelineConfig.put(Pipeline.PROCESSORS_KEY, Collections.singletonList(Collections.singletonMap("test", processorConfig)));
        pipelineConfig.put(Pipeline.PROCESSORS_KEY, Collections.emptyList());
        Map<String, Object> pipelineConfig = new HashMap<>();
package org.opensearch.ingest;
 *    http://www.apache.org/licenses/LICENSE-2.0
        try {
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);
        assertThat(pipeline.getVersion(), equalTo(version));  
        assertThat(pipeline.getOnFailureProcessors().size(), equalTo(1));  
 * under the License.  
            Arrays.asList(Collections.singletonMap("test", processorConfig0), Collections.singletonMap("test", processorConfig1))
        pipelineConfig.put(Pipeline.PROCESSORS_KEY, Collections.singletonList(Collections.singletonMap("test", processorConfig)));  
 * KIND, either express or implied.  See the License for the
    public void testCreateWithPipelineOnFailure() throws Exception {
import java.util.HashMap;
            Collections.singletonList(testProcessor)
import java.util.Arrays;
        Pipeline pipeline = Pipeline.create("_id", pipelineConfig, null, scriptService);  
        assertThat(pipeline.getProcessors().get(0).getTag(), equalTo("first-processor"));
/*  
    public void testFlattenProcessors() throws Exception {
    }
        Map<String, Object> processorConfig = new HashMap<>();
            OpenSearchParseException.class,
        assertThat(pipeline.getVersion(), equalTo(version));
        assertThat(pipeline.getOnFailureProcessors().get(0).getType(), equalTo("test-processor"));
        assertThat(pipeline.getProcessors().get(0).getType(), equalTo("test-processor"));
    public void testCreateWithPipelineIgnoreFailure() throws Exception {
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");
        assertThat(processor.isIgnoreFailure(), is(true));
    private final ScriptService scriptService = mock(ScriptService.class);  
        Map<String, Object> processorConfig1 = new HashMap<>();
        assertThat(processor.getProcessors().get(0).getType(), equalTo("test-processor"));
        assertThat(pipeline.getVersion(), equalTo(version));
    private final Integer version = randomBoolean() ? randomInt() : null;
    public void testCreateUnusedProcessorOptions() throws Exception {
    public void testCreate() throws Exception {
}
 *
        Map<String, Object> processorConfig = new HashMap<>();  
        assertThat(pipeline.getId(), equalTo("_id"));  
        Exception e = expectThrows(  
/*
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
        );  
import org.opensearch.OpenSearchParseException;
            OpenSearchParseException.class,
 * this file be licensed under the Apache-2.0 license or a
        assertThat(pipeline.getProcessors().get(1).getTag(), nullValue());
    }
        assertThat(pipeline.getDescription(), equalTo("_description"));
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");
import static org.hamcrest.Matchers.nullValue;
        Map<String, Object> processorConfig = new HashMap<>();
        );
/*  
    }
            Collections.singletonList(testProcessor),  
        Map<String, Object> processorConfig0 = new HashMap<>();  
        CompoundProcessor processor1 = new CompoundProcessor(testProcessor, testProcessor);  
        pipelineConfig.put(Pipeline.PROCESSORS_KEY, Collections.singletonList(Collections.singletonMap("test", processorConfig)));  
        assertThat(e.getMessage(), equalTo("pipeline [_id] cannot have an empty on_failure option defined"));
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);  
        assertThat(pipeline.getProcessors().size(), equalTo(1));  
 */  
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");  
        assertThat(pipeline.getVersion(), equalTo(version));
            () -> Pipeline.create("_id", pipelineConfig, processorRegistry, scriptService)
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");
        pipelineConfig.put(Pipeline.ON_FAILURE_KEY, Collections.emptyList());
        Map<String, Processor.Factory> processorRegistry = Collections.singletonMap("test", new TestProcessor.Factory());  
import static org.hamcrest.Matchers.empty;  
        pipelineConfig.put(Pipeline.ON_FAILURE_KEY, Collections.singletonList(Collections.singletonMap("test", processorConfig)));
        Exception e = expectThrows(  
        Map<String, Object> processorConfig = new HashMap<>();
import java.util.Map;  
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor1, processor2));  
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);
        } catch (OpenSearchParseException e) {
 * Modifications Copyright OpenSearch Contributors. See
        Exception e = expectThrows(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Pipeline pipeline = Pipeline.create("_id", pipelineConfig, processorRegistry, scriptService);
 */  
        }
        Map<String, Object> processorConfig = new HashMap<>();  
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");
        );  
        assertThat(pipeline.getDescription(), equalTo("_description"));
public class PipelineFactoryTests extends OpenSearchTestCase {
    }
        assertThat(e.getMessage(), equalTo("processor [test] doesn't support one or more provided configuration parameters [unused]"));
        Map<String, Object> processorConfig = new HashMap<>();
import org.opensearch.script.ScriptService;

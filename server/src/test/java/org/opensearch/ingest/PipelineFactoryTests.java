    public void testCreateWithNoProcessorsField() throws Exception {
        assertThat(pipeline.getProcessors(), is(empty()));
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.OpenSearchTestCase;
/*
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);
 * Unless required by applicable law or agreed to in writing,
        processorConfig0.put(ConfigurationUtils.TAG_KEY, "first-processor");
        Map<String, Processor.Factory> processorRegistry = Collections.singletonMap("test", new TestProcessor.Factory());
        assertThat(pipeline.getOnFailureProcessors().get(0).getType(), equalTo("test-processor"));
    public void testCreateWithPipelineEmptyOnFailureInProcessor() throws Exception {
            () -> Pipeline.create("_id", pipelineConfig, processorRegistry, scriptService)
        Map<String, Processor.Factory> processorRegistry = Collections.singletonMap("test", new TestProcessor.Factory());
        assertThat(pipeline.getId(), equalTo("_id"));
 * You may obtain a copy of the License at
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");
    public void testCreateWithPipelineEmptyOnFailure() throws Exception {
        Map<String, Object> pipelineConfig = new HashMap<>();
import java.util.List;
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");
        TestProcessor testProcessor = new TestProcessor(ingestDocument -> {});
 * compatible open source license.
        assertThat(pipeline.getVersion(), equalTo(version));
 * KIND, either express or implied.  See the License for the
    }
        assertThat(pipeline.getProcessors().get(0).getType(), equalTo("compound"));
            () -> Pipeline.create("_id", pipelineConfig, processorRegistry, scriptService)
        pipelineConfig.put(Pipeline.PROCESSORS_KEY, Collections.singletonList(Collections.singletonMap("test", processorConfig)));
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);
    }
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);
        assertThat(pipeline.getId(), equalTo("_id"));
            fail("should fail, missing required [processors] field");
/*
        Pipeline pipeline = new Pipeline("_id", "_description", version, new CompoundProcessor(processor1, processor2));
 */
            assertThat(e.getMessage(), equalTo("[processors] required property is missing"));
    }
        assertThat(processor.isIgnoreFailure(), is(true));
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);
        CompoundProcessor processor2 = new CompoundProcessor(
        assertThat(pipeline.getVersion(), equalTo(version));
        );
        Pipeline pipeline = Pipeline.create("_id", pipelineConfig, processorRegistry, scriptService);
        Map<String, Object> processorConfig = new HashMap<>();
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);
        assertThat(processor.getProcessors().get(0).getType(), equalTo("test-processor"));
        Map<String, Processor.Factory> processorRegistry = Collections.singletonMap("test", new TestProcessor.Factory());
        pipelineConfig.put(Pipeline.PROCESSORS_KEY, Collections.singletonList(Collections.singletonMap("test", processorConfig)));
            Pipeline.PROCESSORS_KEY,
 * not use this file except in compliance with the License.
import org.opensearch.script.ScriptService;
        pipelineConfig.put(Pipeline.ON_FAILURE_KEY, Collections.emptyList());
        pipelineConfig.put(Pipeline.PROCESSORS_KEY, Collections.singletonList(Collections.singletonMap("test", processorConfig)));
        );
            Arrays.asList(Collections.singletonMap("test", processorConfig0), Collections.singletonMap("test", processorConfig1))
 * under the License.
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);
        CompoundProcessor processor = (CompoundProcessor) pipeline.getProcessors().get(0);
 * Licensed to Elasticsearch under one or more contributor
        Map<String, Object> pipelineConfig = new HashMap<>();
        assertThat(pipeline.getId(), equalTo("_id"));
        assertThat(pipeline.getDescription(), equalTo("_description"));
 *
import static org.hamcrest.Matchers.is;
        Map<String, Object> processorConfig = new HashMap<>();
        assertThat(pipeline.getOnFailureProcessors().size(), equalTo(0));
        assertThat(pipeline.getVersion(), equalTo(version));
        Map<String, Processor.Factory> processorRegistry = Collections.singletonMap("test", new TestProcessor.Factory());
        pipelineConfig.put(Pipeline.PROCESSORS_KEY, Collections.singletonList(Collections.singletonMap("test", processorConfig)));
import static org.hamcrest.Matchers.empty;
    }
import java.util.HashMap;
}
        Map<String, Object> pipelineConfig = new HashMap<>();
        }
        Map<String, Object> pipelineConfig = new HashMap<>();
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");
    }
            Pipeline.create("_id", pipelineConfig, Collections.emptyMap(), scriptService);
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Arrays;
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");
        assertThat(pipeline.getProcessors().get(0).getTag(), equalTo("first-processor"));
        Map<String, Object> pipelineConfig = new HashMap<>();
public class PipelineFactoryTests extends OpenSearchTestCase {
            OpenSearchParseException.class,
        assertThat(pipeline.getProcessors().get(1).getType(), equalTo("test-processor"));
 */
        assertThat(pipeline.getId(), equalTo("_id"));
        assertThat(pipeline.getDescription(), equalTo("_description"));
        Map<String, Object> processorConfig = new HashMap<>();
        assertThat(pipeline.getProcessors().get(0).getType(), equalTo("test-processor"));
 *
    private final ScriptService scriptService = mock(ScriptService.class);
package org.opensearch.ingest;
        Map<String, Object> pipelineConfig = new HashMap<>();
    private final String versionString = version != null ? Integer.toString(version) : null;
        Exception e = expectThrows(
        processorConfig.put("ignore_failure", true);
            false,
        assertThat(pipeline.getProcessors().size(), equalTo(2));
 *
            Collections.singletonList(testProcessor),
    }
        } catch (OpenSearchParseException e) {
    }
 * software distributed under the License is distributed on an
        Map<String, Object> pipelineConfig = new HashMap<>();
            Collections.singletonList(testProcessor)
    public void testCreateWithPipelineOnFailure() throws Exception {
        Pipeline pipeline = Pipeline.create("_id", pipelineConfig, null, scriptService);
 * specific language governing permissions and limitations
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");
            () -> Pipeline.create("_id", pipelineConfig, processorRegistry, scriptService)
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under
    public void testCreateProcessorsWithOnFailureProperties() throws Exception {
        processorConfig.put("unused", "value");
        assertThat(pipeline.getProcessors().size(), equalTo(1));
        Pipeline pipeline = Pipeline.create("_id", pipelineConfig, processorRegistry, scriptService);
        pipelineConfig.put(Pipeline.PROCESSORS_KEY, Collections.singletonList(Collections.singletonMap("test", processorConfig)));
        Exception e = expectThrows(
/*
        assertThat(pipeline.getDescription(), equalTo("_description"));
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Processor.Factory> processorRegistry = Collections.singletonMap("test", new TestProcessor.Factory());
        assertThat(pipeline.getDescription(), equalTo("_description"));
 */
import java.util.Map;
 * this work for additional information regarding copyright
        processorConfig.put(Pipeline.ON_FAILURE_KEY, Collections.emptyList());
        assertThat(pipeline.getDescription(), equalTo("_description"));
        assertThat(pipeline.getProcessors().size(), equalTo(1));
            OpenSearchParseException.class,
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Map<String, Object> processorConfig = new HashMap<>();
        Map<String, Object> processorConfig0 = new HashMap<>();
        assertThat(pipeline.getProcessors().get(1).getTag(), nullValue());
        try {
import static org.hamcrest.Matchers.nullValue;
    public void testCreateWithEmptyProcessorsField() throws Exception {
        Map<String, Object> processorConfig = new HashMap<>();
        Map<String, Object> processorConfig = new HashMap<>();
        Pipeline pipeline = Pipeline.create("_id", pipelineConfig, processorRegistry, scriptService);
        assertThat(e.getMessage(), equalTo("[on_failure] processors list cannot be empty"));
        assertThat(pipeline.getProcessors().get(0).getType(), equalTo("test-processor"));
        pipelineConfig.put(Pipeline.PROCESSORS_KEY, Collections.singletonList(Collections.singletonMap("test", processorConfig)));
        );
        CompoundProcessor processor1 = new CompoundProcessor(testProcessor, testProcessor);
import org.opensearch.OpenSearchParseException;
import static org.hamcrest.CoreMatchers.equalTo;
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(pipeline.getVersion(), equalTo(version));
    private final Integer version = randomBoolean() ? randomInt() : null;
        Exception e = expectThrows(
        List<Processor> flattened = pipeline.flattenAllProcessors();
        Pipeline pipeline = Pipeline.create("_id", pipelineConfig, processorRegistry, scriptService);
        Map<String, Object> pipelineConfig = new HashMap<>();
        assertThat(e.getMessage(), equalTo("processor [test] doesn't support one or more provided configuration parameters [unused]"));
 * GitHub history for details.
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);
        assertThat(e.getMessage(), equalTo("pipeline [_id] cannot have an empty on_failure option defined"));
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");
    public void testCreateUnusedProcessorOptions() throws Exception {
 * The OpenSearch Contributors require contributions made to
    }
        pipelineConfig.put(Pipeline.PROCESSORS_KEY, Collections.emptyList());
        Map<String, Object> processorConfig1 = new HashMap<>();
        );
        assertThat(pipeline.getId(), equalTo("_id"));
    public void testCreate() throws Exception {
        assertThat(pipeline.getOnFailureProcessors().size(), equalTo(1));
    public void testCreateWithPipelineIgnoreFailure() throws Exception {
import java.util.Collections;
import static org.mockito.Mockito.mock;
    public void testFlattenProcessors() throws Exception {
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");
        pipelineConfig.put(Pipeline.DESCRIPTION_KEY, "_description");
            OpenSearchParseException.class,
        assertThat(pipeline.getProcessors().size(), equalTo(1));
        );
    }
        assertThat(pipeline.getVersion(), equalTo(version));
        assertThat(flattened.size(), equalTo(4));
        pipelineConfig.put(
        Map<String, Processor.Factory> processorRegistry = Collections.singletonMap("test", new TestProcessor.Factory());
        processorConfig.put(Pipeline.ON_FAILURE_KEY, Collections.singletonList(Collections.singletonMap("test", new HashMap<>())));
        pipelineConfig.put(Pipeline.VERSION_KEY, versionString);
        pipelineConfig.put(Pipeline.ON_FAILURE_KEY, Collections.singletonList(Collections.singletonMap("test", processorConfig)));
 * license agreements. See the NOTICE file distributed with
        Map<String, Processor.Factory> processorRegistry = Collections.singletonMap("test", new TestProcessor.Factory());
        Map<String, Object> pipelineConfig = new HashMap<>();

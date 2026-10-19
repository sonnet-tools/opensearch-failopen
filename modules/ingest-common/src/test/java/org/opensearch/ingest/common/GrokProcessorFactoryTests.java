        assertThat(processor.isIgnoreMissing(), is(false));
        GrokProcessor.Factory factory = new GrokProcessor.Factory(Collections.emptyMap(), MatcherWatchdog.noop());
/*
import static org.hamcrest.Matchers.equalTo;
 * compatible open source license.
    public void testBuildWithCaptureAllMatches() throws Exception {
        GrokProcessor.Factory factory = new GrokProcessor.Factory(Collections.emptyMap(), MatcherWatchdog.noop());
        config.put("pattern_definitions", Collections.singletonMap("MY_PATTERN", "foo"));
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config));
 *
 *
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config));
import org.opensearch.grok.MatcherWatchdog;
        config.put("patterns", Collections.singletonList("(?<foo>\\w+)"));
        GrokProcessor processor = factory.create(null, processorTag, null, config);
 * specific language governing permissions and limitations
        Map<String, Object> config = new HashMap<>();
        assertThat(e.getMessage(), equalTo("[field] required property is missing"));
        assertThat(e.getMessage(), equalTo("[patterns] Invalid regex pattern found in: [[]. premature end of char-class"));
 * license agreements. See the NOTICE file distributed with
        config.put("capture_all_matches", true);
        Map<String, Object> config = new HashMap<>();
        assertThat(processor.getTag(), equalTo(processorTag));
 * Licensed to Elasticsearch under one or more contributor
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config));
        );
 * SPDX-License-Identifier: Apache-2.0
 *
        assertThat(processor.getMatchField(), equalTo("_field"));
 */
        GrokProcessor.Factory factory = new GrokProcessor.Factory(Collections.emptyMap(), MatcherWatchdog.noop());
        config.put("field", "foo");
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at
        GrokProcessor processor = factory.create(null, processorTag, null, config);
        Map<String, Object> config = new HashMap<>();
    public void testBuildEmptyPatternsList() throws Exception {
 */
import java.util.Collections;
        GrokProcessor.Factory factory = new GrokProcessor.Factory(Collections.emptyMap(), MatcherWatchdog.noop());
    }
        config.put("field", "_field");
        Map<String, Object> config = new HashMap<>();
    public void testCreateWithInvalidPatternDefinition() throws Exception {
        config.put("pattern_definitions", Collections.singletonMap("MY_PATTERN", "["));
        GrokProcessor.Factory factory = new GrokProcessor.Factory(Collections.emptyMap(), MatcherWatchdog.noop());
}
    public void testBuildMissingField() throws Exception {
        config.put("field", "_field");
        Map<String, Object> config = new HashMap<>();
 * Unless required by applicable law or agreed to in writing,
public class GrokProcessorFactoryTests extends OpenSearchTestCase {
        config.put("field", "_field");
        GrokProcessor.Factory factory = new GrokProcessor.Factory(Collections.emptyMap(), MatcherWatchdog.noop());
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config));
 * GitHub history for details.
        GrokProcessor processor = factory.create(null, processorTag, null, config);
import static org.hamcrest.Matchers.notNullValue;
        String processorTag = randomAlphaOfLength(10);
        assertThat(processor.getMatchField(), equalTo("_field"));
 * The OpenSearch Contributors require contributions made to
package org.opensearch.ingest.common;
        assertThat(processor.getMatchField(), equalTo("_field"));
        config.put("field", "foo");
    public void testBuild() throws Exception {
        config.put("patterns", Collections.singletonList("%{MY_PATTERN:name}!"));
import java.util.HashMap;
        Map<String, Object> config = new HashMap<>();
        config.put("patterns", Collections.singletonList("["));
        Map<String, Object> config = new HashMap<>();
        config.put("field", "_field");
/*
 * this file be licensed under the Apache-2.0 license or a
        assertThat(e.getMessage(), equalTo("[patterns] List of patterns must not be empty"));
        config.put("patterns", Collections.singletonList("(?<foo>\\w+)"));
import java.util.Map;
        config.put("patterns", Collections.singletonList("(?<foo>\\w+)"));
        assertThat(processor.getGrok(), notNullValue());
    }
 * ownership. Elasticsearch licenses this file to you under
        config.put("patterns", Collections.singletonList("%{MY_PATTERN:name}!"));
import static org.hamcrest.Matchers.is;
import org.opensearch.OpenSearchParseException;
        assertThat(processor.isCaptureAllMatches(), is(true));
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config));
        assertThat(processor.getGrok().match("foo!"), equalTo(true));
 * under the License.
        GrokProcessor.Factory factory = new GrokProcessor.Factory(Collections.emptyMap(), MatcherWatchdog.noop());
    public void testBuildMissingPatterns() throws Exception {
    }
 * this work for additional information regarding copyright
        assertThat(
 * Modifications Copyright OpenSearch Contributors. See
    }
 * software distributed under the License is distributed on an
        assertThat(processor.isIgnoreMissing(), is(true));
    }
        config.put("patterns", Collections.emptyList());
    public void testCreateWithInvalidPattern() throws Exception {
    }
    public void testBuildWithIgnoreMissing() throws Exception {
            e.getMessage(),
    public void testCreateWithCustomPatterns() throws Exception {
        assertThat(e.getMessage(), equalTo("[patterns] required property is missing"));
 * the Apache License, Version 2.0 (the "License"); you may
        config.put("patterns", Collections.singletonList("(?<foo>\\w+)"));
        assertThat(processor.getTag(), equalTo(processorTag));
            equalTo("[patterns] Invalid regex pattern found in: [%{MY_PATTERN:name}!]. premature end of char-class")
        GrokProcessor processor = factory.create(null, null, null, config);
 * KIND, either express or implied.  See the License for the
        assertThat(processor.getGrok(), notNullValue());
import org.opensearch.test.OpenSearchTestCase;
        assertThat(processor.getMatchField(), equalTo("_field"));
        config.put("ignore_missing", true);
/*
        Map<String, Object> config = new HashMap<>();
        String processorTag = randomAlphaOfLength(10);
        GrokProcessor.Factory factory = new GrokProcessor.Factory(Collections.emptyMap(), MatcherWatchdog.noop());
        GrokProcessor.Factory factory = new GrokProcessor.Factory(Collections.emptyMap(), MatcherWatchdog.noop());
        config.put("field", "_field");
        assertThat(processor.getTag(), equalTo(processorTag));
        Map<String, Object> config = new HashMap<>();
    }
 */
    }
        assertThat(processor.getGrok(), notNullValue());
        config.put("field", "_field");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String processorTag = randomAlphaOfLength(10);
 * not use this file except in compliance with the License.
        assertThat(processor.getGrok(), notNullValue());

import static org.hamcrest.Matchers.equalTo;
        String sourceField = randomAlphaOfLengthBetween(1, 10);
 * The OpenSearch Contributors require contributions made to
        config.put("field", sourceField);
}
            fail("processor creation should have failed");
 * not use this file except in compliance with the License.
        config.put("field", sourceField);
        config.put("target_field", targetField);
        ZoneId timezone = randomZone();
        factory = new DateProcessor.Factory(TestTemplateService.instance());
 * compatible open source license.
        } catch (OpenSearchParseException e) {
        String sourceField = randomAlphaOfLengthBetween(1, 10);
 * under the License.
        config.put("output_format", outputFormat);
    public void testDefaultOutputFormat() throws Exception {
        }
        assertThat(processor.getOutputFormat(), equalTo(outputFormat));
        config.put("formats", Collections.singletonList("dd/MM/yyyyy"));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> factory.create(null, null, null, config));
 */
        String targetField = randomAlphaOfLengthBetween(1, 10);
        config.put("target_field", targetField);
        config.put("locale", locale.toLanguageTag());
import java.time.ZoneId;
    }
    public void testBuildDefaults() throws Exception {
        String sourceField = randomAlphaOfLengthBetween(1, 10);
    }
        config.put("timezone", timezone.getId());
            assertThat(e.getMessage(), containsString("[formats] property isn't a list, but of type [java.lang.String]"));
        DateProcessor processor = factory.create(null, null, null, config);
    public void init() {
        assertNull(processor.getLocale());
        config.put("formats", Arrays.asList("dd/MM/yyyy", "dd-MM-yyyy"));
        config.put("field", sourceField);
        try {
        DateProcessor processor = factory.create(null, processorTag, null, config);
        Map<String, Object> config = new HashMap<>();
        config.put("formats", "dd/MM/yyyy");
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
    }
            fail("processor creation should have failed");
        config.put("field", sourceField);
        assertThat(processor.getFormats(), equalTo(Arrays.asList("dd/MM/yyyy", "dd-MM-yyyy")));
        }
        Map<String, Object> config = new HashMap<>();
            factory.create(null, null, null, config);
 * KIND, either express or implied.  See the License for the
import static org.hamcrest.Matchers.containsString;
            factory.create(null, null, null, config);
        }
    public void testMatchFieldIsMandatory() throws Exception {
        assertThat(processor.getOutputFormat(), equalTo(DateProcessor.DEFAULT_OUTPUT_FORMAT));
 * Licensed to Elasticsearch under one or more contributor
 */
    }
    }
        config.put("formats", Collections.singletonList("dd/MM/yyyyy"));
        config.put("field", sourceField);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        try {
        Locale locale = randomFrom(Locale.GERMANY, Locale.FRENCH, Locale.ROOT);
        config.put("target_field", targetField);
            fail("processor creation should have failed");
        Map<String, Object> config = new HashMap<>();
        String processorTag = randomAlphaOfLength(10);
import org.opensearch.test.OpenSearchTestCase;
 * license agreements. See the NOTICE file distributed with
        try {
import org.opensearch.ingest.TestTemplateService;
    public void testParseTimezone() throws Exception {
        config.put("target_field", targetField);
    public void testParseOutputFormat() throws Exception {
        DateProcessor processor = factory.create(null, null, null, config);
        assertThat(processor.getTargetField(), equalTo(targetField));
import org.junit.Before;
 *
    private DateProcessor.Factory factory;
    }
    public void testMatchFormatsIsMandatory() throws Exception {
package org.opensearch.ingest.common;
/*
 * You may obtain a copy of the License at
    public void testParseLocale() throws Exception {
 *
 * SPDX-License-Identifier: Apache-2.0
    }
        assertThat(processor.getField(), equalTo(sourceField));
        String targetField = randomAlphaOfLengthBetween(1, 10);
        config.put("formats", Collections.singletonList("dd/MM/yyyyy"));
        config.put("field", sourceField);
        Map<String, Object> config = new HashMap<>();
        assertNull(processor.getTimezone());
        config.put("formats", Arrays.asList("dd/MM/yyyy", "dd-MM-yyyy"));
        config.put("field", sourceField);
        Map<String, Object> config = new HashMap<>();
        assertThat(processor.getTag(), equalTo(processorTag));
 * GitHub history for details.
        config.put("field", sourceField);
            assertThat(e.getMessage(), containsString("[field] required property is missing"));
        config.put("field", sourceField);
        String sourceField = randomAlphaOfLengthBetween(1, 10);
        final String outputFormat = "dd:MM:yyyy";
        Map<String, Object> config = new HashMap<>();
    public void testParseMatchFormats() throws Exception {
        Map<String, Object> config = new HashMap<>();
        String sourceField = randomAlphaOfLengthBetween(1, 10);
        config.put("formats", Arrays.asList("dd/MM/yyyy", "dd-MM-yyyy"));
        } catch (OpenSearchParseException e) {
        DateProcessor processor = factory.create(null, null, null, config);
        DateProcessor processor = factory.create(null, null, null, config);
        String sourceField = randomAlphaOfLengthBetween(1, 10);
        String sourceField = randomAlphaOfLengthBetween(1, 10);
        config.put("field", sourceField);
        Map<String, Object> config = new HashMap<>();
        assertThat(processor.getFormats(), equalTo(Collections.singletonList("dd/MM/yyyyy")));
        String sourceField = randomAlphaOfLengthBetween(1, 10);
            assertThat(e.getMessage(), containsString("[formats] required property is missing"));
/*
        String targetField = randomAlphaOfLengthBetween(1, 10);
    }
        final String outputFormat = "invalid_date_format";
        config.put("formats", Collections.singletonList("dd/MM/yyyyy"));
        assertThat(processor.getTimezone().newInstance(Collections.emptyMap()).execute(), equalTo(timezone.getId()));
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> config = new HashMap<>();
        String targetField = randomAlphaOfLengthBetween(1, 10);
        DateProcessor processor = factory.create(null, null, null, config);
    }
    }
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under
 * Modifications Copyright OpenSearch Contributors. See
        Map<String, Object> config = new HashMap<>();
        assertThat(processor.getLocale().newInstance(Collections.emptyMap()).execute(), equalTo(locale.toLanguageTag()));
import java.util.Collections;
    public void testParseTargetField() throws Exception {
import java.util.Locale;
        Map<String, Object> config = new HashMap<>();
 */
        String sourceField = randomAlphaOfLengthBetween(1, 10);
    }
        config.put("target_field", targetField);
import java.util.Arrays;
public class DateProcessorFactoryTests extends OpenSearchTestCase {
        assertThat(e.getMessage(), containsString("invalid output format [" + outputFormat + "]"));
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 *
 * the Apache License, Version 2.0 (the "License"); you may
    public void testInvalidOutputFormatRejected() throws Exception {
    public void testParseMatchFormatsFailure() throws Exception {
import org.opensearch.OpenSearchParseException;
        config.put("output_format", outputFormat);
        config.put("formats", Arrays.asList("dd/MM/yyyy", "dd-MM-yyyy"));
        String sourceField = randomAlphaOfLengthBetween(1, 10);
        config.put("formats", Arrays.asList("dd/MM/yyyy", "dd-MM-yyyy"));
import java.util.Map;
import java.util.HashMap;
        } catch (OpenSearchParseException e) {
        assertThat(processor.getTargetField(), equalTo(DateProcessor.DEFAULT_TARGET_FIELD));
    @Before
/*
        config.put("target_field", targetField);
        DateProcessor processor = factory.create(null, null, null, config);
        String targetField = randomAlphaOfLengthBetween(1, 10);
            factory.create(null, null, null, config);
        String targetField = randomAlphaOfLengthBetween(1, 10);

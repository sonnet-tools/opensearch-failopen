        assertThat(processor.getFormats(), equalTo(Arrays.asList("dd/MM/yyyy", "dd-MM-yyyy")));
        config.put("formats", "dd/MM/yyyy");
        Locale locale = randomFrom(Locale.GERMANY, Locale.FRENCH, Locale.ROOT);
        String sourceField = randomAlphaOfLengthBetween(1, 10);  
        DateProcessor processor = factory.create(null, null, null, config);
import java.time.ZoneId;  
    }  
        final String outputFormat = "dd:MM:yyyy";
    }
        String targetField = randomAlphaOfLengthBetween(1, 10);  
        String targetField = randomAlphaOfLengthBetween(1, 10);  
 * software distributed under the License is distributed on an
/*  
        config.put("field", sourceField);  
    }
    public void testParseTargetField() throws Exception {  
    }
        String sourceField = randomAlphaOfLengthBetween(1, 10);  
    public void testParseLocale() throws Exception {  
        config.put("target_field", targetField);
        config.put("field", sourceField);
        config.put("formats", Arrays.asList("dd/MM/yyyy", "dd-MM-yyyy"));
        DateProcessor processor = factory.create(null, null, null, config);
            fail("processor creation should have failed");  
 *
        config.put("field", sourceField);
        config.put("field", sourceField);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> factory.create(null, null, null, config));
    }
 * license agreements. See the NOTICE file distributed with
    public void testParseTimezone() throws Exception {  
        config.put("formats", Collections.singletonList("dd/MM/yyyyy"));
 *
        config.put("formats", Collections.singletonList("dd/MM/yyyyy"));
package org.opensearch.ingest.common;
        String sourceField = randomAlphaOfLengthBetween(1, 10);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;  
        }  
        DateProcessor processor = factory.create(null, null, null, config);  
        factory = new DateProcessor.Factory(TestTemplateService.instance());
        }  
    public void testMatchFieldIsMandatory() throws Exception {
}
        config.put("field", sourceField);
        assertThat(processor.getTargetField(), equalTo(DateProcessor.DEFAULT_TARGET_FIELD));
    public void testParseMatchFormatsFailure() throws Exception {
        assertThat(processor.getTimezone().newInstance(Collections.emptyMap()).execute(), equalTo(timezone.getId()));  
    }
import static org.hamcrest.Matchers.containsString;
        DateProcessor processor = factory.create(null, null, null, config);
import org.opensearch.OpenSearchParseException;
    }
        assertNull(processor.getLocale());  
        }  
 */  
    public void testBuildDefaults() throws Exception {
        Map<String, Object> config = new HashMap<>();
        config.put("timezone", timezone.getId());
        Map<String, Object> config = new HashMap<>();
            factory.create(null, null, null, config);
import java.util.Map;
import org.opensearch.ingest.TestTemplateService;
    public void testParseOutputFormat() throws Exception {  
import org.junit.Before;
        assertThat(processor.getLocale().newInstance(Collections.emptyMap()).execute(), equalTo(locale.toLanguageTag()));  
        String targetField = randomAlphaOfLengthBetween(1, 10);  
        config.put("formats", Arrays.asList("dd/MM/yyyy", "dd-MM-yyyy"));
    }
    public void testParseMatchFormats() throws Exception {  
 * The OpenSearch Contributors require contributions made to  
        config.put("target_field", targetField);  
import static org.hamcrest.Matchers.equalTo;
public class DateProcessorFactoryTests extends OpenSearchTestCase {
            factory.create(null, null, null, config);
import java.util.Arrays;
        DateProcessor processor = factory.create(null, null, null, config);
            assertThat(e.getMessage(), containsString("[formats] property isn't a list, but of type [java.lang.String]"));
        assertNull(processor.getTimezone());
 * not use this file except in compliance with the License.
            fail("processor creation should have failed");  
        String sourceField = randomAlphaOfLengthBetween(1, 10);
        config.put("field", sourceField);
        assertThat(processor.getTag(), equalTo(processorTag));
            fail("processor creation should have failed");  
        Map<String, Object> config = new HashMap<>();
 */  
        config.put("output_format", outputFormat);
            assertThat(e.getMessage(), containsString("[field] required property is missing"));
    }
        config.put("field", sourceField);
        config.put("formats", Arrays.asList("dd/MM/yyyy", "dd-MM-yyyy"));
            assertThat(e.getMessage(), containsString("[formats] required property is missing"));
 * under the License.  
    }
        try {
        final String outputFormat = "invalid_date_format";
 * KIND, either express or implied.  See the License for the
 */
            factory.create(null, null, null, config);
        String sourceField = randomAlphaOfLengthBetween(1, 10);  
 * specific language governing permissions and limitations
        config.put("formats", Collections.singletonList("dd/MM/yyyyy"));
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
        ZoneId timezone = randomZone();  
        String targetField = randomAlphaOfLengthBetween(1, 10);
import java.util.Locale;
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(processor.getOutputFormat(), equalTo(DateProcessor.DEFAULT_OUTPUT_FORMAT));  
        String sourceField = randomAlphaOfLengthBetween(1, 10);
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
        config.put("output_format", outputFormat);
        } catch (OpenSearchParseException e) {
        String sourceField = randomAlphaOfLengthBetween(1, 10);
        Map<String, Object> config = new HashMap<>();
    public void testMatchFormatsIsMandatory() throws Exception {  
        Map<String, Object> config = new HashMap<>();
        String processorTag = randomAlphaOfLength(10);  
    @Before
 * compatible open source license.
        assertThat(processor.getOutputFormat(), equalTo(outputFormat));
        try {
        String sourceField = randomAlphaOfLengthBetween(1, 10);  
        String sourceField = randomAlphaOfLengthBetween(1, 10);  
        config.put("locale", locale.toLanguageTag());  
        config.put("target_field", targetField);  
import java.util.HashMap;  
 * Licensed to Elasticsearch under one or more contributor  
        Map<String, Object> config = new HashMap<>();
        config.put("field", sourceField);  
        DateProcessor processor = factory.create(null, null, null, config);  
        String targetField = randomAlphaOfLengthBetween(1, 10);
        config.put("formats", Arrays.asList("dd/MM/yyyy", "dd-MM-yyyy"));  
        DateProcessor processor = factory.create(null, processorTag, null, config);
 * GitHub history for details.
        assertThat(e.getMessage(), containsString("invalid output format [" + outputFormat + "]"));
 *  
        config.put("target_field", targetField);  
/*  
        try {
    }
        String targetField = randomAlphaOfLengthBetween(1, 10);
    private DateProcessor.Factory factory;  
import java.util.Collections;
        Map<String, Object> config = new HashMap<>();
        assertThat(processor.getField(), equalTo(sourceField));  
        config.put("field", sourceField);
        Map<String, Object> config = new HashMap<>();
        } catch (OpenSearchParseException e) {
 * Unless required by applicable law or agreed to in writing,
        Map<String, Object> config = new HashMap<>();
        config.put("field", sourceField);  
        config.put("formats", Collections.singletonList("dd/MM/yyyyy"));
        config.put("formats", Arrays.asList("dd/MM/yyyy", "dd-MM-yyyy"));
        String sourceField = randomAlphaOfLengthBetween(1, 10);
    public void testInvalidOutputFormatRejected() throws Exception {  
        Map<String, Object> config = new HashMap<>();
 * Modifications Copyright OpenSearch Contributors. See
        config.put("target_field", targetField);
        assertThat(processor.getTargetField(), equalTo(targetField));  
        } catch (OpenSearchParseException e) {
        Map<String, Object> config = new HashMap<>();
        assertThat(processor.getFormats(), equalTo(Collections.singletonList("dd/MM/yyyyy")));
    public void testDefaultOutputFormat() throws Exception {
 * this work for additional information regarding copyright
        config.put("target_field", targetField);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void init() {  

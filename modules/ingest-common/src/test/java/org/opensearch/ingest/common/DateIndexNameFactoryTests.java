        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config));
package org.opensearch.ingest.common;
        config = new HashMap<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
    public void testSpecifyOptionalSettings() throws Exception {
        Map<String, Object> config = new HashMap<>();
        config.put("field", "_field");
        assertThat(processor.getTimezone(), Matchers.equalTo(ZoneOffset.ofHours(2)));
        config.put("field", "_field");
 * not use this file except in compliance with the License.
        assertThat(processor.getIndexNamePrefixTemplate().newInstance(Collections.emptyMap()).execute(), Matchers.equalTo(""));
        processor = factory.create(null, null, null, config);
        config.put("field", "_field");  
        config.put("date_rounding", "y");
        config.put("index_name_prefix", "_prefix");  
        DateIndexNameProcessor processor = factory.create(null, null, null, config);
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
        config = new HashMap<>();
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(e.getMessage(), Matchers.equalTo("[date_rounding] required property is missing"));
        config.put("index_name_prefix", "_prefix");  
        assertThat(processor.getDateFormats().size(), Matchers.equalTo(1));  
        config.put("index_name_prefix", "_prefix");  
        Map<String, Object> config = new HashMap<>();  
import java.util.Map;
        config.put("date_rounding", "y");
        assertThat(processor.getIndexNameFormatTemplate().newInstance(Collections.emptyMap()).execute(), Matchers.equalTo("yyyy-MM-dd"));
/*  
        DateIndexNameProcessor.Factory factory = new DateIndexNameProcessor.Factory(TestTemplateService.instance());  
 * this work for additional information regarding copyright
        DateIndexNameProcessor.Factory factory = new DateIndexNameProcessor.Factory(TestTemplateService.instance());
 * under the License.  
        config.put("field", "_field");
 * license agreements. See the NOTICE file distributed with
        assertThat(processor.getField(), Matchers.equalTo("_field"));
        assertThat(processor.getDateFormats().size(), Matchers.equalTo(2));
        e = expectThrows(OpenSearchParseException.class, () -> factory.create(null, null, null, config));
        assertThat(processor.getDateRoundingTemplate().newInstance(Collections.emptyMap()).execute(), Matchers.equalTo("y"));  
    }  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(e.getMessage(), Matchers.equalTo("[field] required property is missing"));  
 *
        processor = factory.create(null, null, null, config);  
        config.put("timezone", "+02:00");
import java.util.Arrays;
        Map<String, Object> config = new HashMap<>();
import java.time.ZoneOffset;  
        processor = factory.create(null, null, null, config);
        config.put("date_rounding", "y");
import org.hamcrest.Matchers;
    public void testDefaults() throws Exception {
        DateIndexNameProcessor.Factory factory = new DateIndexNameProcessor.Factory(TestTemplateService.instance());  
/*
        DateIndexNameProcessor processor = factory.create(null, null, null, config);
import org.opensearch.OpenSearchParseException;
 */
    public void testRequiredFields() throws Exception {
 *  
    }  
        assertThat(processor.getTimezone(), Matchers.equalTo(ZoneOffset.UTC));
        config.put("field", "_field");
import org.opensearch.test.OpenSearchTestCase;  
 * SPDX-License-Identifier: Apache-2.0
        config.put("index_name_format", "yyyyMMdd");
        config.put("index_name_prefix", "_prefix");  
import java.util.Collections;
 * Licensed to Elasticsearch under one or more contributor  
    }
        config.put("date_rounding", "y");
 * GitHub history for details.
import java.util.HashMap;  
public class DateIndexNameFactoryTests extends OpenSearchTestCase {  
        config.clear();
        config.put("date_rounding", "y");  
        assertThat(processor.getIndexNameFormatTemplate().newInstance(Collections.emptyMap()).execute(), Matchers.equalTo("yyyyMMdd"));
 * The OpenSearch Contributors require contributions made to  
 */  
        config.put("field", "_field");
        config = new HashMap<>();
 *    http://www.apache.org/licenses/LICENSE-2.0
}
        config.put("date_formats", Arrays.asList("UNIX", "UNIX_MS"));
        config.put("date_rounding", "y");
/*  
 */  
        assertThat(processor.getIndexNamePrefixTemplate().newInstance(Collections.emptyMap()).execute(), Matchers.equalTo("_prefix"));
 *
import org.opensearch.ingest.TestTemplateService;

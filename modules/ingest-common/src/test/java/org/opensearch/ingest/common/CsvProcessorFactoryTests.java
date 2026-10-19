 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
public class CsvProcessorFactoryTests extends OpenSearchTestCase {
        properties.put("separator", "/");
import static org.hamcrest.Matchers.is;
        assertThat(csv, notNullValue());  
import static org.hamcrest.Matchers.notNullValue;  
 *
import java.util.HashMap;
 *
        CsvProcessor csv = factory.create(null, "csv", null, properties);
        assertThat(csv.ignoreMissing, equalTo(true));
 */  
 * specific language governing permissions and limitations
        CsvProcessor.Factory factory = new CsvProcessor.Factory();
        properties.put("ignore_missing", true);
/*  
        properties.put("target_fields", Collections.singletonList("target"));
/*  
package org.opensearch.ingest.common;
        assertThat(csv.emptyValue, equalTo("empty"));
import org.opensearch.test.OpenSearchTestCase;
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        assertThat(csv.separator, equalTo('/'));
        assertThat(properties, is(emptyMap()));
    }  
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * under the License.  
/*
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        properties.put("trim", true);  
 * this file be licensed under the Apache-2.0 license or a
        HashMap<String, Object> properties = new HashMap<>();  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
    public void testProcessorIsCreated() {
        assertThat(csv.field, equalTo("field"));
        assertThat(csv.quote, equalTo('|'));  
        assertThat(csv.trim, equalTo(true));  
}
        properties.put("quote", "|");  
        properties.put("field", "field");
 */
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(csv.headers, equalTo(new String[] { "target" }));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Collections;  
        properties.put("empty_value", "empty");
import static org.hamcrest.Matchers.equalTo;
 * Modifications Copyright OpenSearch Contributors. See
import static java.util.Collections.emptyMap;  

        @SuppressWarnings("unchecked")  
 * under the License.  
import java.util.Collections;
import java.util.List;
        assertThat(valueSource, instanceOf(ValueSource.MapValue.class));
 *
        map.put("field2", Collections.singletonMap("field3", "{{field2.field3}}"));
 * not use this file except in compliance with the License.
        Map<String, Object> map = new HashMap<>();  
        assertThat(result.size(), equalTo(2));
    }
        Map<String, Object> resultMap = (Map<String, Object>) valueSource.copyAndResolve(model);
}  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(ingestDocument.hasField("marvel"), is(false));
 */  
        assertThat(valueSource, instanceOf(ValueSource.ListValue.class));
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
/*
        assertThat(valueSource.copyAndResolve(model), equalTo("value1/{field3=value3}/value3"));
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
        ingestDocument.removeField(compile("{{marvel}}"));
        IngestDocument ingestDocument = new IngestDocument("marvel", "id", null, null, null, new HashMap<>());
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.HashMap;  
        map.put("field4", "_value");  
    public void testValueSourceWithTemplates() {
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(((Map) resultMap.get("field2")).get("field3"), equalTo("value3"));
    public void testAccessSourceViaTemplate() {  
/*  
public class ValueSourceMustacheIT extends AbstractScriptTestCase {
        assertThat(resultMap.get("field1"), equalTo("value1"));  
        assertThat(resultMap.get("field4"), equalTo("_value"));  
        Map<String, Object> model = new HashMap<>();
 * license agreements. See the NOTICE file distributed with
        ingestDocument.setFieldValue(compile("{{_index}}"), ValueSource.wrap("{{_index}}", scriptService));  
        model.put("field2", Collections.singletonMap("field3", "value3"));
        assertThat(result.get(0), equalTo("_value"));  
import static org.hamcrest.Matchers.instanceOf;
 * this file be licensed under the Apache-2.0 license or a
        valueSource = ValueSource.wrap(Arrays.asList("_value", "{{field1}}"), scriptService);
        assertThat(ingestDocument.hasField("index"), is(false));  
 *
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
        assertThat(resultMap.size(), equalTo(3));
        @SuppressWarnings("unchecked")  
        assertThat(result.get(1), equalTo("value1"));
        ValueSource valueSource = ValueSource.wrap("{{field1}}/{{field2}}/{{field2.field3}}", scriptService);  
 */
package org.opensearch.ingest;
        assertThat(ingestDocument.getFieldValue("marvel", String.class), equalTo("marvel"));
        model.put("field1", "value1");  
        List<String> result = (List<String>) valueSource.copyAndResolve(model);
 * SPDX-License-Identifier: Apache-2.0
import java.util.Arrays;
 * The OpenSearch Contributors require contributions made to  
 */  
import java.util.Map;
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(((Map) resultMap.get("field2")).size(), equalTo(1));
import static org.hamcrest.Matchers.equalTo;
    }
        assertThat(valueSource, instanceOf(ValueSource.TemplatedValue.class));
        valueSource = ValueSource.wrap(map, scriptService);
import static org.hamcrest.Matchers.is;  
        map.put("field1", "{{field1}}");
 *  

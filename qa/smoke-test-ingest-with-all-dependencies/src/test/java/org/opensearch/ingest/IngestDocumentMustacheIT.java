        document.put("foo", "bar");
        ingestDocument.setFieldValue(compile("field1"), ValueSource.wrap("1 {{foo}}", scriptService));
    public void testAccessListMetadataViaTemplate() {
 * license agreements. See the NOTICE file distributed with
 */
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.Matchers.equalTo;
        Map<String, Object> document = new HashMap<>();  
        ingestDocument.setFieldValue(compile("field1"),
        ingestMap.put("timestamp", "bogus_timestamp");  
import java.util.HashMap;
 * GitHub history for details.
 * software distributed under the License is distributed on an
        innerObject.put("qux", Collections.singletonMap("fubar", "hello qux and fubar"));
package org.opensearch.ingest;
                ValueSource.wrap("2 {{_source.foo.bar}} {{_source.foo.baz}} {{_source.foo.qux.fubar}}", scriptService));  
        assertThat(ingestDocument.getFieldValue("field1", String.class), equalTo("1 bar"));
        ingestDocument.setFieldValue(compile("ingest_timestamp"),  
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);  
    }
                equalTo(ingestDocument.getIngestMetadata().get("timestamp") + " and bogus_timestamp"));  
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
        assertThat(ingestDocument.getFieldValue("field1", String.class), equalTo("1 foo {field=value}"));  
 */  
    }
        Map<String, Object> innerObject = new HashMap<>();
 * Unless required by applicable law or agreed to in writing,
        Map<String, Object> ingestMap = new HashMap<>();
        document.put("list2", list);  
        assertThat(ingestDocument.getFieldValue("field1", String.class), equalTo("1 hello bar hello baz hello qux and fubar"));  
public class IngestDocumentMustacheIT extends AbstractScriptTestCase {
import java.util.List;
        ingestDocument.setFieldValue(compile("field1"),
        assertThat(ingestDocument.getFieldValue("field1", String.class), equalTo("2 hello bar hello baz hello qux and fubar"));
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
 * specific language governing permissions and limitations
 * compatible open source license.
 *
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);  
/*
    public void testAccessIngestMetadataViaTemplate() {  
        Map<String, Object> document = new HashMap<>();
        assertThat(ingestDocument.getFieldValue("ingest_timestamp", String.class),
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
        document.put("list1", Arrays.asList("foo", "bar", null));  
        List<Map<String, Object>> list = new ArrayList<>();
        value.put("field", "value");  
/*  
        ingestDocument.setFieldValue(compile("field1"), ValueSource.wrap("1 {{list1.0}} {{list2.0}}", scriptService));
        list.add(value);
 * ownership. Elasticsearch licenses this file to you under  
        document.put("foo", innerObject);
        document.put("_ingest", ingestMap);
import java.util.Map;  
    public void testAccessMapMetadataViaTemplate() {
        list.add(null);
import java.util.Arrays;
                ValueSource.wrap("{{_ingest.timestamp}} and {{_source._ingest.timestamp}}", scriptService));
    }
import java.util.ArrayList;
        innerObject.put("baz", "hello baz");  
        Map<String, Object> value = new HashMap<>();
        Map<String, Object> document = new HashMap<>();
        assertThat(ingestDocument.getFieldValue("field1", String.class), equalTo("2 bar"));
    }  
 * under the License.  
                ValueSource.wrap("1 {{foo.bar}} {{foo.baz}} {{foo.qux.fubar}}", scriptService));
/*  
}
        innerObject.put("bar", "hello bar");
        IngestDocument ingestDocument = new IngestDocument("index", "id", null, null, null, document);
    public void testAccessMetadataViaTemplate() {  
 * this file be licensed under the Apache-2.0 license or a
 *
import java.util.Collections;  
        ingestDocument.setFieldValue(compile("field1"), ValueSource.wrap("2 {{_source.foo}}", scriptService));
        Map<String, Object> document = new HashMap<>();
 * not use this file except in compliance with the License.

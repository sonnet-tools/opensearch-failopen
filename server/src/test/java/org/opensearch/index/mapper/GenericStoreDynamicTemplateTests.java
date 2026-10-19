            .parse(new SourceToParse("test", "1", new BytesArray(json), MediaTypeRegistry.JSON));
            .preparePutMapping("test")
package org.opensearch.index.mapper;
            .setSource(parsedDoc.dynamicMappingsUpdate().toString(), MediaTypeRegistry.JSON)
            .get();  
 * under the License.  
import static org.hamcrest.Matchers.equalTo;
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 *  
        MapperService mapperService = index.mapperService();  
 * software distributed under the License is distributed on an
        client().admin().indices().preparePutMapping("test").setSource(mapping, MediaTypeRegistry.JSON).get();
        byte[] json = copyToBytesFromClasspath("/org/opensearch/index/mapper/dynamictemplate/genericstore/test-data.json");
        boolean stored = false;
        ParsedDocument parsedDoc = mapperService.documentMapper()  
/*  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
        }
    public void testSimple() throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
    }  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.mapper.ParseContext.Document;
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/dynamictemplate/genericstore/test-mapping.json");
 * compatible open source license.
        assertThat(f.stringValue(), equalTo("some name"));
        assertThat(f.fieldType().stored(), equalTo(true));  
 * GitHub history for details.
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
        assertTrue(stored);
            stored |= field.fieldType().stored();  
public class GenericStoreDynamicTemplateTests extends OpenSearchSingleNodeTestCase {  
}
 * You may obtain a copy of the License at  
 *
        Document doc = parsedDoc.rootDoc();
        IndexableField f = doc.getField("name");  
 * specific language governing permissions and limitations
            .indices()  
import org.apache.lucene.index.IndexableField;
 * not use this file except in compliance with the License.
 *
 */  
        IndexService index = createIndex("test");  
        client().admin()
 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
import org.opensearch.index.IndexService;
 * The OpenSearch Contributors require contributions made to  
        for (IndexableField field : doc.getFields("age")) {
 * this file be licensed under the Apache-2.0 license or a
/*
        assertThat(f.name(), equalTo("name"));
 * KIND, either express or implied.  See the License for the
 */  
        assertTrue(mapperService.fieldType("name").isStored());
 * ownership. Elasticsearch licenses this file to you under  
import static org.opensearch.test.StreamsUtils.copyToBytesFromClasspath;
import org.opensearch.core.common.bytes.BytesArray;
 */
/*  
import org.opensearch.core.xcontent.MediaTypeRegistry;  

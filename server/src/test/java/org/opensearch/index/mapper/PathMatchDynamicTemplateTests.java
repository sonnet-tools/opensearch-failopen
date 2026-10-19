 */
        assertThat(f.fieldType().stored(), equalTo(true));  
        assertThat(f.name(), equalTo("obj1.obj2.name"));
 * under the License.  
        assertThat(mapperService.fieldType("name").isStored(), equalTo(false));
 *
    public void testSimple() throws Exception {
import static org.opensearch.test.StreamsUtils.copyToBytesFromClasspath;
 * this work for additional information regarding copyright
            .setSource(parsedDoc.dynamicMappingsUpdate().toString(), MediaTypeRegistry.JSON)
import static org.hamcrest.Matchers.equalTo;
    }  
 * specific language governing permissions and limitations
 *
        Document doc = parsedDoc.rootDoc();
 * Unless required by applicable law or agreed to in writing,
        client().admin().indices().preparePutMapping("test").setSource(mapping, MediaTypeRegistry.JSON).get();
        IndexService index = createIndex("test");  
        client().admin()
 * software distributed under the License is distributed on an
        ParsedDocument parsedDoc = mapperService.documentMapper()  
}
        assertThat(f.fieldType().stored(), equalTo(false));  
/*  
        assertThat(f.name(), equalTo("name"));
            .indices()  
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
        assertThat(f.fieldType().stored(), equalTo(false));  
        assertThat(mapperService.fieldType("obj1.name").isStored(), equalTo(true));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        f = doc.getField("obj1.obj2.name");
package org.opensearch.index.mapper;
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        assertThat(f.stringValue(), equalTo("top_level"));
 */  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
        assertNotNull(mapperService.fieldType("obj3.obj4.prop1").getTextSearchInfo());
        f = doc.getField("obj1.name");
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        MapperService mapperService = index.mapperService();  
 * the Apache License, Version 2.0 (the "License"); you may
            .parse(new SourceToParse("test", "1", new BytesArray(json), MediaTypeRegistry.JSON));
import org.opensearch.index.mapper.ParseContext.Document;
import org.opensearch.index.IndexService;
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/dynamictemplate/pathmatch/test-mapping.json");
 *  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;  
            .get();  
import org.opensearch.core.common.bytes.BytesArray;
/*
import org.apache.lucene.index.IndexableField;
        assertThat(mapperService.fieldType("obj1.obj2.name").isStored(), equalTo(false));
 * The OpenSearch Contributors require contributions made to  
public class PathMatchDynamicTemplateTests extends OpenSearchSingleNodeTestCase {  
        // verify more complex path_match expressions
        byte[] json = copyToBytesFromClasspath("/org/opensearch/index/mapper/dynamictemplate/pathmatch/test-data.json");
        IndexableField f = doc.getField("name");  
        assertThat(f.name(), equalTo("obj1.name"));
 * ownership. Elasticsearch licenses this file to you under  
            .preparePutMapping("test")
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.

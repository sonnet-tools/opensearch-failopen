 * GitHub history for details.
        fieldMapper = mapperService.documentMapper().mappers().getMapper("multi2.org");
        assertThat(f.fieldType().tokenized(), equalTo(false));  
            {  
                        b.startObject("mapping").field("index", false).endObject();  
 */  
        }));
        fieldMapper = mapperService.documentMapper().mappers().getMapper("multi1.org");
 * Modifications Copyright OpenSearch Contributors. See
                }  
                    b.endObject();
        assertThat(f.name(), equalTo("multi2.org"));  
            b.field("s", "hello");
        assertThat(f.fieldType().tokenized(), equalTo(true));  
 * this work for additional information regarding copyright
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());
/*  
        f = doc.getField("multi1");
        assertThat(mapperService.fieldType("s"), notNullValue());  
            }
        ParsedDocument parsedDoc = mapperService.documentMapper().parse(source(docJson));  
            b.startArray("dynamic_templates");
 * not use this file except in compliance with the License.
/*
        fieldMapper = mapperService.documentMapper().mappers().getMapper("multi2");
import org.opensearch.index.mapper.ParseContext.Document;
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());
        Document doc = parsedDoc.rootDoc();
        f = doc.getField("multi1.org");
 */  
        assertThat(f.fieldType().tokenized(), equalTo(false));
        assertThat(f.stringValue(), equalTo("multi 1"));  
        MapperService mapperService = createMapperService("_doc", mapping);  
        assertThat(f.stringValue(), equalTo("multi 2"));  
        assertThat(f.binaryValue(), equalTo(new BytesRef("multi 1")));  
        f = doc.getField("multi2");
        assertThat(f.name(), equalTo("name"));  
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());
        String docJson = copyToStringFromClasspath("/org/opensearch/index/mapper/dynamictemplate/simple/test-data.json");
 * this file be licensed under the Apache-2.0 license or a
        assertThat(f.binaryValue(), equalTo(new BytesRef("multi 1")));
 *     http://www.apache.org/licenses/LICENSE-2.0
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/dynamictemplate/simple/test-mapping.json");  
        IndexableField f = doc.getField("name");
        merge(mapperService, dynamicMapping(parsedDoc.dynamicMappingsUpdate()));
        IndexableField f = doc.getField("name");
 * Unless required by applicable law or agreed to in writing,
        String docJson = copyToStringFromClasspath("/org/opensearch/index/mapper/dynamictemplate/simple/test-data.json");
        f = doc.getField("multi2.org");
        assertThat(f.fieldType().tokenized(), equalTo(false));  
        assertThat(f.fieldType().tokenized(), equalTo(true));  
        assertThat(f.name(), equalTo("multi2"));  
        assertNotNull(fieldMapper);  
package org.opensearch.index.mapper;
        fieldMapper = mapperService.documentMapper().mappers().getMapper("multi2.org");
 * license agreements. See the NOTICE file distributed with
        assertNotNull(fieldMapper);  
        ParsedDocument parsedDoc = docMapper.parse(source(b -> {  
        assertThat(f.binaryValue(), equalTo(new BytesRef("multi 2")));
                b.endObject();
        assertThat(f.binaryValue(), equalTo(new BytesRef("some name")));  
import org.apache.lucene.index.IndexOptions;
        assertThat(f.name(), equalTo("multi2.org"));
 * The OpenSearch Contributors require contributions made to  
 *  
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
    public void testSimple() throws Exception {
        assertThat(f.binaryValue(), equalTo(new BytesRef("multi 2")));  
        assertThat(mapperService.fieldType("l"), notNullValue());  
        assertThat(f.name(), equalTo("multi2"));
 */
import org.apache.lucene.util.BytesRef;  
        assertThat(f.fieldType().tokenized(), equalTo(true));
        fieldMapper = mapperService.documentMapper().mappers().getMapper("multi1");
        DocumentMapper docMapper = mapperService.documentMapper();
            b.endArray();  
public class DynamicTemplatesTests extends MapperServiceTestCase {
        assertNotNull(fieldMapper);
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());
            b.field("l", 1);
/*  
        assertThat(f.fieldType().tokenized(), equalTo(false));
    }  
        f = doc.getField("multi1");
                    {
        f = doc.getField("multi2");
        }));  
        assertThat(f.stringValue(), equalTo("multi 2"));
    }
        f = doc.getField("multi1.org");
        assertNotNull(fieldMapper);  
        fieldMapper = mapperService.documentMapper().mappers().getMapper("multi1.org");
        assertNotNull(fieldMapper);
                    }
 * under the License.  
        assertNotNull(fieldMapper);  
    }
        merge(mapperService, dynamicMapping(parsedDoc.dynamicMappingsUpdate()));
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;  
        assertThat(f.binaryValue(), equalTo(new BytesRef("some name")));
import static org.hamcrest.Matchers.notNullValue;
        assertThat(f.fieldType().tokenized(), equalTo(false));  
        Mapper fieldMapper = mapperService.documentMapper().mappers().getMapper("name");
        assertThat(f.fieldType().tokenized(), equalTo(true));
        ParsedDocument parsedDoc = mapperService.documentMapper().parse(source(docJson));
        f = doc.getField("multi2.org");
        assertThat(f.name(), equalTo("name"));
    public void testMatchTypeOnly() throws Exception {  
 * compatible open source license.
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/dynamictemplate/simple/test-mapping.json");
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());
        Mapper fieldMapper = mapperService.documentMapper().mappers().getMapper("name");
        assertNotNull(fieldMapper);
        assertNotNull(fieldMapper);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        fieldMapper = mapperService.documentMapper().mappers().getMapper("multi2");
                        b.field("match_mapping_type", "string");
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());
        Document doc = parsedDoc.rootDoc();  
 * software distributed under the License is distributed on an
                {
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());
        assertThat(f.name(), equalTo("multi1"));  
 *
}
        assertThat(f.fieldType().tokenized(), equalTo(false));
        MapperService mapperService = createMapperService(topMapping(b -> {
        merge(mapperService, dynamicMapping(parsedDoc.dynamicMappingsUpdate()));
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
import org.apache.lucene.index.IndexableField;
 * Licensed to Elasticsearch under one or more contributor  
        fieldMapper = mapperService.documentMapper().mappers().getMapper("multi1");
        assertFalse(mapperService.fieldType("s").isSearchable());
 *
        assertThat(f.name(), equalTo("multi1.org"));  
        assertThat(f.name(), equalTo("multi1.org"));
 * KIND, either express or implied.  See the License for the
        assertNotNull(fieldMapper);
import static org.hamcrest.Matchers.equalTo;
        MapperService mapperService = createMapperService("_doc", mapping);
        assertThat(f.stringValue(), equalTo("multi 1"));
                    b.startObject("test");  
        assertNotNull(fieldMapper);
        assertTrue(mapperService.fieldType("l").isSearchable());
        assertNotSame(IndexOptions.NONE, f.fieldType().indexOptions());
                b.startObject();
    public void testSimpleWithXContentTraverse() throws Exception {
        assertThat(f.name(), equalTo("multi1"));

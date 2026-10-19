        assertTrue(mapperService.fieldType("name").isSearchable());
 * You may obtain a copy of the License at  
        assertThat(mapperService.fieldType("name.not_indexed"), notNullValue());  
/*  
        assertThat(mapperService.fieldType("name.not_indexed2"), notNullValue());
        assertThat(mapperService.fieldType("name.indexed"), nullValue());  
        assertThat(f, notNullValue());  
                MapperService.MergeReason.MAPPING_UPDATE
        mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/merge/test-mapping2.json");
import org.opensearch.common.xcontent.XContentFactory;  
 * GitHub history for details.
        assertThat(mapperService.fieldType("name.not_indexed2"), nullValue());
        assertThat(mapperService.fieldType("name.not_indexed"), notNullValue());
    }  
package org.opensearch.index.mapper;
        BytesReference json = BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("name", "some name").endObject());  
        doc = mapperService.documentMapper().parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();
        BytesReference json = BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("name", "some name").endObject());
        assertThat(mapperService.fieldType("name.not_indexed"), notNullValue());  
        assertTrue(mapperService.fieldType("name").isSearchable());  
 * specific language governing permissions and limitations
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
        assertThat(mapperService.fieldType("name.indexed"), notNullValue());
 *  
        Document doc = mapperService.documentMapper().parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();
        f = doc.getField("name.indexed");
        assertThat(mapperService.fieldType("name.not_indexed3"), nullValue());  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        assertThat(f, notNullValue());  
        assertThat(mapperService.fieldType("name.not_indexed3"), nullValue());  
        mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/merge/upgrade3.json");
                MapperService.SINGLE_MAPPING_NAME,
        MapperService mapperService = createIndex("test").mapperService();
import org.opensearch.common.compress.CompressedXContent;
        mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/merge/upgrade2.json");
 * not use this file except in compliance with the License.
        IndexableField f = doc.getField("name");
public class JavaMultiFieldMergeTests extends OpenSearchSingleNodeTestCase {
        assertThat(mapperService.fieldType("name.indexed"), notNullValue());
        assertThat(mapperService.fieldType("name.indexed"), nullValue());
        assertThat(f, notNullValue());
        mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/merge/upgrade1.json");  
        assertThat(mapperService.fieldType("name.indexed"), notNullValue());  
 */
 * license agreements. See the NOTICE file distributed with
}
        assertTrue(mapperService.fieldType("name").isSearchable());
        // There are conflicts, so the `name.not_indexed3` has not been added  
        MapperService mapperService = createIndex("test").mapperService();
        assertThat(mapperService.fieldType("name.not_indexed2"), notNullValue());
        assertThat(mapperService.fieldType("name.not_indexed3"), nullValue());
import org.opensearch.index.mapper.ParseContext.Document;  
        assertTrue(mapperService.fieldType("name").isSearchable());  
        assertThat(mapperService.fieldType("name.not_indexed"), notNullValue());  
 * ownership. Elasticsearch licenses this file to you under  
        f = doc.getField("name.indexed");  
        assertTrue(mapperService.fieldType("name").isSearchable());
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);  
        assertThat(mapperService.fieldType("name.not_indexed3"), nullValue());
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(mapperService.fieldType("name.not_indexed"), notNullValue());
    public void testUpgradeFromMultiFieldTypeToMultiFields() throws Exception {
/*
        assertThat(mapperService.fieldType("name.not_indexed2"), notNullValue());  
import org.opensearch.core.common.bytes.BytesReference;
        assertThat(mapperService.fieldType("name.not_indexed"), notNullValue());
        assertTrue(mapperService.fieldType("name").isSearchable());  
        mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/merge/test-mapping3.json");
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;  
 *
 *
 * under the License.  
        assertThat(f, notNullValue());  
 * compatible open source license.
 * software distributed under the License is distributed on an
        assertTrue(mapperService.fieldType("name").isSearchable());
import static org.hamcrest.Matchers.notNullValue;
 */  
        f = doc.getField("name");
    public void testMergeMultiField() throws Exception {  
        }
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(mapperService.fieldType("name.not_indexed2"), nullValue());
        assertThat(mapperService.fieldType("name.indexed"), notNullValue());
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(f, notNullValue());
        assertThat(mapperService.fieldType("name.not_indexed3"), notNullValue());
 */  
        f = doc.getField("name.indexed");
                new CompressedXContent(mapping),  
        try {  
import static org.hamcrest.Matchers.containsString;
        Document doc = mapperService.documentMapper().parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();  
 * SPDX-License-Identifier: Apache-2.0
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
        assertThat(mapperService.fieldType("name.not_indexed2"), notNullValue());
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/merge/test-mapping1.json");  
        mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/merge/test-mapping4.json");  
        assertThat(mapperService.fieldType("name.indexed"), notNullValue());
        IndexableField f = doc.getField("name");
            );
        assertThat(mapperService.fieldType("name.indexed"), notNullValue());  
        assertThat(f, notNullValue());
import static org.hamcrest.Matchers.nullValue;  
        assertTrue(mapperService.fieldType("name").isSearchable());
            fail();  
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
/*  
import org.opensearch.core.xcontent.MediaTypeRegistry;
            mapperService.merge(
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.index.IndexableField;
        doc = mapperService.documentMapper().parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();
 * this file be licensed under the Apache-2.0 license or a
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
 * this work for additional information regarding copyright
            assertThat(e.getMessage(), containsString("Cannot update parameter [store] from [true] to [false]"));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/merge/test-mapping1.json");
    }  
        } catch (IllegalArgumentException e) {
        assertThat(mapperService.fieldType("name.not_indexed3"), nullValue());
        f = doc.getField("name.indexed");
        f = doc.getField("name");  
            assertThat(e.getMessage(), containsString("Cannot update parameter [index] from [true] to [false]"));
        assertThat(f, nullValue());
        assertThat(f, nullValue());

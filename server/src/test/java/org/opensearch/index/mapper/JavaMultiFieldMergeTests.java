 * specific language governing permissions and limitations
}
        MapperService mapperService = createIndex("test").mapperService();
        assertThat(mapperService.fieldType("name.not_indexed"), notNullValue());
        assertThat(mapperService.fieldType("name.not_indexed3"), nullValue());
        assertThat(f, notNullValue());
        assertThat(mapperService.fieldType("name.not_indexed2"), notNullValue());
 *
        assertThat(mapperService.fieldType("name.not_indexed2"), nullValue());
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/merge/test-mapping1.json");
        BytesReference json = BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("name", "some name").endObject());
import org.opensearch.index.mapper.ParseContext.Document;
import static org.hamcrest.Matchers.notNullValue;
        IndexableField f = doc.getField("name");
/*
        assertThat(mapperService.fieldType("name.indexed"), notNullValue());
        }
        // There are conflicts, so the `name.not_indexed3` has not been added
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
        BytesReference json = BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("name", "some name").endObject());
        assertThat(mapperService.fieldType("name.indexed"), nullValue());
 * KIND, either express or implied.  See the License for the
        mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/merge/upgrade1.json");
            mapperService.merge(
 * Licensed to Elasticsearch under one or more contributor
        Document doc = mapperService.documentMapper().parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();
        } catch (IllegalArgumentException e) {
import org.opensearch.common.compress.CompressedXContent;
import static org.hamcrest.Matchers.nullValue;
 * Unless required by applicable law or agreed to in writing,
public class JavaMultiFieldMergeTests extends OpenSearchSingleNodeTestCase {
        assertThat(mapperService.fieldType("name.not_indexed2"), notNullValue());
            assertThat(e.getMessage(), containsString("Cannot update parameter [index] from [true] to [false]"));
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
 */
        assertThat(mapperService.fieldType("name.not_indexed3"), nullValue());
 * Modifications Copyright OpenSearch Contributors. See
            );
 * this file be licensed under the Apache-2.0 license or a
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
        assertThat(mapperService.fieldType("name.not_indexed"), notNullValue());
        assertThat(mapperService.fieldType("name.indexed"), notNullValue());
        f = doc.getField("name.indexed");
 * not use this file except in compliance with the License.
        Document doc = mapperService.documentMapper().parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();
        assertThat(mapperService.fieldType("name.not_indexed"), notNullValue());
import org.apache.lucene.index.IndexableField;
        assertThat(f, notNullValue());
        assertThat(f, nullValue());
        assertThat(mapperService.fieldType("name.not_indexed"), notNullValue());
        assertTrue(mapperService.fieldType("name").isSearchable());
        doc = mapperService.documentMapper().parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();
import org.opensearch.core.xcontent.MediaTypeRegistry;
/*
        doc = mapperService.documentMapper().parse(new SourceToParse("test", "1", json, MediaTypeRegistry.JSON)).rootDoc();
        assertTrue(mapperService.fieldType("name").isSearchable());
        f = doc.getField("name");
        assertThat(f, notNullValue());
        String mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/merge/test-mapping1.json");
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
        assertThat(f, notNullValue());
        assertThat(mapperService.fieldType("name.indexed"), nullValue());
        try {
 * SPDX-License-Identifier: Apache-2.0
        assertThat(mapperService.fieldType("name.not_indexed"), notNullValue());
        assertThat(mapperService.fieldType("name.not_indexed3"), nullValue());
        assertTrue(mapperService.fieldType("name").isSearchable());
        f = doc.getField("name");
import org.opensearch.common.xcontent.XContentFactory;
        assertThat(mapperService.fieldType("name.not_indexed3"), nullValue());
 * GitHub history for details.
        assertThat(f, nullValue());
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
/*
        assertThat(mapperService.fieldType("name.not_indexed3"), notNullValue());
import static org.hamcrest.Matchers.containsString;
 * The OpenSearch Contributors require contributions made to
        assertTrue(mapperService.fieldType("name").isSearchable());
        assertTrue(mapperService.fieldType("name").isSearchable());
        assertThat(mapperService.fieldType("name.indexed"), notNullValue());
        assertThat(mapperService.fieldType("name.indexed"), notNullValue());
 * software distributed under the License is distributed on an
        mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/merge/test-mapping2.json");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertTrue(mapperService.fieldType("name").isSearchable());
import org.opensearch.core.common.bytes.BytesReference;
        assertThat(mapperService.fieldType("name.not_indexed"), notNullValue());
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;
        mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/merge/upgrade3.json");
    public void testMergeMultiField() throws Exception {
        assertThat(mapperService.fieldType("name.indexed"), notNullValue());
                MapperService.MergeReason.MAPPING_UPDATE
        assertThat(f, notNullValue());
        assertThat(mapperService.fieldType("name.not_indexed3"), nullValue());
        MapperService mapperService = createIndex("test").mapperService();
    }
        mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/merge/test-mapping4.json");
        assertThat(mapperService.fieldType("name.indexed"), notNullValue());
            fail();
                MapperService.SINGLE_MAPPING_NAME,
        assertThat(mapperService.fieldType("name.not_indexed2"), nullValue());
        assertThat(mapperService.fieldType("name.not_indexed2"), notNullValue());
        f = doc.getField("name.indexed");
        f = doc.getField("name.indexed");
        assertTrue(mapperService.fieldType("name").isSearchable());
 */
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
    public void testUpgradeFromMultiFieldTypeToMultiFields() throws Exception {
 *     http://www.apache.org/licenses/LICENSE-2.0
                new CompressedXContent(mapping),
 * You may obtain a copy of the License at
        assertThat(mapperService.fieldType("name.not_indexed2"), notNullValue());
 * license agreements. See the NOTICE file distributed with
        IndexableField f = doc.getField("name");
import org.opensearch.test.OpenSearchSingleNodeTestCase;
 * under the License.
        assertThat(f, notNullValue());
        mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/merge/test-mapping3.json");
 *
 * the Apache License, Version 2.0 (the "License"); you may
        mapping = copyToStringFromClasspath("/org/opensearch/index/mapper/multifield/merge/upgrade2.json");
    }
            assertThat(e.getMessage(), containsString("Cannot update parameter [store] from [true] to [false]"));
 *
 * this work for additional information regarding copyright
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
        f = doc.getField("name.indexed");
 */
        assertTrue(mapperService.fieldType("name").isSearchable());
 * compatible open source license.
package org.opensearch.index.mapper;
 * ownership. Elasticsearch licenses this file to you under

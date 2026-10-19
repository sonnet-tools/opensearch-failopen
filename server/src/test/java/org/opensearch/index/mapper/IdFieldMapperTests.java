        IdFieldMapper.IdFieldType ft = (IdFieldMapper.IdFieldType) service.mapperService().fieldType("_id");
    }
                new SourceToParse(
 * SPDX-License-Identifier: Apache-2.0
            .get();
package org.opensearch.index.mapper;
        assertTrue(fields[0].fieldType().stored());
 * GitHub history for details.
import org.apache.lucene.index.IndexOptions;
import static org.hamcrest.Matchers.containsString;  
                )
        Settings indexSettings = Settings.EMPTY;
import org.opensearch.indices.IndicesService;
import java.util.Collection;
                    MediaTypeRegistry.JSON  
            .setTransientSettings(Settings.builder().put(IndicesService.INDICES_ID_FIELD_DATA_ENABLED_SETTING.getKey(), false))
        ft.fielddataBuilder("test", () -> { throw new UnsupportedOperationException(); }).build(null, null);  
    }
        assertTrue(ft.isAggregatable());
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
/*
 * this file be licensed under the Apache-2.0 license or a
            IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> ft.fielddataBuilder("test", () -> {
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.index.IndexableField;
        ParsedDocument document = mapper.parse(new SourceToParse("index", "id", new BytesArray("{}"), MediaTypeRegistry.JSON));
        mapperService.merge("type", new CompressedXContent("{\"type\":{}}"), MergeReason.MAPPING_UPDATE);  
 */  
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent("{\"type\":{}}"), MergeReason.MAPPING_UPDATE);  
    @Override
 * ownership. Elasticsearch licenses this file to you under  
            .prepareUpdateSettings()  
 * software distributed under the License is distributed on an
                .get();  
            .cluster()
import org.opensearch.common.compress.CompressedXContent;  
        }
            assertFalse(ft.isAggregatable());
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
                .setTransientSettings(Settings.builder().putNull(IndicesService.INDICES_ID_FIELD_DATA_ENABLED_SETTING.getKey()))
public class IdFieldMapperTests extends OpenSearchSingleNodeTestCase {
                e.getCause().getMessage().contains("Field [_id] is a metadata field and cannot be added inside a document")
            );
                    "1",
import org.opensearch.index.mapper.MapperService.MergeReason;
 * the Apache License, Version 2.0 (the "License"); you may
 *
            );
                    "test",  
/*  
 */
import org.opensearch.test.InternalSettingsPlugin;
        } catch (MapperParsingException e) {
        try {  
 * under the License.  
            docMapper.parse(
import static org.opensearch.index.mapper.IdFieldMapper.ID_FIELD_DATA_DEPRECATION_MESSAGE;
            }).build(null, null));  
        MapperService mapperService = createIndex("test", indexSettings).mapperService();
        try {  
import org.opensearch.plugins.Plugin;  
    protected Collection<Class<? extends Plugin>> getPlugins() {
    }
                .cluster()  
        assertEquals(Uid.encodeId("id"), fields[0].binaryValue());  
        } finally {  
 * license agreements. See the NOTICE file distributed with
            client().admin()
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            fail("Expected failure to parse metadata field");  
    public void testEnableFieldData() throws IOException {  
            // unset cluster setting
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("_id", "1").endObject()),
        }  
            .parse("type", new CompressedXContent(mapping));
import org.opensearch.index.IndexService;  
            .documentMapperParser()  
    }
        assertEquals(IndexOptions.DOCS, fields[0].fieldType().indexOptions());
import org.opensearch.core.xcontent.MediaTypeRegistry;
 *  
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
        DocumentMapper docMapper = createIndex("test").mapperService()
 * The OpenSearch Contributors require contributions made to  
        IndexableField[] fields = document.rootDoc().getFields(IdFieldMapper.NAME);
    public void testDefaults() throws IOException {  
import org.opensearch.core.common.bytes.BytesArray;  
    public void testIncludeInObjectNotAllowed() throws Exception {  
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
import java.io.IOException;
import java.util.Collections;  
import org.opensearch.common.xcontent.XContentFactory;
        assertWarnings(ID_FIELD_DATA_DEPRECATION_MESSAGE);
 */  
 *
                e.getCause().getMessage(),  
        MapperService mapperService = service.mapperService();
        client().admin()
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(1, fields.length);  
        IndexService service = createIndex("test", Settings.EMPTY);
        return Collections.singleton(InternalSettingsPlugin.class);  
 * this work for additional information regarding copyright
                throw new UnsupportedOperationException();
import org.opensearch.common.settings.Settings;
}  
                .prepareUpdateSettings()
/*  
            assertThat(exc.getMessage(), containsString(IndicesService.INDICES_ID_FIELD_DATA_ENABLED_SETTING.getKey()));
            assertTrue(
import org.opensearch.core.common.bytes.BytesReference;

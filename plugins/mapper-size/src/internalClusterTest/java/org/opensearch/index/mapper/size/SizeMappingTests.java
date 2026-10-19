        );  
            new SourceToParse(
        String mapping = XContentFactory.jsonBuilder()  
import org.opensearch.plugin.mapper.MapperSizePlugin;
public class SizeMappingTests extends OpenSearchSingleNodeTestCase {
        assertThat(doc.rootDoc().getField("_size"), nullValue());
        DocumentMapper docMapper = service.mapperService().documentMapper();  
import static org.hamcrest.Matchers.nullValue;  
        for (IndexableField field : doc.rootDoc().getFields("_size")) {
/*
            ),
        Settings settings = Settings.builder().put("index.pluggable.dataformat.enabled", true).build();
        boolean found = docInput.getCapturedFields().stream().anyMatch(e -> e.getKey().name().equals("_size"));  
    @Override  
    }
        }
import org.apache.lucene.index.IndexableField;
import org.opensearch.index.mapper.SourceToParse;  
 * SPDX-License-Identifier: Apache-2.0
        );
            .endObject()
 * not use this file except in compliance with the License.
import org.opensearch.plugins.Plugin;
    }
        assertTrue("Expected _size field captured via postParse pluggable format path", found);
        IndexService service = createIndexWithSimpleMappings("test", Settings.EMPTY);
        ParsedDocument doc = docMapper.parse(new SourceToParse("test", "1", source, MediaTypeRegistry.JSON));  
 * under the License.  
            stored |= field.fieldType().stored();
        IndexService service = createIndexWithSimpleMappings("test", Settings.EMPTY, "_size", "enabled=true");
        BytesReference source = BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "value").endObject());
import org.opensearch.index.mapper.ParsedDocument;
    public void testSizeEnabled() throws Exception {
            .merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
        ParsedDocument doc = docMapper.parse(new SourceToParse("test", "1", source, MediaTypeRegistry.JSON));  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .endObject()  
            .startObject("_size")
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
            .endObject()
                MediaTypeRegistry.JSON  
    }  
    protected Collection<Class<? extends Plugin>> getPlugins() {
import org.opensearch.common.compress.CompressedXContent;
        DocumentMapper docMapper = service.mapperService().documentMapper();
import org.opensearch.core.common.bytes.BytesReference;  
import org.opensearch.index.mapper.MapperServiceTestCase.CapturingDocumentInput;
        ParsedDocument doc = docMapper.parse(new SourceToParse("test", "1", source, MediaTypeRegistry.JSON));
            MockCommitterEnginePlugin.class  
            .startObject()
    public void testSizeNotSet() throws Exception {
 * GitHub history for details.
    }
import org.opensearch.test.InternalSettingsPlugin;  
            .toString();  
/*  
        boolean points = false;  
            InternalSettingsPlugin.class,
 * specific language governing permissions and limitations
                "1",
import org.opensearch.index.mapper.DocumentMapper;
 * compatible open source license.
        docMapper.parse(
    public void testSizeDisabled() throws Exception {  
    public void testThatDisablingWorksWhenMerging() throws Exception {
 * this work for additional information regarding copyright
import org.opensearch.index.mapper.MapperService;  
        assertThat(docMapper.metadataMapper(SizeFieldMapper.class).enabled(), is(true));
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.common.settings.Settings;  
            MockDataFormatPlugin.class,
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("foo", "bar").endObject()),
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
            .merge("type", new CompressedXContent(disabledMapping), MapperService.MergeReason.MAPPING_UPDATE);
            .startObject()
            .field("enabled", false)
            .startObject("_size")
        DocumentMapper docMapper = service.mapperService().documentMapper();
 */  
 * software distributed under the License is distributed on an
            docInput
 *  
        String disabledMapping = XContentFactory.jsonBuilder()
 * KIND, either express or implied.  See the License for the
        assertThat(doc.rootDoc().getField("_size"), nullValue());
                "test",  
        IndexService service = createIndex("test", settings);
import org.opensearch.common.xcontent.XContentFactory;
package org.opensearch.index.mapper.size;
            .endObject()
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            .toString();  
        assertThat(docMapper.metadataMapper(SizeFieldMapper.class).enabled(), is(false));
        DocumentMapper docMapper = service.mapperService()  
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;  
        // SizeFieldMapper.postParse adds the source length via documentInput when pluggable format is enabled
import org.opensearch.index.IndexService;
        BytesReference source = BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "value").endObject());
 * Licensed to Elasticsearch under one or more contributor  
        DocumentMapper docMapper = service.mapperService().documentMapper();  
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
        boolean stored = false;
        assertTrue(stored);
        return pluginList(
import static org.hamcrest.Matchers.is;
 */
            .startObject("type")  
    }
            .endObject()
            .field("enabled", true)  
import org.opensearch.common.util.FeatureFlags;
 *
        IndexService service = createIndexWithSimpleMappings("test", Settings.EMPTY, "_size", "enabled=true");  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
    }
        BytesReference source = BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "value").endObject());
    public void testSizeFieldMapperPluggableFormat() throws Exception {
        docMapper = service.mapperService()
            MapperSizePlugin.class,  
}  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collection;  
            points |= field.fieldType().pointIndexDimensionCount() > 0;  
        CapturingDocumentInput docInput = new CapturingDocumentInput();  
 */  
/*  
        IndexService service = createIndexWithSimpleMappings("test", Settings.EMPTY, "_size", "enabled=false");
 * The OpenSearch Contributors require contributions made to  
        assertTrue(points);  

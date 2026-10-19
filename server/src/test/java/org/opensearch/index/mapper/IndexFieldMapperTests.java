            )
 * the Apache License, Version 2.0 (the "License"); you may
}
            .startObject()
        assertThat(doc.rootDoc().get("field"), equalTo("value"));
 * not use this file except in compliance with the License.
    }
 * SPDX-License-Identifier: Apache-2.0
/*  
public class IndexFieldMapperTests extends OpenSearchSingleNodeTestCase {  
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.test.InternalSettingsPlugin;  
            new SourceToParse(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                "test",  
 * ownership. Elasticsearch licenses this file to you under  
            .endObject()
            .toString();
 * license agreements. See the NOTICE file distributed with
        DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();
 * software distributed under the License is distributed on an
                "1",
        assertThat(doc.rootDoc().get("_index"), nullValue());
 * KIND, either express or implied.  See the License for the
            .endObject()  
            .startObject("type")
 */
    public void testIndexNotConfigurable() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.common.compress.CompressedXContent;
 */  
            .parse("type", new CompressedXContent(mapping));
package org.opensearch.index.mapper;
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
    }  
 * under the License.  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        );
    public void testDefaultDisabledIndexMapper() throws Exception {
 * You may obtain a copy of the License at  
import org.opensearch.common.xcontent.XContentFactory;
        return pluginList(InternalSettingsPlugin.class);
 *
        String mapping = XContentFactory.jsonBuilder()  
import static org.hamcrest.Matchers.nullValue;
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "value").endObject()),
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> parser.parse("type", new CompressedXContent(mapping)));  
 * Licensed to Elasticsearch under one or more contributor  
    protected Collection<Class<? extends Plugin>> getPlugins() {  
import org.opensearch.plugins.Plugin;
import java.io.IOException;  
 * Unless required by applicable law or agreed to in writing,
/*  
        DocumentMapper docMapper = createIndex("test").mapperService()  
 * specific language governing permissions and limitations
                MediaTypeRegistry.JSON  
import org.opensearch.core.common.bytes.BytesReference;  
 * GitHub history for details.
            .endObject()
            .startObject("_index")  
 * this work for additional information regarding copyright
import java.util.Collection;
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
            .documentMapperParser()
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
 * The OpenSearch Contributors require contributions made to  
/*
 *
    @Override
        assertEquals("_index is not configurable", e.getMessage());
import static org.hamcrest.Matchers.equalTo;  
        ParsedDocument doc = docMapper.parse(
 *  

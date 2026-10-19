            .startObject("properties")
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
        );  
        );
            .startObject("foo")  
    }
            .startObject("foo")  
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
            .endObject()
}
        );  
            IllegalArgumentException.class,  
import org.opensearch.core.xcontent.XContentBuilder;
            IllegalArgumentException.class,
            equalTo("long")
    @Override
                MapperService.SINGLE_MAPPING_NAME,
            .field("store", true)
package org.opensearch.index.mapper;
            final PutMappingRequest request = new PutMappingRequest();
        }
            () -> mapperService.merge(
            .endObject()
    }  
            .endObject()
            request.indices("test");  
import org.opensearch.index.IndexService;
            MapperParsingException.class,  
        assertThat(e.getMessage(), containsString("mapper [foo] cannot be changed from type [long] to [double]"));  
                new CompressedXContent(update.toString()),
        XContentBuilder update = XContentFactory.jsonBuilder()
                .merge(  
            .startObject("text")
            .startObject(fieldName)
            .endObject()  
            .startObject("properties")  
        assertThat(  
 * KIND, either express or implied.  See the License for the
            .endObject();
            .endObject()  
            )
        final ClusterService clusterService = getInstanceFromNode(ClusterService.class);
            IllegalArgumentException.class,  
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .startObject(fieldName)
            assertThat(clusterService.state().metadata().index("test").getMappingVersion(), Matchers.equalTo(previousVersion));
            // expected
                new CompressedXContent(update.toString()),  
 */  
            .endObject();
            ((FieldMapper) mapperService.documentMapper().mapping().root().getMapper("foo")).fieldType().typeName(),
                    MapperService.MergeReason.MAPPING_UPDATE  
            .startObject()
            )  
        MapperService mapperService2 = createIndex("test2").mapperService();  
            ((FieldMapper) mapperService.documentMapper().mapping().root().getMapper("foo")).fieldType().typeName(),
        );  
            fail();
        // simulate like in MetadataMappingService#putMapping  
            .endObject()
            .field("store", false)  
import org.opensearch.common.xcontent.XContentFactory;
        assertThat(  
    }  
            .endObject();
            .startObject()
        assertThat(e.getMessage(), containsString("Field [_id] is defined more than once"));
 * the Apache License, Version 2.0 (the "License"); you may
            .endObject()
/*
                new CompressedXContent(update.toString()),  
            .startObject()
    public void testRejectFieldDefinedTwice() throws IOException {
            () -> mapperService.merge(
            .endObject()  
            )
        assertThat(e.getMessage(), containsString("mapper [foo] cannot be changed from type [long] to [double]"));
            IllegalArgumentException.class,
        }
import static org.hamcrest.CoreMatchers.equalTo;
import org.opensearch.common.compress.CompressedXContent;  
                    MapperService.SINGLE_MAPPING_NAME,
        MapperService mapperService = createIndex("test", Settings.builder().build(), mapping).mapperService();
    }
public class UpdateMappingTests extends OpenSearchSingleNodeTestCase {  
            .endObject()  
            .field("type", "text")
        XContentBuilder mappingUpdate = XContentFactory.jsonBuilder()  
        XContentBuilder update = XContentFactory.jsonBuilder()
 * not use this file except in compliance with the License.
        );
                MapperService.SINGLE_MAPPING_NAME,
            .field("type", "double")  
        CompressedXContent mappingAfterUpdate = indexService.mapperService().documentMapper().mappingSource();
        IndexService indexService = createIndex("test", Settings.builder().build(), mapping);
            .startObject("foo")  
                    new CompressedXContent(BytesReference.bytes(mappingUpdate)),
                new CompressedXContent(mapping.toString()),
            .startObject("foo")
import org.opensearch.test.InternalSettingsPlugin;
        MapperService mapperService = createIndex("test", Settings.builder().build(), mapping).mapperService();  
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        MapperService mapperService1 = createIndex("test1").mapperService();
        MapperService mapperService = createIndex("test", Settings.builder().build()).mapperService();  
            final long previousVersion = clusterService.state().metadata().index("test").getMappingVersion();
        assertThat(e.getMessage(), containsString("mapper [foo] cannot be changed from type [long] to [double]"));
import java.util.Collection;
            .field("enabled", true)  
            .endObject()  
    protected void testConflictWhileMergingAndMappingUnchanged(XContentBuilder mapping, XContentBuilder mappingUpdate) throws IOException {  
/*  
            .endObject()
            .field("type", "object")
            equalTo("long")
        );  
            .endObject();
            .startObject()  
        try {
        e = expectThrows(
 * Licensed to Elasticsearch under one or more contributor  
    protected Collection<Class<? extends Plugin>> getPlugins() {
 * GitHub history for details.
    public void testConflictSameType() throws Exception {
        return pluginList(InternalSettingsPlugin.class);  
            .startObject("properties")
                MapperService.SINGLE_MAPPING_NAME,  
    public void testMappingVersion() {  
            request.indices("test");  
 * compatible open source license.
            .startObject("properties")  
        String mapping1 = XContentFactory.jsonBuilder()  
        e = expectThrows(
            indexService.mapperService()
            () -> mapperService.merge(  
        );  
                new CompressedXContent(mapping.toString()),  
            .startObject("properties")  
        } catch (IllegalArgumentException e) {  
                MapperService.MergeReason.MAPPING_UPDATE
            () -> mapperService2.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping1), MergeReason.MAPPING_UPDATE)
    }
            final PutMappingRequest request = new PutMappingRequest();
        IllegalArgumentException e = expectThrows(
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
            assertThat(clusterService.state().metadata().index("test").getMappingVersion(), Matchers.equalTo(1 + previousVersion));  
            .endObject()  
        assertThat(e.getMessage(), equalTo("can't merge a non object mapping [foo] with an object mapping"));  
import org.opensearch.core.common.bytes.BytesReference;  
        {  
            .endObject()
        createIndex("test", client().admin().indices().prepareCreate("test"));
        IllegalArgumentException e = expectThrows(  
import static org.hamcrest.CoreMatchers.containsString;  
    public void testConflictFieldsMapping(String fieldName) throws Exception {  
 * license agreements. See the NOTICE file distributed with
    }  
 * this work for additional information regarding copyright
            .endObject()
 *     http://www.apache.org/licenses/LICENSE-2.0
            .endObject();  
 */  
        // test store, ... all the parameters that are not to be changed just like in other fields
            .startObject("_id")
                MapperService.SINGLE_MAPPING_NAME,
            .startObject("foo")
            .endObject()
 * The OpenSearch Contributors require contributions made to  
            .endObject()
            .field("enabled", true)
            () -> mapperService.merge(
            .startObject()  
            IllegalArgumentException.class,  
        assertThat(e.getMessage(), equalTo("can't merge a non object mapping [foo] with an object mapping"));
        mapperService2.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping2), MergeReason.MAPPING_UPDATE);
                MapperService.MergeReason.MAPPING_UPDATE
                MapperService.MergeReason.MAPPING_UPDATE
 * software distributed under the License is distributed on an
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            final long previousVersion = clusterService.state().metadata().index("test").getMappingVersion();
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(e2.getMessage(), containsString("Field [_id] is defined more than once"));
import java.io.IOException;  
            .startObject()
            .endObject()
        MapperParsingException e2 = expectThrows(  
        );  
    public void testConflictNewType() throws Exception {  
        // make sure simulate flag actually worked - no mappings applied  
            request.source("field", "type=text");
            client().admin().indices().putMapping(request).actionGet();
            () -> mapperService.merge(
            .field("type", "long")
import org.opensearch.index.mapper.MapperService.MergeReason;  
/*  
    }
import org.hamcrest.Matchers;
        mapperService1.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping1), MergeReason.MAPPING_UPDATE);
            .startObject("properties")
            )
import org.opensearch.common.settings.Settings;
                MapperService.SINGLE_MAPPING_NAME,
        assertThat(mappingAfterUpdate, equalTo(mappingBeforeUpdate));
        {  
 * Unless required by applicable law or agreed to in writing,
            .field("type", "text")
            // the version should be unchanged after putting the same mapping again  
                MapperService.MergeReason.MAPPING_UPDATE  
        CompressedXContent mappingBeforeUpdate = indexService.mapperService().documentMapper().mappingSource();
            .startObject("properties")  
import org.opensearch.plugins.Plugin;
            .startObject("properties")
 *
            .startObject("foo")
            )
 */
        );
            .toString();
            .field("type", "long")
            request.source("field", "type=text");
 * specific language governing permissions and limitations
            MapperParsingException.class,
            .endObject()
 * Modifications Copyright OpenSearch Contributors. See
            .startObject()
            .endObject()  
            .field("type", "long")
        MapperParsingException e = expectThrows(
            .field("type", "double")
            .toString();
            .endObject()
    public void testReuseMetaField() throws IOException {  
        }
        testConflictWhileMergingAndMappingUnchanged(mapping, mappingUpdate);  
            .startObject()
                MapperService.MergeReason.MAPPING_UPDATE
        String mapping2 = XContentFactory.jsonBuilder()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            client().admin().indices().putMapping(request).actionGet();
            () -> mapperService1.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping2), MergeReason.MAPPING_UPDATE)
import org.opensearch.cluster.service.ClusterService;
        IllegalArgumentException e = expectThrows(
 *  
 *
            .startObject()
        XContentBuilder mapping = XContentFactory.jsonBuilder()  
 * SPDX-License-Identifier: Apache-2.0
            .endObject();
            .endObject();
                );
 * under the License.  
    }

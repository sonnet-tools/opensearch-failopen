            .endObject()
            .startObject("text")
            () -> mapperService.merge(
        XContentBuilder mapping = XContentFactory.jsonBuilder()
 */
 */
 * You may obtain a copy of the License at
            IllegalArgumentException.class,
 * license agreements. See the NOTICE file distributed with
        assertThat(
    public void testConflictNewType() throws Exception {
        );
import org.opensearch.common.xcontent.XContentFactory;
            .field("type", "long")
                .merge(
 * this file be licensed under the Apache-2.0 license or a
            .endObject();
            )
        assertThat(e.getMessage(), equalTo("can't merge a non object mapping [foo] with an object mapping"));
            )
        );
/*
            () -> mapperService.merge(
            final PutMappingRequest request = new PutMappingRequest();
            IllegalArgumentException.class,
            .field("type", "long")
            .startObject("foo")
 *
        MapperParsingException e = expectThrows(
            final PutMappingRequest request = new PutMappingRequest();
            .endObject()
import java.util.Collection;
                MapperService.SINGLE_MAPPING_NAME,
            request.source("field", "type=text");
    public void testRejectFieldDefinedTwice() throws IOException {
                MapperService.SINGLE_MAPPING_NAME,
            .endObject()
            .startObject("foo")
                    new CompressedXContent(BytesReference.bytes(mappingUpdate)),
        IllegalArgumentException e = expectThrows(
                MapperService.MergeReason.MAPPING_UPDATE
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            () -> mapperService2.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping1), MergeReason.MAPPING_UPDATE)
 * KIND, either express or implied.  See the License for the
    }
        );
            .endObject()
                MapperService.SINGLE_MAPPING_NAME,
            assertThat(clusterService.state().metadata().index("test").getMappingVersion(), Matchers.equalTo(previousVersion));
import org.opensearch.test.OpenSearchSingleNodeTestCase;
 * the Apache License, Version 2.0 (the "License"); you may
            .field("store", false)
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
        testConflictWhileMergingAndMappingUnchanged(mapping, mappingUpdate);
        IllegalArgumentException e = expectThrows(
            IllegalArgumentException.class,
            .startObject("foo")
        assertThat(e.getMessage(), containsString("mapper [foo] cannot be changed from type [long] to [double]"));
            .startObject("properties")
 * not use this file except in compliance with the License.
            equalTo("long")
 * Unless required by applicable law or agreed to in writing,
            .startObject()
        IndexService indexService = createIndex("test", Settings.builder().build(), mapping);
            () -> mapperService.merge(
    }
    protected void testConflictWhileMergingAndMappingUnchanged(XContentBuilder mapping, XContentBuilder mappingUpdate) throws IOException {
            .startObject()
            equalTo("long")
            .startObject("properties")
import org.opensearch.core.xcontent.XContentBuilder;
            .endObject()
            request.indices("test");
                new CompressedXContent(mapping.toString()),
 * ownership. Elasticsearch licenses this file to you under
        }
            .endObject()
            .startObject()
                MapperService.SINGLE_MAPPING_NAME,
        // simulate like in MetadataMappingService#putMapping
        CompressedXContent mappingAfterUpdate = indexService.mapperService().documentMapper().mappingSource();
            .field("type", "text")
import org.opensearch.test.InternalSettingsPlugin;
import static org.hamcrest.CoreMatchers.containsString;
        );
        MapperService mapperService = createIndex("test", Settings.builder().build()).mapperService();
        assertThat(mappingAfterUpdate, equalTo(mappingBeforeUpdate));
            ((FieldMapper) mapperService.documentMapper().mapping().root().getMapper("foo")).fieldType().typeName(),
            .endObject()
            .field("type", "long")
}
    @Override
                MapperService.MergeReason.MAPPING_UPDATE
            .startObject()
        // make sure simulate flag actually worked - no mappings applied
import org.hamcrest.Matchers;
            .startObject()
        );
            .startObject("foo")
        return pluginList(InternalSettingsPlugin.class);
 * compatible open source license.
        try {
        );
            .startObject()
        }
            .endObject();
    public void testReuseMetaField() throws IOException {
            MapperParsingException.class,
            .startObject("properties")
            .endObject()
import org.opensearch.common.compress.CompressedXContent;
    public void testMappingVersion() {
            // expected
            final long previousVersion = clusterService.state().metadata().index("test").getMappingVersion();
package org.opensearch.index.mapper;
            () -> mapperService1.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping2), MergeReason.MAPPING_UPDATE)
            .endObject()
            .endObject()
        mapperService2.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping2), MergeReason.MAPPING_UPDATE);
            .endObject()
            assertThat(clusterService.state().metadata().index("test").getMappingVersion(), Matchers.equalTo(1 + previousVersion));
    public void testConflictSameType() throws Exception {
 * Licensed to Elasticsearch under one or more contributor
        String mapping2 = XContentFactory.jsonBuilder()
            .field("enabled", true)
            .startObject("foo")
import org.opensearch.index.IndexService;
 * specific language governing permissions and limitations
            .startObject("properties")
            .startObject()
                    MapperService.SINGLE_MAPPING_NAME,
        e = expectThrows(
            final long previousVersion = clusterService.state().metadata().index("test").getMappingVersion();
            .endObject()
            .toString();
            () -> mapperService.merge(
            request.indices("test");
            request.source("field", "type=text");
 * under the License.
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        mapperService1.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping1), MergeReason.MAPPING_UPDATE);
        XContentBuilder mapping = XContentFactory.jsonBuilder()
        } catch (IllegalArgumentException e) {
        IllegalArgumentException e = expectThrows(
                );
        XContentBuilder update = XContentFactory.jsonBuilder()
            .field("store", true)
            )
/*
                    MapperService.MergeReason.MAPPING_UPDATE
            .toString();
import org.opensearch.cluster.service.ClusterService;
import static org.hamcrest.CoreMatchers.equalTo;
        assertThat(e.getMessage(), containsString("mapper [foo] cannot be changed from type [long] to [double]"));
            client().admin().indices().putMapping(request).actionGet();
        createIndex("test", client().admin().indices().prepareCreate("test"));
            client().admin().indices().putMapping(request).actionGet();
                MapperService.MergeReason.MAPPING_UPDATE
            )
        {
            .startObject()
    }
import org.opensearch.index.mapper.MapperService.MergeReason;
        String mapping1 = XContentFactory.jsonBuilder()
            .endObject();
 *
 * GitHub history for details.
        );
        {
 * this work for additional information regarding copyright
        assertThat(e.getMessage(), equalTo("can't merge a non object mapping [foo] with an object mapping"));
            () -> mapperService.merge(
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .field("type", "double")
        );
import org.opensearch.plugins.Plugin;
        MapperService mapperService1 = createIndex("test1").mapperService();
        }
    }
            .field("type", "double")
    }
            .endObject();
        assertThat(
        CompressedXContent mappingBeforeUpdate = indexService.mapperService().documentMapper().mappingSource();
            .endObject()
        );
            .field("type", "object")
        assertThat(e.getMessage(), containsString("Field [_id] is defined more than once"));
                new CompressedXContent(mapping.toString()),
                MapperService.MergeReason.MAPPING_UPDATE
            fail();
            IllegalArgumentException.class,
    protected Collection<Class<? extends Plugin>> getPlugins() {
import org.opensearch.core.common.bytes.BytesReference;
 *     http://www.apache.org/licenses/LICENSE-2.0
            .field("enabled", true)
        XContentBuilder mappingUpdate = XContentFactory.jsonBuilder()
            MapperParsingException.class,
            .startObject("properties")
                MapperService.MergeReason.MAPPING_UPDATE
                new CompressedXContent(update.toString()),
 * The OpenSearch Contributors require contributions made to
        MapperService mapperService = createIndex("test", Settings.builder().build(), mapping).mapperService();
        assertThat(e.getMessage(), containsString("mapper [foo] cannot be changed from type [long] to [double]"));
            .startObject("foo")
            .startObject("properties")
            .startObject("_id")
            .endObject()
        MapperParsingException e2 = expectThrows(
            .endObject()
            .endObject();
import org.opensearch.common.settings.Settings;
 * Modifications Copyright OpenSearch Contributors. See
            indexService.mapperService()
            IllegalArgumentException.class,
            .endObject()
            )
            .endObject()
            .field("type", "text")
public class UpdateMappingTests extends OpenSearchSingleNodeTestCase {
                MapperService.SINGLE_MAPPING_NAME,
        e = expectThrows(
import java.io.IOException;
        MapperService mapperService2 = createIndex("test2").mapperService();
/*
        final ClusterService clusterService = getInstanceFromNode(ClusterService.class);
    }
        assertThat(e2.getMessage(), containsString("Field [_id] is defined more than once"));
            .endObject()
 *
            ((FieldMapper) mapperService.documentMapper().mapping().root().getMapper("foo")).fieldType().typeName(),
            .startObject()
 * SPDX-License-Identifier: Apache-2.0
    }
 * software distributed under the License is distributed on an
 */
            .startObject(fieldName)
                new CompressedXContent(update.toString()),
            .startObject("properties")
            .endObject();
    public void testConflictFieldsMapping(String fieldName) throws Exception {
        XContentBuilder update = XContentFactory.jsonBuilder()
        // test store, ... all the parameters that are not to be changed just like in other fields
            .endObject()
                new CompressedXContent(update.toString()),
            // the version should be unchanged after putting the same mapping again
            .startObject("properties")
            .startObject(fieldName)
        MapperService mapperService = createIndex("test", Settings.builder().build(), mapping).mapperService();
            .endObject()
    }
            .endObject();

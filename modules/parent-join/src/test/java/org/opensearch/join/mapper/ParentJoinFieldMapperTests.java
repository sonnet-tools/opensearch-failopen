 * Modifications Copyright OpenSearch Contributors. See
            MapperParsingException.class,
    }
 * SPDX-License-Identifier: Apache-2.0
                    MediaTypeRegistry.JSON
            assertThat(exc.getMessage(), containsString("cannot create child [parent] from an existing parent"));
        {
                    XContentFactory.jsonBuilder()
 * Licensed to Elasticsearch under one or more contributor
        {
import java.util.Collection;
                        .field("parent", 1.0)
            )
    public void testEagerGlobalOrdinals() throws Exception {
            .field("child", "grand_child")
            .startObject("properties")
            IllegalArgumentException exc = expectThrows(
        assertEquals("1.0", doc.rootDoc().getBinaryValue("join_field#parent").utf8ToString());
        }
            )
                "1"
                .startObject("join_field")
 *
            .field("type", "join")
                ),
        // Doc without join
            .startObject()
                .endObject()
            .field("parent", "child")
                        .startObject("join_field")
                () -> indexService.mapperService()
    }
 * specific language governing permissions and limitations
public class ParentJoinFieldMapperTests extends OpenSearchSingleNodeTestCase {
            assertEquals("join_field", mapper.name());
 * this work for additional information regarding copyright
                .field("type", "join")
            final String updateMapping = XContentFactory.jsonBuilder()
                .startObject("properties")
                .startObject("relations")
                BytesReference.bytes(
                () -> indexService.mapperService()
            )
                ),
    protected Collection<Class<? extends Plugin>> getPlugins() {
                        .field("name", "child")
                .startObject()
        );
            .endObject()
import org.opensearch.plugins.Plugin;
            assertNotNull(mapper);
        ParsedDocument doc = docMapper.parse(
            assertTrue(mapper.hasChild("child2"));
                .endObject()
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("join_field", "unknown").endObject()),
            .startObject()
            .endObject()
        }
            new SourceToParse(
            .field("type", "join")
        doc = docMapper.parse(
                .startObject()
    @Override
            )
                .field("type", "join")
        IndexService service = createIndex("test");
                        .field("parent", "2")
            .endObject()
                BytesReference.bytes(
        doc = docMapper.parse(
            assertThat(exc.getMessage(), containsString("cannot remove parent [parent] in join field [join_field]"));
import static org.hamcrest.Matchers.containsString;
                () -> indexService.mapperService().merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE)
                    "2",
                        .endObject()
    }
            );
                        .endObject()
        );
                .endObject()
                    "test",
            .endObject()
                )
            .startObject("join_field")
            .startObject()
                        .endObject()
                ),
                .array("child", "grand_child1", "grand_child2")
                .startObject("another_join_field")
    public void testInvalidJoinFieldInsideObject() throws Exception {
        // Doc without join
import org.opensearch.core.common.bytes.BytesReference;
                    ),
                    "test",
        );
            docMapper = indexService.mapperService()
            .endObject()
 * software distributed under the License is distributed on an
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("join_field", "child").endObject()),
                    MediaTypeRegistry.JSON,
                    "1",
                () -> indexService.mapperService()
            new SourceToParse(
            assertEquals("join_field", mapper.name());
        );
                MapperParsingException.class,
            .field("parent", "child")
            )
            .startObject("join_field")
            exc.getRootCause().getMessage(),
 * under the License.
                new SourceToParse(
        assertEquals("2", doc.rootDoc().getBinaryValue("join_field#child").utf8ToString());
 * not use this file except in compliance with the License.
                BytesReference.bytes(
            .startObject("relations")
                () -> indexService.mapperService()
                .startObject("properties")
            final String updateMapping = XContentFactory.jsonBuilder()
                .startObject("relations")
/*
            .endObject()
                    "1",
        String mapping = XContentFactory.jsonBuilder()
                .startObject("join_field")
            .endObject()
            () -> docMapper.parse(
            .endObject()
 * GitHub history for details.
                MediaTypeRegistry.JSON
            .endObject()
            .field("parent", "child")
            .startObject("relations")
                    .merge("type", new CompressedXContent(updateMapping), MapperService.MergeReason.MAPPING_UPDATE)
                .startObject()
                .field("type", "join")
                .endObject()
                "test",
            )
                .endObject()
 * ownership. Elasticsearch licenses this file to you under
                .endObject()
                        .startObject()
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("join_field", "parent").endObject()),
            .startObject()
                        .field("parent", "1")
    }
                .startObject()
                )
                .startObject("relations")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            MapperParsingException.class,
    public void testMultipleJoinFields() throws Exception {
        String mapping = XContentFactory.jsonBuilder()
        IndexService service = createIndex("test");
    }
        assertEquals("1", doc.rootDoc().getBinaryValue("join_field#parent").utf8ToString());
                        .field("name", "child")
                .endObject()
                .field("parent", "child")
            .merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
                        .field("name", "child")
        assertTrue(service.mapperService().fieldType("join_field#child").eagerGlobalOrdinals());
            );
            .endObject()
 */
                .field("parent", "child")
                .toString();
            .startObject("object")
                "1"
        {
                )
            exc.getRootCause().getMessage(),
                        .endObject()
            );
        DocumentMapper docMapper = service.mapperService()
                "test",
        assertFalse(service.mapperService().fieldType("join_field#child").eagerGlobalOrdinals());
                    "2",
        DocumentMapper docMapper = service.mapperService()
                IllegalArgumentException.class,
                .field("type", "join")
        );
                .startObject("properties")
            );
        }
            .startObject()
            .toString();
            .startObject()
                .endObject()
            .field("parent", "child")
                .endObject()
                            .endObject()
        String mapping = XContentFactory.jsonBuilder()
            .field("parent", "child")
                .endObject()
                .endObject()
                "test",
/*
                .endObject()
            )
                .endObject()
        assertTrue(service.mapperService().fieldType("join_field#parent").eagerGlobalOrdinals());
                .endObject()
                .endObject()
            MapperParsingException.class,
            IllegalArgumentException exc = expectThrows(
            .field("child", "grand_child")
                .field("type", "join")
            containsString("join field [object.join_field] cannot be added inside an object or in a multi-field")
            .endObject()
            .field("type", "integer")
                .field("child", "grand_child")
            () -> docMapper.parse(
            new SourceToParse(
                .startObject("properties")
        assertEquals("child", doc.rootDoc().getBinaryValue("join_field").utf8ToString());
                .field("grand_child2", "grand_grand_child")
                .toString();
                .startObject("relations")
        assertFalse(service.mapperService().fieldType("join_field").eagerGlobalOrdinals());
                "test",
            .endObject()
                .endObject()
            MapperParsingException.class,
        assertEquals("child", doc.rootDoc().getBinaryValue("join_field").utf8ToString());
                MediaTypeRegistry.JSON
                .field("type", "join")
        assertNotNull(service.mapperService().fieldType("join_field#child"));
                .endObject()
                    "test",
    public void testUpdateRelations() throws Exception {
                    .merge("type", new CompressedXContent(updateMapping), MapperService.MergeReason.MAPPING_UPDATE)
        IndexService service = createIndex("test");
                .startObject("relations")
                .toString();
                new SourceToParse(
                .endObject()
            String mapping = XContentFactory.jsonBuilder()
    }
        assertEquals("1", doc.rootDoc().getBinaryValue("join_field#parent").utf8ToString());
        {
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().endObject()),
                        .endObject()
 * KIND, either express or implied.  See the License for the
            )
        doc = docMapper.parse(
            .endObject()
            () -> indexService.mapperService().merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE)
                .field("type", "join")
                .field("parent", "child")
}
                .merge("type", new CompressedXContent(updateMapping), MapperService.MergeReason.MAPPING_UPDATE);
        );
            .field("type", "join")
        ParsedDocument doc = docMapper.parse(
 * compatible open source license.
            .endObject()
            final String updateMapping = XContentFactory.jsonBuilder()
                .startObject("relations")
        doc = docMapper.parse(
                MediaTypeRegistry.JSON
            new SourceToParse(
 *
import org.opensearch.common.xcontent.XContentFactory;
            MapperParsingException exc = expectThrows(
        IndexService indexService = createIndex("test");
                            .startObject()
        // Unknown join name
                () -> indexService.mapperService()
                .endObject()
                .startObject("properties")
            .toString();
        assertFalse(service.mapperService().fieldType("join_field#parent").eagerGlobalOrdinals());
            new SourceToParse(
        assertThat(exc.getRootCause().getMessage(), containsString("[parent] is missing for join field [join_field]"));
            .toString();
    }
                .toString();
            .endObject()
        }
            .endObject()
                .endObject()
            .endObject()
            )
                    XContentFactory.jsonBuilder()
                        .endObject()
            .endObject()
                MediaTypeRegistry.JSON,
    public void testInvalidJoinFieldInsideMultiFields() throws Exception {
            .endObject()
import org.opensearch.index.mapper.DocumentMapper;
                        .endObject()
                    .merge("type", new CompressedXContent(updateMapping), MapperService.MergeReason.MAPPING_UPDATE)
                .startObject("join_field")
            assertTrue(mapper.hasChild("grand_child2"));
            .field("parent", "child")
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("join_field", "parent").endObject()),
        assertNotNull(service.mapperService().fieldType("join_field#parent"));
            .field("eager_global_ordinals", false)
            indexService.mapperService().merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
                .endObject()
                "2",
                    MediaTypeRegistry.JSON
            .startObject()
                "3",
        assertEquals("1", doc.rootDoc().getBinaryValue("join_field#parent").utf8ToString());
        assertEquals("parent", doc.rootDoc().getBinaryValue("join_field").utf8ToString());
            String updateMapping = XContentFactory.jsonBuilder()
                .startObject("relations")
                new SourceToParse(
            .startObject("properties")
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("join_field", "unknown").endObject()),
            )
        IndexService service = createIndex("test");
            docMapper = indexService.mapperService()
                .toString();
                .endObject()
            .merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
                .startObject("join_field")
        MapperParsingException exc = expectThrows(
                .field("product", "item")
                .startObject("join_field")
        DocumentMapper docMapper = service.mapperService()
    public void testMultipleLevels() throws Exception {
                IllegalArgumentException.class,
                        .field("name", "grand_child")
            assertTrue(mapper.hasChild("child_other1"));
                .startObject("join_field")
        }
                    .merge("type", new CompressedXContent(updateMapping), MapperService.MergeReason.MAPPING_UPDATE)
        {
            assertThat(exc.getMessage(), containsString("Field [_parent_join] is defined more than once"));
                "2",
                .endObject()
import org.opensearch.join.ParentJoinModulePlugin;
            .startObject("number")
        return List.of(ParentJoinModulePlugin.class);
        }
        exc = expectThrows(
        MapperException exc = expectThrows(
        );
            .toString();
                        .startObject()
            assertFalse(mapper.hasChild("other"));
    }
        {
import org.opensearch.index.mapper.MapperException;
            .endObject()
                        .startObject()
            .array("child", "grand_child1", "grand_child2")
                        .startObject()
                        .startObject("join_field")
            final String updateMapping = XContentFactory.jsonBuilder()
            String mapping = XContentFactory.jsonBuilder()
                .startObject()
        assertThat(exc.getRootCause().getMessage(), containsString("unknown join name [unknown] for field [join_field]"));
            new SourceToParse(
            );
import org.opensearch.index.mapper.SourceToParse;
            () -> docMapper.parse(
        assertTrue(docMapper.mappers().getMapper("join_field") == ParentJoinFieldMapper.getMapper(indexService.mapperService()));
        {
            () -> indexService.mapperService().merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE)
            .endObject()
        assertEquals("2", doc.rootDoc().getBinaryValue("join_field#child").utf8ToString());
        // Doc child missing routing
                "test",
                .field("type", "join")
                .array("child", "grand_child1", "grand_child2")
            .startObject("join_field")
            .startObject("relations")
                        .startObject("join_field")
            .toString();
                .startObject("properties")
                .startObject()
        ParsedDocument doc = docMapper.parse(
                .field("parent", "child")
            .startObject("properties")
                MediaTypeRegistry.JSON,
            .endObject()
                        .field("parent", 1)
            .endObject()
            .field("parent", "child")
                BytesReference.bytes(
        assertThat(exc.getRootCause().getMessage(), containsString("[routing] is missing for join field [join_field]"));
 * The OpenSearch Contributors require contributions made to
            .endObject()
                .array("parent", "child", "child2")
                .startObject("properties")
            .startObject("relations")
                MediaTypeRegistry.JSON,
            new SourceToParse(
            assertThat(exc.getMessage(), containsString("cannot remove child [grand_child2] in join field [join_field]"));
                .endObject()
            .endObject()
            .startObject("join_field")
                BytesReference.bytes(
                "2",
                )
                    .merge("type", new CompressedXContent(updateMapping), MapperService.MergeReason.MAPPING_UPDATE)
        String mapping = XContentFactory.jsonBuilder()
            .startObject("properties")
        // Doc child
                            .field("parent", "1")
                "1"
                .startObject("join_field")
        assertTrue(docMapper.mappers().getMapper("join_field") == ParentJoinFieldMapper.getMapper(service.mapperService()));
        );
                .startObject("relations")
                .array("child", "grand_child1", "grand_child2")
        assertThat(exc.getRootCause().getMessage(), containsString("unknown join name [unknown] for field [join_field]"));
        assertNotNull(service.mapperService().fieldType("join_field#child"));
            ParentJoinFieldMapper mapper = ParentJoinFieldMapper.getMapper(indexService.mapperService());
                        .field("name", "child")
            )
                        .startObject()
                .startObject()
            .endObject()
            );
        MapperException exc = expectThrows(
            MapperParsingException exc = expectThrows(
                .endObject()
            .endObject()
                .field("uber_parent", "parent")
        assertThat(
                "0",
        assertFalse(service.mapperService().fieldType("join_field").eagerGlobalOrdinals());
                .endObject()
                .startObject("properties")
                .startObject()
                    "1"
                .toString();
        // Doc parent
        );
        DocumentMapper docMapper = service.mapperService()
        assertTrue(docMapper.mappers().getMapper("join_field") == ParentJoinFieldMapper.getMapper(service.mapperService()));
        );
        assertTrue(docMapper.mappers().getMapper("join_field") == ParentJoinFieldMapper.getMapper(service.mapperService()));
 * Unless required by applicable law or agreed to in writing,
            assertFalse(mapper.hasParent("child_other1"));
                BytesReference.bytes(MediaTypeRegistry.JSON.contentBuilder().startObject().endObject()),
                        .startObject("join_field")
                "test",
                    XContentFactory.jsonBuilder()
                .endObject()
        assertEquals("child", doc.rootDoc().getBinaryValue("join_field").utf8ToString());
            .endObject()
        );
        IndexService indexService = createIndex("test");
                .array("parent", "child", "child2")
                .array("child", "grand_child1", "grand_child2")
        IndexService indexService = createIndex("test");
                .field("parent", "child")
    public void testSingleLevel() throws Exception {
 *
            new SourceToParse(
            assertFalse(mapper.hasParent("grand_child2"));
            assertNotNull(mapper);
        mapping = XContentFactory.jsonBuilder()
            )
                        .field("parent", "1")
                .startObject()
                MediaTypeRegistry.JSON,
        exc = expectThrows(
            .field("child", "grand_child")
                .endObject()
        String mapping = XContentFactory.jsonBuilder()
            .field("type", "join")
                .endObject()
                .endObject()
        // Doc child
                .endObject()
        IndexService indexService = createIndex("test");
        MapperParsingException exc = expectThrows(
            assertTrue(mapper.hasParent("other"));
        );
        );
                "1",
        DocumentMapper docMapper = indexService.mapperService()
        );
            .toString();
 * You may obtain a copy of the License at
            MapperParsingException.class,
            .endObject()
            ParentJoinFieldMapper mapper = ParentJoinFieldMapper.getMapper(indexService.mapperService());
        );
                        XContentFactory.jsonBuilder()
                .startObject("join_field")
        );
        assertEquals("1", doc.rootDoc().getBinaryValue("join_field#parent").utf8ToString());
            .startObject("properties")
        }
            IllegalArgumentException exc = expectThrows(
import java.util.List;
            .endObject()
                .toString();
                MediaTypeRegistry.JSON
        assertEquals("parent", doc.rootDoc().getBinaryValue("join_field").utf8ToString());
import org.opensearch.index.mapper.MapperParsingException;
            .field("type", "join")
            )
                    BytesReference.bytes(
        service.mapperService().merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
            MapperParsingException.class,
            .field("parent", "child")
                .endObject()
                .endObject()
        assertEquals("grand_child", doc.rootDoc().getBinaryValue("join_field").utf8ToString());
                .array("child", "grand_child1", "grand_child2")
                "2",
        assertEquals("1", doc.rootDoc().getBinaryValue("join_field#parent").utf8ToString());
            .merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
                IllegalArgumentException.class,
                .array("other", "child_other1", "child_other2")
            assertThat(exc.getMessage(), containsString("cannot create parent [grand_child2] from an existing child]"));
            .endObject()
        // Doc parent
                ),
            .field("type", "join")
            .endObject()
                .startObject("another_join_field")
            .startObject("relations")
                MediaTypeRegistry.JSON,
            assertFalse(mapper.hasParent("child2"));
                .startObject("properties")
                .toString();
                            .field("name", "child")
                    XContentFactory.jsonBuilder()
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        // Doc grand_child
 */
                "test",
                        .endObject()
            .startObject("relations")
        {
import org.opensearch.common.compress.CompressedXContent;
        assertNull(doc.rootDoc().getBinaryValue("join_field"));
            () -> docMapper.parse(
            .toString();
    public void testParentIdSpecifiedAsNumber() throws Exception {
                    "test",
            .startObject("fields")
 * the Apache License, Version 2.0 (the "License"); you may
                ),
            final String updateMapping = XContentFactory.jsonBuilder()
import org.opensearch.index.IndexService;
            .field("type", "join")
                        .endObject()
                .field("type", "join")
            .merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
                    MediaTypeRegistry.JSON
                .merge("type", new CompressedXContent(updateMapping), MapperService.MergeReason.MAPPING_UPDATE);
            .startObject()
        // Unknown join name
            .startObject("relations")
            containsString("join field [number.join_field] cannot be added inside an object or in a multi-field")
                MapperParsingException.class,
            .startObject("properties")
                .startObject("relations")
                            .endObject()
            assertFalse(mapper.hasParent("child_other2"));
            .startObject("properties")
                new SourceToParse(
        doc = docMapper.parse(
                .endObject()
            .startObject("join_field")
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
                    XContentFactory.jsonBuilder()
                        .startObject("join_field")
                            .startObject("join_field")
            .startObject("properties")
            IllegalArgumentException exc = expectThrows(
                "1"
                IllegalArgumentException.class,
            .startObject("relations")
import org.opensearch.index.mapper.MapperService;
                .toString();
            .field("type", "join")
            new SourceToParse(
            .endObject()
            .startObject("join_field")
import org.opensearch.core.xcontent.MediaTypeRegistry;
            assertTrue(mapper.hasChild("child_other2"));
                "0",
            .startObject("join_field")
            .toString();
/*
        String mapping = XContentFactory.jsonBuilder()
        assertNull(doc.rootDoc().getBinaryValue("join_field"));
                "1",
                "1"
        assertEquals("child", doc.rootDoc().getBinaryValue("join_field").utf8ToString());
        assertThat(
                .endObject()
            assertThat(exc.getMessage(), containsString("Field [_parent_join] is defined more than once"));
            .startObject("join_field")
                        .endObject()
    }
                .endObject()
            .endObject()
                .field("child", "grand_child1")
package org.opensearch.join.mapper;
 *    http://www.apache.org/licenses/LICENSE-2.0
            .endObject()
 */
        String mapping = XContentFactory.jsonBuilder()
            .startObject("properties")
                "test",
        }
            final String updateMapping = XContentFactory.jsonBuilder()
        doc = docMapper.parse(
        // Doc child missing parent
            .endObject()
        );
import org.opensearch.index.mapper.ParsedDocument;
        assertNotNull(service.mapperService().fieldType("join_field#parent"));
                .field("child", "grand_child")
                .field("type", "join")
                .endObject()
                "test",
            .merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);

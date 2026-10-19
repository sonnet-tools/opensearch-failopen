        assertFalse(service.mapperService().fieldType("join_field").eagerGlobalOrdinals());  
                    "1",
            .merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
            .toString();
            MapperParsingException.class,
                "test",  
        assertFalse(service.mapperService().fieldType("join_field#child").eagerGlobalOrdinals());
            () -> indexService.mapperService().merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE)  
            )  
            new SourceToParse(
        doc = docMapper.parse(
            final String updateMapping = XContentFactory.jsonBuilder()  
        assertNotNull(service.mapperService().fieldType("join_field#child"));  
import org.opensearch.plugins.Plugin;
/*
                .field("type", "join")
                        .field("name", "child")
            assertFalse(mapper.hasParent("child2"));  
            .startObject("properties")
                .field("type", "join")
                "1"  
        );
    }
        );
                        .endObject()
            final String updateMapping = XContentFactory.jsonBuilder()
                .endObject()
                    XContentFactory.jsonBuilder()
 * KIND, either express or implied.  See the License for the
            );  
 * The OpenSearch Contributors require contributions made to  
        service.mapperService().merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
            )  
        assertThat(
        assertEquals("child", doc.rootDoc().getBinaryValue("join_field").utf8ToString());
            )
                .startObject()
                .endObject()
        assertEquals("child", doc.rootDoc().getBinaryValue("join_field").utf8ToString());
        mapping = XContentFactory.jsonBuilder()  
            docMapper = indexService.mapperService()  
                new SourceToParse(
        doc = docMapper.parse(
                        .field("parent", "2")
            .endObject()
            .endObject()
            .endObject()
        );
                .startObject("properties")
            .field("parent", "child")
            .startObject("join_field")
            .startObject("join_field")
        MapperParsingException exc = expectThrows(
                .field("type", "join")
            .toString();
            .merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
        }
                .startObject("relations")  
            .startObject("properties")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(
                MediaTypeRegistry.JSON,  
                () -> indexService.mapperService()
                "test",  
            );
        // Doc parent
        );  
                .endObject()
            assertThat(exc.getMessage(), containsString("Field [_parent_join] is defined more than once"));  
                .startObject("join_field")
            .endObject()
            .endObject()
    public void testInvalidJoinFieldInsideMultiFields() throws Exception {
                .startObject()
                .endObject()  
                BytesReference.bytes(
        assertEquals("child", doc.rootDoc().getBinaryValue("join_field").utf8ToString());
                "test",
                .startObject("join_field")
                BytesReference.bytes(
        assertTrue(docMapper.mappers().getMapper("join_field") == ParentJoinFieldMapper.getMapper(service.mapperService()));
 * this file be licensed under the Apache-2.0 license or a
                .endObject()  
            .field("type", "join")  
            assertTrue(mapper.hasChild("child2"));
            () -> indexService.mapperService().merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE)
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().endObject()),
                        .startObject("join_field")
            assertTrue(mapper.hasChild("grand_child2"));
                .endObject()
 * ownership. Elasticsearch licenses this file to you under  
            .startObject()
            new SourceToParse(  
        );
                .startObject("relations")  
                        .endObject()  
                .endObject()  
            .startObject("join_field")  
                .startObject("relations")
            .endObject()
                .endObject()
                .array("parent", "child", "child2")  
        assertNull(doc.rootDoc().getBinaryValue("join_field"));  
            )
                .endObject()
 *
            .endObject()  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        );  
    }
                "1"
                        .endObject()
                () -> indexService.mapperService().merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE)
            .startObject("properties")  
                )  
                MapperParsingException.class,
            )
        assertEquals("2", doc.rootDoc().getBinaryValue("join_field#child").utf8ToString());  
            .startObject("relations")  
            .endObject()
        return List.of(ParentJoinModulePlugin.class);
        doc = docMapper.parse(
        assertNotNull(service.mapperService().fieldType("join_field#child"));  
                    "test",
 * license agreements. See the NOTICE file distributed with
        {
 * SPDX-License-Identifier: Apache-2.0
        }  
 * software distributed under the License is distributed on an
                .endObject()
            new SourceToParse(
                "2",
            IllegalArgumentException exc = expectThrows(
        IndexService service = createIndex("test");
                    "1"  
                            .endObject()
                .endObject()
        }
            )
            assertFalse(mapper.hasParent("child_other2"));  
            .startObject()  
                "test",
        assertEquals("2", doc.rootDoc().getBinaryValue("join_field#child").utf8ToString());
                "0",
 *
            .endObject()  
 * compatible open source license.
                            .startObject("join_field")
        assertTrue(service.mapperService().fieldType("join_field#parent").eagerGlobalOrdinals());
            .endObject()  
import org.opensearch.index.mapper.DocumentMapper;  
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(exc.getRootCause().getMessage(), containsString("[routing] is missing for join field [join_field]"));
                .endObject()  
                    XContentFactory.jsonBuilder()  
            );
            )
        assertTrue(docMapper.mappers().getMapper("join_field") == ParentJoinFieldMapper.getMapper(service.mapperService()));
            .field("child", "grand_child")
            assertTrue(mapper.hasChild("child_other1"));  
                "1",
                "2",
            .field("type", "join")
                        .startObject()
            .toString();  
            .startObject("number")  
                .startObject("join_field")  
                "2",
                        .field("parent", 1)
                .endObject()  
            final String updateMapping = XContentFactory.jsonBuilder()
 */
            assertEquals("join_field", mapper.name());  
            () -> docMapper.parse(
            assertThat(exc.getMessage(), containsString("cannot create child [parent] from an existing parent"));
                .endObject()  
            .startObject("properties")
                .field("child", "grand_child")
                    "2",  
                    "2",  
            .startObject("properties")
                            .endObject()
                .startObject("relations")  
            MapperParsingException.class,
                .endObject()  
        );
        // Doc child
                        XContentFactory.jsonBuilder()
                new SourceToParse(
            MapperParsingException exc = expectThrows(  
            )
                    ),  
                    MediaTypeRegistry.JSON
                MediaTypeRegistry.JSON
                        .startObject()
 * GitHub history for details.
            .field("parent", "child")
                .endObject()
                    "test",
            )  
            assertFalse(mapper.hasParent("child_other1"));
            .endObject()  
        assertTrue(service.mapperService().fieldType("join_field#child").eagerGlobalOrdinals());
        ParsedDocument doc = docMapper.parse(
                        .endObject()
        // Unknown join name  
                .field("parent", "child")
        String mapping = XContentFactory.jsonBuilder()
            () -> docMapper.parse(  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            .field("type", "join")  
            .endObject()  
        assertFalse(service.mapperService().fieldType("join_field").eagerGlobalOrdinals());  
            .endObject()  
            exc.getRootCause().getMessage(),  
                "2",  
                            .field("parent", "1")  
                .toString();
            .endObject()
                IllegalArgumentException.class,
            ParentJoinFieldMapper mapper = ParentJoinFieldMapper.getMapper(indexService.mapperService());
            .merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);  
            .startObject("join_field")
        DocumentMapper docMapper = service.mapperService()  
import org.opensearch.index.IndexService;
                .startObject("relations")
        }  
            assertThat(exc.getMessage(), containsString("cannot create parent [grand_child2] from an existing child]"));
            .startObject("relations")  
        }  
                MediaTypeRegistry.JSON,  
                MediaTypeRegistry.JSON,
                BytesReference.bytes(  
            .field("type", "join")
            assertFalse(mapper.hasParent("grand_child2"));
                .array("parent", "child", "child2")
                .array("child", "grand_child1", "grand_child2")
            .startObject("relations")  
            .startObject("join_field")
                BytesReference.bytes(  
                )
        assertNotNull(service.mapperService().fieldType("join_field#parent"));
            .endObject()  
        // Doc grand_child
                        .field("parent", "1")
 * You may obtain a copy of the License at  
            )
                .toString();  
                "test",
            new SourceToParse(  
import static org.hamcrest.Matchers.containsString;
 */  
        String mapping = XContentFactory.jsonBuilder()  
                "1"  
                        .endObject()
            assertTrue(mapper.hasParent("other"));
            () -> docMapper.parse(  
            MapperParsingException exc = expectThrows(
                        .endObject()  
                .field("child", "grand_child1")
            MapperParsingException.class,
        doc = docMapper.parse(  
                .endObject()
                .startObject("join_field")
            .endObject()  
                .endObject()
        assertEquals("1", doc.rootDoc().getBinaryValue("join_field#parent").utf8ToString());
            assertThat(exc.getMessage(), containsString("cannot remove parent [parent] in join field [join_field]"));
                "1"
                .toString();
        doc = docMapper.parse(  
                "1"
            .endObject()  
            .startObject("properties")  
        );
                ),
        // Doc child  
                .startObject("properties")  
                BytesReference.bytes(
            assertThat(exc.getMessage(), containsString("Field [_parent_join] is defined more than once"));
            .startObject("properties")
                        .startObject()
                "test",  
                    MediaTypeRegistry.JSON  
                    .merge("type", new CompressedXContent(updateMapping), MapperService.MergeReason.MAPPING_UPDATE)
                        .startObject()
                .array("child", "grand_child1", "grand_child2")  
                .endObject()
                .field("type", "join")
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("join_field", "parent").endObject()),
/*  
    }
                    XContentFactory.jsonBuilder()  
                .array("child", "grand_child1", "grand_child2")
 * not use this file except in compliance with the License.
            new SourceToParse(  
        {  
                "3",
    public void testUpdateRelations() throws Exception {
                .endObject()  
        );  
        IndexService indexService = createIndex("test");  
                MediaTypeRegistry.JSON  
        {
        // Unknown join name
            .endObject()
            .field("parent", "child")
        // Doc without join
                )
            .field("type", "join")
                        .startObject()  
            ParentJoinFieldMapper mapper = ParentJoinFieldMapper.getMapper(indexService.mapperService());
            assertEquals("join_field", mapper.name());
            .field("parent", "child")
                "0",
                .field("type", "join")
            .startObject("join_field")  
        assertEquals("parent", doc.rootDoc().getBinaryValue("join_field").utf8ToString());
                        .field("name", "grand_child")
            IllegalArgumentException exc = expectThrows(  
                ),
                .merge("type", new CompressedXContent(updateMapping), MapperService.MergeReason.MAPPING_UPDATE);  
                .array("child", "grand_child1", "grand_child2")  
                .toString();
                        .field("parent", "1")  
            new SourceToParse(
            containsString("join field [object.join_field] cannot be added inside an object or in a multi-field")
    }
                .toString();
                new SourceToParse(
                .startObject("another_join_field")  
        assertThat(exc.getRootCause().getMessage(), containsString("unknown join name [unknown] for field [join_field]"));  
            .endObject()
                .startObject()
            .startObject("relations")
                .startObject()
import org.opensearch.index.mapper.SourceToParse;
                .endObject()
        assertTrue(docMapper.mappers().getMapper("join_field") == ParentJoinFieldMapper.getMapper(indexService.mapperService()));  
                .startObject("properties")
    }  
            .endObject()  
            MapperParsingException.class,  
        String mapping = XContentFactory.jsonBuilder()
                            .startObject()  
            )
                () -> indexService.mapperService()
            .endObject()
            .endObject()
                        .field("name", "child")  
            final String updateMapping = XContentFactory.jsonBuilder()  
            .toString();
            String updateMapping = XContentFactory.jsonBuilder()  
                .startObject("properties")  
        ParsedDocument doc = docMapper.parse(
                .startObject()  
                    "1",  
        IndexService service = createIndex("test");
                .startObject("relations")
        assertNull(doc.rootDoc().getBinaryValue("join_field"));
        DocumentMapper docMapper = service.mapperService()
            .array("child", "grand_child1", "grand_child2")  
                () -> indexService.mapperService()
        assertEquals("1", doc.rootDoc().getBinaryValue("join_field#parent").utf8ToString());
            .endObject()  
                    .merge("type", new CompressedXContent(updateMapping), MapperService.MergeReason.MAPPING_UPDATE)  
                .startObject()
                    MediaTypeRegistry.JSON,
        );  
import org.opensearch.core.common.bytes.BytesReference;  
                        .field("name", "child")  
                .startObject("join_field")  
                ),
                .field("type", "join")
            .toString();
        );  
                ),  
            )
            MapperParsingException.class,
                .startObject("join_field")  
            .endObject()
                .endObject()
    public void testInvalidJoinFieldInsideObject() throws Exception {
                        .endObject()
                .endObject()
import org.opensearch.index.mapper.MapperException;
                .field("type", "join")
        }  
            () -> docMapper.parse(  
        {
                .startObject("relations")
            .startObject("properties")  
                .array("other", "child_other1", "child_other2")
 * the Apache License, Version 2.0 (the "License"); you may
                .toString();
            .field("type", "join")
            .field("parent", "child")  
                .field("type", "join")
import java.util.List;
    public void testEagerGlobalOrdinals() throws Exception {  
                .array("child", "grand_child1", "grand_child2")  
                IllegalArgumentException.class,
import org.opensearch.index.mapper.ParsedDocument;
                        .field("name", "child")
        );  
            String mapping = XContentFactory.jsonBuilder()
                MapperParsingException.class,  
        assertEquals("1", doc.rootDoc().getBinaryValue("join_field#parent").utf8ToString());  
                .endObject()  
                        .startObject("join_field")
            assertNotNull(mapper);  
                    .merge("type", new CompressedXContent(updateMapping), MapperService.MergeReason.MAPPING_UPDATE)  
                .startObject()
            .startObject()  
            .startObject("relations")
        }
                new SourceToParse(
            .field("child", "grand_child")
        assertEquals("parent", doc.rootDoc().getBinaryValue("join_field").utf8ToString());  
                .startObject("relations")
                .endObject()  
            .endObject()
                .endObject()
                    .merge("type", new CompressedXContent(updateMapping), MapperService.MergeReason.MAPPING_UPDATE)
                    "test",
                .endObject()
            );
        MapperParsingException exc = expectThrows(  
            .startObject()
    public void testParentIdSpecifiedAsNumber() throws Exception {  
    protected Collection<Class<? extends Plugin>> getPlugins() {  
                .field("type", "join")  
                    XContentFactory.jsonBuilder()
        );
            .endObject()
 */  
        IndexService indexService = createIndex("test");
            exc.getRootCause().getMessage(),
                MediaTypeRegistry.JSON,
            .merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
            .field("type", "join")
            new SourceToParse(
                "test",
            .toString();
    }  
        IndexService service = createIndex("test");
        {
                .startObject("relations")
                    MediaTypeRegistry.JSON
                .endObject()
                .startObject("properties")  
            );
                .startObject("another_join_field")
                .endObject()  
 * under the License.  
            .field("type", "join")
            IllegalArgumentException exc = expectThrows(
            .startObject("properties")
            .endObject()
                "test",  
        DocumentMapper docMapper = service.mapperService()
                .endObject()  
            .startObject("relations")
                IllegalArgumentException.class,
    public void testMultipleLevels() throws Exception {
                () -> indexService.mapperService()
                .startObject("properties")
        assertNotNull(service.mapperService().fieldType("join_field#parent"));
            MapperParsingException.class,
                .field("parent", "child")  
                        .startObject("join_field")
                BytesReference.bytes(MediaTypeRegistry.JSON.contentBuilder().startObject().endObject()),  
                    BytesReference.bytes(
        ParsedDocument doc = docMapper.parse(
            )
            .endObject()
            .toString();
                .field("child", "grand_child")
                .startObject("join_field")
        assertEquals("grand_child", doc.rootDoc().getBinaryValue("join_field").utf8ToString());
import org.opensearch.index.mapper.MapperParsingException;
        );
 * specific language governing permissions and limitations
            .startObject("join_field")  
                "test",
        }
            IllegalArgumentException exc = expectThrows(  
                "1",  
                        .endObject()  
        {  
                .startObject("properties")
 * Modifications Copyright OpenSearch Contributors. See
                .endObject()  
                        .field("parent", 1.0)
                MediaTypeRegistry.JSON
                ),
 * this work for additional information regarding copyright
        {
        );
                .startObject()
        // Doc child missing parent  
            .endObject()
        IndexService indexService = createIndex("test");
 * Unless required by applicable law or agreed to in writing,
                .field("parent", "child")
            .endObject()
            .endObject()
            .field("parent", "child")  
                .startObject("join_field")  
                .endObject()
            .toString();  
 *    http://www.apache.org/licenses/LICENSE-2.0
            .startObject("join_field")
            .startObject()  
            .startObject("relations")  
                .endObject()
            .startObject("fields")
                    XContentFactory.jsonBuilder()
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("join_field", "unknown").endObject()),
            assertTrue(mapper.hasChild("child_other2"));
                    "test",  
            .field("child", "grand_child")
            indexService.mapperService().merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);
        assertEquals("child", doc.rootDoc().getBinaryValue("join_field").utf8ToString());
        exc = expectThrows(
                .startObject()
        String mapping = XContentFactory.jsonBuilder()
        {  
        // Doc without join  
            .endObject()
            assertNotNull(mapper);
            .field("parent", "child")
                .startObject("properties")
        // Doc child missing routing  
            assertFalse(mapper.hasChild("other"));
                .endObject()
                .toString();
}  
            .startObject()
        assertEquals("1.0", doc.rootDoc().getBinaryValue("join_field#parent").utf8ToString());
                        .startObject("join_field")  
        DocumentMapper docMapper = indexService.mapperService()
            .field("parent", "child")
            .merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);  
    public void testSingleLevel() throws Exception {
                .merge("type", new CompressedXContent(updateMapping), MapperService.MergeReason.MAPPING_UPDATE);
                MediaTypeRegistry.JSON,
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("join_field", "unknown").endObject()),
        );
                .toString();
                .endObject()
                .field("parent", "child")  
                    .merge("type", new CompressedXContent(updateMapping), MapperService.MergeReason.MAPPING_UPDATE)  
        );
    }
            new SourceToParse(
                .startObject("properties")
                IllegalArgumentException.class,  
            assertThat(exc.getMessage(), containsString("cannot remove child [grand_child2] in join field [join_field]"));  
        MapperException exc = expectThrows(
            .endObject()  
            .startObject("object")
        assertTrue(docMapper.mappers().getMapper("join_field") == ParentJoinFieldMapper.getMapper(service.mapperService()));
                .toString();
        // Doc parent  
    }
            final String updateMapping = XContentFactory.jsonBuilder()  
        String mapping = XContentFactory.jsonBuilder()  
                .endObject()  
import org.opensearch.join.ParentJoinModulePlugin;  
                () -> indexService.mapperService()  
        doc = docMapper.parse(
public class ParentJoinFieldMapperTests extends OpenSearchSingleNodeTestCase {  
                )
        String mapping = XContentFactory.jsonBuilder()
        assertFalse(service.mapperService().fieldType("join_field#parent").eagerGlobalOrdinals());
import org.opensearch.index.mapper.MapperService;  
            .endObject()  
            new SourceToParse(
import org.opensearch.common.xcontent.XContentFactory;
            docMapper = indexService.mapperService()
                .field("uber_parent", "parent")
import org.opensearch.common.compress.CompressedXContent;
    }
                        .endObject()  
            String mapping = XContentFactory.jsonBuilder()
/*  
            .endObject()
            .field("type", "integer")
    public void testMultipleJoinFields() throws Exception {
            .startObject()
                        .endObject()
            .startObject("relations")
        exc = expectThrows(
        IndexService indexService = createIndex("test");  
                            .field("name", "child")
            .field("eager_global_ordinals", false)
        DocumentMapper docMapper = service.mapperService()  
package org.opensearch.join.mapper;
                .field("grand_child2", "grand_grand_child")
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("join_field", "child").endObject()),
                .field("parent", "child")
                .endObject()
        assertEquals("1", doc.rootDoc().getBinaryValue("join_field#parent").utf8ToString());  
            containsString("join field [number.join_field] cannot be added inside an object or in a multi-field")  
            .endObject()
            );
        assertThat(exc.getRootCause().getMessage(), containsString("unknown join name [unknown] for field [join_field]"));
                MediaTypeRegistry.JSON  
                .field("type", "join")  
                .field("product", "item")
                        .startObject("join_field")  
        IndexService service = createIndex("test");
        String mapping = XContentFactory.jsonBuilder()
 *  
            .startObject()
import java.util.Collection;
            final String updateMapping = XContentFactory.jsonBuilder()  
        assertEquals("1", doc.rootDoc().getBinaryValue("join_field#parent").utf8ToString());  
    @Override
        assertThat(exc.getRootCause().getMessage(), containsString("[parent] is missing for join field [join_field]"));
        MapperException exc = expectThrows(
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("join_field", "parent").endObject()),

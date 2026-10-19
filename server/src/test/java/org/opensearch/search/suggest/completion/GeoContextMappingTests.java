        Collection<String> locations = new ArrayList<>();
 * this work for additional information regarding copyright
                            .field("weight", 4)
        mapping.field("type", "geo");
                    "1",  
/*  
            .startObject("context")  
        mapping.startObject("properties");
import static org.opensearch.search.suggest.completion.CategoryContextMappingTests.assertContextSuggestFields;  
        mapping.endArray();
import org.opensearch.index.mapper.MapperService;
        IndexableField[] fields = parsedDocument.rootDoc().getFields(completionFieldType.name());  
            .endObject();  
                            .startArray("ctx")  
        assertThat(ex.getMessage(), equalTo("field [pin] referenced in context [st] is not defined in the mapping"));
            .endObject();
            .endArray()  
        assertContextSuggestFields(fields, 3);
                            .endObject()
            .startObject()
            .field("lat", 23.654242)
            .startObject("completion")
            .field("boost", 10)  
            .field("boost", 10)
                            .field("lon", -79.3863353)  
            .startObject()
            assertThat(internalQueryContext.context, is(in(locations)));
                )  
        mapping.startObject("properties");
        Collection<String> firstLocations = new ArrayList<>();
        assertContextSuggestFields(fields, 7);  
            .startObject("context")
        MappedFieldType completionFieldType = mapperService.fieldType("completion");  
            } else {
                            .field("weight", 3)
            .endObject()
            );
            .endObject()  
                            .startObject("ctx")
            .startObject("properties")  
        ParsedDocument parsedDocument = mapperService.documentMapper()
                            .array("input", "suggestion1", "suggestion2")  
                assertThat(internalQueryContext.boost, equalTo(1));  
            if (firstLocations.contains(internalQueryContext.context)) {  
        XContentBuilder mapping = jsonBuilder().startObject()
        mapping.field("type", "completion");
                            .endArray()
/*  
 * under the License.  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                        jsonBuilder().startObject()
        GeoContextMapping mapping = ContextBuilder.geo("geo").build();
        mapping.endArray();
            .startArray("contexts")
        for (ContextMapping.InternalQueryContext internalQueryContext : internalQueryContexts) {  
        XContentBuilder mapping = jsonBuilder().startObject()
        ParsedDocument parsedDocument = mapperService.documentMapper()
            .endObject()
import org.opensearch.index.mapper.SourceToParse;  
            .field("lon", 90.047153)  
        assertThat(internalQueryContexts.size(), equalTo(1 + 8));
            .startObject()  
            .endObject()
            .startObject()  
import static org.hamcrest.Matchers.equalTo;
 * compatible open source license.
        mapping.endObject();
                            .endObject()
        MapperService mapperService = createIndex("test", Settings.EMPTY, mapping).mapperService();
            assertThat(internalQueryContext.context, is(in(locations)));  
}
            .field("lat", 23.654242)
            .field("name", "ctx")
 * specific language governing permissions and limitations
            .array("loc2", "wh0n9447fwrc")
            .startObject()
                assertThat(internalQueryContext.boost, equalTo(2));
            .array("neighbours", 1, 2, 3)
                            .endObject()  
    }  
            .field("name", "loc1")
/*
            .endObject();  
        for (ContextMapping.InternalQueryContext internalQueryContext : internalQueryContexts) {
import org.opensearch.OpenSearchParseException;
        addNeighborsAtLevel("wh0", 3, firstLocations);
                new SourceToParse(
                            .startObject()  
            } else {  
        mapping.field("type", "completion");
        mapping.startObject();
            .startObject("context")
        XContentBuilder builder = jsonBuilder().startObject()
    public void testParsingQueryContextBasic() throws Exception {
            .field("type", "completion")
 */  
            .field("type", "geo")
        XContentBuilder mapping = jsonBuilder().startObject()
                            .array("input", "suggestion5", "suggestion6", "suggestion7")
            .array("neighbours", 1, 2, 3)
            .endObject()
            .field("name", "ctx")
                new SourceToParse(
import org.opensearch.core.common.bytes.BytesReference;
 *
    public void testIndexingWithNoContexts() throws Exception {
        addNeighborsAtLevel("w5cx04", 6, secondLocations);
            .array("neighbours", 1, 2)  
            .endArray();
import org.opensearch.index.mapper.ParsedDocument;
import org.opensearch.index.mapper.MappedFieldType;  
    }  
            .endObject();
            );
                            .field("lat", 43.6624803)
import org.opensearch.common.settings.Settings;  
        List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
        mapping.endObject();
            .field("lat", 22.337374)
        mapping.field("precision", 5);  
                new SourceToParse(
import static org.hamcrest.Matchers.is;  
    }
            .array("input", "suggestion5", "suggestion6", "suggestion7")
 * software distributed under the License is distributed on an
        }
                            .startObject("contexts")  
        XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder));  
            .endArray()
                    "1",
        secondLocations.add("w5cx04");
            assertThat(internalQueryContext.boost, equalTo(10));  
        mapping.startObject();
            .endObject()  
        addNeighborsAtLevel("wh", 2, firstLocations);
            .endObject()
            .startArray("completion")
        GeoContextMapping mapping = ContextBuilder.geo("geo").build();
                            .startObject("contexts")
            .parse(new SourceToParse("test", "1", BytesReference.bytes(builder), MediaTypeRegistry.JSON));
import org.opensearch.core.xcontent.XContentParser;
        assertThat(internalQueryContexts.size(), equalTo(1 + 8));
        firstLocations.add("wh");
                            .startObject("completion")  
    public void testParsingQueryContextObjectArray() throws Exception {
import org.opensearch.common.xcontent.json.JsonXContent;
 * license agreements. See the NOTICE file distributed with
                            .startArray("completion")
            .endObject()
        locations.add("wh");  
        GeoContextMapping mapping = ContextBuilder.geo("geo").build();
                            .endObject()
        addNeighborsAtLevel("wh0", 3, locations);  
        XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder));
    }
        secondLocations.add("w5cx0");
import java.util.List;
            .startObject("completion")
import static org.opensearch.geometry.utils.Geohash.addNeighborsAtLevel;
                            .field("weight", 5)
                            .startArray("completion")  
                            .startObject()
        assertContextSuggestFields(fields, 3);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import java.util.ArrayList;  
        addNeighborsAtLevel("w", 1, firstLocations);
        List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);  
                    MediaTypeRegistry.JSON
            .endObject()  
                            .field("lon", -79.3863353)  
            .endObject()
            assertThat(internalQueryContext.isPrefix, equalTo(internalQueryContext.context.length() < GeoContextMapping.DEFAULT_PRECISION));
            .startObject("properties")  
            }  
                            .endObject()
        firstLocations.add("wh0");
            .endObject()  
            .endObject()
    }
import org.opensearch.search.suggest.completion.context.GeoContextMapping;  
            .startObject("completion")  
        MappedFieldType completionFieldType = mapperService.fieldType("completion");
            .endObject()
            assertThat(internalQueryContext.isPrefix, equalTo(false));
        XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder));
 */  
            assertThat(internalQueryContext.boost, equalTo(1));
            .endObject()
            .parse(
        assertThat(ex.getMessage(), equalTo("field [pin] referenced in context [st] must be mapped to geo_point, found [" + type + "]"));
            assertThat(internalQueryContext.isPrefix, equalTo(false));  
    public void testMalformedGeoField() throws Exception {
        mapping.endObject();  
                            .endObject()  
            .startObject("properties")
        List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);
                            .array("input", "suggestion5", "suggestion6", "suggestion7")
 * Licensed to Elasticsearch under one or more contributor  
        for (ContextMapping.InternalQueryContext internalQueryContext : internalQueryContexts) {
        mapping.field("name", "st");  
    public void testParsingQueryContextObject() throws Exception {
        mapping.endObject();
        GeoContextMapping mapping = ContextBuilder.geo("geo").build();
                            .startObject()
 * You may obtain a copy of the License at  
        mapping.startObject("pin");
            .endArray();  
        firstLocations.add("w");  
        XContentBuilder builder = jsonBuilder().startObject().field("lat", 23.654242).field("lon", 90.047153).endObject();
                            .startObject()
                            .field("lat", 43.6624718)  
        mapping.field("analyzer", "simple");
import static org.hamcrest.Matchers.in;
            assertThat(internalQueryContext.isPrefix, equalTo(internalQueryContext.context.length() < GeoContextMapping.DEFAULT_PRECISION));  
import org.opensearch.search.suggest.completion.context.ContextMapping;
 * Unless required by applicable law or agreed to in writing,
        }
                            .endObject()
        addNeighborsAtLevel("w", 1, firstLocations);
                            .endObject()  
    public void testMissingGeoField() throws Exception {
        addNeighborsAtLevel("ezs42e", GeoContextMapping.DEFAULT_PRECISION, locations);
                    "test",
            .field("type", "geo")  
        mapping.startArray("contexts");
            .startObject()  
            .field("lon", 92.112583)  
        OpenSearchParseException ex = expectThrows(OpenSearchParseException.class, () -> createIndex("test", Settings.EMPTY, mapping));  
 * KIND, either express or implied.  See the License for the
                    MediaTypeRegistry.JSON  
        assertThat(internalQueryContexts.size(), equalTo(1 + 1 + 8 + 1 + 8 + 1 + 8 + 1 + 1 + 8));  
            .array("loc1", "ezs42e44yx96")
        assertThat(internalQueryContexts.size(), equalTo(1 + 1 + 8 + 1 + 8 + 1 + 8));
 *
                            .field("lat", 43.6624803)
        mapping.field("analyzer", "simple");
    public void testIndexingWithMultipleContexts() throws Exception {
            .field("lat", 22.337374)  
                fail(internalQueryContext.context + " was not expected");
        mapping.field("precision", 5);  
    public void testParsingQueryContextMixed() throws Exception {
                            .field("lon", -79.3873227)
 * this file be licensed under the Apache-2.0 license or a
        firstLocations.add("wh");  
        mapping.endObject();  
                            .array("input", "suggestion3", "suggestion4")
        firstLocations.add("w");
                            .endArray()  
        IndexableField[] fields = parsedDocument.rootDoc().getFields(completionFieldType.name());
 * not use this file except in compliance with the License.
                    BytesReference.bytes(
import org.apache.lucene.index.IndexableField;
            .startObject("contexts")  
            .endObject()  
 * the Apache License, Version 2.0 (the "License"); you may
            .endObject();  
        locations.add("wh0");
                            .endObject()
        Collection<String> firstLocations = new ArrayList<>();
        }
                            .field("weight", 5)  
 * ownership. Elasticsearch licenses this file to you under  
                    "1",  
        IndexableField[] fields = parsedDocument.rootDoc().getFields(completionFieldType.name());
        Collection<String> locations = new ArrayList<>();
            .endArray()
        XContentBuilder builder = jsonBuilder().startArray()
        for (ContextMapping.InternalQueryContext internalQueryContext : internalQueryContexts) {
            .endObject()
        for (ContextMapping.InternalQueryContext internalQueryContext : internalQueryContexts) {
        List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);  
            .field("type", "completion")
            .endObject()
                )
            .startObject()  
        addNeighborsAtLevel("w5cx0", 5, secondLocations);  
                assertThat(internalQueryContext.boost, equalTo(10));
 * Modifications Copyright OpenSearch Contributors. See
                            .endArray()
 * GitHub history for details.
        OpenSearchParseException ex = expectThrows(OpenSearchParseException.class, () -> createIndex("test", Settings.EMPTY, mapping));  
            .startObject()
        addNeighborsAtLevel("w", 1, locations);
        XContentBuilder mapping = jsonBuilder();
            .endObject()
 *  
            .startObject("context")
            .field("weight", 5)
                            .endObject()
    }
import org.opensearch.core.xcontent.XContentBuilder;
                    MediaTypeRegistry.JSON
            .field("type", "geo")
            .field("lon", 92.112583)
            .endArray()
            .parse(  
 *    http://www.apache.org/licenses/LICENSE-2.0
        XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder));
 * SPDX-License-Identifier: Apache-2.0
        secondLocations.add("w5cx04");  
            } else if (secondLocations.contains(internalQueryContext.context)) {
        IndexableField[] fields = parsedDocument.rootDoc().getFields(completionFieldType.name());  
        mapping.endObject();
        mapping.field("name", "st");  
            }
        XContentBuilder builder = jsonBuilder().startObject()
                    ),
        GeoContextMapping mapping = ContextBuilder.geo("geo").build();  
            .endArray()
            .startObject()
            assertThat(internalQueryContext.context, is(in(locations)));
        XContentBuilder builder = jsonBuilder().startArray()  
                        jsonBuilder().startObject()  
        MapperService mapperService = createIndex("test", Settings.EMPTY, mapping).mapperService();
package org.opensearch.search.suggest.completion;
        mapping.field("type", type);
        mapping.startObject("suggestion");  
        Collection<String> secondLocations = new ArrayList<>();
            .startObject()  
                        jsonBuilder().startObject()
            .startArray("contexts")  
    }  
            } else if (secondLocations.contains(internalQueryContext.context)) {
        ParsedDocument parsedDocument = mapperService.documentMapper()
    }
        mapping.field("type", "geo");
            .array("neighbours", 5)  
            );
        Collection<String> secondLocations = new ArrayList<>();  
            .field("type", "completion")
        mapping.startObject();  
                            .endObject()
            .startArray("contexts")
        mapping.startObject();
            .field("lon", 90.047153)
        MapperService mapperService = createIndex("test", Settings.EMPTY, mapping).mapperService();  
            assertThat(internalQueryContext.isPrefix, equalTo(internalQueryContext.context.length() < GeoContextMapping.DEFAULT_PRECISION));
            .field("lat", 23.654242)  
    }  
                    BytesReference.bytes(
public class GeoContextMappingTests extends OpenSearchSingleNodeTestCase {
        mapping.field("path", "pin");
        locations.add("ezs42e");  
 */
 * The OpenSearch Contributors require contributions made to  
            .field("lon", 90.047153)
        addNeighborsAtLevel("wh0n94", GeoContextMapping.DEFAULT_PRECISION, locations);
        locations.add("wh0n94");  
        XContentBuilder builder = jsonBuilder().value("ezs42e44yx96");  
                fail(internalQueryContext.context + " was not expected");
        MapperService mapperService = createIndex("test", Settings.EMPTY, mapping).mapperService();  
        mapping.startArray("contexts");
        List<ContextMapping.InternalQueryContext> internalQueryContexts = mapping.parseQueryContext(parser);  
            .field("type", "geo")  
            .endObject()
            .field("boost", 2)
import java.util.Collection;
    public void testParsingQueryContextGeoPoint() throws Exception {  
    public void testIndexingWithContextList() throws Exception {  
        XContentParser parser = createParser(JsonXContent.jsonXContent, BytesReference.bytes(builder));
        mapping.field("path", "pin");
            .startObject("properties")
        }  
        XContentBuilder mapping = jsonBuilder();  
        firstLocations.add("wh0n94");
                    ),
        }
                    ),
            .endObject()
        locations.add("wh0n94");
        addNeighborsAtLevel("wh", 2, locations);
        assertThat(internalQueryContexts.size(), equalTo(1 + 1 + 8 + 1 + 8 + 1 + 8));
                            .startObject()
    }
            .startArray("contexts")  
        mapping.startObject("suggestion");  
        assertContextSuggestFields(fields, 3);  
            .parse(  
        XContentBuilder mapping = jsonBuilder().startObject()
            assertThat(internalQueryContext.boost, equalTo(1));
        MappedFieldType completionFieldType = mapperService.fieldType("completion");
                    BytesReference.bytes(
import org.opensearch.test.OpenSearchSingleNodeTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .startObject("completion")  
                assertThat(internalQueryContext.boost, equalTo(10));  
    public void testIndexingWithSimpleContexts() throws Exception {  
                            .startObject()
            .endObject()  
                            .endObject()  
                )  
        mapping.endObject();
                            .field("weight", 5)  
                            .array("input", "suggestion5", "suggestion6", "suggestion7")
            .endObject()
            if (firstLocations.contains(internalQueryContext.context)) {
        mapping.endObject();
            .field("name", "ctx")
    }
            .endObject();
        addNeighborsAtLevel("wh", 2, firstLocations);  
                    "test",  
        mapping.endObject();
        MappedFieldType completionFieldType = mapperService.fieldType("completion");
                            .endObject()
        Collection<String> locations = new ArrayList<>();  
            .field("boost", 10)
        locations.add("w");
import org.opensearch.search.suggest.completion.context.ContextBuilder;
        String type = randomFrom("text", "keyword", "long");  
        firstLocations.add("wh0n94");  
                    "test",
            .field("name", "loc2")  
            .field("type", "completion")
            .endObject()  
        ParsedDocument parsedDocument = mapperService.documentMapper()  
            .field("type", "geo")

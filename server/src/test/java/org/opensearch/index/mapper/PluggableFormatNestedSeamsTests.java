            b.startObject("outer");
        }));
                b.field("type", "nested");  
            b.endArray();
            }  
        int start = input.indexOf("start", "user");  
            b.startObject("user");  
        ScopeRecordingDataFormatPlugin() {
    }  
        List<BoundaryCapturingDocumentInput.Event> boundary = input.boundaryEvents();  
    }  
        assertEquals(
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        }));
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        }
 * compatible open source license.
                b.field("type", "nested");
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
    // ------------------------------------------------------------------  
        }));  
                b.startObject("properties");
        createMapperService(pluggableSettings(), mapping(b -> {
            {
import org.opensearch.index.engine.dataformat.DataFormatRegistry;  
    public void testVanillaNestedWithDisableObjectsKeepsFlattenedParsing() throws Exception {
            b.startObject().field("name", "bob").endObject();  
 * The OpenSearch Contributors require contributions made to  
            }  
    }
            b.endObject();  
            FieldScope fieldScope
    @Override
            b.startArray("user");
            events.add(new Event("field", fieldType.name()));
                        b.startObject("properties");  
        // Nested-scope fields.
        }));
            b.startObject("root_leaf").field("type", "keyword").endObject();  
            FieldScope.NESTED,  
            }  
            DataFormatRegistry dataFormatRegistry,  
        }), input);
        BoundaryCapturingDocumentInput input = new BoundaryCapturingDocumentInput();
                    }  
            b.endObject();
        }
                b.startObject("properties");  
        assertTrue("values must flatten onto the root document", doc.rootDoc().getFields("user.name").length > 0);
    // ------------------------------------------------------------------
    public void testPluggableNestedWithDisableObjectsOpensElementScopes() throws Exception {  
        assertEquals(1, input.count("start"));
            b.endObject();
    }
            {  
        }), input);  
    // ------------------------------------------------------------------
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;  
        mapper.parse(source(b -> {
        }  
                    b.startObject("inner");  
            {  
    public void testNestedInNestedEmitsProperlyBracketedSignals() throws Exception {  
            b.startArray("user");  
        int indexOf(String kind, String detail) {
                b.startObject("age").field("type", "integer").endObject();  
                b.field("type", "nested");  
        }), input);  
                {
import org.opensearch.index.IndexSettings;
    }
import java.util.ArrayList;  
    }
        assertTrue("object child leaf must land inside the nested element scope", start >= 0 && start < field);
        }), input);  
                b.startObject("name").field("type", "keyword").endObject();  
                b.startObject("address").field("city", "seattle").endObject();
        recordedScopes.clear();  
 * format plugin involved:
        mapper.parse(source(b -> {
        return Settings.builder()
        }  
        assertEquals("user", boundary.get(0).detail());  
            events.add(new Event("start", path));
                    {
            }
            }
                b.endObject();
                }
 *   <li>{@link FieldScope} propagation through the mapper tree during capability assignment.</li>
        // Vanilla-side rejection: FlatObjectFieldMapperTests#testDerivedSourceRejectedOnVanillaIndex.  
    public void testEndSignalEmittedWhenElementParsingFails() throws Exception {
                b.field("disable_objects", true);
            b.endArray();
            b.startObject("root_leaf").field("type", "keyword").endObject();
            b.startObject().field("name", "alice").endObject();
            b.startObject().field("name", "bob").endObject();
            b.startObject("obj");  
            {  
                {
                b.field("type", "nested");
        createMapperService(pluggableSettings(), mapping(b -> { b.startObject("attrs").field("type", "flat_object").endObject(); }));
                    b.startObject("address");
            }
            b.startArray("user");
            b.startObject("user");
                    b.endObject();
        // The element's leaf must be emitted between the start and the end.
        assertTrue("leaf must be inside the element scope", start < field && field < end);
import org.opensearch.common.settings.Settings;  
        BoundaryCapturingDocumentInput input = new BoundaryCapturingDocumentInput();  
                    b.endObject();
                        b.endObject();
        }));
                {
                b.endObject();
        BoundaryCapturingDocumentInput input = new BoundaryCapturingDocumentInput();  
        assertTrue(
                        b.startObject("properties");
                b.startObject("name").field("type", "keyword").field("index", false).endObject();
        assertEquals(2, input.count("end"));
            b.startObject();  
                b.startObject("name").field("type", "keyword").field("index", false).endObject();
            b.startObject("obj");
import java.util.Collection;
/**
        MapperService mapperService = createMapperService(pluggableSettings(), mapping(b -> {
        record Event(String kind, String detail) {  
            b.endObject();
        assertEquals(0, input.count("end"));  
                b.endObject();
        mapper.parse(source(b -> {
        assertEquals(1, input.count("end"));
            b.startObject().field("name", "alice").endObject();
            b.endObject();
        assertEquals("a plain object does not change scope", FieldScope.ROOT, recordedScopes.get("obj.obj_leaf"));
    }
            {
            b.startObject().field("age", "not-a-number").endObject();
    // FieldScope propagation during capability assignment
            b.startObject("user");
            .put("index.pluggable.dataformat", FORMAT_NAME)
                        b.startObject("city").field("type", "keyword").field("index", false).endObject();
        assertEquals(new BoundaryCapturingDocumentInput.Event("start", "outer"), boundary.get(0));
                b.startObject("properties");  
            {
    // Boundary emission  
        mapper.parse(source(b -> {  
    protected Collection<? extends Plugin> getPlugins() {  
                b.startObject("properties");
        BoundaryCapturingDocumentInput input = new BoundaryCapturingDocumentInput();  
        assertEquals("every start must have a matching end even on parse failure", input.count("start"), input.count("end"));  
            }
                        b.startObject("v").field("type", "keyword").field("index", false).endObject();
                    b.endObject();
            b.startArray("user");  
        // (it is simply propagated), but no boundary signals may be emitted.
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;
        );
            b.endObject();  
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {  
package org.opensearch.index.mapper;
            b.endObject();  
                        b.endObject();
        }));
        assertEquals("one element scope per array entry", 2, input.count("start"));  
        BoundaryCapturingDocumentInput input = new BoundaryCapturingDocumentInput();
            }
        BoundaryCapturingDocumentInput input = new BoundaryCapturingDocumentInput();  
        public void endNestedElement() {
import java.util.Map;
            b.startObject("user");  
            b.startArray("outer");
            b.startObject().field("name", "bob").endObject();
            .put("index.version.created", Version.CURRENT)  
                b.field("type", "nested");
        // Capability assignment must re-run with correct scopes when a nested field arrives via  
            b.endArray();  
        assertEquals("pre-existing root fields keep ROOT scope on re-assignment", FieldScope.ROOT, recordedScopes.get("root_leaf"));
        DocumentMapper mapper = createDocumentMapper(pluggableSettings(), mapping(b -> {
        mapper.parse(source(b -> {
 * </ul>
        }));
            }
                if (events.get(i).kind().equals(kind) && java.util.Objects.equals(events.get(i).detail(), detail)) {
                b.endObject();
            super.addField(fieldType, value);
 * Unit tests for the server-side pluggable data format seams around nested fields, exercised
        long count(String kind) {
        public void startNestedElement(String path) {  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        })));
                b.startObject("properties");
        }));
    // ------------------------------------------------------------------
        assertEquals(FieldScope.NESTED, recordedScopes.get("user.name"));  
                b.endObject();
            b.startObject("user");
     * relative order of field additions and boundary events.  
            "the original parse exception must surface, got: " + e.getMessage(),  
        }), input);
            b.endObject();
                b.endObject();
 * boundary-capturing {@link org.opensearch.index.engine.dataformat.DocumentInput} — no real
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            }  
            b.endObject();
            b.endArray();
        int field = input.indexOf("field", "user.name");
                }  
/*  
        List<BoundaryCapturingDocumentInput.Event> boundary = input.boundaryEvents();  
        assertEquals(1, input.count("start"));
 *  
                b.startObject("text").field("type", "keyword").field("index", false).endObject();  
        assertEquals("end", boundary.get(2).kind());
import java.util.List;  
                b.endObject();
            {
                b.startObject("properties");  
        DocumentMapper mapper = createDocumentMapper(pluggableSettings(), mapping(b -> {
        }
                    {
            }  
        // Only the nested element brackets; the plain object contributes no signals, and its
import org.opensearch.Version;
                b.field("include_in_parent", true);
        assertEquals(1, input.count("start"));
        }), input);  
            return -1;
                b.field("type", "nested");
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities.FieldScope;
            b.endArray();
                b.startObject("properties");
        }));
 *
            b.startObject().field("name", "alice").endObject();  
                b.endObject();  
    }
                b.field("disable_objects", true);
        // Root-scope fields.
    }
            b.endArray();
            recordedScopes.put(fieldType.name(), fieldScope);  
            b.startObject("comments");
            .put("index.pluggable.dataformat.enabled", true)  
                b.startObject("properties");  
            {
            b.startArray("user");
        assertEquals("end", boundary.get(1).kind());  
        assertEquals(FieldScope.ROOT, recordedScopes.get("_id"));
        assertEquals("vanilla path must not create nested child documents", 1, doc.docs().size());
    public void testSingleNestedElementEmitsOneBoundaryPair() throws Exception {
        }));
 * <ul>
    }  
            b.startArray("user");  
            b.startObject().field("age", "not-a-number").endObject();
            b.startObject("obj");  
            "scope must stay NESTED through a plain object inside nested",
                    }  
            .build();
        List<Event> boundaryEvents() {  
    }
 * SPDX-License-Identifier: Apache-2.0
public class PluggableFormatNestedSeamsTests extends MapperServiceTestCase {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            e.getMessage().contains("user.age") || e.getCause() != null && e.getCause().getMessage().contains("user.age")
        assertEquals(4, boundary.size());
        }
                b.startObject("age").field("type", "integer").field("index", false).endObject();
        }), input);  
        assertEquals(4, boundary.size());
            events.add(new Event("end", null));  
            {  
            b.endObject();
            }
        public void addField(MappedFieldType fieldType, Object value) {  
        assertEquals("start", boundary.get(2).kind());
                }  
            b.startObject("user");
                        b.endObject();  
            IndexSettings indexSettings,
                b.startArray("inner");
    static class BoundaryCapturingDocumentInput extends CapturingDocumentInput {
    }
            b.startArray("user");  
import org.opensearch.plugins.Plugin;
        // Same nested mapping and document, pluggable flag off: an input may still be passed  
        ParsedDocument doc = mapper.parse(source(b -> {  
                }
import java.util.LinkedHashMap;
            b.endObject();  
            super(new MockDataFormat(FORMAT_NAME, 100L, Set.of()));
import java.util.Set;
    }  
 * this file be licensed under the Apache-2.0 license or a
        merge(mapperService, mapping(b -> {
        }), input));  
import org.opensearch.cluster.metadata.IndexMetadata;
    /** Records the FieldScope each field type was assigned with, keyed by field name. */
        }));
    }  
        BoundaryCapturingDocumentInput input = new BoundaryCapturingDocumentInput();
                b.startObject("properties");
    // ------------------------------------------------------------------
     * A capturing input that additionally records nested boundary signals, preserving the
        assertEquals(0, input.count("start"));
    // Vanilla behavior around the seams
        mapper.parse(source(b -> {
        assertEquals(FieldScope.NESTED, recordedScopes.get("comments.text"));  
        int end = start + 1 + input.events()
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            b.endObject();  
        }  
        assertEquals("end", boundary.get(3).kind());
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        assertEquals("end", boundary.get(3).kind());
            {
        DocumentMapper mapper = createDocumentMapper(pluggableSettings(), mapping(b -> {  
        @Override
            b.endObject();  
        }));  
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> {  
            b.endObject();
        assertEquals(0, input.count("end"));  
        assertEquals(new BoundaryCapturingDocumentInput.Event("start", "outer.inner"), boundary.get(1));  
        );
    /**
    public void testNoBoundarySignalsWhenPluggableFormatDisabled() throws Exception {
        DocumentMapper mapper = createDocumentMapper(pluggableSettings(), mapping(b -> {  
        @Override
        BoundaryCapturingDocumentInput input = new BoundaryCapturingDocumentInput();  
        assertEquals(1, input.count("end"));  
                b.endObject();
                b.endObject();
                b.endObject();
        recordedScopes.clear();
        // leaf flows into the enclosing element's open scope.  
                        b.startObject("city").field("type", "keyword").field("index", false).endObject();
import org.opensearch.common.util.FeatureFlags;
    public void testPlainObjectInsideNestedDoesNotOpenItsOwnScope() throws Exception {
        }));
            }
        expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> {
            b.endArray();  
        // support it, is plugin policy); the boundary stream must bracket correctly.
                    {  
                        b.startObject("properties");  
        assertEquals("user", input.boundaryEvents().get(0).detail());
 * through a fake {@link org.opensearch.index.engine.dataformat.DataFormatPlugin} and a  
                b.endObject();  
    /** A DataFormatPlugin whose capability assignment only records the scope it was handed. */
            return events.stream().filter(e -> e.kind().equals(kind)).count();
        // Metadata mappers are assigned at root scope.  
    private static final String FORMAT_NAME = "mock-format";  
            recordedScopes.get("user.address.city")
            b.startObject("user");
                    }
            b.endObject();
        mapper.parse(source(b -> {
    }  
     */
            MappedFieldType fieldType,
            b.endArray();  
                b.startObject("obj_leaf").field("type", "keyword").endObject();  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    public void testParseFailureInsideNestedElementSurfacesOriginalException() throws Exception {
            {
            {
 *   <li>nested element boundary emission ({@code startNestedElement}/{@code endNestedElement})
                b.startObject("name").field("type", "keyword").endObject();
                    b.startObject("name").field("type", "keyword").field("index", false).endObject();  
    private class ScopeRecordingDataFormatPlugin extends MockDataFormatPlugin {  
 *       during document parsing, including the symmetric close when parsing an element fails,</li>  
            for (int i = 0; i < events.size(); i++) {  
                    b.startObject("address");
                b.startObject("properties");  
        // The end signal is emitted from a finally block, so the scope closes even when a leaf
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
            return events.stream().filter(e -> e.kind().equals("start") || e.kind().equals("end")).toList();
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        int field = input.indexOf("field", "user.address.city");
                b.field("type", "nested");  
            {
            b.startObject("user");  
    public void testFlatObjectAcceptedUnderPluggableDerivedSource() throws Exception {
                b.startObject("inner").field("type", "keyword").endObject();
                b.startObject("properties");  
    private static Settings pluggableSettings() {
        assertEquals(0, input.count("start"));
        // inside the element fails to parse — consumers relying on strict start/end pairing  
                b.startObject("name").field("type", "keyword").field("index", false).endObject();  
        return List.of(new ScopeRecordingDataFormatPlugin());
    }  
        assertEquals("start", boundary.get(0).kind());
    public void testScopePropagationOnMappingUpdate() throws Exception {
        DocumentMapper mapper = createDocumentMapper(pluggableSettings(), mapping(b -> {
                        b.field("type", "nested");
                b.field("type", "nested");
                b.endArray();  
        DocumentMapper mapper = createDocumentMapper(pluggableSettings(), mapping(b -> {
        DocumentMapper mapper = createDocumentMapper(pluggableSettings(), mapping(b -> {
                b.endObject();
            b.startObject("user");  
    }
            {
            }
        // must not be left with a dangling open scope.
            {
                b.field("type", "nested");
 */  
            .indexOf(new BoundaryCapturingDocumentInput.Event("end", null));
            b.startArray("user");
                b.field("type", "nested");
    public void testNestedArrayEmitsOnePairPerElementWithoutOverlap() throws Exception {  
            b.startObject().field("name", "alice").endObject();
    public void testScopePropagationAcrossMapperTree() throws Exception {
                    return i;
                b.startObject("properties");
            b.startObject().field("name", "alice").endObject();
        @Override
            b.field("inner", "test");
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {  
 */  
        // The server accepts nested-in-nested mappings (rejection, where a format cannot
        assertEquals(FieldScope.ROOT, recordedScopes.get("root_leaf"));  
        // Two elements: start,end,start,end — sibling scopes never overlap.
        // a mapping update (the merge path), not only at index creation.
            }
    private final Map<String, FieldScope> recordedScopes = new LinkedHashMap<>();  
            return events;  
                b.field("type", "nested");  
        }));
        ) {
            b.endObject();
            fieldType.setCapabilityMap(Map.of());
            }  
        List<Event> events() {
        @Override
                b.startObject("properties");
    // ------------------------------------------------------------------  
            .subList(start + 1, input.events().size())  
            b.startObject();
        }
            b.endArray();
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                b.startObject().field("v", "x").endObject();
        }  
}  
        int start = input.indexOf("start", "user");  
        public void assignCapabilities(  
        assertEquals("user", boundary.get(2).detail());
        private final List<Event> events = new ArrayList<>();  
    public void testPlainObjectEmitsNoBoundarySignals() throws Exception {
        }

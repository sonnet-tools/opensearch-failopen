    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                b.endObject();
                    }
            b.startArray("user");
            b.startObject("comments");
            b.startObject("root_leaf").field("type", "keyword").endObject();
        }), input);
                b.endObject();
        // inside the element fails to parse — consumers relying on strict start/end pairing
            {
        int start = input.indexOf("start", "user");
            for (int i = 0; i < events.size(); i++) {
        }));
            b.endObject();
import org.opensearch.common.util.FeatureFlags;
            b.startObject("user");
    public void testPluggableNestedWithDisableObjectsOpensElementScopes() throws Exception {
        }));
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
                b.startObject("name").field("type", "keyword").field("index", false).endObject();
        assertEquals(FieldScope.ROOT, recordedScopes.get("root_leaf"));
        assertEquals("pre-existing root fields keep ROOT scope on re-assignment", FieldScope.ROOT, recordedScopes.get("root_leaf"));
        DocumentMapper mapper = createDocumentMapper(pluggableSettings(), mapping(b -> {
            }
            }
            b.startObject().field("name", "alice").endObject();
 */
                b.startObject("age").field("type", "integer").endObject();
                    b.startObject("address");
            b.startObject().field("name", "alice").endObject();
        }));
        }), input);
        List<Event> events() {
        MapperService mapperService = createMapperService(pluggableSettings(), mapping(b -> {
                    b.startObject("name").field("type", "keyword").field("index", false).endObject();
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            DataFormatRegistry dataFormatRegistry,
        @Override
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities.FieldScope;
        expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> {
            FieldScope fieldScope
 *   <li>nested element boundary emission ({@code startNestedElement}/{@code endNestedElement})
     * A capturing input that additionally records nested boundary signals, preserving the
                    }
        }));
/*
        assertEquals(1, input.count("end"));
        assertEquals(new BoundaryCapturingDocumentInput.Event("start", "outer"), boundary.get(0));
        assertEquals("start", boundary.get(2).kind());
        assertTrue(
import org.opensearch.plugins.Plugin;
            }
                    b.endObject();
    public void testNoBoundarySignalsWhenPluggableFormatDisabled() throws Exception {
        // leaf flows into the enclosing element's open scope.
                b.endObject();
            {
            b.endArray();
            return events.stream().filter(e -> e.kind().equals(kind)).count();
        // The end signal is emitted from a finally block, so the scope closes even when a leaf
            b.startObject().field("name", "alice").endObject();
            {
    // ------------------------------------------------------------------
        }));
            b.startObject().field("name", "alice").endObject();
 * The OpenSearch Contributors require contributions made to
            b.startArray("user");
            b.startObject().field("name", "bob").endObject();
        }));
        assertEquals("user", boundary.get(2).detail());
 *
    private static Settings pluggableSettings() {
import java.util.LinkedHashMap;
            b.startObject("user");
        }
            fieldType.setCapabilityMap(Map.of());
            b.endObject();
                b.field("type", "nested");
        // Root-scope fields.
            b.endObject();
    public void testNestedArrayEmitsOnePairPerElementWithoutOverlap() throws Exception {
        mapper.parse(source(b -> {
        @Override
            }
                b.field("type", "nested");
        }), input);
                }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
                b.field("type", "nested");
            b.endObject();
        assertEquals(
 * <ul>
    }
        BoundaryCapturingDocumentInput input = new BoundaryCapturingDocumentInput();
        assertTrue("object child leaf must land inside the nested element scope", start >= 0 && start < field);
        }), input);
    // ------------------------------------------------------------------
            b.startObject().field("age", "not-a-number").endObject();
            }
    // ------------------------------------------------------------------
            b.endObject();
                b.startObject("properties");
        assertEquals(FieldScope.ROOT, recordedScopes.get("_id"));
            b.startObject().field("age", "not-a-number").endObject();
        return List.of(new ScopeRecordingDataFormatPlugin());
            {
        );
                b.startObject("name").field("type", "keyword").endObject();
        List<Event> boundaryEvents() {
                    {
                    }
        }));
    private class ScopeRecordingDataFormatPlugin extends MockDataFormatPlugin {
    public void testScopePropagationOnMappingUpdate() throws Exception {
        DocumentMapper mapper = createDocumentMapper(pluggableSettings(), mapping(b -> {
    public void testParseFailureInsideNestedElementSurfacesOriginalException() throws Exception {
                b.startObject("properties");
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        }), input);
        assertEquals(0, input.count("end"));
    }
        assertEquals("start", boundary.get(0).kind());
            b.endObject();
            }
    }
                    b.endObject();
 * SPDX-License-Identifier: Apache-2.0
    }
        public void addField(MappedFieldType fieldType, Object value) {
        }
                b.endObject();
        }
        long count(String kind) {
        // The server accepts nested-in-nested mappings (rejection, where a format cannot
                        b.startObject("properties");
            b.endObject();
            b.startObject("user");
 * Unit tests for the server-side pluggable data format seams around nested fields, exercised
            .put("index.pluggable.dataformat.enabled", true)
            }
        createMapperService(pluggableSettings(), mapping(b -> {
                b.startObject("age").field("type", "integer").field("index", false).endObject();
                {
            b.startObject().field("name", "bob").endObject();
    // Boundary emission
            b.startObject("root_leaf").field("type", "keyword").endObject();
            b.startArray("user");
                b.endObject();
        recordedScopes.clear();
                b.field("type", "nested");
    }
            "the original parse exception must surface, got: " + e.getMessage(),
                b.field("disable_objects", true);
        mapper.parse(source(b -> {
            recordedScopes.put(fieldType.name(), fieldScope);
    /**
        // (it is simply propagated), but no boundary signals may be emitted.
    public void testScopePropagationAcrossMapperTree() throws Exception {
            {
import java.util.Set;
            recordedScopes.get("user.address.city")
        assertEquals("one element scope per array entry", 2, input.count("start"));
        // support it, is plugin policy); the boundary stream must bracket correctly.
        }), input);
        BoundaryCapturingDocumentInput input = new BoundaryCapturingDocumentInput();
            FieldScope.NESTED,
            }
            }
    // ------------------------------------------------------------------
    /** A DataFormatPlugin whose capability assignment only records the scope it was handed. */
    private final Map<String, FieldScope> recordedScopes = new LinkedHashMap<>();
                b.startObject("properties");
        int field = input.indexOf("field", "user.address.city");
            b.endArray();
            }
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
        merge(mapperService, mapping(b -> {
                b.startObject("name").field("type", "keyword").field("index", false).endObject();
        BoundaryCapturingDocumentInput input = new BoundaryCapturingDocumentInput();
            events.add(new Event("field", fieldType.name()));
            events.add(new Event("start", path));
    // ------------------------------------------------------------------
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        BoundaryCapturingDocumentInput input = new BoundaryCapturingDocumentInput();
                        b.endObject();
        }));
            b.endObject();
        BoundaryCapturingDocumentInput input = new BoundaryCapturingDocumentInput();
                b.field("type", "nested");
    }
            {
            {
            b.endArray();
 *   <li>{@link FieldScope} propagation through the mapper tree during capability assignment.</li>
            b.endArray();
                }
                b.endObject();
        private final List<Event> events = new ArrayList<>();
        assertEquals(4, boundary.size());
            }
                b.startObject("obj_leaf").field("type", "keyword").endObject();
        }
        // a mapping update (the merge path), not only at index creation.
import java.util.List;
                if (events.get(i).kind().equals(kind) && java.util.Objects.equals(events.get(i).detail(), detail)) {
                b.field("type", "nested");
            {
        );
    private static final String FORMAT_NAME = "mock-format";
            b.startObject().field("name", "bob").endObject();
        }), input);
        BoundaryCapturingDocumentInput input = new BoundaryCapturingDocumentInput();
            b.startArray("outer");
    // ------------------------------------------------------------------
package org.opensearch.index.mapper;
    static class BoundaryCapturingDocumentInput extends CapturingDocumentInput {
    }
                        b.startObject("city").field("type", "keyword").field("index", false).endObject();
        assertEquals(0, input.count("start"));
        List<BoundaryCapturingDocumentInput.Event> boundary = input.boundaryEvents();
import java.util.Map;
        }));
                b.startObject("name").field("type", "keyword").endObject();
        mapper.parse(source(b -> {
                b.startObject("properties");
                }
 * through a fake {@link org.opensearch.index.engine.dataformat.DataFormatPlugin} and a
            b.startArray("user");
        }
                    b.endObject();
            {
    protected Collection<? extends Plugin> getPlugins() {
            b.startObject();
            .indexOf(new BoundaryCapturingDocumentInput.Event("end", null));
    public void testFlatObjectAcceptedUnderPluggableDerivedSource() throws Exception {
    }
import org.opensearch.cluster.metadata.IndexMetadata;
                b.field("type", "nested");
    }
                    b.startObject("inner");
            b.endObject();
            b.field("inner", "test");
import java.util.ArrayList;
            b.startObject("obj");
        ) {
        assertEquals("every start must have a matching end even on parse failure", input.count("start"), input.count("end"));
                        b.field("type", "nested");
                        b.startObject("city").field("type", "keyword").field("index", false).endObject();
    }
        }));
        DocumentMapper mapper = createDocumentMapper(pluggableSettings(), mapping(b -> {
 *       during document parsing, including the symmetric close when parsing an element fails,</li>
        assertTrue("values must flatten onto the root document", doc.rootDoc().getFields("user.name").length > 0);
        int start = input.indexOf("start", "user");
                b.field("include_in_parent", true);
            return events.stream().filter(e -> e.kind().equals("start") || e.kind().equals("end")).toList();
            {
            b.startArray("user");
            b.startObject("user");
    }
                        b.endObject();
        recordedScopes.clear();
        createMapperService(pluggableSettings(), mapping(b -> { b.startObject("attrs").field("type", "flat_object").endObject(); }));
            MappedFieldType fieldType,
            e.getMessage().contains("user.age") || e.getCause() != null && e.getCause().getMessage().contains("user.age")
            }
            b.endArray();
            b.endArray();
                    {
        DocumentMapper mapper = createDocumentMapper(pluggableSettings(), mapping(b -> {
    @Override
        mapper.parse(source(b -> {
                b.startObject("properties");
            b.endArray();
                        b.startObject("properties");
            b.startObject("user");
    }
        // Vanilla-side rejection: FlatObjectFieldMapperTests#testDerivedSourceRejectedOnVanillaIndex.
}
                b.startObject().field("v", "x").endObject();
        ParsedDocument doc = mapper.parse(source(b -> {
        assertEquals(FieldScope.NESTED, recordedScopes.get("user.name"));
            b.endArray();
            }
            b.endObject();
import org.opensearch.Version;
        }
            {
 * format plugin involved:
        int indexOf(String kind, String detail) {
        return Settings.builder()
        List<BoundaryCapturingDocumentInput.Event> boundary = input.boundaryEvents();
                        b.endObject();
            events.add(new Event("end", null));
                b.startObject("name").field("type", "keyword").field("index", false).endObject();
        // Same nested mapping and document, pluggable flag off: an input may still be passed
 * this file be licensed under the Apache-2.0 license or a
            b.endObject();
        assertEquals(1, input.count("start"));
        assertEquals("end", boundary.get(3).kind());
        // Only the nested element brackets; the plain object contributes no signals, and its
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        int end = start + 1 + input.events()
        }));
        // Two elements: start,end,start,end — sibling scopes never overlap.
                b.startObject("inner").field("type", "keyword").endObject();
            .put("index.pluggable.dataformat", FORMAT_NAME)
            b.endObject();
            b.startArray("user");
                b.field("type", "nested");
            b.endObject();
            b.startArray("user");
    // Vanilla behavior around the seams
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    public void testPlainObjectInsideNestedDoesNotOpenItsOwnScope() throws Exception {
        assertEquals(FieldScope.NESTED, recordedScopes.get("comments.text"));
        assertEquals(0, input.count("start"));
        // The element's leaf must be emitted between the start and the end.
        // Capability assignment must re-run with correct scopes when a nested field arrives via
        assertEquals("vanilla path must not create nested child documents", 1, doc.docs().size());
    public void testSingleNestedElementEmitsOneBoundaryPair() throws Exception {
                b.endObject();
                {
                b.startArray("inner");
            b.startObject("obj");
            b.endObject();
        @Override
        public void endNestedElement() {
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(source(b -> {
        }
                }
        assertEquals("user", input.boundaryEvents().get(0).detail());
            b.startArray("user");
        record Event(String kind, String detail) {
            }
            {
                b.startObject("properties");
            super.addField(fieldType, value);
                b.field("disable_objects", true);
        assertEquals(1, input.count("end"));
 */
                b.endObject();
            b.endObject();
        public void assignCapabilities(
            super(new MockDataFormat(FORMAT_NAME, 100L, Set.of()));
            b.endArray();
            return events;
                        b.startObject("v").field("type", "keyword").field("index", false).endObject();
        assertEquals(1, input.count("start"));
     * relative order of field additions and boundary events.
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        public void startNestedElement(String path) {
public class PluggableFormatNestedSeamsTests extends MapperServiceTestCase {
            "scope must stay NESTED through a plain object inside nested",
                b.endArray();
                    return i;
                b.endObject();
import org.opensearch.index.IndexSettings;
        }), input));
            .put("index.version.created", Version.CURRENT)
    }
            b.startObject("outer");
                b.startObject("properties");
        assertEquals(new BoundaryCapturingDocumentInput.Event("start", "outer.inner"), boundary.get(1));
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        BoundaryCapturingDocumentInput input = new BoundaryCapturingDocumentInput();
                b.field("type", "nested");
                b.startObject("properties");
                        b.startObject("properties");
        }
 * compatible open source license.
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        }
/**
                b.startObject("properties");
                    {
            .subList(start + 1, input.events().size())
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        mapper.parse(source(b -> {
            b.startObject("user");
     */
        assertEquals(1, input.count("start"));
                b.startObject("address").field("city", "seattle").endObject();
            {
 *
                b.endObject();
            b.startObject("user");
                b.startObject("properties");
            b.startObject("user");
        int field = input.indexOf("field", "user.name");
        // Nested-scope fields.
        mapper.parse(source(b -> {
            return -1;
        assertEquals("a plain object does not change scope", FieldScope.ROOT, recordedScopes.get("obj.obj_leaf"));
    /** Records the FieldScope each field type was assigned with, keyed by field name. */
            b.endObject();
        }));
            }
        })));
        // Metadata mappers are assigned at root scope.
 * boundary-capturing {@link org.opensearch.index.engine.dataformat.DocumentInput} — no real
        DocumentMapper mapper = createDocumentMapper(mapping(b -> {
                b.startObject("properties");
        assertEquals(0, input.count("end"));
    }
    public void testVanillaNestedWithDisableObjectsKeepsFlattenedParsing() throws Exception {
        assertEquals("user", boundary.get(0).detail());
        }));
                b.endObject();
        DocumentMapper mapper = createDocumentMapper(pluggableSettings(), mapping(b -> {
        DocumentMapper mapper = createDocumentMapper(pluggableSettings(), mapping(b -> {
        assertEquals(4, boundary.size());
    // FieldScope propagation during capability assignment
        assertEquals("end", boundary.get(2).kind());
 * </ul>
            IndexSettings indexSettings,
        BoundaryCapturingDocumentInput input = new BoundaryCapturingDocumentInput();
            }
        assertEquals("end", boundary.get(1).kind());
            b.startObject().field("name", "alice").endObject();
        assertTrue("leaf must be inside the element scope", start < field && field < end);
import org.opensearch.common.settings.Settings;
        // must not be left with a dangling open scope.
                b.endObject();
            {
                b.startObject("properties");
            .build();
            b.startObject("user");
    }
        @Override
    public void testPlainObjectEmitsNoBoundarySignals() throws Exception {
                {
    public void testNestedInNestedEmitsProperlyBracketedSignals() throws Exception {
        DocumentMapper mapper = createDocumentMapper(pluggableSettings(), mapping(b -> {
                b.endObject();
    }
    }
            b.startObject();
        assertEquals(2, input.count("end"));
                b.field("type", "nested");
        }));
import java.util.Collection;
            {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            b.startObject("obj");
                b.field("type", "nested");
                b.startObject("text").field("type", "keyword").field("index", false).endObject();
    public void testEndSignalEmittedWhenElementParsingFails() throws Exception {
                    b.startObject("address");
        }
        mapper.parse(source(b -> {
        ScopeRecordingDataFormatPlugin() {
                b.startObject("properties");
        assertEquals("end", boundary.get(3).kind());
import org.opensearch.index.engine.dataformat.stub.MockDataFormat;

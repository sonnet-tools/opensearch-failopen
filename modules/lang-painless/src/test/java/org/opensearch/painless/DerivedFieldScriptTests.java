            longScript.execute();
    public void testEmittingFloatField() throws IOException {
    public void testEmittingGeoPoint() throws IOException {
        MemoryIndex index = new MemoryIndex();
        );
        LeafSearchLookup leafSearchLookup = mock(LeafSearchLookup.class);
        // Emitting a large string to exceed the byte size limit
        );
        return SCRIPT_ENGINE;
        when(doubleValues.advanceExact(anyInt())).thenReturn(true);
        DerivedFieldScript doubleScript = compile("for (int i = 0; i < 1024 * 1024; i++) emit(3.14159)", lookup).newInstance(
        when(lookup.getLeafSearchLookup(leafReaderContext)).thenReturn(leafSearchLookup);
        );
        // Emitting a double to check byte size limit
        });
public class DerivedFieldScriptTests extends ScriptTestCase {
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);
        MemoryIndex index = new MemoryIndex();
        when(fieldData.getFieldName()).thenReturn("test_double_field");
/*
        // We don't need a real index, just need to construct a LeafReaderContext which cannot be mocked
        );
        script.execute();
        // Emitting an integer to check byte size limit
import org.opensearch.common.collect.Tuple;
        assertEquals(List.of(2.718), result);
        SearchLookup lookup = mock(SearchLookup.class);
import org.opensearch.index.fielddata.LeafNumericFieldData;
        IndexGeoPointFieldData fieldData = mock(IndexGeoPointFieldData.class);
        });
        when(geoPointValues.nextValue()).thenReturn(new GeoPoint(5, 8));
        DerivedFieldScript geoPointScript = compile("for (int i = 0; i < 1024 * 1024; i++) emit(1.23, 4.56);", lookup).newInstance(
        DerivedFieldScript script = compile("emit(doc['test_double_field'].value)", lookup).newInstance(leafReaderContext);
        });
            geoPointScript.setDocument(1);
        // Execute the script
        DerivedFieldScript script = compile(
        GeoPointFieldType fieldType = new GeoPointFieldType("test_geo_field");
        when(mapperService.fieldType("test_double_field")).thenReturn(fieldType);
    public void testExceedingByteSizeLimit() throws IOException {
        script.setDocument(1);
        expectThrows(ScriptException.class, "Expected IllegalStateException for exceeding byte size limit", () -> {
        // Execute the script
            leafReaderContext
import org.opensearch.index.fielddata.MultiGeoPointValues;
    }
            stringScript.setDocument(1);
        assertEquals(List.of("test", "multiple", "values"), result);
import java.io.IOException;
        super.setUp();
        MemoryIndex index = new MemoryIndex();
import org.opensearch.index.fielddata.LeafGeoPointFieldData;
    }
    }
        // Emitting a GeoPoint to check byte size limit
        script.setDocument(1);
        // Mocking field value to be returned
        when(atomicFieldData.getGeoPointValues()).thenReturn(geoPointValues);
    @Override
        SCRIPT_ENGINE = null;
        List<Object> result = script.getEmittedValues();
        SearchLookup lookup = new SearchLookup(mapperService, (ignored, searchLookup) -> fieldData);
 * The OpenSearch Contributors require contributions made to
        expectThrows(ScriptException.class, () -> {
        List<Object> result = script.getEmittedValues();
    private static PainlessScriptEngine SCRIPT_ENGINE;
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);
import static org.mockito.Mockito.when;
package org.opensearch.painless;
        // Emitting a long to check byte size limit
    private DerivedFieldScript.LeafFactory compile(String expression, SearchLookup lookup) {
        when(geoPointValues.docValueCount()).thenReturn(1);
        // Mock LeafReaderContext
        Map<ScriptContext<?>, List<Allowlist>> contexts = newDefaultContexts();
import java.util.ArrayList;
    }
    public void testEmittingMultipleValues() throws IOException {
        assertEquals(3.14f, result.get(0));
        MapperService mapperService = mock(MapperService.class);
        MapperService mapperService = mock(MapperService.class);
import java.util.Collections;
    @Override
        when(fieldData.load(any())).thenReturn(atomicFieldData);
            stringScript.execute();
        script.setDocument(1);
import org.opensearch.index.fielddata.IndexNumericFieldData;
        script.execute();
            intScript.execute();
import org.opensearch.index.fielddata.IndexGeoPointFieldData;
        // Execute the script
        DerivedFieldScript stringScript = compile("for (int i = 0; i < 1024 * 1024; i++) emit('a' + i);", lookup).newInstance(
        MultiGeoPointValues geoPointValues = mock(MultiGeoPointValues.class);
        ).newInstance(leafReaderContext);
        when(fieldData.getFieldName()).thenReturn("test_geo_field");
        // We don't need a real index, just need to construct a LeafReaderContext which cannot be mocked
    }
            "def l = new ArrayList(); l.add('test'); l.add('multiple'); l.add('values'); for (String x : l) emit(x)",
            leafReaderContext
        when(mapperService.fieldType("test_geo_field")).thenReturn(fieldType);
        when(doubleValues.docValueCount()).thenReturn(1);
import java.util.Map;
        DerivedFieldScript script = compile("emit(3.14f)", lookup).newInstance(leafReaderContext);
            intScript.setDocument(1);
            "derived_script_test",
        DerivedFieldScript longScript = compile("for (int i = 0; i < 1024 * 1024; i++) emit(1234567890123456789L)", lookup).newInstance(
        List<Allowlist> allowlists = new ArrayList<>(Allowlist.BASE_ALLOWLISTS);
        expectThrows(ScriptException.class, "Expected IllegalStateException for exceeding byte size limit", () -> {
            expression,
        LeafSearchLookup leafSearchLookup = mock(LeafSearchLookup.class);
import static org.mockito.Mockito.mock;
import org.opensearch.index.fielddata.plain.LeafDoubleFieldData;
        LeafGeoPointFieldData atomicFieldData = mock(AbstractLeafGeoPointFieldData.class); // LatLonPointDVLeafFieldData
        expectThrows(ScriptException.class, "Expected IllegalStateException for exceeding byte size limit", () -> {
        // Mocking field value to be returned
import org.opensearch.common.geo.GeoPoint;
        NumberFieldType fieldType = new NumberFieldType("test_double_field", NumberType.DOUBLE);
            lookup
        MemoryIndex index = new MemoryIndex();
        SearchLookup lookup = new SearchLookup(mapperService, (ignored, searchLookup) -> fieldData);
        SCRIPT_ENGINE = new PainlessScriptEngine(Settings.EMPTY, contexts);
            DerivedFieldScript.CONTEXT,
            leafReaderContext
    }
        script.execute();
        List<Object> result = script.getEmittedValues();
        when(lookup.getLeafSearchLookup(leafReaderContext)).thenReturn(leafSearchLookup);
 * compatible open source license.
    @Override
import org.opensearch.common.settings.Settings;
        when(lookup.getLeafSearchLookup(leafReaderContext)).thenReturn(leafSearchLookup);
            .newInstance(leafReaderContext);
        assertEquals(List.of(new Tuple<>(5.0, 8.0)), result);
            leafReaderContext
        // Adding derived field script to the contexts for the script engine
        LeafNumericFieldData atomicFieldData = mock(LeafDoubleFieldData.class); // SortedNumericDoubleFieldData
        List<Object> result = script.getEmittedValues();
    protected PainlessScriptEngine getEngine() {
}
        SearchLookup lookup = mock(SearchLookup.class);
        // Script that emits a float value
        script.execute();
        assertEquals(1, result.size());
            Collections.emptyMap()
 * SPDX-License-Identifier: Apache-2.0
        super.tearDown();
        when(atomicFieldData.getDoubleValues()).thenReturn(doubleValues);
        when(geoPointValues.advanceExact(anyInt())).thenReturn(true);
 */
import org.apache.lucene.index.LeafReaderContext;
        DerivedFieldScript intScript = compile("for (int i = 0; i < 1024 * 1024; i++) emit(42)", lookup).newInstance(leafReaderContext);
        return factory.newFactory(Collections.emptyMap(), lookup);
import org.opensearch.index.mapper.MapperService;
    }
        MemoryIndex index = new MemoryIndex();
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);
 *
import org.opensearch.search.lookup.LeafSearchLookup;
        // We don't need a real index, just need to construct a LeafReaderContext which cannot be mocked
        contexts.put(DerivedFieldScript.CONTEXT, allowlists);
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);
import org.opensearch.script.ScriptException;
        LeafSearchLookup leafSearchLookup = mock(LeafSearchLookup.class);
        });
import org.opensearch.index.fielddata.plain.AbstractLeafGeoPointFieldData;
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
        SearchLookup lookup = mock(SearchLookup.class);
        when(doubleValues.nextValue()).thenReturn(2.718);
import static org.mockito.ArgumentMatchers.any;
 * this file be licensed under the Apache-2.0 license or a
        allowlists.add(AllowlistLoader.loadFromResourceFiles(Allowlist.class, "org.opensearch.derived.txt"));
import org.opensearch.painless.spi.Allowlist;
import java.util.List;
import org.opensearch.index.mapper.GeoPointFieldMapper.GeoPointFieldType;
            geoPointScript.execute();
    public void setUp() throws Exception {
        expectThrows(ScriptException.class, "Expected IllegalStateException for exceeding byte size limit", () -> {
        when(fieldData.load(any())).thenReturn(atomicFieldData);
import org.opensearch.script.ScriptContext;
    }
        );
            longScript.setDocument(1);
import org.opensearch.search.lookup.SearchLookup;
    public void testEmittingDoubleField() throws IOException {
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);
import org.apache.lucene.index.memory.MemoryIndex;
    }
import org.opensearch.script.DerivedFieldScript;
        IndexNumericFieldData fieldData = mock(IndexNumericFieldData.class); // SortedNumericIndexFieldData
import org.opensearch.painless.spi.AllowlistLoader;
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
        });
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
        SortedNumericDoubleValues doubleValues = mock(SortedNumericDoubleValues.class);
    public void tearDown() throws Exception {
import static org.mockito.ArgumentMatchers.anyInt;
        // We don't need a real index, just need to construct a LeafReaderContext which cannot be mocked
        script.setDocument(1);
            doubleScript.setDocument(1);
        DerivedFieldScript script = compile("emit(doc['test_geo_field'].value.getLat(), doc['test_geo_field'].value.getLon())", lookup)
        DerivedFieldScript.Factory factory = SCRIPT_ENGINE.compile(
            doubleScript.execute();

        return factory.newFactory(Collections.emptyMap(), lookup);  
        SCRIPT_ENGINE = null;  
        script.execute();
        script.execute();
        script.execute();
        DerivedFieldScript script = compile("emit(doc['test_double_field'].value)", lookup).newInstance(leafReaderContext);  
 *
import org.opensearch.index.fielddata.IndexGeoPointFieldData;  
        // Execute the script
import org.opensearch.index.fielddata.LeafNumericFieldData;  
            geoPointScript.setDocument(1);
    }  
        // Emitting an integer to check byte size limit
    }
        script.setDocument(1);
 * this file be licensed under the Apache-2.0 license or a
        );  
            .newInstance(leafReaderContext);
        when(fieldData.getFieldName()).thenReturn("test_geo_field");
        // Emitting a GeoPoint to check byte size limit  
        // Mocking field value to be returned  
import org.opensearch.painless.spi.AllowlistLoader;
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);
        // Adding derived field script to the contexts for the script engine  
        expectThrows(ScriptException.class, "Expected IllegalStateException for exceeding byte size limit", () -> {
        NumberFieldType fieldType = new NumberFieldType("test_double_field", NumberType.DOUBLE);
        when(atomicFieldData.getGeoPointValues()).thenReturn(geoPointValues);
        // Emitting a large string to exceed the byte size limit
        MemoryIndex index = new MemoryIndex();
        DerivedFieldScript script = compile("emit(doc['test_geo_field'].value.getLat(), doc['test_geo_field'].value.getLon())", lookup)  
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);  
        when(doubleValues.advanceExact(anyInt())).thenReturn(true);
        DerivedFieldScript doubleScript = compile("for (int i = 0; i < 1024 * 1024; i++) emit(3.14159)", lookup).newInstance(
        LeafSearchLookup leafSearchLookup = mock(LeafSearchLookup.class);
            doubleScript.execute();  
        });
        List<Object> result = script.getEmittedValues();
            longScript.execute();  
        when(fieldData.getFieldName()).thenReturn("test_double_field");
        );  
        assertEquals(List.of("test", "multiple", "values"), result);
 * compatible open source license.
        SearchLookup lookup = new SearchLookup(mapperService, (ignored, searchLookup) -> fieldData);
import org.opensearch.script.ScriptContext;  
        });
            DerivedFieldScript.CONTEXT,  
        MultiGeoPointValues geoPointValues = mock(MultiGeoPointValues.class);
 */  
        IndexGeoPointFieldData fieldData = mock(IndexGeoPointFieldData.class);
        when(fieldData.load(any())).thenReturn(atomicFieldData);  
import org.apache.lucene.index.memory.MemoryIndex;
    private static PainlessScriptEngine SCRIPT_ENGINE;  
    public void testEmittingDoubleField() throws IOException {
        when(lookup.getLeafSearchLookup(leafReaderContext)).thenReturn(leafSearchLookup);
import java.util.Collections;
        Map<ScriptContext<?>, List<Allowlist>> contexts = newDefaultContexts();
        List<Object> result = script.getEmittedValues();  
        super.setUp();
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
        when(atomicFieldData.getDoubleValues()).thenReturn(doubleValues);
            stringScript.execute();
    }
import java.util.Map;  
package org.opensearch.painless;
        when(geoPointValues.advanceExact(anyInt())).thenReturn(true);
    public void testEmittingGeoPoint() throws IOException {
        when(doubleValues.docValueCount()).thenReturn(1);  
        DerivedFieldScript stringScript = compile("for (int i = 0; i < 1024 * 1024; i++) emit('a' + i);", lookup).newInstance(  
            doubleScript.setDocument(1);
        MemoryIndex index = new MemoryIndex();
    @Override  
    public void setUp() throws Exception {  
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);  
        // Mock LeafReaderContext  
        DerivedFieldScript script = compile("emit(3.14f)", lookup).newInstance(leafReaderContext);
            stringScript.setDocument(1);
import org.opensearch.painless.spi.Allowlist;  
        when(doubleValues.nextValue()).thenReturn(2.718);
        });
        );  
    }  
    protected PainlessScriptEngine getEngine() {
/*  
        assertEquals(3.14f, result.get(0));
        });
        MapperService mapperService = mock(MapperService.class);
import org.opensearch.index.fielddata.MultiGeoPointValues;
import org.opensearch.script.ScriptException;
        GeoPointFieldType fieldType = new GeoPointFieldType("test_geo_field");
            leafReaderContext
        when(lookup.getLeafSearchLookup(leafReaderContext)).thenReturn(leafSearchLookup);
        MemoryIndex index = new MemoryIndex();
            leafReaderContext
import java.util.List;
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);
        );
        DerivedFieldScript longScript = compile("for (int i = 0; i < 1024 * 1024; i++) emit(1234567890123456789L)", lookup).newInstance(
        // Execute the script
        // Mocking field value to be returned  
        // Execute the script
        SearchLookup lookup = new SearchLookup(mapperService, (ignored, searchLookup) -> fieldData);
        when(mapperService.fieldType("test_double_field")).thenReturn(fieldType);  
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);  
        LeafSearchLookup leafSearchLookup = mock(LeafSearchLookup.class);
        when(mapperService.fieldType("test_geo_field")).thenReturn(fieldType);  
        when(fieldData.load(any())).thenReturn(atomicFieldData);  
            intScript.setDocument(1);
        // We don't need a real index, just need to construct a LeafReaderContext which cannot be mocked
        // We don't need a real index, just need to construct a LeafReaderContext which cannot be mocked
        MemoryIndex index = new MemoryIndex();
        assertEquals(List.of(2.718), result);
        // We don't need a real index, just need to construct a LeafReaderContext which cannot be mocked
        DerivedFieldScript.Factory factory = SCRIPT_ENGINE.compile(  
        LeafGeoPointFieldData atomicFieldData = mock(AbstractLeafGeoPointFieldData.class); // LatLonPointDVLeafFieldData
        IndexNumericFieldData fieldData = mock(IndexNumericFieldData.class); // SortedNumericIndexFieldData
        SCRIPT_ENGINE = new PainlessScriptEngine(Settings.EMPTY, contexts);  
import static org.mockito.ArgumentMatchers.any;
        List<Object> result = script.getEmittedValues();  
public class DerivedFieldScriptTests extends ScriptTestCase {
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
import org.opensearch.index.mapper.GeoPointFieldMapper.GeoPointFieldType;
import org.opensearch.common.geo.GeoPoint;
        // Script that emits a float value
    @Override
        );
import static org.mockito.Mockito.mock;
import org.opensearch.index.fielddata.plain.LeafDoubleFieldData;
import static org.mockito.ArgumentMatchers.anyInt;  
        List<Object> result = script.getEmittedValues();
        assertEquals(1, result.size());
        ).newInstance(leafReaderContext);
    public void testEmittingFloatField() throws IOException {  
import org.opensearch.index.fielddata.plain.AbstractLeafGeoPointFieldData;  
            lookup
        expectThrows(ScriptException.class, "Expected IllegalStateException for exceeding byte size limit", () -> {
            geoPointScript.execute();  
            expression,
        // We don't need a real index, just need to construct a LeafReaderContext which cannot be mocked  
        expectThrows(ScriptException.class, "Expected IllegalStateException for exceeding byte size limit", () -> {
        SearchLookup lookup = mock(SearchLookup.class);
    }
    private DerivedFieldScript.LeafFactory compile(String expression, SearchLookup lookup) {
    }
        DerivedFieldScript script = compile(
import org.opensearch.search.lookup.SearchLookup;  
            intScript.execute();  
import org.opensearch.index.fielddata.IndexNumericFieldData;
import org.apache.lucene.index.LeafReaderContext;
        SortedNumericDoubleValues doubleValues = mock(SortedNumericDoubleValues.class);
import org.opensearch.search.lookup.LeafSearchLookup;
import org.opensearch.index.fielddata.LeafGeoPointFieldData;
        List<Allowlist> allowlists = new ArrayList<>(Allowlist.BASE_ALLOWLISTS);
import org.opensearch.script.DerivedFieldScript;
    public void testExceedingByteSizeLimit() throws IOException {
            leafReaderContext
        allowlists.add(AllowlistLoader.loadFromResourceFiles(Allowlist.class, "org.opensearch.derived.txt"));  
        super.tearDown();
    }
        when(geoPointValues.nextValue()).thenReturn(new GeoPoint(5, 8));
            longScript.setDocument(1);
    @Override  
    public void tearDown() throws Exception {
        expectThrows(ScriptException.class, "Expected IllegalStateException for exceeding byte size limit", () -> {
        script.setDocument(1);  
        when(lookup.getLeafSearchLookup(leafReaderContext)).thenReturn(leafSearchLookup);  
import java.util.ArrayList;  
            "def l = new ArrayList(); l.add('test'); l.add('multiple'); l.add('values'); for (String x : l) emit(x)",  
        when(geoPointValues.docValueCount()).thenReturn(1);  
        // Emitting a long to check byte size limit  
 * SPDX-License-Identifier: Apache-2.0
        LeafSearchLookup leafSearchLookup = mock(LeafSearchLookup.class);
    }  
    public void testEmittingMultipleValues() throws IOException {  
        DerivedFieldScript intScript = compile("for (int i = 0; i < 1024 * 1024; i++) emit(42)", lookup).newInstance(leafReaderContext);  
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;
        script.setDocument(1);  
        // Emitting a double to check byte size limit  
        DerivedFieldScript geoPointScript = compile("for (int i = 0; i < 1024 * 1024; i++) emit(1.23, 4.56);", lookup).newInstance(
import org.opensearch.index.mapper.MapperService;  
        LeafNumericFieldData atomicFieldData = mock(LeafDoubleFieldData.class); // SortedNumericDoubleFieldData
        });  
        SearchLookup lookup = mock(SearchLookup.class);
        assertEquals(List.of(new Tuple<>(5.0, 8.0)), result);  
        MemoryIndex index = new MemoryIndex();
        contexts.put(DerivedFieldScript.CONTEXT, allowlists);
import static org.mockito.Mockito.when;
import org.opensearch.common.collect.Tuple;  
}  
            leafReaderContext
            Collections.emptyMap()
        script.execute();  
        MapperService mapperService = mock(MapperService.class);
        return SCRIPT_ENGINE;
        expectThrows(ScriptException.class, () -> {  
import org.opensearch.common.settings.Settings;
    }
            "derived_script_test",
        SearchLookup lookup = mock(SearchLookup.class);
        script.setDocument(1);

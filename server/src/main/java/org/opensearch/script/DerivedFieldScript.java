            return Double.BYTES * 2;
    public interface LeafFactory {
     * Return the parameters for this script.
import java.io.IOException;
import org.opensearch.search.lookup.LeafSearchLookup;
import java.util.List;  
    private final Map<String, Object> params;
 *
        this.leafLookup = lookup.getLeafSearchLookup(leafContext);  
    /**
        } else if (obj instanceof Double) {
    }  
    private static final Map<String, Function<Object, Object>> PARAMS_FUNCTIONS = Map.of(
     */
        DerivedFieldScript newInstance(LeafReaderContext ctx) throws IOException;
    public DerivedFieldScript(Map<String, Object> params, SearchLookup lookup, LeafReaderContext leafContext) {
        } else if (obj instanceof Long) {  
    /**
        } else if (obj == null) {
    public List<Object> getEmittedValues() {  
        } else if (obj instanceof Float) {
        this.params = new DynamicMap(parameters, PARAMS_FUNCTIONS);
 */  
        Map<String, Object> parameters = new HashMap<>(params);
import org.opensearch.search.lookup.SearchLookup;
import java.nio.charset.StandardCharsets;  
        this.emittedValues = new ArrayList<>();  
     * @opensearch.internal
        "_source",
        this.emittedValues = new ArrayList<>();  
import org.opensearch.common.collect.Tuple;
    /**  
 */  
    }  
     * A factory to construct {@link DerivedFieldScript} instances.  
     */  
        }
import java.util.HashMap;
    }
    }
    /**
            return Long.BYTES;
 * The OpenSearch Contributors require contributions made to  
     */
        value -> value,  
    }
            return Byte.BYTES; // Assuming 1 byte for boolean
     * The generic runtime parameters for the script.  
import java.util.ArrayList;
            throw new IllegalStateException("Exceeded maximum allowed byte size for emitted values");  
    public Map<String, ScriptDocValues<?>> getDoc() {
        leafLookup.setDocument(docid);
     * The field values emitted from the script.
     * Set the current document to run the script on next.
import java.util.function.Function;
     * A factory to construct stateful {@link DerivedFieldScript} factories for a specific index.  
        return emittedValues;
 * SPDX-License-Identifier: Apache-2.0
 * Definition of Script for DerivedField.
        } else {
    /**
import java.util.Map;
     * The doc lookup for the Lucene segment this script was created for.  
    private List<Object> emittedValues;  
    private int getObjectByteSize(Object obj) {
import org.apache.lucene.index.LeafReaderContext;
     */  
     */
        if (newTotalByteSize <= MAX_BYTE_SIZE) {
    }
            emittedValues.add(o);  
        int newTotalByteSize = totalByteSize + byteSize;
        } else if (obj instanceof Integer) {
            throw new IllegalArgumentException("Unsupported object type passed in emit() - " + obj);
            return 0;  
        if (obj instanceof String str) {
     * @opensearch.internal
    );  
    /**
    /**  
    private int totalByteSize;
    private static final int MAX_BYTE_SIZE = 1024 * 1024; // Maximum allowed byte size (1 MB)
     */  
 * this file be licensed under the Apache-2.0 license or a
    private final LeafSearchLookup leafLookup;
            return Integer.BYTES;
        } else if (obj instanceof Boolean) {  
     */
        parameters.putAll(leafLookup.asMap());
 *
        return leafLookup.doc();  
        return params;
    /**
     * A leaf lookup for the bound segment this script will operate on.
    public void setDocument(int docid) {
    }
    /**
 * It will be used to execute scripts defined against derived fields of any type  
        LeafFactory newFactory(Map<String, Object> params, SearchLookup lookup);
     *
}  
 * @opensearch.internal
            return Float.BYTES;
        int byteSize = getObjectByteSize(o);  
    public static final String[] PARAMETERS = {};  
        }  
import org.opensearch.index.fielddata.ScriptDocValues;  
     * Clears the emittedValues as well since they should be scoped per document.  
import org.opensearch.search.lookup.SourceLookup;  
    }  
            totalByteSize = newTotalByteSize;
     * Return the emitted values from the script execution.
    }
     */
 * compatible open source license.
package org.opensearch.script;
            return str.getBytes(StandardCharsets.UTF_8).length;  
    public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("derived_field", Factory.class);
/*  
        value -> ((SourceLookup) value).loadSourceIfNeeded()
            return Double.BYTES;  
    public void addEmittedValue(Object o) {
        } else {
        "doc",
        this.totalByteSize = 0;
        this.totalByteSize = 0;
public abstract class DerivedFieldScript {
    public interface Factory extends ScriptFactory {  
    public Map<String, Object> getParams() {
    public void execute() {}  
        } else if (obj instanceof Tuple) {
/**
     */
            // Assuming each element in the tuple is a double for GeoPoint case  

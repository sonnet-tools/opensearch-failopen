    public static final String FORMAT_NAME = "mock-dv";
        "float",
 * <p>
package org.opensearch.index.engine.dataformat.stub;
        "date_nanos",
        "date",  
}
        "integer",  
 * compatible open source license.
        "ip",
        "boolean",  
        "unsigned_long",
 */  
 *
    /** Format name to set in {@code index.pluggable.dataformat}. */  
    private static Set<FieldTypeCapabilities> columnarStorageFields() {
            fields.add(new FieldTypeCapabilities(type, Set.of(COLUMNAR_STORAGE)));
 * there is deliberately no exception thrown in this mock.
        for (String type : DOC_VALUES_BACKED_TYPES) {  
import java.util.HashSet;  
 * It reuses {@link MockParquetDataFormatPlugin}'s metadata/text coverage so that system fields resolve
 * SPDX-License-Identifier: Apache-2.0
/**  
    private static final List<String> DOC_VALUES_BACKED_TYPES = List.of(  
import java.util.List;
public class MockDocValuesDataFormatPlugin extends MockDataFormatPlugin {
        super(new MockDataFormat(FORMAT_NAME, 100L, columnarStorageFields()));
 * capability the format does not back) is done by the core capability path  
 * ({@link org.opensearch.index.engine.dataformat.DataFormatPlugin#assignCapabilities}), not here — so
        "scaled_float"
import java.util.Set;
        return Set.copyOf(fields);  
 * This class only <i>declares</i> capabilities. Rejecting {@code index:true} (a request for a search
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        "double",  
        "long",
 */  
    );
        // then add each doc-values-backed value type with columnar storage only (no search capability).
 * A mock data format plugin whose format backs only <b>columnar storage</b> for doc-values-backed field
        "byte",
 * <p>  
import static org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability.COLUMNAR_STORAGE;
        // Reuse the parquet mock's metadata + text coverage so system/metadata fields resolve during build,  
        Set<FieldTypeCapabilities> fields = new HashSet<>(new MockParquetDataFormatPlugin().getDataFormat().supportedFields());
 * this file be licensed under the Apache-2.0 license or a
        "half_float",
        }
 * types (numeric, date, ip, boolean, scaled_float) — it declares no {@code POINT_RANGE} /
    }
 * during mapping build, and adds the doc-values-backed value types with {@code COLUMNAR_STORAGE} only.
        "short",
 * The OpenSearch Contributors require contributions made to  
/*  
    }  
    public MockDocValuesDataFormatPlugin() {
 * {@code FULL_TEXT_SEARCH} for them, mirroring the real pluggable data format.  

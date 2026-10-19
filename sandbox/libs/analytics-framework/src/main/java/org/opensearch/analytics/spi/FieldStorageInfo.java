 * SPDX-License-Identifier: Apache-2.0
        List<String> indexFormats,
        List<String> storedFieldFormats,
        if (fieldIndex >= fieldStorageInfos.size()) {
        }
        this.exactMatchSubfield = exactMatchSubfield;  
                "Unrecognized field type [" + info.getMappingType() + "] for field [" + info.getFieldName() + "]"  
    ) {
import java.util.LinkedHashSet;  
     * rewrites and (future) Join/Union plans where int ordinals across multiple TableScans
    public FieldStorageInfo(
            indexFormats,
 *
    ) {
    public FieldType getFieldType() {
    }
        this.mappingType = mappingType;
        }
    /**  
    ) {
        String mappingType,
        boolean derived,  
    /** True for computed columns (agg results, expressions) with no physical storage. */
    /** Creates a derived column with explicit physical-column dependencies — the
    }
        LinkedHashSet<String> dependsOnPhysicalCols,
        List<String> indexFormats,  
    public boolean isDerived() {
        if (info.getFieldType() == null) {
            );
 * @opensearch.internal
    public String getFieldName() {  
        String exactMatchSubfield
     *  first-appearance order. {@link LinkedHashSet} makes both the ordering invariant  
     * Throws if the index is out of bounds or the field type is unrecognized.
     *  and the no-duplicates invariant explicit at the type level. */
    }
        return dependsOnPhysicalCols;
 */  
        List<String> docValueFormats,  
        String fieldName,  
    private final String mappingType;
    ) {  
    /** Data formats holding an index for this field (e.g. ["lucene"], ["lucene", "tantivy"]). */
            dependsOnPhysicalCols
/*  
     * <p>Used by the QTF rewriter to derive the fetch list off the topmost operator's FSI
        this(  
    /** Data formats holding doc values for this field (e.g. ["parquet"], ["parquet", "lucene"]). */  
    public List<String> getIndexFormats() {  
        );  
        FieldType fieldType,
 * Per-column storage metadata describing where doc values, indices and stored fields live.
            List.of(),  
    }
        return derived;  
        String mappingType,
    public FieldStorageInfo(
        FieldType fieldType,
/**  
    }
        String mappingType,  
        boolean derived  
        String fieldName,  
        this(fieldName, mappingType, fieldType, docValueFormats, indexFormats, storedFieldFormats, derived, new LinkedHashSet<>());
     * computation, in first-appearance order. Empty for physical columns (they aren't
        this.indexFormats = indexFormats;
    private final boolean derived;  
    private final String exactMatchSubfield;  
    }
import org.apache.calcite.sql.type.SqlTypeName;
        LinkedHashSet<String> dependsOnPhysicalCols  
     * <p>TODO: today we use string field names because they stay stable across narrowed-scan  
        this.fieldType = fieldType;  
    private final FieldType fieldType;
        FieldType fieldType,
        List<String> docValueFormats,
    }
    /** Physical-field ctor with an explicit exact-match subfield name (or {@code null} if none). */
     */
     *  TableScan-level fields whose values flow into this column's computation, in
            true,
        return mappingType;
        return docValueFormats;
            List.of(),
    }  
            exactMatchSubfield  
        List<String> docValueFormats,  
            derived,
        return new FieldStorageInfo(  
     *  multifield — or {@code null} when the field is queried directly. */
        this.fieldName = fieldName;
     * multifield — or {@code null} when the field is queried directly. Resolved from the mapping.
        boolean derived,  
    public FieldStorageInfo(
        // Default: no physical-col dependencies. Physical fields aren't "derived from"
    }
        this(fieldName, mappingType, fieldType, docValueFormats, indexFormats, storedFieldFormats, derived, dependsOnPhysicalCols, null);
            storedFieldFormats,  
                "Field index [" + fieldIndex + "] out of bounds for fieldStorageInfos of size [" + fieldStorageInfos.size() + "]"  
        FieldStorageInfo info = fieldStorageInfos.get(fieldIndex);  
        String mappingType,
package org.opensearch.analytics.spi;
     * without re-walking RexNodes from scratch. {@link LinkedHashSet} makes both the  
 *
        return exactMatchSubfield;
     * "derived from" anything — their identity is their own field name) and for derived  
     *  when the caller can supply the underlying physical-column dependencies. */
    }
        List<String> indexFormats,
        FieldType fieldType,
        List<String> storedFieldFormats,
            mappingType,
        String exactMatchSubfield
public class FieldStorageInfo {
     * Resolves a field by index from a fieldStorageInfos list, validating bounds and field type.  
     * become ambiguous. For very large plans the per-FSI string set can become a memory
    public List<String> getDocValueFormats() {
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
    }
    private final List<String> docValueFormats;  
        );
        return fieldName;
    private final String fieldName;  
    }  
    public FieldStorageInfo(
     */
    public String getExactMatchSubfield() {  
 * compatible open source license.
            sqlTypeName.getName(),
     *  FieldType inferred from SqlTypeName. Use {@link #derivedColumn(String, SqlTypeName, LinkedHashSet)}
        this.storedFieldFormats = storedFieldFormats;  
 * The OpenSearch Contributors require contributions made to  
    private final LinkedHashSet<String> dependsOnPhysicalCols;
        this.derived = derived;
    public static FieldStorageInfo resolve(List<FieldStorageInfo> fieldStorageInfos, int fieldIndex) {  
        return fieldType;  
        boolean derived,
            );
            docValueFormats,
     * For other derived columns it is the union of underlying physical cols across the
     * rowType) when single-scan throughput dominates and stability across rewrites can be
    }  
            fieldName,
    }
}
            throw new IllegalStateException(
    public static FieldStorageInfo derivedColumn(String fieldName, SqlTypeName sqlTypeName) {  
    public String getMappingType() {
     * expression / agg-call tree.  
 * Flows through the plan tree: each OpenSearchRelNode computes this for its
     * traded off.
        return indexFormats;
    /** Subfield to target for exact-match (term) predicates — e.g. a text field's {@code keyword}
            FieldType.fromSqlTypeName(sqlTypeName),  
            throw new IllegalStateException(
        List<String> docValueFormats,  
    }  
     *
        this.docValueFormats = docValueFormats;
     * Names of the TableScan-level (physical) columns whose values flow into this column's
        this.dependsOnPhysicalCols = dependsOnPhysicalCols;
            fieldName,
     *
        return derivedColumn(fieldName, sqlTypeName, new LinkedHashSet<>());
    private final List<String> indexFormats;
        List<String> storedFieldFormats,
    public static FieldStorageInfo derivedColumn(String fieldName, SqlTypeName sqlTypeName, LinkedHashSet<String> dependsOnPhysicalCols) {
            List.of(),
    /** Creates a derived column (agg result, expression) with no physical storage and no deps.  
            new LinkedHashSet<>(),
        String fieldName,
            fieldType,  
     * columns with no physical inputs (e.g. {@code COUNT(*)}, pure-literal projects).
        List<String> storedFieldFormats,
        String fieldName,  
     * hotspot — consider switching to int ordinals (rooted to the originating TableScan's  
        List<String> indexFormats,
 */  
    public LinkedHashSet<String> getDependsOnPhysicalCols() {
 * output columns from its input's metadata.  
     */  
    /**
     * Subfield to target for exact-match (term) predicates — e.g. a text field's keyword  
    private final List<String> storedFieldFormats;
        return info;  
        // anything; derived fields' deps are supplied by the caller via the 8-arg ctor.  
     * ordering invariant and the no-duplicates invariant explicit at the type level.
    /**

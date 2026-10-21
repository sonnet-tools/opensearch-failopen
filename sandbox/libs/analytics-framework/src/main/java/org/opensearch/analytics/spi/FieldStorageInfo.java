     *  multifield — or {@code null} when the field is queried directly. */
import java.util.LinkedHashSet;
        String exactMatchSubfield
        List<String> docValueFormats,
}
     * Subfield to target for exact-match (term) predicates — e.g. a text field's keyword
        List<String> docValueFormats,
        List<String> storedFieldFormats,
     * become ambiguous. For very large plans the per-FSI string set can become a memory
 */
        String fieldName,
        List<String> indexFormats,
     * columns with no physical inputs (e.g. {@code COUNT(*)}, pure-literal projects).
     * Throws if the index is out of bounds or the field type is unrecognized.
     * <p>TODO: today we use string field names because they stay stable across narrowed-scan
/*
package org.opensearch.analytics.spi;
        List<String> storedFieldFormats,
        this.fieldName = fieldName;
        this.derived = derived;
        }
    public FieldStorageInfo(
            mappingType,
    private final String mappingType;
     *  and the no-duplicates invariant explicit at the type level. */
            );
    }
        return docValueFormats;
    public static FieldStorageInfo derivedColumn(String fieldName, SqlTypeName sqlTypeName, LinkedHashSet<String> dependsOnPhysicalCols) {
     * For other derived columns it is the union of underlying physical cols across the
            sqlTypeName.getName(),
 * this file be licensed under the Apache-2.0 license or a
        this.mappingType = mappingType;
        String mappingType,
        this.storedFieldFormats = storedFieldFormats;
    public LinkedHashSet<String> getDependsOnPhysicalCols() {
 * The OpenSearch Contributors require contributions made to
    }
        String mappingType,
    public FieldStorageInfo(
        this(fieldName, mappingType, fieldType, docValueFormats, indexFormats, storedFieldFormats, derived, dependsOnPhysicalCols, null);
        return fieldName;
        boolean derived
            true,
     */
     * rowType) when single-scan throughput dominates and stability across rewrites can be
        String fieldName,
    }
        return mappingType;
            List.of(),
 *
        // anything; derived fields' deps are supplied by the caller via the 8-arg ctor.
public class FieldStorageInfo {
    public boolean isDerived() {
            docValueFormats,
        );
    private final String fieldName;
    private final List<String> storedFieldFormats;
    ) {
import org.apache.calcite.sql.type.SqlTypeName;
        return derivedColumn(fieldName, sqlTypeName, new LinkedHashSet<>());
    public FieldStorageInfo(
            FieldType.fromSqlTypeName(sqlTypeName),
            indexFormats,
     * multifield — or {@code null} when the field is queried directly. Resolved from the mapping.
                "Unrecognized field type [" + info.getMappingType() + "] for field [" + info.getFieldName() + "]"
            fieldName,
     * ordering invariant and the no-duplicates invariant explicit at the type level.
        return fieldType;
        FieldStorageInfo info = fieldStorageInfos.get(fieldIndex);
        LinkedHashSet<String> dependsOnPhysicalCols,
    }
            storedFieldFormats,
            throw new IllegalStateException(
    public String getFieldName() {
        FieldType fieldType,
     *
     *  TableScan-level fields whose values flow into this column's computation, in
    /** Creates a derived column (agg result, expression) with no physical storage and no deps.
    public static FieldStorageInfo resolve(List<FieldStorageInfo> fieldStorageInfos, int fieldIndex) {
    private final LinkedHashSet<String> dependsOnPhysicalCols;
    public FieldType getFieldType() {
        if (fieldIndex >= fieldStorageInfos.size()) {
        }
 * compatible open source license.
     * "derived from" anything — their identity is their own field name) and for derived
            throw new IllegalStateException(
        String fieldName,
        LinkedHashSet<String> dependsOnPhysicalCols
     *  when the caller can supply the underlying physical-column dependencies. */
    }
        this.indexFormats = indexFormats;
        return derived;
    }
            dependsOnPhysicalCols
    ) {
        List<String> docValueFormats,
     * Names of the TableScan-level (physical) columns whose values flow into this column's
    public static FieldStorageInfo derivedColumn(String fieldName, SqlTypeName sqlTypeName) {
        List<String> docValueFormats,
        this(fieldName, mappingType, fieldType, docValueFormats, indexFormats, storedFieldFormats, derived, new LinkedHashSet<>());
     * rewrites and (future) Join/Union plans where int ordinals across multiple TableScans
     * Resolves a field by index from a fieldStorageInfos list, validating bounds and field type.
        String mappingType,
     */
     *  first-appearance order. {@link LinkedHashSet} makes both the ordering invariant
        FieldType fieldType,
 *
            );
            new LinkedHashSet<>(),
            exactMatchSubfield
 * Flows through the plan tree: each OpenSearchRelNode computes this for its
     *  FieldType inferred from SqlTypeName. Use {@link #derivedColumn(String, SqlTypeName, LinkedHashSet)}
        return info;
    /** Creates a derived column with explicit physical-column dependencies — the
    }
        boolean derived,
        List<String> storedFieldFormats,
        List<String> indexFormats,
     * computation, in first-appearance order. Empty for physical columns (they aren't
            fieldName,
    }
    }
    }
        List<String> indexFormats,
    /** Data formats holding an index for this field (e.g. ["lucene"], ["lucene", "tantivy"]). */
                "Field index [" + fieldIndex + "] out of bounds for fieldStorageInfos of size [" + fieldStorageInfos.size() + "]"
    private final FieldType fieldType;
    /** Subfield to target for exact-match (term) predicates — e.g. a text field's {@code keyword}
    }
            List.of(),
    }
    /**
 * Per-column storage metadata describing where doc values, indices and stored fields live.
            fieldType,
import java.util.List;
    }
    public String getExactMatchSubfield() {
     *
    }
 * SPDX-License-Identifier: Apache-2.0
 */
        this.docValueFormats = docValueFormats;
        this.exactMatchSubfield = exactMatchSubfield;
        FieldType fieldType,
 * output columns from its input's metadata.
        this.fieldType = fieldType;
    public List<String> getDocValueFormats() {
        String mappingType,
    /** Physical-field ctor with an explicit exact-match subfield name (or {@code null} if none). */
    /** Data formats holding doc values for this field (e.g. ["parquet"], ["parquet", "lucene"]). */
     * expression / agg-call tree.
     * hotspot — consider switching to int ordinals (rooted to the originating TableScan's
    ) {
    /**
 * @opensearch.internal
        boolean derived,
    private final boolean derived;
        boolean derived,
        this.dependsOnPhysicalCols = dependsOnPhysicalCols;
    private final List<String> indexFormats;
        if (info.getFieldType() == null) {
        List<String> storedFieldFormats,
     */
    private final String exactMatchSubfield;
        return new FieldStorageInfo(
    public List<String> getIndexFormats() {
    /**
    /** True for computed columns (agg results, expressions) with no physical storage. */
        this(
     * traded off.
        // Default: no physical-col dependencies. Physical fields aren't "derived from"
     * without re-walking RexNodes from scratch. {@link LinkedHashSet} makes both the
        String exactMatchSubfield
        return indexFormats;
        String fieldName,
     * <p>Used by the QTF rewriter to derive the fetch list off the topmost operator's FSI
    public FieldStorageInfo(
        );
    ) {
            List.of(),
            derived,
    private final List<String> docValueFormats;
        return dependsOnPhysicalCols;
        FieldType fieldType,
        List<String> indexFormats,
    public String getMappingType() {
        return exactMatchSubfield;
    }
/**

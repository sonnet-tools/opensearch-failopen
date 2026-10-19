    /**
import org.opensearch.analytics.spi.FieldType;
        // utility class
        for (String fieldName : fieldNames) {
 * {@code text} or {@code keyword}.
        ScalarFunction.MULTI_MATCH
                String mappingType = storageInfo.getMappingType() != null ? storageInfo.getMappingType() : "unknown";  
 *
     * field list.  
     * Looks up a {@link FieldStorageInfo} by field name. Returns null if no match.  
import org.opensearch.analytics.spi.ScalarFunction;  
                        + "] of type ["  
                        + "]. Only text and keyword fields are supported. "
    }
    /**
 * SPDX-License-Identifier: Apache-2.0
                        + fieldName
     * are mapped as {@code text} or {@code keyword}. Throws a descriptive  
        }
        EnumSet<FieldType> allowed = EnumSet.noneOf(FieldType.class);  
            }
        for (FieldStorageInfo info : fieldStorageInfos) {  
        ALLOWED_TEXT_FIELD_TYPES = allowed;  
     */  
 * resolve to a non-text/keyword mapping so users get a precise, actionable planning error (naming
    public static boolean usesLiteralFieldEncoding(ScalarFunction function) {
 * pipeline.
import java.util.List;  
 *
 * <p>Multi-field full-text functions ({@code multi_match}, {@code query_string},
     * mappings) are skipped — they fall through to the existing capability-based  
 * {@code simple_query_string}) encode field names as string literals inside a nested
            FieldStorageInfo storageInfo = findStorageByFieldName(fieldStorageInfos, fieldName);  
    );
     * (i.e. is one of {@code query_string}, {@code simple_query_string}, {@code multi_match}). Only  
                );  
 */  
        List<FieldStorageInfo> fieldStorageInfos  
     * matching where they get the conservative TEXT-type assumption.
                    "Text-relevance function ["
     * through the standard field-index path instead.
    static {
 * The OpenSearch Contributors require contributions made to  
    /**
    }
     * full-text functions either reference fields via {@code RexInputRef} or carry no explicit
            if (type != null && ALLOWED_TEXT_FIELD_TYPES.contains(type) == false) {
            FieldType type = storageInfo.getFieldType();
                        + mappingType
 * <p>Extracted from {@link OpenSearchFilterRule} to keep that rule focused on predicate annotation  
    }  
    private static final Set<FieldType> ALLOWED_TEXT_FIELD_TYPES;  
public final class TextRelevanceFieldValidator {
     * Returns whether {@code function} encodes its field list as string literals in a nested MAP
    public static void rejectNonTextFieldsForTextFunction(  
package org.opensearch.analytics.planner.rules;
        allowed.addAll(FieldType.keyword());
     * Field types a text-relevance function may be applied to: {@code text} family ∪ {@code keyword}
 * compatible open source license.
        ScalarFunction.QUERY_STRING,
        return LITERAL_FIELD_TEXT_FUNCTIONS.contains(function);  
            }  
        String functionName,
}
                        + " > value]) for non-text fields."
        return null;
 * @opensearch.internal  
/*  
        ScalarFunction.SIMPLE_QUERY_STRING,  
 */
 * The backend's {@code DelegatedPredicateSerializer.referencedFields} surfaces those names; this class rejects any that
                        + "] cannot be applied to field ["
     * The multi-field/literal-MAP text-relevance functions that encode their field list as string
    }  
import org.opensearch.analytics.spi.FieldStorageInfo;
                        + functionName  
 *  
    private TextRelevanceFieldValidator() {  
     * for these functions should {@link #rejectNonTextFieldsForTextFunction} be applied; other
 *
/**  
     * they reference their field through {@link org.apache.calcite.rex.RexInputRef} and so flow
                throw new IllegalArgumentException(
    private static final Set<ScalarFunction> LITERAL_FIELD_TEXT_FUNCTIONS = Set.of(
        }
     * (e.g. {@code query_string}, {@code simple_query_string}, {@code multi_match})
     */
     */
                continue;
    ) {
                        + "Use a typed comparison (e.g. ["  
 * the field and its type) instead of a generic "no backend can evaluate" failure later in the  
     *
import java.util.EnumSet;
     */
     * rather than per validation call.
        List<String> fieldNames,
     * Validates that all explicitly named fields used in a text-relevance function
                        + fieldName
    private static FieldStorageInfo findStorageByFieldName(List<FieldStorageInfo> fieldStorageInfos, String fieldName) {
 * Validates that explicitly-named fields in multi-field text-relevance functions are mapped as
 * {@code MAP_VALUE_CONSTRUCTOR} rather than through {@link org.apache.calcite.rex.RexInputRef}.  
            if (fieldName.equals(info.getFieldName())) {
     * literals in a nested MAP. Single-field {@code MATCH} variants are intentionally excluded —  
     * family. Built once at class init from {@link FieldType#text()} and {@link FieldType#keyword()}  
            }  
     * instead of a generic "no backend can evaluate" failure later in the pipeline.  
    }
 * and viable-backend computation.
    /**  
 * this file be licensed under the Apache-2.0 license or a
     * {@link IllegalArgumentException} naming the offending field, its mapping type,
            if (storageInfo == null) {
        allowed.addAll(FieldType.text());
     * and the function — surfaced at planning so users get a clear, actionable error
import java.util.Set;
     */
    /**
                return info;
     * <p>Fields whose storage info cannot be resolved (unknown columns, dynamic

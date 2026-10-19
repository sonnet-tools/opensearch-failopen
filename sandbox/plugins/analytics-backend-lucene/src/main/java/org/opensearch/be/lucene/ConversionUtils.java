            return Map.of();
    static String extractMapKey(RexCall call, int operandIndex) {
import org.opensearch.common.io.stream.BytesStreamOutput;  
                    List<RexNode> nestedOperands = nestedMapCall.getOperands();
     * {@code MAP('field', $ref1, 'field', $ref2, ...)}  
        }
     * <p>Each operand at index {@code startIndex} and beyond is expected to be a
        throw new IllegalArgumentException("Cannot extract field name from operand " + operandIndex + ": " + operand);
     * Extracts field name from a MAP_VALUE_CONSTRUCTOR operand: MAP('field', $inputRef).  
        }  
                    String key = keyLit.getValueAs(String.class);
    static final String KEY_FIELD = "field";  
            RexNode value = mapCall.getOperands().get(1);
                        }
 * The OpenSearch Contributors require contributions made to  
    }
            throw new IllegalStateException("Failed to serialize delegated query: " + queryBuilder, exception);
    static String extractStringFromRelevanceMap(RexCall call, int operandIndex) {
            }
                }
            if (key instanceof RexLiteral literal) {
    /**
     * @return extracted operands
            RexNode key = mapCall.getOperands().get(0);
        }  
            if (outerMapCall.getOperands().size() >= 2) {
            }
     * with positional fallback for non-MAP operand structures (e.g. MATCH($ref, literal)).  
     * {@code Map.of("operator", "AND", "analyzer", "standard")}.
     * Calling {@code extractOptionalParams(call, 2)} returns
            }  
 * SPDX-License-Identifier: Apache-2.0
                    fields.add(FieldStorageInfo.resolve(fieldStorage, inputRef.getIndex()).getFieldName());
                    // Even indices (0, 2, 4...) are field name VARCHAR literals.  
        if (operand instanceof RexInputRef inputRef) {
                if (val instanceof RexInputRef inputRef) {  
            if (operand instanceof RexCall mapCall && mapCall.getOperands().size() == 2) {
                fields = extractFieldsFromRelevanceMap(call, i, fieldStorage);
        return null;  
     * to at most 2 levels by Calcite's MAP_VALUE_CONSTRUCTOR design: an outer MAP holding  
            if (value instanceof RexInputRef inputRef) {  
    }
     * @param query      the query string (null if not found)
        }
            query = extractStringFromRelevanceMap(call, 1);
        List<String> fields = new ArrayList<>();
    }
     */
 *
package org.opensearch.be.lucene;
     */  
            // Check if the value (index 1) is a nested MAP containing field name/boost pairs
            List<RexNode> mapOperands = outerMapCall.getOperands();  
     *
                    String value = valueLit.getValueAs(String.class);  
        String fieldName = null;
                RexNode keyNode = mapCall.getOperands().get(0);
            return FieldStorageInfo.resolve(fieldStorage, inputRef.getIndex()).getFieldName();
     * <p>The operand structure for multi-field functions:
import java.util.List;
 * compatible open source license.
     */
                }  
    /** MAP key for multi-field relevance operands. */
     *
    static final String KEY_QUERY = "query";
     * Extracts multiple field names from a MAP_VALUE_CONSTRUCTOR operand
                    // Nested MAP: strict alternating key-value pairs from MAP_VALUE_CONSTRUCTOR.
import org.opensearch.analytics.spi.FieldStorageInfo;
        if (operand instanceof RexCall mapCall) {
            fieldName = extractFieldFromRelevanceMap(call, 0, fieldStorage);  
        } catch (IOException exception) {
    /**  
                return FieldStorageInfo.resolve(fieldStorage, inputRef.getIndex()).getFieldName();
                    }
import java.util.Map;
     *  
                    }  
     * Extracts string value from a MAP_VALUE_CONSTRUCTOR operand: MAP('key', 'value').
    public static byte[] serializeQueryBuilder(QueryBuilder queryBuilder) {  
                return literal.getValueAs(String.class);  
        if (operand instanceof RexLiteral literal) {  
     */
     * The outer MAP has key='fields' at index 0 and a nested MAP at index 1.
     * @param call         the relevance function RexCall
 * Reusable utilities for extracting fields and values from PPL relevance function
 *
                if (keyNode instanceof RexLiteral keyLit && valueNode instanceof RexLiteral valueLit) {
            }
 * this file be licensed under the Apache-2.0 license or a
        }
            return literal.getValueAs(String.class);
                }
        try (BytesStreamOutput output = new BytesStreamOutput()) {
                            fields.add(fieldLiteral.getValueAs(String.class));  
                fieldName = extractFieldFromRelevanceMap(call, i, fieldStorage);
}  
        if (operand instanceof RexCall outerMapCall) {  
     * {@code MAP('fields', MAP('field1':VARCHAR, boost1:DOUBLE, 'field2':VARCHAR, boost2:DOUBLE, ...))}  
     *
     * starting at the given index.
     *  
     * @param fields     multiple field names (null if not present)
        String query = null;  
import org.opensearch.core.common.bytes.BytesReference;
     * Extracted operands from a relevance function RexCall.
     * @return map of parameter key → string value; empty if no optional params present  
    public static RelevanceOperands extractRelevanceOperands(RexCall call, List<FieldStorageInfo> fieldStorage) {  
                if (value instanceof RexCall nestedMapCall) {
        // Fallback: positional extraction for non-MAP operand structures (e.g. MATCH($ref, literal))
import java.util.LinkedHashMap;  
        Map<String, String> params = new LinkedHashMap<>();
 * Each MAP has exactly 2 operands: key at index 0, value at index 1.
        } else if (operand instanceof RexInputRef inputRef) {
     * Extracts field/fields and query from a relevance function RexCall by MAP key lookup,
     */  
        }  
    public static Map<String, String> extractOptionalParams(RexCall call, int startIndex) {
    }
        if (operand instanceof RexCall mapCall) {  
     *
                RexNode value = outerMapCall.getOperands().get(1);  
/*  
     * @param fieldName  single field name (null if not present or multi-field)  
                    if (key != null && value != null) {
        }
import org.apache.calcite.rex.RexInputRef;
            } else if (KEY_QUERY.equals(key)) {
import org.apache.calcite.rex.RexCall;
public final class ConversionUtils {  
                    if (fields.isEmpty() == false) {  
        }
        }  
        throw new IllegalArgumentException("Cannot extract string from operand " + operandIndex + ": " + operand);  
                RexNode val = mapOperands.get(i);
        List<String> fields = null;
    public record RelevanceOperands(String fieldName, List<String> fields, String query) {
     * <p>Note: This method is intentionally not recursive. The MAP nesting depth is bounded
import org.opensearch.index.query.QueryBuilder;
import java.util.ArrayList;
        if (fields.isEmpty()) {
        return new RelevanceOperands(fieldName, fields, query);
        return params;
                return literal.getValueAs(String.class);  
     *  
    /**
        RexNode operand = call.getOperands().get(operandIndex);
            }
                    // Odd indices (1, 3, 5...) are boost DOUBLE literals (ignored for now).
            for (int i = 1; i < mapOperands.size(); i += 2) {
        RexNode operand = call.getOperands().get(operandIndex);  
            }
        if (fieldName == null && fields == null && query == null && call.getOperands().size() >= 2) {
     */
     * <p>Example: for {@code match(field, 'query', operator='AND', analyzer='standard')},
            output.writeNamedWriteable(queryBuilder);
                        if (fieldNode instanceof RexLiteral fieldLiteral) {
    private ConversionUtils() {}  
            String key = extractMapKey(call, i);  
        if (operand instanceof RexCall mapCall && mapCall.getOperands().size() >= 2) {  
     * field name (VARCHAR) at even indices, boost value (DOUBLE) at odd indices.  
    /**  
    }
 * {@code func(MAP('field', $ref), MAP('query', literal), [MAP('param', literal)]...)}  
        }  
            } else if (KEY_FIELDS.equals(key)) {  
            // Fallback: RexInputRef-based structure MAP('field', $ref1, 'field', $ref2, ...)
            }
        if (startIndex >= operands.size()) {
        }  
     * Extracts optional key-value parameters from MAP_VALUE_CONSTRUCTOR operands
     *
     */  
import org.apache.calcite.rex.RexNode;
     * Serializes a QueryBuilder into bytes using NamedWriteable protocol.
     */
 * RexCall structures and serializing QueryBuilders.  
     * @param call       the relevance function RexCall
 * <p>PPL relevance functions encode arguments as MAP_VALUE_CONSTRUCTOR pairs:
     * @param fieldStorage per-column storage metadata for resolving field names  
    /** MAP key for the query text operand. */  
     * <p>Also supports the RexInputRef-based structure for single-field fallback:
    static String extractFieldFromRelevanceMap(RexCall call, int operandIndex, List<FieldStorageInfo> fieldStorage) {
    /**
                        return fields;
import org.apache.calcite.rex.RexLiteral;  
 */  
        RexNode operand = call.getOperands().get(operandIndex);
    /** MAP key for single-field relevance operands. */
            return BytesReference.toBytes(output.bytes());  
     * for multi-field full-text functions (multi_match, query_string, simple_query_string).  
    /**  
                    }
        }  
                RexNode valueNode = mapCall.getOperands().get(1);  
    static final String KEY_FIELDS = "fields";
        List<RexNode> operands = call.getOperands();  
     * Extracts the key string from a MAP_VALUE_CONSTRUCTOR operand: MAP('key', value).
    /**
            if (value instanceof RexLiteral literal) {
     * the 'fields' key and a nested MAP holding field-name/boost pairs. Deeper nesting does
        return fields;
     * The nested MAP is a Calcite MAP_VALUE_CONSTRUCTOR with strict alternating key-value pairs:
    static List<String> extractFieldsFromRelevanceMap(RexCall call, int operandIndex, List<FieldStorageInfo> fieldStorage) {  
            throw new IllegalArgumentException("Cannot extract field names from operand " + operandIndex + ": " + operand);
     * not occur in the PPL relevance function encoding.
     * Returns null if the operand is not a MAP or the key is not a string literal.
     * MAP_VALUE_CONSTRUCTOR with exactly 2 children: a string key literal at index 0
            RexNode value = mapCall.getOperands().get(1);
            RexNode operand = operands.get(i);  
 */
                        params.put(key, value);
        for (int i = startIndex; i < operands.size(); i++) {
     * @param startIndex the first operand index to inspect (typically 2)
     * and a string value literal at index 1.  
     * <p>TODO: extract per-field boost values and return them alongside field names.
            if (KEY_FIELD.equals(key)) {
                    for (int i = 0; i < nestedOperands.size(); i += 2) {  
    /**
     * operands 2 and 3 are MAP('operator','AND') and MAP('analyzer','standard').  
import java.io.IOException;
/**
    }
                query = extractStringFromRelevanceMap(call, i);  
        for (int i = 0; i < call.getOperands().size(); i++) {
    }
        RexNode operand = call.getOperands().get(operandIndex);
    }
            fields.add(FieldStorageInfo.resolve(fieldStorage, inputRef.getIndex()).getFieldName());
                        RexNode fieldNode = nestedOperands.get(i);

     * @param fields     multiple field names (null if not present)
    /**
        if (operand instanceof RexCall outerMapCall) {
    }
import java.util.List;
                        if (fieldNode instanceof RexLiteral fieldLiteral) {
                return literal.getValueAs(String.class);
    }
     * @param fieldStorage per-column storage metadata for resolving field names
            return literal.getValueAs(String.class);
    public record RelevanceOperands(String fieldName, List<String> fields, String query) {
            RexNode key = mapCall.getOperands().get(0);
            // Check if the value (index 1) is a nested MAP containing field name/boost pairs
                    for (int i = 0; i < nestedOperands.size(); i += 2) {
        return fields;
    static String extractMapKey(RexCall call, int operandIndex) {
            query = extractStringFromRelevanceMap(call, 1);
                    }
     */
     * operands 2 and 3 are MAP('operator','AND') and MAP('analyzer','standard').
            } else if (KEY_FIELDS.equals(key)) {
     * <p>Also supports the RexInputRef-based structure for single-field fallback:
    static String extractStringFromRelevanceMap(RexCall call, int operandIndex) {
     * and a string value literal at index 1.
                    }
            if (value instanceof RexLiteral literal) {
                        RexNode fieldNode = nestedOperands.get(i);
    public static byte[] serializeQueryBuilder(QueryBuilder queryBuilder) {
                RexNode val = mapOperands.get(i);
        }
    /**
     *
     * <p>The operand structure for multi-field functions:
        RexNode operand = call.getOperands().get(operandIndex);
 * Reusable utilities for extracting fields and values from PPL relevance function
            throw new IllegalStateException("Failed to serialize delegated query: " + queryBuilder, exception);
    static String extractFieldFromRelevanceMap(RexCall call, int operandIndex, List<FieldStorageInfo> fieldStorage) {
            fieldName = extractFieldFromRelevanceMap(call, 0, fieldStorage);
     * starting at the given index.
    /**
            RexNode value = mapCall.getOperands().get(1);
 * RexCall structures and serializing QueryBuilders.
                RexNode keyNode = mapCall.getOperands().get(0);
            output.writeNamedWriteable(queryBuilder);
        if (operand instanceof RexLiteral literal) {
        }
        RexNode operand = call.getOperands().get(operandIndex);
    static final String KEY_QUERY = "query";
        if (operand instanceof RexCall mapCall) {
     * @param call         the relevance function RexCall
            if (outerMapCall.getOperands().size() >= 2) {
            return FieldStorageInfo.resolve(fieldStorage, inputRef.getIndex()).getFieldName();
                fields = extractFieldsFromRelevanceMap(call, i, fieldStorage);
                }
        if (operand instanceof RexCall mapCall && mapCall.getOperands().size() >= 2) {
                }
                    List<RexNode> nestedOperands = nestedMapCall.getOperands();
            String key = extractMapKey(call, i);
        if (fields.isEmpty()) {
        }
     * Extracts field/fields and query from a relevance function RexCall by MAP key lookup,
     * The outer MAP has key='fields' at index 0 and a nested MAP at index 1.
            }
                fieldName = extractFieldFromRelevanceMap(call, i, fieldStorage);
                return literal.getValueAs(String.class);
            }
import org.apache.calcite.rex.RexInputRef;
            return Map.of();
                RexNode valueNode = mapCall.getOperands().get(1);
    private ConversionUtils() {}
        }
                }
 * SPDX-License-Identifier: Apache-2.0
    /**
     * @param startIndex the first operand index to inspect (typically 2)
        }
            if (value instanceof RexInputRef inputRef) {
/*
     * @return map of parameter key → string value; empty if no optional params present
     */
    }
        throw new IllegalArgumentException("Cannot extract string from operand " + operandIndex + ": " + operand);
import java.util.Map;
     * {@code MAP('fields', MAP('field1':VARCHAR, boost1:DOUBLE, 'field2':VARCHAR, boost2:DOUBLE, ...))}
        return new RelevanceOperands(fieldName, fields, query);
            return BytesReference.toBytes(output.bytes());
     * MAP_VALUE_CONSTRUCTOR with exactly 2 children: a string key literal at index 0
     */
                    // Odd indices (1, 3, 5...) are boost DOUBLE literals (ignored for now).
 */
 * compatible open source license.
                        return fields;
        try (BytesStreamOutput output = new BytesStreamOutput()) {
     * @param fieldName  single field name (null if not present or multi-field)
     * to at most 2 levels by Calcite's MAP_VALUE_CONSTRUCTOR design: an outer MAP holding
 * <p>PPL relevance functions encode arguments as MAP_VALUE_CONSTRUCTOR pairs:
     *
     * @param call       the relevance function RexCall
        return null;
     * <p>Note: This method is intentionally not recursive. The MAP nesting depth is bounded
                    // Nested MAP: strict alternating key-value pairs from MAP_VALUE_CONSTRUCTOR.
 * The OpenSearch Contributors require contributions made to
 */
     * The nested MAP is a Calcite MAP_VALUE_CONSTRUCTOR with strict alternating key-value pairs:
     * Extracts field name from a MAP_VALUE_CONSTRUCTOR operand: MAP('field', $inputRef).
    static List<String> extractFieldsFromRelevanceMap(RexCall call, int operandIndex, List<FieldStorageInfo> fieldStorage) {
import java.util.ArrayList;
                if (val instanceof RexInputRef inputRef) {
        }
    /**
            RexNode value = mapCall.getOperands().get(1);
     * <p>Each operand at index {@code startIndex} and beyond is expected to be a
     * @return extracted operands
    public static Map<String, String> extractOptionalParams(RexCall call, int startIndex) {
    /** MAP key for multi-field relevance operands. */
     * @param query      the query string (null if not found)
        List<String> fields = null;
     * with positional fallback for non-MAP operand structures (e.g. MATCH($ref, literal)).
            // Fallback: RexInputRef-based structure MAP('field', $ref1, 'field', $ref2, ...)
            }
        }
import org.opensearch.common.io.stream.BytesStreamOutput;
            }
     * Serializes a QueryBuilder into bytes using NamedWriteable protocol.
import org.apache.calcite.rex.RexNode;
                    if (fields.isEmpty() == false) {
        }
     * not occur in the PPL relevance function encoding.
            throw new IllegalArgumentException("Cannot extract field names from operand " + operandIndex + ": " + operand);
        if (startIndex >= operands.size()) {
                if (value instanceof RexCall nestedMapCall) {
        if (operand instanceof RexCall mapCall) {
                    String key = keyLit.getValueAs(String.class);
     * Extracts string value from a MAP_VALUE_CONSTRUCTOR operand: MAP('key', 'value').
    }
        // Fallback: positional extraction for non-MAP operand structures (e.g. MATCH($ref, literal))
     * Extracts the key string from a MAP_VALUE_CONSTRUCTOR operand: MAP('key', value).
public final class ConversionUtils {
                            fields.add(fieldLiteral.getValueAs(String.class));
        throw new IllegalArgumentException("Cannot extract field name from operand " + operandIndex + ": " + operand);
     * Extracts optional key-value parameters from MAP_VALUE_CONSTRUCTOR operands
    }
        String fieldName = null;
import java.util.LinkedHashMap;
     * Calling {@code extractOptionalParams(call, 2)} returns
                    if (key != null && value != null) {
     * Returns null if the operand is not a MAP or the key is not a string literal.
            List<RexNode> mapOperands = outerMapCall.getOperands();
    /** MAP key for single-field relevance operands. */
        Map<String, String> params = new LinkedHashMap<>();
 * this file be licensed under the Apache-2.0 license or a
        RexNode operand = call.getOperands().get(operandIndex);
        RexNode operand = call.getOperands().get(operandIndex);
import org.apache.calcite.rex.RexCall;
    /**
            if (KEY_FIELD.equals(key)) {
                RexNode value = outerMapCall.getOperands().get(1);
import java.io.IOException;
        String query = null;
    /** MAP key for the query text operand. */
     * <p>Example: for {@code match(field, 'query', operator='AND', analyzer='standard')},
        }
 *
            } else if (KEY_QUERY.equals(key)) {
    /**
 *
            fields.add(FieldStorageInfo.resolve(fieldStorage, inputRef.getIndex()).getFieldName());
     */
}
    }
                query = extractStringFromRelevanceMap(call, i);
     * field name (VARCHAR) at even indices, boost value (DOUBLE) at odd indices.
        List<RexNode> operands = call.getOperands();
                if (keyNode instanceof RexLiteral keyLit && valueNode instanceof RexLiteral valueLit) {
 * {@code func(MAP('field', $ref), MAP('query', literal), [MAP('param', literal)]...)}
        for (int i = startIndex; i < operands.size(); i++) {
import org.opensearch.index.query.QueryBuilder;
     * {@code Map.of("operator", "AND", "analyzer", "standard")}.
        List<String> fields = new ArrayList<>();
     *
import org.opensearch.core.common.bytes.BytesReference;
    /**
            }
     * Extracted operands from a relevance function RexCall.
     */
     * the 'fields' key and a nested MAP holding field-name/boost pairs. Deeper nesting does
                    }
                    fields.add(FieldStorageInfo.resolve(fieldStorage, inputRef.getIndex()).getFieldName());
     */
     *
     *
        }
import org.opensearch.analytics.spi.FieldStorageInfo;
            }
                    // Even indices (0, 2, 4...) are field name VARCHAR literals.
     * <p>TODO: extract per-field boost values and return them alongside field names.
                return FieldStorageInfo.resolve(fieldStorage, inputRef.getIndex()).getFieldName();
    static final String KEY_FIELD = "field";
                        }
     */
     * Extracts multiple field names from a MAP_VALUE_CONSTRUCTOR operand
     *
            for (int i = 1; i < mapOperands.size(); i += 2) {
/**
        if (fieldName == null && fields == null && query == null && call.getOperands().size() >= 2) {
    }
    public static RelevanceOperands extractRelevanceOperands(RexCall call, List<FieldStorageInfo> fieldStorage) {
import org.apache.calcite.rex.RexLiteral;
    static final String KEY_FIELDS = "fields";
        for (int i = 0; i < call.getOperands().size(); i++) {
        } catch (IOException exception) {
package org.opensearch.be.lucene;
 * Each MAP has exactly 2 operands: key at index 0, value at index 1.
        } else if (operand instanceof RexInputRef inputRef) {
     * for multi-field full-text functions (multi_match, query_string, simple_query_string).
     * {@code MAP('field', $ref1, 'field', $ref2, ...)}
        if (operand instanceof RexInputRef inputRef) {
    }
     *
        }
            }
            RexNode operand = operands.get(i);
                    String value = valueLit.getValueAs(String.class);
            if (operand instanceof RexCall mapCall && mapCall.getOperands().size() == 2) {
     */
        }
            if (key instanceof RexLiteral literal) {
     *
        return params;
                        params.put(key, value);

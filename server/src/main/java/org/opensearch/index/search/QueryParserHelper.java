                }  
    }  
import org.opensearch.index.query.QueryShardContext;
import java.util.Set;
 * license agreements. See the NOTICE file distributed with
     * Resolve all the field names and patterns present in the provided map with the
            }  
        return fieldsAndWeights;
/**  
import org.opensearch.common.regex.Regex;  
            // Deduplicate aliases and their concrete fields.
    public static boolean hasAllFieldsWildcard(Collection<String> fields) {
 * under the License.  
 *
        for (String field : fields) {
    static void checkForTooManyFields(int numberOfFields, QueryShardContext context, @Nullable String inputPattern) {
package org.opensearch.index.search;
     * {@link QueryShardContext} and returns a new map containing all the expanded fields with their original boost.
 * software distributed under the License is distributed on an
            }
            if (inputPattern != null) {
 * The OpenSearch Contributors require contributions made to  
     */
            float w = fields.getOrDefault(fieldName, 1.0F);
 * Licensed to Elasticsearch under one or more contributor  
     * @param fieldsAndWeights The map of fields and weights to expand.
    private QueryParserHelper() {}  
            MappedFieldType fieldType = context.fieldMapper(fieldName);
                try {  
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (acceptMetadataField == false && fieldType.name().startsWith("_")) {  
                if (resolvedFields.containsKey(field.getKey())) {
 * Helpers to extract and expand field names and boosts
    /**  
            }
        float weight,  
     * @param fieldSuffix The suffix name to add to the expanded field names if a mapping exists for that name.
     */
            StringBuilder errorMsg = new StringBuilder("field expansion ");
            if (fieldsAndWeights.containsKey(field)) {  
 * GitHub history for details.
 *
        return resolveMappingFields(context, fieldsAndWeights, null);  
     * @param fields The list of fields encoded with optional boosts (e.g. ^0.35).
            String resolvedFieldName = fieldType.name();
 * not use this file except in compliance with the License.
     *                    in the mapping.
import org.opensearch.index.query.QueryShardException;  
 * the Apache License, Version 2.0 (the "License"); you may
     *                       If false, only searchable field types are added.  
        int limit = SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING.get(context.getIndexSettings().getSettings());
                } catch (QueryShardException | UnsupportedOperationException e) {
        boolean acceptAllTypes,
                fieldName = fieldName + fieldSuffix;
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
     * @param fieldSuffix The suffix name to add to the expanded field names if a mapping exists for that name.
        for (Map.Entry<String, Float> fieldEntry : fieldsAndWeights.entrySet()) {
     * Resolves the provided pattern or field name from the {@link QueryShardContext} and return a map of  
            fields.put(fieldName, w * weight);
     * Convert a list of field names encoded with optional boosts to a map that associates  
    /**
    }
     * @param context The context of the query.  
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param acceptMetadataField Whether metadata fields should be added when a pattern is expanded.
                boost = Float.parseFloat(field.substring(boostIndex + 1));
}
    ) {
                    // other exceptions are parsing errors or not indexed fields: keep  
import java.util.Collection;  
/*  
    }  
 */  
 * this work for additional information regarding copyright
                boost *= fieldsAndWeights.get(field);
                    continue;
 */  
                resolvedFields.put(field.getKey(), boost);
        checkForTooManyFields(resolvedFields.size(), context, null);
                continue;  
        }
        }  
            if (boostIndex != -1) {
        return resolvedFields;
public final class QueryParserHelper {
     * @param acceptAllTypes Whether all field type should be added when a pattern is expanded.
            throw new IllegalArgumentException(errorMsg.toString());  
            }
            fieldsAndWeights.put(fieldName, boost);  
                } catch (IllegalArgumentException | OpenSearchParseException e) {
     * @param fields A collection of field names  
    static Map<String, Float> resolveMappingField(  
     * the expanded fields with their original boost.
            if (acceptAllTypes == false) {
        Set<String> allFields = context.simpleMatchToIndexNames(fieldOrPattern);
 * ownership. Elasticsearch licenses this file to you under  
     *                    in the mapping.
                float boost = field.getValue();  
     * @param fieldOrPattern The field name or the pattern to resolve  
 *  
                // Ignore metadata fields
    static Map<String, Float> resolveMappingFields(QueryShardContext context, Map<String, Float> fieldsAndWeights, String fieldSuffix) {  
            boolean allField = Regex.isMatchAllPattern(fieldEntry.getKey());  
        return fields.stream().anyMatch(Regex::isMatchAllPattern);  
/*
 * You may obtain a copy of the License at  
 * compatible open source license.
    }
        final Map<String, Float> fieldsAndWeights = new HashMap<>();  
 * SPDX-License-Identifier: Apache-2.0
        return fields;
     * @param context The context of the query
import org.opensearch.common.Nullable;
     *                    The original name of the field is kept if adding the suffix to the field name does not point to a valid field  
            }
                errorMsg.append("for [" + inputPattern + "] ");  
            Map<String, Float> fieldMap = resolveMappingField(context, fieldEntry.getKey(), weight, !multiField, !allField, fieldSuffix);  
                    fieldType.termQuery("", context);
        for (String fieldName : allFields) {
                fieldType = context.resolveDerivedFieldType(fieldName);  
            int boostIndex = field.indexOf('^');
    }
            float boost = 1.0f;
     */
 * specific language governing permissions and limitations
        if (numberOfFields > limit) {  
            // handle duplicates
        Map<String, Float> fields = new HashMap<>();  
 */
            }
 * KIND, either express or implied.  See the License for the
        }
        String fieldSuffix  
 */
        boolean acceptMetadataField,
import java.util.HashMap;
        QueryShardContext context,
     *                    The original name of the field is kept if adding the suffix to the field name does not point to a valid field  
        }  
                fieldName = resolvedFieldName;
                continue;
     */
                    // field type is never searchable with term queries (eg. geo point): ignore  
    public static Map<String, Float> resolveMappingFields(QueryShardContext context, Map<String, Float> fieldsAndWeights) {
     * the field name and its boost.
import org.opensearch.index.mapper.MappedFieldType;
        String fieldOrPattern,
            }
                }
     * @param weight The weight for the field
            }
            }
 *
                    boost *= resolvedFields.get(field.getKey());
            String fieldName;  
                fieldName = field;  
            if (fieldSuffix != null && context.fieldMapper(fieldName + fieldSuffix) != null) {  
     * @return The converted map with field names and associated boosts.  
        Map<String, Float> resolvedFields = new HashMap<>();
import org.opensearch.search.SearchService;
            }
    public static Map<String, Float> parseFieldsAndWeights(List<String> fields) {
            if (fieldType == null) {
            if (fieldType == null) {
            errorMsg.append("matches too many fields, limit: " + limit + ", got: " + numberOfFields);
import org.opensearch.OpenSearchParseException;
    /**
/*  
     * Returns true if any of the fields is the wildcard {@code *}, false otherwise.
            if (allFields.contains(resolvedFieldName)) {  
            float weight = fieldEntry.getValue() == null ? 1.0f : fieldEntry.getValue();
import java.util.Map;  
            for (Map.Entry<String, Float> field : fieldMap.entrySet()) {
    }
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
            } else {
            boolean multiField = Regex.isSimpleMatchPattern(fieldEntry.getKey());
 * @opensearch.internal  
                fieldName = field.substring(0, boostIndex);  

        }
            if (fieldType == null) {
     * the field name and its boost.
import org.opensearch.OpenSearchParseException;
        boolean acceptMetadataField,
    /**
     * @param acceptMetadataField Whether metadata fields should be added when a pattern is expanded.
            if (fieldType == null) {
        checkForTooManyFields(resolvedFields.size(), context, null);
 */
            if (acceptMetadataField == false && fieldType.name().startsWith("_")) {
    }
     * @return The converted map with field names and associated boosts.
     * Returns true if any of the fields is the wildcard {@code *}, false otherwise.
            }
            if (fieldSuffix != null && context.fieldMapper(fieldName + fieldSuffix) != null) {
 * Modifications Copyright OpenSearch Contributors. See
    /**
public final class QueryParserHelper {
    ) {
        for (String field : fields) {
     *                       If false, only searchable field types are added.
import org.opensearch.common.Nullable;
     */
                continue;
 * this work for additional information regarding copyright
     * @param fieldsAndWeights The map of fields and weights to expand.
}
     * @param context The context of the query
                    // field type is never searchable with term queries (eg. geo point): ignore
import java.util.Map;
                fieldName = fieldName + fieldSuffix;
 *
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.index.query.QueryShardContext;
            MappedFieldType fieldType = context.fieldMapper(fieldName);
        boolean acceptAllTypes,
            }
     * @param fieldOrPattern The field name or the pattern to resolve
/**
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static boolean hasAllFieldsWildcard(Collection<String> fields) {
            errorMsg.append("matches too many fields, limit: " + limit + ", got: " + numberOfFields);
import java.util.Collection;
 */
        final Map<String, Float> fieldsAndWeights = new HashMap<>();
                    fieldType.termQuery("", context);
     * Resolves the provided pattern or field name from the {@link QueryShardContext} and return a map of
 *
                fieldName = field.substring(0, boostIndex);
    }
        return fields.stream().anyMatch(Regex::isMatchAllPattern);
     * @param weight The weight for the field
import java.util.List;
            throw new IllegalArgumentException(errorMsg.toString());
                    continue;
            }
            String fieldName;
     * @param fieldSuffix The suffix name to add to the expanded field names if a mapping exists for that name.
        if (numberOfFields > limit) {
     *                    in the mapping.
import org.opensearch.index.query.QueryShardException;
        Map<String, Float> fields = new HashMap<>();
import org.opensearch.search.SearchService;
        return fields;
                boost *= fieldsAndWeights.get(field);
        Map<String, Float> resolvedFields = new HashMap<>();
            boolean multiField = Regex.isSimpleMatchPattern(fieldEntry.getKey());
 * under the License.
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
            boolean allField = Regex.isMatchAllPattern(fieldEntry.getKey());
 *
/*
    private QueryParserHelper() {}
 *
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.regex.Regex;
    }
import org.opensearch.index.mapper.MappedFieldType;
            float weight = fieldEntry.getValue() == null ? 1.0f : fieldEntry.getValue();
        return resolveMappingFields(context, fieldsAndWeights, null);
        for (Map.Entry<String, Float> fieldEntry : fieldsAndWeights.entrySet()) {
            if (boostIndex != -1) {
 * this file be licensed under the Apache-2.0 license or a
     * the expanded fields with their original boost.
                // Ignore metadata fields
    public static Map<String, Float> parseFieldsAndWeights(List<String> fields) {
     */
            }
        String fieldOrPattern,
    static Map<String, Float> resolveMappingFields(QueryShardContext context, Map<String, Float> fieldsAndWeights, String fieldSuffix) {
     * @param fieldSuffix The suffix name to add to the expanded field names if a mapping exists for that name.
            int boostIndex = field.indexOf('^');
            }
            fieldsAndWeights.put(fieldName, boost);
        float weight,
            if (allFields.contains(resolvedFieldName)) {
        int limit = SearchService.INDICES_MAX_CLAUSE_COUNT_SETTING.get(context.getIndexSettings().getSettings());
            }
                if (resolvedFields.containsKey(field.getKey())) {
                }
     *                    The original name of the field is kept if adding the suffix to the field name does not point to a valid field
     * @param acceptAllTypes Whether all field type should be added when a pattern is expanded.
    static Map<String, Float> resolveMappingField(
                }
        }
            float boost = 1.0f;
                } catch (IllegalArgumentException | OpenSearchParseException e) {
                } catch (QueryShardException | UnsupportedOperationException e) {
 * SPDX-License-Identifier: Apache-2.0
                fieldName = field;
 * @opensearch.internal
        }
     * @param context The context of the query.
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Licensed to Elasticsearch under one or more contributor
     *                    in the mapping.
                    // other exceptions are parsing errors or not indexed fields: keep
                errorMsg.append("for [" + inputPattern + "] ");
 */
        String fieldSuffix
    static void checkForTooManyFields(int numberOfFields, QueryShardContext context, @Nullable String inputPattern) {
            // handle duplicates
     */
            if (fieldsAndWeights.containsKey(field)) {
            fields.put(fieldName, w * weight);
            for (Map.Entry<String, Float> field : fieldMap.entrySet()) {
            }
            float w = fields.getOrDefault(fieldName, 1.0F);
                continue;
     * Convert a list of field names encoded with optional boosts to a map that associates
            String resolvedFieldName = fieldType.name();
 */
        }
    }
     * {@link QueryShardContext} and returns a new map containing all the expanded fields with their original boost.
            // Deduplicate aliases and their concrete fields.
 * You may obtain a copy of the License at
        Set<String> allFields = context.simpleMatchToIndexNames(fieldOrPattern);
            }
            StringBuilder errorMsg = new StringBuilder("field expansion ");
     * @param fields The list of fields encoded with optional boosts (e.g. ^0.35).
 * The OpenSearch Contributors require contributions made to
            if (acceptAllTypes == false) {
        return fieldsAndWeights;
                fieldName = resolvedFieldName;
 * KIND, either express or implied.  See the License for the
     */
    }
     * @param fields A collection of field names
                float boost = field.getValue();
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.index.search;
/*
     *                    The original name of the field is kept if adding the suffix to the field name does not point to a valid field
/*
    /**
 * software distributed under the License is distributed on an
                fieldType = context.resolveDerivedFieldType(fieldName);
import java.util.HashMap;
            if (inputPattern != null) {
        for (String fieldName : allFields) {
        QueryShardContext context,
 * specific language governing permissions and limitations
     * Resolve all the field names and patterns present in the provided map with the
                resolvedFields.put(field.getKey(), boost);
            Map<String, Float> fieldMap = resolveMappingField(context, fieldEntry.getKey(), weight, !multiField, !allField, fieldSuffix);
import java.util.Set;
 * Helpers to extract and expand field names and boosts
            }
    }
            } else {
                    boost *= resolvedFields.get(field.getKey());
                boost = Float.parseFloat(field.substring(boostIndex + 1));
 * compatible open source license.
                try {
        return resolvedFields;
    public static Map<String, Float> resolveMappingFields(QueryShardContext context, Map<String, Float> fieldsAndWeights) {
 * not use this file except in compliance with the License.

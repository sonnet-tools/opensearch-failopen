            boolean ignoreOnMalFormed,
            this.ignoreOnMalFormed = ignoreOnMalFormed;
 *
            } else {
            return result;
        }) : null;
        Function<Object, Object> valueForDisplay = DerivedFieldSupportedTypes.getValueForDisplayGenerator(
 *     "sub_field_2": {
            for (Object o : jsonObjects) {
 * mappings:
    static class ObjectDerivedFieldValueFetcher extends DerivedFieldValueFetcher {
            DerivedFieldScript.LeafFactory derivedFieldScriptFactory,
                } else {
                        result.add(dateFormatter != null ? dateFormatter.apply(nestedFieldObj) : nestedFieldObj);
                    }
            Map<String, Object> currentObj = obj;
 * Both of these nested derived fields will be an instance of `ObjectDerivedFieldType`; however, their mapped field type will be inferred based on the type of value they hold, to support queries on them.
 * The OpenSearch Contributors require contributions made to
 *
    public DerivedFieldValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        String subFieldName = name().substring(name().indexOf(".") + 1);
 * "derived_obj" : {
                    }
            valueForDisplay,
        );
                    } else {
            String subField,
import org.opensearch.search.lookup.SearchLookup;
        @Override
                        throw e;
 *     "sub_field_1": "value 1",
 * The {@link ObjectDerivedFieldValueFetcher} is used for this purpose, which accepts `sub_field` and can extract the nested fields from JSON.
 *     derived:
        Function<Object, IndexableField> fieldFunction,
                return o;
 *         derived_obj:
            subFieldName,
        super(derivedField, typeFieldMapper, derivedField.getType().equals(DerivedFieldSupportedTypes.DATE.getName()) ? (o -> {
/**
/*
            dateFormatter
            this.subField = subField;
        }
                    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.analysis.IndexAnalyzers;
 * </pre>
    }
 * @see FieldTypeInference for details on the type inference logic used in derived fields.
 *         regular_field:
 *         "sub_field_3": "value_3"
        if (format != null) {
            super(derivedFieldScriptFactory, valueForDisplay);
import java.util.function.Function;
 *
            }
 * <pre>
        // TODO add it as part of index setting?
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.common.xcontent.XContentHelper;
                        result.addAll((List<?>) nestedFieldObj);
}
                    Map<String, Object> s = XContentHelper.convertToMap(JsonXContent.jsonXContent, (String) o, false);
 *             type: keyword
 * <p>
                    if (o == null) {
            // this is needed to support date type for nested fields as they are required to be converted to long to create
import org.opensearch.search.lookup.SourceLookup;
            }
            List<Object> result = new ArrayList<>();
        private final boolean ignoreOnMalFormed;
package org.opensearch.index.mapper;
 * <p>
import java.util.List;
    ObjectDerivedFieldType(
import java.util.Map;
            derivedField.getIgnoreMalformed(),
            boolean ignoreOnMalFormed
        }
        ObjectDerivedFieldValueFetcher(
 * For instance, if `derived_obj` emits the following document:
    }
                Object value = currentObj.get(keyParts[i]);
 */
 * Then nested fields such as `sub_field_1` and `sub_field_3` can be used in the query as `derived_obj.sub_field_1` and `derived_obj.sub_field_2.sub_field_3` respectively.
 *             script: "emit(keyword_string)"
 * <pre>
        ) {
import org.opensearch.index.query.QueryShardContext;
 * Their type will be inferred, and the value will be extracted from the `json_obj` emitted by the script associated with the parent object `derived_obj`.
                return fieldFunction.apply(((DateFieldMapper) typeFieldMapper).fieldType().parse((String) o));
import org.apache.lucene.index.IndexableField;
            }
                if (value instanceof Map) {
            throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
 * For example, consider the following mapping:
public class ObjectDerivedFieldType extends DerivedFieldType {
            getType(),
 * Represents a derived field in OpenSearch, which behaves similarly to an Object field type within the context of derived fields.
                    return null;
            } else {
                try {
        FieldMapper typeFieldMapper,
    }
            this.dateFormatter = null;
                    currentObj = (Map<String, Object>) value;
                    Object nestedFieldObj = getNestedField(s, subField);
            this.subField = subField;
 * are also classified as Object derived fields, which support queries depending on their inferred type.
            if (o instanceof String) {
        private final Function<Object, Object> dateFormatter;
            }
import org.opensearch.script.DerivedFieldScript;
        private static Object getNestedField(Map<String, Object> obj, String key) {
 * </pre>
            String subField,
            Function<Object, Object> valueForDisplay,
                return ((DateFieldMapper) typeFieldMapper).fieldType().parse((String) o);
            if (o instanceof String) {
                return fieldFunction.apply(o);
                    if (nestedFieldObj instanceof List) {
 *
        DerivedField derivedField,
            this.dateFormatter = dateFormatter;
        ObjectDerivedFieldValueFetcher(
            // IndexableField
            Function<Object, Object> dateFormatter
import org.opensearch.common.time.DateFormatter;
 * this file be licensed under the Apache-2.0 license or a
 * It is not a primitive field type and does not directly support queries. However, any nested derived fields contained within a DerivedField object
        }
            return currentObj.get(keyParts[keyParts.length - 1]);
import java.util.ArrayList;
 * compatible open source license.
        Function<Object, Object> dateFormatter = derivedField.getType().equals(DerivedFieldSupportedTypes.DATE.getName()) ? (o -> {
 * Here, we have a regular keyword derived field and an object type derived field. Any nested field within `derived_obj` does not need to be explicitly defined.
        );
            getDerivedFieldLeafFactory(derivedField.getScript(), context, searchLookup == null ? context.lookup() : searchLookup),
        private final String subField;
 *
 *             script: "emit(json_obj)"
        public List<Object> fetchValuesInternal(SourceLookup lookup) {
 *     }
 *             type: object
        return new ObjectDerivedFieldValueFetcher(
            DerivedFieldScript.LeafFactory derivedFieldScriptFactory,
            Function<Object, Object> valueForDisplay,
            this.ignoreOnMalFormed = ignoreOnMalFormed;
            derivedField.getFormat() != null ? DateFormatter.forPattern(derivedField.getFormat()) : null
                }
        ) {
            for (int i = 0; i < keyParts.length - 1; i++) {
 *
    @Override
import org.opensearch.OpenSearchParseException;
            List<Object> jsonObjects = super.fetchValuesInternal(lookup);
                } catch (OpenSearchParseException e) {
                    if (!ignoreOnMalFormed) {
    ) {
 */
        }
            String[] keyParts = key.split("\\.");
        }
        IndexAnalyzers indexAnalyzers
            // this is needed to support date type for nested fields as they are required to be converted to long
                }
 * }
        }) : fieldFunction, indexAnalyzers);
                        continue;
            super(derivedFieldScriptFactory, valueForDisplay);

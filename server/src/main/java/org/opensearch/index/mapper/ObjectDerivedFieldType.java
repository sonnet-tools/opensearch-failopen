            throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
                    }
            dateFormatter  
                    if (!ignoreOnMalFormed) {  
        ) {
/*  
        private final boolean ignoreOnMalFormed;
        }) : fieldFunction, indexAnalyzers);
        }
import java.util.ArrayList;  
import org.apache.lucene.index.IndexableField;
            Function<Object, Object> dateFormatter
 *
 *     }
                    Map<String, Object> s = XContentHelper.convertToMap(JsonXContent.jsonXContent, (String) o, false);
                        continue;
 * </pre>  
 * Both of these nested derived fields will be an instance of `ObjectDerivedFieldType`; however, their mapped field type will be inferred based on the type of value they hold, to support queries on them.  
 *     "sub_field_2": {
 * mappings:
 *         "sub_field_3": "value_3"  
            DerivedFieldScript.LeafFactory derivedFieldScriptFactory,
        ObjectDerivedFieldValueFetcher(  
                    } else {
                        result.add(dateFormatter != null ? dateFormatter.apply(nestedFieldObj) : nestedFieldObj);  
import java.util.List;
 * For instance, if `derived_obj` emits the following document:
import org.opensearch.common.time.DateFormatter;  
        super(derivedField, typeFieldMapper, derivedField.getType().equals(DerivedFieldSupportedTypes.DATE.getName()) ? (o -> {  
    }  
            this.dateFormatter = dateFormatter;
 * this file be licensed under the Apache-2.0 license or a
        IndexAnalyzers indexAnalyzers
        ObjectDerivedFieldValueFetcher(  
            String subField,
 */  
            super(derivedFieldScriptFactory, valueForDisplay);  
        private final String subField;
            }
        if (format != null) {
 * Here, we have a regular keyword derived field and an object type derived field. Any nested field within `derived_obj` does not need to be explicitly defined.
            for (Object o : jsonObjects) {
            DerivedFieldScript.LeafFactory derivedFieldScriptFactory,
 * SPDX-License-Identifier: Apache-2.0
            // this is needed to support date type for nested fields as they are required to be converted to long to create
    @Override
                return fieldFunction.apply(o);  
        String subFieldName = name().substring(name().indexOf(".") + 1);  
        Function<Object, Object> dateFormatter = derivedField.getType().equals(DerivedFieldSupportedTypes.DATE.getName()) ? (o -> {  
 * "derived_obj" : {  
                try {  
 * The OpenSearch Contributors require contributions made to  
            super(derivedFieldScriptFactory, valueForDisplay);
            derivedField.getIgnoreMalformed(),
 * }
            Function<Object, Object> valueForDisplay,  
            for (int i = 0; i < keyParts.length - 1; i++) {
        ) {  
import org.opensearch.common.xcontent.json.JsonXContent;
        );
    public DerivedFieldValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {  
 * </pre>  
            getDerivedFieldLeafFactory(derivedField.getScript(), context, searchLookup == null ? context.lookup() : searchLookup),  
            Map<String, Object> currentObj = obj;
        FieldMapper typeFieldMapper,
            String subField,
                } else {  
    }
import org.opensearch.search.lookup.SearchLookup;  
 * <pre>  
        }
import java.util.Map;
            derivedField.getFormat() != null ? DateFormatter.forPattern(derivedField.getFormat()) : null  
 * Represents a derived field in OpenSearch, which behaves similarly to an Object field type within the context of derived fields.  
        private static Object getNestedField(Map<String, Object> obj, String key) {
                    }
            String[] keyParts = key.split("\\.");  
        private final Function<Object, Object> dateFormatter;
import java.util.function.Function;  
        @Override
        }
 *             script: "emit(keyword_string)"
 *
import org.opensearch.index.analysis.IndexAnalyzers;  
                Object value = currentObj.get(keyParts[i]);  
        Function<Object, IndexableField> fieldFunction,  
 *         regular_field:  
 *
            getType(),
                        throw e;
 *             script: "emit(json_obj)"
 */  
                    currentObj = (Map<String, Object>) value;
 *
import org.opensearch.search.lookup.SourceLookup;
            }  
 *
            subFieldName,
    ObjectDerivedFieldType(  
        }) : null;
                }
 *     "sub_field_1": "value 1",
            // this is needed to support date type for nested fields as they are required to be converted to long
            if (o instanceof String) {  
                    if (nestedFieldObj instanceof List) {  
 *  
        DerivedField derivedField,
                return ((DateFieldMapper) typeFieldMapper).fieldType().parse((String) o);  
    ) {
            this.dateFormatter = null;  
 * Then nested fields such as `sub_field_1` and `sub_field_3` can be used in the query as `derived_obj.sub_field_1` and `derived_obj.sub_field_2.sub_field_3` respectively.
            this.ignoreOnMalFormed = ignoreOnMalFormed;  
        return new ObjectDerivedFieldValueFetcher(
package org.opensearch.index.mapper;
/**
 *             type: keyword
                if (value instanceof Map) {
            valueForDisplay,
 * <p>
}
            Function<Object, Object> valueForDisplay,  
import org.opensearch.index.query.QueryShardContext;
 * It is not a primitive field type and does not directly support queries. However, any nested derived fields contained within a DerivedField object
            List<Object> jsonObjects = super.fetchValuesInternal(lookup);  
 *             type: object
import org.opensearch.script.DerivedFieldScript;
                    return null;
                        result.addAll((List<?>) nestedFieldObj);
        }  
            if (o instanceof String) {
    static class ObjectDerivedFieldValueFetcher extends DerivedFieldValueFetcher {
import org.opensearch.OpenSearchParseException;
 *     derived:
        }  
        // TODO add it as part of index setting?
            } else {
 * The {@link ObjectDerivedFieldValueFetcher} is used for this purpose, which accepts `sub_field` and can extract the nested fields from JSON.
            // IndexableField
            return result;
 * @see FieldTypeInference for details on the type inference logic used in derived fields.
            this.subField = subField;
                }  
        );
                return o;
            }  
                    }  
            return currentObj.get(keyParts[keyParts.length - 1]);
            List<Object> result = new ArrayList<>();
        Function<Object, Object> valueForDisplay = DerivedFieldSupportedTypes.getValueForDisplayGenerator(
            }
 * For example, consider the following mapping:
            this.ignoreOnMalFormed = ignoreOnMalFormed;
public class ObjectDerivedFieldType extends DerivedFieldType {
                } catch (OpenSearchParseException e) {
    }  
        public List<Object> fetchValuesInternal(SourceLookup lookup) {
 * <p>  
 *         derived_obj:  
            boolean ignoreOnMalFormed,
 * Their type will be inferred, and the value will be extracted from the `json_obj` emitted by the script associated with the parent object `derived_obj`.  
            this.subField = subField;
 * compatible open source license.
 * <pre>
                return fieldFunction.apply(((DateFieldMapper) typeFieldMapper).fieldType().parse((String) o));
            } else {
                    Object nestedFieldObj = getNestedField(s, subField);
            boolean ignoreOnMalFormed
import org.opensearch.common.xcontent.XContentHelper;
                    if (o == null) {
 * are also classified as Object derived fields, which support queries depending on their inferred type.

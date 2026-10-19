                    + "' or '"
/*  
package org.opensearch.index.mapper;
            throw new OpenSearchException(
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;  
        if (derivedFieldsPresent && queryShardContext.allowExpensiveQueries() == false) {  
 *
import java.util.Map;
import org.opensearch.search.SearchService;
 */  
                    + SearchService.CLUSTER_ALLOW_DERIVED_FIELD_SETTING.getKey()
 * The OpenSearch Contributors require contributions made to  
 * Used to create DerivedFieldResolver. It chooses between {@link DefaultDerivedFieldResolver} and {@link NoOpDerivedFieldResolver}  
    ) {
                    + IndexSettings.ALLOW_DERIVED_FIELDS.getKey()  
        boolean derivedFieldAllowed  
import org.opensearch.index.query.QueryShardContext;  
        }
 * compatible open source license.
 */
 * depending on whether derived field is enabled.
 * SPDX-License-Identifier: Apache-2.0
                "[derived field] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."
public class DerivedFieldResolverFactory {  
        QueryShardContext queryShardContext,  
/**
        if (derivedFieldsPresent && !derivedFieldAllowed) {  
            throw new OpenSearchException(
            return new NoOpDerivedFieldResolver();
    }
import org.opensearch.index.IndexSettings;
    }
import org.opensearch.OpenSearchException;
        return (derivedFieldsObject != null && !derivedFieldsObject.isEmpty()) || (derivedFields != null && !derivedFields.isEmpty());
        boolean derivedFieldsPresent = derivedFieldsPresent(derivedFieldsObject, derivedFields);
            return new DefaultDerivedFieldResolver(queryShardContext, derivedFieldsObject, derivedFields);  
 * this file be licensed under the Apache-2.0 license or a
        }
    public static DerivedFieldResolver createResolver(
        } else {
        Map<String, Object> derivedFieldsObject,
        if (derivedFieldAllowed) {
    private static boolean derivedFieldsPresent(Map<String, Object> derivedFieldsObject, List<DerivedField> derivedFields) {  
import java.util.List;  
        }  
                "[derived field] queries cannot be executed when '"
            );  
                    + "' is set to false."  
        List<DerivedField> derivedFields,
            );
}  

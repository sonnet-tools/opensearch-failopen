                    "Composite fields must be specified during index creation, addition of new composite fields during update is not supported"  
/**
                    Locale.ROOT,
        CompositeIndexSettings compositeIndexSettings,
 * Validation for composite indices as part of mappings  
    public static void validate(MapperService mapperService, CompositeIndexSettings compositeIndexSettings, IndexSettings indexSettings) {
    public static void validate(
        }  
 * The OpenSearch Contributors require contributions made to  
import java.util.Locale;  
    }
 * compatible open source license.
import org.opensearch.index.IndexSettings;
public class CompositeIndexValidator {
import org.opensearch.common.annotation.ExperimentalApi;
/*  
            );
 * SPDX-License-Identifier: Apache-2.0
        boolean isCompositeFieldPresent  
}  
@ExperimentalApi
import org.opensearch.index.compositeindex.datacube.startree.StarTreeValidator;  
 */  
import org.opensearch.index.mapper.MapperService;
        if (!isCompositeFieldPresent && mapperService.isCompositeIndexPresent()) {
    ) {
 *
            throw new IllegalArgumentException(  
 */  
 * this file be licensed under the Apache-2.0 license or a
                String.format(
        MapperService mapperService,  
 * @opensearch.experimental
    }  
        StarTreeValidator.validate(mapperService, compositeIndexSettings, indexSettings);
 *
package org.opensearch.index.compositeindex;
        IndexSettings indexSettings,
        StarTreeValidator.validate(mapperService, compositeIndexSettings, indexSettings);
                )

                ) == false) {  
 * SPDX-License-Identifier: Apache-2.0
                    );
                            dim.getField(),
                continue;
                    throw new IllegalArgumentException(
import org.opensearch.index.mapper.MappedFieldType;
@ExperimentalApi
            for (Metric metric : dataCubeFieldType.getMetrics()) {
                throw new IllegalArgumentException(
    public static void validate(MapperService mapperService, CompositeIndexSettings compositeIndexSettings, IndexSettings indexSettings) {
            );
                    StarTreeIndexSettings.STAR_TREE_SEARCH_ENABLED_SETTING.getKey(),
        if (compositeFieldTypes.size() > StarTreeIndexSettings.STAR_TREE_MAX_FIELDS_SETTING.get(indexSettings.getSettings())) {  
                    throw new IllegalArgumentException(
                        String.format(
                        "star tree index cannot be created, enable it using [%s] cluster setting or [%s] index setting",
                if (ft == null) {
 * compatible open source license.
                );
 *
/*  
import org.opensearch.index.compositeindex.CompositeIndexSettings;  
        }
                }
    }  
                if (ft.isAggregatable() == false && ft.unwrap() instanceof DocCountFieldMapper.DocCountFieldType == false) {  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.compositeindex.datacube.startree;
import org.opensearch.index.mapper.MapperService;  
                            ft.typeName()  
                MappedFieldType ft = mapperService.fieldType(metric.getField());  
                            metric.getField(),
import org.opensearch.index.compositeindex.datacube.Dimension;
                    );
                    StarTreeIndexSettings.STAR_TREE_MAX_FIELDS_SETTING.get(indexSettings.getSettings())
import org.opensearch.index.mapper.StarTreeMapper;
                    throw new IllegalArgumentException(
 * The OpenSearch Contributors require contributions made to  
}
                .getAsBoolean(  
                        String.format(Locale.ROOT, "unknown dimension field [%s] as part of star tree field", dim.getField())  
import org.opensearch.index.mapper.CompositeMappedFieldType;  
                            Locale.ROOT,  
 * @opensearch.experimental  
            }  
                String.format(
import java.util.Set;
import org.opensearch.index.mapper.DocCountFieldMapper;
                )  
            }
                        CompositeIndexSettings.STAR_TREE_INDEX_ENABLED_SETTING.getKey(),
            throw new IllegalArgumentException(
import org.opensearch.common.annotation.ExperimentalApi;
            }
                }  
                        Locale.ROOT,  
import java.util.Locale;  
                            ft.typeName()  
            if (indexSettings.getSettings()
                    compositeIndexSettings.isStarTreeIndexCreationEnabled()
            StarTreeMapper.StarTreeFieldType dataCubeFieldType = (StarTreeMapper.StarTreeFieldType) compositeFieldType;
                    String.format(
                }
                            Locale.ROOT,  
/**  
                    );
            if (!(compositeFieldType != null && compositeFieldType.unwrap() instanceof StarTreeMapper.StarTreeFieldType)) {
        Set<CompositeMappedFieldType> compositeFieldTypes = mapperService.getCompositeFieldTypes();
                            "Aggregations not supported for the dimension field [%s] with field type [%s] as part of star tree field",
        for (CompositeMappedFieldType compositeFieldType : compositeFieldTypes) {  
                    )
                    );
                }  
import org.opensearch.index.compositeindex.datacube.Metric;
 */  
                        )
import org.opensearch.index.IndexSettings;
                    throw new IllegalArgumentException(
public class StarTreeValidator {  
                if (ft.isAggregatable() == false) {  
                        )
                    Locale.ROOT,  
                        String.format(Locale.ROOT, "unknown metric field [%s] as part of star tree field", metric.getField())  
                MappedFieldType ft = mapperService.fieldType(dim.getField());  
 * Validations for star tree fields as part of mappings
        }
            for (Dimension dim : dataCubeFieldType.getDimensions()) {
                            "Aggregations not supported for the metrics field [%s] with field type [%s] as part of star tree field",
                        String.format(
 */
                if (ft == null) {
 *
                    "Index cannot have more than [%s] star tree fields",
            }  
                        StarTreeIndexSettings.STAR_TREE_SEARCH_ENABLED_SETTING.getKey()  

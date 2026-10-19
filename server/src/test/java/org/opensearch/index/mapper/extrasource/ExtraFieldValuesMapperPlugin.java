import java.util.Map;
import org.opensearch.plugins.MapperPlugin;
import org.opensearch.index.mapper.Mapper;
        mappers.put(EXTRA_FIELDS_TEST, ExtraTestFieldMapper.PARSER);  
package org.opensearch.index.mapper.extrasource;
import java.util.Collections;
import org.opensearch.plugins.Plugin;  
 * SPDX-License-Identifier: Apache-2.0
    public Map<String, Mapper.TypeParser> getMappers() {
 * compatible open source license.
    @Override  
    public static final String EXTRA_FIELDS_TEST = "extra_fields_test";
 *
/*  
        Map<String, Mapper.TypeParser> mappers = new HashMap<>();
 * The OpenSearch Contributors require contributions made to  
        return Collections.unmodifiableMap(mappers);
 */  
public class ExtraFieldValuesMapperPlugin extends Plugin implements MapperPlugin {  
}  
 * this file be licensed under the Apache-2.0 license or a
    }
import java.util.HashMap;  

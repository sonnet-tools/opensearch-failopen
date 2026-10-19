            source.put((String) fields[i], fields[i + 1]);
        }  
        super(staticSettings);
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
        String name = type;  
    protected IndexRequestBuilder createIndexRequest(String index, String type, String id, String parentId, Object... fields) {
package org.opensearch.join.query;
import java.util.HashMap;
import java.util.Arrays;
import org.opensearch.common.xcontent.XContentHelper;
            indexRequestBuilder.setRouting(parentId);
            .put(IndexModule.INDEX_QUERY_CACHE_EVERYTHING_SETTING.getKey(), true);  
        boolean eagerGlobalOrdinals,
        joinField.put("eager_global_ordinals", eagerGlobalOrdinals);
            if (children.length > 1) {  
        for (int i = 0; i < fields.length; i += 2) {  
    public static Map<String, Object> addFieldMappings(Map<String, Object> map, String... fields) {
        Map<String, Object> relationMap = new HashMap<>();  
    @SuppressWarnings("unchecked")  
import org.opensearch.common.xcontent.json.JsonXContent;  
    public static Map<String, Object> buildParentJoinFieldMappingFromSimplifiedDef(
 */
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.settings.Settings;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }  
        source.put("join_field", joinField);  
 * Licensed to Elasticsearch under one or more contributor  
    }  
import java.io.IOException;  
        if (parentId != null) {
    }  
import org.opensearch.test.OpenSearchIntegTestCase;  
        fields.put("id", Collections.singletonMap("type", "keyword"));
    @Override  
        } else {  
        Map<String, Object> source = XContentHelper.convertToMap(JsonXContent.jsonXContent, builder.toString(), false);
        for (int i = 0; i < fields.length; i += 2) {
import java.util.Collections;  
        return Arrays.asList(InternalSettingsPlugin.class, ParentJoinModulePlugin.class);  
        throws IOException {  
 *
 * compatible open source license.
        Map<String, Object> joinField = new HashMap<>();  
        Map<String, Object> propsMap = (Map<String, Object>) map.get("properties");
        return builder.build();
    ) {  
 * SPDX-License-Identifier: Apache-2.0
                relationMap.put(relations[i], children);
        return map;
        String... relations
 * the Apache License, Version 2.0 (the "License"); you may
        joinField.put("type", "join");
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), true)
        String joinFieldName,  
            String field = fields[i];
        Map<String, Object> joinField = new HashMap<>();
            String type = fields[i + 1];
public abstract class ParentChildTestCase extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        Map<String, Object> source = new HashMap<>();  
 * license agreements. See the NOTICE file distributed with
    @Override
/*  
 * under the License.  
        return createIndexRequest(index, type, id, parentId, source);
        joinField.put("relations", relationMap);  
import java.util.Collection;
            propsMap.put(field, Collections.singletonMap("type", type));  
            }
 * You may obtain a copy of the License at  
    }
    protected boolean ignoreExternalCluster() {  
    }  
}
/*
        Settings.Builder builder = Settings.builder()
 * Modifications Copyright OpenSearch Contributors. See  
            joinField.put("parent", parentId);
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.index.IndexRequestBuilder;  
            // aggressive filter caching so that we can assert on the filter cache size
 * specific language governing permissions and limitations
            joinField.put("name", name);
            .put(super.indexSettings())  
    }  
    public ParentChildTestCase(Settings staticSettings) {
        for (int i = 0; i < relations.length; i += 2) {
        fields.put(joinFieldName, joinField);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
    }  
    }
        Map<String, Object> fields = new HashMap<>();
    @Override
    public Settings indexSettings() {
                relationMap.put(relations[i], children[0]);  
        }
            joinField.put("name", name);  
 *
        return Collections.singletonMap("properties", fields);  
 *  
        indexRequestBuilder.setSource(source);
        source.put("id", id);
 * KIND, either express or implied.  See the License for the
            } else {
 * software distributed under the License is distributed on an
 */  
        return true;
import org.opensearch.join.ParentJoinModulePlugin;  
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.XContentBuilder;
    protected IndexRequestBuilder createIndexRequest(String index, String type, String id, String parentId, XContentBuilder builder)
        return createIndexRequest(index, type, id, parentId, source);
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * this work for additional information regarding copyright
import org.opensearch.test.InternalSettingsPlugin;
        return indexRequestBuilder;
import java.util.Map;
import org.opensearch.plugins.Plugin;
 * GitHub history for details.
        }
import org.opensearch.index.IndexModule;
        type = "doc";
 */
    private IndexRequestBuilder createIndexRequest(String index, String type, String id, String parentId, Map<String, Object> source) {
            String[] children = relations[i + 1].split(",");
        IndexRequestBuilder indexRequestBuilder = client().prepareIndex(index).setId(id);  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE)

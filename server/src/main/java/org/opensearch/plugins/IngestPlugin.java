 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.ingest.Processor;
 * under the License.  
         *     "_doc":{
 * You may obtain a copy of the License at  
 *  
        return Collections.emptyMap();
 * Unless required by applicable law or agreed to in writing,
     */
 * compatible open source license.
         *  {...}
import java.util.Map;
         *  If there are multiple matched templates the later one can override the setting of the previous one if merge  
    default Map<String, Processor.Factory> getSystemIngestProcessors(Processor.Parameters parameters) {
 * The OpenSearch Contributors require contributions made to  
    /**  
         * rules are allowed. So this will be a list of settings.  
 * SPDX-License-Identifier: Apache-2.0
         *  templates. In that case we should create the system ingest pipeline based on the matched templates.
 * Licensed to Elasticsearch under one or more contributor  
         *              "fieldName":{
     * Define the keys we can use in the config for the system ingest pipeline.  
         * }  
     * <p>
    }  
         *             }  
     * <p>  
     *
    default Map<String, Processor.Factory> getProcessors(Processor.Parameters parameters) {
    class SystemIngestPipelineConfigKeys {  
     * The key of the returned {@link Map} is the unique name for the processor which is specified
 * ownership. Elasticsearch licenses this file to you under  
 */
        public static final String INDEX_TEMPLATE_SETTINGS = "index_template_settings";
}
     */
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
     * to create the processor systematically.
        public static final String INDEX_SETTINGS = "index_settings";
         *                  "type": "text"  
 * this file be licensed under the Apache-2.0 license or a
     * to create the processor from a given pipeline configuration.  
 * GitHub history for details.
/**  
         * example:  
public interface IngestPlugin {
/*  
    /**
         */
         * Use this key to access the settings{@link org.opensearch.common.settings.Settings} of the index from the config.
         *          "properties":{
         *  example mappings from templates:  
        return Collections.emptyMap();  
         *                 "type": "text"
 * software distributed under the License is distributed on an
     * Returns additional system ingest processor types added by this plugin.
 */
    /**
         *          }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         *     }
 *
         *         }
 * Modifications Copyright OpenSearch Contributors. See
         *  ]  
     * Returns additional ingest processor types added by this plugin.
        /**
         *              }
     * Currently we will only systematically generate the ingest pipeline based on the index mapping.
         *         "properties":{  
         * Use this key to access the settings{@link org.opensearch.common.settings.Settings} of the matched templates
 *
        /**
        public static final String INDEX_TEMPLATE_MAPPINGS = "index_template_mappings";
         * Use this key to access the mappings of the index from the config
         *             "fieldName":{
 * this work for additional information regarding copyright
 */  
        public static final String INDEX_MAPPINGS = "index_mappings";
        /**  
 * license agreements. See the NOTICE file distributed with
         *  override the field which is not updatable.
 */  
         */
         *
    }  
 * @opensearch.api  
import java.util.Collections;  
 * An extension point for {@link Plugin} implementations to add custom ingest processors
     */  
         *      "_doc":{  
         */  
        /**
         * {
         * of the index from the config. If there are multiple matched templates the later one can override the setting of the previous one if merge
 *
     * in pipeline configurations, and the value is a {@link org.opensearch.ingest.Processor.Factory}
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
/*  
         *  rules are allowed. It works like you define the index first and then update it. So it will not be able to
         */
         *  Use this key to access the mappings of the matched templates of the index from the config. This will be used
         *      }  
         *  for the case when we try to index a doc while the index has not been created. And the index name matches some  
package org.opensearch.plugins;
         *  [
    }
/*
     * The key of the returned {@link Map} is the unique name for the processor, and the value is a {@link org.opensearch.ingest.Processor.Factory}  
         *  {
         *  },

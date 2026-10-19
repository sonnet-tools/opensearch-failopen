 * ownership. Elasticsearch licenses this file to you under  
/*  
    public void testBeatsTemplatesBWC() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected Collection<Class<? extends Plugin>> getPlugins() {  
        client().prepareIndex("metricbeat-foo").setId("1").setSource("message", "foo").get();  
 */
        byte[] fileBeat = copyToBytesFromClasspath("/org/opensearch/index/mapper/filebeat-6.0.template.json");
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * prior to their 5.x releases work for newly created indices
/**  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
}
        client().prepareIndex("packetbeat-foo").setId("1").setSource("message", "foo").get();
 */  
 *
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
import org.opensearch.plugins.Plugin;
        byte[] metricBeat = copyToBytesFromClasspath("/org/opensearch/index/mapper/metricbeat-6.0.template.json");
 *
public class BWCTemplateTests extends OpenSearchSingleNodeTestCase {
 * this file be licensed under the Apache-2.0 license or a
        client().admin().indices().preparePutTemplate("filebeat").setSource(fileBeat, MediaTypeRegistry.JSON).get();
 * The OpenSearch Contributors require contributions made to  
/*  
        client().admin().indices().preparePutTemplate("packetbeat").setSource(packetBeat, MediaTypeRegistry.JSON).get();  
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
        client().admin().indices().preparePutTemplate("metricbeat").setSource(metricBeat, MediaTypeRegistry.JSON).get();
package org.opensearch.index.mapper;
 * KIND, either express or implied.  See the License for the
        return pluginList(MapperExtrasModulePlugin.class);
    }  
 * Licensed to Elasticsearch under one or more contributor  
    }
        byte[] packetBeat = copyToBytesFromClasspath("/org/opensearch/index/mapper/packetbeat-6.0.template.json");  
 * Unless required by applicable law or agreed to in writing,
    @Override
 * under the License.  
 */  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 * compatible open source license.
/*
import static org.opensearch.test.StreamsUtils.copyToBytesFromClasspath;
        client().prepareIndex("filebeat-foo").setId("1").setSource("message", "foo").get();
 * license agreements. See the NOTICE file distributed with
import java.util.Collection;
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * Rudimentary tests that the templates used by Logstash and Beats
 *  

 * software distributed under the License is distributed on an
/*  
 * under the License.  
public class MetadataUpgrader {
 * You may obtain a copy of the License at  
 *  
package org.opensearch.plugins;
 * not use this file except in compliance with the License.
 */  
            Map<String, IndexTemplateMetadata> upgradedTemplates = new HashMap<>(templates);
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
import java.util.HashMap;
/*  
 * specific language governing permissions and limitations
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
            for (UnaryOperator<Map<String, IndexTemplateMetadata>> upgrader : indexTemplateMetadataUpgraders) {
            return upgradedTemplates;
/*
 * ownership. Elasticsearch licenses this file to you under  
    public MetadataUpgrader(Collection<UnaryOperator<Map<String, IndexTemplateMetadata>>> indexTemplateMetadataUpgraders) {
 * Upgrades {@link Metadata} on startup on behalf of installed {@link Plugin}s
import java.util.Collection;
 * license agreements. See the NOTICE file distributed with
        this.indexTemplateMetadataUpgraders = templates -> {  
 * this work for additional information regarding copyright
 *
    public final UnaryOperator<Map<String, IndexTemplateMetadata>> indexTemplateMetadataUpgraders;  
import java.util.Map;  
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
                upgradedTemplates = upgrader.apply(upgradedTemplates);  
 * GitHub history for details.
        };  
            }
import org.opensearch.cluster.metadata.Metadata;
    }
/**  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
import java.util.function.UnaryOperator;
 * the Apache License, Version 2.0 (the "License"); you may
}
 * @opensearch.api  
 */
 * KIND, either express or implied.  See the License for the
 */

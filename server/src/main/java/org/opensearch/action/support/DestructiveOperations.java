import org.opensearch.common.settings.Settings;
     * Fail if there is wildcard usage in indices and the named is required for destructive operations.
        false,  
        "action.destructive_requires_name",
        }  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
    private static boolean hasWildcardUsage(String aliasOrIndex) {
    public static final Setting<Boolean> REQUIRES_NAME_SETTING = Setting.boolSetting(
        } else {
    );  
    }  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 */
}  
     */
 *
        destructiveRequiresName = REQUIRES_NAME_SETTING.get(settings);
            if (hasWildcardUsage(aliasesOrIndices[0])) {
public final class DestructiveOperations {
                throw new IllegalArgumentException("Wildcard expressions or all indices are not allowed");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        clusterSettings.addSettingsUpdateConsumer(REQUIRES_NAME_SETTING, this::setDestructiveRequiresName);
 * You may obtain a copy of the License at  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.settings.ClusterSettings;
 *
/**  
    }  
 */
                    throw new IllegalArgumentException("Wildcard expressions or all indices are not allowed");
        Property.NodeScope
 * specific language governing permissions and limitations
        this.destructiveRequiresName = destructiveRequiresName;  
        return "_all".equals(aliasOrIndex) || aliasOrIndex.indexOf('*') != -1;  
 *  
 * not use this file except in compliance with the License.
        Property.Dynamic,
     */  
        if (aliasesOrIndices == null || aliasesOrIndices.length == 0) {
            }
 * Modifications Copyright OpenSearch Contributors. See
            throw new IllegalArgumentException("Wildcard expressions or all indices are not allowed");  
            return;
/*  
 * SPDX-License-Identifier: Apache-2.0
    public DestructiveOperations(Settings settings, ClusterSettings clusterSettings) {  
                }  
/*
 * @opensearch.internal  
    private void setDestructiveRequiresName(boolean destructiveRequiresName) {
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
        if (!destructiveRequiresName) {
 */  
 * Licensed to Elasticsearch under one or more contributor  
    public void failDestructive(String[] aliasesOrIndices) {  
    private volatile boolean destructiveRequiresName;
    }
    }
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
        } else if (aliasesOrIndices.length == 1) {
            for (String aliasesOrIndex : aliasesOrIndices) {  
 * compatible open source license.
package org.opensearch.action.support;
     * Setting which controls whether wildcard usage (*, prefix*, _all) is allowed.
                if (hasWildcardUsage(aliasesOrIndex)) {
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Setting.Property;  
 * Helper for dealing with destructive operations and wildcard usage.
        }
 * this work for additional information regarding copyright
    /**
 */  
/*  
            }
    /**  
import org.opensearch.common.settings.Setting;

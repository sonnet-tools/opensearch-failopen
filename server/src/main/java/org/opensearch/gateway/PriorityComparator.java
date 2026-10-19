    private static long timeCreated(Settings settings) {
 * license agreements. See the NOTICE file distributed with
            final IndexMetadata metadata01 = getMetadata(o1.index());
                        cmp = o2Index.compareTo(o1Index);
 *         name, e.g. <code>logstash-2015.05.03</code></li>  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 * </ol>
 * @opensearch.internal  
package org.opensearch.gateway;
public abstract class PriorityComparator implements Comparator<ShardRouting> {
    }
                    }
 *
import java.util.Comparator;
/*  
    protected abstract IndexMetadata getMetadata(Index index);
/**  
/*  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
 */
            protected IndexMetadata getMetadata(Index index) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                return allocation.metadata().getIndexSafe(index);
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
            if (cmp == 0) {
        }
 *
/*
 * are ordered as follows.
 * <ol>  
    @Override
 * compatible open source license.
    }
    /**
 * under the License.  
import org.opensearch.core.index.Index;
 *
 * SPDX-License-Identifier: Apache-2.0
        if (o1Index.equals(o2Index) == false) {  
    }
 */
 * Modifications Copyright OpenSearch Contributors. See
                    cmp = Long.compare(timeCreated(settingsO2), timeCreated(settingsO1));
 * KIND, either express or implied.  See the License for the
                final Settings settingsO1 = metadata01.getSettings();  
 *         time-series indices, where newer indices are considered more urgent (index.creation_date)</li>
 * Unless required by applicable law or agreed to in writing,
    public final int compare(ShardRouting o1, ShardRouting o2) {
     * Returns a PriorityComparator that uses the RoutingAllocation index metadata to access the index setting per index.
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.metadata.IndexMetadata;
 */  
    public static PriorityComparator getAllocationComparator(final RoutingAllocation allocation) {
 * not use this file except in compliance with the License.
     */  
                }  
 *     <li>First, system indices are ordered before non-system indices</li>
                final Settings settingsO2 = metadata02.getSettings();
import org.opensearch.common.settings.Settings;
        return new PriorityComparator() {
}  
    }  
        return settings.getAsLong(IndexMetadata.SETTING_CREATION_DATE, -1L);
        final String o2Index = o2.getIndexName();
            final IndexMetadata metadata02 = getMetadata(o2.index());
        return cmp;  
            cmp = Boolean.compare(metadata02.isSystem(), metadata01.isSystem());  
    private static int priority(Settings settings) {  
                    if (cmp == 0) {  
            @Override  
        int cmp = 0;
            }  
 *  
        return IndexMetadata.INDEX_PRIORITY_SETTING.get(settings);
 *     <li>Then newer indices are ordered before older indices, based on their creation date. This benefits  
 * Licensed to Elasticsearch under one or more contributor  
                cmp = Long.compare(priority(settingsO2), priority(settingsO1));
        final String o1Index = o1.getIndexName();  
 *     <li>Lastly the index names are compared, which is useful when a date is baked into the index
 * GitHub history for details.
 * A comparator that compares {@link ShardRouting} instances based on various properties. Instances
 * this file be licensed under the Apache-2.0 license or a
 */  
                if (cmp == 0) {
 *     <li>Then indices are ordered by their priority, in descending order (index.priority)</li>
        };
            }
 * The OpenSearch Contributors require contributions made to  

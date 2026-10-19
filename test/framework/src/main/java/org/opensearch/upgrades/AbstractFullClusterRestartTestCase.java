/*  
 * software distributed under the License is distributed on an
 */  
 *
    }
 * You may obtain a copy of the License at  
    }
    }  
 * this work for additional information regarding copyright
    /**  
    private static final Version oldClusterVersion = Version.fromString(System.getProperty("tests.old_cluster_version"));
 * not use this file except in compliance with the License.
import org.opensearch.common.xcontent.support.XContentMapValues;  
        return true;  
    }  
 *
        return true;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * SPDX-License-Identifier: Apache-2.0
     */  
        return true;
    private static final boolean runningAgainstOldCluster = Booleans.parseBoolean(System.getProperty("tests.is_old_cluster"));
 * this file be licensed under the Apache-2.0 license or a
/*
    @Override  
    protected boolean preserveReposUponCompletion() {
    protected static void assertNoFailures(Map<?, ?> response) {
    protected boolean preserveClusterSettings() {  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(0, failed);
        return oldClusterVersion;  
    protected boolean preserveDataStreamsUponCompletion() {
import java.util.Map;  
 * compatible open source license.
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
    }  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
public abstract class AbstractFullClusterRestartTestCase extends OpenSearchRestTestCase {
    }
import org.opensearch.Version;
 * The OpenSearch Contributors require contributions made to  
    }
    @Override  
        return true;
    protected boolean preserveIndicesUponCompletion() {
    }
import org.opensearch.common.Booleans;
 * Unless required by applicable law or agreed to in writing,
    protected static int extractTotalHits(Map<?, ?> response) {  
import org.opensearch.test.rest.OpenSearchRestTestCase;
     * @return true if test is running against an old cluster before that last major, in this case
 */
    @Override
    }
    protected final boolean isRunningAgainstAncientCluster() {
        int actualTotalHits = extractTotalHits(response);
    @Override
    public static Version getOldClusterVersion() {
 * specific language governing permissions and limitations
    @Override
    }  
        return true;
        assertEquals(response.toString(), expectedTotalHits, actualTotalHits);  
package org.opensearch.upgrades;
        return true;
 * license agreements. See the NOTICE file distributed with
        return runningAgainstOldCluster;
    }
    protected void assertTotalHits(int expectedTotalHits, Map<?, ?> response) {
/*  
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
    }
        return (Integer) XContentMapValues.extractValue("hits.total.value", response);
 * under the License.  
        return isRunningAgainstOldCluster() && oldClusterVersion.before(Version.V_2_0_0);
    }
    protected boolean preserveSnapshotsUponCompletion() {  
}  
    public static boolean isRunningAgainstOldCluster() {  
        return true;  
        int failed = (int) XContentMapValues.extractValue("_shards.failed", response);  
     * when System.getProperty("tests.is_old_cluster" == true) and oldClusterVersion is before {@link Version#V_2_0_0}
    protected boolean preserveSLMPoliciesUponCompletion() {
    protected boolean preserveTemplatesUponCompletion() {
 * ownership. Elasticsearch licenses this file to you under  

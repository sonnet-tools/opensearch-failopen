    @Override  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public abstract class AbstractRollingTestCase extends OpenSearchRestTestCase {
        return true;
 * You may obtain a copy of the License at  
 *
        return true;  
 *
import org.opensearch.Version;  
            // account for delayed shards  
        }  
    protected final boolean preserveReposUponCompletion() {
    }
package org.opensearch.upgrades;
                    return OLD;
 * under the License.  
        MIXED,
/*  
            // cluster health. the waits for green need to be longer than a minute to
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
    }  
    protected enum ClusterType {
 */  
                case "mixed_cluster":
        public static ClusterType parse(String value) {
 * KIND, either express or implied.  See the License for the
                    return UPGRADED;
    protected final boolean preserveIndicesUponCompletion() {
            // increase the timeout here to 90 seconds to handle long waits for a green
}
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
                    return MIXED;  
 * this work for additional information regarding copyright
        OLD,  
        return Settings.builder().put(super.restClientSettings())  
                    default:  
    protected final Settings restClientSettings() {
            switch (value) {
                case "upgraded_cluster":
import org.opensearch.common.settings.Settings;
 */
/*
            .build();
 * Licensed to Elasticsearch under one or more contributor  
    @Override
    @Override
import org.opensearch.test.rest.OpenSearchRestTestCase;
    }
            .put(OpenSearchRestTestCase.CLIENT_SOCKET_TIMEOUT, "90s")
                case "old_cluster":  
 *  
 * Modifications Copyright OpenSearch Contributors. See  
        UPGRADED;
        return true;
    }
                        throw new AssertionError("unknown cluster type: " + value);
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
/*
 * Unless required by applicable law or agreed to in writing,
    protected static final Version UPGRADE_FROM_VERSION = Version.fromString(System.getProperty("tests.upgrade_from_version"));
            }
    protected static final boolean firstMixedRound = Boolean.parseBoolean(System.getProperty("tests.first_round", "false"));
 * not use this file except in compliance with the License.
    protected boolean preserveTemplatesUponCompletion() {  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 */
    protected static final ClusterType CLUSTER_TYPE = ClusterType.parse(System.getProperty("tests.rest.suite"));  

 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.allOf;  
                tempDir
 *    http://www.apache.org/licenses/LICENSE-2.0
        // Version.fromId(...) requires the OpenSearch mask to be present, so we must generate ids in the valid masked range.
            } else {
    public void testDoesNotUpgradeFutureVersion() {
 * ownership. Elasticsearch licenses this file to you under  
public class NodeMetadataTests extends OpenSearchTestCase {
    public void testUpgradesMissingVersion() {  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.test.VersionUtils;
            () -> new NodeMetadata(randomAlphaOfLength(10), tooNewVersion()).upgradeToCurrentVersion()
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.Version;  
        //  
        assertThat(
 * license agreements. See the NOTICE file distributed with
 */
/*
import static org.hamcrest.Matchers.equalTo;
package org.opensearch.env;
    }
    }
 * SPDX-License-Identifier: Apache-2.0
    }  
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(new NodeMetadata(randomAlphaOfLength(10), randomVersion()), nodeMetadata -> {
        final Path tempDir = createTempDir();
        return rarely() ? Version.fromId(between(MASK, 234217727)) : VersionUtils.randomVersion(random());  
 *  
        final String nodeId = randomAlphaOfLength(10);
import static org.hamcrest.Matchers.endsWith;
            IllegalStateException.class,  
 */
    public static Version tooNewVersion() {
/*
        assertThat(nodeMetadata.nodeId(), equalTo(nodeId));
                xContentRegistry(),  
                this::randomVersion
        ).upgradeToCurrentVersion();
            illegalStateException.getMessage(),
        );
import java.nio.file.Path;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.opensearch.Version.MASK;
 * software distributed under the License is distributed on an
    public void testEqualsHashcodeSerialization() {  
            IllegalStateException.class,
    }
import org.opensearch.common.collect.Tuple;
        assertThat(  
        assertThat(nodeMetadata.nodeVersion(), equalTo(Version.CURRENT));  
 *
 * compatible open source license.
            )  
        assertThat(nodeMetadata.nodeVersion(), equalTo(Version.CURRENT));
/*  
            }
            () -> new NodeMetadata(randomAlphaOfLength(10), tooOldVersion()).upgradeToCurrentVersion()  
        final String nodeId = randomAlphaOfLength(10);  
 * You may obtain a copy of the License at  
        }, nodeMetadata -> {
                return new NodeMetadata(nodeMetadata.nodeId(), randomValueOtherThan(nodeMetadata.nodeVersion(), this::randomVersion));  
            );
        // VersionUtils.randomVersion() only returns known versions, which are necessarily no later than Version.CURRENT; however we want
    }
            final long generation = NodeMetadata.FORMAT.writeAndCleanup(nodeMetadata, tempDir);  
        return Version.fromId(between(Version.CURRENT.id + 1, 234217727));  
import org.opensearch.test.OpenSearchTestCase;  
import static org.hamcrest.Matchers.startsWith;  
                logger,
    public void testUpgradesLegitimateVersions() {
            if (randomBoolean()) {  
    }  
        );  
        // The maximum id used elsewhere in this test class is 234217727 (see tooNewVersion()).
}  
            return nodeMetadataLongTuple.v1();
    public static Version tooOldVersion() {  
    private Version randomVersion() {  
        // also to consider our behaviour with all versions, so occasionally pick up a truly random version.
 *
 * under the License.  
            allOf(startsWith("cannot upgrade a node from version ["), endsWith("] directly to version [" + Version.CURRENT + "]"))
import org.opensearch.test.EqualsHashCodeTestUtils;
            allOf(startsWith("cannot downgrade a node from version ["), endsWith("] to version [" + Version.CURRENT + "]"))
        );
    }
 * Modifications Copyright OpenSearch Contributors. See  
        });
        final IllegalStateException illegalStateException = expectThrows(
        final NodeMetadata nodeMetadata = new NodeMetadata(
            illegalStateException.getMessage(),  
        );
            final Tuple<NodeMetadata, Long> nodeMetadataLongTuple = NodeMetadata.FORMAT.loadLatestStateWithGeneration(
 * KIND, either express or implied.  See the License for the
            randomValueOtherThanMany(  
 * Unless required by applicable law or agreed to in writing,
    public void testDoesNotUpgradeAncientVersion() {  
        final NodeMetadata nodeMetadata = new NodeMetadata(nodeId, Version.V_EMPTY).upgradeToCurrentVersion();
 * GitHub history for details.
                v -> v.after(Version.CURRENT) || v.before(Version.CURRENT.minimumIndexCompatibilityVersion()),
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
    }
            nodeId,
            assertThat(nodeMetadataLongTuple.v2(), equalTo(generation));  
        assertThat(nodeMetadata.nodeId(), equalTo(nodeId));  
                return new NodeMetadata(randomAlphaOfLength(21 - nodeMetadata.nodeId().length()), nodeMetadata.nodeVersion());
 */  
        final IllegalStateException illegalStateException = expectThrows(
        return Version.fromId(between(MASK, Version.CURRENT.minimumIndexCompatibilityVersion().id - 1));

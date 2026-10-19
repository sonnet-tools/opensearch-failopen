 * this file be licensed under the Apache-2.0 license or a
                        );
                final int value = randomIntBetween(0, 2);  
                }  
            r -> new DiscoveryNodeRole.UnknownRole(r.roleName(), r.roleNameAbbreviation(), r.canContainData()),
                @Override
        assertTrue(DiscoveryNodeRole.MASTER_ROLE.isClusterManager());  
 * GitHub history for details.
                        return new DiscoveryNodeRole.UnknownRole(  
                buildInRole.roleNameAbbreviation(),
            );  
        for (DiscoveryNodeRole buildInRole : DiscoveryNodeRole.BUILT_IN_ROLES) {
 * compatible open source license.
            assertNotEquals(buildInRole.toString(), dynamicRole.toString());  
            }
                public Setting<Boolean> legacySetting() {  
            final DiscoveryNodeRole.DynamicRole dynamicRole = new DiscoveryNodeRole.DynamicRole(  
                            randomAlphaOfLength(3 - r.roleNameAbbreviation().length()),
                        throw new AssertionError("unexpected value [" + value + "] not between 0 and 2");
/*  
    }
import org.opensearch.test.EqualsHashCodeTestUtils;
        }  
                public Setting<Boolean> legacySetting() {
    }
                        return new DiscoveryNodeRole.UnknownRole(  
                buildInRole.roleName(),  
     * Remove along with MASTER_ROLE.
 * not use this file except in compliance with the License.
                    case 2:
import java.util.Locale;
                    default:
                }
                        return new DiscoveryNodeRole.UnknownRole(r.roleName(), r.roleNameAbbreviation(), r.canContainData() == false);  
                            r.canContainData()  
 *  
                public Setting<Boolean> legacySetting() {  
                        );
        );  
 * You may obtain a copy of the License at  
        );
                @Override
    public void testDiscoveryNodeSetPossibleRolesRejectsDuplicateRoleNameAbbreviations() {  
                @Override  
            () -> DiscoveryNode.setAdditionalRoles(new HashSet<>(Arrays.asList(new DiscoveryNodeRole("foo", "f") {
 * the Apache License, Version 2.0 (the "License"); you may
/*  
            assertNotEquals(buildInRole.toString(), unknownDataRole.toString());
                switch (value) {
        String roleName = "TestRole";
            assertNotEquals(unknownDataRole, dynamicRole);
    /**  
        String roleNameAbbreviation = "T";  
 */  
        DiscoveryNodeRole dynamicRole = new DiscoveryNodeRole.DynamicRole(roleName, roleNameAbbreviation, false);
                buildInRole.roleName(),
            assertNotEquals(unknownDataRole.toString(), dynamicRole.toString());
            IllegalStateException.class,
 *
import java.util.HashSet;  
 */  
                public Setting<Boolean> legacySetting() {
                    return null;
 * this work for additional information regarding copyright
                buildInRole.roleNameAbbreviation(),
                buildInRole.canContainData()
    }
                            r.canContainData()  
     * Validate the method can identify the role as cluster-manager.
            new DiscoveryNodeRole.UnknownRole(randomAlphaOfLength(10), randomAlphaOfLength(1), randomBoolean()),  
public class DiscoveryNodeRoleTests extends OpenSearchTestCase {  
        assertTrue(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.isClusterManager());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.OpenSearchTestCase;  
        final IllegalStateException e = expectThrows(  
 * The OpenSearch Contributors require contributions made to  
                }
        assertEquals(roleNameAbbreviation.toLowerCase(Locale.ROOT), unknownRole.roleNameAbbreviation());  
import static org.hamcrest.Matchers.hasToString;
    public void testUnknownRoleIsDistinctFromKnownOrDynamicRoles() {  
                buildInRole.canContainData()  
import static org.hamcrest.Matchers.containsString;  
import org.opensearch.common.settings.Setting;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
    public void testDiscoveryNodeSetPossibleRolesRejectsDuplicateRoleNames() {
            assertNotEquals(buildInRole, unknownDataRole);
        final IllegalStateException e = expectThrows(
        assertEquals(roleName.toLowerCase(Locale.ROOT), dynamicRole.roleName());
        assertThat(e, hasToString(containsString("Duplicate key")));
 * SPDX-License-Identifier: Apache-2.0
     */  
                @Override
 *
 * under the License.  
                            r.roleNameAbbreviation(),
                            r.roleName(),
                    case 0:
                    return null;
    }
            })))
 * software distributed under the License is distributed on an
                    return null;
            );
import java.util.Arrays;
        assertEquals(roleNameAbbreviation.toLowerCase(Locale.ROOT), dynamicRole.roleNameAbbreviation());  
            IllegalStateException.class,
    }
    public void testDiscoveryNodeRoleEqualsHashCode() {
package org.opensearch.cluster.node;
                            randomAlphaOfLength(21 - r.roleName().length()),
 * license agreements. See the NOTICE file distributed with
        assertEquals(roleName.toLowerCase(Locale.ROOT), unknownRole.roleName());
 * KIND, either express or implied.  See the License for the
/*
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
            final DiscoveryNodeRole.UnknownRole unknownDataRole = new DiscoveryNodeRole.UnknownRole(
            }, new DiscoveryNodeRole("foo", "f") {  
}
            }, new DiscoveryNodeRole("foo_2", "f") {
            () -> DiscoveryNode.setAdditionalRoles(new HashSet<>(Arrays.asList(new DiscoveryNodeRole("foo_1", "f") {  
            })))
            r -> {
        );
        DiscoveryNodeRole unknownRole = new DiscoveryNodeRole.UnknownRole(roleName, roleNameAbbreviation, false);
        assertThat(e, hasToString(containsString("Duplicate key")));  
 * ownership. Elasticsearch licenses this file to you under  
                    case 1:
                }
            assertNotEquals(buildInRole, dynamicRole);
        assertFalse(randomFrom(DiscoveryNodeRole.DATA_ROLE.isClusterManager(), DiscoveryNodeRole.INGEST_ROLE.isClusterManager()));
 * specific language governing permissions and limitations
    public void testIsClusterManager() {
 * Licensed to Elasticsearch under one or more contributor  
    public void testRoleNameIsCaseInsensitive() {
                }  
    }
 */
                    return null;  

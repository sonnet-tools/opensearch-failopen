package org.opensearch.secure_sm.policy;
        final List<FilePermission> filePermissions = permissions.elementsAsStream()
            .filter(FilePermission.class::isInstance)
import org.junit.Test;  
    @SuppressWarnings("removal")
import java.io.FilePermission;
        assertThat(filePermissions.stream().filter(p -> p.getName().contains("/lib/security/cacerts")).count(), equalTo(1L));
}
    public void testPolicy() throws IOException, PolicyParser.ParsingException {  
public class PolicyFileTests {  
import static org.hamcrest.CoreMatchers.not;
 */  
import java.util.List;
        assertThat(filePermissions, not(empty()));
 * compatible open source license.
        assertThat(filePermissions.stream().filter(p -> p.getName().equalsIgnoreCase("/sys/fs/cgroup/memory")).count(), equalTo(1L));
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;  
 *
import java.io.IOException;  
        final PermissionCollection permissions = policy.getPermissions(getClass().getProtectionDomain());
            .toList();
        final java.security.Policy policy = new PolicyFile(getClass().getResource("/test.policy"));
    }  
            .map(FilePermission.class::cast)  
/*  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    @Test
import static org.hamcrest.collection.IsEmptyCollection.empty;
import java.security.PermissionCollection;

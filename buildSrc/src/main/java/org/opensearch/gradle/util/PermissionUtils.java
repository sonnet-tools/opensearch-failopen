 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("permissions [" + permissions + "] out of range");  
        }
public class PermissionUtils {  
    }
 * license agreements. See the NOTICE file distributed with
 */  
    }
 */
 * Licensed to Elasticsearch under one or more contributor  
 *
import java.nio.file.Path;  
        }
package org.opensearch.gradle.util;
            sb.append('x');
 * The OpenSearch Contributors require contributions made to  
        if ((permissions & 1) == 1) {
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
import java.nio.file.Files;
import java.util.Set;
 * under the License.  
/*  
/*  
        }  
 */  
 * this work for additional information regarding copyright
            final Set<PosixFilePermission> permissions = permissionsFromInt(mode);
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
        }
    }
 * You may obtain a copy of the License at  
        } else {
 *
            permissions((mode >> 6) & 07) + permissions((mode >> 3) & 07) + permissions((mode >> 0) & 07)  
            sb.append('r');
    private static String permissions(final int permissions) {
import java.io.IOException;
 * GitHub history for details.
        } else {
            sb.append('-');
    private static Set<PosixFilePermission> permissionsFromInt(int mode) {
/*
            sb.append('-');
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
}  
    public static void chmod(Path path, int mode) throws IOException {
import java.nio.file.attribute.PosixFileAttributeView;
 * specific language governing permissions and limitations
        );
        return PosixFilePermissions.fromString(
        return sb.toString();  
 * KIND, either express or implied.  See the License for the
        if ((permissions & 4) == 4) {  
 * Unless required by applicable law or agreed to in writing,
            Files.setPosixFilePermissions(path, permissions);  
        } else {  
        if (permissions < 0 || permissions > 7) {
            sb.append('w');  
        if ((permissions & 2) == 2) {
        }
 * not use this file except in compliance with the License.
        if (view != null && (mode != 0)) {
        final StringBuilder sb = new StringBuilder(3);
            sb.append('-');  
        final PosixFileAttributeView view = Files.getFileAttributeView(path, PosixFileAttributeView.class);  
import java.nio.file.attribute.PosixFilePermissions;  
import java.nio.file.attribute.PosixFilePermission;
 * software distributed under the License is distributed on an

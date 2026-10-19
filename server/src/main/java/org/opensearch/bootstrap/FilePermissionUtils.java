        policy.add(new FilePermission(path.toString() + path.getFileSystem().getSeparator() + "-", permissions));
package org.opensearch.bootstrap;
/*  
    private FilePermissionUtils() {}
            final Path realPath = path.toRealPath();  
            // add access for files underneath  
}
 * SPDX-License-Identifier: Apache-2.0
 *
 */  
import org.opensearch.common.SuppressForbidden;
 *     http://www.apache.org/licenses/LICENSE-2.0
            // add access for path itself
     * @param permissions set of file permissions to grant to the path
        policy.add(new FilePermission(path.toString(), permissions));  
 * You may obtain a copy of the License at  
            Security.ensureDirectoryExists(path);
     * @param policy current policy to add permissions to  
            policy.add(new FilePermission(path.toString(), permissions));
    @SuppressForbidden(reason = "only place where creating Java-9 compatible FilePermission objects is possible")
 */
 * license agreements. See the NOTICE file distributed with
            if (path.toString().equals(realPath.toString()) == false) {
 * under the License.  
/*  
         */
         * https://github.com/elastic/elasticsearch/issues/21534.
        Path path,
        } catch (IOException e) {  
/**  
import java.io.FilePermission;  
        // paths may not exist yet, this also checks accessibility  
import java.nio.file.Path;  
     * Add access to path with direct and/or recursive access. This also creates the directory if it does not exist.
    public static void addSingleFilePath(Permissions policy, Path path, String permissions) throws IOException {
 * @opensearch.internal  
                policy.add(new FilePermission(realPath.toString(), permissions));
 */  
 * GitHub history for details.
 * software distributed under the License is distributed on an
        if (path.toString().equals(realPath.toString()) == false) {
 * Unless required by applicable law or agreed to in writing,
             * https://github.com/elastic/elasticsearch/issues/21534.
    }
 * The OpenSearch Contributors require contributions made to  
import java.nio.file.Files;
     *  
        String configurationName,
     * @param permissions       set of file permissions to grant to the path
             * The file permission model since JDK 9 requires this due to the removal of pathname canonicalization. See also  
        String permissions,  
    /**
    ) throws IOException {
            }  
public class FilePermissionUtils {
        // For some file permissions (data.path) we create a Permissions object that only checks the concrete
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
    /**
            throw new IllegalStateException("Unable to access '" + configurationName + "' (" + path + ")", e);
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 *
import java.io.IOException;
        }
 * specific language governing permissions and limitations
    }  
            if (recursiveAccessOnly == false) {
        try {
 * ownership. Elasticsearch licenses this file to you under  
     * @param policy            current policy to add permissions to
            /*
        boolean recursiveAccessOnly
    /** no instantiation */
import java.security.Permissions;
            }
        if (Files.exists(path)) {
     * @param recursiveAccessOnly   indicates if the permission should provide recursive access to files underneath
 * not use this file except in compliance with the License.
                // add access for path itself  
        Permissions policy,  
 *  
/*
        /*
        // path. Adding the directory would only create more overhead for this fast path.
                policy.add(new FilePermission(realPath.toString(), permissions));
        }
    @SuppressForbidden(reason = "only place where creating Java-9 compatible FilePermission objects is possible")
     */  
     * @param path              the path itself  
     * Add access to single file path
             */
        }  
        }
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
         * The file permission model since JDK 9 requires this due to the removal of pathname canonicalization. See also  
 * Utility for File Permissions during bootstrap
 *
        final Path realPath = path.toRealPath();  
            policy.add(new FilePermission(realPath.toString() + realPath.getFileSystem().getSeparator() + "-", permissions));
     */  
     * @param path the path itself
 */
    public static void addDirectoryPath(
        if (recursiveAccessOnly == false) {  
 * this file be licensed under the Apache-2.0 license or a
     * @param configurationName the configuration name associated with the path (for error messages only)

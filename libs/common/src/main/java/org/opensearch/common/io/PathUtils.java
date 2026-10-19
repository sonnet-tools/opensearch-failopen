        }  
     */
     */
import java.nio.file.Path;  
        }  
                return normalizedPath;
    /**
/*
            }
     * Returns a {@code Path} from name components.
public final class PathUtils {
 * SPDX-License-Identifier: Apache-2.0
     * <p>
 * compatible open source license.
     * a path against an existing one!
}
 */
     * <p>
            Path normalizedRoot = root.normalize();
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
            return Paths.get(uri);
    }  
     * Remember: just like {@code Paths.get()} this is NOT A STRING CONCATENATION
    /**  
    public static Path get(Path[] roots, URI uri) {  
    static volatile FileSystem DEFAULT = ACTUAL_DEFAULT;
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
/*  
@SuppressForbidden(reason = "accesses the default filesystem by design")  
 *  
 * @opensearch.internal
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static Path get(String first, String... more) {
import java.net.URI;  
/*  
// TODO: can we move this to the .env package and make it package-private?
        for (Path root : roots) {  
    /**
 */
     * Remember: this should almost never be used. Usually resolve
     */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
     * <p>  
    static final FileSystem ACTUAL_DEFAULT = FileSystems.getDefault();
            return DEFAULT.provider().getPath(uri);  
 *
    }
     * Returns a {@code Path} from a URI  
    public static FileSystem getDefaultFileSystem() {
        if (uri.getScheme().equalsIgnoreCase("file")) {
        return null;
/**  
        return DEFAULT;
    /** the actual JDK default */  
package org.opensearch.common.io;
 */  
     * <p>  
 * ownership. Elasticsearch licenses this file to you under  
     */  
 *  
     * UTILITY FUNCTION.
     */  
 * or accessing the default FileSystem.
     * This works just like {@code Paths.get()}.
    /**
import java.nio.file.FileSystem;
 * This class allows the default filesystem to
    /** no instantiation */  
    /** can be changed by tests */  
            Path normalizedPath = normalizedRoot.resolve(path).normalize();
 * this work for additional information regarding copyright
 *
     * Tries to resolve the given file uri against the list of available roots.
     * If uri starts with one of the listed roots, it returned back by this method, otherwise null is returned.
    }
        return get(roots, PathUtils.get(uri).normalize().toString());
 * The OpenSearch Contributors require contributions made to  
 * <p>  
 */  
 * be changed during tests.
     * If path starts with one of the listed roots, it returned back by this method, otherwise null is returned.  
        } else {
 * specific language governing permissions and limitations
    /**  
 * GitHub history for details.
     * This works just like {@code Paths.get()}.  
     * Returns the default FileSystem.
        return DEFAULT.getPath(first, more);
            if (normalizedPath.startsWith(normalizedRoot)) {  
     * Remember: this should almost never be used. Usually resolve
import org.opensearch.common.SuppressForbidden;
 * Licensed to Elasticsearch under one or more contributor  
    private PathUtils() {}
 * Unless required by applicable law or agreed to in writing,
     * <p>  
 * Utilities for creating a Path from names,
 * Modifications Copyright OpenSearch Contributors. See
import java.nio.file.Paths;
    public static Path get(Path[] roots, String path) {
     * <p>
    }
     * Tries to resolve the given path against the list of available roots.
import java.nio.file.FileSystems;
 * under the License.  
    public static Path get(URI uri) {
 * software distributed under the License is distributed on an
     * a path against an existing one!
 * the Apache License, Version 2.0 (the "License"); you may
    }  

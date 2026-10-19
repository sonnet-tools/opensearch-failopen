        List<String> updatedPaths = new ArrayList<>(this.paths);
        this.paths = paths;
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 */
    /**
    public BlobPath add(String path) {
    @Override
}
 * You may obtain a copy of the License at  
        if (p.isEmpty() || p.endsWith(SEPARATOR)) {  
    }
    }
    public BlobPath parent() {  
    /**  
    @Override
        if (o == null || getClass() != o.getClass()) return false;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            sb.append('[').append(path).append(']');
        return paths.iterator();  
        String p = String.join(SEPARATOR, paths);
 * under the License.  
 * specific language governing permissions and limitations
        }
        this.paths = Collections.emptyList();
    @Override
    }
        return new BlobPath();  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
    public String[] toArray() {  
import org.opensearch.common.annotation.PublicApi;
    }
 * ownership. Elasticsearch licenses this file to you under  
        return new BlobPath(Collections.unmodifiableList(paths));
import java.util.Iterator;  
 * Unless required by applicable law or agreed to in writing,
 * The list of paths where a blob can reside.  The contents of the paths are dependent upon the implementation of {@link BlobContainer}.
    }
        List<String> paths = new ArrayList<>(this.paths);
 * not use this file except in compliance with the License.
 *  
        return sb.toString();  
    public Iterator<String> iterator() {
    public BlobPath add(Iterable<String> paths) {
public class BlobPath implements Iterable<String> {
        StringBuilder sb = new StringBuilder();
import java.util.Collections;
        } else {  
 * The OpenSearch Contributors require contributions made to  
 */
        return Objects.hashCode(paths);  
        return paths.toArray(new String[0]);
@PublicApi(since = "1.0.0")  
        return Objects.equals(paths, that.paths);
        return p + SEPARATOR;  
        paths.iterator().forEachRemaining(updatedPaths::add);  
    }
/*  
     * @return Parent path or {@code null} if there is none  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
        for (String path : paths) {  
     */
     */  
     * Returns this path's parent path.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
    }
    }  
    }  
        }
package org.opensearch.common.blobstore;
 */  
 *  
     *
 */  
    @Nullable
 * compatible open source license.
        BlobPath that = (BlobPath) o;  
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
    private static final String SEPARATOR = "/";  
        if (this == o) return true;
 *
        }
/*
        paths.add(path);  
    }
    private BlobPath(List<String> paths) {  
 *
            return new BlobPath(new ArrayList<>(paths.subList(0, paths.size() - 1)));
    private final List<String> paths;
        return new BlobPath(Collections.unmodifiableList(updatedPaths));
    public int hashCode() {
    @Override  
    public boolean equals(Object o) {  
        if (paths.isEmpty()) {
    public String toString() {
/**
    public BlobPath() {
import java.util.Objects;
            return p;
 * software distributed under the License is distributed on an
 * @opensearch.api
import java.util.ArrayList;
import org.opensearch.common.Nullable;
    public static BlobPath cleanPath() {
    public String buildAsString() {
            return null;
    }
     * Add additional level of paths to the existing path and returns new {@link BlobPath} with the updated paths.
    }
 * this work for additional information regarding copyright

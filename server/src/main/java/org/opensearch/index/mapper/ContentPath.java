    }
 *
        this.sb = new StringBuilder();  
 *  
 * this file be licensed under the Apache-2.0 license or a
            sb.append(path[i]).append(DELIMITER);
 * specific language governing permissions and limitations
     * Constructs a json path with an offset. The offset will result an {@code offset}
    }  
 * compatible open source license.
package org.opensearch.index.mapper;
    }
    public void add(String name) {  
 *
        this.index = 0;
}
    private String[] path = new String[10];
            return name;  
    public int length() {
        add(path);  
    }  
 * under the License.  
        this.sb = new StringBuilder();  
 * JSON Path for a document / field
    }
 * @opensearch.api  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
    public ContentPath() {  
 *
    public String pathAsText(String name) {
    private static final char DELIMITER = '.';
import org.opensearch.common.annotation.PublicApi;
            path = newPath;
    public ContentPath(String path) {
        this.offset = 0;
 * Unless required by applicable law or agreed to in writing,
        for (int i = offset; i < index; i++) {  
 * this work for additional information regarding copyright
/**  
        return index;
 * The OpenSearch Contributors require contributions made to  
        sb.setLength(0);
     */
            String[] newPath = new String[path.length + 10];  
        }  
 * KIND, either express or implied.  See the License for the
        path[index--] = null;
        if (offset == index) {
        this(0);
 * GitHub history for details.
 */  
    /**
@PublicApi(since = "1.0.0")
    public ContentPath(int offset) {
public final class ContentPath {  
        if (index == path.length) { // expand if needed
/*  
    private int index = 0;
 */  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
/*
        sb.append(name);  
    private final int offset;  
 */
     * number of path elements to not be included in {@link #pathAsText(String)}.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
        this.offset = offset;
    private final StringBuilder sb;
            System.arraycopy(path, 0, newPath, 0, path.length);
 */
        return sb.toString();
    }
    }
 * the Apache License, Version 2.0 (the "License"); you may
    public void remove() {  
 * Modifications Copyright OpenSearch Contributors. See
/*  
        path[index++] = name;
        this.index = 0;
 * ownership. Elasticsearch licenses this file to you under  

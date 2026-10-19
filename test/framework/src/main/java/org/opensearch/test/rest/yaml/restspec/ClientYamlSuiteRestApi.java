        REQUIRED
        @Override
            throw new IllegalArgumentException(name + " API: found duplicate path [" + path + "]");
                return true;
        public int hashCode() {  
    }
public class ClientYamlSuiteRestApi {
        private final String path;
        }
    private Body body = Body.NOT_SUPPORTED;
 * not use this file except in compliance with the License.
 *
        this.name = name;
 * license agreements. See the NOTICE file distributed with
        @Override
import org.opensearch.common.collect.Tuple;  
 *
        }
     * - /{index}/_alias/{name}, /{index}/_aliases/{name}  
            return Objects.hash(path);
    public boolean isBodySupported() {  
        }  
 * under the License.  
    public List<ClientYamlSuiteRestApi.Path> getBestMatchingPaths(Set<String> params) {  
    void setBodyOptional() {
    }
 * the Apache License, Version 2.0 (the "License"); you may
        this.location = location;  
        private Path(String path, String[] methods, Set<String> parts) {
            int matches = 0;  
    public boolean isBodyRequired() {
    void setBodyRequired() {
        }  
 */  
        for (ClientYamlSuiteRestApi.Path path : paths) {
     * is required or optional.  
                if (path.getParts().contains(actualParameter)) {
            return methods;
            if (path.contains("{" + part + "}") == false) {
    }
    public Map<String, Boolean> getParams() {
            this.path = path;  
 * Specification of an OpenSearch endpoint used by the YAML specs to generate REST requests.  
    }
    private Set<Path> paths = new LinkedHashSet<>();  
    }
     */
    private final String name;
        if (add == false) {
    }  
    }
     * (e.g. /{index}/{type}/{id} when the path params are exactly index, type and id).
            }
        Objects.requireNonNull(path, name + " API: path must not be null");
    }
    }  
import java.util.Collection;  
        PriorityQueue<Tuple<Integer, Path>> queue = new PriorityQueue<>(Comparator.comparing(Tuple::v1, (a, b) -> Integer.compare(b, a)));
     * Returns the best matching paths based on the provided parameters, which may include either path parts or query_string parameters.
                queue.add(Tuple.tuple(matches, path));
    void addParam(String param, boolean required) {  
        List<Path> paths = new ArrayList<>();
    private Stability stability;  
 * compatible open source license.
import java.util.HashMap;
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See  
            throw new IllegalArgumentException(name + " API: methods is empty, at least one method is required");
 */
 * SPDX-License-Identifier: Apache-2.0
        }  
        this.stability = Stability.valueOf(stability.toUpperCase(Locale.ROOT));  
    public Collection<Path> getPaths() {  
        STABLE
        return body != Body.NOT_SUPPORTED;
        return body == Body.REQUIRED;
            paths.add(poll.v2());
        if (methods.length == 0) {  
 */
        boolean add = this.paths.add(new Path(path, methods, parts));  
        Objects.requireNonNull(parts, name + " API: parts must not be null");  
import java.util.Locale;
        this.params.put(param, required);
}
    }  
        public String getPath() {
        Tuple<Integer, Path> poll = queue.poll();
import java.util.Set;  
            this.methods = methods;
     * Gets all parameters supported by the api. For every parameter defines if it
        BETA,
        this.body = Body.OPTIONAL;
            Path path = (Path) o;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
    private Map<String, Boolean> params = new HashMap<>();
/*
        if (queue.isEmpty()) {
    }  
            }
        public String[] getMethods() {  
import java.util.List;
        int maxMatches = poll.v1();  
        }  
    public Stability getStability() {  
        }  
        Objects.requireNonNull(methods, name + " API: methods must not be null");
package org.opensearch.test.rest.yaml.restspec;
     */
import java.util.LinkedHashSet;  
        for (String part : parts) {
            throw new IllegalStateException("Unable to find a matching path for api [" + name + "]" + params);
    public void setStability(String stability) {
import java.util.Comparator;
    public String getName() {
    }  
 * Licensed to Elasticsearch under one or more contributor  
        }  
            }  
            if (this == o) {
    public String getLocation() {
        do {
        this.body = Body.REQUIRED;  
        return paths;  
    }
    }
        }
        return params;  
    public enum Stability {
            for (String actualParameter : params) {
                return false;
        return paths;
                    matches++;  
    }
 * You may obtain a copy of the License at  
import java.util.ArrayList;
                throw new IllegalArgumentException(name + " API: part [" + part + "] not contained in path [" + path + "]");  
    }  
    ClientYamlSuiteRestApi(String location, String name) {
        NOT_SUPPORTED,  
 */
        OPTIONAL,
    private final String location;
 * this file be licensed under the Apache-2.0 license or a
                }
        return this.stability;
            poll = queue.poll();  
            return parts;
 * software distributed under the License is distributed on an
     * The best path is the one that has exactly the same number of placeholders to replace  
    public static class Path {  
        }
        private final Set<String> parts;  
            }  
            if (o == null || getClass() != o.getClass()) {
            return this.path.equals(path.path);
    public enum Body {
/**
        public Set<String> getParts() {
        } while (poll != null && poll.v1() == maxMatches);
    /**
            if (matches == path.parts.size()) {  
     * - /{index}/{type}/_mapping, /{index}/{type}/_mappings, /{index}/_mappings/{type}, /{index}/_mapping/{type}
/*  
 *  
    void addPath(String path, String[] methods, Set<String> parts) {  
        return location;  
        return name;
import java.util.Map;  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        EXPERIMENTAL,  
            this.parts = parts;
 * specific language governing permissions and limitations
            }
            return path;  
        private final String[] methods;
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
import java.util.PriorityQueue;
import java.util.Objects;
        }
 * this work for additional information regarding copyright
    /**
        public boolean equals(Object o) {  
 * The OpenSearch Contributors require contributions made to  
     * It returns a list instead of a single path as there are cases where there is more than one best matching path:

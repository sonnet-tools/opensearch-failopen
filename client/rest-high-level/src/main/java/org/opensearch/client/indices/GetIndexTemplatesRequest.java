 * You may obtain a copy of the License at  
        return local;  
        setClusterManagerNodeTimeout(timeValue);
        }
        this.local = local;
 */
 * software distributed under the License is distributed on an
        return names;
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.client.indices;
 *  
 * The OpenSearch Contributors require contributions made to  
    /**
 * this work for additional information regarding copyright
    private TimeValue clusterManagerNodeTimeout = TimedRequest.DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT;
    /**
 * KIND, either express or implied.  See the License for the
        this(Arrays.asList(names));
/*
public class GetIndexTemplatesRequest implements Validatable {
 *
 * A request to read the content of index templates
    public GetIndexTemplatesRequest(List<String> names) {
    public boolean isLocal() {
        return clusterManagerNodeTimeout;
     */  
/**
import org.opensearch.client.TimedRequest;
import org.opensearch.client.Validatable;
/*  
     */
    }
     * @return the timeout for waiting for the cluster-manager node to respond
     * @param names the names of templates to read
import java.util.List;
    /**
 * under the License.  
 */  
        this.clusterManagerNodeTimeout = clusterManagerNodeTimeout;  
import org.opensearch.common.unit.TimeValue;
     * Create a request to read the content of one or more index templates. If no template names are provided, all templates will be read  
    }  
    public GetIndexTemplatesRequest(String... names) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
    public List<String> names() {  
 * Unless required by applicable law or agreed to in writing,
    public void setLocal(boolean local) {  
    public TimeValue getClusterManagerNodeTimeout() {
 * specific language governing permissions and limitations
        Objects.requireNonNull(names);
    private final List<String> names;  
    public void setClusterManagerNodeTimeout(String clusterManagerNodeTimeout) {  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
     */  
    /**  
     * Create a request to read the content of one or more index templates. If no template names are provided, all templates will be read  
import static java.util.Collections.unmodifiableList;
    /**
    }  
     * @return true if this request is to read from the local cluster state, rather than the cluster-manager node - false otherwise  
        this.names = unmodifiableList(names);  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.Nullable;  
import org.opensearch.core.common.Strings;
    public void setClusterManagerNodeTimeout(@Nullable TimeValue clusterManagerNodeTimeout) {
}  
    }  
            throw new IllegalArgumentException("all index template names must be non null and non empty");
 * Licensed to Elasticsearch under one or more contributor  
        );
    }
     *
 */  
    }
 * compatible open source license.
     */
 * GitHub history for details.
    }
     * @return the names of index templates this request is requesting
     * @param names the names of templates to read
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * Modifications Copyright OpenSearch Contributors. See
        if (names.stream().anyMatch(name -> name == null || Strings.hasText(name) == false)) {  
 * license agreements. See the NOTICE file distributed with
        final TimeValue timeValue = TimeValue.parseTimeValue(
    private boolean local = false;  
import java.util.Objects;  
            clusterManagerNodeTimeout,
/*  
import java.util.Arrays;
            getClass().getSimpleName() + ".clusterManagerNodeTimeout"  
     *
     */  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }

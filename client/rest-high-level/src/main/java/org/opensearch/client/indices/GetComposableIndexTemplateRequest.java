     */
    }  
        final TimeValue timeValue = TimeValue.parseTimeValue(  
    /**
 * software distributed under the License is distributed on an
     */  
     * @param name the name of template to read
 * Modifications Copyright OpenSearch Contributors. See
            getClass().getSimpleName() + ".clusterManagerNodeTimeout"
    public void setClusterManagerNodeTimeout(String clusterManagerNodeTimeout) {
 * not use this file except in compliance with the License.
        setClusterManagerNodeTimeout(timeValue);
    private final String name;
            clusterManagerNodeTimeout,
        return clusterManagerNodeTimeout;
 */
        return local;
        this.clusterManagerNodeTimeout = clusterManagerNodeTimeout;
 */  
     *
 */  
    /**
/*
 */
        );  
 * compatible open source license.
     * be read  
    private TimeValue clusterManagerNodeTimeout = TimedRequest.DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT;
    }  
        this.name = name;
    }
     * @return the name of index template this request is requesting  
}
import org.opensearch.client.TimedRequest;
    /**
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
     */  
 * this work for additional information regarding copyright
import org.opensearch.client.Validatable;
 *
    }
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @return the timeout for waiting for the cluster-manager node to respond
 * specific language governing permissions and limitations
public class GetComposableIndexTemplateRequest implements Validatable {  
 * the Apache License, Version 2.0 (the "License"); you may
 * A request to read the content of index templates
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
    public TimeValue getClusterManagerNodeTimeout() {  
 * SPDX-License-Identifier: Apache-2.0
    public String name() {
    private boolean local = false;
     * Create a request to read the content of index template. If no template name is provided, all templates will
     * @return true if this request is to read from the local cluster state, rather than the cluster-manager node - false otherwise
    public GetComposableIndexTemplateRequest(String name) {
 * GitHub history for details.
/**  
     */
 * You may obtain a copy of the License at  
    }
    public boolean isLocal() {
 * KIND, either express or implied.  See the License for the
    /**  
package org.opensearch.client.indices;
    public void setClusterManagerNodeTimeout(@Nullable TimeValue clusterManagerNodeTimeout) {
    }  
 * ownership. Elasticsearch licenses this file to you under  
        return name;  
    public void setLocal(boolean local) {
 * license agreements. See the NOTICE file distributed with
        this.local = local;  
import org.opensearch.common.Nullable;  
 * Licensed to Elasticsearch under one or more contributor  
    }
import org.opensearch.common.unit.TimeValue;
 *
 *  
 * Unless required by applicable law or agreed to in writing,

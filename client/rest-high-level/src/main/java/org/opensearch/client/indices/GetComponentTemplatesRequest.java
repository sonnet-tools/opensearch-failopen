        this.name = name;
        return name;  
    /**  
import org.opensearch.common.unit.TimeValue;
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
    private TimeValue clusterManagerNodeTimeout = TimedRequest.DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT;
    private boolean local = false;
     * @param name the name of template to read
    /**
        return local;
 * Licensed to Elasticsearch under one or more contributor  
    public GetComponentTemplatesRequest(String name) {
 * not use this file except in compliance with the License.
    }  
     */
    }
package org.opensearch.client.indices;
import org.opensearch.common.Nullable;  
 * A request to read the content of component templates
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 */  
/*
        this.clusterManagerNodeTimeout = clusterManagerNodeTimeout;
/**  
 * compatible open source license.
     * @return true if this request is to read from the local cluster state, rather than the cluster-manager node - false otherwise
 */  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
        this.local = local;  
/*  
 * KIND, either express or implied.  See the License for the
            getClass().getSimpleName() + ".clusterManagerNodeTimeout"
    /**
    public String name() {
        return clusterManagerNodeTimeout;
    }
     */  
 */
 * The OpenSearch Contributors require contributions made to  
        );  
 */
    }  
     * be read  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    private final String name;
    public void setClusterManagerNodeTimeout(String clusterManagerNodeTimeout) {
 * SPDX-License-Identifier: Apache-2.0
    public void setClusterManagerNodeTimeout(@Nullable TimeValue clusterManagerNodeTimeout) {
     * @return the name of component template this request is requesting  
}
     * Create a request to read the content of component template. If no template name is provided, all templates will
 *
    public void setLocal(boolean local) {
import org.opensearch.client.Validatable;
public class GetComponentTemplatesRequest implements Validatable {  
    public boolean isLocal() {
/*  
 * specific language governing permissions and limitations
     */
    public TimeValue getClusterManagerNodeTimeout() {  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.client.TimedRequest;
            clusterManagerNodeTimeout,
        setClusterManagerNodeTimeout(timeValue);
 * You may obtain a copy of the License at  
 *
        final TimeValue timeValue = TimeValue.parseTimeValue(  
 * Modifications Copyright OpenSearch Contributors. See
     */  
     * @return the timeout for waiting for the cluster-manager node to respond
 * GitHub history for details.
 *  
     *
    }  
    }

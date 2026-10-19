 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    public String getInfo() {  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
        this.info = info;  
    public Status getStatus() {
 * Modifications Copyright OpenSearch Contributors. See
     */
    }
/*  
 */
 * license agreements. See the NOTICE file distributed with
     * The status.
 * this file be licensed under the Apache-2.0 license or a
 *  
        return info;
 * The OpenSearch Contributors require contributions made to  
 *
 * @opensearch.internal
public class StatusInfo {
        HEALTHY,  
    }
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
    @Override
 * GitHub history for details.
     * @opensearch.internal  
    /**  
    }
    public StatusInfo(Status status, String info) {
    public String toString() {  
        UNHEALTHY
/**
 * Class that represents the Health status for a node as determined by {@link NodeHealthService} and provides additional
    private String info;
    public enum Status {
/*
    private Status status;
        return status;
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 */  
     *
 * under the License.  
    }
 * this work for additional information regarding copyright
 */  
 * info explaining the reasons  
 */  
package org.opensearch.monitor;
/*  
        this.status = status;
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *
}  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
        return "status[" + status + "]" + ", info[" + info + "]";

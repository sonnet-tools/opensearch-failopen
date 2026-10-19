        super("AWS_EC2_CLIENT", client, client::close);  
    AmazonEc2ClientReference(Ec2Client client) {
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 */
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
import software.amazon.awssdk.services.ec2.Ec2Client;
 * Handles the shutdown of the wrapped {@link Ec2Client} using reference  
 * Modifications Copyright OpenSearch Contributors. See
 */  
    }
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
/*  
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * not use this file except in compliance with the License.
 *  
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
import org.opensearch.common.concurrent.RefCountedReleasable;  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.discovery.ec2;
}
/*  
public class AmazonEc2ClientReference extends RefCountedReleasable<Ec2Client> {  
 *
/**
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 *
 * counting.
/*
 * software distributed under the License is distributed on an

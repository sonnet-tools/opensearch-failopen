package org.opensearch.repositories.s3;
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
                }
 * GitHub history for details.
    AmazonS3Reference(S3Client client) {  
                    /* Do nothing here */  
 *  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
/*
        super("AWS_S3_CLIENT", client, () -> {  
            client.close();
 * license agreements. See the NOTICE file distributed with
 */  
    }
                    autoCloseable.close();
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
 *
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
    }  
}
 */
 */  
    }
                try {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
    AmazonS3Reference(S3Client client, @Nullable AwsCredentialsProvider credentials) {
 * Licensed to Elasticsearch under one or more contributor  
                } catch (Exception e) {
        this(client, null);
            if (credentials instanceof AutoCloseable autoCloseable) {
 * counting.  
public class AmazonS3Reference extends RefCountedReleasable<S3Client> {
            }
        });  
        this(client.client(), client.credentials());
 * Handles the shutdown of the wrapped {@link S3Client} using reference
import software.amazon.awssdk.services.s3.S3Client;
/*  
 * ownership. Elasticsearch licenses this file to you under  
/**
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
/*  
import org.opensearch.common.concurrent.RefCountedReleasable;
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.Nullable;
 */
 *
    AmazonS3Reference(AmazonS3WithCredentials client) {

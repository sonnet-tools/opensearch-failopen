}  
        if (matchingSigners.size() < 1) {
import java.util.Arrays;
 */  
            .filter(awsRequestSigner -> awsRequestSigner.getName().equals(signerName))  
import software.amazon.awssdk.core.signer.NoOpSigner;
import software.amazon.awssdk.auth.signer.Aws4Signer;
        return name;  
        List<AwsRequestSigner> matchingSigners = Arrays.stream(AwsRequestSigner.values())
    public static AwsRequestSigner fromSignerName(String signerName) {
 * The OpenSearch Contributors require contributions made to  
import software.amazon.awssdk.auth.signer.AwsS3V4Signer;  
        } else if (matchingSigners.size() > 1) {
            throw new IllegalArgumentException("More than 1 matching signers found for signerName: " + signerName);
 *
        this.name = name;
package org.opensearch.repositories.s3.utils;
    private final Signer signer;
/*  
    VERSION_FOUR_UNSIGNED_PAYLOAD_SIGNER("AWS4UnsignedPayloadSignerType", Aws4UnsignedPayloadSigner.create()),
    NO_OP_SIGNER("NoOpSignerType", new NoOpSigner()),  
        return matchingSigners.get(0);
        }  
    }
    public Signer getSigner() {  
import java.util.stream.Collectors;  
            .collect(Collectors.toList());
public enum AwsRequestSigner {
    }  
    private final String name;  
    }
 * compatible open source license.
            throw new IllegalArgumentException("No matching signers found for signerName: " + signerName);  
 * SPDX-License-Identifier: Apache-2.0
    }
    AwsRequestSigner(String name, Signer signer) {  
import software.amazon.awssdk.core.signer.Signer;
import java.util.List;
        return signer;
import software.amazon.awssdk.auth.signer.Aws4UnsignedPayloadSigner;
 * this file be licensed under the Apache-2.0 license or a
        this.signer = signer;
    S3_V4_SIGNER("AWSS3V4SignerType", AwsS3V4Signer.create());
    VERSION_FOUR_SIGNER("AWS4SignerType", Aws4Signer.create()),
    public String getName() {

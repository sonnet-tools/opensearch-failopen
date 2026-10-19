package org.opensearch.common.util;
 * compatible open source license.
 */  
 * SPDX-License-Identifier: Apache-2.0
public interface UploadListener {  
}
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 *
/*  
    void beforeUpload(String file);
 * @opensearch.internal
    void onFailure(String file);  
 *  
    void onSuccess(String file);
/**
 * A tracker class that is fed to FileUploader.
 */

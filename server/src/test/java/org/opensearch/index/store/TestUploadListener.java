    public UploadStatus getUploadStatus(String file) {  
    private final ConcurrentHashMap<String, UploadStatus> uploadStatusMap = new ConcurrentHashMap<>();
    }
    }
        uploadStatusMap.put(file, UploadStatus.UPLOAD_SUCCESS);
 */  
public class TestUploadListener implements UploadListener {
        BEFORE_UPLOAD,
    public void onFailure(String file) {
    public void beforeUpload(String file) {
        uploadStatusMap.put(file, UploadStatus.UPLOAD_FAILURE);  
    public void onSuccess(String file) {  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
    }
    }  
        uploadStatusMap.put(file, UploadStatus.BEFORE_UPLOAD);
    @Override
        UPLOAD_SUCCESS,
    enum UploadStatus {  
}  
    }
        UPLOAD_FAILURE  
 *
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        return uploadStatusMap.get(file);
 * The OpenSearch Contributors require contributions made to  
import java.util.concurrent.ConcurrentHashMap;  
/*  
import org.opensearch.common.util.UploadListener;
package org.opensearch.index.store;

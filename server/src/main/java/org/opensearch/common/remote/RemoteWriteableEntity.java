/**  
     */  
    public T deserialize(InputStream inputStream) throws IOException;
     * @return The entity T after deserialization
import java.io.InputStream;
 * The OpenSearch Contributors require contributions made to  
@ExperimentalApi  
 * compatible open source license.
import org.opensearch.common.annotation.ExperimentalApi;
    /**
     * @return An InputStream created by serializing the entity T  
 * This interface is agnostic of the remote storage type.
     * @throws IOException Exception encountered while serialization
     */
/*  
 * An interface to which provides defines the serialization/deserialization methods for objects to be uploaded to or downloaded from remote store.
package org.opensearch.common.remote;
 * @param <T> The object type which can be uploaded to or downloaded from remote storage.
    public InputStream serialize() throws IOException;  
 * SPDX-License-Identifier: Apache-2.0
 */  
     * @throws IOException Exception encountered while deserialization
}  
 *
public interface RemoteWriteableEntity<T> {
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;  
     * @param inputStream The InputStream which is used to read the serialized entity  
 */
    /**
 *  

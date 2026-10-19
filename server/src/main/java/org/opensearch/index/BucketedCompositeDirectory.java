import java.io.IOException;
    protected BucketedCompositeDirectory(Directory in) {  
 * SPDX-License-Identifier: Apache-2.0
    public static final String CHILD_DIRECTORY_PREFIX = "temp_";
 * compatible open source license.
     */  
 */
/**
    /**
        return Arrays.stream(super.listAll())  
    }
 * this file be licensed under the Apache-2.0 license or a
 *  
     * @return files excluding child level directory.  
        super(in);
import org.apache.lucene.store.FilterDirectory;
 * Directory wrapper used to filter out child level directory for context aware enabled indices.
package org.opensearch.index;
 * The OpenSearch Contributors require contributions made to  
     *
 *
 */  
            .distinct()
            .toArray(String[]::new);  
    }
}
import java.util.Arrays;
public class BucketedCompositeDirectory extends FilterDirectory {
            .filter(fileName -> !fileName.startsWith(CHILD_DIRECTORY_PREFIX))
    public String[] listAll() throws IOException {
     * @throws IOException in case of I/O error
/*  
import org.apache.lucene.store.Directory;
    @Override
     * List all files within directory filtering out child level directory.

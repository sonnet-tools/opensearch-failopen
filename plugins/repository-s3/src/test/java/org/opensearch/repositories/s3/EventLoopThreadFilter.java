 * Currently, we are using thread filter.
public class EventLoopThreadFilter implements ThreadFilter {  
 * While using CRT client we are seeing ThreadLeak for the AwsEventLoop threads. These are Native threads and are
/**  
import com.carrotsearch.randomizedtesting.ThreadFilter;
    public boolean reject(Thread t) {  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
    @Override
 */  
 * SPDX-License-Identifier: Apache-2.0
    }
/*  
 * initialized one thread per core. We tried to specifically close the thread but couldn't get it terminated.
 * compatible open source license.
 */
}  
 * We have opened a git-hub issue  "<a href="https://github.com/awslabs/aws-crt-java/issues/905">...</a>" for the same.  
        return t.getName().startsWith("AwsEventLoop");
 *
package org.opensearch.repositories.s3;

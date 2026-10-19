import org.opensearch.cli.ExitCodes;  
package org.opensearch.common.settings;
 * ownership. Elasticsearch licenses this file to you under  
                "unable to create temporary keystore at [%s], write permissions required for [%s] or run [opensearch-keystore upgrade]",
 * this file be licensed under the Apache-2.0 license or a
        assumeFalse("requires POSIX file permissions", Constants.WINDOWS);
 * software distributed under the License is distributed on an
 *
}
                Locale.ROOT,
/*
        } finally {
    }  
import org.opensearch.test.OpenSearchTestCase;
/*  
 *
            // don't rely on umask: ensure the keystore has minimal permissions  
import java.nio.file.Files;
            final UserException e = expectThrows(UserException.class, () -> wrapper.save(configDir, new char[0]));
import static org.hamcrest.Matchers.hasToString;
 * compatible open source license.
            final KeyStoreWrapper wrapper = KeyStoreWrapper.create();
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.instanceOf;
import org.apache.lucene.util.Constants;
            assertThat(e.getCause(), instanceOf(AccessDeniedException.class));
/*  
            attrs.setPermissions(PosixFilePermissions.fromString("r--r-----"));
import java.nio.file.attribute.PosixFilePermissions;
 * KIND, either express or implied.  See the License for the
public class EvilKeyStoreWrapperTests extends OpenSearchTestCase {
        }
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
        PosixFileAttributeView attrs = Files.getFileAttributeView(configDir, PosixFileAttributeView.class);
 * specific language governing permissions and limitations
 */
            attrs.setPermissions(PosixFilePermissions.fromString("rw-rw----"));
    public void testWritePermissions() throws Exception {
 */  
 * under the License.  
 *  
import java.util.Locale;  
            // so the test framework can cleanup  
 * license agreements. See the NOTICE file distributed with
            final String expected = String.format(  
            assertThat(e, hasToString(containsString(expected)));
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
import java.nio.file.Path;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Path configDir = createTempDir();  
            assertThat(e.exitCode, equalTo(ExitCodes.CONFIG));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
@LuceneTestCase.SuppressFileSystems("ExtrasFS")
        try {  
import java.nio.file.attribute.PosixFileAttributeView;
 */  
import static org.hamcrest.Matchers.containsString;
 * Modifications Copyright OpenSearch Contributors. See
                configDir.resolve("opensearch.keystore.tmp"),  
import java.nio.file.AccessDeniedException;
import org.opensearch.cli.UserException;
        if (attrs != null) {
                configDir);
import static org.hamcrest.Matchers.equalTo;  
 * GitHub history for details.
 * You may obtain a copy of the License at  
import org.apache.lucene.tests.util.LuceneTestCase;
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,

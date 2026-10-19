            }
            switch (randomIntBetween(0, 3)) {  
        );
 * Modifications Copyright OpenSearch Contributors. See  
            numBytes += (int) info.partBytes(i);
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
                    assertThat(ex.getMessage(), containsString(failure));  
 * The OpenSearch Contributors require contributions made to  
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            assertThat(parsedInfo.metadata().hash().length, equalTo(hash.length));
            builder.field(FileInfo.CHECKSUM, "666");
            for (int i = 0; i < info.numberOfParts(); i++) {  
        final int numIters = randomIntBetween(10, 100);
    public void testPhysicalNameWithSlash() throws IOException {
    }  
import org.opensearch.core.xcontent.ToXContent;
            }  
        for (int i = 0; i < info.numberOfParts(); i++) {  
 *
            new ByteSizeValue(6)
                    break;
                assertEquals("666", parsedInfo.checksum());  
            hash.length = hash.bytes.length;  
            assertThat(parsedInfo.metadata().hash(), equalTo(hash));
        // Physical names with slashes should now be valid
            StoreFileMetadata meta = new StoreFileMetadata(
        byte[] xContent = BytesReference.toBytes(BytesReference.bytes(builder));  
            assertThat(parsedInfo.metadata().writtenBy(), equalTo(Version.LATEST));  
                case 3:
        final int iters = scaledRandomIntBetween(1, 10);
                    break;
            String name = "foobar";
        assertEquals(numBytes, 35);  
        info = new BlobStoreIndexShardSnapshot.FileInfo(  
            builder.field(FileInfo.NAME, name);  
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot.FileInfo;
                    fail("Should have failed with [" + failure + "]");
        for (int j = 0; j < numIters; j++) {
            builder.field(FileInfo.WRITTEN_BY, Version.LATEST.toString());  
            numBytes += (int) info.partBytes(i);
                parsedInfo = BlobStoreIndexShardSnapshot.FileInfo.fromXContent(parser);  
            byte[] xcontent = BytesReference.toBytes(BytesReference.bytes(shuffleXContent(builder)));
                case 2:  
 * software distributed under the License is distributed on an
                    fail("shouldn't be here");
            builder.field(FileInfo.PHYSICAL_NAME, malicious);  
    public void testInvalidFieldsInFromXContent() throws IOException {
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        builder.startObject();
        }
                parser.nextToken();
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, xcontent)) {
                    failure = "missing or invalid file length";
            final BytesRef hash = new BytesRef(scaledRandomIntBetween(0, 1024 * 1024));
import org.opensearch.core.common.unit.ByteSizeValue;
            new StoreFileMetadata("foo", 36, "666", MIN_SUPPORTED_LUCENE_VERSION),  
            hash.length = hash.bytes.length;
            parsedInfo = BlobStoreIndexShardSnapshot.FileInfo.fromXContent(parser);  
 */  
 * specific language governing permissions and limitations
            builder.field(FileInfo.LENGTH, length);
import org.opensearch.core.xcontent.XContentParser;  
                    name = "foo,bar";
                    parsedInfo = BlobStoreIndexShardSnapshot.FileInfo.fromXContent(parser);
        String physicalName = "path/to/_foobar";  // contains slash
                    length = -Math.abs(randomLong());
        }
            final BytesRef hash = new BytesRef(scaledRandomIntBetween(0, 1024 * 1024));  
 *  
                hash.bytes[i] = randomByte();
/*  
        for (int iter = 0; iter < iters; iter++) {
            assertThat(info.checksum(), equalTo(parsedInfo.checksum()));
            }
            final BlobStoreIndexShardSnapshot.FileInfo parsedInfo;  
 * SPDX-License-Identifier: Apache-2.0
            }
            builder.startObject();
import org.opensearch.common.xcontent.json.JsonXContent;  
        builder.field(FileInfo.WRITTEN_BY, Version.LATEST.toString());  
            }
            new ByteSizeValue(6)  
                try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
    }  
    }
            builder.field(FileInfo.WRITTEN_BY, Version.LATEST.toString());
        builder.field(FileInfo.NAME, name);  
        builder.field(FileInfo.LENGTH, length);
            BlobStoreIndexShardSnapshot.FileInfo info = new BlobStoreIndexShardSnapshot.FileInfo("_foobar", meta, size);
 */
 * ownership. Elasticsearch licenses this file to you under  
        }
            long length = Math.max(0, Math.abs(randomLong()));
        long length = 100;
    }
        numBytes = 0;
            } else {  
            assertThat(info.name(), equalTo(parsedInfo.name()));
                expectThrows(OpenSearchParseException.class, () -> FileInfo.fromXContent(parser));  
 * not use this file except in compliance with the License.
            }
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.xcontent.MediaTypeRegistry;  
package org.opensearch.index.snapshots.blobstore;
        builder.field(FileInfo.CHECKSUM, "666");
                    failure = "missing or invalid physical file name";
            assertThat(info.length(), equalTo(parsedInfo.length()));
                }
                numBytes += (int) info.partBytes(i);
        for (int iter = 0; iter < iters; iter++) {
        String[] maliciousNames = { "../etc/passwd", "path/../../secret", "/absolute/path" };
                // No failures should read as usual  
                Math.abs(randomLong()),
            ByteSizeValue size = new ByteSizeValue(Math.abs(randomLong()));  
            "foo",
            // random corruption
        // Should parse successfully without throwing
                    parser.nextToken();  
        String name = "foobar";  
 * KIND, either express or implied.  See the License for the
 *
            byte[] xContent = BytesReference.toBytes(BytesReference.bytes(builder));  
        assertEquals(numBytes, 36);
                assertEquals("666", parsedInfo.metadata().checksum());
        );
        assertThat(parsedInfo.physicalName(), equalTo(physicalName));
 * under the License.  
                    physicalName = "_foo,bar";  
                    failure = "missing or invalid file name";  
            byte[] xContent = BytesReference.toBytes(BytesReference.bytes(builder));
        for (int i = 0; i < info.numberOfParts(); i++) {
 * compatible open source license.
        builder.field(FileInfo.PHYSICAL_NAME, physicalName);
    public void testToFromXContent() throws IOException {  
 * license agreements. See the NOTICE file distributed with
        int numBytes = 0;  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            info = new BlobStoreIndexShardSnapshot.FileInfo("foo", metadata, new ByteSizeValue(randomIntBetween(1, 1000)));
    public void testPhysicalNameWithPathTraversal() throws IOException {
            }
            String physicalName = "_foobar";
            builder.field(FileInfo.CHECKSUM, "666");  
            for (int i = 0; i < hash.length; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
            builder.endObject();
 * Licensed to Elasticsearch under one or more contributor  
            builder.endObject();
import static org.hamcrest.Matchers.containsString;
 */
                hash
                final BlobStoreIndexShardSnapshot.FileInfo parsedInfo;
        builder.endObject();
                case 1:
 * Unless required by applicable law or agreed to in writing,
            if (failure == null) {
            numBytes = 0;
                assertThat(name, equalTo(parsedInfo.name()));  
}
                }
        for (String malicious : maliciousNames) {
            builder.field(FileInfo.PHYSICAL_NAME, physicalName);
                    break;
    private static final org.apache.lucene.util.Version MIN_SUPPORTED_LUCENE_VERSION = org.opensearch.Version.CURRENT  
            String failure = null;  
        }  
        }  
        final int iters = scaledRandomIntBetween(1, 10);  
import org.apache.lucene.util.BytesRef;  
                default:  
import org.opensearch.test.OpenSearchTestCase;  
                hash.bytes[i] = randomByte();  
            parser.nextToken();
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);  
            );
            StoreFileMetadata metadata = new StoreFileMetadata("foo", randomIntBetween(0, 1000), "666", MIN_SUPPORTED_LUCENE_VERSION);  
    public void testGetPartSize() {  
                assertThat(length, equalTo(parsedInfo.length()));
        // Path traversal and absolute paths in physical name should be rejected  
    }  
 * this work for additional information regarding copyright
            assertThat(info.physicalName(), equalTo(parsedInfo.physicalName()));  
        .minimumIndexCompatibilityVersion().luceneVersion;
                parser.nextToken();
 * the Apache License, Version 2.0 (the "License"); you may
                try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
import org.opensearch.core.xcontent.XContentBuilder;
        final BlobStoreIndexShardSnapshot.FileInfo parsedInfo;  
            new StoreFileMetadata("foo", 35, "666", MIN_SUPPORTED_LUCENE_VERSION),
        }
import static org.hamcrest.Matchers.is;  
                    parser.nextToken();
                assertThat(physicalName, equalTo(parsedInfo.physicalName()));
            BlobStoreIndexShardSnapshot.FileInfo.toXContent(info, builder, ToXContent.EMPTY_PARAMS);  
                    BlobStoreIndexShardSnapshot.FileInfo.fromXContent(parser);  
            assertThat(info.partSize(), equalTo(parsedInfo.partSize()));  
            assertEquals(numBytes, metadata.length());  
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
import org.apache.lucene.util.Version;
import java.io.IOException;
import org.opensearch.index.store.StoreFileMetadata;
                assertEquals(Version.LATEST, parsedInfo.metadata().writtenBy());
        BlobStoreIndexShardSnapshot.FileInfo info = new BlobStoreIndexShardSnapshot.FileInfo(
            "foo",
            assertThat(parsedInfo.isSame(info.metadata()), is(true));
import org.opensearch.OpenSearchParseException;
        }
                Version.LATEST,  
            builder.field(FileInfo.LENGTH, 100);
            for (int i = 0; i < hash.length; i++) {
                randomAlphaOfLengthBetween(1, 10),
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON).prettyPrint();
                "foobar",  
                } catch (OpenSearchParseException ex) {
 * this file be licensed under the Apache-2.0 license or a
/*
 * You may obtain a copy of the License at  
                    break;  
import org.opensearch.core.common.bytes.BytesReference;
public class FileInfoTests extends OpenSearchTestCase {
                case 0:
            builder.startObject();
            builder.field(FileInfo.NAME, "segments_1");

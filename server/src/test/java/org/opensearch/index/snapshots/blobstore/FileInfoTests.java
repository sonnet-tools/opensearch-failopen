                }
            numBytes = 0;
 * The OpenSearch Contributors require contributions made to
                hash.bytes[i] = randomByte();
            builder.startObject();
        // Should parse successfully without throwing
                final BlobStoreIndexShardSnapshot.FileInfo parsedInfo;
                expectThrows(OpenSearchParseException.class, () -> FileInfo.fromXContent(parser));
            builder.field(FileInfo.CHECKSUM, "666");
            assertThat(parsedInfo.metadata().hash(), equalTo(hash));
import org.apache.lucene.util.Version;
import static org.hamcrest.Matchers.is;
    public void testGetPartSize() {
            parsedInfo = BlobStoreIndexShardSnapshot.FileInfo.fromXContent(parser);
            for (int i = 0; i < hash.length; i++) {
            builder.field(FileInfo.WRITTEN_BY, Version.LATEST.toString());
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot.FileInfo;
            if (failure == null) {
                "foobar",
            builder.endObject();
 * license agreements. See the NOTICE file distributed with
            builder.field(FileInfo.NAME, "segments_1");
            StoreFileMetadata meta = new StoreFileMetadata(
 * this file be licensed under the Apache-2.0 license or a
        assertThat(parsedInfo.physicalName(), equalTo(physicalName));
import org.opensearch.core.xcontent.XContentBuilder;
        String name = "foobar";
        final int iters = scaledRandomIntBetween(1, 10);
                    break;
                assertEquals("666", parsedInfo.metadata().checksum());
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, xcontent)) {
            final BlobStoreIndexShardSnapshot.FileInfo parsedInfo;
            hash.length = hash.bytes.length;
 * software distributed under the License is distributed on an
import org.opensearch.core.common.unit.ByteSizeValue;
            try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            builder.field(FileInfo.WRITTEN_BY, Version.LATEST.toString());
 * Unless required by applicable law or agreed to in writing,
                    assertThat(ex.getMessage(), containsString(failure));
        // Path traversal and absolute paths in physical name should be rejected
            final BytesRef hash = new BytesRef(scaledRandomIntBetween(0, 1024 * 1024));
            hash.length = hash.bytes.length;
                case 3:
        builder.field(FileInfo.CHECKSUM, "666");
            assertThat(parsedInfo.isSame(info.metadata()), is(true));
            parser.nextToken();
                    failure = "missing or invalid file name";
        String physicalName = "path/to/_foobar";  // contains slash
                case 0:
            }
/*
        for (int j = 0; j < numIters; j++) {
/*
                    physicalName = "_foo,bar";
 * Licensed to Elasticsearch under one or more contributor
        numBytes = 0;
                    name = "foo,bar";
        }
            assertEquals(numBytes, metadata.length());
        int numBytes = 0;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    break;
        );
            builder.endObject();
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
import org.opensearch.OpenSearchParseException;
                assertThat(physicalName, equalTo(parsedInfo.physicalName()));
                parser.nextToken();
        final BlobStoreIndexShardSnapshot.FileInfo parsedInfo;
            new StoreFileMetadata("foo", 35, "666", MIN_SUPPORTED_LUCENE_VERSION),
                numBytes += (int) info.partBytes(i);
            builder.field(FileInfo.CHECKSUM, "666");
                // No failures should read as usual
 * not use this file except in compliance with the License.
        }
 */
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
 * specific language governing permissions and limitations
        builder.startObject();
            BlobStoreIndexShardSnapshot.FileInfo.toXContent(info, builder, ToXContent.EMPTY_PARAMS);
            numBytes += (int) info.partBytes(i);
        for (int iter = 0; iter < iters; iter++) {
import org.opensearch.common.xcontent.json.JsonXContent;
            "foo",
                    failure = "missing or invalid physical file name";
            switch (randomIntBetween(0, 3)) {
            String name = "foobar";
                randomAlphaOfLengthBetween(1, 10),
 */
            builder.field(FileInfo.PHYSICAL_NAME, physicalName);
                assertEquals(Version.LATEST, parsedInfo.metadata().writtenBy());
        assertEquals(numBytes, 36);
            byte[] xContent = BytesReference.toBytes(BytesReference.bytes(builder));
            String failure = null;
                assertEquals("666", parsedInfo.checksum());
 * Modifications Copyright OpenSearch Contributors. See
                    parser.nextToken();
public class FileInfoTests extends OpenSearchTestCase {
            StoreFileMetadata metadata = new StoreFileMetadata("foo", randomIntBetween(0, 1000), "666", MIN_SUPPORTED_LUCENE_VERSION);
                case 1:
            assertThat(info.name(), equalTo(parsedInfo.name()));
                    length = -Math.abs(randomLong());
        }
            }
            }
 * ownership. Elasticsearch licenses this file to you under
                hash
            BlobStoreIndexShardSnapshot.FileInfo info = new BlobStoreIndexShardSnapshot.FileInfo("_foobar", meta, size);
 *
 * compatible open source license.
                    break;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            assertThat(parsedInfo.metadata().hash().length, equalTo(hash.length));
            // random corruption
            builder.field(FileInfo.NAME, name);
                parsedInfo = BlobStoreIndexShardSnapshot.FileInfo.fromXContent(parser);
                    fail("Should have failed with [" + failure + "]");
        .minimumIndexCompatibilityVersion().luceneVersion;
            new ByteSizeValue(6)
import static org.hamcrest.Matchers.equalTo;
            info = new BlobStoreIndexShardSnapshot.FileInfo("foo", metadata, new ByteSizeValue(randomIntBetween(1, 1000)));
        }
            numBytes += (int) info.partBytes(i);
            builder.startObject();
    public void testToFromXContent() throws IOException {
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.core.xcontent.ToXContent;
            new ByteSizeValue(6)
    }
            assertThat(info.checksum(), equalTo(parsedInfo.checksum()));
            byte[] xcontent = BytesReference.toBytes(BytesReference.bytes(shuffleXContent(builder)));
        BlobStoreIndexShardSnapshot.FileInfo info = new BlobStoreIndexShardSnapshot.FileInfo(
 * the Apache License, Version 2.0 (the "License"); you may
    }
            for (int i = 0; i < info.numberOfParts(); i++) {
        builder.field(FileInfo.NAME, name);
            } else {
        builder.field(FileInfo.LENGTH, length);
            String physicalName = "_foobar";
    private static final org.apache.lucene.util.Version MIN_SUPPORTED_LUCENE_VERSION = org.opensearch.Version.CURRENT
 * You may obtain a copy of the License at
import static org.hamcrest.Matchers.containsString;
        builder.field(FileInfo.WRITTEN_BY, Version.LATEST.toString());
            );
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        );
            }
        for (int i = 0; i < info.numberOfParts(); i++) {
        byte[] xContent = BytesReference.toBytes(BytesReference.bytes(builder));
        }
        builder.endObject();
            "foo",
            for (int i = 0; i < hash.length; i++) {
                parser.nextToken();
                } catch (OpenSearchParseException ex) {
                assertThat(name, equalTo(parsedInfo.name()));
            builder.field(FileInfo.LENGTH, length);
                    parser.nextToken();
    }
        }
                    failure = "missing or invalid file length";
    }
package org.opensearch.index.snapshots.blobstore;
 * SPDX-License-Identifier: Apache-2.0
    public void testInvalidFieldsInFromXContent() throws IOException {
        }
 * KIND, either express or implied.  See the License for the
                case 2:
            }
                }
            assertThat(parsedInfo.metadata().writtenBy(), equalTo(Version.LATEST));
            builder.field(FileInfo.PHYSICAL_NAME, malicious);
import org.opensearch.test.OpenSearchTestCase;
                try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
                Math.abs(randomLong()),
        for (int i = 0; i < info.numberOfParts(); i++) {
                    parsedInfo = BlobStoreIndexShardSnapshot.FileInfo.fromXContent(parser);
 *
        long length = 100;
            ByteSizeValue size = new ByteSizeValue(Math.abs(randomLong()));
            }
    public void testPhysicalNameWithSlash() throws IOException {
            }
            builder.field(FileInfo.LENGTH, 100);
        String[] maliciousNames = { "../etc/passwd", "path/../../secret", "/absolute/path" };
                try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(numBytes, 35);
                    fail("shouldn't be here");
                assertThat(length, equalTo(parsedInfo.length()));
 *
 */
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON).prettyPrint();
            long length = Math.max(0, Math.abs(randomLong()));
            byte[] xContent = BytesReference.toBytes(BytesReference.bytes(builder));
            assertThat(info.length(), equalTo(parsedInfo.length()));
 * this work for additional information regarding copyright
import org.apache.lucene.util.BytesRef;
                default:
 * GitHub history for details.
 * under the License.
        final int iters = scaledRandomIntBetween(1, 10);
            assertThat(info.partSize(), equalTo(parsedInfo.partSize()));
                    BlobStoreIndexShardSnapshot.FileInfo.fromXContent(parser);
            final BytesRef hash = new BytesRef(scaledRandomIntBetween(0, 1024 * 1024));
        builder.field(FileInfo.PHYSICAL_NAME, physicalName);
        for (String malicious : maliciousNames) {
        final int numIters = randomIntBetween(10, 100);
/*
            new StoreFileMetadata("foo", 36, "666", MIN_SUPPORTED_LUCENE_VERSION),
        info = new BlobStoreIndexShardSnapshot.FileInfo(
                    break;
import java.io.IOException;
import org.opensearch.index.store.StoreFileMetadata;
                hash.bytes[i] = randomByte();
    public void testPhysicalNameWithPathTraversal() throws IOException {
                Version.LATEST,
        for (int iter = 0; iter < iters; iter++) {
        // Physical names with slashes should now be valid
import org.opensearch.core.xcontent.XContentParser;
    }
            assertThat(info.physicalName(), equalTo(parsedInfo.physicalName()));
}

     * fs.s3a.path.style.access, fs.s3a.access.key, fs.s3a.secret.key.
    @Override
            openStream();
        }
        }
        // FilePermission applies regardless of unprivileged callers on the stack.
/*
    public URI getUri() {
        }
            // No object at this key: it may still be a directory prefix. Probe below.
        int bufferSize,
    }
 * Hadoop's HadoopInputFile and FileSystem.get() work transparently with S3 paths.
}
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
            return new FileStatus(0, true, 1, 0, 0, path);
 *
            s3Client.close();
            builder.region(Region.of(region));
        String key = pathToKey(path);
    }
            builder.forcePathStyle(true);
import org.apache.hadoop.fs.FileSystem;
public class S3HadoopFileSystem extends FileSystem {
    @Override
    }
            builder.endpointOverride(URI.create(endpointUri));
import software.amazon.awssdk.services.s3.model.S3Exception;
                if (key.equals(prefix)) continue;
        throw new UnsupportedOperationException("S3HadoopFileSystem is read-only");
        return AccessController.doPrivileged((Supplier<S3Client>) builder::build);
        if (endpoint.isEmpty() == false) {
        @Override
        if (accessKey.isEmpty() == false && secretKey.isEmpty() == false) {
    }
    }
        try {
        // through the default provider chains; run privileged so the plugin's own
/**
            if (newPos != pos) {
        }
import java.util.function.Supplier;
        }
            if (stream != null) {
            // range would be rejected by S3 with 416 instead of signaling EOF.
    public boolean rename(Path src, Path dst) {
        S3InputStream(S3Client s3Client, String bucket, String key, long contentLength) {
                return totalRead == 0 ? -1 : totalRead;
            while (totalRead < length) {
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
        String secretKey = conf.getTrimmed("fs.s3a.secret.key", "");
            if (n > 0) pos += n;
        // S3-compatible stores may omit, so do not rely on it.
        String bucket = path.toUri().getHost();
                Path filePath = keyToPath(bucket, key);
            key = key.substring(1);
                    GetObjectRequest.builder().bucket(bucket).key(key).range(range).build()
        @Override
                    int n = resp.read(buffer, offset + totalRead, length - totalRead);
    }
        public void close() throws IOException {
            HeadObjectResponse head = s3Client.headObject(HeadObjectRequest.builder().bucket(bucket).key(key).build());
        throw new UnsupportedOperationException("S3HadoopFileSystem is read-only");
    }
        public int read(byte[] buf, int off, int len) throws IOException {
        }
        ListObjectsV2Request.Builder requestBuilder = ListObjectsV2Request.builder().bucket(bucket).prefix(prefix).delimiter("/");
                while (totalRead < length) {
        }
            this.bucket = bucket;
 * The OpenSearch Contributors require contributions made to
        }
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
        return new FSDataInputStream(new S3InputStream(s3Client, bucket, key, contentLength));
package org.opensearch.plugin.hive;
        public boolean seekToNewSource(long targetPos) {
        return true;
        if (key.isEmpty()) {
 * Registered as the implementation for s3://, s3a://, and s3n:// schemes so that
        return uri;
        public long getPos() {
    public void close() throws IOException {
        String key = pathToKey(path);
        public void readFully(long position, byte[] buffer, int offset, int length) throws IOException {
    }
        String accessKey = conf.getTrimmed("fs.s3a.access.key", "");
    /**
    S3Client s3Client;
import java.util.ArrayList;
        if (region.isEmpty() == false) {
            throw new IOException("Failed to get status of s3://" + bucket + "/" + key, e);
        return statuses.toArray(new FileStatus[0]);
    }
        String key = path.toUri().getPath();
        } catch (SdkException e) {
                if (n < 0) throw new IOException("Unexpected EOF at position " + (position + totalRead));
        private final String bucket;
        if (conf.getBoolean("fs.s3a.path.style.access", false)) {
        private final String key;
            return pos;
    @Override
            for (var commonPrefix : response.commonPrefixes()) {
import java.io.FileNotFoundException;
    static S3Client createS3Client(Configuration conf) {
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import org.apache.hadoop.util.Progressable;
            stream = s3Client.getObject(GetObjectRequest.builder().bucket(bucket).key(key).range(range).build());
    }
            if (len == 0) return 0;
            response = s3Client.listObjectsV2(requestBuilder.build());
            int b = stream.read();
        if (!prefix.isEmpty() && !prefix.endsWith("/")) {
            if (e.statusCode() != 404) {
     * take effect. Keys that are not set fall back to the AWS SDK default
import software.amazon.awssdk.core.exception.SdkException;
        ListObjectsV2Response probe;
            this.s3Client = s3Client;
        }
            if (b >= 0) pos++;
        }
            closeStream();
                int n = read(position + totalRead, buffer, offset + totalRead, length - totalRead);
        }
import org.apache.hadoop.fs.Seekable;
    }
        String bucket = path.toUri().getHost();
 * compatible open source license.
    private static class S3InputStream extends InputStream implements Seekable, PositionedReadable {
        HeadObjectResponse head = s3Client.headObject(HeadObjectRequest.builder().bucket(bucket).key(key).build());
            if (stream == null) return -1;
        private long pos;
        }
        short replication,
        FsPermission permission,
        return new Path(uri.getScheme() + "://" + bucket + "/" + key);
            // s3a convention allows an endpoint without a scheme; default to https
        }
            String range = "bytes=" + pos + "-" + (contentLength - 1);
import java.io.IOException;
 * Minimal Hadoop FileSystem implementation for S3 using AWS SDK v2.
        private void openStream() {
            if (stream == null) return -1;
            prefix += "/";
    @Override
            this.key = key;
            probe = s3Client.listObjectsV2(ListObjectsV2Request.builder().bucket(bucket).prefix(prefix).maxKeys(1).build());
    @Override
        throw new FileNotFoundException("No such file or directory: s3://" + bucket + "/" + key);
    public boolean delete(Path path, boolean recursive) {
    public void initialize(URI name, Configuration conf) throws IOException {
import software.amazon.awssdk.services.s3.S3Client;
        }
            }
        } catch (S3Exception e) {
            if (position >= contentLength) return -1;
            }
        }
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
        private ResponseInputStream<GetObjectResponse> stream;
            if (pos >= contentLength) {
        }
        private void closeStream() throws IOException {
        if (key.startsWith("/")) {
    @Override
 * this file be licensed under the Apache-2.0 license or a
import org.apache.hadoop.fs.permission.FsPermission;
                ResponseInputStream<GetObjectResponse> resp = s3Client.getObject(
                    totalRead += n;
            }
            long endInclusive = Math.min(position + length - 1, contentLength - 1);
            int n = stream.read(buf, off, len);
        if (s3Client != null) {
        @Override
            // virtual-hosted-style bucket DNS is not available.
                // The null-token check guards against S3-compatible stores that
    public FSDataOutputStream append(Path path, int bufferSize, Progressable progress) {
     * configuration, so that {@code hadoop_config.fs.s3a.*} ingestion parameters
import software.amazon.awssdk.services.s3.model.S3Object;
            String endpointUri = endpoint.contains("://") ? endpoint : "https://" + endpoint;
                closeStream();
    }
        }
            // Clamp the end of the range; a start at or past EOF or an inverted
        @Override
        throw new UnsupportedOperationException("S3HadoopFileSystem is read-only");
                statuses.add(new FileStatus(obj.size(), false, 1, 0, obj.lastModified().toEpochMilli(), filePath));
        String region = conf.getTrimmed("fs.s3a.endpoint.region", "");
        String prefix = key.endsWith("/") ? key : key + "/";
    public String getScheme() {
    @Override
                return;
     * provider chains (environment, instance profile, etc.).
        super.close();
                stream = null;
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;
import org.apache.hadoop.fs.FileStatus;
            return n;
                // At or past EOF: a range like "bytes=N-(N-1)" is invalid and S3
     *
            }
        } catch (SdkException e) {
        long contentLength = head.contentLength();
    }
            if (stream != null) return;
            return new FileStatus(head.contentLength(), false, 1, 0, head.lastModified().toEpochMilli(), path);
            }
        }
            this.contentLength = contentLength;
import software.amazon.awssdk.services.s3.S3ClientBuilder;
                totalRead += n;
                int totalRead = 0;
        } while (true);
        @Override
                // unopened; the read methods report EOF when the stream is null.
    @Override
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
        }
    public FSDataOutputStream create(
                statuses.add(new FileStatus(0, true, 1, 0, 0, dirPath));
import org.apache.hadoop.fs.FSDataInputStream;
        @Override
    private static String pathToKey(Path path) {
    @Override
        super.initialize(name, conf);
                stream.close();
        }
            String range = "bytes=" + position + "-" + endInclusive;
            requestBuilder.continuationToken(response.nextContinuationToken());
        try {
    public Path getWorkingDirectory() {
import software.amazon.awssdk.regions.Region;
    @Override
        private final S3Client s3Client;
        S3ClientBuilder builder = S3Client.builder();
    public FSDataInputStream open(Path path, int bufferSize) throws IOException {
        List<FileStatus> statuses = new ArrayList<>();
        // contents() is never null in SDK v2; keyCount() is a nullable Integer that
        do {
import org.apache.hadoop.fs.FSDataOutputStream;
                throw new IOException("Failed to get status of s3://" + bucket + "/" + key, e);
 */
import java.net.URI;
                    if (n < 0) break;
     */
            try (
                String key = obj.key();
                )
        Path path,
            // Required by most S3-compatible stores (e.g., MinIO) where
            if (Boolean.TRUE.equals(response.isTruncated()) == false || response.nextContinuationToken() == null) {
            builder.credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey)));
 * SPDX-License-Identifier: Apache-2.0
        this.s3Client = createS3Client(conf);
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.Configuration;
 * Supports read-only operations needed for Hive ingestion: open, listStatus, getFileStatus.
    public boolean mkdirs(Path path, FsPermission permission) {
    public FileStatus[] listStatus(Path path) throws IOException {
            return new FileStatus(0, true, 1, 0, 0, path);
        boolean overwrite,
            }
                // would otherwise loop forever re-listing the first page.
    @Override
            return b;
            }
 */
            return false;
        public void readFully(long position, byte[] buffer) throws IOException {
        }
        String endpoint = conf.getTrimmed("fs.s3a.endpoint", "");
                pos = newPos;
            throw new IOException("Failed to get status of s3://" + bucket + "/" + key, e);
                // rejects it with 416 instead of signaling EOF. Leave the stream
import java.util.List;
     * InputStream for reading S3 objects that supports seeking via range-request re-open.
            }
        String prefix = pathToKey(path);
import org.apache.hadoop.fs.PositionedReadable;
        public void seek(long newPos) throws IOException {
        long blockSize,
        @Override
        String bucket = path.toUri().getHost();
                }
            openStream();
    }
     * Supported keys: fs.s3a.endpoint, fs.s3a.endpoint.region,
        private final long contentLength;
        public int read() throws IOException {
        @Override
    @Override
        return uri != null ? uri.getScheme() : "s3";
    @Override
import software.amazon.awssdk.core.ResponseInputStream;
     * Builds an S3 client honoring the standard fs.s3a.* keys from the Hadoop
        @Override
            readFully(position, buffer, 0, buffer.length);
import org.opensearch.secure_sm.AccessController;
        return key;
        }
            }
    public void setWorkingDirectory(Path newDir) {
        ListObjectsV2Response response;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
    }
        this.workingDir = newDir;
            int totalRead = 0;
    public FileStatus getFileStatus(Path path) throws IOException {
    /**
        public int read(long position, byte[] buffer, int offset, int length) throws IOException {
        }
     */
            ) {
    private Path workingDir;
        this.uri = URI.create(name.getScheme() + "://" + name.getAuthority());
    URI uri;
                // report a truncated listing without a continuation token, which
    ) {
        throw new UnsupportedOperationException("S3HadoopFileSystem is read-only");
                break;
    @Override
import java.io.InputStream;
    private Path keyToPath(String bucket, String key) {
        if (probe.contents().isEmpty() == false) {
            this.pos = 0;
            if (length == 0) return 0;
            for (S3Object obj : response.contents()) {
        Progressable progress
        // Building the client reads AWS profile files (~/.aws/config, ~/.aws/credentials)
        return workingDir;
    }
    }
    }
                Path dirPath = keyToPath(bucket, commonPrefix.prefix());
        this.workingDir = new Path("/");

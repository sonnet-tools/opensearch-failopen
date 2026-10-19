                // rejects it with 416 instead of signaling EOF. Leave the stream
        }
            if (e.statusCode() != 404) {
import org.apache.hadoop.fs.Seekable;  
                // report a truncated listing without a continuation token, which
                Path filePath = keyToPath(bucket, key);
    public boolean mkdirs(Path path, FsPermission permission) {
import software.amazon.awssdk.services.s3.S3ClientBuilder;
            }
    public URI getUri() {
        private final String bucket;
            HeadObjectResponse head = s3Client.headObject(HeadObjectRequest.builder().bucket(bucket).key(key).build());
    @Override
    public Path getWorkingDirectory() {
            try (
            // Required by most S3-compatible stores (e.g., MinIO) where
    public FileStatus getFileStatus(Path path) throws IOException {
        throw new UnsupportedOperationException("S3HadoopFileSystem is read-only");
        private long pos;  
    public FileStatus[] listStatus(Path path) throws IOException {
     * fs.s3a.path.style.access, fs.s3a.access.key, fs.s3a.secret.key.
            }
            String range = "bytes=" + position + "-" + endInclusive;  
        public int read(byte[] buf, int off, int len) throws IOException {
        public int read() throws IOException {
        this.s3Client = createS3Client(conf);
        }
            builder.region(Region.of(region));
    static S3Client createS3Client(Configuration conf) {  
            closeStream();  
        }
import java.net.URI;
        }
        @Override
        }
 * SPDX-License-Identifier: Apache-2.0
        String bucket = path.toUri().getHost();  
     * provider chains (environment, instance profile, etc.).
     */
        }
            String endpointUri = endpoint.contains("://") ? endpoint : "https://" + endpoint;
            if (b >= 0) pos++;  
        String prefix = key.endsWith("/") ? key : key + "/";
        }  
            }
    }  
    }
                // At or past EOF: a range like "bytes=N-(N-1)" is invalid and S3
        try {
        }
        } catch (SdkException e) {  
import org.opensearch.secure_sm.AccessController;  
    @Override
            }
            }
        @Override  
import software.amazon.awssdk.services.s3.model.GetObjectResponse;  
 */  
        }
            int n = stream.read(buf, off, len);  
            int b = stream.read();
            if (stream == null) return -1;
            // range would be rejected by S3 with 416 instead of signaling EOF.
        if (accessKey.isEmpty() == false && secretKey.isEmpty() == false) {
                while (totalRead < length) {
            readFully(position, buffer, 0, buffer.length);
        public void readFully(long position, byte[] buffer, int offset, int length) throws IOException {
                break;
        if (key.startsWith("/")) {
        public boolean seekToNewSource(long targetPos) {
        if (region.isEmpty() == false) {  
        if (key.isEmpty()) {  
import java.io.InputStream;
    }
        String region = conf.getTrimmed("fs.s3a.endpoint.region", "");
import software.amazon.awssdk.core.exception.SdkException;
     * configuration, so that {@code hadoop_config.fs.s3a.*} ingestion parameters
     * take effect. Keys that are not set fall back to the AWS SDK default  
            this.key = key;
        public void seek(long newPos) throws IOException {  
        }
            if (length == 0) return 0;
        private void closeStream() throws IOException {  
        throw new UnsupportedOperationException("S3HadoopFileSystem is read-only");
import software.amazon.awssdk.services.s3.S3Client;  
            openStream();  
            requestBuilder.continuationToken(response.nextContinuationToken());  
        private final long contentLength;
        private ResponseInputStream<GetObjectResponse> stream;
                int n = read(position + totalRead, buffer, offset + totalRead, length - totalRead);
            if (position >= contentLength) return -1;
        return AccessController.doPrivileged((Supplier<S3Client>) builder::build);
        List<FileStatus> statuses = new ArrayList<>();  
import software.amazon.awssdk.services.s3.model.S3Exception;
            return b;
     *
import org.apache.hadoop.fs.permission.FsPermission;
        @Override
        if (probe.contents().isEmpty() == false) {
    public FSDataOutputStream create(
        @Override
        Path path,  
        String key = pathToKey(path);
        }  
            if (stream != null) {
            builder.credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey)));
            openStream();
}
            if (n > 0) pos += n;
/*  
    private Path keyToPath(String bucket, String key) {
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
/**
            }
    }
            builder.forcePathStyle(true);  
        }
    }
 * The OpenSearch Contributors require contributions made to  
    @Override  
    @Override
                String key = obj.key();  
            return new FileStatus(0, true, 1, 0, 0, path);
    @Override
        ListObjectsV2Response response;
        @Override
        }
        public void close() throws IOException {
    @Override
import java.io.IOException;  
                totalRead += n;
    public FSDataInputStream open(Path path, int bufferSize) throws IOException {  
    S3Client s3Client;
        return new FSDataInputStream(new S3InputStream(s3Client, bucket, key, contentLength));
            this.s3Client = s3Client;  
    }
    public void close() throws IOException {
        String prefix = pathToKey(path);
        throw new UnsupportedOperationException("S3HadoopFileSystem is read-only");
    ) {
        // through the default provider chains; run privileged so the plugin's own
                return;
                    int n = resp.read(buffer, offset + totalRead, length - totalRead);
        }
    }  
        public void readFully(long position, byte[] buffer) throws IOException {  
        @Override
    @Override
        boolean overwrite,
        return new Path(uri.getScheme() + "://" + bucket + "/" + key);  
    public String getScheme() {
        super.close();  
            return n;
                Path dirPath = keyToPath(bucket, commonPrefix.prefix());  
        // S3-compatible stores may omit, so do not rely on it.  
                pos = newPos;  
    public void setWorkingDirectory(Path newDir) {  
        }
            response = s3Client.listObjectsV2(requestBuilder.build());
        } catch (S3Exception e) {
        public int read(long position, byte[] buffer, int offset, int length) throws IOException {  
        return true;  
        private void openStream() {
    }
        private final S3Client s3Client;
        Progressable progress  
        try {  
     * Builds an S3 client honoring the standard fs.s3a.* keys from the Hadoop
            stream = s3Client.getObject(GetObjectRequest.builder().bucket(bucket).key(key).range(range).build());
            if (stream != null) return;
        private final String key;  
 */  
    }
    }  
 * Registered as the implementation for s3://, s3a://, and s3n:// schemes so that
    }  
import java.util.List;
        String endpoint = conf.getTrimmed("fs.s3a.endpoint", "");
                stream.close();
            return new FileStatus(0, true, 1, 0, 0, path);
        }
    }  
                // unopened; the read methods report EOF when the stream is null.  
            // s3a convention allows an endpoint without a scheme; default to https
                    if (n < 0) break;  
        // FilePermission applies regardless of unprivileged callers on the stack.  
            throw new IOException("Failed to get status of s3://" + bucket + "/" + key, e);  
            long endInclusive = Math.min(position + length - 1, contentLength - 1);
        }  
                // The null-token check guards against S3-compatible stores that
            for (S3Object obj : response.contents()) {
            String range = "bytes=" + pos + "-" + (contentLength - 1);  
import org.apache.hadoop.conf.Configuration;
        if (s3Client != null) {  
        long blockSize,
                if (key.equals(prefix)) continue;
    }
        String key = pathToKey(path);
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
            return pos;  
            }
            this.bucket = bucket;
        } while (true);
    /**  
        ListObjectsV2Request.Builder requestBuilder = ListObjectsV2Request.builder().bucket(bucket).prefix(prefix).delimiter("/");
            }
    @Override
    @Override
import software.amazon.awssdk.services.s3.model.S3Object;  
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
                throw new IOException("Failed to get status of s3://" + bucket + "/" + key, e);  
        return workingDir;
    }
            // No object at this key: it may still be a directory prefix. Probe below.
    public FSDataOutputStream append(Path path, int bufferSize, Progressable progress) {  
    /**  
                closeStream();
                }
        super.initialize(name, conf);  
        S3ClientBuilder builder = S3Client.builder();
        String accessKey = conf.getTrimmed("fs.s3a.access.key", "");
     * InputStream for reading S3 objects that supports seeking via range-request re-open.
    @Override
    public boolean delete(Path path, boolean recursive) {  
            return new FileStatus(head.contentLength(), false, 1, 0, head.lastModified().toEpochMilli(), path);  
        }
        throw new FileNotFoundException("No such file or directory: s3://" + bucket + "/" + key);
        String secretKey = conf.getTrimmed("fs.s3a.secret.key", "");  
        String bucket = path.toUri().getHost();  
            s3Client.close();
    private static String pathToKey(Path path) {  
 * Minimal Hadoop FileSystem implementation for S3 using AWS SDK v2.
        @Override
                    GetObjectRequest.builder().bucket(bucket).key(key).range(range).build()  
            return false;
        int bufferSize,  
            // virtual-hosted-style bucket DNS is not available.
        }  
        return uri;  
import software.amazon.awssdk.regions.Region;
        S3InputStream(S3Client s3Client, String bucket, String key, long contentLength) {
        }
            builder.endpointOverride(URI.create(endpointUri));  
        return uri != null ? uri.getScheme() : "s3";
            while (totalRead < length) {
        @Override
    @Override
            if (newPos != pos) {
import org.apache.hadoop.fs.PositionedReadable;
 * compatible open source license.
        } catch (SdkException e) {
        return statuses.toArray(new FileStatus[0]);  
            ) {
    public void initialize(URI name, Configuration conf) throws IOException {
import org.apache.hadoop.fs.FileStatus;
            throw new IOException("Failed to get status of s3://" + bucket + "/" + key, e);
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
 * Supports read-only operations needed for Hive ingestion: open, listStatus, getFileStatus.  
    @Override  
        FsPermission permission,
            // Clamp the end of the range; a start at or past EOF or an inverted  
        this.workingDir = newDir;
        }
        }  
                return totalRead == 0 ? -1 : totalRead;  
        public long getPos() {
                statuses.add(new FileStatus(0, true, 1, 0, 0, dirPath));
        this.workingDir = new Path("/");  
    }  
            if (pos >= contentLength) {  
            this.contentLength = contentLength;  
import org.apache.hadoop.fs.FileSystem;  
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
 * Hadoop's HadoopInputFile and FileSystem.get() work transparently with S3 paths.
import org.apache.hadoop.fs.FSDataInputStream;  
import org.apache.hadoop.fs.Path;
        short replication,
        ListObjectsV2Response probe;
                int totalRead = 0;  
            }
import java.util.function.Supplier;
 *
        HeadObjectResponse head = s3Client.headObject(HeadObjectRequest.builder().bucket(bucket).key(key).build());
import java.io.FileNotFoundException;
        @Override
    }
        // Building the client reads AWS profile files (~/.aws/config, ~/.aws/credentials)
    URI uri;  
            key = key.substring(1);  
        do {  
import org.apache.hadoop.fs.FSDataOutputStream;
        // contents() is never null in SDK v2; keyCount() is a nullable Integer that
                ResponseInputStream<GetObjectResponse> resp = s3Client.getObject(
     * Supported keys: fs.s3a.endpoint, fs.s3a.endpoint.region,  
import java.util.ArrayList;  
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;
 * this file be licensed under the Apache-2.0 license or a
    @Override
        String bucket = path.toUri().getHost();
            if (len == 0) return 0;  
            if (Boolean.TRUE.equals(response.isTruncated()) == false || response.nextContinuationToken() == null) {  
            prefix += "/";  
            int totalRead = 0;  
        if (!prefix.isEmpty() && !prefix.endsWith("/")) {
            if (stream == null) return -1;
        if (conf.getBoolean("fs.s3a.path.style.access", false)) {  
    private static class S3InputStream extends InputStream implements Seekable, PositionedReadable {  
        long contentLength = head.contentLength();
package org.opensearch.plugin.hive;
public class S3HadoopFileSystem extends FileSystem {
    }
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;  
import software.amazon.awssdk.core.ResponseInputStream;  
        throw new UnsupportedOperationException("S3HadoopFileSystem is read-only");
                stream = null;  
        }
                if (n < 0) throw new IOException("Unexpected EOF at position " + (position + totalRead));  
            probe = s3Client.listObjectsV2(ListObjectsV2Request.builder().bucket(bucket).prefix(prefix).maxKeys(1).build());
     */
        String key = path.toUri().getPath();
            for (var commonPrefix : response.commonPrefixes()) {
    public boolean rename(Path src, Path dst) {
        if (endpoint.isEmpty() == false) {  
    @Override  
    }
        return key;
        this.uri = URI.create(name.getScheme() + "://" + name.getAuthority());
    private Path workingDir;
                statuses.add(new FileStatus(obj.size(), false, 1, 0, obj.lastModified().toEpochMilli(), filePath));  
                )
            this.pos = 0;
                // would otherwise loop forever re-listing the first page.  
                    totalRead += n;
import org.apache.hadoop.util.Progressable;

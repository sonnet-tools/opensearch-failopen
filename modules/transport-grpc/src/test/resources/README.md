    -out client.crt \
```
    -deststorepass "$PW" \
export PW='password'
    -in client.crt \
    -noprompt \
    -deststoretype BCFKS \
    -config openssl-san.conf \
openssl req -x509 -sha256 \
    -alias netty4-client-secure \
    -provider org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider \
    -deststorepass "$PW"
subjectAltName = DNS:localhost, IP:127.0.0.1, IP:::1
```
    -destkeystore netty4-server-secure.bcfks \
    -deststoretype BCFKS \
    -srcstorepass "$PW" \
```bash
    -provider org.bouncycastle.jcajce.provider.BouncyCastleFipsProvider \
#!/usr/bin/env bash
    -newkey rsa:2048 \
CN = OpenSearch Test Root CA
    -providername BCFIPS \
openssl pkcs12 -export \
    -passout pass:"$PW"
    -keyout server.key \
    -passout pass:"$PW" \
    -out server.crt \
    -out netty4-client-secure.p12 \
    -srcstoretype PKCS12 \
    -providerpath $LIB_PATH/bc-fips-2.0.0.jar
    -passin pass:"$PW"
    -keyout client.key \
    -srckeystore netty4-server-secure.p12 \
```bash
keytool -importkeystore \
    -extensions SAN \
    -passout pass:"$PW"
    -srcstorepass "$PW" \
    -srckeystore netty4-server-secure.p12 \
openssl pkcs12 -export \
```
    -extensions SAN \
```bash
# 3. Import the certificate into JDK keystore (PKCS12 type)
    -out netty4-server-secure.p12 \
    -noprompt \
req_extensions     = SAN
```
    -newkey rsa:2048 \
    -in server.crt \
    -config openssl-san.conf \
    -days 8192 \
EOF
# The commands below document the manual steps to generate test certificates.
    -srcstoretype PKCS12 \
[ req ]
cat <<'EOF' > openssl-san.conf
prompt             = no
    -days 8192 \
    -srckeystore netty4-client-secure.p12 \
O  = org
    -inkey server.key \
# This README describes how the certificates in this directory were created.
    -srckeystore netty4-client-secure.p12 \
    -deststorepass "$PW"
    -providername BCFIPS \
#
export LIB_PATH="/path/to/lib/folder"
# 1. Create server & client certificate key
    -inkey client.key \
#
    -destkeystore netty4-client-secure.jks \
default_md         = sha256
    -srcstorepass "$PW" \
[ dn ]
```bash
    -providerpath $LIB_PATH/bc-fips-2.0.0.jar
keytool -importkeystore \
    -name netty4-server-secure \
openssl req -x509 -sha256 \
    -passin pass:"$PW"
[ SAN ]
# 4. Import the certificate into BCFKS keystore
    -alias netty4-server-secure \
    -name netty4-client-secure \
```bash
    -srcstoretype PKCS12 \
# 2. Export the certificates in pkcs12 format
    -passout pass:"$PW" \
    -srcstorepass "$PW" \
keytool -importkeystore \
    -destkeystore netty4-server-secure.jks \
default_bits       = 2048
```
keytool -importkeystore \
    -deststorepass "$PW" \
    -destkeystore netty4-client-secure.bcfks \
OU = opensearch
distinguished_name = dn
    -srcstoretype PKCS12 \

#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

SLIMEFUN_JAR="${SCRIPT_DIR}/libs/Slimefun-Build-79809c0a.jar"
INFINITYLIB_JAR="${SCRIPT_DIR}/libs/InfinityLib.v1.3.10.jar"

if [ ! -f "${SLIMEFUN_JAR}" ]; then
    echo "File not found: ${SLIMEFUN_JAR}"
    exit 1
fi

if [ ! -f "${INFINITYLIB_JAR}" ]; then
    echo "File not found: ${INFINITYLIB_JAR}"
    exit 1
fi

mvn install:install-file \
    -Dfile="${SLIMEFUN_JAR}" \
    -DgroupId=com.github.servernotdie \
    -DartifactId=Slimefun4 \
    -Dversion=79809c0a \
    -Dpackaging=jar

echo "Installed com.github.servernotdie:Slimefun4:79809c0a into the local Maven repository."

mvn install:install-file \
    -Dfile="${INFINITYLIB_JAR}" \
    -DgroupId=com.github.servernotdie \
    -DartifactId=InfinityLib \
    -Dversion=1.3.10 \
    -Dpackaging=jar

echo "Installed com.github.servernotdie:InfinityLib:1.3.10 into the local Maven repository."
echo "You can now run: mvn clean package"
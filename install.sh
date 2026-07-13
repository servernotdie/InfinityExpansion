#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

SLIMEFUN_JAR="${SCRIPT_DIR}/libs/Slimefun-Build-a34a69e8.jar"
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
    -Dversion=a34a69e8 \
    -Dpackaging=jar

echo "Installed com.github.servernotdie:Slimefun4:a34a69e8 into the local Maven repository."

mvn install:install-file \
    -Dfile="${INFINITYLIB_JAR}" \
    -DgroupId=com.github.servernotdie \
    -DartifactId=InfinityLib \
    -Dversion=build-3 \
    -Dpackaging=jar

echo "Installed com.github.servernotdie:InfinityLib:build-3 into the local Maven repository."
echo "You can now run: mvn clean package"
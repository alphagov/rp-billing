#!/usr/bin/env bash

. deploy/functions.sh
. ../ida-build-scripts/check_for_library_updates.sh

BUILD_OUTPUT=build-output.log
rm $BUILD_OUTPUT
environment=local

pre_commit_main_build
./gradlew clean build intTest
if [$? -ne 0] ; then
  exit $?
fi

./startup.sh
if [$? -ne 0] ; then
  exit $?
fi

./kill-all-the-services.sh

tput setaf 2
printf "\n########     ###     ######   ######  ######## ######## \n"
printf "##     ##   ## ##   ##    ## ##    ## ##       ##     ##\n"
printf "##     ##  ##   ##  ##       ##       ##       ##     ##\n"
printf "########  ##     ##  ######   ######  ######   ##     ##\n"
printf "##        #########       ##       ## ##       ##     ##\n"
printf "##        ##     ## ##    ## ##    ## ##       ##     ##\n"
printf "##        ##     ##  ######   ######  ######## ######## \n"
tput sgr0

check_for_library_updates common-utils rest-utils security-utils common-test-utils


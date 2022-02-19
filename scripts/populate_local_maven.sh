#!/bin/bash
pushd ../

COMMAND=gradle
# determine gradle command
if ! command -v $COMMAND &> /dev/null
then
    COMMAND="./gradle"
    exit
fi


$COMMAND :entities:clean :entities:assembleDebug :entities:publishToMavenLocal && \
$COMMAND :commons:clean :common:assembleDebug :common:publishToMavenLocal && \
$COMMAND :features:credit_card:clean :features:credit_card:assembleDebug :features:credit_card:publishToMavenLocal && \
$COMMAND :features:profile:clean :features:profile:assembleDebug :features:profile:publishToMavenLocal && \
$COMMAND :features:home:clean :features:home:assembleDebug :features:home:publishToMavenLocal && \
$COMMAND :features:profile:clean :features:profile:assembleDebug :features:profile:publishToMavenLocal && \
popd || exit
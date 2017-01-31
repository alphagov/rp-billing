#!/usr/bin/env bash
set -e
. $(dirname $0)/../ida-build-scripts/functions.sh
. $(dirname $0)/deploy/functions.sh
set_project_root


function usage {
    echo "startup.sh [-B] [-s] [-e environment]"
    echo "-B                skip gradle build"
    echo "-s                skip create config"
    echo "-e environment    set acceptance test environment"
    exit
}

environment=local
create_config=true
skip_gradle_build=false

while getopts "hBse:" option
do
     case $option in
         B)
             skip_gradle_build=true
             ;;
         s)
             create_config=false
             ;;
         e)
             environment=$OPTARG
             ;;
         h)
             usage
             ;;
         ?)
             usage
             ;;
     esac
done



$skip_gradle_build || build_project rp-billing ${extra_gradle_tasks}

$(dirname $0)/kill-all-the-services.sh

log "Deploying apps..."
config_dir=$PROJECT_ROOT/configuration/$environment
log config_dir=$config_dir
start_service rp-billing $config_dir

wait_for_jobs

log "Finished"


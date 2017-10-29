#!/bin/bash

# Forwarding Information Base of routers are generated by running command "show route forwarding-table"
# For other information, see http://www.juniper.net/documentation/en_US/junos13.3/topics/reference/command-summary/show-route-forwarding-table.html
# For other information about Internet2, see http://vn.grnoc.iu.edu/Internet2/

DDIR=../data/$(date +%Y-%m-%d)
if [ "$1" != "" ]; then
    DDIR=$1/$(date +%Y-%m-%d)
fi
echo Output to "$DDIR"


declare -a ROUTERS=("ATLA" "CHIC" "CLEV" "HOUS" "KANS" "LOSA" "NEWY32AOA" "PAIX" "SALT" "SEAT" "WASH" "WILC")

function download-current-fib {
    if [ -e $DDIR ]
    then
	echo 'Data has been downloaded, exit...'
	exit 1
    fi
    mkdir $DDIR
    for router in "${ROUTERS[@]}"
    do
	wget http://vn.grnoc.iu.edu/Internet2/fib/${router,,}-show_route_forwarding-table_table_default.xml -O $DDIR/${router}-fib.xml
    done
}

download-current-fib


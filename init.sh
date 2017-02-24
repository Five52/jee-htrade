#!/bin/bash
read -e -p "Enter database host : " dbhost
read -e -p "Enter database name : " dbname
read -e -p "Enter username : " username
read -e -s -p "Enter password : " password

mkdir app/lib
cd libPerson
sed -i "s/DB_HOST/${dbhost}/g;s/DB_NAME/${dbname}/g;s/USERNAME/${username}/g;s/PASSWORD/${password}/g" resources/hibernate.cfg.xml
ant test
ant dist
cp dist/libPerson.jar ../libTrade/lib/

cd ../libHabitation
sed -i "s/DB_HOST/${dbhost}/g;s/DB_NAME/${dbname}/g;s/USERNAME/${username}/g;s/PASSWORD/${password}/g" resources/hibernate.cfg.xml
ant test
ant dist
cp dist/libHabitation.jar ../libTrade/lib/

cd ../libTrade
sed -i "s/DB_HOST/${dbhost}/g;s/DB_NAME/${dbname}/g;s/USERNAME/${username}/g;s/PASSWORD/${password}/g" resources/hibernate.cfg.xml
ant test
ant dist
cp lib/* ../app/lib/
cp dist/libTrade.jar ../app/lib/

cd ../app
sed -i "s/DB_HOST/${dbhost}/g;s/DB_NAME/${dbname}/g;s/USERNAME/${username}/g;s/PASSWORD/${password}/g" resources/hibernate.cfg.xml

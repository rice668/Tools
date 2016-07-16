cd /root/Tools
mvn clean package
cd /root/Downloads/apache-tomcat-8.0.30/webapps
rm -rf HelloWeb
cd /root/Tools/web/target
mv web-1.0-SNAPSHOT HelloWeb
cp -rf HelloWeb /root/Downloads/apache-tomcat-8.0.30/webapps

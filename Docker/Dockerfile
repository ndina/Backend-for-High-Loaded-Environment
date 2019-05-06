FROM darecosystem/java8-deb

MAINTAINER Nassyrkhan Dina<dbom12360@gmail.com>


ENV APP_NAME Docker-1.0.0.zip
ENV APP_DIR Docker-1.0.0
ENV JAVA_OPTS -server -Xms128M -Xmx512M -Xss1M -XX:+CMSClassUnloadingEnabled
ENV RUN_SCRIPT Docker
ENV LOG_DIR /dar/logs/Docker
ENV LOG_ARCHIVE_DIR /dar/logs/archive/Docker
#ENV config  application.conf
ENV logback logback.xml

# logs
RUN mkdir -p /root/config/ \
    && mkdir -p $LOG_DIR \
    && mkdir -p $LOG_ARCHIVE_DIR

COPY ./src/main/resources/*logback.xml /root/config/

WORKDIR /root
COPY ./target/universal/$APP_NAME /root/
RUN unzip -q $APP_NAME
WORKDIR /root/$APP_DIR/bin
CMD chmod +x $RUN_SCRIPT
EXPOSE 8080
CMD ./$RUN_SCRIPT
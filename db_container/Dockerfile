FROM postgres:9.4
MAINTAINER Federico Tomassetti

RUN apt-get update
RUN apt-get install -y software-properties-common

ADD ./setup.sql /db/setup.sql
ADD ./schema.sql /db/schema.sql

EXPOSE 5432

USER postgres

CMD ["/usr/lib/postgresql/9.4/bin/postgres", "-D", "/var/lib/postgresql/9.4/main", "-c", "config_file=/etc/postgresql/9.4/main/postgresql.conf"]

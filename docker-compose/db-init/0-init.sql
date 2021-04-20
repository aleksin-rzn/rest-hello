CREATE SCHEMA my_schema;
GRANT ALL ON SCHEMA my_schema TO docker_user;
ALTER USER docker_user SET search_path TO my_schema;

create table my_schema.logs(

                                            id varchar(50) not null,
                                            value varchar(50) not null,
                                            date timestamp not null
);


CREATE TABLE IF NOT EXISTS photos(
    id bigint identity primary key,
    file_name varchar(200),
    content_type varchar(200),
    data binary
);
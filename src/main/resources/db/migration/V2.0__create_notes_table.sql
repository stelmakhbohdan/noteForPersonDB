CREATE TABLE notes(
                       id bigserial primary key,
                       title text not null,
                       body text not null,
                       person_id bigint REFERENCES persons(id)
);
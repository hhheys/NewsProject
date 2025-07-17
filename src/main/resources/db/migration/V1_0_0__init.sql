CREATE TABLE account
(
    id    UUID primary key,
    name  text,
    email text
);

CREATE TABLE publisher
(
    id            UUID,
    legal_name    text,
    legal_address text
);

CREATE TABLE user_entity
(
    id   UUID primary key,
    role text
);

CREATE TABLE reaction
(
    id        UUID primary key,
    post_uuid UUID,
    user_uuid UUID
);

CREATE TABLE like_entity
(
    reaction_uuid UUID
);

CREATE TABLE dislike
(
    reaction_uuid UUID
);

ALTER TABLE publisher
    ADD CONSTRAINT publisher_account_id_fk FOREIGN KEY (id)
        REFERENCES account (id);

ALTER TABLE user_entity
    ADD CONSTRAINT user_account_id_fk FOREIGN KEY (id)
        REFERENCES account (id);

ALTER TABLE reaction
    ADD CONSTRAINT reaction_user_uuid_fk FOREIGN KEY (user_uuid)
        REFERENCES user_entity (id);

ALTER TABLE like_entity
    ADD CONSTRAINT like_reaction_uuid_fk FOREIGN KEY (reaction_uuid)
        REFERENCES reaction (id);

ALTER TABLE dislike
    ADD CONSTRAINT dislike_reaction_uuid_fk FOREIGN KEY (reaction_uuid)
        REFERENCES reaction (id);
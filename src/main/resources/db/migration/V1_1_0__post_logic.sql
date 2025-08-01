CREATE TABLE post
(
    id             UUID primary key,
    title          text,
    topic_id       bigint,
    description    text,
    content        text,
    publisher_uuid UUID,
    view_count     bigint
);

CREATE TABLE topic
(
    id   bigint primary key,
    name text
);

CREATE TABLE comment
(
    id        UUID,
    content   text,
    user_uuid UUID,
    post_uuid UUID
);

CREATE TABLE repost
(
    id             UUID,
    post_uuid      UUID,
    sender_uuid    UUID,
    recipient_uuid UUID
);

CREATE TABLE post_topic
(
    post_uuid UUID,
    topic_id  bigint
);

ALTER TABLE post_topic
    ADD CONSTRAINT post_topic_post_uuid_fk FOREIGN KEY (post_uuid)
        REFERENCES post (id);

ALTER TABLE post_topic
    ADD CONSTRAINT post_topic_topic_id_fk FOREIGN KEY (topic_id)
        REFERENCES topic (id);

ALTER TABLE comment
    ADD CONSTRAINT comment_post_uuid_fk FOREIGN KEY (post_uuid)
        REFERENCES post (id);

ALTER TABLE repost
    ADD CONSTRAINT repost_post_uuid_fk FOREIGN KEY (post_uuid)
        REFERENCES post (id);
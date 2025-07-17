ALTER TABLE reaction
    ADD CONSTRAINT reaction_post_uuid_fk FOREIGN KEY (post_uuid)
        REFERENCES post (id);

ALTER TABLE comment
    ADD CONSTRAINT comment_user_uuid_fk FOREIGN KEY (user_uuid)
        REFERENCES user_entity (id);

ALTER TABLE publisher
    ADD CONSTRAINT publisher_id_unique UNIQUE (id);

ALTER TABLE post
    ADD CONSTRAINT post_publisher_uuid_fk FOREIGN KEY (publisher_uuid)
        REFERENCES publisher (id);

ALTER TABLE repost
    ADD CONSTRAINT repost_sender_uuid_fk FOREIGN KEY (sender_uuid)
        REFERENCES user_entity (id);

ALTER TABLE repost
    ADD CONSTRAINT repost_recipient_uuid_fk FOREIGN KEY (recipient_uuid)
        REFERENCES user_entity (id);


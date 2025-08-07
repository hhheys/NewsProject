ALTER TABLE reaction
    ADD CONSTRAINT unique_user_post_reaction
        UNIQUE (user_uuid, post_uuid);
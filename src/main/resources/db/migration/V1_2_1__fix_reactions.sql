ALTER TABLE like_entity
    ADD PRIMARY KEY (reaction_uuid);

ALTER TABLE like_entity
    ADD CONSTRAINT like_entity_reaction_fk
        FOREIGN KEY (reaction_uuid) REFERENCES reaction(id);

ALTER TABLE dislike
    ADD PRIMARY KEY (reaction_uuid);

ALTER TABLE dislike
    ADD CONSTRAINT dislike_reaction_fk
        FOREIGN KEY (reaction_uuid) REFERENCES reaction(id);
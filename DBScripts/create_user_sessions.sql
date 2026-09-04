
CREATE TABLE user_sessions (
    session_id UUID PRIMARY KEY,
    user_id BIGINT NOT NULL,

    access_token TEXT NOT NULL,
    refresh_token TEXT,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    expires_at TIMESTAMP NOT NULL,

    is_active BOOLEAN NOT NULL DEFAULT TRUE,

    ip_address VARCHAR(45),

    CONSTRAINT fk_user_sessions_user
        FOREIGN KEY (user_id)
        REFERENCES usos_users(user_id)
        ON DELETE CASCADE
);

CREATE INDEX idx_user_sessions_user_id
ON user_sessions(user_id);

CREATE INDEX idx_user_sessions_active
ON user_sessions(is_active);

CREATE INDEX idx_user_sessions_expires_at
ON user_sessions(expires_at);
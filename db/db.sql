-- User table
CREATE TABLE IF NOT EXISTS users
(
    id            VARCHAR(255) NOT NULL,
    password      VARCHAR(255) NOT NULL,
    name          VARCHAR(255) NOT NULL,
    register_time BIGINT       NOT NULL,
    signs         VARCHAR(255),
    PRIMARY KEY (id)
);

-- Notes table
CREATE TABLE IF NOT EXISTS notes
(
    title         VARCHAR(255) NOT NULL,
    body          TEXT         NOT NULL,
    create_time   BIGINT       NOT NULL,
    modified_time BIGINT       NOT NULL,
    user          VARCHAR(255) NOT NULL,
    PRIMARY KEY (create_time, user),
    FOREIGN KEY (user) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Todos table
CREATE TABLE IF NOT EXISTS todos
(
    is_over       BOOLEAN      NOT NULL,
    body          TEXT         NOT NULL,
    create_time   BIGINT       NOT NULL,
    remind_time   BIGINT,
    over_time     BIGINT,
    repeat_period BIGINT       NOT NULL DEFAULT 0,
    user          VARCHAR(255) NOT NULL,
    PRIMARY KEY (create_time, user),
    FOREIGN KEY (user) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Task_lists table
CREATE TABLE IF NOT EXISTS task_lists
(
    list_name   VARCHAR(255) NOT NULL,
    create_time BIGINT       NOT NULL,
    user        VARCHAR(255) NOT NULL,
    PRIMARY KEY (create_time, user),
    FOREIGN KEY (user) REFERENCES users (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Tasks table
CREATE TABLE IF NOT EXISTS tasks
(
    is_over       BOOLEAN      NOT NULL,
    body          VARCHAR(255) NOT NULL,
    create_time   BIGINT       NOT NULL,
    remind_time   BIGINT,
    over_time     BIGINT,
    repeat_period BIGINT       NOT NULL DEFAULT 0,
    task_list_id  BIGINT       NOT NULL,
    user          VARCHAR(255) NOT NULL,
    PRIMARY KEY (create_time, user),
    FOREIGN KEY (task_list_id, user) REFERENCES task_lists (create_time, user) ON DELETE CASCADE ON UPDATE CASCADE,
    INDEX (task_list_id)
);
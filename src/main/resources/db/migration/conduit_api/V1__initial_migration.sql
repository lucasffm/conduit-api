CREATE TABLE "user" (
    "id" TEXT NOT NULL,
    "email" TEXT NOT NULL,
    "username" TEXT NOT NULL,
    "bio" TEXT,
    "image" TEXT,
    "password" TEXT NOT NULL,
    "created_at" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updated_at" TIMESTAMP(3) NOT NULL,
    CONSTRAINT "user_pkey" PRIMARY KEY ("id")
);

CREATE TABLE "follower" (
    "user_id" TEXT NOT NULL,
    "following_id" TEXT NOT NULL,
    CONSTRAINT "follower_pkey" PRIMARY KEY ("user_id","following_id")
);

CREATE TABLE "tag" (
    "id" TEXT NOT NULL,
    "name" TEXT NOT NULL,
    "created_at" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updated_at" TIMESTAMP(3) NOT NULL,
    CONSTRAINT "tag_pkey" PRIMARY KEY ("id")
);

CREATE TABLE "article" (
    "id" TEXT NOT NULL,
    "author_id" TEXT NOT NULL,
    "slug" TEXT NOT NULL,
    "title" TEXT NOT NULL,
    "description" TEXT NOT NULL,
    "body" TEXT NOT NULL,
    "created_at" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updated_at" TIMESTAMP(3) NOT NULL,
    CONSTRAINT "article_pkey" PRIMARY KEY ("id")
);

CREATE TABLE "comment" (
    "id" SERIAL NOT NULL,
    "body" TEXT NOT NULL,
    "article_id" TEXT NOT NULL,
    "author_id" TEXT NOT NULL,
    "created_at" TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updated_at" TIMESTAMP(3) NOT NULL,
    CONSTRAINT "comment_pkey" PRIMARY KEY ("id")
);

CREATE TABLE "favorite" (
    "user_id" TEXT NOT NULL,
    "article_id" TEXT NOT NULL,
    CONSTRAINT "favorite_pkey" PRIMARY KEY ("user_id","article_id")
);

CREATE TABLE "article_has_tag" (
    article_id TEXT NOT NULL,
    tag_id TEXT NOT NULL
);


CREATE UNIQUE INDEX "user_email_key" ON "user"("email");

CREATE UNIQUE INDEX "user_username_key" ON "user"("username");

CREATE INDEX "user_email_username_idx" ON "user"("email", "username");

CREATE UNIQUE INDEX "tag_name_key" ON "tag"("name");

CREATE UNIQUE INDEX "article_slug_key" ON "article"("slug");

CREATE UNIQUE INDEX "article_title_key" ON "article"("title");

CREATE UNIQUE INDEX "_article_has_tag_unique" ON "article_has_tag"(article_id, tag_id);

CREATE INDEX "article_has_tag_tag_id_index" ON "article_has_tag"(tag_id);

ALTER TABLE "follower" ADD CONSTRAINT "follower_following_id_fkey" FOREIGN KEY ("following_id") REFERENCES "user"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE "follower" ADD CONSTRAINT "follower_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "user"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE "article" ADD CONSTRAINT "article_author_id_fkey" FOREIGN KEY ("author_id") REFERENCES "user"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE "comment" ADD CONSTRAINT "comment_article_id_fkey" FOREIGN KEY ("article_id") REFERENCES "article"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE "comment" ADD CONSTRAINT "comment_author_id_fkey" FOREIGN KEY ("author_id") REFERENCES "user"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE "article_has_tag" ADD FOREIGN KEY (article_id) REFERENCES "article"("id") ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "article_has_tag" ADD FOREIGN KEY (tag_id) REFERENCES "tag"("id") ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "favorite" ADD CONSTRAINT "favorite_article_id_fkey" FOREIGN KEY ("article_id") REFERENCES "article"("id") ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE "favorite" ADD CONSTRAINT "favorite_user_id_fkey" FOREIGN KEY ("user_id") REFERENCES "user"("id") ON DELETE RESTRICT ON UPDATE CASCADE;
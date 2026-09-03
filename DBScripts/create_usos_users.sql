
CREATE TABLE public.usos_users (
	user_id bigserial NOT NULL,
	user_type varchar(30) NOT NULL,
	first_name varchar(100) NOT NULL,
	last_name varchar(100) NOT NULL,
	email varchar(255) NOT NULL,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
	updated_at timestamp NULL,
	contact_number varchar NOT NULL,
	"password" varchar NULL,
	roles varchar NOT NULL,
	CONSTRAINT usos_users_contact_number_not_null NOT NULL contact_number,
	CONSTRAINT usos_users_created_at_not_null NOT NULL created_at,
	CONSTRAINT usos_users_email_key UNIQUE (email),
	CONSTRAINT usos_users_email_not_null NOT NULL email,
	CONSTRAINT usos_users_first_name_not_null NOT NULL first_name,
	CONSTRAINT usos_users_last_name_not_null NOT NULL last_name,
	CONSTRAINT usos_users_pkey PRIMARY KEY (user_id),
	CONSTRAINT usos_users_roles_not_null NOT NULL roles,
	CONSTRAINT usos_users_user_id_not_null NOT NULL user_id,
	CONSTRAINT usos_users_user_type_not_null NOT NULL user_type
);
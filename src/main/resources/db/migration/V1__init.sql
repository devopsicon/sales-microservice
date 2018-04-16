CREATE TABLE sale (
	id BIGINT NOT NULL AUTO_INCREMENT,
	amount FLOAT not null,
	item_id BIGINT not null,
	user_id BIGINT not null,
	location_id BIGINT not null,
	comments varchar(255) not null,
	  PRIMARY KEY (id)
);
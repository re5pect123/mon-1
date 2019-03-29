insert into users(username,password,enabled)
	values('admin','$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu',true) if not exists;

insert into authorities(username,authority)
	values('admin','ROLE_ADMIN') if not exists;
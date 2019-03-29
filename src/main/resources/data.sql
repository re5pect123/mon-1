insert into users(username,password,enabled)
	values('marko-diz','$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu',true);

insert into users(username,password,enabled)
values('sima-kro','$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu',true);

insert into authorities(username,authority)
	values('marko-diz','ROLE_DIZAJNER');

insert into authorities(username,authority)
values('sima-kro','ROLE_KROJAC');